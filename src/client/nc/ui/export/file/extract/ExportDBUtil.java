package nc.ui.export.file.extract;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.export.file.IFbsDataFileService;
import nc.itf.spike.ISpike;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.pub.Constants;
import nc.ui.pub.ClientEnvironment;
import nc.ui.trade.manage.BillManageUI;
import nc.util.AntZipUtil;
import nc.util.FileUtil;
import nc.vo.Export.FbsDataFileItemVO;
import nc.vo.Export.FbsDatafileVO;
import nc.vo.Export.time.FbsExportTimeVO;
import nc.vo.hr.iufo.func.Global;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.spike.bd.Bd_deptdocVO;
import nc.vo.spike.bd.Bd_psnbasdocVO;
import nc.vo.spike.bd.Bd_psndocVO;
import nc.vo.spike.expert.Expert_termVO;
import nc.vo.spike.hi.Hi_psndoc_abroadVO;
import nc.vo.spike.hi.Hi_psndoc_deptchgVO;
import nc.vo.spike.hi.Hi_psndoc_dimissionVO;
import nc.vo.spike.hi.Hi_psndoc_eduVO;
import nc.vo.spike.hi.Hi_psndoc_encVO;
import nc.vo.spike.hi.Hi_psndoc_grpdef11VO;
import nc.vo.spike.hi.Hi_psndoc_grpdef14VO;
import nc.vo.spike.hi.Hi_psndoc_partylogVO;
import nc.vo.spike.hi.Hi_psndoc_punVO;
import nc.vo.spike.hi.Hi_psndoc_spetechVO;
import nc.vo.spike.hi.Hi_psndoc_techrankVO;
import nc.vo.spike.hi.Hi_psndoc_trainingVO;
import nc.vo.spike.hi.Hi_psndoc_workVO;
import nc.vo.spike.hr.Hr_expertVO;
import nc.vo.spike.hrldm.Hrldm_ldpsn_infoVO;
import nc.vo.spike.hrldm.Hrldm_psndoc_dutyVO;
import nc.vo.spike.hrldm.Hrldm_train_planVO;
import nc.vo.spike.om.OmDutyVo;
import nc.vo.spike.om.Om_corp_workoutVO;
import nc.vo.spike.om.Om_corp_workout_bVO;
import nc.vo.spike.om.Om_dept_workoutVO;
import nc.vo.spike.om.Om_jobVO;
import nc.vo.spike.om.Om_job_workoutVO;
import nc.vo.spike.wa.Wa_dataVO;

/**
 * @ClassName: ExportDBUtil <b> 前台抽取db文件工具类 </b>
 *             <p>
 *             此类把原所有有关抽取db文件的代码进行了重新整理
 *             </p>
 *             创建日期: 2016年10月13日 上午11:49:55
 * @Author 王凯强
 * @Version
 */
public class ExportDBUtil {
	BillManageUI exportUI;
	
	//HashMap<String,String> tabcode_name = new HashMap<String,String>();

	public ExportDBUtil(BillManageUI billUI) {
		exportUI = billUI;
	}



	IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
			.getInstance().lookup(IFbsDataFileService.class.getName());


	/**
	 * @Title: exportData
	 * @Description: 导出文件主方法入口
	 * @Time: 2016年10月14日 下午2:15:44
	 * @param fileSavePath
	 * @param nowtime
	 * @param lasttime
	 * @throws Exception
	 */
	public void exportData(String fileSavePath, String nowtime, String lasttime)
			throws Exception {
		// 获取生成文件的名称
		String filename = FileUtil.getFolderNameByTime();
		String dbHostFolderPath = fileSavePath + Constants.SEP + filename;

		// 获取数据并且插入到文件数据库中
		Connection dbConnection = null;

		Statement statement = null;
		try {
			// .h2.db后缀文件保存路径(与压缩文件同名文件夹)
			FileUtil.createFolder(dbHostFolderPath);

			// 获取文件数据库连接
			dbConnection = H2Connection.getConnection(dbHostFolderPath);

			// 1.获取所有创建表结构的sql
			List<String> sqlStrs = ifdfService.getAllCreateSqls();

			// 创建表结构
			statement = dbConnection.createStatement();
			for (int i = 0; i < sqlStrs.size(); i++) {
				statement.execute(sqlStrs.get(i));
			}

			String version = ifdfService.getToolVersion();
			//补丁版本信息
			if(version!=null){
				statement.execute("insert into fbs_version(version) values ('"+version+"')");
				dbConnection.commit();
			}
			// 获取数据并且保存到db中
			FbsDataFileItemVO[] bvos = saveData(dbConnection,statement, lasttime);
			// 提交数据
//			dbConnection.commit();
			// 保存版本信息
			saveVersion( statement, nowtime, lasttime);
			// 提交数据
			dbConnection.commit();
			
			FbsDatafileVO dataFileVO = new FbsDatafileVO();
			dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// 默认当前登陆人
			dataFileVO.setPk_corp(Global.getPkGroup());// 默认当前登陆公司
			dataFileVO.setOperate_time(new UFDateTime(nowtime));// 操作时间
			dataFileVO.setIssuccess(UFBoolean.TRUE);
			dataFileVO.setIsall(lasttime==null?UFBoolean.TRUE:UFBoolean.FALSE);
			dataFileVO.setIsspike(lasttime!=null?UFBoolean.TRUE:UFBoolean.FALSE);
			dataFileVO.setStart_date(lasttime == null?null:new UFDateTime(lasttime));
			dataFileVO.setVbillstatus(Integer.valueOf(8));// 抽取数据结束时间
			
			dataFileVO.setVmemo(Constants.OPT_TYPE_DATA);
			
			ifdfService.saveLogVO(dataFileVO,bvos,getExtTime(nowtime, lasttime));

		} catch (Exception e) {
			if(dbConnection!=null){
				dbConnection.rollback();
			}
			H2Connection.closeStatement(statement);
			H2Connection.closeConnection(dbConnection);
			//如果出错了，把文件夹删掉
			FileUtil.deleteFolder(dbHostFolderPath);
			e.printStackTrace();
			throw e;
		} finally {
			H2Connection.closeStatement(statement);
			H2Connection.closeConnection(dbConnection);
		}
		
		//进度条进度
		ProcessLine.addValueProcess(29, "正在压缩文件...");
		
		// 压缩文件保存路径
		File filePath = FileUtil.createFolder(fileSavePath);
		String zipFileName = filename + Constants.DATA_ZIP_EXTNAME;
		String zipFileFullPath = filePath.getAbsolutePath() + Constants.SEP + zipFileName;
		AntZipUtil.zipFile(zipFileFullPath, dbHostFolderPath);

		//用完文件夹后删除文件夹
		FileUtil.deleteFolder(dbHostFolderPath);

	}

	private void saveVersion( Statement st,
			String nowtime, String lasttime) throws Exception {
		String[] pkCorps =  getPkCorps();
		String isall = "N";
		if (pkCorps != null && pkCorps.length > 0) {
			if(lasttime==null){
				isall = "Y";
			}
			for (int m = 0; m < pkCorps.length; m++) {
				String sql = "insert into fbs_export_time (pk_corp,this_time,last_time,isall) values ('"
						+ pkCorps[m]
						+ "', '"
						+ nowtime
						+ "', '"
						+ (lasttime==null?"":lasttime)
						+ "','"+isall+"' )";
				st.addBatch(sql);
			}
			st.executeBatch();
		}
	}
	@SuppressWarnings("rawtypes")
	public String[] getPkCorps() throws BusinessException{
		IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		List list = null;
		
		//查询bd_corp表与mid_bd_corp内连接的mid_bd_corp的pk_corp
		String sql = "select mc.pk_corp from bd_corp c inner join mid_bd_corp mc on mc.unitcode = c.unitcode ";
		//查询上一个sql中在fbs_expcorp_conf表中存在的mid_bd_corp的pk_corp
		String sql_corp = "select distinct mc.pk_corp from bd_corp c inner join fbs_expcorp_conf conf on c.pk_corp = conf.exp_pk_corp and isnull(conf.dr,0) = 0 inner join mid_bd_corp mc on mc.unitcode = c.unitcode ";
		
		list = (List) bs.executeQuery(sql_corp, new ArrayListProcessor());
		if(list == null || list.size() == 0){
			//先查询数据抽取配置节点有没有配置公司，如果配置了就按照配置的查询，如果没有配置则按照默认查询
			list = (List) bs.executeQuery(sql, new ArrayListProcessor());
		}
		String[] corppks = new String[list.size()]; 
		Object[] obj = null;
		for (int i = 0; i < corppks.length; i++) {
			obj = (Object[]) list.get(i);
			corppks[i] = (String) obj[0];
		}
		return corppks;
	}

	public FbsDataFileItemVO[] saveData(Connection conn, Statement statement, String lasttime)
			throws Exception {
	
		StringBuffer whereBuffer = new StringBuffer(" 1=1 ");
		
		if (lasttime==null) {// 全量：
			
		} else {// 增量
			whereBuffer.append(" and ts_m > '" + lasttime + "'");
		}
		String whereStr = whereBuffer.toString();

		// step3.根据查询条件查询本地28张表数据
		List<SuperVO> list = new ArrayList<SuperVO>();
		List<FbsDataFileItemVO> logvos = new ArrayList<FbsDataFileItemVO>();
		int index = 0;
		/************************************ 1.部门档案 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【部门档案】数据... ...");
		list = ifdfService.getSpikeData(Bd_deptdocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"部门档案");

		/************************************ 2.岗位基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【岗位基本信息】数据... ...");
		list = ifdfService.getSpikeData(Om_jobVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"岗位基本信息");

		/************************************ 3.职务基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【职务基本信息】数据... ...");
		list = ifdfService.getSpikeData(OmDutyVo.class, whereStr);
		index+=insertDB(statement, list, logvos,"职务基本信息");
		
		/************************************ 4.单位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【单位编制信息】数据... ...");
		list = ifdfService.getSpikeData(Om_corp_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"单位编制信息");

		/************************************ 5.单位编制子表 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【单位编制子表】数据... ...");
		list = ifdfService.getSpikeData(Om_corp_workout_bVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"单位编制子表");
		
		/************************************ 6.部门编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【部门编制信息】数据... ...");
		list = ifdfService.getSpikeData(Om_dept_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"部门编制信息");
		
		/************************************ 7.岗位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【岗位编制信息】数据... ...");
		list = ifdfService.getSpikeData(Om_job_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"岗位编制信息");
		
		/************************************ 8.人员基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【人员基本信息】数据... ...");
		list = ifdfService.getSpikeData(Bd_psnbasdocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"人员基本信息");
		
		/************************************ 9.员工工作信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工工作信息】数据... ...");
		list = ifdfService.getSpikeData(Bd_psndocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工工作信息");

		/************************************ 10.员工任职信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工任职信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_deptchgVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工任职信息");

		/************************************ 11.政治面貌信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【政治面貌信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_partylogVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"政治面貌信息");

		/************************************ 12.学历学位信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【学历学位信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_eduVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"学历学位信息");
		
		/************************************ 13.家庭成员海外背景信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【家庭成员海外背景信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_grpdef14VO.class, whereStr);
		index+=insertDB(statement, list, logvos,"家庭成员海外背景信息");

		/************************************ 14.员工工作履历信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工工作履历信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_workVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工工作履历信息");

		/************************************ 15.员工涉外经历信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工涉外经历信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_abroadVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工涉外经历信息");

		/************************************ 16.员工奖励信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工奖励信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_encVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工奖励信息");

		/************************************ 17.员工惩处信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工惩处信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_punVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工惩处信息");

		/************************************ 18.员工培训信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工培训信息】数据... ...");
		int i_px = 0;
		boolean flag_px = false;
		int pxsize = 0;
		while(true){
			list = ifdfService.getSpikeDataByPage(Hi_psndoc_trainingVO.class, whereStr,i_px++);
			
			if(list==null || list.size()<ISpike.MAXROWS){
				flag_px = true;
			}
			pxsize+=insertDB(statement, list);
			if(flag_px){
				break;
			}
		}
		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
		// itemVo.setPk_fbs_datafile(logPk);
		itemVo.setData_size(String.valueOf(pxsize));
		itemVo.setTable_name("员工培训信息");
		logvos.add(itemVo);
		index+=pxsize;
		
		/************************************ 19.专业技术职务 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【专业技术职务】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_spetechVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"专业技术职务");

		/************************************ 20.工人技术等级 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【工人技术等级】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_techrankVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"工人技术等级");

		/************************************ 21.知识产权信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【知识产权信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_grpdef11VO.class, whereStr);
		index+=insertDB(statement, list, logvos,"知识产权信息");
		
		/************************************ 22.员工离职信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工离职信息】数据... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_dimissionVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"员工离职信息");

		/************************************ 23.干部信息主集-干部分类信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【干部信息主集-干部分类信息】数据... ...");
		list = ifdfService.getSpikeData(Hrldm_ldpsn_infoVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"干部信息主集-干部分类信息");

		/************************************ 24.领导人员职务信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【领导人员职务信息子集】数据... ...");
		list = ifdfService.getSpikeData(Hrldm_psndoc_dutyVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"领导人员职务信息子集");
		
		/************************************ 25.后备干部信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【后备干部信息子集】数据... ...");
		list = ifdfService.getSpikeData(Hrldm_train_planVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"后备干部信息子集");

		/************************************ 26.专业人才管理-院士专家信息维护 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【专业人才管理-院士专家信息维护】数据... ...");
		list = ifdfService.getSpikeData(Hr_expertVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"专业人才管理-院士专家信息维护");

		/************************************ 27.院士专家子集－聘期管理 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【院士专家子集－聘期管理】数据... ...");
		list = ifdfService.getSpikeData(Expert_termVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"院士专家子集－聘期管理");
		
		/************************************ 9.薪酬管理-发放总额 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【薪酬管理-发放总额】数据... ...");
		
		int i_wa = 0;
		boolean flag_wa = false;
		int wasize = 0;
		while(true){
			list = ifdfService.getSpikeDataByPage(Wa_dataVO.class, whereStr,i_wa++);
			
			if(list==null || list.size()<ISpike.MAXROWS){
				flag_wa = true;
			}
			wasize+=insertDB(statement, list);
			if(flag_wa){
				break;
			}
		}
		itemVo = new FbsDataFileItemVO();
		// itemVo.setPk_fbs_datafile(logPk);
		itemVo.setData_size(String.valueOf(wasize));
		itemVo.setTable_name("薪酬管理-发放总额");
		logvos.add(itemVo);
		index+=wasize;
		
		if(index==0){
			throw new BusinessException("没有获取到符合条件的数据,请检查确认！");
		}

		return logvos.toArray(new FbsDataFileItemVO[logvos.size()]);
	}
//	private void initTabcodename() {
//		tabcode_name.put("mid_wa_data", "薪酬管理-发放总额");
//		tabcode_name.put("mid_expert_term", "院士专家子集－聘期管理");
//		tabcode_name.put("mid_hr_expert", "专业人才管理-院士专家信息维护");
//		
//		tabcode_name.put("mid_hrldm_train_plan", "后备干部信息子集");
//		tabcode_name.put("mid_hrldm_ldpsn_info", "干部信息主集-干部分类信息");
//		tabcode_name.put("mid_hrldm_psndoc_duty", "领导人员职务信息子集");
//		tabcode_name.put("mid_hi_psndoc_dimission", "员工离职信息");
//		tabcode_name.put("mid_hi_psndoc_grpdef11", "知识产权信息");
//		
//		tabcode_name.put("mid_hi_psndoc_spetech", "专业技术职务");
//		tabcode_name.put("mid_hi_psndoc_techrank", "工人技术等级");
//		tabcode_name.put("mid_hi_psndoc_training", "员工培训信息");
//		tabcode_name.put("mid_hi_psndoc_pun", "员工惩处信息");
//		tabcode_name.put("mid_hi_psndoc_enc", "员工奖励信息");
//		
//		tabcode_name.put("mid_hi_psndoc_work", "员工工作履历信息");
//		tabcode_name.put("mid_hi_psndoc_abroad", "员工涉外经历信息");
//		tabcode_name.put("mid_hi_psndoc_grpdef14", "家庭成员海外背景信息");
//		tabcode_name.put("mid_hi_psndoc_partylog", "政治面貌信息");
//		tabcode_name.put("mid_hi_psndoc_edu", "学历学位信息");
//		
//		tabcode_name.put("mid_om_dept_workout", "部门编制信息");
//		tabcode_name.put("mid_om_job_workout", "岗位编制信息");
//		tabcode_name.put("mid_bd_psnbasdoc", "人员基本信息");
//		tabcode_name.put("mid_bd_psndoc", "员工工作信息");
//		tabcode_name.put("mid_hi_psndoc_deptchg", "员工任职信息");
//		
//		
//		tabcode_name.put("mid_bd_deptdoc", "部门档案");
//		tabcode_name.put("mid_om_job", "岗位基本信息");
//		tabcode_name.put("mid_om_duty", "职务基本信息");
//		tabcode_name.put("mid_om_corp_workout_b", "单位编制子表");
//		tabcode_name.put("mid_om_corp_workout", "单位编制信息");
//		
//		
//	}

	public int insertDB(Statement st, List<SuperVO> list,
			List<FbsDataFileItemVO> logvo, String tabname) throws Exception {
		int count=0;
		if (list == null || list.size() == 0) {
			FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
			// itemVo.setPk_fbs_datafile(logPk);
			itemVo.setData_size(String.valueOf(0));
			itemVo.setTable_name(tabname);
			logvo.add(itemVo);
			return 0;
		}

		// step1.插入28张表db数据
		String tab_name = list.get(0).getTableName();
		String[] fields = list.get(0).getAttributeNames();
		SuperVO vo = null;
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			count++;
			st.addBatch(getInsertSql(tab_name, fields, vo));
			if(count%500==0){
				st.executeBatch();
			}
		}
		if(count%500>0){
			st.executeBatch();
		}
		st.getConnection().commit();
		
		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
		// itemVo.setPk_fbs_datafile(logPk);
		itemVo.setData_size(String.valueOf(list.size()));
		itemVo.setTable_name(tabname);
		logvo.add(itemVo);
		int size = list.size();
		list.clear();
		return size;
	}
	
	public int insertDB(Statement st, List<SuperVO> list ) throws Exception {
		int count=0;
		if (list == null || list.size() == 0) {
//			FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
//			// itemVo.setPk_fbs_datafile(logPk);
//			itemVo.setData_size(String.valueOf(list.size()));
//			itemVo.setTable_name(tabname);
//			logvo.add(itemVo);
			return 0;
		}

		// step1.插入28张表db数据
		String tab_name = list.get(0).getTableName();
		String[] fields = list.get(0).getAttributeNames();
		SuperVO vo = null;
		for (int i = 0; i < list.size(); i++) {
			vo = list.get(i);
			count++;
			st.addBatch(getInsertSql(tab_name, fields, vo));
			if(count%500==0){
				st.executeBatch();
			}
		}
		if(count%500>0){
			st.executeBatch();
		}
		st.getConnection().commit();
		
//		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
//		// itemVo.setPk_fbs_datafile(logPk);
//		itemVo.setData_size(String.valueOf(list.size()));
//		itemVo.setTable_name(tabname);
//		logvo.add(itemVo);
		
		int size = list.size();
		list.clear();
		return size;
	}

	private String getInsertSql(String tab_name, String[] fields, SuperVO vo) {
		String sql = "insert into " + tab_name + " (";

		for (int j = 0; j < fields.length; j++) {
			if (isJump(tab_name, fields[j])) {
				continue;
			} else {
				sql += (fields[j] + ",");
			}
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")values (";
		for (int j = 0; j < fields.length; j++) {
			if (isJump(tab_name, fields[j])) {
				continue;
			} else {
				if (vo.getAttributeValue(fields[j]) == null) {
					sql += "null,";
				} else {
					sql += ("'" + vo.getAttributeValue(fields[j]) + "',");
				}
			}
		}
		sql = sql.substring(0, sql.length() - 1);
		sql += ")";

		return sql;
	}

	/**
	 * 拼sql是否需要跳过
	 * 
	 * @param tablename
	 * @param fieldname
	 * @return
	 */
	private boolean isJump(String tablename, String fieldname) {
		if ("dr".equals(fieldname) || "ts".equals(fieldname)
				|| "last_time".equals(fieldname)
				|| "this_time".equals(fieldname) || fieldname.endsWith("_old")
				|| "photo".equals(fieldname)  
				|| "unitcode".equals(fieldname)) {
			return true;
		}
		if("exper_code".equals(fieldname) && !"mid_hr_expert".equals(tablename)){
			return true;
		}
		if ("mid_om_dept_workout".equals(tablename)
				&& "deptcode".equals(fieldname)) {
			return true;
		}
		if ("mid_om_job_workout".equals(tablename)
				&& "jobcode".equals(fieldname)) {
			return true;
		}

		if (!"mid_bd_psndoc".equals(tablename) 
				&& ("psnclscope".equals(fieldname) 
				|| "psncode".equals(fieldname))) {
			return true;
		}
		
		if(!"mid_bd_psndoc".equals(tablename) 
				&& !"mid_hi_psndoc_deptchg".equals(tablename) 
				&& "pk_psncl".equals(fieldname)){
			return true;
		}
		if("bas_pkcorp".equals(fieldname)){
			return true;
		}
//		if ("pk_corp".equals(fieldname)) {
//			if ("mid_om_corp_workout_b".equals(tablename)
//					|| "mid_hi_psndoc_edu".equals(tablename)
//					|| "mid_hi_psndoc_grpdef14".equals(tablename)
//					|| "mid_hi_psndoc_work".equals(tablename)
//					|| "mid_hi_psndoc_enc".equals(tablename)
//					|| "mid_hi_psndoc_pun".equals(tablename)
//					|| "mid_hi_psndoc_grpdef11".equals(tablename)
//					|| "mid_hrldm_train_plan".equals(tablename)
//					|| "mid_expert_term".equals(tablename)
//					|| "mid_wa_data".equals(tablename)) {
//				return true;
//			}
//		}
		return false;
	}

	

	

	/**
	 * @Title: saveExtTime
	 * @Description: 保存本次抽取文件时间
	 * @Author: 王凯强
	 * @Date: 2016年9月5日
	 * @param time
	 * @param dbFlag
	 * @throws BusinessException
	 */
	public FbsExportTimeVO[] getExtTime(String time, String lasttime)
			throws BusinessException {
		
		String isall = "N";// N:增量数据，Y：全量数据
		if (lasttime==null) {
			isall = "Y";
		}
		String[] m_corpArr = getPkCorps();
		FbsExportTimeVO[] timeVO = new FbsExportTimeVO[m_corpArr.length];
		for (int i = 0; i < m_corpArr.length; i++) {
			timeVO[i] = new FbsExportTimeVO();
			timeVO[i].setTime(new UFDateTime(time));
			timeVO[i].setPk_corp(m_corpArr[i]);
			timeVO[i].setIsall(isall);
		}
		return timeVO;

	}
}

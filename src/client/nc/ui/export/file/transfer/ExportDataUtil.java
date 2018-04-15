package nc.ui.export.file.transfer;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.export.file.IFbsDataFileService;
import nc.itf.export.file.IGetAllBSData;
import nc.pub.Constants;
import nc.ui.export.file.extract.H2Connection;
import nc.ui.export.file.extract.ProcessLine;
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

/**
 * @ClassName: ExportDataUtil
 * @Description:  业务数据迁移导出
 * @Author: 王凯强
 * @Date: 2017年5月16日下午12:24:09
 */
public class ExportDataUtil {

	private BillManageUI exportDataUi;

	public ExportDataUtil(BillManageUI billUI) {
		this.exportDataUi = billUI;
	}
	
	IGetAllBSData getAllBSData = (IGetAllBSData) NCLocator
			.getInstance().lookup(IGetAllBSData.class.getName());
	
	public void doExport(String fileSavePath, String[] corpArr, String thistime)
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
			List<String> sqlStrs = getAllBSData.getAllCreateBSSqls();

			// 创建表结构
			statement = dbConnection.createStatement();
			for (int i = 0; i < sqlStrs.size(); i++) {
				statement.execute(sqlStrs.get(i));
			}
			FbsDatafileVO dataFileVO = initHeadLogVO(thistime);
			
			FbsDataFileItemVO[] bvos = saveData(dbConnection,statement, corpArr);
			// 提交数据
			dbConnection.commit();
			
			//存储日志
			IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
					.getInstance().lookup(IFbsDataFileService.class.getName());
			ifdfService.saveLogVO(dataFileVO,bvos,new FbsExportTimeVO[]{});
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
	
	public FbsDatafileVO initHeadLogVO(String thistime){
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// 默认当前登陆人
		dataFileVO.setPk_corp(Global.getPkGroup());// 默认当前登陆公司
		dataFileVO.setOperate_time(new UFDateTime(thistime));// 操作时间
		dataFileVO.setIssuccess(UFBoolean.TRUE);
		dataFileVO.setIsall(UFBoolean.TRUE);
		dataFileVO.setIsspike(UFBoolean.FALSE);
		dataFileVO.setStart_date(null);
		dataFileVO.setVbillstatus(Integer.valueOf(8));// 抽取数据结束时间
		dataFileVO.setVmemo(Constants.OPT_TYPE_EXPORT);
		return dataFileVO;
	}
	
	private void getItemVO(int count, String tabname, List<FbsDataFileItemVO> items){
		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
		itemVo.setData_size(String.valueOf(count));
		itemVo.setTable_name(tabname);
		items.add(itemVo);
	}
	
	public FbsDataFileItemVO[] saveData(Connection conn, Statement statement, String[] corpArr)
			throws Exception {
		List<SuperVO> list = new ArrayList<SuperVO>();
		List<FbsDataFileItemVO> items = new ArrayList<FbsDataFileItemVO>();
		int index = 0;
		/************************************ 1.部门档案 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【部门档案】数据... ...");
		list = getAllBSData.getBd_deptdocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "部门档案", items);
		index+=insertDB(statement, list);

		/************************************ 2.岗位基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【岗位基本信息】数据... ...");
		list = getAllBSData.getOm_jobData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "岗位基本信息", items);
		index+=insertDB(statement, list);

		/************************************ 3.职务基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【职务基本信息】数据... ...");
		list = getAllBSData.getOm_dutyData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "职务基本信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 4.单位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【单位编制信息】数据... ...");
		list = getAllBSData.getOm_corp_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "单位编制信息", items);
		index+=insertDB(statement, list);

		/************************************ 5.单位编制子表 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【单位编制子表】数据... ...");
		list = getAllBSData.getOm_corp_workout_bData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "单位编制子表", items);
		index+=insertDB(statement, list);
		
		/************************************ 6.部门编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【部门编制信息】数据... ...");
		list = getAllBSData.getOm_dept_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "部门编制信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 7.岗位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【岗位编制信息】数据... ...");
		list = getAllBSData.getOm_job_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "岗位编制信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 8.人员基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【人员基本信息】数据... ...");
		list = getAllBSData.getBd_psnbasdocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "人员基本信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 9.员工工作信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工工作信息】数据... ...");
		list = getAllBSData.getBd_psndocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工工作信息", items);
		index+=insertDB(statement, list);

		/************************************ 10.员工任职信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工任职信息】数据... ...");
		list = getAllBSData.getHi_psndoc_deptchgData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工任职信息", items);
		index+=insertDB(statement, list);

		/************************************ 11.政治面貌信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【政治面貌信息】数据... ...");
		list = getAllBSData.getHi_psndoc_partylogData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "政治面貌信息", items);
		index+=insertDB(statement, list);

		/************************************ 12.学历学位信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【学历学位信息】数据... ...");
		list = getAllBSData.getHi_psndoc_eduData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "学历学位信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 13.家庭成员海外背景信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【家庭成员海外背景信息】数据... ...");
		list = getAllBSData.getHi_psndoc_grpdef14Data(corpArr);
		getItemVO(list == null ? 0 : list.size(), "家庭成员海外背景信息", items);
		index+=insertDB(statement, list);

		/************************************ 14.员工工作履历信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工工作履历信息】数据... ...");
		list = getAllBSData.getHi_psndoc_workData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工工作履历信息", items);
		index+=insertDB(statement, list);

		/************************************ 15.员工涉外经历信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工涉外经历信息】数据... ...");
		list = getAllBSData.getHi_psndoc_abroadData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工涉外经历信息", items);
		index+=insertDB(statement, list);

		/************************************ 16.员工奖励信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工奖励信息】数据... ...");
		list = getAllBSData.getHi_psndoc_encData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工奖励信息", items);
		index+=insertDB(statement, list);

		/************************************ 17.员工惩处信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工惩处信息】数据... ...");
		list = getAllBSData.getHi_psndoc_punData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工惩处信息", items);
		index+=insertDB(statement, list);

		/************************************ 18.员工培训信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工培训信息】数据... ...");
		list = getAllBSData.getHi_psndoc_trainingData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工培训信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 19.专业技术职务 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【专业技术职务】数据... ...");
		list = getAllBSData.getHi_psndoc_spetechData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "专业技术职务", items);
		index+=insertDB(statement, list);

		/************************************ 20.工人技术等级 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【工人技术等级】数据... ...");
		list = getAllBSData.getHi_psndoc_techrankData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "工人技术等级", items);
		index+=insertDB(statement, list);

		/************************************ 21.知识产权信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【知识产权信息】数据... ...");
		list = getAllBSData.getHi_psndoc_grpdef11Data(corpArr);
		getItemVO(list == null ? 0 : list.size(), "知识产权信息", items);
		index+=insertDB(statement, list);
		
		/************************************ 22.员工离职信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【员工离职信息】数据... ...");
		list = getAllBSData.getHi_psndoc_dimissionData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "员工离职信息", items);
		index+=insertDB(statement, list);

		/************************************ 23.干部信息主集-干部分类信息 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【干部信息主集-干部分类信息】数据... ...");
		list = getAllBSData.getHrldm_ldpsn_infoData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "干部信息主集-干部分类信息", items);
		index+=insertDB(statement, list);

		/************************************ 24.领导人员职务信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【领导人员职务信息子集】数据... ...");
		list = getAllBSData.getHrldm_psndoc_dutyData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "领导人员职务信息子集", items);
		index+=insertDB(statement, list);
		
		/************************************ 25.后备干部信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【后备干部信息子集】数据... ...");
		list = getAllBSData.getHrldm_train_planData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "后备干部信息子集", items);
		index+=insertDB(statement, list);

		/************************************ 26.专业人才管理-院士专家信息维护 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【专业人才管理-院士专家信息维护】数据... ...");
		list = getAllBSData.getHr_expertData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "专业人才管理-院士专家信息维护", items);
		index+=insertDB(statement, list);

		/************************************ 27.院士专家子集－聘期管理 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【院士专家子集－聘期管理】数据... ...");
		list = getAllBSData.getExpert_termData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "院士专家子集－聘期管理", items);
		index+=insertDB(statement, list);
		
		/************************************ 28.薪酬管理-发放总额 ************************************/
		ProcessLine.addDefaultProcess("正在抽取【薪酬管理-发放总额】数据... ...");
		list = getAllBSData.getWa_dataData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "薪酬管理-发放总额", items);
		index+=insertDB(statement, list);
		
		if(index==0){
			throw new BusinessException("没有获取到符合条件的数据,请检查确认！");
		}
		return items.toArray(new FbsDataFileItemVO[items.size()]);

	}
	public int insertDB(Statement st, List<SuperVO> list ) throws Exception {
		int count=0;
		if (list == null || list.size() == 0) {
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
		if("exper_code".equals(fieldname) && !"hr_expert".equals(tablename)){
			return true;
		}
		if ("om_dept_workout".equals(tablename)
				&& "deptcode".equals(fieldname)) {
			return true;
		}
		if ("om_job_workout".equals(tablename)
				&& "jobcode".equals(fieldname)) {
			return true;
		}

		if (!"bd_psndoc".equals(tablename) 
				&& ("psnclscope".equals(fieldname) 
				|| "psncode".equals(fieldname))) {
			return true;
		}
		
		if(!"bd_psndoc".equals(tablename) 
				&& !"hi_psndoc_deptchg".equals(tablename) 
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
}

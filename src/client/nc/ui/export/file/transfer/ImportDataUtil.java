package nc.ui.export.file.transfer;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.export.file.IFbsDataFileService;
import nc.pub.Constants;
import nc.ui.export.file.extract.H2Connection;
import nc.ui.export.file.extract.ProcessLine;
import nc.ui.trade.manage.BillManageUI;
import nc.util.AntZipUtil;
import nc.util.ExtFilenameFilter;
import nc.util.FileUtil;
import nc.vo.Export.FbsDataFileItemVO;
import nc.vo.Export.FbsDatafileVO;
import nc.vo.Export.time.FbsExportTimeVO;
import nc.vo.hr.iufo.func.Global;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.pub.lang.UFDouble;

/**
 * @ClassName: ImportDBUtil
 * @Description:  业务数据迁移导入
 * @Author: 王凯强
 * @Date: 2017年5月12日上午11:17:48
 */
public class ImportDataUtil {

	private int maxrow = 1000;
	
	BillManageUI importUI;

	public ImportDataUtil(BillManageUI billUI) {
		importUI = billUI;
	}

	/**
	 * @Title: doImport
	 * @Description: 导入数据入口
	 * @param realFile
	 * @throws Exception
	 */
	public void doImport(File realFile, String thistime) throws BusinessException {
		String dataFolderPath = "";
		try {
			IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
					.getInstance().lookup(IFbsDataFileService.class.getName());
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyyMMddHHmmss");
			String currentTS = sdf.format(new java.util.Date());
			dataFolderPath = realFile.getParent() + File.separator + currentTS;
			extractDsbtDataFile(realFile, dataFolderPath);
			File dataFolder = new File(dataFolderPath);
			File dbFolder = findDBLocationFolder(dataFolder);// 读取客户端文件
			if (dbFolder == null) {
				Logger.error(">>>DataPath:" + dataFolderPath);
				throw new BusinessException("分布式离线数据文件格式存在异常!");
			}
			
			FbsDatafileVO dataFileVO = initHeadLogVO(thistime);
			
			FbsDataFileItemVO[] bvos = execute(dbFolder);
			
			ifdfService.saveLogVO(dataFileVO,bvos,new FbsExportTimeVO[]{});
			
			FileUtil.deleteFolder(dataFolderPath);
		} catch (BusinessException e) {
			e.printStackTrace();
			FileUtil.deleteFolder(dataFolderPath);
			throw new BusinessException(e);
		}
	}

	
	/**
	 * @Title: initHeadLogVO
	 * @Description: 初始化日志表头
	 * @Author: 王凯强
	 * @Date: 2017年5月16日
	 * @param thistime
	 * @return
	 */
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
		dataFileVO.setVmemo(Constants.OPT_TYPE_IMPORT);
		return dataFileVO;
	}
	
	/**
	 * @Title: execute
	 * @Description: 执行查询数据和写入数据
	 * @param dbFolder
	 */
	private FbsDataFileItemVO[] execute(File dbFolder) throws BusinessException{
		IFbsDataFileService expDataService = NCLocator.getInstance()
				.lookup(IFbsDataFileService.class);
		
		Connection conn;
			try {
				conn = H2Connection.getConnection(dbFolder.getAbsolutePath());
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
				throw new BusinessException(e1);
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new BusinessException(e2);
			}

		String[] targetTable = { Constants.BD_DEPTDOC,
				Constants.BD_PSNDOC, Constants.BD_PSNBASDOC,
				Constants.HI_PSNDOC_DEPTCHG,Constants.HI_PSNDOC_DIMISSION, 
				Constants.HI_PSNDOC_EDU, Constants.HI_PSNDOC_ABROAD, 
				Constants.HI_PSNDOC_ENC, Constants.HI_PSNDOC_GRPDEF11,
				Constants.HI_PSNDOC_GRPDEF14, Constants.HI_PSNDOC_PARTYLOG, 
				Constants.HI_PSNDOC_PUN, Constants.HI_PSNDOC_SPETECH,
				Constants.HI_PSNDOC_TECHRANK, Constants.HI_PSNDOC_TRAINING, 
				Constants.HI_PSNDOC_WORK, Constants.HR_EXPERT, 
				Constants.EXPERT_TERM, Constants.HRLDM_LDPSN_INFO,
				Constants.HRLDM_PSNDOC_DUTY, Constants.HRLDM_TRAIN_PLAN, 
				Constants.OM_CORP_WORKOUT, Constants.OM_CORP_WORKOUT_B, 
				Constants.OM_DEPT_WORKOUT, Constants.OM_DUTY, 
				Constants.OM_JOB, Constants.OM_JOB_WORKOUT, 
				Constants.WA_DATA };
		
		Map<String, String> tableName = new HashMap<String, String>();
		tableName.put("bd_deptdoc","部门档案");
		tableName.put("bd_psndoc","员工工作信息");
		tableName.put("bd_psnbasdoc","人员基本信息");
		tableName.put("om_job","岗位基本信息");
		tableName.put("om_job_workout","岗位编制信息");
		tableName.put("om_dept_workout","部门编制信息");
		tableName.put("om_corp_workout","单位编制信息数据");
		tableName.put("om_corp_workout_b","单位编制子表");
		tableName.put("hi_psndoc_edu","学历学位信息");
		tableName.put("om_duty","职务基本信息");
		tableName.put("hi_psndoc_work","员工工作履历信息");
		tableName.put("hi_psndoc_training","员工培训信息");
		tableName.put("hi_psndoc_techrank","工人技术等级");
		tableName.put("hi_psndoc_spetech","专业技术职务");
		tableName.put("hi_psndoc_pun","员工惩处信息");
		tableName.put("hi_psndoc_partylog","政治面貌信息");
		tableName.put("hi_psndoc_grpdef14","家庭成员海外背景信息");
		tableName.put("hi_psndoc_grpdef11","知识产权信息");
		tableName.put("hi_psndoc_enc","员工奖励信息");
		tableName.put("hi_psndoc_dimission","员工离职信息");
		tableName.put("hi_psndoc_deptchg","员工任职信息");
		tableName.put("hi_psndoc_abroad","员工涉外经历信息");
		tableName.put("hrldm_ldpsn_info","干部信息主集-干部分类信息");
		tableName.put("hrldm_psndoc_duty","领导人员职务信息子集");
		tableName.put("hrldm_train_plan","后备干部信息子集");
		tableName.put("hr_expert","专业人才管理-院士专家信息维护");
		tableName.put("expert_term","院士专家子集－聘期管理");
		tableName.put("wa_data","薪酬管理-发放总额");

		Logger.debug("正在执行数据导入......请稍候......");
		
		List<FbsDataFileItemVO> items = new ArrayList<FbsDataFileItemVO>();
		try{
			
			// 1.将bd数据中表数据放入SuperVO[]中
			SuperVO[] superVOs = null;
			boolean isempty = true;
			ProcessLine.setMaximum(targetTable.length+1);
			for (int i = 0; i < targetTable.length; i++) {
				ProcessLine.addValueProcess(i+1, "正在导入"+ tableName.get(targetTable[i]) +"数据......");
				int index = 0;
				int count = 0;
				//分页
				while(true){
					superVOs = getDBMidData(conn, targetTable[i],index++);
					count += superVOs.length;
					if (superVOs != null && superVOs.length > 0) {
						isempty=false;
						//分别存入业务表
						expDataService.insertBusinessData(superVOs);
					}
					if(superVOs == null || superVOs.length < maxrow){
						break;
					}
				}
				getItemVO(count, tableName.get(targetTable[i]), items);
			}
			if (isempty) {
				throw new BusinessException("待导入的数据为空!");
			}
			Logger.debug(">>恭喜<<,数据导入完成.");
			ProcessLine.addValueProcess(targetTable.length+1, "数据导入完成......");
			return items.toArray(new FbsDataFileItemVO[items.size()]);
		}catch(BusinessException e){
			e.printStackTrace();
			throw e;
		}finally{
			H2Connection.closeConnection(conn);
		}
	}
	
	private void getItemVO(int count, String tabname, List<FbsDataFileItemVO> items){
		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
		itemVo.setData_size(String.valueOf(count));
		itemVo.setTable_name(tabname);
		items.add(itemVo);
	}
	
	@SuppressWarnings("deprecation")
	public SuperVO[] getDBMidData(Connection conn, String targetTable, int count) throws BusinessException {

		Statement st = null;
		ResultSet rs = null;
		String errTable = null;
		
		try {
			// 1.将bd数据中表数据放入SuperVO[]中,并存入map中s
			st = conn.createStatement();
			SuperVO vo = instance(targetTable);
			errTable = vo.getTableName();

			String[] fields = vo.getAttributeNames();
			String sql = "select ";
			for (int i = 0; i < fields.length; i++) {
				if ("dr".equals(fields[i]) || "ts".equals(fields[i])
						|| "last_time".equals(fields[i])
						|| "this_time".equals(fields[i])
						|| fields[i].endsWith("_old")) {
					continue;
				} else {
					sql += (fields[i] + ",");
				}

			}
			sql = sql.substring(0, sql.length() - 1);
			sql += (" from "
					+ vo.getTableName() + " limit "
					+ maxrow * count + "," + maxrow);
			rs = st.executeQuery(sql);

			ArrayList<SuperVO> vos = new ArrayList<SuperVO>();
			// 获取单表vo
			Object cellName = null;
			Object cellValue = null;
			while (rs.next()) {
				vo = instance(targetTable);
				for (int j = 0; j < fields.length; j++) {
					cellName = fields[j];
					if ("dr".equals(cellName) || "ts".equals(cellName)
							|| "last_time".equals(cellName)
							|| "this_time".equals(cellName)
							|| cellName.toString().contains("_old")
							|| "photo".equals(cellName)
							|| "budge_person_fee".equals(cellName)) {
						continue;
					}
					cellValue = rs.getObject(fields[j]);
					// 给字段设值
					if (cellValue != null) {
						setValue(vo, cellName, cellValue, targetTable);
					}
				}
				vo.setAttributeValue("dr", 0);
				vos.add(vo);
			}
			return vos.toArray(new SuperVO[vos.size()]);
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage(), e);
			if (e instanceof BusinessException) {
				throw (BusinessException) e;
			} else {
				throw new BusinessException("导入表【" + errTable + "】数据时发生异常:"
						+ e.getMessage(), e);
			}
		} finally {
			H2Connection.closeResutSet(rs);
			H2Connection.closeStatement(st);
		}
	}
	
	private void setValue(SuperVO superVO, Object cellName, Object cellValue,
			String targetTable) {
		if ("ts_m".equals(cellName)) {
			superVO.setAttributeValue("ts_m", WorkbenchEnvironment.getServerTime()
					.toString());
		} else if ("showorder".equals(cellName) || "recordnum".equals(cellName)
				|| "xtersysflag".equals(cellName)
				|| "depttype".equals(cellName)) {
			superVO.setAttributeValue(cellName.toString(),
					Long.parseLong(cellValue.toString()));
		} else if ("psnclscope".equals(cellName) || "workout".equals(cellName)
				|| "workoutcount".equals(cellName) /*|| "cyear".equals(cellName)*/
				|| "actualnum".equals(cellName) || "version".equals(cellName)
				|| "workoutincludesub".equals(cellName)
				|| "jobtype".equals(cellName) || "poll".equals(cellName)
				|| "pass_poll".equals(cellName) || "subsidy".equals(cellName)
				|| "ld_type".equals(cellName) || "stat".equals(cellName)
				|| "tbm_prop".equals(cellName)
				|| "typeaftertrans".equals(cellName)
				|| "typeaftertrans".equals(cellName)
				|| "holdyear".equals(cellName)
				|| "taketrm_method".equals(cellName)
				|| "source_type".equals(cellName)
				|| "apprvtype".equals(cellName)
				|| "certif_period".equals(cellName)
				|| "approveflag".equals(cellName)) {
			superVO.setAttributeValue(cellName.toString(),
					Long.parseLong(cellValue.toString()));
		} else if ("edusystem".equals(cellName)
				|| "budge_person_fee".equals(cellName)
				|| "tra_score".equals(cellName) || "tra_time".equals(cellName)
				|| "tra_cost".equals(cellName) || "f_1".equals(cellName)
				|| "f_2".equals(cellName) || "f_3".equals(cellName)
				|| "f_4".equals(cellName) || "d_11".equals(cellName)
				|| "d_12".equals(cellName) || "d_13".equals(cellName)
				|| "d_14".equals(cellName) || "d_21".equals(cellName)
				|| "d_22".equals(cellName) || "d_23".equals(cellName)
				|| "d_24".equals(cellName) || "d_25".equals(cellName)
				|| "d_26".equals(cellName) || "icheckflag".equals(cellName)
				|| "ipartflag".equals(cellName)
				|| "irecaculateflag".equals(cellName)
				|| "irecheckflag".equals(cellName)
				|| "istopflag".equals(cellName) || "itaxflag".equals(cellName)
				|| "redtotal".equals(cellName)) {
			superVO.setAttributeValue(cellName.toString(), new UFDouble(
					cellValue.toString()));
		} else if ("cincomeway".equals(cellName) || "orgtype".equals(cellName)) {
			superVO.setAttributeValue(cellName.toString(),
					Integer.parseInt(cellValue.toString()));
		} else if ("mid_om_job".equals(targetTable)
				&& "groupdef12".equals(cellName)) {
			superVO.setAttributeValue(cellName.toString(),
					Long.parseLong(cellValue.toString()));
		} else {
			superVO.setAttributeValue(cellName.toString(), cellValue.toString());
		}
	}
	
	public static SuperVO instance(String tableName) {
		SuperVO superVo = null;
		try {
			int preIndex = tableName.indexOf("_");
			String prefix = tableName.substring(0, preIndex);
			superVo = (SuperVO) Class.forName("nc.vo.bs." + prefix + "." + captureName(tableName) + "VO").newInstance();
		} catch (Exception e) {
			Logger.error(e.getMessage(), e);
			e.printStackTrace();
		}
		return superVo;
	}

	/**
	 * @Title: captureName
	 * @Description: 字符串首字母大写
	 * @Author: 王凯强
	 * @Time: 2016年12月8日 下午1:04:15
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
//	private SuperVO getSuperVO(String targetTable) {
//
//		SuperVO vo = null;
//
//		if (Constants.MID_BD_DEPTDOC.equals(targetTable)) {
//			vo = new Bd_deptdocVO();
//
//		} else if (Constants.MID_OM_JOB.equals(targetTable)) {
//			vo = new Om_jobVO();
//
//		} else if (Constants.MID_OM_DUTY.equals(targetTable)) {
//			vo = new OmDutyVo();
//		} else if (Constants.MID_OM_CORP_WORKOUT.equals(targetTable)) {
//			vo = new Om_corp_workoutVO();
//		} else if (Constants.MID_OM_CORP_WORKOUT_B.equals(targetTable)) {
//			vo = new Om_corp_workout_bVO();
//		} else if (Constants.MID_OM_DEPT_WORKOUT.equals(targetTable)) {
//			vo = new Om_dept_workoutVO();
//		} else if (Constants.MID_OM_JOB_WORKOUT.equals(targetTable)) {
//			vo = new Om_job_workoutVO();
//		} else if (Constants.MID_BD_PSNBASDOC.equals(targetTable)) {
//			vo = new Bd_psnbasdocVO();
//		} else if (Constants.MID_BD_PSNDOC.equals(targetTable)) {
//			vo = new Bd_psndocVO();
//		} else if (Constants.MID_HI_PSNDOC_DEPTCHG.equals(targetTable)) {
//			vo = new Hi_psndoc_deptchgVO();
//		} else if (Constants.MID_HI_PSNDOC_PARTYLOG.equals(targetTable)) {
//			vo = new Hi_psndoc_partylogVO();
//		} else if (Constants.MID_HI_PSNDOC_EDU.equals(targetTable)) {
//			vo = new Hi_psndoc_eduVO();
//		} else if (Constants.MID_HI_PSNDOC_GRPDEF14.equals(targetTable)) {
//			vo = new Hi_psndoc_grpdef14VO();
//		} else if (Constants.MID_HI_PSNDOC_WORK.equals(targetTable)) {
//			vo = new Hi_psndoc_workVO();
//		} else if (Constants.MID_HI_PSNDOC_ABROAD.equals(targetTable)) {
//			vo = new Hi_psndoc_abroadVO();
//		} else if (Constants.MID_HI_PSNDOC_ENC.equals(targetTable)) {
//			vo = new Hi_psndoc_encVO();
//		} else if (Constants.MID_HI_PSNDOC_PUN.equals(targetTable)) {
//			vo = new Hi_psndoc_punVO();
//		} else if (Constants.MID_HI_PSNDOC_TRAINING.equals(targetTable)) {
//			vo = new Hi_psndoc_trainingVO();
//		} else if (Constants.MID_HI_PSNDOC_SPETECH.equals(targetTable)) {
//			vo = new Hi_psndoc_spetechVO();
//		} else if (Constants.MID_HI_PSNDOC_TECHRANK.equals(targetTable)) {
//			vo = new Hi_psndoc_techrankVO();
//		} else if (Constants.MID_HI_PSNDOC_GRPDEF11.equals(targetTable)) {
//			vo = new Hi_psndoc_grpdef11VO();
//		} else if (Constants.MID_HI_PSNDOC_DIMISSION.equals(targetTable)) {
//			vo = new Hi_psndoc_dimissionVO();
//		} else if (Constants.MID_HRLDM_LDPSN_INFO.equals(targetTable)) {
//			vo = new Hrldm_ldpsn_infoVO();
//		} else if (Constants.MID_HRLDM_PSNDOC_DUTY.equals(targetTable)) {
//			vo = new Hrldm_psndoc_dutyVO();
//		} else if (Constants.MID_HRLDM_TRAIN_PLAN.equals(targetTable)) {
//			vo = new Hrldm_train_planVO();
//		} else if (Constants.MID_HR_EXPERT.equals(targetTable)) {
//			vo = new Hr_expertVO();
//		} else if (Constants.MID_EXPERT_TERM.equals(targetTable)) {
//			vo = new Expert_termVO();
//		} else if (Constants.MID_WA_DATA.equals(targetTable)) {
//			vo = new Wa_dataVO();
//		}
//
//		return vo;
//	}
	
	/**
	 * @Title: extractDsbtDataFile
	 * @Description: 解压文件
	 * @param dataFile
	 * @param extractFolderPath
	 * @throws Exception
	 */
	private void extractDsbtDataFile(File dataFile, String extractFolderPath) throws BusinessException {
		try {
			Logger.debug("正在读取数据文件【" + dataFile.getName() + "】....");
			AntZipUtil.unZipFile(dataFile.getAbsolutePath(), extractFolderPath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("读取数据文件【" + dataFile.getName() + "】发生异常:" + e.getMessage(), e);
		}
	}
	
	/**
	 * @Title: findDBLocationFolder
	 * @Description: 读取db文件
	 * @param topFolder
	 * @return
	 */
	public File findDBLocationFolder(File topFolder) {
		File[] dbFolders = topFolder.listFiles(new ExtFilenameFilter(".db",
				"db数据文件"));
		if (dbFolders != null && dbFolders.length > 0) {
			return topFolder;
		}

		File[] subFiles = topFolder.listFiles();
		if (subFiles != null && subFiles.length > 0) {
			for (File subFile : subFiles) {
				if (subFile.isDirectory()) {
					File dbFolder = findDBLocationFolder(subFile);
					if (dbFolder != null) {
						return dbFolder;
					}
				}
			}
		}
		return null;
	}

}

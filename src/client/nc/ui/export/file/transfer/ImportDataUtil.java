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
 * @Description:  ҵ������Ǩ�Ƶ���
 * @Author: ����ǿ
 * @Date: 2017��5��12������11:17:48
 */
public class ImportDataUtil {

	private int maxrow = 1000;
	
	BillManageUI importUI;

	public ImportDataUtil(BillManageUI billUI) {
		importUI = billUI;
	}

	/**
	 * @Title: doImport
	 * @Description: �����������
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
			File dbFolder = findDBLocationFolder(dataFolder);// ��ȡ�ͻ����ļ�
			if (dbFolder == null) {
				Logger.error(">>>DataPath:" + dataFolderPath);
				throw new BusinessException("�ֲ�ʽ���������ļ���ʽ�����쳣!");
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
	 * @Description: ��ʼ����־��ͷ
	 * @Author: ����ǿ
	 * @Date: 2017��5��16��
	 * @param thistime
	 * @return
	 */
	public FbsDatafileVO initHeadLogVO(String thistime){
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// Ĭ�ϵ�ǰ��½��
		dataFileVO.setPk_corp(Global.getPkGroup());// Ĭ�ϵ�ǰ��½��˾
		dataFileVO.setOperate_time(new UFDateTime(thistime));// ����ʱ��
		dataFileVO.setIssuccess(UFBoolean.TRUE);
		dataFileVO.setIsall(UFBoolean.TRUE);
		dataFileVO.setIsspike(UFBoolean.FALSE);
		dataFileVO.setStart_date(null);
		dataFileVO.setVbillstatus(Integer.valueOf(8));// ��ȡ���ݽ���ʱ��
		dataFileVO.setVmemo(Constants.OPT_TYPE_IMPORT);
		return dataFileVO;
	}
	
	/**
	 * @Title: execute
	 * @Description: ִ�в�ѯ���ݺ�д������
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
		tableName.put("bd_deptdoc","���ŵ���");
		tableName.put("bd_psndoc","Ա��������Ϣ");
		tableName.put("bd_psnbasdoc","��Ա������Ϣ");
		tableName.put("om_job","��λ������Ϣ");
		tableName.put("om_job_workout","��λ������Ϣ");
		tableName.put("om_dept_workout","���ű�����Ϣ");
		tableName.put("om_corp_workout","��λ������Ϣ����");
		tableName.put("om_corp_workout_b","��λ�����ӱ�");
		tableName.put("hi_psndoc_edu","ѧ��ѧλ��Ϣ");
		tableName.put("om_duty","ְ�������Ϣ");
		tableName.put("hi_psndoc_work","Ա������������Ϣ");
		tableName.put("hi_psndoc_training","Ա����ѵ��Ϣ");
		tableName.put("hi_psndoc_techrank","���˼����ȼ�");
		tableName.put("hi_psndoc_spetech","רҵ����ְ��");
		tableName.put("hi_psndoc_pun","Ա���ʹ���Ϣ");
		tableName.put("hi_psndoc_partylog","������ò��Ϣ");
		tableName.put("hi_psndoc_grpdef14","��ͥ��Ա���ⱳ����Ϣ");
		tableName.put("hi_psndoc_grpdef11","֪ʶ��Ȩ��Ϣ");
		tableName.put("hi_psndoc_enc","Ա��������Ϣ");
		tableName.put("hi_psndoc_dimission","Ա����ְ��Ϣ");
		tableName.put("hi_psndoc_deptchg","Ա����ְ��Ϣ");
		tableName.put("hi_psndoc_abroad","Ա�����⾭����Ϣ");
		tableName.put("hrldm_ldpsn_info","�ɲ���Ϣ����-�ɲ�������Ϣ");
		tableName.put("hrldm_psndoc_duty","�쵼��Աְ����Ϣ�Ӽ�");
		tableName.put("hrldm_train_plan","�󱸸ɲ���Ϣ�Ӽ�");
		tableName.put("hr_expert","רҵ�˲Ź���-Ժʿר����Ϣά��");
		tableName.put("expert_term","Ժʿר���Ӽ���Ƹ�ڹ���");
		tableName.put("wa_data","н�����-�����ܶ�");

		Logger.debug("����ִ�����ݵ���......���Ժ�......");
		
		List<FbsDataFileItemVO> items = new ArrayList<FbsDataFileItemVO>();
		try{
			
			// 1.��bd�����б����ݷ���SuperVO[]��
			SuperVO[] superVOs = null;
			boolean isempty = true;
			ProcessLine.setMaximum(targetTable.length+1);
			for (int i = 0; i < targetTable.length; i++) {
				ProcessLine.addValueProcess(i+1, "���ڵ���"+ tableName.get(targetTable[i]) +"����......");
				int index = 0;
				int count = 0;
				//��ҳ
				while(true){
					superVOs = getDBMidData(conn, targetTable[i],index++);
					count += superVOs.length;
					if (superVOs != null && superVOs.length > 0) {
						isempty=false;
						//�ֱ����ҵ���
						expDataService.insertBusinessData(superVOs);
					}
					if(superVOs == null || superVOs.length < maxrow){
						break;
					}
				}
				getItemVO(count, tableName.get(targetTable[i]), items);
			}
			if (isempty) {
				throw new BusinessException("�����������Ϊ��!");
			}
			Logger.debug(">>��ϲ<<,���ݵ������.");
			ProcessLine.addValueProcess(targetTable.length+1, "���ݵ������......");
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
			// 1.��bd�����б����ݷ���SuperVO[]��,������map��s
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
			// ��ȡ����vo
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
					// ���ֶ���ֵ
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
				throw new BusinessException("�����" + errTable + "������ʱ�����쳣:"
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
	 * @Description: �ַ�������ĸ��д
	 * @Author: ����ǿ
	 * @Time: 2016��12��8�� ����1:04:15
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
	 * @Description: ��ѹ�ļ�
	 * @param dataFile
	 * @param extractFolderPath
	 * @throws Exception
	 */
	private void extractDsbtDataFile(File dataFile, String extractFolderPath) throws BusinessException {
		try {
			Logger.debug("���ڶ�ȡ�����ļ���" + dataFile.getName() + "��....");
			AntZipUtil.unZipFile(dataFile.getAbsolutePath(), extractFolderPath);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException("��ȡ�����ļ���" + dataFile.getName() + "�������쳣:" + e.getMessage(), e);
		}
	}
	
	/**
	 * @Title: findDBLocationFolder
	 * @Description: ��ȡdb�ļ�
	 * @param topFolder
	 * @return
	 */
	public File findDBLocationFolder(File topFolder) {
		File[] dbFolders = topFolder.listFiles(new ExtFilenameFilter(".db",
				"db�����ļ�"));
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

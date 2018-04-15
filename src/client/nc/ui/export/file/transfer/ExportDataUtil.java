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
 * @Description:  ҵ������Ǩ�Ƶ���
 * @Author: ����ǿ
 * @Date: 2017��5��16������12:24:09
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

		// ��ȡ�����ļ�������
		String filename = FileUtil.getFolderNameByTime();
		String dbHostFolderPath = fileSavePath + Constants.SEP + filename;

		// ��ȡ���ݲ��Ҳ��뵽�ļ����ݿ���
		Connection dbConnection = null;

		Statement statement = null;
		try {
			// .h2.db��׺�ļ�����·��(��ѹ���ļ�ͬ���ļ���)
			FileUtil.createFolder(dbHostFolderPath);
			
			// ��ȡ�ļ����ݿ�����
			dbConnection = H2Connection.getConnection(dbHostFolderPath);
			// 1.��ȡ���д�����ṹ��sql
			List<String> sqlStrs = getAllBSData.getAllCreateBSSqls();

			// ������ṹ
			statement = dbConnection.createStatement();
			for (int i = 0; i < sqlStrs.size(); i++) {
				statement.execute(sqlStrs.get(i));
			}
			FbsDatafileVO dataFileVO = initHeadLogVO(thistime);
			
			FbsDataFileItemVO[] bvos = saveData(dbConnection,statement, corpArr);
			// �ύ����
			dbConnection.commit();
			
			//�洢��־
			IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
					.getInstance().lookup(IFbsDataFileService.class.getName());
			ifdfService.saveLogVO(dataFileVO,bvos,new FbsExportTimeVO[]{});
		} catch (Exception e) {
			if(dbConnection!=null){
				dbConnection.rollback();
			}
			H2Connection.closeStatement(statement); 
			H2Connection.closeConnection(dbConnection); 
			//��������ˣ����ļ���ɾ��
			FileUtil.deleteFolder(dbHostFolderPath);
			e.printStackTrace();
			throw e;
		} finally {
			H2Connection.closeStatement(statement); 
			H2Connection.closeConnection(dbConnection); 
		}
		
		//����������
		ProcessLine.addValueProcess(29, "����ѹ���ļ�...");
		
		// ѹ���ļ�����·��
		File filePath = FileUtil.createFolder(fileSavePath);
		String zipFileName = filename + Constants.DATA_ZIP_EXTNAME;
		String zipFileFullPath = filePath.getAbsolutePath() + Constants.SEP + zipFileName;
		AntZipUtil.zipFile(zipFileFullPath, dbHostFolderPath);
		
		//�����ļ��к�ɾ���ļ���
		FileUtil.deleteFolder(dbHostFolderPath);

	}
	
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
		/************************************ 1.���ŵ��� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����ŵ���������... ...");
		list = getAllBSData.getBd_deptdocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "���ŵ���", items);
		index+=insertDB(statement, list);

		/************************************ 2.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = getAllBSData.getOm_jobData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��λ������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 3.ְ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��ְ�������Ϣ������... ...");
		list = getAllBSData.getOm_dutyData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "ְ�������Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 4.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = getAllBSData.getOm_corp_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��λ������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 5.��λ�����ӱ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ�����ӱ�����... ...");
		list = getAllBSData.getOm_corp_workout_bData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��λ�����ӱ�", items);
		index+=insertDB(statement, list);
		
		/************************************ 6.���ű�����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����ű�����Ϣ������... ...");
		list = getAllBSData.getOm_dept_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "���ű�����Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 7.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = getAllBSData.getOm_job_workoutData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��λ������Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 8.��Ա������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����Ա������Ϣ������... ...");
		list = getAllBSData.getBd_psnbasdocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��Ա������Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 9.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա��������Ϣ������... ...");
		list = getAllBSData.getBd_psndocData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա��������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 10.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ְ��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_deptchgData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա����ְ��Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 11.������ò��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��������ò��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_partylogData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "������ò��Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 12.ѧ��ѧλ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��ѧ��ѧλ��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_eduData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "ѧ��ѧλ��Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 13.��ͥ��Ա���ⱳ����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����ͥ��Ա���ⱳ����Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_grpdef14Data(corpArr);
		getItemVO(list == null ? 0 : list.size(), "��ͥ��Ա���ⱳ����Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 14.Ա������������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա������������Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_workData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա������������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 15.Ա�����⾭����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա�����⾭����Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_abroadData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա�����⾭����Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 16.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա��������Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_encData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա��������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 17.Ա���ʹ���Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա���ʹ���Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_punData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա���ʹ���Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 18.Ա����ѵ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ѵ��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_trainingData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա����ѵ��Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 19.רҵ����ְ�� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��רҵ����ְ������... ...");
		list = getAllBSData.getHi_psndoc_spetechData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "רҵ����ְ��", items);
		index+=insertDB(statement, list);

		/************************************ 20.���˼����ȼ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����˼����ȼ�������... ...");
		list = getAllBSData.getHi_psndoc_techrankData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "���˼����ȼ�", items);
		index+=insertDB(statement, list);

		/************************************ 21.֪ʶ��Ȩ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��֪ʶ��Ȩ��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_grpdef11Data(corpArr);
		getItemVO(list == null ? 0 : list.size(), "֪ʶ��Ȩ��Ϣ", items);
		index+=insertDB(statement, list);
		
		/************************************ 22.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ְ��Ϣ������... ...");
		list = getAllBSData.getHi_psndoc_dimissionData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ա����ְ��Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 23.�ɲ���Ϣ����-�ɲ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���ɲ���Ϣ����-�ɲ�������Ϣ������... ...");
		list = getAllBSData.getHrldm_ldpsn_infoData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "�ɲ���Ϣ����-�ɲ�������Ϣ", items);
		index+=insertDB(statement, list);

		/************************************ 24.�쵼��Աְ����Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���쵼��Աְ����Ϣ�Ӽ�������... ...");
		list = getAllBSData.getHrldm_psndoc_dutyData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "�쵼��Աְ����Ϣ�Ӽ�", items);
		index+=insertDB(statement, list);
		
		/************************************ 25.�󱸸ɲ���Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���󱸸ɲ���Ϣ�Ӽ�������... ...");
		list = getAllBSData.getHrldm_train_planData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "�󱸸ɲ���Ϣ�Ӽ�", items);
		index+=insertDB(statement, list);

		/************************************ 26.רҵ�˲Ź���-Ժʿר����Ϣά�� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��רҵ�˲Ź���-Ժʿר����Ϣά��������... ...");
		list = getAllBSData.getHr_expertData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "רҵ�˲Ź���-Ժʿר����Ϣά��", items);
		index+=insertDB(statement, list);

		/************************************ 27.Ժʿר���Ӽ���Ƹ�ڹ��� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ժʿר���Ӽ���Ƹ�ڹ�������... ...");
		list = getAllBSData.getExpert_termData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "Ժʿר���Ӽ���Ƹ�ڹ���", items);
		index+=insertDB(statement, list);
		
		/************************************ 28.н�����-�����ܶ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��н�����-�����ܶ����... ...");
		list = getAllBSData.getWa_dataData(corpArr);
		getItemVO(list == null ? 0 : list.size(), "н�����-�����ܶ�", items);
		index+=insertDB(statement, list);
		
		if(index==0){
			throw new BusinessException("û�л�ȡ����������������,����ȷ�ϣ�");
		}
		return items.toArray(new FbsDataFileItemVO[items.size()]);

	}
	public int insertDB(Statement st, List<SuperVO> list ) throws Exception {
		int count=0;
		if (list == null || list.size() == 0) {
			return 0;
		}

		// step1.����28�ű�db����
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
	 * ƴsql�Ƿ���Ҫ����
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

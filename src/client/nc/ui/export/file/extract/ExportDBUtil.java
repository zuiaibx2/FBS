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
 * @ClassName: ExportDBUtil <b> ǰ̨��ȡdb�ļ������� </b>
 *             <p>
 *             �����ԭ�����йس�ȡdb�ļ��Ĵ����������������
 *             </p>
 *             ��������: 2016��10��13�� ����11:49:55
 * @Author ����ǿ
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
	 * @Description: �����ļ����������
	 * @Time: 2016��10��14�� ����2:15:44
	 * @param fileSavePath
	 * @param nowtime
	 * @param lasttime
	 * @throws Exception
	 */
	public void exportData(String fileSavePath, String nowtime, String lasttime)
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
			List<String> sqlStrs = ifdfService.getAllCreateSqls();

			// ������ṹ
			statement = dbConnection.createStatement();
			for (int i = 0; i < sqlStrs.size(); i++) {
				statement.execute(sqlStrs.get(i));
			}

			String version = ifdfService.getToolVersion();
			//�����汾��Ϣ
			if(version!=null){
				statement.execute("insert into fbs_version(version) values ('"+version+"')");
				dbConnection.commit();
			}
			// ��ȡ���ݲ��ұ��浽db��
			FbsDataFileItemVO[] bvos = saveData(dbConnection,statement, lasttime);
			// �ύ����
//			dbConnection.commit();
			// ����汾��Ϣ
			saveVersion( statement, nowtime, lasttime);
			// �ύ����
			dbConnection.commit();
			
			FbsDatafileVO dataFileVO = new FbsDatafileVO();
			dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// Ĭ�ϵ�ǰ��½��
			dataFileVO.setPk_corp(Global.getPkGroup());// Ĭ�ϵ�ǰ��½��˾
			dataFileVO.setOperate_time(new UFDateTime(nowtime));// ����ʱ��
			dataFileVO.setIssuccess(UFBoolean.TRUE);
			dataFileVO.setIsall(lasttime==null?UFBoolean.TRUE:UFBoolean.FALSE);
			dataFileVO.setIsspike(lasttime!=null?UFBoolean.TRUE:UFBoolean.FALSE);
			dataFileVO.setStart_date(lasttime == null?null:new UFDateTime(lasttime));
			dataFileVO.setVbillstatus(Integer.valueOf(8));// ��ȡ���ݽ���ʱ��
			
			dataFileVO.setVmemo(Constants.OPT_TYPE_DATA);
			
			ifdfService.saveLogVO(dataFileVO,bvos,getExtTime(nowtime, lasttime));

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
		
		//��ѯbd_corp����mid_bd_corp�����ӵ�mid_bd_corp��pk_corp
		String sql = "select mc.pk_corp from bd_corp c inner join mid_bd_corp mc on mc.unitcode = c.unitcode ";
		//��ѯ��һ��sql����fbs_expcorp_conf���д��ڵ�mid_bd_corp��pk_corp
		String sql_corp = "select distinct mc.pk_corp from bd_corp c inner join fbs_expcorp_conf conf on c.pk_corp = conf.exp_pk_corp and isnull(conf.dr,0) = 0 inner join mid_bd_corp mc on mc.unitcode = c.unitcode ";
		
		list = (List) bs.executeQuery(sql_corp, new ArrayListProcessor());
		if(list == null || list.size() == 0){
			//�Ȳ�ѯ���ݳ�ȡ���ýڵ���û�����ù�˾����������˾Ͱ������õĲ�ѯ�����û����������Ĭ�ϲ�ѯ
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
		
		if (lasttime==null) {// ȫ����
			
		} else {// ����
			whereBuffer.append(" and ts_m > '" + lasttime + "'");
		}
		String whereStr = whereBuffer.toString();

		// step3.���ݲ�ѯ������ѯ����28�ű�����
		List<SuperVO> list = new ArrayList<SuperVO>();
		List<FbsDataFileItemVO> logvos = new ArrayList<FbsDataFileItemVO>();
		int index = 0;
		/************************************ 1.���ŵ��� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����ŵ���������... ...");
		list = ifdfService.getSpikeData(Bd_deptdocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"���ŵ���");

		/************************************ 2.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = ifdfService.getSpikeData(Om_jobVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��λ������Ϣ");

		/************************************ 3.ְ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��ְ�������Ϣ������... ...");
		list = ifdfService.getSpikeData(OmDutyVo.class, whereStr);
		index+=insertDB(statement, list, logvos,"ְ�������Ϣ");
		
		/************************************ 4.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = ifdfService.getSpikeData(Om_corp_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��λ������Ϣ");

		/************************************ 5.��λ�����ӱ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ�����ӱ�����... ...");
		list = ifdfService.getSpikeData(Om_corp_workout_bVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��λ�����ӱ�");
		
		/************************************ 6.���ű�����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����ű�����Ϣ������... ...");
		list = ifdfService.getSpikeData(Om_dept_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"���ű�����Ϣ");
		
		/************************************ 7.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����λ������Ϣ������... ...");
		list = ifdfService.getSpikeData(Om_job_workoutVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��λ������Ϣ");
		
		/************************************ 8.��Ա������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����Ա������Ϣ������... ...");
		list = ifdfService.getSpikeData(Bd_psnbasdocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��Ա������Ϣ");
		
		/************************************ 9.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա��������Ϣ������... ...");
		list = ifdfService.getSpikeData(Bd_psndocVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա��������Ϣ");

		/************************************ 10.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ְ��Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_deptchgVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա����ְ��Ϣ");

		/************************************ 11.������ò��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��������ò��Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_partylogVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"������ò��Ϣ");

		/************************************ 12.ѧ��ѧλ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��ѧ��ѧλ��Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_eduVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"ѧ��ѧλ��Ϣ");
		
		/************************************ 13.��ͥ��Ա���ⱳ����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ����ͥ��Ա���ⱳ����Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_grpdef14VO.class, whereStr);
		index+=insertDB(statement, list, logvos,"��ͥ��Ա���ⱳ����Ϣ");

		/************************************ 14.Ա������������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա������������Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_workVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա������������Ϣ");

		/************************************ 15.Ա�����⾭����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա�����⾭����Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_abroadVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա�����⾭����Ϣ");

		/************************************ 16.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա��������Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_encVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա��������Ϣ");

		/************************************ 17.Ա���ʹ���Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա���ʹ���Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_punVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա���ʹ���Ϣ");

		/************************************ 18.Ա����ѵ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ѵ��Ϣ������... ...");
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
		itemVo.setTable_name("Ա����ѵ��Ϣ");
		logvos.add(itemVo);
		index+=pxsize;
		
		/************************************ 19.רҵ����ְ�� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��רҵ����ְ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_spetechVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"רҵ����ְ��");

		/************************************ 20.���˼����ȼ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ�����˼����ȼ�������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_techrankVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"���˼����ȼ�");

		/************************************ 21.֪ʶ��Ȩ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��֪ʶ��Ȩ��Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_grpdef11VO.class, whereStr);
		index+=insertDB(statement, list, logvos,"֪ʶ��Ȩ��Ϣ");
		
		/************************************ 22.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ա����ְ��Ϣ������... ...");
		list = ifdfService.getSpikeData(Hi_psndoc_dimissionVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ա����ְ��Ϣ");

		/************************************ 23.�ɲ���Ϣ����-�ɲ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���ɲ���Ϣ����-�ɲ�������Ϣ������... ...");
		list = ifdfService.getSpikeData(Hrldm_ldpsn_infoVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"�ɲ���Ϣ����-�ɲ�������Ϣ");

		/************************************ 24.�쵼��Աְ����Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���쵼��Աְ����Ϣ�Ӽ�������... ...");
		list = ifdfService.getSpikeData(Hrldm_psndoc_dutyVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"�쵼��Աְ����Ϣ�Ӽ�");
		
		/************************************ 25.�󱸸ɲ���Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ���󱸸ɲ���Ϣ�Ӽ�������... ...");
		list = ifdfService.getSpikeData(Hrldm_train_planVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"�󱸸ɲ���Ϣ�Ӽ�");

		/************************************ 26.רҵ�˲Ź���-Ժʿר����Ϣά�� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��רҵ�˲Ź���-Ժʿר����Ϣά��������... ...");
		list = ifdfService.getSpikeData(Hr_expertVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"רҵ�˲Ź���-Ժʿר����Ϣά��");

		/************************************ 27.Ժʿר���Ӽ���Ƹ�ڹ��� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��Ժʿר���Ӽ���Ƹ�ڹ�������... ...");
		list = ifdfService.getSpikeData(Expert_termVO.class, whereStr);
		index+=insertDB(statement, list, logvos,"Ժʿר���Ӽ���Ƹ�ڹ���");
		
		/************************************ 9.н�����-�����ܶ� ************************************/
		ProcessLine.addDefaultProcess("���ڳ�ȡ��н�����-�����ܶ����... ...");
		
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
		itemVo.setTable_name("н�����-�����ܶ�");
		logvos.add(itemVo);
		index+=wasize;
		
		if(index==0){
			throw new BusinessException("û�л�ȡ����������������,����ȷ�ϣ�");
		}

		return logvos.toArray(new FbsDataFileItemVO[logvos.size()]);
	}
//	private void initTabcodename() {
//		tabcode_name.put("mid_wa_data", "н�����-�����ܶ�");
//		tabcode_name.put("mid_expert_term", "Ժʿר���Ӽ���Ƹ�ڹ���");
//		tabcode_name.put("mid_hr_expert", "רҵ�˲Ź���-Ժʿר����Ϣά��");
//		
//		tabcode_name.put("mid_hrldm_train_plan", "�󱸸ɲ���Ϣ�Ӽ�");
//		tabcode_name.put("mid_hrldm_ldpsn_info", "�ɲ���Ϣ����-�ɲ�������Ϣ");
//		tabcode_name.put("mid_hrldm_psndoc_duty", "�쵼��Աְ����Ϣ�Ӽ�");
//		tabcode_name.put("mid_hi_psndoc_dimission", "Ա����ְ��Ϣ");
//		tabcode_name.put("mid_hi_psndoc_grpdef11", "֪ʶ��Ȩ��Ϣ");
//		
//		tabcode_name.put("mid_hi_psndoc_spetech", "רҵ����ְ��");
//		tabcode_name.put("mid_hi_psndoc_techrank", "���˼����ȼ�");
//		tabcode_name.put("mid_hi_psndoc_training", "Ա����ѵ��Ϣ");
//		tabcode_name.put("mid_hi_psndoc_pun", "Ա���ʹ���Ϣ");
//		tabcode_name.put("mid_hi_psndoc_enc", "Ա��������Ϣ");
//		
//		tabcode_name.put("mid_hi_psndoc_work", "Ա������������Ϣ");
//		tabcode_name.put("mid_hi_psndoc_abroad", "Ա�����⾭����Ϣ");
//		tabcode_name.put("mid_hi_psndoc_grpdef14", "��ͥ��Ա���ⱳ����Ϣ");
//		tabcode_name.put("mid_hi_psndoc_partylog", "������ò��Ϣ");
//		tabcode_name.put("mid_hi_psndoc_edu", "ѧ��ѧλ��Ϣ");
//		
//		tabcode_name.put("mid_om_dept_workout", "���ű�����Ϣ");
//		tabcode_name.put("mid_om_job_workout", "��λ������Ϣ");
//		tabcode_name.put("mid_bd_psnbasdoc", "��Ա������Ϣ");
//		tabcode_name.put("mid_bd_psndoc", "Ա��������Ϣ");
//		tabcode_name.put("mid_hi_psndoc_deptchg", "Ա����ְ��Ϣ");
//		
//		
//		tabcode_name.put("mid_bd_deptdoc", "���ŵ���");
//		tabcode_name.put("mid_om_job", "��λ������Ϣ");
//		tabcode_name.put("mid_om_duty", "ְ�������Ϣ");
//		tabcode_name.put("mid_om_corp_workout_b", "��λ�����ӱ�");
//		tabcode_name.put("mid_om_corp_workout", "��λ������Ϣ");
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
	 * @Description: ���汾�γ�ȡ�ļ�ʱ��
	 * @Author: ����ǿ
	 * @Date: 2016��9��5��
	 * @param time
	 * @param dbFlag
	 * @throws BusinessException
	 */
	public FbsExportTimeVO[] getExtTime(String time, String lasttime)
			throws BusinessException {
		
		String isall = "N";// N:�������ݣ�Y��ȫ������
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

package nc.ui.export.file.extract;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.rpc.ServiceException;

import nc.bs.framework.common.NCLocator;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.export.file.IFbsDataFileService;
import nc.pub.Constants;
import nc.ui.export.webservice.IWriteWSDataServiceLocator;
import nc.ui.export.webservice.IWriteWSDataServicePortType;
import nc.ui.trade.manage.BillManageUI;
import nc.vo.Export.FbsDataFileItemVO;
import nc.vo.Export.FbsDatafileVO;
import nc.vo.hr.iufo.func.Global;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.ws.itf.ISendDataService;
import nc.ws.vo.bd.Bd_deptdocVO;
import nc.ws.vo.bd.Bd_psnbasdocVO;
import nc.ws.vo.bd.Bd_psndocVO;
import nc.ws.vo.expert.Expert_termVO;
import nc.ws.vo.hi.Hi_psndoc_abroadVO;
import nc.ws.vo.hi.Hi_psndoc_deptchgVO;
import nc.ws.vo.hi.Hi_psndoc_dimissionVO;
import nc.ws.vo.hi.Hi_psndoc_eduVO;
import nc.ws.vo.hi.Hi_psndoc_encVO;
import nc.ws.vo.hi.Hi_psndoc_grpdef11VO;
import nc.ws.vo.hi.Hi_psndoc_grpdef14VO;
import nc.ws.vo.hi.Hi_psndoc_partylogVO;
import nc.ws.vo.hi.Hi_psndoc_punVO;
import nc.ws.vo.hi.Hi_psndoc_spetechVO;
import nc.ws.vo.hi.Hi_psndoc_techrankVO;
import nc.ws.vo.hi.Hi_psndoc_trainingVO;
import nc.ws.vo.hi.Hi_psndoc_workVO;
import nc.ws.vo.hr.Hr_expertVO;
import nc.ws.vo.hrldm.Hrldm_ldpsn_infoVO;
import nc.ws.vo.hrldm.Hrldm_psndoc_dutyVO;
import nc.ws.vo.hrldm.Hrldm_train_planVO;
import nc.ws.vo.om.Om_corp_workoutVO;
import nc.ws.vo.om.Om_corp_workout_bVO;
import nc.ws.vo.om.Om_dept_workoutVO;
import nc.ws.vo.om.Om_dutyVO;
import nc.ws.vo.om.Om_jobVO;
import nc.ws.vo.om.Om_job_workoutVO;
import nc.ws.vo.version.Fbs_export_timeVO;
import nc.ws.vo.wa.Wa_dataVO;

/**
 * @ClassName: WSSendDataUtil <b> webservice�������ݹ����� </b>
 *             <p>
 *             �ڴ˴���Ӵ����������Ϣ
 *             </p>
 *             ��������: 2016��11��7�� ����11:54:33
 * @Author ����ǿ
 * @Version
 */
public class WSSendDataUtil {
	BillManageUI sendUI;

	public WSSendDataUtil(BillManageUI billUI) {
		this.sendUI = billUI;
	}

	private IWriteWSDataServicePortType service = null;
	private IWriteWSDataServicePortType getWsService() throws ServiceException {
		if (service == null) {
			service = new IWriteWSDataServiceLocator().getIWriteWSDataServiceSOAP11port_http();
		}
		return service;
	}

	private ISendDataService sendService = null;
	private ISendDataService getSendService() {
		if (sendService == null) {
			sendService = (ISendDataService) NCLocator.getInstance().lookup(ISendDataService.class.getName());
		}
		return sendService;
	}

	private static int MAX_SIZE = 10000;

	/**
	 * @Title: doSendData
	 * @Description: ���ݴ������
	 * @Author: ����ǿ
	 * @Time: 2016��11��7�� ����2:32:56
	 * @param lastTime
	 * @param thisTime
	 * @throws RemoteException
	 * @throws ServiceException
	 * @throws Exception
	 */
	public void doSendData(String lastTime, String nowtime) throws BusinessException, RemoteException, ServiceException {
		try {
			ExportDBUtil expdbutil = new ExportDBUtil(sendUI);
			List<FbsDataFileItemVO> logvos = new ArrayList<FbsDataFileItemVO>();
			// У�鲹���汾
			IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator.getInstance().lookup(IFbsDataFileService.class.getName());
			String version = ifdfService.getToolVersion();
			String result = getWsService().checkToolVersion(version);
			if (result != null && !"".equals(result)) {
				throw new BusinessException(result);
			}
			// У�����ݰ汾
			String[] pkCorps = expdbutil.getPkCorps();
			result = getWsService().checkWsVersion(getOldVersion(pkCorps, lastTime));
			if (result != null && !"".equals(result)) {
				throw new BusinessException(result);
			}
			// ��ȡ����
			Map<String, List<?>> map = getData(lastTime);

			// ��������
			FbsDataFileItemVO[] bvos = sendData(logvos, map);

			// ������־
			ifdfService.saveLogVO(getDataFileVO(lastTime, nowtime), bvos, expdbutil.getExtTime(nowtime, lastTime));

			// �޸ļ��Ű汾
			getWsService().insertWSVersion(getNewVersion(pkCorps, nowtime));
			// ����������
			ProcessLine.addValueProcess(58, "������ɡ�");
		} catch (BusinessException e) {
			e.printStackTrace();
			throw (e);
		}
	}

	private Fbs_export_timeVO[] getOldVersion(String[] pkCorps, String lasttime) {
		Fbs_export_timeVO[] versionArr = new Fbs_export_timeVO[pkCorps.length];
		Fbs_export_timeVO versionVO = null;
		if (pkCorps == null || pkCorps.length == 0) {
			return versionArr;
		}
		for (int i = 0; i < pkCorps.length; i++) {
			versionVO = new Fbs_export_timeVO();
			versionVO.setTime(lasttime);
			versionVO.setPk_corp(pkCorps[i]);
			versionArr[i] = versionVO;
		}
		return versionArr;
	}

	private Fbs_export_timeVO[] getNewVersion(String[] pkCorps, String nowtime) {
		Fbs_export_timeVO[] versionArr = new Fbs_export_timeVO[pkCorps.length];
		Fbs_export_timeVO versionVO = null;
		if (pkCorps == null || pkCorps.length == 0) {
			return versionArr;
		}
		for (int i = 0; i < pkCorps.length; i++) {
			versionVO = new Fbs_export_timeVO();
			versionVO.setTime(nowtime);
			versionVO.setPk_corp(pkCorps[i]);
			versionArr[i] = versionVO;
		}
		return versionArr;
	}

	/**
	 * @Title: getDataFileVO
	 * @Description: ���ݴ�����־
	 * @Author: ����ǿ
	 * @Time: 2016��12��13�� ����1:36:42
	 * @param lastTime
	 * @param nowtime
	 * @return
	 */
	private FbsDatafileVO getDataFileVO(String lastTime, String nowtime) {
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// Ĭ�ϵ�ǰ��½��
		dataFileVO.setPk_corp(Global.getPkGroup());// Ĭ�ϵ�ǰ��½��˾
		dataFileVO.setOperate_time(new UFDateTime(nowtime));// ����ʱ��
		dataFileVO.setIssuccess(UFBoolean.TRUE);
		dataFileVO.setIsall(lastTime == null ? UFBoolean.TRUE : UFBoolean.FALSE);
		dataFileVO.setIsspike(lastTime != null ? UFBoolean.TRUE : UFBoolean.FALSE);
		dataFileVO.setStart_date(new UFDateTime(lastTime));
		dataFileVO.setVbillstatus(Integer.valueOf(8));// ��ȡ���ݽ���ʱ��

		dataFileVO.setVmemo(Constants.OPT_TYPE_SEND);
		return dataFileVO;
	}

	/**
	 * @Title: getData
	 * @Description: ��ȡ���ݣ��˷��������У�����ݴ�С��Χ��������2M���ݣ���ʱδ��ӣ�
	 * @Author: ����ǿ
	 * @Time: 2016��12��13�� ����1:41:20
	 * @param lasttime
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, List<?>> getData(String lasttime) throws BusinessException {
		StringBuffer whereBuffer = new StringBuffer(" 1=1 ");

		if (lasttime != null) {// ����
			whereBuffer.append(" and ts_m > '" + lasttime + "'");
		}
		String whereStr = whereBuffer.toString();
		int index = 0;
		// ���ݲ�ѯ������ѯ����28�ű�����
		Map<String, List<?>> map = new HashMap<String, List<?>>();
		/************************************ 1.���ŵ��� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ�����ŵ���������......");
		List<Bd_deptdocVO> deptdoc_list = getSendService().getBd_deptdocData(whereStr);
		map.put(Constants.MID_BD_DEPTDOC, deptdoc_list);
		index += deptdoc_list.size();
		checkDataSize(index);

		/************************************ 2.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����λ������Ϣ������......");
		List<Om_jobVO> omjob_list = getSendService().getOm_jobData(whereStr);
		map.put(Constants.MID_OM_JOB, omjob_list);
		index += omjob_list.size();
		checkDataSize(index);

		/************************************ 3.ְ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��ְ�������Ϣ������......");
		List<Om_dutyVO> omduty_list = getSendService().getOm_dutyData(whereStr);
		map.put(Constants.MID_OM_DUTY, omduty_list);
		index += omduty_list.size();
		checkDataSize(index);

		/************************************ 4.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����λ������Ϣ������......");
		List<Om_corp_workoutVO> corpworkout_list = getSendService().getOm_corp_workoutData(whereStr);
		map.put(Constants.MID_OM_CORP_WORKOUT, corpworkout_list);
		index += corpworkout_list.size();
		checkDataSize(index);

		/************************************ 5.��λ�����ӱ� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����λ�����ӱ�����......");
		List<Om_corp_workout_bVO> corpworkoutb_list = getSendService().getOm_corp_workout_bData(whereStr);
		map.put(Constants.MID_OM_CORP_WORKOUT_B, corpworkoutb_list);
		index += corpworkoutb_list.size();
		checkDataSize(index);

		/************************************ 6.���ű�����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ�����ű�����Ϣ������......");
		List<Om_dept_workoutVO> deptworkout_list = getSendService().getOm_dept_workoutData(whereStr);
		map.put(Constants.MID_OM_DEPT_WORKOUT, deptworkout_list);
		index += deptworkout_list.size();
		checkDataSize(index);

		/************************************ 7.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����λ������Ϣ������......");
		List<Om_job_workoutVO> jobworkout_list = getSendService().getOm_job_workoutData(whereStr);
		map.put(Constants.MID_OM_JOB_WORKOUT, jobworkout_list);
		index += jobworkout_list.size();
		checkDataSize(index);

		/************************************ 8.��Ա������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����Ա������Ϣ������......");
		List<Bd_psnbasdocVO> psnbasdoc_list = getSendService().getBd_psnbasdocData(whereStr);
		map.put(Constants.MID_BD_PSNBASDOC, psnbasdoc_list);
		index += psnbasdoc_list.size();
		checkDataSize(index);

		/************************************ 9.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա��������Ϣ������......");
		List<Bd_psndocVO> psndoc_list = getSendService().getBd_psndocData(whereStr);
		map.put(Constants.MID_BD_PSNDOC, psndoc_list);
		index += psndoc_list.size();
		checkDataSize(index);

		/************************************ 10.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա����ְ��Ϣ������......");
		List<Hi_psndoc_deptchgVO> deptchg_list = getSendService().getHi_psndoc_deptchgData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_DEPTCHG, deptchg_list);
		index += deptchg_list.size();
		checkDataSize(index);

		/************************************ 11.������ò��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��������ò��Ϣ������......");
		List<Hi_psndoc_partylogVO> partylog_list = getSendService().getHi_psndoc_partylogData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_PARTYLOG, partylog_list);
		index += partylog_list.size();
		checkDataSize(index);

		/************************************ 12.ѧ��ѧλ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��ѧ��ѧλ��Ϣ������......");
		List<Hi_psndoc_eduVO> edu_ist = getSendService().getHi_psndoc_eduData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_EDU, edu_ist);
		index += edu_ist.size();
		checkDataSize(index);

		/************************************ 13.��ͥ��Ա���ⱳ����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ����ͥ��Ա���ⱳ����Ϣ������......");
		List<Hi_psndoc_grpdef14VO> grpdef14_list = getSendService().getHi_psndoc_grpdef14Data(whereStr);
		map.put(Constants.MID_HI_PSNDOC_GRPDEF14, grpdef14_list);
		index += grpdef14_list.size();
		checkDataSize(index);

		/************************************ 14.Ա������������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա������������Ϣ������......");
		List<Hi_psndoc_workVO> work_list = getSendService().getHi_psndoc_workData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_WORK, work_list);
		index += work_list.size();
		checkDataSize(index);

		/************************************ 15.Ա�����⾭����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա�����⾭����Ϣ������......");
		List<Hi_psndoc_abroadVO> abroad_list = getSendService().getHi_psndoc_abroadData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_ABROAD, abroad_list);
		index += abroad_list.size();
		checkDataSize(index);

		/************************************ 16.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա��������Ϣ������......");
		List<Hi_psndoc_encVO> enc_list = getSendService().getHi_psndoc_encData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_ENC, enc_list);
		index += enc_list.size();
		checkDataSize(index);

		/************************************ 17.Ա���ʹ���Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա���ʹ���Ϣ������......");
		List<Hi_psndoc_punVO> pun_list = getSendService().getHi_psndoc_punData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_PUN, pun_list);
		index += pun_list.size();
		checkDataSize(index);

		/************************************ 18.Ա����ѵ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա����ѵ��Ϣ������......");
		List<Hi_psndoc_trainingVO> training_list = getSendService().getHi_psndoc_trainingData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_TRAINING, training_list);
		index += training_list.size();
		checkDataSize(index);

		/************************************ 19.רҵ����ְ�� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��רҵ����ְ������......");
		List<Hi_psndoc_spetechVO> spetech_list = getSendService().getHi_psndoc_spetechData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_SPETECH, spetech_list);
		index += spetech_list.size();
		checkDataSize(index);

		/************************************ 20.���˼����ȼ� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ�����˼����ȼ�������......");
		List<Hi_psndoc_techrankVO> techrank_list = getSendService().getHi_psndoc_techrankData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_TECHRANK, techrank_list);
		index += techrank_list.size();
		checkDataSize(index);

		/************************************ 21.֪ʶ��Ȩ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��֪ʶ��Ȩ��Ϣ������......");
		List<Hi_psndoc_grpdef11VO> grpdef11_list = getSendService().getHi_psndoc_grpdef11Data(whereStr);
		map.put(Constants.MID_HI_PSNDOC_GRPDEF11, grpdef11_list);
		index += grpdef11_list.size();
		checkDataSize(index);

		/************************************ 22.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ա����ְ��Ϣ������......");
		List<Hi_psndoc_dimissionVO> dimission_list = getSendService().getHi_psndoc_dimissionData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_DIMISSION, dimission_list);
		index += dimission_list.size();
		checkDataSize(index);

		/************************************ 23.�ɲ���Ϣ����-�ɲ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ���ɲ���Ϣ����-�ɲ�������Ϣ������......");
		List<Hrldm_ldpsn_infoVO> psndocinfo_list = getSendService().getHrldm_ldpsn_infoData(whereStr);
		map.put(Constants.MID_HRLDM_LDPSN_INFO, psndocinfo_list);
		index += psndocinfo_list.size();
		checkDataSize(index);

		/************************************ 24.�쵼��Աְ����Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ���쵼��Աְ����Ϣ�Ӽ�������......");
		List<Hrldm_psndoc_dutyVO> psndocduty_list = getSendService().getHrldm_psndoc_dutyData(whereStr);
		map.put(Constants.MID_HRLDM_PSNDOC_DUTY, psndocduty_list);
		index += psndocduty_list.size();
		checkDataSize(index);

		/************************************ 25.�󱸸ɲ���Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ���󱸸ɲ���Ϣ�Ӽ�������......");
		List<Hrldm_train_planVO> trainplan_list = getSendService().getHrldm_train_planData(whereStr);
		map.put(Constants.MID_HRLDM_TRAIN_PLAN, trainplan_list);
		index += trainplan_list.size();
		checkDataSize(index);

		/************************************ 26.רҵ�˲Ź���-Ժʿר����Ϣά�� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��רҵ�˲Ź���-Ժʿר����Ϣά��������......");
		List<Hr_expertVO> expert_list = getSendService().getHr_expertData(whereStr);
		map.put(Constants.MID_HR_EXPERT, expert_list);
		index += expert_list.size();
		checkDataSize(index);

		/************************************ 27.Ժʿר���Ӽ���Ƹ�ڹ��� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��Ժʿר���Ӽ���Ƹ�ڹ�������......");
		List<Expert_termVO> term_list = getSendService().getExpert_termData(whereStr);
		map.put(Constants.MID_EXPERT_TERM, term_list);
		index += term_list.size();
		checkDataSize(index);

		/************************************ 9.н�����-�����ܶ� ************************************/
		ProcessLine.addDefaultProcess("���ڻ�ȡ��н�����-�����ܶ����......");
		List<Wa_dataVO> wa_list = getSendService().getWa_dataData(whereStr);
		map.put(Constants.MID_WA_DATA, wa_list);
		index += wa_list.size();
		checkDataSize(index);

		if (index == 0) {
			throw new BusinessException("û�л�ȡ����������������,����ȷ�ϣ�");
		}
		return map;
	}

	private void checkDataSize(int count) throws BusinessException {
		if (count > MAX_SIZE) {
			throw new BusinessException("������̫�󣬱�����֧����ഫ��" + MAX_SIZE + "�����ݣ��������ڶɡ�->����ȡ���ݡ���ť!");
		}
	}

	/**
	 * @Title: sendData
	 * @Description: ����webservice�ӿڴ�������
	 * @Author: ����ǿ
	 * @Time: 2016��12��13�� ����1:42:35
	 * @param logvos
	 * @param map
	 * @return
	 * @throws BusinessException
	 * @throws RemoteException
	 * @throws ServiceException
	 */
	@SuppressWarnings({ "unchecked", "restriction" })
	public FbsDataFileItemVO[] sendData(List<FbsDataFileItemVO> logvos, Map<String, List<?>> map) throws BusinessException, RemoteException, ServiceException {
		String result = null;
		/************************************ 1.���ŵ��� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾���ŵ���������......");
		List<Bd_deptdocVO> deptdoc_list = (List<Bd_deptdocVO>) map.get(Constants.MID_BD_DEPTDOC);
		result = getWsService().writeBd_deptdoc(deptdoc_list.toArray(new Bd_deptdocVO[deptdoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "���ŵ���", deptdoc_list.size());

		/************************************ 2.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��λ������Ϣ������......");
		List<Om_jobVO> omjob_list = (List<Om_jobVO>) map.get(Constants.MID_OM_JOB);
		result = getWsService().writeOm_job(omjob_list.toArray(new Om_jobVO[omjob_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��λ������Ϣ", omjob_list.size());

		/************************************ 3.ְ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾ְ�������Ϣ������......");
		List<Om_dutyVO> omduty_list = (List<Om_dutyVO>) map.get(Constants.MID_OM_DUTY);
		result = getWsService().writeOm_duty(omduty_list.toArray(new Om_dutyVO[omduty_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "ְ�������Ϣ", omduty_list.size());

		/************************************ 4.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��λ������Ϣ������......");
		List<Om_corp_workoutVO> corpworkout_list = (List<Om_corp_workoutVO>) map.get(Constants.MID_OM_CORP_WORKOUT);
		result = getWsService().writeOm_corp_workout(corpworkout_list.toArray(new Om_corp_workoutVO[corpworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��λ������Ϣ", corpworkout_list.size());

		/************************************ 5.��λ�����ӱ� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��λ�����ӱ�����......");
		List<Om_corp_workout_bVO> corpworkoutb_list = (List<Om_corp_workout_bVO>) map.get(Constants.MID_OM_CORP_WORKOUT_B);
		result = getWsService().writeOm_corp_workout_b(corpworkoutb_list.toArray(new Om_corp_workout_bVO[corpworkoutb_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��λ�����ӱ�", corpworkoutb_list.size());

		/************************************ 6.���ű�����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾���ű�����Ϣ������......");
		List<Om_dept_workoutVO> deptworkout_list = (List<Om_dept_workoutVO>) map.get(Constants.MID_OM_DEPT_WORKOUT);
		result = getWsService().writeOm_dept_workout(deptworkout_list.toArray(new Om_dept_workoutVO[deptworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "���ű�����Ϣ", deptworkout_list.size());

		/************************************ 7.��λ������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��λ������Ϣ������......");
		List<Om_job_workoutVO> jobworkout_list = (List<Om_job_workoutVO>) map.get(Constants.MID_OM_JOB_WORKOUT);
		result = getWsService().writeOm_job_workout(jobworkout_list.toArray(new Om_job_workoutVO[jobworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��λ������Ϣ", jobworkout_list.size());

		/************************************ 8.��Ա������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��Ա������Ϣ������......");
		List<Bd_psnbasdocVO> psnbasdoc_list = (List<Bd_psnbasdocVO>) map.get(Constants.MID_BD_PSNBASDOC);
		result = getWsService().writeBd_psnbasdoc(psnbasdoc_list.toArray(new Bd_psnbasdocVO[psnbasdoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��Ա������Ϣ", psnbasdoc_list.size());

		/************************************ 9.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա��������Ϣ������......");
		List<Bd_psndocVO> psndoc_list = (List<Bd_psndocVO>) map.get(Constants.MID_BD_PSNDOC);
		result = getWsService().writeBd_psndoc(psndoc_list.toArray(new Bd_psndocVO[psndoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա��������Ϣ", psndoc_list.size());

		/************************************ 10.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա����ְ��Ϣ������......");
		List<Hi_psndoc_deptchgVO> deptchg_list = (List<Hi_psndoc_deptchgVO>) map.get(Constants.MID_HI_PSNDOC_DEPTCHG);
		result = getWsService().writeHi_psndoc_deptchg(deptchg_list.toArray(new Hi_psndoc_deptchgVO[deptchg_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա����ְ��Ϣ", deptchg_list.size());

		/************************************ 11.������ò��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾������ò��Ϣ������......");
		List<Hi_psndoc_partylogVO> partylog_list = (List<Hi_psndoc_partylogVO>) map.get(Constants.MID_HI_PSNDOC_PARTYLOG);
		result = getWsService().writeHi_psndoc_partylog(partylog_list.toArray(new Hi_psndoc_partylogVO[partylog_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "������ò��Ϣ", partylog_list.size());

		/************************************ 12.ѧ��ѧλ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾ѧ��ѧλ��Ϣ������......");
		List<Hi_psndoc_eduVO> edu_ist = (List<Hi_psndoc_eduVO>) map.get(Constants.MID_HI_PSNDOC_EDU);
		result = getWsService().writeHi_psndoc_edu(edu_ist.toArray(new Hi_psndoc_eduVO[edu_ist.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "ѧ��ѧλ��Ϣ", edu_ist.size());

		/************************************ 13.��ͥ��Ա���ⱳ����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾��ͥ��Ա���ⱳ����Ϣ������......");
		List<Hi_psndoc_grpdef14VO> grpdef14_list = (List<Hi_psndoc_grpdef14VO>) map.get(Constants.MID_HI_PSNDOC_GRPDEF14);
		result = getWsService().writeHi_psndoc_grpdef14(grpdef14_list.toArray(new Hi_psndoc_grpdef14VO[grpdef14_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "��ͥ��Ա���ⱳ����Ϣ", grpdef14_list.size());

		/************************************ 14.Ա������������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա������������Ϣ������......");
		List<Hi_psndoc_workVO> work_list = (List<Hi_psndoc_workVO>) map.get(Constants.MID_HI_PSNDOC_WORK);
		result = getWsService().writeHi_psndoc_work(work_list.toArray(new Hi_psndoc_workVO[work_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա������������Ϣ", work_list.size());

		/************************************ 15.Ա�����⾭����Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա�����⾭����Ϣ������......");
		List<Hi_psndoc_abroadVO> abroad_list = (List<Hi_psndoc_abroadVO>) map.get(Constants.MID_HI_PSNDOC_ABROAD);
		result = getWsService().writeHi_psndoc_abroad(abroad_list.toArray(new Hi_psndoc_abroadVO[abroad_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա�����⾭����Ϣ", abroad_list.size());

		/************************************ 16.Ա��������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա��������Ϣ������......");
		List<Hi_psndoc_encVO> enc_list = (List<Hi_psndoc_encVO>) map.get(Constants.MID_HI_PSNDOC_ENC);
		result = getWsService().writeHi_psndoc_enc(enc_list.toArray(new Hi_psndoc_encVO[enc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա��������Ϣ", enc_list.size());

		/************************************ 17.Ա���ʹ���Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա���ʹ���Ϣ������......");
		List<Hi_psndoc_punVO> pun_list = (List<Hi_psndoc_punVO>) map.get(Constants.MID_HI_PSNDOC_PUN);
		result = getWsService().writeHi_psndoc_pun(pun_list.toArray(new Hi_psndoc_punVO[pun_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա���ʹ���Ϣ", pun_list.size());

		/************************************ 18.Ա����ѵ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա����ѵ��Ϣ������......");
		List<Hi_psndoc_trainingVO> training_list = (List<Hi_psndoc_trainingVO>) map.get(Constants.MID_HI_PSNDOC_TRAINING);
		result = getWsService().writeHi_psndoc_training(training_list.toArray(new Hi_psndoc_trainingVO[training_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա����ѵ��Ϣ", training_list.size());

		/************************************ 19.רҵ����ְ�� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾רҵ����ְ������......");
		List<Hi_psndoc_spetechVO> spetech_list = (List<Hi_psndoc_spetechVO>) map.get(Constants.MID_HI_PSNDOC_SPETECH);
		result = getWsService().writeHi_psndoc_spetech(spetech_list.toArray(new Hi_psndoc_spetechVO[spetech_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "רҵ����ְ��", spetech_list.size());

		/************************************ 20.���˼����ȼ� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾���˼����ȼ�������......");
		List<Hi_psndoc_techrankVO> techrank_list = (List<Hi_psndoc_techrankVO>) map.get(Constants.MID_HI_PSNDOC_TECHRANK);
		result = getWsService().writeHi_psndoc_techrank(techrank_list.toArray(new Hi_psndoc_techrankVO[techrank_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "���˼����ȼ�", techrank_list.size());

		/************************************ 21.֪ʶ��Ȩ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾֪ʶ��Ȩ��Ϣ������......");
		List<Hi_psndoc_grpdef11VO> grpdef11_list = (List<Hi_psndoc_grpdef11VO>) map.get(Constants.MID_HI_PSNDOC_GRPDEF11);
		result = getWsService().writeHi_psndoc_grpdef11(grpdef11_list.toArray(new Hi_psndoc_grpdef11VO[grpdef11_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "֪ʶ��Ȩ��Ϣ", grpdef11_list.size());

		/************************************ 22.Ա����ְ��Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ա����ְ��Ϣ������......");
		List<Hi_psndoc_dimissionVO> dimission_list = (List<Hi_psndoc_dimissionVO>) map.get(Constants.MID_HI_PSNDOC_DIMISSION);
		result = getWsService().writeHi_psndoc_dimission(dimission_list.toArray(new Hi_psndoc_dimissionVO[dimission_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ա����ְ��Ϣ", dimission_list.size());

		/************************************ 23.�ɲ���Ϣ����-�ɲ�������Ϣ ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾�ɲ���Ϣ����-�ɲ�������Ϣ������......");
		List<Hrldm_ldpsn_infoVO> psndocinfo_list = (List<Hrldm_ldpsn_infoVO>) map.get(Constants.MID_HRLDM_LDPSN_INFO);
		result = getWsService().writeHrldm_ldpsn_info(psndocinfo_list.toArray(new Hrldm_ldpsn_infoVO[psndocinfo_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "�ɲ���Ϣ����-�ɲ�������Ϣ", psndocinfo_list.size());

		/************************************ 24.�쵼��Աְ����Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾�쵼��Աְ����Ϣ�Ӽ�������......");
		List<Hrldm_psndoc_dutyVO> psndocduty_list = (List<Hrldm_psndoc_dutyVO>) map.get(Constants.MID_HRLDM_PSNDOC_DUTY);
		result = getWsService().writeHrldm_psndoc_duty(psndocduty_list.toArray(new Hrldm_psndoc_dutyVO[psndocduty_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "�쵼��Աְ����Ϣ�Ӽ�", psndocduty_list.size());

		/************************************ 25.�󱸸ɲ���Ϣ�Ӽ� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾�󱸸ɲ���Ϣ�Ӽ�������......");
		List<Hrldm_train_planVO> trainplan_list = (List<Hrldm_train_planVO>) map.get(Constants.MID_HRLDM_TRAIN_PLAN);
		result = getWsService().writeHrldm_train_plan(trainplan_list.toArray(new Hrldm_train_planVO[trainplan_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "�󱸸ɲ���Ϣ�Ӽ�", trainplan_list.size());

		/************************************ 26.רҵ�˲Ź���-Ժʿר����Ϣά�� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾רҵ�˲Ź���-Ժʿר����Ϣά��������......");
		List<Hr_expertVO> expert_list = (List<Hr_expertVO>) map.get(Constants.MID_HR_EXPERT);
		result = getWsService().writeHr_expert(expert_list.toArray(new Hr_expertVO[expert_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "רҵ�˲Ź���-Ժʿר����Ϣά��", expert_list.size());

		/************************************ 27.Ժʿר���Ӽ���Ƹ�ڹ��� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾Ժʿר���Ӽ���Ƹ�ڹ�������......");
		List<Expert_termVO> term_list = (List<Expert_termVO>) map.get(Constants.MID_EXPERT_TERM);
		result = getWsService().writeExpert_term(term_list.toArray(new Expert_termVO[term_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "Ժʿר���Ӽ���Ƹ�ڹ���", term_list.size());

		/************************************ 28.н�����-�����ܶ� ************************************/
		ProcessLine.addDefaultProcess("���ڴ��䡾н�����-�����ܶ����......");
		List<Wa_dataVO> wa_list = (List<Wa_dataVO>) map.get(Constants.MID_WA_DATA);
		result = getWsService().writeWa_data(wa_list.toArray(new Wa_dataVO[wa_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "н�����-�����ܶ�", wa_list.size());

		return logvos.toArray(new FbsDataFileItemVO[logvos.size()]);
	}

	/**
	 * @Title: addLogs
	 * @Description: ������־�ӱ���Ŀ
	 * @Author: ����ǿ
	 * @Time: 2016��12��13�� ����1:43:14
	 * @param logvos
	 * @param tableName
	 * @param count
	 * @return
	 */
	private List<FbsDataFileItemVO> addLogs(List<FbsDataFileItemVO> logvos, String tableName, int count) {
		FbsDataFileItemVO itemVo = new FbsDataFileItemVO();
		itemVo.setData_size(count == 0 ? String.valueOf(0) : String.valueOf(count));
		itemVo.setTable_name(tableName);
		logvos.add(itemVo);
		return logvos;
	}

}

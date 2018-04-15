package nc.bs.mid.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.check.beanUtil.DataMap;
import nc.bs.check.dbo.CHeckBusinessDataUtil;
import nc.bs.check.impl.CheckDataImpl;
import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.RuntimeEnv;
import nc.itf.mid.IInsertMidData;
import nc.itf.spike.ISpike;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.pub.Constants;
import nc.util.ExtFilenameFilter;
import nc.util.FileNameComparator;
import nc.util.FileUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.spike.BasicVO;
import nc.vo.tasktime.Fbs_backtask_timeVO;

/**
 * @ClassName: InsertMidDataDao 
 * <b> ���ݷ����¼���λ�м�� </b>
 * <p> �ڴ˴���Ӵ����������Ϣ </p>
 * ��������:2016��7��27�� ����10:02:54
 * @Author ����ǿ
 * @Version
 */
public class InsertMidDataDao implements IInsertMidData {
	private String sysTime = null;

//	private ICheckData iCheckData = (ICheckData) NCLocator.getInstance().lookup(ICheckData.class.getName());

	private CheckDataImpl checkData;
	private CheckDataImpl getCheckData(){
		if(checkData == null){
			checkData = new CheckDataImpl();
		}
		return checkData;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see nc.itf.mid.IInsertMidData#insertMidData()
	 */
	public String insertMidData() throws BusinessException {
		CHeckBusinessDataUtil checkBusinessDataUtil = new CHeckBusinessDataUtil();
		String flag = "ok";
		int sum = 0;
		// �Ƚ��й�˾�Ƚϣ��ȽϹ�˾��������bd_corp �� mid_bd_corp����֤��ͨ�����ɽ�����һ��
		if (!checkBusinessDataUtil.checkCorp()) {
			flag = "sorry";
			return flag;
		}

		// ��ʼ��ϵͳʱ��
		sysTime = new UFDateTime().toString();
		// ���ݶ���map����
		List<DataMap> dataControlMap = getCheckData().getDatacontrol();
		// �Զ��嵵������
		List<DataMap> defdocMap = getCheckData().getDefdocList();

		//FIXME ǿ��ȫ���Ĵ���
		String lastTime = getlastTime();

		List<SuperVO> list = new ArrayList<SuperVO>();
		
		//��Ҫ�������ݵĹ�˾
		String[] corpArr = getExpCorpStr();
		Map<String, String> sqlMap = new HashMap<String, String>();
		int queryType = getQueryDataType();
		if(1 == queryType){//0:Ĭ�ϳ�ȡ   1:��ͼ��ȡ
			sqlMap = getAllSelectSqls(sqlMap);
			createView(lastTime);
		}
		
		/******************************************  ���ŵ�����Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_BD_DEPTDOC) != null){
			list = checkBusinessDataUtil.checkBd_deptdocAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkBd_deptdoc(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
		/****************************************** ��λ������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_OM_JOB) != null){
			list = checkBusinessDataUtil.checkOm_jobAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOm_job(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
			
		/****************************************** ְ�������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_OM_DUTY) != null){
			list = checkBusinessDataUtil.checkOmDutyAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOmDuty(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
			
		/****************************************** ��λ������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT) != null){
			list = checkBusinessDataUtil.checkOm_corp_workoutAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOm_corp_workout(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
	
		/****************************************** ��λ�����ӱ� ******************************************/
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B) != null){
			list = checkBusinessDataUtil.checkOm_corp_workout_bAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOm_corp_workout_b(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
	
		/****************************************** ���ű�����Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_OM_DEPT_WORKOUT) != null){
			list = checkBusinessDataUtil.checkOm_dept_workoutAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOm_dept_workout(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
	
		/****************************************** ��λ������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_OM_JOB_WORKOUT) != null){
			list = checkBusinessDataUtil.checkOm_job_workoutAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkOm_job_workout(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
	
		/****************************************** ��Ա������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_BD_PSNBASDOC) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkBd_psnbasdocEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkBd_psnbasdocAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
		
		/****************************************** Ա��������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_BD_PSNDOC) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkBd_psndocEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkBd_psndocAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
		
		/****************************************** Ա����ְ��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DEPTCHG) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_deptchgEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_deptchgAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
		/****************************************** ������ò��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PARTYLOG) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_partylogEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_partylogAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
			
		/****************************************** ѧ��ѧλ��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_EDU) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_eduEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_eduAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** ��ͥ��Ա���ⱳ����Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_grpdef14Edit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_grpdef14Add(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** Ա������������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_WORK) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_workEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_workAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
			
		/****************************************** Ա�����⾭����Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_abroadEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_abroadAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** Ա��������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ENC) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_encEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_encAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}

		/****************************************** Ա���ʹ���Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PUN) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_punEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_punAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** Ա����ѵ��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TRAINING) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_trainingEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_trainingAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** רҵ����ְ�� ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_SPETECH) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_spetechEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_spetechAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** ���˼����ȼ� ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TECHRANK) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_techrankEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_techrankAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** У��֪ʶ��Ȩ��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_grpdef11Edit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_grpdef11Add(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** Ա����ְ��Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkHi_psndoc_dimissionEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkHi_psndoc_dimissionAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
	
		/****************************************** �ɲ���Ϣ����-�ɲ�������Ϣ ******************************************/
		if(sqlMap.get(Constants.MID_HRLDM_LDPSN_INFO) != null){
			list = checkBusinessDataUtil.checkHrldm_ldpsn_infoAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkHrldm_ldpsn_info(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		/****************************************** �쵼��Աְ����Ϣ�Ӽ� ******************************************/
		if(sqlMap.get(Constants.MID_HRLDM_PSNDOC_DUTY) != null){
			list = checkBusinessDataUtil.checkHrldm_psndoc_dutyAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkHrldm_psndoc_duty(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
	
		/****************************************** �󱸸ɲ���Ϣ�Ӽ� ******************************************/
		if(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN) != null){
			list = checkBusinessDataUtil.checkHrldm_train_planAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkHrldm_train_plan(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
		/****************************************** רҵ�˲Ź���-Ժʿר����Ϣά�� ******************************************/
		if(sqlMap.get(Constants.MID_HR_EXPERT) != null){
			list = checkBusinessDataUtil.checkHr_expertAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkHr_expert(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
		/****************************************** Ժʿר���Ӽ���Ƹ�ڹ������� ******************************************/
		if(sqlMap.get(Constants.MID_EXPERT_TERM) != null){
			list = checkBusinessDataUtil.checkExpert_termAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}else{
			list = checkBusinessDataUtil.checkExpert_term(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
		}
		
		/****************************************** ��ȡн���������� ******************************************/
		if(sqlMap.get(Constants.MID_WA_DATA) == null){
			if(lastTime != null){
				while(true){
					list = checkBusinessDataUtil.checkWa_DataEdit(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
					sum += insertMidData(list);
					if(list==null || list.size() < ISpike.MAXROWS){
						break;
					}
				}
			}
		}
		while(true){
			list = checkBusinessDataUtil.checkWa_DataAdd(dataControlMap, defdocMap, lastTime, sysTime, corpArr, sqlMap);
			sum += insertMidData(list);
			if(list==null || list.size() < ISpike.MAXROWS){
				break;
			}
		}
			

		// �����޸�ɾ���������������м���״̬Ϊ'del'
		sum += updateSpikeDelData();

		String sql_errlog = "select count(1) from fbs_error_logs";
		// ������־����
		int errLogNum = Integer.parseInt(getDao().executeQuery(sql_errlog, new ColumnProcessor()).toString());
		if (errLogNum != 0) {
			flag = "sorry";
			return flag;
		}

		// ���汾������ִ��ʱ��,�����д������ݣ�û���������ݺ�ִ������ɹ���Ҫ��������ִ��ʱ��
		saveTaskTime(sysTime);

		if (errLogNum == 0 && sum == 0) {
			flag = "success";
			return flag;
		}

		return flag;
	}

	/**
	 * @Title: saveTaskTime
	 * @Description: �����̨����ִ��ʱ�䣬ֻ��û���������ݺ�ִ������ɹ�ʱ����
	 * @Author: ����ǿ
	 * @Time: 2016��11��3�� ����2:46:29
	 * @param time
	 * @throws BusinessException
	 */
	private void saveTaskTime(String time) throws BusinessException {
		Fbs_backtask_timeVO taskTImeVO = new Fbs_backtask_timeVO();
		taskTImeVO.setTime(time);
		getDao().insertVO(taskTImeVO);
	}

	/**
	 * @Title: insertMidData
	 * @Description: ���ݲ�ͬ���������д���м��
	 * @Author: ����ǿ
	 * @param list
	 * @throws BusinessException
	 */
	public int insertMidData(List<SuperVO> list) throws BusinessException {
		if (list == null || list.size() == 0) {
			return 0;
		}
		String sign = null;
		List<SuperVO> uplist = new ArrayList<SuperVO>();
		List<SuperVO> addlist = new ArrayList<SuperVO>();
		for (int i = 0; i < list.size(); i++) {
			sign = list.get(i).getAttributeValue(BasicVO.SPIKE_SIGN).toString();
			if (sign != null && BasicVO.SPIKE_ADD.equals(sign)) {
				addlist.add(list.get(i));
			}
			if (sign != null && BasicVO.SPIKE_EDIT.equals(sign)) {
				uplist.add(list.get(i));
			}
		}
		if (uplist.size() > 0) {
			getDao().updateVOList(uplist);
		}
		if (addlist.size() > 0) {
			getDao().insertVOArrayWithPK(addlist.toArray(new SuperVO[addlist.size()]));
		}

		return list.size();

	}

	/**
	 * @Title: updateMidDelData
	 * @Description: �޸�ɾ���������������м���״̬
	 * @Author: ����ǿ
	 * @Time: 2016��10��10�� ����2:19:17
	 * @return ���޸ļ�¼�ĸ���
	 * @throws BusinessException
	 */
	public int updateSpikeDelData() throws BusinessException {
		int count = 0;
		String sql = null;
		UFDateTime time = new UFDateTime();
		// ���ŵ���
		sql = "update mid_bd_deptdoc dept_m set dept_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select dept.pk_deptdoc from bd_deptdoc dept where dept_m.pk_deptdoc_old = dept.pk_deptdoc and dept_m.pk_deptdoc_old is not null) and dept_m.spike_sign != 'del' ";
		count += getDao().executeUpdate(sql);

		// Ա��������Ϣ
		sql = "update mid_bd_psndoc psn_m set psn_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select psn.pk_psndoc from bd_psndoc psn where psn.pk_psndoc = psn_m.pk_psndoc_old and psn_m.pk_psndoc is not null) and psn_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��Ա������Ϣ
		sql = "update mid_bd_psnbasdoc psn_m set psn_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select psn.pk_psnbasdoc from bd_psnbasdoc psn where psn.pk_psnbasdoc = psn_m.pk_psnbasdoc_old and psn_m.pk_psnbasdoc_old is not null) and psn_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��λ������Ϣ
		sql = "update mid_om_job job_m set job_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select job.pk_om_job from om_job job where job_m.pk_om_job_old = job.pk_om_job and job_m.pk_om_job_old is not null) and job_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��λ������Ϣ
		sql = "update mid_om_job_workout work_m set work_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select work.pk_om_job_workout from om_job_workout work where work_m.pk_om_job_workout_old = work.pk_om_job_workout and work_m.pk_om_job_workout_old is not null) and work_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ���ű�����Ϣ
		sql = "update mid_om_dept_workout dept_m set dept_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select dept.pk_om_dept_workout from om_dept_workout dept where dept_m.pk_om_dept_workout_old = dept.pk_om_dept_workout and dept_m.pk_om_dept_workout_old is not null) and dept_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��λ������Ϣ
		sql = "update mid_om_corp_workout corp_m set corp_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists ( select corp.pk_om_corp_workout from om_corp_workout corp where corp.pk_om_corp_workout = corp_m.pk_om_corp_workout_old and corp_m.pk_om_corp_workout_old is not null) and corp_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��λ�����ӱ�
		sql = "update mid_om_corp_workout_b corp_m set corp_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select corp.pk_om_corp_workout_b from om_corp_workout_b corp where corp_m.pk_om_corp_workout_b_old = corp.pk_om_corp_workout_b and corp_m.pk_om_corp_workout_b_old is not null) and corp_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ѧ��ѧλ��Ϣ
		sql = "update mid_hi_psndoc_edu edu_m set edu_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select edu.pk_psndoc_sub from hi_psndoc_edu edu where edu_m.pk_psndoc_sub_old = edu.pk_psndoc_sub and edu_m.pk_psndoc_sub_old is not null) and edu_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ְ�������Ϣ
		sql = "update mid_om_duty dutym set dutym.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select duty.pk_om_duty from om_duty duty  where  dutym.pk_om_duty_old = duty.pk_om_duty and dutym.pk_om_duty_old is not null) and dutym.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա������������Ϣ
		sql = "update mid_hi_psndoc_work work_m set work_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select work.pk_psndoc_sub from hi_psndoc_work work where work.pk_psndoc_sub = work_m.pk_psndoc_sub_old and work_m.pk_psndoc_sub_old is not null) and work_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա����ѵ��Ϣ
		sql = "update mid_hi_psndoc_training train_m set train_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select train.pk_psndoc_sub from hi_psndoc_training train where train.pk_psndoc_sub = train_m.pk_psndoc_sub_old and train_m.pk_psndoc_sub_old is not null) and train_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ���˼����ȼ�
		sql = "update mid_hi_psndoc_techrank rank_m set rank_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select rank.pk_psndoc_sub from hi_psndoc_techrank rank where rank.pk_psndoc_sub = rank_m.pk_psndoc_sub_old and rank_m.pk_psndoc_sub_old is not null) and rank_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// רҵ����ְ��
		sql = "update mid_hi_psndoc_spetech tech_m set tech_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select tech.pk_psndoc_sub from hi_psndoc_spetech tech where tech_m.pk_psndoc_sub_old = tech.pk_psndoc_sub and tech_m.pk_psndoc_sub_old is not null) and tech_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա���ʹ���Ϣ
		sql = "update mid_hi_psndoc_pun pun_m set pun_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select pun.pk_psndoc_sub from hi_psndoc_pun pun where pun.pk_psndoc_sub = pun_m.pk_psndoc_sub_old and pun.pk_psndoc_sub is not null) and pun_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ������ò��Ϣ
		sql = "update mid_hi_psndoc_partylog party_m set party_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select party.pk_psndoc_sub from hi_psndoc_partylog party where party.pk_psndoc_sub = party_m.pk_psndoc_sub_old and party_m.pk_psndoc_sub_old is not null) and party_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ��ͥ��Ա���ⱳ����Ϣ
		sql = "update mid_hi_psndoc_grpdef14 grp_m set grp_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select grp.pk_psndoc_sub from hi_psndoc_grpdef14 grp where grp.pk_psndoc_sub = grp_m.pk_psndoc_sub_old and grp_m.pk_psndoc_sub_old is not null) and grp_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// ֪ʶ��Ȩ��Ϣ
		sql = "update mid_hi_psndoc_grpdef11 grp_m set grp_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select grp.pk_psndoc_sub from hi_psndoc_grpdef11 grp where grp.pk_psndoc_sub = grp_m.pk_psndoc_sub_old and grp_m.pk_psndoc_sub_old is not null) and grp_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա��������Ϣ
		sql = "update mid_hi_psndoc_enc enc_m set enc_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select enc.pk_psndoc_sub from hi_psndoc_enc enc where enc.pk_psndoc_sub = enc_m.pk_psndoc_sub_old and enc_m.pk_psndoc_sub_old is not null) and enc_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա����ְ��Ϣ
		sql = "update mid_hi_psndoc_dimission model_m set model_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select model.pk_psndoc_sub from hi_psndoc_dimission model where model.pk_psndoc_sub = model_m.pk_psndoc_sub_old and model_m.pk_psndoc_sub_old is not null) and model_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա����ְ��Ϣ
		sql = "update mid_hi_psndoc_deptchg chg_m set chg_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select chg.pk_psndoc_sub from hi_psndoc_deptchg chg where chg_m.pk_psndoc_sub_old = chg.pk_psndoc_sub and chg_m.pk_psndoc_sub_old is not null) and chg_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ա�����⾭����Ϣ
		sql = "update mid_hi_psndoc_abroad abroad_m set abroad_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select abroad.pk_psndoc_sub from hi_psndoc_abroad abroad where abroad_m.pk_psndoc_sub_old = abroad.pk_psndoc_sub and abroad_m.pk_psndoc_sub_old is not null) and abroad_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// �ɲ���Ϣ����-�ɲ�������Ϣ
		sql = "update mid_hrldm_ldpsn_info info_m set info_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select info.pk_psndoc_sub from hrldm_ldpsn_info info where info.pk_psndoc_sub = info_m.pk_psndoc_sub_old and info_m.pk_psndoc_sub_old is not null) and info_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// �쵼��Աְ����Ϣ�Ӽ�
		sql = "update mid_hrldm_psndoc_duty psndoc_m set psndoc_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select psndoc.pk_psndoc_sub from hrldm_psndoc_duty psndoc where psndoc_m.pk_psndoc_sub_old = psndoc.pk_psndoc_sub and psndoc_m.pk_psndoc_sub_old is not null) and psndoc_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// �󱸸ɲ���Ϣ�Ӽ�
		sql = "update mid_hrldm_train_plan train_m set train_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select train.pk_psndoc_sub from hrldm_train_plan train where train.pk_psndoc_sub = train_m.pk_psndoc_sub_old and train_m.pk_psndoc_sub_old is not null) and train_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// רҵ�˲Ź���-Ժʿר����Ϣά��
		sql = "update mid_hr_expert expert_m set expert_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select expert.pk_hr_exper from hr_expert expert where expert_m.pk_hr_exper_old = expert.pk_hr_exper and expert_m.pk_hr_exper_old is not null) and expert_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// Ժʿר���Ӽ���Ƹ�ڹ���
		sql = "update mid_expert_term term_m set term_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists (select term.pk_expert_term from expert_term term where term_m.pk_expert_term_old = term.pk_expert_term and term_m.pk_expert_term_old is not null) and term_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);

		// н�����-�����ܶ�
		sql = "update mid_wa_data wa_m set wa_m.spike_sign = 'del',ts= '" + time + "',ts_m= '" + time + "' where not exists(select wa.pk_wa_data from wa_data wa inner join wa_waclass class on wa.classid=class.pk_wa_class inner join wa_periodstate state on class.pk_wa_class = state.classid and state.ipayoffflag = '1'  inner join wa_period period on state.pk_periodset = period.pk_wa_period  and wa.cyear = period.cyear and wa.cperiod = period.cperiod and period.cnestyear >='2016' where wa.pk_wa_data = wa_m.pk_wa_data_old and wa_m.pk_wa_data_old is not null) and wa_m.spike_sign != 'del'";
		count += getDao().executeUpdate(sql);
		return count;
	}

	/**
	 * @Title: getlastTime
	 * @Description: ��ȡ�ϴ�ִ�к�̨�����ʱ��
	 * @Author: ����ǿ
	 * @Time: 2016��11��2�� ����2:38:37
	 * @return
	 * @throws DAOException
	 */
	private String getlastTime() throws DAOException {
		String backtask = "select max(time) from fbs_backtask_time";
		return (String) getDao().executeQuery(backtask, new ColumnProcessor());
	}

	/**
	 * @Title: getExpCorpStr
	 * @Description: ��ȡҪ�����Ĺ�˾�ַ������Զ��ż��
	 * @Author: ����ǿ
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	private String[] getExpCorpStr() throws BusinessException{
		String sql_corp = "select exp_pk_corp from fbs_expcorp_conf conf inner join bd_corp corp on conf.exp_pk_corp = corp.pk_corp where nvl(conf.dr,0) = 0 group by conf.exp_pk_corp ";
		List<Object> list = (List<Object>) getDao().executeQuery(sql_corp, new ArrayListProcessor());
		return toStrArr(list);
	}
	
	/**
	 * @Title: toStrArr
	 * @Description: ת���ַ������͵�����
	 * @Author: ����ǿ
	 * @Time: 2016��11��15�� ����3:07:38
	 * @param list
	 * @return
	 */
	public String[] toStrArr(List<Object> list){
		if(list == null || list.size() == 0){
			return new String[]{};
		}
		String[] strArr = new String[list.size()+1];
		for(int i = 0; i < list.size(); i++){
			Object[] arr = (Object[]) list.get(i);
			strArr[i] = arr[0].toString().trim();
		}
		strArr[strArr.length-1] = "0001";
		return strArr;
	}
	
	/**
	 * @Title: getQueryDataType
	 * @Description: ��ȡ���ݳ�ȡ���� 0:Ĭ�ϳ�ȡ�� 1:��ͼ��ȡ
	 * �������ýڵ�λ��:��������Դ��-->����Ա��Ϣ����-->���������á�-->���������á�
	 * @Author: ����ǿ
	 * @Date: 2017��1��3��
	 * @return
	 * @throws BusinessException
	 *	Ĭ�ϳ�ȡ��ȥ����ͼ
	 */
	public int getQueryDataType() {
		return 0;
//		IHrPara itf = NCLocator.getInstance().lookup(IHrPara.class); 
//		Integer queryType = itf.getParaIntValue("0001", "HI_AVIC_FBS01", null, null); 
//		return queryType == null ? 0 : queryType;
	}
	
	public void createView(String lastTime) throws BusinessException{
		getViewSql(lastTime);
		for(String key : addViewMap.keySet()){
			String sql = "create or replace view v_"+ key.replaceFirst("mid_", "") +" as ( " + addViewMap.get(key) + "  union  " + editViewMap.get(key)+ " )";
			getDao().executeUpdate(sql);
		}
	}
	
	Map<String, String> addViewMap = new HashMap<String, String>();
	Map<String, String> editViewMap = new HashMap<String, String>();
	public void getViewSql(String lastTime) throws BusinessException{
		String path_sqls = RuntimeEnv.getInstance().getNCHome() 
				+ Constants.SEP + "modules" 
				+ Constants.SEP + "fbsxj" 
				+ Constants.SEP + "cfgs" 
				+ Constants.SEP + "sqls" 
				+ Constants.SEP + "ncehr" 
				+ Constants.SEP + "57" 
				+ Constants.SEP + "oracle" 
				+ Constants.SEP + "09view"+ Constants.SEP;
		File viewsFolder  = new File(path_sqls);
		if (viewsFolder.exists()) {
			File[] sqlFiles = viewsFolder.listFiles(new ExtFilenameFilter(".sql"));
			if (sqlFiles == null || sqlFiles.length == 0) {
				return ;
			}
			
			Arrays.sort(sqlFiles, new FileNameComparator());
			
			for (int i = 0; i<sqlFiles.length; i++) {
				String[] items = sqlFiles[i].getName().split("\\.");
				if("add".equals(items[1])){
					String addSql = FileUtil.readSqlFileContent(sqlFiles[i]);
					if (addSql != null && lastTime != null && !"".equals(lastTime)) {
						addSql += " and "+ items[2] +".ts > '" + lastTime + "'";
					}
					addViewMap.put(items[3], addSql);
				}else{
					String editSql = FileUtil.readSqlFileContent(sqlFiles[i]);
					if (editSql != null && lastTime != null && !"".equals(lastTime)) {
						editSql += " and "+ items[2] +".ts > '" + lastTime + "'";
					}
					editViewMap.put(items[3], editSql);
				}
				
			}
		} else {
			throw new BusinessException("��ͼĿ¼��" + viewsFolder.getAbsolutePath() + "�²�������ͼ�ļ�!");
		}
	}
	
	public Map<String, String> getAllSelectSqls(Map<String, String> sqlMap) throws BusinessException {
		String path_sqls = RuntimeEnv.getInstance().getNCHome() 
				+ Constants.SEP + "modules" 
				+ Constants.SEP + "fbsxj" 
				+ Constants.SEP + "cfgs" 
				+ Constants.SEP + "sqls" 
				+ Constants.SEP + "ncehr" 
				+ Constants.SEP + "57" 
				+ Constants.SEP + "oracle" 
				+ Constants.SEP + "08gain"+ Constants.SEP;
		File viewsFolder  = new File(path_sqls);
		if (viewsFolder.exists()) {
			File[] sqlFiles = viewsFolder.listFiles(new ExtFilenameFilter(".sql"));
			if (sqlFiles == null || sqlFiles.length == 0) {
				return sqlMap;
			}
			
			Arrays.sort(sqlFiles, new FileNameComparator());
			
			for (int i = 0; i<sqlFiles.length; i++) {
				String[] items = sqlFiles[i].getName().split("\\.");
				sqlMap.put(items[1], FileUtil.readSqlFileContent(sqlFiles[i]));
			}
		} else {
			throw new BusinessException("��ͼĿ¼��" + viewsFolder.getAbsolutePath() + "�²�������ͼ�ļ�!");
		}
		return sqlMap;
	}
	
	private BaseDAO dao = null;

	public BaseDAO getDao() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}
}

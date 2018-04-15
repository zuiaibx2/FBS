package nc.itf.spike;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import nc.vo.pub.BusinessException;
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
 * @ClassName: ISpike
 * <b> ��ȡ��������ҵ����ӿ� </b>
 * <p>
 *     ��������� 1���������ݻ�ȡ���� 2����ȡ��Ƭ����
 * </p>
 * ��������: 2016��7��27�� ����4:25:36
 * @Author ����ǿ
 * @Version 
 */
public interface ISpike {
	
	/**
	 * @Field: MAXROWS
	 * @Discription: ��ѯʱ������������Դ˷�ҳ
	 */
	public static int MAXROWS = 100000;
	
	/**
	 * @Title: getOm_corp_workoutSpikeData
	 * @Description: ��λ������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_corp_workoutVO> getOm_corp_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	/**
	 * @Title: getOm_corp_workout_bSpikeData
	 * @Description: ��λ�����ӱ���������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_corp_workout_bVO> getOm_corp_workout_bSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	/**
	 * @Title: getOm_dutySpikeData
	 * @Description: ְ�������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<OmDutyVo> getOm_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getOm_jobSpikeData
	 * @Description: ��λ������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_jobVO> getOm_jobSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getOm_dept_workoutSpikeData
	 * @Description: ���ű�����Ϣ��������
	 * @Auavic1014thor: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_dept_workoutVO> getOm_dept_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getOm_job_workoutSpikeData
	 * @Description: ��λ������Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_job_workoutVO> getOm_job_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getBd_psnbasdocSpikeData
	 * @Description: ��Ա������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<Bd_psnbasdocVO> getBd_psnbasdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getBd_psndocVOSpikeData
	 * @Description: Ա��������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_psndocVO> getBd_psndocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getBd_deptdocVOSpikeData
	 * @Description: ���ŵ�����������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_deptdocVO> getBd_deptdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_ldpsn_infoVOSpikeDel
	 * @Description: �ɲ���Ϣ����-�ɲ�������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planSpikeDel
	 * @Description: �쵼��Աְ����Ϣ�Ӽ���������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planSpikeDel
	 * @Description: �󱸸ɲ���Ϣ�Ӽ���������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_train_planVO> getHrldm_train_planSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getExpert_termSpikeDel
	 * @Description: רҵ�˲Ź���-Ժʿר����Ϣά����������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hr_expertVO> getHr_expertSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getExpert_termSpikeDel
	 * @Description: Ժʿר���Ӽ���Ƹ�ڹ�����������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<Expert_termVO> getExpert_termSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getWa_dataSpikeDel
	 * @Description: н�����-�����ܶ���������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<Wa_dataVO> getWa_dataSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_abroadSpikeDel
	 * @Description: Ա�����⾭����Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_deptchgSpikeDel
	 * @Description: Ա����ְ��Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_dimissionSpikeData
	 * @Description: Ա����ְ��Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_eduSpikeData
	 * @Description: ѧ��ѧλ��Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_encSpikeData
	 * @Description: Ա��������Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_encVO> getHi_psndoc_encSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef11SpikeData
	 * @Description: ֪ʶ��Ȩ��Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef14SpikeData
	 * @Description: ��ͥ��Ա���ⱳ����Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_partylogSpikeData
	 * @Description: ������ò��Ϣ��������
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_punSpikeData
	 * @Description: Ա���ʹ���Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_punVO> getHi_psndoc_punSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_techrankSpikeData
	 * @Description: ���˼����ȼ�
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_spetechSpikeData
	 * @Description: רҵ����ְ��
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_trainingSpikeData
	 * @Description: Ա����ѵ��Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_workSpikeData
	 * @Description: Ա������������Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_workVO> getHi_psndoc_workSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getSpikePhotoData
	 * @Description: ������ȡ��Ƭ
	 * @Time: 2016��10��26�� ����11:05:52
	 * @param lastTime
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_psnbasdocVO> getPhotoSpikeData(String lastTime) throws BusinessException;
	
	/**
	 * @Title: getMaxTime
	 * @Description: �ϴγ�ȡʱ��
	 * @Time: 2016��10��26�� ����2:59:20
	 * @param sql
	 * @return
	 * @throws BusinessException
	 */
	public String getMaxTime(String sql) throws BusinessException;

}

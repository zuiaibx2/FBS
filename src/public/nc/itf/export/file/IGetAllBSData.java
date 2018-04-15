package nc.itf.export.file;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @ClassName: I
 * <b> ��ȡ����ҵ����ӿ� </b>
 * <p>
 *     ������������ݹ�˾��ȡҵ����ƾ�
 * </p>
 * ��������: 2016��7��27�� ����4:25:36
 * @Author ����ǿ
 * @Version 
 */
public interface IGetAllBSData {
	
	/**
	 * @Field: MAXROWS
	 * @Discription: ��ѯʱ������������Դ˷�ҳ
	 */
	public static int MAXROWS = 100000;
	
	/**
	 * @Title: getOm_corp_workoutData
	 * @Description: ��λ������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_corp_workoutData(String[] corpArr) throws BusinessException;
	/**
	 * @Title: getOm_corp_workout_bData
	 * @Description: ��λ�����ӱ�����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_corp_workout_bData(String[] corpArr) throws BusinessException;
	/**
	 * @Title: getOm_dutyData
	 * @Description: ְ�������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_dutyData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getOm_jobData
	 * @Description: ��λ������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_jobData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getOm_dept_workoutData
	 * @Description: ���ű�����Ϣ����
	 * @Auavic1014thor: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_dept_workoutData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getOm_job_workoutData
	 * @Description: ��λ������Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_job_workoutData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getBd_psnbasdocData
	 * @Description: ��Ա������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_psnbasdocData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getBd_psndocVOData
	 * @Description: Ա��������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_psndocData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getBd_deptdocVOData
	 * @Description: ���ŵ�������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_deptdocData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_ldpsn_infoVODel
	 * @Description: �ɲ���Ϣ����-�ɲ�������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_ldpsn_infoData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planDel
	 * @Description: �쵼��Աְ����Ϣ�Ӽ�����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_psndoc_dutyData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planDel
	 * @Description: �󱸸ɲ���Ϣ�Ӽ�����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_train_planData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getExpert_termDel
	 * @Description: רҵ�˲Ź���-Ժʿר����Ϣά������
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHr_expertData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getExpert_termDel
	 * @Description: Ժʿר���Ӽ���Ƹ�ڹ�������
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getExpert_termData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getWa_dataDel
	 * @Description: н�����-�����ܶ�����
	 * @Author: ����ǿ
	 * @Date: 2016��7��29��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getWa_dataData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_abroadDel
	 * @Description: Ա�����⾭����Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_abroadData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_deptchgDel
	 * @Description: Ա����ְ��Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_deptchgData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_dimissionData
	 * @Description: Ա����ְ��Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��30��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_dimissionData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_eduData
	 * @Description: ѧ��ѧλ��Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_eduData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_encData
	 * @Description: Ա��������Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_encData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef11Data
	 * @Description: ֪ʶ��Ȩ��Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_grpdef11Data(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef14Data
	 * @Description: ��ͥ��Ա���ⱳ����Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_grpdef14Data(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_partylogData
	 * @Description: ������ò��Ϣ����
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_partylogData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_punData
	 * @Description: Ա���ʹ���Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_punData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_techrankData
	 * @Description: ���˼����ȼ�
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_techrankData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_spetechData
	 * @Description: רҵ����ְ��
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_spetechData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_trainingData
	 * @Description: Ա����ѵ��Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_trainingData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_workData
	 * @Description: Ա������������Ϣ
	 * @Author: ����ǿ
	 * @Date: 2016��7��31��
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_workData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getAllCreateSqls
	 * @Description: ��ȡ��ͼ�ļ�
	 * @Author: ����ǿ
	 * @Time: 2016��10��14�� ����1:25:57
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllCreateBSSqls() throws BusinessException;

}

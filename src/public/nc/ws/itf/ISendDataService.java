package nc.ws.itf; 

import java.util.List;

import nc.vo.pub.BusinessException;
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
import nc.ws.vo.wa.Wa_dataVO;


/**
 * @ClassName: ISendDataService
 * <b>  </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年11月7日 下午4:04:33
 * @Author 王凯强
 * @Version 
 */
public interface ISendDataService {
	public List<Bd_deptdocVO> getBd_deptdocData(String whereStr) throws BusinessException;
	public List<Bd_psnbasdocVO> getBd_psnbasdocData(String whereStr) throws BusinessException;
	public List<Bd_psndocVO> getBd_psndocData(String whereStr) throws BusinessException;
	public List<Expert_termVO> getExpert_termData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_encVO> getHi_psndoc_encData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11Data(String whereStr) throws BusinessException;
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14Data(String whereStr) throws BusinessException;
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_punVO> getHi_psndoc_punData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankData(String whereStr) throws BusinessException;
	
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingData(String whereStr) throws BusinessException;
	public List<Hi_psndoc_workVO> getHi_psndoc_workData(String whereStr) throws BusinessException;
	
	public List<Hr_expertVO> getHr_expertData(String whereStr) throws BusinessException;
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoData(String whereStr) throws BusinessException;
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutyData(String whereStr) throws BusinessException;
	public List<Hrldm_train_planVO> getHrldm_train_planData(String whereStr) throws BusinessException;
	public List<Om_corp_workout_bVO> getOm_corp_workout_bData(String whereStr) throws BusinessException;
	public List<Om_corp_workoutVO> getOm_corp_workoutData(String whereStr) throws BusinessException;
	public List<Om_dept_workoutVO> getOm_dept_workoutData(String whereStr) throws BusinessException;
	public List<Om_dutyVO> getOm_dutyData(String whereStr) throws BusinessException;
	public List<Om_job_workoutVO> getOm_job_workoutData(String whereStr) throws BusinessException;
	public List<Om_jobVO> getOm_jobData(String whereStr) throws BusinessException;
	public List<Wa_dataVO> getWa_dataData(String whereStr) throws BusinessException;
	public String getWebServicePort();

}

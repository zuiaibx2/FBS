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
 * <b> 获取增量数据业务处理接口 </b>
 * <p>
 *     此类包含： 1、增量数据获取方法 2、抽取照片方法
 * </p>
 * 创建日期: 2016年7月27日 下午4:25:36
 * @Author 王凯强
 * @Version 
 */
public interface ISpike {
	
	/**
	 * @Field: MAXROWS
	 * @Discription: 查询时的最大条数，以此分页
	 */
	public static int MAXROWS = 100000;
	
	/**
	 * @Title: getOm_corp_workoutSpikeData
	 * @Description: 单位编制信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_corp_workoutVO> getOm_corp_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	/**
	 * @Title: getOm_corp_workout_bSpikeData
	 * @Description: 单位编制子表增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_corp_workout_bVO> getOm_corp_workout_bSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	/**
	 * @Title: getOm_dutySpikeData
	 * @Description: 职务基本信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<OmDutyVo> getOm_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getOm_jobSpikeData
	 * @Description: 岗位基本信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_jobVO> getOm_jobSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getOm_dept_workoutSpikeData
	 * @Description: 部门编制信息增量数据
	 * @Auavic1014thor: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_dept_workoutVO> getOm_dept_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getOm_job_workoutSpikeData
	 * @Description: 岗位编制信息
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Om_job_workoutVO> getOm_job_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getBd_psnbasdocSpikeData
	 * @Description: 人员基本信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<Bd_psnbasdocVO> getBd_psnbasdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getBd_psndocVOSpikeData
	 * @Description: 员工工作信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_psndocVO> getBd_psndocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getBd_deptdocVOSpikeData
	 * @Description: 部门档案增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_deptdocVO> getBd_deptdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_ldpsn_infoVOSpikeDel
	 * @Description: 干部信息主集-干部分类信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planSpikeDel
	 * @Description: 领导人员职务信息子集增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planSpikeDel
	 * @Description: 后备干部信息子集增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hrldm_train_planVO> getHrldm_train_planSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getExpert_termSpikeDel
	 * @Description: 专业人才管理-院士专家信息维护增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hr_expertVO> getHr_expertSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getExpert_termSpikeDel
	 * @Description: 院士专家子集－聘期管理增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<Expert_termVO> getExpert_termSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getWa_dataSpikeDel
	 * @Description: 薪酬管理-发放总额增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<Wa_dataVO> getWa_dataSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_abroadSpikeDel
	 * @Description: 员工涉外经历信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_deptchgSpikeDel
	 * @Description: 员工任职信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_dimissionSpikeData
	 * @Description: 员工离职信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_eduSpikeData
	 * @Description: 学历学位信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_encSpikeData
	 * @Description: 员工奖励信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_encVO> getHi_psndoc_encSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef11SpikeData
	 * @Description: 知识产权信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef14SpikeData
	 * @Description: 家庭成员海外背景信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_partylogSpikeData
	 * @Description: 政治面貌信息增量数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_punSpikeData
	 * @Description: 员工惩处信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_punVO> getHi_psndoc_punSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_techrankSpikeData
	 * @Description: 工人技术等级
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_spetechSpikeData
	 * @Description: 专业技术职务
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_trainingSpikeData
	 * @Description: 员工培训信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_workSpikeData
	 * @Description: 员工工作履历信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<Hi_psndoc_workVO> getHi_psndoc_workSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> SqlMap) throws BusinessException;
	
	/**
	 * @Title: getSpikePhotoData
	 * @Description: 增量抽取照片
	 * @Time: 2016年10月26日 上午11:05:52
	 * @param lastTime
	 * @return
	 * @throws BusinessException
	 */
	public List<Bd_psnbasdocVO> getPhotoSpikeData(String lastTime) throws BusinessException;
	
	/**
	 * @Title: getMaxTime
	 * @Description: 上次抽取时间
	 * @Time: 2016年10月26日 下午2:59:20
	 * @param sql
	 * @return
	 * @throws BusinessException
	 */
	public String getMaxTime(String sql) throws BusinessException;

}

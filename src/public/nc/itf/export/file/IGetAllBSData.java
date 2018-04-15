package nc.itf.export.file;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @ClassName: I
 * <b> 获取数据业务处理接口 </b>
 * <p>
 *     此类包含：根据公司获取业务审计局
 * </p>
 * 创建日期: 2016年7月27日 下午4:25:36
 * @Author 王凯强
 * @Version 
 */
public interface IGetAllBSData {
	
	/**
	 * @Field: MAXROWS
	 * @Discription: 查询时的最大条数，以此分页
	 */
	public static int MAXROWS = 100000;
	
	/**
	 * @Title: getOm_corp_workoutData
	 * @Description: 单位编制信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_corp_workoutData(String[] corpArr) throws BusinessException;
	/**
	 * @Title: getOm_corp_workout_bData
	 * @Description: 单位编制子表数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_corp_workout_bData(String[] corpArr) throws BusinessException;
	/**
	 * @Title: getOm_dutyData
	 * @Description: 职务基本信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_dutyData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getOm_jobData
	 * @Description: 岗位基本信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_jobData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getOm_dept_workoutData
	 * @Description: 部门编制信息数据
	 * @Auavic1014thor: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_dept_workoutData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getOm_job_workoutData
	 * @Description: 岗位编制信息
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getOm_job_workoutData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getBd_psnbasdocData
	 * @Description: 人员基本信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_psnbasdocData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getBd_psndocVOData
	 * @Description: 员工工作信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_psndocData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getBd_deptdocVOData
	 * @Description: 部门档案数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getBd_deptdocData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_ldpsn_infoVODel
	 * @Description: 干部信息主集-干部分类信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_ldpsn_infoData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planDel
	 * @Description: 领导人员职务信息子集数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_psndoc_dutyData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHrldm_train_planDel
	 * @Description: 后备干部信息子集数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHrldm_train_planData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getExpert_termDel
	 * @Description: 专业人才管理-院士专家信息维护数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHr_expertData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getExpert_termDel
	 * @Description: 院士专家子集－聘期管理数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getExpert_termData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getWa_dataDel
	 * @Description: 薪酬管理-发放总额数据
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getWa_dataData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_abroadDel
	 * @Description: 员工涉外经历信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_abroadData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_deptchgDel
	 * @Description: 员工任职信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_deptchgData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_dimissionData
	 * @Description: 员工离职信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月30日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_dimissionData(String[] corpArr) throws BusinessException;

	/**
	 * @Title: getHi_psndoc_eduData
	 * @Description: 学历学位信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_eduData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_encData
	 * @Description: 员工奖励信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_encData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef11Data
	 * @Description: 知识产权信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_grpdef11Data(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_grpdef14Data
	 * @Description: 家庭成员海外背景信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_grpdef14Data(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_partylogData
	 * @Description: 政治面貌信息数据
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_partylogData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_punData
	 * @Description: 员工惩处信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_punData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_techrankData
	 * @Description: 工人技术等级
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_techrankData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_spetechData
	 * @Description: 专业技术职务
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_spetechData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_trainingData
	 * @Description: 员工培训信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_trainingData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getHi_psndoc_workData
	 * @Description: 员工工作履历信息
	 * @Author: 王凯强
	 * @Date: 2016年7月31日
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> getHi_psndoc_workData(String[] corpArr) throws BusinessException;
	
	/**
	 * @Title: getAllCreateSqls
	 * @Description: 获取视图文件
	 * @Author: 王凯强
	 * @Time: 2016年10月14日 下午1:25:57
	 * @return
	 * @throws Exception
	 */
	public List<String> getAllCreateBSSqls() throws BusinessException;

}

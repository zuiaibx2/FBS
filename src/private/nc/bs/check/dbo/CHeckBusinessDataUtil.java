package nc.bs.check.dbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nc.bs.check.beanUtil.DataMap;
import nc.bs.check.dbo.util.CheckDataUtil;
import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.framework.common.NCLocator;
import nc.bs.spike.impl.SpikeImpl;
import nc.itf.check.ICheckData;
import nc.itf.fbs.pub.CheckField;
import nc.vo.hr.iufo.func.Global;
import nc.vo.log.error.Fbs_logVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDate;
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
 * @author changrh 2016-7-27
 * 
 */
/**
 * @ClassName: CHeckBusinessDataUtil
 * <b> 数据非空验证 </b>
 * <p>
 *     notnull_ 开头数据为非空校验数组
 *     pk_ 开头数组为主键转换数组
 *     def 开头数组是数据对照数组
 *     tip开头数组为提醒数组
 * </p>
 * 创建日期: 2016年9月18日 下午3:09:28
 * @Version 
 */
public class CHeckBusinessDataUtil implements CheckField{
	
//	private ISpike spike = (ISpike) NCLocator.getInstance().lookup(ISpike.class.getName());
	
	private SpikeImpl spike = new SpikeImpl(); 
	
	private List<SuperVO> list = null;
	
	private CheckDataUtil checkDataUtil = new CheckDataUtil();
	/**
	 * @Title: checkBd_deptdoc
	 * @Description: 校验部门档案
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_deptdoc(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		// 1.部门档案
		List<Bd_deptdocVO> bdDeptlist =spike.getBd_deptdocSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(bdDeptlist !=null && bdDeptlist.size()>0){
			list.addAll(bdDeptlist);
			flag = checkDataUtil.checkData(list,TABLENAME_DEPT,NOTNULL_DEPT,NOTNULL_NAME_DEPT,null,null,PK_DEPT,PK_NAME_DEPT,TIP_DEPT, TIP_NAME_DEPT,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkBd_deptdoc
	 * @Description: 校验部门档案增量数据
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_deptdocAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		// 1.部门档案
		List<Bd_deptdocVO> bdDeptlist =spike.getBd_deptdocSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(bdDeptlist !=null && bdDeptlist.size()>0){
			list.addAll(bdDeptlist);
			flag = checkDataUtil.checkData(list,TABLENAME_DEPT,NOTNULL_DEPT,NOTNULL_NAME_DEPT,null,null,PK_DEPT,PK_NAME_DEPT,TIP_DEPT, TIP_NAME_DEPT,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_job
	 * @Description: 校验岗位基本信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_job(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Om_jobVO> omJoblist =spike.getOm_jobSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(omJoblist !=null && omJoblist.size()>0){
			list.addAll(omJoblist);
			flag = checkDataUtil.checkData(list,TABLENAME_JOB,NOTNULL_JOB,NOTNULL_NAME_JOB,DEFDOC_JOB,DEFDOC_NAME_JOB,PK_JOB,PK_NAME_JOB,TIP_JOB, TIP_NAME_JOB,dataControlMap,defdocMap,NULLARR,NULLARR);
			
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_job
	 * @Description: 校验岗位基本信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_jobAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Om_jobVO> omJoblist =spike.getOm_jobSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(omJoblist !=null && omJoblist.size()>0){
			list.addAll(omJoblist);
			flag = checkDataUtil.checkData(list,TABLENAME_JOB,NOTNULL_JOB,NOTNULL_NAME_JOB,DEFDOC_JOB,DEFDOC_NAME_JOB,PK_JOB,PK_NAME_JOB,TIP_JOB, TIP_NAME_JOB,dataControlMap,defdocMap,NULLARR,NULLARR);
			
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkOmDuty
	 * @Description: 校验职务基本信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOmDuty(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		// 2.职务基本信息
		List<OmDutyVo> omDutylist = spike.getOm_dutySpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(omDutylist !=null && omDutylist.size()>0){
			list.addAll(omDutylist);
			flag =checkDataUtil.checkData(list,TABLENAME_DUTY,NOTNULL_DUTY,NOTNULL_NAME_DUTY,DEFDOC_DUTY,DEFDOC_NAME_DUTY,PK_DUTY,PK_NAME_DUTY,TIP_DUTY, TIP_NAME_DUTY,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOmDuty
	 * @Description: 校验职务基本信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOmDutyAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		// 2.职务基本信息
		List<OmDutyVo> omDutylist = spike.getOm_dutySpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(omDutylist !=null && omDutylist.size()>0){
			list.addAll(omDutylist);
			flag =checkDataUtil.checkData(list,TABLENAME_DUTY,NOTNULL_DUTY,NOTNULL_NAME_DUTY,DEFDOC_DUTY,DEFDOC_NAME_DUTY,PK_DUTY,PK_NAME_DUTY,TIP_DUTY, TIP_NAME_DUTY,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkOm_corp_workout
	 * @Description: 校验单位编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_corp_workout(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 4.单位编制信息
		List<Om_corp_workoutVO> corpWorkoutlist =spike.getOm_corp_workoutSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(corpWorkoutlist !=null && corpWorkoutlist.size()>0){
			list.addAll(corpWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_CORPLB,NOTNULL_CORPLB,NOTNULL_NAME_CORPLB,null,null,PK_CORPLB,PK_NAME_CORPLB,TIP_CORPLB, TIP_NAME_CORPLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_corp_workout
	 * @Description: 校验单位编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_corp_workoutAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 4.单位编制信息
		List<Om_corp_workoutVO> corpWorkoutlist =spike.getOm_corp_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(corpWorkoutlist !=null && corpWorkoutlist.size()>0){
			list.addAll(corpWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_CORPLB,NOTNULL_CORPLB,NOTNULL_NAME_CORPLB,null,null,PK_CORPLB,PK_NAME_CORPLB,TIP_CORPLB, TIP_NAME_CORPLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_corp_workout_b
	 * @Description: 校验单位编制子表
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_corp_workout_b(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 5.单位编制子表
		List<Om_corp_workout_bVO> corpWorkoutBlist =spike.getOm_corp_workout_bSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(corpWorkoutBlist !=null && corpWorkoutBlist.size()>0){
			list.addAll(corpWorkoutBlist);
			flag = checkDataUtil.checkData(list,TABLENAME_CORPLBB,NOTNULL_CORPLBB,NOTNULL_NAME_CORPLBB,null,null,PK_CORPLBB,PK_NAME_CORPLBB,TIP_CORPLBB, TIP_NAME_CORPLBB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_corp_workout_b
	 * @Description: 校验单位编制子表
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_corp_workout_bAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 5.单位编制子表
		List<Om_corp_workout_bVO> corpWorkoutBlist =spike.getOm_corp_workout_bSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(corpWorkoutBlist !=null && corpWorkoutBlist.size()>0){
			list.addAll(corpWorkoutBlist);
			flag = checkDataUtil.checkData(list,TABLENAME_CORPLBB,NOTNULL_CORPLBB,NOTNULL_NAME_CORPLBB,null,null,PK_CORPLBB,PK_NAME_CORPLBB,TIP_CORPLBB, TIP_NAME_CORPLBB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_dept_workout
	 * @Description: 校验部门编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_dept_workout(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 6.部门编制信息
		List<Om_dept_workoutVO> deptWorkoutlist =spike.getOm_dept_workoutSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(deptWorkoutlist !=null && deptWorkoutlist.size()>0){
			list.addAll(deptWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_DEPTLB,NOTNULL_DEPTLB,NOTNULL_NAME_DEPTLB,null,null,PK_DEPTLB,PK_NAME_DEPTLB,TIP_DEPTLB, TIP_NAME_DEPTLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_dept_workout
	 * @Description: 校验部门编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_dept_workoutAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 6.部门编制信息
		List<Om_dept_workoutVO> deptWorkoutlist =spike.getOm_dept_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(deptWorkoutlist !=null && deptWorkoutlist.size()>0){
			list.addAll(deptWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_DEPTLB,NOTNULL_DEPTLB,NOTNULL_NAME_DEPTLB,null,null,PK_DEPTLB,PK_NAME_DEPTLB,TIP_DEPTLB, TIP_NAME_DEPTLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_job_workout
	 * @Description: 校验岗位编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_job_workout(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 7.岗位编制信息
		List<Om_job_workoutVO> jobWorkoutlist =spike.getOm_job_workoutSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(jobWorkoutlist !=null && jobWorkoutlist.size()>0){
			list.addAll(jobWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_JOBLB,NOTNULL_JOBLB,NOTNULL_NAME_JOBLB,null,null,PK_JOBLB,PK_NAME_JOBLB,TIP_JOBLB, TIP_NAME_JOBLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkOm_job_workout
	 * @Description: 校验岗位编制信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkOm_job_workoutAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 7.岗位编制信息
		List<Om_job_workoutVO> jobWorkoutlist =spike.getOm_job_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(jobWorkoutlist !=null && jobWorkoutlist.size()>0){
			list.addAll(jobWorkoutlist);
			flag = checkDataUtil.checkData(list,TABLENAME_JOBLB,NOTNULL_JOBLB,NOTNULL_NAME_JOBLB,null,null,PK_JOBLB,PK_NAME_JOBLB,TIP_JOBLB, TIP_NAME_JOBLB,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkBd_psnbasdocAdd
	 * @Description: 校验人员基本信息新增数据,分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_psnbasdocAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 人员基本信息
		List<Bd_psnbasdocVO> psnbaslist =spike.getBd_psnbasdocSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(psnbaslist !=null && psnbaslist.size()>0){
			list.addAll(psnbaslist);
			flag = checkDataUtil.checkData(list,TABLENAME_PSNBAS,NOTNULL_PSNBAS,NOTNULL_NAME_PSNBAS,DEFDOC_PSNBAS,DEFDOC_NAME_PSNBAS,PK_PSNBAS,PK_NAME_PSNBAS,TIP_PSNBAS, TIP_NAME_PSNBAS,dataControlMap,defdocMap,NOTNULL_OTHER_PSNBAS,NOTNULL_OTHER_NAME_PSNBAS);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkBd_psnbasdocEdit
	 * @Description: 校验人员基本信息修改数据,分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_psnbasdocEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 人员基本信息
		List<Bd_psnbasdocVO> psnbaslist =spike.getBd_psnbasdocSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(psnbaslist !=null && psnbaslist.size()>0){
			list.addAll(psnbaslist);
			flag = checkDataUtil.checkData(list,TABLENAME_PSNBAS,NOTNULL_PSNBAS,NOTNULL_NAME_PSNBAS,DEFDOC_PSNBAS,DEFDOC_NAME_PSNBAS,PK_PSNBAS,PK_NAME_PSNBAS,TIP_PSNBAS, TIP_NAME_PSNBAS,dataControlMap,defdocMap,NOTNULL_OTHER_PSNBAS,NOTNULL_OTHER_NAME_PSNBAS);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkBd_psndocAdd
	 * @Description: 校验员工工作信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_psndocAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		// 员工工作信息
		List<Bd_psndocVO> psnlist =spike.getBd_psndocSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(psnlist !=null && psnlist.size()>0){
			list.addAll(psnlist);
			flag = checkDataUtil.checkData(list,TABLENAME_PSN,NOTNULL_PSN,NOTNULL_NAME_PSN,DEFDOC_PSN,DEFDOC_NAME_PSN,PK_PSN,PK_NAME_PSN,TIP_PSN, TIP_NAME_PSN,dataControlMap,defdocMap,NOTNULL_OTHER_PSN,NOTNULL_OTHER_NAME_PSN);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkBd_psndocAdd
	 * @Description: 校验员工工作信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkBd_psndocEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工工作信息
		List<Bd_psndocVO> psnlist =spike.getBd_psndocSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(psnlist !=null && psnlist.size()>0){
			list.addAll(psnlist);
			flag = checkDataUtil.checkData(list,TABLENAME_PSN,NOTNULL_PSN,NOTNULL_NAME_PSN,DEFDOC_PSN,DEFDOC_NAME_PSN,PK_PSN,PK_NAME_PSN,TIP_PSN, TIP_NAME_PSN,dataControlMap,defdocMap,NOTNULL_OTHER_PSN,NOTNULL_OTHER_NAME_PSN);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_deptchgAdd
	 * @Description: 校验员工任职信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_deptchgAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工任职信息
		List<Hi_psndoc_deptchgVO> deptchList =spike.getHi_psndoc_deptchgSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(deptchList !=null && deptchList.size()>0){
			list.addAll(deptchList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIDEPTCHG,NOTNULL_HIDEPTCHG,NOTNULL_NAME_HIDEPTCHG,DEFDOC_HIDEPTCHG,DEFDOC_NAME_HIDEPTCHG,PK_HIDEPTCHG,PK_NAME_HIDEPTCHG,TIP_HIDEPTCHG, TIP_NAME_HIDEPTCHG,dataControlMap,defdocMap,NOTNULL_OTHER_HIDEPTCHG,NOTNULL_OTHER_NAME_HIDEPTCHG);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_deptchgEdit
	 * @Description: 校验员工任职信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_deptchgEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工任职信息
		List<Hi_psndoc_deptchgVO> deptchList =spike.getHi_psndoc_deptchgSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(deptchList !=null && deptchList.size()>0){
			list.addAll(deptchList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIDEPTCHG,NOTNULL_HIDEPTCHG,NOTNULL_NAME_HIDEPTCHG,DEFDOC_HIDEPTCHG,DEFDOC_NAME_HIDEPTCHG,PK_HIDEPTCHG,PK_NAME_HIDEPTCHG,TIP_HIDEPTCHG, TIP_NAME_HIDEPTCHG,dataControlMap,defdocMap,NOTNULL_OTHER_HIDEPTCHG,NOTNULL_OTHER_NAME_HIDEPTCHG);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_partylogAdd
	 * @Description: 校验政治面貌信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_partylogAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 政治面貌信息
		List<Hi_psndoc_partylogVO> partylogList =spike.getHi_psndoc_partylogSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(partylogList !=null && partylogList.size()>0){
			list.addAll(partylogList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIPARTYLOG,NOTNULL_HIPARTYLOG,NOTNULL_NAME_HIPARTYLOG,DEFDOC_HIPARTYLOG,DEFDOC_NAME_HIPARTYLOG,PK_HIPARTYLOG,PK_NAME_HIPARTYLOG,TIP_HIPARTYLOG, TIP_NAME_HIPARTYLOG,dataControlMap,defdocMap,NOTNULL_OTHER_HIPARTYLOG,NOTNULL_OTHER_NAME_HIPARTYLOG);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkHi_psndoc_partylogEdit
	 * @Description: 校验政治面貌信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_partylogEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 政治面貌信息
		List<Hi_psndoc_partylogVO> partylogList =spike.getHi_psndoc_partylogSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(partylogList !=null && partylogList.size()>0){
			list.addAll(partylogList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIPARTYLOG,NOTNULL_HIPARTYLOG,NOTNULL_NAME_HIPARTYLOG,DEFDOC_HIPARTYLOG,DEFDOC_NAME_HIPARTYLOG,PK_HIPARTYLOG,PK_NAME_HIPARTYLOG,TIP_HIPARTYLOG, TIP_NAME_HIPARTYLOG,dataControlMap,defdocMap,NOTNULL_OTHER_HIPARTYLOG,NOTNULL_OTHER_NAME_HIPARTYLOG);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_eduAdd
	 * @Description: 校验学历学位信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_eduAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 学历学位信息
		List<Hi_psndoc_eduVO> eduList =spike.getHi_psndoc_eduSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(eduList !=null && eduList.size()>0){
			list.addAll(eduList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIEDU,NOTNULL_HIEDU,NOTNULL_NAME_HIEDU,DEFDOC_HIEDU,DEFDOC_NAME_HIEDU,PK_HIEDU,PK_NAME_HIEDU,TIP_HIEDU, TIP_NAME_HIEDU,dataControlMap,defdocMap,NOTNULL_OTHER_HIEDU,NOTNULL_OTHER_NAME_HIEDU);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkHi_psndoc_eduEdit
	 * @Description: 校验学历学位信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_eduEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 学历学位信息
		List<Hi_psndoc_eduVO> eduList =spike.getHi_psndoc_eduSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(eduList !=null && eduList.size()>0){
			list.addAll(eduList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIEDU,NOTNULL_HIEDU,NOTNULL_NAME_HIEDU,DEFDOC_HIEDU,DEFDOC_NAME_HIEDU,PK_HIEDU,PK_NAME_HIEDU,TIP_HIEDU, TIP_NAME_HIEDU,dataControlMap,defdocMap,NOTNULL_OTHER_HIEDU,NOTNULL_OTHER_NAME_HIEDU);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_grpdef14Add
	 * @Description: 校验家庭成员海外背景信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_grpdef14Add(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 家庭成员海外背景信息
		List<Hi_psndoc_grpdef14VO> grpdef14List =spike.getHi_psndoc_grpdef14SpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(grpdef14List !=null && grpdef14List.size()>0){
			list.addAll(grpdef14List);
			flag = checkDataUtil.checkData(list,TABLENAME_HIGRPDEF14,NOTNULL_HIGRPDEF14,NOTNULL_NAME_HIGRPDEF14,null,null,PK_HIGRPDEF14,PK_NAME_HIGRPDEF14,TIP_HIGRPDEF14, TIP_NAME_HIGRPDEF14,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_grpdef14Edit
	 * @Description: 校验家庭成员海外背景信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_grpdef14Edit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 家庭成员海外背景信息
		List<Hi_psndoc_grpdef14VO> grpdef14List =spike.getHi_psndoc_grpdef14SpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(grpdef14List !=null && grpdef14List.size()>0){
			list.addAll(grpdef14List);
			flag = checkDataUtil.checkData(list,TABLENAME_HIGRPDEF14,NOTNULL_HIGRPDEF14,NOTNULL_NAME_HIGRPDEF14,null,null,PK_HIGRPDEF14,PK_NAME_HIGRPDEF14,TIP_HIGRPDEF14, TIP_NAME_HIGRPDEF14,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_workAdd
	 * @Description: 校验员工工作履历信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_workAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 员工工作履历信息
		List<Hi_psndoc_workVO> workList =spike.getHi_psndoc_workSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(workList !=null && workList.size()>0){
			list.addAll(workList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIWORK,NOTNULL_HIWORK,NOTNULL_NAME_HIWORK,null,null,PK_HIWORK,PK_NAME_HIWORK,TIP_HIWORK, TIP_NAME_HIWORK,dataControlMap,defdocMap,NOTNULL_OTHER_HIWORK,NOTNULL_OTHER_NAME_HIWORK);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_workEdit
	 * @Description: 校验员工工作履历信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_workEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 员工工作履历信息
		List<Hi_psndoc_workVO> workList =spike.getHi_psndoc_workSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(workList !=null && workList.size()>0){
			list.addAll(workList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIWORK,NOTNULL_HIWORK,NOTNULL_NAME_HIWORK,null,null,PK_HIWORK,PK_NAME_HIWORK,TIP_HIWORK, TIP_NAME_HIWORK,dataControlMap,defdocMap,NOTNULL_OTHER_HIWORK,NOTNULL_OTHER_NAME_HIWORK);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_abroadAdd
	 * @Description: 校验员工涉外经历信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_abroadAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 员工涉外经历信息(即员工出国（境）信息)
		List<Hi_psndoc_abroadVO> abroadList =spike.getHi_psndoc_abroadSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(abroadList !=null && abroadList.size()>0){
			list.addAll(abroadList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIABROAD,NOTNULL_HIABROAD,NOTNULL_NAME_HIABROAD,null,null,PK_HIABROAD,PK_NAME_HIABROAD,TIP_HIABROAD, TIP_NAME_HIABROAD,dataControlMap,defdocMap,NOTNULL_OTHER_HIABROAD,NOTNULL_OTHER_NAME_HIABROAD);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_abroadEdit
	 * @Description: 校验员工涉外经历信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_abroadEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 员工涉外经历信息(即员工出国（境）信息)
		List<Hi_psndoc_abroadVO> abroadList =spike.getHi_psndoc_abroadSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(abroadList !=null && abroadList.size()>0){
			list.addAll(abroadList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIABROAD,NOTNULL_HIABROAD,NOTNULL_NAME_HIABROAD,null,null,PK_HIABROAD,PK_NAME_HIABROAD,TIP_HIABROAD, TIP_NAME_HIABROAD,dataControlMap,defdocMap,NOTNULL_OTHER_HIABROAD,NOTNULL_OTHER_NAME_HIABROAD);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_encAdd
	 * @Description: 校验员工奖励信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_encAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		// 员工奖励信息
		List<Hi_psndoc_encVO> encList =spike.getHi_psndoc_encSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(encList !=null && encList.size()>0){
			list.addAll(encList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIENC,NOTNULL_HIENC,NOTNULL_NAME_HIENC,null,null,PK_HIENC,PK_NAME_HIENC,TIP_HIENC, TIP_NAME_HIENC,dataControlMap,defdocMap,NOTNULL_OTHER_HIENC,NOTNULL_OTHER_NAME_HIENC);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_encEdit
	 * @Description: 校验员工奖励信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_encEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工奖励信息
		List<Hi_psndoc_encVO> encList =spike.getHi_psndoc_encSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(encList !=null && encList.size()>0){
			list.addAll(encList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIENC,NOTNULL_HIENC,NOTNULL_NAME_HIENC,null,null,PK_HIENC,PK_NAME_HIENC,TIP_HIENC, TIP_NAME_HIENC,dataControlMap,defdocMap,NOTNULL_OTHER_HIENC,NOTNULL_OTHER_NAME_HIENC);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_punAdd
	 * @Description: 校验员工惩处信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @Time: 2016年9月28日 下午9:39:18
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_punAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工惩处信息
		List<Hi_psndoc_punVO> punList =spike.getHi_psndoc_punSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(punList !=null && punList.size()>0){
			list.addAll(punList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIPUN,NOTNULL_HIPUN,NOTNULL_NAME_HIPUN,null,null,PK_HIPUN,PK_NAME_HIPUN,TIP_HIPUN, TIP_NAME_HIPUN,dataControlMap,defdocMap,NOTNULL_OTHER_HIPUN,NOTNULL_OTHER_NAME_HIPUN);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: getHi_psndoc_punSpikeEdit
	 * @Description: 校验员工惩处信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @Time: 2016年9月28日 下午9:39:18
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_punEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		// 员工惩处信息
		List<Hi_psndoc_punVO> punList =spike.getHi_psndoc_punSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(punList !=null && punList.size()>0){
			list.addAll(punList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIPUN,NOTNULL_HIPUN,NOTNULL_NAME_HIPUN,null,null,PK_HIPUN,PK_NAME_HIPUN,TIP_HIPUN, TIP_NAME_HIPUN,dataControlMap,defdocMap,NOTNULL_OTHER_HIPUN,NOTNULL_OTHER_NAME_HIPUN);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_trainingAdd
	 * @Description: 校验员工培训信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_trainingAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		//员工培训信息
		List<Hi_psndoc_trainingVO> trainingList =spike.getHi_psndoc_trainingSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(trainingList !=null && trainingList.size()>0){
			list.addAll(trainingList);
			flag = checkDataUtil.checkData(list,TABLENAME_HITRAINING,NOTNULL_HITRAINING,NOTNULL_NAME_HITRAINING,DEFDOC_HITRAINING,DEFDOC_NAME_HITRAINING,PK_HITRAINING,PK_NAME_HITRAINING,TIP_HITRAINING, TIP_NAME_HITRAINING,dataControlMap,defdocMap,NOTNULL_OTHER_HITRAINING,NOTNULL_OTHER_NAME_HITRAINING);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_trainingEdit
	 * @Description: 校验员工培训信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_trainingEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		//员工培训信息
		List<Hi_psndoc_trainingVO> trainingList =spike.getHi_psndoc_trainingSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(trainingList !=null && trainingList.size()>0){
			list.addAll(trainingList);
			flag = checkDataUtil.checkData(list,TABLENAME_HITRAINING,NOTNULL_HITRAINING,NOTNULL_NAME_HITRAINING,DEFDOC_HITRAINING,DEFDOC_NAME_HITRAINING,PK_HITRAINING,PK_NAME_HITRAINING,TIP_HITRAINING, TIP_NAME_HITRAINING,dataControlMap,defdocMap,NOTNULL_OTHER_HITRAINING,NOTNULL_OTHER_NAME_HITRAINING);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_spetechAdd
	 * @Description: 校验专业技术职务新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_spetechAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		List<Hi_psndoc_spetechVO> spetechList =spike.getHi_psndoc_spetechSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(spetechList !=null && spetechList.size()>0){
			list.addAll(spetechList);
			flag = checkDataUtil.checkData(list,TABLENAME_HISPETECH,NOTNULL_HISPETECH,NOTNULL_NAME_HISPETECH,DEFDOC_HISPETECH,DEFDOC_NAME_HISPETECH,PK_HISPETECH,PK_NAME_HISPETECH,TIP_HISPETECH, TIP_NAME_HISPETECH,dataControlMap,defdocMap,NOTNULL_OTHER_HISPETECH,NOTNULL_OTHER_NAME_HISPETECH);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_spetechEdit
	 * @Description: 校验专业技术职务修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_spetechEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();

		List<Hi_psndoc_spetechVO> spetechList =spike.getHi_psndoc_spetechSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(spetechList !=null && spetechList.size()>0){
			list.addAll(spetechList);
			flag = checkDataUtil.checkData(list,TABLENAME_HISPETECH,NOTNULL_HISPETECH,NOTNULL_NAME_HISPETECH,DEFDOC_HISPETECH,DEFDOC_NAME_HISPETECH,PK_HISPETECH,PK_NAME_HISPETECH,TIP_HISPETECH, TIP_NAME_HISPETECH,dataControlMap,defdocMap,NOTNULL_OTHER_HISPETECH,NOTNULL_OTHER_NAME_HISPETECH);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_techrankAdd
	 * @Description: 校验工人技术等级新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_techrankAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		List<Hi_psndoc_techrankVO> techrankList =spike.getHi_psndoc_techrankSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(techrankList !=null && techrankList.size()>0){
			list.addAll(techrankList);
			flag = checkDataUtil.checkData(list,TABLENAME_HITECHRANK,NOTNULL_HITECHRANK,NOTNULL_NAME_HITECHRANK,DEFDOC_HITECHRANK,DEFDOC_NAME_HITECHRANK,PK_HITECHRANK,PK_NAME_HITECHRANK,TIP_HITECHRANK, TIP_NAME_HITECHRANK,dataControlMap,defdocMap,NOTNULL_OTHER_HITECHRANK,NOTNULL_OTHER_NAME_HITECHRANK);
		}
		return flag ? list : null;
	}

	/**
	 * @Title: checkHi_psndoc_techrankEdit
	 * @Description: 校验工人技术等级修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_techrankEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		List<Hi_psndoc_techrankVO> techrankList =spike.getHi_psndoc_techrankSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(techrankList !=null && techrankList.size()>0){
			list.addAll(techrankList);
			flag = checkDataUtil.checkData(list,TABLENAME_HITECHRANK,NOTNULL_HITECHRANK,NOTNULL_NAME_HITECHRANK,DEFDOC_HITECHRANK,DEFDOC_NAME_HITECHRANK,PK_HITECHRANK,PK_NAME_HITECHRANK,TIP_HITECHRANK, TIP_NAME_HITECHRANK,dataControlMap,defdocMap,NOTNULL_OTHER_HITECHRANK,NOTNULL_OTHER_NAME_HITECHRANK);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: getHi_psndoc_grpdef11SpikeAdd
	 * @Description: 校验知识产权信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_grpdef11Add(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hi_psndoc_grpdef11VO> grpdef11List =spike.getHi_psndoc_grpdef11SpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(grpdef11List !=null && grpdef11List.size()>0){
			list.addAll(grpdef11List);
			flag = checkDataUtil.checkData(list,TABLENAME_HIGRPDEF11,NOTNULL_HIGRPDEF11,NOTNULL_NAME_HIGRPDEF11,null,null,PK_HIGRPDEF11,PK_NAME_HIGRPDEF11,TIP_HIGRPDEF11, TIP_NAME_HIGRPDEF11,dataControlMap,defdocMap,NOTNULL_OTHER_HIGRPDEF11,NOTNULL_OTHER_NAME_HIGRPDEF11);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_grpdef11Edit
	 * @Description: 校验知识产权信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_grpdef11Edit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hi_psndoc_grpdef11VO> grpdef11List =spike.getHi_psndoc_grpdef11SpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(grpdef11List !=null && grpdef11List.size()>0){
			list.addAll(grpdef11List);
			flag = checkDataUtil.checkData(list,TABLENAME_HIGRPDEF11,NOTNULL_HIGRPDEF11,NOTNULL_NAME_HIGRPDEF11,null,null,PK_HIGRPDEF11,PK_NAME_HIGRPDEF11,TIP_HIGRPDEF11, TIP_NAME_HIGRPDEF11,dataControlMap,defdocMap,NOTNULL_OTHER_HIGRPDEF11,NOTNULL_OTHER_NAME_HIGRPDEF11);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_dimissionAdd
	 * @Description: 校验员工离职信息新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_dimissionAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hi_psndoc_dimissionVO> dimissionList =spike.getHi_psndoc_dimissionSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(dimissionList !=null && dimissionList.size()>0){
			list.addAll(dimissionList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIDIMISSION,NOTNULL_HIDIMISSION,NOTNULL_NAME_HIDIMISSION,DEFDOC_HIDIMISSION,DEFDOC_NAME_HIDIMISSION,PK_HIDIMISSION,PK_NAME_HIDIMISSION,TIP_HIDIMISSION, TIP_NAME_HIDIMISSION,dataControlMap,defdocMap,NOTNULL_OTHER_HIDIMISSION,NOTNULL_OTHER_NAME_HIDIMISSION);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHi_psndoc_dimissionEdit
	 * @Description: 校验员工离职信息修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHi_psndoc_dimissionEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hi_psndoc_dimissionVO> dimissionList =spike.getHi_psndoc_dimissionSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(dimissionList !=null && dimissionList.size()>0){
			list.addAll(dimissionList);
			flag = checkDataUtil.checkData(list,TABLENAME_HIDIMISSION,NOTNULL_HIDIMISSION,NOTNULL_NAME_HIDIMISSION,DEFDOC_HIDIMISSION,DEFDOC_NAME_HIDIMISSION,PK_HIDIMISSION,PK_NAME_HIDIMISSION,TIP_HIDIMISSION, TIP_NAME_HIDIMISSION,dataControlMap,defdocMap,NOTNULL_OTHER_HIDIMISSION,NOTNULL_OTHER_NAME_HIDIMISSION);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHrldm_ldpsn_info
	 * @Description: 校验干部信息主集-干部分类信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_ldpsn_info(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_ldpsn_infoVO> infoList =spike.getHrldm_ldpsn_infoSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(infoList !=null && infoList.size()>0){
			list.addAll(infoList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMINFO,NOTNULL_HRLDMINFO,NOTNULL_NAME_HRLDMINFO,null,null,PK_HRLDMINFO,PK_NAME_HRLDMINFO,TIP_HRLDMINFO, TIP_NAME_HRLDMINFO,dataControlMap,defdocMap,NOTNULL_OTHER_HRLDMINFO,NOTNULL_OTHER_NAME_HRLDMINFO);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHrldm_ldpsn_info
	 * @Description: 校验干部信息主集-干部分类信息
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_ldpsn_infoAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_ldpsn_infoVO> infoList =spike.getHrldm_ldpsn_infoSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(infoList !=null && infoList.size()>0){
			list.addAll(infoList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMINFO,NOTNULL_HRLDMINFO,NOTNULL_NAME_HRLDMINFO,null,null,PK_HRLDMINFO,PK_NAME_HRLDMINFO,TIP_HRLDMINFO, TIP_NAME_HRLDMINFO,dataControlMap,defdocMap,NOTNULL_OTHER_HRLDMINFO,NOTNULL_OTHER_NAME_HRLDMINFO);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHrldm_psndoc_duty
	 * @Description: 校验领导人员职务信息子集
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_psndoc_duty(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_psndoc_dutyVO> dutyList =spike.getHrldm_psndoc_dutySpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(dutyList !=null && dutyList.size()>0){
			list.addAll(dutyList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMDUTY,NOTNULL_HRLDMDUTY,NOTNULL_NAME_HRLDMDUTY,null,null,PK_HRLDMDUTY,PK_NAME_HRLDMDUTY,TIP_HRLDMDUTY, TIP_NAME_HRLDMDUTY,dataControlMap,defdocMap,NOTNULL_OTHER_HRLDMDUTY,NOTNULL_OTHER_NAME_HRLDMDUTY);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHrldm_psndoc_duty
	 * @Description: 校验领导人员职务信息子集
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_psndoc_dutyAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_psndoc_dutyVO> dutyList =spike.getHrldm_psndoc_dutySpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(dutyList !=null && dutyList.size()>0){
			list.addAll(dutyList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMDUTY,NOTNULL_HRLDMDUTY,NOTNULL_NAME_HRLDMDUTY,null,null,PK_HRLDMDUTY,PK_NAME_HRLDMDUTY,TIP_HRLDMDUTY, TIP_NAME_HRLDMDUTY,dataControlMap,defdocMap,NOTNULL_OTHER_HRLDMDUTY,NOTNULL_OTHER_NAME_HRLDMDUTY);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checHrldm_train_plan
	 * @Description: 校验后备干部信息子集
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_train_plan(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_train_planVO> planList =spike.getHrldm_train_planSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(planList !=null && planList.size()>0){
			list.addAll(planList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMPLAN,NOTNULL_HRLDMPLAN,NOTNULL_NAME_HRLDMPLAN,null,null,PK_HRLDMPLAN,PK_NAME_HRLDMPLAN,TIP_HRLDMPLAN, TIP_NAME_HRLDMPLAN,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checHrldm_train_plan
	 * @Description: 校验后备干部信息子集
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHrldm_train_planAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hrldm_train_planVO> planList =spike.getHrldm_train_planSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(planList !=null && planList.size()>0){
			list.addAll(planList);
			flag = checkDataUtil.checkData(list,TABLENAME_HRLDMPLAN,NOTNULL_HRLDMPLAN,NOTNULL_NAME_HRLDMPLAN,null,null,PK_HRLDMPLAN,PK_NAME_HRLDMPLAN,TIP_HRLDMPLAN, TIP_NAME_HRLDMPLAN,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkHr_expert
	 * @Description: 校验专业人才管理-院士专家信息维护
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHr_expert(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hr_expertVO> hrExpertList =spike.getHr_expertSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(hrExpertList !=null && hrExpertList.size()>0){
			list.addAll(hrExpertList);
			flag = checkDataUtil.checkData(list,TABLENAME_HREXPERT,NOTNULL_HREXPERT,NOTNULL_NAME_HREXPERT,DEFDOC_HREXPERT,DEFDOC_NAME_HREXPERT,PK_HREXPERT,PK_NAME_HREXPERT,TIP_HREXPERT, TIP_NAME_HREXPERT,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkHr_expert
	 * @Description: 校验专业人才管理-院士专家信息维护
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkHr_expertAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Hr_expertVO> hrExpertList =spike.getHr_expertSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(hrExpertList !=null && hrExpertList.size()>0){
			list.addAll(hrExpertList);
			flag = checkDataUtil.checkData(list,TABLENAME_HREXPERT,NOTNULL_HREXPERT,NOTNULL_NAME_HREXPERT,DEFDOC_HREXPERT,DEFDOC_NAME_HREXPERT,PK_HREXPERT,PK_NAME_HREXPERT,TIP_HREXPERT, TIP_NAME_HREXPERT,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	/**
	 * @Title: checkExpert_term
	 * @Description: 校验院士专家子集－聘期管理增量数据
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkExpert_term(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Expert_termVO> expertTermList =spike.getExpert_termSpikeData(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(expertTermList !=null && expertTermList.size()>0){
			list.addAll(expertTermList);
			flag = checkDataUtil.checkData(list,TABLENAME_EXPERTTERM,NOTNULL_EXPERTTERM,NOTNULL_NAME_EXPERTTERM,DEFDOC_EXPERTTERM,DEFDOC_NAME_EXPERTTERM,PK_EXPERTTERM,PK_NAME_EXPERTTERM,TIP_EXPERTTERM, TIP_NAME_EXPERTTERM,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkExpert_term
	 * @Description: 校验院士专家子集－聘期管理增量数据
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkExpert_termAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		
		List<Expert_termVO> expertTermList =spike.getExpert_termSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(expertTermList !=null && expertTermList.size()>0){
			list.addAll(expertTermList);
			flag = checkDataUtil.checkData(list,TABLENAME_EXPERTTERM,NOTNULL_EXPERTTERM,NOTNULL_NAME_EXPERTTERM,DEFDOC_EXPERTTERM,DEFDOC_NAME_EXPERTTERM,PK_EXPERTTERM,PK_NAME_EXPERTTERM,TIP_EXPERTTERM, TIP_NAME_EXPERTTERM,dataControlMap,defdocMap,NULLARR,NULLARR);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkWa_DataAdd
	 * @Description: 校验薪资新增数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkWa_DataAdd(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		List<Wa_dataVO> waDataList =spike.getWa_dataSpikeAdd(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(waDataList !=null && waDataList.size()>0){
			list.addAll(waDataList);
			flag = checkDataUtil.checkData(list,TABLENAME_WADATA,NOTNULL_WADATA,NOTNULL_NAME_WADATA,DEFDOC_WADATA,DEFDOC_NAME_WADATA,PK_WADATA,PK_NAME_WADATA,TIP_WADATA, TIP_NAME_WADATA,dataControlMap,defdocMap,NOTNULL_WADATA,NOTNULL_NAME_WADATA);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkWa_DataEdit
	 * @Description: 校验薪资修改数据，分页处理
	 * @修改人: 王凯强
	 * @param dataControlMap
	 * @param defdocMap
	 * @param lastTime
	 * @param sysTime
	 * @return
	 * @throws BusinessException
	 */
	public List<SuperVO> checkWa_DataEdit(List<DataMap> dataControlMap, List<DataMap> defdocMap, String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		list = new ArrayList<SuperVO>();
		List<Wa_dataVO> waDataList =spike.getWa_dataSpikeEdit(lastTime, sysTime, corpArr, sqlMap);
		boolean flag = true;
		if(waDataList !=null && waDataList.size()>0){
			list.addAll(waDataList);
			flag = checkDataUtil.checkData(list,TABLENAME_WADATA,NOTNULL_WADATA,NOTNULL_NAME_WADATA,DEFDOC_WADATA,DEFDOC_NAME_WADATA,PK_WADATA,PK_NAME_WADATA,TIP_WADATA, TIP_NAME_WADATA,dataControlMap,defdocMap,NOTNULL_WADATA,NOTNULL_NAME_WADATA);
		}
		return flag ? list : null;
	}
	
	/**
	 * @Title: checkCorp
	 * @Description: 先进行公司比较，比较公司的两个表：bd_corp 与 mid_bd_corp
	 * @Author: 王凯强
	 * @Date: 2016年9月8日
	 * @return
	 * @throws BusinessException
	 */
	public boolean checkCorp() throws BusinessException{
		ICheckData iCheckData = (ICheckData) NCLocator.getInstance().lookup(ICheckData.class.getName());
		List<String> list = iCheckData.checkCorp();
		final List<Fbs_logVO> vos = new ArrayList<Fbs_logVO>();
		for(int i=0;i<list.size();i++){
			String message = "进行公司对照时，编码为'" + list.get(i) + "'的公司在集团不存在，请核对后继续操作";
			vos.add(getErrorLog(CheckField.TYPE_CHECK_CORP, message, "公司表", list.get(i)));
		}
		if(vos.size()>0){
			final String ds = InvocationInfoProxy.getInstance().getUserDataSource();
			//起个线程，不受事务控制
			new Thread(new Runnable() {
				public void run() {
					try {
						new BaseDAO(ds).insertVOList(vos);
					} catch (DAOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			return false;
		}
		return true;
	}
	
	
	public  Fbs_logVO getErrorLog(String type, String message, String table, String errorCorp)
			throws BusinessException {
		Fbs_logVO logVO = new Fbs_logVO();
		logVO.setVgroupdef2(type);
		logVO.setVgroupdef1(table);
		logVO.setFbs_log_content(message);
		logVO.setPk_corp(Global.getPkGroup());
		logVO.setBill_writer_date(new UFDate(System.currentTimeMillis()));
		logVO.setVgroupdef3(errorCorp);
		return logVO;
	}
	
}

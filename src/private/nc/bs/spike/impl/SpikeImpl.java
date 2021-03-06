package nc.bs.spike.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import nc.bs.dao.BaseDAO;
import nc.itf.spike.ISpike;
import nc.jdbc.framework.processor.BeanListProcessor;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.pub.Constants;
import nc.util.fbs.pub.PubTool;
import nc.vo.pub.BusinessException;
import nc.vo.spike.BasicVO;
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
 * @ClassName: SpikeImpl <b> 获取增量数据业务处理类 </b>
 *             <p>
 *                以SpikeAdd结尾的方法是获取增量增加的方法
 *                以SpikeEdit结尾的方法是获取增量修改的方法 
 *                以SpikeData结尾的方法是获取增量增加及修改的方法
 *                getPhotoSpikeData是增量抽取照片方法
 *             </p>
 *             创建日期:2016年7月27日 上午9:54:57
 * @author 王凯强
 * @version
 */
public class SpikeImpl implements ISpike {
	
	/**
	 * @field: series
	 * @Discription: 职务簇在集团bd_defdoclist中可能会变，需要及时维护
	 * 该属性在下面的方法中会用，用到的表有：bd_psndoc，om_duty,hi_psndoc_deptchg
	 */
	private String series = "HI000000000000000222";
	
	/************************************* 部门档案增量数据 ******************************************/

	@SuppressWarnings("unchecked")
	public List<Bd_deptdocVO> getBd_deptdocSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_deptdocVO> list = new ArrayList<Bd_deptdocVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_BD_DEPTDOC) == null){
			sql.append("select dept.ts as ts_old, dept.innercode, dept.pk_deptdoc, dept.pk_corp, dept.deptcode, dept.deptname, dept.showorder, dept.def1, dept.createdate, dept.pk_fathedept, dept.deptduty, dept.pk_psndoc, dept.phone, dept.pk_psndoc2, dept.def2, dept.memo, dept.canceled, dept.deptattr, dept.hrcanceled, dept.isuseretail from bd_deptdoc dept where not exists (select dept_m.pk_deptdoc_old from mid_bd_deptdoc dept_m where dept.pk_deptdoc = dept_m.pk_deptdoc_old and dept_m.pk_deptdoc_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_DEPTDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and dept.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("dept", sql, corpArr);
		list = (ArrayList<Bd_deptdocVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_deptdocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_deptdoc_old(list.get(i).getPk_deptdoc());
			if ("".equals(PubTool.toString(list.get(i).getHrcanceled()))) {
				list.get(i).setHrcanceled("N");
			}
			if("".equals(list.get(i).getCanceled())){
				list.get(i).setCanceled("N");
			}
			if("".equals(list.get(i).getIsuseretail())){
				list.get(i).setIsuseretail("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_deptdocVO> getBd_deptdocSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_deptdocVO> list = new ArrayList<Bd_deptdocVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_BD_DEPTDOC) == null){
			sql.append("select dept.ts as ts_old, dept.innercode, dept.pk_deptdoc, dept.pk_corp, dept.deptcode, dept.deptname, dept.showorder, dept.def1, dept.createdate, dept.pk_fathedept, dept.deptduty, dept.pk_psndoc, dept.phone, dept.pk_psndoc2, dept.def2, dept.memo, dept.canceled, dept.deptattr, dept.hrcanceled, dept.isuseretail from bd_deptdoc dept, mid_bd_deptdoc dept_m where dept.pk_deptdoc = dept_m.pk_deptdoc_old and dept.ts != dept_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_DEPTDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and dept.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("dept", sql, corpArr);
		list = (ArrayList<Bd_deptdocVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_deptdocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_deptdoc_old(list.get(i).getPk_deptdoc());
			if (list.get(i).getHrcanceled() == null || list.get(i).getHrcanceled().equals("")) {
				list.get(i).setHrcanceled("N");
			}
			if(list.get(i).getCanceled() == null || list.get(i).getCanceled().equals("")){
				list.get(i).setCanceled("N");
			}
			if(list.get(i).getIsuseretail() == null || list.get(i).getIsuseretail().equals("")){
				list.get(i).setIsuseretail("N");
			}
		}
		return list;
	}

	public List<Bd_deptdocVO> getBd_deptdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_deptdocVO> list = new ArrayList<Bd_deptdocVO>();

		if (lastTime != null) {
			list.addAll(getBd_deptdocSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}
		
		list.addAll(getBd_deptdocSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		
		return list;
	}

	/************************************* 员工工作信息增量数据 ****************************************/

	@SuppressWarnings("unchecked")
	public List<Bd_psndocVO> getBd_psndocSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psndocVO> list = new ArrayList<Bd_psndocVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_BD_PSNDOC) == null){
			sql.append("select psn.ts as ts_old, psn.indocflag, psn.pk_psnbasdoc, psn.pk_psndoc, psn.pk_corp, psn.pk_psncl, psn.psnclscope, psn.psncode, psn.psnname, psn.pk_deptdoc, psn.pk_om_job, psn.jobseries, psn.groupdef1, psn.pk_dutyrank, psn.dutyname, psn.series, psn.groupdef3, psn.groupdef2, psn.onpostdate, psn.groupdef14, psn.groupdef4, psn.groupdef10, psn.insource, psn.outdutydate, psn.groupdef12, psn.groupdef11, psn.regulardata, psn.wastopdate, psn.showorder, basdoc.pk_corp as bas_pkcorp from bd_psndoc psn inner join bd_psnbasdoc basdoc on psn.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select psn_m.pk_psndoc_old from mid_bd_psndoc psn_m where psn.pk_psndoc = psn_m.pk_psndoc_old and psn_m.pk_psndoc_old is not null) and psn.indocflag = 'Y' ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_PSNDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psn.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psn", sql, corpArr);
		list = (ArrayList<Bd_psndocVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Bd_psndocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_old(list.get(i).getPk_psndoc());
			list.get(i).setSeries(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_psndocVO> getBd_psndocSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psndocVO> list = new ArrayList<Bd_psndocVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_BD_PSNDOC) == null){
			sql.append("select psn.ts as ts_old, psn.indocflag, psn.pk_psnbasdoc, psn.pk_psndoc, psn.pk_corp, psn.pk_psncl, psn.psnclscope, psn.psncode,psn.psnname, psn.pk_deptdoc, psn.pk_om_job, psn.jobseries, psn.groupdef1, psn.pk_dutyrank, psn.dutyname, psn.series, psn.groupdef3, psn.groupdef2, psn.onpostdate, psn.groupdef14, psn.groupdef4, psn.groupdef10, psn.insource, psn.outdutydate, psn.groupdef12, psn.groupdef11, psn.regulardata, psn.wastopdate, psn.showorder, basdoc.pk_corp as bas_pkcorp from bd_psndoc psn inner join mid_bd_psndoc psn_m on psn.pk_psndoc = psn_m.pk_psndoc_old inner join bd_psnbasdoc basdoc on psn.pk_psnbasdoc = basdoc.pk_psnbasdoc where psn.ts != psn_m.ts_old and psn.indocflag = 'Y' ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_PSNDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psn.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psn", sql, corpArr);
		list = (ArrayList<Bd_psndocVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Bd_psndocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_old(list.get(i).getPk_psndoc());
			list.get(i).setSeries(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
		}
		return list;
	}

	public List<Bd_psndocVO> getBd_psndocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psndocVO> list = new ArrayList<Bd_psndocVO>();
		
		if (lastTime != null) {
			list.addAll(getBd_psndocSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}
		
		list.addAll(getBd_psndocSpikeAdd(lastTime, sysTime, corpArr, sqlMap));

		return list;
	}

	/****************************************** 人员基本信息增量数据 ***************************************************/
	public List<Bd_psnbasdocVO> getBd_psnbasdocSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psnbasdocVO> list = new ArrayList<Bd_psnbasdocVO>();

		if (lastTime != null) {
			list.addAll(getBd_psnbasdocSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 
		
		list.addAll(getBd_psnbasdocSpikeAdd(lastTime, sysTime, corpArr, sqlMap));

		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_psnbasdocVO> getBd_psnbasdocSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psnbasdocVO> list = new ArrayList<Bd_psnbasdocVO>();
		StringBuffer sql = new StringBuffer();//先不查询, psn.photo
		if(sqlMap.get(Constants.MID_BD_PSNBASDOC) == null){
			sql.append("select psn.ts as ts_old, psn.nativeplace, psn.basgroupdef12, psn.indocflag, psn.pk_psnbasdoc, psn.pk_corp, psn.basgroupdef1, psn.basgroupdef2, psn.psnname, psn.usedname, psn.nationality, psn.country, psn.sex, psn.id, psn.birthdate, psn.joinworkdate, psn.joinsysdate, psn.basgroupdef13, psn.basgroupdef14, psn.ssnum, psn.penelauth, psn.marital, psn.health, psn.bloodtype, psn.characterrpr, psn.permanreside, psn.addr, psn.postalcode, psn.mobile, psn.homephone, psn.officephone, psn.basgroupdef4, psn.email, psn.basgroupdef5, psn.polity, psndoc.psncode, psndoc.pk_psncl from bd_psnbasdoc psn inner join bd_psndoc psndoc on psn.pk_psnbasdoc = psndoc.pk_psnbasdoc and psn.pk_corp = psndoc.pk_corp inner join bd_psncl psncl on psncl.pk_psncl = psndoc.pk_psncl where not exists (select psn_m.pk_psnbasdoc_old from mid_bd_psnbasdoc psn_m where psn.pk_psnbasdoc = psn_m.pk_psnbasdoc_old and psn_m.pk_psnbasdoc_old is not null) and psn.indocflag = 'Y' ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_PSNBASDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psn.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psn", sql, corpArr);
		list = (ArrayList<Bd_psnbasdocVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Bd_psnbasdocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psnbasdoc_old(list.get(i).getPk_psnbasdoc());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_psnbasdocVO> getBd_psnbasdocSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Bd_psnbasdocVO> list = new ArrayList<Bd_psnbasdocVO>();
		StringBuffer sql = new StringBuffer();//先不查询, psn.photo
		if(sqlMap.get(Constants.MID_BD_PSNBASDOC) == null){
			sql.append("select psn.ts as ts_old, psn.indocflag, psn.nativeplace, psn.basgroupdef12, psn.pk_psnbasdoc, psn.pk_corp, psn.basgroupdef1, psn.basgroupdef2, psn.psnname, psn.usedname, psn.nationality, psn.country, psn.sex, psn.id, psn.birthdate, psn.joinworkdate, psn.joinsysdate, psn.basgroupdef13, psn.basgroupdef14, psn.ssnum, psn.penelauth, psn.marital, psn.health, psn.bloodtype, psn.characterrpr, psn.permanreside, psn.addr, psn.postalcode, psn.mobile, psn.homephone, psn.officephone, psn.basgroupdef4, psn.email, psn.basgroupdef5,psn.polity, psndoc.psncode, psndoc.pk_psncl from bd_psnbasdoc psn inner join mid_bd_psnbasdoc psn_m on psn.pk_psnbasdoc = psn_m.pk_psnbasdoc_old inner join bd_psndoc psndoc on psn.pk_psnbasdoc = psndoc.pk_psnbasdoc and psn.pk_corp = psndoc.pk_corp inner join bd_psncl psncl on psncl.pk_psncl = psndoc.pk_psncl where psn.ts != psn_m.ts_old and psn.indocflag = 'Y' ");
		}else{
			sql.append(sqlMap.get(Constants.MID_BD_PSNBASDOC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psn.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psn", sql, corpArr);
		list = (ArrayList<Bd_psnbasdocVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Bd_psnbasdocVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psnbasdoc_old(list.get(i).getPk_psnbasdoc());
		}
		return list;
	}
	/****************************************** 岗位基本信息 *******************************************/

	@SuppressWarnings("unchecked")
	public List<Om_jobVO> getOm_jobSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_jobVO> list = new ArrayList<Om_jobVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_JOB) == null){
			sql.append("select job.ts as ts_old, job.pk_om_job, job.pk_corp, job.jobcode, job.jobname, job.builddate, job.pk_deptdoc, job.suporior, job.pk_om_duty, job.jobseries, job.groupdef1, job.groupdef2,job.groupdef3, job.groupdef4,job.avicdef1, job.worksumm, job.createcorp, job.isabort, job.isdeptrespon from om_job job where not exists (select job_m.pk_om_job_old from mid_om_job job_m where job.pk_om_job = job_m.pk_om_job_old and job_m.pk_om_job_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_JOB));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and job.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("job", sql, corpArr);
		list = (ArrayList<Om_jobVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_jobVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_job_old(list.get(i).getPk_om_job());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_jobVO> getOm_jobSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_jobVO> list = new ArrayList<Om_jobVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_JOB) == null){
			sql.append("select job.ts as ts_old, job.pk_om_job, job.pk_corp, job.jobcode, job.jobname, job.builddate, job.pk_deptdoc, job.suporior, job.pk_om_duty, job.jobseries, job.groupdef1, job.groupdef2,job.groupdef3, job.groupdef4,job.avicdef1, job.worksumm, job.createcorp, job.isabort, job.isdeptrespon from om_job job, mid_om_job job_m where job.pk_om_job = job_m.pk_om_job_old and job.ts != job_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_JOB));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and job.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("job", sql, corpArr);
		list = (ArrayList<Om_jobVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_jobVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_job_old(list.get(i).getPk_om_job());
		}
		return list;
	}

	public List<Om_jobVO> getOm_jobSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_jobVO> list = new ArrayList<Om_jobVO>();

		if (lastTime != null) {
			list.addAll(getOm_jobSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getOm_jobSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 岗位编制信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Om_job_workoutVO> getOm_job_workoutSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_job_workoutVO> list = new ArrayList<Om_job_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_JOB_WORKOUT) == null){
			sql.append("select work.ts as ts_old, work.pk_om_job_workout, work.pk_corp, work.pk_om_job, work.cyear, work.workout, work.actualnum, work.version, job.jobcode from om_job_workout work inner join om_job job on work.pk_om_job = job.pk_om_job where not exists (select work_m.pk_om_job_workout_old from mid_om_job_workout work_m where work.pk_om_job_workout = work_m.pk_om_job_workout_old and work_m.pk_om_job_workout_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_JOB_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and work.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("work", sql, corpArr);
		list = (ArrayList<Om_job_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_job_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_job_workout_old(list.get(i).getPk_om_job_workout());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_job_workoutVO> getOm_job_workoutSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_job_workoutVO> list = new ArrayList<Om_job_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_JOB_WORKOUT) == null){
			sql.append("select work.ts as ts_old, work.pk_om_job_workout, work.pk_corp, work.pk_om_job, work.cyear, work.workout, work.actualnum, work.version, job.jobcode from om_job_workout work inner join mid_om_job_workout work_m on work.pk_om_job_workout = work_m.pk_om_job_workout_old inner join om_job job on work.pk_om_job = job.pk_om_job where work.ts != work_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_JOB_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and work.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("work", sql, corpArr);
		list = (ArrayList<Om_job_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_job_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_job_workout_old(list.get(i).getPk_om_job_workout());
		}
		return list;
	}

	public List<Om_job_workoutVO> getOm_job_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_job_workoutVO> list = new ArrayList<Om_job_workoutVO>();

		if (lastTime != null) {
			list.addAll(getOm_job_workoutSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 
		
		list.addAll(getOm_job_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取部门编制信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Om_dept_workoutVO> getOm_dept_workoutSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_dept_workoutVO> list = new ArrayList<Om_dept_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_DEPT_WORKOUT) == null){
			sql.append("select dept.ts as ts_old, dept.pk_om_dept_workout, dept.pk_corp, dept.pk_deptdoc, dept.cyear, dept.workout, dept.actualnum, dept.version, deptdoc.deptcode from om_dept_workout dept inner join bd_deptdoc deptdoc on dept.pk_deptdoc = deptdoc.pk_deptdoc where not exists (select dept_m.pk_om_dept_workout_old from mid_om_dept_workout dept_m where dept.pk_om_dept_workout = dept_m.pk_om_dept_workout_old and dept_m.pk_om_dept_workout_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_DEPT_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and dept.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("dept", sql, corpArr);
		list = (ArrayList<Om_dept_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_dept_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_dept_workout_old(list.get(i).getPk_om_dept_workout());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_dept_workoutVO> getOm_dept_workoutSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_dept_workoutVO> list = new ArrayList<Om_dept_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_DEPT_WORKOUT) == null){
			sql.append("select dept.ts as ts_old, dept.pk_om_dept_workout, dept.pk_corp, dept.pk_deptdoc, dept.cyear, dept.workout, dept.actualnum, dept.version, deptdoc.deptcode from om_dept_workout dept inner join mid_om_dept_workout dept_m on dept.pk_om_dept_workout = dept_m.pk_om_dept_workout_old inner join bd_deptdoc deptdoc on dept.pk_deptdoc = deptdoc.pk_deptdoc where dept.ts != dept_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_DEPT_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and dept.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("dept", sql, corpArr);
		list = (ArrayList<Om_dept_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_dept_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_dept_workout_old(list.get(i).getPk_om_dept_workout());
		}
		return list;
	}

	public List<Om_dept_workoutVO> getOm_dept_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_dept_workoutVO> list = new ArrayList<Om_dept_workoutVO>();
		
		if (lastTime != null) {
			list.addAll(getOm_dept_workoutSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 
		
		list.addAll(getOm_dept_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap));

		return list;
	}
	/***************************************** 获取单位编制信息增量数据增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Om_corp_workoutVO> getOm_corp_workoutSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workoutVO> list = new ArrayList<Om_corp_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT) == null){
			sql.append("select corp.ts as ts_old, corp.pk_om_corp_workout, corp.pk_corp, corp.makecorp, corp.cyear, corp.workout, corp.actualnum, corp.pk_om_workout_type, corp.stat, corp.version, bd_corp.unitcode from om_corp_workout corp inner join bd_corp on corp.pk_corp = bd_corp.pk_corp where not exists (select corp_m.pk_om_corp_workout_old from mid_om_corp_workout corp_m where corp.pk_om_corp_workout = corp_m.pk_om_corp_workout_old and corp_m.pk_om_corp_workout_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_CORP_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and corp.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("corp", sql, corpArr);
		list = (ArrayList<Om_corp_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_corp_workout_old(list.get(i).getPk_om_corp_workout());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_corp_workoutVO> getOm_corp_workoutSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workoutVO> list = new ArrayList<Om_corp_workoutVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT) == null){
			sql.append("select corp.ts as ts_old, corp.pk_om_corp_workout, corp.pk_corp, corp.makecorp, corp.cyear, corp.workout, corp.pk_om_workout_type, corp.stat, corp.version, bd_corp.unitcode from om_corp_workout corp inner join mid_om_corp_workout corp_m on corp.pk_om_corp_workout = corp_m.pk_om_corp_workout_old inner join bd_corp on corp.pk_corp = bd_corp.pk_corp where corp.ts != corp_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_CORP_WORKOUT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and corp.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("corp", sql, corpArr);
		list = (ArrayList<Om_corp_workoutVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workoutVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_corp_workout_old(list.get(i).getPk_om_corp_workout());
		}
		return list;
	}

	public List<Om_corp_workoutVO> getOm_corp_workoutSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workoutVO> list = new ArrayList<Om_corp_workoutVO>();

		if (lastTime != null) {
			list.addAll(getOm_corp_workoutSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}  

		list.addAll(getOm_corp_workoutSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取单位编制子表增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Om_corp_workout_bVO> getOm_corp_workout_bSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workout_bVO> list = new ArrayList<Om_corp_workout_bVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B) == null){
			sql.append("select corp.ts as ts_old, corp.pk_om_corp_workout_b,corp.pk_om_corp_workout, corp.pk_ref_name, corp.workout, corp.workoutcount, bd_corp.unitcode, corp_work.pk_corp from om_corp_workout_b corp inner join om_corp_workout corp_work on corp.pk_om_corp_workout = corp_work.pk_om_corp_workout inner join bd_corp on corp_work.pk_corp = bd_corp.pk_corp where not exists (select corp_m.pk_om_corp_workout_b_old from mid_om_corp_workout_b corp_m where corp.pk_om_corp_workout_b = corp_m.pk_om_corp_workout_b_old and corp_m.pk_om_corp_workout_b_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and corp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B) == null){
			sql = getExtCorp("corp_work", sql, corpArr);
		}else{
			sql = getExtCorp("corp", sql, corpArr);
		}
		
		list = (ArrayList<Om_corp_workout_bVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workout_bVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_corp_workout_b_old(list.get(i).getPk_om_corp_workout_b());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_corp_workout_bVO> getOm_corp_workout_bSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workout_bVO> list = new ArrayList<Om_corp_workout_bVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B) == null){
			sql.append("select corp.ts as ts_old, corp.pk_om_corp_workout_b,corp.pk_om_corp_workout, corp.pk_ref_name, corp.workout, corp.workoutcount, bd_corp.unitcode, corp_work.pk_corp from om_corp_workout_b corp inner join mid_om_corp_workout_b corp_m on corp.pk_om_corp_workout_b = corp_m.pk_om_corp_workout_b_old inner join om_corp_workout corp_work on corp.pk_om_corp_workout = corp_work.pk_om_corp_workout inner join bd_corp on corp_work.pk_corp = bd_corp.pk_corp where corp.ts != corp_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and corp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_OM_CORP_WORKOUT_B) == null){
			sql = getExtCorp("corp_work", sql, corpArr);
		}else{
			sql = getExtCorp("corp", sql, corpArr);
		}
		list = (ArrayList<Om_corp_workout_bVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workout_bVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_corp_workout_b_old(list.get(i).getPk_om_corp_workout_b());
		}
		return list;
	}

	public List<Om_corp_workout_bVO> getOm_corp_workout_bSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Om_corp_workout_bVO> list = new ArrayList<Om_corp_workout_bVO>();

		if (lastTime != null) {
			list.addAll(getOm_corp_workout_bSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getOm_corp_workout_bSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取学历学位信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_eduVO> list = new ArrayList<Hi_psndoc_eduVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_EDU) == null){
			sql.append("select edu.ts as ts_old, edu.pk_psndoc_sub, edu.pk_psnbasdoc, edu.pk_psndoc, edu.begindate, edu.enddate, edu.school, edu.vschooltype, edu.groupdef9, edu.vstudymode, edu.groupdef11, edu.education, edu.groupdef12, edu.lasteducation, edu.educationctifcode, edu.degree, edu.groupdef2, edu.groupdef3, edu.vcertifcode, edu.ddegreedate, edu.vdegreeunit, edu.edusystem, edu.groupdef4, edu.groupdef5, edu.groupdef6, edu.groupdef7, edu.groupdef8, edu.recordnum, edu.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_edu edu inner join bd_psndoc psndoc on psndoc.pk_psndoc = edu.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select edu_m.pk_psndoc_sub_old from mid_hi_psndoc_edu edu_m where edu.pk_psndoc_sub = edu_m.pk_psndoc_sub_old and edu_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_EDU));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and edu.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_EDU) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("edu", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_eduVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_eduVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef12() == null || list.get(i).getGroupdef12().equals("")) {
				list.get(i).setGroupdef12("N");
			}
			if (list.get(i).getLasteducation() == null || list.get(i).getLasteducation().equals("")) {
				list.get(i).setLasteducation("N");
			}
			if (list.get(i).getGroupdef2() == null || list.get(i).getGroupdef2().equals("")) {
				list.get(i).setGroupdef2("N");
			}
			if (list.get(i).getGroupdef3() == null || list.get(i).getGroupdef3().equals("")) {
				list.get(i).setGroupdef3("N");
			}
			if (list.get(i).getGroupdef4() == null || list.get(i).getGroupdef4().equals("")) {
				list.get(i).setGroupdef4("N");
			}
			if (list.get(i).getGroupdef5() == null || list.get(i).getGroupdef5().equals("")) {
				list.get(i).setGroupdef5("N");
			}
			if (list.get(i).getGroupdef6() == null || list.get(i).getGroupdef6().equals("")) {
				list.get(i).setGroupdef6("N");
			}
			if (list.get(i).getGroupdef7() == null || list.get(i).getGroupdef7().equals("")) {
				list.get(i).setGroupdef7("N");
			}
			if (list.get(i).getGroupdef8() == null || list.get(i).getGroupdef8().equals("")) {
				list.get(i).setGroupdef8("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_eduVO> list = new ArrayList<Hi_psndoc_eduVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_EDU) == null){
			sql.append("select edu.ts as ts_old, edu.pk_psndoc_sub, edu.pk_psnbasdoc, edu.pk_psndoc, edu.begindate, edu.enddate, edu.school, edu.vschooltype, edu.groupdef9, edu.vstudymode, edu.groupdef11, edu.education, edu.groupdef12, edu.lasteducation, edu.educationctifcode, edu.degree, edu.groupdef2, edu.groupdef3, edu.vcertifcode, edu.ddegreedate, edu.vdegreeunit, edu.edusystem, edu.groupdef4, edu.groupdef5, edu.groupdef6, edu.groupdef7, edu.groupdef8, edu.recordnum, edu.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_edu edu inner join mid_hi_psndoc_edu edu_m on edu.pk_psndoc_sub = edu_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = edu.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where edu.ts != edu_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_EDU));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and edu.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_EDU) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("edu", sql, corpArr);
		}		list = (ArrayList<Hi_psndoc_eduVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_eduVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef12() == null || list.get(i).getGroupdef12().equals("")) {
				list.get(i).setGroupdef12("N");
			}
			if (list.get(i).getLasteducation() == null || list.get(i).getLasteducation().equals("")) {
				list.get(i).setLasteducation("N");
			}
			if (list.get(i).getGroupdef2() == null || list.get(i).getGroupdef2().equals("")) {
				list.get(i).setGroupdef2("N");
			}
			if (list.get(i).getGroupdef3() == null || list.get(i).getGroupdef3().equals("")) {
				list.get(i).setGroupdef3("N");
			}
			if (list.get(i).getGroupdef4() == null || list.get(i).getGroupdef4().equals("")) {
				list.get(i).setGroupdef4("N");
			}
			if (list.get(i).getGroupdef5() == null || list.get(i).getGroupdef5().equals("")) {
				list.get(i).setGroupdef5("N");
			}
			if (list.get(i).getGroupdef6() == null || list.get(i).getGroupdef6().equals("")) {
				list.get(i).setGroupdef6("N");
			}
			if (list.get(i).getGroupdef7() == null || list.get(i).getGroupdef7().equals("")) {
				list.get(i).setGroupdef7("N");
			}
			if (list.get(i).getGroupdef8() == null || list.get(i).getGroupdef8().equals("")) {
				list.get(i).setGroupdef8("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_eduVO> getHi_psndoc_eduSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_eduVO> list = new ArrayList<Hi_psndoc_eduVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_eduSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}  

		list.addAll(getHi_psndoc_eduSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取职务基本信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<OmDutyVo> getOm_dutySpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<OmDutyVo> list = new ArrayList<OmDutyVo>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_DUTY) == null){
			sql.append("select duty.ts as ts_old, duty.createcorp, duty.pk_om_duty,duty.pk_corp, duty.dutycode, duty.dutyname, duty.dutyrank, duty.series,duty.vdutysumm from om_duty duty where not exists (select dutym.pk_om_duty_old from mid_om_duty dutym  where duty.pk_om_duty = dutym.pk_om_duty_old and  dutym.pk_om_duty_old is not null)");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_DUTY));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and duty.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("duty", sql, corpArr);
		list = (ArrayList<OmDutyVo>) getDao().executeQuery(sql.toString(), new BeanListProcessor(OmDutyVo.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_duty_old(list.get(i).getPk_om_duty());
			list.get(i).setSeries(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<OmDutyVo> getOm_dutySpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<OmDutyVo> list = new ArrayList<OmDutyVo>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_OM_DUTY) == null){
			sql.append("select duty.ts as ts_old, duty.createcorp,  duty.dr,  duty.dutycode,  duty.dutyname,  duty.dutyrank, duty.pk_corp,  duty.pk_om_duty,  duty.series,  duty.ts as ts_old,  duty.vdutysumm from om_duty duty, mid_om_duty dutym where duty.ts != dutym.ts_old and duty.pk_om_duty = dutym.pk_om_duty_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_OM_DUTY));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and duty.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("duty", sql, corpArr);
		list = (ArrayList<OmDutyVo>) getDao().executeQuery(sql.toString(), new BeanListProcessor(OmDutyVo.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_om_duty_old(list.get(i).getPk_om_duty());
			list.get(i).setSeries(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
		}
		return list;
	}

	public List<OmDutyVo> getOm_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<OmDutyVo> list = new ArrayList<OmDutyVo>();
		
		if (lastTime != null) {
			list.addAll(getOm_dutySpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getOm_dutySpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取员工工作履历信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_workVO> getHi_psndoc_workSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_workVO> list = new ArrayList<Hi_psndoc_workVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_WORK) == null){
			sql.append("select work.ts as ts_old, work.pk_psndoc_sub, work.pk_psnbasdoc, work.pk_psndoc, work.begindate, work.enddate, work.workcorp, work.workdept, work.workpost, work.vcertifier, work.vcertiphone, work.vdismismatter, work.recordnum, work.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_work work inner join bd_psndoc psndoc on psndoc.pk_psndoc = work.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select work_m.pk_psndoc_sub_old from mid_hi_psndoc_work work_m where work.pk_psndoc_sub = work_m.pk_psndoc_sub_old and work_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_WORK));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and work.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_WORK) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("work", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_workVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_workVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_workVO> getHi_psndoc_workSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_workVO> list = new ArrayList<Hi_psndoc_workVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_WORK) == null){
			sql.append("select work.ts as ts_old, work.pk_psndoc_sub, work.pk_psnbasdoc, work.pk_psndoc, work.begindate, work.enddate, work.workcorp, work.workdept, work.workpost, work.vcertifier, work.vcertiphone, work.vdismismatter, work.recordnum, work.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_work work inner join mid_hi_psndoc_work work_m on work.pk_psndoc_sub = work_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = work.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where work.ts != work_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_WORK));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and work.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_WORK) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("work", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_workVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_workVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_workVO> getHi_psndoc_workSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_workVO> list = new ArrayList<Hi_psndoc_workVO>();
		
		if (lastTime != null) {
			list.addAll(getHi_psndoc_workSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_workSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}

	/***************************************** 获取员工培训信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_trainingVO> list = new ArrayList<Hi_psndoc_trainingVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TRAINING) == null){
			sql.append("select train.ts as ts_old, train.tra_mode, train.taketrm_method, train.source_type, train.indocflag, train.pk_psndoc_sub, train.pk_psnbasdoc, train.pk_psndoc,train.groupdef2, train.vtra_act, train.groupdef5, train.begindate, train.enddate, train.groupdef1, train.tra_time, train.groupdef6, train.trm_certif_name, train.tra_mode_name, train.groupdef4, train.groupdef3, train.certificate_date, train.tra_content, train.groupdef7, train.tra_cost, train.recordnum, train.lastflag, psndoc.pk_psncl, psndoc.psncode, psndoc.pk_corp, basdoc.pk_corp as bas_pkcorp from hi_psndoc_training train inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select train_m.pk_psndoc_sub_old from mid_hi_psndoc_training train_m where train.pk_psndoc_sub = train_m.pk_psndoc_sub_old and train_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_TRAINING));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and train.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("train", sql, corpArr);
		list = (ArrayList<Hi_psndoc_trainingVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_trainingVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef7() == null || list.get(i).getGroupdef7().equals("")) {
				list.get(i).setGroupdef7("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_trainingVO> list = new ArrayList<Hi_psndoc_trainingVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TRAINING) == null){
			sql.append("select train.ts as ts_old, train.tra_mode, train.taketrm_method, train.source_type, train.indocflag, train.pk_psndoc_sub, train.pk_psnbasdoc, train.pk_psndoc,train.groupdef2, train.vtra_act, train.groupdef5, train.begindate, train.enddate, train.groupdef1, train.tra_time, train.groupdef6, train.trm_certif_name, train.tra_mode_name, train.groupdef4, train.groupdef3, train.certificate_date, train.tra_content, train.groupdef7, train.tra_cost, train.recordnum, train.lastflag, psndoc.pk_psncl, psndoc.psncode, psndoc.pk_corp from hi_psndoc_training train inner join mid_hi_psndoc_training train_m on train.pk_psndoc_sub = train_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc where train.ts != train_m.ts_old");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_TRAINING));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and train.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("train", sql, corpArr);
		list = (ArrayList<Hi_psndoc_trainingVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_trainingVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef7() == null || list.get(i).getGroupdef7().equals("")) {
				list.get(i).setGroupdef7("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_trainingVO> list = new ArrayList<Hi_psndoc_trainingVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_trainingSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_trainingSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取工人技术等级增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_techrankVO> list = new ArrayList<Hi_psndoc_techrankVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TECHRANK) == null){
			sql.append("select rank.ts as ts_old, rank.pk_psndoc_sub, rank.pk_psnbasdoc, rank.pk_psndoc, rank.techdutyname, rank.techlevelname, rank.jdtype, rank.arridate, rank.approvecorp, rank.rddate, rank.jdzscode, rank.pr_flag, rank.prstartdate, rank.jp_flag, rank.jpstartdate, rank.bsmark, rank.czmark, rank.recordnum, rank.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_techrank rank inner join bd_psndoc psndoc on psndoc.pk_psndoc = rank.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select rank_m.pk_psndoc_sub_old from mid_hi_psndoc_techrank rank_m where rank.pk_psndoc_sub = rank_m.pk_psndoc_sub_old and rank_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_TECHRANK));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and rank.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("rank", sql, corpArr);
		list = (ArrayList<Hi_psndoc_techrankVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_techrankVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
			if(list.get(i).getJp_flag() == null || list.get(i).getJp_flag().equals("")){
				list.get(i).setJp_flag("N");
			}
			if(list.get(i).getPr_flag() == null || list.get(i).getPr_flag().equals("")){
				list.get(i).setPr_flag("N");
			}
			
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_techrankVO> list = new ArrayList<Hi_psndoc_techrankVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_TECHRANK) == null){
			sql.append("select rank.ts as ts_old, rank.pk_psndoc_sub, rank.pk_psnbasdoc, rank.pk_psndoc, rank.techdutyname, rank.techlevelname, rank.jdtype, rank.arridate, rank.approvecorp, rank.rddate, rank.jdzscode, rank.pr_flag, rank.prstartdate, rank.jp_flag, rank.jpstartdate, rank.bsmark, rank.czmark, rank.recordnum, rank.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_techrank rank inner join mid_hi_psndoc_techrank rank_m on rank.pk_psndoc_sub = rank_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = rank.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where rank.ts != rank_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_TECHRANK));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and rank.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("rank", sql, corpArr);
		list = (ArrayList<Hi_psndoc_techrankVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_techrankVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
			if(list.get(i).getJp_flag() == null || list.get(i).getJp_flag().equals("")){
				list.get(i).setJp_flag("N");
			}
			if(list.get(i).getPr_flag() == null || list.get(i).getPr_flag().equals("")){
				list.get(i).setPr_flag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_techrankVO> list = new ArrayList<Hi_psndoc_techrankVO>();
		
		if (lastTime != null) {
			list.addAll(getHi_psndoc_techrankSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_techrankSpikeAdd(lastTime, sysTime, corpArr, sqlMap));

		return list;
	}
	/***************************************** 获取专业技术职务增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_spetechVO> list = new ArrayList<Hi_psndoc_spetechVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_SPETECH) == null){
			sql.append("select tech.ts as ts_old, tech.pk_psndoc_sub, tech.pk_psnbasdoc, tech.pk_psndoc, tech.ctechname, tech.ctechduty, tech.dengbegin, tech.dengend, tech.cengunit, tech.cengspe,tech.dindate, tech.cincomeway, tech.cprounit, tech.czsbh, tech.recordnum, tech.lastflag, tech.jp_flag, tech.pr_flag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_spetech tech inner join bd_psndoc psndoc on psndoc.pk_psndoc = tech.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select tech_m.pk_psndoc_sub_old from mid_hi_psndoc_spetech tech_m where tech.pk_psndoc_sub = tech_m.pk_psndoc_sub_old and tech_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_SPETECH));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and tech.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("tech", sql, corpArr);
		list = (ArrayList<Hi_psndoc_spetechVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_spetechVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
			if(list.get(i).getJp_flag() == null || list.get(i).getJp_flag().equals("")){
				list.get(i).setJp_flag("N");
			}
			if(list.get(i).getPr_flag() == null || list.get(i).getPr_flag().equals("")){
				list.get(i).setPr_flag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_spetechVO> list = new ArrayList<Hi_psndoc_spetechVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_SPETECH) == null){
			sql.append("select tech.ts as ts_old, tech.pk_psndoc_sub, tech.pk_psnbasdoc, tech.pk_psndoc, tech.ctechname, tech.ctechduty, tech.dengbegin, tech.dengend, tech.cengunit, tech.cengspe,tech.dindate, tech.cincomeway, tech.cprounit, tech.czsbh, tech.recordnum, tech.lastflag, tech.jp_flag, tech.pr_flag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_spetech tech inner join mid_hi_psndoc_spetech tech_m on tech.pk_psndoc_sub = tech_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = tech.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where tech.ts != tech_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_SPETECH));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and tech.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("tech", sql, corpArr);
		list = (ArrayList<Hi_psndoc_spetechVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_spetechVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
			if(list.get(i).getJp_flag() == null || list.get(i).getJp_flag().equals("")){
				list.get(i).setJp_flag("N");
			}
			if(list.get(i).getPr_flag() == null || list.get(i).getPr_flag().equals("")){
				list.get(i).setPr_flag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_spetechVO> list = new ArrayList<Hi_psndoc_spetechVO>();
		if (lastTime != null) {
			list.addAll(getHi_psndoc_spetechSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}

		list.addAll(getHi_psndoc_spetechSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		 
		return list;
	}
	/***************************************** 获取员工惩处信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_punVO> getHi_psndoc_punSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_punVO> list = new ArrayList<Hi_psndoc_punVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PUN) == null){
			sql.append("select pun.ts as ts_old, pun.pk_psndoc_sub, pun.pk_psnbasdoc, pun.pk_psndoc, pun.groupdef2, pun.groupdef1, pun.dpunishdate, pun.groupdef3, pun.vpunishorg, pun.vpunishmeas, pun.vpunishmatter, pun.groupdef4, pun.groupdef5, pun.groupdef6, pun.groupdef7, pun.groupdef8, pun.groupdef9, pun.recordnum, pun.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_pun pun inner join bd_psndoc psndoc on psndoc.pk_psndoc = pun.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select pun_m.pk_psndoc_sub_old from mid_hi_psndoc_pun pun_m where pun_m.pk_psndoc_sub_old = pun.pk_psndoc_sub and pun_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_PUN));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and pun.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PUN) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("pun", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_punVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_punVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_punVO> getHi_psndoc_punSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_punVO> list = new ArrayList<Hi_psndoc_punVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PUN) == null){
			sql.append("select pun.ts as ts_old, pun.pk_psndoc_sub, pun.pk_psnbasdoc, pun.pk_psndoc, pun.groupdef2, pun.groupdef1, pun.dpunishdate, pun.groupdef3, pun.vpunishorg, pun.vpunishmeas, pun.vpunishmatter, pun.groupdef4, pun.groupdef5, pun.groupdef6, pun.groupdef7, pun.groupdef8, pun.groupdef9, pun.recordnum, pun.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_pun pun inner join mid_hi_psndoc_pun pun_m on pun_m.pk_psndoc_sub_old = pun.pk_psndoc_sub inner join bd_psndoc psndoc on psndoc.pk_psndoc = pun.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where pun.ts != pun_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_PUN));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and pun.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PUN) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("pun", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_punVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_punVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_punVO> getHi_psndoc_punSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_punVO> list = new ArrayList<Hi_psndoc_punVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_punSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_punSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取政治面貌信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_partylogVO> list = new ArrayList<Hi_psndoc_partylogVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PARTYLOG) == null){
			sql.append("select party.ts as ts_old, party.pk_psndoc_sub, party.pk_psnbasdoc, party.pk_psndoc, party.cpartyname, party.dpartydate, party.dpartyduedate, party.cpartypsn, party.cpartyunit, party.groupdef2, party.recordnum, party.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_partylog party inner join bd_psndoc psndoc on psndoc.pk_psndoc = party.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select party_m.pk_psndoc_sub_old from mid_hi_psndoc_partylog party_m where party.pk_psndoc_sub = party_m.pk_psndoc_sub_old and party_m.pk_psndoc_sub_old is not null)");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_PARTYLOG));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and party.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("party", sql, corpArr);
		list = (ArrayList<Hi_psndoc_partylogVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_partylogVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getCpartyunit() == null || list.get(i).getCpartyunit().equals("")) {
				list.get(i).setCpartyunit("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_partylogVO> list = new ArrayList<Hi_psndoc_partylogVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_PARTYLOG) == null){
			sql.append("select party.ts as ts_old, party.pk_psndoc_sub, party.pk_psnbasdoc, party.pk_psndoc, party.cpartyname, party.dpartydate, party.dpartyduedate, party.cpartypsn, party.cpartyunit, party.groupdef2, party.recordnum, party.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_partylog party inner join mid_hi_psndoc_partylog party_m on party.pk_psndoc_sub = party_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = party.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where party.ts != party_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_PARTYLOG));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and party.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("party", sql, corpArr);
		list = (ArrayList<Hi_psndoc_partylogVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_partylogVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getCpartyunit() == null || list.get(i).getCpartyunit().equals("")) {
				list.get(i).setCpartyunit("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_partylogVO> list = new ArrayList<Hi_psndoc_partylogVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_partylogSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_partylogSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取家庭成员海外背景信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14SpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef14VO> list = new ArrayList<Hi_psndoc_grpdef14VO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14) == null){
			sql.append("select grp.ts as ts_old, grp.pk_psndoc_sub, grp.pk_psnbasdoc, grp.pk_psndoc, grp.groupdef1, grp.groupdef2, grp.groupdef3, grp.begindate, grp.groupdef6, grp.groupdef7, grp.groupdef9, grp.enddate, grp.groupdef8, grp.recordnum, grp.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_grpdef14 grp inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select grp_m.pk_psndoc_sub_old from mid_hi_psndoc_grpdef14 grp_m where grp_m.pk_psndoc_sub_old = grp.pk_psndoc_sub and grp_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and grp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("grp", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_grpdef14VO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_grpdef14VO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef9() == null || list.get(i).getGroupdef9().equals("")) {
				list.get(i).setGroupdef9("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14SpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef14VO> list = new ArrayList<Hi_psndoc_grpdef14VO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14) == null){
			sql.append("select grp.ts as ts_old, grp.pk_psndoc_sub, grp.pk_psnbasdoc, grp.pk_psndoc, grp.groupdef1, grp.groupdef2, grp.groupdef3, grp.begindate, grp.groupdef6, grp.groupdef7, grp.groupdef9, grp.enddate, grp.groupdef8, grp.recordnum, grp.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_grpdef14 grp inner join mid_hi_psndoc_grpdef14 grp_m on grp_m.pk_psndoc_sub_old = grp.pk_psndoc_sub inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where grp.ts != grp_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and grp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF14) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("grp", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_grpdef14VO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_grpdef14VO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef9() == null || list.get(i).getGroupdef9().equals("")) {
				list.get(i).setGroupdef9("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef14VO> list = new ArrayList<Hi_psndoc_grpdef14VO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_grpdef14SpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_grpdef14SpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取知识产权信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11SpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef11VO> list = new ArrayList<Hi_psndoc_grpdef11VO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11) == null){
			sql.append("select grp.ts as ts_old, grp.pk_psndoc_sub, grp.pk_psnbasdoc, grp.pk_psndoc, grp.groupdef1, grp.groupdef2, grp.begindate, grp.recordnum, grp.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_grpdef11 grp inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select grp_m.pk_psndoc_sub_old from mid_hi_psndoc_grpdef11 grp_m where grp.pk_psndoc_sub = grp_m.pk_psndoc_sub_old and grp_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and grp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("grp", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_grpdef11VO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_grpdef11VO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11SpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef11VO> list = new ArrayList<Hi_psndoc_grpdef11VO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11) == null){
			sql.append("select grp.ts as ts_old, grp.pk_psndoc_sub, grp.pk_psnbasdoc, grp.pk_psndoc, grp.groupdef1, grp.groupdef2, grp.begindate, grp.recordnum, grp.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_grpdef11 grp inner join mid_hi_psndoc_grpdef11 grp_m on grp.pk_psndoc_sub = grp_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where grp.ts != grp_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and grp.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_GRPDEF11) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("grp", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_grpdef11VO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_grpdef11VO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11SpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_grpdef11VO> list = new ArrayList<Hi_psndoc_grpdef11VO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_grpdef11SpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_grpdef11SpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取员工奖励信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_encVO> getHi_psndoc_encSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_encVO> list = new ArrayList<Hi_psndoc_encVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ENC) == null){
			sql.append("select enc.ts as ts_old, enc.pk_psndoc_sub, enc.pk_psnbasdoc, enc.pk_psndoc, enc.groupdef1, enc.groupdef2, enc.groupdef3, enc.vencourorg, enc.dencourdate, enc.vencourmatter, enc.vencourmeas, enc.groupdef4, enc.groupdef5, enc.groupdef6, enc.groupdef7, enc.groupdef8, enc.groupdef9, enc.recordnum, enc.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_enc enc inner join bd_psndoc psndoc on psndoc.pk_psndoc = enc.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select enc_m.pk_psndoc_sub_old from mid_hi_psndoc_enc enc_m where enc.pk_psndoc_sub = enc_m.pk_psndoc_sub_old and enc_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_ENC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and enc.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ENC) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("enc", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_encVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_encVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_encVO> getHi_psndoc_encSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_encVO> list = new ArrayList<Hi_psndoc_encVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ENC) == null){
			sql.append("select enc.ts as ts_old, enc.pk_psndoc_sub, enc.pk_psnbasdoc, enc.pk_psndoc, enc.groupdef1, enc.groupdef2, enc.groupdef3, enc.vencourorg, enc.dencourdate, enc.vencourmatter, enc.vencourmeas, enc.groupdef4, enc.groupdef5, enc.groupdef6, enc.groupdef7, enc.groupdef8, enc.groupdef9, enc.recordnum, enc.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_enc enc inner join mid_hi_psndoc_enc enc_m on enc.pk_psndoc_sub = enc_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = enc.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where enc.ts != enc_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_ENC));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and enc.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ENC) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("enc", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_encVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_encVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_encVO> getHi_psndoc_encSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_encVO> list = new ArrayList<Hi_psndoc_encVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_encSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_encSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取员工离职信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_dimissionVO> list = new ArrayList<Hi_psndoc_dimissionVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION) == null){
			sql.append("select model.ts as ts_old, model.pk_psndoc_sub, model.pk_psnbasdoc, model.pk_psndoc, model.leavedate, model.pkpostbefore, model.psnclbefore, model.psnclafter, model.type, model.pkdeptbefore, model.pk_corpafter, model.pkdeptafter, model.towhere, model.reason, model.description, model.salarystopdate, model.welfarestopdate, model.recordnum, model.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_dimission model inner join bd_psndoc psndoc on psndoc.pk_psndoc = model.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select model_m.pk_psndoc_sub_old from mid_hi_psndoc_dimission model_m where model.pk_psndoc_sub = model_m.pk_psndoc_sub_old and model_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and model.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("model", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_dimissionVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_dimissionVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_dimissionVO> list = new ArrayList<Hi_psndoc_dimissionVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION) == null){
			sql.append("select model.ts as ts_old, model.pk_psndoc_sub, model.pk_psnbasdoc, model.pk_psndoc, model.leavedate, model.pkpostbefore, model.psnclbefore, model.psnclafter, model.type, model.pkdeptbefore, model.pk_corpafter, model.pkdeptafter, model.towhere, model.reason, model.description, model.salarystopdate, model.welfarestopdate, model.recordnum, model.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_dimission model inner join mid_hi_psndoc_dimission model_m on model.pk_psndoc_sub = model_m.pk_psndoc_sub_old  inner join bd_psndoc psndoc on psndoc.pk_psndoc = model.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where model.ts != model_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and model.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DIMISSION) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("model", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_dimissionVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_dimissionVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_dimissionVO> list = new ArrayList<Hi_psndoc_dimissionVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_dimissionSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_dimissionSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取员工任职信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_deptchgVO> list = new ArrayList<Hi_psndoc_deptchgVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DEPTCHG) == null){
			sql.append("select chg.ts as ts_old, chg.pk_psndoc_sub, chg.pk_psnbasdoc, chg.pk_psndoc, chg.begindate, chg.enddate, chg.poststat, chg.pk_deptdoc, chg.pk_jobserial, chg.pk_postdoc, chg.pk_om_duty, chg.pk_dutyrank, chg.posttype, chg.jobtype, chg.choldreason, chg.deposetype, chg.deposereason, chg.preparetype, chg.preparereason, chg.preparenote, chg.isreturn, chg.avicdef1, chg.recordnum, chg.lastflag, chg.bendflag, chg.iscalovertime, chg.tbm_prop, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_deptchg chg inner join bd_psndoc psndoc on psndoc.pk_psndoc = chg.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select chg_m.pk_psndoc_sub_old from mid_hi_psndoc_deptchg chg_m where chg_m.pk_psndoc_sub_old = chg.pk_psndoc_sub and chg_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_DEPTCHG));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and chg.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("chg", sql, corpArr);
		list = (ArrayList<Hi_psndoc_deptchgVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_deptchgVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_detytype(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getIsreturn() == null || list.get(i).getIsreturn().equals("")) {
				list.get(i).setIsreturn("N");
			}
			if (list.get(i).getPoststat() == null || list.get(i).getPoststat().equals("")) {
				list.get(i).setPoststat("Y");
			}
			if (list.get(i).getBendflag() == null || list.get(i).getBendflag().equals("")){
				list.get(i).setBendflag("N");
			}
			if (list.get(i).getIscalovertime() == null || list.get(i).getIscalovertime().equals("")){
				list.get(i).setIscalovertime("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_deptchgVO> list = new ArrayList<Hi_psndoc_deptchgVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_DEPTCHG) == null){
			sql.append("select chg.ts as ts_old, chg.pk_psndoc_sub, chg.pk_psnbasdoc, chg.pk_psndoc, chg.begindate, chg.enddate, chg.poststat, chg.pk_deptdoc, chg.pk_jobserial, chg.pk_postdoc, chg.pk_om_duty, chg.pk_dutyrank, chg.posttype, chg.jobtype, chg.choldreason, chg.deposetype, chg.deposereason, chg.preparetype, chg.preparereason, chg.preparenote, chg.isreturn, chg.avicdef1, chg.recordnum, chg.lastflag, chg.bendflag, chg.iscalovertime, chg.tbm_prop, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_deptchg chg inner join mid_hi_psndoc_deptchg chg_m on chg_m.pk_psndoc_sub_old = chg.pk_psndoc_sub inner join bd_psndoc psndoc on psndoc.pk_psndoc = chg.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where chg_m.ts_old != chg.ts");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_DEPTCHG));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and chg.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("chg", sql, corpArr);
		list = (ArrayList<Hi_psndoc_deptchgVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_deptchgVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_detytype(series);//职务簇在集团bd_defdoclist中可能会变，需要及时维护
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getIsreturn() == null || list.get(i).getIsreturn().equals("")) {
				list.get(i).setIsreturn("N");
			}
			if (list.get(i).getPoststat() == null || list.get(i).getPoststat().equals("")) {
				list.get(i).setPoststat("Y");
			}
			if (list.get(i).getBendflag() == null || list.get(i).getBendflag().equals("")){
				list.get(i).setBendflag("N");
			}
			if (list.get(i).getIscalovertime() == null || list.get(i).getIscalovertime().equals("")){
				list.get(i).setIscalovertime("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_deptchgVO> list = new ArrayList<Hi_psndoc_deptchgVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_deptchgSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 
		
		list.addAll(getHi_psndoc_deptchgSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取员工涉外经历信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_abroadVO> list = new ArrayList<Hi_psndoc_abroadVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD) == null){
			sql.append("select abroad.ts as ts_old, abroad.pk_psndoc_sub, abroad.pk_psnbasdoc, abroad.pk_psndoc, abroad.groupdef2, abroad.cabroadarea, abroad.dabroaddate, abroad.groupdef3, abroad.dabroadreturn, abroad.cabroadunit, abroad.cabroadgroup, abroad.groupdef4, abroad.groupdef5, abroad.cabroadout, abroad.cabroadoutlay, abroad.cabroadpro, abroad.dabroadprodate, abroad.cabroadnumber, abroad.recordnum, abroad.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_abroad abroad inner join bd_psndoc psndoc on psndoc.pk_psndoc = abroad.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select abroad_m.pk_psndoc_sub_old from mid_hi_psndoc_abroad abroad_m where abroad.pk_psndoc_sub = abroad_m.pk_psndoc_sub_old and abroad_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and abroad.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("abroad", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_abroadVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_abroadVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef5() == null || list.get(i).getGroupdef5().equals("")) {
				list.get(i).setGroupdef5("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_abroadVO> list = new ArrayList<Hi_psndoc_abroadVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD) == null){
			sql.append("select abroad.ts as ts_old, abroad.pk_psndoc_sub, abroad.pk_psnbasdoc, abroad.pk_psndoc, abroad.groupdef2, abroad.cabroadarea, abroad.dabroaddate, abroad.groupdef3, abroad.dabroadreturn, abroad.cabroadunit, abroad.cabroadgroup, abroad.groupdef4, abroad.groupdef5, abroad.cabroadout, abroad.cabroadoutlay, abroad.cabroadpro, abroad.dabroadprodate, abroad.cabroadnumber, abroad.recordnum, abroad.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hi_psndoc_abroad abroad inner join mid_hi_psndoc_abroad abroad_m on abroad.pk_psndoc_sub = abroad_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = abroad.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where abroad.ts != abroad_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and abroad.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HI_PSNDOC_ABROAD) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("abroad", sql, corpArr);
		}
		list = (ArrayList<Hi_psndoc_abroadVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Hi_psndoc_abroadVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef5() == null || list.get(i).getGroupdef5().equals("")) {
				list.get(i).setGroupdef5("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hi_psndoc_abroadVO> list = new ArrayList<Hi_psndoc_abroadVO>();

		if (lastTime != null) {
			list.addAll(getHi_psndoc_abroadSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHi_psndoc_abroadSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取干部信息主集-干部分类信息增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_ldpsn_infoVO> list = new ArrayList<Hrldm_ldpsn_infoVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_LDPSN_INFO) == null){
			sql.append("select info.ts as ts_old, info.pk_psndoc_sub, info.pk_psnbasdoc, info.pk_psndoc, info.pk_defdoc, info.ld_type, info.showorder, info.memo, info.begindate,info.enddate, info.recordnum, info.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_ldpsn_info info inner join bd_psndoc psndoc on psndoc.pk_psndoc = info.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select info_m.pk_psndoc_sub_old from mid_hrldm_ldpsn_info info_m where info.pk_psndoc_sub = info_m.pk_psndoc_sub_old and info_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_LDPSN_INFO));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and info.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("info", sql, corpArr);
		list = (ArrayList<Hrldm_ldpsn_infoVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_ldpsn_infoVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_ldpsn_infoVO> list = new ArrayList<Hrldm_ldpsn_infoVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_LDPSN_INFO) == null){
			sql.append("select info.ts as ts_old, info.pk_psndoc_sub, info.pk_psnbasdoc, info.pk_psndoc, info.pk_defdoc, info.ld_type, info.showorder, info.memo, info.begindate,info.enddate, info.recordnum, info.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_ldpsn_info info inner join mid_hrldm_ldpsn_info info_m on info.pk_psndoc_sub = info_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = info.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where info.ts != info_m.ts_old");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_LDPSN_INFO));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and info.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("info", sql, corpArr);
		list = (ArrayList<Hrldm_ldpsn_infoVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_ldpsn_infoVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_ldpsn_infoVO> list = new ArrayList<Hrldm_ldpsn_infoVO>();

		if (lastTime != null) {
			list.addAll(getHrldm_ldpsn_infoSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		}  

		list.addAll(getHrldm_ldpsn_infoSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 获取领导人员职务信息子集增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutySpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_psndoc_dutyVO> list = new ArrayList<Hrldm_psndoc_dutyVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_PSNDOC_DUTY) == null){
			sql.append("select psndoc.ts as ts_old, psndoc.pk_psndoc_sub, psndoc.pk_psnbasdoc, psndoc.pk_psndoc, psndoc.groupdef1, psndoc.groupdef2, psndoc.groupdef3, psndoc.groupdef4, psndoc.pk_hold_corp, psndoc.pk_hold_dept, psndoc.pk_om_duty, psndoc.groupdef5, psndoc.pk_dutylevel, psndoc.pk_dutytype, psndoc.groupdef6, psndoc.pk_holdtype, psndoc.holddate, psndoc.holdnumber, psndoc.holdjob, psndoc.holdunit, psndoc.groupdef7, psndoc.groupdef8, psndoc.deposeunit, psndoc.deposedate, psndoc.deposenumber, psndoc.pk_holdreason, psndoc.recordnum, psndoc.lastflag , psn.pk_psncl, psn.pk_corp, psn.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_psndoc_duty psndoc inner join bd_psndoc psn on psn.pk_psndoc = psndoc.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select psndoc_m.pk_psndoc_sub_old from mid_hrldm_psndoc_duty psndoc_m where psndoc.pk_psndoc_sub = psndoc_m.pk_psndoc_sub_old and psndoc_m.pk_psndoc_sub_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_PSNDOC_DUTY));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psndoc.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psndoc", sql, corpArr);
		list = (ArrayList<Hrldm_psndoc_dutyVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_psndoc_dutyVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef4() == null || list.get(i).getGroupdef4().equals("")) {
				list.get(i).setGroupdef4("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutySpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_psndoc_dutyVO> list = new ArrayList<Hrldm_psndoc_dutyVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_PSNDOC_DUTY) == null){
			sql.append("select psndoc.ts as ts_old, psndoc.pk_psndoc_sub, psndoc.pk_psnbasdoc, psndoc.pk_psndoc, psndoc.groupdef1, psndoc.groupdef2, psndoc.groupdef3, psndoc.groupdef4, psndoc.pk_hold_corp, psndoc.pk_hold_dept, psndoc.pk_om_duty, psndoc.groupdef5, psndoc.pk_dutylevel, psndoc.pk_dutytype, psndoc.groupdef6, psndoc.pk_holdtype, psndoc.holddate, psndoc.holdnumber, psndoc.holdjob, psndoc.holdunit, psndoc.groupdef7, psndoc.groupdef8, psndoc.deposeunit, psndoc.deposedate, psndoc.deposenumber, psndoc.pk_holdreason, psndoc.recordnum, psndoc.lastflag, psn.pk_psncl, psn.pk_corp, psn.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_psndoc_duty psndoc inner join mid_hrldm_psndoc_duty psndoc_m on psndoc.pk_psndoc_sub = psndoc_m.pk_psndoc_sub_old inner join bd_psndoc psn on psn.pk_psndoc = psndoc.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where psndoc.ts != psndoc_m.ts_old");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_PSNDOC_DUTY));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and psndoc.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("psndoc", sql, corpArr);
		list = (ArrayList<Hrldm_psndoc_dutyVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_psndoc_dutyVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getGroupdef4() == null || list.get(i).getGroupdef4().equals("")) {
				list.get(i).setGroupdef4("N");
			}
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutySpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_psndoc_dutyVO> list = new ArrayList<Hrldm_psndoc_dutyVO>();
		if (lastTime != null) {
			list.addAll(getHrldm_psndoc_dutySpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHrldm_psndoc_dutySpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/***************************************** 获取后备干部信息子集增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hrldm_train_planVO> getHrldm_train_planSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_train_planVO> list = new ArrayList<Hrldm_train_planVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN) == null){
			sql.append("select train.ts as ts_old, train.pk_psndoc_sub, train.pk_psnbasdoc, train.pk_psndoc, train.groupdef1, train.groupdef2, train.train_target, train.groupdef3, train.train_object, train.groupdef4, train.begindate, train.groupdef5, train.groupdef6, train.groupdef7, train.train_step, train.recordnum, train.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_train_plan train inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where not exists (select train_m.pk_psndoc_sub_old from mid_hrldm_train_plan train_m where train.pk_psndoc_sub = train_m.pk_psndoc_sub_old and train_m.pk_psndoc_sub_old is not null)");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and train.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("train", sql, corpArr);
		}
		list = (ArrayList<Hrldm_train_planVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_train_planVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_train_planVO> getHrldm_train_planSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_train_planVO> list = new ArrayList<Hrldm_train_planVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN) == null){
			sql.append("select train.ts as ts_old, train.pk_psndoc_sub, train.pk_psnbasdoc, train.pk_psndoc, train.groupdef1, train.groupdef2, train.train_target, train.groupdef3, train.train_object, train.groupdef4, train.begindate, train.groupdef5, train.groupdef6, train.groupdef7, train.train_step, train.recordnum, train.lastflag, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode, basdoc.pk_corp as bas_pkcorp from hrldm_train_plan train inner join mid_hrldm_train_plan train_m on train.pk_psndoc_sub = train_m.pk_psndoc_sub_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc = basdoc.pk_psnbasdoc where train.ts != train_m.ts_old ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and train.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_HRLDM_TRAIN_PLAN) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("train", sql, corpArr);
		}
		list = (ArrayList<Hrldm_train_planVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_train_planVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_psndoc_sub_old(list.get(i).getPk_psndoc_sub());
			if (list.get(i).getLastflag() == null || list.get(i).getLastflag().equals("")) {
				list.get(i).setLastflag("N");
			}
		}
		return list;
	}

	public List<Hrldm_train_planVO> getHrldm_train_planSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hrldm_train_planVO> list = new ArrayList<Hrldm_train_planVO>();

		if (lastTime != null) {
			list.addAll(getHrldm_train_planSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getHrldm_train_planSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/***************************************** 专业人才管理-院士专家信息维护增量数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<Hr_expertVO> getHr_expertSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hr_expertVO> list = new ArrayList<Hr_expertVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HR_EXPERT) == null){
			sql.append("select expert.ts as ts_old, expert.pk_hr_exper, expert.exper_code, expert.exper_name, expert.exper_level, expert.exper_type, expert.zjdj, expert.groupdef2, expert.avic_major, expert.vaca_types, expert.isavic, expert.major_order, expert.pk_new_corp, expert.pk_dept, expert.pk_om_job, expert.out_corp, psndoc.pk_psncl, expert.pk_corp, psndoc.psncode from hr_expert expert left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.pk_psndoc where not exists (select expert_m.pk_hr_exper_old from mid_hr_expert expert_m where expert.pk_hr_exper = expert_m.pk_hr_exper_old and expert_m.pk_hr_exper_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_HR_EXPERT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and expert.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("expert", sql, corpArr);
		list = (ArrayList<Hr_expertVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hr_expertVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_hr_exper_old(list.get(i).getPk_hr_exper());
			if (list.get(i).getIsavic() == null || list.get(i).getIsavic().equals("")) {
				list.get(i).setIsavic("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hr_expertVO> getHr_expertSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hr_expertVO> list = new ArrayList<Hr_expertVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_HR_EXPERT) == null){
			sql.append("select expert.ts as ts_old, expert.pk_hr_exper, expert.exper_code, expert.exper_name, expert.exper_level, expert.exper_type, expert.zjdj, expert.groupdef2, expert.avic_major, expert.vaca_types, expert.isavic, expert.major_order, expert.pk_new_corp, expert.pk_dept, expert.pk_om_job, expert.out_corp, psndoc.pk_psncl, expert.pk_corp, psndoc.psncode from hr_expert expert inner join mid_hr_expert expert_m on expert.pk_hr_exper = expert_m.pk_hr_exper_old left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.pk_psndoc where expert.ts != expert_m.ts_old");
		}else{
			sql.append(sqlMap.get(Constants.MID_HR_EXPERT));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and expert.ts > '" + lastTime + "'");
		}
		sql = getExtCorp("expert", sql, corpArr);
		list = (ArrayList<Hr_expertVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hr_expertVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_hr_exper_old(list.get(i).getPk_hr_exper());
			if (list.get(i).getIsavic() == null || list.get(i).getIsavic().equals("")) {
				list.get(i).setIsavic("N");
			}
		}
		return list;
	}

	public List<Hr_expertVO> getHr_expertSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Hr_expertVO> list = new ArrayList<Hr_expertVO>();
		
		if (lastTime != null) {
			list.addAll(getHr_expertSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 
		
		list.addAll(getHr_expertSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
			
		return list;
	}
	/************************************* 院士专家子集－聘期管理增量数据 ************************************************/

	@SuppressWarnings("unchecked")
	public List<Expert_termVO> getExpert_termSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Expert_termVO> list = new ArrayList<Expert_termVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_EXPERT_TERM) == null){
			sql.append("select term.ts as ts_old, term.pk_expert_term, term.pk_hr_exper, term.begindate, term.enddate, term.glory_step, term.term_corp, term.is_term, term.recommend, term.poll, term.pass_poll, term.term_team, term.judge, term.treatment, term.card_code, term.subsidy, term.expel, term.groupdef1,term.groupdef2, term.groupdef3, term.groupdef5, term.groupdef6, expert.exper_code, psndoc.pk_psncl, psndoc.pk_corp from expert_term term inner join hr_expert expert on expert.pk_hr_exper = term.pk_hr_exper left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.exper_name where not exists (select term_m.pk_expert_term_old from mid_expert_term term_m where term.pk_expert_term = term_m.pk_expert_term_old and term_m.pk_expert_term_old is not null) ");
		}else{
			sql.append(sqlMap.get(Constants.MID_EXPERT_TERM));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and term.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_EXPERT_TERM) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("term", sql, corpArr);
		}
		list = (ArrayList<Expert_termVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Expert_termVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_expert_term_old(list.get(i).getPk_expert_term());
			if (list.get(i).getIs_term() == null || list.get(i).getIs_term().equals("")) {
				list.get(i).setIs_term("N");
			}
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Expert_termVO> getExpert_termSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Expert_termVO> list = new ArrayList<Expert_termVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_EXPERT_TERM) == null){
			sql.append("select term.ts as ts_old, term.pk_expert_term, term.pk_hr_exper, term.begindate, term.enddate, term.glory_step, term.term_corp, term.is_term, term.recommend, term.poll, term.pass_poll, term.term_team, term.judge, term.treatment, term.card_code, term.subsidy, term.expel, term.groupdef1,term.groupdef2, term.groupdef3, term.groupdef5, term.groupdef6, expert.exper_code, psndoc.pk_psncl, psndoc.pk_corp from expert_term term inner join mid_expert_term term_m on term.pk_expert_term = term_m.pk_expert_term_old inner join hr_expert expert on expert.pk_hr_exper = term.pk_hr_exper left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.exper_name where term.ts != term_m.ts_old");
		}else{
			sql.append(sqlMap.get(Constants.MID_EXPERT_TERM));
		}
		if (lastTime != null && !"".equals(lastTime)) {
			sql.append(" and term.ts > '" + lastTime + "'");
		}
		if(sqlMap.get(Constants.MID_EXPERT_TERM) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("term", sql, corpArr);
		}
		list = (ArrayList<Expert_termVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Expert_termVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_expert_term_old(list.get(i).getPk_expert_term());
			if (list.get(i).getIs_term() == null || list.get(i).getIs_term().equals("")) {
				list.get(i).setIs_term("N");
			}
		}
		return list;
	}

	public List<Expert_termVO> getExpert_termSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Expert_termVO> list = new ArrayList<Expert_termVO>();

		if (lastTime != null) {
			list.addAll(getExpert_termSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getExpert_termSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}
	/****************************************** 薪酬管理-发放总额 *****************************************/

	@SuppressWarnings("unchecked")
	public List<Wa_dataVO> getWa_dataSpikeAdd(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Wa_dataVO> list = new ArrayList<Wa_dataVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_WA_DATA) == null){
			sql.append(" select wa.ts as ts_old, wa.icheckflag, wa.ipartflag, wa.irecheckflag, wa.irecaculateflag, wa.istopflag, wa.itaxflag, wa.classid, wa.pk_wa_data, wa.psnid, wa.psnclid, wa.deptid, wa.cyear, wa.cperiod, wa.cnestyear, wa.cnestperiod, wa.d_11, wa.d_12, wa.d_13, wa.d_14, wa.f_1, wa.d_21, wa.d_22, wa.d_23, wa.d_24, wa.d_25, wa.d_26, wa.f_2, wa.f_3, wa.f_4,wa.redtotal, wa.nestdeptid, wa.nestpk_om_job, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode from wa_data wa inner join bd_psndoc psndoc on psndoc.pk_psndoc = wa.psnid where not exists (select wa_m.pk_wa_data_old from mid_wa_data wa_m where wa.pk_wa_data = wa_m.pk_wa_data_old and wa_m.pk_wa_data_old is not null) and wa.isextract = 'Y'");
			sql.append(" union ");
			sql.append(" select wa.ts as ts_old, wa.icheckflag, wa.ipartflag, wa.irecheckflag, wa.irecaculateflag, wa.istopflag, wa.itaxflag, wa.classid, wa.pk_wa_data, wa.psnid, wa.psnclid, wa.deptid, wa.cyear, wa.cperiod, wa.cnestyear, wa.cnestperiod, wa.d_11, wa.d_12, wa.d_13, wa.d_14, wa.f_1, wa.d_21, wa.d_22, wa.d_23, wa.d_24, wa.d_25, wa.d_26, wa.f_2, wa.f_3, wa.f_4,wa.redtotal, wa.nestdeptid, wa.nestpk_om_job, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode from wa_data wa inner join bd_psndoc psndoc on psndoc.pk_psndoc = wa.psnid inner join wa_waclass class on wa.classid = class.pk_wa_class and class.icollectflag = 0 inner join wa_periodstate state on class.pk_wa_class = state.classid and state.ipayoffflag = '1' inner join wa_period period on state.pk_periodset = period.pk_wa_period and wa.cyear = period.cyear and wa.cperiod = period.cperiod and period.cnestyear >= '2016' where not exists (select wa_m.pk_wa_data_old from mid_wa_data wa_m where wa.pk_wa_data = wa_m.pk_wa_data_old and wa_m.pk_wa_data_old is not null) and wa.isextract != 'Y' ");
			if (lastTime != null && !"".equals(lastTime)) {
				sql.append(" and state.ts > '" + lastTime + "'");
			}
		}else{
			sql.append(sqlMap.get(Constants.MID_WA_DATA));
			if (lastTime != null && !"".equals(lastTime)) {
				sql.append(" and wa.ts > '" + lastTime + "'");
			}
		}
		if(sqlMap.get(Constants.MID_WA_DATA) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("wa", sql, corpArr);
		}
		list = (ArrayList<Wa_dataVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Wa_dataVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_ADD);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_wa_data_old(list.get(i).getPk_wa_data());
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Wa_dataVO> getWa_dataSpikeEdit(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Wa_dataVO> list = new ArrayList<Wa_dataVO>();
		StringBuffer sql = new StringBuffer();
		if(sqlMap.get(Constants.MID_WA_DATA) == null){
			sql.append(" select wa.ts as ts_old, wa.classid, wa.icheckflag, wa.ipartflag,wa.irecheckflag, wa.irecaculateflag,wa.istopflag, wa.itaxflag, wa.pk_wa_data, wa.psnid,wa.psnclid, wa.deptid, wa.cyear, wa.cperiod, wa.cnestyear, wa.cnestperiod, wa.d_11, wa.d_12, wa.d_13, wa.d_14, wa.f_1, wa.d_21,wa.d_22, wa.d_23, wa.d_24, wa.d_25, wa.d_26,wa.f_2, wa.f_3, wa.f_4, wa.redtotal, wa.nestdeptid, wa.nestpk_om_job, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode from wa_data wa inner join bd_psndoc psndoc on psndoc.pk_psndoc = wa.psnid inner join mid_wa_data wa_m on wa.pk_wa_data = wa_m.pk_wa_data_old where wa.ts != wa_m.ts_old and wa.isextract = 'Y' ");
			sql.append(" union ");
			sql.append(" select wa.ts as ts_old, wa.classid, wa.icheckflag, wa.ipartflag,wa.irecheckflag, wa.irecaculateflag,wa.istopflag, wa.itaxflag, wa.pk_wa_data, wa.psnid,wa.psnclid, wa.deptid, wa.cyear, wa.cperiod, wa.cnestyear, wa.cnestperiod, wa.d_11, wa.d_12, wa.d_13, wa.d_14, wa.f_1, wa.d_21,wa.d_22, wa.d_23, wa.d_24, wa.d_25, wa.d_26,wa.f_2, wa.f_3, wa.f_4, wa.redtotal, wa.nestdeptid, wa.nestpk_om_job, psndoc.pk_psncl, psndoc.pk_corp, psndoc.psncode from wa_data wa inner join wa_waclass class on wa.classid=class.pk_wa_class inner join wa_periodstate state on class.pk_wa_class = state.classid and state.ipayoffflag = '1' inner join wa_period period on state.pk_periodset = period.pk_wa_period and wa.cyear = period.cyear and wa.cperiod = period.cperiod and period.cnestyear >='2016' inner join mid_wa_data wa_m on wa.pk_wa_data = wa_m.pk_wa_data_old inner join bd_psndoc psndoc on psndoc.pk_psndoc = wa.psnid where wa.ts != wa_m.ts_old and wa.isextract != 'Y' ");
			if (lastTime != null && !"".equals(lastTime)) {
				sql.append(" and state.ts > '" + lastTime + "'");
			}
		}else{
			sql.append(sqlMap.get(Constants.MID_WA_DATA));
			if (lastTime != null && !"".equals(lastTime)) {
				sql.append(" and wa.ts > '" + lastTime + "'");
			}
		}
		if(sqlMap.get(Constants.MID_WA_DATA) == null){
			sql = getExtCorp("psndoc", sql, corpArr);
		}else{
			sql = getExtCorp("wa", sql, corpArr);
		}
		list = (ArrayList<Wa_dataVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Wa_dataVO.class));
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setSpike_sign(BasicVO.SPIKE_EDIT);
			list.get(i).setTs_m(sysTime);
			list.get(i).setPk_wa_data_old(list.get(i).getPk_wa_data());
		}
		return list;
	}

	public List<Wa_dataVO> getWa_dataSpikeData(String lastTime, String sysTime, String[] corpArr, Map<String, String> sqlMap) throws BusinessException {
		List<Wa_dataVO> list = new ArrayList<Wa_dataVO>();

		if (lastTime != null) {
			list.addAll(getWa_dataSpikeEdit(lastTime, sysTime, corpArr, sqlMap));
		} 

		list.addAll(getWa_dataSpikeAdd(lastTime, sysTime, corpArr, sqlMap));
		 
		return list;
	}

	/***************************************** 抽取照片方法 ***********************************************/
	
	/**
	 * @Title: getSpikePhotoData
	 * @Description: 增量抽取照片
	 * @Time: 2016年10月26日 上午11:05:52
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<Bd_psnbasdocVO> getPhotoSpikeData(String lastTime) throws BusinessException {
		//最近抽取时间
		StringBuffer sql = new StringBuffer();
		sql.append("select psn.photo as newphoto, psn.psnname, psn.pk_psnbasdoc, psn.pk_corp, psn.pk_corp as bas_pkcorp, exp.photo from bd_psnbasdoc psn left join fbs_export_photo exp on psn.pk_psnbasdoc = exp.pk_psnbasdoc where not ( psn.photo is null and exp.photo is null)");
		if (lastTime!=null && !"".equals(lastTime)) {
			sql.append(" and psn.ts >= '" + lastTime + "'");
		}
		//查询结果：newphoto是员工的最新照片，photo是员工的记录表的照片
		List<Bd_psnbasdocVO> list = (ArrayList<Bd_psnbasdocVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_psnbasdocVO.class));
		List<Bd_psnbasdocVO> photo_list = new ArrayList<Bd_psnbasdocVO>();
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).getPhoto() != list.get(i).getNewphoto()){//新照片和旧照片不一样
				photo_list.add(list.get(i));
			}
		}
		return photo_list;
	}
	
	/***************************************** 公共方法 ***********************************************/
	private BaseDAO dao = null;

	/**
	 * @Title: getDao
	 * @Description: 获取Dao
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @return
	 */
	private BaseDAO getDao() {
		if (dao == null){
			dao = new BaseDAO();
			dao.setMaxRows(300000);
		}
	
		return dao;
	}

	/**
	 * @Title: getMaxTime
	 * @Description: 公用方法，获取中间表的最近操作时间
	 * @Author: 王凯强
	 * @Date: 2016年7月28日
	 * @param sql
	 * @return
	 * @throws BusinessException
	 */
	public String getMaxTime(String sql) throws BusinessException {
		return (String) getDao().executeQuery(sql, new ColumnProcessor());
	}

	/**
	 * @Title: getRecordNum
	 * @Description: 获取单张表的记录个数
	 * @Author: 王凯强
	 * @Date: 2016年7月29日
	 * @param sql
	 * @return
	 * @throws BusinessException
	 */
	public Integer getRecordNum(String sql) throws BusinessException {
		return Integer.parseInt(getDao().executeQuery(sql, new ColumnProcessor()).toString());
	}
	
	/**
	 * @Title: getLimitSql
	 * @Description: 拼接分页sql
	 * @Author: 王凯强
	 * @Time: 2016年11月15日 下午3:07:00
	 * @param sql_b
	 * @return
	 */
	private String getLimitSql(StringBuffer sql_b){
		return "select * from (select a.* , rownum rownum_ from (" + sql_b + ") a where rownum <= "+ ISpike.MAXROWS +") where rownum_ > 0";
	}
	
	/**
	 * @Title: getExtCorp
	 * @Description: 拼接按公司抽取sql
	 * @Author: 王凯强
	 * @Time: 2016年11月15日 下午3:07:14
	 * @param alias 表别名
	 * @param sql_b 原始sql
	 * @return
	 * @throws BusinessException
	 */
	private StringBuffer getExtCorp(String alias, StringBuffer sql_b, String[] corpArr) throws BusinessException{
		try {
			if(corpArr != null && corpArr.length > 1){//数组中含有默认的0001
				nc.bs.fbs.pub.TempTableDMO dmoTempTbl = new nc.bs.fbs.pub.TempTableDMO();
				String sTemp1 = dmoTempTbl.insertTempTable(corpArr, " compare", " pk_id ");
				sql_b.append(" and "+ alias +".pk_corp in "+ sTemp1 );
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
		
		return sql_b;
	}


	
}

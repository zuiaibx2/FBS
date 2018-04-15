package nc.bs.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.RuntimeEnv;
import nc.itf.export.file.IGetAllBSData;
import nc.jdbc.framework.processor.BeanListProcessor;
import nc.pub.Constants;
import nc.util.ExtFilenameFilter;
import nc.util.FileNameComparator;
import nc.util.FileUtil;
import nc.vo.bs.bd.Bd_deptdocVO;
import nc.vo.bs.bd.Bd_psnbasdocVO;
import nc.vo.bs.bd.Bd_psndocVO;
import nc.vo.bs.expert.Expert_termVO;
import nc.vo.bs.hi.Hi_psndoc_abroadVO;
import nc.vo.bs.hi.Hi_psndoc_deptchgVO;
import nc.vo.bs.hi.Hi_psndoc_dimissionVO;
import nc.vo.bs.hi.Hi_psndoc_eduVO;
import nc.vo.bs.hi.Hi_psndoc_encVO;
import nc.vo.bs.hi.Hi_psndoc_grpdef11VO;
import nc.vo.bs.hi.Hi_psndoc_grpdef14VO;
import nc.vo.bs.hi.Hi_psndoc_partylogVO;
import nc.vo.bs.hi.Hi_psndoc_punVO;
import nc.vo.bs.hi.Hi_psndoc_spetechVO;
import nc.vo.bs.hi.Hi_psndoc_techrankVO;
import nc.vo.bs.hi.Hi_psndoc_trainingVO;
import nc.vo.bs.hi.Hi_psndoc_workVO;
import nc.vo.bs.hr.Hr_expertVO;
import nc.vo.bs.hrldm.Hrldm_ldpsn_infoVO;
import nc.vo.bs.hrldm.Hrldm_psndoc_dutyVO;
import nc.vo.bs.hrldm.Hrldm_train_planVO;
import nc.vo.bs.om.Om_corp_workoutVO;
import nc.vo.bs.om.Om_corp_workout_bVO;
import nc.vo.bs.om.Om_dept_workoutVO;
import nc.vo.bs.om.Om_dutyVO;
import nc.vo.bs.om.Om_jobVO;
import nc.vo.bs.om.Om_job_workoutVO;
import nc.vo.bs.wa.Wa_dataVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @ClassName: GetAllBSDataImpl <b> 获取业务数据处理类 </b>
 *             创建日期:2016年7月27日 上午9:54:57
 * @author 王凯强
 * @version
 */
public class GetAllBSDataImpl implements IGetAllBSData {
	
	/**
	 * @field: series
	 * @Discription: 职务簇在集团bd_defdoclist中可能会变，需要及时维护
	 * 该属性在下面的方法中会用，用到的表有：bd_psndoc，om_duty,hi_psndoc_deptchg
	 */
	private String series = "HI000000000000000222";
	
	/************************************* 部门档案数据 ******************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getBd_deptdocData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select dept.innercode,\n" +
						"       dept.pk_deptdoc,\n" + 
						"       dept.pk_corp,\n" + 
						"       dept.deptcode,\n" + 
						"       dept.deptname,\n" + 
						"       dept.showorder,\n" + 
						"       dept.def1,\n" + 
						"       dept.createdate,\n" + 
						"       dept.pk_fathedept,\n" + 
						"       dept.deptduty,\n" + 
						"       dept.pk_psndoc,\n" + 
						"       dept.phone,\n" + 
						"       dept.pk_psndoc2,\n" + 
						"       dept.def2,\n" + 
						"       dept.memo,\n" + 
						"       dept.canceled,\n" + 
						"       dept.deptattr,\n" + 
						"       dept.hrcanceled,\n" + 
						"       dept.dr,\n" + 
						"       dept.isuseretail\n" + 
						"  from bd_deptdoc dept where 1=1 "
					);
	
		sql = getExtCorp("dept", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>)getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_deptdocVO.class));
		return list;
	}

	/************************************* 员工工作信息数据 ****************************************/


	@SuppressWarnings("unchecked")
	public List<SuperVO> getBd_psndocData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select\n" +
						"       psn.indocflag,\n" + 
						"       psn.pk_psnbasdoc,\n" + 
						"       psn.pk_psndoc,\n" + 
						"       psn.pk_corp,\n" + 
						"       psn.pk_psncl,\n" + 
						"       psn.psnclscope,\n" + 
						"       psn.psncode,\n" + 
						"       psn.psnname,\n" + 
						"       psn.pk_deptdoc,\n" + 
						"       psn.pk_om_job,\n" + 
						"       psn.jobseries,\n" + 
						"       psn.groupdef1,\n" + 
						"       psn.pk_dutyrank,\n" + 
						"       psn.dutyname,\n" + 
						"       psn.series,\n" + 
						"       psn.groupdef3,\n" + 
						"       psn.groupdef2,\n" + 
						"       psn.onpostdate,\n" + 
						"       psn.groupdef14,\n" + 
						"       psn.groupdef4,\n" + 
						"       psn.groupdef10,\n" + 
						"       psn.insource,\n" + 
						"       psn.outdutydate,\n" + 
						"       psn.groupdef12,\n" + 
						"       psn.groupdef11,\n" + 
						"       psn.regulardata,\n" + 
						"       psn.wastopdate,\n" + 
						"       psn.showorder\n" + 
						"  from bd_psndoc psn\n" + 
						" inner join bd_psnbasdoc basdoc on psn.pk_psnbasdoc = basdoc.pk_psnbasdoc\n" + 
						" where 1=1 "
						);
		sql = getExtCorp("psn", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_psndocVO.class));
		return list;
	}

	/****************************************** 人员基本信息数据 ***************************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getBd_psnbasdocData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();//先不查询, psn.photo
		sql.append(
				"select psn.nativeplace,\n" +
						"       psn.basgroupdef12,\n" + 
						"       psn.indocflag,\n" + 
						"       psn.pk_psnbasdoc,\n" + 
						"       psn.pk_corp,\n" + 
						"       psn.basgroupdef1,\n" + 
						"       psn.basgroupdef2,\n" + 
						"       psn.psnname,\n" + 
						"       psn.usedname,\n" + 
						"       psn.nationality,\n" + 
						"       psn.country,\n" + 
						"       psn.sex,\n" + 
						"       psn.id,\n" + 
						"       psn.birthdate,\n" + 
						"       psn.joinworkdate,\n" + 
						"       psn.joinsysdate,\n" + 
						"       psn.basgroupdef13,\n" + 
						"       psn.basgroupdef14,\n" + 
						"       psn.ssnum,\n" + 
						"       psn.penelauth,\n" + 
						"       psn.marital,\n" + 
						"       psn.health,\n" + 
						"       psn.bloodtype,\n" + 
						"       psn.characterrpr,\n" + 
						"       psn.permanreside,\n" + 
						"       psn.addr,\n" + 
						"       psn.postalcode,\n" + 
						"       psn.mobile,\n" + 
						"       psn.homephone,\n" + 
						"       psn.officephone,\n" + 
						"       psn.basgroupdef4,\n" + 
						"       psn.email,\n" + 
						"       psn.basgroupdef5,\n" + 
						"       psn.polity\n" + 
						"  from bd_psnbasdoc psn\n" + 
						" inner join bd_psndoc psndoc on psn.pk_psnbasdoc = psndoc.pk_psnbasdoc\n" + 
						"                            and psn.pk_corp = psndoc.pk_corp\n" + 
						" inner join bd_psncl psncl on psncl.pk_psncl = psndoc.pk_psncl\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psn", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Bd_psnbasdocVO.class));
		return list;
	}

	/****************************************** 岗位基本信息 *******************************************/


	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_jobData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select job.pk_om_job,\n" +
						"       job.pk_corp,\n" + 
						"       job.jobcode,\n" + 
						"       job.jobname,\n" + 
						"       job.builddate,\n" + 
						"       job.pk_deptdoc,\n" + 
						"       job.suporior,\n" + 
						"       job.pk_om_duty,\n" + 
						"       job.jobseries,\n" + 
						"       job.groupdef1,\n" + 
						"       job.groupdef2,\n" + 
						"       job.groupdef3,\n" + 
						"       job.groupdef4,\n" + 
						"       job.avicdef1,\n" + 
						"       job.worksumm,\n" + 
						"       job.createcorp,\n" + 
						"       job.isabort,\n" + 
						"       job.isdeptrespon\n" + 
						"  from om_job job\n" + 
						" where 1 = 1"
					);
		sql = getExtCorp("job", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_jobVO.class));
		return list;
	}
	/***************************************** 岗位编制信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_job_workoutData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select work.pk_om_job_workout,\n" +
						"       work.pk_corp,\n" + 
						"       work.pk_om_job,\n" + 
						"       work.cyear,\n" + 
						"       work.workout,\n" + 
						"       work.actualnum,\n" + 
						"       work.version\n" + 
						"  from om_job_workout work\n" + 
						" inner join om_job job on work.pk_om_job = job.pk_om_job\n" + 
						" where 1 = 1 "
					);
		sql = getExtCorp("work", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_job_workoutVO.class));
		return list;
	}
	/***************************************** 获取部门编制信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_dept_workoutData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select dept.pk_om_dept_workout,\n" +
						"       dept.pk_corp,\n" + 
						"       dept.pk_deptdoc,\n" + 
						"       dept.cyear,\n" + 
						"       dept.workout,\n" + 
						"       dept.actualnum,\n" + 
						"       dept.version\n" + 
						"  from om_dept_workout dept\n" + 
						" inner join bd_deptdoc deptdoc on dept.pk_deptdoc = deptdoc.pk_deptdoc\n" + 
						" where 1 = 1"
				);
		sql = getExtCorp("dept", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_dept_workoutVO.class));
		return list;
	}
	/***************************************** 获取单位编制信息数据数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_corp_workoutData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select corp.pk_om_corp_workout,\n" +
						"       corp.pk_corp,\n" + 
						"       corp.makecorp,\n" + 
						"       corp.cyear,\n" + 
						"       corp.workout,\n" + 
						"       corp.actualnum,\n" + 
						"       corp.pk_om_workout_type,\n" + 
						"       corp.stat,\n" + 
						"       corp.version\n" + 
						"  from om_corp_workout corp\n" + 
						" inner join bd_corp on corp.pk_corp = bd_corp.pk_corp\n" + 
						" where 1 = 1"
					);
		sql = getExtCorp("corp", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workoutVO.class));
		return list;
	}
	/***************************************** 获取单位编制子表数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_corp_workout_bData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select corp.pk_om_corp_workout_b,\n" +
						"       corp.pk_om_corp_workout,\n" + 
						"       corp.pk_ref_name,\n" + 
						"       corp.workout,\n" + 
						"       corp.workoutcount\n" + 
						"  from om_corp_workout_b corp\n" + 
						" inner join om_corp_workout corp_work on corp.pk_om_corp_workout =\n" + 
						"                                         corp_work.pk_om_corp_workout\n" + 
						" inner join bd_corp on corp_work.pk_corp = bd_corp.pk_corp\n" + 
						" where 1=1"
					);
		sql = getExtCorp("corp_work", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_corp_workout_bVO.class));
		return list;
	}
	/***************************************** 获取学历学位信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_eduData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"select edu.pk_psndoc_sub,\n" +
						"       edu.pk_psnbasdoc,\n" + 
						"       edu.pk_psndoc,\n" + 
						"       edu.begindate,\n" + 
						"       edu.enddate,\n" + 
						"       edu.school,\n" + 
						"       edu.vschooltype,\n" + 
						"       edu.groupdef9,\n" + 
						"       edu.vstudymode,\n" + 
						"       edu.groupdef11,\n" + 
						"       edu.education,\n" + 
						"       edu.groupdef12,\n" + 
						"       edu.lasteducation,\n" + 
						"       edu.educationctifcode,\n" + 
						"       edu.degree,\n" + 
						"       edu.groupdef2,\n" + 
						"       edu.groupdef3,\n" + 
						"       edu.vcertifcode,\n" + 
						"       edu.ddegreedate,\n" + 
						"       edu.vdegreeunit,\n" + 
						"       edu.edusystem,\n" + 
						"       edu.groupdef4,\n" + 
						"       edu.groupdef5,\n" + 
						"       edu.groupdef6,\n" + 
						"       edu.groupdef7,\n" + 
						"       edu.groupdef8,\n" + 
						"       edu.recordnum,\n" + 
						"       edu.lastflag,\n" + 
						"       psndoc.pk_psncl,\n" + 
						"       psndoc.pk_corp,\n" + 
						"       psndoc.psncode\n" + 
						"  from hi_psndoc_edu edu\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = edu.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1=1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_eduVO.class));
		return list;
	}
	/***************************************** 获取职务基本信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getOm_dutyData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select duty.createcorp,\n" +
						"       duty.pk_om_duty,\n" + 
						"       duty.pk_corp,\n" + 
						"       duty.dutycode,\n" + 
						"       duty.dutyname,\n" + 
						"       duty.dutyrank,\n" + 
						"       duty.series,\n" + 
						"       duty.vdutysumm\n" + 
						"  from om_duty duty\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("duty", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Om_dutyVO.class));
		return list;
	}
	/***************************************** 获取员工工作履历信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_workData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select work.pk_psndoc_sub,\n" +
						"       work.pk_psnbasdoc,\n" + 
						"       work.pk_psndoc,\n" + 
						"       work.begindate,\n" + 
						"       work.enddate,\n" + 
						"       work.workcorp,\n" + 
						"       work.workdept,\n" + 
						"       work.workpost,\n" + 
						"       work.vcertifier,\n" + 
						"       work.vcertiphone,\n" + 
						"       work.vdismismatter,\n" + 
						"       work.recordnum,\n" + 
						"       work.lastflag,\n" + 
						"       psndoc.pk_psncl,\n" + 
						"       psndoc.pk_corp,\n" + 
						"       psndoc.psncode\n" + 
						"  from hi_psndoc_work work\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = work.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_workVO.class));
		return list;
	}

	/***************************************** 获取员工培训信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_trainingData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select train.tra_mode,\n" +
						"       train.taketrm_method,\n" + 
						"       train.source_type,\n" + 
						"       train.indocflag,\n" + 
						"       train.pk_psndoc_sub,\n" + 
						"       train.pk_psnbasdoc,\n" + 
						"       train.pk_psndoc,\n" + 
						"       train.groupdef2,\n" + 
						"       train.vtra_act,\n" + 
						"       train.groupdef5,\n" + 
						"       train.begindate,\n" + 
						"       train.enddate,\n" + 
						"       train.groupdef1,\n" + 
						"       train.tra_time,\n" + 
						"       train.groupdef6,\n" + 
						"       train.trm_certif_name,\n" + 
						"       train.tra_mode_name,\n" + 
						"       train.groupdef4,\n" + 
						"       train.groupdef3,\n" + 
						"       train.certificate_date,\n" + 
						"       train.tra_content,\n" + 
						"       train.groupdef7,\n" + 
						"       train.tra_cost,\n" + 
						"       train.recordnum,\n" + 
						"       train.lastflag\n" + 
						"  from hi_psndoc_training train\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1=1"
						);
		sql = getExtCorp("train", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_trainingVO.class));
		return list;
	}
	/***************************************** 获取工人技术等级数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_techrankData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
			sql.append("select rank.pk_psndoc_sub,\n" +
							"       rank.pk_psnbasdoc,\n" + 
							"       rank.pk_psndoc,\n" + 
							"       rank.techdutyname,\n" + 
							"       rank.techlevelname,\n" + 
							"       rank.jdtype,\n" + 
							"       rank.arridate,\n" + 
							"       rank.approvecorp,\n" + 
							"       rank.rddate,\n" + 
							"       rank.jdzscode,\n" + 
							"       rank.pr_flag,\n" + 
							"       rank.prstartdate,\n" + 
							"       rank.jp_flag,\n" + 
							"       rank.jpstartdate,\n" + 
							"       rank.bsmark,\n" + 
							"       rank.czmark,\n" + 
							"       rank.recordnum,\n" + 
							"       rank.lastflag,\n" + 
							"       psndoc.pk_psncl,\n" + 
							"       psndoc.pk_corp,\n" + 
							"       psndoc.psncode\n" + 
							"  from hi_psndoc_techrank rank\n" + 
							" inner join bd_psndoc psndoc on psndoc.pk_psndoc = rank.pk_psndoc\n" + 
							" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
							"                                   basdoc.pk_psnbasdoc\n" + 
							" where 1 = 1"
							);
		sql = getExtCorp("rank", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_techrankVO.class));

		return list;
	}
	/***************************************** 获取专业技术职务数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_spetechData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
			sql.append("select tech.pk_psndoc_sub,\n" +
							"       tech.pk_psnbasdoc,\n" + 
							"       tech.pk_psndoc,\n" + 
							"       tech.ctechname,\n" + 
							"       tech.ctechduty,\n" + 
							"       tech.dengbegin,\n" + 
							"       tech.dengend,\n" + 
							"       tech.cengunit,\n" + 
							"       tech.cengspe,\n" + 
							"       tech.dindate,\n" + 
							"       tech.cincomeway,\n" + 
							"       tech.cprounit,\n" + 
							"       tech.czsbh,\n" + 
							"       tech.recordnum,\n" + 
							"       tech.lastflag,\n" + 
							"       tech.jp_flag,\n" + 
							"       tech.pr_flag\n" + 
							"  from hi_psndoc_spetech tech\n" + 
							" inner join bd_psndoc psndoc on psndoc.pk_psndoc = tech.pk_psndoc\n" + 
							" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
							"                                   basdoc.pk_psnbasdoc\n" + 
							" where 1=1"
							);
		sql = getExtCorp("tech", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_spetechVO.class));
		 
		return list;
	}
	/***************************************** 获取员工惩处信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_punData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select pun.pk_psndoc_sub,\n" +
						"       pun.pk_psnbasdoc,\n" + 
						"       pun.pk_psndoc,\n" + 
						"       pun.groupdef2,\n" + 
						"       pun.groupdef1,\n" + 
						"       pun.dpunishdate,\n" + 
						"       pun.groupdef3,\n" + 
						"       pun.vpunishorg,\n" + 
						"       pun.vpunishmeas,\n" + 
						"       pun.vpunishmatter,\n" + 
						"       pun.groupdef4,\n" + 
						"       pun.groupdef5,\n" + 
						"       pun.groupdef6,\n" + 
						"       pun.groupdef7,\n" + 
						"       pun.groupdef8,\n" + 
						"       pun.groupdef9,\n" + 
						"       pun.recordnum,\n" + 
						"       pun.lastflag\n" + 
						"  from hi_psndoc_pun pun\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = pun.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1");
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_punVO.class));
		return list;
	}
	/***************************************** 获取政治面貌信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_partylogData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select party.pk_psndoc_sub,\n" +
						"       party.pk_psnbasdoc,\n" + 
						"       party.pk_psndoc,\n" + 
						"       party.cpartyname,\n" + 
						"       party.dpartydate,\n" + 
						"       party.dpartyduedate,\n" + 
						"       party.cpartypsn,\n" + 
						"       party.cpartyunit,\n" + 
						"       party.groupdef2,\n" + 
						"       party.recordnum,\n" + 
						"       party.lastflag\n" + 
						"  from hi_psndoc_partylog party\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = party.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("party", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_partylogVO.class));
		return list;
	}
	/***************************************** 获取家庭成员海外背景信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_grpdef14Data(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select grp.pk_psndoc_sub,\n" +
						"       grp.pk_psnbasdoc,\n" + 
						"       grp.pk_psndoc,\n" + 
						"       grp.groupdef1,\n" + 
						"       grp.groupdef2,\n" + 
						"       grp.groupdef3,\n" + 
						"       grp.begindate,\n" + 
						"       grp.groupdef6,\n" + 
						"       grp.groupdef7,\n" + 
						"       grp.groupdef9,\n" + 
						"       grp.enddate,\n" + 
						"       grp.groupdef8,\n" + 
						"       grp.recordnum,\n" + 
						"       grp.lastflag\n" + 
						"  from hi_psndoc_grpdef14 grp\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_grpdef14VO.class));
		return list;
	}
	/***************************************** 获取知识产权信息数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_grpdef11Data(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select grp.pk_psndoc_sub,\n" +
						"       grp.pk_psnbasdoc,\n" + 
						"       grp.pk_psndoc,\n" + 
						"       grp.groupdef1,\n" + 
						"       grp.groupdef2,\n" + 
						"       grp.begindate,\n" + 
						"       grp.recordnum,\n" + 
						"       grp.lastflag\n" + 
						"  from hi_psndoc_grpdef11 grp\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = grp.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_grpdef11VO.class));
		return list;
	}
	/***************************************** 获取员工奖励信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_encData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select enc.pk_psndoc_sub,\n" +
						"       enc.pk_psnbasdoc,\n" + 
						"       enc.pk_psndoc,\n" + 
						"       enc.groupdef1,\n" + 
						"       enc.groupdef2,\n" + 
						"       enc.groupdef3,\n" + 
						"       enc.vencourorg,\n" + 
						"       enc.dencourdate,\n" + 
						"       enc.vencourmatter,\n" + 
						"       enc.vencourmeas,\n" + 
						"       enc.groupdef4,\n" + 
						"       enc.groupdef5,\n" + 
						"       enc.groupdef6,\n" + 
						"       enc.groupdef7,\n" + 
						"       enc.groupdef8,\n" + 
						"       enc.groupdef9,\n" + 
						"       enc.recordnum,\n" + 
						"       enc.lastflag\n" + 
						"  from hi_psndoc_enc enc\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = enc.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_encVO.class));

		return list;
	}
	/***************************************** 获取员工离职信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_dimissionData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select model.pk_psndoc_sub,\n" +
						"       model.pk_psnbasdoc,\n" + 
						"       model.pk_psndoc,\n" + 
						"       model.leavedate,\n" + 
						"       model.pkpostbefore,\n" + 
						"       model.psnclbefore,\n" + 
						"       model.psnclafter,\n" + 
						"       model.type,\n" + 
						"       model.pkdeptbefore,\n" + 
						"       model.pk_corpafter,\n" + 
						"       model.pkdeptafter,\n" + 
						"       model.towhere,\n" + 
						"       model.reason,\n" + 
						"       model.description,\n" + 
						"       model.salarystopdate,\n" + 
						"       model.welfarestopdate,\n" + 
						"       model.recordnum,\n" + 
						"       model.lastflag\n" + 
						"  from hi_psndoc_dimission model\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = model.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1");
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_dimissionVO.class));

		return list;
	}
	/***************************************** 获取员工任职信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_deptchgData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select chg.pk_psndoc_sub,\n" +
						"       chg.pk_psnbasdoc,\n" + 
						"       chg.pk_psndoc,\n" + 
						"       chg.begindate,\n" + 
						"       chg.enddate,\n" + 
						"       chg.poststat,\n" + 
						"       chg.pk_deptdoc,\n" + 
						"       chg.pk_jobserial,\n" + 
						"       chg.pk_postdoc,\n" + 
						"       chg.pk_om_duty,\n" + 
						"       chg.pk_dutyrank,\n" + 
						"       chg.posttype,\n" + 
						"       chg.jobtype,\n" + 
						"       chg.choldreason,\n" + 
						"       chg.deposetype,\n" + 
						"       chg.deposereason,\n" + 
						"       chg.preparetype,\n" + 
						"       chg.preparereason,\n" + 
						"       chg.preparenote,\n" + 
						"       chg.isreturn,\n" + 
						"       chg.avicdef1,\n" + 
						"       chg.recordnum,\n" + 
						"       chg.lastflag,\n" + 
						"       chg.bendflag,\n" + 
						"       chg.iscalovertime,\n" + 
						
						/*************加上公司和人员类别************/
						"       chg.pk_corp,\n" + 
						"       chg.pk_psncl,\n" + 
						/****************END********************/
						
						
						"       chg.tbm_prop\n" + 
						"  from hi_psndoc_deptchg chg\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = chg.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("chg", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_deptchgVO.class));
		return list;
	}
	/***************************************** 获取员工涉外经历信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHi_psndoc_abroadData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select abroad.pk_psndoc_sub,\n" +
						"       abroad.pk_psnbasdoc,\n" + 
						"       abroad.pk_psndoc,\n" + 
						"       abroad.groupdef2,\n" + 
						"       abroad.cabroadarea,\n" + 
						"       abroad.dabroaddate,\n" + 
						"       abroad.groupdef3,\n" + 
						"       abroad.dabroadreturn,\n" + 
						"       abroad.cabroadunit,\n" + 
						"       abroad.cabroadgroup,\n" + 
						"       abroad.groupdef4,\n" + 
						"       abroad.groupdef5,\n" + 
						"       abroad.cabroadout,\n" + 
						"       abroad.cabroadoutlay,\n" + 
						"       abroad.cabroadpro,\n" + 
						"       abroad.dabroadprodate,\n" + 
						"       abroad.cabroadnumber,\n" + 
						"       abroad.recordnum,\n" + 
						"       abroad.lastflag\n" + 
						"  from hi_psndoc_abroad abroad\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = abroad.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hi_psndoc_abroadVO.class));
		return list;
	}
	/***************************************** 获取干部信息主集-干部分类信息数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHrldm_ldpsn_infoData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select info.pk_psndoc_sub,\n" +
						"       info.pk_psnbasdoc,\n" + 
						"       info.pk_psndoc,\n" + 
						"       info.pk_defdoc,\n" + 
						"       info.ld_type,\n" + 
						"       info.showorder,\n" + 
						"       info.memo,\n" + 
						"       info.begindate,\n" + 
						"       info.enddate,\n" + 
						"       info.recordnum,\n" + 
						"       info.lastflag\n" + 
						"  from hrldm_ldpsn_info info\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = info.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("info", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_ldpsn_infoVO.class));
		return list;
	}
	/***************************************** 获取领导人员职务信息子集数据 ***********************************************/

	@SuppressWarnings("unchecked")
	public List<SuperVO> getHrldm_psndoc_dutyData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select psndoc.pk_psndoc_sub,\n" +
						"       psndoc.pk_psnbasdoc,\n" + 
						"       psndoc.pk_psndoc,\n" + 
						"       psndoc.groupdef1,\n" + 
						"       psndoc.groupdef2,\n" + 
						"       psndoc.groupdef3,\n" + 
						"       psndoc.groupdef4,\n" + 
						"       psndoc.pk_hold_corp,\n" + 
						"       psndoc.pk_hold_dept,\n" + 
						"       psndoc.pk_om_duty,\n" + 
						"       psndoc.groupdef5,\n" + 
						"       psndoc.pk_dutylevel,\n" + 
						"       psndoc.pk_dutytype,\n" + 
						"       psndoc.groupdef6,\n" + 
						"       psndoc.pk_holdtype,\n" + 
						"       psndoc.holddate,\n" + 
						"       psndoc.holdnumber,\n" + 
						"       psndoc.holdjob,\n" + 
						"       psndoc.holdunit,\n" + 
						"       psndoc.groupdef7,\n" + 
						"       psndoc.groupdef8,\n" + 
						"       psndoc.deposeunit,\n" + 
						"       psndoc.deposedate,\n" + 
						"       psndoc.deposenumber,\n" + 
						"       psndoc.pk_holdreason,\n" + 
						"       psndoc.recordnum,\n" + 
						"       psndoc.lastflag\n" + 
						"  from hrldm_psndoc_duty psndoc\n" + 
						" inner join bd_psndoc psn on psn.pk_psndoc = psndoc.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_psndoc_dutyVO.class));

		return list;
	}
	/***************************************** 获取后备干部信息子集数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHrldm_train_planData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select train.pk_psndoc_sub,\n" +
						"       train.pk_psnbasdoc,\n" + 
						"       train.pk_psndoc,\n" + 
						"       train.groupdef1,\n" + 
						"       train.groupdef2,\n" + 
						"       train.train_target,\n" + 
						"       train.groupdef3,\n" + 
						"       train.train_object,\n" + 
						"       train.groupdef4,\n" + 
						"       train.begindate,\n" + 
						"       train.groupdef5,\n" + 
						"       train.groupdef6,\n" + 
						"       train.groupdef7,\n" + 
						"       train.train_step,\n" + 
						"       train.recordnum,\n" + 
						"       train.lastflag\n" + 
						"  from hrldm_train_plan train\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = train.pk_psndoc\n" + 
						" inner join bd_psnbasdoc basdoc on psndoc.pk_psnbasdoc =\n" + 
						"                                   basdoc.pk_psnbasdoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hrldm_train_planVO.class));

		return list;
	}
	/***************************************** 专业人才管理-院士专家信息维护数据 ***********************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getHr_expertData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select expert.pk_hr_exper,\n" +
						"       expert.exper_code,\n" + 
						"       expert.exper_name,\n" + 
						"       expert.exper_level,\n" + 
						"       expert.exper_type,\n" + 
						"       expert.zjdj,\n" + 
						"       expert.groupdef2,\n" + 
						"       expert.avic_major,\n" + 
						"       expert.vaca_types,\n" + 
						"       expert.isavic,\n" + 
						"       expert.major_order,\n" + 
						"       expert.pk_new_corp,\n" + 
						"       expert.pk_dept,\n" + 
						"       expert.pk_om_job,\n" + 
						"       expert.out_corp\n" + 
						"  from hr_expert expert\n" + 
						"  left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.pk_psndoc\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("expert", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Hr_expertVO.class));

		return list;
	}
	/************************************* 院士专家子集－聘期管理数据 ************************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getExpert_termData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select term.pk_expert_term,\n" +
						"       term.pk_hr_exper,\n" + 
						"       term.begindate,\n" + 
						"       term.enddate,\n" + 
						"       term.glory_step,\n" + 
						"       term.term_corp,\n" + 
						"       term.is_term,\n" + 
						"       term.recommend,\n" + 
						"       term.poll,\n" + 
						"       term.pass_poll,\n" + 
						"       term.term_team,\n" + 
						"       term.judge,\n" + 
						"       term.treatment,\n" + 
						"       term.card_code,\n" + 
						"       term.subsidy,\n" + 
						"       term.expel,\n" + 
						"       term.groupdef1,\n" + 
						"       term.groupdef2,\n" + 
						"       term.groupdef3,\n" + 
						"       term.groupdef5,\n" + 
						"       term.groupdef6\n" + 
						"  from expert_term term\n" + 
						" inner join hr_expert expert on expert.pk_hr_exper = term.pk_hr_exper\n" + 
						"  left join bd_psndoc psndoc on psndoc.pk_psndoc = expert.exper_name\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Expert_termVO.class));
		return list;
	}
	/****************************************** 薪酬管理-发放总额 *****************************************/
	@SuppressWarnings("unchecked")
	public List<SuperVO> getWa_dataData(String[] corpArr) throws BusinessException {
		StringBuffer sql = new StringBuffer();
		sql.append("select wa.icheckflag,\n" +
						"       wa.ipartflag,\n" + 
						"       wa.irecheckflag,\n" + 
						"       wa.irecaculateflag,\n" + 
						"       wa.istopflag,\n" + 
						"       wa.itaxflag,\n" + 
						"       wa.classid,\n" + 
						"       wa.pk_wa_data,\n" + 
						"       wa.psnid,\n" + 
						"       wa.psnclid,\n" + 
						"       wa.deptid,\n" + 
						"       wa.cyear,\n" + 
						"       wa.cperiod,\n" + 
						"       wa.cnestyear,\n" + 
						"       wa.cnestperiod,\n" + 
						"       wa.d_11,\n" + 
						"       wa.d_12,\n" + 
						"       wa.d_13,\n" + 
						"       wa.d_14,\n" + 
						"       wa.f_1,\n" + 
						"       wa.d_21,\n" + 
						"       wa.d_22,\n" + 
						"       wa.d_23,\n" + 
						"       wa.d_24,\n" + 
						"       wa.d_25,\n" + 
						"       wa.d_26,\n" + 
						"       wa.f_2,\n" + 
						"       wa.f_3,\n" + 
						"       wa.f_4,\n" + 
						"       wa.redtotal,\n" + 
						"       wa.nestdeptid,\n" + 
						"       wa.nestpk_om_job\n" + 
						"  from wa_data wa\n" + 
						" inner join bd_psndoc psndoc on psndoc.pk_psndoc = wa.psnid\n" + 
						" where 1 = 1"
						);
		sql = getExtCorp("psndoc", sql, corpArr);
		List<SuperVO> list = (List<SuperVO>) getDao().executeQuery(sql.toString(), new BeanListProcessor(Wa_dataVO.class));
//		List<Wa_dataVO> list = (ArrayList<Wa_dataVO>) getDao().executeQuery(getLimitSql(sql), new BeanListProcessor(Wa_dataVO.class));
		return list;
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
	 * @Title: getLimitSql
	 * @Description: 拼接分页sql
	 * @Author: 王凯强
	 * @Time: 2016年11月15日 下午3:07:00
	 * @param sql_b
	 * @return
	 */
//	private String getLimitSql(StringBuffer sql_b){
//		return "select * from (select a.* , rownum rownum_ from (" + sql_b + ") a where rownum <= "+ IGetAllBSData.MAXROWS +") where rownum_ > 0";
//	}
	
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
			if(corpArr != null && corpArr.length > 0){//数组中含有默认的0001
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

	/**
	 * 获得nchome下视图的路径
	 */
	public String getWorkingDirPath() {
		String Path_sqls = "modules"+ Constants.SEP +"fbsxj"+ Constants.SEP +"cfgs"+ Constants.SEP +"sqls"+ 
				Constants.SEP +"ncehr"+ Constants.SEP +"57"+ Constants.SEP +"oracle"+ 
				Constants.SEP +"011view_bs" + Constants.SEP;
		return RuntimeEnv.getInstance().getNCHome() + Constants.SEP + Path_sqls;
	}
	
	public List<String> getAllCreateBSSqls() throws BusinessException {
		String scriptFolderPath = getWorkingDirPath();
		File viewsFolder  = new File(scriptFolderPath);
		if (viewsFolder.exists())
		{
			File[] sqlFiles = viewsFolder.listFiles(new ExtFilenameFilter(".sql"));
			if (sqlFiles == null || sqlFiles.length == 0)
			{
				return null;
			}
			
			Arrays.sort(sqlFiles, new FileNameComparator());
			
			// 创建表结构
			List<String> createsqls = new ArrayList<String>();
			for (int i = 0; i<sqlFiles.length; i++) {
				String createsql = FileUtil.readSqlFileContent(sqlFiles[i]);
				createsqls.add(createsql);
			}
			return createsqls;
		} else {
			throw new BusinessException("视图目录：" + viewsFolder.getAbsolutePath() + "下不存在视图文件!");
		}
	}

	/**
	 * @Title: getSpikeData
	 * @Description: 根据条件获取中间表数据
	 * @Author: 王凯强
	 * @Time: 2016年10月13日 上午11:32:59
	 * @param clazz
	 * @param whereStr
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	public List<SuperVO> getSpikeData(Class<?> clazz, String whereStr) throws BusinessException {
		List<SuperVO> list = new ArrayList<SuperVO>();
		try {
			SuperVO superVO= (SuperVO) clazz.newInstance();
			String sql =null;
			String querySql= getQuerySql(superVO, whereStr);
			int i = 0;
			List<SuperVO> voList = new ArrayList<SuperVO>();
			while(true)
			{
				sql=getLimitSql(querySql,i);
				
				voList.clear();
				voList = (List<SuperVO>)getDao().executeQuery(sql, new BeanListProcessor(superVO.getClass()));
				list.addAll(voList);
				if(voList.size()<MAXROWS){
					break;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<SuperVO> getBSDataByPage(Class<?> clazz, String whereStr,int i) throws BusinessException {
		List<SuperVO> list = new ArrayList<SuperVO>();
		try {
			SuperVO superVO= (SuperVO) clazz.newInstance();
			String sql =null;
			String querySql= getQuerySql(superVO, whereStr);
			sql=getLimitSql(querySql,i);
			List<SuperVO> voList = (List<SuperVO>)getDao().executeQuery(sql, new BeanListProcessor(superVO.getClass()));
			list.addAll(voList);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(e);
		}
		return list;
	}
	
	private String getLimitSql(String sql_b,int rownum){
		return "select * from (select a.* , rownum rownum_ from (" + sql_b + ") a where rownum <="+ MAXROWS*(rownum+1)+") where rownum_ > "+rownum*MAXROWS;//MAXROWS
	}
	
	private String getQuerySql(SuperVO vo,String whereStr){
		StringBuffer sb = new StringBuffer("select ");
		String[] fields = vo.getAttributeNames(); 
		String tableName = vo.getTableName();
		String strtemp = null;
		for (int i = 0; i < fields.length - 1; i++) {
			strtemp = fields[i];
			if (isJump(tableName,strtemp)) {
				continue;
			}
			sb.append(strtemp + ",");
		}
		sb.append(fields[fields.length-1]);
		sb.append(" from ");
		sb.append( tableName +" where "+whereStr);
		return sb.toString();
	}

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
		return false;
	}
	
}

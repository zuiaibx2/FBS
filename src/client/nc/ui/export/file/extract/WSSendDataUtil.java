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
 * @ClassName: WSSendDataUtil <b> webservice传输数据工具类 </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期: 2016年11月7日 上午11:54:33
 * @Author 王凯强
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
	 * @Description: 数据传输入口
	 * @Author: 王凯强
	 * @Time: 2016年11月7日 下午2:32:56
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
			// 校验补丁版本
			IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator.getInstance().lookup(IFbsDataFileService.class.getName());
			String version = ifdfService.getToolVersion();
			String result = getWsService().checkToolVersion(version);
			if (result != null && !"".equals(result)) {
				throw new BusinessException(result);
			}
			// 校验数据版本
			String[] pkCorps = expdbutil.getPkCorps();
			result = getWsService().checkWsVersion(getOldVersion(pkCorps, lastTime));
			if (result != null && !"".equals(result)) {
				throw new BusinessException(result);
			}
			// 获取数据
			Map<String, List<?>> map = getData(lastTime);

			// 传送数据
			FbsDataFileItemVO[] bvos = sendData(logvos, map);

			// 保存日志
			ifdfService.saveLogVO(getDataFileVO(lastTime, nowtime), bvos, expdbutil.getExtTime(nowtime, lastTime));

			// 修改集团版本
			getWsService().insertWSVersion(getNewVersion(pkCorps, nowtime));
			// 进度条进度
			ProcessLine.addValueProcess(58, "传输完成。");
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
	 * @Description: 数据传输日志
	 * @Author: 王凯强
	 * @Time: 2016年12月13日 下午1:36:42
	 * @param lastTime
	 * @param nowtime
	 * @return
	 */
	private FbsDatafileVO getDataFileVO(String lastTime, String nowtime) {
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// 默认当前登陆人
		dataFileVO.setPk_corp(Global.getPkGroup());// 默认当前登陆公司
		dataFileVO.setOperate_time(new UFDateTime(nowtime));// 操作时间
		dataFileVO.setIssuccess(UFBoolean.TRUE);
		dataFileVO.setIsall(lastTime == null ? UFBoolean.TRUE : UFBoolean.FALSE);
		dataFileVO.setIsspike(lastTime != null ? UFBoolean.TRUE : UFBoolean.FALSE);
		dataFileVO.setStart_date(new UFDateTime(lastTime));
		dataFileVO.setVbillstatus(Integer.valueOf(8));// 抽取数据结束时间

		dataFileVO.setVmemo(Constants.OPT_TYPE_SEND);
		return dataFileVO;
	}

	/**
	 * @Title: getData
	 * @Description: 获取数据（此方法中添加校验数据大小范围，不超过2M数据，暂时未添加）
	 * @Author: 王凯强
	 * @Time: 2016年12月13日 下午1:41:20
	 * @param lasttime
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, List<?>> getData(String lasttime) throws BusinessException {
		StringBuffer whereBuffer = new StringBuffer(" 1=1 ");

		if (lasttime != null) {// 增量
			whereBuffer.append(" and ts_m > '" + lasttime + "'");
		}
		String whereStr = whereBuffer.toString();
		int index = 0;
		// 根据查询条件查询本地28张表数据
		Map<String, List<?>> map = new HashMap<String, List<?>>();
		/************************************ 1.部门档案 ************************************/
		ProcessLine.addDefaultProcess("正在获取【部门档案】数据......");
		List<Bd_deptdocVO> deptdoc_list = getSendService().getBd_deptdocData(whereStr);
		map.put(Constants.MID_BD_DEPTDOC, deptdoc_list);
		index += deptdoc_list.size();
		checkDataSize(index);

		/************************************ 2.岗位基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【岗位基本信息】数据......");
		List<Om_jobVO> omjob_list = getSendService().getOm_jobData(whereStr);
		map.put(Constants.MID_OM_JOB, omjob_list);
		index += omjob_list.size();
		checkDataSize(index);

		/************************************ 3.职务基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【职务基本信息】数据......");
		List<Om_dutyVO> omduty_list = getSendService().getOm_dutyData(whereStr);
		map.put(Constants.MID_OM_DUTY, omduty_list);
		index += omduty_list.size();
		checkDataSize(index);

		/************************************ 4.单位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【单位编制信息】数据......");
		List<Om_corp_workoutVO> corpworkout_list = getSendService().getOm_corp_workoutData(whereStr);
		map.put(Constants.MID_OM_CORP_WORKOUT, corpworkout_list);
		index += corpworkout_list.size();
		checkDataSize(index);

		/************************************ 5.单位编制子表 ************************************/
		ProcessLine.addDefaultProcess("正在获取【单位编制子表】数据......");
		List<Om_corp_workout_bVO> corpworkoutb_list = getSendService().getOm_corp_workout_bData(whereStr);
		map.put(Constants.MID_OM_CORP_WORKOUT_B, corpworkoutb_list);
		index += corpworkoutb_list.size();
		checkDataSize(index);

		/************************************ 6.部门编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【部门编制信息】数据......");
		List<Om_dept_workoutVO> deptworkout_list = getSendService().getOm_dept_workoutData(whereStr);
		map.put(Constants.MID_OM_DEPT_WORKOUT, deptworkout_list);
		index += deptworkout_list.size();
		checkDataSize(index);

		/************************************ 7.岗位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【岗位编制信息】数据......");
		List<Om_job_workoutVO> jobworkout_list = getSendService().getOm_job_workoutData(whereStr);
		map.put(Constants.MID_OM_JOB_WORKOUT, jobworkout_list);
		index += jobworkout_list.size();
		checkDataSize(index);

		/************************************ 8.人员基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【人员基本信息】数据......");
		List<Bd_psnbasdocVO> psnbasdoc_list = getSendService().getBd_psnbasdocData(whereStr);
		map.put(Constants.MID_BD_PSNBASDOC, psnbasdoc_list);
		index += psnbasdoc_list.size();
		checkDataSize(index);

		/************************************ 9.员工工作信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工工作信息】数据......");
		List<Bd_psndocVO> psndoc_list = getSendService().getBd_psndocData(whereStr);
		map.put(Constants.MID_BD_PSNDOC, psndoc_list);
		index += psndoc_list.size();
		checkDataSize(index);

		/************************************ 10.员工任职信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工任职信息】数据......");
		List<Hi_psndoc_deptchgVO> deptchg_list = getSendService().getHi_psndoc_deptchgData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_DEPTCHG, deptchg_list);
		index += deptchg_list.size();
		checkDataSize(index);

		/************************************ 11.政治面貌信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【政治面貌信息】数据......");
		List<Hi_psndoc_partylogVO> partylog_list = getSendService().getHi_psndoc_partylogData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_PARTYLOG, partylog_list);
		index += partylog_list.size();
		checkDataSize(index);

		/************************************ 12.学历学位信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【学历学位信息】数据......");
		List<Hi_psndoc_eduVO> edu_ist = getSendService().getHi_psndoc_eduData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_EDU, edu_ist);
		index += edu_ist.size();
		checkDataSize(index);

		/************************************ 13.家庭成员海外背景信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【家庭成员海外背景信息】数据......");
		List<Hi_psndoc_grpdef14VO> grpdef14_list = getSendService().getHi_psndoc_grpdef14Data(whereStr);
		map.put(Constants.MID_HI_PSNDOC_GRPDEF14, grpdef14_list);
		index += grpdef14_list.size();
		checkDataSize(index);

		/************************************ 14.员工工作履历信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工工作履历信息】数据......");
		List<Hi_psndoc_workVO> work_list = getSendService().getHi_psndoc_workData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_WORK, work_list);
		index += work_list.size();
		checkDataSize(index);

		/************************************ 15.员工涉外经历信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工涉外经历信息】数据......");
		List<Hi_psndoc_abroadVO> abroad_list = getSendService().getHi_psndoc_abroadData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_ABROAD, abroad_list);
		index += abroad_list.size();
		checkDataSize(index);

		/************************************ 16.员工奖励信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工奖励信息】数据......");
		List<Hi_psndoc_encVO> enc_list = getSendService().getHi_psndoc_encData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_ENC, enc_list);
		index += enc_list.size();
		checkDataSize(index);

		/************************************ 17.员工惩处信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工惩处信息】数据......");
		List<Hi_psndoc_punVO> pun_list = getSendService().getHi_psndoc_punData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_PUN, pun_list);
		index += pun_list.size();
		checkDataSize(index);

		/************************************ 18.员工培训信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工培训信息】数据......");
		List<Hi_psndoc_trainingVO> training_list = getSendService().getHi_psndoc_trainingData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_TRAINING, training_list);
		index += training_list.size();
		checkDataSize(index);

		/************************************ 19.专业技术职务 ************************************/
		ProcessLine.addDefaultProcess("正在获取【专业技术职务】数据......");
		List<Hi_psndoc_spetechVO> spetech_list = getSendService().getHi_psndoc_spetechData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_SPETECH, spetech_list);
		index += spetech_list.size();
		checkDataSize(index);

		/************************************ 20.工人技术等级 ************************************/
		ProcessLine.addDefaultProcess("正在获取【工人技术等级】数据......");
		List<Hi_psndoc_techrankVO> techrank_list = getSendService().getHi_psndoc_techrankData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_TECHRANK, techrank_list);
		index += techrank_list.size();
		checkDataSize(index);

		/************************************ 21.知识产权信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【知识产权信息】数据......");
		List<Hi_psndoc_grpdef11VO> grpdef11_list = getSendService().getHi_psndoc_grpdef11Data(whereStr);
		map.put(Constants.MID_HI_PSNDOC_GRPDEF11, grpdef11_list);
		index += grpdef11_list.size();
		checkDataSize(index);

		/************************************ 22.员工离职信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【员工离职信息】数据......");
		List<Hi_psndoc_dimissionVO> dimission_list = getSendService().getHi_psndoc_dimissionData(whereStr);
		map.put(Constants.MID_HI_PSNDOC_DIMISSION, dimission_list);
		index += dimission_list.size();
		checkDataSize(index);

		/************************************ 23.干部信息主集-干部分类信息 ************************************/
		ProcessLine.addDefaultProcess("正在获取【干部信息主集-干部分类信息】数据......");
		List<Hrldm_ldpsn_infoVO> psndocinfo_list = getSendService().getHrldm_ldpsn_infoData(whereStr);
		map.put(Constants.MID_HRLDM_LDPSN_INFO, psndocinfo_list);
		index += psndocinfo_list.size();
		checkDataSize(index);

		/************************************ 24.领导人员职务信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在获取【领导人员职务信息子集】数据......");
		List<Hrldm_psndoc_dutyVO> psndocduty_list = getSendService().getHrldm_psndoc_dutyData(whereStr);
		map.put(Constants.MID_HRLDM_PSNDOC_DUTY, psndocduty_list);
		index += psndocduty_list.size();
		checkDataSize(index);

		/************************************ 25.后备干部信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在获取【后备干部信息子集】数据......");
		List<Hrldm_train_planVO> trainplan_list = getSendService().getHrldm_train_planData(whereStr);
		map.put(Constants.MID_HRLDM_TRAIN_PLAN, trainplan_list);
		index += trainplan_list.size();
		checkDataSize(index);

		/************************************ 26.专业人才管理-院士专家信息维护 ************************************/
		ProcessLine.addDefaultProcess("正在获取【专业人才管理-院士专家信息维护】数据......");
		List<Hr_expertVO> expert_list = getSendService().getHr_expertData(whereStr);
		map.put(Constants.MID_HR_EXPERT, expert_list);
		index += expert_list.size();
		checkDataSize(index);

		/************************************ 27.院士专家子集－聘期管理 ************************************/
		ProcessLine.addDefaultProcess("正在获取【院士专家子集－聘期管理】数据......");
		List<Expert_termVO> term_list = getSendService().getExpert_termData(whereStr);
		map.put(Constants.MID_EXPERT_TERM, term_list);
		index += term_list.size();
		checkDataSize(index);

		/************************************ 9.薪酬管理-发放总额 ************************************/
		ProcessLine.addDefaultProcess("正在获取【薪酬管理-发放总额】数据......");
		List<Wa_dataVO> wa_list = getSendService().getWa_dataData(whereStr);
		map.put(Constants.MID_WA_DATA, wa_list);
		index += wa_list.size();
		checkDataSize(index);

		if (index == 0) {
			throw new BusinessException("没有获取到符合条件的数据,请检查确认！");
		}
		return map;
	}

	private void checkDataSize(int count) throws BusinessException {
		if (count > MAX_SIZE) {
			throw new BusinessException("数据量太大，本功能支持最多传送" + MAX_SIZE + "条数据，请点击【摆渡】->【抽取数据】按钮!");
		}
	}

	/**
	 * @Title: sendData
	 * @Description: 调用webservice接口传送数据
	 * @Author: 王凯强
	 * @Time: 2016年12月13日 下午1:42:35
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
		/************************************ 1.部门档案 ************************************/
		ProcessLine.addDefaultProcess("正在传输【部门档案】数据......");
		List<Bd_deptdocVO> deptdoc_list = (List<Bd_deptdocVO>) map.get(Constants.MID_BD_DEPTDOC);
		result = getWsService().writeBd_deptdoc(deptdoc_list.toArray(new Bd_deptdocVO[deptdoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "部门档案", deptdoc_list.size());

		/************************************ 2.岗位基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【岗位基本信息】数据......");
		List<Om_jobVO> omjob_list = (List<Om_jobVO>) map.get(Constants.MID_OM_JOB);
		result = getWsService().writeOm_job(omjob_list.toArray(new Om_jobVO[omjob_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "岗位基本信息", omjob_list.size());

		/************************************ 3.职务基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【职务基本信息】数据......");
		List<Om_dutyVO> omduty_list = (List<Om_dutyVO>) map.get(Constants.MID_OM_DUTY);
		result = getWsService().writeOm_duty(omduty_list.toArray(new Om_dutyVO[omduty_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "职务基本信息", omduty_list.size());

		/************************************ 4.单位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【单位编制信息】数据......");
		List<Om_corp_workoutVO> corpworkout_list = (List<Om_corp_workoutVO>) map.get(Constants.MID_OM_CORP_WORKOUT);
		result = getWsService().writeOm_corp_workout(corpworkout_list.toArray(new Om_corp_workoutVO[corpworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "单位编制信息", corpworkout_list.size());

		/************************************ 5.单位编制子表 ************************************/
		ProcessLine.addDefaultProcess("正在传输【单位编制子表】数据......");
		List<Om_corp_workout_bVO> corpworkoutb_list = (List<Om_corp_workout_bVO>) map.get(Constants.MID_OM_CORP_WORKOUT_B);
		result = getWsService().writeOm_corp_workout_b(corpworkoutb_list.toArray(new Om_corp_workout_bVO[corpworkoutb_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "单位编制子表", corpworkoutb_list.size());

		/************************************ 6.部门编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【部门编制信息】数据......");
		List<Om_dept_workoutVO> deptworkout_list = (List<Om_dept_workoutVO>) map.get(Constants.MID_OM_DEPT_WORKOUT);
		result = getWsService().writeOm_dept_workout(deptworkout_list.toArray(new Om_dept_workoutVO[deptworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "部门编制信息", deptworkout_list.size());

		/************************************ 7.岗位编制信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【岗位编制信息】数据......");
		List<Om_job_workoutVO> jobworkout_list = (List<Om_job_workoutVO>) map.get(Constants.MID_OM_JOB_WORKOUT);
		result = getWsService().writeOm_job_workout(jobworkout_list.toArray(new Om_job_workoutVO[jobworkout_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "岗位编制信息", jobworkout_list.size());

		/************************************ 8.人员基本信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【人员基本信息】数据......");
		List<Bd_psnbasdocVO> psnbasdoc_list = (List<Bd_psnbasdocVO>) map.get(Constants.MID_BD_PSNBASDOC);
		result = getWsService().writeBd_psnbasdoc(psnbasdoc_list.toArray(new Bd_psnbasdocVO[psnbasdoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "人员基本信息", psnbasdoc_list.size());

		/************************************ 9.员工工作信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工工作信息】数据......");
		List<Bd_psndocVO> psndoc_list = (List<Bd_psndocVO>) map.get(Constants.MID_BD_PSNDOC);
		result = getWsService().writeBd_psndoc(psndoc_list.toArray(new Bd_psndocVO[psndoc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工工作信息", psndoc_list.size());

		/************************************ 10.员工任职信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工任职信息】数据......");
		List<Hi_psndoc_deptchgVO> deptchg_list = (List<Hi_psndoc_deptchgVO>) map.get(Constants.MID_HI_PSNDOC_DEPTCHG);
		result = getWsService().writeHi_psndoc_deptchg(deptchg_list.toArray(new Hi_psndoc_deptchgVO[deptchg_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工任职信息", deptchg_list.size());

		/************************************ 11.政治面貌信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【政治面貌信息】数据......");
		List<Hi_psndoc_partylogVO> partylog_list = (List<Hi_psndoc_partylogVO>) map.get(Constants.MID_HI_PSNDOC_PARTYLOG);
		result = getWsService().writeHi_psndoc_partylog(partylog_list.toArray(new Hi_psndoc_partylogVO[partylog_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "政治面貌信息", partylog_list.size());

		/************************************ 12.学历学位信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【学历学位信息】数据......");
		List<Hi_psndoc_eduVO> edu_ist = (List<Hi_psndoc_eduVO>) map.get(Constants.MID_HI_PSNDOC_EDU);
		result = getWsService().writeHi_psndoc_edu(edu_ist.toArray(new Hi_psndoc_eduVO[edu_ist.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "学历学位信息", edu_ist.size());

		/************************************ 13.家庭成员海外背景信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【家庭成员海外背景信息】数据......");
		List<Hi_psndoc_grpdef14VO> grpdef14_list = (List<Hi_psndoc_grpdef14VO>) map.get(Constants.MID_HI_PSNDOC_GRPDEF14);
		result = getWsService().writeHi_psndoc_grpdef14(grpdef14_list.toArray(new Hi_psndoc_grpdef14VO[grpdef14_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "家庭成员海外背景信息", grpdef14_list.size());

		/************************************ 14.员工工作履历信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工工作履历信息】数据......");
		List<Hi_psndoc_workVO> work_list = (List<Hi_psndoc_workVO>) map.get(Constants.MID_HI_PSNDOC_WORK);
		result = getWsService().writeHi_psndoc_work(work_list.toArray(new Hi_psndoc_workVO[work_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工工作履历信息", work_list.size());

		/************************************ 15.员工涉外经历信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工涉外经历信息】数据......");
		List<Hi_psndoc_abroadVO> abroad_list = (List<Hi_psndoc_abroadVO>) map.get(Constants.MID_HI_PSNDOC_ABROAD);
		result = getWsService().writeHi_psndoc_abroad(abroad_list.toArray(new Hi_psndoc_abroadVO[abroad_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工涉外经历信息", abroad_list.size());

		/************************************ 16.员工奖励信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工奖励信息】数据......");
		List<Hi_psndoc_encVO> enc_list = (List<Hi_psndoc_encVO>) map.get(Constants.MID_HI_PSNDOC_ENC);
		result = getWsService().writeHi_psndoc_enc(enc_list.toArray(new Hi_psndoc_encVO[enc_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工奖励信息", enc_list.size());

		/************************************ 17.员工惩处信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工惩处信息】数据......");
		List<Hi_psndoc_punVO> pun_list = (List<Hi_psndoc_punVO>) map.get(Constants.MID_HI_PSNDOC_PUN);
		result = getWsService().writeHi_psndoc_pun(pun_list.toArray(new Hi_psndoc_punVO[pun_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工惩处信息", pun_list.size());

		/************************************ 18.员工培训信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工培训信息】数据......");
		List<Hi_psndoc_trainingVO> training_list = (List<Hi_psndoc_trainingVO>) map.get(Constants.MID_HI_PSNDOC_TRAINING);
		result = getWsService().writeHi_psndoc_training(training_list.toArray(new Hi_psndoc_trainingVO[training_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工培训信息", training_list.size());

		/************************************ 19.专业技术职务 ************************************/
		ProcessLine.addDefaultProcess("正在传输【专业技术职务】数据......");
		List<Hi_psndoc_spetechVO> spetech_list = (List<Hi_psndoc_spetechVO>) map.get(Constants.MID_HI_PSNDOC_SPETECH);
		result = getWsService().writeHi_psndoc_spetech(spetech_list.toArray(new Hi_psndoc_spetechVO[spetech_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "专业技术职务", spetech_list.size());

		/************************************ 20.工人技术等级 ************************************/
		ProcessLine.addDefaultProcess("正在传输【工人技术等级】数据......");
		List<Hi_psndoc_techrankVO> techrank_list = (List<Hi_psndoc_techrankVO>) map.get(Constants.MID_HI_PSNDOC_TECHRANK);
		result = getWsService().writeHi_psndoc_techrank(techrank_list.toArray(new Hi_psndoc_techrankVO[techrank_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "工人技术等级", techrank_list.size());

		/************************************ 21.知识产权信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【知识产权信息】数据......");
		List<Hi_psndoc_grpdef11VO> grpdef11_list = (List<Hi_psndoc_grpdef11VO>) map.get(Constants.MID_HI_PSNDOC_GRPDEF11);
		result = getWsService().writeHi_psndoc_grpdef11(grpdef11_list.toArray(new Hi_psndoc_grpdef11VO[grpdef11_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "知识产权信息", grpdef11_list.size());

		/************************************ 22.员工离职信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【员工离职信息】数据......");
		List<Hi_psndoc_dimissionVO> dimission_list = (List<Hi_psndoc_dimissionVO>) map.get(Constants.MID_HI_PSNDOC_DIMISSION);
		result = getWsService().writeHi_psndoc_dimission(dimission_list.toArray(new Hi_psndoc_dimissionVO[dimission_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "员工离职信息", dimission_list.size());

		/************************************ 23.干部信息主集-干部分类信息 ************************************/
		ProcessLine.addDefaultProcess("正在传输【干部信息主集-干部分类信息】数据......");
		List<Hrldm_ldpsn_infoVO> psndocinfo_list = (List<Hrldm_ldpsn_infoVO>) map.get(Constants.MID_HRLDM_LDPSN_INFO);
		result = getWsService().writeHrldm_ldpsn_info(psndocinfo_list.toArray(new Hrldm_ldpsn_infoVO[psndocinfo_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "干部信息主集-干部分类信息", psndocinfo_list.size());

		/************************************ 24.领导人员职务信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在传输【领导人员职务信息子集】数据......");
		List<Hrldm_psndoc_dutyVO> psndocduty_list = (List<Hrldm_psndoc_dutyVO>) map.get(Constants.MID_HRLDM_PSNDOC_DUTY);
		result = getWsService().writeHrldm_psndoc_duty(psndocduty_list.toArray(new Hrldm_psndoc_dutyVO[psndocduty_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "领导人员职务信息子集", psndocduty_list.size());

		/************************************ 25.后备干部信息子集 ************************************/
		ProcessLine.addDefaultProcess("正在传输【后备干部信息子集】数据......");
		List<Hrldm_train_planVO> trainplan_list = (List<Hrldm_train_planVO>) map.get(Constants.MID_HRLDM_TRAIN_PLAN);
		result = getWsService().writeHrldm_train_plan(trainplan_list.toArray(new Hrldm_train_planVO[trainplan_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "后备干部信息子集", trainplan_list.size());

		/************************************ 26.专业人才管理-院士专家信息维护 ************************************/
		ProcessLine.addDefaultProcess("正在传输【专业人才管理-院士专家信息维护】数据......");
		List<Hr_expertVO> expert_list = (List<Hr_expertVO>) map.get(Constants.MID_HR_EXPERT);
		result = getWsService().writeHr_expert(expert_list.toArray(new Hr_expertVO[expert_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "专业人才管理-院士专家信息维护", expert_list.size());

		/************************************ 27.院士专家子集－聘期管理 ************************************/
		ProcessLine.addDefaultProcess("正在传输【院士专家子集－聘期管理】数据......");
		List<Expert_termVO> term_list = (List<Expert_termVO>) map.get(Constants.MID_EXPERT_TERM);
		result = getWsService().writeExpert_term(term_list.toArray(new Expert_termVO[term_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "院士专家子集－聘期管理", term_list.size());

		/************************************ 28.薪酬管理-发放总额 ************************************/
		ProcessLine.addDefaultProcess("正在传输【薪酬管理-发放总额】数据......");
		List<Wa_dataVO> wa_list = (List<Wa_dataVO>) map.get(Constants.MID_WA_DATA);
		result = getWsService().writeWa_data(wa_list.toArray(new Wa_dataVO[wa_list.size()]));
		if (result != null && !"".equals(result)) {
			throw new BusinessException(result);
		}
		addLogs(logvos, "薪酬管理-发放总额", wa_list.size());

		return logvos.toArray(new FbsDataFileItemVO[logvos.size()]);
	}

	/**
	 * @Title: addLogs
	 * @Description: 增加日志子表条目
	 * @Author: 王凯强
	 * @Time: 2016年12月13日 下午1:43:14
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

package nc.ws.impl; 

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import nc.bs.dao.BaseDAO;
import nc.bs.framework.common.RuntimeEnv;
import nc.jdbc.framework.processor.BeanListProcessor;
import nc.pub.Constants;
import nc.vo.pub.BusinessException;
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
import nc.ws.vo.wa.Wa_dataVO;

/**
 * @ClassName: SendDataServiceImpl
 * <b> 在此处简要描述此类的功能 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年11月8日 上午9:51:13
 * @Author 王凯强
 * @Version 
 */
public class SendDataServiceImpl implements ISendDataService {
	private BaseDAO dao = null;
	private BaseDAO getDao(){
		if(dao == null){
			dao = new BaseDAO();
		}
		return dao;
	}
	
	private String getQuerySql(Class<?> clazz,String tableName, String whereStr){
		List<String> fields = getVOFields(clazz);
		StringBuffer sb = new StringBuffer("select ");
		String strtemp = null;
		for (int i = 0; i < fields.size() - 1; i++) {
			strtemp = fields.get(i);
			sb.append(strtemp + ",");
		}
		sb.append(fields.get(fields.size() - 1));
		sb.append(" from ");
		sb.append( tableName +" where "+whereStr);
		return sb.toString();
	}

	public static List<String> getVOFields(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		List<String> field_list = new ArrayList<String>();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			if (fields[i].getName().toLowerCase().equals("serialversionuid") 
					|| fields[i].getName().toLowerCase().equals("tablename") 
					|| fields[i].getName().startsWith("_") 
					|| fields[i].getName().toLowerCase().equals("typedesc") )
				continue;
			field_list.add(fields[i].getName());
		}
		return field_list;
	}
	@SuppressWarnings("unchecked")
	public List<Bd_deptdocVO> getBd_deptdocData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Bd_deptdocVO.class, Constants.MID_BD_DEPTDOC, whereStr);
		List<Bd_deptdocVO> list = (List<Bd_deptdocVO>)getDao().executeQuery(sql, new BeanListProcessor(Bd_deptdocVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_psnbasdocVO> getBd_psnbasdocData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Bd_psnbasdocVO.class, Constants.MID_BD_PSNBASDOC, whereStr);
		List<Bd_psnbasdocVO> list = (List<Bd_psnbasdocVO>)getDao().executeQuery(sql, new BeanListProcessor(Bd_psnbasdocVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Bd_psndocVO> getBd_psndocData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Bd_psndocVO.class, Constants.MID_BD_PSNDOC, whereStr);
		List<Bd_psndocVO> list = (List<Bd_psndocVO>)getDao().executeQuery(sql, new BeanListProcessor(Bd_psndocVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Expert_termVO> getExpert_termData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Expert_termVO.class, Constants.MID_EXPERT_TERM, whereStr);
		List<Expert_termVO> list = (List<Expert_termVO>)getDao().executeQuery(sql, new BeanListProcessor(Expert_termVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_abroadVO> getHi_psndoc_abroadData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_abroadVO.class, Constants.MID_HI_PSNDOC_ABROAD, whereStr);
		List<Hi_psndoc_abroadVO> list = (List<Hi_psndoc_abroadVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_abroadVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_deptchgVO> getHi_psndoc_deptchgData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_deptchgVO.class, Constants.MID_HI_PSNDOC_DEPTCHG, whereStr);
		List<Hi_psndoc_deptchgVO> list = (List<Hi_psndoc_deptchgVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_deptchgVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_dimissionVO> getHi_psndoc_dimissionData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_dimissionVO.class, Constants.MID_HI_PSNDOC_DIMISSION, whereStr);
		List<Hi_psndoc_dimissionVO> list = (List<Hi_psndoc_dimissionVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_dimissionVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_eduVO> getHi_psndoc_eduData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_eduVO.class, Constants.MID_HI_PSNDOC_EDU, whereStr);
		List<Hi_psndoc_eduVO> list = (List<Hi_psndoc_eduVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_eduVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_encVO> getHi_psndoc_encData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_encVO.class, Constants.MID_HI_PSNDOC_ENC, whereStr);
		List<Hi_psndoc_encVO> list = (List<Hi_psndoc_encVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_encVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef11VO> getHi_psndoc_grpdef11Data(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_grpdef11VO.class, Constants.MID_HI_PSNDOC_GRPDEF11, whereStr);
		List<Hi_psndoc_grpdef11VO> list = (List<Hi_psndoc_grpdef11VO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_grpdef11VO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_grpdef14VO> getHi_psndoc_grpdef14Data(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_grpdef14VO.class, Constants.MID_HI_PSNDOC_GRPDEF14, whereStr);
		List<Hi_psndoc_grpdef14VO> list = (List<Hi_psndoc_grpdef14VO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_grpdef14VO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_partylogVO> getHi_psndoc_partylogData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_partylogVO.class, Constants.MID_HI_PSNDOC_PARTYLOG, whereStr);
		List<Hi_psndoc_partylogVO> list = (List<Hi_psndoc_partylogVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_partylogVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_punVO> getHi_psndoc_punData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_punVO.class, Constants.MID_HI_PSNDOC_PUN, whereStr);
		List<Hi_psndoc_punVO> list = (List<Hi_psndoc_punVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_punVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_spetechVO> getHi_psndoc_spetechData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_spetechVO.class, Constants.MID_HI_PSNDOC_SPETECH, whereStr);
		List<Hi_psndoc_spetechVO> list = (List<Hi_psndoc_spetechVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_spetechVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_techrankVO> getHi_psndoc_techrankData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_techrankVO.class, Constants.MID_HI_PSNDOC_TECHRANK, whereStr);
		List<Hi_psndoc_techrankVO> list = (List<Hi_psndoc_techrankVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_techrankVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_trainingVO> getHi_psndoc_trainingData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_trainingVO.class, Constants.MID_HI_PSNDOC_TRAINING, whereStr);
		List<Hi_psndoc_trainingVO> list = (List<Hi_psndoc_trainingVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_trainingVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hi_psndoc_workVO> getHi_psndoc_workData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hi_psndoc_workVO.class, Constants.MID_HI_PSNDOC_WORK, whereStr);
		List<Hi_psndoc_workVO> list = (List<Hi_psndoc_workVO>)getDao().executeQuery(sql, new BeanListProcessor(Hi_psndoc_workVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hr_expertVO> getHr_expertData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hr_expertVO.class, Constants.MID_HR_EXPERT, whereStr);
		List<Hr_expertVO> list = (List<Hr_expertVO>)getDao().executeQuery(sql, new BeanListProcessor(Hr_expertVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_ldpsn_infoVO> getHrldm_ldpsn_infoData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hrldm_ldpsn_infoVO.class, Constants.MID_HRLDM_LDPSN_INFO, whereStr);
		List<Hrldm_ldpsn_infoVO> list = (List<Hrldm_ldpsn_infoVO>)getDao().executeQuery(sql, new BeanListProcessor(Hrldm_ldpsn_infoVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_psndoc_dutyVO> getHrldm_psndoc_dutyData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hrldm_psndoc_dutyVO.class, Constants.MID_HRLDM_PSNDOC_DUTY, whereStr);
		List<Hrldm_psndoc_dutyVO> list = (List<Hrldm_psndoc_dutyVO>)getDao().executeQuery(sql, new BeanListProcessor(Hrldm_psndoc_dutyVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Hrldm_train_planVO> getHrldm_train_planData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Hrldm_train_planVO.class, Constants.MID_HRLDM_TRAIN_PLAN, whereStr);
		List<Hrldm_train_planVO> list = (List<Hrldm_train_planVO>)getDao().executeQuery(sql, new BeanListProcessor(Hrldm_train_planVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_corp_workout_bVO> getOm_corp_workout_bData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_corp_workout_bVO.class, Constants.MID_OM_CORP_WORKOUT_B, whereStr);
		List<Om_corp_workout_bVO> list = (List<Om_corp_workout_bVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_corp_workout_bVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_corp_workoutVO> getOm_corp_workoutData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_corp_workoutVO.class, Constants.MID_OM_CORP_WORKOUT, whereStr);
		List<Om_corp_workoutVO> list = (List<Om_corp_workoutVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_corp_workoutVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_dept_workoutVO> getOm_dept_workoutData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_dept_workoutVO.class, Constants.MID_OM_DEPT_WORKOUT, whereStr);
		List<Om_dept_workoutVO> list = (List<Om_dept_workoutVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_dept_workoutVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_dutyVO> getOm_dutyData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_dutyVO.class, Constants.MID_OM_DUTY, whereStr);
		List<Om_dutyVO> list = (List<Om_dutyVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_dutyVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_job_workoutVO> getOm_job_workoutData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_job_workoutVO.class, Constants.MID_OM_JOB_WORKOUT, whereStr);
		List<Om_job_workoutVO> list = (List<Om_job_workoutVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_job_workoutVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Om_jobVO> getOm_jobData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Om_jobVO.class, Constants.MID_OM_JOB, whereStr);
		List<Om_jobVO> list = (List<Om_jobVO>)getDao().executeQuery(sql, new BeanListProcessor(Om_jobVO.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Wa_dataVO> getWa_dataData(String whereStr) throws BusinessException {
		String sql = getQuerySql(Wa_dataVO.class, Constants.MID_WA_DATA, whereStr);
		List<Wa_dataVO> list = (List<Wa_dataVO>)getDao().executeQuery(sql, new BeanListProcessor(Wa_dataVO.class));
		return list;
	}

	public String getWebServicePort() {
		String versionfilename = RuntimeEnv.getInstance().getNCHome()
				+ java.io.File.separator + "modules"
				+ java.io.File.separator + "fbsxj"
				+ java.io.File.separator + "cfgs"
				+ java.io.File.separator + "sqls"
				+ java.io.File.separator + "ncehr"
				+ java.io.File.separator + "57"
				+ java.io.File.separator + "oracle"
				+ java.io.File.separator + "010webservice"
				+ java.io.File.separator + "port.properties";
		String port = "";
		try {
			FileInputStream input = new FileInputStream(versionfilename);
			Properties properties = new Properties();
			properties.load(input);
			port = properties.getProperty("port");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return port;
	}
}

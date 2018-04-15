package nc.bs.check;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import nc.bs.check.beanUtil.DataMap;
import nc.bs.check.impl.CheckDataImpl;
import nc.bs.dao.BaseDAO;
import nc.itf.fbs.pub.CheckField;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.vo.log.error.Fbs_logVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDate;

/**
 * @author changrh
 * @date 2016-8-1
 *       非空校验、pk校验、转换pk，如果非空与pk校验不通过则返回sorry，并把日志信息存入到异常日志展示表中，如果两项都检测通过
 *       ，返回ok，同时转换pk与转换公司pk
 */
public class CheckVObynullpk {
	
	private CheckDataImpl cdi = null;
	
	public CheckDataImpl getCdi() {
		if(cdi == null){
			cdi = new CheckDataImpl();
		}
		return cdi;
	}

	

//	private Map<String, String> mapCorp = null;

	/**
	 * @Title: checkNull
	 * @Description: 非空校验方法
	 * @Time: 2016年10月27日 上午10:53:45
	 * @param checkvo		     增量vo
	 * @param checkNull       非空的数据；
	 * @param checkNullName   非空对应中文名
	 * @param checkPk 
	 * @param checkPkName     对照对应的中文名
	 * @param pkFields        主键要转换的的数组
	 * @param tipField		     提醒的字段
	 * @param tipName         提醒的名字
	 * @param tableName       表中文名称
	 * @param dataControlMap  数据对照缓存
	 * @param defdocMap       自定义档案缓存
	 * @param notnull_other   不为空字段特殊校验
	 * @param notnull_other_name不为空字段特殊校验字段名称
	 * @return 增量VO
	 * @throws BusinessException
	 */
	public SuperVO checkNull(SuperVO checkvo, String[] checkNull,
			String[] checkNullName, String[] checkPk, String[] checkPkName,
			String[] pkFields, String tipField, String tipName,
			String tableName, List<DataMap> dataControlMap,
			List<DataMap> defdocMap, String[] notnull_other,
			String[] notnull_other_name) throws BusinessException {

		String flagIsNUll = "0";
		

		// 获取人员归属范围，以便只针对在职人员（归属范围为0）的人员进行非空校验，其中分为两种情况，在岗人员、离岗仍保留劳动关系人员是否必输
		// (psnclasscode like 'B1%' or psnclasscode like 'B4%')
		// 劳务派遣、其他从业人员是否必输(psnclasscode like 'B2%' or psnclasscode like 'B3%')
		// 返回结果 0：未找到对照数据，1：B1或B4开头，2：B2或B3开头
		if (checkvo.getTableName().toString().contains("hi_psndoc_deptchg")) {
			Double jobtype = Double.parseDouble(checkvo.getAttributeValue(
					"jobtype").toString());
			// hi_psndoc_deptchg中的jobtype是不为空字段
			if (jobtype != 0) {
				return null;
			}
		}
		int checkNullFlag = getPsnclasscode(checkvo);
		Fbs_logVO logvo = null;
		// 非空校验
		// isnull,isnullName为B1和B4校验的非空字段和字段名，notnull_other,notnull_other_name为B2和B3校验的非空字段和字段名
		if (checkNullFlag == 1 || checkNullFlag == 3) {
			// hi_psndoc_deptchg 表 如果jobtype = 0，则校验非空字段，如果 <> 0则不校验。
			logvo = checkNullAndPK(checkvo, checkNull, checkNullName, tipField,
					tipName, tableName, flagIsNUll, dataControlMap, defdocMap);

		} else if (checkNullFlag == 2) {
			logvo = checkNullAndPK(checkvo, notnull_other, notnull_other_name,
					tipField, tipName, tableName, flagIsNUll, dataControlMap,
					defdocMap);

		}

		// 如果非空校验通过，则进行数据对照
		return logvo;
	}

	
	/**
	 * @Title: checkDataControlAndPk
	 * @Description: 数据对照校验和主键转换
	 * @Time: 2016年10月27日 上午10:58:53
	 * @param checkvo
	 * @param checkpk
	 * @param checkpkName
	 * @param pkFields
	 * @param tipField
	 * @param tipName
	 * @param tableName
	 * @param dataControlMap
	 * @param defdocMap
	 * @return
	 * @throws BusinessException
	 */
	public SuperVO checkDataControlAndPk(SuperVO checkvo, String[] checkpk, String[] checkpkName,
			String[] pkFields, String tipField, String tipName,String tableName, List<DataMap> dataControlMap,
			List<DataMap> defdocMap) throws BusinessException{
		Fbs_logVO logvo = null;
		String flagIsPk = "1";
		// 数据对照校验
		if (checkpk != null && checkpk.length > 0) {
			logvo = checkNullAndPK(checkvo, checkpk, checkpkName, tipField,
					tipName, tableName, flagIsPk, dataControlMap, defdocMap);
		}
		//人员的归属范围转换
		if(CheckField.TABLENAME_PSN.equals(tableName)){
			initPsncl();
			checkvo.setAttributeValue("psnclscope", psncl.get(checkvo.getAttributeValue("pk_psncl")));
		}

//		ICheckData checkData = (ICheckData) NCLocator.getInstance().lookup(ICheckData.class.getName());
		// 只有所有数据验证通过了，才能返回新vo
		// 转换pk
		checkvo = getCdi().changPk(checkvo, pkFields, tableName);
		return logvo;
	}
	/**
	 * @Title: getDefDocPK
	 * @Description: 从缓存的自定义档案中找到相应的pk_defdoc或者从数据对照缓存中找到相应上级的pk
	 * @Author: 王凯强
	 * @Date: 2016年9月8日
	 * @param dataControlMap
	 *            数据对照集合
	 * @param defdocList
	 *            自定义档案集合
	 * @param value
	 *            pk
	 * @return
	 */
	private List<String> getDefDocPK(List<DataMap> dataControlMap,
			List<DataMap> defdocMap, String value) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < defdocMap.size(); i++) {
			if (defdocMap.get(i).getKey().equals(value)) {
				list.add(defdocMap.get(i).getKey());
				break;
			}
			if (defdocMap.get(i).getValue().equals(value)) {
				list.add(defdocMap.get(i).getValue());
				break;
			}
		}
		if (list.size() == 0) {// 如果已经找到了，就没必要找了
			for (int i = 0; i < dataControlMap.size(); i++) {
				if (dataControlMap.get(i).getKey().equals(value)) {
					list.add(dataControlMap.get(i).getValue());
					break;
				}
			}
		}
		return list;
	}

	/**
	 * @author changrh
	 * @dta 2016-8-5 非空验证和数据对照验证
	 * @param checkvo
	 * @param fields
	 * @param fieldNames
	 * @param tipField
	 * @param tipName
	 * @param tableName
	 * @param flag
	 * @return
	 * @throws BusinessException
	 */
	private Fbs_logVO checkNullAndPK(SuperVO checkvo, String[] fields,
			String[] fieldNames, String tipField, String tipName,
			String tableName, String flag, List<DataMap> dataControlMap,
			List<DataMap> defdocMap) throws BusinessException {
		String msg = "", msgTipName = "", msgTemp = "", msgTempTail = "";
		String type;
		List<String> list = null;

		if ("0".equals(flag)) {
			msgTempTail = "不能为空！";
			type = CheckField.TYPE_CHECK_NULL;
		} else {
			msgTempTail = "没有在数据对照中转换为集团对应基础档案参照数据！";
			type = CheckField.TYPE_DATA_CONTROL;
		}

		if (checkvo == null) {
			return null;
		}

		if (fields == null || fieldNames == null) {
			return null;
		}

		Object objField = null;
		for (int j = 0; j < fields.length; j++) {
			objField = checkvo.getAttributeValue(fields[j]);
			// 0:进行非空验证；1：进行基础数据对照验证
			if ("0".equals(flag)) {
				// hi_psndoc_partylog 表 如果cpartyname =
				// 'HI800000000000002813'，则不校验dpartydate非空
				// 如果cpartyname <> 'HI800000000000002813'，则dpartydate不可为空。
				if (checkvo.getTableName().toString()
						.contains("hi_psndoc_partylog")) {
					if ("dpartydate".equals(fields[j])
							&& "HI800000000000002813".equals(checkvo
									.getAttributeValue("cpartyname")))
						continue;
				}
				if ("".equals(objField) || objField == null) {
					msgTemp += ("【" + fieldNames[j] + "】");
				}
			}
			if ("1".equals(flag)) {
				if (objField != null) {
					String value = objField.toString().trim();
					// step1
					// 校验自定义档案和数据对照
					list = getDefDocPK(dataControlMap, defdocMap, value);
					// step2
					// 日志缓存
					if (list == null || list.size() == 0) {
						msgTemp += ("【" + fieldNames[j] + "】");
					} else {
						checkvo.setAttributeValue(fields[j], list.get(0));
					}
				}
			}
		}
		// 日志提示内容
		String value = (String) checkvo.getAttributeValue(tipField);

		// 若提示字段的值为主键，则需转换为编码，否则不用转换
		msgTipName = tipName + "[" + value + "],";
		// step2
		if (!"".equals(msgTemp)) {
			msg = msgTipName + msgTemp + msgTempTail + "";
			// 校验非空不通过，则将错误日志写入日志表中，返回结果“sorry”
			// String pk_corp = getPKCorp(checkvo);

			return getErrorLog(type, msg, tableName,
					(String) checkvo.getAttributeValue("pk_corp"));

		}

		return null;
	}

//	private SuperVO changPk(SuperVO checkvo, String[] pkFields, String tbname) 
//			throws BusinessException {
//		String pkCorpOld = "", pkCorpNew = "";
//		Object obj = null;
//		if (mapCorp == null) {
//			ICheckData iCheckData = (ICheckData) NCLocator.getInstance()
//					.lookup(ICheckData.class.getName());
//			mapCorp = iCheckData.allCorp();
//		}
//		for (int i = 0; i < pkFields.length; i++) {
//			obj = checkvo.getAttributeValue(pkFields[i]);
//			if (obj != null) {
//				String pkOld = obj.toString();
//				if (pkOld.length() != 20) {
//					throw new BusinessException("表：" + tbname + "的字段为：'"
//							+ pkFields[i] + "'的主键格式不正确，请联系业务人员！！");
//				}
//				pkCorpOld = pkOld.substring(0, 4);
//				// String pk_corp = getPKCorp(checkvo);
//				// pkCorpNew = icd.getPkCorp(pk_corp);
//				// lxf 在后台任务开始执行时已经对比过是否集团与下级公司一致的情况，此处可不重复对比
//				// lxf pk_corp 直接在vo中得到 将集团与下级的pk_corp放到listmap里进行对比
//				
//				//人员工作信息公司主键
//				String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
//				//人员基本信息公司主键,部分表这个字段为空
//				String bas_pkcorp = PubTool.toString(checkvo.getAttributeValue("bas_pkcorp"));
//				if(!"".equals(bas_pkcorp) && !pk_corp.equals(bas_pkcorp)){
//					pk_corp = bas_pkcorp;
//				}
//				pkCorpNew = PubTool.toString(mapCorp.get(pk_corp));
//				// if ("".equals(pkCorpNew) || pkCorpNew == null) {//
//				// 企业编码不存在，抛出异常并且存储日志
//				// String unitcode = "";
//				// if(!"".equals(pk_corp) && pk_corp !=null){
//				// unitcode =
//				// getCorpUnitcode(pk_corp);//从本表pk_corp或者主表pk_corp获取企业编码
//				// }
//				// if(unitcode == null){
//				// if(!"".equals(pk_corp) && pk_corp !=null){
//				// unitcode = pk_corp;
//				// }
//				// }
//				// String message = "编码为'" + unitcode + "'的公司在集团不存在，请核对后继续操作";
//				//
//				// saveErrorLog(CheckField.TYPE_CHECK_CORP, message, tbname,
//				// pk_corp);
//				// break;
//				// }
//
//				// 2016-09-29 lxf add pk转换规则定义
//				// 1046A320160926001122--->1087ZA10460926001122 前十位转换规则1087为转换公司
//				// ZA转换后的sid 1046 原先的pk_corp
//				// 2016-10-09 lxf edit pk转换修改规定定义 如果前四位是0001，则只将pk_corp转换第七至第十位.
//
//				String pk_new = "";
//
//				if ("0001".equals(pkCorpOld)) {
//					String q_Liu = pkOld.substring(0, 6);// 前六位
//															// 0001A320160926001122
//															// 0001A3
//					String h_Shi = pkOld.substring(10, 20);// 后十位0001A320160926001122
//															// 0926001122
//					pk_new = q_Liu + pkCorpNew + h_Shi;// 组合后
//														// 0001A310870926001122
//				} else {
//					pkCorpNew = PubTool.toString(mapCorp.get(pkCorpOld));
//					pk_new = pkOld.replaceFirst(pkCorpOld, pkCorpNew);// 将主键中前四位公司主键改为集团下发的公司主键
//					String oid = pk_new.substring(4, 6);
//					pk_new = pk_new.replaceFirst(oid, "ZA");
//				}
//				checkvo.setAttributeValue(pkFields[i], pk_new);
//
////				checkvo.setAttributeValue(chgpkNew[i], pk_New);
//
//				// String qShiNew = pkCorpNew+"ZA"+pkCorpOld;
//				// String pkNew = pkOld.replaceFirst(pkCorpOld, pkCorpNew);//
//				// 将主键中前四位公司主键改为集团下发的公司主键
//				// String oid = pkNew.substring(4, 6);
//				// pkNew = pkNew.replaceFirst(oid, "ZA");
//				// String pkNew = pkOld.substring(10, 20);
//				// pkNew = qShiNew+pkNew;
//				// checkvo.setAttributeValue(chgpkNew[i], pkNew);
//				// global_pk_corp = pkCorpNew;
//				// checkvo.setAttributeValue(chgpkNew[i], pkNew);
//			}
//		}
//		//修改本条数据的pk_corp
//		String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
//		if(!"0001".equals(pk_corp)){
//			checkvo.setAttributeValue("pk_corp", mapCorp.get(pk_corp));
//		}
//		//专业人才管理-院士专家信息维护（hr_expert）的所属中航单位（pk_new_corp）也需要转换
//		String pk = (String) checkvo.getAttributeValue("pk_new_corp");
//		if(pk!= null && checkvo.getTableName().endsWith("hr_expert") && !"0001".equals(pk)){
//			checkvo.setAttributeValue("pk_new_corp", mapCorp.get(pk));
//		}
//		return checkvo;
//	}


	/**
	 * @Title: getErrorLog
	 * @Description: 保存日志
	 * @param type
	 * @param message
	 * @param table
	 * @param errorCorp
	 * @throws BusinessException
	 */
	public Fbs_logVO getErrorLog(String type, String message, String table,
			String errorCorp) throws BusinessException {
		Fbs_logVO logVO = new Fbs_logVO();
		logVO.setVgroupdef2(type);
		logVO.setVgroupdef1(table);
		logVO.setFbs_log_content(message);
		logVO.setPk_corp(errorCorp);
		logVO.setBill_writer_date(new UFDate(System.currentTimeMillis()));
		logVO.setVgroupdef3(errorCorp);
		return logVO;
	}

	/**
	 * 返回结果 0：不校验，1：B1或B4开头，2：B2或B3开头,3:不包含人员类别的数据，比如部门，岗位等等
	 * 
	 * @param vo
	 * @return
	 * @throws BusinessException
	 */
	private int getPsnclasscode(SuperVO vo) throws BusinessException {
		initPsncope();
		if (vo.getAttributeValue("pk_psncl") == null
				|| vo.getAttributeValue("pk_psncl").toString().trim().length() == 0) {
			return 3;
		}
		String psnclcode = psncope.get(vo.getAttributeValue("pk_psncl"));
		if (psnclcode == null) {
			return 0;
		} else if (psnclcode.startsWith("B1") || psnclcode.startsWith("B4")) {
			return 1;
		} else if (psnclcode.startsWith("B2") || psnclcode.startsWith("B3")) {
			return 2;
		}
		return 0;
	}

	HashMap<String, String> psncope = null;
	private BaseDAO dao = null;
	private BaseDAO getDao(){
		if(dao==null){
			dao = new BaseDAO();
		}
		return dao;
	}
			
	@SuppressWarnings("rawtypes")
	private void initPsncope() throws BusinessException {
		if (psncope == null) {
			psncope = new HashMap<String, String>();
			String sql1 = "select pk_defdoc,doccode from mid_bd_defdoc where memo=0 and pk_defdoclist = '0001V8100000000042GX'";
			String sql2 = " select b.xj_pk,b.jt_code"
					+ " from dc_datacontrol_type h"
					+ " inner join dc_datacontrol b"
					+ " on h.pk_datacontrol_type = b.pk_datacontrol_type"
					+ " where h.vuserdef4 = '人员类别'";
			//不去校验没有对照的那些人员类别，因为没有意义
			//String sql3 = "select pk_psncl,psnclasscode from bd_psncl where psnscope=0 and pk_psncl not in (select pk_defdoc from mid_bd_defdoc where pk_defdoclist = '0001V9101100000004MQ')";
			
			List list = (List) getDao().executeQuery(sql1, new ArrayListProcessor());
			Object[] obj = null;
			for (int i = 0; i < list.size(); i++) {
				obj = (Object[]) list.get(i);
				psncope.put((String)obj[0], (String)obj[1]);
			}
			list = (List) getDao().executeQuery(sql2, new ArrayListProcessor());
			for (int i = 0; i < list.size(); i++) {
				obj = (Object[]) list.get(i);
				psncope.put((String)obj[0], (String)obj[1]);
			}
//			list = (List) getDao().executeQuery(sql3, new ArrayListProcessor());
//			for (int i = 0; i < list.size(); i++) {
//				obj = (Object[]) list.get(i);
//				if(!psncope.keySet().contains((String)obj[0])){
//					psncope.put((String)obj[0], (String)obj[1]);
//				}
//			}
		}
	}
	
	HashMap<String, Integer> psncl = null;
	@SuppressWarnings("rawtypes")
	private void initPsncl() throws BusinessException{
		if(psncl==null){
			psncl = new HashMap<String, Integer>();
			String sql1 = "select pk_defdoc,memo from mid_bd_defdoc where  pk_defdoclist = '0001V8100000000042GX'";
			List list = (List) getDao().executeQuery(sql1, new ArrayListProcessor());
			Object[] obj = null;
			for (int i = 0; i < list.size(); i++) {
				obj = (Object[]) list.get(i);
				psncl.put((String)obj[0], obj[1] == null?null:Integer.parseInt((String) obj[1]));
			}
		}
	}
	
	
}

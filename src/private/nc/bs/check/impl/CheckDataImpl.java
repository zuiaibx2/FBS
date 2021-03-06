package nc.bs.check.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nc.bs.check.beanUtil.DataMap;
import nc.bs.dao.BaseDAO;
import nc.itf.check.ICheckData;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.util.fbs.pub.PubTool;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @author changrh
 * @date 2016-8-1
 * 校验数据查询数据库实现类
 *
 */
public class CheckDataImpl implements ICheckData {

	private Map<String, String> mapCorp = null;
	
	BaseDAO dao = null;
	private BaseDAO getDao() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}
	
	@SuppressWarnings("rawtypes")
	public List<DataMap> getDefdocList() throws BusinessException {
		String sql = "select pk_defdoc,docname from mid_bd_defdoc where dr=0 or dr is null";
		List list =  (List) getDao().executeQuery(sql, new ArrayListProcessor());
		List<DataMap> defdocMap = new ArrayList<DataMap>();
		DataMap defdoc = null;
		Object[] obj = null;
		for(int i=0;i<list.size();i++){
			obj = (Object[]) list.get(i);
			defdoc = new DataMap();
			defdoc.setKey(obj[0].toString());
			defdoc.setValue(obj[1].toString());
			defdocMap.add(defdoc);
		}
		return defdocMap;
	}
	
	@SuppressWarnings("rawtypes")
	public List<DataMap> getDatacontrol() throws nc.vo.pub.BusinessException{
		String sql ="select control.xj_pk, control.jt_zj from dc_datacontrol control where control.dr = null or control.dr = 0";
		List list =  (List) getDao().executeQuery(sql, new ArrayListProcessor());
		List<DataMap> dataControlMap = new ArrayList<DataMap>();
		DataMap dataControl = null;
		Object[] obj =null;
		for(int i=0;i<list.size();i++){
			obj = (Object[]) list.get(i);
			dataControl = new DataMap();
			dataControl.setKey(obj[0].toString());
			dataControl.setValue(obj[1].toString());
			dataControlMap.add(dataControl);
		}
		return dataControlMap;
	}
	
	@SuppressWarnings("rawtypes")
	public List<String> checkCorp() throws BusinessException {
		String sql = "select count(*) from fbs_expcorp_conf where isnull(dr,0) = 0";
		int count = Integer.parseInt(getDao().executeQuery(sql, new ColumnProcessor()).toString());
		if(count == 0){
			sql ="select corp.unitcode from bd_corp corp where not exists (select corp_m.unitcode from mid_bd_corp corp_m where corp_m.unitcode = corp.unitcode)";
		}else{
			sql = "select distinct corp.unitcode from bd_corp corp inner join fbs_expcorp_conf conf on corp.pk_corp = conf.exp_pk_corp and isnull(conf.dr,0) = 0 where not exists (select corp_m.unitcode from mid_bd_corp corp_m where corp_m.unitcode = corp.unitcode)";
		}
		
		List list = (List) getDao().executeQuery(sql, new ArrayListProcessor());
		List<String> listString = new ArrayList<String>();
		Object[] obj =null;
		for(int i=0;i<list.size();i++){
			obj = (Object[]) list.get(i);
			listString.add(obj[0].toString());
		}
		return listString;
	}
	
	@SuppressWarnings("rawtypes")
	public Map<String, String> allCorp() throws BusinessException {
		String sql = "select count(*) from fbs_expcorp_conf where isnull(dr,0) = 0";
		int count = Integer.parseInt(getDao().executeQuery(sql, new ColumnProcessor()).toString());
		if(count == 0){
			sql ="select corp.pk_corp,corp_m.pk_corp from bd_corp corp inner join mid_bd_corp corp_m on corp_m.unitcode = corp.unitcode order by corp.pk_corp asc";
		}else{
			sql = "select distinct corp.pk_corp, corp_m.pk_corp from bd_corp corp inner join mid_bd_corp corp_m on corp_m.unitcode = corp.unitcode inner join fbs_expcorp_conf conf on corp.pk_corp = conf.exp_pk_corp and nvl(conf.dr,0)=0 order by corp.pk_corp asc ";
		}
		
		List list = (List) getDao().executeQuery(sql, new ArrayListProcessor());
		Map<String, String> dataControl = new HashMap<String, String>();
		for(int i=0;i<list.size();i++){
			Object[] obj = (Object[]) list.get(i);
			dataControl.put(PubTool.toString(obj[0]), PubTool.toString(obj[1]));
		}
		//给0001对照到本帐套最小的pk_corp对应集团的pk_corp
		//{1087=1888, 1089=1089, 0001=1888, 1088=1088}
		dataControl.put("0001", PubTool.toString(((Object[]) list.get(0))[1]));
		return dataControl;
	}

	/* (non-Javadoc) 转换主键方法
	 * @see nc.itf.check.ICheckData#changPk(nc.vo.pub.SuperVO, java.lang.String[], java.lang.String)
	 */
	public SuperVO changPk(SuperVO checkvo, String[] pkFields, String tbname) throws BusinessException {
		Object obj = null;
		if (mapCorp == null) {
			mapCorp = allCorp();
		}
		for (int i = 0; i < pkFields.length; i++) {
			obj = checkvo.getAttributeValue(pkFields[i]);
			if (obj != null) {
				String pkOld = obj.toString();
				if (pkOld.length() != 20) {
					throw new BusinessException("表：" + tbname + "的字段为：'"
							+ pkFields[i] + "'的主键格式不正确，请联系业务人员！！");
				}

				String pk_new = getNewPk(pkOld, mapCorp, checkvo);
						
				checkvo.setAttributeValue(pkFields[i], pk_new);

			}
		}
		//修改本条数据的pk_corp
		String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
		if(!"0001".equals(pk_corp)){
			checkvo.setAttributeValue("pk_corp", mapCorp.get(pk_corp));
		}
		//专业人才管理-院士专家信息维护（hr_expert）的所属中航单位（pk_new_corp）也需要转换
		String pk_new_corp = (String) checkvo.getAttributeValue("pk_new_corp");
		if(pk_new_corp!= null && checkvo.getTableName().endsWith("hr_expert") && !"0001".equals(pk_new_corp)){
			checkvo.setAttributeValue("pk_new_corp", mapCorp.get(pk_new_corp));
		}
		return checkvo;
	}
	
	/* (non-Javadoc) 获取新的主键
	 * @see nc.itf.check.ICheckData#getNewPk(java.lang.String, java.util.Map, nc.vo.pub.SuperVO)
	 */
	public String getNewPk(String pkOld, Map<String, String> mapCorp, SuperVO checkvo) throws BusinessException {
		String pkCorpOld = "", pkCorpNew = "";
		pkCorpOld = pkOld.substring(0, 4);
		
		//人员工作信息公司主键
		String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
		//人员基本信息公司主键,部分表这个字段为空
		String bas_pkcorp = PubTool.toString(checkvo.getAttributeValue("bas_pkcorp"));
		
		if(!"".equals(bas_pkcorp) && !pk_corp.equals(bas_pkcorp)){
			pk_corp = bas_pkcorp;
		}
		pkCorpNew = PubTool.toString(mapCorp.get(pk_corp));
		if("".equals(pkCorpNew)){
			throw new BusinessException("主键为：" + pk_corp + "的公司在集团不存在，请核实！");
		}
		String pk_new = "";

		if ("0001".equals(pkCorpOld)) {
			String q_Liu = pkOld.substring(0, 6);// 前六位
													// 0001A320160926001122
													// 0001A3
			String h_Shi = pkOld.substring(10, 20);// 后十位0001A320160926001122
													// 0926001122
			pk_new = q_Liu + pkCorpNew + h_Shi;// 组合后
												// 0001A310870926001122
		} else {
			pkCorpNew = PubTool.toString(mapCorp.get(pkCorpOld));
			/*********** 主键特殊处理代码开始 ***********/
			//部分公司已不存在，主键前四位找不到转换的pk_corp，特殊处理
			//直升机公司特殊处理，不许特殊处理的公司注释即可
			//FIXME 注释掉的代码是配置文件处理方式，以后再定具体用哪种方式
//			if("".equals(pkCorpNew)){
//				if("1002".equals(pkCorpOld) || "1321".equals(pkCorpOld) || "1319".equals(pkCorpOld)){
//	//				Map<String, String> corpMap = getSpecificCorp();
//	//				pkCorpNew = PubTool.toString(corpMap.get(pkCorpOld));
//					pkCorpNew = PubTool.toString(mapCorp.get("1009"));
//				}
//				
//				if("1320".equals(pkCorpOld)){
//					pkCorpNew = PubTool.toString(mapCorp.get("1323"));
//				}
//				if("".equals(pkCorpNew) && "1319".equals(pkCorpOld)){
//					//直升机公司的数据1319共对应三个公司（1323,1324,1009）
//					pkCorpNew = PubTool.toString(mapCorp.get("1323"));
//				}
//				if("".equals(pkCorpNew) && "1319".equals(pkCorpOld)){
//					pkCorpNew = PubTool.toString(mapCorp.get("1324"));
//				}
//			}
			
			/*********** 主键特殊处理代码结束 ***********/
			if("".equals(pkCorpNew)){
				throw new BusinessException("主键为：" + pkCorpOld + "的公司在集团不存在，请核实！");
			}
			pk_new = pkOld.replaceFirst(pkCorpOld, pkCorpNew);// 将主键中前四位公司主键改为集团下发的公司主键
			String oid = pk_new.substring(4, 6);
			pk_new = pk_new.replaceFirst(oid, "ZA");
		}
		return pk_new;
	}
	
//	private Map<String, String> corpMap = new HashMap<String, String>();
//	/**
//	 * 主键转换特殊处理,初始化成一个map
//	 * @return 特殊处理pk_corp的键值对
//	 * @throws BusinessException
//	 */
//	public Map<String, String> getSpecificCorp() throws BusinessException {
//		if(!corpMap.isEmpty()){
//			return corpMap;
//		}
//		try{
//			//modules\fbsxj\cfgs\sqls\ncehr\57\oracle\03procedures
//			String versionfilename = RuntimeEnv.getInstance().getNCHome()
//					+ java.io.File.separator + "modules"
//					+ java.io.File.separator + "fbsxj"
//					+ java.io.File.separator + "cfgs"
//					+ java.io.File.separator + "sqls"
//					+ java.io.File.separator + "ncehr"
//					+ java.io.File.separator + "57"
//					+ java.io.File.separator + "oracle"
//					+ java.io.File.separator + "03procedures"
//					+ java.io.File.separator + "corp.properties";
//			FileInputStream input = new FileInputStream(versionfilename);
//	        Properties properties = new Properties();
//	        properties.load(input);
//	        String keys = properties.getProperty("key");
//	        String values = properties.getProperty("value");
//	        if(keys == null || values == null){
//	        	return corpMap;
//	        }
//	        String[] keyArr = keys.split(",");
//	        String[] valueArr = values.split(",");
//	        for(int i = 0; i < keyArr.length; i++){
//	        	if(corpMap.containsKey(keyArr[i])){
//	        		continue;
//	        	}
//	        	corpMap.put(keyArr[i], valueArr[i]);
//	        }
//		}catch(Exception e){
//			e.printStackTrace();
//			throw new BusinessException(e);
//		}
//		return corpMap;
//		
//	}
}

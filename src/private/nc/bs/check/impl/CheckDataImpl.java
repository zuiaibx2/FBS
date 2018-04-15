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
 * У�����ݲ�ѯ���ݿ�ʵ����
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
		//��0001���յ���������С��pk_corp��Ӧ���ŵ�pk_corp
		//{1087=1888, 1089=1089, 0001=1888, 1088=1088}
		dataControl.put("0001", PubTool.toString(((Object[]) list.get(0))[1]));
		return dataControl;
	}

	/* (non-Javadoc) ת����������
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
					throw new BusinessException("����" + tbname + "���ֶ�Ϊ��'"
							+ pkFields[i] + "'��������ʽ����ȷ������ϵҵ����Ա����");
				}

				String pk_new = getNewPk(pkOld, mapCorp, checkvo);
						
				checkvo.setAttributeValue(pkFields[i], pk_new);

			}
		}
		//�޸ı������ݵ�pk_corp
		String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
		if(!"0001".equals(pk_corp)){
			checkvo.setAttributeValue("pk_corp", mapCorp.get(pk_corp));
		}
		//רҵ�˲Ź���-Ժʿר����Ϣά����hr_expert���������к���λ��pk_new_corp��Ҳ��Ҫת��
		String pk_new_corp = (String) checkvo.getAttributeValue("pk_new_corp");
		if(pk_new_corp!= null && checkvo.getTableName().endsWith("hr_expert") && !"0001".equals(pk_new_corp)){
			checkvo.setAttributeValue("pk_new_corp", mapCorp.get(pk_new_corp));
		}
		return checkvo;
	}
	
	/* (non-Javadoc) ��ȡ�µ�����
	 * @see nc.itf.check.ICheckData#getNewPk(java.lang.String, java.util.Map, nc.vo.pub.SuperVO)
	 */
	public String getNewPk(String pkOld, Map<String, String> mapCorp, SuperVO checkvo) throws BusinessException {
		String pkCorpOld = "", pkCorpNew = "";
		pkCorpOld = pkOld.substring(0, 4);
		
		//��Ա������Ϣ��˾����
		String pk_corp = PubTool.toString(checkvo.getAttributeValue("pk_corp"));
		//��Ա������Ϣ��˾����,���ֱ�����ֶ�Ϊ��
		String bas_pkcorp = PubTool.toString(checkvo.getAttributeValue("bas_pkcorp"));
		
		if(!"".equals(bas_pkcorp) && !pk_corp.equals(bas_pkcorp)){
			pk_corp = bas_pkcorp;
		}
		pkCorpNew = PubTool.toString(mapCorp.get(pk_corp));
		if("".equals(pkCorpNew)){
			throw new BusinessException("����Ϊ��" + pk_corp + "�Ĺ�˾�ڼ��Ų����ڣ����ʵ��");
		}
		String pk_new = "";

		if ("0001".equals(pkCorpOld)) {
			String q_Liu = pkOld.substring(0, 6);// ǰ��λ
													// 0001A320160926001122
													// 0001A3
			String h_Shi = pkOld.substring(10, 20);// ��ʮλ0001A320160926001122
													// 0926001122
			pk_new = q_Liu + pkCorpNew + h_Shi;// ��Ϻ�
												// 0001A310870926001122
		} else {
			pkCorpNew = PubTool.toString(mapCorp.get(pkCorpOld));
			/*********** �������⴦�����뿪ʼ ***********/
			//���ֹ�˾�Ѳ����ڣ�����ǰ��λ�Ҳ���ת����pk_corp�����⴦��
			//ֱ������˾���⴦�����������⴦���Ĺ�˾ע�ͼ���
			//FIXME ע�͵��Ĵ����������ļ�������ʽ���Ժ��ٶ����������ַ�ʽ
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
//					//ֱ������˾������1319����Ӧ������˾��1323,1324,1009��
//					pkCorpNew = PubTool.toString(mapCorp.get("1323"));
//				}
//				if("".equals(pkCorpNew) && "1319".equals(pkCorpOld)){
//					pkCorpNew = PubTool.toString(mapCorp.get("1324"));
//				}
//			}
			
			/*********** �������⴦��������� ***********/
			if("".equals(pkCorpNew)){
				throw new BusinessException("����Ϊ��" + pkCorpOld + "�Ĺ�˾�ڼ��Ų����ڣ����ʵ��");
			}
			pk_new = pkOld.replaceFirst(pkCorpOld, pkCorpNew);// ��������ǰ��λ��˾������Ϊ�����·��Ĺ�˾����
			String oid = pk_new.substring(4, 6);
			pk_new = pk_new.replaceFirst(oid, "ZA");
		}
		return pk_new;
	}
	
//	private Map<String, String> corpMap = new HashMap<String, String>();
//	/**
//	 * ����ת�����⴦��,��ʼ����һ��map
//	 * @return ���⴦��pk_corp�ļ�ֵ��
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
package nc.bs.check.dbo.util;

import java.util.ArrayList;
import java.util.List;

import nc.bs.check.CheckVObynullpk;
import nc.bs.check.beanUtil.DataMap;
import nc.bs.framework.common.NCLocator;
import nc.itf.export.file.IFbsDataFileService;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

public class CheckDataUtil {

	/**
	 * @param list vo数据
	 * @param tipField 提示字段
	 * @param fieldNames 非空字段名称
	 * @param fields 非空字段
	 * @param tipName 提示字段名称
	 * @param defDocN_Duty 
	 * @param defDocF_Duty 
	 * @param tablename 表名
	 * @return
	 * @throws BusinessException 
	 */
	public boolean checkData(List<SuperVO> list,String tablename,String[] fields,String[] fieldNames,
			String[] defDocField, String[] defDocName,String[] pkFields, String[] pkName,
			 String tipField,String tipName,List<DataMap> dataControlMap,List<DataMap> defdocMap,
			 String[] notnull_other, String[] notnull_other_name) throws BusinessException {
		SuperVO vo =null;
		final List<SuperVO> logvos =new ArrayList<SuperVO>();//存放返回的新vo
		CheckVObynullpk checkVObynullpk = new CheckVObynullpk();
		SuperVO superVO = null;
		for (int i = 0; i < list.size(); i++) {
			superVO = list.get(i);
			vo =checkVObynullpk.checkNull(superVO,fields,fieldNames,defDocField,defDocName,pkFields,tipField,tipName,tablename,dataControlMap, defdocMap,notnull_other, notnull_other_name);
			if(vo!= null){
				logvos.add(vo);
			}
			vo =checkVObynullpk.checkDataControlAndPk(superVO,defDocField,defDocName,pkFields,tipField,tipName,tablename,dataControlMap, defdocMap);
			if(vo!= null){
				logvos.add(vo);
			}
			
		}
		
		if(logvos.size()>0){
			getService().saveLogVO_RequiresNew(logvos);
			return false;
		}
		return true;
	}
	
	IFbsDataFileService service  = null;
	private IFbsDataFileService getService(){
		if(service == null){
			service =NCLocator.getInstance().lookup(IFbsDataFileService.class);
		}
		return service;
	}
	
}

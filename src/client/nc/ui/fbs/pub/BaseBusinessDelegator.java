package nc.ui.fbs.pub;

import java.util.Hashtable;

import nc.ui.trade.bsdelegate.BusinessDelegator;
import nc.vo.pub.SuperVO;

/**
 * 
 * <b> ���ӱ��ݳ����������� </b>
 * <p>
 * �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������:2012-6-20 ����03:24:33
 * 
 * @author gejw
 * @version NCPrj 1.0
 */
public abstract class BaseBusinessDelegator extends BusinessDelegator {
	
	public BaseBusinessDelegator(){
		super();
	}
	
	@Override
	public Hashtable loadChildDataAry(String[] tableCodes, String key) throws Exception {

		Class[] c = getChildVOClass();

//		����ѯ���ݷ���hashtable������
		Hashtable<String,SuperVO[]> dataHashTable = new Hashtable<String,SuperVO[]>(tableCodes.length);

		for(int i=0;i<tableCodes.length;i++){
			SuperVO[] temp = getChildVO(c[i],key);
			if (temp != null && temp.length > 0){
				dataHashTable.put(tableCodes[i], temp);
			}
		}

		return dataHashTable;
	}

	protected SuperVO[] getChildVO(Class c,String key)throws Exception{
		return queryByCondition(c, getParentPKFieldName(c)+" = '" + key + "' and isnull(dr,0)=0 ");
	}
	
	public abstract Class[] getChildVOClass();
	
	public  String getParentPKFieldName(Class c) throws Exception{
		return ((SuperVO)c.newInstance()).getParentPKFieldName();
	}
	

}

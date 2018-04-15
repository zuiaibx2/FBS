package nc.bs.avic.djdz;

import java.util.ArrayList;

import nc.bs.trade.business.IBDBusiCheck;
import nc.bs.trade.comcheckunique.BillIsUnique;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.trade.comcheckunique.IUniqueFieldCheck;
import nc.vo.trade.pub.HYBillVO;
import nc.vo.trade.pub.IBDACTION;

/**
 * ѡ�����ú�̨У����
 * 
 * @author ZY
 * @date 2012-3-6
 * 
 */
public class ClientBackCHK implements IBDBusiCheck, IBDACTION, IUniqueFieldCheck
{

	public void check(int intBdAction, AggregatedValueObject vo, Object userObj) throws Exception
	{

		if (intBdAction == IBDACTION.SAVE)
		{
			onCheckSave((HYBillVO) vo);
		}

	}

	public void dealAfter(int intBdAction, AggregatedValueObject billVo, Object userObj) throws Exception
	{

	}

	/**
	 * Ψһ��У����ֶ���
	 */
	public ArrayList<String[]> getFieldArray()
	{
		ArrayList<String[]> fieldArray = new ArrayList<String[]>();
		fieldArray.add(new String[] { "category", "jt_pk" });
		return fieldArray;
	}

	/**
	 * Ψһ��У�����ʾ������
	 */
	public ArrayList<String[]> getNameArray()
	{
		ArrayList<String[]> nameArray = new ArrayList<String[]>();
		nameArray.add(new String[] { "���", "���Ŷ�Ӧ����"});
		return nameArray;
	}

	public boolean isDetail()
	{
		return false;
	}

	public boolean isSingleTable()
	{
		return false;
	}

	private void onCheckSave(HYBillVO vo) throws BusinessException
	{
		BillIsUnique check = new BillIsUnique();
		try
		{
			check.checkBDisUnique(vo, this.getClass().getName());
		}
		catch (BusinessException e)
		{
			e.printStackTrace();
			throw e;
		}
	}

}


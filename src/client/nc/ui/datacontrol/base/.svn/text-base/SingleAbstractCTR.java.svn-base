package nc.ui.datacontrol.base;

import nc.ui.trade.bill.ISingleController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;

/**
 * 
 * 基础设置单表控制基类
 * 
 * @author flq
 * @date 2012-2-17
 */
public abstract class SingleAbstractCTR extends AbstractCTR implements ISingleController
{

	public int[] getCardButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Edit, IBillButton.Line, IBillButton.Return, IBillButton.Save, IBillButton.Cancel, IBillButton.Refresh };

	}

	public int[] getListButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Edit, IBillButton.Line, IBillButton.Card, IBillButton.Refresh };

	}

	// boolean true:单表体，false:单表头
	public boolean isSingleDetail()
	{
		return false;
	}

	public int getBusinessActionType()
	{
		return IBusinessActionType.BD;
	}

	public String[] getCardBodyHideCol()
	{
		return null;
	}

	public boolean isShowCardRowNo()
	{
		return false;
	}

	public boolean isShowCardTotal()
	{
		return false;
	}

	public String getBodyCondition()
	{
		return null;
	}

	public String getBodyZYXKey()
	{
		return null;
	}

	public String getChildPkField()
	{
		return null;
	}

	public String getHeadZYXKey()
	{
		return null;
	}

	public String getPkField()
	{
		return null;
	}

	public Boolean isEditInGoing() throws Exception
	{
		return null;
	}

	public boolean isExistBillStatus()
	{
		return false;
	}

	public boolean isLoadCardFormula()
	{
		return false;
	}

}

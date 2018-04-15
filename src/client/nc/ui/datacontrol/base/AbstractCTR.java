package nc.ui.datacontrol.base;

import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;

/**
 * 
 * 基础设置主子表控制基类
 * 
 * @author duyt
 * @author jieely
 * @date 2012-2-21
 */
public abstract class AbstractCTR extends AbstractManageController
{
	public abstract String getBillType();

	public abstract String[] getBillVoName();

	public int[] getCardButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Edit, IBillButton.Line, IBillButton.Return, IBillButton.Save, IBillButton.Cancel, IBillButton.Refresh };

	}

	public int[] getListButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Edit, IBillButton.Card, IBillButton.Refresh };

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
		return true;
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

	public String[] getListBodyHideCol()
	{
		return null;
	}

	public String[] getListHeadHideCol()
	{
		return null;
	}

	public boolean isShowListRowNo()
	{
		return true;
	}

	public boolean isShowListTotal()
	{
		return false;
	}

}

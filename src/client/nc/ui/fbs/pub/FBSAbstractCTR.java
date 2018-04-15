package nc.ui.fbs.pub;

import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;
//
/**
 * 业务单据控制抽象基类        
 * 
 * @author zongy
 * @since 2012-09-13
 */
public abstract class FBSAbstractCTR extends AbstractManageController {

	public FBSAbstractCTR()
	{
		super();
	}

	public abstract String getBillType();

	public abstract String[] getBillVoName();

	public abstract String getChildPkField();

	public abstract String getPkField();

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

	public int getBusinessActionType()
	{

		return IBusinessActionType.BD;
	}

	public int[] getListButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Query, IBillButton.Card, IBillButton.Refresh };

	}

	public int[] getCardButtonAry()
	{
		return new int[] { IBillButton.Add, IBillButton.Edit, IBillButton.Query, IBillButton.Return, IBillButton.Save, IBillButton.Cancel, IBillButton.Delete, IBillButton.Action, IBillButton.Refresh, IBillButton.Brow, IBillButton.Print,
		         };
	}

	public String getBodyZYXKey()
	{
		return null;
	}

	public String getHeadZYXKey()
	{
		return null;
	}

	public String getBodyCondition()
	{
		return null;
	}

	public Boolean isEditInGoing() throws Exception
	{
		return false;
	}
    //是否返回单据状态
	public boolean isExistBillStatus() 
	{
		return false;
	}

	public boolean isLoadCardFormula()
	{
		return true;
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

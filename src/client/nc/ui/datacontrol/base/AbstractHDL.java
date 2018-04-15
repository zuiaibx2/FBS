package nc.ui.datacontrol.base;

import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.ui.trade.manage.ManageEventHandler;

public abstract class AbstractHDL extends ManageEventHandler
{
	public BillManageUI billUI;

	protected AbstractManageController control;

	public AbstractHDL(BillManageUI billUI, IControllerBase control)
	{
		super(billUI, control);
		this.billUI = billUI;
		this.control = (AbstractManageController) control;
	}

}

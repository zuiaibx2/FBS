package nc.ui.datacontrol.PersonCtrl;

import nc.ui.fbs.pub.FBSAbstractEventHandler;
import nc.ui.pub.ButtonObject;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.vo.pub.SuperVO;

/**
 * 下级单位对照表 EventHandler
 * 
 */
public class ClientEH extends FBSAbstractEventHandler {

    public ClientEH(BillManageUI billUI, IControllerBase control) {
	super(billUI, control);
    }

    protected BillManageUI getUI() {
	return (BillManageUI) getBillUI();
    }

    @Override
    public void onBoAdd(ButtonObject bo) throws Exception {
	super.onBoAdd(bo);
    }

    @Override
    protected void onBoSave() throws Exception {

	getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();// 检测必输项是否有值
	super.onBoSave();
    }

	/* (non-Javadoc)
	 * @see nc.ui.trade.bill.BillEventHandler#onBoQuery()
	 */
	@Override
	protected void onBoQuery() throws Exception {

		StringBuffer strWhere = new StringBuffer();

		if (askForQueryCondition(strWhere) == false)
			return;// 用户放弃了查询
		SuperVO[] queryVos = queryHeadVOs(strWhere.toString());
		strWhere.append( " and "+ " pk_billtype='PC2'");
		getBufferData().clear();
		// 增加数据到Buffer
		addDataToBuffer(queryVos);

		updateBuffer();

	}

}

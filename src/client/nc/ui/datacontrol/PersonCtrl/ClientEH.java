package nc.ui.datacontrol.PersonCtrl;

import nc.ui.fbs.pub.FBSAbstractEventHandler;
import nc.ui.pub.ButtonObject;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.vo.pub.SuperVO;

/**
 * �¼���λ���ձ� EventHandler
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

	getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();// ���������Ƿ���ֵ
	super.onBoSave();
    }

	/* (non-Javadoc)
	 * @see nc.ui.trade.bill.BillEventHandler#onBoQuery()
	 */
	@Override
	protected void onBoQuery() throws Exception {

		StringBuffer strWhere = new StringBuffer();

		if (askForQueryCondition(strWhere) == false)
			return;// �û������˲�ѯ
		SuperVO[] queryVos = queryHeadVOs(strWhere.toString());
		strWhere.append( " and "+ " pk_billtype='PC2'");
		getBufferData().clear();
		// �������ݵ�Buffer
		addDataToBuffer(queryVos);

		updateBuffer();

	}

}

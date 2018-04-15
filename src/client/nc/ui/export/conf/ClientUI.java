package nc.ui.export.conf;

import nc.bs.logging.Logger;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemEvent;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.ICardController;
import nc.ui.trade.card.BillCardUI;
import nc.ui.trade.card.CardEventHandler;
import nc.vo.pub.SuperVO;
import nc.vo.trade.pub.HYBillVO;

/**
 * @ClassName: ClientUI <b> ���ݳ�ȡ��˾����UI����� </b>
 *             <p>
 *             �ڴ˴����Ӵ����������Ϣ
 *             </p>
 *             ��������: 2016��11��11�� ����2:32:30
 * @Author ����ǿ
 * @Version
 */
public class ClientUI extends BillCardUI implements nc.ui.pub.bill.BillCardBeforeEditListener {

	private static final long serialVersionUID = 2345667L;

	/**
	 * 
	 */
	public ClientUI() {
		// TODO �Զ����ɹ��캯�����
		super();
		readData();
		this.getBillCardPanel().setBillBeforeEditListenerHeadTail(this);
	}

	/**
	 * ˵����
	 * 
	 */
	public ClientUI(String pk_corp, String pk_billType, String pk_busitype, String operater, String billId) {
		super(pk_corp, pk_billType, pk_busitype, operater, billId);
		readData();
		this.getBillCardPanel().setBillBeforeEditListenerHeadTail(this);
		// TODO �Զ����ɹ��캯�����
	}

	/**
	 * 
	 * ˵������ȡ���ݿ�������,����ʾ�ڽ���
	 *
	 */
	public void readData() {

		HYBillVO[] dataVOs = new HYBillVO[1];
		SuperVO[] bodyVOs = null;
		try {
			Class<?> c = Class.forName(createController().getBillVoName()[1]);
			bodyVOs = getBusiDelegator().queryByCondition(c, " isnull(dr,0)=0 " + getQueryWherePart());
			if (bodyVOs != null) {
				dataVOs[0] = new HYBillVO();
				dataVOs[0].setChildrenVO(bodyVOs);
				dataVOs[0].setParentVO(null);
			}
		} catch (java.lang.Exception e) {
			e.printStackTrace();
		}

		getBufferData().clear();
		if (getBufferData() == null || getBufferData().getVOBufferSize() <= 0) {
			getBufferData().addVOsToBuffer(dataVOs);
		} else {
			getBufferData().clear();
			if (dataVOs[0].getChildrenVO() != null && dataVOs[0].getChildrenVO().length > 0)
				getBufferData().setCurrentVO(dataVOs[0]);
			else
				getBufferData().clear();
		}
		// getBufferData().setCurrentRow(0);

		try {
			if (getBufferData().getVOBufferSize() != 0) {

				setListHeadData(getBufferData().getAllHeadVOsFromBuffer());

				setBillOperate(IBillOperate.OP_NOTEDIT);
				getBufferData().setCurrentRow(0);
			} else {
				setListHeadData(null);
				setBillOperate(IBillOperate.OP_INIT);
				getBufferData().setCurrentRow(-1);
				showHintMessage(nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000066")/* @res "û�в鵽�κ���������������!" */);
			}
		} catch (Exception e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see nc.ui.trade.card.BillCardUI#createController()
	 */
	@Override
	protected ICardController createController() {
		// TODO �Զ����ɷ������
		return new ClientCtrl();
	}

	@Override
	protected CardEventHandler createEventHandler() {
		return new ClientEH(this, getUIControl());
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see nc.ui.trade.base.AbstractBillUI#getRefBillType()
	 */
	@Override
	public String getRefBillType() {
		// TODO �Զ����ɷ������
		return null;
	}

	/*
	 * ���� Javadoc��
	 * 
	 * @see nc.ui.trade.base.AbstractBillUI#initSelfData()
	 */
	@Override
	protected void initSelfData() {

	}

	@Override
	public void setDefaultData() throws Exception {

	}

	@Override
	public boolean beforeEdit(BillEditEvent e) {
		if ("corp_code".equals(e.getKey())) {
			BillItem corp_code = getBillCardPanel().getBodyItem("corp_code");
			UIRefPane pane = (UIRefPane) corp_code.getComponent();
			pane.setMultiSelectedEnabled(true);
		}

		return super.beforeEdit(e);
	}

	/*
	 * (non-Javadoc) �༭���¼�
	 * 
	 * @see nc.ui.fbs.pub.FBSAbstractUI#afterEdit(nc.ui.pub.bill.BillEditEvent)
	 */
	public void afterEdit(BillEditEvent e) {
		try {
			super.afterEdit(e);
		} catch (Exception ex) {
			Logger.error(ex.getMessage(), ex);
			MessageDialog.showWarningDlg(this, "��ʾ", "����:" + ex.getMessage() + ",������ϸ��Ϣ��������־!");
		}
	}

	protected String getQueryWherePart() {
		return "";
	}

	public boolean beforeEdit(BillItemEvent e) {

		return false;
	}
}
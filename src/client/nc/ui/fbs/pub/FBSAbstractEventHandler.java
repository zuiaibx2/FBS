package nc.ui.fbs.pub;

import org.apache.commons.lang.StringUtils;

import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillModel;
import nc.ui.pub.pf.PfUtilClient;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.bill.ISingleController;
import nc.ui.trade.business.HYPubBO_Client;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.trade.pub.IExAggVO;

//
/**
 * �����¼�����������
 * 
 * @author zhangjh
 * @since 2012-08-28
 */

public abstract class FBSAbstractEventHandler extends ManageEventHandler {

	protected final BillManageUI billUI;

	protected final AbstractManageController control;

	public FBSAbstractEventHandler(BillManageUI billUI, IControllerBase control) {
		super(billUI, control);
		this.billUI = billUI;
		this.control = (AbstractManageController) control;
	}
	
	@Override
	protected void onBoSave() throws Exception {
		// checkNullHead();
		// checkNullBody();
		getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();

		// getBillCardPanelWrapper().getBillCardPanel().getHeadItem("pk_corp").setValue(_getCorp().getPk_corp());//
		// ��˾
		// getBillCardPanelWrapper().getBillCardPanel().getHeadItem("bill_writer").setValue(_getOperator());//
		// �޸���
		// getBillCardPanelWrapper().getBillCardPanel().getHeadItem("bill_write_date").setValue(_getDate());//
		// �޸�����
		//
		// System.out.println(getBillCardPanelWrapper().getBillCardPanel().getHeadItem("pk_corp").getValue());
		super.onBoSave();
		// afterOnBoBtn();
	}


	/**
	 * ȫѡ��ť
	 */
	protected void onBoSelAll() throws Exception {
		if (billUI.isListPanelSelected()) {
			int rowcount = billUI.getBillListPanel().getHeadTable().getRowCount();
			for (int i = 0; i < rowcount; i++) {
				billUI.getBillListPanel().getHeadBillModel().setRowState(i, BillModel.SELECTED);
			}
		}
	}

	/**
	 * ȫ����ť.
	 */
	protected void onBoSelNone() throws Exception {
		if (billUI.isListPanelSelected()) {
			int rowcount = billUI.getBillListPanel().getHeadTable().getRowCount();
			for (int i = 0; i < rowcount; i++) {
				if (billUI.getBillListPanel().getHeadBillModel().getRowState(i) == BillModel.SELECTED)
					billUI.getBillListPanel().getHeadBillModel().setRowState(i, BillModel.UNSTATE);
			}
		}
	}

	/**
	 * �������Ʒ��� item <br>
	 * �����ڷǱ���item<br>
	 * �������ڣ�2008-10-27
	 * 
	 * @param name
	 *            item name
	 * @return BillItem
	 */
	public BillItem getItem(String name) throws Exception {
		if (StringUtils.isBlank(name)) {
			//billUI.showErrorMessage("ErmAbstractEventHandler.getItem(String name)������nameΪ��");
			return null;
		}
		if (billUI.getBillCardPanel().getHeadItem(name) != null) {
			return billUI.getBillCardPanel().getHeadItem(name);
		} else if (billUI.getBillCardPanel().getTailItem(name) != null) {
			return billUI.getBillCardPanel().getTailItem(name);
		} else {
			//billUI.showErrorMessage("ErmAbstractEventHandler.getItem(String name)��û�л�ȡ���ֶ�" + name);
			return null;
		}
	}

	/**
	 * �ж�Ԫ���Ƿ�ɱ༭<br>
	 * �����ڷǱ���item<br>
	 * �ɱ༭ ���� true �����ɱ༭���� false û�ж�ӦԪ�� ����null <br>
	 * �������ڣ�2008-10-27
	 * 
	 * @param name
	 *            item name
	 * @return Boolean
	 */
	public Boolean isEnabled(String itemkey) throws Exception {
		return getItem(itemkey).isEnabled();
	}

	/**
	 * ��item ��ֵ �������ڣ�2008-10-30<br>
	 * �����ڷǱ���item<br>
	 * 
	 * @return void
	 * @param name
	 *            Ԫ������
	 * @param value
	 *            ֵ
	 */
	public void setItemValue(String name, Object value) throws Exception {
		if (getItem(name) != null) {
			getItem(name).setValue(value);
		}
	}

	@Override
	protected void onBoLineAdd() throws Exception {
		super.onBoLineAdd();

	}

	@Override
	protected void onBoDelete() throws Exception {
		// super.onBoDelete();
		// ����û�����ݻ��������ݵ���û��ѡ���κ���
		if (getBufferData().getCurrentVO() == null)
			return;

		if (MessageDialog.showOkCancelDlg(getBillUI(),
				nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000064")/* @res "����ɾ��" */,
				nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000065")/* @res "�Ƿ�ȷ��ɾ���û�������?" */
				, MessageDialog.ID_CANCEL) != UIDialog.ID_OK)
			return;

		AggregatedValueObject modelVo = getBufferData().getCurrentVO();
		// getBusinessAction().delete(modelVo, getUIController().getBillType(),
		// getBillUI()._getDate().toString(), getBillUI().getUserObject());

		// �Ĳ���ֱ��ɾ���ķ�ʽ
		// ɾ���ӱ�
		if (modelVo instanceof IExAggVO) {
			SuperVO[] items = (SuperVO[]) ((IExAggVO) modelVo).getAllChildrenVO();
			if (items != null && items.length > 0) {
				for (SuperVO item : items) {
					HYPubBO_Client.delete(item);
				}
			}
			HYPubBO_Client.delete((SuperVO) modelVo.getParentVO());
		} else {
			SuperVO[] items = (SuperVO[]) modelVo.getChildrenVO();
			if (items != null && items.length > 0) {
				for (SuperVO item : items) {
					HYPubBO_Client.delete(item);
				}
			}
			HYPubBO_Client.delete((SuperVO) modelVo.getParentVO());
		}

		if (PfUtilClient.isSuccess()) {
			// �����������
			getBillUI().removeListHeadData(getBufferData().getCurrentRow());
			if (getUIController() instanceof ISingleController) {
				ISingleController sctl = (ISingleController) getUIController();
				if (!sctl.isSingleDetail())
					getBufferData().removeCurrentRow();
			} else {
				getBufferData().removeCurrentRow();
			}

		}
		if (getBufferData().getVOBufferSize() == 0)
			getBillUI().setBillOperate(IBillOperate.OP_INIT);
		else
			getBillUI().setBillOperate(IBillOperate.OP_NOTEDIT);
		getBufferData().setCurrentRow(getBufferData().getCurrentRow());
	}

	/**
	 * <strong>Description:�õ���ͷĳ�ֶ�ֵ</strong><br>
	 * <br>
	 * 
	 * @param headItemKey
	 * @return
	 */
	public Object getHeadItemValue(String headItemKey) {
		return getBillCardPanelWrapper().getBillCardPanel().getHeadItem(headItemKey).getValueObject();
	}

	/**
	 * ����
	 * 
	 * @throws Exception
	 */
	protected void onBoFileWrite() throws Exception {

		// String strObjectPk = getObjectPk();
		//
		// EhrAttachmentDialog attachmentDialog = new
		// EhrAttachmentDialog(getBillUI(), strObjectPk, ((SuperVO)
		// (getBillUI().getBufferData().getCurrentVO().getParentVO())).getTableName());
		//
		// attachmentDialog.setFileBtnUsable(0);
		//
		// attachmentDialog.setUsePower(false);
		//
		// attachmentDialog.showModal();
	}

	/**
	 * ��õ�ǰVO�ı�ͷ����
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String getObjectPk() throws BusinessException {
		AggregatedValueObject hrAggVO = getBillUI().getBufferData().getCurrentVO();

		String strErrorMsg = "��ѡ�����ݣ�";

		if (hrAggVO == null || hrAggVO.getParentVO() == null) {
			throw new BusinessException(strErrorMsg);
		}

		String strObjectPk = hrAggVO.getParentVO().getPrimaryKey();

		if (strObjectPk == null || strObjectPk.trim().length() == 0) {
			throw new BusinessException("��ǰû�����ݣ�����ά��������");
		}

		return strObjectPk;
	}

}

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
 * 单据事件处理抽象基类
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
		// 公司
		// getBillCardPanelWrapper().getBillCardPanel().getHeadItem("bill_writer").setValue(_getOperator());//
		// 修改人
		// getBillCardPanelWrapper().getBillCardPanel().getHeadItem("bill_write_date").setValue(_getDate());//
		// 修改日期
		//
		// System.out.println(getBillCardPanelWrapper().getBillCardPanel().getHeadItem("pk_corp").getValue());
		super.onBoSave();
		// afterOnBoBtn();
	}


	/**
	 * 全选按钮
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
	 * 全消按钮.
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
	 * 根据名称返回 item <br>
	 * 适用于非表体item<br>
	 * 创建日期：2008-10-27
	 * 
	 * @param name
	 *            item name
	 * @return BillItem
	 */
	public BillItem getItem(String name) throws Exception {
		if (StringUtils.isBlank(name)) {
			//billUI.showErrorMessage("ErmAbstractEventHandler.getItem(String name)，参数name为空");
			return null;
		}
		if (billUI.getBillCardPanel().getHeadItem(name) != null) {
			return billUI.getBillCardPanel().getHeadItem(name);
		} else if (billUI.getBillCardPanel().getTailItem(name) != null) {
			return billUI.getBillCardPanel().getTailItem(name);
		} else {
			//billUI.showErrorMessage("ErmAbstractEventHandler.getItem(String name)，没有获取到字段" + name);
			return null;
		}
	}

	/**
	 * 判断元素是否可编辑<br>
	 * 适用于非表体item<br>
	 * 可编辑 返回 true ，不可编辑返回 false 没有对应元素 返回null <br>
	 * 创建日期：2008-10-27
	 * 
	 * @param name
	 *            item name
	 * @return Boolean
	 */
	public Boolean isEnabled(String itemkey) throws Exception {
		return getItem(itemkey).isEnabled();
	}

	/**
	 * 给item 赋值 创建日期：2008-10-30<br>
	 * 适用于非表体item<br>
	 * 
	 * @return void
	 * @param name
	 *            元素名称
	 * @param value
	 *            值
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
		// 界面没有数据或者有数据但是没有选中任何行
		if (getBufferData().getCurrentVO() == null)
			return;

		if (MessageDialog.showOkCancelDlg(getBillUI(),
				nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000064")/* @res "档案删除" */,
				nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000065")/* @res "是否确认删除该基本档案?" */
				, MessageDialog.ID_CANCEL) != UIDialog.ID_OK)
			return;

		AggregatedValueObject modelVo = getBufferData().getCurrentVO();
		// getBusinessAction().delete(modelVo, getUIController().getBillType(),
		// getBillUI()._getDate().toString(), getBillUI().getUserObject());

		// 改采用直接删除的方式
		// 删除子表
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
			// 清除界面数据
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
	 * <strong>Description:得到表头某字段值</strong><br>
	 * <br>
	 * 
	 * @param headItemKey
	 * @return
	 */
	public Object getHeadItemValue(String headItemKey) {
		return getBillCardPanelWrapper().getBillCardPanel().getHeadItem(headItemKey).getValueObject();
	}

	/**
	 * 附件
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
	 * 获得当前VO的表头主键
	 * 
	 * @return
	 * @throws BusinessException
	 */
	public String getObjectPk() throws BusinessException {
		AggregatedValueObject hrAggVO = getBillUI().getBufferData().getCurrentVO();

		String strErrorMsg = "请选择数据！";

		if (hrAggVO == null || hrAggVO.getParentVO() == null) {
			throw new BusinessException(strErrorMsg);
		}

		String strObjectPk = hrAggVO.getParentVO().getPrimaryKey();

		if (strObjectPk == null || strObjectPk.trim().length() == 0) {
			throw new BusinessException("当前没有数据，不能维护附件！");
		}

		return strObjectPk;
	}

}

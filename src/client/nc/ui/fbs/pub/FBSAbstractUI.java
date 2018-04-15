package nc.ui.fbs.pub;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import nc.ui.pub.bill.BillCardBeforeEditListener;
import nc.ui.pub.bill.BillData;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemEvent;
import nc.ui.pub.linkoperate.ILinkApproveData;
import nc.ui.pub.linkoperate.ILinkMaintainData;
import nc.ui.pub.linkoperate.ILinkQuery;
import nc.ui.pub.linkoperate.ILinkQueryData;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.BillTemplateWrapper;
import nc.ui.trade.button.IBillButton;
import nc.ui.trade.manage.BillManageUI;
import nc.vo.logging.Debug;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;

//
/**
 * ���ӱ����ݳ���UI����
 * 
 * @author ge
 * @date 2011-09-13
 */
public abstract class FBSAbstractUI extends BillManageUI implements ILinkQuery, BillCardBeforeEditListener {

	private static final long serialVersionUID = 1L;

	public FBSAbstractUI() {
		super();
		afterInit();
	}

	@Override
	public void setBodySpecialData(CircularlyAccessibleValueObject[] vos) throws Exception {
	}

	@Override
	protected void setHeadSpecialData(CircularlyAccessibleValueObject vo, int intRow) throws Exception {
	}

	@Override
	protected void setTotalHeadSpecialData(CircularlyAccessibleValueObject[] vos) throws Exception {
	}

	public boolean isSaveAndCommitTogether() {
		return false;
	}

	@Override
	public String checkPrerequisite() {
		return null;
	}

	/**
	 * ����ʼ������޸�
	 * 
	 */
	protected void afterInit() {
		if (isRemoveLineChildBtn())
			removeChildWithLine();
	}

	@Override
	protected void initSelfData() {
		// �Զ�ִ�б�ͷ��β�༭��ʽ
		getBillCardPanel().setAutoExecHeadEditFormula(true);
		// ���ӱ�ͷ�༭ǰ�¼�����
		getBillCardPanel().setBillBeforeEditListenerHeadTail(this);
		// �б���ѡ��򣬿ɶ�ѡ
		// getBillListPanel().setMultiSelect(true);

		// Add by gejw 2010-09-03 ���ý��Ϊ��ʱ��ʾ
		nc.vo.pub.bill.BillRendererVO cellVO = new nc.vo.pub.bill.BillRendererVO();
		cellVO.setShowZeroLikeNull(false);
		cellVO.setShowThMark(true);
		getBillCardPanel().setBodyShowFlags(cellVO);

//		getBillCardPanel().setShowThMark(true);
		BillItem items[] = getBillCardPanel().getHeadItems();

		getBillCardPanel().setHeadTailShowThMark(items, true);
//		getBillListPanel().getParentListPanel().setShowThMark(true);
//		getBillListPanel().getChildListPanel().setShowThMark(true);

		// removeChildWithLine();
	}

	@Override
	public void afterUpdate() {
		super.afterUpdate();
		afterOnBoBtn();
	}

	/**
	 * ��ʼ��Ƭ״̬����һ������һ����ť״̬����
	 */
	protected void afterOnBoBtn() {
		//updateButtons();
	}

	/*
	 * ��ʼ�� �������͡���˾��¼���ˡ�����״̬ (non-Javadoc)
	 * 
	 * @see nc.ui.trade.base.AbstractBillUI#setDefaultData()
	 */
	@Override
	public void setDefaultData() throws Exception {
//		BillField fileDef = BillField.getInstance();
//		String billtype = getUIControl().getBillType();
//		String pkCorp = _getCorp().getPrimaryKey();
//		String[] itemkeys = new String[] { fileDef.getField_Corp(), fileDef.getField_Billtype(),
//				fileDef.getField_Operator(), fileDef.getField_BillStatus() };
//		Object[] values = new Object[] { pkCorp, billtype, _getOperator(),
//				Integer.valueOf(IBillStatus.FREE).toString() };
//
//		for (int i = 0; i < itemkeys.length; i++) {
//			BillItem item = null;
//			item = getBillCardPanel().getHeadItem(itemkeys[i]);
//			if (item == null)
//				item = getBillCardPanel().getTailItem(itemkeys[i]);
//			if (item != null)
//				item.setValue(values[i]);
//		}
	}

	/**
	 * ��ͷ�༭ǰ�¼�
	 */
	public boolean beforeEdit(BillItemEvent e) {
		if (getBillOperate() == IBillOperate.OP_NOTEDIT || getBillOperate() == IBillOperate.OP_INIT) {
			return false;
		}
		return true;
	}

	/**
	 * ����༭ǰ�¼�
	 */
	@Override
	public boolean beforeEdit(BillEditEvent e) {
		boolean ret = super.beforeEdit(e);

		return ret;
	}

	@Override
	public void afterEdit(BillEditEvent e) {
		if (e.getPos() == HEAD) {
			afterHeadEdit(e);
		} else if (e.getPos() == BODY) {
			afterBodyEdit(e);
		}
		super.afterEdit(e);
	}

	public void afterBodyEdit(BillEditEvent e) {
		// doWriteInumber();
	}

	public void afterHeadEdit(BillEditEvent e) {

	}

	// @Override
	// public void doApproveAction(ILinkApproveData approvedata)
	// {
	// super.doApproveAction(approvedata);
	// }
	//
	// @Override
	// public void doMaintainAction(ILinkMaintainData maintaindata)
	// {
	// super.doMaintainAction(maintaindata);
	// }

	/**
	 * ����
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void doQueryAction(ILinkQueryData querydata) {
		try {
			Object userObj = querydata.getUserObject();
			if (userObj == null || !(userObj instanceof ArrayList<?>)) {
				throw new BusinessException("��������querydata.getUserObject()");
			}
			ArrayList<String> pkList = (ArrayList<String>) userObj;
			if (pkList.size() == 0)
				return;
			String pkField = getUIControl().getPkField();
			if (StringUtils.isBlank(pkField)) {
				throw new BusinessException("getUIControl().getPkField()Ϊ��");
			}
			StringBuffer strWhere = new StringBuffer(" dr=0 and ").append(pkField).append(" in (");
			for (String pk : pkList) {
				strWhere.append("'").append(pk).append("',");
			}
			strWhere.setLength(strWhere.length() - 1);
			strWhere.append(")");

			SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(Class.forName(getUIControl().getBillVoName()[1]),
					getUIControl().getBillType(), strWhere.toString());
			// ��ջ�������
			getBufferData().clear();
			if (queryVos != null && queryVos.length > 0) {
				for (int i = 0; i < queryVos.length; i++) {
					AggregatedValueObject aVo = (AggregatedValueObject) Class.forName(getUIControl().getBillVoName()[0])
							.newInstance();
					aVo.setParentVO(queryVos[i]);
					getBufferData().addVOToBuffer(aVo);
				}
				setListHeadData(queryVos);
				if (queryVos.length > 1)
					setCurrentPanel(BillTemplateWrapper.LISTPANEL);
				else
					setCurrentPanel(BillTemplateWrapper.CARDPANEL);
				getBufferData().setCurrentRow(0);
				setBillOperate(IBillOperate.OP_NOTEDIT);
			} else {
				getBufferData().setCurrentRow(-1);
				setBillOperate(IBillOperate.OP_INIT);
			}
		} catch (Exception ex) {
			Debug.error(ex);
		}
	}

	/**
	 * <strong>Description:�õ���ͷĳ�ֶ�ֵ</strong><br>
	 * <br>
	 * 
	 * @param headItemKey
	 * @return
	 */
	public Object getHeadItemValue(String headItemKey) {
		return getBillCardPanel().getHeadItem(headItemKey).getValueObject();
	}

	/**
	 * <strong>Description:���ñ�ͷֵ</strong><br>
	 * 
	 * @param headItemKey
	 * @param ovalue
	 */
	public void setHeadItemValue(String headItemKey, Object ovalue) {
		/**
		 * �жϵ�ǰ�����ǿ�Ƭ�����б�
		 */
		if (isListPanelSelected()) {
			int currentRow = getBillListPanel().getHeadTable().getSelectedRow();
			getBillListPanel().getBillListData().getHeadBillModel().setValueAt(ovalue, currentRow, headItemKey);
		} else {
			getBillCardPanel().setHeadItem(headItemKey, ovalue);
		}
	}

	/**
	 * <strong>Description:�õ�������ֶ�ֵ</strong><br>
	 * 
	 * @param row
	 * @param bodyItemKey
	 * @return
	 */
	public Object getBodyItemValue(int row, String bodyItemKey) {
		return getBillCardPanel().getBodyValueAt(row, bodyItemKey);
	}

	/**
	 * <strong>Description:���ñ���ĳ�е�ĳ���ֶ�ֵ</strong><br>
	 * 
	 * @param row
	 * @param bodyItemKey
	 * @param ovalue
	 */
	public void setBodyItemValue(int row, String bodyItemKey, Object ovalue) {
		getBillCardPanel().setBodyValueAt(ovalue, row, bodyItemKey);
	}

	/**
	 * �ж��������Ƿ���ĳһ��Ԫ��
	 * 
	 * @param str
	 * @return
	 */
	public boolean containts(String[] array, String str) {
		boolean isContains = false;
		for (String element : array) {
			if (element.equalsIgnoreCase(str))
				isContains = true;
		}
		return isContains;
	}

	/**
	 * ���ر����ҳǩ
	 * 
	 * @return
	 */
	public String[] getTablecodes() {
		return getBillCardPanel().getBillData().getTableCodes(BillData.BODY);
	}

	@Override
	protected void initPrivateButton() {
		super.initPrivateButton();
		// // ��һҳ
		// ButtonVO btnPrev =
		// PrivateButton.createButtonVO(IBillPrtButton.PREV_CODE,
		// IBillPrtButton.PREV_NAME, IBillPrtButton.PREV_NAME);
		// btnPrev.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
		// addPrivateButton(btnPrev);
		// // ��һҳ
		// ButtonVO btnNext =
		// PrivateButton.createButtonVO(IBillPrtButton.NEXT_CODE,
		// IBillPrtButton.NEXT_NAME, IBillPrtButton.NEXT_NAME);
		// btnNext.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
		// addPrivateButton(btnNext);

	}

	/**
	 * 
	 * <strong>Description:</strong><br>
	 * Ĭ���Ƴ� ���ơ�ճ���С� ճ���е���β�� ������<br>
	 * ��Ҫʱ������<br>
	 * 
	 * @return1
	 * 
	 */
	protected int[] childBtnGroup() {
		return null;
		// ȥ�����ơ�ճ���С� ճ���е���β�� ������
		// return new int[] { IBillButton.InsLine,IBillButton.CopyLine,
		// IBillButton.PasteLine, IBillButton.PasteLinetoTail };
	}

	private void removeChildWithLine() {
		if (isRemoveLineChildBtn())
			removeChildButton(IBillButton.Line, childBtnGroup());
	}

	/**
	 * 
	 * <strong>Description:�Ƴ��Ӱ�ť</strong><br>
	 * <br>
	 * 
	 * @param fatherBtn
	 *            ����ť
	 * @param childBtn
	 *            ��Ҫ�Ƴ����Ӱ�ť
	 */
	protected void removeChildButton(int fatherBtn, int[] childBtn) {
		// if (childBtn.length <= 0)
		// return;
		// for (int btn : childBtn)
		// this.getButtonManager().getButton(fatherBtn).removeChildButton(getButtonManager().getButton(btn));

	}

	/**
	 * 
	 * <strong>Description:</strong><br>
	 * �Ƿ�ɾ���� �����е� ���ơ�ճ���С� ճ���е���β�� ������<br>
	 * 
	 * @date 2010-8-23 ����09:53:31
	 * @return
	 */
	protected boolean isRemoveLineChildBtn() {
		return false;

	}

	/**
	 * ��ʼ������״̬:
	 * </p>
	 * Ĭ�ϵ���״̬�ֶ�Ϊ:getBillField().getField_BillStatus()
	 * </p>
	 * Ĭ�ϵ���״̬Ϊ:IETBillStatus.strStateRemark
	 */
	public void initBillStatus() {
		// ��ʼ������״̬
		if (getUIControl().isExistBillStatus()) {
			getBillCardWrapper().initHeadComboBox(getBillField().getField_BillStatus(), strStateRemark, true);
			getBillListWrapper().initHeadComboBox(getBillField().getField_BillStatus(), strStateRemark, true);

		}
	}

	// ״̬����
	public static String[] strStateRemark = new String[] { "δ��׼", "����׼", "������", "���ύ", "������", "�ѳ���", "��ֹ(����)", "����̬",
			"��д��" };

	/***************************************************************************
	 * <br>
	 * ����������<br>
	 * Created on 2006-4-29 14:36:06<br>
	 * 
	 * @author Rocex Wang
	 * @param iPosition
	 *            λ�ã�ȡֵĬ��ΪIBillItem.HEAD(��ͷ)��IBillItem.BODY(����)��IBillItem
	 *            .TAIL(��β)
	 * @param strTabCode
	 *            ҳǩ����
	 * @param strItemCode
	 *            �ֶα���
	 * @param objValues
	 *            �������ȡֵ
	 * @param blIsWithIndex
	 *            ����ֵ�Ƿ�index
	 **************************************************************************/

	/**
	 * �����Ŷ�����
	 *
	 */
	// protected void doWriteInumber()
	// {
	// int irows = getBillCardPanel().getBillTable().getRowCount();
	// if (irows > 0)
	// {
	// getBillCardPanel().setHeadItem(BUSINESSABROADVO.INUMBER, irows);
	//
	// }
	// }

	@Override
	public void doMaintainAction(ILinkMaintainData maintaindata) {
		setCurrentPanel(BillTemplateWrapper.CARDPANEL);
		// ��������
		try {
			getBufferData().clear();// �����BufferData
			getBufferData().addVOToBuffer(loadHeadData(maintaindata.getBillID()));
			setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
			getBufferData().setCurrentRow(getBufferData().getCurrentRow());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * �����������
	 */
	public void doApproveAction(ILinkApproveData approvedata) {
		// setBusinessType(approvedata.pk_busitype);
		setCurrentPanel(BillTemplateWrapper.CARDPANEL);
		// ��������
		try {
			getBufferData().clear();// �����BufferData
			getBufferData().addVOToBuffer(loadHeadData(approvedata.getBillID()));
			setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
			getBufferData().setCurrentRow(getBufferData().getCurrentRow());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
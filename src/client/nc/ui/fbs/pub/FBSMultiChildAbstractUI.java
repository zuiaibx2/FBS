package nc.ui.fbs.pub;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import nc.cmp.utils.BillcodeGenerater;
import nc.ui.glpub.IUiPanel;
import nc.ui.pub.bill.BillCardBeforeEditListener;
import nc.ui.pub.bill.BillData;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillItemEvent;
import nc.ui.pub.linkoperate.ILinkApproveData;
import nc.ui.pub.linkoperate.ILinkMaintainData;
import nc.ui.pub.linkoperate.ILinkQuery;
import nc.ui.pub.linkoperate.ILinkQueryData;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.BillTemplateWrapper;
import nc.ui.trade.button.IBillButton;
import nc.ui.trade.multichild.MultiChildBillManageUI;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;

/**
 * ���ӱ��ݳ���UI����
 * @author ge
 * @date 2011-09-13
 * 
 */
public abstract class FBSMultiChildAbstractUI extends MultiChildBillManageUI implements IUiPanel, ILinkQuery,
		BillCardBeforeEditListener {

	private static final long serialVersionUID = 3726046459578922791L;

	public FBSMultiChildAbstractUI() {
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
		return true;
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
		// ��ӱ�ͷ�༭ǰ�¼�����
		getBillCardPanel().setBillBeforeEditListenerHeadTail(this);
		// �б���ѡ��򣬿ɶ�ѡ
		getBillListPanel().setMultiSelect(true);
		// ���ý��Ϊ��ʱ��ʾ
		nc.vo.pub.bill.BillRendererVO cellVO = new nc.vo.pub.bill.BillRendererVO();
		cellVO.setShowZeroLikeNull(false);
		getBillCardPanel().setBodyShowFlags(cellVO);
		
	}

	@Override
	public void setDefaultData() throws Exception {
//		BillField fileDef = BillField.getInstance();
//		String billtype = getUIControl().getBillType();
//		String pkCorp = _getCorp().getPrimaryKey();
//		String[] itemkeys = new String[] { fileDef.getField_Corp(), fileDef.getField_Billtype(),
//				fileDef.getField_Operator(), fileDef.getField_BillStatus() };
//		Object[] values = new Object[] { pkCorp, billtype, _getOperator(), Integer.valueOf(BillStatus.FREE).toString() };
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
	public void doApproveAction(ILinkApproveData approvedata) {
		super.doApproveAction(approvedata);
	}

	@Override
	public void doMaintainAction(ILinkMaintainData maintaindata) {
		super.doMaintainAction(maintaindata);
	}

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
					AggregatedValueObject aVo = (AggregatedValueObject) Class
							.forName(getUIControl().getBillVoName()[0]).newInstance();
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
			ex.printStackTrace();
		}
	}

	@Override
	public void afterEdit(BillEditEvent e) {
		super.afterEdit(e);
	}

	/**
	 * �ж��������Ƿ���ĳһ��Ԫ��
	 * 
	 * @author sigp
	 * @since 2010-8-16
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

	/**
	 * UIControl���Ƿ����button
	 * @param buttons
	 * @param button
	 * @return
	 */
//	private boolean isContaints(int[] buttons, int button) {
//
//		if (buttons == null || buttons.length <= 0) {
//			return false;
//		}
//		for (int i = 0; i < buttons.length; i++) {
//			if (buttons[i] == button) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
	/**
	 * 
	 * <strong>Description:</strong><br>
	 * Ĭ���Ƴ� ���ơ�ճ���С� ճ���е���β�� ������<br>
	 * ��Ҫʱ������<br>
	 * @return1
	 * 
	 */
	protected int[] childBtnGroup() {
		// ȥ�����ơ�ճ���С� ճ���е���β�� ������
		return null ;
//		return new int[] { IBillButton.CopyLine, IBillButton.PasteLine,
//				IBillButton.PasteLinetoTail, IBillButton.InsLine };
	}

	private void removeChildWithLine() {
		removeChildButton(IBillButton.Line, childBtnGroup());
	}
	/**
	 * 
	 * <strong>Description:�Ƴ��Ӱ�ť</strong><br>
	 * <br>
	 * @param fatherBtn
	 *            ����ť
	 * @param childBtn
	 *            ��Ҫ�Ƴ����Ӱ�ť
	 */
	protected void removeChildButton(int fatherBtn, int[] childBtn) {
		if (childBtn.length <= 0)
			return;
		for (int btn : childBtn)
			this.getButtonManager().getButton(fatherBtn).removeChildButton(
					getButtonManager().getButton(btn));

	}
	/**
	 * 
	 * <strong>Description:</strong><br>
	 * �Ƿ�ɾ���� �����е� ���ơ�ճ���С� ճ���е���β�� ������<br>
	 * @date 2010-8-23 ����09:53:31
	 * @return
	 */
	protected boolean isRemoveLineChildBtn() {
		return false;

	}
	public String getBillNo(String pk_billtype) throws BusinessException {
		BillcodeGenerater gene = new BillcodeGenerater();

		String billno = gene.getBillCode(pk_billtype, null,null,
				null, null);
		return billno;
	}
	@Override
	protected void initPrivateButton() {
		super.initPrivateButton();
////		 �Զ��尴ť������
//		ButtonVO btnFileUpload = PrivateButton.createButtonVO(
//				IBillPrtButton.fileUpload_code, IBillPrtButton.fileUpload_name,
//				IBillPrtButton.fileUpload_name);
//		btnFileUpload.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
//		addPrivateButton(btnFileUpload);
//		//��һҳ
//		ButtonVO btnPrev = PrivateButton.createButtonVO(
//				IBillPrtButton.PREV_CODE, IBillPrtButton.PREV_NAME,
//				IBillPrtButton.PREV_NAME);
//		btnPrev.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
//		addPrivateButton(btnPrev);
//		//��һҳ
//		ButtonVO btnNext = PrivateButton.createButtonVO(
//				IBillPrtButton.NEXT_CODE, IBillPrtButton.NEXT_NAME,
//				IBillPrtButton.NEXT_NAME);
//		btnNext.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
//		addPrivateButton(btnNext);
//		
	}
}

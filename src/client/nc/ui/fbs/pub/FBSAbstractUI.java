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
 * 单子表单据抽象UI基类
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
	 * 做初始化后的修改
	 * 
	 */
	protected void afterInit() {
		if (isRemoveLineChildBtn())
			removeChildWithLine();
	}

	@Override
	protected void initSelfData() {
		// 自动执行表头表尾编辑公式
		getBillCardPanel().setAutoExecHeadEditFormula(true);
		// 添加表头编辑前事件监听
		getBillCardPanel().setBillBeforeEditListenerHeadTail(this);
		// 列表有选择框，可多选
		// getBillListPanel().setMultiSelect(true);

		// Add by gejw 2010-09-03 设置金额为零时显示
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
	 * 初始卡片状态、上一条、下一条后按钮状态处理
	 */
	protected void afterOnBoBtn() {
		//updateButtons();
	}

	/*
	 * 初始化 单据类型、公司、录入人、单据状态 (non-Javadoc)
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
	 * 表头编辑前事件
	 */
	public boolean beforeEdit(BillItemEvent e) {
		if (getBillOperate() == IBillOperate.OP_NOTEDIT || getBillOperate() == IBillOperate.OP_INIT) {
			return false;
		}
		return true;
	}

	/**
	 * 表体编辑前事件
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
	 * 联查
	 * 
	 */
	@SuppressWarnings("unchecked")
	public void doQueryAction(ILinkQueryData querydata) {
		try {
			Object userObj = querydata.getUserObject();
			if (userObj == null || !(userObj instanceof ArrayList<?>)) {
				throw new BusinessException("参数错误querydata.getUserObject()");
			}
			ArrayList<String> pkList = (ArrayList<String>) userObj;
			if (pkList.size() == 0)
				return;
			String pkField = getUIControl().getPkField();
			if (StringUtils.isBlank(pkField)) {
				throw new BusinessException("getUIControl().getPkField()为空");
			}
			StringBuffer strWhere = new StringBuffer(" dr=0 and ").append(pkField).append(" in (");
			for (String pk : pkList) {
				strWhere.append("'").append(pk).append("',");
			}
			strWhere.setLength(strWhere.length() - 1);
			strWhere.append(")");

			SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(Class.forName(getUIControl().getBillVoName()[1]),
					getUIControl().getBillType(), strWhere.toString());
			// 清空缓冲数据
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
	 * <strong>Description:得到表头某字段值</strong><br>
	 * <br>
	 * 
	 * @param headItemKey
	 * @return
	 */
	public Object getHeadItemValue(String headItemKey) {
		return getBillCardPanel().getHeadItem(headItemKey).getValueObject();
	}

	/**
	 * <strong>Description:设置表头值</strong><br>
	 * 
	 * @param headItemKey
	 * @param ovalue
	 */
	public void setHeadItemValue(String headItemKey, Object ovalue) {
		/**
		 * 判断当前界面是卡片还是列表
		 */
		if (isListPanelSelected()) {
			int currentRow = getBillListPanel().getHeadTable().getSelectedRow();
			getBillListPanel().getBillListData().getHeadBillModel().setValueAt(ovalue, currentRow, headItemKey);
		} else {
			getBillCardPanel().setHeadItem(headItemKey, ovalue);
		}
	}

	/**
	 * <strong>Description:得到表体的字段值</strong><br>
	 * 
	 * @param row
	 * @param bodyItemKey
	 * @return
	 */
	public Object getBodyItemValue(int row, String bodyItemKey) {
		return getBillCardPanel().getBodyValueAt(row, bodyItemKey);
	}

	/**
	 * <strong>Description:设置表体某行的某个字段值</strong><br>
	 * 
	 * @param row
	 * @param bodyItemKey
	 * @param ovalue
	 */
	public void setBodyItemValue(int row, String bodyItemKey, Object ovalue) {
		getBillCardPanel().setBodyValueAt(ovalue, row, bodyItemKey);
	}

	/**
	 * 判断数组中是否含有某一个元素
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
	 * 返回表体的页签
	 * 
	 * @return
	 */
	public String[] getTablecodes() {
		return getBillCardPanel().getBillData().getTableCodes(BillData.BODY);
	}

	@Override
	protected void initPrivateButton() {
		super.initPrivateButton();
		// // 上一页
		// ButtonVO btnPrev =
		// PrivateButton.createButtonVO(IBillPrtButton.PREV_CODE,
		// IBillPrtButton.PREV_NAME, IBillPrtButton.PREV_NAME);
		// btnPrev.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
		// addPrivateButton(btnPrev);
		// // 下一页
		// ButtonVO btnNext =
		// PrivateButton.createButtonVO(IBillPrtButton.NEXT_CODE,
		// IBillPrtButton.NEXT_NAME, IBillPrtButton.NEXT_NAME);
		// btnNext.setOperateStatus(new int[] { OP_INIT, OP_NOTEDIT });
		// addPrivateButton(btnNext);

	}

	/**
	 * 
	 * <strong>Description:</strong><br>
	 * 默认移除 复制、粘贴行、 粘贴行到表尾、 插入行<br>
	 * 必要时可重载<br>
	 * 
	 * @return1
	 * 
	 */
	protected int[] childBtnGroup() {
		return null;
		// 去掉复制、粘贴行、 粘贴行到表尾、 插入行
		// return new int[] { IBillButton.InsLine,IBillButton.CopyLine,
		// IBillButton.PasteLine, IBillButton.PasteLinetoTail };
	}

	private void removeChildWithLine() {
		if (isRemoveLineChildBtn())
			removeChildButton(IBillButton.Line, childBtnGroup());
	}

	/**
	 * 
	 * <strong>Description:移除子按钮</strong><br>
	 * <br>
	 * 
	 * @param fatherBtn
	 *            父按钮
	 * @param childBtn
	 *            需要移除的子按钮
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
	 * 是否删除行 操作中的 复制、粘贴行、 粘贴行到表尾、 插入行<br>
	 * 
	 * @date 2010-8-23 上午09:53:31
	 * @return
	 */
	protected boolean isRemoveLineChildBtn() {
		return false;

	}

	/**
	 * 初始化单据状态:
	 * </p>
	 * 默认单据状态字段为:getBillField().getField_BillStatus()
	 * </p>
	 * 默认单据状态为:IETBillStatus.strStateRemark
	 */
	public void initBillStatus() {
		// 初始化单据状态
		if (getUIControl().isExistBillStatus()) {
			getBillCardWrapper().initHeadComboBox(getBillField().getField_BillStatus(), strStateRemark, true);
			getBillListWrapper().initHeadComboBox(getBillField().getField_BillStatus(), strStateRemark, true);

		}
	}

	// 状态名称
	public static String[] strStateRemark = new String[] { "未批准", "已批准", "审批中", "已提交", "已作废", "已冲销", "终止(结算)", "冻结态",
			"编写中" };

	/***************************************************************************
	 * <br>
	 * 设置下拉框<br>
	 * Created on 2006-4-29 14:36:06<br>
	 * 
	 * @author Rocex Wang
	 * @param iPosition
	 *            位置，取值默认为IBillItem.HEAD(表头)、IBillItem.BODY(表体)、IBillItem
	 *            .TAIL(表尾)
	 * @param strTabCode
	 *            页签编码
	 * @param strItemCode
	 *            字段编码
	 * @param objValues
	 *            下拉框的取值
	 * @param blIsWithIndex
	 *            返回值是否index
	 **************************************************************************/

	/**
	 * 计算团队人数
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
		// 加载数据
		try {
			getBufferData().clear();// 先清空BufferData
			getBufferData().addVOToBuffer(loadHeadData(maintaindata.getBillID()));
			setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
			getBufferData().setCurrentRow(getBufferData().getCurrentRow());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 代办审核事物
	 */
	public void doApproveAction(ILinkApproveData approvedata) {
		// setBusinessType(approvedata.pk_busitype);
		setCurrentPanel(BillTemplateWrapper.CARDPANEL);
		// 加载数据
		try {
			getBufferData().clear();// 先清空BufferData
			getBufferData().addVOToBuffer(loadHeadData(approvedata.getBillID()));
			setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
			getBufferData().setCurrentRow(getBufferData().getCurrentRow());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

package nc.ui.datacontrol.base;

import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillMouseEnent;
import nc.ui.trade.button.IBillButton;
import nc.ui.trade.manage.BillManageUI;

/**
 * 
 * 基础设置UI基类
 * 
 * @author duyt
 * @author jieely
 * @date 2012-2-17
 */
public abstract class AbstractUI extends BillManageUI {

	private static final long serialVersionUID = 1L;

	public AbstractUI() {
		super();
		initData();
	}


	/**
	 * 子类重载，初始自己数据加载
	 * 
	 * @author duyt @date2012-2-24 下午02:02:05
	 */
	public void initData() {
		loadData();
		// 去掉按钮
		removeBtn();
	}

	/**
	 * 初始去掉按钮
	 * 
	 * @author duyt
	 * @date 2012-2-28
	 */
	public void removeBtn() {

		if (getButtonManager().getButton(IBillButton.Line) != null) {
			getButtonManager().getButton(IBillButton.Line)
					.removeChildButton(getButtonManager().getButton(IBillButton.InsLine));
			getButtonManager().getButton(IBillButton.Line)
					.removeChildButton(getButtonManager().getButton(IBillButton.CopyLine));
			getButtonManager().getButton(IBillButton.Line)
					.removeChildButton(getButtonManager().getButton(IBillButton.PasteLine));
		}
	}

	@Override
	protected void initSelfData() {
		getBillCardPanel().setAutoExecHeadEditFormula(true);

		getBillCardWrapper().getBillCardPanel().execHeadLoadFormulas();
		getBillCardPanel().execHeadLoadFormulas();

	}

	@Override
	public void setDefaultData() throws Exception {
		/*
		 * String billtype = getUIControl().getBillType(); String pkCorp =
		 * _getCorp().getPrimaryKey(); String[] itemkeys = new String[] {
		 * "pk_corp", "pk_billtype", "voperatorid", "dmakedate", "pk_org",
		 * "pk_super" }; Object[] values = new Object[] { pkCorp, billtype,
		 * _getOperator(), _getDate(), _getCorp().getDef1(),
		 * _getCorp().getFathercorp() }; for (int i = 0; i < itemkeys.length;
		 * i++) { BillItem item = null; item =
		 * getBillCardPanel().getHeadItem(itemkeys[i]); if (item == null) item =
		 * getBillCardPanel().getTailItem(itemkeys[i]); if (item != null)
		 * item.setValue(values[i]); }
		 * getBillCardPanel().execHeadLoadFormulas();
		 */
	}

	/**
	 * 加载数据，打开节点即查询数据
	 * 
	 * @author jieely
	 * @date 2012-2-27
	 */
	private void loadData() {
	/*	try {
			*//**
			 * 上级公司可查询下级公司数据&&下级公司可查询上级公司数据
			 *//*
			String pk_corp = _getCorp().getPk_corp();// 当前公司
			String pk_super = _getCorp().getFathercorp();// 所属上级
			String pk_org = _getCorp().getDef1();// 所属机构

			StringBuffer sql = new StringBuffer(" (ISNULL(dr,0)=0) ");
			sql.append(" AND ( pk_corp = '" + pk_corp + "'");// 当前公司数据
			sql.append(" OR pk_corp = '" + pk_super + "' OR pk_corp = '" + pk_org + "'");// 下级公司可以查看上级公司数据
			sql.append(" OR pk_super = '" + pk_corp + "' OR pk_org = '" + pk_corp + "'");// 上级公司可以查看下级公司数据
			sql.append(" )");

			SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(Class.forName(getUIControl().getBillVoName()[1]),
					getUIControl().getBillType(), sql.toString());
			getBufferData().clear();
			if (queryVos == null) {
				getBufferData().clear();
				return;
			}
			for (int i = 0; i < queryVos.length; i++) {
				AggregatedValueObject aVo = (AggregatedValueObject) Class.forName(getUIControl().getBillVoName()[0])
						.newInstance();
				aVo.setParentVO(queryVos[i]);
				getBufferData().addVOToBuffer(aVo);
			}

			if (getBufferData().getVOBufferSize() != 0) {
				setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
				setBillOperate(IBillOperate.OP_NOTEDIT);
				getBufferData().setCurrentRow(0);
			} else {
				setListHeadData(null);
				setBillOperate(IBillOperate.OP_INIT);
				getBufferData().setCurrentRow(-1);
				showHintMessage(nc.ui.ml.NCLangRes.getInstance().getStrByID("uifactory",
						"UPPuifactory-000066")
												 * @res "没有查到任何满足条件的数据!"
												 );
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * 编辑前处理。 创建日期：(2001-3-23 2:02:27)
	 * 
	 * @param e
	 *            ufbill.BillEditEvent
	 */
	public boolean beforeEdit(nc.ui.pub.bill.BillEditEvent e) {
		return true;
	}

	/**
	 * 
	 * 功能：重写父类方法 显示公式不能执行
	 * 
	 * @author flq
	 * @date 2012-2-17
	 */
	public void mouse_doubleclick(BillMouseEnent e) {
		super.mouse_doubleclick(e);
		getBillCardPanel().execHeadLoadFormulas();
	}

	@Override
	protected void initPrivateButton() {
		super.initPrivateButton();
	}

	@Override
	public void afterEdit(BillEditEvent e) {
		super.afterEdit(e);
	}

	@Override
	public String getRefBillType() {
		return null;
	}
}

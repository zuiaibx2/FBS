package nc.ui.datacontrol.base;

import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillMouseEnent;
import nc.ui.trade.button.IBillButton;
import nc.ui.trade.manage.BillManageUI;

/**
 * 
 * ��������UI����
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
	 * �������أ���ʼ�Լ����ݼ���
	 * 
	 * @author duyt @date2012-2-24 ����02:02:05
	 */
	public void initData() {
		loadData();
		// ȥ����ť
		removeBtn();
	}

	/**
	 * ��ʼȥ����ť
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
	 * �������ݣ��򿪽ڵ㼴��ѯ����
	 * 
	 * @author jieely
	 * @date 2012-2-27
	 */
	private void loadData() {
	/*	try {
			*//**
			 * �ϼ���˾�ɲ�ѯ�¼���˾����&&�¼���˾�ɲ�ѯ�ϼ���˾����
			 *//*
			String pk_corp = _getCorp().getPk_corp();// ��ǰ��˾
			String pk_super = _getCorp().getFathercorp();// �����ϼ�
			String pk_org = _getCorp().getDef1();// ��������

			StringBuffer sql = new StringBuffer(" (ISNULL(dr,0)=0) ");
			sql.append(" AND ( pk_corp = '" + pk_corp + "'");// ��ǰ��˾����
			sql.append(" OR pk_corp = '" + pk_super + "' OR pk_corp = '" + pk_org + "'");// �¼���˾���Բ鿴�ϼ���˾����
			sql.append(" OR pk_super = '" + pk_corp + "' OR pk_org = '" + pk_corp + "'");// �ϼ���˾���Բ鿴�¼���˾����
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
												 * @res "û�в鵽�κ���������������!"
												 );
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * �༭ǰ���� �������ڣ�(2001-3-23 2:02:27)
	 * 
	 * @param e
	 *            ufbill.BillEditEvent
	 */
	public boolean beforeEdit(nc.ui.pub.bill.BillEditEvent e) {
		return true;
	}

	/**
	 * 
	 * ���ܣ���д���෽�� ��ʾ��ʽ����ִ��
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

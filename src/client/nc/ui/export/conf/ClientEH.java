package nc.ui.export.conf;

import nc.ui.pub.ButtonObject;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillModel;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.ICardController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.businessaction.IBusinessController;
import nc.ui.trade.card.BillCardUI;
import nc.ui.trade.card.CardEventHandler;
import nc.vo.pub.ValidationException;


/**
 * @ClassName: ClientEH
 * <b> 数据抽取公司配置事件管理器 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年11月11日 下午2:31:34
 * @Author 王凯强
 * @Version 
 */
public class ClientEH extends CardEventHandler {

	public ClientEH(BillCardUI billUI, ICardController control) {
		super(billUI, control); 
	}
	
	private static boolean editflag = false;
	@Override
	protected void onBoEdit() throws Exception {
		editflag = true;
	
		int selectRow = getBillCardPanelWrapper().getBillCardPanel().getBillTable().getSelectedRow();
		if (selectRow < 0) {
			MessageDialog.showHintDlg(getBillUI(), "提示", "请选中要修改的行");
			return;
		}
		super.onBoEdit();
		BillModel model = getBillCardPanelWrapper().getBillCardPanel().getBodyPanel().getTableModel();
		model.setRowEditState(true);
		model.setEditRow(selectRow);
//		this.getButtonManager().getButton(10).setEnabled(false);
//		this.getBillUI().updateButtons();
		if(this.getButtonManager().getButton(10)!=null){
			this.getButtonManager().getButton(10).setEnabled(false);
			this.getBillUI().updateButtons();
		}
	}
	@Override
	protected void onBoRefresh() throws Exception {
		// TODO 自动生成方法存根
		((ClientUI)getBillUI()).readData();
	}
	@Override
	protected void onBoSave() throws Exception {
		if(!editflag){
			try {
				getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();
				BillItem corp_code = getBillCardPanelWrapper().getBillCardPanel().getBodyItem("corp_code");
				UIRefPane pane = (UIRefPane)corp_code.getComponent();
//				Vector refValue = 
//				Object[] corpArr = refValue.toArray();
				String[] corp_pkArr =pane.getRefPKs();;
//				for(int i = 0; i < corpArr.length; i++){
//					Object corp =  corpArr[i];
//					String[] corppk = corp.toString().split(",");
//					corp_pkArr[i] = corppk[2];
//				}
				//检验是否已经配置
	//			checkCorp(toStr(corp_pkArr));
				int selectRow = getBillCardPanelWrapper().getBillCardPanel().getBillTable().getRowCount()-1;
				BillModel model = getBillCardPanelWrapper().getBillCardPanel().getBodyPanel().getTableModel();
				if(selectRow >= 0){
					model.delLine(new int[]{selectRow});
				}
				
				for(int i = 0; i < corp_pkArr.length; i++){
					super.onBoLineAdd();
					
					selectRow = getBillCardPanelWrapper().getBillCardPanel().getBillTable().getRowCount()-1;
					model = getBillCardPanelWrapper().getBillCardPanel().getBodyPanel().getTableModel();
					model.setRowEditState(true);
					model.setEditRow(selectRow);	
					getBillCardPanelWrapper().getBillCardPanel().setBodyValueAt("Y", selectRow, "exp_flag");
					//getBillCardPanelWrapper().getBillCardPanel().setBodyValueAt(this._getCorp().getPrimaryKey(), selectRow, "pk_corp");	
					getBillCardPanelWrapper().getBillCardPanel().setBodyValueAt(corp_pkArr[i].trim(), selectRow, "exp_pk_corp");	
					
				}
				
			} catch (ValidationException e) {
				MessageDialog.showErrorDlg(getBillUI(), "校验", e.getMessage());
				return;
			}
		}
		super.onBoSave();
		editflag = false;
	}
	
//	public void checkCorp(String pks){
//		IUAPQueryBS qu = (IUAPQueryBS) NCLocator.getInstance().lookup(IUAPQueryBS.class.getName());
//		String sql = "select count(exp_pk_corp) from fbs_expcorp_conf where exp_pk_corp in ("+ pks +") and isnull(dr,0) = 0 and pk_corp = '"+ getCorpPrimaryKey() +"'";
//	}
	
	/**
	 * @Title: toStr
	 * @Description: 数组转换成字符串
	 * @Author: 王凯强
	 * @Time: 2016年11月11日 下午4:46:16
	 * @param pks
	 * @return
	 */
	public String toStr(String[] corp){
		StringBuffer pkStr = new StringBuffer("");
		for(int i = 0; i < corp.length; i++){
			if(i != 0){
				pkStr.append(", ");
			}
			pkStr.append("'" + corp[i].trim() + "'");
		}
		return pkStr.toString();
	}
	
	public void onBoAdd(ButtonObject bo) throws Exception {
		super.onBoEdit();
		super.onBoLineAdd();
		
		int selectRow = getBillCardPanelWrapper().getBillCardPanel().getBillTable().getRowCount()-1;
		BillModel model = getBillCardPanelWrapper().getBillCardPanel().getBodyPanel().getTableModel();
		model.setRowEditState(true);
		model.setEditRow(selectRow);	
		getBillCardPanelWrapper().getBillCardPanel().setBodyValueAt("Y", selectRow, "exp_flag");
		//getBillCardPanelWrapper().getBillCardPanel().setBodyValueAt(this._getCorp().getPrimaryKey(), selectRow, "pk_corp");	
		
	}

	@Override
	protected void onBoDelete() throws Exception {
		int selectRow =	getBillCardPanelWrapper().getBillCardPanel().getBillTable().getSelectedRowCount();
		if(selectRow<=0){
			MessageDialog.showHintDlg(getBillUI(), "提示", "请选中要删除的行!");
			return;
		}
		if (MessageDialog.showYesNoDlg(getBillUI(), "提示", "是否确认删除该数据?")
				!= UIDialog.ID_YES) {
				return;
			}
		
		if(getUIController().getBusinessActionType() == IBusinessActionType.BD){
			onBoLineDel();
			try {
				super.onBoSave();
			} catch (Exception e) {
				e.printStackTrace();
				onBoRefresh();
				getBillUI().setBillOperate(IBillOperate.OP_NOTEDIT);
				getBillCardPanelWrapper()
					.getBillCardPanel()
					.getBillTable()
					.getSelectionModel()
					.setSelectionInterval(selectRow, selectRow);
				getBillUI().showErrorMessage(e.getMessage());
			}
				
		}
		
	}

	@Override
	protected IBusinessController createBusinessAction() {
		// TODO 自动生成方法存根
//		switch (getUIController().getBusinessActionType()) {
//		case IBusinessActionType.PLATFORM:
//			return new BusinessAction(getBillUI());
//		case IBusinessActionType.BD:
//			return new XHBdBusinessAction(getBillUI());
//		default:
//			return new BusinessAction(getBillUI());
//		}
		return super.createBusinessAction();
	}
	
}

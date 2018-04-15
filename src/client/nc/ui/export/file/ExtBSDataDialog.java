package nc.ui.export.file;

import java.awt.Container;
import java.util.Vector;

import javax.swing.JComponent;

import nc.hr.utils.PubEnv;
import nc.ui.hr.frame.dialog.HrDialog;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillEditListener;
import nc.ui.pub.bill.BillItem;

@SuppressWarnings({ "serial", "restriction" })
public class ExtBSDataDialog extends HrDialog implements BillEditListener {

	private BillCardPanel billCardPanel;
	private String corp;
	private String[] corpArr;
	
	public ExtBSDataDialog(Container parent) {
		super(parent);
		initialize();
	}
	
	public void initialize() {
		setTitle("抽取数据");
//		setSize(900, 650);
		setSize(300, 130);
		setLocation(300,300);
	}
	
	protected JComponent createCenterPanel()
	{
		return getBillCardPanel();
	}

	public BillCardPanel getBillCardPanel()
	{
		if (billCardPanel == null)
		{
			billCardPanel = new BillCardPanel();
			billCardPanel.addEditListener(this);
			billCardPanel.loadTemplet("exp01_xj", null, PubEnv.getPk_user(), PubEnv.getPk_corp());
			BillItem pk_corp = getBillCardPanel().getHeadItem("pk_corp");
			UIRefPane pane = (UIRefPane)pk_corp.getComponent();
			pane.setMultiSelectedEnabled(true);
		}
		return billCardPanel;
	}

	public HrDialog getDlg(){
		return this;
	}
	@SuppressWarnings("rawtypes")
	public void afterEdit(BillEditEvent e)
	{
		BillItem corp_code = getBillCardPanel().getHeadItem("pk_corp");
		UIRefPane pane = (UIRefPane)corp_code.getComponent();
		//Vector refValue =
		
		String[] corp_pkArr =  pane.getRefPKs();
//		Object[] corpArr = refValue.toArray();
//		String[] corp_pkArr = new String[corpArr.length];
//		for(int i = 0; i < corpArr.length; i++){
//			Object corp =  corpArr[i];
//			String[] corppk = corp.toString().split(",");
//			corp_pkArr[i] = corppk[2].trim();
//		}
		setCorpArr(corp_pkArr);
		corp = toStr(corp_pkArr);
		setCorp(corp);
		
		if(corp == null || "".equals(corp)){
			MessageDialog.showHintDlg(billCardPanel, "错误", "请选择要导出数据的公司！");
		}
		
	}
	
	public void bodyRowChange(BillEditEvent e) {
		
	}
	
	/**
	 * @Title: toStr
	 * @Description: 数组转换成字符串,以‘,’拼接
	 * @param corp
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

	public String getCorp() {
		return corp;
	}


	public void setCorp(String corp) {
		this.corp = corp;
	}

	public String[] getCorpArr() {
		return corpArr;
	}

	public void setCorpArr(String[] corpArr) {
		this.corpArr = corpArr;
	}

}

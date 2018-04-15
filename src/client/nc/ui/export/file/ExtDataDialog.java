package nc.ui.export.file;

import java.awt.Container;

import javax.swing.JComponent;

import nc.hr.utils.PubEnv;
import nc.ui.hr.frame.dialog.HrDialog;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.bill.BillCardPanel;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillEditListener;

@SuppressWarnings({ "serial", "restriction" })
public class ExtDataDialog extends HrDialog implements BillEditListener {

	private BillCardPanel billCardPanel;
	private String corp;
	private String startDate;
	private String endDate;
	private String isall;//是否强制全量 
	
	public ExtDataDialog(Container parent) {
		super(parent);
		initialize();
	}
	
	
	public void initialize() {
		setTitle("增量抽取数据");
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
			billCardPanel.loadTemplet("tanchu", null, PubEnv.getPk_user(), PubEnv.getPk_corp());
		}
		return billCardPanel;
	}

	public HrDialog getDlg(){
		return this;
	}
	@SuppressWarnings("deprecation")
	public void afterEdit(BillEditEvent e)
	{
		corp = getBillCardPanel().getHeadItem("pk_corp").getValue();
		setCorp(corp);
		
		startDate = getBillCardPanel().getHeadItem("startdate").getValue();
		setStartDate(startDate);
		
		endDate = getBillCardPanel().getHeadItem("enddate").getValue();
		setEndDate(endDate);
		
		isall = getBillCardPanel().getHeadItem("isall").getValue();
		setIsall(isall);
		
		if(startDate != null 
			&& startDate.trim().length() != 0 
			&& (isall != null 
			&& "true".equals(isall))){
			MessageDialog.showHintDlg(billCardPanel, "错误", "【开始时间】和【强制全量】不可同时选择！！");
			getBillCardPanel().getHeadItem("isall").setValue("false");
		}
		
	}
	
	public void bodyRowChange(BillEditEvent e) {
		
	}
	
	
	public String getIsall() {
		return isall;
	}

	public void setIsall(String isall) {
		this.isall = isall;
	}

	public String getCorp() {
		return corp;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setCorp(String corp) {
		this.corp = corp;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}

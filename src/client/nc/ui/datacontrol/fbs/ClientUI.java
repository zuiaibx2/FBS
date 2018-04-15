package nc.ui.datacontrol.fbs;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillEditEvent;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemEvent;
import nc.ui.pub.bill.IBillItem;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.trade.field.BillField;
import nc.vo.trade.pub.IBillStatus;
/**
 * @ClassName: ClientUI
 * @Description:  分布式数据对照展示UI
 * @项目名称: fbsjt
 * @文件名称: ClientUI.java
 * @Author: 王凯强
 * @Date: 2016年8月2日上午9:14:30
 */
public class ClientUI extends FBSAbstractUI
{

    public ClientUI() {
		super();
		// 默认加载数据
		try {
		    loadDefaultData();
	
		} catch (Exception e) {
		    showWarningMessage("加载默认数据失败：" + e.getMessage());
		    return;
		}
    }

    private static final long serialVersionUID = 1L;


    @Override
    protected AbstractManageController createController() {

	return new ClientCtrl();
    }

    protected ManageEventHandler createEventHandler() {
	return new ClientEH(this, getUIControl());
    }

    @Override
    protected void initPrivateButton() {

    }

    @Override
    protected void initSelfData() {
	super.initSelfData();
	// 设置表头执行公式
	getBillCardPanel().setAutoExecHeadEditFormula(true);

    }


    /**
     * 加载默认数据
     * 
     * @throws Exception
     * @throws ClassNotFoundException
     */
    public void loadDefaultData() throws Exception {

		String strWhere = " isnull(dr,0)=0  ";

		SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(
			Class.forName(createController().getBillVoName()[1]),
			createController().getBillType(), strWhere.toString());

		getBufferData().clear();
		// 增加数据到Buffer
		if (queryVos == null) {
		    getBufferData().clear();
		    return;
		}
		 AggregatedValueObject aVo =null;
		for (int i = 0; i < queryVos.length; i++) {
			aVo= (AggregatedValueObject) Class.forName(
			    createController().getBillVoName()[0]).newInstance();
		    aVo.setParentVO(queryVos[i]);
		    getBufferData().addVOToBuffer(aVo);
		}

		if (getBufferData().getVOBufferSize() != 0) {
	
		    setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
		    setBillOperate(IBillOperate.OP_NOTEDIT);
		    getBufferData().setCurrentRow(0);
		} else {
		    setListHeadData(null);
		    getBufferData().setCurrentRow(-1);
		    showHintMessage(nc.ui.ml.NCLangRes.getInstance().getStrByID(
			    "uifactory", "UPPuifactory-000066")/* @res "没有查到任何满足条件的数据!" */);
		}
    }
    
	/**
	 * 表体编辑前事件
	 */
	@Override
	public boolean beforeEdit(BillEditEvent e)
	{
		super.beforeEdit(e);
		
		String pk_defdoclist = (String)getBillCardPanel().getHeadItem("pk_defdoclist").getValueObject();
		
		if("jt_code".equals(e.getKey())){
			
			if(pk_defdoclist == null || "".equals(pk_defdoclist)){
				MessageDialog.showWarningDlg(this, "提示", "请先选择【关联基本档案】");
			}
			
			//得到集团参照的pane
			BillItem jt_attr = getBillCardPanel().getBodyItem("jt_code");
			UIRefPane pane = (UIRefPane)jt_attr.getComponent() ;
			
			//将集团字段参照付范围
			pane.getRefModel().addWherePart(" and isnull(mid_bd_defdoc.sealflag,'N') = 'N' and mid_bd_defdoc.PK_DEFDOCLIST = '"+pk_defdoclist+"'") ;
		}
		
		if("xj_code".equals(e.getKey())){
			if(pk_defdoclist == null || "".equals(pk_defdoclist)){
				MessageDialog.showWarningDlg(this, "提示", "请先选择【关联基本档案】");
			}
			
			IUAPQueryBS qu = (IUAPQueryBS) NCLocator.getInstance().lookup(
					IUAPQueryBS.class.getName());
			//得到下级参照的pane
			BillItem xj_code = getBillCardPanel().getBodyItem("xj_code");
			UIRefPane pane_xj = (UIRefPane)xj_code.getComponent() ;
			
//			取得当前自定义档案名字
			String vuserdef4 =  (String)getBillCardPanel().getHeadItem("vuserdef4").getValueObject();
			
			//下级参照范围  针对于档案在公司可以修改的情况
			if(!"人员类别".equals(vuserdef4)){
				getBillCardPanel().getBodyItem("xj_code").setRefType("<nc.ui.datacontrol.secret.duty.XjRef>");
				String SQL_PkbyName = "select pk_defdoclist from bd_defdoclist where doclistname = '"+vuserdef4+"' and isnull(dr,0) = 0";
				Object deflistPK = null;
				try {
					deflistPK = qu.executeQuery(SQL_PkbyName, new ColumnProcessor());
					
				} catch (BusinessException e1) {
					// TODO 自动生成 catch 块
					e1.printStackTrace();
				}
				pane_xj.getRefModel().addWherePart(" and isnull(bd_defdoc.sealflag,'N') = 'N' and bd_defdoc.pk_defdoclist = '"+deflistPK
						+"'  and bd_defdoc.pk_defdoc not in (select pk_defdoc from mid_bd_defdoc)") ;
			}else{
				getBillCardPanel().getBodyItem("xj_code").setRefType(vuserdef4);
				
				BillItem xj_attr = getBillCardPanel().getBodyItem("xj_code");
				UIRefPane pane = (UIRefPane)xj_attr.getComponent();
				pane.getRefModel().addWherePart(" and  isnull(bd_psncl.sealflag,'N') = 'N' and bd_psncl.pk_psncl not in (select pk_defdoc from mid_bd_defdoc)") ;
			}
		}
		return true;
	}
	/* (non-Javadoc) 表体编辑后事件  vuserdef1  vuserdef2
	 * @see nc.ui.fbs.pub.FBSAbstractUI#afterEdit(nc.ui.pub.bill.BillEditEvent)
	 */
	public void afterEdit(BillEditEvent e)
	{
		IUAPQueryBS qu = (IUAPQueryBS) NCLocator.getInstance().lookup(IUAPQueryBS.class.getName());
		try
		{
			super.afterEdit(e);
			
			int pos = e.getPos();
			int row = e.getRow();
			if(pos == IBillItem.HEAD){
				if("pk_defdoclist".equals(e.getKey())){
					String pk_defdoclist = (String)getBillCardPanel().getHeadItem("pk_defdoclist").getValueObject();
					if(pk_defdoclist != null && !"".equals(pk_defdoclist)){
						String sql = "select count(pk_defdoclist) from dc_datacontrol_type where pk_defdoclist = '"+ pk_defdoclist +"' and isnull(dr,0) = 0";
						Object count = qu.executeQuery(sql, new ColumnProcessor());
						if(Integer.parseInt(count.toString()) > 0){
							MessageDialog.showWarningDlg(this, "提示", "此【关联基本档案】已做过参照，只可修改不可新增！");
							getBillCardPanel().getHeadItem("pk_defdoclist").clearViewData();
							return;
						}
					}
				}
			}
			if (pos == IBillItem.BODY){
				if("jt_code".equals(e.getKey())){
					BillItem billItem = getBillCardPanel().getBillModel().getItemByKey("jt_code");
					UIRefPane refPanel = (UIRefPane) billItem.getComponent();
					String name = refPanel.getRefName();
					getBillCardPanel().getBillModel().setValueAt(name, row, "vuserdef1");
				}
				if("xj_code".equals(e.getKey())){
					BillItem billItem = getBillCardPanel().getBillModel().getItemByKey("xj_code");
					String xj_pk = (String)billItem.getValueObject();
					if(xj_pk != null && !"".equals(xj_pk)){
						String sql = "select count(xj_pk) from dc_datacontrol where xj_pk = '"+ xj_pk +"' and isnull(dr,0) = 0";
						Object count = qu.executeQuery(sql, new ColumnProcessor());
						if(Integer.parseInt(count.toString()) > 0){
							MessageDialog.showWarningDlg(this, "提示", "此【档案】已做过参照，只可修改不可新增！");
							getBillCardPanel().getBillModel().clearRowData(row, new String[]{e.getKey().toString(), "vuserdef2"});
							return;
						}
					}
					UIRefPane refPanel = (UIRefPane) billItem.getComponent();
					String name = refPanel.getRefName();
					getBillCardPanel().getBillModel().setValueAt(name, row, "vuserdef2");
				}
			}
		}catch(Exception ex){
			Logger.error(ex.getMessage(), ex);
			MessageDialog.showWarningDlg(this, "提示", "错误:" + ex.getMessage() + ",更多详细信息，请检查日志!");
		}
	}
	
	/* (non-Javadoc) 表头编辑前事件
	 * @see nc.ui.fbs.pub.FBSAbstractUI#beforeEdit(nc.ui.pub.bill.BillItemEvent)
	 */
	public boolean beforeEdit(BillItemEvent e)
	{
		if (getBillOperate() == IBillOperate.OP_NOTEDIT || getBillOperate() == IBillOperate.OP_INIT)
		{
			return false;
		}
		String pk_defdoclist = (String)getBillCardPanel().getHeadItem("pk_defdoclist").getValueObject();
		int count = this.getBillCardPanel().getRowCount();
		if(pk_defdoclist!=null && !"".equals(pk_defdoclist) && count > 0){
			getBillCardPanel().getHeadItem("pk_defdoclist").setEnabled(false);
		}
		if(count == 0){
			getBillCardPanel().getHeadItem("pk_defdoclist").setEnabled(true);
		}
		return true;
	}
	
    public void DefaultData() {
    	// 当前操作员
    	BillField billField = BillField.getInstance();

    	// 单据状态
    	getBillCardPanel().getHeadItem(billField.getField_BillStatus()).setValue(
    		new Integer(IBillStatus.FREE).toString());

        }

}

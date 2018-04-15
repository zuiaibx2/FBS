package nc.ui.datacontrol;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.pub.beans.UIRefPane;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemEvent;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.pub.BusinessException;
public class ClientUI extends FBSAbstractUI
{

    public ClientUI() {
	super();
	// 默认加载数据
	try {
//	    loadDefaultData();

	} catch (Exception e) {
	    // TODO Auto-generated catch block
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

    public boolean beforeEdit(BillItemEvent e) {
//		((UIRefPane)
		
		super.beforeEdit(e);
		
		if("jt_attr".equals(e.getItem().getKey())){
			IUAPQueryBS qu = (IUAPQueryBS) NCLocator.getInstance().lookup(
					IUAPQueryBS.class.getName());

			//得到集团参照的pane
			BillItem jt_attr = getBillCardPanel().getHeadItem("jt_attr");
			UIRefPane pane = (UIRefPane)jt_attr.getComponent() ;
			//得到下级参照的pane
			BillItem xj_attr = getBillCardPanel().getHeadItem("xj_attr");
			UIRefPane pane_xj = (UIRefPane)xj_attr.getComponent() ;
			
			String pk_course_cf = (String)getBillCardPanel().getHeadItem("category").getValueObject();
			String vuserdef4 =  (String)getBillCardPanel().getHeadItem("vuserdef4").getValueObject();
			//将集团字段参照付范围
			pane.getRefModel().addWherePart(" and mid_bd_defdoc.PK_DEFDOCLIST = '"+pk_course_cf+"'") ;
			
			
			//下级参照范围  针对于档案在公司可以修改的情况
			String SQL_PkbyName = "select pk_defdoclist from bd_defdoclist where doclistname = '"+vuserdef4+"' and nvl(dr,0) = 0"
					+ " and pk_defdoc not in (select pk_defdoc from mid_bd_defdoc)";
			Object deflistPK = null;
			try {
				deflistPK = qu.executeQuery(SQL_PkbyName, new ColumnProcessor());
				
			} catch (BusinessException e1) {
				// TODO 自动生成 catch 块
				e1.printStackTrace();
			}
			pane_xj.getRefModel().addWherePart(" and bd_defdoc.PK_DEFDOCLIST = '"+deflistPK+"'") ;
//			getBillCardPanel().getHeadItem("xj_attr").setRefType(vuserdef4);
		}
		
		
		if("xj_attr".equals(e.getItem().getKey())){
			
				String vuserdef4 =  (String)getBillCardPanel().getHeadItem("vuserdef4").getValueObject();
				
				getBillCardPanel().getHeadItem("xj_attr").setRefType(vuserdef4);
			}
		return true ;
	}
    
    /**
     * 加载默认数据
     * 
     * @throws Exception
     * @throws ClassNotFoundException
     */
//    public void loadDefaultData() throws Exception {
//
//	String strWhere = " dr = 0 and (pk_corp='" + getCorpPrimaryKey()
//		+ "' or pk_corp='0001') and isnull(dr,0)=0  ";
//
//	SuperVO[] queryVos = getBusiDelegator().queryHeadAllData(
//		Class.forName(createController().getBillVoName()[1]),
//		createController().getBillType(), strWhere.toString());
//
//	getBufferData().clear();
//	// 增加数据到Buffer
//	if (queryVos == null) {
//	    getBufferData().clear();
//	    return;
//	}
//	for (int i = 0; i < queryVos.length; i++) {
//	    AggregatedValueObject aVo = (AggregatedValueObject) Class.forName(
//		    createController().getBillVoName()[0]).newInstance();
//	    aVo.setParentVO(queryVos[i]);
//	    getBufferData().addVOToBuffer(aVo);
//	}
//
//	if (getBufferData().getVOBufferSize() != 0) {
//
//	    setListHeadData(getBufferData().getAllHeadVOsFromBuffer());
//	    setBillOperate(IBillOperate.OP_NOTEDIT);
//	    getBufferData().setCurrentRow(0);
//	} else {
//	    setListHeadData(null);
//	    setBillOperate(IBillOperate.OP_INIT);
//	    getBufferData().setCurrentRow(-1);
//	    showHintMessage(nc.ui.ml.NCLangRes.getInstance().getStrByID(
//		    "uifactory", "UPPuifactory-000066")/* @res "没有查到任何满足条件的数据!" */);
//	}
//    }
}

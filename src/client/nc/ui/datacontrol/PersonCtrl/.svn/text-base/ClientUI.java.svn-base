/**
 * 
 */
package nc.ui.datacontrol.PersonCtrl;

import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;

/**
 * @author Administrator
 *
 */
public class ClientUI extends FBSAbstractUI{


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

//    private String pk_corp = _getCorp().getPk_corp();

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

//    public boolean beforeEdit(BillItemEvent e) {
//		
//		super.beforeEdit(e);
//		
//		if(("jt_attr").equals(e.getItem().getKey())||("xj_attr").equals(e.getItem().getKey())){
//			BillItem jt_attr = getBillCardPanel().getHeadItem("jt_attr");
//			UIRefPane pane = (UIRefPane)jt_attr.getComponent() ;
//			
//				String pk_course_cf = (String)getBillCardPanel().getHeadItem("category").getValueObject();
//			
//			pane.getRefModel().addWherePart(" and pk_psncl  = '"+pk_course_cf+"'") ;
//		}
//		return true ;
//	}
    
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

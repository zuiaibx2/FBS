package nc.ui.log.err;

import nc.pub.fbs.btn.FbsButtonVO;
import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.trade.base.IBillOperate;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.SuperVO;
/**
 * @ClassName: ClientUI
 * @Description:  分布式错误日志展示UI
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
    	
          	FbsButtonVO buttonVO = new FbsButtonVO();
          	addPrivateButton(buttonVO.getExcelExpVO());
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
    	String strWhere = " isnull(dr,0)=0 order by ts desc ";
//    	if("0001".equals(_getCorp().getPrimaryKey())){
//    		strWhere = " isnull(dr,0)=0 order by ts desc ";
//    	}else{
//    		strWhere = " (pk_corp='" + getCorpPrimaryKey()
//			+ "' or pk_corp='0001') and isnull(dr,0)=0 order by ts desc ";
//		}

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
			aVo  = (AggregatedValueObject) Class.forName(
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



}

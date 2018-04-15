package nc.ui.datacontrol.fbs;

import nc.ui.fbs.pub.FBSAbstractEventHandler;
import nc.ui.pub.ButtonObject;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;

/**
 * 下级单位对照表 EventHandler
 * 
 */
/**
 * @ClassName: ClientEH
 * @Description:  分布式数据对照展示EH
 * @项目名称: fbsjt
 * @文件名称: ClientEH.java
 * @Author: 王凯强
 * @Date: 2016年8月2日上午9:15:10
 */
public class ClientEH extends FBSAbstractEventHandler {

    public ClientEH(BillManageUI billUI, IControllerBase control) {
	super(billUI, control);
    }

    protected BillManageUI getUI() {
	return (BillManageUI) getBillUI();
    }

    @Override
    protected void onBoSave() throws Exception {
		getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();// 检测必输项是否有值
		super.onBoSave();
    }

    @Override
    public void onBoAdd(ButtonObject bo) throws Exception {
	super.onBoAdd(bo);
    }

}

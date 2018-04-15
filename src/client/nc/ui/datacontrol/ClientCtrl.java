/**
 * 
 */
package nc.ui.datacontrol;

import nc.ui.fbs.pub.FBSAbstractSingleCTR;
import nc.ui.trade.button.IBillButton;
import nc.vo.djdz.DataControlVO;
import nc.vo.trade.pub.HYBillVO;

public class ClientCtrl  extends FBSAbstractSingleCTR{

    @Override
    public String getBillType() {

	return "DC";
    }

    // 返回卡片上的按钮类型数组
    public int[] getCardButtonAry() {
	return new int[] {

	IBillButton.Query, IBillButton.Add, IBillButton.Edit,
		IBillButton.Delete, IBillButton.Save, IBillButton.Cancel,
		IBillButton.Return, IBillButton.Refresh, IBillButton.Print,

	};
    }

    // 返回列表上的按钮类型数组
    public int[] getListButtonAry() {
	return new int[] {

	IBillButton.Query, IBillButton.Add, IBillButton.Edit,
		IBillButton.Delete, IBillButton.Card, IBillButton.Refresh,
		IBillButton.Print, IBillButton.DirectPrint,

	};

    }

    @Override
    public String[] getBillVoName() {

	return new String[] { HYBillVO.class.getName(),
			DataControlVO.class.getName(), DataControlVO.class.getName() };
    }

    @Override
    public String getPkField() {
	return "pk_wh_h";
    }

    @Override
    public String getChildPkField() {
	return null;
    }

    public boolean isSingleDetail() {
	return false;
    }

}

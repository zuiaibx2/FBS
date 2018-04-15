/**
 * 
 */
package nc.ui.datacontrol.fbs;

import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;
import nc.vo.djdz.DataControlVO;
import nc.vo.djdz.DataControl_typeVO;
import nc.vo.djdz.HBillVO;

/**
 * @ClassName: ClientCtrl
 * @Description:  分布式数据对照展示Ctrl
 * @项目名称: fbsjt
 * @文件名称: ClientCtrl.java
 * @Author: 王凯强
 * @Date: 2016年8月2日上午9:14:59
 */
public class ClientCtrl  extends AbstractManageController{

	public String[] getCardBodyHideCol() {
		// TODO Auto-generated method stub
		return null;
	    }
	
		// 返回列表上的按钮类型数组
	    public int[] getCardButtonAry() {
		// TODO Auto-generated method stub
		return new int[] { IBillButton.Query, IBillButton.Add, IBillButton.Edit,
				IBillButton.Delete, IBillButton.Save, IBillButton.Cancel,
				IBillButton.Return, IBillButton.Refresh, IBillButton.Print, 
				IBillButton.Line};
	    }

	    // 返回列表上的按钮类型数组
	    public int[] getListButtonAry() {
		return new int[] { IBillButton.Query, IBillButton.Add, IBillButton.Edit,
				IBillButton.Delete, IBillButton.Card, IBillButton.Refresh,
				IBillButton.Print, IBillButton.DirectPrint, };

	    }

	    public boolean isShowCardRowNo() {
		// TODO Auto-generated method stub
		return true;
	    }

	    public boolean isShowCardTotal() {
		// TODO Auto-generated method stub
		return false;
	    }

	    public String getBillType() {
		// TODO Auto-generated method stub
		return "FBSD";
	    }

	    public String[] getBillVoName() {
		// TODO Auto-generated method stub
		return new String[] { HBillVO.class.getName(),
				DataControl_typeVO.class.getName(), DataControlVO.class.getName() };
	    }

	    public String getBodyCondition() {
		// TODO Auto-generated method stub
		return null;
	    }

	    public String getBodyZYXKey() {
		// TODO Auto-generated method stub
		return null;
	    }

	    public int getBusinessActionType() {
		// TODO Auto-generated method stub
		return IBusinessActionType.BD;
	    }

	    public String getChildPkField() {
		// TODO Auto-generated method stub
		return "pk_datacontrol";
	    }

	    public String getHeadZYXKey() {
		// TODO Auto-generated method stub
		return null;
	    }

	    public String getPkField() {
		// TODO Auto-generated method stub
		return "pk_datacontrol_type";
	    }

	    public Boolean isEditInGoing() throws Exception {
		// TODO Auto-generated method stub
		return null;
	    }

	    public boolean isExistBillStatus() {
		// TODO Auto-generated method stub
		return true;
	    }

	    public boolean isLoadCardFormula() {
		// TODO Auto-generated method stub
		return false;
	    }

	    public boolean isSingleDetail() {
		// TODO Auto-generated method stub
		return false;
	    }

	    public String[] getListBodyHideCol() {
		// TODO Auto-generated method stub
		return null;
	    }

	    public String[] getListHeadHideCol() {
		// TODO Auto-generated method stub
		return null;
	    }

	    public boolean isShowListRowNo() {
		// TODO Auto-generated method stub
		return true;
	    }

	    public boolean isShowListTotal() {
		// TODO Auto-generated method stub
		return false;
	    }
}

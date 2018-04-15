package nc.ui.log.err;

import nc.pub.fbs.btn.FbsButton;
import nc.ui.fbs.pub.FBSAbstractSingleCTR;
import nc.ui.trade.button.IBillButton;
import nc.vo.log.error.Fbs_logVO;
import nc.vo.trade.pub.HYBillVO;

/**
 * @ClassName: ClientCtrl
 * @Description: 分布式错误日志展示Ctrl
 * @项目名称: fbsjt
 * @文件名称: ClientCtrl.java
 * @Author: 王凯强
 * @Date: 2016年8月2日上午9:14:59
 */
public class ClientCtrl extends FBSAbstractSingleCTR {

	@Override
	public String getBillType() {

		return "FBSL";
	}

	// 返回卡片上的按钮类型数组
	public int[] getCardButtonAry() {
		return new int[] { 
				IBillButton.Query, 
				IBillButton.Return, 
				IBillButton.Refresh, 
				
				};
	}

	// 返回列表上的按钮类型数组
	public int[] getListButtonAry() {
		return new int[] { 
				IBillButton.Query, 
				IBillButton.Card, 
				IBillButton.Refresh, 
				IBillButton.Print,
				FbsButton.excel_dc, 
				};
	}

	@Override
	public String[] getBillVoName() {
		return new String[] { 
				HYBillVO.class.getName(), 
				Fbs_logVO.class.getName(), 
				Fbs_logVO.class.getName() 
				};
	}

	@Override
	public String getPkField() {
		return "pk_fbs_error_logs";
	}

	@Override
	public String getChildPkField() {
		return null;
	}

	public boolean isSingleDetail() {
		return false;
	}

}

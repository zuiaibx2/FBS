package nc.ui.log.err;

import nc.pub.fbs.btn.FbsButton;
import nc.ui.fbs.pub.FBSAbstractSingleCTR;
import nc.ui.trade.button.IBillButton;
import nc.vo.log.error.Fbs_logVO;
import nc.vo.trade.pub.HYBillVO;

/**
 * @ClassName: ClientCtrl
 * @Description: �ֲ�ʽ������־չʾCtrl
 * @��Ŀ����: fbsjt
 * @�ļ�����: ClientCtrl.java
 * @Author: ����ǿ
 * @Date: 2016��8��2������9:14:59
 */
public class ClientCtrl extends FBSAbstractSingleCTR {

	@Override
	public String getBillType() {

		return "FBSL";
	}

	// ���ؿ�Ƭ�ϵİ�ť��������
	public int[] getCardButtonAry() {
		return new int[] { 
				IBillButton.Query, 
				IBillButton.Return, 
				IBillButton.Refresh, 
				
				};
	}

	// �����б��ϵİ�ť��������
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
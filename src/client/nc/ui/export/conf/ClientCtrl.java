package nc.ui.export.conf;

import nc.ui.trade.bill.ICardController;
import nc.ui.trade.bill.ISingleController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;
import nc.vo.Export.conf.Fbs_expcorp_confVO;
import nc.vo.trade.pub.HYBillVO;

/**
 * @ClassName: ClientCtrl
 * <b> ���ݳ�ȡ��˾���ÿ����� </b>
 * <p>
 *     �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������: 2016��11��11�� ����2:33:04
 * @Author ����ǿ
 * @Version 
 */
public class ClientCtrl  implements ICardController, ISingleController {


	/* ���� Javadoc��
	 * @see nc.ui.trade.bill.ICardController#getCardBodyHideCol()
	 */
	public String[] getCardBodyHideCol() {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.bill.ICardController#getCardButtonAry()
	 */
	public int[] getCardButtonAry() {
		// TODO �Զ����ɷ������
			
//		if(ClientEnvironment.getInstance().getCorporation().getPrimaryKey().equals("0001")){
			return new int[]{
					IBillButton.Add,
					IBillButton.Save,
					IBillButton.Cancel,
					IBillButton.Delete,
					IBillButton.Refresh
					
		};
//		}else{
//			return new int[]{IBillButton.Refresh};
//		}
	}
	public int[] getListButtonAry() {
		// TODO �Զ����ɷ������
			
//		if(ClientEnvironment.getInstance().getCorporation().getPrimaryKey().equals("0001")){
			return new int[]{
					IBillButton.Add,
					IBillButton.Save,
					IBillButton.Cancel,
					IBillButton.Delete,
					IBillButton.Refresh
					
		};
//		}else{
//			return new int[]{IBillButton.Refresh};
//		}
	}
	

	/* ���� Javadoc��
	 * @see nc.ui.trade.bill.ICardController#isShowCardRowNo()
	 */
	public boolean isShowCardRowNo() {
		// TODO �Զ����ɷ������
		return true;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.bill.ICardController#isShowCardTotal()
	 */
	public boolean isShowCardTotal() {
		// TODO �Զ����ɷ������
		return false;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getBillType()
	 */
	public String getBillType() {
		// TODO �Զ����ɷ������
		return "FBSC";
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getBillVoName()
	 */
	public String[] getBillVoName() {
		// TODO �Զ����ɷ������
		return new String[] { HYBillVO.class.getName(),
    			Fbs_expcorp_confVO.class.getName(), Fbs_expcorp_confVO.class.getName() 
		};
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getBodyCondition()
	 */
	public String getBodyCondition() {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getBodyZYXKey()
	 */
	public String getBodyZYXKey() {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getBusinessActionType()
	 */
	public int getBusinessActionType() {
		// TODO �Զ����ɷ������
		return IBusinessActionType.BD;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getChildPkField()
	 */
	public String getChildPkField() {
		// TODO �Զ����ɷ������
		return "pk_expcorp_conf";
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getHeadZYXKey()
	 */
	public String getHeadZYXKey() {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#getPkField()
	 */
	public String getPkField() {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#isEditInGoing()
	 */
	public Boolean isEditInGoing() throws Exception {
		// TODO �Զ����ɷ������
		return null;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#isExistBillStatus()
	 */
	public boolean isExistBillStatus() {
		// TODO �Զ����ɷ������
		return false;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.controller.IControllerBase#isLoadCardFormula()
	 */
	public boolean isLoadCardFormula() {
		// TODO �Զ����ɷ������
		return false;
	}

	/* ���� Javadoc��
	 * @see nc.ui.trade.bill.ISingleController#isSingleDetail()
	 */
	public boolean isSingleDetail() {
		// TODO �Զ����ɷ������
		return true;
	}

}
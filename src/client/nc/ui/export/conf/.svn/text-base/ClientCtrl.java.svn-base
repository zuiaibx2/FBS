package nc.ui.export.conf;

import nc.ui.trade.bill.ICardController;
import nc.ui.trade.bill.ISingleController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;
import nc.vo.Export.conf.Fbs_expcorp_confVO;
import nc.vo.trade.pub.HYBillVO;

/**
 * @ClassName: ClientCtrl
 * <b> 数据抽取公司配置控制器 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年11月11日 下午2:33:04
 * @Author 王凯强
 * @Version 
 */
public class ClientCtrl  implements ICardController, ISingleController {


	/* （非 Javadoc）
	 * @see nc.ui.trade.bill.ICardController#getCardBodyHideCol()
	 */
	public String[] getCardBodyHideCol() {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.bill.ICardController#getCardButtonAry()
	 */
	public int[] getCardButtonAry() {
		// TODO 自动生成方法存根
			
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
		// TODO 自动生成方法存根
			
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
	

	/* （非 Javadoc）
	 * @see nc.ui.trade.bill.ICardController#isShowCardRowNo()
	 */
	public boolean isShowCardRowNo() {
		// TODO 自动生成方法存根
		return true;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.bill.ICardController#isShowCardTotal()
	 */
	public boolean isShowCardTotal() {
		// TODO 自动生成方法存根
		return false;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getBillType()
	 */
	public String getBillType() {
		// TODO 自动生成方法存根
		return "FBSC";
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getBillVoName()
	 */
	public String[] getBillVoName() {
		// TODO 自动生成方法存根
		return new String[] { HYBillVO.class.getName(),
    			Fbs_expcorp_confVO.class.getName(), Fbs_expcorp_confVO.class.getName() 
		};
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getBodyCondition()
	 */
	public String getBodyCondition() {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getBodyZYXKey()
	 */
	public String getBodyZYXKey() {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getBusinessActionType()
	 */
	public int getBusinessActionType() {
		// TODO 自动生成方法存根
		return IBusinessActionType.BD;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getChildPkField()
	 */
	public String getChildPkField() {
		// TODO 自动生成方法存根
		return "pk_expcorp_conf";
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getHeadZYXKey()
	 */
	public String getHeadZYXKey() {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#getPkField()
	 */
	public String getPkField() {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#isEditInGoing()
	 */
	public Boolean isEditInGoing() throws Exception {
		// TODO 自动生成方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#isExistBillStatus()
	 */
	public boolean isExistBillStatus() {
		// TODO 自动生成方法存根
		return false;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.controller.IControllerBase#isLoadCardFormula()
	 */
	public boolean isLoadCardFormula() {
		// TODO 自动生成方法存根
		return false;
	}

	/* （非 Javadoc）
	 * @see nc.ui.trade.bill.ISingleController#isSingleDetail()
	 */
	public boolean isSingleDetail() {
		// TODO 自动生成方法存根
		return true;
	}

}
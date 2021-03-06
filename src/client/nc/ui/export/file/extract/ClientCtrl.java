/**
 * 
 */
package nc.ui.export.file.extract;

import nc.pub.fbs.btn.FbsButton;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.businessaction.IBusinessActionType;
import nc.ui.trade.button.IBillButton;
import nc.vo.Export.FbsDataFileBillVO;
import nc.vo.Export.FbsDataFileItemVO;
import nc.vo.Export.FbsDatafileVO;

/**
 * @ClassName: ClientCtrl <b> 分布式数据抽取展示Ctrl </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期: 2016年8月2日上午9:14:59
 * @Author 王凯强
 * @Version
 */
public class ClientCtrl extends AbstractManageController {

	public String[] getCardBodyHideCol() {
		// TODO Auto-generated method stub
		return null;
	}

	// 返回列表上的按钮类型数组
	public int[] getCardButtonAry() {
		// TODO Auto-generated method stub
		return new int[] { 
				IBillButton.Query, 
				IBillButton.Return,
				IBillButton.Refresh, 
				FbsButton.NETERROR_NO, 
				FbsButton.NETOK_NO, 
				FbsButton.IMPORT_NO,
				FbsButton.EXPORT_NO
				};
	}

	// 返回列表上的按钮类型数组
	public int[] getListButtonAry() {
		return new int[] { 
				IBillButton.Query, 
				IBillButton.Card,
				IBillButton.Refresh, 
				FbsButton.NETERROR_NO, 
				FbsButton.NETOK_NO, 
				FbsButton.IMPORT_NO,
				FbsButton.EXPORT_NO
				};

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
		return "h3h1";
	}

	public String[] getBillVoName() {
		// TODO Auto-generated method stub
		return new String[] { FbsDataFileBillVO.class.getName(),
				FbsDatafileVO.class.getName(),
				FbsDataFileItemVO.class.getName() };
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
		return "pk_fbs_datafile_item";
	}

	public String getHeadZYXKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPkField() {
		// TODO Auto-generated method stub
		return "pk_fbs_datafile";
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

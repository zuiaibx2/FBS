package nc.ui.export.file.extract;

import nc.pub.fbs.btn.FbsButtonVO;
import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;

/**
 * @ClassName: ClientUI <b> 分布式数据抽取展示UI </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期: 2016年8月2日 上午9:14:30
 * @Author 王凯强
 * @Version
 */
public class ClientUI extends FBSAbstractUI {

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
		FbsButtonVO pbtnVO = new FbsButtonVO();
		addPrivateButton(pbtnVO.getALLDataFileVo());
		addPrivateButton(pbtnVO.getDataFileVo());
		addPrivateButton(pbtnVO.getNetErrBtn());
		addPrivateButton(pbtnVO.getNetOKBtn());
		addPrivateButton(pbtnVO.getSendDataBtn());
		addPrivateButton(pbtnVO.getDataFilePhotoBtn());
		addPrivateButton(pbtnVO.getImportBtn());
		addPrivateButton(pbtnVO.getEexporTVO());

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

	}

}

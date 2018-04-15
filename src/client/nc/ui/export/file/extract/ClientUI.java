package nc.ui.export.file.extract;

import nc.pub.fbs.btn.FbsButtonVO;
import nc.ui.fbs.pub.FBSAbstractUI;
import nc.ui.trade.bill.AbstractManageController;
import nc.ui.trade.manage.ManageEventHandler;

/**
 * @ClassName: ClientUI <b> �ֲ�ʽ���ݳ�ȡչʾUI </b>
 *             <p>
 *             �ڴ˴���Ӵ����������Ϣ
 *             </p>
 *             ��������: 2016��8��2�� ����9:14:30
 * @Author ����ǿ
 * @Version
 */
public class ClientUI extends FBSAbstractUI {

	public ClientUI() {
		super();
		// Ĭ�ϼ�������
		try {
			loadDefaultData();

		} catch (Exception e) {
			showWarningMessage("����Ĭ������ʧ�ܣ�" + e.getMessage());
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
		// ���ñ�ͷִ�й�ʽ
		getBillCardPanel().setAutoExecHeadEditFormula(true);

	}

	/**
	 * ����Ĭ������
	 * 
	 * @throws Exception
	 * @throws ClassNotFoundException
	 */
	public void loadDefaultData() throws Exception {

	}

}

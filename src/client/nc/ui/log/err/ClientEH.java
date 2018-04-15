package nc.ui.log.err;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import nc.bs.framework.common.NCLocator;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ArrayListProcessor;
import nc.pub.fbs.btn.FbsButton;
import nc.ui.fbs.pub.FBSAbstractEventHandler;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.flowdesigner.editor.DefaultFileFilter;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.util.fbs.pub.PubTool;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;

/**
 * �¼���λ���ձ� EventHandler
 * 
 */
/**
 * @ClassName: ClientEH
 * @Description: �ֲ�ʽ������־չʾEH
 * @��Ŀ����: fbsjt
 * @�ļ�����: ClientEH.java
 * @Author: ����ǿ
 * @Date: 2016��8��2������9:15:10
 */
public class ClientEH extends FBSAbstractEventHandler {

	private IUAPQueryBS iUapQuery = null;

	private IUAPQueryBS getIUAPQuery() {
		if (iUapQuery == null)
			iUapQuery = (IUAPQueryBS) NCLocator.getInstance().lookup(IUAPQueryBS.class.getName());
		return iUapQuery;
	}

	public ClientEH(BillManageUI billUI, IControllerBase control) {
		super(billUI, control);
	}

	protected BillManageUI getUI() {
		return (BillManageUI) getBillUI();
	}

	@Override
	protected void onBoSave() throws Exception {
		getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();// ���������Ƿ���ֵ
		super.onBoSave();
	}

	@Override
	protected void onBoElse(int intBtn) throws Exception {
		// TODO �Զ����ɷ������
		super.onBoElse(intBtn);
		if (intBtn == FbsButton.excel_dc) {
			onBillExcel();
		}
	}

	/**
	 * ������: lxf ******************* ����: ���ݵ���Excel ����: int iFlag �������ڣ�(2013-1-29)
	 * �޸����ڣ��޸��ˣ��޸�ԭ��ע�ͱ�־��
	 */
	@SuppressWarnings("deprecation")
	public void onBillExcel() {
		try {

			// �õ�����vo
			CircularlyAccessibleValueObject[] vos = billUI.getBufferData().getAllHeadVOsFromBuffer();
			if (vos.length == 0) {
				this.getBillUI().showErrorMessage("û�д�����־�������²�ѯ");
				return;
			}

			// �õ�״̬
			int returnVal = getFileChooser().showSaveDialog(this.getBillUI());
			// ���������
			FileOutputStream fileOut = null;
			// �õ�������
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				// �õ���������
				String Description = getFileChooser().getFileFilter().getDescription();
				// �½�excel
				HSSFWorkbook wb = null;
				if ("Microsoft Office Excel ������ (.xls)".equals(Description)) {
					wb = new HSSFWorkbook();
					fileOut = new FileOutputStream(getFileChooser().getSelectedFile() + ".xls");
				}

				int sheetCount = 1;
				// �½�������
				HSSFSheet sheet = wb.createSheet("������־��" + sheetCount + "ҳ");

				HSSFRow row = sheet.createRow((int) 0); // ��sheet�����ӱ�ͷ�У���0�У�

				HSSFCellStyle style = wb.createCellStyle(); // ������Ԫ����ʽ
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

				String[] items = new String[] { "ʱ��", "����˾", "����", "��������", "������־����" };
				HSSFCell cell = null;
				for (int i = 0; i < items.length; i++) { // ������ͷ��ģ��̶�Ϊ10��
					cell = row.createCell((short) i);
					cell.setCellValue(items[i]);
					cell.setCellStyle(style);
				}
				sheet.setColumnWidth((short) 0, (short) 3000);// �����п�
				sheet.setColumnWidth((short) 1, (short) 8000);
				sheet.setColumnWidth((short) 2, (short) 6000);
				sheet.setColumnWidth((short) 3, (short) 4000);
				sheet.setColumnWidth((short) 4, (short) 25000);

				// ��ʼ����˾��Ϣ
				initCorpName();
				// excel��Ԫ��ֵ
				String pk_corp = null;
				for (int i = 0; i < vos.length; i++) {
					if (vos[i] != null) {

						row = sheet.createRow((int) i + 1);
						row.createCell((short) 0).setCellValue(
								PubTool.toString(vos[i].getAttributeValue("bill_writer_date").toString()));

						pk_corp = PubTool.toString(vos[i].getAttributeValue("vgroupdef3"));
						String corpname = corpMap.get(pk_corp);
						if (corpname == null) {
							corpname = pk_corp;
						}
						row.createCell((short) 1).setCellValue(PubTool.toString(corpname));
						row.createCell((short) 2)
								.setCellValue(PubTool.toString(vos[i].getAttributeValue("vgroupdef1").toString()));
						row.createCell((short) 3)
								.setCellValue(PubTool.toString(vos[i].getAttributeValue("vgroupdef2").toString()));
						row.createCell((short) 4)
								.setCellValue(PubTool.toString(vos[i].getAttributeValue("fbs_log_content").toString()));

					}
					// if(i > 60000){
					// sheetCount++;
					// sheet = wb.createSheet("������־��"+ sheetCount +"ҳ");
					// }
				}

				wb.write(fileOut);
				fileOut.close();
				MessageDialog.showHintDlg(getBillUI(), "��ʾ", "������ɣ�");

				this.onBoCancel();

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.getBillUI().showErrorMessage(e.getMessage());
			e.printStackTrace();
		}
	}

	private Map<String, String> corpMap = null;

	/**
	 * @Title: initCorpName
	 * @Description: ��ʼ����˾����
	 * @Time: 2016��10��10�� ����5:01:23
	 * @throws BusinessException
	 */
	@SuppressWarnings("rawtypes")
	private void initCorpName() throws BusinessException {
		if (corpMap == null) {
			String sql = "select pk_corp, unitname from bd_corp";
			List list = (List) getIUAPQuery().executeQuery(sql, new ArrayListProcessor());
			corpMap = new HashMap<String, String>();
			Object[] obj = null;
			for (int i = 0; i < list.size(); i++) {
				obj = (Object[]) list.get(i);
				corpMap.put(obj[0].toString(), obj[1].toString());
			}
		}
	}

	// ������
	JFileChooser fileChooser = null;

	// excel�����ࡣ�������洰��
	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();

			DefaultFileFilter filter = new DefaultFileFilter("xls", "Microsoft Office Excel ������");

			fileChooser.setFileFilter(filter);
		}
		return fileChooser;
	}

	@Override
	protected String getHeadCondition() {
		// if("0001".equals(_getCorp().getPrimaryKey())){
		// return null;
		// }
		// return super.getHeadCondition();
		return null;
	}
}
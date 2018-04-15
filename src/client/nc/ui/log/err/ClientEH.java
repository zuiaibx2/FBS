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
 * 下级单位对照表 EventHandler
 * 
 */
/**
 * @ClassName: ClientEH
 * @Description: 分布式错误日志展示EH
 * @项目名称: fbsjt
 * @文件名称: ClientEH.java
 * @Author: 王凯强
 * @Date: 2016年8月2日上午9:15:10
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
		getBillCardPanelWrapper().getBillCardPanel().dataNotNullValidate();// 检测必输项是否有值
		super.onBoSave();
	}

	@Override
	protected void onBoElse(int intBtn) throws Exception {
		// TODO 自动生成方法存根
		super.onBoElse(intBtn);
		if (intBtn == FbsButton.excel_dc) {
			onBillExcel();
		}
	}

	/**
	 * 创建者: lxf ******************* 功能: 单据导出Excel 参数: int iFlag 创建日期：(2013-1-29)
	 * 修改日期，修改人，修改原因，注释标志：
	 */
	@SuppressWarnings("deprecation")
	public void onBillExcel() {
		try {

			// 得到界面vo
			CircularlyAccessibleValueObject[] vos = billUI.getBufferData().getAllHeadVOsFromBuffer();
			if (vos.length == 0) {
				this.getBillUI().showErrorMessage("没有错误日志，请重新查询");
				return;
			}

			// 得到状态
			int returnVal = getFileChooser().showSaveDialog(this.getBillUI());
			// 输出流定义
			FileOutputStream fileOut = null;
			// 得到表体行
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				// 得到保存类型
				String Description = getFileChooser().getFileFilter().getDescription();
				// 新建excel
				HSSFWorkbook wb = null;
				if ("Microsoft Office Excel 工作簿 (.xls)".equals(Description)) {
					wb = new HSSFWorkbook();
					fileOut = new FileOutputStream(getFileChooser().getSelectedFile() + ".xls");
				}

				int sheetCount = 1;
				// 新建工作表
				HSSFSheet sheet = wb.createSheet("错误日志第" + sheetCount + "页");

				HSSFRow row = sheet.createRow((int) 0); // 在sheet中添加表头行（第0行）

				HSSFCellStyle style = wb.createCellStyle(); // 创建单元格样式
				style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
				style.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
				style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

				String[] items = new String[] { "时间", "错误公司", "表名", "错误类型", "错误日志内容" };
				HSSFCell cell = null;
				for (int i = 0; i < items.length; i++) { // 创建表头，模版固定为10列
					cell = row.createCell((short) i);
					cell.setCellValue(items[i]);
					cell.setCellStyle(style);
				}
				sheet.setColumnWidth((short) 0, (short) 3000);// 设置列宽
				sheet.setColumnWidth((short) 1, (short) 8000);
				sheet.setColumnWidth((short) 2, (short) 6000);
				sheet.setColumnWidth((short) 3, (short) 4000);
				sheet.setColumnWidth((short) 4, (short) 25000);

				// 初始化公司信息
				initCorpName();
				// excel单元格赋值
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
					// sheet = wb.createSheet("错误日志第"+ sheetCount +"页");
					// }
				}

				wb.write(fileOut);
				fileOut.close();
				MessageDialog.showHintDlg(getBillUI(), "提示", "导出完成！");

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
	 * @Description: 初始化公司名称
	 * @Time: 2016年10月10日 下午5:01:23
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

	// 工具类
	JFileChooser fileChooser = null;

	// excel工具类。弹出保存窗口
	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();

			DefaultFileFilter filter = new DefaultFileFilter("xls", "Microsoft Office Excel 工作簿");

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

package nc.ui.export.file.extract;

import java.io.File;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import nc.bs.framework.common.NCLocator;
import nc.itf.export.file.IFbsDataFileService;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.pub.Constants;
import nc.pub.fbs.btn.FbsButton;
import nc.ui.export.file.ExtBSDataDialog;
import nc.ui.export.file.ExtDataDialog;
import nc.ui.export.file.transfer.ExportDataUtil;
import nc.ui.export.file.transfer.ImportDataUtil;
import nc.ui.fbs.pub.FBSAbstractEventHandler;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.beans.UIDialog;
import nc.ui.pub.beans.UIFileChooser;
import nc.ui.trade.controller.IControllerBase;
import nc.ui.trade.manage.BillManageUI;
import nc.util.ExtFilenameFilter;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDateTime;

/**
 * @ClassName: ClientEH <b> 分布式数据抽取展示EH </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期: 2016年8月2日上午9:15:10
 * @Author 王凯强
 * @Version
 */
public class ClientEH extends FBSAbstractEventHandler {

	IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
			.getInstance().lookup(IFbsDataFileService.class.getName());
	// db文件导出工具类
	ExportDBUtil ecportUtil = new ExportDBUtil(getUI());

	public ClientEH(BillManageUI billUI, IControllerBase control) {
		super(billUI, control);
	}

	protected BillManageUI getUI() {
		return (BillManageUI) getBillUI();
	}

	protected void onBoElse(int intBtn) throws Exception {

		if (intBtn == FbsButton.DATAFILE_NO) {
			onBoExportData();
		} else if (intBtn == FbsButton.ALLDATAFILE_NO) {
			exportDataByCon();
		} else if (intBtn == FbsButton.DATAFILE_PHOTO_NO) {//导出照片
//			MessageDialog.showHintDlg(getUI(), "提示", "该功能有待完善！");
			onBoExportPhoto();
		}else if(intBtn == FbsButton.SENDDATA_NO){
//			MessageDialog.showHintDlg(getUI(), "提示", "该功能有待完善！");
			onBoSendData();
		}else if(intBtn == FbsButton.IMPORT_NO){
			//导入数据
			onBoBSImportData();
		}else if(intBtn == FbsButton.EXPORT_NO){
			onBoBSExportData();
		} else {
			super.onBoElse(intBtn);
		}

	}
	
	/**
	 * @Title: onBoExportData
	 * @Description: 业务数据迁移导出数据
	 */
	public void onBoBSExportData(){
		ExtBSDataDialog dialog = new ExtBSDataDialog(getUI());
		if (dialog.getDlg().showModal() == UIDialog.ID_OK) {// 点击确定
			final String[] corpArr = dialog.getCorpArr();//获取前端UI传过来的公司
			if (corpArr == null || corpArr.length == 0) {
				MessageDialog.showHintDlg(getBillUI(), "错误", "请选择公司！");
				return;
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("另存数据文件到:");
			if (fileChooser.showDialog(getUI(), "选择") == JFileChooser.APPROVE_OPTION) {
				File saveAsFolder = fileChooser.getSelectedFile();
				final String fileSavePath = saveAsFolder.getAbsolutePath();
				final JDialog processDialog = new ProcessLine(30, getUI()).run();
				final String thistime = new UFDateTime(new Date()).toString();
				new Thread(new Runnable() {
					public void run() {
						try {
							new ExportDataUtil(getUI()).doExport(fileSavePath, corpArr, thistime);
							
							updateOptRecord(thistime);
							
						} catch (Exception e) {
							e.printStackTrace();
							processDialog.dispose();
							getUI().showErrorMessage(e.getMessage());
						}finally{
							processDialog.dispose();
						}
					}
				}).start();
				processDialog.setVisible(true);
			}
		}
	
	}
	/**
	 * @Title: onBoImportData
	 * @Description: 导入数据方法
	 * @Author: 王凯强
	 * @Date: 2017年5月11日
	 * @throws Exception
	 */
	public void onBoBSImportData() throws Exception {
		uifileChooser = getInFileChooser();
		int returnVal = uifileChooser.showDialog(getUI(), "选择");
		if(returnVal != JFileChooser.APPROVE_OPTION){
			return ;
		}
		//文件
		final File realFile = uifileChooser.getSelectedFile();
		uifileChooser.setDialogTitle("目标文件:");
		final JDialog processDialog = new ProcessLine(0, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//进度条进度
					ProcessLine.addValueProcess(1, "正在做必要的准备......");
					
					new ImportDataUtil(getUI()).doImport(realFile, thistime);
					
					updateOptRecord(thistime);
				} catch (Exception e) {
					e.printStackTrace();
					processDialog.dispose();
					getUI().showErrorMessage(e.getMessage());
				}finally{
					processDialog.dispose();
				}
			}
		}).start();
		processDialog.setVisible(true);
	}
	
	private UIFileChooser uifileChooser;
	public UIFileChooser getInFileChooser() {
		if (uifileChooser == null) {
			uifileChooser = new UIFileChooser();
			uifileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			uifileChooser.setFileFilter(new ExtFilenameFilter(
					Constants.DATA_ZIP_EXTNAME, "分布式离线数据文件("
							+ Constants.DATA_ZIP_EXTNAME + ")"));
			uifileChooser.setMultiSelectionEnabled(false);
			uifileChooser.setDialogTitle("请选择分布式离线数据文件");
			uifileChooser.setAcceptAllFileFilterUsed(false);
		}

		return uifileChooser;
	}
	
	/**
	 * @Title: onBoExportPhoto
	 * @Description: 导出照片包方法
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 上午10:21:20
	 * @throws Exception
	 */
	public void onBoExportPhoto() throws Exception {
		fileChooser = getFileChooser();
		int returnVal = fileChooser.showDialog(getUI(), "选择");
		if(returnVal != JFileChooser.APPROVE_OPTION){
			return ;
		}
		//文件保存路径
		final String fileSavePath = fileChooser.getSelectedFile().getAbsolutePath();
		
		final JDialog processDialog = new ProcessLine(0, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//进度条进度
					ProcessLine.addValueProcess(1, "正在初始化需要的内容......");
					
					new ExportPhotoUtil(getUI()).doExport(fileSavePath, thistime);
					
					updateOptRecord(thistime);
					
				} catch (Exception e) {
					e.printStackTrace();
					processDialog.dispose();
					getUI().showErrorMessage(e.getMessage());
				}finally{
					processDialog.dispose();
				}
			}
		}).start();
		processDialog.setVisible(true);
	}
	
	/**
	 * @Title: onBoSendData
	 * @Description: 传输数据
	 * @throws BusinessException
	 */
	public void onBoSendData() throws BusinessException{
		final String lasttime = getMaxExtDate();
		if (lasttime == null) {// 上次抽取文件时间不为空时才可以传输数据
			MessageDialog.showHintDlg(getBillUI(), "错误",
					"本次为第一次抽取文件，请点击\"抽取数据\"按钮！");
			return;
		}
		
		final JDialog processDialog = new ProcessLine(58, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//进度条进度
					ProcessLine.addValueProcess(1, "正在初始化需要的内容......");
					
					new WSSendDataUtil(getUI()).doSendData(lasttime, thistime);;
					
					updateOptRecord(thistime);
					
				} catch (Exception e) {
					e.printStackTrace();
					processDialog.dispose();
					getUI().showErrorMessage(e.getMessage());
				}finally{
					processDialog.dispose();
				}
			}
		}).start();
		processDialog.setVisible(true);
	}
	
	/**
	 * 将中间表的数据抽取成文件
	 * 条件抽取方法
	 * @throws Exception
	 */
	private void exportDataByCon() throws Exception {
		String lasttime = getMaxExtDate();
		if (lasttime == null) {// 上次抽取文件时间不为空时才可以输入时间范围
			MessageDialog.showHintDlg(getBillUI(), "错误",
					"本次为第一次抽取文件，请点击\"抽取数据\"按钮！");
			return;
		}
		ExtDataDialog dialog = new ExtDataDialog(getUI());
		if (dialog.getDlg().showModal() == UIDialog.ID_OK) {// 点击确定
			final String starttime = dialog.getStartDate();// 获取前端UI传过来的开始时间
			final String isAll = dialog.getIsall();//获取前端UI传过来的是否强制全量状态
			if ((starttime == null || starttime.trim().length() == 0) 
					&& (isAll == null || isAll.length() == 0)) {
				MessageDialog.showHintDlg(getBillUI(), "错误", "请选择【开始时间】或【强制全量】");
				return;
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("另存数据文件到:");
			if (fileChooser.showDialog(getUI(), "选择") == JFileChooser.APPROVE_OPTION) {
				File saveAsFolder = fileChooser.getSelectedFile();
				final String thistime = new UFDateTime(new Date()).toString();
				final String fileSavePath = saveAsFolder.getAbsolutePath();
				final JDialog processDialog = new ProcessLine(30, getUI()).run();
				new Thread(new Runnable() {
					public void run() {
						try {
							if("true".equals(isAll)){
								ecportUtil.exportData(fileSavePath, thistime, null);
							}else{
								ecportUtil.exportData(fileSavePath, thistime, starttime);
							}
							
							updateOptRecord(thistime);
							
						} catch (Exception e) {
							e.printStackTrace();
							processDialog.dispose();
							getUI().showErrorMessage(e.getMessage());
						}finally{
							processDialog.dispose();
						}
					}
				}).start();
				processDialog.setVisible(true);
			}
		}
	}

	/**
	 * @Title: onBoImportData
	 * @Description: 抽取数据方法（增量抽取）
	 * @throws Exception
	 */
	private void onBoExportData() throws Exception {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("另存数据文件到:");
		if (fileChooser.showDialog(getUI(), "选择") == JFileChooser.APPROVE_OPTION) {
			File saveAsFolder = fileChooser.getSelectedFile();
			final String thistime = new UFDateTime(new Date()).toString();
			final String fileSavePath = saveAsFolder.getAbsolutePath();
			//FIXME 强制全量的处理
			final String lasttime = getMaxExtDate();
			final JDialog processDialog = new ProcessLine(30, getUI()).run();

			new Thread(new Runnable() {
				public void run() {
					try {
						ecportUtil.exportData(fileSavePath, thistime, lasttime);
						
						updateOptRecord(thistime);
						
					} catch (Exception e) {
						e.printStackTrace();
						processDialog.dispose();
						getUI().showErrorMessage(e.getMessage());
					}finally{
						processDialog.dispose();
					}
				}
			}).start();
			processDialog.setVisible(true);
		}

	}

	private JFileChooser fileChooser = null;
	/**
	 * @Title: getFileChooser
	 * @Description: 创建文件选择器
	 * @Author: 王凯强
	 * @return
	 */
	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("另存数据文件到:");
			// 设置成只能选择文件夹
	        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
	    return fileChooser;
	}

	
	/**
	 * @Title: updateOptRecord
	 * @Description: 更新buffer数据
	 * @Time: 2016年10月26日 下午2:29:48
	 * @param thistime
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	private void updateOptRecord(String thistime) throws ClassNotFoundException, Exception{
		SuperVO[] queryVos = queryHeadVOs(" operate_time >='" + thistime + "' ");

		getBufferData().clear();
		// 增加数据到Buffer
		addDataToBuffer(queryVos);
		updateBuffer();
	}
	
	/**
	 * @Title: getMaxExtDate
	 * @Description: 获取上次抽取文件的时间
	 * @Author: 王凯强
	 * @Date: 2016年9月5日
	 * @return 上次抽取文件时间
	 * @throws BusinessException
	 */
	private String getMaxExtDate() throws BusinessException {
		String sql = "select max(time) from fbs_export_time";
		Object obj = ((IUAPQueryBS) NCLocator.getInstance().lookup(
				IUAPQueryBS.class.getName())).executeQuery(sql,
				new ColumnProcessor());
		return obj != null ? obj.toString() : null;
	}

}

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
 * @ClassName: ClientEH <b> �ֲ�ʽ���ݳ�ȡչʾEH </b>
 *             <p>
 *             �ڴ˴���Ӵ����������Ϣ
 *             </p>
 *             ��������: 2016��8��2������9:15:10
 * @Author ����ǿ
 * @Version
 */
public class ClientEH extends FBSAbstractEventHandler {

	IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator
			.getInstance().lookup(IFbsDataFileService.class.getName());
	// db�ļ�����������
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
		} else if (intBtn == FbsButton.DATAFILE_PHOTO_NO) {//������Ƭ
//			MessageDialog.showHintDlg(getUI(), "��ʾ", "�ù����д����ƣ�");
			onBoExportPhoto();
		}else if(intBtn == FbsButton.SENDDATA_NO){
//			MessageDialog.showHintDlg(getUI(), "��ʾ", "�ù����д����ƣ�");
			onBoSendData();
		}else if(intBtn == FbsButton.IMPORT_NO){
			//��������
			onBoBSImportData();
		}else if(intBtn == FbsButton.EXPORT_NO){
			onBoBSExportData();
		} else {
			super.onBoElse(intBtn);
		}

	}
	
	/**
	 * @Title: onBoExportData
	 * @Description: ҵ������Ǩ�Ƶ�������
	 */
	public void onBoBSExportData(){
		ExtBSDataDialog dialog = new ExtBSDataDialog(getUI());
		if (dialog.getDlg().showModal() == UIDialog.ID_OK) {// ���ȷ��
			final String[] corpArr = dialog.getCorpArr();//��ȡǰ��UI�������Ĺ�˾
			if (corpArr == null || corpArr.length == 0) {
				MessageDialog.showHintDlg(getBillUI(), "����", "��ѡ��˾��");
				return;
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("��������ļ���:");
			if (fileChooser.showDialog(getUI(), "ѡ��") == JFileChooser.APPROVE_OPTION) {
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
	 * @Description: �������ݷ���
	 * @Author: ����ǿ
	 * @Date: 2017��5��11��
	 * @throws Exception
	 */
	public void onBoBSImportData() throws Exception {
		uifileChooser = getInFileChooser();
		int returnVal = uifileChooser.showDialog(getUI(), "ѡ��");
		if(returnVal != JFileChooser.APPROVE_OPTION){
			return ;
		}
		//�ļ�
		final File realFile = uifileChooser.getSelectedFile();
		uifileChooser.setDialogTitle("Ŀ���ļ�:");
		final JDialog processDialog = new ProcessLine(0, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//����������
					ProcessLine.addValueProcess(1, "��������Ҫ��׼��......");
					
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
					Constants.DATA_ZIP_EXTNAME, "�ֲ�ʽ���������ļ�("
							+ Constants.DATA_ZIP_EXTNAME + ")"));
			uifileChooser.setMultiSelectionEnabled(false);
			uifileChooser.setDialogTitle("��ѡ��ֲ�ʽ���������ļ�");
			uifileChooser.setAcceptAllFileFilterUsed(false);
		}

		return uifileChooser;
	}
	
	/**
	 * @Title: onBoExportPhoto
	 * @Description: ������Ƭ������
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����10:21:20
	 * @throws Exception
	 */
	public void onBoExportPhoto() throws Exception {
		fileChooser = getFileChooser();
		int returnVal = fileChooser.showDialog(getUI(), "ѡ��");
		if(returnVal != JFileChooser.APPROVE_OPTION){
			return ;
		}
		//�ļ�����·��
		final String fileSavePath = fileChooser.getSelectedFile().getAbsolutePath();
		
		final JDialog processDialog = new ProcessLine(0, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//����������
					ProcessLine.addValueProcess(1, "���ڳ�ʼ����Ҫ������......");
					
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
	 * @Description: ��������
	 * @throws BusinessException
	 */
	public void onBoSendData() throws BusinessException{
		final String lasttime = getMaxExtDate();
		if (lasttime == null) {// �ϴγ�ȡ�ļ�ʱ�䲻Ϊ��ʱ�ſ��Դ�������
			MessageDialog.showHintDlg(getBillUI(), "����",
					"����Ϊ��һ�γ�ȡ�ļ�������\"��ȡ����\"��ť��");
			return;
		}
		
		final JDialog processDialog = new ProcessLine(58, getUI()).run();
		final String thistime = new UFDateTime(new Date()).toString();
		new Thread(new Runnable() {
			public void run() {
				try {
					//����������
					ProcessLine.addValueProcess(1, "���ڳ�ʼ����Ҫ������......");
					
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
	 * ���м������ݳ�ȡ���ļ�
	 * ������ȡ����
	 * @throws Exception
	 */
	private void exportDataByCon() throws Exception {
		String lasttime = getMaxExtDate();
		if (lasttime == null) {// �ϴγ�ȡ�ļ�ʱ�䲻Ϊ��ʱ�ſ�������ʱ�䷶Χ
			MessageDialog.showHintDlg(getBillUI(), "����",
					"����Ϊ��һ�γ�ȡ�ļ�������\"��ȡ����\"��ť��");
			return;
		}
		ExtDataDialog dialog = new ExtDataDialog(getUI());
		if (dialog.getDlg().showModal() == UIDialog.ID_OK) {// ���ȷ��
			final String starttime = dialog.getStartDate();// ��ȡǰ��UI�������Ŀ�ʼʱ��
			final String isAll = dialog.getIsall();//��ȡǰ��UI���������Ƿ�ǿ��ȫ��״̬
			if ((starttime == null || starttime.trim().length() == 0) 
					&& (isAll == null || isAll.length() == 0)) {
				MessageDialog.showHintDlg(getBillUI(), "����", "��ѡ�񡾿�ʼʱ�䡿��ǿ��ȫ����");
				return;
			}
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			fileChooser.setDialogTitle("��������ļ���:");
			if (fileChooser.showDialog(getUI(), "ѡ��") == JFileChooser.APPROVE_OPTION) {
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
	 * @Description: ��ȡ���ݷ�����������ȡ��
	 * @throws Exception
	 */
	private void onBoExportData() throws Exception {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fileChooser.setDialogTitle("��������ļ���:");
		if (fileChooser.showDialog(getUI(), "ѡ��") == JFileChooser.APPROVE_OPTION) {
			File saveAsFolder = fileChooser.getSelectedFile();
			final String thistime = new UFDateTime(new Date()).toString();
			final String fileSavePath = saveAsFolder.getAbsolutePath();
			//FIXME ǿ��ȫ���Ĵ���
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
	 * @Description: �����ļ�ѡ����
	 * @Author: ����ǿ
	 * @return
	 */
	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			fileChooser.setDialogTitle("��������ļ���:");
			// ���ó�ֻ��ѡ���ļ���
	        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
	    return fileChooser;
	}

	
	/**
	 * @Title: updateOptRecord
	 * @Description: ����buffer����
	 * @Time: 2016��10��26�� ����2:29:48
	 * @param thistime
	 * @throws ClassNotFoundException
	 * @throws Exception
	 */
	private void updateOptRecord(String thistime) throws ClassNotFoundException, Exception{
		SuperVO[] queryVos = queryHeadVOs(" operate_time >='" + thistime + "' ");

		getBufferData().clear();
		// �������ݵ�Buffer
		addDataToBuffer(queryVos);
		updateBuffer();
	}
	
	/**
	 * @Title: getMaxExtDate
	 * @Description: ��ȡ�ϴγ�ȡ�ļ���ʱ��
	 * @Author: ����ǿ
	 * @Date: 2016��9��5��
	 * @return �ϴγ�ȡ�ļ�ʱ��
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

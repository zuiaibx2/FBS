package nc.ui.export.file.extract; 
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import nc.ui.trade.manage.BillManageUI;
  
/**
 * @ClassName: ProcessLine
 * <b> �������� </b>
 * <p>
 *     �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������: 2016��10��19�� ����10:48:03
 * @Author ����ǿ
 * @Version 
 */
public class ProcessLine {
	private JDialog dialog = null;
	BillManageUI exportUI;
	
	public static JProgressBar progressBar = null;
	
	
	/**
	 * @Package: nc.ui.export.file.extract.ProcessLine.java
	 * @Description:���췽������ʼ����������
	 * @param maximum ���������ֵ������0ʱĬ��ֵ��100
	 * @param billUI ҳ��UI
	 */
	public ProcessLine(int maximum, BillManageUI billUI) {
		exportUI = billUI;
		initProgressBar(maximum);
	}
	
	/**
	 * @Title: initProgressBar
	 * @Description: ��ʼ��������
	 * @Time: 2016��10��27�� ����9:51:36
	 */
	private void initProgressBar(int maximum){
		progressBar = new JProgressBar();
		progressBar.setPreferredSize(new Dimension(370,20));
        progressBar.setStringPainted(true);  
        progressBar.setIndeterminate(false);
        maximum = maximum == 0 ? maximum = 100: maximum;
        progressBar.setMaximum(maximum);
        progressBar.setValue(0);
		progressBar.setString("");
	}
	
	/**
	 * @Title: addDefaultProcess
	 * @Description: ����Ĭ�����ݽ��ȣ�ÿ������1������
	 * @Author: ����ǿ
	 * @Time: 2016��11��7�� ����3:53:59
	 * @param remindStr ��ʾ�������ֶ�
	 */
	public static void addDefaultProcess(String remindStr){
//		int interval = (int) Math.ceil(100/56);
		progressBar.setValue(1 + progressBar.getValue());
		progressBar.setString(remindStr);
	}
	
//	/**
//	 * @Title: addProcess
//	 * @Description: ��ȡ�����������ѣ�������
//	 * @Time: 2016��10��27�� ����9:51:56
//	 * @param tablename
//	 */
//	public static void addProcess(String tablename){
//		if(tablename == null){
//			progressBar.setValue(95);
//			progressBar.setString("����ѹ���ļ�...");
//			return ;
//		}
//		int interval = (int) Math.ceil(100/28);
//		progressBar.setValue(interval + progressBar.getValue());
//		progressBar.setString("���ڳ�ȡ'"+ tablename +"'����......");
//	}
	
	/**
	 * @Title: addValueProcess
	 * @Description: �������޸Ľ��Ⱥ��������
	 * @Time: 2016��10��27�� ����9:52:20
	 * @param value  ������ֵ
	 * @param remindStr �������������
	 */
	public static void addValueProcess(int value, String remindStr){
		progressBar.setValue(value);
		progressBar.setString(remindStr);
	}
	
//	/**
//	 * @Title: addProcess
//	 * @Description: ������Ƭ������
//	 * @Time: 2016��10��26�� ����10:35:55
//	 * @param index �ڼ�����
//	 * @param all   һ��������
//	 */
//	public static void addProcess(int index, int all){
//		if(all == 0){
//			progressBar.setValue(99);
//			progressBar.setString("����ѹ���ļ�...");
//			return ;
//		}
//		
//		int interval = (int) Math.ceil(100/all);
//		progressBar.setValue(interval + progressBar.getValue());
//		progressBar.setString("���ڳ�ȡ��"+ index +"����Ա����Ƭ......");
//	}
	
	public static void setMaximum(int maximum){
		maximum = maximum == 0 ? maximum = 100: maximum;
        progressBar.setMaximum(maximum);
	}
	
    public JDialog run(){
    	// �õ���ʾ����Ļ�Ŀ��
        int width = exportUI.getWidth();
        int height = exportUI.getHeight();
        
        JLabel label = new JLabel("��ʱ���������ڽ����У����Ժ�");
        
        JPanel panel = new JPanel();      
        panel.add(label);
        panel.setAlignmentY(Component.TOP_ALIGNMENT);
        panel.setSize(370, 30);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
        
        JPanel progressPanel = new JPanel();      
        progressPanel.add(progressBar);
        progressPanel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        progressPanel.setSize(370, 30);
        progressPanel.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        
        dialog = new JDialog();
        dialog.add(panel);
        dialog.add(progressPanel);
        dialog.setTitle("��ʾ");
		dialog.setLocationRelativeTo(exportUI);
		dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(width / 2, height / 2, 400, 100);
        dialog.setResizable(false);
        return dialog;
    }
    
//    ���÷������£�ע��processDialog.setVisible(true);��������߳�֮��
//    final JDialog processDialog = new ProcessLine(getUI()).run();
//	new Thread(new Runnable() {
//		public void run() {
//			try {
//				ecportUtil.exportData(fileSavePath, thistime, starttime);
//				SuperVO[] queryVos = queryHeadVOs(" operate_time >='"+thistime+"' ");
//				
//				getBufferData().clear();
//				// �������ݵ�Buffer
//				addDataToBuffer(queryVos);
//				
//				processDialog.setVisible(false);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}).start();
//	processDialog.setVisible(true);
}  
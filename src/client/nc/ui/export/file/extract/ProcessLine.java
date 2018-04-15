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
 * <b> 进度条类 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年10月19日 上午10:48:03
 * @Author 王凯强
 * @Version 
 */
public class ProcessLine {
	private JDialog dialog = null;
	BillManageUI exportUI;
	
	public static JProgressBar progressBar = null;
	
	
	/**
	 * @Package: nc.ui.export.file.extract.ProcessLine.java
	 * @Description:构造方法，初始化进度条，
	 * @param maximum 进度条最大值，传入0时默认值是100
	 * @param billUI 页面UI
	 */
	public ProcessLine(int maximum, BillManageUI billUI) {
		exportUI = billUI;
		initProgressBar(maximum);
	}
	
	/**
	 * @Title: initProgressBar
	 * @Description: 初始化滚动条
	 * @Time: 2016年10月27日 上午9:51:36
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
	 * @Description: 增加默认数据进度，每次增加1个进度
	 * @Author: 王凯强
	 * @Time: 2016年11月7日 下午3:53:59
	 * @param remindStr 显示的提醒字段
	 */
	public static void addDefaultProcess(String remindStr){
//		int interval = (int) Math.ceil(100/56);
		progressBar.setValue(1 + progressBar.getValue());
		progressBar.setString(remindStr);
	}
	
//	/**
//	 * @Title: addProcess
//	 * @Description: 获取增量数据提醒，按表名
//	 * @Time: 2016年10月27日 上午9:51:56
//	 * @param tablename
//	 */
//	public static void addProcess(String tablename){
//		if(tablename == null){
//			progressBar.setValue(95);
//			progressBar.setString("正在压缩文件...");
//			return ;
//		}
//		int interval = (int) Math.ceil(100/28);
//		progressBar.setValue(interval + progressBar.getValue());
//		progressBar.setString("正在抽取'"+ tablename +"'数据......");
//	}
	
	/**
	 * @Title: addValueProcess
	 * @Description: 进度条修改进度和提醒语句
	 * @Time: 2016年10月27日 上午9:52:20
	 * @param value  进度条值
	 * @param remindStr 进度条提醒语句
	 */
	public static void addValueProcess(int value, String remindStr){
		progressBar.setValue(value);
		progressBar.setString(remindStr);
	}
	
//	/**
//	 * @Title: addProcess
//	 * @Description: 导出照片进度条
//	 * @Time: 2016年10月26日 上午10:35:55
//	 * @param index 第几个人
//	 * @param all   一共几个人
//	 */
//	public static void addProcess(int index, int all){
//		if(all == 0){
//			progressBar.setValue(99);
//			progressBar.setString("正在压缩文件...");
//			return ;
//		}
//		
//		int interval = (int) Math.ceil(100/all);
//		progressBar.setValue(interval + progressBar.getValue());
//		progressBar.setString("正在抽取第"+ index +"个人员的照片......");
//	}
	
	public static void setMaximum(int maximum){
		maximum = maximum == 0 ? maximum = 100: maximum;
        progressBar.setMaximum(maximum);
	}
	
    public JDialog run(){
    	// 得到显示器屏幕的宽高
        int width = exportUI.getWidth();
        int height = exportUI.getHeight();
        
        JLabel label = new JLabel("耗时操作，正在进行中，请稍候！");
        
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
        dialog.setTitle("提示");
		dialog.setLocationRelativeTo(exportUI);
		dialog.setAlwaysOnTop(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setBounds(width / 2, height / 2, 400, 100);
        dialog.setResizable(false);
        return dialog;
    }
    
//    调用方法如下：注意processDialog.setVisible(true);必须放在线程之后
//    final JDialog processDialog = new ProcessLine(getUI()).run();
//	new Thread(new Runnable() {
//		public void run() {
//			try {
//				ecportUtil.exportData(fileSavePath, thistime, starttime);
//				SuperVO[] queryVos = queryHeadVOs(" operate_time >='"+thistime+"' ");
//				
//				getBufferData().clear();
//				// 增加数据到Buffer
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
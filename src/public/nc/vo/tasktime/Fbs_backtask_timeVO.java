package nc.vo.tasktime; 

import nc.vo.pub.SuperVO;

/**
 * @ClassName: Fbs_backtask_timeVO
 * <b> ��¼������̨����ִ��ʱ�� </b>
 * <p>
 *     �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������: 2016��11��2�� ����4:34:35
 * @Author ����ǿ
 * @Version 
 */
public class Fbs_backtask_timeVO extends SuperVO{
	private static final long serialVersionUID = -6074133078033023401L;
	
	private java.lang.String pk_backtask_time;
	private java.lang.String time;
	private java.lang.String ts;
	
	public java.lang.String getPk_backtask_time() {
		return pk_backtask_time;
	}
	public void setPk_backtask_time(java.lang.String pk_backtask_time) {
		this.pk_backtask_time = pk_backtask_time;
	}
	public java.lang.String getTime() {
		return time;
	}
	public void setTime(java.lang.String time) {
		this.time = time;
	}
	public java.lang.String getTs() {
		return ts;
	}
	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}
	@Override
	public String getPKFieldName() {
		return "pk_backtask_time";
	}
	@Override
	public String getParentPKFieldName() {
		return null;
	}
	@Override
	public String getTableName() {
		return "fbs_backtask_time";
	}
	
	
}

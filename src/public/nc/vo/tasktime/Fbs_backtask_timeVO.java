package nc.vo.tasktime; 

import nc.vo.pub.SuperVO;

/**
 * @ClassName: Fbs_backtask_timeVO
 * <b> 记录增量后台任务执行时间 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年11月2日 下午4:34:35
 * @Author 王凯强
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

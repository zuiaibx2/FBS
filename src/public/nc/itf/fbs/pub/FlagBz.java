package nc.itf.fbs.pub;

/**
 * @ClassName:
 * <b> 所用flag标志字段 </b>
 * 创建日期: 2016年9月30日 下午1:07:16
 * @Author lxf
 * @Version 
 */
public interface FlagBz {

	//	后台任务所用flag
	public String sorry = "sorry";/**获取的
	                                /*增量数据集有错误数据，
	                                 * 请查看异常日志展示，修正后再执行任务
	                                 */
	public String success = "success";/**
	                                    *本次没有增量数据
	                                    */
	public String ok = "ok";/**
     									*增量数据生成成功，
     									*可以进行数据抽取
     									*/
	
}

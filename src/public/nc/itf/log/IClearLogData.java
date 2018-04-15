package nc.itf.log;

import nc.vo.pub.BusinessException;

/**
 * @ClassName: IClearLogData
 * <b> 清空数据校验日志 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:2016年7月27日 上午10:19:43
 * @Author 王凯强
 * @Version 
 */
public interface IClearLogData {
	public void clearLogDatas() throws BusinessException;
}

package nc.itf.mid;

import java.util.List;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @ClassName: IInsertMidData
 * <b> 数据放入下级单位中间表接口 </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:2016年7月27日 上午10:19:43
 * @Author 王凯强
 * @Version 
 */
public interface IInsertMidData {
	/**
	 * @Title: insertMidData
	 * @Description: 插入中间表数据
	 * @Author: 王凯强
	 * @Date: 2016年8月8日
	 * @return
	 * @throws Exception
	 */
	public String insertMidData() throws BusinessException;
	
	public int insertMidData(List<SuperVO> list) throws BusinessException;
}

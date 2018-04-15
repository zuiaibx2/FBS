package nc.itf.check;

import java.util.List;
import java.util.Map;

import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;

/**
 * @author changrh 2016-7-31
 * 抽取数据校验接口
 *
 */
public interface ICheckData {
	
	
	/**
	 * @Title: checkCorp
	 * @Description: 获取下级bd_corp表中存在mid_bd_corp(集团下发公司表)中不存在的企业pk_corp
	 * @Author: 王凯强
	 * @Date: 2016年9月9日
	 * @return
	 * @throws BusinessException
	 */
	public List<String> checkCorp() throws BusinessException;
	
	/**
	 * @Title: checkCorp
	 * @Description: 获取下级bd_corp表中存在mid_bd_corp(集团下发公司表)中所有pk_corp
	 * @Author: lxf
	 * @Date: 2016年10月9日
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, String> allCorp() throws BusinessException;
	
	/**
	 * @Title: getNewPk
	 * @Description: 获取新的主键
	 * @Time: 2016年10月27日 上午11:43:01
	 * @param pkOld
	 * @param mapCorp
	 * @param checkvo
	 * @return
	 * @throws BusinessException
	 */
	public String getNewPk(String pkOld, Map<String, String> mapCorp, SuperVO checkvo) throws BusinessException;
	
	/**
	 * @Title: changPk
	 * @Description: 转换主键方法
	 * @Author: 王凯强
	 * @Time: 2016年11月1日 下午3:22:04
	 * @param checkvo
	 * @param pkFields
	 * @param tbname
	 * @return
	 * @throws BusinessException
	 */
	public SuperVO changPk(SuperVO checkvo, String[] pkFields, String tbname) throws BusinessException;
	
}

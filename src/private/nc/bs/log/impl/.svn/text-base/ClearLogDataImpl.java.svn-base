package nc.bs.log.impl;

import nc.bs.dao.BaseDAO;
import nc.bs.logging.Logger;
import nc.itf.log.IClearLogData;
import nc.vo.pub.BusinessException;

/**
 * @ClassName: InsertMidDataDao <b> 数据放入下级单位中间表 </b>
 *             <p>
 *             在此处添加此类的描述信息
 *             </p>
 *             创建日期:2016年7月27日 上午10:02:54
 * @Author 王凯强
 * @Version
 */
public class ClearLogDataImpl implements IClearLogData {

	public void clearLogDatas() throws BusinessException {
		String sql = "delete from fbs_error_logs";
		int count = getDao().executeUpdate(sql);
		Logger.info("共清除错误日志" + count + "条数据...");
	}

	private BaseDAO dao = null;

	public BaseDAO getDao() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}
}

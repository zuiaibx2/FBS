package nc.bs.log.impl;

import nc.bs.dao.BaseDAO;
import nc.bs.logging.Logger;
import nc.itf.log.IClearLogData;
import nc.vo.pub.BusinessException;

/**
 * @ClassName: InsertMidDataDao <b> ���ݷ����¼���λ�м�� </b>
 *             <p>
 *             �ڴ˴���Ӵ����������Ϣ
 *             </p>
 *             ��������:2016��7��27�� ����10:02:54
 * @Author ����ǿ
 * @Version
 */
public class ClearLogDataImpl implements IClearLogData {

	public void clearLogDatas() throws BusinessException {
		String sql = "delete from fbs_error_logs";
		int count = getDao().executeUpdate(sql);
		Logger.info("�����������־" + count + "������...");
	}

	private BaseDAO dao = null;

	public BaseDAO getDao() {
		if (dao == null) {
			dao = new BaseDAO();
		}
		return dao;
	}
}

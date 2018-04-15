package nc.bs.fbs.autdatatask;

import nc.bs.dao.BaseDAO;
import nc.bs.dao.DAOException;
import nc.bs.framework.common.InvocationInfoProxy;
import nc.bs.logging.Logger;
import nc.bs.mid.dao.InsertMidDataDao;
import nc.bs.pub.pa.PreAlertObject;
import nc.bs.pub.pa.PreAlertReturnType;
import nc.bs.pub.taskcenter.BgWorkingContext;
import nc.bs.pub.taskcenter.IBackgroundWorkPlugin;
import nc.itf.fbs.pub.FlagBz;
import nc.vo.pub.BusinessException;

public class DataAutTask implements IBackgroundWorkPlugin {
	
	public PreAlertObject executeTask(BgWorkingContext bgwc)
			throws BusinessException {

		String flag = "";
		Logger.debug(">>> nc.impl.hrdsbt.task.MergeDataIntoNCSystem.executeTask Start <<<");
		try {
			InsertMidDataDao dao = new InsertMidDataDao();
			final String ds = InvocationInfoProxy.getInstance().getUserDataSource();
			//FIXME 权宜之计，后续重新架构起个线程，不受事务控制
			new Thread(new Runnable() {
				public void run() {
					try {
						BaseDAO dao = new BaseDAO(ds);
						dao.executeUpdate("delete from fbs_error_logs");
					} catch (DAOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			String sflag = dao.insertMidData();
			if(FlagBz.sorry.equals(sflag)){
				flag = "获取的增量数据集有错误数据，请查看异常日志展示，修正后再执行任务";
				throw new BusinessException(flag);
			}else if(FlagBz.success.equals(sflag)){
				flag = "本次没有增量数据";
			}else if(FlagBz.ok.equals(sflag)){
				flag = "增量数据生成成功，可以进行数据抽取";
			}
		}catch (BusinessException e)  {
			e.printStackTrace();
			throw e;
		}
		PreAlertObject retObj = new PreAlertObject();
		retObj.setReturnObj(flag);
		retObj.setReturnType(PreAlertReturnType.RETURNNOTHING);
		return retObj;
	}


}

package nc.ui.export.file.extract; 

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.desktop.ui.WorkbenchEnvironment;
import nc.itf.check.ICheckData;
import nc.itf.export.file.IFbsDataFileService;
import nc.itf.spike.ISpike;
import nc.itf.uap.IUAPQueryBS;
import nc.jdbc.framework.processor.ColumnProcessor;
import nc.pub.Constants;
import nc.ui.pub.ClientEnvironment;
import nc.ui.trade.manage.BillManageUI;
import nc.util.AntZipUtil;
import nc.util.FileUtil;
import nc.vo.Export.FbsDataFileItemVO;
import nc.vo.Export.FbsDatafileVO;
import nc.vo.Export.time.FbsExportTimeVO;
import nc.vo.hr.iufo.func.Global;
import nc.vo.photo.Fbs_export_photoVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDateTime;
import nc.vo.spike.bd.Bd_psnbasdocVO;

import org.apache.commons.io.FileUtils;

/**
 * @ClassName: ExportPhotoUtil
 * <b> 导出照片工具类 </b>
 * <p>
 *     在用户选择的文件夹下创建以当前时间命名的文件夹，
 *     里面存储的是"人员基本信息主键_姓名.jpg"格式的照片
 *     (pk_psnbasdoc_psnname.jpg)
 * </p>
 * 创建日期: 2016年10月26日 上午10:57:01
 * @Author 王凯强
 * @Version 1.0
 */
public class ExportPhotoUtil {

	BillManageUI exportUI;
	
	public ExportPhotoUtil(BillManageUI billUI) {
		exportUI = billUI;
	}
	
	IFbsDataFileService ifdfService = (IFbsDataFileService) NCLocator.getInstance().lookup(IFbsDataFileService.class.getName());
	
	ISpike spike = (ISpike) NCLocator.getInstance().lookup(ISpike.class.getName());
	
	
	/**
	 * @Title: doExport
	 * @Description: 导出
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 上午10:21:20
	 * @param fileSavePath
	 * @param thistime
	 * @throws Exception 
	 */
	final void doExport(String fileSavePath, String thistime) throws Exception {
		String filePath = null;
		String lastTime = null;
		try {
			//上次抽取时间
			String sql_last = "select max(time) from fbs_export_photo ";
			lastTime = spike.getMaxTime(sql_last);
			
			List<Bd_psnbasdocVO> psn_list = spike.getPhotoSpikeData(lastTime);
			
			if(psn_list.size() == 0){
				throw new BusinessException("没有需要导出照片的人员！");
			}
			
			String _filename = FileUtil.getFolderNameByTime();
			//照片路径
			filePath = fileSavePath + Constants.SEP + _filename;
			
			// 创建相片文件夹(文件夹不存在时创建)
			FileUtil.createFolder(filePath);
			ProcessLine.setMaximum(psn_list.size()+1);
			for(int i = 0; i < psn_list.size(); i++){
				//进度条进度
				ProcessLine.addDefaultProcess("正在抽取第"+ (i+1) +"个人员的照片......");
				String pk_psnbasdoc = changPk(psn_list.get(i));
				String fileName = filePath + Constants.SEP + pk_psnbasdoc + "_" + psn_list.get(i).getPsnname() + Constants.PHOTO_EXTNAME;
				saveToFile(psn_list.get(i), fileName, thistime);
			}
			
			//保存操作日志
			saveLog(lastTime, UFBoolean.TRUE);
			
			//结束进度条
			ProcessLine.addValueProcess(psn_list.size(), "正在压缩文件......");
			
			// 创建压缩文件保存路径
			File zipPath = FileUtil.createFolder(fileSavePath);
			String zipFileName = _filename + Constants.PHOTO_ZIP_EXTNAME;
			String zipFileFullPath = zipPath.getAbsolutePath() + Constants.SEP + zipFileName;
			AntZipUtil.zipFile(zipFileFullPath, filePath);

//			//用完文件夹后删除文件夹
//			FileUtil.deleteFolder(filePath);
		} catch (Exception e) {
			//保存操作日志
			saveLog(lastTime, UFBoolean.FALSE);
			e.printStackTrace();
			throw(e);
		} finally {
			//用完文件夹后删除文件夹
			FileUtil.deleteFolder(filePath);
		}
	}
	
	private Map<String, String> mapCorp = null;
	/**
	 * @Title: changPk
	 * @Description: 转换主键，调用与数据抽取转换主键方法
	 * @Time: 2016年10月26日 下午5:1:11
	 * @param psnbasdocvo
	 * @return
	 * @throws BusinessException
	 */
	private String changPk(Bd_psnbasdocVO psnbasdocvo) throws BusinessException{
		ICheckData checkData = (ICheckData) NCLocator.getInstance().lookup(ICheckData.class.getName());
 		if (mapCorp == null) {
			mapCorp = checkData.allCorp();
		}
 		String pk_psnbasdoc = psnbasdocvo.getPk_psnbasdoc();
 		if ((pk_psnbasdoc.trim()).length() != 20) {
			throw new BusinessException("人员基本信息主键格式不正确，请联系业务人员！！");
		}
 		//转换主键
 		String pk_New = checkData.getNewPk(pk_psnbasdoc, mapCorp, psnbasdocvo);
 		return pk_New;
	}
	
	/**
	 * @Title: saveToFile
	 * @Description: 保存文件
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 上午10:21:29
	 * @param psnVO
	 * @param filepath
	 * @param thistime
	 * @throws IOException
	 * @throws BusinessException
	 */
	private void saveToFile(Bd_psnbasdocVO psnVO, String filepath, String thistime) throws IOException, BusinessException {
        byte photo[] = psnVO.getNewphoto();//这里的newphoto对应到数据库的photo
        
        if (photo == null) {
            return;
        }
        
        FileUtils.writeByteArrayToFile(new File(filepath), photo);
        
        String pk_psnbasdoc = psnVO.getPk_psnbasdoc();
        //保存导出记录
        saveOptTime(pk_psnbasdoc,thistime);
        //保存记录后直接在数据库把照片更新到记录中
        updatePsnPhoto(thistime, photo, pk_psnbasdoc);
    }
	
	/**
	 * @Title: saveLog
	 * @Description: 保存操作记录
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 下午2:49:46
	 * @param lastTime
	 * @throws BusinessException
	 */
	private void saveLog(String lastTime, UFBoolean flag) throws BusinessException{
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// 默认当前登陆人
		dataFileVO.setPk_corp(Global.getPkGroup());// 默认当前登陆公司
		dataFileVO.setOperate_time(new UFDateTime(new Date()));// 操作时间
		dataFileVO.setIssuccess(flag);
		dataFileVO.setIsall(lastTime==null?UFBoolean.TRUE:UFBoolean.FALSE);
		dataFileVO.setIsspike(lastTime!=null?UFBoolean.TRUE:UFBoolean.FALSE);
		
		dataFileVO.setStart_date(lastTime!=null?new UFDateTime(lastTime):null);
		
		dataFileVO.setVbillstatus(Integer.valueOf(8));// 抽取数据结束时间
		
		dataFileVO.setVmemo(Constants.OPT_TYPE_PHOTO);
		
		ifdfService.saveLogVO(dataFileVO,new FbsDataFileItemVO[]{},new FbsExportTimeVO[]{});
	}
	
	
	/**
	 * @Title: saveOptTime
	 * @Description: 保存导出记录
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 下午4:08:51
	 * @param pk_psnbasdoc
	 * @param thistime
	 * @return
	 * @throws BusinessException
	 */
	private void saveOptTime(String pk_psnbasdoc, String thistime) throws BusinessException{
		IUAPQueryBS bs = NCLocator.getInstance().lookup(IUAPQueryBS.class);
		String photo_sql = "select pk_export_photo from fbs_export_photo where pk_psnbasdoc = '"+ pk_psnbasdoc +"'";
		Object pk_export_photo =  bs.executeQuery(photo_sql, new ColumnProcessor());
		if(pk_export_photo != null){
			return ;
		}
		Fbs_export_photoVO exp = new Fbs_export_photoVO();
		exp.setTime(thistime);
		exp.setPk_psnbasdoc(pk_psnbasdoc);
		ifdfService.insertVOIF(exp);
	}
	
	/**
	 * @Title: updatePsnPhoto
	 * @Description: 保存记录后直接在数据库把照片更新到记录中
	 * @Author: 王凯强
	 * @Time: 2016年10月26日 下午4:08:41
	 * @param photo
	 * @param pk_psnbasdoc
	 * @throws BusinessException
	 */
	private void updatePsnPhoto(String thistime, byte photo[], String pk_psnbasdoc) throws BusinessException{
		String[] sqls = new String[]{
				"update fbs_export_photo set time = '"+ thistime +"', photo = (select photo from bd_psnbasdoc where pk_psnbasdoc = '"
						+ pk_psnbasdoc +"') where pk_psnbasdoc = '"
						+ pk_psnbasdoc +"'"
				};
		ifdfService.executeSQLS(sqls);
	}
}

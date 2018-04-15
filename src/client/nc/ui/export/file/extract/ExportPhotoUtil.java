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
 * <b> ������Ƭ������ </b>
 * <p>
 *     ���û�ѡ����ļ����´����Ե�ǰʱ���������ļ��У�
 *     ����洢����"��Ա������Ϣ����_����.jpg"��ʽ����Ƭ
 *     (pk_psnbasdoc_psnname.jpg)
 * </p>
 * ��������: 2016��10��26�� ����10:57:01
 * @Author ����ǿ
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
	 * @Description: ����
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����10:21:20
	 * @param fileSavePath
	 * @param thistime
	 * @throws Exception 
	 */
	final void doExport(String fileSavePath, String thistime) throws Exception {
		String filePath = null;
		String lastTime = null;
		try {
			//�ϴγ�ȡʱ��
			String sql_last = "select max(time) from fbs_export_photo ";
			lastTime = spike.getMaxTime(sql_last);
			
			List<Bd_psnbasdocVO> psn_list = spike.getPhotoSpikeData(lastTime);
			
			if(psn_list.size() == 0){
				throw new BusinessException("û����Ҫ������Ƭ����Ա��");
			}
			
			String _filename = FileUtil.getFolderNameByTime();
			//��Ƭ·��
			filePath = fileSavePath + Constants.SEP + _filename;
			
			// ������Ƭ�ļ���(�ļ��в�����ʱ����)
			FileUtil.createFolder(filePath);
			ProcessLine.setMaximum(psn_list.size()+1);
			for(int i = 0; i < psn_list.size(); i++){
				//����������
				ProcessLine.addDefaultProcess("���ڳ�ȡ��"+ (i+1) +"����Ա����Ƭ......");
				String pk_psnbasdoc = changPk(psn_list.get(i));
				String fileName = filePath + Constants.SEP + pk_psnbasdoc + "_" + psn_list.get(i).getPsnname() + Constants.PHOTO_EXTNAME;
				saveToFile(psn_list.get(i), fileName, thistime);
			}
			
			//���������־
			saveLog(lastTime, UFBoolean.TRUE);
			
			//����������
			ProcessLine.addValueProcess(psn_list.size(), "����ѹ���ļ�......");
			
			// ����ѹ���ļ�����·��
			File zipPath = FileUtil.createFolder(fileSavePath);
			String zipFileName = _filename + Constants.PHOTO_ZIP_EXTNAME;
			String zipFileFullPath = zipPath.getAbsolutePath() + Constants.SEP + zipFileName;
			AntZipUtil.zipFile(zipFileFullPath, filePath);

//			//�����ļ��к�ɾ���ļ���
//			FileUtil.deleteFolder(filePath);
		} catch (Exception e) {
			//���������־
			saveLog(lastTime, UFBoolean.FALSE);
			e.printStackTrace();
			throw(e);
		} finally {
			//�����ļ��к�ɾ���ļ���
			FileUtil.deleteFolder(filePath);
		}
	}
	
	private Map<String, String> mapCorp = null;
	/**
	 * @Title: changPk
	 * @Description: ת�����������������ݳ�ȡת����������
	 * @Time: 2016��10��26�� ����5:1:11
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
			throw new BusinessException("��Ա������Ϣ������ʽ����ȷ������ϵҵ����Ա����");
		}
 		//ת������
 		String pk_New = checkData.getNewPk(pk_psnbasdoc, mapCorp, psnbasdocvo);
 		return pk_New;
	}
	
	/**
	 * @Title: saveToFile
	 * @Description: �����ļ�
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����10:21:29
	 * @param psnVO
	 * @param filepath
	 * @param thistime
	 * @throws IOException
	 * @throws BusinessException
	 */
	private void saveToFile(Bd_psnbasdocVO psnVO, String filepath, String thistime) throws IOException, BusinessException {
        byte photo[] = psnVO.getNewphoto();//�����newphoto��Ӧ�����ݿ��photo
        
        if (photo == null) {
            return;
        }
        
        FileUtils.writeByteArrayToFile(new File(filepath), photo);
        
        String pk_psnbasdoc = psnVO.getPk_psnbasdoc();
        //���浼����¼
        saveOptTime(pk_psnbasdoc,thistime);
        //�����¼��ֱ�������ݿ����Ƭ���µ���¼��
        updatePsnPhoto(thistime, photo, pk_psnbasdoc);
    }
	
	/**
	 * @Title: saveLog
	 * @Description: ���������¼
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����2:49:46
	 * @param lastTime
	 * @throws BusinessException
	 */
	private void saveLog(String lastTime, UFBoolean flag) throws BusinessException{
		FbsDatafileVO dataFileVO = new FbsDatafileVO();
		dataFileVO.setOperator(WorkbenchEnvironment.getInstance().getLoginUser().getCuserid());// Ĭ�ϵ�ǰ��½��
		dataFileVO.setPk_corp(Global.getPkGroup());// Ĭ�ϵ�ǰ��½��˾
		dataFileVO.setOperate_time(new UFDateTime(new Date()));// ����ʱ��
		dataFileVO.setIssuccess(flag);
		dataFileVO.setIsall(lastTime==null?UFBoolean.TRUE:UFBoolean.FALSE);
		dataFileVO.setIsspike(lastTime!=null?UFBoolean.TRUE:UFBoolean.FALSE);
		
		dataFileVO.setStart_date(lastTime!=null?new UFDateTime(lastTime):null);
		
		dataFileVO.setVbillstatus(Integer.valueOf(8));// ��ȡ���ݽ���ʱ��
		
		dataFileVO.setVmemo(Constants.OPT_TYPE_PHOTO);
		
		ifdfService.saveLogVO(dataFileVO,new FbsDataFileItemVO[]{},new FbsExportTimeVO[]{});
	}
	
	
	/**
	 * @Title: saveOptTime
	 * @Description: ���浼����¼
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����4:08:51
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
	 * @Description: �����¼��ֱ�������ݿ����Ƭ���µ���¼��
	 * @Author: ����ǿ
	 * @Time: 2016��10��26�� ����4:08:41
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

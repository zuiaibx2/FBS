package nc.pub.fbs.btn;

import nc.ui.trade.base.IBillOperate;
import nc.vo.trade.button.ButtonVO;

public class FbsButtonVO {

	/**
	 * @param id
	 * @param code
	 * @param name
	 * @return
	 */
	public static ButtonVO createButtonVO(int id, String code, String name) {
		nc.vo.trade.button.ButtonVO btn = new nc.vo.trade.button.ButtonVO();
		btn.setBtnNo(id);// ��ťid
		btn.setBtnName(name);// ��ť������
		btn.setHintStr(name);// ��ͣ������
		btn.setBtnCode(code);// ����code
		btn.setBtnChinaName(name);// ���ĵ�����
		return btn;
	}
	/**
	 * ����Excel����
	 * 
	 * @return btnVO
	 */
	public ButtonVO getExcelExpVO() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.excel_dc);
		btnVO.setBtnCode(FbsButton.EXCEL_DC_CODE);
		btnVO.setBtnName(FbsButton.EXCEL_DC_NAME);
		btnVO.setOperateStatus(new int[] { IBillOperate.OP_INIT,
				IBillOperate.OP_ALL });
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		return btnVO;
	}
	
	/**
	 * �ϴ��ֲ�ʽ��������
	 * 
	 * @return btnVO
	 */
	public ButtonVO getDataFileVo() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.DATAFILE_NO);
		btnVO.setBtnCode(FbsButton.DATAFILE_CODE);
		btnVO.setBtnName(FbsButton.DATAFILE_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		return btnVO;
	}
	
	/**
	 * �ϴ��ֲ�ʽȫ������
	 * 
	 * @return btnVO
	 */
	public ButtonVO getALLDataFileVo() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.ALLDATAFILE_NO);
		btnVO.setBtnCode(FbsButton.ALLDATAFILE_CODE);
		btnVO.setBtnName(FbsButton.ALLDATAFILE_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		
		return btnVO;
	}
	
	/**
	 * �ϴ��ֲ�ʽ��������
	 * 
	 * @return btnVO
	 */
	public ButtonVO getSendDataBtn() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.SENDDATA_NO);
		btnVO.setBtnCode(FbsButton.SENDDATA_CODE);
		btnVO.setBtnName(FbsButton.SENDDATA_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		return btnVO;
	}
	
	/**
	 * ���粻ͨ��ȡ��Ƭ
	 * 
	 * @return btnVO
	 */
	public ButtonVO getDataFilePhotoBtn() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.DATAFILE_PHOTO_NO);
		btnVO.setBtnCode(FbsButton.DATAFILE_PHOTO_CODE);
		btnVO.setBtnName(FbsButton.DATAFILE_PHOTO_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		return btnVO;
	}
	
	/**
	 * @Title: getDataFileInBtn
	 * @Description: ҵ������Ǩ�����ݵ���
	 * @return
	 */
	public ButtonVO getImportBtn() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.IMPORT_NO);
		btnVO.setBtnCode(FbsButton.IMPORT_CODE);
		btnVO.setBtnName(FbsButton.IMPORT_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		return btnVO;
	}
	
	/**
	 * @Title: getEXPORTVO
	 * @Description: ҵ������Ǩ�Ƶ�������
	 * @return
	 */
	public ButtonVO getEexporTVO() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.EXPORT_NO);
		btnVO.setBtnCode(FbsButton.EXPORT_CODE);
		btnVO.setBtnName(FbsButton.EXPORT_NAME);
		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });		
		return btnVO;
	}
	
	public ButtonVO getNetOKBtn() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.NETOK_NO);
		btnVO.setBtnCode(FbsButton.NETOK_CODE);
		btnVO.setBtnName(FbsButton.NETOK_NAME);
//		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
//		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		btnVO.setChildAry(new int[]{FbsButton.SENDDATA_NO, FbsButton.DATAFILE_PHOTO_NO});
		return btnVO;
	}
	public ButtonVO getNetErrBtn() {
		ButtonVO btnVO = new ButtonVO();
		btnVO.setBtnNo(FbsButton.NETERROR_NO);
		btnVO.setBtnCode(FbsButton.NETERROR_CODE);
		btnVO.setBtnName(FbsButton.NETERROR_NAME);
//		btnVO.setOperateStatus(new int[] {IBillOperate.OP_NOTEDIT,IBillOperate.OP_INIT,IBillOperate.OP_NOADD_NOTEDIT});
//		btnVO.setBusinessStatus(new int[] { nc.vo.trade.pub.IBillStatus.FREE });
		btnVO.setChildAry(new int[]{FbsButton.DATAFILE_NO,FbsButton.ALLDATAFILE_NO});
		return btnVO;
	}

}
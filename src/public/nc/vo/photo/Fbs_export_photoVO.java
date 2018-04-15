package nc.vo.photo; 

import nc.vo.pub.SuperVO;

/**
 * @ClassName: Fbs_export_photoVO
 * <b> ������Ƭ��¼�� </b>
 * <p>
 *     �ڴ˴���Ӵ����������Ϣ
 * </p>
 * ��������: 2016��10��26�� ����3:53:02
 * @Author ����ǿ
 * @Version 
 */
public class Fbs_export_photoVO extends SuperVO{

	private static final long serialVersionUID = -1807400793491085661L;

	/**
	 * @field: time
	 * @Discription: ����ʱ��
	 */
	private java.lang.String time;
	
	/**
	 * @field: pk_export_photo
	 * @Discription: ������
	 */
	private java.lang.String pk_export_photo;
	
	/**
	 * @field: pk_psnbasdoc
	 * @Discription: ��Ա����
	 */
	private java.lang.String pk_psnbasdoc;
	
	/**
	 * @field: photo
	 * @Discription: ��Ƭ
	 */
	private byte[] photo;
	
	/**
	 * @field: ts
	 * @Discription: ʱ���
	 */
	private java.lang.String ts;
	
	public java.lang.String getTime() {
		return time;
	}

	public void setTime(java.lang.String time) {
		this.time = time;
	}

	public java.lang.String getPk_export_photo() {
		return pk_export_photo;
	}

	public void setPk_export_photo(java.lang.String pk_export_photo) {
		this.pk_export_photo = pk_export_photo;
	}

	public java.lang.String getPk_psnbasdoc() {
		return pk_psnbasdoc;
	}

	public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
		this.pk_psnbasdoc = pk_psnbasdoc;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	@Override
	public String getPKFieldName() {
		return "pk_export_photo";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "fbs_export_photo";
	}

}

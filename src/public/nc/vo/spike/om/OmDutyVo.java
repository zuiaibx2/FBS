package nc.vo.spike.om;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: OmDutyVo
 * <b> ְ�������Ϣ�м��VO </b>
 * <p>
 *     �ڴ˴����Ӵ����������Ϣ
 * </p>
 * ��������: 2016��7��26�� ����4:45:14
 * @Author ����ǿ
 * @Version 
 */
public class OmDutyVo extends BasicVO {

	private static final long serialVersionUID = 5347916373029659229L;
	/**
	 *@field : pk_om_duty
	 *@Discription : ְ������
	 */
	private java.lang.String pk_om_duty;
	private java.lang.String pk_om_duty_old;
	
	/**
	 *@field : createcorp
	 *@Discription : ������˾
	 */
	private java.lang.String createcorp;
	
	/**
	 *@field : dr
	 *@Discription : ɾ����־
	 */
	private java.lang.Integer dr;
	
	/**
	 *@field : dutycode
	 *@Discription : ְ�����
	 */
	private java.lang.String dutycode;
	
	/**
	 *@field : dutyname
	 *@Discription : ְ������
	 */
	private java.lang.String dutyname;
	
	/**
	 *@field : dutyrank
	 *@Discription : ְ��ȼ�
	 */
	private java.lang.String dutyrank;
	
	/**
	 *@field : ������˾
	 *@Discription : 
	 */
	private java.lang.String pk_corp;
	
	/**
	 *@field : series
	 *@Discription : ְ�����
	 */
	private java.lang.String series;
	
	/**
	 *@field : ts
	 *@Discription : ʱ������������ʱ��
	 */
	private java.lang.String ts;
	
	/**
	 *@field : vdutysumm
	 *@Discription : ְ���Ҫ
	 */
	private java.lang.String vdutysumm;
	
	public java.lang.String getPk_om_duty_old() {
		return pk_om_duty_old;
	}

	public void setPk_om_duty_old(java.lang.String pk_om_duty_old) {
		this.pk_om_duty_old = pk_om_duty_old;
	}

	public java.lang.String getPk_om_duty() {
		return pk_om_duty;
	}

	public void setPk_om_duty(java.lang.String pk_om_duty) {
		this.pk_om_duty = pk_om_duty;
	}

	public java.lang.String getCreatecorp() {
		return createcorp;
	}

	public void setCreatecorp(java.lang.String createcorp) {
		this.createcorp = createcorp;
	}

	public java.lang.Integer getDr() {
		return dr;
	}

	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}

	public java.lang.String getDutycode() {
		return dutycode;
	}

	public void setDutycode(java.lang.String dutycode) {
		this.dutycode = dutycode;
	}

	public java.lang.String getDutyname() {
		return dutyname;
	}

	public void setDutyname(java.lang.String dutyname) {
		this.dutyname = dutyname;
	}

	public java.lang.String getDutyrank() {
		return dutyrank;
	}

	public void setDutyrank(java.lang.String dutyrank) {
		this.dutyrank = dutyrank;
	}

	public java.lang.String getPk_corp() {
		return pk_corp;
	}

	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}

	public java.lang.String getSeries() {
		return series;
	}

	public void setSeries(java.lang.String series) {
		this.series = series;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	public java.lang.String getVdutysumm() {
		return vdutysumm;
	}

	public void setVdutysumm(java.lang.String vdutysumm) {
		this.vdutysumm = vdutysumm;
	}

	@Override
	public String getPKFieldName() {
		return "pk_om_duty";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "mid_om_duty";
	}
	
}
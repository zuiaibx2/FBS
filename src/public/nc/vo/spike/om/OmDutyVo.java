package nc.vo.spike.om;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: OmDutyVo
 * <b> 职务基本信息中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月26日 下午4:45:14
 * @Author 王凯强
 * @Version 
 */
public class OmDutyVo extends BasicVO {

	private static final long serialVersionUID = 5347916373029659229L;
	/**
	 *@field : pk_om_duty
	 *@Discription : 职务主键
	 */
	private java.lang.String pk_om_duty;
	private java.lang.String pk_om_duty_old;
	
	/**
	 *@field : createcorp
	 *@Discription : 建立公司
	 */
	private java.lang.String createcorp;
	
	/**
	 *@field : dr
	 *@Discription : 删除标志
	 */
	private java.lang.Integer dr;
	
	/**
	 *@field : dutycode
	 *@Discription : 职务编码
	 */
	private java.lang.String dutycode;
	
	/**
	 *@field : dutyname
	 *@Discription : 职务名称
	 */
	private java.lang.String dutyname;
	
	/**
	 *@field : dutyrank
	 *@Discription : 职务等级
	 */
	private java.lang.String dutyrank;
	
	/**
	 *@field : 所属公司
	 *@Discription : 
	 */
	private java.lang.String pk_corp;
	
	/**
	 *@field : series
	 *@Discription : 职务类别
	 */
	private java.lang.String series;
	
	/**
	 *@field : ts
	 *@Discription : 时间戳，最近操作时间
	 */
	private java.lang.String ts;
	
	/**
	 *@field : vdutysumm
	 *@Discription : 职务概要
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

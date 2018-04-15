package nc.vo.spike.hrldm;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: Hrldm_train_planVO
 * <b> 后备干部信息子集中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月29日下午1:44:01
 * @Author 王凯强
 * @Version 
 */
public class Hrldm_train_planVO extends BasicVO {

	private static final long serialVersionUID = -952278337665216556L;
	private java.lang.String begindate;
	private java.lang.Integer dr;
	private java.lang.String enddate;
	private java.lang.String groupdef1;
	private java.lang.String groupdef10;
	private java.lang.String groupdef2;
	private java.lang.String groupdef3;
	private java.lang.String groupdef4;
	private java.lang.String groupdef5;
	private java.lang.String groupdef6;
	private java.lang.String groupdef7;
	private java.lang.String groupdef8;
	private java.lang.String groupdef9;
	private java.lang.String lastflag;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.String pk_psndoc_sub_old;
	private java.lang.Long recordnum;
	private java.lang.String train_object;
	private java.lang.String train_plan;
	private java.lang.String train_production;
	private java.lang.String train_step;
	private java.lang.String train_target;
	private java.lang.String ts;
	/**
	 * @field: pk_corp
	 * @Discription: 公司编码
	 */
	private java.lang.String pk_corp;
	
	/**
	 * @field: psncode
	 * @Discription: 员工编码
	 */
	private java.lang.String psncode;
	
	/**
	 * @field: pk_psncl
	 * @Discription: 人员类别
	 */
	private java.lang.String pk_psncl;
	
	public java.lang.String getPk_corp() {
		return pk_corp;
	}

	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}

	public java.lang.String getPsncode() {
		return psncode;
	}

	public void setPsncode(java.lang.String psncode) {
		this.psncode = psncode;
	}

	public java.lang.String getPk_psncl() {
		return pk_psncl;
	}

	public void setPk_psncl(java.lang.String pk_psncl) {
		this.pk_psncl = pk_psncl;
	}

	public java.lang.String getPk_psndoc_sub_old() {
		return pk_psndoc_sub_old;
	}

	public void setPk_psndoc_sub_old(java.lang.String pk_psndoc_sub_old) {
		this.pk_psndoc_sub_old = pk_psndoc_sub_old;
	}

	public java.lang.String getBegindate() {
		return begindate;
	}

	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}

	public java.lang.Integer getDr() {
		return dr;
	}

	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}

	public java.lang.String getEnddate() {
		return enddate;
	}

	public void setEnddate(java.lang.String enddate) {
		this.enddate = enddate;
	}

	public java.lang.String getGroupdef1() {
		return groupdef1;
	}

	public void setGroupdef1(java.lang.String groupdef1) {
		this.groupdef1 = groupdef1;
	}

	public java.lang.String getGroupdef10() {
		return groupdef10;
	}

	public void setGroupdef10(java.lang.String groupdef10) {
		this.groupdef10 = groupdef10;
	}

	public java.lang.String getGroupdef2() {
		return groupdef2;
	}

	public void setGroupdef2(java.lang.String groupdef2) {
		this.groupdef2 = groupdef2;
	}

	public java.lang.String getGroupdef3() {
		return groupdef3;
	}

	public void setGroupdef3(java.lang.String groupdef3) {
		this.groupdef3 = groupdef3;
	}

	public java.lang.String getGroupdef4() {
		return groupdef4;
	}

	public void setGroupdef4(java.lang.String groupdef4) {
		this.groupdef4 = groupdef4;
	}

	public java.lang.String getGroupdef5() {
		return groupdef5;
	}

	public void setGroupdef5(java.lang.String groupdef5) {
		this.groupdef5 = groupdef5;
	}

	public java.lang.String getGroupdef6() {
		return groupdef6;
	}

	public void setGroupdef6(java.lang.String groupdef6) {
		this.groupdef6 = groupdef6;
	}

	public java.lang.String getGroupdef7() {
		return groupdef7;
	}

	public void setGroupdef7(java.lang.String groupdef7) {
		this.groupdef7 = groupdef7;
	}

	public java.lang.String getGroupdef8() {
		return groupdef8;
	}

	public void setGroupdef8(java.lang.String groupdef8) {
		this.groupdef8 = groupdef8;
	}

	public java.lang.String getGroupdef9() {
		return groupdef9;
	}

	public void setGroupdef9(java.lang.String groupdef9) {
		this.groupdef9 = groupdef9;
	}

	public java.lang.String getLastflag() {
		return lastflag;
	}

	public void setLastflag(java.lang.String lastflag) {
		this.lastflag = lastflag;
	}

	public java.lang.String getPk_psnbasdoc() {
		return pk_psnbasdoc;
	}

	public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
		this.pk_psnbasdoc = pk_psnbasdoc;
	}

	public java.lang.String getPk_psndoc() {
		return pk_psndoc;
	}

	public void setPk_psndoc(java.lang.String pk_psndoc) {
		this.pk_psndoc = pk_psndoc;
	}

	public java.lang.String getPk_psndoc_sub() {
		return pk_psndoc_sub;
	}

	public void setPk_psndoc_sub(java.lang.String pk_psndoc_sub) {
		this.pk_psndoc_sub = pk_psndoc_sub;
	}

	public java.lang.Long getRecordnum() {
		return recordnum;
	}

	public void setRecordnum(java.lang.Long recordnum) {
		this.recordnum = recordnum;
	}

	public java.lang.String getTrain_object() {
		return train_object;
	}

	public void setTrain_object(java.lang.String train_object) {
		this.train_object = train_object;
	}

	public java.lang.String getTrain_plan() {
		return train_plan;
	}

	public void setTrain_plan(java.lang.String train_plan) {
		this.train_plan = train_plan;
	}

	public java.lang.String getTrain_production() {
		return train_production;
	}

	public void setTrain_production(java.lang.String train_production) {
		this.train_production = train_production;
	}

	public java.lang.String getTrain_step() {
		return train_step;
	}

	public void setTrain_step(java.lang.String train_step) {
		this.train_step = train_step;
	}

	public java.lang.String getTrain_target() {
		return train_target;
	}

	public void setTrain_target(java.lang.String train_target) {
		this.train_target = train_target;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	@Override
	public String getPKFieldName() {
		return "pk_psndoc_sub";
	}

	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		return "mid_hrldm_train_plan";
	}
}

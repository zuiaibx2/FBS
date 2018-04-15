package nc.vo.spike.hrldm;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: Hrldm_psndoc_dutyVO
 * <b> 领导人员职务信息子集中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月29日 下午1:38:46
 * @Author 王凯强
 * @Version 
 */
public class Hrldm_psndoc_dutyVO extends BasicVO {

	private static final long serialVersionUID = -3354749273149741148L;
	private java.lang.String begindate;
	private java.lang.String deposedate;
	private java.lang.String deposenumber;
	private java.lang.String deposeunit;
	private java.lang.Integer dr;
	private java.lang.String enddate;
	private java.lang.String groupdef1;
	private java.lang.String groupdef10;
	private java.lang.String groupdef11;
	private java.lang.String groupdef12;
	private java.lang.String groupdef13;
	private java.lang.String groupdef14;
	private java.lang.String groupdef15;
	private java.lang.String groupdef16;
	private java.lang.String groupdef17;
	private java.lang.String groupdef18;
	private java.lang.String groupdef19;
	private java.lang.String groupdef2;
	private java.lang.String groupdef20;
	private java.lang.String groupdef3;
	private java.lang.String groupdef4;
	private java.lang.String groupdef5;
	private java.lang.String groupdef6;
	private java.lang.String groupdef7;
	private java.lang.String groupdef8;
	private java.lang.String groupdef9;
	private java.lang.String holddate;
	private java.lang.String holdjob;
	private java.lang.String holdnumber;
	private java.lang.String holdunit;
	private java.lang.Long holdyear;
	private java.lang.String lastflag;
	private java.lang.String memo;
	private java.lang.String pk_deposereason;
	private java.lang.String pk_deposetype;
	private java.lang.String pk_dutylevel;
	private java.lang.String pk_dutytype;
	private java.lang.String pk_hold_corp;
	private java.lang.String pk_hold_dept;
	private java.lang.String pk_holdreason;
	private java.lang.String pk_holdtype;
	private java.lang.String pk_om_duty;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc;
	private java.lang.String pk_psndoc_duty;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.String pk_psndoc_sub_old;
	private java.lang.Long recordnum;
	private java.lang.String ts;
	private java.lang.String mzhxzjb;
	private java.lang.String avicmzdef1;
	private java.lang.String avicmzdef2;
	private java.lang.String avicmzdef3;
	private java.lang.String avicmzdef4;
	private java.lang.String avicmzdef5;
	private java.lang.String nrxzjb;
	private java.lang.String avicrzdef1;
	private java.lang.String avicrzdef2;
	private java.lang.String avicrzdef3;
	private java.lang.String avicrzdef4;
	private java.lang.String avicrzdef5;
	private java.lang.String issy;
	private java.lang.String syenddate;
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

	public java.lang.String getDeposedate() {
		return deposedate;
	}

	public void setDeposedate(java.lang.String deposedate) {
		this.deposedate = deposedate;
	}

	public java.lang.String getDeposenumber() {
		return deposenumber;
	}

	public void setDeposenumber(java.lang.String deposenumber) {
		this.deposenumber = deposenumber;
	}

	public java.lang.String getDeposeunit() {
		return deposeunit;
	}

	public void setDeposeunit(java.lang.String deposeunit) {
		this.deposeunit = deposeunit;
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

	public java.lang.String getGroupdef11() {
		return groupdef11;
	}

	public void setGroupdef11(java.lang.String groupdef11) {
		this.groupdef11 = groupdef11;
	}

	public java.lang.String getGroupdef12() {
		return groupdef12;
	}

	public void setGroupdef12(java.lang.String groupdef12) {
		this.groupdef12 = groupdef12;
	}

	public java.lang.String getGroupdef13() {
		return groupdef13;
	}

	public void setGroupdef13(java.lang.String groupdef13) {
		this.groupdef13 = groupdef13;
	}

	public java.lang.String getGroupdef14() {
		return groupdef14;
	}

	public void setGroupdef14(java.lang.String groupdef14) {
		this.groupdef14 = groupdef14;
	}

	public java.lang.String getGroupdef15() {
		return groupdef15;
	}

	public void setGroupdef15(java.lang.String groupdef15) {
		this.groupdef15 = groupdef15;
	}

	public java.lang.String getGroupdef16() {
		return groupdef16;
	}

	public void setGroupdef16(java.lang.String groupdef16) {
		this.groupdef16 = groupdef16;
	}

	public java.lang.String getGroupdef17() {
		return groupdef17;
	}

	public void setGroupdef17(java.lang.String groupdef17) {
		this.groupdef17 = groupdef17;
	}

	public java.lang.String getGroupdef18() {
		return groupdef18;
	}

	public void setGroupdef18(java.lang.String groupdef18) {
		this.groupdef18 = groupdef18;
	}

	public java.lang.String getGroupdef19() {
		return groupdef19;
	}

	public void setGroupdef19(java.lang.String groupdef19) {
		this.groupdef19 = groupdef19;
	}

	public java.lang.String getGroupdef2() {
		return groupdef2;
	}

	public void setGroupdef2(java.lang.String groupdef2) {
		this.groupdef2 = groupdef2;
	}

	public java.lang.String getGroupdef20() {
		return groupdef20;
	}

	public void setGroupdef20(java.lang.String groupdef20) {
		this.groupdef20 = groupdef20;
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

	public java.lang.String getHolddate() {
		return holddate;
	}

	public void setHolddate(java.lang.String holddate) {
		this.holddate = holddate;
	}

	public java.lang.String getHoldjob() {
		return holdjob;
	}

	public void setHoldjob(java.lang.String holdjob) {
		this.holdjob = holdjob;
	}

	public java.lang.String getHoldnumber() {
		return holdnumber;
	}

	public void setHoldnumber(java.lang.String holdnumber) {
		this.holdnumber = holdnumber;
	}

	public java.lang.String getHoldunit() {
		return holdunit;
	}

	public void setHoldunit(java.lang.String holdunit) {
		this.holdunit = holdunit;
	}

	public java.lang.Long getHoldyear() {
		return holdyear;
	}

	public void setHoldyear(java.lang.Long holdyear) {
		this.holdyear = holdyear;
	}

	public java.lang.String getLastflag() {
		return lastflag;
	}

	public void setLastflag(java.lang.String lastflag) {
		this.lastflag = lastflag;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getPk_corp() {
		return pk_corp;
	}

	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}

	public java.lang.String getPk_deposereason() {
		return pk_deposereason;
	}

	public void setPk_deposereason(java.lang.String pk_deposereason) {
		this.pk_deposereason = pk_deposereason;
	}

	public java.lang.String getPk_deposetype() {
		return pk_deposetype;
	}

	public void setPk_deposetype(java.lang.String pk_deposetype) {
		this.pk_deposetype = pk_deposetype;
	}

	public java.lang.String getPk_dutylevel() {
		return pk_dutylevel;
	}

	public void setPk_dutylevel(java.lang.String pk_dutylevel) {
		this.pk_dutylevel = pk_dutylevel;
	}

	public java.lang.String getPk_dutytype() {
		return pk_dutytype;
	}

	public void setPk_dutytype(java.lang.String pk_dutytype) {
		this.pk_dutytype = pk_dutytype;
	}

	public java.lang.String getPk_hold_corp() {
		return pk_hold_corp;
	}

	public void setPk_hold_corp(java.lang.String pk_hold_corp) {
		this.pk_hold_corp = pk_hold_corp;
	}

	public java.lang.String getPk_hold_dept() {
		return pk_hold_dept;
	}

	public void setPk_hold_dept(java.lang.String pk_hold_dept) {
		this.pk_hold_dept = pk_hold_dept;
	}

	public java.lang.String getPk_holdreason() {
		return pk_holdreason;
	}

	public void setPk_holdreason(java.lang.String pk_holdreason) {
		this.pk_holdreason = pk_holdreason;
	}

	public java.lang.String getPk_holdtype() {
		return pk_holdtype;
	}

	public void setPk_holdtype(java.lang.String pk_holdtype) {
		this.pk_holdtype = pk_holdtype;
	}

	public java.lang.String getPk_om_duty() {
		return pk_om_duty;
	}

	public void setPk_om_duty(java.lang.String pk_om_duty) {
		this.pk_om_duty = pk_om_duty;
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

	public java.lang.String getPk_psndoc_duty() {
		return pk_psndoc_duty;
	}

	public void setPk_psndoc_duty(java.lang.String pk_psndoc_duty) {
		this.pk_psndoc_duty = pk_psndoc_duty;
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

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	public java.lang.String getMzhxzjb() {
		return mzhxzjb;
	}

	public void setMzhxzjb(java.lang.String mzhxzjb) {
		this.mzhxzjb = mzhxzjb;
	}

	public java.lang.String getAvicmzdef1() {
		return avicmzdef1;
	}

	public void setAvicmzdef1(java.lang.String avicmzdef1) {
		this.avicmzdef1 = avicmzdef1;
	}

	public java.lang.String getAvicmzdef2() {
		return avicmzdef2;
	}

	public void setAvicmzdef2(java.lang.String avicmzdef2) {
		this.avicmzdef2 = avicmzdef2;
	}

	public java.lang.String getAvicmzdef3() {
		return avicmzdef3;
	}

	public void setAvicmzdef3(java.lang.String avicmzdef3) {
		this.avicmzdef3 = avicmzdef3;
	}

	public java.lang.String getAvicmzdef4() {
		return avicmzdef4;
	}

	public void setAvicmzdef4(java.lang.String avicmzdef4) {
		this.avicmzdef4 = avicmzdef4;
	}

	public java.lang.String getAvicmzdef5() {
		return avicmzdef5;
	}

	public void setAvicmzdef5(java.lang.String avicmzdef5) {
		this.avicmzdef5 = avicmzdef5;
	}

	public java.lang.String getNrxzjb() {
		return nrxzjb;
	}

	public void setNrxzjb(java.lang.String nrxzjb) {
		this.nrxzjb = nrxzjb;
	}

	public java.lang.String getAvicrzdef1() {
		return avicrzdef1;
	}

	public void setAvicrzdef1(java.lang.String avicrzdef1) {
		this.avicrzdef1 = avicrzdef1;
	}

	public java.lang.String getAvicrzdef2() {
		return avicrzdef2;
	}

	public void setAvicrzdef2(java.lang.String avicrzdef2) {
		this.avicrzdef2 = avicrzdef2;
	}

	public java.lang.String getAvicrzdef3() {
		return avicrzdef3;
	}

	public void setAvicrzdef3(java.lang.String avicrzdef3) {
		this.avicrzdef3 = avicrzdef3;
	}

	public java.lang.String getAvicrzdef4() {
		return avicrzdef4;
	}

	public void setAvicrzdef4(java.lang.String avicrzdef4) {
		this.avicrzdef4 = avicrzdef4;
	}

	public java.lang.String getAvicrzdef5() {
		return avicrzdef5;
	}

	public void setAvicrzdef5(java.lang.String avicrzdef5) {
		this.avicrzdef5 = avicrzdef5;
	}

	public java.lang.String getIssy() {
		return issy;
	}

	public void setIssy(java.lang.String issy) {
		this.issy = issy;
	}

	public java.lang.String getSyenddate() {
		return syenddate;
	}

	public void setSyenddate(java.lang.String syenddate) {
		this.syenddate = syenddate;
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
		return "mid_hrldm_psndoc_duty";
	}
}

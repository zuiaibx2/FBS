package nc.vo.bs.hrldm;

import nc.vo.pub.SuperVO;


/**
 * @ClassName: Hrldm_ldpsn_infoVO
 * @Description:  干部信息主集-干部分类信息
 * @项目名称: fbsjt
 * @文件名称: Hrldm_ldpsn_infoVO.java
 * @Author: 王凯强
 * @Date: 2016年7月29日下午1:30:30
 */
public class Hrldm_ldpsn_infoVO extends SuperVO{

	private static final long serialVersionUID = -5264742871680496552L;
	
	private java.lang.String begindate;
//	private java.lang.Integer dr;
	private java.lang.String enddate;
//	private java.lang.String groupdef1;
//	private java.lang.String groupdef10;
//	private java.lang.String groupdef11;
//	private java.lang.String groupdef12;
//	private java.lang.String groupdef13;
//	private java.lang.String groupdef14;
//	private java.lang.String groupdef15;
//	private java.lang.String groupdef16;
//	private java.lang.String groupdef17;
//	private java.lang.String groupdef18;
//	private java.lang.String groupdef19;
//	private java.lang.String groupdef2;
//	private java.lang.String groupdef20;
//	private java.lang.String groupdef3;
//	private java.lang.String groupdef4;
//	private java.lang.String groupdef5;
//	private java.lang.String groupdef6;
//	private java.lang.String groupdef7;
//	private java.lang.String groupdef8;
//	private java.lang.String groupdef9;
	private java.lang.String lastflag;
	private java.lang.Long ld_type;
	private java.lang.String memo;
	private java.lang.String pk_corp;
	private java.lang.String pk_defdoc;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.Long recordnum;
	private java.lang.Long showorder;
	private java.lang.String ts;

	public java.lang.String getBegindate() {
		return begindate;
	}

	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}

//	public java.lang.Integer getDr() {
//		return dr;
//	}
//
//	public void setDr(java.lang.Integer dr) {
//		this.dr = dr;
//	}

	public java.lang.String getEnddate() {
		return enddate;
	}

	public void setEnddate(java.lang.String enddate) {
		this.enddate = enddate;
	}

//	public java.lang.String getGroupdef1() {
//		return groupdef1;
//	}
//
//	public void setGroupdef1(java.lang.String groupdef1) {
//		this.groupdef1 = groupdef1;
//	}
//
//	public java.lang.String getGroupdef10() {
//		return groupdef10;
//	}
//
//	public void setGroupdef10(java.lang.String groupdef10) {
//		this.groupdef10 = groupdef10;
//	}
//
//	public java.lang.String getGroupdef11() {
//		return groupdef11;
//	}
//
//	public void setGroupdef11(java.lang.String groupdef11) {
//		this.groupdef11 = groupdef11;
//	}
//
//	public java.lang.String getGroupdef12() {
//		return groupdef12;
//	}
//
//	public void setGroupdef12(java.lang.String groupdef12) {
//		this.groupdef12 = groupdef12;
//	}
//
//	public java.lang.String getGroupdef13() {
//		return groupdef13;
//	}
//
//	public void setGroupdef13(java.lang.String groupdef13) {
//		this.groupdef13 = groupdef13;
//	}
//
//	public java.lang.String getGroupdef14() {
//		return groupdef14;
//	}
//
//	public void setGroupdef14(java.lang.String groupdef14) {
//		this.groupdef14 = groupdef14;
//	}
//
//	public java.lang.String getGroupdef15() {
//		return groupdef15;
//	}
//
//	public void setGroupdef15(java.lang.String groupdef15) {
//		this.groupdef15 = groupdef15;
//	}
//
//	public java.lang.String getGroupdef16() {
//		return groupdef16;
//	}
//
//	public void setGroupdef16(java.lang.String groupdef16) {
//		this.groupdef16 = groupdef16;
//	}
//
//	public java.lang.String getGroupdef17() {
//		return groupdef17;
//	}
//
//	public void setGroupdef17(java.lang.String groupdef17) {
//		this.groupdef17 = groupdef17;
//	}
//
//	public java.lang.String getGroupdef18() {
//		return groupdef18;
//	}
//
//	public void setGroupdef18(java.lang.String groupdef18) {
//		this.groupdef18 = groupdef18;
//	}
//
//	public java.lang.String getGroupdef19() {
//		return groupdef19;
//	}
//
//	public void setGroupdef19(java.lang.String groupdef19) {
//		this.groupdef19 = groupdef19;
//	}
//
//	public java.lang.String getGroupdef2() {
//		return groupdef2;
//	}
//
//	public void setGroupdef2(java.lang.String groupdef2) {
//		this.groupdef2 = groupdef2;
//	}
//
//	public java.lang.String getGroupdef20() {
//		return groupdef20;
//	}
//
//	public void setGroupdef20(java.lang.String groupdef20) {
//		this.groupdef20 = groupdef20;
//	}
//
//	public java.lang.String getGroupdef3() {
//		return groupdef3;
//	}
//
//	public void setGroupdef3(java.lang.String groupdef3) {
//		this.groupdef3 = groupdef3;
//	}
//
//	public java.lang.String getGroupdef4() {
//		return groupdef4;
//	}
//
//	public void setGroupdef4(java.lang.String groupdef4) {
//		this.groupdef4 = groupdef4;
//	}
//
//	public java.lang.String getGroupdef5() {
//		return groupdef5;
//	}
//
//	public void setGroupdef5(java.lang.String groupdef5) {
//		this.groupdef5 = groupdef5;
//	}
//
//	public java.lang.String getGroupdef6() {
//		return groupdef6;
//	}
//
//	public void setGroupdef6(java.lang.String groupdef6) {
//		this.groupdef6 = groupdef6;
//	}
//
//	public java.lang.String getGroupdef7() {
//		return groupdef7;
//	}
//
//	public void setGroupdef7(java.lang.String groupdef7) {
//		this.groupdef7 = groupdef7;
//	}
//
//	public java.lang.String getGroupdef8() {
//		return groupdef8;
//	}
//
//	public void setGroupdef8(java.lang.String groupdef8) {
//		this.groupdef8 = groupdef8;
//	}
//
//	public java.lang.String getGroupdef9() {
//		return groupdef9;
//	}
//
//	public void setGroupdef9(java.lang.String groupdef9) {
//		this.groupdef9 = groupdef9;
//	}

	public java.lang.String getLastflag() {
		return lastflag;
	}

	public void setLastflag(java.lang.String lastflag) {
		this.lastflag = lastflag;
	}

	public java.lang.Long getLd_type() {
		return ld_type;
	}

	public void setLd_type(java.lang.Long ld_type) {
		this.ld_type = ld_type;
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

	public java.lang.String getPk_defdoc() {
		return pk_defdoc;
	}

	public void setPk_defdoc(java.lang.String pk_defdoc) {
		this.pk_defdoc = pk_defdoc;
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

	public java.lang.Long getShoworder() {
		return showorder;
	}

	public void setShoworder(java.lang.Long showorder) {
		this.showorder = showorder;
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
		return "hrldm_ldpsn_info";
	}

}

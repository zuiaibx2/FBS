package nc.vo.bs.hi;

import nc.vo.pub.SuperVO;

/**
 * @ClassName: Hi_psndoc_grpdef11VO
 * @Description:  知识产权信息
 * @项目名称: fbsjt
 * @文件名称: Hi_psndoc_grpdef11VO.java
 * @Author: 王凯强
 * @Date: 2016年7月29日下午1:15:43
 */
public class Hi_psndoc_grpdef11VO extends SuperVO{

	private static final long serialVersionUID = 4899899880903589098L;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.String pk_psndoc;
	private java.lang.String pk_psnbasdoc;
	private java.lang.Long recordnum;
	private java.lang.String lastflag;
	private java.lang.String begindate;
	private java.lang.String enddate;
	private java.lang.String period;
	private java.lang.String hroperator;
	private java.lang.String groupdef1;
	private java.lang.String groupdef2;
//	private java.lang.String groupdef3;
//	private java.lang.String groupdef4;
//	private java.lang.String groupdef5;
//	private java.lang.String groupdef6;
//	private java.lang.String groupdef7;
//	private java.lang.String groupdef8;
//	private java.lang.String groupdef9;
//	private java.lang.String groupdef10;
//	private java.lang.Integer approveflag;
	private java.lang.String ts;
//	private java.lang.Integer dr;
	
	public java.lang.String getPk_psndoc_sub() {
		return pk_psndoc_sub;
	}

	public void setPk_psndoc_sub(java.lang.String pk_psndoc_sub) {
		this.pk_psndoc_sub = pk_psndoc_sub;
	}

	public java.lang.String getPk_psndoc() {
		return pk_psndoc;
	}

	public void setPk_psndoc(java.lang.String pk_psndoc) {
		this.pk_psndoc = pk_psndoc;
	}

	public java.lang.String getPk_psnbasdoc() {
		return pk_psnbasdoc;
	}

	public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
		this.pk_psnbasdoc = pk_psnbasdoc;
	}

	public java.lang.Long getRecordnum() {
		return recordnum;
	}

	public void setRecordnum(java.lang.Long recordnum) {
		this.recordnum = recordnum;
	}

	public java.lang.String getLastflag() {
		return lastflag;
	}

	public void setLastflag(java.lang.String lastflag) {
		this.lastflag = lastflag;
	}

	public java.lang.String getBegindate() {
		return begindate;
	}

	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}

	public java.lang.String getEnddate() {
		return enddate;
	}

	public void setEnddate(java.lang.String enddate) {
		this.enddate = enddate;
	}

	public java.lang.String getPeriod() {
		return period;
	}

	public void setPeriod(java.lang.String period) {
		this.period = period;
	}

	public java.lang.String getHroperator() {
		return hroperator;
	}

	public void setHroperator(java.lang.String hroperator) {
		this.hroperator = hroperator;
	}

	public java.lang.String getGroupdef1() {
		return groupdef1;
	}

	public void setGroupdef1(java.lang.String groupdef1) {
		this.groupdef1 = groupdef1;
	}

	public java.lang.String getGroupdef2() {
		return groupdef2;
	}

	public void setGroupdef2(java.lang.String groupdef2) {
		this.groupdef2 = groupdef2;
	}

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
//
//	public java.lang.String getGroupdef10() {
//		return groupdef10;
//	}
//
//	public void setGroupdef10(java.lang.String groupdef10) {
//		this.groupdef10 = groupdef10;
//	}
//
//	public java.lang.Integer getApproveflag() {
//		return approveflag;
//	}
//
//	public void setApproveflag(java.lang.Integer approveflag) {
//		this.approveflag = approveflag;
//	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

//	public java.lang.Integer getDr() {
//		return dr;
//	}
//
//	public void setDr(java.lang.Integer dr) {
//		this.dr = dr;
//	}

	@Override
	public String getPKFieldName() {
		return "pk_psndoc_sub";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "hi_psndoc_grpdef11";
	}

}

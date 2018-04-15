package nc.vo.spike.hi;

import nc.vo.pub.lang.UFDouble;
import nc.vo.spike.BasicVO;

/**
 * @ClassName: Hi_psndoc_eduVO
 * <b> 学历学位信息中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月28日下午2:19:03
 * @Author 王凯强
 * @Version 
 */
public class Hi_psndoc_eduVO extends BasicVO{
	private static final long serialVersionUID = -6801753848833015187L;
	
	private java.lang.Long approveflag;
	private java.lang.String begindate;
	private java.lang.String corpdef1;
	private java.lang.String corpdef10;
	private java.lang.String corpdef2;
	private java.lang.String corpdef3;
	private java.lang.String corpdef4;
	private java.lang.String corpdef5;
	private java.lang.String corpdef6;
	private java.lang.String corpdef7;
	private java.lang.String corpdef8;
	private java.lang.String corpdef9;
	private java.lang.String ddegreedate;
	private java.lang.String degree;
	private java.lang.Integer dr;
	private java.lang.String education;
	private java.lang.String educationctifcode;
	private UFDouble edusystem;
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
	private java.lang.String hroperator;
	private java.lang.String lasteducation;
	private java.lang.String lastflag;
	private java.lang.String major;
	private java.lang.String majortype;
	private java.lang.String memo;
	private java.lang.String period;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.String pk_psndoc_sub_old;
	private java.lang.Long recordnum;
	private java.lang.String school;
	private java.lang.String ts;
	private java.lang.String vcertifcode;
	private java.lang.String vdegreeunit;
	private java.lang.String vschooltype;
	private java.lang.String vstudymode;
	private java.lang.String groupdef11;
	private java.lang.String groupdef12;
	private java.lang.String groupdef13;
	private java.lang.String groupdef14;
	private java.lang.String groupdef15;
	
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
	
	public java.lang.String getPk_psndoc_sub_old() {
		return pk_psndoc_sub_old;
	}
	public void setPk_psndoc_sub_old(java.lang.String pk_psndoc_sub_old) {
		this.pk_psndoc_sub_old = pk_psndoc_sub_old;
	}
	public java.lang.Long getApproveflag() {
		return approveflag;
	}
	public void setApproveflag(java.lang.Long approveflag) {
		this.approveflag = approveflag;
	}
	public java.lang.String getBegindate() {
		return begindate;
	}
	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}
	public java.lang.String getCorpdef1() {
		return corpdef1;
	}
	public void setCorpdef1(java.lang.String corpdef1) {
		this.corpdef1 = corpdef1;
	}
	public java.lang.String getCorpdef10() {
		return corpdef10;
	}
	public void setCorpdef10(java.lang.String corpdef10) {
		this.corpdef10 = corpdef10;
	}
	public java.lang.String getCorpdef2() {
		return corpdef2;
	}
	public void setCorpdef2(java.lang.String corpdef2) {
		this.corpdef2 = corpdef2;
	}
	public java.lang.String getCorpdef3() {
		return corpdef3;
	}
	public void setCorpdef3(java.lang.String corpdef3) {
		this.corpdef3 = corpdef3;
	}
	public java.lang.String getCorpdef4() {
		return corpdef4;
	}
	public void setCorpdef4(java.lang.String corpdef4) {
		this.corpdef4 = corpdef4;
	}
	public java.lang.String getCorpdef5() {
		return corpdef5;
	}
	public void setCorpdef5(java.lang.String corpdef5) {
		this.corpdef5 = corpdef5;
	}
	public java.lang.String getCorpdef6() {
		return corpdef6;
	}
	public void setCorpdef6(java.lang.String corpdef6) {
		this.corpdef6 = corpdef6;
	}
	public java.lang.String getCorpdef7() {
		return corpdef7;
	}
	public void setCorpdef7(java.lang.String corpdef7) {
		this.corpdef7 = corpdef7;
	}
	public java.lang.String getCorpdef8() {
		return corpdef8;
	}
	public void setCorpdef8(java.lang.String corpdef8) {
		this.corpdef8 = corpdef8;
	}
	public java.lang.String getCorpdef9() {
		return corpdef9;
	}
	public void setCorpdef9(java.lang.String corpdef9) {
		this.corpdef9 = corpdef9;
	}
	public java.lang.String getDdegreedate() {
		return ddegreedate;
	}
	public void setDdegreedate(java.lang.String ddegreedate) {
		this.ddegreedate = ddegreedate;
	}
	public java.lang.String getDegree() {
		return degree;
	}
	public void setDegree(java.lang.String degree) {
		this.degree = degree;
	}
	public java.lang.Integer getDr() {
		return dr;
	}
	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}
	public java.lang.String getEducation() {
		return education;
	}
	public void setEducation(java.lang.String education) {
		this.education = education;
	}
	public java.lang.String getEducationctifcode() {
		return educationctifcode;
	}
	public void setEducationctifcode(java.lang.String educationctifcode) {
		this.educationctifcode = educationctifcode;
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
	public java.lang.String getHroperator() {
		return hroperator;
	}
	public void setHroperator(java.lang.String hroperator) {
		this.hroperator = hroperator;
	}
	public java.lang.String getLasteducation() {
		return lasteducation;
	}
	public void setLasteducation(java.lang.String lasteducation) {
		this.lasteducation = lasteducation;
	}
	public java.lang.String getLastflag() {
		return lastflag;
	}
	public void setLastflag(java.lang.String lastflag) {
		this.lastflag = lastflag;
	}
	public java.lang.String getMajor() {
		return major;
	}
	public void setMajor(java.lang.String major) {
		this.major = major;
	}
	public java.lang.String getMajortype() {
		return majortype;
	}
	public void setMajortype(java.lang.String majortype) {
		this.majortype = majortype;
	}
	public java.lang.String getMemo() {
		return memo;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	public java.lang.String getPeriod() {
		return period;
	}
	public void setPeriod(java.lang.String period) {
		this.period = period;
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
	public java.lang.String getSchool() {
		return school;
	}
	public void setSchool(java.lang.String school) {
		this.school = school;
	}
	public java.lang.String getTs() {
		return ts;
	}
	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}
	public java.lang.String getVcertifcode() {
		return vcertifcode;
	}
	public void setVcertifcode(java.lang.String vcertifcode) {
		this.vcertifcode = vcertifcode;
	}
	public java.lang.String getVdegreeunit() {
		return vdegreeunit;
	}
	public void setVdegreeunit(java.lang.String vdegreeunit) {
		this.vdegreeunit = vdegreeunit;
	}
	public java.lang.String getVschooltype() {
		return vschooltype;
	}
	public void setVschooltype(java.lang.String vschooltype) {
		this.vschooltype = vschooltype;
	}
	public java.lang.String getVstudymode() {
		return vstudymode;
	}
	public void setVstudymode(java.lang.String vstudymode) {
		this.vstudymode = vstudymode;
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
	public UFDouble getEdusystem() {
		return edusystem;
	}
	public void setEdusystem(UFDouble edusystem) {
		this.edusystem = edusystem;
	}
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
		return "mid_hi_psndoc_edu";
	}
}

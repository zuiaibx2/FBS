package nc.vo.spike.bd;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: Bd_psndocVO
 * <b> 员工工作信息中间表中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:2016年7月27日 下午6:33:21
 * @Author 王凯强
 * @Version 
 */
public class Bd_psndocVO extends BasicVO {

	private static final long serialVersionUID = 1866277183618041930L;
	
	private java.lang.String amcode;
	private java.lang.String clerkcode;
	private java.lang.String clerkflag;
	private java.lang.String createtime;
	private java.lang.String creator;
	private java.lang.String def1;
	private java.lang.String def10;
	private java.lang.String def11;
	private java.lang.String def12;
	private java.lang.String def13;
	private java.lang.String def14;
	private java.lang.String def15;
	private java.lang.String def16;
	private java.lang.String def17;
	private java.lang.String def18;
	private java.lang.String def19;
	private java.lang.String def2;
	private java.lang.String def20;
	private java.lang.String def3;
	private java.lang.String def4;
	private java.lang.String def5;
	private java.lang.String def6;
	private java.lang.String def7;
	private java.lang.String def8;
	private java.lang.String def9;
	private java.lang.Integer dr;
	private java.lang.String indocflag;
	private java.lang.String indutydate;
	private java.lang.String innercode;
	private java.lang.String jobrank;
	private java.lang.String jobseries;
	private java.lang.String maxinnercode;
	private java.lang.String modifier;
	private java.lang.String modifytime;
	private java.lang.String outdutydate;
	private java.lang.String pk_corp;
	private java.lang.String pk_deptdoc;
	private java.lang.String pk_om_job;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psncl;
	/**
	 * @field: pk_psndoc
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc;
	private java.lang.String pk_psndoc_old;
	private java.lang.Integer psnclscope;
	private java.lang.String psncode;
	private java.lang.String psnname;
	private java.lang.String sealdate;
	private java.lang.String ts;
	private java.lang.String directleader;
	private java.lang.String dutyname;
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
	private java.lang.String hroperator;
	private java.lang.String insource;
	private java.lang.String iscalovertime;
	private java.lang.String isreferenced;
	private java.lang.String isreturn;
	private java.lang.String onpostdate;
	private java.lang.String outmethod;
	private java.lang.String pk_clerkclass;
	private java.lang.String pk_dutyrank;
	private java.lang.String pk_psntype;
	private java.lang.String poststat;
	private java.lang.String psnnamepinyin;
	private java.lang.String recruitresource;
	private java.lang.String regular;
	private java.lang.String regulardata;
	private java.lang.String series;
	private java.lang.Long showorder;
	private java.lang.Long tbm_prop;
	private java.lang.String timecardid;
	private java.lang.String wastopdate;
	private java.lang.String years_score;
	private java.lang.String onclassdate;
	
	
	public java.lang.String getPk_psndoc_old() {
		return pk_psndoc_old;
	}
	public void setPk_psndoc_old(java.lang.String pk_psndoc_old) {
		this.pk_psndoc_old = pk_psndoc_old;
	}
	public java.lang.String getAmcode() {
		return amcode;
	}
	public void setAmcode(java.lang.String amcode) {
		this.amcode = amcode;
	}
	public java.lang.String getClerkcode() {
		return clerkcode;
	}
	public void setClerkcode(java.lang.String clerkcode) {
		this.clerkcode = clerkcode;
	}
	public java.lang.String getClerkflag() {
		return clerkflag;
	}
	public void setClerkflag(java.lang.String clerkflag) {
		this.clerkflag = clerkflag;
	}
	public java.lang.String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(java.lang.String createtime) {
		this.createtime = createtime;
	}
	public java.lang.String getCreator() {
		return creator;
	}
	public void setCreator(java.lang.String creator) {
		this.creator = creator;
	}
	public java.lang.String getDef1() {
		return def1;
	}
	public void setDef1(java.lang.String def1) {
		this.def1 = def1;
	}
	public java.lang.String getDef10() {
		return def10;
	}
	public void setDef10(java.lang.String def10) {
		this.def10 = def10;
	}
	public java.lang.String getDef11() {
		return def11;
	}
	public void setDef11(java.lang.String def11) {
		this.def11 = def11;
	}
	public java.lang.String getDef12() {
		return def12;
	}
	public void setDef12(java.lang.String def12) {
		this.def12 = def12;
	}
	public java.lang.String getDef13() {
		return def13;
	}
	public void setDef13(java.lang.String def13) {
		this.def13 = def13;
	}
	public java.lang.String getDef14() {
		return def14;
	}
	public void setDef14(java.lang.String def14) {
		this.def14 = def14;
	}
	public java.lang.String getDef15() {
		return def15;
	}
	public void setDef15(java.lang.String def15) {
		this.def15 = def15;
	}
	public java.lang.String getDef16() {
		return def16;
	}
	public void setDef16(java.lang.String def16) {
		this.def16 = def16;
	}
	public java.lang.String getDef17() {
		return def17;
	}
	public void setDef17(java.lang.String def17) {
		this.def17 = def17;
	}
	public java.lang.String getDef18() {
		return def18;
	}
	public void setDef18(java.lang.String def18) {
		this.def18 = def18;
	}
	public java.lang.String getDef19() {
		return def19;
	}
	public void setDef19(java.lang.String def19) {
		this.def19 = def19;
	}
	public java.lang.String getDef2() {
		return def2;
	}
	public void setDef2(java.lang.String def2) {
		this.def2 = def2;
	}
	public java.lang.String getDef20() {
		return def20;
	}
	public void setDef20(java.lang.String def20) {
		this.def20 = def20;
	}
	public java.lang.String getDef3() {
		return def3;
	}
	public void setDef3(java.lang.String def3) {
		this.def3 = def3;
	}
	public java.lang.String getDef4() {
		return def4;
	}
	public void setDef4(java.lang.String def4) {
		this.def4 = def4;
	}
	public java.lang.String getDef5() {
		return def5;
	}
	public void setDef5(java.lang.String def5) {
		this.def5 = def5;
	}
	public java.lang.String getDef6() {
		return def6;
	}
	public void setDef6(java.lang.String def6) {
		this.def6 = def6;
	}
	public java.lang.String getDef7() {
		return def7;
	}
	public void setDef7(java.lang.String def7) {
		this.def7 = def7;
	}
	public java.lang.String getDef8() {
		return def8;
	}
	public void setDef8(java.lang.String def8) {
		this.def8 = def8;
	}
	public java.lang.String getDef9() {
		return def9;
	}
	public void setDef9(java.lang.String def9) {
		this.def9 = def9;
	}
	public java.lang.Integer getDr() {
		return dr;
	}
	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}
	public java.lang.String getIndocflag() {
		return indocflag;
	}
	public void setIndocflag(java.lang.String indocflag) {
		this.indocflag = indocflag;
	}
	public java.lang.String getIndutydate() {
		return indutydate;
	}
	public void setIndutydate(java.lang.String indutydate) {
		this.indutydate = indutydate;
	}
	public java.lang.String getInnercode() {
		return innercode;
	}
	public void setInnercode(java.lang.String innercode) {
		this.innercode = innercode;
	}
	public java.lang.String getJobrank() {
		return jobrank;
	}
	public void setJobrank(java.lang.String jobrank) {
		this.jobrank = jobrank;
	}
	public java.lang.String getJobseries() {
		return jobseries;
	}
	public void setJobseries(java.lang.String jobseries) {
		this.jobseries = jobseries;
	}
	public java.lang.String getMaxinnercode() {
		return maxinnercode;
	}
	public void setMaxinnercode(java.lang.String maxinnercode) {
		this.maxinnercode = maxinnercode;
	}
	public java.lang.String getModifier() {
		return modifier;
	}
	public void setModifier(java.lang.String modifier) {
		this.modifier = modifier;
	}
	public java.lang.String getModifytime() {
		return modifytime;
	}
	public void setModifytime(java.lang.String modifytime) {
		this.modifytime = modifytime;
	}
	public java.lang.String getOutdutydate() {
		return outdutydate;
	}
	public void setOutdutydate(java.lang.String outdutydate) {
		this.outdutydate = outdutydate;
	}
	public java.lang.String getPk_corp() {
		return pk_corp;
	}
	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}
	public java.lang.String getPk_deptdoc() {
		return pk_deptdoc;
	}
	public void setPk_deptdoc(java.lang.String pk_deptdoc) {
		this.pk_deptdoc = pk_deptdoc;
	}
	public java.lang.String getPk_om_job() {
		return pk_om_job;
	}
	public void setPk_om_job(java.lang.String pk_om_job) {
		this.pk_om_job = pk_om_job;
	}
	public java.lang.String getPk_psnbasdoc() {
		return pk_psnbasdoc;
	}
	public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
		this.pk_psnbasdoc = pk_psnbasdoc;
	}
	public java.lang.String getPk_psncl() {
		return pk_psncl;
	}
	public void setPk_psncl(java.lang.String pk_psncl) {
		this.pk_psncl = pk_psncl;
	}
	public java.lang.String getPk_psndoc() {
		return pk_psndoc;
	}
	public void setPk_psndoc(java.lang.String pk_psndoc) {
		this.pk_psndoc = pk_psndoc;
	}
	public java.lang.Integer getPsnclscope() {
		return psnclscope;
	}
	public void setPsnclscope(java.lang.Integer psnclscope) {
		this.psnclscope = psnclscope;
	}
	public java.lang.String getPsncode() {
		return psncode;
	}
	public void setPsncode(java.lang.String psncode) {
		this.psncode = psncode;
	}
	public java.lang.String getPsnname() {
		return psnname;
	}
	public void setPsnname(java.lang.String psnname) {
		this.psnname = psnname;
	}
	public java.lang.String getSealdate() {
		return sealdate;
	}
	public void setSealdate(java.lang.String sealdate) {
		this.sealdate = sealdate;
	}
	public java.lang.String getTs() {
		return ts;
	}
	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}
	public java.lang.String getDirectleader() {
		return directleader;
	}
	public void setDirectleader(java.lang.String directleader) {
		this.directleader = directleader;
	}
	public java.lang.String getDutyname() {
		return dutyname;
	}
	public void setDutyname(java.lang.String dutyname) {
		this.dutyname = dutyname;
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
	public java.lang.String getHroperator() {
		return hroperator;
	}
	public void setHroperator(java.lang.String hroperator) {
		this.hroperator = hroperator;
	}
	public java.lang.String getInsource() {
		return insource;
	}
	public void setInsource(java.lang.String insource) {
		this.insource = insource;
	}
	public java.lang.String getIscalovertime() {
		return iscalovertime;
	}
	public void setIscalovertime(java.lang.String iscalovertime) {
		this.iscalovertime = iscalovertime;
	}
	public java.lang.String getIsreferenced() {
		return isreferenced;
	}
	public void setIsreferenced(java.lang.String isreferenced) {
		this.isreferenced = isreferenced;
	}
	public java.lang.String getIsreturn() {
		return isreturn;
	}
	public void setIsreturn(java.lang.String isreturn) {
		this.isreturn = isreturn;
	}
	public java.lang.String getOnpostdate() {
		return onpostdate;
	}
	public void setOnpostdate(java.lang.String onpostdate) {
		this.onpostdate = onpostdate;
	}
	public java.lang.String getOutmethod() {
		return outmethod;
	}
	public void setOutmethod(java.lang.String outmethod) {
		this.outmethod = outmethod;
	}
	public java.lang.String getPk_clerkclass() {
		return pk_clerkclass;
	}
	public void setPk_clerkclass(java.lang.String pk_clerkclass) {
		this.pk_clerkclass = pk_clerkclass;
	}
	public java.lang.String getPk_dutyrank() {
		return pk_dutyrank;
	}
	public void setPk_dutyrank(java.lang.String pk_dutyrank) {
		this.pk_dutyrank = pk_dutyrank;
	}
	public java.lang.String getPk_psntype() {
		return pk_psntype;
	}
	public void setPk_psntype(java.lang.String pk_psntype) {
		this.pk_psntype = pk_psntype;
	}
	public java.lang.String getPoststat() {
		return poststat;
	}
	public void setPoststat(java.lang.String poststat) {
		this.poststat = poststat;
	}
	public java.lang.String getPsnnamepinyin() {
		return psnnamepinyin;
	}
	public void setPsnnamepinyin(java.lang.String psnnamepinyin) {
		this.psnnamepinyin = psnnamepinyin;
	}
	public java.lang.String getRecruitresource() {
		return recruitresource;
	}
	public void setRecruitresource(java.lang.String recruitresource) {
		this.recruitresource = recruitresource;
	}
	public java.lang.String getRegular() {
		return regular;
	}
	public void setRegular(java.lang.String regular) {
		this.regular = regular;
	}
	public java.lang.String getRegulardata() {
		return regulardata;
	}
	public void setRegulardata(java.lang.String regulardata) {
		this.regulardata = regulardata;
	}
	public java.lang.String getSeries() {
		return series;
	}
	public void setSeries(java.lang.String series) {
		this.series = series;
	}
	public java.lang.Long getShoworder() {
		return showorder;
	}
	public void setShoworder(java.lang.Long showorder) {
		this.showorder = showorder;
	}
	public java.lang.Long getTbm_prop() {
		return tbm_prop;
	}
	public void setTbm_prop(java.lang.Long tbm_prop) {
		this.tbm_prop = tbm_prop;
	}
	public java.lang.String getTimecardid() {
		return timecardid;
	}
	public void setTimecardid(java.lang.String timecardid) {
		this.timecardid = timecardid;
	}
	public java.lang.String getWastopdate() {
		return wastopdate;
	}
	public void setWastopdate(java.lang.String wastopdate) {
		this.wastopdate = wastopdate;
	}
	public java.lang.String getYears_score() {
		return years_score;
	}
	public void setYears_score(java.lang.String years_score) {
		this.years_score = years_score;
	}
	public java.lang.String getOnclassdate() {
		return onclassdate;
	}
	public void setOnclassdate(java.lang.String onclassdate) {
		this.onclassdate = onclassdate;
	}
	@Override
	public String getPKFieldName() {
		return "pk_psndoc";
	}
	@Override
	public String getParentPKFieldName() {
		return null;
	}
	@Override
	public String getTableName() {
		return "mid_bd_psndoc";
	}
}

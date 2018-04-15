package nc.vo.spike.hi;

import nc.vo.pub.lang.UFDouble;
import nc.vo.spike.BasicVO;

/**
 * @ClassName: Hi_psndoc_trainingVO
 * <b> 工人技术等级中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月28日下午3:21:55
 * @Author 王凯强
 * @Version 
 */
public class Hi_psndoc_trainingVO extends BasicVO {
	private static final long serialVersionUID = -7059875610019850502L;
	
	private java.lang.Long approveflag;
	private java.lang.String apprvpsn;
	private java.lang.Long apprvtype;
	private java.lang.String assist_unit;
	private java.lang.String begindate;
	private java.lang.String bfromtrm;
	private UFDouble budge_person_fee;
	private java.lang.String busitype;
	private java.lang.Long certif_period;
	private java.lang.String certificate_date;
	private java.lang.String certificate_unit;
	private java.lang.String checknote;
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
	private java.lang.Integer dr;
	private java.lang.String enddate;
	private java.lang.String entrepreneur;
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
	private java.lang.String groupdef21;
	private java.lang.String groupdef22;
	private java.lang.String groupdef23;
	private java.lang.String groupdef24;
	private java.lang.String groupdef25;
	private java.lang.String groupdef26;
	private java.lang.String groupdef27;
	private java.lang.String groupdef28;
	private java.lang.String groupdef29;
	private java.lang.String groupdef3;
	private java.lang.String groupdef30;
	private java.lang.String groupdef4;
	private java.lang.String groupdef5;
	private java.lang.String groupdef6;
	private java.lang.String groupdef7;
	private java.lang.String groupdef8;
	private java.lang.String groupdef9;
	private java.lang.String hroperator;
	private java.lang.String indocflag;
	private java.lang.String lastflag;
	private java.lang.String memo;
	private java.lang.String period;
	private java.lang.String pk_apprpsn;
	private java.lang.String pk_corptraining;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc;
	/**
	 * @field: pk_psndoc_sub
	 * @Discription: 主键
	 */
	private java.lang.String pk_psndoc_sub;
	private java.lang.String pk_psndoc_sub_old;
	private java.lang.String pk_trm_rs_org;
	private java.lang.String purveyor;
	private java.lang.Long recordnum;
	private java.lang.String signon_dt;
	private java.lang.Long source_type;
	private java.lang.String taketr_reason;
	private java.lang.Long taketrm_method;
	private java.lang.String tra_content;
	private java.lang.Double tra_cost;
	private java.lang.String tra_mode;
	private java.lang.String tra_mode_name;
	private java.lang.String tra_project;
	private java.lang.String tra_result;
	private java.lang.Double tra_score;
	private java.lang.Double tra_time;
	private java.lang.String tra_type;
	private java.lang.String traim;
	private java.lang.String trm_certif_code;
	private java.lang.String trm_certif_name;
	private java.lang.String trm_class_names;
	private java.lang.String trm_location;
	private java.lang.String ts;
	private java.lang.String vcontcode;
	private java.lang.String vtra_act;
	private java.lang.String is_deptinner_act;
	private java.lang.String pk_deptdoc_create;
	private java.lang.String pk_act_class_101;
	private java.lang.String pk_act_class_102;
	private java.lang.String pk_act_class_103;
	private java.lang.String pk_act_class_104;
	private java.lang.String pk_act_class_105;
	private java.lang.String course_grade;
	private java.lang.String pk_oldjobname;
	private java.lang.String pk_nowjobname;
	private java.lang.String model;
	private java.lang.String beginworkthisjobdate;
	private java.lang.String beizhu;
	private java.lang.String hqzsgroupdef1;
	private java.lang.String hqzsgroupdef2;
	private java.lang.String hqzsgroupdef3;
	private java.lang.String hqzsgroupdef4;
	private java.lang.String hqzsgroupdef5;
	private java.lang.String hqzsgroupdef6;
	private java.lang.String hqzsgroupdef7;
	private java.lang.String hqzsgroupdef8;
	private java.lang.String hqzsgroupdef9;
	private java.lang.String hqzsgroupdef10;
	private java.lang.String practice_result;
	private java.lang.String date1;
	private java.lang.String date2;
	private java.lang.String applyproduct;
	private java.lang.Integer orgtype;
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
	public java.lang.Long getApproveflag() {
		return approveflag;
	}
	public void setApproveflag(java.lang.Long approveflag) {
		this.approveflag = approveflag;
	}
	public java.lang.String getApprvpsn() {
		return apprvpsn;
	}
	public void setApprvpsn(java.lang.String apprvpsn) {
		this.apprvpsn = apprvpsn;
	}
	public java.lang.Long getApprvtype() {
		return apprvtype;
	}
	public void setApprvtype(java.lang.Long apprvtype) {
		this.apprvtype = apprvtype;
	}
	public java.lang.String getAssist_unit() {
		return assist_unit;
	}
	public void setAssist_unit(java.lang.String assist_unit) {
		this.assist_unit = assist_unit;
	}
	public java.lang.String getBegindate() {
		return begindate;
	}
	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}
	public java.lang.String getBfromtrm() {
		return bfromtrm;
	}
	public void setBfromtrm(java.lang.String bfromtrm) {
		this.bfromtrm = bfromtrm;
	}
	public java.lang.String getBusitype() {
		return busitype;
	}
	public void setBusitype(java.lang.String busitype) {
		this.busitype = busitype;
	}
	public java.lang.Long getCertif_period() {
		return certif_period;
	}
	public void setCertif_period(java.lang.Long certif_period) {
		this.certif_period = certif_period;
	}
	public java.lang.String getCertificate_date() {
		return certificate_date;
	}
	public void setCertificate_date(java.lang.String certificate_date) {
		this.certificate_date = certificate_date;
	}
	public java.lang.String getCertificate_unit() {
		return certificate_unit;
	}
	public void setCertificate_unit(java.lang.String certificate_unit) {
		this.certificate_unit = certificate_unit;
	}
	public java.lang.String getChecknote() {
		return checknote;
	}
	public void setChecknote(java.lang.String checknote) {
		this.checknote = checknote;
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
	public java.lang.String getEntrepreneur() {
		return entrepreneur;
	}
	public void setEntrepreneur(java.lang.String entrepreneur) {
		this.entrepreneur = entrepreneur;
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
	public java.lang.String getGroupdef21() {
		return groupdef21;
	}
	public void setGroupdef21(java.lang.String groupdef21) {
		this.groupdef21 = groupdef21;
	}
	public java.lang.String getGroupdef22() {
		return groupdef22;
	}
	public void setGroupdef22(java.lang.String groupdef22) {
		this.groupdef22 = groupdef22;
	}
	public java.lang.String getGroupdef23() {
		return groupdef23;
	}
	public void setGroupdef23(java.lang.String groupdef23) {
		this.groupdef23 = groupdef23;
	}
	public java.lang.String getGroupdef24() {
		return groupdef24;
	}
	public void setGroupdef24(java.lang.String groupdef24) {
		this.groupdef24 = groupdef24;
	}
	public java.lang.String getGroupdef25() {
		return groupdef25;
	}
	public void setGroupdef25(java.lang.String groupdef25) {
		this.groupdef25 = groupdef25;
	}
	public java.lang.String getGroupdef26() {
		return groupdef26;
	}
	public void setGroupdef26(java.lang.String groupdef26) {
		this.groupdef26 = groupdef26;
	}
	public java.lang.String getGroupdef27() {
		return groupdef27;
	}
	public void setGroupdef27(java.lang.String groupdef27) {
		this.groupdef27 = groupdef27;
	}
	public java.lang.String getGroupdef28() {
		return groupdef28;
	}
	public void setGroupdef28(java.lang.String groupdef28) {
		this.groupdef28 = groupdef28;
	}
	public java.lang.String getGroupdef29() {
		return groupdef29;
	}
	public void setGroupdef29(java.lang.String groupdef29) {
		this.groupdef29 = groupdef29;
	}
	public java.lang.String getGroupdef3() {
		return groupdef3;
	}
	public void setGroupdef3(java.lang.String groupdef3) {
		this.groupdef3 = groupdef3;
	}
	public java.lang.String getGroupdef30() {
		return groupdef30;
	}
	public void setGroupdef30(java.lang.String groupdef30) {
		this.groupdef30 = groupdef30;
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
	public java.lang.String getIndocflag() {
		return indocflag;
	}
	public void setIndocflag(java.lang.String indocflag) {
		this.indocflag = indocflag;
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
	public java.lang.String getPeriod() {
		return period;
	}
	public void setPeriod(java.lang.String period) {
		this.period = period;
	}
	public java.lang.String getPk_apprpsn() {
		return pk_apprpsn;
	}
	public void setPk_apprpsn(java.lang.String pk_apprpsn) {
		this.pk_apprpsn = pk_apprpsn;
	}
	public java.lang.String getPk_corp() {
		return pk_corp;
	}
	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}
	public java.lang.String getPk_corptraining() {
		return pk_corptraining;
	}
	public void setPk_corptraining(java.lang.String pk_corptraining) {
		this.pk_corptraining = pk_corptraining;
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
	public java.lang.String getPk_trm_rs_org() {
		return pk_trm_rs_org;
	}
	public void setPk_trm_rs_org(java.lang.String pk_trm_rs_org) {
		this.pk_trm_rs_org = pk_trm_rs_org;
	}
	public java.lang.String getPurveyor() {
		return purveyor;
	}
	public void setPurveyor(java.lang.String purveyor) {
		this.purveyor = purveyor;
	}
	public java.lang.Long getRecordnum() {
		return recordnum;
	}
	public void setRecordnum(java.lang.Long recordnum) {
		this.recordnum = recordnum;
	}
	public java.lang.String getSignon_dt() {
		return signon_dt;
	}
	public void setSignon_dt(java.lang.String signon_dt) {
		this.signon_dt = signon_dt;
	}
	public java.lang.Long getSource_type() {
		return source_type;
	}
	public void setSource_type(java.lang.Long source_type) {
		this.source_type = source_type;
	}
	public java.lang.String getTaketr_reason() {
		return taketr_reason;
	}
	public void setTaketr_reason(java.lang.String taketr_reason) {
		this.taketr_reason = taketr_reason;
	}
	public java.lang.Long getTaketrm_method() {
		return taketrm_method;
	}
	public void setTaketrm_method(java.lang.Long taketrm_method) {
		this.taketrm_method = taketrm_method;
	}
	public java.lang.String getTra_content() {
		return tra_content;
	}
	public void setTra_content(java.lang.String tra_content) {
		this.tra_content = tra_content;
	}
	public java.lang.Double getTra_cost() {
		return tra_cost;
	}
	public void setTra_cost(java.lang.Double tra_cost) {
		this.tra_cost = tra_cost;
	}
	public java.lang.String getTra_mode() {
		return tra_mode;
	}
	public void setTra_mode(java.lang.String tra_mode) {
		this.tra_mode = tra_mode;
	}
	public java.lang.String getTra_mode_name() {
		return tra_mode_name;
	}
	public void setTra_mode_name(java.lang.String tra_mode_name) {
		this.tra_mode_name = tra_mode_name;
	}
	public java.lang.String getTra_project() {
		return tra_project;
	}
	public void setTra_project(java.lang.String tra_project) {
		this.tra_project = tra_project;
	}
	public java.lang.String getTra_result() {
		return tra_result;
	}
	public void setTra_result(java.lang.String tra_result) {
		this.tra_result = tra_result;
	}
	public java.lang.Double getTra_score() {
		return tra_score;
	}
	public void setTra_score(java.lang.Double tra_score) {
		this.tra_score = tra_score;
	}
	public java.lang.Double getTra_time() {
		return tra_time;
	}
	public void setTra_time(java.lang.Double tra_time) {
		this.tra_time = tra_time;
	}
	public java.lang.String getTra_type() {
		return tra_type;
	}
	public void setTra_type(java.lang.String tra_type) {
		this.tra_type = tra_type;
	}
	public java.lang.String getTraim() {
		return traim;
	}
	public void setTraim(java.lang.String traim) {
		this.traim = traim;
	}
	public java.lang.String getTrm_certif_code() {
		return trm_certif_code;
	}
	public void setTrm_certif_code(java.lang.String trm_certif_code) {
		this.trm_certif_code = trm_certif_code;
	}
	public java.lang.String getTrm_certif_name() {
		return trm_certif_name;
	}
	public void setTrm_certif_name(java.lang.String trm_certif_name) {
		this.trm_certif_name = trm_certif_name;
	}
	public java.lang.String getTrm_class_names() {
		return trm_class_names;
	}
	public void setTrm_class_names(java.lang.String trm_class_names) {
		this.trm_class_names = trm_class_names;
	}
	public java.lang.String getTrm_location() {
		return trm_location;
	}
	public void setTrm_location(java.lang.String trm_location) {
		this.trm_location = trm_location;
	}
	public java.lang.String getTs() {
		return ts;
	}
	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}
	public java.lang.String getVcontcode() {
		return vcontcode;
	}
	public void setVcontcode(java.lang.String vcontcode) {
		this.vcontcode = vcontcode;
	}
	public java.lang.String getVtra_act() {
		return vtra_act;
	}
	public void setVtra_act(java.lang.String vtra_act) {
		this.vtra_act = vtra_act;
	}
	public java.lang.String getIs_deptinner_act() {
		return is_deptinner_act;
	}
	public void setIs_deptinner_act(java.lang.String is_deptinner_act) {
		this.is_deptinner_act = is_deptinner_act;
	}
	public java.lang.String getPk_deptdoc_create() {
		return pk_deptdoc_create;
	}
	public void setPk_deptdoc_create(java.lang.String pk_deptdoc_create) {
		this.pk_deptdoc_create = pk_deptdoc_create;
	}
	public java.lang.String getPk_act_class_101() {
		return pk_act_class_101;
	}
	public void setPk_act_class_101(java.lang.String pk_act_class_101) {
		this.pk_act_class_101 = pk_act_class_101;
	}
	public java.lang.String getPk_act_class_102() {
		return pk_act_class_102;
	}
	public void setPk_act_class_102(java.lang.String pk_act_class_102) {
		this.pk_act_class_102 = pk_act_class_102;
	}
	public java.lang.String getPk_act_class_103() {
		return pk_act_class_103;
	}
	public void setPk_act_class_103(java.lang.String pk_act_class_103) {
		this.pk_act_class_103 = pk_act_class_103;
	}
	public java.lang.String getPk_act_class_104() {
		return pk_act_class_104;
	}
	public void setPk_act_class_104(java.lang.String pk_act_class_104) {
		this.pk_act_class_104 = pk_act_class_104;
	}
	public java.lang.String getPk_act_class_105() {
		return pk_act_class_105;
	}
	public void setPk_act_class_105(java.lang.String pk_act_class_105) {
		this.pk_act_class_105 = pk_act_class_105;
	}
	public java.lang.String getCourse_grade() {
		return course_grade;
	}
	public void setCourse_grade(java.lang.String course_grade) {
		this.course_grade = course_grade;
	}
	public java.lang.String getPk_oldjobname() {
		return pk_oldjobname;
	}
	public void setPk_oldjobname(java.lang.String pk_oldjobname) {
		this.pk_oldjobname = pk_oldjobname;
	}
	public java.lang.String getPk_nowjobname() {
		return pk_nowjobname;
	}
	public void setPk_nowjobname(java.lang.String pk_nowjobname) {
		this.pk_nowjobname = pk_nowjobname;
	}
	public java.lang.String getModel() {
		return model;
	}
	public void setModel(java.lang.String model) {
		this.model = model;
	}
	public java.lang.String getBeginworkthisjobdate() {
		return beginworkthisjobdate;
	}
	public void setBeginworkthisjobdate(java.lang.String beginworkthisjobdate) {
		this.beginworkthisjobdate = beginworkthisjobdate;
	}
	public java.lang.String getBeizhu() {
		return beizhu;
	}
	public void setBeizhu(java.lang.String beizhu) {
		this.beizhu = beizhu;
	}
	public java.lang.String getHqzsgroupdef1() {
		return hqzsgroupdef1;
	}
	public void setHqzsgroupdef1(java.lang.String hqzsgroupdef1) {
		this.hqzsgroupdef1 = hqzsgroupdef1;
	}
	public java.lang.String getHqzsgroupdef2() {
		return hqzsgroupdef2;
	}
	public void setHqzsgroupdef2(java.lang.String hqzsgroupdef2) {
		this.hqzsgroupdef2 = hqzsgroupdef2;
	}
	public java.lang.String getHqzsgroupdef3() {
		return hqzsgroupdef3;
	}
	public void setHqzsgroupdef3(java.lang.String hqzsgroupdef3) {
		this.hqzsgroupdef3 = hqzsgroupdef3;
	}
	public java.lang.String getHqzsgroupdef4() {
		return hqzsgroupdef4;
	}
	public void setHqzsgroupdef4(java.lang.String hqzsgroupdef4) {
		this.hqzsgroupdef4 = hqzsgroupdef4;
	}
	public java.lang.String getHqzsgroupdef5() {
		return hqzsgroupdef5;
	}
	public void setHqzsgroupdef5(java.lang.String hqzsgroupdef5) {
		this.hqzsgroupdef5 = hqzsgroupdef5;
	}
	public java.lang.String getHqzsgroupdef6() {
		return hqzsgroupdef6;
	}
	public void setHqzsgroupdef6(java.lang.String hqzsgroupdef6) {
		this.hqzsgroupdef6 = hqzsgroupdef6;
	}
	public java.lang.String getHqzsgroupdef7() {
		return hqzsgroupdef7;
	}
	public void setHqzsgroupdef7(java.lang.String hqzsgroupdef7) {
		this.hqzsgroupdef7 = hqzsgroupdef7;
	}
	public java.lang.String getHqzsgroupdef8() {
		return hqzsgroupdef8;
	}
	public void setHqzsgroupdef8(java.lang.String hqzsgroupdef8) {
		this.hqzsgroupdef8 = hqzsgroupdef8;
	}
	public java.lang.String getHqzsgroupdef9() {
		return hqzsgroupdef9;
	}
	public void setHqzsgroupdef9(java.lang.String hqzsgroupdef9) {
		this.hqzsgroupdef9 = hqzsgroupdef9;
	}
	public java.lang.String getHqzsgroupdef10() {
		return hqzsgroupdef10;
	}
	public void setHqzsgroupdef10(java.lang.String hqzsgroupdef10) {
		this.hqzsgroupdef10 = hqzsgroupdef10;
	}
	public java.lang.String getPractice_result() {
		return practice_result;
	}
	public void setPractice_result(java.lang.String practice_result) {
		this.practice_result = practice_result;
	}
	public java.lang.String getDate1() {
		return date1;
	}
	public void setDate1(java.lang.String date1) {
		this.date1 = date1;
	}
	public java.lang.String getDate2() {
		return date2;
	}
	public void setDate2(java.lang.String date2) {
		this.date2 = date2;
	}
	public java.lang.String getApplyproduct() {
		return applyproduct;
	}
	public void setApplyproduct(java.lang.String applyproduct) {
		this.applyproduct = applyproduct;
	}
	public java.lang.Integer getOrgtype() {
		return orgtype;
	}
	public void setOrgtype(java.lang.Integer orgtype) {
		this.orgtype = orgtype;
	}
	public UFDouble getBudge_person_fee() {
		return budge_person_fee;
	}
	public void setBudge_person_fee(UFDouble budge_person_fee) {
		this.budge_person_fee = budge_person_fee;
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
		return "mid_hi_psndoc_training";
	}
}

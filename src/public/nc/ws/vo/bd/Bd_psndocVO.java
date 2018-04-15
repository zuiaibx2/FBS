/**
 * Bd_psndocVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.bd;

public class Bd_psndocVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String ts;

    private java.lang.String groupdef11;

    private java.lang.String directleader;

    private java.lang.String groupdef12;

    private java.lang.String groupdef10;

    private java.lang.String groupdef15;

    private java.lang.String groupdef16;

    private java.lang.String groupdef13;

    private java.lang.String groupdef14;

    private java.lang.String groupdef19;

    private java.lang.String pk_psntype;

    private java.lang.String groupdef17;

    private java.lang.String groupdef18;

    private java.lang.String pk_psncl;

    private java.lang.String innercode;

    private java.lang.String regulardata;

    private java.lang.String psncode;

    private java.lang.String indutydate;

    private java.lang.String outmethod;

    private java.lang.String poststat;

    private java.lang.String def7;

    private java.lang.String def8;

    private java.lang.String def5;

    private java.lang.String def6;

    private java.lang.String groupdef20;

    private java.lang.String def9;

    private java.lang.String dutyname;

    private java.lang.String spike_sign;

    private java.lang.String insource;

    private java.lang.String indocflag;

    private java.lang.String pk_dutyrank;

    private java.lang.String isreturn;

    private java.lang.String modifier;

    private java.lang.String wastopdate;

    private java.lang.String years_score;

    private java.lang.String psnnamepinyin;

    private java.lang.String def20;

    private java.lang.String def4;

    private java.lang.String def3;

    private java.lang.String def2;

    private java.lang.String def1;

    private java.lang.String def12;

    private java.lang.String series;

    private java.lang.String def13;

    private java.lang.String pk_psndoc;

    private java.lang.String def10;

    private java.lang.Long psnclscope;

    private java.lang.String def11;

    private java.lang.String clerkcode;

    private java.lang.String def18;

    private java.lang.String def19;

    private java.lang.String jobseries;

    private java.lang.String def16;

    private java.lang.String def17;

    private java.lang.String def14;

    private java.lang.String sealdate;

    private java.lang.String creator;

    private java.lang.String def15;

    private java.lang.String createtime;

    private java.lang.String iscalovertime;

    private java.lang.String pk_clerkclass;

    private java.lang.String tableName;

    private java.lang.String onclassdate;

    private java.lang.String clerkflag;

    private java.lang.Long showorder;

    private java.lang.String amcode;

    private java.lang.String outdutydate;

    private java.lang.String isreferenced;

    private java.lang.Integer dr;

    private java.lang.Long tbm_prop;

    private java.lang.String pk_corp;

    private java.lang.String regular;

    private java.lang.String psnname;

    private java.lang.String pk_om_job;

    private java.lang.String recruitresource;

    private java.lang.String hroperator;

    private java.lang.String groupdef6;

    private java.lang.String groupdef7;

    private java.lang.String groupdef8;

    private java.lang.String pk_psnbasdoc;

    private java.lang.String maxinnercode;

    private java.lang.String groupdef9;

    private java.lang.String modifytime;

    private java.lang.String groupdef3;

    private java.lang.String groupdef2;

    private java.lang.String groupdef5;

    private java.lang.String groupdef4;

    private java.lang.String onpostdate;

    private java.lang.String groupdef1;

    private java.lang.String jobrank;

    private java.lang.String pk_deptdoc;

    private java.lang.String timecardid;

    public Bd_psndocVO() {
    }

    public Bd_psndocVO(
           java.lang.String ts,
           java.lang.String groupdef11,
           java.lang.String directleader,
           java.lang.String groupdef12,
           java.lang.String groupdef10,
           java.lang.String groupdef15,
           java.lang.String groupdef16,
           java.lang.String groupdef13,
           java.lang.String groupdef14,
           java.lang.String groupdef19,
           java.lang.String pk_psntype,
           java.lang.String groupdef17,
           java.lang.String groupdef18,
           java.lang.String pk_psncl,
           java.lang.String innercode,
           java.lang.String regulardata,
           java.lang.String psncode,
           java.lang.String indutydate,
           java.lang.String outmethod,
           java.lang.String poststat,
           java.lang.String def7,
           java.lang.String def8,
           java.lang.String def5,
           java.lang.String def6,
           java.lang.String groupdef20,
           java.lang.String def9,
           java.lang.String dutyname,
           java.lang.String spike_sign,
           java.lang.String insource,
           java.lang.String indocflag,
           java.lang.String pk_dutyrank,
           java.lang.String isreturn,
           java.lang.String modifier,
           java.lang.String wastopdate,
           java.lang.String years_score,
           java.lang.String psnnamepinyin,
           java.lang.String def20,
           java.lang.String def4,
           java.lang.String def3,
           java.lang.String def2,
           java.lang.String def1,
           java.lang.String def12,
           java.lang.String series,
           java.lang.String def13,
           java.lang.String pk_psndoc,
           java.lang.String def10,
           java.lang.Long psnclscope,
           java.lang.String def11,
           java.lang.String clerkcode,
           java.lang.String def18,
           java.lang.String def19,
           java.lang.String jobseries,
           java.lang.String def16,
           java.lang.String def17,
           java.lang.String def14,
           java.lang.String sealdate,
           java.lang.String creator,
           java.lang.String def15,
           java.lang.String createtime,
           java.lang.String iscalovertime,
           java.lang.String pk_clerkclass,
           java.lang.String tableName,
           java.lang.String onclassdate,
           java.lang.String clerkflag,
           java.lang.Long showorder,
           java.lang.String amcode,
           java.lang.String outdutydate,
           java.lang.String isreferenced,
           java.lang.Integer dr,
           java.lang.Long tbm_prop,
           java.lang.String pk_corp,
           java.lang.String regular,
           java.lang.String psnname,
           java.lang.String pk_om_job,
           java.lang.String recruitresource,
           java.lang.String hroperator,
           java.lang.String groupdef6,
           java.lang.String groupdef7,
           java.lang.String groupdef8,
           java.lang.String pk_psnbasdoc,
           java.lang.String maxinnercode,
           java.lang.String groupdef9,
           java.lang.String modifytime,
           java.lang.String groupdef3,
           java.lang.String groupdef2,
           java.lang.String groupdef5,
           java.lang.String groupdef4,
           java.lang.String onpostdate,
           java.lang.String groupdef1,
           java.lang.String jobrank,
           java.lang.String pk_deptdoc,
           java.lang.String timecardid) {
           this.ts = ts;
           this.groupdef11 = groupdef11;
           this.directleader = directleader;
           this.groupdef12 = groupdef12;
           this.groupdef10 = groupdef10;
           this.groupdef15 = groupdef15;
           this.groupdef16 = groupdef16;
           this.groupdef13 = groupdef13;
           this.groupdef14 = groupdef14;
           this.groupdef19 = groupdef19;
           this.pk_psntype = pk_psntype;
           this.groupdef17 = groupdef17;
           this.groupdef18 = groupdef18;
           this.pk_psncl = pk_psncl;
           this.innercode = innercode;
           this.regulardata = regulardata;
           this.psncode = psncode;
           this.indutydate = indutydate;
           this.outmethod = outmethod;
           this.poststat = poststat;
           this.def7 = def7;
           this.def8 = def8;
           this.def5 = def5;
           this.def6 = def6;
           this.groupdef20 = groupdef20;
           this.def9 = def9;
           this.dutyname = dutyname;
           this.spike_sign = spike_sign;
           this.insource = insource;
           this.indocflag = indocflag;
           this.pk_dutyrank = pk_dutyrank;
           this.isreturn = isreturn;
           this.modifier = modifier;
           this.wastopdate = wastopdate;
           this.years_score = years_score;
           this.psnnamepinyin = psnnamepinyin;
           this.def20 = def20;
           this.def4 = def4;
           this.def3 = def3;
           this.def2 = def2;
           this.def1 = def1;
           this.def12 = def12;
           this.series = series;
           this.def13 = def13;
           this.pk_psndoc = pk_psndoc;
           this.def10 = def10;
           this.psnclscope = psnclscope;
           this.def11 = def11;
           this.clerkcode = clerkcode;
           this.def18 = def18;
           this.def19 = def19;
           this.jobseries = jobseries;
           this.def16 = def16;
           this.def17 = def17;
           this.def14 = def14;
           this.sealdate = sealdate;
           this.creator = creator;
           this.def15 = def15;
           this.createtime = createtime;
           this.iscalovertime = iscalovertime;
           this.pk_clerkclass = pk_clerkclass;
           this.tableName = tableName;
           this.onclassdate = onclassdate;
           this.clerkflag = clerkflag;
           this.showorder = showorder;
           this.amcode = amcode;
           this.outdutydate = outdutydate;
           this.isreferenced = isreferenced;
           this.dr = dr;
           this.tbm_prop = tbm_prop;
           this.pk_corp = pk_corp;
           this.regular = regular;
           this.psnname = psnname;
           this.pk_om_job = pk_om_job;
           this.recruitresource = recruitresource;
           this.hroperator = hroperator;
           this.groupdef6 = groupdef6;
           this.groupdef7 = groupdef7;
           this.groupdef8 = groupdef8;
           this.pk_psnbasdoc = pk_psnbasdoc;
           this.maxinnercode = maxinnercode;
           this.groupdef9 = groupdef9;
           this.modifytime = modifytime;
           this.groupdef3 = groupdef3;
           this.groupdef2 = groupdef2;
           this.groupdef5 = groupdef5;
           this.groupdef4 = groupdef4;
           this.onpostdate = onpostdate;
           this.groupdef1 = groupdef1;
           this.jobrank = jobrank;
           this.pk_deptdoc = pk_deptdoc;
           this.timecardid = timecardid;
    }


    /**
     * Gets the ts value for this Bd_psndocVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Bd_psndocVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the groupdef11 value for this Bd_psndocVO.
     * 
     * @return groupdef11
     */
    public java.lang.String getGroupdef11() {
        return groupdef11;
    }


    /**
     * Sets the groupdef11 value for this Bd_psndocVO.
     * 
     * @param groupdef11
     */
    public void setGroupdef11(java.lang.String groupdef11) {
        this.groupdef11 = groupdef11;
    }


    /**
     * Gets the directleader value for this Bd_psndocVO.
     * 
     * @return directleader
     */
    public java.lang.String getDirectleader() {
        return directleader;
    }


    /**
     * Sets the directleader value for this Bd_psndocVO.
     * 
     * @param directleader
     */
    public void setDirectleader(java.lang.String directleader) {
        this.directleader = directleader;
    }


    /**
     * Gets the groupdef12 value for this Bd_psndocVO.
     * 
     * @return groupdef12
     */
    public java.lang.String getGroupdef12() {
        return groupdef12;
    }


    /**
     * Sets the groupdef12 value for this Bd_psndocVO.
     * 
     * @param groupdef12
     */
    public void setGroupdef12(java.lang.String groupdef12) {
        this.groupdef12 = groupdef12;
    }


    /**
     * Gets the groupdef10 value for this Bd_psndocVO.
     * 
     * @return groupdef10
     */
    public java.lang.String getGroupdef10() {
        return groupdef10;
    }


    /**
     * Sets the groupdef10 value for this Bd_psndocVO.
     * 
     * @param groupdef10
     */
    public void setGroupdef10(java.lang.String groupdef10) {
        this.groupdef10 = groupdef10;
    }


    /**
     * Gets the groupdef15 value for this Bd_psndocVO.
     * 
     * @return groupdef15
     */
    public java.lang.String getGroupdef15() {
        return groupdef15;
    }


    /**
     * Sets the groupdef15 value for this Bd_psndocVO.
     * 
     * @param groupdef15
     */
    public void setGroupdef15(java.lang.String groupdef15) {
        this.groupdef15 = groupdef15;
    }


    /**
     * Gets the groupdef16 value for this Bd_psndocVO.
     * 
     * @return groupdef16
     */
    public java.lang.String getGroupdef16() {
        return groupdef16;
    }


    /**
     * Sets the groupdef16 value for this Bd_psndocVO.
     * 
     * @param groupdef16
     */
    public void setGroupdef16(java.lang.String groupdef16) {
        this.groupdef16 = groupdef16;
    }


    /**
     * Gets the groupdef13 value for this Bd_psndocVO.
     * 
     * @return groupdef13
     */
    public java.lang.String getGroupdef13() {
        return groupdef13;
    }


    /**
     * Sets the groupdef13 value for this Bd_psndocVO.
     * 
     * @param groupdef13
     */
    public void setGroupdef13(java.lang.String groupdef13) {
        this.groupdef13 = groupdef13;
    }


    /**
     * Gets the groupdef14 value for this Bd_psndocVO.
     * 
     * @return groupdef14
     */
    public java.lang.String getGroupdef14() {
        return groupdef14;
    }


    /**
     * Sets the groupdef14 value for this Bd_psndocVO.
     * 
     * @param groupdef14
     */
    public void setGroupdef14(java.lang.String groupdef14) {
        this.groupdef14 = groupdef14;
    }


    /**
     * Gets the groupdef19 value for this Bd_psndocVO.
     * 
     * @return groupdef19
     */
    public java.lang.String getGroupdef19() {
        return groupdef19;
    }


    /**
     * Sets the groupdef19 value for this Bd_psndocVO.
     * 
     * @param groupdef19
     */
    public void setGroupdef19(java.lang.String groupdef19) {
        this.groupdef19 = groupdef19;
    }


    /**
     * Gets the pk_psntype value for this Bd_psndocVO.
     * 
     * @return pk_psntype
     */
    public java.lang.String getPk_psntype() {
        return pk_psntype;
    }


    /**
     * Sets the pk_psntype value for this Bd_psndocVO.
     * 
     * @param pk_psntype
     */
    public void setPk_psntype(java.lang.String pk_psntype) {
        this.pk_psntype = pk_psntype;
    }


    /**
     * Gets the groupdef17 value for this Bd_psndocVO.
     * 
     * @return groupdef17
     */
    public java.lang.String getGroupdef17() {
        return groupdef17;
    }


    /**
     * Sets the groupdef17 value for this Bd_psndocVO.
     * 
     * @param groupdef17
     */
    public void setGroupdef17(java.lang.String groupdef17) {
        this.groupdef17 = groupdef17;
    }


    /**
     * Gets the groupdef18 value for this Bd_psndocVO.
     * 
     * @return groupdef18
     */
    public java.lang.String getGroupdef18() {
        return groupdef18;
    }


    /**
     * Sets the groupdef18 value for this Bd_psndocVO.
     * 
     * @param groupdef18
     */
    public void setGroupdef18(java.lang.String groupdef18) {
        this.groupdef18 = groupdef18;
    }


    /**
     * Gets the pk_psncl value for this Bd_psndocVO.
     * 
     * @return pk_psncl
     */
    public java.lang.String getPk_psncl() {
        return pk_psncl;
    }


    /**
     * Sets the pk_psncl value for this Bd_psndocVO.
     * 
     * @param pk_psncl
     */
    public void setPk_psncl(java.lang.String pk_psncl) {
        this.pk_psncl = pk_psncl;
    }


    /**
     * Gets the innercode value for this Bd_psndocVO.
     * 
     * @return innercode
     */
    public java.lang.String getInnercode() {
        return innercode;
    }


    /**
     * Sets the innercode value for this Bd_psndocVO.
     * 
     * @param innercode
     */
    public void setInnercode(java.lang.String innercode) {
        this.innercode = innercode;
    }


    /**
     * Gets the regulardata value for this Bd_psndocVO.
     * 
     * @return regulardata
     */
    public java.lang.String getRegulardata() {
        return regulardata;
    }


    /**
     * Sets the regulardata value for this Bd_psndocVO.
     * 
     * @param regulardata
     */
    public void setRegulardata(java.lang.String regulardata) {
        this.regulardata = regulardata;
    }


    /**
     * Gets the psncode value for this Bd_psndocVO.
     * 
     * @return psncode
     */
    public java.lang.String getPsncode() {
        return psncode;
    }


    /**
     * Sets the psncode value for this Bd_psndocVO.
     * 
     * @param psncode
     */
    public void setPsncode(java.lang.String psncode) {
        this.psncode = psncode;
    }


    /**
     * Gets the indutydate value for this Bd_psndocVO.
     * 
     * @return indutydate
     */
    public java.lang.String getIndutydate() {
        return indutydate;
    }


    /**
     * Sets the indutydate value for this Bd_psndocVO.
     * 
     * @param indutydate
     */
    public void setIndutydate(java.lang.String indutydate) {
        this.indutydate = indutydate;
    }


    /**
     * Gets the outmethod value for this Bd_psndocVO.
     * 
     * @return outmethod
     */
    public java.lang.String getOutmethod() {
        return outmethod;
    }


    /**
     * Sets the outmethod value for this Bd_psndocVO.
     * 
     * @param outmethod
     */
    public void setOutmethod(java.lang.String outmethod) {
        this.outmethod = outmethod;
    }


    /**
     * Gets the poststat value for this Bd_psndocVO.
     * 
     * @return poststat
     */
    public java.lang.String getPoststat() {
        return poststat;
    }


    /**
     * Sets the poststat value for this Bd_psndocVO.
     * 
     * @param poststat
     */
    public void setPoststat(java.lang.String poststat) {
        this.poststat = poststat;
    }


    /**
     * Gets the def7 value for this Bd_psndocVO.
     * 
     * @return def7
     */
    public java.lang.String getDef7() {
        return def7;
    }


    /**
     * Sets the def7 value for this Bd_psndocVO.
     * 
     * @param def7
     */
    public void setDef7(java.lang.String def7) {
        this.def7 = def7;
    }


    /**
     * Gets the def8 value for this Bd_psndocVO.
     * 
     * @return def8
     */
    public java.lang.String getDef8() {
        return def8;
    }


    /**
     * Sets the def8 value for this Bd_psndocVO.
     * 
     * @param def8
     */
    public void setDef8(java.lang.String def8) {
        this.def8 = def8;
    }


    /**
     * Gets the def5 value for this Bd_psndocVO.
     * 
     * @return def5
     */
    public java.lang.String getDef5() {
        return def5;
    }


    /**
     * Sets the def5 value for this Bd_psndocVO.
     * 
     * @param def5
     */
    public void setDef5(java.lang.String def5) {
        this.def5 = def5;
    }


    /**
     * Gets the def6 value for this Bd_psndocVO.
     * 
     * @return def6
     */
    public java.lang.String getDef6() {
        return def6;
    }


    /**
     * Sets the def6 value for this Bd_psndocVO.
     * 
     * @param def6
     */
    public void setDef6(java.lang.String def6) {
        this.def6 = def6;
    }


    /**
     * Gets the groupdef20 value for this Bd_psndocVO.
     * 
     * @return groupdef20
     */
    public java.lang.String getGroupdef20() {
        return groupdef20;
    }


    /**
     * Sets the groupdef20 value for this Bd_psndocVO.
     * 
     * @param groupdef20
     */
    public void setGroupdef20(java.lang.String groupdef20) {
        this.groupdef20 = groupdef20;
    }


    /**
     * Gets the def9 value for this Bd_psndocVO.
     * 
     * @return def9
     */
    public java.lang.String getDef9() {
        return def9;
    }


    /**
     * Sets the def9 value for this Bd_psndocVO.
     * 
     * @param def9
     */
    public void setDef9(java.lang.String def9) {
        this.def9 = def9;
    }


    /**
     * Gets the dutyname value for this Bd_psndocVO.
     * 
     * @return dutyname
     */
    public java.lang.String getDutyname() {
        return dutyname;
    }


    /**
     * Sets the dutyname value for this Bd_psndocVO.
     * 
     * @param dutyname
     */
    public void setDutyname(java.lang.String dutyname) {
        this.dutyname = dutyname;
    }


    /**
     * Gets the spike_sign value for this Bd_psndocVO.
     * 
     * @return spike_sign
     */
    public java.lang.String getSpike_sign() {
        return spike_sign;
    }


    /**
     * Sets the spike_sign value for this Bd_psndocVO.
     * 
     * @param spike_sign
     */
    public void setSpike_sign(java.lang.String spike_sign) {
        this.spike_sign = spike_sign;
    }


    /**
     * Gets the insource value for this Bd_psndocVO.
     * 
     * @return insource
     */
    public java.lang.String getInsource() {
        return insource;
    }


    /**
     * Sets the insource value for this Bd_psndocVO.
     * 
     * @param insource
     */
    public void setInsource(java.lang.String insource) {
        this.insource = insource;
    }


    /**
     * Gets the indocflag value for this Bd_psndocVO.
     * 
     * @return indocflag
     */
    public java.lang.String getIndocflag() {
        return indocflag;
    }


    /**
     * Sets the indocflag value for this Bd_psndocVO.
     * 
     * @param indocflag
     */
    public void setIndocflag(java.lang.String indocflag) {
        this.indocflag = indocflag;
    }


    /**
     * Gets the pk_dutyrank value for this Bd_psndocVO.
     * 
     * @return pk_dutyrank
     */
    public java.lang.String getPk_dutyrank() {
        return pk_dutyrank;
    }


    /**
     * Sets the pk_dutyrank value for this Bd_psndocVO.
     * 
     * @param pk_dutyrank
     */
    public void setPk_dutyrank(java.lang.String pk_dutyrank) {
        this.pk_dutyrank = pk_dutyrank;
    }


    /**
     * Gets the isreturn value for this Bd_psndocVO.
     * 
     * @return isreturn
     */
    public java.lang.String getIsreturn() {
        return isreturn;
    }


    /**
     * Sets the isreturn value for this Bd_psndocVO.
     * 
     * @param isreturn
     */
    public void setIsreturn(java.lang.String isreturn) {
        this.isreturn = isreturn;
    }


    /**
     * Gets the modifier value for this Bd_psndocVO.
     * 
     * @return modifier
     */
    public java.lang.String getModifier() {
        return modifier;
    }


    /**
     * Sets the modifier value for this Bd_psndocVO.
     * 
     * @param modifier
     */
    public void setModifier(java.lang.String modifier) {
        this.modifier = modifier;
    }


    /**
     * Gets the wastopdate value for this Bd_psndocVO.
     * 
     * @return wastopdate
     */
    public java.lang.String getWastopdate() {
        return wastopdate;
    }


    /**
     * Sets the wastopdate value for this Bd_psndocVO.
     * 
     * @param wastopdate
     */
    public void setWastopdate(java.lang.String wastopdate) {
        this.wastopdate = wastopdate;
    }


    /**
     * Gets the years_score value for this Bd_psndocVO.
     * 
     * @return years_score
     */
    public java.lang.String getYears_score() {
        return years_score;
    }


    /**
     * Sets the years_score value for this Bd_psndocVO.
     * 
     * @param years_score
     */
    public void setYears_score(java.lang.String years_score) {
        this.years_score = years_score;
    }


    /**
     * Gets the psnnamepinyin value for this Bd_psndocVO.
     * 
     * @return psnnamepinyin
     */
    public java.lang.String getPsnnamepinyin() {
        return psnnamepinyin;
    }


    /**
     * Sets the psnnamepinyin value for this Bd_psndocVO.
     * 
     * @param psnnamepinyin
     */
    public void setPsnnamepinyin(java.lang.String psnnamepinyin) {
        this.psnnamepinyin = psnnamepinyin;
    }


    /**
     * Gets the def20 value for this Bd_psndocVO.
     * 
     * @return def20
     */
    public java.lang.String getDef20() {
        return def20;
    }


    /**
     * Sets the def20 value for this Bd_psndocVO.
     * 
     * @param def20
     */
    public void setDef20(java.lang.String def20) {
        this.def20 = def20;
    }


    /**
     * Gets the def4 value for this Bd_psndocVO.
     * 
     * @return def4
     */
    public java.lang.String getDef4() {
        return def4;
    }


    /**
     * Sets the def4 value for this Bd_psndocVO.
     * 
     * @param def4
     */
    public void setDef4(java.lang.String def4) {
        this.def4 = def4;
    }


    /**
     * Gets the def3 value for this Bd_psndocVO.
     * 
     * @return def3
     */
    public java.lang.String getDef3() {
        return def3;
    }


    /**
     * Sets the def3 value for this Bd_psndocVO.
     * 
     * @param def3
     */
    public void setDef3(java.lang.String def3) {
        this.def3 = def3;
    }


    /**
     * Gets the def2 value for this Bd_psndocVO.
     * 
     * @return def2
     */
    public java.lang.String getDef2() {
        return def2;
    }


    /**
     * Sets the def2 value for this Bd_psndocVO.
     * 
     * @param def2
     */
    public void setDef2(java.lang.String def2) {
        this.def2 = def2;
    }


    /**
     * Gets the def1 value for this Bd_psndocVO.
     * 
     * @return def1
     */
    public java.lang.String getDef1() {
        return def1;
    }


    /**
     * Sets the def1 value for this Bd_psndocVO.
     * 
     * @param def1
     */
    public void setDef1(java.lang.String def1) {
        this.def1 = def1;
    }


    /**
     * Gets the def12 value for this Bd_psndocVO.
     * 
     * @return def12
     */
    public java.lang.String getDef12() {
        return def12;
    }


    /**
     * Sets the def12 value for this Bd_psndocVO.
     * 
     * @param def12
     */
    public void setDef12(java.lang.String def12) {
        this.def12 = def12;
    }


    /**
     * Gets the series value for this Bd_psndocVO.
     * 
     * @return series
     */
    public java.lang.String getSeries() {
        return series;
    }


    /**
     * Sets the series value for this Bd_psndocVO.
     * 
     * @param series
     */
    public void setSeries(java.lang.String series) {
        this.series = series;
    }


    /**
     * Gets the def13 value for this Bd_psndocVO.
     * 
     * @return def13
     */
    public java.lang.String getDef13() {
        return def13;
    }


    /**
     * Sets the def13 value for this Bd_psndocVO.
     * 
     * @param def13
     */
    public void setDef13(java.lang.String def13) {
        this.def13 = def13;
    }


    /**
     * Gets the pk_psndoc value for this Bd_psndocVO.
     * 
     * @return pk_psndoc
     */
    public java.lang.String getPk_psndoc() {
        return pk_psndoc;
    }


    /**
     * Sets the pk_psndoc value for this Bd_psndocVO.
     * 
     * @param pk_psndoc
     */
    public void setPk_psndoc(java.lang.String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }


    /**
     * Gets the def10 value for this Bd_psndocVO.
     * 
     * @return def10
     */
    public java.lang.String getDef10() {
        return def10;
    }


    /**
     * Sets the def10 value for this Bd_psndocVO.
     * 
     * @param def10
     */
    public void setDef10(java.lang.String def10) {
        this.def10 = def10;
    }


    /**
     * Gets the psnclscope value for this Bd_psndocVO.
     * 
     * @return psnclscope
     */
    public java.lang.Long getPsnclscope() {
        return psnclscope;
    }


    /**
     * Sets the psnclscope value for this Bd_psndocVO.
     * 
     * @param psnclscope
     */
    public void setPsnclscope(java.lang.Long psnclscope) {
        this.psnclscope = psnclscope;
    }


    /**
     * Gets the def11 value for this Bd_psndocVO.
     * 
     * @return def11
     */
    public java.lang.String getDef11() {
        return def11;
    }


    /**
     * Sets the def11 value for this Bd_psndocVO.
     * 
     * @param def11
     */
    public void setDef11(java.lang.String def11) {
        this.def11 = def11;
    }


    /**
     * Gets the clerkcode value for this Bd_psndocVO.
     * 
     * @return clerkcode
     */
    public java.lang.String getClerkcode() {
        return clerkcode;
    }


    /**
     * Sets the clerkcode value for this Bd_psndocVO.
     * 
     * @param clerkcode
     */
    public void setClerkcode(java.lang.String clerkcode) {
        this.clerkcode = clerkcode;
    }


    /**
     * Gets the def18 value for this Bd_psndocVO.
     * 
     * @return def18
     */
    public java.lang.String getDef18() {
        return def18;
    }


    /**
     * Sets the def18 value for this Bd_psndocVO.
     * 
     * @param def18
     */
    public void setDef18(java.lang.String def18) {
        this.def18 = def18;
    }


    /**
     * Gets the def19 value for this Bd_psndocVO.
     * 
     * @return def19
     */
    public java.lang.String getDef19() {
        return def19;
    }


    /**
     * Sets the def19 value for this Bd_psndocVO.
     * 
     * @param def19
     */
    public void setDef19(java.lang.String def19) {
        this.def19 = def19;
    }


    /**
     * Gets the jobseries value for this Bd_psndocVO.
     * 
     * @return jobseries
     */
    public java.lang.String getJobseries() {
        return jobseries;
    }


    /**
     * Sets the jobseries value for this Bd_psndocVO.
     * 
     * @param jobseries
     */
    public void setJobseries(java.lang.String jobseries) {
        this.jobseries = jobseries;
    }


    /**
     * Gets the def16 value for this Bd_psndocVO.
     * 
     * @return def16
     */
    public java.lang.String getDef16() {
        return def16;
    }


    /**
     * Sets the def16 value for this Bd_psndocVO.
     * 
     * @param def16
     */
    public void setDef16(java.lang.String def16) {
        this.def16 = def16;
    }


    /**
     * Gets the def17 value for this Bd_psndocVO.
     * 
     * @return def17
     */
    public java.lang.String getDef17() {
        return def17;
    }


    /**
     * Sets the def17 value for this Bd_psndocVO.
     * 
     * @param def17
     */
    public void setDef17(java.lang.String def17) {
        this.def17 = def17;
    }


    /**
     * Gets the def14 value for this Bd_psndocVO.
     * 
     * @return def14
     */
    public java.lang.String getDef14() {
        return def14;
    }


    /**
     * Sets the def14 value for this Bd_psndocVO.
     * 
     * @param def14
     */
    public void setDef14(java.lang.String def14) {
        this.def14 = def14;
    }


    /**
     * Gets the sealdate value for this Bd_psndocVO.
     * 
     * @return sealdate
     */
    public java.lang.String getSealdate() {
        return sealdate;
    }


    /**
     * Sets the sealdate value for this Bd_psndocVO.
     * 
     * @param sealdate
     */
    public void setSealdate(java.lang.String sealdate) {
        this.sealdate = sealdate;
    }


    /**
     * Gets the creator value for this Bd_psndocVO.
     * 
     * @return creator
     */
    public java.lang.String getCreator() {
        return creator;
    }


    /**
     * Sets the creator value for this Bd_psndocVO.
     * 
     * @param creator
     */
    public void setCreator(java.lang.String creator) {
        this.creator = creator;
    }


    /**
     * Gets the def15 value for this Bd_psndocVO.
     * 
     * @return def15
     */
    public java.lang.String getDef15() {
        return def15;
    }


    /**
     * Sets the def15 value for this Bd_psndocVO.
     * 
     * @param def15
     */
    public void setDef15(java.lang.String def15) {
        this.def15 = def15;
    }


    /**
     * Gets the createtime value for this Bd_psndocVO.
     * 
     * @return createtime
     */
    public java.lang.String getCreatetime() {
        return createtime;
    }


    /**
     * Sets the createtime value for this Bd_psndocVO.
     * 
     * @param createtime
     */
    public void setCreatetime(java.lang.String createtime) {
        this.createtime = createtime;
    }


    /**
     * Gets the iscalovertime value for this Bd_psndocVO.
     * 
     * @return iscalovertime
     */
    public java.lang.String getIscalovertime() {
        return iscalovertime;
    }


    /**
     * Sets the iscalovertime value for this Bd_psndocVO.
     * 
     * @param iscalovertime
     */
    public void setIscalovertime(java.lang.String iscalovertime) {
        this.iscalovertime = iscalovertime;
    }


    /**
     * Gets the pk_clerkclass value for this Bd_psndocVO.
     * 
     * @return pk_clerkclass
     */
    public java.lang.String getPk_clerkclass() {
        return pk_clerkclass;
    }


    /**
     * Sets the pk_clerkclass value for this Bd_psndocVO.
     * 
     * @param pk_clerkclass
     */
    public void setPk_clerkclass(java.lang.String pk_clerkclass) {
        this.pk_clerkclass = pk_clerkclass;
    }


    /**
     * Gets the tableName value for this Bd_psndocVO.
     * 
     * @return tableName
     */
    public java.lang.String getTableName() {
        return tableName;
    }


    /**
     * Sets the tableName value for this Bd_psndocVO.
     * 
     * @param tableName
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }


    /**
     * Gets the onclassdate value for this Bd_psndocVO.
     * 
     * @return onclassdate
     */
    public java.lang.String getOnclassdate() {
        return onclassdate;
    }


    /**
     * Sets the onclassdate value for this Bd_psndocVO.
     * 
     * @param onclassdate
     */
    public void setOnclassdate(java.lang.String onclassdate) {
        this.onclassdate = onclassdate;
    }


    /**
     * Gets the clerkflag value for this Bd_psndocVO.
     * 
     * @return clerkflag
     */
    public java.lang.String getClerkflag() {
        return clerkflag;
    }


    /**
     * Sets the clerkflag value for this Bd_psndocVO.
     * 
     * @param clerkflag
     */
    public void setClerkflag(java.lang.String clerkflag) {
        this.clerkflag = clerkflag;
    }


    /**
     * Gets the showorder value for this Bd_psndocVO.
     * 
     * @return showorder
     */
    public java.lang.Long getShoworder() {
        return showorder;
    }


    /**
     * Sets the showorder value for this Bd_psndocVO.
     * 
     * @param showorder
     */
    public void setShoworder(java.lang.Long showorder) {
        this.showorder = showorder;
    }


    /**
     * Gets the amcode value for this Bd_psndocVO.
     * 
     * @return amcode
     */
    public java.lang.String getAmcode() {
        return amcode;
    }


    /**
     * Sets the amcode value for this Bd_psndocVO.
     * 
     * @param amcode
     */
    public void setAmcode(java.lang.String amcode) {
        this.amcode = amcode;
    }


    /**
     * Gets the outdutydate value for this Bd_psndocVO.
     * 
     * @return outdutydate
     */
    public java.lang.String getOutdutydate() {
        return outdutydate;
    }


    /**
     * Sets the outdutydate value for this Bd_psndocVO.
     * 
     * @param outdutydate
     */
    public void setOutdutydate(java.lang.String outdutydate) {
        this.outdutydate = outdutydate;
    }


    /**
     * Gets the isreferenced value for this Bd_psndocVO.
     * 
     * @return isreferenced
     */
    public java.lang.String getIsreferenced() {
        return isreferenced;
    }


    /**
     * Sets the isreferenced value for this Bd_psndocVO.
     * 
     * @param isreferenced
     */
    public void setIsreferenced(java.lang.String isreferenced) {
        this.isreferenced = isreferenced;
    }


    /**
     * Gets the dr value for this Bd_psndocVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Bd_psndocVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }


    /**
     * Gets the tbm_prop value for this Bd_psndocVO.
     * 
     * @return tbm_prop
     */
    public java.lang.Long getTbm_prop() {
        return tbm_prop;
    }


    /**
     * Sets the tbm_prop value for this Bd_psndocVO.
     * 
     * @param tbm_prop
     */
    public void setTbm_prop(java.lang.Long tbm_prop) {
        this.tbm_prop = tbm_prop;
    }


    /**
     * Gets the pk_corp value for this Bd_psndocVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Bd_psndocVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the regular value for this Bd_psndocVO.
     * 
     * @return regular
     */
    public java.lang.String getRegular() {
        return regular;
    }


    /**
     * Sets the regular value for this Bd_psndocVO.
     * 
     * @param regular
     */
    public void setRegular(java.lang.String regular) {
        this.regular = regular;
    }


    /**
     * Gets the psnname value for this Bd_psndocVO.
     * 
     * @return psnname
     */
    public java.lang.String getPsnname() {
        return psnname;
    }


    /**
     * Sets the psnname value for this Bd_psndocVO.
     * 
     * @param psnname
     */
    public void setPsnname(java.lang.String psnname) {
        this.psnname = psnname;
    }


    /**
     * Gets the pk_om_job value for this Bd_psndocVO.
     * 
     * @return pk_om_job
     */
    public java.lang.String getPk_om_job() {
        return pk_om_job;
    }


    /**
     * Sets the pk_om_job value for this Bd_psndocVO.
     * 
     * @param pk_om_job
     */
    public void setPk_om_job(java.lang.String pk_om_job) {
        this.pk_om_job = pk_om_job;
    }


    /**
     * Gets the recruitresource value for this Bd_psndocVO.
     * 
     * @return recruitresource
     */
    public java.lang.String getRecruitresource() {
        return recruitresource;
    }


    /**
     * Sets the recruitresource value for this Bd_psndocVO.
     * 
     * @param recruitresource
     */
    public void setRecruitresource(java.lang.String recruitresource) {
        this.recruitresource = recruitresource;
    }


    /**
     * Gets the hroperator value for this Bd_psndocVO.
     * 
     * @return hroperator
     */
    public java.lang.String getHroperator() {
        return hroperator;
    }


    /**
     * Sets the hroperator value for this Bd_psndocVO.
     * 
     * @param hroperator
     */
    public void setHroperator(java.lang.String hroperator) {
        this.hroperator = hroperator;
    }


    /**
     * Gets the groupdef6 value for this Bd_psndocVO.
     * 
     * @return groupdef6
     */
    public java.lang.String getGroupdef6() {
        return groupdef6;
    }


    /**
     * Sets the groupdef6 value for this Bd_psndocVO.
     * 
     * @param groupdef6
     */
    public void setGroupdef6(java.lang.String groupdef6) {
        this.groupdef6 = groupdef6;
    }


    /**
     * Gets the groupdef7 value for this Bd_psndocVO.
     * 
     * @return groupdef7
     */
    public java.lang.String getGroupdef7() {
        return groupdef7;
    }


    /**
     * Sets the groupdef7 value for this Bd_psndocVO.
     * 
     * @param groupdef7
     */
    public void setGroupdef7(java.lang.String groupdef7) {
        this.groupdef7 = groupdef7;
    }


    /**
     * Gets the groupdef8 value for this Bd_psndocVO.
     * 
     * @return groupdef8
     */
    public java.lang.String getGroupdef8() {
        return groupdef8;
    }


    /**
     * Sets the groupdef8 value for this Bd_psndocVO.
     * 
     * @param groupdef8
     */
    public void setGroupdef8(java.lang.String groupdef8) {
        this.groupdef8 = groupdef8;
    }


    /**
     * Gets the pk_psnbasdoc value for this Bd_psndocVO.
     * 
     * @return pk_psnbasdoc
     */
    public java.lang.String getPk_psnbasdoc() {
        return pk_psnbasdoc;
    }


    /**
     * Sets the pk_psnbasdoc value for this Bd_psndocVO.
     * 
     * @param pk_psnbasdoc
     */
    public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
        this.pk_psnbasdoc = pk_psnbasdoc;
    }


    /**
     * Gets the maxinnercode value for this Bd_psndocVO.
     * 
     * @return maxinnercode
     */
    public java.lang.String getMaxinnercode() {
        return maxinnercode;
    }


    /**
     * Sets the maxinnercode value for this Bd_psndocVO.
     * 
     * @param maxinnercode
     */
    public void setMaxinnercode(java.lang.String maxinnercode) {
        this.maxinnercode = maxinnercode;
    }


    /**
     * Gets the groupdef9 value for this Bd_psndocVO.
     * 
     * @return groupdef9
     */
    public java.lang.String getGroupdef9() {
        return groupdef9;
    }


    /**
     * Sets the groupdef9 value for this Bd_psndocVO.
     * 
     * @param groupdef9
     */
    public void setGroupdef9(java.lang.String groupdef9) {
        this.groupdef9 = groupdef9;
    }


    /**
     * Gets the modifytime value for this Bd_psndocVO.
     * 
     * @return modifytime
     */
    public java.lang.String getModifytime() {
        return modifytime;
    }


    /**
     * Sets the modifytime value for this Bd_psndocVO.
     * 
     * @param modifytime
     */
    public void setModifytime(java.lang.String modifytime) {
        this.modifytime = modifytime;
    }


    /**
     * Gets the groupdef3 value for this Bd_psndocVO.
     * 
     * @return groupdef3
     */
    public java.lang.String getGroupdef3() {
        return groupdef3;
    }


    /**
     * Sets the groupdef3 value for this Bd_psndocVO.
     * 
     * @param groupdef3
     */
    public void setGroupdef3(java.lang.String groupdef3) {
        this.groupdef3 = groupdef3;
    }


    /**
     * Gets the groupdef2 value for this Bd_psndocVO.
     * 
     * @return groupdef2
     */
    public java.lang.String getGroupdef2() {
        return groupdef2;
    }


    /**
     * Sets the groupdef2 value for this Bd_psndocVO.
     * 
     * @param groupdef2
     */
    public void setGroupdef2(java.lang.String groupdef2) {
        this.groupdef2 = groupdef2;
    }


    /**
     * Gets the groupdef5 value for this Bd_psndocVO.
     * 
     * @return groupdef5
     */
    public java.lang.String getGroupdef5() {
        return groupdef5;
    }


    /**
     * Sets the groupdef5 value for this Bd_psndocVO.
     * 
     * @param groupdef5
     */
    public void setGroupdef5(java.lang.String groupdef5) {
        this.groupdef5 = groupdef5;
    }


    /**
     * Gets the groupdef4 value for this Bd_psndocVO.
     * 
     * @return groupdef4
     */
    public java.lang.String getGroupdef4() {
        return groupdef4;
    }


    /**
     * Sets the groupdef4 value for this Bd_psndocVO.
     * 
     * @param groupdef4
     */
    public void setGroupdef4(java.lang.String groupdef4) {
        this.groupdef4 = groupdef4;
    }


    /**
     * Gets the onpostdate value for this Bd_psndocVO.
     * 
     * @return onpostdate
     */
    public java.lang.String getOnpostdate() {
        return onpostdate;
    }


    /**
     * Sets the onpostdate value for this Bd_psndocVO.
     * 
     * @param onpostdate
     */
    public void setOnpostdate(java.lang.String onpostdate) {
        this.onpostdate = onpostdate;
    }


    /**
     * Gets the groupdef1 value for this Bd_psndocVO.
     * 
     * @return groupdef1
     */
    public java.lang.String getGroupdef1() {
        return groupdef1;
    }


    /**
     * Sets the groupdef1 value for this Bd_psndocVO.
     * 
     * @param groupdef1
     */
    public void setGroupdef1(java.lang.String groupdef1) {
        this.groupdef1 = groupdef1;
    }


    /**
     * Gets the jobrank value for this Bd_psndocVO.
     * 
     * @return jobrank
     */
    public java.lang.String getJobrank() {
        return jobrank;
    }


    /**
     * Sets the jobrank value for this Bd_psndocVO.
     * 
     * @param jobrank
     */
    public void setJobrank(java.lang.String jobrank) {
        this.jobrank = jobrank;
    }


    /**
     * Gets the pk_deptdoc value for this Bd_psndocVO.
     * 
     * @return pk_deptdoc
     */
    public java.lang.String getPk_deptdoc() {
        return pk_deptdoc;
    }


    /**
     * Sets the pk_deptdoc value for this Bd_psndocVO.
     * 
     * @param pk_deptdoc
     */
    public void setPk_deptdoc(java.lang.String pk_deptdoc) {
        this.pk_deptdoc = pk_deptdoc;
    }


    /**
     * Gets the timecardid value for this Bd_psndocVO.
     * 
     * @return timecardid
     */
    public java.lang.String getTimecardid() {
        return timecardid;
    }


    /**
     * Sets the timecardid value for this Bd_psndocVO.
     * 
     * @param timecardid
     */
    public void setTimecardid(java.lang.String timecardid) {
        this.timecardid = timecardid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Bd_psndocVO)) return false;
        Bd_psndocVO other = (Bd_psndocVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
            ((this.groupdef11==null && other.getGroupdef11()==null) || 
             (this.groupdef11!=null &&
              this.groupdef11.equals(other.getGroupdef11()))) &&
            ((this.directleader==null && other.getDirectleader()==null) || 
             (this.directleader!=null &&
              this.directleader.equals(other.getDirectleader()))) &&
            ((this.groupdef12==null && other.getGroupdef12()==null) || 
             (this.groupdef12!=null &&
              this.groupdef12.equals(other.getGroupdef12()))) &&
            ((this.groupdef10==null && other.getGroupdef10()==null) || 
             (this.groupdef10!=null &&
              this.groupdef10.equals(other.getGroupdef10()))) &&
            ((this.groupdef15==null && other.getGroupdef15()==null) || 
             (this.groupdef15!=null &&
              this.groupdef15.equals(other.getGroupdef15()))) &&
            ((this.groupdef16==null && other.getGroupdef16()==null) || 
             (this.groupdef16!=null &&
              this.groupdef16.equals(other.getGroupdef16()))) &&
            ((this.groupdef13==null && other.getGroupdef13()==null) || 
             (this.groupdef13!=null &&
              this.groupdef13.equals(other.getGroupdef13()))) &&
            ((this.groupdef14==null && other.getGroupdef14()==null) || 
             (this.groupdef14!=null &&
              this.groupdef14.equals(other.getGroupdef14()))) &&
            ((this.groupdef19==null && other.getGroupdef19()==null) || 
             (this.groupdef19!=null &&
              this.groupdef19.equals(other.getGroupdef19()))) &&
            ((this.pk_psntype==null && other.getPk_psntype()==null) || 
             (this.pk_psntype!=null &&
              this.pk_psntype.equals(other.getPk_psntype()))) &&
            ((this.groupdef17==null && other.getGroupdef17()==null) || 
             (this.groupdef17!=null &&
              this.groupdef17.equals(other.getGroupdef17()))) &&
            ((this.groupdef18==null && other.getGroupdef18()==null) || 
             (this.groupdef18!=null &&
              this.groupdef18.equals(other.getGroupdef18()))) &&
            ((this.pk_psncl==null && other.getPk_psncl()==null) || 
             (this.pk_psncl!=null &&
              this.pk_psncl.equals(other.getPk_psncl()))) &&
            ((this.innercode==null && other.getInnercode()==null) || 
             (this.innercode!=null &&
              this.innercode.equals(other.getInnercode()))) &&
            ((this.regulardata==null && other.getRegulardata()==null) || 
             (this.regulardata!=null &&
              this.regulardata.equals(other.getRegulardata()))) &&
            ((this.psncode==null && other.getPsncode()==null) || 
             (this.psncode!=null &&
              this.psncode.equals(other.getPsncode()))) &&
            ((this.indutydate==null && other.getIndutydate()==null) || 
             (this.indutydate!=null &&
              this.indutydate.equals(other.getIndutydate()))) &&
            ((this.outmethod==null && other.getOutmethod()==null) || 
             (this.outmethod!=null &&
              this.outmethod.equals(other.getOutmethod()))) &&
            ((this.poststat==null && other.getPoststat()==null) || 
             (this.poststat!=null &&
              this.poststat.equals(other.getPoststat()))) &&
            ((this.def7==null && other.getDef7()==null) || 
             (this.def7!=null &&
              this.def7.equals(other.getDef7()))) &&
            ((this.def8==null && other.getDef8()==null) || 
             (this.def8!=null &&
              this.def8.equals(other.getDef8()))) &&
            ((this.def5==null && other.getDef5()==null) || 
             (this.def5!=null &&
              this.def5.equals(other.getDef5()))) &&
            ((this.def6==null && other.getDef6()==null) || 
             (this.def6!=null &&
              this.def6.equals(other.getDef6()))) &&
            ((this.groupdef20==null && other.getGroupdef20()==null) || 
             (this.groupdef20!=null &&
              this.groupdef20.equals(other.getGroupdef20()))) &&
            ((this.def9==null && other.getDef9()==null) || 
             (this.def9!=null &&
              this.def9.equals(other.getDef9()))) &&
            ((this.dutyname==null && other.getDutyname()==null) || 
             (this.dutyname!=null &&
              this.dutyname.equals(other.getDutyname()))) &&
            ((this.spike_sign==null && other.getSpike_sign()==null) || 
             (this.spike_sign!=null &&
              this.spike_sign.equals(other.getSpike_sign()))) &&
            ((this.insource==null && other.getInsource()==null) || 
             (this.insource!=null &&
              this.insource.equals(other.getInsource()))) &&
            ((this.indocflag==null && other.getIndocflag()==null) || 
             (this.indocflag!=null &&
              this.indocflag.equals(other.getIndocflag()))) &&
            ((this.pk_dutyrank==null && other.getPk_dutyrank()==null) || 
             (this.pk_dutyrank!=null &&
              this.pk_dutyrank.equals(other.getPk_dutyrank()))) &&
            ((this.isreturn==null && other.getIsreturn()==null) || 
             (this.isreturn!=null &&
              this.isreturn.equals(other.getIsreturn()))) &&
            ((this.modifier==null && other.getModifier()==null) || 
             (this.modifier!=null &&
              this.modifier.equals(other.getModifier()))) &&
            ((this.wastopdate==null && other.getWastopdate()==null) || 
             (this.wastopdate!=null &&
              this.wastopdate.equals(other.getWastopdate()))) &&
            ((this.years_score==null && other.getYears_score()==null) || 
             (this.years_score!=null &&
              this.years_score.equals(other.getYears_score()))) &&
            ((this.psnnamepinyin==null && other.getPsnnamepinyin()==null) || 
             (this.psnnamepinyin!=null &&
              this.psnnamepinyin.equals(other.getPsnnamepinyin()))) &&
            ((this.def20==null && other.getDef20()==null) || 
             (this.def20!=null &&
              this.def20.equals(other.getDef20()))) &&
            ((this.def4==null && other.getDef4()==null) || 
             (this.def4!=null &&
              this.def4.equals(other.getDef4()))) &&
            ((this.def3==null && other.getDef3()==null) || 
             (this.def3!=null &&
              this.def3.equals(other.getDef3()))) &&
            ((this.def2==null && other.getDef2()==null) || 
             (this.def2!=null &&
              this.def2.equals(other.getDef2()))) &&
            ((this.def1==null && other.getDef1()==null) || 
             (this.def1!=null &&
              this.def1.equals(other.getDef1()))) &&
            ((this.def12==null && other.getDef12()==null) || 
             (this.def12!=null &&
              this.def12.equals(other.getDef12()))) &&
            ((this.series==null && other.getSeries()==null) || 
             (this.series!=null &&
              this.series.equals(other.getSeries()))) &&
            ((this.def13==null && other.getDef13()==null) || 
             (this.def13!=null &&
              this.def13.equals(other.getDef13()))) &&
            ((this.pk_psndoc==null && other.getPk_psndoc()==null) || 
             (this.pk_psndoc!=null &&
              this.pk_psndoc.equals(other.getPk_psndoc()))) &&
            ((this.def10==null && other.getDef10()==null) || 
             (this.def10!=null &&
              this.def10.equals(other.getDef10()))) &&
            ((this.psnclscope==null && other.getPsnclscope()==null) || 
             (this.psnclscope!=null &&
              this.psnclscope.equals(other.getPsnclscope()))) &&
            ((this.def11==null && other.getDef11()==null) || 
             (this.def11!=null &&
              this.def11.equals(other.getDef11()))) &&
            ((this.clerkcode==null && other.getClerkcode()==null) || 
             (this.clerkcode!=null &&
              this.clerkcode.equals(other.getClerkcode()))) &&
            ((this.def18==null && other.getDef18()==null) || 
             (this.def18!=null &&
              this.def18.equals(other.getDef18()))) &&
            ((this.def19==null && other.getDef19()==null) || 
             (this.def19!=null &&
              this.def19.equals(other.getDef19()))) &&
            ((this.jobseries==null && other.getJobseries()==null) || 
             (this.jobseries!=null &&
              this.jobseries.equals(other.getJobseries()))) &&
            ((this.def16==null && other.getDef16()==null) || 
             (this.def16!=null &&
              this.def16.equals(other.getDef16()))) &&
            ((this.def17==null && other.getDef17()==null) || 
             (this.def17!=null &&
              this.def17.equals(other.getDef17()))) &&
            ((this.def14==null && other.getDef14()==null) || 
             (this.def14!=null &&
              this.def14.equals(other.getDef14()))) &&
            ((this.sealdate==null && other.getSealdate()==null) || 
             (this.sealdate!=null &&
              this.sealdate.equals(other.getSealdate()))) &&
            ((this.creator==null && other.getCreator()==null) || 
             (this.creator!=null &&
              this.creator.equals(other.getCreator()))) &&
            ((this.def15==null && other.getDef15()==null) || 
             (this.def15!=null &&
              this.def15.equals(other.getDef15()))) &&
            ((this.createtime==null && other.getCreatetime()==null) || 
             (this.createtime!=null &&
              this.createtime.equals(other.getCreatetime()))) &&
            ((this.iscalovertime==null && other.getIscalovertime()==null) || 
             (this.iscalovertime!=null &&
              this.iscalovertime.equals(other.getIscalovertime()))) &&
            ((this.pk_clerkclass==null && other.getPk_clerkclass()==null) || 
             (this.pk_clerkclass!=null &&
              this.pk_clerkclass.equals(other.getPk_clerkclass()))) &&
            ((this.tableName==null && other.getTableName()==null) || 
             (this.tableName!=null &&
              this.tableName.equals(other.getTableName()))) &&
            ((this.onclassdate==null && other.getOnclassdate()==null) || 
             (this.onclassdate!=null &&
              this.onclassdate.equals(other.getOnclassdate()))) &&
            ((this.clerkflag==null && other.getClerkflag()==null) || 
             (this.clerkflag!=null &&
              this.clerkflag.equals(other.getClerkflag()))) &&
            ((this.showorder==null && other.getShoworder()==null) || 
             (this.showorder!=null &&
              this.showorder.equals(other.getShoworder()))) &&
            ((this.amcode==null && other.getAmcode()==null) || 
             (this.amcode!=null &&
              this.amcode.equals(other.getAmcode()))) &&
            ((this.outdutydate==null && other.getOutdutydate()==null) || 
             (this.outdutydate!=null &&
              this.outdutydate.equals(other.getOutdutydate()))) &&
            ((this.isreferenced==null && other.getIsreferenced()==null) || 
             (this.isreferenced!=null &&
              this.isreferenced.equals(other.getIsreferenced()))) &&
            ((this.dr==null && other.getDr()==null) || 
             (this.dr!=null &&
              this.dr.equals(other.getDr()))) &&
            ((this.tbm_prop==null && other.getTbm_prop()==null) || 
             (this.tbm_prop!=null &&
              this.tbm_prop.equals(other.getTbm_prop()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.regular==null && other.getRegular()==null) || 
             (this.regular!=null &&
              this.regular.equals(other.getRegular()))) &&
            ((this.psnname==null && other.getPsnname()==null) || 
             (this.psnname!=null &&
              this.psnname.equals(other.getPsnname()))) &&
            ((this.pk_om_job==null && other.getPk_om_job()==null) || 
             (this.pk_om_job!=null &&
              this.pk_om_job.equals(other.getPk_om_job()))) &&
            ((this.recruitresource==null && other.getRecruitresource()==null) || 
             (this.recruitresource!=null &&
              this.recruitresource.equals(other.getRecruitresource()))) &&
            ((this.hroperator==null && other.getHroperator()==null) || 
             (this.hroperator!=null &&
              this.hroperator.equals(other.getHroperator()))) &&
            ((this.groupdef6==null && other.getGroupdef6()==null) || 
             (this.groupdef6!=null &&
              this.groupdef6.equals(other.getGroupdef6()))) &&
            ((this.groupdef7==null && other.getGroupdef7()==null) || 
             (this.groupdef7!=null &&
              this.groupdef7.equals(other.getGroupdef7()))) &&
            ((this.groupdef8==null && other.getGroupdef8()==null) || 
             (this.groupdef8!=null &&
              this.groupdef8.equals(other.getGroupdef8()))) &&
            ((this.pk_psnbasdoc==null && other.getPk_psnbasdoc()==null) || 
             (this.pk_psnbasdoc!=null &&
              this.pk_psnbasdoc.equals(other.getPk_psnbasdoc()))) &&
            ((this.maxinnercode==null && other.getMaxinnercode()==null) || 
             (this.maxinnercode!=null &&
              this.maxinnercode.equals(other.getMaxinnercode()))) &&
            ((this.groupdef9==null && other.getGroupdef9()==null) || 
             (this.groupdef9!=null &&
              this.groupdef9.equals(other.getGroupdef9()))) &&
            ((this.modifytime==null && other.getModifytime()==null) || 
             (this.modifytime!=null &&
              this.modifytime.equals(other.getModifytime()))) &&
            ((this.groupdef3==null && other.getGroupdef3()==null) || 
             (this.groupdef3!=null &&
              this.groupdef3.equals(other.getGroupdef3()))) &&
            ((this.groupdef2==null && other.getGroupdef2()==null) || 
             (this.groupdef2!=null &&
              this.groupdef2.equals(other.getGroupdef2()))) &&
            ((this.groupdef5==null && other.getGroupdef5()==null) || 
             (this.groupdef5!=null &&
              this.groupdef5.equals(other.getGroupdef5()))) &&
            ((this.groupdef4==null && other.getGroupdef4()==null) || 
             (this.groupdef4!=null &&
              this.groupdef4.equals(other.getGroupdef4()))) &&
            ((this.onpostdate==null && other.getOnpostdate()==null) || 
             (this.onpostdate!=null &&
              this.onpostdate.equals(other.getOnpostdate()))) &&
            ((this.groupdef1==null && other.getGroupdef1()==null) || 
             (this.groupdef1!=null &&
              this.groupdef1.equals(other.getGroupdef1()))) &&
            ((this.jobrank==null && other.getJobrank()==null) || 
             (this.jobrank!=null &&
              this.jobrank.equals(other.getJobrank()))) &&
            ((this.pk_deptdoc==null && other.getPk_deptdoc()==null) || 
             (this.pk_deptdoc!=null &&
              this.pk_deptdoc.equals(other.getPk_deptdoc()))) &&
            ((this.timecardid==null && other.getTimecardid()==null) || 
             (this.timecardid!=null &&
              this.timecardid.equals(other.getTimecardid())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getGroupdef11() != null) {
            _hashCode += getGroupdef11().hashCode();
        }
        if (getDirectleader() != null) {
            _hashCode += getDirectleader().hashCode();
        }
        if (getGroupdef12() != null) {
            _hashCode += getGroupdef12().hashCode();
        }
        if (getGroupdef10() != null) {
            _hashCode += getGroupdef10().hashCode();
        }
        if (getGroupdef15() != null) {
            _hashCode += getGroupdef15().hashCode();
        }
        if (getGroupdef16() != null) {
            _hashCode += getGroupdef16().hashCode();
        }
        if (getGroupdef13() != null) {
            _hashCode += getGroupdef13().hashCode();
        }
        if (getGroupdef14() != null) {
            _hashCode += getGroupdef14().hashCode();
        }
        if (getGroupdef19() != null) {
            _hashCode += getGroupdef19().hashCode();
        }
        if (getPk_psntype() != null) {
            _hashCode += getPk_psntype().hashCode();
        }
        if (getGroupdef17() != null) {
            _hashCode += getGroupdef17().hashCode();
        }
        if (getGroupdef18() != null) {
            _hashCode += getGroupdef18().hashCode();
        }
        if (getPk_psncl() != null) {
            _hashCode += getPk_psncl().hashCode();
        }
        if (getInnercode() != null) {
            _hashCode += getInnercode().hashCode();
        }
        if (getRegulardata() != null) {
            _hashCode += getRegulardata().hashCode();
        }
        if (getPsncode() != null) {
            _hashCode += getPsncode().hashCode();
        }
        if (getIndutydate() != null) {
            _hashCode += getIndutydate().hashCode();
        }
        if (getOutmethod() != null) {
            _hashCode += getOutmethod().hashCode();
        }
        if (getPoststat() != null) {
            _hashCode += getPoststat().hashCode();
        }
        if (getDef7() != null) {
            _hashCode += getDef7().hashCode();
        }
        if (getDef8() != null) {
            _hashCode += getDef8().hashCode();
        }
        if (getDef5() != null) {
            _hashCode += getDef5().hashCode();
        }
        if (getDef6() != null) {
            _hashCode += getDef6().hashCode();
        }
        if (getGroupdef20() != null) {
            _hashCode += getGroupdef20().hashCode();
        }
        if (getDef9() != null) {
            _hashCode += getDef9().hashCode();
        }
        if (getDutyname() != null) {
            _hashCode += getDutyname().hashCode();
        }
        if (getSpike_sign() != null) {
            _hashCode += getSpike_sign().hashCode();
        }
        if (getInsource() != null) {
            _hashCode += getInsource().hashCode();
        }
        if (getIndocflag() != null) {
            _hashCode += getIndocflag().hashCode();
        }
        if (getPk_dutyrank() != null) {
            _hashCode += getPk_dutyrank().hashCode();
        }
        if (getIsreturn() != null) {
            _hashCode += getIsreturn().hashCode();
        }
        if (getModifier() != null) {
            _hashCode += getModifier().hashCode();
        }
        if (getWastopdate() != null) {
            _hashCode += getWastopdate().hashCode();
        }
        if (getYears_score() != null) {
            _hashCode += getYears_score().hashCode();
        }
        if (getPsnnamepinyin() != null) {
            _hashCode += getPsnnamepinyin().hashCode();
        }
        if (getDef20() != null) {
            _hashCode += getDef20().hashCode();
        }
        if (getDef4() != null) {
            _hashCode += getDef4().hashCode();
        }
        if (getDef3() != null) {
            _hashCode += getDef3().hashCode();
        }
        if (getDef2() != null) {
            _hashCode += getDef2().hashCode();
        }
        if (getDef1() != null) {
            _hashCode += getDef1().hashCode();
        }
        if (getDef12() != null) {
            _hashCode += getDef12().hashCode();
        }
        if (getSeries() != null) {
            _hashCode += getSeries().hashCode();
        }
        if (getDef13() != null) {
            _hashCode += getDef13().hashCode();
        }
        if (getPk_psndoc() != null) {
            _hashCode += getPk_psndoc().hashCode();
        }
        if (getDef10() != null) {
            _hashCode += getDef10().hashCode();
        }
        if (getPsnclscope() != null) {
            _hashCode += getPsnclscope().hashCode();
        }
        if (getDef11() != null) {
            _hashCode += getDef11().hashCode();
        }
        if (getClerkcode() != null) {
            _hashCode += getClerkcode().hashCode();
        }
        if (getDef18() != null) {
            _hashCode += getDef18().hashCode();
        }
        if (getDef19() != null) {
            _hashCode += getDef19().hashCode();
        }
        if (getJobseries() != null) {
            _hashCode += getJobseries().hashCode();
        }
        if (getDef16() != null) {
            _hashCode += getDef16().hashCode();
        }
        if (getDef17() != null) {
            _hashCode += getDef17().hashCode();
        }
        if (getDef14() != null) {
            _hashCode += getDef14().hashCode();
        }
        if (getSealdate() != null) {
            _hashCode += getSealdate().hashCode();
        }
        if (getCreator() != null) {
            _hashCode += getCreator().hashCode();
        }
        if (getDef15() != null) {
            _hashCode += getDef15().hashCode();
        }
        if (getCreatetime() != null) {
            _hashCode += getCreatetime().hashCode();
        }
        if (getIscalovertime() != null) {
            _hashCode += getIscalovertime().hashCode();
        }
        if (getPk_clerkclass() != null) {
            _hashCode += getPk_clerkclass().hashCode();
        }
        if (getTableName() != null) {
            _hashCode += getTableName().hashCode();
        }
        if (getOnclassdate() != null) {
            _hashCode += getOnclassdate().hashCode();
        }
        if (getClerkflag() != null) {
            _hashCode += getClerkflag().hashCode();
        }
        if (getShoworder() != null) {
            _hashCode += getShoworder().hashCode();
        }
        if (getAmcode() != null) {
            _hashCode += getAmcode().hashCode();
        }
        if (getOutdutydate() != null) {
            _hashCode += getOutdutydate().hashCode();
        }
        if (getIsreferenced() != null) {
            _hashCode += getIsreferenced().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        if (getTbm_prop() != null) {
            _hashCode += getTbm_prop().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getRegular() != null) {
            _hashCode += getRegular().hashCode();
        }
        if (getPsnname() != null) {
            _hashCode += getPsnname().hashCode();
        }
        if (getPk_om_job() != null) {
            _hashCode += getPk_om_job().hashCode();
        }
        if (getRecruitresource() != null) {
            _hashCode += getRecruitresource().hashCode();
        }
        if (getHroperator() != null) {
            _hashCode += getHroperator().hashCode();
        }
        if (getGroupdef6() != null) {
            _hashCode += getGroupdef6().hashCode();
        }
        if (getGroupdef7() != null) {
            _hashCode += getGroupdef7().hashCode();
        }
        if (getGroupdef8() != null) {
            _hashCode += getGroupdef8().hashCode();
        }
        if (getPk_psnbasdoc() != null) {
            _hashCode += getPk_psnbasdoc().hashCode();
        }
        if (getMaxinnercode() != null) {
            _hashCode += getMaxinnercode().hashCode();
        }
        if (getGroupdef9() != null) {
            _hashCode += getGroupdef9().hashCode();
        }
        if (getModifytime() != null) {
            _hashCode += getModifytime().hashCode();
        }
        if (getGroupdef3() != null) {
            _hashCode += getGroupdef3().hashCode();
        }
        if (getGroupdef2() != null) {
            _hashCode += getGroupdef2().hashCode();
        }
        if (getGroupdef5() != null) {
            _hashCode += getGroupdef5().hashCode();
        }
        if (getGroupdef4() != null) {
            _hashCode += getGroupdef4().hashCode();
        }
        if (getOnpostdate() != null) {
            _hashCode += getOnpostdate().hashCode();
        }
        if (getGroupdef1() != null) {
            _hashCode += getGroupdef1().hashCode();
        }
        if (getJobrank() != null) {
            _hashCode += getJobrank().hashCode();
        }
        if (getPk_deptdoc() != null) {
            _hashCode += getPk_deptdoc().hashCode();
        }
        if (getTimecardid() != null) {
            _hashCode += getTimecardid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Bd_psndocVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://bd.vo.ws.nc/Bd_psndocVO", "Bd_psndocVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef11");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef11"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("directleader");
        elemField.setXmlName(new javax.xml.namespace.QName("", "directleader"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef12");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef12"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef10");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef10"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef15");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef15"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef16");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef16"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef13");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef13"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef14");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef14"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef19");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef19"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_psntype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_psntype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef17");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef17"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef18");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef18"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_psncl");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_psncl"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("innercode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "innercode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regulardata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regulardata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psncode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psncode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indutydate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indutydate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outmethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outmethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("poststat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "poststat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef20");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef20"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dutyname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dutyname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("spike_sign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spike_sign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("insource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "insource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("indocflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "indocflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_dutyrank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_dutyrank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isreturn");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isreturn"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifier");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wastopdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wastopdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("years_score");
        elemField.setXmlName(new javax.xml.namespace.QName("", "years_score"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnnamepinyin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnnamepinyin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def20");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def20"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def12");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def12"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("series");
        elemField.setXmlName(new javax.xml.namespace.QName("", "series"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def13");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def13"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_psndoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_psndoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def10");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def10"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnclscope");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnclscope"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def11");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def11"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clerkcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clerkcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def18");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def18"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def19");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def19"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobseries");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobseries"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def16");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def16"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def17");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def17"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def14");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def14"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sealdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sealdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("def15");
        elemField.setXmlName(new javax.xml.namespace.QName("", "def15"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("iscalovertime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "iscalovertime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_clerkclass");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_clerkclass"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tableName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tableName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onclassdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onclassdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clerkflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clerkflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("showorder");
        elemField.setXmlName(new javax.xml.namespace.QName("", "showorder"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "amcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outdutydate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outdutydate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isreferenced");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isreferenced"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tbm_prop");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tbm_prop"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_corp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_corp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("regular");
        elemField.setXmlName(new javax.xml.namespace.QName("", "regular"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_om_job");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_om_job"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recruitresource");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recruitresource"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("hroperator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "hroperator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_psnbasdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_psnbasdoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maxinnercode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "maxinnercode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modifytime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modifytime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("onpostdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "onpostdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobrank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobrank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_deptdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_deptdoc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("timecardid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "timecardid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}

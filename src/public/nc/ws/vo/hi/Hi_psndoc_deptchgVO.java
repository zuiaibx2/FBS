/**
 * Hi_psndoc_deptchgVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.hi;

public class Hi_psndoc_deptchgVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String avicstring30;

    private java.lang.String ts;

    private java.lang.String groupdef10;

    private java.lang.String choldreason;

    private java.lang.String pk_psncl;

    private java.lang.String preparetype;

    private java.lang.Long jobtype;

    private java.lang.String pk_psndoc_sub;

    private java.lang.String avicstring29;

    private java.lang.String avicstring28;

    private java.lang.String avicstring27;

    private java.lang.String avicstring26;

    private java.lang.String avicstring25;

    private java.lang.String avicstring24;

    private java.lang.String avicstring23;

    private java.lang.String avicstring22;

    private java.lang.String poststat;

    private java.lang.String avicstring20;

    private java.lang.String avicstring21;

    private java.lang.String posttype;

    private java.lang.String bendflag;

    private java.lang.String preparereason;

    private java.lang.String spike_sign;

    private java.lang.String pk_detytype;

    private java.lang.String period;

    private java.lang.String pk_dutyrank;

    private java.lang.String avicstring1;

    private java.lang.String isreturn;

    private java.lang.String avicstring3;

    private java.lang.String deposetype;

    private java.lang.String avicstring2;

    private java.lang.String avicstring5;

    private java.lang.String avicstring19;

    private java.lang.String avicstring4;

    private java.lang.String avicstring7;

    private java.lang.String avicstring6;

    private java.lang.String corpdef10;

    private java.lang.String avicstring16;

    private java.lang.String avicstring9;

    private java.lang.String avicstring15;

    private java.lang.String avicstring8;

    private java.lang.String avicstring18;

    private java.lang.String avicstring17;

    private java.lang.String avicstring12;

    private java.lang.String pk_jobserial;

    private java.lang.String begindate;

    private java.lang.String enddate;

    private java.lang.String avicstring11;

    private java.lang.String preparenote;

    private java.lang.String avicstring14;

    private java.lang.String avicstring13;

    private java.lang.String pk_psndoc;

    private java.lang.String memo;

    private java.lang.String iscalovertime;

    private java.lang.String avicdef1;

    private java.lang.String tableName;

    private java.lang.String approveflag;

    private java.lang.String avicstring10;

    private java.lang.Integer dr;

    private java.lang.Long tbm_prop;

    private java.lang.String pk_jobrank;

    private java.lang.String pk_corp;

    private java.lang.String pk_postdoc;

    private java.lang.String hroperator;

    private java.lang.String groupdef6;

    private java.lang.String groupdef7;

    private java.lang.String groupdef8;

    private java.lang.String pk_psnbasdoc;

    private java.lang.String groupdef9;

    private java.lang.String lastflag;

    private java.lang.String groupdef3;

    private java.lang.String deposereason;

    private java.lang.String groupdef2;

    private java.lang.String groupdef5;

    private java.lang.String pk_om_duty;

    private java.lang.String groupdef4;

    private java.lang.Long recordnum;

    private java.lang.String groupdef1;

    private java.lang.String corpdef2;

    private java.lang.String corpdef1;

    private java.lang.String corpdef4;

    private java.lang.String corpdef3;

    private java.lang.String corpdef6;

    private java.lang.String corpdef5;

    private java.lang.String pk_deptdoc;

    private java.lang.String corpdef8;

    private java.lang.String corpdef7;

    private java.lang.String timecardid;

    private java.lang.String corpdef9;

    public Hi_psndoc_deptchgVO() {
    }

    public Hi_psndoc_deptchgVO(
           java.lang.String avicstring30,
           java.lang.String ts,
           java.lang.String groupdef10,
           java.lang.String choldreason,
           java.lang.String pk_psncl,
           java.lang.String preparetype,
           java.lang.Long jobtype,
           java.lang.String pk_psndoc_sub,
           java.lang.String avicstring29,
           java.lang.String avicstring28,
           java.lang.String avicstring27,
           java.lang.String avicstring26,
           java.lang.String avicstring25,
           java.lang.String avicstring24,
           java.lang.String avicstring23,
           java.lang.String avicstring22,
           java.lang.String poststat,
           java.lang.String avicstring20,
           java.lang.String avicstring21,
           java.lang.String posttype,
           java.lang.String bendflag,
           java.lang.String preparereason,
           java.lang.String spike_sign,
           java.lang.String pk_detytype,
           java.lang.String period,
           java.lang.String pk_dutyrank,
           java.lang.String avicstring1,
           java.lang.String isreturn,
           java.lang.String avicstring3,
           java.lang.String deposetype,
           java.lang.String avicstring2,
           java.lang.String avicstring5,
           java.lang.String avicstring19,
           java.lang.String avicstring4,
           java.lang.String avicstring7,
           java.lang.String avicstring6,
           java.lang.String corpdef10,
           java.lang.String avicstring16,
           java.lang.String avicstring9,
           java.lang.String avicstring15,
           java.lang.String avicstring8,
           java.lang.String avicstring18,
           java.lang.String avicstring17,
           java.lang.String avicstring12,
           java.lang.String pk_jobserial,
           java.lang.String begindate,
           java.lang.String enddate,
           java.lang.String avicstring11,
           java.lang.String preparenote,
           java.lang.String avicstring14,
           java.lang.String avicstring13,
           java.lang.String pk_psndoc,
           java.lang.String memo,
           java.lang.String iscalovertime,
           java.lang.String avicdef1,
           java.lang.String tableName,
           java.lang.String approveflag,
           java.lang.String avicstring10,
           java.lang.Integer dr,
           java.lang.Long tbm_prop,
           java.lang.String pk_jobrank,
           java.lang.String pk_corp,
           java.lang.String pk_postdoc,
           java.lang.String hroperator,
           java.lang.String groupdef6,
           java.lang.String groupdef7,
           java.lang.String groupdef8,
           java.lang.String pk_psnbasdoc,
           java.lang.String groupdef9,
           java.lang.String lastflag,
           java.lang.String groupdef3,
           java.lang.String deposereason,
           java.lang.String groupdef2,
           java.lang.String groupdef5,
           java.lang.String pk_om_duty,
           java.lang.String groupdef4,
           java.lang.Long recordnum,
           java.lang.String groupdef1,
           java.lang.String corpdef2,
           java.lang.String corpdef1,
           java.lang.String corpdef4,
           java.lang.String corpdef3,
           java.lang.String corpdef6,
           java.lang.String corpdef5,
           java.lang.String pk_deptdoc,
           java.lang.String corpdef8,
           java.lang.String corpdef7,
           java.lang.String timecardid,
           java.lang.String corpdef9) {
           this.avicstring30 = avicstring30;
           this.ts = ts;
           this.groupdef10 = groupdef10;
           this.choldreason = choldreason;
           this.pk_psncl = pk_psncl;
           this.preparetype = preparetype;
           this.jobtype = jobtype;
           this.pk_psndoc_sub = pk_psndoc_sub;
           this.avicstring29 = avicstring29;
           this.avicstring28 = avicstring28;
           this.avicstring27 = avicstring27;
           this.avicstring26 = avicstring26;
           this.avicstring25 = avicstring25;
           this.avicstring24 = avicstring24;
           this.avicstring23 = avicstring23;
           this.avicstring22 = avicstring22;
           this.poststat = poststat;
           this.avicstring20 = avicstring20;
           this.avicstring21 = avicstring21;
           this.posttype = posttype;
           this.bendflag = bendflag;
           this.preparereason = preparereason;
           this.spike_sign = spike_sign;
           this.pk_detytype = pk_detytype;
           this.period = period;
           this.pk_dutyrank = pk_dutyrank;
           this.avicstring1 = avicstring1;
           this.isreturn = isreturn;
           this.avicstring3 = avicstring3;
           this.deposetype = deposetype;
           this.avicstring2 = avicstring2;
           this.avicstring5 = avicstring5;
           this.avicstring19 = avicstring19;
           this.avicstring4 = avicstring4;
           this.avicstring7 = avicstring7;
           this.avicstring6 = avicstring6;
           this.corpdef10 = corpdef10;
           this.avicstring16 = avicstring16;
           this.avicstring9 = avicstring9;
           this.avicstring15 = avicstring15;
           this.avicstring8 = avicstring8;
           this.avicstring18 = avicstring18;
           this.avicstring17 = avicstring17;
           this.avicstring12 = avicstring12;
           this.pk_jobserial = pk_jobserial;
           this.begindate = begindate;
           this.enddate = enddate;
           this.avicstring11 = avicstring11;
           this.preparenote = preparenote;
           this.avicstring14 = avicstring14;
           this.avicstring13 = avicstring13;
           this.pk_psndoc = pk_psndoc;
           this.memo = memo;
           this.iscalovertime = iscalovertime;
           this.avicdef1 = avicdef1;
           this.tableName = tableName;
           this.approveflag = approveflag;
           this.avicstring10 = avicstring10;
           this.dr = dr;
           this.tbm_prop = tbm_prop;
           this.pk_jobrank = pk_jobrank;
           this.pk_corp = pk_corp;
           this.pk_postdoc = pk_postdoc;
           this.hroperator = hroperator;
           this.groupdef6 = groupdef6;
           this.groupdef7 = groupdef7;
           this.groupdef8 = groupdef8;
           this.pk_psnbasdoc = pk_psnbasdoc;
           this.groupdef9 = groupdef9;
           this.lastflag = lastflag;
           this.groupdef3 = groupdef3;
           this.deposereason = deposereason;
           this.groupdef2 = groupdef2;
           this.groupdef5 = groupdef5;
           this.pk_om_duty = pk_om_duty;
           this.groupdef4 = groupdef4;
           this.recordnum = recordnum;
           this.groupdef1 = groupdef1;
           this.corpdef2 = corpdef2;
           this.corpdef1 = corpdef1;
           this.corpdef4 = corpdef4;
           this.corpdef3 = corpdef3;
           this.corpdef6 = corpdef6;
           this.corpdef5 = corpdef5;
           this.pk_deptdoc = pk_deptdoc;
           this.corpdef8 = corpdef8;
           this.corpdef7 = corpdef7;
           this.timecardid = timecardid;
           this.corpdef9 = corpdef9;
    }


    /**
     * Gets the avicstring30 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring30
     */
    public java.lang.String getAvicstring30() {
        return avicstring30;
    }


    /**
     * Sets the avicstring30 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring30
     */
    public void setAvicstring30(java.lang.String avicstring30) {
        this.avicstring30 = avicstring30;
    }


    /**
     * Gets the ts value for this Hi_psndoc_deptchgVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Hi_psndoc_deptchgVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the groupdef10 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef10
     */
    public java.lang.String getGroupdef10() {
        return groupdef10;
    }


    /**
     * Sets the groupdef10 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef10
     */
    public void setGroupdef10(java.lang.String groupdef10) {
        this.groupdef10 = groupdef10;
    }


    /**
     * Gets the choldreason value for this Hi_psndoc_deptchgVO.
     * 
     * @return choldreason
     */
    public java.lang.String getCholdreason() {
        return choldreason;
    }


    /**
     * Sets the choldreason value for this Hi_psndoc_deptchgVO.
     * 
     * @param choldreason
     */
    public void setCholdreason(java.lang.String choldreason) {
        this.choldreason = choldreason;
    }


    /**
     * Gets the pk_psncl value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_psncl
     */
    public java.lang.String getPk_psncl() {
        return pk_psncl;
    }


    /**
     * Sets the pk_psncl value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_psncl
     */
    public void setPk_psncl(java.lang.String pk_psncl) {
        this.pk_psncl = pk_psncl;
    }


    /**
     * Gets the preparetype value for this Hi_psndoc_deptchgVO.
     * 
     * @return preparetype
     */
    public java.lang.String getPreparetype() {
        return preparetype;
    }


    /**
     * Sets the preparetype value for this Hi_psndoc_deptchgVO.
     * 
     * @param preparetype
     */
    public void setPreparetype(java.lang.String preparetype) {
        this.preparetype = preparetype;
    }


    /**
     * Gets the jobtype value for this Hi_psndoc_deptchgVO.
     * 
     * @return jobtype
     */
    public java.lang.Long getJobtype() {
        return jobtype;
    }


    /**
     * Sets the jobtype value for this Hi_psndoc_deptchgVO.
     * 
     * @param jobtype
     */
    public void setJobtype(java.lang.Long jobtype) {
        this.jobtype = jobtype;
    }


    /**
     * Gets the pk_psndoc_sub value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_psndoc_sub
     */
    public java.lang.String getPk_psndoc_sub() {
        return pk_psndoc_sub;
    }


    /**
     * Sets the pk_psndoc_sub value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_psndoc_sub
     */
    public void setPk_psndoc_sub(java.lang.String pk_psndoc_sub) {
        this.pk_psndoc_sub = pk_psndoc_sub;
    }


    /**
     * Gets the avicstring29 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring29
     */
    public java.lang.String getAvicstring29() {
        return avicstring29;
    }


    /**
     * Sets the avicstring29 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring29
     */
    public void setAvicstring29(java.lang.String avicstring29) {
        this.avicstring29 = avicstring29;
    }


    /**
     * Gets the avicstring28 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring28
     */
    public java.lang.String getAvicstring28() {
        return avicstring28;
    }


    /**
     * Sets the avicstring28 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring28
     */
    public void setAvicstring28(java.lang.String avicstring28) {
        this.avicstring28 = avicstring28;
    }


    /**
     * Gets the avicstring27 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring27
     */
    public java.lang.String getAvicstring27() {
        return avicstring27;
    }


    /**
     * Sets the avicstring27 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring27
     */
    public void setAvicstring27(java.lang.String avicstring27) {
        this.avicstring27 = avicstring27;
    }


    /**
     * Gets the avicstring26 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring26
     */
    public java.lang.String getAvicstring26() {
        return avicstring26;
    }


    /**
     * Sets the avicstring26 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring26
     */
    public void setAvicstring26(java.lang.String avicstring26) {
        this.avicstring26 = avicstring26;
    }


    /**
     * Gets the avicstring25 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring25
     */
    public java.lang.String getAvicstring25() {
        return avicstring25;
    }


    /**
     * Sets the avicstring25 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring25
     */
    public void setAvicstring25(java.lang.String avicstring25) {
        this.avicstring25 = avicstring25;
    }


    /**
     * Gets the avicstring24 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring24
     */
    public java.lang.String getAvicstring24() {
        return avicstring24;
    }


    /**
     * Sets the avicstring24 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring24
     */
    public void setAvicstring24(java.lang.String avicstring24) {
        this.avicstring24 = avicstring24;
    }


    /**
     * Gets the avicstring23 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring23
     */
    public java.lang.String getAvicstring23() {
        return avicstring23;
    }


    /**
     * Sets the avicstring23 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring23
     */
    public void setAvicstring23(java.lang.String avicstring23) {
        this.avicstring23 = avicstring23;
    }


    /**
     * Gets the avicstring22 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring22
     */
    public java.lang.String getAvicstring22() {
        return avicstring22;
    }


    /**
     * Sets the avicstring22 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring22
     */
    public void setAvicstring22(java.lang.String avicstring22) {
        this.avicstring22 = avicstring22;
    }


    /**
     * Gets the poststat value for this Hi_psndoc_deptchgVO.
     * 
     * @return poststat
     */
    public java.lang.String getPoststat() {
        return poststat;
    }


    /**
     * Sets the poststat value for this Hi_psndoc_deptchgVO.
     * 
     * @param poststat
     */
    public void setPoststat(java.lang.String poststat) {
        this.poststat = poststat;
    }


    /**
     * Gets the avicstring20 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring20
     */
    public java.lang.String getAvicstring20() {
        return avicstring20;
    }


    /**
     * Sets the avicstring20 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring20
     */
    public void setAvicstring20(java.lang.String avicstring20) {
        this.avicstring20 = avicstring20;
    }


    /**
     * Gets the avicstring21 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring21
     */
    public java.lang.String getAvicstring21() {
        return avicstring21;
    }


    /**
     * Sets the avicstring21 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring21
     */
    public void setAvicstring21(java.lang.String avicstring21) {
        this.avicstring21 = avicstring21;
    }


    /**
     * Gets the posttype value for this Hi_psndoc_deptchgVO.
     * 
     * @return posttype
     */
    public java.lang.String getPosttype() {
        return posttype;
    }


    /**
     * Sets the posttype value for this Hi_psndoc_deptchgVO.
     * 
     * @param posttype
     */
    public void setPosttype(java.lang.String posttype) {
        this.posttype = posttype;
    }


    /**
     * Gets the bendflag value for this Hi_psndoc_deptchgVO.
     * 
     * @return bendflag
     */
    public java.lang.String getBendflag() {
        return bendflag;
    }


    /**
     * Sets the bendflag value for this Hi_psndoc_deptchgVO.
     * 
     * @param bendflag
     */
    public void setBendflag(java.lang.String bendflag) {
        this.bendflag = bendflag;
    }


    /**
     * Gets the preparereason value for this Hi_psndoc_deptchgVO.
     * 
     * @return preparereason
     */
    public java.lang.String getPreparereason() {
        return preparereason;
    }


    /**
     * Sets the preparereason value for this Hi_psndoc_deptchgVO.
     * 
     * @param preparereason
     */
    public void setPreparereason(java.lang.String preparereason) {
        this.preparereason = preparereason;
    }


    /**
     * Gets the spike_sign value for this Hi_psndoc_deptchgVO.
     * 
     * @return spike_sign
     */
    public java.lang.String getSpike_sign() {
        return spike_sign;
    }


    /**
     * Sets the spike_sign value for this Hi_psndoc_deptchgVO.
     * 
     * @param spike_sign
     */
    public void setSpike_sign(java.lang.String spike_sign) {
        this.spike_sign = spike_sign;
    }


    /**
     * Gets the pk_detytype value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_detytype
     */
    public java.lang.String getPk_detytype() {
        return pk_detytype;
    }


    /**
     * Sets the pk_detytype value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_detytype
     */
    public void setPk_detytype(java.lang.String pk_detytype) {
        this.pk_detytype = pk_detytype;
    }


    /**
     * Gets the period value for this Hi_psndoc_deptchgVO.
     * 
     * @return period
     */
    public java.lang.String getPeriod() {
        return period;
    }


    /**
     * Sets the period value for this Hi_psndoc_deptchgVO.
     * 
     * @param period
     */
    public void setPeriod(java.lang.String period) {
        this.period = period;
    }


    /**
     * Gets the pk_dutyrank value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_dutyrank
     */
    public java.lang.String getPk_dutyrank() {
        return pk_dutyrank;
    }


    /**
     * Sets the pk_dutyrank value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_dutyrank
     */
    public void setPk_dutyrank(java.lang.String pk_dutyrank) {
        this.pk_dutyrank = pk_dutyrank;
    }


    /**
     * Gets the avicstring1 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring1
     */
    public java.lang.String getAvicstring1() {
        return avicstring1;
    }


    /**
     * Sets the avicstring1 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring1
     */
    public void setAvicstring1(java.lang.String avicstring1) {
        this.avicstring1 = avicstring1;
    }


    /**
     * Gets the isreturn value for this Hi_psndoc_deptchgVO.
     * 
     * @return isreturn
     */
    public java.lang.String getIsreturn() {
        return isreturn;
    }


    /**
     * Sets the isreturn value for this Hi_psndoc_deptchgVO.
     * 
     * @param isreturn
     */
    public void setIsreturn(java.lang.String isreturn) {
        this.isreturn = isreturn;
    }


    /**
     * Gets the avicstring3 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring3
     */
    public java.lang.String getAvicstring3() {
        return avicstring3;
    }


    /**
     * Sets the avicstring3 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring3
     */
    public void setAvicstring3(java.lang.String avicstring3) {
        this.avicstring3 = avicstring3;
    }


    /**
     * Gets the deposetype value for this Hi_psndoc_deptchgVO.
     * 
     * @return deposetype
     */
    public java.lang.String getDeposetype() {
        return deposetype;
    }


    /**
     * Sets the deposetype value for this Hi_psndoc_deptchgVO.
     * 
     * @param deposetype
     */
    public void setDeposetype(java.lang.String deposetype) {
        this.deposetype = deposetype;
    }


    /**
     * Gets the avicstring2 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring2
     */
    public java.lang.String getAvicstring2() {
        return avicstring2;
    }


    /**
     * Sets the avicstring2 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring2
     */
    public void setAvicstring2(java.lang.String avicstring2) {
        this.avicstring2 = avicstring2;
    }


    /**
     * Gets the avicstring5 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring5
     */
    public java.lang.String getAvicstring5() {
        return avicstring5;
    }


    /**
     * Sets the avicstring5 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring5
     */
    public void setAvicstring5(java.lang.String avicstring5) {
        this.avicstring5 = avicstring5;
    }


    /**
     * Gets the avicstring19 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring19
     */
    public java.lang.String getAvicstring19() {
        return avicstring19;
    }


    /**
     * Sets the avicstring19 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring19
     */
    public void setAvicstring19(java.lang.String avicstring19) {
        this.avicstring19 = avicstring19;
    }


    /**
     * Gets the avicstring4 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring4
     */
    public java.lang.String getAvicstring4() {
        return avicstring4;
    }


    /**
     * Sets the avicstring4 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring4
     */
    public void setAvicstring4(java.lang.String avicstring4) {
        this.avicstring4 = avicstring4;
    }


    /**
     * Gets the avicstring7 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring7
     */
    public java.lang.String getAvicstring7() {
        return avicstring7;
    }


    /**
     * Sets the avicstring7 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring7
     */
    public void setAvicstring7(java.lang.String avicstring7) {
        this.avicstring7 = avicstring7;
    }


    /**
     * Gets the avicstring6 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring6
     */
    public java.lang.String getAvicstring6() {
        return avicstring6;
    }


    /**
     * Sets the avicstring6 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring6
     */
    public void setAvicstring6(java.lang.String avicstring6) {
        this.avicstring6 = avicstring6;
    }


    /**
     * Gets the corpdef10 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef10
     */
    public java.lang.String getCorpdef10() {
        return corpdef10;
    }


    /**
     * Sets the corpdef10 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef10
     */
    public void setCorpdef10(java.lang.String corpdef10) {
        this.corpdef10 = corpdef10;
    }


    /**
     * Gets the avicstring16 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring16
     */
    public java.lang.String getAvicstring16() {
        return avicstring16;
    }


    /**
     * Sets the avicstring16 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring16
     */
    public void setAvicstring16(java.lang.String avicstring16) {
        this.avicstring16 = avicstring16;
    }


    /**
     * Gets the avicstring9 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring9
     */
    public java.lang.String getAvicstring9() {
        return avicstring9;
    }


    /**
     * Sets the avicstring9 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring9
     */
    public void setAvicstring9(java.lang.String avicstring9) {
        this.avicstring9 = avicstring9;
    }


    /**
     * Gets the avicstring15 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring15
     */
    public java.lang.String getAvicstring15() {
        return avicstring15;
    }


    /**
     * Sets the avicstring15 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring15
     */
    public void setAvicstring15(java.lang.String avicstring15) {
        this.avicstring15 = avicstring15;
    }


    /**
     * Gets the avicstring8 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring8
     */
    public java.lang.String getAvicstring8() {
        return avicstring8;
    }


    /**
     * Sets the avicstring8 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring8
     */
    public void setAvicstring8(java.lang.String avicstring8) {
        this.avicstring8 = avicstring8;
    }


    /**
     * Gets the avicstring18 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring18
     */
    public java.lang.String getAvicstring18() {
        return avicstring18;
    }


    /**
     * Sets the avicstring18 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring18
     */
    public void setAvicstring18(java.lang.String avicstring18) {
        this.avicstring18 = avicstring18;
    }


    /**
     * Gets the avicstring17 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring17
     */
    public java.lang.String getAvicstring17() {
        return avicstring17;
    }


    /**
     * Sets the avicstring17 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring17
     */
    public void setAvicstring17(java.lang.String avicstring17) {
        this.avicstring17 = avicstring17;
    }


    /**
     * Gets the avicstring12 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring12
     */
    public java.lang.String getAvicstring12() {
        return avicstring12;
    }


    /**
     * Sets the avicstring12 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring12
     */
    public void setAvicstring12(java.lang.String avicstring12) {
        this.avicstring12 = avicstring12;
    }


    /**
     * Gets the pk_jobserial value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_jobserial
     */
    public java.lang.String getPk_jobserial() {
        return pk_jobserial;
    }


    /**
     * Sets the pk_jobserial value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_jobserial
     */
    public void setPk_jobserial(java.lang.String pk_jobserial) {
        this.pk_jobserial = pk_jobserial;
    }


    /**
     * Gets the begindate value for this Hi_psndoc_deptchgVO.
     * 
     * @return begindate
     */
    public java.lang.String getBegindate() {
        return begindate;
    }


    /**
     * Sets the begindate value for this Hi_psndoc_deptchgVO.
     * 
     * @param begindate
     */
    public void setBegindate(java.lang.String begindate) {
        this.begindate = begindate;
    }


    /**
     * Gets the enddate value for this Hi_psndoc_deptchgVO.
     * 
     * @return enddate
     */
    public java.lang.String getEnddate() {
        return enddate;
    }


    /**
     * Sets the enddate value for this Hi_psndoc_deptchgVO.
     * 
     * @param enddate
     */
    public void setEnddate(java.lang.String enddate) {
        this.enddate = enddate;
    }


    /**
     * Gets the avicstring11 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring11
     */
    public java.lang.String getAvicstring11() {
        return avicstring11;
    }


    /**
     * Sets the avicstring11 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring11
     */
    public void setAvicstring11(java.lang.String avicstring11) {
        this.avicstring11 = avicstring11;
    }


    /**
     * Gets the preparenote value for this Hi_psndoc_deptchgVO.
     * 
     * @return preparenote
     */
    public java.lang.String getPreparenote() {
        return preparenote;
    }


    /**
     * Sets the preparenote value for this Hi_psndoc_deptchgVO.
     * 
     * @param preparenote
     */
    public void setPreparenote(java.lang.String preparenote) {
        this.preparenote = preparenote;
    }


    /**
     * Gets the avicstring14 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring14
     */
    public java.lang.String getAvicstring14() {
        return avicstring14;
    }


    /**
     * Sets the avicstring14 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring14
     */
    public void setAvicstring14(java.lang.String avicstring14) {
        this.avicstring14 = avicstring14;
    }


    /**
     * Gets the avicstring13 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring13
     */
    public java.lang.String getAvicstring13() {
        return avicstring13;
    }


    /**
     * Sets the avicstring13 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring13
     */
    public void setAvicstring13(java.lang.String avicstring13) {
        this.avicstring13 = avicstring13;
    }


    /**
     * Gets the pk_psndoc value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_psndoc
     */
    public java.lang.String getPk_psndoc() {
        return pk_psndoc;
    }


    /**
     * Sets the pk_psndoc value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_psndoc
     */
    public void setPk_psndoc(java.lang.String pk_psndoc) {
        this.pk_psndoc = pk_psndoc;
    }


    /**
     * Gets the memo value for this Hi_psndoc_deptchgVO.
     * 
     * @return memo
     */
    public java.lang.String getMemo() {
        return memo;
    }


    /**
     * Sets the memo value for this Hi_psndoc_deptchgVO.
     * 
     * @param memo
     */
    public void setMemo(java.lang.String memo) {
        this.memo = memo;
    }


    /**
     * Gets the iscalovertime value for this Hi_psndoc_deptchgVO.
     * 
     * @return iscalovertime
     */
    public java.lang.String getIscalovertime() {
        return iscalovertime;
    }


    /**
     * Sets the iscalovertime value for this Hi_psndoc_deptchgVO.
     * 
     * @param iscalovertime
     */
    public void setIscalovertime(java.lang.String iscalovertime) {
        this.iscalovertime = iscalovertime;
    }


    /**
     * Gets the avicdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicdef1
     */
    public java.lang.String getAvicdef1() {
        return avicdef1;
    }


    /**
     * Sets the avicdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicdef1
     */
    public void setAvicdef1(java.lang.String avicdef1) {
        this.avicdef1 = avicdef1;
    }


    /**
     * Gets the tableName value for this Hi_psndoc_deptchgVO.
     * 
     * @return tableName
     */
    public java.lang.String getTableName() {
        return tableName;
    }


    /**
     * Sets the tableName value for this Hi_psndoc_deptchgVO.
     * 
     * @param tableName
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }


    /**
     * Gets the approveflag value for this Hi_psndoc_deptchgVO.
     * 
     * @return approveflag
     */
    public java.lang.String getApproveflag() {
        return approveflag;
    }


    /**
     * Sets the approveflag value for this Hi_psndoc_deptchgVO.
     * 
     * @param approveflag
     */
    public void setApproveflag(java.lang.String approveflag) {
        this.approveflag = approveflag;
    }


    /**
     * Gets the avicstring10 value for this Hi_psndoc_deptchgVO.
     * 
     * @return avicstring10
     */
    public java.lang.String getAvicstring10() {
        return avicstring10;
    }


    /**
     * Sets the avicstring10 value for this Hi_psndoc_deptchgVO.
     * 
     * @param avicstring10
     */
    public void setAvicstring10(java.lang.String avicstring10) {
        this.avicstring10 = avicstring10;
    }


    /**
     * Gets the dr value for this Hi_psndoc_deptchgVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Hi_psndoc_deptchgVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }


    /**
     * Gets the tbm_prop value for this Hi_psndoc_deptchgVO.
     * 
     * @return tbm_prop
     */
    public java.lang.Long getTbm_prop() {
        return tbm_prop;
    }


    /**
     * Sets the tbm_prop value for this Hi_psndoc_deptchgVO.
     * 
     * @param tbm_prop
     */
    public void setTbm_prop(java.lang.Long tbm_prop) {
        this.tbm_prop = tbm_prop;
    }


    /**
     * Gets the pk_jobrank value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_jobrank
     */
    public java.lang.String getPk_jobrank() {
        return pk_jobrank;
    }


    /**
     * Sets the pk_jobrank value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_jobrank
     */
    public void setPk_jobrank(java.lang.String pk_jobrank) {
        this.pk_jobrank = pk_jobrank;
    }


    /**
     * Gets the pk_corp value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the pk_postdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_postdoc
     */
    public java.lang.String getPk_postdoc() {
        return pk_postdoc;
    }


    /**
     * Sets the pk_postdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_postdoc
     */
    public void setPk_postdoc(java.lang.String pk_postdoc) {
        this.pk_postdoc = pk_postdoc;
    }


    /**
     * Gets the hroperator value for this Hi_psndoc_deptchgVO.
     * 
     * @return hroperator
     */
    public java.lang.String getHroperator() {
        return hroperator;
    }


    /**
     * Sets the hroperator value for this Hi_psndoc_deptchgVO.
     * 
     * @param hroperator
     */
    public void setHroperator(java.lang.String hroperator) {
        this.hroperator = hroperator;
    }


    /**
     * Gets the groupdef6 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef6
     */
    public java.lang.String getGroupdef6() {
        return groupdef6;
    }


    /**
     * Sets the groupdef6 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef6
     */
    public void setGroupdef6(java.lang.String groupdef6) {
        this.groupdef6 = groupdef6;
    }


    /**
     * Gets the groupdef7 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef7
     */
    public java.lang.String getGroupdef7() {
        return groupdef7;
    }


    /**
     * Sets the groupdef7 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef7
     */
    public void setGroupdef7(java.lang.String groupdef7) {
        this.groupdef7 = groupdef7;
    }


    /**
     * Gets the groupdef8 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef8
     */
    public java.lang.String getGroupdef8() {
        return groupdef8;
    }


    /**
     * Sets the groupdef8 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef8
     */
    public void setGroupdef8(java.lang.String groupdef8) {
        this.groupdef8 = groupdef8;
    }


    /**
     * Gets the pk_psnbasdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_psnbasdoc
     */
    public java.lang.String getPk_psnbasdoc() {
        return pk_psnbasdoc;
    }


    /**
     * Sets the pk_psnbasdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_psnbasdoc
     */
    public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
        this.pk_psnbasdoc = pk_psnbasdoc;
    }


    /**
     * Gets the groupdef9 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef9
     */
    public java.lang.String getGroupdef9() {
        return groupdef9;
    }


    /**
     * Sets the groupdef9 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef9
     */
    public void setGroupdef9(java.lang.String groupdef9) {
        this.groupdef9 = groupdef9;
    }


    /**
     * Gets the lastflag value for this Hi_psndoc_deptchgVO.
     * 
     * @return lastflag
     */
    public java.lang.String getLastflag() {
        return lastflag;
    }


    /**
     * Sets the lastflag value for this Hi_psndoc_deptchgVO.
     * 
     * @param lastflag
     */
    public void setLastflag(java.lang.String lastflag) {
        this.lastflag = lastflag;
    }


    /**
     * Gets the groupdef3 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef3
     */
    public java.lang.String getGroupdef3() {
        return groupdef3;
    }


    /**
     * Sets the groupdef3 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef3
     */
    public void setGroupdef3(java.lang.String groupdef3) {
        this.groupdef3 = groupdef3;
    }


    /**
     * Gets the deposereason value for this Hi_psndoc_deptchgVO.
     * 
     * @return deposereason
     */
    public java.lang.String getDeposereason() {
        return deposereason;
    }


    /**
     * Sets the deposereason value for this Hi_psndoc_deptchgVO.
     * 
     * @param deposereason
     */
    public void setDeposereason(java.lang.String deposereason) {
        this.deposereason = deposereason;
    }


    /**
     * Gets the groupdef2 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef2
     */
    public java.lang.String getGroupdef2() {
        return groupdef2;
    }


    /**
     * Sets the groupdef2 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef2
     */
    public void setGroupdef2(java.lang.String groupdef2) {
        this.groupdef2 = groupdef2;
    }


    /**
     * Gets the groupdef5 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef5
     */
    public java.lang.String getGroupdef5() {
        return groupdef5;
    }


    /**
     * Sets the groupdef5 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef5
     */
    public void setGroupdef5(java.lang.String groupdef5) {
        this.groupdef5 = groupdef5;
    }


    /**
     * Gets the pk_om_duty value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_om_duty
     */
    public java.lang.String getPk_om_duty() {
        return pk_om_duty;
    }


    /**
     * Sets the pk_om_duty value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_om_duty
     */
    public void setPk_om_duty(java.lang.String pk_om_duty) {
        this.pk_om_duty = pk_om_duty;
    }


    /**
     * Gets the groupdef4 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef4
     */
    public java.lang.String getGroupdef4() {
        return groupdef4;
    }


    /**
     * Sets the groupdef4 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef4
     */
    public void setGroupdef4(java.lang.String groupdef4) {
        this.groupdef4 = groupdef4;
    }


    /**
     * Gets the recordnum value for this Hi_psndoc_deptchgVO.
     * 
     * @return recordnum
     */
    public java.lang.Long getRecordnum() {
        return recordnum;
    }


    /**
     * Sets the recordnum value for this Hi_psndoc_deptchgVO.
     * 
     * @param recordnum
     */
    public void setRecordnum(java.lang.Long recordnum) {
        this.recordnum = recordnum;
    }


    /**
     * Gets the groupdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @return groupdef1
     */
    public java.lang.String getGroupdef1() {
        return groupdef1;
    }


    /**
     * Sets the groupdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @param groupdef1
     */
    public void setGroupdef1(java.lang.String groupdef1) {
        this.groupdef1 = groupdef1;
    }


    /**
     * Gets the corpdef2 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef2
     */
    public java.lang.String getCorpdef2() {
        return corpdef2;
    }


    /**
     * Sets the corpdef2 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef2
     */
    public void setCorpdef2(java.lang.String corpdef2) {
        this.corpdef2 = corpdef2;
    }


    /**
     * Gets the corpdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef1
     */
    public java.lang.String getCorpdef1() {
        return corpdef1;
    }


    /**
     * Sets the corpdef1 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef1
     */
    public void setCorpdef1(java.lang.String corpdef1) {
        this.corpdef1 = corpdef1;
    }


    /**
     * Gets the corpdef4 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef4
     */
    public java.lang.String getCorpdef4() {
        return corpdef4;
    }


    /**
     * Sets the corpdef4 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef4
     */
    public void setCorpdef4(java.lang.String corpdef4) {
        this.corpdef4 = corpdef4;
    }


    /**
     * Gets the corpdef3 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef3
     */
    public java.lang.String getCorpdef3() {
        return corpdef3;
    }


    /**
     * Sets the corpdef3 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef3
     */
    public void setCorpdef3(java.lang.String corpdef3) {
        this.corpdef3 = corpdef3;
    }


    /**
     * Gets the corpdef6 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef6
     */
    public java.lang.String getCorpdef6() {
        return corpdef6;
    }


    /**
     * Sets the corpdef6 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef6
     */
    public void setCorpdef6(java.lang.String corpdef6) {
        this.corpdef6 = corpdef6;
    }


    /**
     * Gets the corpdef5 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef5
     */
    public java.lang.String getCorpdef5() {
        return corpdef5;
    }


    /**
     * Sets the corpdef5 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef5
     */
    public void setCorpdef5(java.lang.String corpdef5) {
        this.corpdef5 = corpdef5;
    }


    /**
     * Gets the pk_deptdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @return pk_deptdoc
     */
    public java.lang.String getPk_deptdoc() {
        return pk_deptdoc;
    }


    /**
     * Sets the pk_deptdoc value for this Hi_psndoc_deptchgVO.
     * 
     * @param pk_deptdoc
     */
    public void setPk_deptdoc(java.lang.String pk_deptdoc) {
        this.pk_deptdoc = pk_deptdoc;
    }


    /**
     * Gets the corpdef8 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef8
     */
    public java.lang.String getCorpdef8() {
        return corpdef8;
    }


    /**
     * Sets the corpdef8 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef8
     */
    public void setCorpdef8(java.lang.String corpdef8) {
        this.corpdef8 = corpdef8;
    }


    /**
     * Gets the corpdef7 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef7
     */
    public java.lang.String getCorpdef7() {
        return corpdef7;
    }


    /**
     * Sets the corpdef7 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef7
     */
    public void setCorpdef7(java.lang.String corpdef7) {
        this.corpdef7 = corpdef7;
    }


    /**
     * Gets the timecardid value for this Hi_psndoc_deptchgVO.
     * 
     * @return timecardid
     */
    public java.lang.String getTimecardid() {
        return timecardid;
    }


    /**
     * Sets the timecardid value for this Hi_psndoc_deptchgVO.
     * 
     * @param timecardid
     */
    public void setTimecardid(java.lang.String timecardid) {
        this.timecardid = timecardid;
    }


    /**
     * Gets the corpdef9 value for this Hi_psndoc_deptchgVO.
     * 
     * @return corpdef9
     */
    public java.lang.String getCorpdef9() {
        return corpdef9;
    }


    /**
     * Sets the corpdef9 value for this Hi_psndoc_deptchgVO.
     * 
     * @param corpdef9
     */
    public void setCorpdef9(java.lang.String corpdef9) {
        this.corpdef9 = corpdef9;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Hi_psndoc_deptchgVO)) return false;
        Hi_psndoc_deptchgVO other = (Hi_psndoc_deptchgVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.avicstring30==null && other.getAvicstring30()==null) || 
             (this.avicstring30!=null &&
              this.avicstring30.equals(other.getAvicstring30()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
            ((this.groupdef10==null && other.getGroupdef10()==null) || 
             (this.groupdef10!=null &&
              this.groupdef10.equals(other.getGroupdef10()))) &&
            ((this.choldreason==null && other.getCholdreason()==null) || 
             (this.choldreason!=null &&
              this.choldreason.equals(other.getCholdreason()))) &&
            ((this.pk_psncl==null && other.getPk_psncl()==null) || 
             (this.pk_psncl!=null &&
              this.pk_psncl.equals(other.getPk_psncl()))) &&
            ((this.preparetype==null && other.getPreparetype()==null) || 
             (this.preparetype!=null &&
              this.preparetype.equals(other.getPreparetype()))) &&
            ((this.jobtype==null && other.getJobtype()==null) || 
             (this.jobtype!=null &&
              this.jobtype.equals(other.getJobtype()))) &&
            ((this.pk_psndoc_sub==null && other.getPk_psndoc_sub()==null) || 
             (this.pk_psndoc_sub!=null &&
              this.pk_psndoc_sub.equals(other.getPk_psndoc_sub()))) &&
            ((this.avicstring29==null && other.getAvicstring29()==null) || 
             (this.avicstring29!=null &&
              this.avicstring29.equals(other.getAvicstring29()))) &&
            ((this.avicstring28==null && other.getAvicstring28()==null) || 
             (this.avicstring28!=null &&
              this.avicstring28.equals(other.getAvicstring28()))) &&
            ((this.avicstring27==null && other.getAvicstring27()==null) || 
             (this.avicstring27!=null &&
              this.avicstring27.equals(other.getAvicstring27()))) &&
            ((this.avicstring26==null && other.getAvicstring26()==null) || 
             (this.avicstring26!=null &&
              this.avicstring26.equals(other.getAvicstring26()))) &&
            ((this.avicstring25==null && other.getAvicstring25()==null) || 
             (this.avicstring25!=null &&
              this.avicstring25.equals(other.getAvicstring25()))) &&
            ((this.avicstring24==null && other.getAvicstring24()==null) || 
             (this.avicstring24!=null &&
              this.avicstring24.equals(other.getAvicstring24()))) &&
            ((this.avicstring23==null && other.getAvicstring23()==null) || 
             (this.avicstring23!=null &&
              this.avicstring23.equals(other.getAvicstring23()))) &&
            ((this.avicstring22==null && other.getAvicstring22()==null) || 
             (this.avicstring22!=null &&
              this.avicstring22.equals(other.getAvicstring22()))) &&
            ((this.poststat==null && other.getPoststat()==null) || 
             (this.poststat!=null &&
              this.poststat.equals(other.getPoststat()))) &&
            ((this.avicstring20==null && other.getAvicstring20()==null) || 
             (this.avicstring20!=null &&
              this.avicstring20.equals(other.getAvicstring20()))) &&
            ((this.avicstring21==null && other.getAvicstring21()==null) || 
             (this.avicstring21!=null &&
              this.avicstring21.equals(other.getAvicstring21()))) &&
            ((this.posttype==null && other.getPosttype()==null) || 
             (this.posttype!=null &&
              this.posttype.equals(other.getPosttype()))) &&
            ((this.bendflag==null && other.getBendflag()==null) || 
             (this.bendflag!=null &&
              this.bendflag.equals(other.getBendflag()))) &&
            ((this.preparereason==null && other.getPreparereason()==null) || 
             (this.preparereason!=null &&
              this.preparereason.equals(other.getPreparereason()))) &&
            ((this.spike_sign==null && other.getSpike_sign()==null) || 
             (this.spike_sign!=null &&
              this.spike_sign.equals(other.getSpike_sign()))) &&
            ((this.pk_detytype==null && other.getPk_detytype()==null) || 
             (this.pk_detytype!=null &&
              this.pk_detytype.equals(other.getPk_detytype()))) &&
            ((this.period==null && other.getPeriod()==null) || 
             (this.period!=null &&
              this.period.equals(other.getPeriod()))) &&
            ((this.pk_dutyrank==null && other.getPk_dutyrank()==null) || 
             (this.pk_dutyrank!=null &&
              this.pk_dutyrank.equals(other.getPk_dutyrank()))) &&
            ((this.avicstring1==null && other.getAvicstring1()==null) || 
             (this.avicstring1!=null &&
              this.avicstring1.equals(other.getAvicstring1()))) &&
            ((this.isreturn==null && other.getIsreturn()==null) || 
             (this.isreturn!=null &&
              this.isreturn.equals(other.getIsreturn()))) &&
            ((this.avicstring3==null && other.getAvicstring3()==null) || 
             (this.avicstring3!=null &&
              this.avicstring3.equals(other.getAvicstring3()))) &&
            ((this.deposetype==null && other.getDeposetype()==null) || 
             (this.deposetype!=null &&
              this.deposetype.equals(other.getDeposetype()))) &&
            ((this.avicstring2==null && other.getAvicstring2()==null) || 
             (this.avicstring2!=null &&
              this.avicstring2.equals(other.getAvicstring2()))) &&
            ((this.avicstring5==null && other.getAvicstring5()==null) || 
             (this.avicstring5!=null &&
              this.avicstring5.equals(other.getAvicstring5()))) &&
            ((this.avicstring19==null && other.getAvicstring19()==null) || 
             (this.avicstring19!=null &&
              this.avicstring19.equals(other.getAvicstring19()))) &&
            ((this.avicstring4==null && other.getAvicstring4()==null) || 
             (this.avicstring4!=null &&
              this.avicstring4.equals(other.getAvicstring4()))) &&
            ((this.avicstring7==null && other.getAvicstring7()==null) || 
             (this.avicstring7!=null &&
              this.avicstring7.equals(other.getAvicstring7()))) &&
            ((this.avicstring6==null && other.getAvicstring6()==null) || 
             (this.avicstring6!=null &&
              this.avicstring6.equals(other.getAvicstring6()))) &&
            ((this.corpdef10==null && other.getCorpdef10()==null) || 
             (this.corpdef10!=null &&
              this.corpdef10.equals(other.getCorpdef10()))) &&
            ((this.avicstring16==null && other.getAvicstring16()==null) || 
             (this.avicstring16!=null &&
              this.avicstring16.equals(other.getAvicstring16()))) &&
            ((this.avicstring9==null && other.getAvicstring9()==null) || 
             (this.avicstring9!=null &&
              this.avicstring9.equals(other.getAvicstring9()))) &&
            ((this.avicstring15==null && other.getAvicstring15()==null) || 
             (this.avicstring15!=null &&
              this.avicstring15.equals(other.getAvicstring15()))) &&
            ((this.avicstring8==null && other.getAvicstring8()==null) || 
             (this.avicstring8!=null &&
              this.avicstring8.equals(other.getAvicstring8()))) &&
            ((this.avicstring18==null && other.getAvicstring18()==null) || 
             (this.avicstring18!=null &&
              this.avicstring18.equals(other.getAvicstring18()))) &&
            ((this.avicstring17==null && other.getAvicstring17()==null) || 
             (this.avicstring17!=null &&
              this.avicstring17.equals(other.getAvicstring17()))) &&
            ((this.avicstring12==null && other.getAvicstring12()==null) || 
             (this.avicstring12!=null &&
              this.avicstring12.equals(other.getAvicstring12()))) &&
            ((this.pk_jobserial==null && other.getPk_jobserial()==null) || 
             (this.pk_jobserial!=null &&
              this.pk_jobserial.equals(other.getPk_jobserial()))) &&
            ((this.begindate==null && other.getBegindate()==null) || 
             (this.begindate!=null &&
              this.begindate.equals(other.getBegindate()))) &&
            ((this.enddate==null && other.getEnddate()==null) || 
             (this.enddate!=null &&
              this.enddate.equals(other.getEnddate()))) &&
            ((this.avicstring11==null && other.getAvicstring11()==null) || 
             (this.avicstring11!=null &&
              this.avicstring11.equals(other.getAvicstring11()))) &&
            ((this.preparenote==null && other.getPreparenote()==null) || 
             (this.preparenote!=null &&
              this.preparenote.equals(other.getPreparenote()))) &&
            ((this.avicstring14==null && other.getAvicstring14()==null) || 
             (this.avicstring14!=null &&
              this.avicstring14.equals(other.getAvicstring14()))) &&
            ((this.avicstring13==null && other.getAvicstring13()==null) || 
             (this.avicstring13!=null &&
              this.avicstring13.equals(other.getAvicstring13()))) &&
            ((this.pk_psndoc==null && other.getPk_psndoc()==null) || 
             (this.pk_psndoc!=null &&
              this.pk_psndoc.equals(other.getPk_psndoc()))) &&
            ((this.memo==null && other.getMemo()==null) || 
             (this.memo!=null &&
              this.memo.equals(other.getMemo()))) &&
            ((this.iscalovertime==null && other.getIscalovertime()==null) || 
             (this.iscalovertime!=null &&
              this.iscalovertime.equals(other.getIscalovertime()))) &&
            ((this.avicdef1==null && other.getAvicdef1()==null) || 
             (this.avicdef1!=null &&
              this.avicdef1.equals(other.getAvicdef1()))) &&
            ((this.tableName==null && other.getTableName()==null) || 
             (this.tableName!=null &&
              this.tableName.equals(other.getTableName()))) &&
            ((this.approveflag==null && other.getApproveflag()==null) || 
             (this.approveflag!=null &&
              this.approveflag.equals(other.getApproveflag()))) &&
            ((this.avicstring10==null && other.getAvicstring10()==null) || 
             (this.avicstring10!=null &&
              this.avicstring10.equals(other.getAvicstring10()))) &&
            ((this.dr==null && other.getDr()==null) || 
             (this.dr!=null &&
              this.dr.equals(other.getDr()))) &&
            ((this.tbm_prop==null && other.getTbm_prop()==null) || 
             (this.tbm_prop!=null &&
              this.tbm_prop.equals(other.getTbm_prop()))) &&
            ((this.pk_jobrank==null && other.getPk_jobrank()==null) || 
             (this.pk_jobrank!=null &&
              this.pk_jobrank.equals(other.getPk_jobrank()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.pk_postdoc==null && other.getPk_postdoc()==null) || 
             (this.pk_postdoc!=null &&
              this.pk_postdoc.equals(other.getPk_postdoc()))) &&
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
            ((this.groupdef9==null && other.getGroupdef9()==null) || 
             (this.groupdef9!=null &&
              this.groupdef9.equals(other.getGroupdef9()))) &&
            ((this.lastflag==null && other.getLastflag()==null) || 
             (this.lastflag!=null &&
              this.lastflag.equals(other.getLastflag()))) &&
            ((this.groupdef3==null && other.getGroupdef3()==null) || 
             (this.groupdef3!=null &&
              this.groupdef3.equals(other.getGroupdef3()))) &&
            ((this.deposereason==null && other.getDeposereason()==null) || 
             (this.deposereason!=null &&
              this.deposereason.equals(other.getDeposereason()))) &&
            ((this.groupdef2==null && other.getGroupdef2()==null) || 
             (this.groupdef2!=null &&
              this.groupdef2.equals(other.getGroupdef2()))) &&
            ((this.groupdef5==null && other.getGroupdef5()==null) || 
             (this.groupdef5!=null &&
              this.groupdef5.equals(other.getGroupdef5()))) &&
            ((this.pk_om_duty==null && other.getPk_om_duty()==null) || 
             (this.pk_om_duty!=null &&
              this.pk_om_duty.equals(other.getPk_om_duty()))) &&
            ((this.groupdef4==null && other.getGroupdef4()==null) || 
             (this.groupdef4!=null &&
              this.groupdef4.equals(other.getGroupdef4()))) &&
            ((this.recordnum==null && other.getRecordnum()==null) || 
             (this.recordnum!=null &&
              this.recordnum.equals(other.getRecordnum()))) &&
            ((this.groupdef1==null && other.getGroupdef1()==null) || 
             (this.groupdef1!=null &&
              this.groupdef1.equals(other.getGroupdef1()))) &&
            ((this.corpdef2==null && other.getCorpdef2()==null) || 
             (this.corpdef2!=null &&
              this.corpdef2.equals(other.getCorpdef2()))) &&
            ((this.corpdef1==null && other.getCorpdef1()==null) || 
             (this.corpdef1!=null &&
              this.corpdef1.equals(other.getCorpdef1()))) &&
            ((this.corpdef4==null && other.getCorpdef4()==null) || 
             (this.corpdef4!=null &&
              this.corpdef4.equals(other.getCorpdef4()))) &&
            ((this.corpdef3==null && other.getCorpdef3()==null) || 
             (this.corpdef3!=null &&
              this.corpdef3.equals(other.getCorpdef3()))) &&
            ((this.corpdef6==null && other.getCorpdef6()==null) || 
             (this.corpdef6!=null &&
              this.corpdef6.equals(other.getCorpdef6()))) &&
            ((this.corpdef5==null && other.getCorpdef5()==null) || 
             (this.corpdef5!=null &&
              this.corpdef5.equals(other.getCorpdef5()))) &&
            ((this.pk_deptdoc==null && other.getPk_deptdoc()==null) || 
             (this.pk_deptdoc!=null &&
              this.pk_deptdoc.equals(other.getPk_deptdoc()))) &&
            ((this.corpdef8==null && other.getCorpdef8()==null) || 
             (this.corpdef8!=null &&
              this.corpdef8.equals(other.getCorpdef8()))) &&
            ((this.corpdef7==null && other.getCorpdef7()==null) || 
             (this.corpdef7!=null &&
              this.corpdef7.equals(other.getCorpdef7()))) &&
            ((this.timecardid==null && other.getTimecardid()==null) || 
             (this.timecardid!=null &&
              this.timecardid.equals(other.getTimecardid()))) &&
            ((this.corpdef9==null && other.getCorpdef9()==null) || 
             (this.corpdef9!=null &&
              this.corpdef9.equals(other.getCorpdef9())));
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
        if (getAvicstring30() != null) {
            _hashCode += getAvicstring30().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getGroupdef10() != null) {
            _hashCode += getGroupdef10().hashCode();
        }
        if (getCholdreason() != null) {
            _hashCode += getCholdreason().hashCode();
        }
        if (getPk_psncl() != null) {
            _hashCode += getPk_psncl().hashCode();
        }
        if (getPreparetype() != null) {
            _hashCode += getPreparetype().hashCode();
        }
        if (getJobtype() != null) {
            _hashCode += getJobtype().hashCode();
        }
        if (getPk_psndoc_sub() != null) {
            _hashCode += getPk_psndoc_sub().hashCode();
        }
        if (getAvicstring29() != null) {
            _hashCode += getAvicstring29().hashCode();
        }
        if (getAvicstring28() != null) {
            _hashCode += getAvicstring28().hashCode();
        }
        if (getAvicstring27() != null) {
            _hashCode += getAvicstring27().hashCode();
        }
        if (getAvicstring26() != null) {
            _hashCode += getAvicstring26().hashCode();
        }
        if (getAvicstring25() != null) {
            _hashCode += getAvicstring25().hashCode();
        }
        if (getAvicstring24() != null) {
            _hashCode += getAvicstring24().hashCode();
        }
        if (getAvicstring23() != null) {
            _hashCode += getAvicstring23().hashCode();
        }
        if (getAvicstring22() != null) {
            _hashCode += getAvicstring22().hashCode();
        }
        if (getPoststat() != null) {
            _hashCode += getPoststat().hashCode();
        }
        if (getAvicstring20() != null) {
            _hashCode += getAvicstring20().hashCode();
        }
        if (getAvicstring21() != null) {
            _hashCode += getAvicstring21().hashCode();
        }
        if (getPosttype() != null) {
            _hashCode += getPosttype().hashCode();
        }
        if (getBendflag() != null) {
            _hashCode += getBendflag().hashCode();
        }
        if (getPreparereason() != null) {
            _hashCode += getPreparereason().hashCode();
        }
        if (getSpike_sign() != null) {
            _hashCode += getSpike_sign().hashCode();
        }
        if (getPk_detytype() != null) {
            _hashCode += getPk_detytype().hashCode();
        }
        if (getPeriod() != null) {
            _hashCode += getPeriod().hashCode();
        }
        if (getPk_dutyrank() != null) {
            _hashCode += getPk_dutyrank().hashCode();
        }
        if (getAvicstring1() != null) {
            _hashCode += getAvicstring1().hashCode();
        }
        if (getIsreturn() != null) {
            _hashCode += getIsreturn().hashCode();
        }
        if (getAvicstring3() != null) {
            _hashCode += getAvicstring3().hashCode();
        }
        if (getDeposetype() != null) {
            _hashCode += getDeposetype().hashCode();
        }
        if (getAvicstring2() != null) {
            _hashCode += getAvicstring2().hashCode();
        }
        if (getAvicstring5() != null) {
            _hashCode += getAvicstring5().hashCode();
        }
        if (getAvicstring19() != null) {
            _hashCode += getAvicstring19().hashCode();
        }
        if (getAvicstring4() != null) {
            _hashCode += getAvicstring4().hashCode();
        }
        if (getAvicstring7() != null) {
            _hashCode += getAvicstring7().hashCode();
        }
        if (getAvicstring6() != null) {
            _hashCode += getAvicstring6().hashCode();
        }
        if (getCorpdef10() != null) {
            _hashCode += getCorpdef10().hashCode();
        }
        if (getAvicstring16() != null) {
            _hashCode += getAvicstring16().hashCode();
        }
        if (getAvicstring9() != null) {
            _hashCode += getAvicstring9().hashCode();
        }
        if (getAvicstring15() != null) {
            _hashCode += getAvicstring15().hashCode();
        }
        if (getAvicstring8() != null) {
            _hashCode += getAvicstring8().hashCode();
        }
        if (getAvicstring18() != null) {
            _hashCode += getAvicstring18().hashCode();
        }
        if (getAvicstring17() != null) {
            _hashCode += getAvicstring17().hashCode();
        }
        if (getAvicstring12() != null) {
            _hashCode += getAvicstring12().hashCode();
        }
        if (getPk_jobserial() != null) {
            _hashCode += getPk_jobserial().hashCode();
        }
        if (getBegindate() != null) {
            _hashCode += getBegindate().hashCode();
        }
        if (getEnddate() != null) {
            _hashCode += getEnddate().hashCode();
        }
        if (getAvicstring11() != null) {
            _hashCode += getAvicstring11().hashCode();
        }
        if (getPreparenote() != null) {
            _hashCode += getPreparenote().hashCode();
        }
        if (getAvicstring14() != null) {
            _hashCode += getAvicstring14().hashCode();
        }
        if (getAvicstring13() != null) {
            _hashCode += getAvicstring13().hashCode();
        }
        if (getPk_psndoc() != null) {
            _hashCode += getPk_psndoc().hashCode();
        }
        if (getMemo() != null) {
            _hashCode += getMemo().hashCode();
        }
        if (getIscalovertime() != null) {
            _hashCode += getIscalovertime().hashCode();
        }
        if (getAvicdef1() != null) {
            _hashCode += getAvicdef1().hashCode();
        }
        if (getTableName() != null) {
            _hashCode += getTableName().hashCode();
        }
        if (getApproveflag() != null) {
            _hashCode += getApproveflag().hashCode();
        }
        if (getAvicstring10() != null) {
            _hashCode += getAvicstring10().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        if (getTbm_prop() != null) {
            _hashCode += getTbm_prop().hashCode();
        }
        if (getPk_jobrank() != null) {
            _hashCode += getPk_jobrank().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getPk_postdoc() != null) {
            _hashCode += getPk_postdoc().hashCode();
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
        if (getGroupdef9() != null) {
            _hashCode += getGroupdef9().hashCode();
        }
        if (getLastflag() != null) {
            _hashCode += getLastflag().hashCode();
        }
        if (getGroupdef3() != null) {
            _hashCode += getGroupdef3().hashCode();
        }
        if (getDeposereason() != null) {
            _hashCode += getDeposereason().hashCode();
        }
        if (getGroupdef2() != null) {
            _hashCode += getGroupdef2().hashCode();
        }
        if (getGroupdef5() != null) {
            _hashCode += getGroupdef5().hashCode();
        }
        if (getPk_om_duty() != null) {
            _hashCode += getPk_om_duty().hashCode();
        }
        if (getGroupdef4() != null) {
            _hashCode += getGroupdef4().hashCode();
        }
        if (getRecordnum() != null) {
            _hashCode += getRecordnum().hashCode();
        }
        if (getGroupdef1() != null) {
            _hashCode += getGroupdef1().hashCode();
        }
        if (getCorpdef2() != null) {
            _hashCode += getCorpdef2().hashCode();
        }
        if (getCorpdef1() != null) {
            _hashCode += getCorpdef1().hashCode();
        }
        if (getCorpdef4() != null) {
            _hashCode += getCorpdef4().hashCode();
        }
        if (getCorpdef3() != null) {
            _hashCode += getCorpdef3().hashCode();
        }
        if (getCorpdef6() != null) {
            _hashCode += getCorpdef6().hashCode();
        }
        if (getCorpdef5() != null) {
            _hashCode += getCorpdef5().hashCode();
        }
        if (getPk_deptdoc() != null) {
            _hashCode += getPk_deptdoc().hashCode();
        }
        if (getCorpdef8() != null) {
            _hashCode += getCorpdef8().hashCode();
        }
        if (getCorpdef7() != null) {
            _hashCode += getCorpdef7().hashCode();
        }
        if (getTimecardid() != null) {
            _hashCode += getTimecardid().hashCode();
        }
        if (getCorpdef9() != null) {
            _hashCode += getCorpdef9().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Hi_psndoc_deptchgVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://hi.vo.ws.nc/Hi_psndoc_deptchgVO", "Hi_psndoc_deptchgVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring30");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring30"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ts"));
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
        elemField.setFieldName("choldreason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "choldreason"));
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
        elemField.setFieldName("preparetype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preparetype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobtype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobtype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_psndoc_sub");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_psndoc_sub"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring29");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring29"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring28");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring28"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring27");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring27"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring26");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring26"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring25");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring25"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring24");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring24"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring23");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring23"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring22");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring22"));
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
        elemField.setFieldName("avicstring20");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring20"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring21");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring21"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("posttype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "posttype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bendflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bendflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preparereason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preparereason"));
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
        elemField.setFieldName("pk_detytype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_detytype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("period");
        elemField.setXmlName(new javax.xml.namespace.QName("", "period"));
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
        elemField.setFieldName("avicstring1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring1"));
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
        elemField.setFieldName("avicstring3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deposetype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deposetype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring19");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring19"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring7"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef10");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef10"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring16");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring16"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring15");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring15"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring18");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring18"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring17");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring17"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring12");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring12"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_jobserial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_jobserial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("begindate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "begindate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "enddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring11");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring11"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("preparenote");
        elemField.setXmlName(new javax.xml.namespace.QName("", "preparenote"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring14");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring14"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring13");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring13"));
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
        elemField.setFieldName("memo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "memo"));
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
        elemField.setFieldName("avicdef1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef1"));
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
        elemField.setFieldName("approveflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "approveflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicstring10");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicstring10"));
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
        elemField.setFieldName("pk_jobrank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_jobrank"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("pk_postdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_postdoc"));
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
        elemField.setFieldName("groupdef9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastflag"));
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
        elemField.setFieldName("deposereason");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deposereason"));
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
        elemField.setFieldName("pk_om_duty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_om_duty"));
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
        elemField.setFieldName("recordnum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recordnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
        elemField.setFieldName("corpdef2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef5"));
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
        elemField.setFieldName("corpdef8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef7"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("corpdef9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "corpdef9"));
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

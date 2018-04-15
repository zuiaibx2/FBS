/**
 * Om_jobVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.om;

public class Om_jobVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String filepath;

    private java.lang.String jobname;

    private java.lang.String ts;

    private java.lang.String groupdef11;

    private java.lang.Long groupdef12;

    private java.lang.String tospvise;

    private java.lang.String groupdef10;

    private java.lang.String groupdef15;

    private java.lang.String abortdate;

    private java.lang.String createcorp;

    private java.lang.String sm_changedate;

    private java.lang.String groupdef13;

    private java.lang.String groupdef14;

    private java.lang.String horisitu;

    private java.lang.String isdeptrespon;

    private java.lang.String spike_sign;

    private java.lang.String worksumm;

    private java.lang.String junior;

    private java.lang.String isabort;

    private java.lang.String jobseries;

    private java.lang.String builddate;

    private java.lang.String avicdef10;

    private java.lang.String avicdef1;

    private java.lang.String avicdef3;

    private java.lang.String avicdef2;

    private java.lang.String tableName;

    private java.lang.String avicdef5;

    private java.lang.String avicdef4;

    private java.lang.String suporior;

    private java.lang.Integer dr;

    private java.lang.String pk_corp;

    private java.lang.String pk_om_job;

    private java.lang.String avicdef8;

    private java.lang.String incontact;

    private java.lang.String avicdef9;

    private java.lang.String avicdef6;

    private java.lang.String avicdef7;

    private java.lang.String groupdef6;

    private java.lang.String groupdef7;

    private java.lang.String bespvised;

    private java.lang.String groupdef8;

    private java.lang.String groupdef9;

    private java.lang.String groupdef3;

    private java.lang.String groupdef2;

    private java.lang.String pk_om_duty;

    private java.lang.String groupdef5;

    private java.lang.String groupdef4;

    private java.lang.String groupdef1;

    private java.lang.String pk_jobdoc;

    private java.lang.String jobrank;

    private java.lang.String outcontact;

    private java.lang.String pk_deptdoc;

    private java.lang.String jobcode;

    public Om_jobVO() {
    }

    public Om_jobVO(
           java.lang.String filepath,
           java.lang.String jobname,
           java.lang.String ts,
           java.lang.String groupdef11,
           java.lang.Long groupdef12,
           java.lang.String tospvise,
           java.lang.String groupdef10,
           java.lang.String groupdef15,
           java.lang.String abortdate,
           java.lang.String createcorp,
           java.lang.String sm_changedate,
           java.lang.String groupdef13,
           java.lang.String groupdef14,
           java.lang.String horisitu,
           java.lang.String isdeptrespon,
           java.lang.String spike_sign,
           java.lang.String worksumm,
           java.lang.String junior,
           java.lang.String isabort,
           java.lang.String jobseries,
           java.lang.String builddate,
           java.lang.String avicdef10,
           java.lang.String avicdef1,
           java.lang.String avicdef3,
           java.lang.String avicdef2,
           java.lang.String tableName,
           java.lang.String avicdef5,
           java.lang.String avicdef4,
           java.lang.String suporior,
           java.lang.Integer dr,
           java.lang.String pk_corp,
           java.lang.String pk_om_job,
           java.lang.String avicdef8,
           java.lang.String incontact,
           java.lang.String avicdef9,
           java.lang.String avicdef6,
           java.lang.String avicdef7,
           java.lang.String groupdef6,
           java.lang.String groupdef7,
           java.lang.String bespvised,
           java.lang.String groupdef8,
           java.lang.String groupdef9,
           java.lang.String groupdef3,
           java.lang.String groupdef2,
           java.lang.String pk_om_duty,
           java.lang.String groupdef5,
           java.lang.String groupdef4,
           java.lang.String groupdef1,
           java.lang.String pk_jobdoc,
           java.lang.String jobrank,
           java.lang.String outcontact,
           java.lang.String pk_deptdoc,
           java.lang.String jobcode) {
           this.filepath = filepath;
           this.jobname = jobname;
           this.ts = ts;
           this.groupdef11 = groupdef11;
           this.groupdef12 = groupdef12;
           this.tospvise = tospvise;
           this.groupdef10 = groupdef10;
           this.groupdef15 = groupdef15;
           this.abortdate = abortdate;
           this.createcorp = createcorp;
           this.sm_changedate = sm_changedate;
           this.groupdef13 = groupdef13;
           this.groupdef14 = groupdef14;
           this.horisitu = horisitu;
           this.isdeptrespon = isdeptrespon;
           this.spike_sign = spike_sign;
           this.worksumm = worksumm;
           this.junior = junior;
           this.isabort = isabort;
           this.jobseries = jobseries;
           this.builddate = builddate;
           this.avicdef10 = avicdef10;
           this.avicdef1 = avicdef1;
           this.avicdef3 = avicdef3;
           this.avicdef2 = avicdef2;
           this.tableName = tableName;
           this.avicdef5 = avicdef5;
           this.avicdef4 = avicdef4;
           this.suporior = suporior;
           this.dr = dr;
           this.pk_corp = pk_corp;
           this.pk_om_job = pk_om_job;
           this.avicdef8 = avicdef8;
           this.incontact = incontact;
           this.avicdef9 = avicdef9;
           this.avicdef6 = avicdef6;
           this.avicdef7 = avicdef7;
           this.groupdef6 = groupdef6;
           this.groupdef7 = groupdef7;
           this.bespvised = bespvised;
           this.groupdef8 = groupdef8;
           this.groupdef9 = groupdef9;
           this.groupdef3 = groupdef3;
           this.groupdef2 = groupdef2;
           this.pk_om_duty = pk_om_duty;
           this.groupdef5 = groupdef5;
           this.groupdef4 = groupdef4;
           this.groupdef1 = groupdef1;
           this.pk_jobdoc = pk_jobdoc;
           this.jobrank = jobrank;
           this.outcontact = outcontact;
           this.pk_deptdoc = pk_deptdoc;
           this.jobcode = jobcode;
    }


    /**
     * Gets the filepath value for this Om_jobVO.
     * 
     * @return filepath
     */
    public java.lang.String getFilepath() {
        return filepath;
    }


    /**
     * Sets the filepath value for this Om_jobVO.
     * 
     * @param filepath
     */
    public void setFilepath(java.lang.String filepath) {
        this.filepath = filepath;
    }


    /**
     * Gets the jobname value for this Om_jobVO.
     * 
     * @return jobname
     */
    public java.lang.String getJobname() {
        return jobname;
    }


    /**
     * Sets the jobname value for this Om_jobVO.
     * 
     * @param jobname
     */
    public void setJobname(java.lang.String jobname) {
        this.jobname = jobname;
    }


    /**
     * Gets the ts value for this Om_jobVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Om_jobVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the groupdef11 value for this Om_jobVO.
     * 
     * @return groupdef11
     */
    public java.lang.String getGroupdef11() {
        return groupdef11;
    }


    /**
     * Sets the groupdef11 value for this Om_jobVO.
     * 
     * @param groupdef11
     */
    public void setGroupdef11(java.lang.String groupdef11) {
        this.groupdef11 = groupdef11;
    }


    /**
     * Gets the groupdef12 value for this Om_jobVO.
     * 
     * @return groupdef12
     */
    public java.lang.Long getGroupdef12() {
        return groupdef12;
    }


    /**
     * Sets the groupdef12 value for this Om_jobVO.
     * 
     * @param groupdef12
     */
    public void setGroupdef12(java.lang.Long groupdef12) {
        this.groupdef12 = groupdef12;
    }


    /**
     * Gets the tospvise value for this Om_jobVO.
     * 
     * @return tospvise
     */
    public java.lang.String getTospvise() {
        return tospvise;
    }


    /**
     * Sets the tospvise value for this Om_jobVO.
     * 
     * @param tospvise
     */
    public void setTospvise(java.lang.String tospvise) {
        this.tospvise = tospvise;
    }


    /**
     * Gets the groupdef10 value for this Om_jobVO.
     * 
     * @return groupdef10
     */
    public java.lang.String getGroupdef10() {
        return groupdef10;
    }


    /**
     * Sets the groupdef10 value for this Om_jobVO.
     * 
     * @param groupdef10
     */
    public void setGroupdef10(java.lang.String groupdef10) {
        this.groupdef10 = groupdef10;
    }


    /**
     * Gets the groupdef15 value for this Om_jobVO.
     * 
     * @return groupdef15
     */
    public java.lang.String getGroupdef15() {
        return groupdef15;
    }


    /**
     * Sets the groupdef15 value for this Om_jobVO.
     * 
     * @param groupdef15
     */
    public void setGroupdef15(java.lang.String groupdef15) {
        this.groupdef15 = groupdef15;
    }


    /**
     * Gets the abortdate value for this Om_jobVO.
     * 
     * @return abortdate
     */
    public java.lang.String getAbortdate() {
        return abortdate;
    }


    /**
     * Sets the abortdate value for this Om_jobVO.
     * 
     * @param abortdate
     */
    public void setAbortdate(java.lang.String abortdate) {
        this.abortdate = abortdate;
    }


    /**
     * Gets the createcorp value for this Om_jobVO.
     * 
     * @return createcorp
     */
    public java.lang.String getCreatecorp() {
        return createcorp;
    }


    /**
     * Sets the createcorp value for this Om_jobVO.
     * 
     * @param createcorp
     */
    public void setCreatecorp(java.lang.String createcorp) {
        this.createcorp = createcorp;
    }


    /**
     * Gets the sm_changedate value for this Om_jobVO.
     * 
     * @return sm_changedate
     */
    public java.lang.String getSm_changedate() {
        return sm_changedate;
    }


    /**
     * Sets the sm_changedate value for this Om_jobVO.
     * 
     * @param sm_changedate
     */
    public void setSm_changedate(java.lang.String sm_changedate) {
        this.sm_changedate = sm_changedate;
    }


    /**
     * Gets the groupdef13 value for this Om_jobVO.
     * 
     * @return groupdef13
     */
    public java.lang.String getGroupdef13() {
        return groupdef13;
    }


    /**
     * Sets the groupdef13 value for this Om_jobVO.
     * 
     * @param groupdef13
     */
    public void setGroupdef13(java.lang.String groupdef13) {
        this.groupdef13 = groupdef13;
    }


    /**
     * Gets the groupdef14 value for this Om_jobVO.
     * 
     * @return groupdef14
     */
    public java.lang.String getGroupdef14() {
        return groupdef14;
    }


    /**
     * Sets the groupdef14 value for this Om_jobVO.
     * 
     * @param groupdef14
     */
    public void setGroupdef14(java.lang.String groupdef14) {
        this.groupdef14 = groupdef14;
    }


    /**
     * Gets the horisitu value for this Om_jobVO.
     * 
     * @return horisitu
     */
    public java.lang.String getHorisitu() {
        return horisitu;
    }


    /**
     * Sets the horisitu value for this Om_jobVO.
     * 
     * @param horisitu
     */
    public void setHorisitu(java.lang.String horisitu) {
        this.horisitu = horisitu;
    }


    /**
     * Gets the isdeptrespon value for this Om_jobVO.
     * 
     * @return isdeptrespon
     */
    public java.lang.String getIsdeptrespon() {
        return isdeptrespon;
    }


    /**
     * Sets the isdeptrespon value for this Om_jobVO.
     * 
     * @param isdeptrespon
     */
    public void setIsdeptrespon(java.lang.String isdeptrespon) {
        this.isdeptrespon = isdeptrespon;
    }


    /**
     * Gets the spike_sign value for this Om_jobVO.
     * 
     * @return spike_sign
     */
    public java.lang.String getSpike_sign() {
        return spike_sign;
    }


    /**
     * Sets the spike_sign value for this Om_jobVO.
     * 
     * @param spike_sign
     */
    public void setSpike_sign(java.lang.String spike_sign) {
        this.spike_sign = spike_sign;
    }


    /**
     * Gets the worksumm value for this Om_jobVO.
     * 
     * @return worksumm
     */
    public java.lang.String getWorksumm() {
        return worksumm;
    }


    /**
     * Sets the worksumm value for this Om_jobVO.
     * 
     * @param worksumm
     */
    public void setWorksumm(java.lang.String worksumm) {
        this.worksumm = worksumm;
    }


    /**
     * Gets the junior value for this Om_jobVO.
     * 
     * @return junior
     */
    public java.lang.String getJunior() {
        return junior;
    }


    /**
     * Sets the junior value for this Om_jobVO.
     * 
     * @param junior
     */
    public void setJunior(java.lang.String junior) {
        this.junior = junior;
    }


    /**
     * Gets the isabort value for this Om_jobVO.
     * 
     * @return isabort
     */
    public java.lang.String getIsabort() {
        return isabort;
    }


    /**
     * Sets the isabort value for this Om_jobVO.
     * 
     * @param isabort
     */
    public void setIsabort(java.lang.String isabort) {
        this.isabort = isabort;
    }


    /**
     * Gets the jobseries value for this Om_jobVO.
     * 
     * @return jobseries
     */
    public java.lang.String getJobseries() {
        return jobseries;
    }


    /**
     * Sets the jobseries value for this Om_jobVO.
     * 
     * @param jobseries
     */
    public void setJobseries(java.lang.String jobseries) {
        this.jobseries = jobseries;
    }


    /**
     * Gets the builddate value for this Om_jobVO.
     * 
     * @return builddate
     */
    public java.lang.String getBuilddate() {
        return builddate;
    }


    /**
     * Sets the builddate value for this Om_jobVO.
     * 
     * @param builddate
     */
    public void setBuilddate(java.lang.String builddate) {
        this.builddate = builddate;
    }


    /**
     * Gets the avicdef10 value for this Om_jobVO.
     * 
     * @return avicdef10
     */
    public java.lang.String getAvicdef10() {
        return avicdef10;
    }


    /**
     * Sets the avicdef10 value for this Om_jobVO.
     * 
     * @param avicdef10
     */
    public void setAvicdef10(java.lang.String avicdef10) {
        this.avicdef10 = avicdef10;
    }


    /**
     * Gets the avicdef1 value for this Om_jobVO.
     * 
     * @return avicdef1
     */
    public java.lang.String getAvicdef1() {
        return avicdef1;
    }


    /**
     * Sets the avicdef1 value for this Om_jobVO.
     * 
     * @param avicdef1
     */
    public void setAvicdef1(java.lang.String avicdef1) {
        this.avicdef1 = avicdef1;
    }


    /**
     * Gets the avicdef3 value for this Om_jobVO.
     * 
     * @return avicdef3
     */
    public java.lang.String getAvicdef3() {
        return avicdef3;
    }


    /**
     * Sets the avicdef3 value for this Om_jobVO.
     * 
     * @param avicdef3
     */
    public void setAvicdef3(java.lang.String avicdef3) {
        this.avicdef3 = avicdef3;
    }


    /**
     * Gets the avicdef2 value for this Om_jobVO.
     * 
     * @return avicdef2
     */
    public java.lang.String getAvicdef2() {
        return avicdef2;
    }


    /**
     * Sets the avicdef2 value for this Om_jobVO.
     * 
     * @param avicdef2
     */
    public void setAvicdef2(java.lang.String avicdef2) {
        this.avicdef2 = avicdef2;
    }


    /**
     * Gets the tableName value for this Om_jobVO.
     * 
     * @return tableName
     */
    public java.lang.String getTableName() {
        return tableName;
    }


    /**
     * Sets the tableName value for this Om_jobVO.
     * 
     * @param tableName
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }


    /**
     * Gets the avicdef5 value for this Om_jobVO.
     * 
     * @return avicdef5
     */
    public java.lang.String getAvicdef5() {
        return avicdef5;
    }


    /**
     * Sets the avicdef5 value for this Om_jobVO.
     * 
     * @param avicdef5
     */
    public void setAvicdef5(java.lang.String avicdef5) {
        this.avicdef5 = avicdef5;
    }


    /**
     * Gets the avicdef4 value for this Om_jobVO.
     * 
     * @return avicdef4
     */
    public java.lang.String getAvicdef4() {
        return avicdef4;
    }


    /**
     * Sets the avicdef4 value for this Om_jobVO.
     * 
     * @param avicdef4
     */
    public void setAvicdef4(java.lang.String avicdef4) {
        this.avicdef4 = avicdef4;
    }


    /**
     * Gets the suporior value for this Om_jobVO.
     * 
     * @return suporior
     */
    public java.lang.String getSuporior() {
        return suporior;
    }


    /**
     * Sets the suporior value for this Om_jobVO.
     * 
     * @param suporior
     */
    public void setSuporior(java.lang.String suporior) {
        this.suporior = suporior;
    }


    /**
     * Gets the dr value for this Om_jobVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Om_jobVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }


    /**
     * Gets the pk_corp value for this Om_jobVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Om_jobVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the pk_om_job value for this Om_jobVO.
     * 
     * @return pk_om_job
     */
    public java.lang.String getPk_om_job() {
        return pk_om_job;
    }


    /**
     * Sets the pk_om_job value for this Om_jobVO.
     * 
     * @param pk_om_job
     */
    public void setPk_om_job(java.lang.String pk_om_job) {
        this.pk_om_job = pk_om_job;
    }


    /**
     * Gets the avicdef8 value for this Om_jobVO.
     * 
     * @return avicdef8
     */
    public java.lang.String getAvicdef8() {
        return avicdef8;
    }


    /**
     * Sets the avicdef8 value for this Om_jobVO.
     * 
     * @param avicdef8
     */
    public void setAvicdef8(java.lang.String avicdef8) {
        this.avicdef8 = avicdef8;
    }


    /**
     * Gets the incontact value for this Om_jobVO.
     * 
     * @return incontact
     */
    public java.lang.String getIncontact() {
        return incontact;
    }


    /**
     * Sets the incontact value for this Om_jobVO.
     * 
     * @param incontact
     */
    public void setIncontact(java.lang.String incontact) {
        this.incontact = incontact;
    }


    /**
     * Gets the avicdef9 value for this Om_jobVO.
     * 
     * @return avicdef9
     */
    public java.lang.String getAvicdef9() {
        return avicdef9;
    }


    /**
     * Sets the avicdef9 value for this Om_jobVO.
     * 
     * @param avicdef9
     */
    public void setAvicdef9(java.lang.String avicdef9) {
        this.avicdef9 = avicdef9;
    }


    /**
     * Gets the avicdef6 value for this Om_jobVO.
     * 
     * @return avicdef6
     */
    public java.lang.String getAvicdef6() {
        return avicdef6;
    }


    /**
     * Sets the avicdef6 value for this Om_jobVO.
     * 
     * @param avicdef6
     */
    public void setAvicdef6(java.lang.String avicdef6) {
        this.avicdef6 = avicdef6;
    }


    /**
     * Gets the avicdef7 value for this Om_jobVO.
     * 
     * @return avicdef7
     */
    public java.lang.String getAvicdef7() {
        return avicdef7;
    }


    /**
     * Sets the avicdef7 value for this Om_jobVO.
     * 
     * @param avicdef7
     */
    public void setAvicdef7(java.lang.String avicdef7) {
        this.avicdef7 = avicdef7;
    }


    /**
     * Gets the groupdef6 value for this Om_jobVO.
     * 
     * @return groupdef6
     */
    public java.lang.String getGroupdef6() {
        return groupdef6;
    }


    /**
     * Sets the groupdef6 value for this Om_jobVO.
     * 
     * @param groupdef6
     */
    public void setGroupdef6(java.lang.String groupdef6) {
        this.groupdef6 = groupdef6;
    }


    /**
     * Gets the groupdef7 value for this Om_jobVO.
     * 
     * @return groupdef7
     */
    public java.lang.String getGroupdef7() {
        return groupdef7;
    }


    /**
     * Sets the groupdef7 value for this Om_jobVO.
     * 
     * @param groupdef7
     */
    public void setGroupdef7(java.lang.String groupdef7) {
        this.groupdef7 = groupdef7;
    }


    /**
     * Gets the bespvised value for this Om_jobVO.
     * 
     * @return bespvised
     */
    public java.lang.String getBespvised() {
        return bespvised;
    }


    /**
     * Sets the bespvised value for this Om_jobVO.
     * 
     * @param bespvised
     */
    public void setBespvised(java.lang.String bespvised) {
        this.bespvised = bespvised;
    }


    /**
     * Gets the groupdef8 value for this Om_jobVO.
     * 
     * @return groupdef8
     */
    public java.lang.String getGroupdef8() {
        return groupdef8;
    }


    /**
     * Sets the groupdef8 value for this Om_jobVO.
     * 
     * @param groupdef8
     */
    public void setGroupdef8(java.lang.String groupdef8) {
        this.groupdef8 = groupdef8;
    }


    /**
     * Gets the groupdef9 value for this Om_jobVO.
     * 
     * @return groupdef9
     */
    public java.lang.String getGroupdef9() {
        return groupdef9;
    }


    /**
     * Sets the groupdef9 value for this Om_jobVO.
     * 
     * @param groupdef9
     */
    public void setGroupdef9(java.lang.String groupdef9) {
        this.groupdef9 = groupdef9;
    }


    /**
     * Gets the groupdef3 value for this Om_jobVO.
     * 
     * @return groupdef3
     */
    public java.lang.String getGroupdef3() {
        return groupdef3;
    }


    /**
     * Sets the groupdef3 value for this Om_jobVO.
     * 
     * @param groupdef3
     */
    public void setGroupdef3(java.lang.String groupdef3) {
        this.groupdef3 = groupdef3;
    }


    /**
     * Gets the groupdef2 value for this Om_jobVO.
     * 
     * @return groupdef2
     */
    public java.lang.String getGroupdef2() {
        return groupdef2;
    }


    /**
     * Sets the groupdef2 value for this Om_jobVO.
     * 
     * @param groupdef2
     */
    public void setGroupdef2(java.lang.String groupdef2) {
        this.groupdef2 = groupdef2;
    }


    /**
     * Gets the pk_om_duty value for this Om_jobVO.
     * 
     * @return pk_om_duty
     */
    public java.lang.String getPk_om_duty() {
        return pk_om_duty;
    }


    /**
     * Sets the pk_om_duty value for this Om_jobVO.
     * 
     * @param pk_om_duty
     */
    public void setPk_om_duty(java.lang.String pk_om_duty) {
        this.pk_om_duty = pk_om_duty;
    }


    /**
     * Gets the groupdef5 value for this Om_jobVO.
     * 
     * @return groupdef5
     */
    public java.lang.String getGroupdef5() {
        return groupdef5;
    }


    /**
     * Sets the groupdef5 value for this Om_jobVO.
     * 
     * @param groupdef5
     */
    public void setGroupdef5(java.lang.String groupdef5) {
        this.groupdef5 = groupdef5;
    }


    /**
     * Gets the groupdef4 value for this Om_jobVO.
     * 
     * @return groupdef4
     */
    public java.lang.String getGroupdef4() {
        return groupdef4;
    }


    /**
     * Sets the groupdef4 value for this Om_jobVO.
     * 
     * @param groupdef4
     */
    public void setGroupdef4(java.lang.String groupdef4) {
        this.groupdef4 = groupdef4;
    }


    /**
     * Gets the groupdef1 value for this Om_jobVO.
     * 
     * @return groupdef1
     */
    public java.lang.String getGroupdef1() {
        return groupdef1;
    }


    /**
     * Sets the groupdef1 value for this Om_jobVO.
     * 
     * @param groupdef1
     */
    public void setGroupdef1(java.lang.String groupdef1) {
        this.groupdef1 = groupdef1;
    }


    /**
     * Gets the pk_jobdoc value for this Om_jobVO.
     * 
     * @return pk_jobdoc
     */
    public java.lang.String getPk_jobdoc() {
        return pk_jobdoc;
    }


    /**
     * Sets the pk_jobdoc value for this Om_jobVO.
     * 
     * @param pk_jobdoc
     */
    public void setPk_jobdoc(java.lang.String pk_jobdoc) {
        this.pk_jobdoc = pk_jobdoc;
    }


    /**
     * Gets the jobrank value for this Om_jobVO.
     * 
     * @return jobrank
     */
    public java.lang.String getJobrank() {
        return jobrank;
    }


    /**
     * Sets the jobrank value for this Om_jobVO.
     * 
     * @param jobrank
     */
    public void setJobrank(java.lang.String jobrank) {
        this.jobrank = jobrank;
    }


    /**
     * Gets the outcontact value for this Om_jobVO.
     * 
     * @return outcontact
     */
    public java.lang.String getOutcontact() {
        return outcontact;
    }


    /**
     * Sets the outcontact value for this Om_jobVO.
     * 
     * @param outcontact
     */
    public void setOutcontact(java.lang.String outcontact) {
        this.outcontact = outcontact;
    }


    /**
     * Gets the pk_deptdoc value for this Om_jobVO.
     * 
     * @return pk_deptdoc
     */
    public java.lang.String getPk_deptdoc() {
        return pk_deptdoc;
    }


    /**
     * Sets the pk_deptdoc value for this Om_jobVO.
     * 
     * @param pk_deptdoc
     */
    public void setPk_deptdoc(java.lang.String pk_deptdoc) {
        this.pk_deptdoc = pk_deptdoc;
    }


    /**
     * Gets the jobcode value for this Om_jobVO.
     * 
     * @return jobcode
     */
    public java.lang.String getJobcode() {
        return jobcode;
    }


    /**
     * Sets the jobcode value for this Om_jobVO.
     * 
     * @param jobcode
     */
    public void setJobcode(java.lang.String jobcode) {
        this.jobcode = jobcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Om_jobVO)) return false;
        Om_jobVO other = (Om_jobVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filepath==null && other.getFilepath()==null) || 
             (this.filepath!=null &&
              this.filepath.equals(other.getFilepath()))) &&
            ((this.jobname==null && other.getJobname()==null) || 
             (this.jobname!=null &&
              this.jobname.equals(other.getJobname()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
            ((this.groupdef11==null && other.getGroupdef11()==null) || 
             (this.groupdef11!=null &&
              this.groupdef11.equals(other.getGroupdef11()))) &&
            ((this.groupdef12==null && other.getGroupdef12()==null) || 
             (this.groupdef12!=null &&
              this.groupdef12.equals(other.getGroupdef12()))) &&
            ((this.tospvise==null && other.getTospvise()==null) || 
             (this.tospvise!=null &&
              this.tospvise.equals(other.getTospvise()))) &&
            ((this.groupdef10==null && other.getGroupdef10()==null) || 
             (this.groupdef10!=null &&
              this.groupdef10.equals(other.getGroupdef10()))) &&
            ((this.groupdef15==null && other.getGroupdef15()==null) || 
             (this.groupdef15!=null &&
              this.groupdef15.equals(other.getGroupdef15()))) &&
            ((this.abortdate==null && other.getAbortdate()==null) || 
             (this.abortdate!=null &&
              this.abortdate.equals(other.getAbortdate()))) &&
            ((this.createcorp==null && other.getCreatecorp()==null) || 
             (this.createcorp!=null &&
              this.createcorp.equals(other.getCreatecorp()))) &&
            ((this.sm_changedate==null && other.getSm_changedate()==null) || 
             (this.sm_changedate!=null &&
              this.sm_changedate.equals(other.getSm_changedate()))) &&
            ((this.groupdef13==null && other.getGroupdef13()==null) || 
             (this.groupdef13!=null &&
              this.groupdef13.equals(other.getGroupdef13()))) &&
            ((this.groupdef14==null && other.getGroupdef14()==null) || 
             (this.groupdef14!=null &&
              this.groupdef14.equals(other.getGroupdef14()))) &&
            ((this.horisitu==null && other.getHorisitu()==null) || 
             (this.horisitu!=null &&
              this.horisitu.equals(other.getHorisitu()))) &&
            ((this.isdeptrespon==null && other.getIsdeptrespon()==null) || 
             (this.isdeptrespon!=null &&
              this.isdeptrespon.equals(other.getIsdeptrespon()))) &&
            ((this.spike_sign==null && other.getSpike_sign()==null) || 
             (this.spike_sign!=null &&
              this.spike_sign.equals(other.getSpike_sign()))) &&
            ((this.worksumm==null && other.getWorksumm()==null) || 
             (this.worksumm!=null &&
              this.worksumm.equals(other.getWorksumm()))) &&
            ((this.junior==null && other.getJunior()==null) || 
             (this.junior!=null &&
              this.junior.equals(other.getJunior()))) &&
            ((this.isabort==null && other.getIsabort()==null) || 
             (this.isabort!=null &&
              this.isabort.equals(other.getIsabort()))) &&
            ((this.jobseries==null && other.getJobseries()==null) || 
             (this.jobseries!=null &&
              this.jobseries.equals(other.getJobseries()))) &&
            ((this.builddate==null && other.getBuilddate()==null) || 
             (this.builddate!=null &&
              this.builddate.equals(other.getBuilddate()))) &&
            ((this.avicdef10==null && other.getAvicdef10()==null) || 
             (this.avicdef10!=null &&
              this.avicdef10.equals(other.getAvicdef10()))) &&
            ((this.avicdef1==null && other.getAvicdef1()==null) || 
             (this.avicdef1!=null &&
              this.avicdef1.equals(other.getAvicdef1()))) &&
            ((this.avicdef3==null && other.getAvicdef3()==null) || 
             (this.avicdef3!=null &&
              this.avicdef3.equals(other.getAvicdef3()))) &&
            ((this.avicdef2==null && other.getAvicdef2()==null) || 
             (this.avicdef2!=null &&
              this.avicdef2.equals(other.getAvicdef2()))) &&
            ((this.tableName==null && other.getTableName()==null) || 
             (this.tableName!=null &&
              this.tableName.equals(other.getTableName()))) &&
            ((this.avicdef5==null && other.getAvicdef5()==null) || 
             (this.avicdef5!=null &&
              this.avicdef5.equals(other.getAvicdef5()))) &&
            ((this.avicdef4==null && other.getAvicdef4()==null) || 
             (this.avicdef4!=null &&
              this.avicdef4.equals(other.getAvicdef4()))) &&
            ((this.suporior==null && other.getSuporior()==null) || 
             (this.suporior!=null &&
              this.suporior.equals(other.getSuporior()))) &&
            ((this.dr==null && other.getDr()==null) || 
             (this.dr!=null &&
              this.dr.equals(other.getDr()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.pk_om_job==null && other.getPk_om_job()==null) || 
             (this.pk_om_job!=null &&
              this.pk_om_job.equals(other.getPk_om_job()))) &&
            ((this.avicdef8==null && other.getAvicdef8()==null) || 
             (this.avicdef8!=null &&
              this.avicdef8.equals(other.getAvicdef8()))) &&
            ((this.incontact==null && other.getIncontact()==null) || 
             (this.incontact!=null &&
              this.incontact.equals(other.getIncontact()))) &&
            ((this.avicdef9==null && other.getAvicdef9()==null) || 
             (this.avicdef9!=null &&
              this.avicdef9.equals(other.getAvicdef9()))) &&
            ((this.avicdef6==null && other.getAvicdef6()==null) || 
             (this.avicdef6!=null &&
              this.avicdef6.equals(other.getAvicdef6()))) &&
            ((this.avicdef7==null && other.getAvicdef7()==null) || 
             (this.avicdef7!=null &&
              this.avicdef7.equals(other.getAvicdef7()))) &&
            ((this.groupdef6==null && other.getGroupdef6()==null) || 
             (this.groupdef6!=null &&
              this.groupdef6.equals(other.getGroupdef6()))) &&
            ((this.groupdef7==null && other.getGroupdef7()==null) || 
             (this.groupdef7!=null &&
              this.groupdef7.equals(other.getGroupdef7()))) &&
            ((this.bespvised==null && other.getBespvised()==null) || 
             (this.bespvised!=null &&
              this.bespvised.equals(other.getBespvised()))) &&
            ((this.groupdef8==null && other.getGroupdef8()==null) || 
             (this.groupdef8!=null &&
              this.groupdef8.equals(other.getGroupdef8()))) &&
            ((this.groupdef9==null && other.getGroupdef9()==null) || 
             (this.groupdef9!=null &&
              this.groupdef9.equals(other.getGroupdef9()))) &&
            ((this.groupdef3==null && other.getGroupdef3()==null) || 
             (this.groupdef3!=null &&
              this.groupdef3.equals(other.getGroupdef3()))) &&
            ((this.groupdef2==null && other.getGroupdef2()==null) || 
             (this.groupdef2!=null &&
              this.groupdef2.equals(other.getGroupdef2()))) &&
            ((this.pk_om_duty==null && other.getPk_om_duty()==null) || 
             (this.pk_om_duty!=null &&
              this.pk_om_duty.equals(other.getPk_om_duty()))) &&
            ((this.groupdef5==null && other.getGroupdef5()==null) || 
             (this.groupdef5!=null &&
              this.groupdef5.equals(other.getGroupdef5()))) &&
            ((this.groupdef4==null && other.getGroupdef4()==null) || 
             (this.groupdef4!=null &&
              this.groupdef4.equals(other.getGroupdef4()))) &&
            ((this.groupdef1==null && other.getGroupdef1()==null) || 
             (this.groupdef1!=null &&
              this.groupdef1.equals(other.getGroupdef1()))) &&
            ((this.pk_jobdoc==null && other.getPk_jobdoc()==null) || 
             (this.pk_jobdoc!=null &&
              this.pk_jobdoc.equals(other.getPk_jobdoc()))) &&
            ((this.jobrank==null && other.getJobrank()==null) || 
             (this.jobrank!=null &&
              this.jobrank.equals(other.getJobrank()))) &&
            ((this.outcontact==null && other.getOutcontact()==null) || 
             (this.outcontact!=null &&
              this.outcontact.equals(other.getOutcontact()))) &&
            ((this.pk_deptdoc==null && other.getPk_deptdoc()==null) || 
             (this.pk_deptdoc!=null &&
              this.pk_deptdoc.equals(other.getPk_deptdoc()))) &&
            ((this.jobcode==null && other.getJobcode()==null) || 
             (this.jobcode!=null &&
              this.jobcode.equals(other.getJobcode())));
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
        if (getFilepath() != null) {
            _hashCode += getFilepath().hashCode();
        }
        if (getJobname() != null) {
            _hashCode += getJobname().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getGroupdef11() != null) {
            _hashCode += getGroupdef11().hashCode();
        }
        if (getGroupdef12() != null) {
            _hashCode += getGroupdef12().hashCode();
        }
        if (getTospvise() != null) {
            _hashCode += getTospvise().hashCode();
        }
        if (getGroupdef10() != null) {
            _hashCode += getGroupdef10().hashCode();
        }
        if (getGroupdef15() != null) {
            _hashCode += getGroupdef15().hashCode();
        }
        if (getAbortdate() != null) {
            _hashCode += getAbortdate().hashCode();
        }
        if (getCreatecorp() != null) {
            _hashCode += getCreatecorp().hashCode();
        }
        if (getSm_changedate() != null) {
            _hashCode += getSm_changedate().hashCode();
        }
        if (getGroupdef13() != null) {
            _hashCode += getGroupdef13().hashCode();
        }
        if (getGroupdef14() != null) {
            _hashCode += getGroupdef14().hashCode();
        }
        if (getHorisitu() != null) {
            _hashCode += getHorisitu().hashCode();
        }
        if (getIsdeptrespon() != null) {
            _hashCode += getIsdeptrespon().hashCode();
        }
        if (getSpike_sign() != null) {
            _hashCode += getSpike_sign().hashCode();
        }
        if (getWorksumm() != null) {
            _hashCode += getWorksumm().hashCode();
        }
        if (getJunior() != null) {
            _hashCode += getJunior().hashCode();
        }
        if (getIsabort() != null) {
            _hashCode += getIsabort().hashCode();
        }
        if (getJobseries() != null) {
            _hashCode += getJobseries().hashCode();
        }
        if (getBuilddate() != null) {
            _hashCode += getBuilddate().hashCode();
        }
        if (getAvicdef10() != null) {
            _hashCode += getAvicdef10().hashCode();
        }
        if (getAvicdef1() != null) {
            _hashCode += getAvicdef1().hashCode();
        }
        if (getAvicdef3() != null) {
            _hashCode += getAvicdef3().hashCode();
        }
        if (getAvicdef2() != null) {
            _hashCode += getAvicdef2().hashCode();
        }
        if (getTableName() != null) {
            _hashCode += getTableName().hashCode();
        }
        if (getAvicdef5() != null) {
            _hashCode += getAvicdef5().hashCode();
        }
        if (getAvicdef4() != null) {
            _hashCode += getAvicdef4().hashCode();
        }
        if (getSuporior() != null) {
            _hashCode += getSuporior().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getPk_om_job() != null) {
            _hashCode += getPk_om_job().hashCode();
        }
        if (getAvicdef8() != null) {
            _hashCode += getAvicdef8().hashCode();
        }
        if (getIncontact() != null) {
            _hashCode += getIncontact().hashCode();
        }
        if (getAvicdef9() != null) {
            _hashCode += getAvicdef9().hashCode();
        }
        if (getAvicdef6() != null) {
            _hashCode += getAvicdef6().hashCode();
        }
        if (getAvicdef7() != null) {
            _hashCode += getAvicdef7().hashCode();
        }
        if (getGroupdef6() != null) {
            _hashCode += getGroupdef6().hashCode();
        }
        if (getGroupdef7() != null) {
            _hashCode += getGroupdef7().hashCode();
        }
        if (getBespvised() != null) {
            _hashCode += getBespvised().hashCode();
        }
        if (getGroupdef8() != null) {
            _hashCode += getGroupdef8().hashCode();
        }
        if (getGroupdef9() != null) {
            _hashCode += getGroupdef9().hashCode();
        }
        if (getGroupdef3() != null) {
            _hashCode += getGroupdef3().hashCode();
        }
        if (getGroupdef2() != null) {
            _hashCode += getGroupdef2().hashCode();
        }
        if (getPk_om_duty() != null) {
            _hashCode += getPk_om_duty().hashCode();
        }
        if (getGroupdef5() != null) {
            _hashCode += getGroupdef5().hashCode();
        }
        if (getGroupdef4() != null) {
            _hashCode += getGroupdef4().hashCode();
        }
        if (getGroupdef1() != null) {
            _hashCode += getGroupdef1().hashCode();
        }
        if (getPk_jobdoc() != null) {
            _hashCode += getPk_jobdoc().hashCode();
        }
        if (getJobrank() != null) {
            _hashCode += getJobrank().hashCode();
        }
        if (getOutcontact() != null) {
            _hashCode += getOutcontact().hashCode();
        }
        if (getPk_deptdoc() != null) {
            _hashCode += getPk_deptdoc().hashCode();
        }
        if (getJobcode() != null) {
            _hashCode += getJobcode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Om_jobVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://om.vo.ws.nc/Om_jobVO", "Om_jobVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filepath");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filepath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("jobname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobname"));
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
        elemField.setFieldName("groupdef11");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef11"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("groupdef12");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef12"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tospvise");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tospvise"));
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
        elemField.setFieldName("abortdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "abortdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createcorp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "createcorp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sm_changedate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sm_changedate"));
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
        elemField.setFieldName("horisitu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "horisitu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isdeptrespon");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isdeptrespon"));
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
        elemField.setFieldName("worksumm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "worksumm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("junior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "junior"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isabort");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isabort"));
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
        elemField.setFieldName("builddate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "builddate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef10");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef10"));
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
        elemField.setFieldName("avicdef3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef2"));
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
        elemField.setFieldName("avicdef5");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef5"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("suporior");
        elemField.setXmlName(new javax.xml.namespace.QName("", "suporior"));
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
        elemField.setFieldName("pk_corp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_corp"));
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
        elemField.setFieldName("avicdef8");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef8"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("incontact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "incontact"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef9"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef6");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef6"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("avicdef7");
        elemField.setXmlName(new javax.xml.namespace.QName("", "avicdef7"));
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
        elemField.setFieldName("bespvised");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bespvised"));
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
        elemField.setFieldName("groupdef9");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef9"));
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
        elemField.setFieldName("pk_om_duty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_om_duty"));
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
        elemField.setFieldName("groupdef1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "groupdef1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_jobdoc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_jobdoc"));
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
        elemField.setFieldName("outcontact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "outcontact"));
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
        elemField.setFieldName("jobcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "jobcode"));
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

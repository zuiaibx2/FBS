/**
 * Wa_dataVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.wa;

public class Wa_dataVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String ts;

    private java.lang.String bankid;

    private java.lang.String psnid;

    private java.lang.String anbonusflag;

    private java.lang.String taxtableid;

    private java.lang.String cperiod;

    private java.lang.String deptid;

    private java.lang.Long cyear;

    private java.lang.String pk_psndoc_sub;

    private java.lang.String tableName;

    private java.lang.Double icheckflag;

    private java.lang.Double d_14;

    private java.lang.String nestpk_om_job;

    private java.lang.Double istopflag;

    private java.lang.Double d_12;

    private java.lang.Double d_13;

    private java.lang.Double d_11;

    private java.lang.String psnclid;

    private java.lang.Double itaxflag;

    private java.lang.String classid;

    private java.lang.Integer dr;

    private java.lang.Double irecheckflag;

    private java.lang.String pk_wa_data;

    private java.lang.String pk_corp;

    private java.lang.String cnestyear;

    private java.lang.String nestdeptid;

    private java.lang.String pk_om_job;

    private java.lang.String spike_sign;

    private java.lang.String cnestperiod;

    private java.lang.Double irecaculateflag;

    private java.lang.Double ipartflag;

    private java.lang.String pk_psnbasdoc;

    private java.lang.Double redtotal;

    private java.lang.Double d_23;

    private java.lang.Double d_24;

    private java.lang.Double d_25;

    private java.lang.String vacccode;

    private java.lang.Double d_26;

    private java.lang.String wa_data_object_id;

    private java.lang.Double f_2;

    private java.lang.Double f_1;

    private java.lang.Double d_21;

    private java.lang.String nestpsnclid;

    private java.lang.Double f_4;

    private java.lang.Double d_22;

    private java.lang.Double f_3;

    public Wa_dataVO() {
    }

    public Wa_dataVO(
           java.lang.String ts,
           java.lang.String bankid,
           java.lang.String psnid,
           java.lang.String anbonusflag,
           java.lang.String taxtableid,
           java.lang.String cperiod,
           java.lang.String deptid,
           java.lang.Long cyear,
           java.lang.String pk_psndoc_sub,
           java.lang.String tableName,
           java.lang.Double icheckflag,
           java.lang.Double d_14,
           java.lang.String nestpk_om_job,
           java.lang.Double istopflag,
           java.lang.Double d_12,
           java.lang.Double d_13,
           java.lang.Double d_11,
           java.lang.String psnclid,
           java.lang.Double itaxflag,
           java.lang.String classid,
           java.lang.Integer dr,
           java.lang.Double irecheckflag,
           java.lang.String pk_wa_data,
           java.lang.String pk_corp,
           java.lang.String cnestyear,
           java.lang.String nestdeptid,
           java.lang.String pk_om_job,
           java.lang.String spike_sign,
           java.lang.String cnestperiod,
           java.lang.Double irecaculateflag,
           java.lang.Double ipartflag,
           java.lang.String pk_psnbasdoc,
           java.lang.Double redtotal,
           java.lang.Double d_23,
           java.lang.Double d_24,
           java.lang.Double d_25,
           java.lang.String vacccode,
           java.lang.Double d_26,
           java.lang.String wa_data_object_id,
           java.lang.Double f_2,
           java.lang.Double f_1,
           java.lang.Double d_21,
           java.lang.String nestpsnclid,
           java.lang.Double f_4,
           java.lang.Double d_22,
           java.lang.Double f_3) {
           this.ts = ts;
           this.bankid = bankid;
           this.psnid = psnid;
           this.anbonusflag = anbonusflag;
           this.taxtableid = taxtableid;
           this.cperiod = cperiod;
           this.deptid = deptid;
           this.cyear = cyear;
           this.pk_psndoc_sub = pk_psndoc_sub;
           this.tableName = tableName;
           this.icheckflag = icheckflag;
           this.d_14 = d_14;
           this.nestpk_om_job = nestpk_om_job;
           this.istopflag = istopflag;
           this.d_12 = d_12;
           this.d_13 = d_13;
           this.d_11 = d_11;
           this.psnclid = psnclid;
           this.itaxflag = itaxflag;
           this.classid = classid;
           this.dr = dr;
           this.irecheckflag = irecheckflag;
           this.pk_wa_data = pk_wa_data;
           this.pk_corp = pk_corp;
           this.cnestyear = cnestyear;
           this.nestdeptid = nestdeptid;
           this.pk_om_job = pk_om_job;
           this.spike_sign = spike_sign;
           this.cnestperiod = cnestperiod;
           this.irecaculateflag = irecaculateflag;
           this.ipartflag = ipartflag;
           this.pk_psnbasdoc = pk_psnbasdoc;
           this.redtotal = redtotal;
           this.d_23 = d_23;
           this.d_24 = d_24;
           this.d_25 = d_25;
           this.vacccode = vacccode;
           this.d_26 = d_26;
           this.wa_data_object_id = wa_data_object_id;
           this.f_2 = f_2;
           this.f_1 = f_1;
           this.d_21 = d_21;
           this.nestpsnclid = nestpsnclid;
           this.f_4 = f_4;
           this.d_22 = d_22;
           this.f_3 = f_3;
    }


    /**
     * Gets the ts value for this Wa_dataVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Wa_dataVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the bankid value for this Wa_dataVO.
     * 
     * @return bankid
     */
    public java.lang.String getBankid() {
        return bankid;
    }


    /**
     * Sets the bankid value for this Wa_dataVO.
     * 
     * @param bankid
     */
    public void setBankid(java.lang.String bankid) {
        this.bankid = bankid;
    }


    /**
     * Gets the psnid value for this Wa_dataVO.
     * 
     * @return psnid
     */
    public java.lang.String getPsnid() {
        return psnid;
    }


    /**
     * Sets the psnid value for this Wa_dataVO.
     * 
     * @param psnid
     */
    public void setPsnid(java.lang.String psnid) {
        this.psnid = psnid;
    }


    /**
     * Gets the anbonusflag value for this Wa_dataVO.
     * 
     * @return anbonusflag
     */
    public java.lang.String getAnbonusflag() {
        return anbonusflag;
    }


    /**
     * Sets the anbonusflag value for this Wa_dataVO.
     * 
     * @param anbonusflag
     */
    public void setAnbonusflag(java.lang.String anbonusflag) {
        this.anbonusflag = anbonusflag;
    }


    /**
     * Gets the taxtableid value for this Wa_dataVO.
     * 
     * @return taxtableid
     */
    public java.lang.String getTaxtableid() {
        return taxtableid;
    }


    /**
     * Sets the taxtableid value for this Wa_dataVO.
     * 
     * @param taxtableid
     */
    public void setTaxtableid(java.lang.String taxtableid) {
        this.taxtableid = taxtableid;
    }


    /**
     * Gets the cperiod value for this Wa_dataVO.
     * 
     * @return cperiod
     */
    public java.lang.String getCperiod() {
        return cperiod;
    }


    /**
     * Sets the cperiod value for this Wa_dataVO.
     * 
     * @param cperiod
     */
    public void setCperiod(java.lang.String cperiod) {
        this.cperiod = cperiod;
    }


    /**
     * Gets the deptid value for this Wa_dataVO.
     * 
     * @return deptid
     */
    public java.lang.String getDeptid() {
        return deptid;
    }


    /**
     * Sets the deptid value for this Wa_dataVO.
     * 
     * @param deptid
     */
    public void setDeptid(java.lang.String deptid) {
        this.deptid = deptid;
    }


    /**
     * Gets the cyear value for this Wa_dataVO.
     * 
     * @return cyear
     */
    public java.lang.Long getCyear() {
        return cyear;
    }


    /**
     * Sets the cyear value for this Wa_dataVO.
     * 
     * @param cyear
     */
    public void setCyear(java.lang.Long cyear) {
        this.cyear = cyear;
    }


    /**
     * Gets the pk_psndoc_sub value for this Wa_dataVO.
     * 
     * @return pk_psndoc_sub
     */
    public java.lang.String getPk_psndoc_sub() {
        return pk_psndoc_sub;
    }


    /**
     * Sets the pk_psndoc_sub value for this Wa_dataVO.
     * 
     * @param pk_psndoc_sub
     */
    public void setPk_psndoc_sub(java.lang.String pk_psndoc_sub) {
        this.pk_psndoc_sub = pk_psndoc_sub;
    }


    /**
     * Gets the tableName value for this Wa_dataVO.
     * 
     * @return tableName
     */
    public java.lang.String getTableName() {
        return tableName;
    }


    /**
     * Sets the tableName value for this Wa_dataVO.
     * 
     * @param tableName
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }


    /**
     * Gets the icheckflag value for this Wa_dataVO.
     * 
     * @return icheckflag
     */
    public java.lang.Double getIcheckflag() {
        return icheckflag;
    }


    /**
     * Sets the icheckflag value for this Wa_dataVO.
     * 
     * @param icheckflag
     */
    public void setIcheckflag(java.lang.Double icheckflag) {
        this.icheckflag = icheckflag;
    }


    /**
     * Gets the d_14 value for this Wa_dataVO.
     * 
     * @return d_14
     */
    public java.lang.Double getD_14() {
        return d_14;
    }


    /**
     * Sets the d_14 value for this Wa_dataVO.
     * 
     * @param d_14
     */
    public void setD_14(java.lang.Double d_14) {
        this.d_14 = d_14;
    }


    /**
     * Gets the nestpk_om_job value for this Wa_dataVO.
     * 
     * @return nestpk_om_job
     */
    public java.lang.String getNestpk_om_job() {
        return nestpk_om_job;
    }


    /**
     * Sets the nestpk_om_job value for this Wa_dataVO.
     * 
     * @param nestpk_om_job
     */
    public void setNestpk_om_job(java.lang.String nestpk_om_job) {
        this.nestpk_om_job = nestpk_om_job;
    }


    /**
     * Gets the istopflag value for this Wa_dataVO.
     * 
     * @return istopflag
     */
    public java.lang.Double getIstopflag() {
        return istopflag;
    }


    /**
     * Sets the istopflag value for this Wa_dataVO.
     * 
     * @param istopflag
     */
    public void setIstopflag(java.lang.Double istopflag) {
        this.istopflag = istopflag;
    }


    /**
     * Gets the d_12 value for this Wa_dataVO.
     * 
     * @return d_12
     */
    public java.lang.Double getD_12() {
        return d_12;
    }


    /**
     * Sets the d_12 value for this Wa_dataVO.
     * 
     * @param d_12
     */
    public void setD_12(java.lang.Double d_12) {
        this.d_12 = d_12;
    }


    /**
     * Gets the d_13 value for this Wa_dataVO.
     * 
     * @return d_13
     */
    public java.lang.Double getD_13() {
        return d_13;
    }


    /**
     * Sets the d_13 value for this Wa_dataVO.
     * 
     * @param d_13
     */
    public void setD_13(java.lang.Double d_13) {
        this.d_13 = d_13;
    }


    /**
     * Gets the d_11 value for this Wa_dataVO.
     * 
     * @return d_11
     */
    public java.lang.Double getD_11() {
        return d_11;
    }


    /**
     * Sets the d_11 value for this Wa_dataVO.
     * 
     * @param d_11
     */
    public void setD_11(java.lang.Double d_11) {
        this.d_11 = d_11;
    }


    /**
     * Gets the psnclid value for this Wa_dataVO.
     * 
     * @return psnclid
     */
    public java.lang.String getPsnclid() {
        return psnclid;
    }


    /**
     * Sets the psnclid value for this Wa_dataVO.
     * 
     * @param psnclid
     */
    public void setPsnclid(java.lang.String psnclid) {
        this.psnclid = psnclid;
    }


    /**
     * Gets the itaxflag value for this Wa_dataVO.
     * 
     * @return itaxflag
     */
    public java.lang.Double getItaxflag() {
        return itaxflag;
    }


    /**
     * Sets the itaxflag value for this Wa_dataVO.
     * 
     * @param itaxflag
     */
    public void setItaxflag(java.lang.Double itaxflag) {
        this.itaxflag = itaxflag;
    }


    /**
     * Gets the classid value for this Wa_dataVO.
     * 
     * @return classid
     */
    public java.lang.String getClassid() {
        return classid;
    }


    /**
     * Sets the classid value for this Wa_dataVO.
     * 
     * @param classid
     */
    public void setClassid(java.lang.String classid) {
        this.classid = classid;
    }


    /**
     * Gets the dr value for this Wa_dataVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Wa_dataVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }


    /**
     * Gets the irecheckflag value for this Wa_dataVO.
     * 
     * @return irecheckflag
     */
    public java.lang.Double getIrecheckflag() {
        return irecheckflag;
    }


    /**
     * Sets the irecheckflag value for this Wa_dataVO.
     * 
     * @param irecheckflag
     */
    public void setIrecheckflag(java.lang.Double irecheckflag) {
        this.irecheckflag = irecheckflag;
    }


    /**
     * Gets the pk_wa_data value for this Wa_dataVO.
     * 
     * @return pk_wa_data
     */
    public java.lang.String getPk_wa_data() {
        return pk_wa_data;
    }


    /**
     * Sets the pk_wa_data value for this Wa_dataVO.
     * 
     * @param pk_wa_data
     */
    public void setPk_wa_data(java.lang.String pk_wa_data) {
        this.pk_wa_data = pk_wa_data;
    }


    /**
     * Gets the pk_corp value for this Wa_dataVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Wa_dataVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the cnestyear value for this Wa_dataVO.
     * 
     * @return cnestyear
     */
    public java.lang.String getCnestyear() {
        return cnestyear;
    }


    /**
     * Sets the cnestyear value for this Wa_dataVO.
     * 
     * @param cnestyear
     */
    public void setCnestyear(java.lang.String cnestyear) {
        this.cnestyear = cnestyear;
    }


    /**
     * Gets the nestdeptid value for this Wa_dataVO.
     * 
     * @return nestdeptid
     */
    public java.lang.String getNestdeptid() {
        return nestdeptid;
    }


    /**
     * Sets the nestdeptid value for this Wa_dataVO.
     * 
     * @param nestdeptid
     */
    public void setNestdeptid(java.lang.String nestdeptid) {
        this.nestdeptid = nestdeptid;
    }


    /**
     * Gets the pk_om_job value for this Wa_dataVO.
     * 
     * @return pk_om_job
     */
    public java.lang.String getPk_om_job() {
        return pk_om_job;
    }


    /**
     * Sets the pk_om_job value for this Wa_dataVO.
     * 
     * @param pk_om_job
     */
    public void setPk_om_job(java.lang.String pk_om_job) {
        this.pk_om_job = pk_om_job;
    }


    /**
     * Gets the spike_sign value for this Wa_dataVO.
     * 
     * @return spike_sign
     */
    public java.lang.String getSpike_sign() {
        return spike_sign;
    }


    /**
     * Sets the spike_sign value for this Wa_dataVO.
     * 
     * @param spike_sign
     */
    public void setSpike_sign(java.lang.String spike_sign) {
        this.spike_sign = spike_sign;
    }


    /**
     * Gets the cnestperiod value for this Wa_dataVO.
     * 
     * @return cnestperiod
     */
    public java.lang.String getCnestperiod() {
        return cnestperiod;
    }


    /**
     * Sets the cnestperiod value for this Wa_dataVO.
     * 
     * @param cnestperiod
     */
    public void setCnestperiod(java.lang.String cnestperiod) {
        this.cnestperiod = cnestperiod;
    }


    /**
     * Gets the irecaculateflag value for this Wa_dataVO.
     * 
     * @return irecaculateflag
     */
    public java.lang.Double getIrecaculateflag() {
        return irecaculateflag;
    }


    /**
     * Sets the irecaculateflag value for this Wa_dataVO.
     * 
     * @param irecaculateflag
     */
    public void setIrecaculateflag(java.lang.Double irecaculateflag) {
        this.irecaculateflag = irecaculateflag;
    }


    /**
     * Gets the ipartflag value for this Wa_dataVO.
     * 
     * @return ipartflag
     */
    public java.lang.Double getIpartflag() {
        return ipartflag;
    }


    /**
     * Sets the ipartflag value for this Wa_dataVO.
     * 
     * @param ipartflag
     */
    public void setIpartflag(java.lang.Double ipartflag) {
        this.ipartflag = ipartflag;
    }


    /**
     * Gets the pk_psnbasdoc value for this Wa_dataVO.
     * 
     * @return pk_psnbasdoc
     */
    public java.lang.String getPk_psnbasdoc() {
        return pk_psnbasdoc;
    }


    /**
     * Sets the pk_psnbasdoc value for this Wa_dataVO.
     * 
     * @param pk_psnbasdoc
     */
    public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
        this.pk_psnbasdoc = pk_psnbasdoc;
    }


    /**
     * Gets the redtotal value for this Wa_dataVO.
     * 
     * @return redtotal
     */
    public java.lang.Double getRedtotal() {
        return redtotal;
    }


    /**
     * Sets the redtotal value for this Wa_dataVO.
     * 
     * @param redtotal
     */
    public void setRedtotal(java.lang.Double redtotal) {
        this.redtotal = redtotal;
    }


    /**
     * Gets the d_23 value for this Wa_dataVO.
     * 
     * @return d_23
     */
    public java.lang.Double getD_23() {
        return d_23;
    }


    /**
     * Sets the d_23 value for this Wa_dataVO.
     * 
     * @param d_23
     */
    public void setD_23(java.lang.Double d_23) {
        this.d_23 = d_23;
    }


    /**
     * Gets the d_24 value for this Wa_dataVO.
     * 
     * @return d_24
     */
    public java.lang.Double getD_24() {
        return d_24;
    }


    /**
     * Sets the d_24 value for this Wa_dataVO.
     * 
     * @param d_24
     */
    public void setD_24(java.lang.Double d_24) {
        this.d_24 = d_24;
    }


    /**
     * Gets the d_25 value for this Wa_dataVO.
     * 
     * @return d_25
     */
    public java.lang.Double getD_25() {
        return d_25;
    }


    /**
     * Sets the d_25 value for this Wa_dataVO.
     * 
     * @param d_25
     */
    public void setD_25(java.lang.Double d_25) {
        this.d_25 = d_25;
    }


    /**
     * Gets the vacccode value for this Wa_dataVO.
     * 
     * @return vacccode
     */
    public java.lang.String getVacccode() {
        return vacccode;
    }


    /**
     * Sets the vacccode value for this Wa_dataVO.
     * 
     * @param vacccode
     */
    public void setVacccode(java.lang.String vacccode) {
        this.vacccode = vacccode;
    }


    /**
     * Gets the d_26 value for this Wa_dataVO.
     * 
     * @return d_26
     */
    public java.lang.Double getD_26() {
        return d_26;
    }


    /**
     * Sets the d_26 value for this Wa_dataVO.
     * 
     * @param d_26
     */
    public void setD_26(java.lang.Double d_26) {
        this.d_26 = d_26;
    }


    /**
     * Gets the wa_data_object_id value for this Wa_dataVO.
     * 
     * @return wa_data_object_id
     */
    public java.lang.String getWa_data_object_id() {
        return wa_data_object_id;
    }


    /**
     * Sets the wa_data_object_id value for this Wa_dataVO.
     * 
     * @param wa_data_object_id
     */
    public void setWa_data_object_id(java.lang.String wa_data_object_id) {
        this.wa_data_object_id = wa_data_object_id;
    }


    /**
     * Gets the f_2 value for this Wa_dataVO.
     * 
     * @return f_2
     */
    public java.lang.Double getF_2() {
        return f_2;
    }


    /**
     * Sets the f_2 value for this Wa_dataVO.
     * 
     * @param f_2
     */
    public void setF_2(java.lang.Double f_2) {
        this.f_2 = f_2;
    }


    /**
     * Gets the f_1 value for this Wa_dataVO.
     * 
     * @return f_1
     */
    public java.lang.Double getF_1() {
        return f_1;
    }


    /**
     * Sets the f_1 value for this Wa_dataVO.
     * 
     * @param f_1
     */
    public void setF_1(java.lang.Double f_1) {
        this.f_1 = f_1;
    }


    /**
     * Gets the d_21 value for this Wa_dataVO.
     * 
     * @return d_21
     */
    public java.lang.Double getD_21() {
        return d_21;
    }


    /**
     * Sets the d_21 value for this Wa_dataVO.
     * 
     * @param d_21
     */
    public void setD_21(java.lang.Double d_21) {
        this.d_21 = d_21;
    }


    /**
     * Gets the nestpsnclid value for this Wa_dataVO.
     * 
     * @return nestpsnclid
     */
    public java.lang.String getNestpsnclid() {
        return nestpsnclid;
    }


    /**
     * Sets the nestpsnclid value for this Wa_dataVO.
     * 
     * @param nestpsnclid
     */
    public void setNestpsnclid(java.lang.String nestpsnclid) {
        this.nestpsnclid = nestpsnclid;
    }


    /**
     * Gets the f_4 value for this Wa_dataVO.
     * 
     * @return f_4
     */
    public java.lang.Double getF_4() {
        return f_4;
    }


    /**
     * Sets the f_4 value for this Wa_dataVO.
     * 
     * @param f_4
     */
    public void setF_4(java.lang.Double f_4) {
        this.f_4 = f_4;
    }


    /**
     * Gets the d_22 value for this Wa_dataVO.
     * 
     * @return d_22
     */
    public java.lang.Double getD_22() {
        return d_22;
    }


    /**
     * Sets the d_22 value for this Wa_dataVO.
     * 
     * @param d_22
     */
    public void setD_22(java.lang.Double d_22) {
        this.d_22 = d_22;
    }


    /**
     * Gets the f_3 value for this Wa_dataVO.
     * 
     * @return f_3
     */
    public java.lang.Double getF_3() {
        return f_3;
    }


    /**
     * Sets the f_3 value for this Wa_dataVO.
     * 
     * @param f_3
     */
    public void setF_3(java.lang.Double f_3) {
        this.f_3 = f_3;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Wa_dataVO)) return false;
        Wa_dataVO other = (Wa_dataVO) obj;
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
            ((this.bankid==null && other.getBankid()==null) || 
             (this.bankid!=null &&
              this.bankid.equals(other.getBankid()))) &&
            ((this.psnid==null && other.getPsnid()==null) || 
             (this.psnid!=null &&
              this.psnid.equals(other.getPsnid()))) &&
            ((this.anbonusflag==null && other.getAnbonusflag()==null) || 
             (this.anbonusflag!=null &&
              this.anbonusflag.equals(other.getAnbonusflag()))) &&
            ((this.taxtableid==null && other.getTaxtableid()==null) || 
             (this.taxtableid!=null &&
              this.taxtableid.equals(other.getTaxtableid()))) &&
            ((this.cperiod==null && other.getCperiod()==null) || 
             (this.cperiod!=null &&
              this.cperiod.equals(other.getCperiod()))) &&
            ((this.deptid==null && other.getDeptid()==null) || 
             (this.deptid!=null &&
              this.deptid.equals(other.getDeptid()))) &&
            ((this.cyear==null && other.getCyear()==null) || 
             (this.cyear!=null &&
              this.cyear.equals(other.getCyear()))) &&
            ((this.pk_psndoc_sub==null && other.getPk_psndoc_sub()==null) || 
             (this.pk_psndoc_sub!=null &&
              this.pk_psndoc_sub.equals(other.getPk_psndoc_sub()))) &&
            ((this.tableName==null && other.getTableName()==null) || 
             (this.tableName!=null &&
              this.tableName.equals(other.getTableName()))) &&
            ((this.icheckflag==null && other.getIcheckflag()==null) || 
             (this.icheckflag!=null &&
              this.icheckflag.equals(other.getIcheckflag()))) &&
            ((this.d_14==null && other.getD_14()==null) || 
             (this.d_14!=null &&
              this.d_14.equals(other.getD_14()))) &&
            ((this.nestpk_om_job==null && other.getNestpk_om_job()==null) || 
             (this.nestpk_om_job!=null &&
              this.nestpk_om_job.equals(other.getNestpk_om_job()))) &&
            ((this.istopflag==null && other.getIstopflag()==null) || 
             (this.istopflag!=null &&
              this.istopflag.equals(other.getIstopflag()))) &&
            ((this.d_12==null && other.getD_12()==null) || 
             (this.d_12!=null &&
              this.d_12.equals(other.getD_12()))) &&
            ((this.d_13==null && other.getD_13()==null) || 
             (this.d_13!=null &&
              this.d_13.equals(other.getD_13()))) &&
            ((this.d_11==null && other.getD_11()==null) || 
             (this.d_11!=null &&
              this.d_11.equals(other.getD_11()))) &&
            ((this.psnclid==null && other.getPsnclid()==null) || 
             (this.psnclid!=null &&
              this.psnclid.equals(other.getPsnclid()))) &&
            ((this.itaxflag==null && other.getItaxflag()==null) || 
             (this.itaxflag!=null &&
              this.itaxflag.equals(other.getItaxflag()))) &&
            ((this.classid==null && other.getClassid()==null) || 
             (this.classid!=null &&
              this.classid.equals(other.getClassid()))) &&
            ((this.dr==null && other.getDr()==null) || 
             (this.dr!=null &&
              this.dr.equals(other.getDr()))) &&
            ((this.irecheckflag==null && other.getIrecheckflag()==null) || 
             (this.irecheckflag!=null &&
              this.irecheckflag.equals(other.getIrecheckflag()))) &&
            ((this.pk_wa_data==null && other.getPk_wa_data()==null) || 
             (this.pk_wa_data!=null &&
              this.pk_wa_data.equals(other.getPk_wa_data()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.cnestyear==null && other.getCnestyear()==null) || 
             (this.cnestyear!=null &&
              this.cnestyear.equals(other.getCnestyear()))) &&
            ((this.nestdeptid==null && other.getNestdeptid()==null) || 
             (this.nestdeptid!=null &&
              this.nestdeptid.equals(other.getNestdeptid()))) &&
            ((this.pk_om_job==null && other.getPk_om_job()==null) || 
             (this.pk_om_job!=null &&
              this.pk_om_job.equals(other.getPk_om_job()))) &&
            ((this.spike_sign==null && other.getSpike_sign()==null) || 
             (this.spike_sign!=null &&
              this.spike_sign.equals(other.getSpike_sign()))) &&
            ((this.cnestperiod==null && other.getCnestperiod()==null) || 
             (this.cnestperiod!=null &&
              this.cnestperiod.equals(other.getCnestperiod()))) &&
            ((this.irecaculateflag==null && other.getIrecaculateflag()==null) || 
             (this.irecaculateflag!=null &&
              this.irecaculateflag.equals(other.getIrecaculateflag()))) &&
            ((this.ipartflag==null && other.getIpartflag()==null) || 
             (this.ipartflag!=null &&
              this.ipartflag.equals(other.getIpartflag()))) &&
            ((this.pk_psnbasdoc==null && other.getPk_psnbasdoc()==null) || 
             (this.pk_psnbasdoc!=null &&
              this.pk_psnbasdoc.equals(other.getPk_psnbasdoc()))) &&
            ((this.redtotal==null && other.getRedtotal()==null) || 
             (this.redtotal!=null &&
              this.redtotal.equals(other.getRedtotal()))) &&
            ((this.d_23==null && other.getD_23()==null) || 
             (this.d_23!=null &&
              this.d_23.equals(other.getD_23()))) &&
            ((this.d_24==null && other.getD_24()==null) || 
             (this.d_24!=null &&
              this.d_24.equals(other.getD_24()))) &&
            ((this.d_25==null && other.getD_25()==null) || 
             (this.d_25!=null &&
              this.d_25.equals(other.getD_25()))) &&
            ((this.vacccode==null && other.getVacccode()==null) || 
             (this.vacccode!=null &&
              this.vacccode.equals(other.getVacccode()))) &&
            ((this.d_26==null && other.getD_26()==null) || 
             (this.d_26!=null &&
              this.d_26.equals(other.getD_26()))) &&
            ((this.wa_data_object_id==null && other.getWa_data_object_id()==null) || 
             (this.wa_data_object_id!=null &&
              this.wa_data_object_id.equals(other.getWa_data_object_id()))) &&
            ((this.f_2==null && other.getF_2()==null) || 
             (this.f_2!=null &&
              this.f_2.equals(other.getF_2()))) &&
            ((this.f_1==null && other.getF_1()==null) || 
             (this.f_1!=null &&
              this.f_1.equals(other.getF_1()))) &&
            ((this.d_21==null && other.getD_21()==null) || 
             (this.d_21!=null &&
              this.d_21.equals(other.getD_21()))) &&
            ((this.nestpsnclid==null && other.getNestpsnclid()==null) || 
             (this.nestpsnclid!=null &&
              this.nestpsnclid.equals(other.getNestpsnclid()))) &&
            ((this.f_4==null && other.getF_4()==null) || 
             (this.f_4!=null &&
              this.f_4.equals(other.getF_4()))) &&
            ((this.d_22==null && other.getD_22()==null) || 
             (this.d_22!=null &&
              this.d_22.equals(other.getD_22()))) &&
            ((this.f_3==null && other.getF_3()==null) || 
             (this.f_3!=null &&
              this.f_3.equals(other.getF_3())));
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
        if (getBankid() != null) {
            _hashCode += getBankid().hashCode();
        }
        if (getPsnid() != null) {
            _hashCode += getPsnid().hashCode();
        }
        if (getAnbonusflag() != null) {
            _hashCode += getAnbonusflag().hashCode();
        }
        if (getTaxtableid() != null) {
            _hashCode += getTaxtableid().hashCode();
        }
        if (getCperiod() != null) {
            _hashCode += getCperiod().hashCode();
        }
        if (getDeptid() != null) {
            _hashCode += getDeptid().hashCode();
        }
        if (getCyear() != null) {
            _hashCode += getCyear().hashCode();
        }
        if (getPk_psndoc_sub() != null) {
            _hashCode += getPk_psndoc_sub().hashCode();
        }
        if (getTableName() != null) {
            _hashCode += getTableName().hashCode();
        }
        if (getIcheckflag() != null) {
            _hashCode += getIcheckflag().hashCode();
        }
        if (getD_14() != null) {
            _hashCode += getD_14().hashCode();
        }
        if (getNestpk_om_job() != null) {
            _hashCode += getNestpk_om_job().hashCode();
        }
        if (getIstopflag() != null) {
            _hashCode += getIstopflag().hashCode();
        }
        if (getD_12() != null) {
            _hashCode += getD_12().hashCode();
        }
        if (getD_13() != null) {
            _hashCode += getD_13().hashCode();
        }
        if (getD_11() != null) {
            _hashCode += getD_11().hashCode();
        }
        if (getPsnclid() != null) {
            _hashCode += getPsnclid().hashCode();
        }
        if (getItaxflag() != null) {
            _hashCode += getItaxflag().hashCode();
        }
        if (getClassid() != null) {
            _hashCode += getClassid().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        if (getIrecheckflag() != null) {
            _hashCode += getIrecheckflag().hashCode();
        }
        if (getPk_wa_data() != null) {
            _hashCode += getPk_wa_data().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getCnestyear() != null) {
            _hashCode += getCnestyear().hashCode();
        }
        if (getNestdeptid() != null) {
            _hashCode += getNestdeptid().hashCode();
        }
        if (getPk_om_job() != null) {
            _hashCode += getPk_om_job().hashCode();
        }
        if (getSpike_sign() != null) {
            _hashCode += getSpike_sign().hashCode();
        }
        if (getCnestperiod() != null) {
            _hashCode += getCnestperiod().hashCode();
        }
        if (getIrecaculateflag() != null) {
            _hashCode += getIrecaculateflag().hashCode();
        }
        if (getIpartflag() != null) {
            _hashCode += getIpartflag().hashCode();
        }
        if (getPk_psnbasdoc() != null) {
            _hashCode += getPk_psnbasdoc().hashCode();
        }
        if (getRedtotal() != null) {
            _hashCode += getRedtotal().hashCode();
        }
        if (getD_23() != null) {
            _hashCode += getD_23().hashCode();
        }
        if (getD_24() != null) {
            _hashCode += getD_24().hashCode();
        }
        if (getD_25() != null) {
            _hashCode += getD_25().hashCode();
        }
        if (getVacccode() != null) {
            _hashCode += getVacccode().hashCode();
        }
        if (getD_26() != null) {
            _hashCode += getD_26().hashCode();
        }
        if (getWa_data_object_id() != null) {
            _hashCode += getWa_data_object_id().hashCode();
        }
        if (getF_2() != null) {
            _hashCode += getF_2().hashCode();
        }
        if (getF_1() != null) {
            _hashCode += getF_1().hashCode();
        }
        if (getD_21() != null) {
            _hashCode += getD_21().hashCode();
        }
        if (getNestpsnclid() != null) {
            _hashCode += getNestpsnclid().hashCode();
        }
        if (getF_4() != null) {
            _hashCode += getF_4().hashCode();
        }
        if (getD_22() != null) {
            _hashCode += getD_22().hashCode();
        }
        if (getF_3() != null) {
            _hashCode += getF_3().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Wa_dataVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://wa.vo.ws.nc/Wa_dataVO", "Wa_dataVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ts"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bankid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anbonusflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anbonusflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("taxtableid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "taxtableid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cperiod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cperiod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cyear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cyear"));
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
        elemField.setFieldName("tableName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tableName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icheckflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "icheckflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_14");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_14"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestpk_om_job");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nestpk_om_job"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("istopflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "istopflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_12");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_12"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_13");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_13"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_11");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_11"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("psnclid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "psnclid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itaxflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itaxflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classid"));
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
        elemField.setFieldName("irecheckflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "irecheckflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_wa_data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_wa_data"));
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
        elemField.setFieldName("cnestyear");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cnestyear"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestdeptid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nestdeptid"));
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
        elemField.setFieldName("spike_sign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spike_sign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnestperiod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cnestperiod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("irecaculateflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "irecaculateflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ipartflag");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ipartflag"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
        elemField.setFieldName("redtotal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "redtotal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_23");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_23"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_24");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_24"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_25");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_25"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vacccode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vacccode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_26");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_26"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wa_data_object_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "wa_data_object_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("f_2");
        elemField.setXmlName(new javax.xml.namespace.QName("", "f_2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("f_1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "f_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_21");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_21"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nestpsnclid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nestpsnclid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("f_4");
        elemField.setXmlName(new javax.xml.namespace.QName("", "f_4"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("d_22");
        elemField.setXmlName(new javax.xml.namespace.QName("", "d_22"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("f_3");
        elemField.setXmlName(new javax.xml.namespace.QName("", "f_3"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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

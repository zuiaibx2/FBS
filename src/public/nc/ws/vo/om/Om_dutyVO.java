/**
 * Om_dutyVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.om;

public class Om_dutyVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String series;

    private java.lang.String pk_om_duty;

    private java.lang.String pk_corp;

    private java.lang.String vdutysumm;

    private java.lang.String ts;

    private java.lang.String tableName;

    private java.lang.String dutyname;

    private java.lang.String dutycode;

    private java.lang.String createcorp;

    private java.lang.String spike_sign;

    private java.lang.String dutyrank;

    private java.lang.Integer dr;

    public Om_dutyVO() {
    }

    public Om_dutyVO(
           java.lang.String series,
           java.lang.String pk_om_duty,
           java.lang.String pk_corp,
           java.lang.String vdutysumm,
           java.lang.String ts,
           java.lang.String tableName,
           java.lang.String dutyname,
           java.lang.String dutycode,
           java.lang.String createcorp,
           java.lang.String spike_sign,
           java.lang.String dutyrank,
           java.lang.Integer dr) {
           this.series = series;
           this.pk_om_duty = pk_om_duty;
           this.pk_corp = pk_corp;
           this.vdutysumm = vdutysumm;
           this.ts = ts;
           this.tableName = tableName;
           this.dutyname = dutyname;
           this.dutycode = dutycode;
           this.createcorp = createcorp;
           this.spike_sign = spike_sign;
           this.dutyrank = dutyrank;
           this.dr = dr;
    }


    /**
     * Gets the series value for this Om_dutyVO.
     * 
     * @return series
     */
    public java.lang.String getSeries() {
        return series;
    }


    /**
     * Sets the series value for this Om_dutyVO.
     * 
     * @param series
     */
    public void setSeries(java.lang.String series) {
        this.series = series;
    }


    /**
     * Gets the pk_om_duty value for this Om_dutyVO.
     * 
     * @return pk_om_duty
     */
    public java.lang.String getPk_om_duty() {
        return pk_om_duty;
    }


    /**
     * Sets the pk_om_duty value for this Om_dutyVO.
     * 
     * @param pk_om_duty
     */
    public void setPk_om_duty(java.lang.String pk_om_duty) {
        this.pk_om_duty = pk_om_duty;
    }


    /**
     * Gets the pk_corp value for this Om_dutyVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Om_dutyVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the vdutysumm value for this Om_dutyVO.
     * 
     * @return vdutysumm
     */
    public java.lang.String getVdutysumm() {
        return vdutysumm;
    }


    /**
     * Sets the vdutysumm value for this Om_dutyVO.
     * 
     * @param vdutysumm
     */
    public void setVdutysumm(java.lang.String vdutysumm) {
        this.vdutysumm = vdutysumm;
    }


    /**
     * Gets the ts value for this Om_dutyVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Om_dutyVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the tableName value for this Om_dutyVO.
     * 
     * @return tableName
     */
    public java.lang.String getTableName() {
        return tableName;
    }


    /**
     * Sets the tableName value for this Om_dutyVO.
     * 
     * @param tableName
     */
    public void setTableName(java.lang.String tableName) {
        this.tableName = tableName;
    }


    /**
     * Gets the dutyname value for this Om_dutyVO.
     * 
     * @return dutyname
     */
    public java.lang.String getDutyname() {
        return dutyname;
    }


    /**
     * Sets the dutyname value for this Om_dutyVO.
     * 
     * @param dutyname
     */
    public void setDutyname(java.lang.String dutyname) {
        this.dutyname = dutyname;
    }


    /**
     * Gets the dutycode value for this Om_dutyVO.
     * 
     * @return dutycode
     */
    public java.lang.String getDutycode() {
        return dutycode;
    }


    /**
     * Sets the dutycode value for this Om_dutyVO.
     * 
     * @param dutycode
     */
    public void setDutycode(java.lang.String dutycode) {
        this.dutycode = dutycode;
    }


    /**
     * Gets the createcorp value for this Om_dutyVO.
     * 
     * @return createcorp
     */
    public java.lang.String getCreatecorp() {
        return createcorp;
    }


    /**
     * Sets the createcorp value for this Om_dutyVO.
     * 
     * @param createcorp
     */
    public void setCreatecorp(java.lang.String createcorp) {
        this.createcorp = createcorp;
    }


    /**
     * Gets the spike_sign value for this Om_dutyVO.
     * 
     * @return spike_sign
     */
    public java.lang.String getSpike_sign() {
        return spike_sign;
    }


    /**
     * Sets the spike_sign value for this Om_dutyVO.
     * 
     * @param spike_sign
     */
    public void setSpike_sign(java.lang.String spike_sign) {
        this.spike_sign = spike_sign;
    }


    /**
     * Gets the dutyrank value for this Om_dutyVO.
     * 
     * @return dutyrank
     */
    public java.lang.String getDutyrank() {
        return dutyrank;
    }


    /**
     * Sets the dutyrank value for this Om_dutyVO.
     * 
     * @param dutyrank
     */
    public void setDutyrank(java.lang.String dutyrank) {
        this.dutyrank = dutyrank;
    }


    /**
     * Gets the dr value for this Om_dutyVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Om_dutyVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Om_dutyVO)) return false;
        Om_dutyVO other = (Om_dutyVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.series==null && other.getSeries()==null) || 
             (this.series!=null &&
              this.series.equals(other.getSeries()))) &&
            ((this.pk_om_duty==null && other.getPk_om_duty()==null) || 
             (this.pk_om_duty!=null &&
              this.pk_om_duty.equals(other.getPk_om_duty()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.vdutysumm==null && other.getVdutysumm()==null) || 
             (this.vdutysumm!=null &&
              this.vdutysumm.equals(other.getVdutysumm()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
            ((this.tableName==null && other.getTableName()==null) || 
             (this.tableName!=null &&
              this.tableName.equals(other.getTableName()))) &&
            ((this.dutyname==null && other.getDutyname()==null) || 
             (this.dutyname!=null &&
              this.dutyname.equals(other.getDutyname()))) &&
            ((this.dutycode==null && other.getDutycode()==null) || 
             (this.dutycode!=null &&
              this.dutycode.equals(other.getDutycode()))) &&
            ((this.createcorp==null && other.getCreatecorp()==null) || 
             (this.createcorp!=null &&
              this.createcorp.equals(other.getCreatecorp()))) &&
            ((this.spike_sign==null && other.getSpike_sign()==null) || 
             (this.spike_sign!=null &&
              this.spike_sign.equals(other.getSpike_sign()))) &&
            ((this.dutyrank==null && other.getDutyrank()==null) || 
             (this.dutyrank!=null &&
              this.dutyrank.equals(other.getDutyrank()))) &&
            ((this.dr==null && other.getDr()==null) || 
             (this.dr!=null &&
              this.dr.equals(other.getDr())));
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
        if (getSeries() != null) {
            _hashCode += getSeries().hashCode();
        }
        if (getPk_om_duty() != null) {
            _hashCode += getPk_om_duty().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getVdutysumm() != null) {
            _hashCode += getVdutysumm().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getTableName() != null) {
            _hashCode += getTableName().hashCode();
        }
        if (getDutyname() != null) {
            _hashCode += getDutyname().hashCode();
        }
        if (getDutycode() != null) {
            _hashCode += getDutycode().hashCode();
        }
        if (getCreatecorp() != null) {
            _hashCode += getCreatecorp().hashCode();
        }
        if (getSpike_sign() != null) {
            _hashCode += getSpike_sign().hashCode();
        }
        if (getDutyrank() != null) {
            _hashCode += getDutyrank().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Om_dutyVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://om.vo.ws.nc/Om_dutyVO", "Om_dutyVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("series");
        elemField.setXmlName(new javax.xml.namespace.QName("", "series"));
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
        elemField.setFieldName("pk_corp");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_corp"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vdutysumm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vdutysumm"));
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
        elemField.setFieldName("tableName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tableName"));
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
        elemField.setFieldName("dutycode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dutycode"));
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
        elemField.setFieldName("spike_sign");
        elemField.setXmlName(new javax.xml.namespace.QName("", "spike_sign"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dutyrank");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dutyrank"));
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

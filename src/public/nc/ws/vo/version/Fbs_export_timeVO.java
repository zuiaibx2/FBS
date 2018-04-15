/**
 * Fbs_export_timeVO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ws.vo.version;

public class Fbs_export_timeVO  implements java.io.Serializable {
    /**
	 * @Field: serialVersionUID
	 * @Discription: 
	 */
	private static final long serialVersionUID = 1L;

	private java.lang.String pk_fbs_export_time;

    private java.lang.String time;

    private java.lang.String pk_corp;

    private java.lang.String ts;

    private java.lang.Integer dr;

    public Fbs_export_timeVO() {
    }

    public Fbs_export_timeVO(
           java.lang.String pk_fbs_export_time,
           java.lang.String time,
           java.lang.String pk_corp,
           java.lang.String ts,
           java.lang.Integer dr) {
           this.pk_fbs_export_time = pk_fbs_export_time;
           this.time = time;
           this.pk_corp = pk_corp;
           this.ts = ts;
           this.dr = dr;
    }


    /**
     * Gets the pk_fbs_export_time value for this Fbs_export_timeVO.
     * 
     * @return pk_fbs_export_time
     */
    public java.lang.String getPk_fbs_export_time() {
        return pk_fbs_export_time;
    }


    /**
     * Sets the pk_fbs_export_time value for this Fbs_export_timeVO.
     * 
     * @param pk_fbs_export_time
     */
    public void setPk_fbs_export_time(java.lang.String pk_fbs_export_time) {
        this.pk_fbs_export_time = pk_fbs_export_time;
    }


    /**
     * Gets the time value for this Fbs_export_timeVO.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this Fbs_export_timeVO.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the pk_corp value for this Fbs_export_timeVO.
     * 
     * @return pk_corp
     */
    public java.lang.String getPk_corp() {
        return pk_corp;
    }


    /**
     * Sets the pk_corp value for this Fbs_export_timeVO.
     * 
     * @param pk_corp
     */
    public void setPk_corp(java.lang.String pk_corp) {
        this.pk_corp = pk_corp;
    }


    /**
     * Gets the ts value for this Fbs_export_timeVO.
     * 
     * @return ts
     */
    public java.lang.String getTs() {
        return ts;
    }


    /**
     * Sets the ts value for this Fbs_export_timeVO.
     * 
     * @param ts
     */
    public void setTs(java.lang.String ts) {
        this.ts = ts;
    }


    /**
     * Gets the dr value for this Fbs_export_timeVO.
     * 
     * @return dr
     */
    public java.lang.Integer getDr() {
        return dr;
    }


    /**
     * Sets the dr value for this Fbs_export_timeVO.
     * 
     * @param dr
     */
    public void setDr(java.lang.Integer dr) {
        this.dr = dr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Fbs_export_timeVO)) return false;
        Fbs_export_timeVO other = (Fbs_export_timeVO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pk_fbs_export_time==null && other.getPk_fbs_export_time()==null) || 
             (this.pk_fbs_export_time!=null &&
              this.pk_fbs_export_time.equals(other.getPk_fbs_export_time()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.pk_corp==null && other.getPk_corp()==null) || 
             (this.pk_corp!=null &&
              this.pk_corp.equals(other.getPk_corp()))) &&
            ((this.ts==null && other.getTs()==null) || 
             (this.ts!=null &&
              this.ts.equals(other.getTs()))) &&
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
        if (getPk_fbs_export_time() != null) {
            _hashCode += getPk_fbs_export_time().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getPk_corp() != null) {
            _hashCode += getPk_corp().hashCode();
        }
        if (getTs() != null) {
            _hashCode += getTs().hashCode();
        }
        if (getDr() != null) {
            _hashCode += getDr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Fbs_export_timeVO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://version.vo.ws.nc/Fbs_export_timeVO", "Fbs_export_timeVO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pk_fbs_export_time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pk_fbs_export_time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("", "time"));
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
        elemField.setFieldName("ts");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ts"));
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

/***************************************************************\
 *     The skeleton of this class is generated by an automatic *
 * code generator for NC product. It is based on Velocity.     *
\***************************************************************/
package nc.vo.djdz;
	
import nc.vo.pub.*;
import nc.vo.pub.lang.*;
	
/**
 *     数据对照VO
 * 创建日期:2016-08-15 12:55:17
 * @author 汪志强
 * @version NCPrj 1.0
 */
@SuppressWarnings("serial")
public class DataControlVO extends SuperVO {
	private String pk_corp;
	private String ts;
	private String vuserdef9;
	private String vuserdef3;
	private String xj_attr;
	private String pk_datacontrol;
	private String vuserdef11;
	private String vuserdef17;
	private String vuserdef14;
	private String pk_busitype;
	private String vuserdef4;
	/**
	 * @field: xj_pk
	 * @Discription: 下级参照主键
	 */
	private String xj_pk;
	/**
	 * @field: jt_zj
	 * @Discription: 集团参照主键
	 */
	private String jt_zj;
	private String jt_code;
	/**
	 * @field: vuserdef1
	 * @Discription: 集团名称
	 */
	private String vuserdef1;
	private String jt_attr;
	private String vuserdef12;
	private String vuserdef8;
	private String category;
	private String vuserdef13;
	private String vuserdef6;
	private String vuserdef10;
	private String pk_datacontrol_type;
	private String vuserdef5;
	private UFDate doperatordate;
	private String vnote;
	private String vuserdef7;
	private String pk_billtype;
	private Integer vbillstatus;
	private String vuserdef15;
	private String xj_code;
	private String vuserdef16;
	private String vbillno;
	private String vuserdef20;
	private Integer dr;
	/**
	 * @field: vuserdef2
	 * @Discription: 下级名称
	 */
	private String vuserdef2;

	public static final String PK_CORP = "pk_corp";
	public static final String VUSERDEF9 = "vuserdef9";
	public static final String VUSERDEF3 = "vuserdef3";
	public static final String XJ_ATTR = "xj_attr";
	public static final String PK_DC_DATACONTROL = "pk_dc_datacontrol";
	public static final String VUSERDEF11 = "vuserdef11";
	public static final String VUSERDEF17 = "vuserdef17";
	public static final String VUSERDEF14 = "vuserdef14";
	public static final String PK_BUSITYPE = "pk_busitype";
	public static final String VUSERDEF4 = "vuserdef4";
	public static final String XJ_PK = "xj_pk";
	public static final String JT_ZJ = "jt_zj";
	public static final String JT_CODE = "jt_code";
	public static final String VUSERDEF1 = "vuserdef1";
	public static final String JT_ATTR = "jt_attr";
	public static final String VUSERDEF12 = "vuserdef12";
	public static final String VUSERDEF8 = "vuserdef8";
	public static final String CATEGORY = "category";
	public static final String VUSERDEF13 = "vuserdef13";
	public static final String VUSERDEF6 = "vuserdef6";
	public static final String VUSERDEF10 = "vuserdef10";
	public static final String PK_DC_DATACONTROL_TYPE = "pk_dc_datacontrol_type";
	public static final String VUSERDEF5 = "vuserdef5";
	public static final String DOPERATORDATE = "doperatordate";
	public static final String VNOTE = "vnote";
	public static final String VUSERDEF7 = "vuserdef7";
	public static final String PK_BILLTYPE = "pk_billtype";
	public static final String VBILLSTATUS = "vbillstatus";
	public static final String VUSERDEF15 = "vuserdef15";
	public static final String XJ_CODE = "xj_code";
	public static final String VUSERDEF16 = "vuserdef16";
	public static final String VBILLNO = "vbillno";
	public static final String VUSERDEF20 = "vuserdef20";
	public static final String VUSERDEF2 = "vuserdef2";
			
	/**
	 * 属性pk_corp的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getPk_corp () {
		return pk_corp;
	}   
	/**
	 * 属性pk_corp的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newPk_corp String
	 */
	public void setPk_corp (String newPk_corp ) {
	 	this.pk_corp = newPk_corp;
	} 	  
	/**
	 * 属性ts的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getTs () {
		return ts;
	}   
	/**
	 * 属性ts的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newTs String
	 */
	public void setTs (String newTs ) {
	 	this.ts = newTs;
	} 	  
	/**
	 * 属性vuserdef9的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef9 () {
		return vuserdef9;
	}   
	/**
	 * 属性vuserdef9的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef9 String
	 */
	public void setVuserdef9 (String newVuserdef9 ) {
	 	this.vuserdef9 = newVuserdef9;
	} 	  
	/**
	 * 属性vuserdef3的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef3 () {
		return vuserdef3;
	}   
	/**
	 * 属性vuserdef3的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef3 String
	 */
	public void setVuserdef3 (String newVuserdef3 ) {
	 	this.vuserdef3 = newVuserdef3;
	} 	  
	/**
	 * 属性xj_attr的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getXj_attr () {
		return xj_attr;
	}   
	/**
	 * 属性xj_attr的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newXj_attr String
	 */
	public void setXj_attr (String newXj_attr ) {
	 	this.xj_attr = newXj_attr;
	} 	  
	/**
	 * 属性pk_dc_datacontrol的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getPk_datacontrol () {
		return pk_datacontrol;
	}   
	/**
	 * 属性pk_dc_datacontrol的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newPk_dc_datacontrol String
	 */
	public void setPk_datacontrol (String newPk_datacontrol ) {
	 	this.pk_datacontrol = newPk_datacontrol;
	} 	  
	/**
	 * 属性vuserdef11的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef11 () {
		return vuserdef11;
	}   
	/**
	 * 属性vuserdef11的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef11 String
	 */
	public void setVuserdef11 (String newVuserdef11 ) {
	 	this.vuserdef11 = newVuserdef11;
	} 	  
	/**
	 * 属性vuserdef17的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef17 () {
		return vuserdef17;
	}   
	/**
	 * 属性vuserdef17的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef17 String
	 */
	public void setVuserdef17 (String newVuserdef17 ) {
	 	this.vuserdef17 = newVuserdef17;
	} 	  
	/**
	 * 属性vuserdef14的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef14 () {
		return vuserdef14;
	}   
	/**
	 * 属性vuserdef14的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef14 String
	 */
	public void setVuserdef14 (String newVuserdef14 ) {
	 	this.vuserdef14 = newVuserdef14;
	} 	  
	/**
	 * 属性pk_busitype的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getPk_busitype () {
		return pk_busitype;
	}   
	/**
	 * 属性pk_busitype的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newPk_busitype String
	 */
	public void setPk_busitype (String newPk_busitype ) {
	 	this.pk_busitype = newPk_busitype;
	} 	  
	/**
	 * 属性vuserdef4的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef4 () {
		return vuserdef4;
	}   
	/**
	 * 属性vuserdef4的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef4 String
	 */
	public void setVuserdef4 (String newVuserdef4 ) {
	 	this.vuserdef4 = newVuserdef4;
	} 	  
	/**
	 * 属性xj_pk的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getXj_pk () {
		return xj_pk;
	}   
	/**
	 * 属性xj_pk的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newXj_pk String
	 */
	public void setXj_pk (String newXj_pk ) {
	 	this.xj_pk = newXj_pk;
	} 	  
	/**
	 * 属性jt_zj的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getJt_zj () {
		return jt_zj;
	}   
	/**
	 * 属性jt_zj的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newJt_zj String
	 */
	public void setJt_zj (String newJt_zj ) {
	 	this.jt_zj = newJt_zj;
	} 	  
	/**
	 * 属性jt_code的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getJt_code () {
		return jt_code;
	}   
	/**
	 * 属性jt_code的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newJt_code String
	 */
	public void setJt_code (String newJt_code ) {
	 	this.jt_code = newJt_code;
	} 	  
	/**
	 * 属性vuserdef1的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef1 () {
		return vuserdef1;
	}   
	/**
	 * 属性vuserdef1的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef1 String
	 */
	public void setVuserdef1 (String newVuserdef1 ) {
	 	this.vuserdef1 = newVuserdef1;
	} 	  
	/**
	 * 属性jt_attr的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getJt_attr () {
		return jt_attr;
	}   
	/**
	 * 属性jt_attr的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newJt_attr String
	 */
	public void setJt_attr (String newJt_attr ) {
	 	this.jt_attr = newJt_attr;
	} 	  
	/**
	 * 属性vuserdef12的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef12 () {
		return vuserdef12;
	}   
	/**
	 * 属性vuserdef12的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef12 String
	 */
	public void setVuserdef12 (String newVuserdef12 ) {
	 	this.vuserdef12 = newVuserdef12;
	} 	  
	/**
	 * 属性vuserdef8的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef8 () {
		return vuserdef8;
	}   
	/**
	 * 属性vuserdef8的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef8 String
	 */
	public void setVuserdef8 (String newVuserdef8 ) {
	 	this.vuserdef8 = newVuserdef8;
	} 	  
	/**
	 * 属性category的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getCategory () {
		return category;
	}   
	/**
	 * 属性category的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newCategory String
	 */
	public void setCategory (String newCategory ) {
	 	this.category = newCategory;
	} 	  
	/**
	 * 属性vuserdef13的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef13 () {
		return vuserdef13;
	}   
	/**
	 * 属性vuserdef13的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef13 String
	 */
	public void setVuserdef13 (String newVuserdef13 ) {
	 	this.vuserdef13 = newVuserdef13;
	} 	  
	/**
	 * 属性vuserdef6的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef6 () {
		return vuserdef6;
	}   
	/**
	 * 属性vuserdef6的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef6 String
	 */
	public void setVuserdef6 (String newVuserdef6 ) {
	 	this.vuserdef6 = newVuserdef6;
	} 	  
	/**
	 * 属性vuserdef10的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef10 () {
		return vuserdef10;
	}   
	/**
	 * 属性vuserdef10的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef10 String
	 */
	public void setVuserdef10 (String newVuserdef10 ) {
	 	this.vuserdef10 = newVuserdef10;
	} 	  
	/**
	 * 属性pk_dc_datacontrol_type的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getPk_datacontrol_type () {
		return pk_datacontrol_type;
	}   
	/**
	 * 属性pk_dc_datacontrol_type的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newPk_dc_datacontrol_type String
	 */
	public void setPk_datacontrol_type (String newPk_datacontrol_type ) {
	 	this.pk_datacontrol_type = newPk_datacontrol_type;
	} 	  
	/**
	 * 属性vuserdef5的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef5 () {
		return vuserdef5;
	}   
	/**
	 * 属性vuserdef5的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef5 String
	 */
	public void setVuserdef5 (String newVuserdef5 ) {
	 	this.vuserdef5 = newVuserdef5;
	} 	  
	/**
	 * 属性doperatordate的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return UFDate
	 */
	public UFDate getDoperatordate () {
		return doperatordate;
	}   
	/**
	 * 属性doperatordate的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newDoperatordate UFDate
	 */
	public void setDoperatordate (UFDate newDoperatordate ) {
	 	this.doperatordate = newDoperatordate;
	} 	  
	/**
	 * 属性vnote的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVnote () {
		return vnote;
	}   
	/**
	 * 属性vnote的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVnote String
	 */
	public void setVnote (String newVnote ) {
	 	this.vnote = newVnote;
	} 	  
	/**
	 * 属性vuserdef7的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef7 () {
		return vuserdef7;
	}   
	/**
	 * 属性vuserdef7的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef7 String
	 */
	public void setVuserdef7 (String newVuserdef7 ) {
	 	this.vuserdef7 = newVuserdef7;
	} 	  
	/**
	 * 属性pk_billtype的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getPk_billtype () {
		return pk_billtype;
	}   
	/**
	 * 属性pk_billtype的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newPk_billtype String
	 */
	public void setPk_billtype (String newPk_billtype ) {
	 	this.pk_billtype = newPk_billtype;
	} 	  
	/**
	 * 属性vbillstatus的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return Integer
	 */
	public Integer getVbillstatus () {
		return vbillstatus;
	}   
	/**
	 * 属性vbillstatus的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVbillstatus Integer
	 */
	public void setVbillstatus (Integer newVbillstatus ) {
	 	this.vbillstatus = newVbillstatus;
	} 	  
	/**
	 * 属性vuserdef15的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef15 () {
		return vuserdef15;
	}   
	/**
	 * 属性vuserdef15的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef15 String
	 */
	public void setVuserdef15 (String newVuserdef15 ) {
	 	this.vuserdef15 = newVuserdef15;
	} 	  
	/**
	 * 属性xj_code的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getXj_code () {
		return xj_code;
	}   
	/**
	 * 属性xj_code的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newXj_code String
	 */
	public void setXj_code (String newXj_code ) {
	 	this.xj_code = newXj_code;
	} 	  
	/**
	 * 属性vuserdef16的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef16 () {
		return vuserdef16;
	}   
	/**
	 * 属性vuserdef16的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef16 String
	 */
	public void setVuserdef16 (String newVuserdef16 ) {
	 	this.vuserdef16 = newVuserdef16;
	} 	  
	/**
	 * 属性vbillno的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVbillno () {
		return vbillno;
	}   
	/**
	 * 属性vbillno的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVbillno String
	 */
	public void setVbillno (String newVbillno ) {
	 	this.vbillno = newVbillno;
	} 	  
	/**
	 * 属性vuserdef20的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef20 () {
		return vuserdef20;
	}   
	/**
	 * 属性vuserdef20的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef20 String
	 */
	public void setVuserdef20 (String newVuserdef20 ) {
	 	this.vuserdef20 = newVuserdef20;
	} 	  
	/**
	 * 属性dr的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return Integer
	 */
	public Integer getDr () {
		return dr;
	}   
	/**
	 * 属性dr的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newDr Integer
	 */
	public void setDr (Integer newDr ) {
	 	this.dr = newDr;
	} 	  
	/**
	 * 属性vuserdef2的Getter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @return String
	 */
	public String getVuserdef2 () {
		return vuserdef2;
	}   
	/**
	 * 属性vuserdef2的Setter方法.
	 * 创建日期:2016-08-15 12:55:17
	 * @param newVuserdef2 String
	 */
	public void setVuserdef2 (String newVuserdef2 ) {
	 	this.vuserdef2 = newVuserdef2;
	} 	  
 
	/**
	  * <p>取得父VO主键字段.
	  * <p>
	  * 创建日期:2016-08-15 12:55:17
	  * @return java.lang.String
	  */
	public java.lang.String getParentPKFieldName() {
		return "pk_datacontrol_type";
	}   
    
	/**
	  * <p>取得表主键.
	  * <p>
	  * 创建日期:2016-08-15 12:55:17
	  * @return java.lang.String
	  */
	public java.lang.String getPKFieldName() {
	  return "pk_datacontrol";
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:2016-08-15 12:55:17
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "dc_datacontrol";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:2016-08-15 12:55:17
	  */
     public DataControlVO() {
		super();	
	}    
} 

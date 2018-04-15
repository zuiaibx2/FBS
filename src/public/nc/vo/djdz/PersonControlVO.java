package nc.vo.djdz;
	
import nc.vo.pub.SuperVO;
	
/**
 * <b>人员类别对照节点 </b>
 * 创建日期:2016-07-26 21:42:50
 * @author wangzhq
 * @version NCPrj 1.0
 */
@SuppressWarnings("serial")
public class PersonControlVO extends SuperVO {
	private String pk_wh_h; //主表主键
	private String vbillno; //单据号
	private String pk_corp; //公司
	private String vnote; //备注
	private String doperatordate; //制单日期
 	private String category; //类别
 	private String person; //人员类别
	private String jt_zj; //集团对应主键
	private String jt_code; //集团对应编码
	private String jt_attr; //集团对应属性
	private String jt_name;//集团对应名称
	private String xj_name;//下级对应名称
	private String xj_pk; //下级对应主键
	private String xj_code; //下级对应编码
	private String xj_attr; //下级对应属性
	private Integer vbillstatus; //单据状态
	private String pk_billtype;//单据类型
	private String pk_busitype; //业务类型
	private Integer dr;//删除标志
	private String ts;//时间戳	
	private String vuserdef3;
	private String vuserdef4;
	private String vuserdef5;
	private String vuserdef6;
	private String vuserdef7;
	private String vuserdef8;
	private String vuserdef9;
	private String vuserdef10;
			
	public String getjt_zj() {
		return jt_zj;
	}
	public String getJt_code() {
		return jt_code;
	}
	public String getXj_pk() {
		return xj_pk;
	}
	public String getXj_code() {
		return xj_code;
	}
	public Integer getVbillstatus() {
		return vbillstatus;
	}
	public Integer getDr() {
		return dr;
	}
	public String getTs() {
		return ts;
	}
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String newPerson) {
		person = newPerson;
	}
	public String getJt_zj() {
		return jt_zj;
	}
	public String getJt_attr() {
		return jt_attr;
	}
	public String getXj_attr() {
		return xj_attr;
	}
	public void setJt_zj(String newJt_zj) {
		jt_zj = newJt_zj;
	}
	public void setJt_attr(String newJt_attr) {
		jt_attr = newJt_attr;
	}
	public void setXj_attr(String newXj_attr) {
		xj_attr = newXj_attr;
	}
	public void setjt_zj(String newJt_zj) {
		jt_zj = newJt_zj;
	}
	public void setJt_code(String newJt_code) {
		jt_code = newJt_code;
	}
	public void setXj_pk(String newXj_pk) {
		xj_pk = newXj_pk;
	}
	public void setVbillstatus(Integer newVbillstatus) {
		vbillstatus = newVbillstatus;
	}
	public void setDr(Integer newDr) {
		dr = newDr;
	}
	public void setTs(String newTs) {
		ts = newTs;
	}
	/**
	 * 属性pk_corp的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_corp () {
		return pk_corp;
	}   
	/**
	 * 属性pk_corp的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newPk_corp String
	 */
	public void setPk_corp (String newPk_corp ) {
	 	this.pk_corp = newPk_corp;
	} 	  
	/**
	 * 属性vuserdef9的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef9 () {
		return vuserdef9;
	}   
	/**
	 * 属性vuserdef9的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef9 String
	 */
	public void setVuserdef9 (String newVuserdef9 ) {
	 	this.vuserdef9 = newVuserdef9;
	} 	  
	/**
	 * 属性doperatordate的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return UFDate
	 */
	public String getDoperatordate () {
		return doperatordate;
	}   
	/**
	 * 属性doperatordate的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newDoperatordate UFDate
	 */
	public void setDoperatordate (String newDoperatordate ) {
	 	this.doperatordate = newDoperatordate;
	} 	  
	/**
	 * 属性vuserdef3的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef3 () {
		return vuserdef3;
	}   
	/**
	 * 属性vuserdef3的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef3 String
	 */
	public void setVuserdef3 (String newVuserdef3 ) {
	 	this.vuserdef3 = newVuserdef3;
	} 	  
	
	
	/**
	 * 属性xj_code的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getCode_xj () {
		return xj_code;
	}   
	/**
	 * 属性xj_code的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newXj_code UFDate
	 */
	public void setXj_code (String newXj_code) {
	 	this.xj_code = newXj_code;
	} 	  
	/**
	 * 属性pk_billtype的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_billtype () {
		return pk_billtype;
	}   
	/**
	 * 属性pk_billtype的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newPk_billtype String
	 */
	public void setPk_billtype (String newPk_billtype ) {
	 	this.pk_billtype = newPk_billtype;
	} 	  
	/**
	 * 属性jt_zj的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return UFDate
	 */
	
	/**
	 * 属性pk_busitype的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_busitype () {
		return pk_busitype;
	}   
	/**
	 * 属性pk_busitype的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newPk_busitype String
	 */
	public void setPk_busitype (String newPk_busitype ) {
	 	this.pk_busitype = newPk_busitype;
	}
	/**
	 * 属性vuserdef1的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getJt_name () {
		return jt_name;
	}   
	/**
	 * 属性vuserdef1的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef1 String
	 */
	public void setJt_name (String newJt_name ) {
	 	this.jt_name = newJt_name;
	} 	  
	
	/**
	 * 属性vbillno的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVbillno () {
		return vbillno;
	}   
	/**
	 * 属性vbillno的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVbillno String
	 */
	public void setVbillno (String newVbillno ) {
	 	this.vbillno = newVbillno;
	} 	  
	/**
	 * 属性vuserdef2的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getXj_name () {
		return xj_name;
	}   
	/**
	 * 属性vuserdef2的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef2 String
	 */
	public void setXj_name (String newXj_name ) {
	 	this.xj_name = newXj_name;
	} 	  
	/**
	 * 属性vuserdef5的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef5 () {
		return vuserdef5;
	}   
	/**
	 * 属性vuserdef5的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef5 String
	 */
	public void setVuserdef5 (String newVuserdef5 ) {
	 	this.vuserdef5 = newVuserdef5;
	} 	  
	/**
	 * 属性category的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return UFDate
	 */
	public String getCategory () {
		return category;
	}   
	/**
	 * 属性category的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newCategory UFDate
	 */
	public void setCategory (String newCategory ) {
	 	this.category = newCategory;
	} 	  
	/**
	 * 属性vnote的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVnote () {
		return vnote;
	}   
	/**
	 * 属性vnote的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVnote String
	 */
	public void setVnote (String newVnote ) {
	 	this.vnote = newVnote;
	} 	  
	/**
	 * 属性vuserdef8的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef8 () {
		return vuserdef8;
	}   
	/**
	 * 属性vuserdef8的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef8 String
	 */
	public void setVuserdef8 (String newVuserdef8 ) {
	 	this.vuserdef8 = newVuserdef8;
	} 	  
	/**
	 * 属性pk_wh_h的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_wh_h () {
		return pk_wh_h;
	}   
	/**
	 * 属性pk_wh_h的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newPk_wh_h String
	 */
	public void setPk_wh_h (String newPk_wh_h ) {
	 	this.pk_wh_h = newPk_wh_h;
	} 	  
	/**
	 * 属性vuserdef4的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef4 () {
		return vuserdef4;
	}   
	/**
	 * 属性vuserdef4的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef4 String
	 */
	public void setVuserdef4 (String newVuserdef4 ) {
	 	this.vuserdef4 = newVuserdef4;
	} 	  

	/**
	 * 属性vuserdef10的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef10 () {
		return vuserdef10;
	}   
	/**
	 * 属性vuserdef10的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef10 String
	 */
	public void setVuserdef10 (String newVuserdef10 ) {
	 	this.vuserdef10 = newVuserdef10;
	} 	  
	/**
	 * 属性vuserdef7的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef7 () {
		return vuserdef7;
	}   
	/**
	 * 属性vuserdef7的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef7 String
	 */
	public void setVuserdef7 (String newVuserdef7 ) {
	 	this.vuserdef7 = newVuserdef7;
	} 	  
	/**
	 * 属性vuserdef6的Getter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef6 () {
		return vuserdef6;
	}   
	/**
	 * 属性vuserdef6的Setter方法.
	 * 创建日期:2016-07-26 21:42:50
	 * @param newVuserdef6 String
	 */
	public void setVuserdef6 (String newVuserdef6 ) {
	 	this.vuserdef6 = newVuserdef6;
	} 	  
 
	/**
	  * <p>取得父VO主键字段.
	  * <p>
	  * 创建日期:2016-07-26 21:42:50
	  * @return java.lang.String
	  */
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	/**
	  * <p>取得表主键.
	  * <p>
	  * 创建日期:2016-07-26 21:42:50
	  * @return java.lang.String
	  */
	public java.lang.String getPKFieldName() {
	  return null;
	}
    
	/**
	 * <p>返回表名称.
	 * <p>
	 * 创建日期:2016-07-26 21:42:50
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "DC_DARACONTROL";
	}    
    
    /**
	  * 按照默认方式创建构造子.
	  *
	  * 创建日期:2016-07-26 21:42:50
	  */
     public PersonControlVO() {
		super();	
	}    
} 



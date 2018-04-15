package nc.vo.djdz;
	
import nc.vo.pub.SuperVO;
	
/**
 * <b>��Ա�����սڵ� </b>
 * ��������:2016-07-26 21:42:50
 * @author wangzhq
 * @version NCPrj 1.0
 */
@SuppressWarnings("serial")
public class PersonControlVO extends SuperVO {
	private String pk_wh_h; //��������
	private String vbillno; //���ݺ�
	private String pk_corp; //��˾
	private String vnote; //��ע
	private String doperatordate; //�Ƶ�����
 	private String category; //���
 	private String person; //��Ա���
	private String jt_zj; //���Ŷ�Ӧ����
	private String jt_code; //���Ŷ�Ӧ����
	private String jt_attr; //���Ŷ�Ӧ����
	private String jt_name;//���Ŷ�Ӧ����
	private String xj_name;//�¼���Ӧ����
	private String xj_pk; //�¼���Ӧ����
	private String xj_code; //�¼���Ӧ����
	private String xj_attr; //�¼���Ӧ����
	private Integer vbillstatus; //����״̬
	private String pk_billtype;//��������
	private String pk_busitype; //ҵ������
	private Integer dr;//ɾ����־
	private String ts;//ʱ���	
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
	 * ����pk_corp��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_corp () {
		return pk_corp;
	}   
	/**
	 * ����pk_corp��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newPk_corp String
	 */
	public void setPk_corp (String newPk_corp ) {
	 	this.pk_corp = newPk_corp;
	} 	  
	/**
	 * ����vuserdef9��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef9 () {
		return vuserdef9;
	}   
	/**
	 * ����vuserdef9��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef9 String
	 */
	public void setVuserdef9 (String newVuserdef9 ) {
	 	this.vuserdef9 = newVuserdef9;
	} 	  
	/**
	 * ����doperatordate��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return UFDate
	 */
	public String getDoperatordate () {
		return doperatordate;
	}   
	/**
	 * ����doperatordate��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newDoperatordate UFDate
	 */
	public void setDoperatordate (String newDoperatordate ) {
	 	this.doperatordate = newDoperatordate;
	} 	  
	/**
	 * ����vuserdef3��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef3 () {
		return vuserdef3;
	}   
	/**
	 * ����vuserdef3��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef3 String
	 */
	public void setVuserdef3 (String newVuserdef3 ) {
	 	this.vuserdef3 = newVuserdef3;
	} 	  
	
	
	/**
	 * ����xj_code��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getCode_xj () {
		return xj_code;
	}   
	/**
	 * ����xj_code��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newXj_code UFDate
	 */
	public void setXj_code (String newXj_code) {
	 	this.xj_code = newXj_code;
	} 	  
	/**
	 * ����pk_billtype��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_billtype () {
		return pk_billtype;
	}   
	/**
	 * ����pk_billtype��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newPk_billtype String
	 */
	public void setPk_billtype (String newPk_billtype ) {
	 	this.pk_billtype = newPk_billtype;
	} 	  
	/**
	 * ����jt_zj��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return UFDate
	 */
	
	/**
	 * ����pk_busitype��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_busitype () {
		return pk_busitype;
	}   
	/**
	 * ����pk_busitype��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newPk_busitype String
	 */
	public void setPk_busitype (String newPk_busitype ) {
	 	this.pk_busitype = newPk_busitype;
	}
	/**
	 * ����vuserdef1��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getJt_name () {
		return jt_name;
	}   
	/**
	 * ����vuserdef1��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef1 String
	 */
	public void setJt_name (String newJt_name ) {
	 	this.jt_name = newJt_name;
	} 	  
	
	/**
	 * ����vbillno��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVbillno () {
		return vbillno;
	}   
	/**
	 * ����vbillno��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVbillno String
	 */
	public void setVbillno (String newVbillno ) {
	 	this.vbillno = newVbillno;
	} 	  
	/**
	 * ����vuserdef2��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getXj_name () {
		return xj_name;
	}   
	/**
	 * ����vuserdef2��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef2 String
	 */
	public void setXj_name (String newXj_name ) {
	 	this.xj_name = newXj_name;
	} 	  
	/**
	 * ����vuserdef5��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef5 () {
		return vuserdef5;
	}   
	/**
	 * ����vuserdef5��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef5 String
	 */
	public void setVuserdef5 (String newVuserdef5 ) {
	 	this.vuserdef5 = newVuserdef5;
	} 	  
	/**
	 * ����category��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return UFDate
	 */
	public String getCategory () {
		return category;
	}   
	/**
	 * ����category��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newCategory UFDate
	 */
	public void setCategory (String newCategory ) {
	 	this.category = newCategory;
	} 	  
	/**
	 * ����vnote��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVnote () {
		return vnote;
	}   
	/**
	 * ����vnote��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVnote String
	 */
	public void setVnote (String newVnote ) {
	 	this.vnote = newVnote;
	} 	  
	/**
	 * ����vuserdef8��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef8 () {
		return vuserdef8;
	}   
	/**
	 * ����vuserdef8��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef8 String
	 */
	public void setVuserdef8 (String newVuserdef8 ) {
	 	this.vuserdef8 = newVuserdef8;
	} 	  
	/**
	 * ����pk_wh_h��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getPk_wh_h () {
		return pk_wh_h;
	}   
	/**
	 * ����pk_wh_h��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newPk_wh_h String
	 */
	public void setPk_wh_h (String newPk_wh_h ) {
	 	this.pk_wh_h = newPk_wh_h;
	} 	  
	/**
	 * ����vuserdef4��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef4 () {
		return vuserdef4;
	}   
	/**
	 * ����vuserdef4��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef4 String
	 */
	public void setVuserdef4 (String newVuserdef4 ) {
	 	this.vuserdef4 = newVuserdef4;
	} 	  

	/**
	 * ����vuserdef10��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef10 () {
		return vuserdef10;
	}   
	/**
	 * ����vuserdef10��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef10 String
	 */
	public void setVuserdef10 (String newVuserdef10 ) {
	 	this.vuserdef10 = newVuserdef10;
	} 	  
	/**
	 * ����vuserdef7��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef7 () {
		return vuserdef7;
	}   
	/**
	 * ����vuserdef7��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef7 String
	 */
	public void setVuserdef7 (String newVuserdef7 ) {
	 	this.vuserdef7 = newVuserdef7;
	} 	  
	/**
	 * ����vuserdef6��Getter����.
	 * ��������:2016-07-26 21:42:50
	 * @return String
	 */
	public String getVuserdef6 () {
		return vuserdef6;
	}   
	/**
	 * ����vuserdef6��Setter����.
	 * ��������:2016-07-26 21:42:50
	 * @param newVuserdef6 String
	 */
	public void setVuserdef6 (String newVuserdef6 ) {
	 	this.vuserdef6 = newVuserdef6;
	} 	  
 
	/**
	  * <p>ȡ�ø�VO�����ֶ�.
	  * <p>
	  * ��������:2016-07-26 21:42:50
	  * @return java.lang.String
	  */
	public java.lang.String getParentPKFieldName() {
	    return null;
	}   
    
	/**
	  * <p>ȡ�ñ�����.
	  * <p>
	  * ��������:2016-07-26 21:42:50
	  * @return java.lang.String
	  */
	public java.lang.String getPKFieldName() {
	  return null;
	}
    
	/**
	 * <p>���ر�����.
	 * <p>
	 * ��������:2016-07-26 21:42:50
	 * @return java.lang.String
	 */
	public java.lang.String getTableName() {
		return "DC_DARACONTROL";
	}    
    
    /**
	  * ����Ĭ�Ϸ�ʽ����������.
	  *
	  * ��������:2016-07-26 21:42:50
	  */
     public PersonControlVO() {
		super();	
	}    
} 



package nc.ui.datacontrol.secret.duty;

import nc.ui.bd.ref.AbstractRefModel;

public class DataControlRef extends AbstractRefModel{
	 /* 
	  * 构造子注解nc.ui.datacontrol.secret.duty.DataControlRef
	 */
	public DataControlRef(){
		super();
	}
	/**
    * 显示字段列表 
    * 
    * @return java.lang.String
    */
  public java.lang.String[] getFieldCode() {
       return new String[] { "DOCLISTCODE",//"字段编码" (按照第一个字段排序)
       		"DOCLISTNAME",//字段名称
       						};
   }

   /**
    * 显示字段中文名 
    * 
    * @return java.lang.String
    */
   public java.lang.String[] getFieldName() {

       return new String[] {
      		"字段编码",
       		"字段名称",
               };
   }
   /**
    * 隐藏的字段编码
    * 
    * @return java.lang.String[]
    */
   public String[] getHiddenFieldCode() {
       return new String[] { "PK_DEFDOCLIST"};
   }

   /**
    * 主键字段名
    * 
    * @return java.lang.String
    */
  public String getPkFieldCode() {
      return "PK_DEFDOCLIST";
   }

   /**
   * 参照标题 创建日期：(01-4-4 0:57:23)
    * 
    * @return java.lang.String
    */
   public String getRefTitle() {
   	return "数据对照";
   }

   /**
    * 参照数据库表或者视图名 创建日期：(01-4-4 0:57:23)
    * 
    * @return java.lang.String
    */
   public String getTableName() {
       return "mid_bd_defdoclist";
   }
   
   /**
    * add by changrh
    * 2014-12-26
	 * 默认显示字段中的显示字段数----表示显示前几个字段
	 */
	public int getDefaultFieldCount() {
		return 2;
	}
}

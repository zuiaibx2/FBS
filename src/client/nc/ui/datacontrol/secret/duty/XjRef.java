package nc.ui.datacontrol.secret.duty;

import nc.ui.bd.ref.AbstractRefModel;

public class XjRef extends AbstractRefModel{
	 /* *
	  * 构造子注解nc.ui.datacontrol.secret.duty.JtRef
	 */
	public XjRef(){
		super();
	}
	/**
    * 显示字段列表 
    * @return java.lang.String
    */
  public java.lang.String[] getFieldCode() {
       return new String[] { "bd_defdoc.DOCCODE",//"字段编码" (按照第一个字段排序)
       		"bd_defdoc.DOCNAME","bd_corp.unitname",//字段名称
       						};
   }

   /**
    * 显示字段中文名 
    * @return java.lang.String
    */
   public java.lang.String[] getFieldName() {

       return new String[] {
      		"字段编码",
       		"字段名称","公司",
               };
   }
   /**
    * 隐藏的字段编码
    * @return java.lang.String[]
    */
   public String[] getHiddenFieldCode() {
       return new String[] { "bd_defdoc.PK_DEFDOC" };
   }

   /**
    * 主键字段名
    * 
    * @return java.lang.String
    */
  public String getPkFieldCode() {
      return " bd_defdoc.PK_DEFDOC";
   }

   /**
   * 参照标题 创建日期:(16-7-29 11:29)
    * @return java.lang.String
    */
   public String getRefTitle() {
   	return "下级对应字段";
   }

   /**
    * 参照数据库表或者视图名 创建日期：(16-7-29 11:29)
    * @return java.lang.String
    */
   public String getTableName() {
       return "bd_defdoc  left join bd_corp on bd_defdoc.pk_corp = bd_corp.pk_corp ";
   }
   
   /**
	 * 默认显示字段中的显示字段数----表示显示前几个字段
	 */
	public int getDefaultFieldCount() {
		return 3;
	}
}

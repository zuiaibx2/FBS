/**
 * 
 */
package nc.ui.datacontrol.secret.duty;

import nc.ui.bd.ref.AbstractRefModel;

public class PersonRef extends AbstractRefModel{/**
	 * 构造子注解nc.ui.secret.duty.PersonRef
	 */
	public PersonRef(){
		super();
	}
	/**
     * 显示字段列表 
     * 
     * @return java.lang.String
     */
    public java.lang.String[] getFieldCode() {
        return new String[] { "PSNCLASSCODE",//人员类别编码 (按照第一个字段排序)
        		"PSNCLASSNAME",//人员类别名称
        						};
    }

    /**
     * 显示字段中文名 
     * 
     * @return java.lang.String
     */
    public java.lang.String[] getFieldName() {

        return new String[] {//"涉密职责主键",
        		"人员类别编码",
        		"人员类别名称",
                };
    }
    /**
     * 隐藏的字段编码
     * 
     * @return java.lang.String[]
     */
    public String[] getHiddenFieldCode() {
        return new String[] { "pk_psncl" };
    }

    /**
     * 主键字段名
     * 
     * @return java.lang.String
     */
    public String getPkFieldCode() {
        return "pk_psncl";
    }

    /**
     * 参照标题 创建日期：(01-4-4 0:57:23)
     * 
     * @return java.lang.String
     */
    public String getRefTitle() {
    	return "人员类别参照";
    }

    /**
     * 参照数据库表或者视图名 创建日期：(01-4-4 0:57:23)
     * 
     * @return java.lang.String
     */
    public String getTableName() {
        return "mid_bd_psncl";
    }
    
	public int getDefaultFieldCount() {
		return 2;
	}
}

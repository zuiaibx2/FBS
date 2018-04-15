package nc.util.fbs.pub;

import java.math.BigDecimal;

import nc.vo.pub.lang.UFBoolean;
import nc.vo.pub.lang.UFDouble;

/**
 * 公共方法工具类
 * 
 * @author lxf
 * @date 2013-9-10
 */
public class PubTool {


    /**
     * 根据一个对象的值得到UFDouble的值，如果为空返回零
     * 
     * @author duyt
     * @param value
     * @return
     */
    public static UFDouble getUFDouble_NullAsZero(Object value) {
	try {
	    if (value == null || "".equals(value.toString().trim())) {
		return new UFDouble(0);
	    } else if (value instanceof UFDouble) {
		return (UFDouble) value;
	    } else if (value instanceof BigDecimal) {
		return new UFDouble((BigDecimal) value);
	    } else if (value instanceof Integer) {
		return new UFDouble((Integer) value);
	    } else if ("无".equals(value)) {
		return new UFDouble(0);
	    } else {
		return new UFDouble(value.toString().trim());
	    }
	} catch (Exception e) {
	    return new UFDouble(0);
	}

    }

    /**
     * 判断对象是否为空或null
     * 
     * @author jieely
     * @param object
     * @return
     */
    public static boolean isNull(Object object) {
	return object == null || "".equals(object);
    }

    /**
     * 把Object转换为非空的UFBoolean类型
     * 
     * @author duyt
     * @date2012-2-20 下午05:43:11
     * @param object
     * @return
     */
    public static UFBoolean toUFBoolean(Object object) {
	return new UFBoolean(toString(object));

    }

    /**
     * 把Object转换为String类型
     * 
     * @author duyt
     * @date2012-2-20 下午05:16:13
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
	if (obj == null) {
	    return "";
	} else {
	    return obj.toString();
	}
    }
}

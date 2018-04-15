package nc.vo.djdz;

import java.util.Arrays;

import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.trade.pub.HYBillVO;

/**
 * 
 * 单子表/单表头/单表体聚合VO
 *
 * @author Administrator
 * @version NCPrj 1.0
 */
public class HBillVO extends HYBillVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public CircularlyAccessibleValueObject[] getChildrenVO() {
		return (DataControlVO[]) super.getChildrenVO();
	}
	@Override
	public CircularlyAccessibleValueObject getParentVO() {
		return (DataControl_typeVO) super.getParentVO();
	}
	@Override
	public void setChildrenVO(CircularlyAccessibleValueObject[] children) {
		if( children == null || children.length == 0 ){
			super.setChildrenVO(null);
		}
		else{
			super.setChildrenVO((CircularlyAccessibleValueObject[]) Arrays.asList(children).toArray(new DataControlVO[0]));
		}
	}
	@Override
	public void setParentVO(CircularlyAccessibleValueObject parent) {
		super.setParentVO((DataControl_typeVO)parent);
	}
	
 
}

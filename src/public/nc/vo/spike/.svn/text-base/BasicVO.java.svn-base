package nc.vo.spike;

import java.io.Serializable;

import nc.vo.pub.SuperVO;

/**
 * @ClassName: BasicVO
 * <b> 基础VO </b>
 * <p>
 *     存放VO的一些公共字段
 * </p>
 * 创建日期: 2016年7月26日 下午5:11:35
 * @Author 王凯强
 * @Version 
 */
public abstract class BasicVO extends SuperVO implements Serializable {
	private static final long serialVersionUID = 4673913167731773965L;

	public static String SPIKE_EDIT = "edit";
	public static String SPIKE_DEL = "del";
	public static String SPIKE_ADD = "add";

	/**
	 * @field : spike_sign
	 * @Discription : 增量标记，分别为edit，del，add
	 */
	private java.lang.String spike_sign;
	public static String SPIKE_SIGN = "spike_sign";
	/**
	 * @field: ts_m
	 * @Discription: 上次操作时间
	 */
	private java.lang.String ts_m;
	/**
	 * @field: ts_old
	 * @Discription: 业务表的ts
	 */
	private java.lang.String ts_old;

	/**
	 * @field: bas_pkcorp
	 * @Discription: 人员基本信息公司主键
	 */
	private java.lang.String bas_pkcorp;
	
	public BasicVO() {
		super();
	}

	public BasicVO(String spike_sign, String ts_m) {
		super();
		this.spike_sign = spike_sign;
		this.ts_m = ts_m;
	}

	public java.lang.String getSpike_sign() {
		return spike_sign;
	}

	public void setSpike_sign(java.lang.String spike_sign) {
		this.spike_sign = spike_sign;
	}

	public java.lang.String getTs_m() {
		return ts_m;
	}

	public void setTs_m(java.lang.String ts_m) {
		this.ts_m = ts_m;
	}

	public java.lang.String getTs_old()
	{
		return ts_old;
	}

	public void setTs_old(java.lang.String ts_old)
	{
		this.ts_old = ts_old;
	}

	public java.lang.String getBas_pkcorp() {
		return bas_pkcorp;
	}

	public void setBas_pkcorp(java.lang.String bas_pkcorp) {
		this.bas_pkcorp = bas_pkcorp;
	}
	
}

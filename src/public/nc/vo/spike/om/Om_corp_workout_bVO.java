package nc.vo.spike.om;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: Om_corp_workout_bVO
 * <b> 单位编制子表中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期: 2016年7月27日 下午7:31:36
 * @Author 王凯强
 * @Version 
 */
public class Om_corp_workout_bVO extends BasicVO {
	private static final long serialVersionUID = -4021705664525395400L;
	
	private java.lang.Integer dr;
	private java.lang.String iscrictrl;
	private java.lang.String pk_om_corp_workout;
	/**
	 * @field: pk_om_corp_workout_b
	 * @Discription: 主键
	 */
	private java.lang.String pk_om_corp_workout_b;
	private java.lang.String pk_om_corp_workout_b_old;
	private java.lang.String pk_ref;
	private java.lang.String pk_ref_name;
	private java.lang.String ts;
	private java.lang.Long workout;
	private java.lang.Long workoutcount;
	
	private java.lang.String pk_corp;
	
	/**
	 * @field: unitcode
	 * @Discription: 编制公司编码
	 */
	private java.lang.String unitcode;

	public java.lang.String getPk_om_corp_workout_b_old() {
		return pk_om_corp_workout_b_old;
	}

	public void setPk_om_corp_workout_b_old(java.lang.String pk_om_corp_workout_b_old) {
		this.pk_om_corp_workout_b_old = pk_om_corp_workout_b_old;
	}

	public java.lang.Integer getDr() {
		return dr;
	}

	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}

	public java.lang.String getIscrictrl() {
		return iscrictrl;
	}

	public void setIscrictrl(java.lang.String iscrictrl) {
		this.iscrictrl = iscrictrl;
	}

	public java.lang.String getPk_om_corp_workout() {
		return pk_om_corp_workout;
	}

	public void setPk_om_corp_workout(java.lang.String pk_om_corp_workout) {
		this.pk_om_corp_workout = pk_om_corp_workout;
	}

	public java.lang.String getPk_om_corp_workout_b() {
		return pk_om_corp_workout_b;
	}

	public void setPk_om_corp_workout_b(java.lang.String pk_om_corp_workout_b) {
		this.pk_om_corp_workout_b = pk_om_corp_workout_b;
	}

	public java.lang.String getPk_ref() {
		return pk_ref;
	}

	public void setPk_ref(java.lang.String pk_ref) {
		this.pk_ref = pk_ref;
	}

	public java.lang.String getPk_ref_name() {
		return pk_ref_name;
	}

	public void setPk_ref_name(java.lang.String pk_ref_name) {
		this.pk_ref_name = pk_ref_name;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	public java.lang.Long getWorkout() {
		return workout;
	}

	public void setWorkout(java.lang.Long workout) {
		this.workout = workout;
	}

	public java.lang.Long getWorkoutcount() {
		return workoutcount;
	}

	public void setWorkoutcount(java.lang.Long workoutcount) {
		this.workoutcount = workoutcount;
	}

	public java.lang.String getUnitcode() {
		return unitcode;
	}

	public void setUnitcode(java.lang.String unitcode) {
		this.unitcode = unitcode;
	}

	public java.lang.String getPk_corp() {
		return pk_corp;
	}

	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}

	@Override
	public String getPKFieldName() {
		return "pk_om_corp_workout_b";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "mid_om_corp_workout_b";
	}
	
}

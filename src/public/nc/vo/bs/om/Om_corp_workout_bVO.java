package nc.vo.bs.om;

import nc.vo.pub.SuperVO;


/**
 * @ClassName: Om_corp_workout_bVO
 * @Description:  单位编制子表
 * @项目名称: fbsjt
 * @文件名称: Om_corp_workout_bVO.java
 * @Author: 王凯强
 * @Date: 2016年7月27日下午7:31:36
 */
public class Om_corp_workout_bVO extends SuperVO {
	private static final long serialVersionUID = -4021705664525395400L;
	
//	private java.lang.Integer dr;
//	private java.lang.String iscrictrl;
	private java.lang.String pk_om_corp_workout;
	/**
	 * @field: pk_om_corp_workout_b
	 * @Discription: 主键
	 */
	private java.lang.String pk_om_corp_workout_b;
	private java.lang.String pk_ref;
	private java.lang.String pk_ref_name;
	private java.lang.String ts;
	private java.lang.Long workout;
	private java.lang.Long workoutcount;

//	public java.lang.Integer getDr() {
//		return dr;
//	}
//
//	public void setDr(java.lang.Integer dr) {
//		this.dr = dr;
//	}
//
//	public java.lang.String getIscrictrl() {
//		return iscrictrl;
//	}
//
//	public void setIscrictrl(java.lang.String iscrictrl) {
//		this.iscrictrl = iscrictrl;
//	}

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

	@Override
	public String getPKFieldName() {
		return "pk_om_corp_workout_b";
	}

	@Override
	public String getParentPKFieldName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		return "om_corp_workout_b";
	}
}

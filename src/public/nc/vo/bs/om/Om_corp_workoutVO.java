package nc.vo.bs.om;

import nc.vo.pub.SuperVO;


/**
 * @ClassName: Om_corp_workoutVO
 * @Description:  单位编制信息
 * @项目名称: fbsjt
 * @文件名称: Om_corp_workoutVO.java
 * @Author: 王凯强
 * @Date: 2016年7月27日下午7:16:23
 */
public class Om_corp_workoutVO extends SuperVO{

	private static final long serialVersionUID = -7880746658783960785L;
	
	private java.lang.Long actualnum;
	private java.lang.Long cyear;
//	private java.lang.Integer dr;
//	private java.lang.String groupdef1;
//	private java.lang.String groupdef10;
//	private java.lang.String groupdef2;
//	private java.lang.String groupdef3;
//	private java.lang.String groupdef4;
//	private java.lang.String groupdef5;
//	private java.lang.String groupdef6;
//	private java.lang.String groupdef7;
//	private java.lang.String groupdef8;
//	private java.lang.String groupdef9;
//	private java.lang.String iscrictrl;
	private java.lang.String makecorp;
	private java.lang.String pk_corp;
	private java.lang.String pk_om_corp_workout;
	private java.lang.String pk_om_workout_type;
	private java.lang.Long stat;
	private java.lang.String ts;
	private java.lang.String version;
	private java.lang.String workout;
	private java.lang.String statdate;
//	private java.lang.String istemporary;
	
	public java.lang.Long getActualnum() {
		return actualnum;
	}
	public void setActualnum(java.lang.Long actualnum) {
		this.actualnum = actualnum;
	}
	public java.lang.Long getCyear() {
		return cyear;
	}
	public void setCyear(java.lang.Long cyear) {
		this.cyear = cyear;
	}
//	public java.lang.Integer getDr() {
//		return dr;
//	}
//	public void setDr(java.lang.Integer dr) {
//		this.dr = dr;
//	}
//	public java.lang.String getGroupdef1() {
//		return groupdef1;
//	}
//	public void setGroupdef1(java.lang.String groupdef1) {
//		this.groupdef1 = groupdef1;
//	}
//	public java.lang.String getGroupdef10() {
//		return groupdef10;
//	}
//	public void setGroupdef10(java.lang.String groupdef10) {
//		this.groupdef10 = groupdef10;
//	}
//	public java.lang.String getGroupdef2() {
//		return groupdef2;
//	}
//	public void setGroupdef2(java.lang.String groupdef2) {
//		this.groupdef2 = groupdef2;
//	}
//	public java.lang.String getGroupdef3() {
//		return groupdef3;
//	}
//	public void setGroupdef3(java.lang.String groupdef3) {
//		this.groupdef3 = groupdef3;
//	}
//	public java.lang.String getGroupdef4() {
//		return groupdef4;
//	}
//	public void setGroupdef4(java.lang.String groupdef4) {
//		this.groupdef4 = groupdef4;
//	}
//	public java.lang.String getGroupdef5() {
//		return groupdef5;
//	}
//	public void setGroupdef5(java.lang.String groupdef5) {
//		this.groupdef5 = groupdef5;
//	}
//	public java.lang.String getGroupdef6() {
//		return groupdef6;
//	}
//	public void setGroupdef6(java.lang.String groupdef6) {
//		this.groupdef6 = groupdef6;
//	}
//	public java.lang.String getGroupdef7() {
//		return groupdef7;
//	}
//	public void setGroupdef7(java.lang.String groupdef7) {
//		this.groupdef7 = groupdef7;
//	}
//	public java.lang.String getGroupdef8() {
//		return groupdef8;
//	}
//	public void setGroupdef8(java.lang.String groupdef8) {
//		this.groupdef8 = groupdef8;
//	}
//	public java.lang.String getGroupdef9() {
//		return groupdef9;
//	}
//	public void setGroupdef9(java.lang.String groupdef9) {
//		this.groupdef9 = groupdef9;
//	}
//	public java.lang.String getIscrictrl() {
//		return iscrictrl;
//	}
//	public void setIscrictrl(java.lang.String iscrictrl) {
//		this.iscrictrl = iscrictrl;
//	}
	public java.lang.String getMakecorp() {
		return makecorp;
	}
	public void setMakecorp(java.lang.String makecorp) {
		this.makecorp = makecorp;
	}
	public java.lang.String getPk_corp() {
		return pk_corp;
	}
	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}
	public java.lang.String getPk_om_corp_workout() {
		return pk_om_corp_workout;
	}
	public void setPk_om_corp_workout(java.lang.String pk_om_corp_workout) {
		this.pk_om_corp_workout = pk_om_corp_workout;
	}
	public java.lang.String getPk_om_workout_type() {
		return pk_om_workout_type;
	}
	public void setPk_om_workout_type(java.lang.String pk_om_workout_type) {
		this.pk_om_workout_type = pk_om_workout_type;
	}
	public java.lang.Long getStat() {
		return stat;
	}
	public void setStat(java.lang.Long stat) {
		this.stat = stat;
	}
	public java.lang.String getTs() {
		return ts;
	}
	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}
	public java.lang.String getVersion() {
		return version;
	}
	public void setVersion(java.lang.String version) {
		this.version = version;
	}
	public java.lang.String getWorkout() {
		return workout;
	}
	public void setWorkout(java.lang.String workout) {
		this.workout = workout;
	}
	public java.lang.String getStatdate() {
		return statdate;
	}
	public void setStatdate(java.lang.String statdate) {
		this.statdate = statdate;
	}
//	public java.lang.String getIstemporary() {
//		return istemporary;
//	}
//	public void setIstemporary(java.lang.String istemporary) {
//		this.istemporary = istemporary;
//	}
	@Override
	public String getPKFieldName() {
		return "pk_om_corp_workout";
	}
	@Override
	public String getParentPKFieldName() {
		return null;
	}
	@Override
	public String getTableName() {
		return "om_corp_workout";
	}
}

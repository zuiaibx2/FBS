package nc.vo.spike.expert;

import nc.vo.spike.BasicVO;

/**
 * @ClassName: Expert_termVO
 * <b> 院士专家子集－聘期管理中间表VO </b>
 * <p>
 *     在此处添加此类的描述信息
 * </p>
 * 创建日期:2016年7月27日 上午10:09:56
 * @Author 王凯强
 * @Version 
 */
public class Expert_termVO extends BasicVO {

	private static final long serialVersionUID = 8772564036342132819L;
	private java.lang.String begindate;
	private java.lang.String card_code;
	private java.lang.String def1;
	private java.lang.String def2;
	private java.lang.Integer dr;
	private java.lang.String enddate;
	private java.lang.String expel;
	private java.lang.String glory_step;
	private java.lang.String groupdef1;
	private java.lang.String groupdef10;
	private java.lang.String groupdef11;
	private java.lang.String groupdef12;
	private java.lang.String groupdef13;
	private java.lang.String groupdef14;
	private java.lang.String groupdef15;
	private java.lang.String groupdef16;
	private java.lang.String groupdef17;
	private java.lang.String groupdef18;
	private java.lang.String groupdef19;
	private java.lang.String groupdef2;
	private java.lang.String groupdef20;
	private java.lang.String groupdef3;
	private java.lang.String groupdef4;
	private java.lang.String groupdef5;
	private java.lang.String groupdef6;
	private java.lang.String groupdef7;
	private java.lang.String groupdef8;
	private java.lang.String groupdef9;
	private java.lang.String is_term;
	private java.lang.String judge;
	private java.lang.String memo;
	private java.lang.Long pass_poll;
	/**
	 * @field: pk_expert_term
	 * @Discription: 主键
	 */
	private java.lang.String pk_expert_term;
	private java.lang.String pk_expert_term_old;
	private java.lang.String pk_hr_exper;
	private java.lang.Long poll;
	private java.lang.String recommend;
	private java.lang.Long subsidy;
	private java.lang.String term_corp;
	private java.lang.String term_team;
	private java.lang.String treatment;
	private java.lang.String ts;
	
     
	/**
	 * @field: pk_corp
	 * @Discription: 公司编码
	 */
	private java.lang.String pk_corp;
	
	/**
	 * @field: pk_psncl
	 * @Discription: 人员类别
	 */
	private java.lang.String pk_psncl;
	
	/**
	 * @field: exper_code
	 * @Discription: 专家编号
	 */
	private java.lang.String exper_code;
	
	public java.lang.String getPk_corp() {
		return pk_corp;
	}

	public void setPk_corp(java.lang.String pk_corp) {
		this.pk_corp = pk_corp;
	}

	public java.lang.String getPk_psncl() {
		return pk_psncl;
	}

	public void setPk_psncl(java.lang.String pk_psncl) {
		this.pk_psncl = pk_psncl;
	}

	public java.lang.String getExper_code() {
		return exper_code;
	}

	public void setExper_code(java.lang.String exper_code) {
		this.exper_code = exper_code;
	}

	public java.lang.String getPk_expert_term_old() {
		return pk_expert_term_old;
	}

	public void setPk_expert_term_old(java.lang.String pk_expert_term_old) {
		this.pk_expert_term_old = pk_expert_term_old;
	}

	public java.lang.String getBegindate() {
		return begindate;
	}

	public void setBegindate(java.lang.String begindate) {
		this.begindate = begindate;
	}

	public java.lang.String getCard_code() {
		return card_code;
	}

	public void setCard_code(java.lang.String card_code) {
		this.card_code = card_code;
	}

	public java.lang.String getDef1() {
		return def1;
	}

	public void setDef1(java.lang.String def1) {
		this.def1 = def1;
	}

	public java.lang.String getDef2() {
		return def2;
	}

	public void setDef2(java.lang.String def2) {
		this.def2 = def2;
	}

	public java.lang.String getEnddate() {
		return enddate;
	}

	public void setEnddate(java.lang.String enddate) {
		this.enddate = enddate;
	}

	public java.lang.String getExpel() {
		return expel;
	}

	public void setExpel(java.lang.String expel) {
		this.expel = expel;
	}

	public java.lang.String getGlory_step() {
		return glory_step;
	}

	public void setGlory_step(java.lang.String glory_step) {
		this.glory_step = glory_step;
	}

	public java.lang.String getGroupdef1() {
		return groupdef1;
	}

	public void setGroupdef1(java.lang.String groupdef1) {
		this.groupdef1 = groupdef1;
	}

	public java.lang.String getGroupdef10() {
		return groupdef10;
	}

	public void setGroupdef10(java.lang.String groupdef10) {
		this.groupdef10 = groupdef10;
	}

	public java.lang.String getGroupdef11() {
		return groupdef11;
	}

	public void setGroupdef11(java.lang.String groupdef11) {
		this.groupdef11 = groupdef11;
	}

	public java.lang.String getGroupdef12() {
		return groupdef12;
	}

	public void setGroupdef12(java.lang.String groupdef12) {
		this.groupdef12 = groupdef12;
	}

	public java.lang.String getGroupdef13() {
		return groupdef13;
	}

	public void setGroupdef13(java.lang.String groupdef13) {
		this.groupdef13 = groupdef13;
	}

	public java.lang.String getGroupdef14() {
		return groupdef14;
	}

	public void setGroupdef14(java.lang.String groupdef14) {
		this.groupdef14 = groupdef14;
	}

	public java.lang.String getGroupdef15() {
		return groupdef15;
	}

	public void setGroupdef15(java.lang.String groupdef15) {
		this.groupdef15 = groupdef15;
	}

	public java.lang.String getGroupdef16() {
		return groupdef16;
	}

	public void setGroupdef16(java.lang.String groupdef16) {
		this.groupdef16 = groupdef16;
	}

	public java.lang.String getGroupdef17() {
		return groupdef17;
	}

	public void setGroupdef17(java.lang.String groupdef17) {
		this.groupdef17 = groupdef17;
	}

	public java.lang.String getGroupdef18() {
		return groupdef18;
	}

	public void setGroupdef18(java.lang.String groupdef18) {
		this.groupdef18 = groupdef18;
	}

	public java.lang.String getGroupdef19() {
		return groupdef19;
	}

	public void setGroupdef19(java.lang.String groupdef19) {
		this.groupdef19 = groupdef19;
	}

	public java.lang.String getGroupdef2() {
		return groupdef2;
	}

	public void setGroupdef2(java.lang.String groupdef2) {
		this.groupdef2 = groupdef2;
	}

	public java.lang.String getGroupdef20() {
		return groupdef20;
	}

	public void setGroupdef20(java.lang.String groupdef20) {
		this.groupdef20 = groupdef20;
	}

	public java.lang.String getGroupdef3() {
		return groupdef3;
	}

	public void setGroupdef3(java.lang.String groupdef3) {
		this.groupdef3 = groupdef3;
	}

	public java.lang.String getGroupdef4() {
		return groupdef4;
	}

	public void setGroupdef4(java.lang.String groupdef4) {
		this.groupdef4 = groupdef4;
	}

	public java.lang.String getGroupdef5() {
		return groupdef5;
	}

	public void setGroupdef5(java.lang.String groupdef5) {
		this.groupdef5 = groupdef5;
	}

	public java.lang.String getGroupdef6() {
		return groupdef6;
	}

	public void setGroupdef6(java.lang.String groupdef6) {
		this.groupdef6 = groupdef6;
	}

	public java.lang.String getGroupdef7() {
		return groupdef7;
	}

	public void setGroupdef7(java.lang.String groupdef7) {
		this.groupdef7 = groupdef7;
	}

	public java.lang.String getGroupdef8() {
		return groupdef8;
	}

	public void setGroupdef8(java.lang.String groupdef8) {
		this.groupdef8 = groupdef8;
	}

	public java.lang.String getGroupdef9() {
		return groupdef9;
	}

	public void setGroupdef9(java.lang.String groupdef9) {
		this.groupdef9 = groupdef9;
	}

	public java.lang.String getIs_term() {
		return is_term;
	}

	public void setIs_term(java.lang.String is_term) {
		this.is_term = is_term;
	}

	public java.lang.String getJudge() {
		return judge;
	}

	public void setJudge(java.lang.String judge) {
		this.judge = judge;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getPk_expert_term() {
		return pk_expert_term;
	}

	public void setPk_expert_term(java.lang.String pk_expert_term) {
		this.pk_expert_term = pk_expert_term;
	}

	public java.lang.String getPk_hr_exper() {
		return pk_hr_exper;
	}

	public void setPk_hr_exper(java.lang.String pk_hr_exper) {
		this.pk_hr_exper = pk_hr_exper;
	}

	public java.lang.String getTerm_corp() {
		return term_corp;
	}

	public void setTerm_corp(java.lang.String term_corp) {
		this.term_corp = term_corp;
	}

	public java.lang.String getTerm_team() {
		return term_team;
	}

	public void setTerm_team(java.lang.String term_team) {
		this.term_team = term_team;
	}

	public java.lang.String getTreatment() {
		return treatment;
	}

	public void setTreatment(java.lang.String treatment) {
		this.treatment = treatment;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	public java.lang.Integer getDr() {
		return dr;
	}

	public void setDr(java.lang.Integer dr) {
		this.dr = dr;
	}

	public java.lang.Long getPass_poll() {
		return pass_poll;
	}

	public void setPass_poll(java.lang.Long pass_poll) {
		this.pass_poll = pass_poll;
	}

	public java.lang.Long getPoll() {
		return poll;
	}

	public void setPoll(java.lang.Long poll) {
		this.poll = poll;
	}

	public java.lang.String getRecommend() {
		return recommend;
	}

	public void setRecommend(java.lang.String recommend) {
		this.recommend = recommend;
	}

	public java.lang.Long getSubsidy() {
		return subsidy;
	}

	public void setSubsidy(java.lang.Long subsidy) {
		this.subsidy = subsidy;
	}

	@Override
	public String getPKFieldName() {
		return "pk_expert_term";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "mid_expert_term";
	}
	
}

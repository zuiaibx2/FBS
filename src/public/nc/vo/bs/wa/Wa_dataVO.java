package nc.vo.bs.wa;

import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFDouble;


/**
 * @ClassName: Wa_dataVO
 * @Description:  薪酬管理-发放总额
 * @项目名称: fbsjt
 * @文件名称: Wa_dataVO.java
 * @Author: 王凯强
 * @Date: 2016年7月29日下午1:48:06
 */
public class Wa_dataVO extends SuperVO{

	private static final long serialVersionUID = -5295426244071381835L;
	private java.lang.String bankid;
	private java.lang.String classid;
	private java.lang.String cnestperiod;
	private java.lang.String cnestyear;
	private java.lang.String cperiod;
	private java.lang.String cyear;
	private java.lang.String deptid;
//	private java.lang.Integer dr;
	private UFDouble f_1;
//	private UFDouble f_10;
//	private UFDouble f_100;
//	private java.lang.String f_101;
//	private java.lang.String f_102;
//	private java.lang.String f_103;
//	private java.lang.String f_104;
//	private java.lang.String f_105;
//	private java.lang.String f_106;
//	private java.lang.String f_107;
//	private java.lang.String f_108;
//	private java.lang.String f_109;
//	private UFDouble f_11;
//	private java.lang.String f_110;
//	private java.lang.String f_111;
//	private java.lang.String f_112;
//	private java.lang.String f_113;
//	private java.lang.String f_114;
//	private java.lang.String f_115;
//	private java.lang.String f_116;
//	private java.lang.String f_117;
//	private java.lang.String f_118;
//	private java.lang.String f_119;
//	private UFDouble f_12;
//	private java.lang.String f_120;
//	private java.lang.String f_121;
//	private java.lang.String f_122;
//	private java.lang.String f_123;
//	private java.lang.String f_124;
//	private java.lang.String f_125;
//	private java.lang.String f_126;
//	private java.lang.String f_127;
//	private java.lang.String f_128;
//	private java.lang.String f_129;
//	private UFDouble f_13;
//	private java.lang.String f_130;
//	private UFDouble f_14;
//	private UFDouble f_15;
//	private UFDouble f_16;
//	private UFDouble f_17;
//	private UFDouble f_18;
//	private UFDouble f_19;
	private UFDouble f_2;
//	private UFDouble f_20;
//	private java.lang.String f_21;
//	private UFDouble f_22;
//	private UFDouble f_23;
//	private UFDouble f_24;
//	private UFDouble f_25;
//	private UFDouble f_26;
//	private UFDouble f_27;
//	private UFDouble f_28;
//	private UFDouble f_29;
	private UFDouble f_3;
//	private UFDouble f_30;
//	private UFDouble f_31;
//	private UFDouble f_32;
//	private UFDouble f_33;
//	private UFDouble f_34;
//	private UFDouble f_35;
//	private UFDouble f_36;
//	private UFDouble f_37;
//	private UFDouble f_38;
//	private UFDouble f_39;
	private UFDouble f_4;
//	private UFDouble f_40;
//	private UFDouble f_41;
//	private UFDouble f_42;
//	private UFDouble f_43;
//	private UFDouble f_44;
//	private UFDouble f_45;
//	private UFDouble f_46;
//	private UFDouble f_47;
//	private UFDouble f_48;
//	private UFDouble f_49;
//	private UFDouble f_5;
//	private UFDouble f_50;
//	private UFDouble f_51;
//	private UFDouble f_52;
//	private UFDouble f_53;
//	private UFDouble f_54;
//	private UFDouble f_55;
//	private UFDouble f_56;
//	private UFDouble f_57;
//	private UFDouble f_58;
//	private UFDouble f_59;
//	private UFDouble f_6;
//	private UFDouble f_60;
//	private UFDouble f_61;
//	private UFDouble f_62;
//	private UFDouble f_63;
//	private UFDouble f_64;
//	private UFDouble f_65;
//	private UFDouble f_66;
//	private UFDouble f_67;
//	private UFDouble f_68;
//	private UFDouble f_69;
//	private UFDouble f_7;
//	private UFDouble f_70;
//	private UFDouble f_71;
//	private UFDouble f_72;
//	private UFDouble f_73;
//	private UFDouble f_74;
//	private UFDouble f_75;
//	private UFDouble f_76;
//	private UFDouble f_77;
//	private UFDouble f_78;
//	private UFDouble f_79;
//	private UFDouble f_8;
//	private UFDouble f_80;
//	private UFDouble f_81;
//	private UFDouble f_82;
//	private UFDouble f_83;
//	private UFDouble f_84;
//	private UFDouble f_85;
//	private UFDouble f_86;
//	private UFDouble f_87;
//	private UFDouble f_88;
//	private UFDouble f_89;
//	private UFDouble f_9;
//	private UFDouble f_90;
	private UFDouble icheckflag;
	private UFDouble ipartflag;
	private UFDouble irecaculateflag;
	private UFDouble irecheckflag;
	private UFDouble istopflag;
	private UFDouble itaxflag;
	private java.lang.String nestdeptid;
	private java.lang.String nestpk_om_job;
	private java.lang.String nestpsnclid;
	private java.lang.String pk_om_job;
	private java.lang.String pk_psnbasdoc;
	private java.lang.String pk_psndoc_sub;
	/**
	 * @field: pk_wa_data
	 * @Discription: 主键
	 */
	private java.lang.String pk_wa_data;
	private java.lang.String psnclid;
	private java.lang.String psnid;
	private UFDouble redtotal;
	private java.lang.String taxtableid;
	private java.lang.String ts;
	private java.lang.String vacccode;
	private UFDouble d_11;
	private UFDouble d_12;
	private UFDouble d_13;
	private UFDouble d_14;
	private UFDouble d_21;
	private UFDouble d_22;
	private UFDouble d_23;
	private UFDouble d_24;
	private UFDouble d_25;
	private UFDouble d_26;
	
	public java.lang.String getBankid() {
		return bankid;
	}

	public void setBankid(java.lang.String bankid) {
		this.bankid = bankid;
	}

	public java.lang.String getClassid() {
		return classid;
	}

	public void setClassid(java.lang.String classid) {
		this.classid = classid;
	}

	public java.lang.String getCnestperiod() {
		return cnestperiod;
	}

	public void setCnestperiod(java.lang.String cnestperiod) {
		this.cnestperiod = cnestperiod;
	}

	public java.lang.String getCnestyear() {
		return cnestyear;
	}

	public void setCnestyear(java.lang.String cnestyear) {
		this.cnestyear = cnestyear;
	}

	public java.lang.String getCperiod() {
		return cperiod;
	}

	public void setCperiod(java.lang.String cperiod) {
		this.cperiod = cperiod;
	}

	public java.lang.String getCyear() {
		return cyear;
	}

	public void setCyear(java.lang.String cyear) {
		this.cyear = cyear;
	}

	public java.lang.String getDeptid() {
		return deptid;
	}

	public void setDeptid(java.lang.String deptid) {
		this.deptid = deptid;
	}

//	public java.lang.Integer getDr() {
//		return dr;
//	}
//
//	public void setDr(java.lang.Integer dr) {
//		this.dr = dr;
//	}

	public UFDouble getF_1() {
		return f_1;
	}

	public void setF_1(UFDouble f_1) {
		this.f_1 = f_1;
	}

//	public UFDouble getF_10() {
//		return f_10;
//	}
//
//	public void setF_10(UFDouble f_10) {
//		this.f_10 = f_10;
//	}
//
//	public UFDouble getF_100() {
//		return f_100;
//	}
//
//	public void setF_100(UFDouble f_100) {
//		this.f_100 = f_100;
//	}
//
//	public java.lang.String getF_101() {
//		return f_101;
//	}
//
//	public void setF_101(java.lang.String f_101) {
//		this.f_101 = f_101;
//	}
//
//	public java.lang.String getF_102() {
//		return f_102;
//	}
//
//	public void setF_102(java.lang.String f_102) {
//		this.f_102 = f_102;
//	}
//
//	public java.lang.String getF_103() {
//		return f_103;
//	}
//
//	public void setF_103(java.lang.String f_103) {
//		this.f_103 = f_103;
//	}
//
//	public java.lang.String getF_104() {
//		return f_104;
//	}
//
//	public void setF_104(java.lang.String f_104) {
//		this.f_104 = f_104;
//	}
//
//	public java.lang.String getF_105() {
//		return f_105;
//	}
//
//	public void setF_105(java.lang.String f_105) {
//		this.f_105 = f_105;
//	}
//
//	public java.lang.String getF_106() {
//		return f_106;
//	}
//
//	public void setF_106(java.lang.String f_106) {
//		this.f_106 = f_106;
//	}
//
//	public java.lang.String getF_107() {
//		return f_107;
//	}
//
//	public void setF_107(java.lang.String f_107) {
//		this.f_107 = f_107;
//	}
//
//	public java.lang.String getF_108() {
//		return f_108;
//	}
//
//	public void setF_108(java.lang.String f_108) {
//		this.f_108 = f_108;
//	}
//
//	public java.lang.String getF_109() {
//		return f_109;
//	}
//
//	public void setF_109(java.lang.String f_109) {
//		this.f_109 = f_109;
//	}
//
//	public UFDouble getF_11() {
//		return f_11;
//	}
//
//	public void setF_11(UFDouble f_11) {
//		this.f_11 = f_11;
//	}
//
//	public java.lang.String getF_110() {
//		return f_110;
//	}
//
//	public void setF_110(java.lang.String f_110) {
//		this.f_110 = f_110;
//	}
//
//	public java.lang.String getF_111() {
//		return f_111;
//	}
//
//	public void setF_111(java.lang.String f_111) {
//		this.f_111 = f_111;
//	}
//
//	public java.lang.String getF_112() {
//		return f_112;
//	}
//
//	public void setF_112(java.lang.String f_112) {
//		this.f_112 = f_112;
//	}
//
//	public java.lang.String getF_113() {
//		return f_113;
//	}
//
//	public void setF_113(java.lang.String f_113) {
//		this.f_113 = f_113;
//	}
//
//	public java.lang.String getF_114() {
//		return f_114;
//	}
//
//	public void setF_114(java.lang.String f_114) {
//		this.f_114 = f_114;
//	}
//
//	public java.lang.String getF_115() {
//		return f_115;
//	}
//
//	public void setF_115(java.lang.String f_115) {
//		this.f_115 = f_115;
//	}
//
//	public java.lang.String getF_116() {
//		return f_116;
//	}
//
//	public void setF_116(java.lang.String f_116) {
//		this.f_116 = f_116;
//	}
//
//	public java.lang.String getF_117() {
//		return f_117;
//	}
//
//	public void setF_117(java.lang.String f_117) {
//		this.f_117 = f_117;
//	}
//
//	public java.lang.String getF_118() {
//		return f_118;
//	}
//
//	public void setF_118(java.lang.String f_118) {
//		this.f_118 = f_118;
//	}
//
//	public java.lang.String getF_119() {
//		return f_119;
//	}
//
//	public void setF_119(java.lang.String f_119) {
//		this.f_119 = f_119;
//	}
//
//	public UFDouble getF_12() {
//		return f_12;
//	}
//
//	public void setF_12(UFDouble f_12) {
//		this.f_12 = f_12;
//	}
//
//	public java.lang.String getF_120() {
//		return f_120;
//	}
//
//	public void setF_120(java.lang.String f_120) {
//		this.f_120 = f_120;
//	}
//
//	public java.lang.String getF_121() {
//		return f_121;
//	}
//
//	public void setF_121(java.lang.String f_121) {
//		this.f_121 = f_121;
//	}
//
//	public java.lang.String getF_122() {
//		return f_122;
//	}
//
//	public void setF_122(java.lang.String f_122) {
//		this.f_122 = f_122;
//	}
//
//	public java.lang.String getF_123() {
//		return f_123;
//	}
//
//	public void setF_123(java.lang.String f_123) {
//		this.f_123 = f_123;
//	}
//
//	public java.lang.String getF_124() {
//		return f_124;
//	}
//
//	public void setF_124(java.lang.String f_124) {
//		this.f_124 = f_124;
//	}
//
//	public java.lang.String getF_125() {
//		return f_125;
//	}
//
//	public void setF_125(java.lang.String f_125) {
//		this.f_125 = f_125;
//	}
//
//	public java.lang.String getF_126() {
//		return f_126;
//	}
//
//	public void setF_126(java.lang.String f_126) {
//		this.f_126 = f_126;
//	}
//
//	public java.lang.String getF_127() {
//		return f_127;
//	}
//
//	public void setF_127(java.lang.String f_127) {
//		this.f_127 = f_127;
//	}
//
//	public java.lang.String getF_128() {
//		return f_128;
//	}
//
//	public void setF_128(java.lang.String f_128) {
//		this.f_128 = f_128;
//	}
//
//	public java.lang.String getF_129() {
//		return f_129;
//	}
//
//	public void setF_129(java.lang.String f_129) {
//		this.f_129 = f_129;
//	}
//
//	public UFDouble getF_13() {
//		return f_13;
//	}
//
//	public void setF_13(UFDouble f_13) {
//		this.f_13 = f_13;
//	}
//
//	public java.lang.String getF_130() {
//		return f_130;
//	}
//
//	public void setF_130(java.lang.String f_130) {
//		this.f_130 = f_130;
//	}
//
//	public UFDouble getF_14() {
//		return f_14;
//	}
//
//	public void setF_14(UFDouble f_14) {
//		this.f_14 = f_14;
//	}
//
//	public UFDouble getF_15() {
//		return f_15;
//	}
//
//	public void setF_15(UFDouble f_15) {
//		this.f_15 = f_15;
//	}
//
//	public UFDouble getF_16() {
//		return f_16;
//	}
//
//	public void setF_16(UFDouble f_16) {
//		this.f_16 = f_16;
//	}
//
//	public UFDouble getF_17() {
//		return f_17;
//	}
//
//	public void setF_17(UFDouble f_17) {
//		this.f_17 = f_17;
//	}
//
//	public UFDouble getF_18() {
//		return f_18;
//	}
//
//	public void setF_18(UFDouble f_18) {
//		this.f_18 = f_18;
//	}
//
//	public UFDouble getF_19() {
//		return f_19;
//	}
//
//	public void setF_19(UFDouble f_19) {
//		this.f_19 = f_19;
//	}

	public UFDouble getF_2() {
		return f_2;
	}

	public void setF_2(UFDouble f_2) {
		this.f_2 = f_2;
	}

//	public UFDouble getF_20() {
//		return f_20;
//	}
//
//	public void setF_20(UFDouble f_20) {
//		this.f_20 = f_20;
//	}
//
//	public java.lang.String getF_21() {
//		return f_21;
//	}
//
//	public void setF_21(java.lang.String f_21) {
//		this.f_21 = f_21;
//	}
//
//	public UFDouble getF_22() {
//		return f_22;
//	}
//
//	public void setF_22(UFDouble f_22) {
//		this.f_22 = f_22;
//	}
//
//	public UFDouble getF_23() {
//		return f_23;
//	}
//
//	public void setF_23(UFDouble f_23) {
//		this.f_23 = f_23;
//	}
//
//	public UFDouble getF_24() {
//		return f_24;
//	}
//
//	public void setF_24(UFDouble f_24) {
//		this.f_24 = f_24;
//	}
//
//	public UFDouble getF_25() {
//		return f_25;
//	}
//
//	public void setF_25(UFDouble f_25) {
//		this.f_25 = f_25;
//	}
//
//	public UFDouble getF_26() {
//		return f_26;
//	}
//
//	public void setF_26(UFDouble f_26) {
//		this.f_26 = f_26;
//	}
//
//	public UFDouble getF_27() {
//		return f_27;
//	}
//
//	public void setF_27(UFDouble f_27) {
//		this.f_27 = f_27;
//	}
//
//	public UFDouble getF_28() {
//		return f_28;
//	}
//
//	public void setF_28(UFDouble f_28) {
//		this.f_28 = f_28;
//	}
//
//	public UFDouble getF_29() {
//		return f_29;
//	}
//
//	public void setF_29(UFDouble f_29) {
//		this.f_29 = f_29;
//	}

	public UFDouble getF_3() {
		return f_3;
	}

	public void setF_3(UFDouble f_3) {
		this.f_3 = f_3;
	}

//	public UFDouble getF_30() {
//		return f_30;
//	}
//
//	public void setF_30(UFDouble f_30) {
//		this.f_30 = f_30;
//	}
//
//	public UFDouble getF_31() {
//		return f_31;
//	}
//
//	public void setF_31(UFDouble f_31) {
//		this.f_31 = f_31;
//	}
//
//	public UFDouble getF_32() {
//		return f_32;
//	}
//
//	public void setF_32(UFDouble f_32) {
//		this.f_32 = f_32;
//	}
//
//	public UFDouble getF_33() {
//		return f_33;
//	}
//
//	public void setF_33(UFDouble f_33) {
//		this.f_33 = f_33;
//	}
//
//	public UFDouble getF_34() {
//		return f_34;
//	}
//
//	public void setF_34(UFDouble f_34) {
//		this.f_34 = f_34;
//	}
//
//	public UFDouble getF_35() {
//		return f_35;
//	}
//
//	public void setF_35(UFDouble f_35) {
//		this.f_35 = f_35;
//	}
//
//	public UFDouble getF_36() {
//		return f_36;
//	}
//
//	public void setF_36(UFDouble f_36) {
//		this.f_36 = f_36;
//	}
//
//	public UFDouble getF_37() {
//		return f_37;
//	}
//
//	public void setF_37(UFDouble f_37) {
//		this.f_37 = f_37;
//	}
//
//	public UFDouble getF_38() {
//		return f_38;
//	}
//
//	public void setF_38(UFDouble f_38) {
//		this.f_38 = f_38;
//	}
//
//	public UFDouble getF_39() {
//		return f_39;
//	}
//
//	public void setF_39(UFDouble f_39) {
//		this.f_39 = f_39;
//	}

	public UFDouble getF_4() {
		return f_4;
	}

	public void setF_4(UFDouble f_4) {
		this.f_4 = f_4;
	}

//	public UFDouble getF_40() {
//		return f_40;
//	}
//
//	public void setF_40(UFDouble f_40) {
//		this.f_40 = f_40;
//	}
//
//	public UFDouble getF_41() {
//		return f_41;
//	}
//
//	public void setF_41(UFDouble f_41) {
//		this.f_41 = f_41;
//	}
//
//	public UFDouble getF_42() {
//		return f_42;
//	}
//
//	public void setF_42(UFDouble f_42) {
//		this.f_42 = f_42;
//	}
//
//	public UFDouble getF_43() {
//		return f_43;
//	}
//
//	public void setF_43(UFDouble f_43) {
//		this.f_43 = f_43;
//	}
//
//	public UFDouble getF_44() {
//		return f_44;
//	}
//
//	public void setF_44(UFDouble f_44) {
//		this.f_44 = f_44;
//	}
//
//	public UFDouble getF_45() {
//		return f_45;
//	}
//
//	public void setF_45(UFDouble f_45) {
//		this.f_45 = f_45;
//	}
//
//	public UFDouble getF_46() {
//		return f_46;
//	}
//
//	public void setF_46(UFDouble f_46) {
//		this.f_46 = f_46;
//	}
//
//	public UFDouble getF_47() {
//		return f_47;
//	}
//
//	public void setF_47(UFDouble f_47) {
//		this.f_47 = f_47;
//	}
//
//	public UFDouble getF_48() {
//		return f_48;
//	}
//
//	public void setF_48(UFDouble f_48) {
//		this.f_48 = f_48;
//	}
//
//	public UFDouble getF_49() {
//		return f_49;
//	}
//
//	public void setF_49(UFDouble f_49) {
//		this.f_49 = f_49;
//	}
//
//	public UFDouble getF_5() {
//		return f_5;
//	}
//
//	public void setF_5(UFDouble f_5) {
//		this.f_5 = f_5;
//	}
//
//	public UFDouble getF_50() {
//		return f_50;
//	}
//
//	public void setF_50(UFDouble f_50) {
//		this.f_50 = f_50;
//	}
//
//	public UFDouble getF_51() {
//		return f_51;
//	}
//
//	public void setF_51(UFDouble f_51) {
//		this.f_51 = f_51;
//	}
//
//	public UFDouble getF_52() {
//		return f_52;
//	}
//
//	public void setF_52(UFDouble f_52) {
//		this.f_52 = f_52;
//	}
//
//	public UFDouble getF_53() {
//		return f_53;
//	}
//
//	public void setF_53(UFDouble f_53) {
//		this.f_53 = f_53;
//	}
//
//	public UFDouble getF_54() {
//		return f_54;
//	}
//
//	public void setF_54(UFDouble f_54) {
//		this.f_54 = f_54;
//	}
//
//	public UFDouble getF_55() {
//		return f_55;
//	}
//
//	public void setF_55(UFDouble f_55) {
//		this.f_55 = f_55;
//	}
//
//	public UFDouble getF_56() {
//		return f_56;
//	}
//
//	public void setF_56(UFDouble f_56) {
//		this.f_56 = f_56;
//	}
//
//	public UFDouble getF_57() {
//		return f_57;
//	}
//
//	public void setF_57(UFDouble f_57) {
//		this.f_57 = f_57;
//	}
//
//	public UFDouble getF_58() {
//		return f_58;
//	}
//
//	public void setF_58(UFDouble f_58) {
//		this.f_58 = f_58;
//	}
//
//	public UFDouble getF_59() {
//		return f_59;
//	}
//
//	public void setF_59(UFDouble f_59) {
//		this.f_59 = f_59;
//	}
//
//	public UFDouble getF_6() {
//		return f_6;
//	}
//
//	public void setF_6(UFDouble f_6) {
//		this.f_6 = f_6;
//	}
//
//	public UFDouble getF_60() {
//		return f_60;
//	}
//
//	public void setF_60(UFDouble f_60) {
//		this.f_60 = f_60;
//	}
//
//	public UFDouble getF_61() {
//		return f_61;
//	}
//
//	public void setF_61(UFDouble f_61) {
//		this.f_61 = f_61;
//	}
//
//	public UFDouble getF_62() {
//		return f_62;
//	}
//
//	public void setF_62(UFDouble f_62) {
//		this.f_62 = f_62;
//	}
//
//	public UFDouble getF_63() {
//		return f_63;
//	}
//
//	public void setF_63(UFDouble f_63) {
//		this.f_63 = f_63;
//	}
//
//	public UFDouble getF_64() {
//		return f_64;
//	}
//
//	public void setF_64(UFDouble f_64) {
//		this.f_64 = f_64;
//	}
//
//	public UFDouble getF_65() {
//		return f_65;
//	}
//
//	public void setF_65(UFDouble f_65) {
//		this.f_65 = f_65;
//	}
//
//	public UFDouble getF_66() {
//		return f_66;
//	}
//
//	public void setF_66(UFDouble f_66) {
//		this.f_66 = f_66;
//	}
//
//	public UFDouble getF_67() {
//		return f_67;
//	}
//
//	public void setF_67(UFDouble f_67) {
//		this.f_67 = f_67;
//	}
//
//	public UFDouble getF_68() {
//		return f_68;
//	}
//
//	public void setF_68(UFDouble f_68) {
//		this.f_68 = f_68;
//	}
//
//	public UFDouble getF_69() {
//		return f_69;
//	}
//
//	public void setF_69(UFDouble f_69) {
//		this.f_69 = f_69;
//	}
//
//	public UFDouble getF_7() {
//		return f_7;
//	}
//
//	public void setF_7(UFDouble f_7) {
//		this.f_7 = f_7;
//	}
//
//	public UFDouble getF_70() {
//		return f_70;
//	}
//
//	public void setF_70(UFDouble f_70) {
//		this.f_70 = f_70;
//	}
//
//	public UFDouble getF_71() {
//		return f_71;
//	}
//
//	public void setF_71(UFDouble f_71) {
//		this.f_71 = f_71;
//	}
//
//	public UFDouble getF_72() {
//		return f_72;
//	}
//
//	public void setF_72(UFDouble f_72) {
//		this.f_72 = f_72;
//	}
//
//	public UFDouble getF_73() {
//		return f_73;
//	}
//
//	public void setF_73(UFDouble f_73) {
//		this.f_73 = f_73;
//	}
//
//	public UFDouble getF_74() {
//		return f_74;
//	}
//
//	public void setF_74(UFDouble f_74) {
//		this.f_74 = f_74;
//	}
//
//	public UFDouble getF_75() {
//		return f_75;
//	}
//
//	public void setF_75(UFDouble f_75) {
//		this.f_75 = f_75;
//	}
//
//	public UFDouble getF_76() {
//		return f_76;
//	}
//
//	public void setF_76(UFDouble f_76) {
//		this.f_76 = f_76;
//	}
//
//	public UFDouble getF_77() {
//		return f_77;
//	}
//
//	public void setF_77(UFDouble f_77) {
//		this.f_77 = f_77;
//	}
//
//	public UFDouble getF_78() {
//		return f_78;
//	}
//
//	public void setF_78(UFDouble f_78) {
//		this.f_78 = f_78;
//	}
//
//	public UFDouble getF_79() {
//		return f_79;
//	}
//
//	public void setF_79(UFDouble f_79) {
//		this.f_79 = f_79;
//	}
//
//	public UFDouble getF_8() {
//		return f_8;
//	}
//
//	public void setF_8(UFDouble f_8) {
//		this.f_8 = f_8;
//	}
//
//	public UFDouble getF_80() {
//		return f_80;
//	}
//
//	public void setF_80(UFDouble f_80) {
//		this.f_80 = f_80;
//	}
//
//	public UFDouble getF_81() {
//		return f_81;
//	}
//
//	public void setF_81(UFDouble f_81) {
//		this.f_81 = f_81;
//	}
//
//	public UFDouble getF_82() {
//		return f_82;
//	}
//
//	public void setF_82(UFDouble f_82) {
//		this.f_82 = f_82;
//	}
//
//	public UFDouble getF_83() {
//		return f_83;
//	}
//
//	public void setF_83(UFDouble f_83) {
//		this.f_83 = f_83;
//	}
//
//	public UFDouble getF_84() {
//		return f_84;
//	}
//
//	public void setF_84(UFDouble f_84) {
//		this.f_84 = f_84;
//	}
//
//	public UFDouble getF_85() {
//		return f_85;
//	}
//
//	public void setF_85(UFDouble f_85) {
//		this.f_85 = f_85;
//	}

//	public UFDouble getF_86() {
//		return f_86;
//	}
//
//	public void setF_86(UFDouble f_86) {
//		this.f_86 = f_86;
//	}
//
//	public UFDouble getF_87() {
//		return f_87;
//	}
//
//	public void setF_87(UFDouble f_87) {
//		this.f_87 = f_87;
//	}
//
//	public UFDouble getF_88() {
//		return f_88;
//	}
//
//	public void setF_88(UFDouble f_88) {
//		this.f_88 = f_88;
//	}
//
//	public UFDouble getF_89() {
//		return f_89;
//	}
//
//	public void setF_89(UFDouble f_89) {
//		this.f_89 = f_89;
//	}
//
//	public UFDouble getF_9() {
//		return f_9;
//	}
//
//	public void setF_9(UFDouble f_9) {
//		this.f_9 = f_9;
//	}
//
//	public UFDouble getF_90() {
//		return f_90;
//	}
//
//	public void setF_90(UFDouble f_90) {
//		this.f_90 = f_90;
//	}

	public UFDouble getIcheckflag() {
		return icheckflag;
	}

	public void setIcheckflag(UFDouble icheckflag) {
		this.icheckflag = icheckflag;
	}

	public UFDouble getIpartflag() {
		return ipartflag;
	}

	public void setIpartflag(UFDouble ipartflag) {
		this.ipartflag = ipartflag;
	}

	public UFDouble getIrecaculateflag() {
		return irecaculateflag;
	}

	public void setIrecaculateflag(UFDouble irecaculateflag) {
		this.irecaculateflag = irecaculateflag;
	}

	public UFDouble getIrecheckflag() {
		return irecheckflag;
	}

	public void setIrecheckflag(UFDouble irecheckflag) {
		this.irecheckflag = irecheckflag;
	}

	public UFDouble getIstopflag() {
		return istopflag;
	}

	public void setIstopflag(UFDouble istopflag) {
		this.istopflag = istopflag;
	}

	public UFDouble getItaxflag() {
		return itaxflag;
	}

	public void setItaxflag(UFDouble itaxflag) {
		this.itaxflag = itaxflag;
	}

	public java.lang.String getNestdeptid() {
		return nestdeptid;
	}

	public void setNestdeptid(java.lang.String nestdeptid) {
		this.nestdeptid = nestdeptid;
	}

	public java.lang.String getNestpk_om_job() {
		return nestpk_om_job;
	}

	public void setNestpk_om_job(java.lang.String nestpk_om_job) {
		this.nestpk_om_job = nestpk_om_job;
	}

	public java.lang.String getNestpsnclid() {
		return nestpsnclid;
	}

	public void setNestpsnclid(java.lang.String nestpsnclid) {
		this.nestpsnclid = nestpsnclid;
	}

	public java.lang.String getPk_om_job() {
		return pk_om_job;
	}

	public void setPk_om_job(java.lang.String pk_om_job) {
		this.pk_om_job = pk_om_job;
	}

	public java.lang.String getPk_psnbasdoc() {
		return pk_psnbasdoc;
	}

	public void setPk_psnbasdoc(java.lang.String pk_psnbasdoc) {
		this.pk_psnbasdoc = pk_psnbasdoc;
	}

	public java.lang.String getPk_psndoc_sub() {
		return pk_psndoc_sub;
	}

	public void setPk_psndoc_sub(java.lang.String pk_psndoc_sub) {
		this.pk_psndoc_sub = pk_psndoc_sub;
	}

	public java.lang.String getPk_wa_data() {
		return pk_wa_data;
	}

	public void setPk_wa_data(java.lang.String pk_wa_data) {
		this.pk_wa_data = pk_wa_data;
	}

	public java.lang.String getPsnclid() {
		return psnclid;
	}

	public void setPsnclid(java.lang.String psnclid) {
		this.psnclid = psnclid;
	}

	public java.lang.String getPsnid() {
		return psnid;
	}

	public void setPsnid(java.lang.String psnid) {
		this.psnid = psnid;
	}

	public UFDouble getRedtotal() {
		return redtotal;
	}

	public void setRedtotal(UFDouble redtotal) {
		this.redtotal = redtotal;
	}

	public java.lang.String getTaxtableid() {
		return taxtableid;
	}

	public void setTaxtableid(java.lang.String taxtableid) {
		this.taxtableid = taxtableid;
	}

	public java.lang.String getTs() {
		return ts;
	}

	public void setTs(java.lang.String ts) {
		this.ts = ts;
	}

	public java.lang.String getVacccode() {
		return vacccode;
	}

	public void setVacccode(java.lang.String vacccode) {
		this.vacccode = vacccode;
	}

	public UFDouble getD_11() {
		return d_11;
	}

	public void setD_11(UFDouble d_11) {
		this.d_11 = d_11;
	}

	public UFDouble getD_12() {
		return d_12;
	}

	public void setD_12(UFDouble d_12) {
		this.d_12 = d_12;
	}

	public UFDouble getD_13() {
		return d_13;
	}

	public void setD_13(UFDouble d_13) {
		this.d_13 = d_13;
	}

	public UFDouble getD_14() {
		return d_14;
	}

	public void setD_14(UFDouble d_14) {
		this.d_14 = d_14;
	}

	public UFDouble getD_21() {
		return d_21;
	}

	public void setD_21(UFDouble d_21) {
		this.d_21 = d_21;
	}

	public UFDouble getD_22() {
		return d_22;
	}

	public void setD_22(UFDouble d_22) {
		this.d_22 = d_22;
	}

	public UFDouble getD_23() {
		return d_23;
	}

	public void setD_23(UFDouble d_23) {
		this.d_23 = d_23;
	}

	public UFDouble getD_24() {
		return d_24;
	}

	public void setD_24(UFDouble d_24) {
		this.d_24 = d_24;
	}

	public UFDouble getD_25() {
		return d_25;
	}

	public void setD_25(UFDouble d_25) {
		this.d_25 = d_25;
	}

	public UFDouble getD_26() {
		return d_26;
	}

	public void setD_26(UFDouble d_26) {
		this.d_26 = d_26;
	}

	@Override
	public String getPKFieldName() {
		return "pk_wa_data";
	}

	@Override
	public String getParentPKFieldName() {
		return null;
	}

	@Override
	public String getTableName() {
		return "wa_data";
	}

}

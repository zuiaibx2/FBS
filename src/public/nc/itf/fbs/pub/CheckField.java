package nc.itf.fbs.pub; 

/**
 * @ClassName: CheckField
 * <b> 数据校验需要校验的字段 </b>
 * <p>
 *     28张表中需要进行非空校验、主键转换、数据对照的字段
 * </p>
 * 创建日期: 2016年9月29日 下午1:07:16
 * @Author 王凯强
 * @Version 
 */
public interface CheckField {
	//部门档案
	public static String TABLENAME_DEPT = "部门档案";
	public static String[] NOTNULL_DEPT ={"pk_corp","deptcode","deptname","createdate"};
	public static String[] NOTNULL_NAME_DEPT ={"所属公司","部门编码","部门名称","成立时间"};
	public static String[] PK_DEPT ={"pk_deptdoc","pk_fathedept","pk_psndoc","pk_psndoc2"};
	public static String[] PK_NAME_DEPT ={"部门主键","上级部门","负责人1","负责人2"};
	public static String TIP_DEPT ="deptcode";
	public static String TIP_NAME_DEPT ="部门编码";
	//岗位基本信息
	public static String TABLENAME_JOB = "岗位基本信息";
	public static String[] NOTNULL_JOB ={"pk_corp","jobcode","jobname","builddate","pk_deptdoc","jobseries","groupdef1"};
	public static String[] NOTNULL_NAME_JOB ={"所属公司","岗位编码","岗位名称","成立日期","所属部门","岗位序列","工作领域"};
	public static String[] DEFDOC_JOB ={"jobseries","groupdef1","groupdef2","groupdef4"};
	public static String[] DEFDOC_NAME_JOB ={"岗位序列","工作领域","涉密等级","对应专业技术职务序列"};
	public static String[] PK_JOB ={"pk_om_job","pk_deptdoc","suporior","pk_om_duty"};
	public static String[] PK_NAME_JOB ={"岗位主键","所属部门","直接上级名称","所属职务"};
	public static String TIP_JOB ="jobcode";
	public static String TIP_NAME_JOB ="岗位编码";
	//职务基本信息
	public static String TABLENAME_DUTY = "职务基本信息";
	public static String[] NOTNULL_DUTY ={"pk_corp","dutycode","dutyname","dutyrank","series"};
	public static String[] NOTNULL_NAME_DUTY ={"所属公司","职务编码","职务名称","职务属性","职务簇"};
	public static String[] DEFDOC_DUTY ={"dutyrank"};
	public static String[] DEFDOC_NAME_DUTY ={"职务属性"};
	public static String[] PK_DUTY ={"pk_om_duty"};
	public static String[] PK_NAME_DUTY ={"职务主键"};
	public static String TIP_DUTY ="dutycode";
	public static String TIP_NAME_DUTY ="职务编码";
	//单位编制信息
	public static String TABLENAME_CORPLB = "单位编制信息";
	public static String[] NOTNULL_CORPLB ={"pk_corp","makecorp","cyear","workout","pk_om_workout_type"};
	public static String[] NOTNULL_NAME_CORPLB ={"所属公司","编制单位","年度","公司编制","分类方式"};
	public static String[] PK_CORPLB ={"pk_om_corp_workout"};
	public static String[] PK_NAME_CORPLB ={"单位编制信息主键"};
	public static String TIP_CORPLB ="makecorp";
	public static String TIP_NAME_CORPLB ="单位编码";
	//单位编制子表
	public static String TABLENAME_CORPLBB = "单位编制子表";
	public static String[] NOTNULL_CORPLBB ={"pk_om_corp_workout","pk_ref_name","workout"};
	public static String[] NOTNULL_NAME_CORPLBB ={"单位编制主表主键","分类名称","计划编制"};
	public static String[] PK_CORPLBB ={"pk_om_corp_workout_b","pk_om_corp_workout"};
	public static String[] PK_NAME_CORPLBB ={"单位编制子表","单位编制信息主键"};
	public static String TIP_CORPLBB ="makecorp";
	public static String TIP_NAME_CORPLBB ="单位编码";
	//部门编制信息
	public static String TABLENAME_DEPTLB = "部门编制信息";
	public static String[] NOTNULL_DEPTLB ={"pk_corp","pk_deptdoc","cyear","workout","actualnum","version"};
	public static String[] NOTNULL_NAME_DEPTLB ={"所属公司","部门","年度","部门编制","占编人数","编制版本"};
	public static String[] PK_DEPTLB ={"pk_om_dept_workout","pk_deptdoc"};
	public static String[] PK_NAME_DEPTLB ={"部门编制信息主键","部门"};
	public static String TIP_DEPTLB ="deptcode";
	public static String TIP_NAME_DEPTLB ="部门编码";
	//岗位编制信息
	public static String TABLENAME_JOBLB = "岗位编制信息";
	public static String[] NOTNULL_JOBLB ={"pk_corp","pk_om_job","cyear","workout","actualnum","version"};
	public static String[] NOTNULL_NAME_JOBLB ={"所属公司","岗位","年度","岗位编制","占编人数","岗位编制版本"};
	public static String[] PK_JOBLB ={"pk_om_job_workout","pk_om_job"};
	public static String[] PK_NAME_JOBLB ={"岗位编制信息主键","岗位"};
	public static String TIP_JOBLB ="jobcode";
	public static String TIP_NAME_JOBLB ="岗位编码";
	//人员基本信息
	public static String TABLENAME_PSNBAS = "人员基本信息";
	public static String[] NOTNULL_PSNBAS ={"pk_corp","psnname","nationality","country","sex","id","birthdate","joinworkdate","joinsysdate","polity","nativeplace","basgroupdef12"};
	public static String[] NOTNULL_NAME_PSNBAS ={"所属公司","姓名","民族","国家/地区","性别","身份证号","出生日期","参加工作日期","进入航空系统工作时间","政治面貌","籍贯","出生地"};
	public static String[] NOTNULL_OTHER_PSNBAS = {"pk_corp","psnname","id"};
	public static String[] NOTNULL_OTHER_NAME_PSNBAS ={"所属公司","姓名","身份证号"};
	public static String[] DEFDOC_PSNBAS ={"penelauth","marital","characterrpr","country","nativeplace","basgroupdef12"};//"bloodtype"
	public static String[] DEFDOC_NAME_PSNBAS ={"个人身份","婚姻状况","户口类型","国家/地区","籍贯","出生地"};//"血型"
	public static String[] PK_PSNBAS ={"pk_psnbasdoc"};
	public static String[] PK_NAME_PSNBAS ={"个人信息主键"};
	public static String TIP_PSNBAS ="psnname";
	public static String TIP_NAME_PSNBAS ="姓名";
	//员工工作信息
	public static String TABLENAME_PSN = "员工工作信息";
	public static String[] NOTNULL_PSN ={"pk_corp","pk_psncl","psncode","psnname","pk_deptdoc","pk_om_job","jobseries","pk_dutyrank","dutyname","groupdef2","onpostdate","groupdef14","groupdef10","insource"};
	public static String[] NOTNULL_NAME_PSN ={"所属公司","人员类别","员工编码","姓名","所在部门","岗位名称","岗位序列","职务属性","职务名称","进入本单位工作时间","任现职时间","任同级职务时间","编制类型","员工来源"};
	public static String[] NOTNULL_OTHER_PSN ={"pk_corp","pk_psncl","psncode","psnname","pk_deptdoc","pk_om_job","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_PSN ={"所属公司","人员类别","员工编码","姓名","所在部门","岗位名称","进入本单位工作时间"};
	public static String[] DEFDOC_PSN ={"pk_psncl","jobseries","groupdef1","pk_dutyrank","groupdef3","groupdef10","insource"};
	public static String[] DEFDOC_NAME_PSN ={"人员类别","岗位序列","工作领域","职务属性","人员密级","编制类型","员工来源"};
	public static String[] PK_PSN ={"pk_psnbasdoc","pk_psndoc","pk_deptdoc","pk_om_job","dutyname"};
	public static String[] PK_NAME_PSN ={"个人信息主键","工作信息主键","所在部门","岗位名称","职务名称"};
	public static String TIP_PSN ="psncode";
	public static String TIP_NAME_PSN ="员工编码";
	//员工任职信息
	public static String TABLENAME_HIDEPTCHG = "员工任职信息";
	public static String[] NOTNULL_HIDEPTCHG ={"pk_psndoc","begindate","pk_corp","poststat","pk_psncl","pk_deptdoc","pk_jobserial","pk_postdoc","pk_om_duty","pk_dutyrank","isreturn"};
	public static String[] NOTNULL_NAME_HIDEPTCHG ={"人员工作信息主键","任职起始日期","任职单位","是否在岗","人员类别","部门","岗位序列","岗位","职务","职务级别","是否返聘"};
	public static String[] NOTNULL_OTHER_HIDEPTCHG ={"pk_psndoc","begindate","pk_corp","pk_psncl","pk_deptdoc"};
	public static String[] NOTNULL_OTHER_NAME_HIDEPTCHG ={"人员工作信息主键","任职起始日期","任职单位","人员类别","部门"};
	public static String[] DEFDOC_HIDEPTCHG ={"preparetype","pk_psncl","pk_jobserial"};
	public static String[] DEFDOC_NAME_HIDEPTCHG ={"调配类型","人员类别","岗位序列"};
	public static String[] PK_HIDEPTCHG ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pk_deptdoc","pk_postdoc","pk_om_duty"};//数据库"series"无此字段
	public static String[] PK_NAME_HIDEPTCHG ={"主键","人员基础档案主键","人员工作信息主键","部门","岗位","职务"};//数据库"职务簇"无此字段
	public static String TIP_HIDEPTCHG ="psncode";
	public static String TIP_NAME_HIDEPTCHG ="员工编码";
	//政治面貌信息
	public static String TABLENAME_HIPARTYLOG = "政治面貌信息";
	public static String[] NOTNULL_HIPARTYLOG ={"pk_psndoc","cpartyname","dpartydate"};
	public static String[] NOTNULL_NAME_HIPARTYLOG ={"人员工作信息主键","政治面貌","入党团日期"};
	public static String[] NOTNULL_OTHER_HIPARTYLOG ={"pk_psndoc","cpartyname"};
	public static String[] NOTNULL_OTHER_NAME_HIPARTYLOG ={"人员工作信息主键","政治面貌"};
	public static String[] DEFDOC_HIPARTYLOG ={"cpartyname"};
	public static String[] DEFDOC_NAME_HIPARTYLOG ={"政治面貌"};
	public static String[] PK_HIPARTYLOG ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIPARTYLOG ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIPARTYLOG ="psncode";
	public static String TIP_NAME_HIPARTYLOG ="员工编码";
	//学历学位信息
	public static String TABLENAME_HIEDU = "学历学位信息";
	public static String[] NOTNULL_HIEDU ={"pk_psndoc","begindate","enddate","school","groupdef9","vstudymode","groupdef11","education","groupdef12","lasteducation","degree","groupdef2","groupdef3","groupdef4","groupdef5","groupdef6","groupdef7","groupdef8"};
	public static String[] NOTNULL_NAME_HIEDU ={"人员工作信息主键","入学日期","毕业日期","毕业院校","院校国别","学习方式","所学专业","所得学历","是否第一学历","是否最高学历","所得学位","是否第一学位","是否最高学位","是否全日制","是否重点","是否211院校","是否985院校","是否航空院校"};
	public static String[] NOTNULL_OTHER_HIEDU ={"pk_psndoc","education"};
	public static String[] NOTNULL_OTHER_NAME_HIEDU ={"人员工作信息主键","所得学历"};
	public static String[] DEFDOC_HIEDU ={"vstudymode","education","degree"};
	public static String[] DEFDOC_NAME_HIEDU ={"学习方式","所得学历","所得学位"};
	public static String[] PK_HIEDU ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIEDU ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIEDU ="psncode";
	public static String TIP_NAME_HIEDU ="员工编码";
	//家庭成员海外背景信息
	public static String TABLENAME_HIGRPDEF14= "家庭成员海外背景信息";
	public static String[] NOTNULL_HIGRPDEF14 ={"pk_psndoc","groupdef1","groupdef2","groupdef3","begindate","groupdef6","groupdef7","groupdef9"};
	public static String[] NOTNULL_NAME_HIGRPDEF14 ={"人员工作信息主键","家庭成员姓名","与本人关系","国家/地区","出国时间","所在国家地区","涉外原因","是否仍在国外"};
	public static String[] PK_HIGRPDEF14 ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIGRPDEF14 ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIGRPDEF14 ="psncode";
	public static String TIP_NAME_HIGRPDEF14 ="员工编码";
	//员工工作履历信息
	public static String TABLENAME_HIWORK = "员工工作履历信息";
	public static String[] NOTNULL_HIWORK ={"pk_psndoc","begindate","workcorp","workdept","workpost"};
	public static String[] NOTNULL_NAME_HIWORK ={"人员工作信息主键","履历起始日期","工作单位","所在部门","岗职务"};
	public static String[] NOTNULL_OTHER_HIWORK ={"pk_psndoc","begindate","workcorp"};
	public static String[] NOTNULL_OTHER_NAME_HIWORK ={"人员工作信息主键","履历起始日期","工作单位"};
	public static String[] PK_HIWORK ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIWORK ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIWORK ="psncode";
	public static String TIP_NAME_HIWORK ="员工编码";
	//员工涉外经历信息
	public static String TABLENAME_HIABROAD = "员工涉外经历信息";
	public static String[] NOTNULL_HIABROAD ={"pk_psndoc","pk_corp","groupdef2","cabroadarea","dabroaddate","groupdef3","groupdef4","groupdef5"};
	public static String[] NOTNULL_NAME_HIABROAD ={"人员工作信息主键","公司主键","出国性质","所去国家（地区）","出国(出境)日期","涉外原因","停留天数","是否仍在国外"};
	public static String[] NOTNULL_OTHER_HIABROAD ={"pk_psndoc","pk_corp","cabroadarea","dabroaddate"};
	public static String[] NOTNULL_OTHER_NAME_HIABROAD ={"人员工作信息主键","公司主键","所去国家（地区）","出国(出境)日期"};
	public static String[] PK_HIABROAD ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIABROAD ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIABROAD ="psncode";
	public static String TIP_NAME_HIABROAD ="员工编码";
	//员工奖励信息
	public static String TABLENAME_HIENC = "员工奖励信息";
	public static String[] NOTNULL_HIENC ={"pk_psndoc","groupdef2","groupdef3"};
	public static String[] NOTNULL_NAME_HIENC ={"人员工作信息主键","奖励名称","奖励年度"};
	public static String[] NOTNULL_OTHER_HIENC ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HIENC ={"人员工作信息主键","奖励名称"};
	public static String[] PK_HIENC ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIENC ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIENC ="psncode";
	public static String TIP_NAME_HIENC ="员工编码";
	//员工惩处信息
	public static String TABLENAME_HIPUN = "员工惩处信息";
	public static String[] NOTNULL_HIPUN ={"pk_psndoc","groupdef2","groupdef1","vpunishorg","vpunishmatter","recordnum","lastflag"};
	public static String[] NOTNULL_NAME_HIPUN ={"人员工作信息主键","惩处年度","惩处名称","惩处单位","惩处原因","记录序号","最近记录标志"};
	public static String[] NOTNULL_OTHER_HIPUN ={"pk_psndoc","groupdef2","groupdef1"};
	public static String[] NOTNULL_OTHER_NAME_HIPUN ={"人员工作信息主键","惩处年度","惩处名称"};
	public static String[] PK_HIPUN ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIPUN ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIPUN ="psncode";
	public static String TIP_NAME_HIPUN ="员工编码";
	//员工培训信息
	public static String TABLENAME_HITRAINING = "员工培训信息";//"培训机构", "groupdef1",  先不做非空校验
	public static String[] NOTNULL_HITRAINING ={"pk_psndoc","groupdef2","pk_corp","vtra_act","groupdef5","begindate","tra_time","groupdef3","groupdef7"};
	public static String[] NOTNULL_NAME_HITRAINING ={"人员工作信息主键","培训级别","人员所属单位","培训项目名称","培训年度","培训起始时间","学时数","培训对象分类","培训是否合格"};
	public static String[] NOTNULL_OTHER_HITRAINING ={"pk_psndoc","vtra_act","groupdef5","begindate","enddate"};
	public static String[] NOTNULL_OTHER_NAME_HITRAINING ={"人员工作信息主键","培训项目名称","培训年度","培训起始时间","培训终止时间"};
	public static String[] DEFDOC_HITRAINING ={"groupdef2","tra_mode","groupdef4","groupdef3"};
	public static String[] DEFDOC_NAME_HITRAINING ={"培训级别","培训方式","培训渠道类别","培训对象分类"};
	public static String[] PK_HITRAINING ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HITRAINING ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HITRAINING ="psncode";
	public static String TIP_NAME_HITRAINING ="员工编码";
	//专业技术职务
	public static String TABLENAME_HISPETECH = "专业技术职务";
	public static String[] NOTNULL_HISPETECH ={"pk_psndoc","ctechname","ctechduty","cincomeway","cprounit","lastflag"};
	public static String[] NOTNULL_NAME_HISPETECH ={"人员工作信息主键","专业技术职务","专业技术等级","取得资格途径","资格审批单位","是否现专业技术职务"};
	public static String[] NOTNULL_OTHER_HISPETECH ={"pk_psndoc","ctechduty"};
	public static String[] NOTNULL_OTHER_NAME_HISPETECH ={"人员工作信息主键","专业技术等级"};
	public static String[] DEFDOC_HISPETECH ={"ctechname","ctechduty"};
	public static String[] DEFDOC_NAME_HISPETECH ={"专业技术职务","专业技术等级"};
	public static String[] PK_HISPETECH ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HISPETECH ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HISPETECH ="psncode";
	public static String TIP_NAME_HISPETECH ="员工编码";
	//工人技术等级
	public static String TABLENAME_HITECHRANK = "工人技术等级";
	public static String[] NOTNULL_HITECHRANK ={"pk_psndoc","techlevelname","techdutyname","jdtype"};
	public static String[] NOTNULL_NAME_HITECHRANK ={"人员工作信息主键","工人技术等级","鉴定工种","鉴定类型"};
	public static String[] NOTNULL_OTHER_HITECHRANK ={"pk_psndoc","techlevelname"};
	public static String[] NOTNULL_OTHER_NAME_HITECHRANK ={"人员工作信息主键","工人技术等级"};
	public static String[] DEFDOC_HITECHRANK ={"techlevelname"};
	public static String[] DEFDOC_NAME_HITECHRANK ={"工人技术等级"};
	public static String[] PK_HITECHRANK ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HITECHRANK ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HITECHRANK ="psncode";
	public static String TIP_NAME_HITECHRANK ="员工编码";
	//知识产权信息
	public static String TABLENAME_HIGRPDEF11 = "知识产权信息";
	public static String[] NOTNULL_HIGRPDEF11 ={"pk_psndoc","groupdef2","recordnum","lastflag"};
	public static String[] NOTNULL_NAME_HIGRPDEF11 ={"人员工作信息主键","产权编号","记录序号","最近记录标志"};
	public static String[] NOTNULL_OTHER_HIGRPDEF11 ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HIGRPDEF11 ={"人员工作信息主键","产权编号"};
	public static String[] PK_HIGRPDEF11 ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIGRPDEF11 ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HIGRPDEF11 ="psncode";
	public static String TIP_NAME_HIGRPDEF11 ="员工编码";
	//员工离职信息
	public static String TABLENAME_HIDIMISSION = "员工离职信息";
	public static String[] NOTNULL_HIDIMISSION ={"pk_psndoc","leavedate","pk_corp","pkpostbefore","psnclbefore","psnclafter","type","reason"};
	public static String[] NOTNULL_NAME_HIDIMISSION ={"人员工作信息主键","离职日期","离职单位","离职前岗位","离职前人员类别","离职后人员类别","离职类型","离职原因"};
	public static String[] NOTNULL_OTHER_HIDIMISSION ={"pk_psndoc","leavedate","pk_corp"};
	public static String[] NOTNULL_OTHER_NAME_HIDIMISSION ={"人员工作信息主键","离职日期","离职单位"};
	public static String[] DEFDOC_HIDIMISSION ={"psnclbefore","psnclafter"};
	public static String[] DEFDOC_NAME_HIDIMISSION ={"离职前人员类别","离职后人员类别"};
	public static String[] PK_HIDIMISSION ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pkpostbefore","pkomdutybefore","pk_deptbefore","pkdeptafter"};
	public static String[] PK_NAME_HIDIMISSION ={"主键","人员基础档案主键","人员工作信息主键","离职前岗位","离职前职务","离职前部门","离职挂靠部门"};
	public static String TIP_HIDIMISSION ="psncode";
	public static String TIP_NAME_HIDIMISSION ="员工编码";
	//干部信息主集-干部分类信息
	public static String TABLENAME_HRLDMINFO = "干部信息主集-干部分类信息";
	public static String[] NOTNULL_HRLDMINFO ={"pk_psndoc","pk_defdoc","ld_type","pk_corp","begindate"};
	public static String[] NOTNULL_NAME_HRLDMINFO ={"人员工作信息主键","干部分类","干部类型","公司主键","开始日期"};
	public static String[] NOTNULL_OTHER_HRLDMINFO ={"pk_psndoc","pk_defdoc","ld_type","pk_corp"};
	public static String[] NOTNULL_OTHER_NAME_HRLDMINFO ={"人员工作信息主键","干部分类","干部类型","公司主键"};
	public static String[] PK_HRLDMINFO ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pkpostbefore","pkomdutybefore","pk_deptbefore","pkdeptafter"};
	public static String[] PK_NAME_HRLDMINFO ={"主键","人员基础档案主键","人员工作信息主键","离职前岗位","离职前职务","离职前部门","离职挂靠部门"};
	public static String TIP_HRLDMINFO ="psncode";
	public static String TIP_NAME_HRLDMINFO ="员工编码";
	//领导人员职务信息子集
	public static String TABLENAME_HRLDMDUTY = "领导人员职务信息子集";
	public static String[] NOTNULL_HRLDMDUTY ={"pk_psndoc","groupdef1","groupdef2","groupdef3","groupdef4","pk_hold_corp","pk_hold_dept","pk_om_duty","groupdef5","pk_dutylevel","pk_dutytype","groupdef6","pk_holdtype","holddate","holdnumber","holdjob","holdunit"};
	public static String[] NOTNULL_NAME_HRLDMDUTY ={"人员工作信息主键","干部状态","干部层级","干部职级","是否领导人员","任职单位","任职部门","职务名称","职务状态","职务属性","职务分类","进班子时间","任职类型","任职时间","任职文号","班子分工","任职批准单位"};
	public static String[] NOTNULL_OTHER_HRLDMDUTY ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HRLDMDUTY ={"人员工作信息主键","干部层级"};
	public static String[] PK_HRLDMDUTY ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pk_hold_dept"};
	public static String[] PK_NAME_HRLDMDUTY ={"主键","人员基础档案主键","人员工作信息主键","任职部门"};
	public static String TIP_HRLDMDUTY ="psncode";
	public static String TIP_NAME_HRLDMDUTY ="员工编码";
	//后备干部信息子集
	public static String TABLENAME_HRLDMPLAN = "后备干部信息子集";
	public static String[] NOTNULL_HRLDMPLAN ={"pk_psndoc","groupdef1","groupdef2","train_target","groupdef3","train_object","groupdef4","begindate","groupdef5","groupdef6","groupdef7","train_step"};
	public static String[] NOTNULL_NAME_HRLDMPLAN ={"人员工作信息主键","后备干部类型","培养方向","培养岗位","培养成熟度","考核单位","考核单位层级","考核日期","推荐排名","推荐票数","推荐率","培养情况"};
	public static String[] PK_HRLDMPLAN ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HRLDMPLAN ={"主键","人员基础档案主键","人员工作信息主键"};
	public static String TIP_HRLDMPLAN ="psncode";
	public static String TIP_NAME_HRLDMPLAN ="员工编码";
	//专业人才管理-院士专家信息维护
	public static String TABLENAME_HREXPERT = "专业人才管理-院士专家信息维护";
	public static String[] NOTNULL_HREXPERT ={"exper_code","exper_name","exper_type","zjdj","isavic"};
	public static String[] NOTNULL_NAME_HREXPERT ={"专家编号","专家姓名","专家类别","专家等级","是否中航内专家"};
	public static String[] DEFDOC_HREXPERT ={"exper_level","exper_type","zjdj","groupdef2","vaca_types"};
	public static String[] DEFDOC_NAME_HREXPERT ={"专家级别","专家类别","专家等级","专家称号","职业（鉴定）工种"};
	public static String[] PK_HREXPERT={"pk_hr_exper","exper_name","pk_dept","pk_om_job"};
	public static String[] PK_NAME_HREXPERT ={"主键","专家姓名","所属中航部门","所属中航岗位"};
	public static String TIP_HREXPERT ="exper_code";
	public static String TIP_NAME_HREXPERT ="专家编码";
	//院士专家子集－聘期管理
	public static String TABLENAME_EXPERTTERM = "院士专家子集－聘期管理";
	public static String[] NOTNULL_EXPERTTERM ={"pk_hr_exper","begindate","glory_step","term_corp","is_term"};
	public static String[] NOTNULL_NAME_EXPERTTERM ={"院士专家主表主键","聘期开始时间","科技人才类型","聘任单位","是否在聘"};
	public static String[] DEFDOC_EXPERTTERM ={"expel"};
	public static String[] DEFDOC_NAME_EXPERTTERM ={"津贴发放机构"};
	public static String[] PK_EXPERTTERM ={"pk_expert_term","pk_hr_exper"};
	public static String[] PK_NAME_EXPERTTERM ={"主键","院士专家主表主键"};
	public static String TIP_EXPERTTERM ="exper_code";
	public static String TIP_NAME_EXPERTTERM ="专家编码";
	//薪酬管理-发放总额
	public static String TABLENAME_WADATA = "薪酬管理-发放总额";
	public static String[] NOTNULL_WADATA ={"psnid","psnclid","deptid"};//"pk_corp"数据库无此字段    ,"cyear","cperiod"暂时不校验
	public static String[] NOTNULL_NAME_WADATA ={"人员","人员类别","部门"};//"发放公司"数据库无此字段  ,"年度","期间"暂时不校验
	public static String[] DEFDOC_WADATA ={"psnclid"};
	public static String[] DEFDOC_NAME_WADATA ={"人员类别"};
	public static String[] PK_WADATA ={"pk_wa_data","classid","psnid","deptid"};//"pk_corp"数据库无此字段
	public static String[] PK_NAME_WADATA ={"主键","薪资类别","人员","部门"};//"发放公司"数据库无此字段
	public static String TIP_WADATA ="psncode";
	public static String TIP_NAME_WADATA ="员工编码";
	
	public static String[] NULLARR = new String[]{};//空数组
	
	public static String TYPE_CHECK_NULL = "非空校验";
	public static String TYPE_CHECK_CORP = "公司校验";
	public static String TYPE_DATA_CONTROL = "数据对照校验";
	
}

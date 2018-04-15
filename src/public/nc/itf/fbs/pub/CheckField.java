package nc.itf.fbs.pub; 

/**
 * @ClassName: CheckField
 * <b> ����У����ҪУ����ֶ� </b>
 * <p>
 *     28�ű�����Ҫ���зǿ�У�顢����ת�������ݶ��յ��ֶ�
 * </p>
 * ��������: 2016��9��29�� ����1:07:16
 * @Author ����ǿ
 * @Version 
 */
public interface CheckField {
	//���ŵ���
	public static String TABLENAME_DEPT = "���ŵ���";
	public static String[] NOTNULL_DEPT ={"pk_corp","deptcode","deptname","createdate"};
	public static String[] NOTNULL_NAME_DEPT ={"������˾","���ű���","��������","����ʱ��"};
	public static String[] PK_DEPT ={"pk_deptdoc","pk_fathedept","pk_psndoc","pk_psndoc2"};
	public static String[] PK_NAME_DEPT ={"��������","�ϼ�����","������1","������2"};
	public static String TIP_DEPT ="deptcode";
	public static String TIP_NAME_DEPT ="���ű���";
	//��λ������Ϣ
	public static String TABLENAME_JOB = "��λ������Ϣ";
	public static String[] NOTNULL_JOB ={"pk_corp","jobcode","jobname","builddate","pk_deptdoc","jobseries","groupdef1"};
	public static String[] NOTNULL_NAME_JOB ={"������˾","��λ����","��λ����","��������","��������","��λ����","��������"};
	public static String[] DEFDOC_JOB ={"jobseries","groupdef1","groupdef2","groupdef4"};
	public static String[] DEFDOC_NAME_JOB ={"��λ����","��������","���ܵȼ�","��Ӧרҵ����ְ������"};
	public static String[] PK_JOB ={"pk_om_job","pk_deptdoc","suporior","pk_om_duty"};
	public static String[] PK_NAME_JOB ={"��λ����","��������","ֱ���ϼ�����","����ְ��"};
	public static String TIP_JOB ="jobcode";
	public static String TIP_NAME_JOB ="��λ����";
	//ְ�������Ϣ
	public static String TABLENAME_DUTY = "ְ�������Ϣ";
	public static String[] NOTNULL_DUTY ={"pk_corp","dutycode","dutyname","dutyrank","series"};
	public static String[] NOTNULL_NAME_DUTY ={"������˾","ְ�����","ְ������","ְ������","ְ���"};
	public static String[] DEFDOC_DUTY ={"dutyrank"};
	public static String[] DEFDOC_NAME_DUTY ={"ְ������"};
	public static String[] PK_DUTY ={"pk_om_duty"};
	public static String[] PK_NAME_DUTY ={"ְ������"};
	public static String TIP_DUTY ="dutycode";
	public static String TIP_NAME_DUTY ="ְ�����";
	//��λ������Ϣ
	public static String TABLENAME_CORPLB = "��λ������Ϣ";
	public static String[] NOTNULL_CORPLB ={"pk_corp","makecorp","cyear","workout","pk_om_workout_type"};
	public static String[] NOTNULL_NAME_CORPLB ={"������˾","���Ƶ�λ","���","��˾����","���෽ʽ"};
	public static String[] PK_CORPLB ={"pk_om_corp_workout"};
	public static String[] PK_NAME_CORPLB ={"��λ������Ϣ����"};
	public static String TIP_CORPLB ="makecorp";
	public static String TIP_NAME_CORPLB ="��λ����";
	//��λ�����ӱ�
	public static String TABLENAME_CORPLBB = "��λ�����ӱ�";
	public static String[] NOTNULL_CORPLBB ={"pk_om_corp_workout","pk_ref_name","workout"};
	public static String[] NOTNULL_NAME_CORPLBB ={"��λ������������","��������","�ƻ�����"};
	public static String[] PK_CORPLBB ={"pk_om_corp_workout_b","pk_om_corp_workout"};
	public static String[] PK_NAME_CORPLBB ={"��λ�����ӱ�","��λ������Ϣ����"};
	public static String TIP_CORPLBB ="makecorp";
	public static String TIP_NAME_CORPLBB ="��λ����";
	//���ű�����Ϣ
	public static String TABLENAME_DEPTLB = "���ű�����Ϣ";
	public static String[] NOTNULL_DEPTLB ={"pk_corp","pk_deptdoc","cyear","workout","actualnum","version"};
	public static String[] NOTNULL_NAME_DEPTLB ={"������˾","����","���","���ű���","ռ������","���ư汾"};
	public static String[] PK_DEPTLB ={"pk_om_dept_workout","pk_deptdoc"};
	public static String[] PK_NAME_DEPTLB ={"���ű�����Ϣ����","����"};
	public static String TIP_DEPTLB ="deptcode";
	public static String TIP_NAME_DEPTLB ="���ű���";
	//��λ������Ϣ
	public static String TABLENAME_JOBLB = "��λ������Ϣ";
	public static String[] NOTNULL_JOBLB ={"pk_corp","pk_om_job","cyear","workout","actualnum","version"};
	public static String[] NOTNULL_NAME_JOBLB ={"������˾","��λ","���","��λ����","ռ������","��λ���ư汾"};
	public static String[] PK_JOBLB ={"pk_om_job_workout","pk_om_job"};
	public static String[] PK_NAME_JOBLB ={"��λ������Ϣ����","��λ"};
	public static String TIP_JOBLB ="jobcode";
	public static String TIP_NAME_JOBLB ="��λ����";
	//��Ա������Ϣ
	public static String TABLENAME_PSNBAS = "��Ա������Ϣ";
	public static String[] NOTNULL_PSNBAS ={"pk_corp","psnname","nationality","country","sex","id","birthdate","joinworkdate","joinsysdate","polity","nativeplace","basgroupdef12"};
	public static String[] NOTNULL_NAME_PSNBAS ={"������˾","����","����","����/����","�Ա�","���֤��","��������","�μӹ�������","���뺽��ϵͳ����ʱ��","������ò","����","������"};
	public static String[] NOTNULL_OTHER_PSNBAS = {"pk_corp","psnname","id"};
	public static String[] NOTNULL_OTHER_NAME_PSNBAS ={"������˾","����","���֤��"};
	public static String[] DEFDOC_PSNBAS ={"penelauth","marital","characterrpr","country","nativeplace","basgroupdef12"};//"bloodtype"
	public static String[] DEFDOC_NAME_PSNBAS ={"�������","����״��","��������","����/����","����","������"};//"Ѫ��"
	public static String[] PK_PSNBAS ={"pk_psnbasdoc"};
	public static String[] PK_NAME_PSNBAS ={"������Ϣ����"};
	public static String TIP_PSNBAS ="psnname";
	public static String TIP_NAME_PSNBAS ="����";
	//Ա��������Ϣ
	public static String TABLENAME_PSN = "Ա��������Ϣ";
	public static String[] NOTNULL_PSN ={"pk_corp","pk_psncl","psncode","psnname","pk_deptdoc","pk_om_job","jobseries","pk_dutyrank","dutyname","groupdef2","onpostdate","groupdef14","groupdef10","insource"};
	public static String[] NOTNULL_NAME_PSN ={"������˾","��Ա���","Ա������","����","���ڲ���","��λ����","��λ����","ְ������","ְ������","���뱾��λ����ʱ��","����ְʱ��","��ͬ��ְ��ʱ��","��������","Ա����Դ"};
	public static String[] NOTNULL_OTHER_PSN ={"pk_corp","pk_psncl","psncode","psnname","pk_deptdoc","pk_om_job","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_PSN ={"������˾","��Ա���","Ա������","����","���ڲ���","��λ����","���뱾��λ����ʱ��"};
	public static String[] DEFDOC_PSN ={"pk_psncl","jobseries","groupdef1","pk_dutyrank","groupdef3","groupdef10","insource"};
	public static String[] DEFDOC_NAME_PSN ={"��Ա���","��λ����","��������","ְ������","��Ա�ܼ�","��������","Ա����Դ"};
	public static String[] PK_PSN ={"pk_psnbasdoc","pk_psndoc","pk_deptdoc","pk_om_job","dutyname"};
	public static String[] PK_NAME_PSN ={"������Ϣ����","������Ϣ����","���ڲ���","��λ����","ְ������"};
	public static String TIP_PSN ="psncode";
	public static String TIP_NAME_PSN ="Ա������";
	//Ա����ְ��Ϣ
	public static String TABLENAME_HIDEPTCHG = "Ա����ְ��Ϣ";
	public static String[] NOTNULL_HIDEPTCHG ={"pk_psndoc","begindate","pk_corp","poststat","pk_psncl","pk_deptdoc","pk_jobserial","pk_postdoc","pk_om_duty","pk_dutyrank","isreturn"};
	public static String[] NOTNULL_NAME_HIDEPTCHG ={"��Ա������Ϣ����","��ְ��ʼ����","��ְ��λ","�Ƿ��ڸ�","��Ա���","����","��λ����","��λ","ְ��","ְ�񼶱�","�Ƿ�Ƹ"};
	public static String[] NOTNULL_OTHER_HIDEPTCHG ={"pk_psndoc","begindate","pk_corp","pk_psncl","pk_deptdoc"};
	public static String[] NOTNULL_OTHER_NAME_HIDEPTCHG ={"��Ա������Ϣ����","��ְ��ʼ����","��ְ��λ","��Ա���","����"};
	public static String[] DEFDOC_HIDEPTCHG ={"preparetype","pk_psncl","pk_jobserial"};
	public static String[] DEFDOC_NAME_HIDEPTCHG ={"��������","��Ա���","��λ����"};
	public static String[] PK_HIDEPTCHG ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pk_deptdoc","pk_postdoc","pk_om_duty"};//���ݿ�"series"�޴��ֶ�
	public static String[] PK_NAME_HIDEPTCHG ={"����","��Ա������������","��Ա������Ϣ����","����","��λ","ְ��"};//���ݿ�"ְ���"�޴��ֶ�
	public static String TIP_HIDEPTCHG ="psncode";
	public static String TIP_NAME_HIDEPTCHG ="Ա������";
	//������ò��Ϣ
	public static String TABLENAME_HIPARTYLOG = "������ò��Ϣ";
	public static String[] NOTNULL_HIPARTYLOG ={"pk_psndoc","cpartyname","dpartydate"};
	public static String[] NOTNULL_NAME_HIPARTYLOG ={"��Ա������Ϣ����","������ò","�뵳������"};
	public static String[] NOTNULL_OTHER_HIPARTYLOG ={"pk_psndoc","cpartyname"};
	public static String[] NOTNULL_OTHER_NAME_HIPARTYLOG ={"��Ա������Ϣ����","������ò"};
	public static String[] DEFDOC_HIPARTYLOG ={"cpartyname"};
	public static String[] DEFDOC_NAME_HIPARTYLOG ={"������ò"};
	public static String[] PK_HIPARTYLOG ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIPARTYLOG ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIPARTYLOG ="psncode";
	public static String TIP_NAME_HIPARTYLOG ="Ա������";
	//ѧ��ѧλ��Ϣ
	public static String TABLENAME_HIEDU = "ѧ��ѧλ��Ϣ";
	public static String[] NOTNULL_HIEDU ={"pk_psndoc","begindate","enddate","school","groupdef9","vstudymode","groupdef11","education","groupdef12","lasteducation","degree","groupdef2","groupdef3","groupdef4","groupdef5","groupdef6","groupdef7","groupdef8"};
	public static String[] NOTNULL_NAME_HIEDU ={"��Ա������Ϣ����","��ѧ����","��ҵ����","��ҵԺУ","ԺУ����","ѧϰ��ʽ","��ѧרҵ","����ѧ��","�Ƿ��һѧ��","�Ƿ����ѧ��","����ѧλ","�Ƿ��һѧλ","�Ƿ����ѧλ","�Ƿ�ȫ����","�Ƿ��ص�","�Ƿ�211ԺУ","�Ƿ�985ԺУ","�Ƿ񺽿�ԺУ"};
	public static String[] NOTNULL_OTHER_HIEDU ={"pk_psndoc","education"};
	public static String[] NOTNULL_OTHER_NAME_HIEDU ={"��Ա������Ϣ����","����ѧ��"};
	public static String[] DEFDOC_HIEDU ={"vstudymode","education","degree"};
	public static String[] DEFDOC_NAME_HIEDU ={"ѧϰ��ʽ","����ѧ��","����ѧλ"};
	public static String[] PK_HIEDU ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIEDU ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIEDU ="psncode";
	public static String TIP_NAME_HIEDU ="Ա������";
	//��ͥ��Ա���ⱳ����Ϣ
	public static String TABLENAME_HIGRPDEF14= "��ͥ��Ա���ⱳ����Ϣ";
	public static String[] NOTNULL_HIGRPDEF14 ={"pk_psndoc","groupdef1","groupdef2","groupdef3","begindate","groupdef6","groupdef7","groupdef9"};
	public static String[] NOTNULL_NAME_HIGRPDEF14 ={"��Ա������Ϣ����","��ͥ��Ա����","�뱾�˹�ϵ","����/����","����ʱ��","���ڹ��ҵ���","����ԭ��","�Ƿ����ڹ���"};
	public static String[] PK_HIGRPDEF14 ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIGRPDEF14 ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIGRPDEF14 ="psncode";
	public static String TIP_NAME_HIGRPDEF14 ="Ա������";
	//Ա������������Ϣ
	public static String TABLENAME_HIWORK = "Ա������������Ϣ";
	public static String[] NOTNULL_HIWORK ={"pk_psndoc","begindate","workcorp","workdept","workpost"};
	public static String[] NOTNULL_NAME_HIWORK ={"��Ա������Ϣ����","������ʼ����","������λ","���ڲ���","��ְ��"};
	public static String[] NOTNULL_OTHER_HIWORK ={"pk_psndoc","begindate","workcorp"};
	public static String[] NOTNULL_OTHER_NAME_HIWORK ={"��Ա������Ϣ����","������ʼ����","������λ"};
	public static String[] PK_HIWORK ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIWORK ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIWORK ="psncode";
	public static String TIP_NAME_HIWORK ="Ա������";
	//Ա�����⾭����Ϣ
	public static String TABLENAME_HIABROAD = "Ա�����⾭����Ϣ";
	public static String[] NOTNULL_HIABROAD ={"pk_psndoc","pk_corp","groupdef2","cabroadarea","dabroaddate","groupdef3","groupdef4","groupdef5"};
	public static String[] NOTNULL_NAME_HIABROAD ={"��Ա������Ϣ����","��˾����","��������","��ȥ���ң�������","����(����)����","����ԭ��","ͣ������","�Ƿ����ڹ���"};
	public static String[] NOTNULL_OTHER_HIABROAD ={"pk_psndoc","pk_corp","cabroadarea","dabroaddate"};
	public static String[] NOTNULL_OTHER_NAME_HIABROAD ={"��Ա������Ϣ����","��˾����","��ȥ���ң�������","����(����)����"};
	public static String[] PK_HIABROAD ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIABROAD ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIABROAD ="psncode";
	public static String TIP_NAME_HIABROAD ="Ա������";
	//Ա��������Ϣ
	public static String TABLENAME_HIENC = "Ա��������Ϣ";
	public static String[] NOTNULL_HIENC ={"pk_psndoc","groupdef2","groupdef3"};
	public static String[] NOTNULL_NAME_HIENC ={"��Ա������Ϣ����","��������","�������"};
	public static String[] NOTNULL_OTHER_HIENC ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HIENC ={"��Ա������Ϣ����","��������"};
	public static String[] PK_HIENC ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIENC ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIENC ="psncode";
	public static String TIP_NAME_HIENC ="Ա������";
	//Ա���ʹ���Ϣ
	public static String TABLENAME_HIPUN = "Ա���ʹ���Ϣ";
	public static String[] NOTNULL_HIPUN ={"pk_psndoc","groupdef2","groupdef1","vpunishorg","vpunishmatter","recordnum","lastflag"};
	public static String[] NOTNULL_NAME_HIPUN ={"��Ա������Ϣ����","�ʹ����","�ʹ�����","�ʹ���λ","�ʹ�ԭ��","��¼���","�����¼��־"};
	public static String[] NOTNULL_OTHER_HIPUN ={"pk_psndoc","groupdef2","groupdef1"};
	public static String[] NOTNULL_OTHER_NAME_HIPUN ={"��Ա������Ϣ����","�ʹ����","�ʹ�����"};
	public static String[] PK_HIPUN ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIPUN ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIPUN ="psncode";
	public static String TIP_NAME_HIPUN ="Ա������";
	//Ա����ѵ��Ϣ
	public static String TABLENAME_HITRAINING = "Ա����ѵ��Ϣ";//"��ѵ����", "groupdef1",  �Ȳ����ǿ�У��
	public static String[] NOTNULL_HITRAINING ={"pk_psndoc","groupdef2","pk_corp","vtra_act","groupdef5","begindate","tra_time","groupdef3","groupdef7"};
	public static String[] NOTNULL_NAME_HITRAINING ={"��Ա������Ϣ����","��ѵ����","��Ա������λ","��ѵ��Ŀ����","��ѵ���","��ѵ��ʼʱ��","ѧʱ��","��ѵ�������","��ѵ�Ƿ�ϸ�"};
	public static String[] NOTNULL_OTHER_HITRAINING ={"pk_psndoc","vtra_act","groupdef5","begindate","enddate"};
	public static String[] NOTNULL_OTHER_NAME_HITRAINING ={"��Ա������Ϣ����","��ѵ��Ŀ����","��ѵ���","��ѵ��ʼʱ��","��ѵ��ֹʱ��"};
	public static String[] DEFDOC_HITRAINING ={"groupdef2","tra_mode","groupdef4","groupdef3"};
	public static String[] DEFDOC_NAME_HITRAINING ={"��ѵ����","��ѵ��ʽ","��ѵ�������","��ѵ�������"};
	public static String[] PK_HITRAINING ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HITRAINING ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HITRAINING ="psncode";
	public static String TIP_NAME_HITRAINING ="Ա������";
	//רҵ����ְ��
	public static String TABLENAME_HISPETECH = "רҵ����ְ��";
	public static String[] NOTNULL_HISPETECH ={"pk_psndoc","ctechname","ctechduty","cincomeway","cprounit","lastflag"};
	public static String[] NOTNULL_NAME_HISPETECH ={"��Ա������Ϣ����","רҵ����ְ��","רҵ�����ȼ�","ȡ���ʸ�;��","�ʸ�������λ","�Ƿ���רҵ����ְ��"};
	public static String[] NOTNULL_OTHER_HISPETECH ={"pk_psndoc","ctechduty"};
	public static String[] NOTNULL_OTHER_NAME_HISPETECH ={"��Ա������Ϣ����","רҵ�����ȼ�"};
	public static String[] DEFDOC_HISPETECH ={"ctechname","ctechduty"};
	public static String[] DEFDOC_NAME_HISPETECH ={"רҵ����ְ��","רҵ�����ȼ�"};
	public static String[] PK_HISPETECH ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HISPETECH ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HISPETECH ="psncode";
	public static String TIP_NAME_HISPETECH ="Ա������";
	//���˼����ȼ�
	public static String TABLENAME_HITECHRANK = "���˼����ȼ�";
	public static String[] NOTNULL_HITECHRANK ={"pk_psndoc","techlevelname","techdutyname","jdtype"};
	public static String[] NOTNULL_NAME_HITECHRANK ={"��Ա������Ϣ����","���˼����ȼ�","��������","��������"};
	public static String[] NOTNULL_OTHER_HITECHRANK ={"pk_psndoc","techlevelname"};
	public static String[] NOTNULL_OTHER_NAME_HITECHRANK ={"��Ա������Ϣ����","���˼����ȼ�"};
	public static String[] DEFDOC_HITECHRANK ={"techlevelname"};
	public static String[] DEFDOC_NAME_HITECHRANK ={"���˼����ȼ�"};
	public static String[] PK_HITECHRANK ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HITECHRANK ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HITECHRANK ="psncode";
	public static String TIP_NAME_HITECHRANK ="Ա������";
	//֪ʶ��Ȩ��Ϣ
	public static String TABLENAME_HIGRPDEF11 = "֪ʶ��Ȩ��Ϣ";
	public static String[] NOTNULL_HIGRPDEF11 ={"pk_psndoc","groupdef2","recordnum","lastflag"};
	public static String[] NOTNULL_NAME_HIGRPDEF11 ={"��Ա������Ϣ����","��Ȩ���","��¼���","�����¼��־"};
	public static String[] NOTNULL_OTHER_HIGRPDEF11 ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HIGRPDEF11 ={"��Ա������Ϣ����","��Ȩ���"};
	public static String[] PK_HIGRPDEF11 ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HIGRPDEF11 ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HIGRPDEF11 ="psncode";
	public static String TIP_NAME_HIGRPDEF11 ="Ա������";
	//Ա����ְ��Ϣ
	public static String TABLENAME_HIDIMISSION = "Ա����ְ��Ϣ";
	public static String[] NOTNULL_HIDIMISSION ={"pk_psndoc","leavedate","pk_corp","pkpostbefore","psnclbefore","psnclafter","type","reason"};
	public static String[] NOTNULL_NAME_HIDIMISSION ={"��Ա������Ϣ����","��ְ����","��ְ��λ","��ְǰ��λ","��ְǰ��Ա���","��ְ����Ա���","��ְ����","��ְԭ��"};
	public static String[] NOTNULL_OTHER_HIDIMISSION ={"pk_psndoc","leavedate","pk_corp"};
	public static String[] NOTNULL_OTHER_NAME_HIDIMISSION ={"��Ա������Ϣ����","��ְ����","��ְ��λ"};
	public static String[] DEFDOC_HIDIMISSION ={"psnclbefore","psnclafter"};
	public static String[] DEFDOC_NAME_HIDIMISSION ={"��ְǰ��Ա���","��ְ����Ա���"};
	public static String[] PK_HIDIMISSION ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pkpostbefore","pkomdutybefore","pk_deptbefore","pkdeptafter"};
	public static String[] PK_NAME_HIDIMISSION ={"����","��Ա������������","��Ա������Ϣ����","��ְǰ��λ","��ְǰְ��","��ְǰ����","��ְ�ҿ�����"};
	public static String TIP_HIDIMISSION ="psncode";
	public static String TIP_NAME_HIDIMISSION ="Ա������";
	//�ɲ���Ϣ����-�ɲ�������Ϣ
	public static String TABLENAME_HRLDMINFO = "�ɲ���Ϣ����-�ɲ�������Ϣ";
	public static String[] NOTNULL_HRLDMINFO ={"pk_psndoc","pk_defdoc","ld_type","pk_corp","begindate"};
	public static String[] NOTNULL_NAME_HRLDMINFO ={"��Ա������Ϣ����","�ɲ�����","�ɲ�����","��˾����","��ʼ����"};
	public static String[] NOTNULL_OTHER_HRLDMINFO ={"pk_psndoc","pk_defdoc","ld_type","pk_corp"};
	public static String[] NOTNULL_OTHER_NAME_HRLDMINFO ={"��Ա������Ϣ����","�ɲ�����","�ɲ�����","��˾����"};
	public static String[] PK_HRLDMINFO ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pkpostbefore","pkomdutybefore","pk_deptbefore","pkdeptafter"};
	public static String[] PK_NAME_HRLDMINFO ={"����","��Ա������������","��Ա������Ϣ����","��ְǰ��λ","��ְǰְ��","��ְǰ����","��ְ�ҿ�����"};
	public static String TIP_HRLDMINFO ="psncode";
	public static String TIP_NAME_HRLDMINFO ="Ա������";
	//�쵼��Աְ����Ϣ�Ӽ�
	public static String TABLENAME_HRLDMDUTY = "�쵼��Աְ����Ϣ�Ӽ�";
	public static String[] NOTNULL_HRLDMDUTY ={"pk_psndoc","groupdef1","groupdef2","groupdef3","groupdef4","pk_hold_corp","pk_hold_dept","pk_om_duty","groupdef5","pk_dutylevel","pk_dutytype","groupdef6","pk_holdtype","holddate","holdnumber","holdjob","holdunit"};
	public static String[] NOTNULL_NAME_HRLDMDUTY ={"��Ա������Ϣ����","�ɲ�״̬","�ɲ��㼶","�ɲ�ְ��","�Ƿ��쵼��Ա","��ְ��λ","��ְ����","ְ������","ְ��״̬","ְ������","ְ�����","������ʱ��","��ְ����","��ְʱ��","��ְ�ĺ�","���ӷֹ�","��ְ��׼��λ"};
	public static String[] NOTNULL_OTHER_HRLDMDUTY ={"pk_psndoc","groupdef2"};
	public static String[] NOTNULL_OTHER_NAME_HRLDMDUTY ={"��Ա������Ϣ����","�ɲ��㼶"};
	public static String[] PK_HRLDMDUTY ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc","pk_hold_dept"};
	public static String[] PK_NAME_HRLDMDUTY ={"����","��Ա������������","��Ա������Ϣ����","��ְ����"};
	public static String TIP_HRLDMDUTY ="psncode";
	public static String TIP_NAME_HRLDMDUTY ="Ա������";
	//�󱸸ɲ���Ϣ�Ӽ�
	public static String TABLENAME_HRLDMPLAN = "�󱸸ɲ���Ϣ�Ӽ�";
	public static String[] NOTNULL_HRLDMPLAN ={"pk_psndoc","groupdef1","groupdef2","train_target","groupdef3","train_object","groupdef4","begindate","groupdef5","groupdef6","groupdef7","train_step"};
	public static String[] NOTNULL_NAME_HRLDMPLAN ={"��Ա������Ϣ����","�󱸸ɲ�����","��������","������λ","���������","���˵�λ","���˵�λ�㼶","��������","�Ƽ�����","�Ƽ�Ʊ��","�Ƽ���","�������"};
	public static String[] PK_HRLDMPLAN ={"pk_psndoc_sub","pk_psnbasdoc","pk_psndoc"};
	public static String[] PK_NAME_HRLDMPLAN ={"����","��Ա������������","��Ա������Ϣ����"};
	public static String TIP_HRLDMPLAN ="psncode";
	public static String TIP_NAME_HRLDMPLAN ="Ա������";
	//רҵ�˲Ź���-Ժʿר����Ϣά��
	public static String TABLENAME_HREXPERT = "רҵ�˲Ź���-Ժʿר����Ϣά��";
	public static String[] NOTNULL_HREXPERT ={"exper_code","exper_name","exper_type","zjdj","isavic"};
	public static String[] NOTNULL_NAME_HREXPERT ={"ר�ұ��","ר������","ר�����","ר�ҵȼ�","�Ƿ��к���ר��"};
	public static String[] DEFDOC_HREXPERT ={"exper_level","exper_type","zjdj","groupdef2","vaca_types"};
	public static String[] DEFDOC_NAME_HREXPERT ={"ר�Ҽ���","ר�����","ר�ҵȼ�","ר�ҳƺ�","ְҵ������������"};
	public static String[] PK_HREXPERT={"pk_hr_exper","exper_name","pk_dept","pk_om_job"};
	public static String[] PK_NAME_HREXPERT ={"����","ר������","�����к�����","�����к���λ"};
	public static String TIP_HREXPERT ="exper_code";
	public static String TIP_NAME_HREXPERT ="ר�ұ���";
	//Ժʿר���Ӽ���Ƹ�ڹ���
	public static String TABLENAME_EXPERTTERM = "Ժʿר���Ӽ���Ƹ�ڹ���";
	public static String[] NOTNULL_EXPERTTERM ={"pk_hr_exper","begindate","glory_step","term_corp","is_term"};
	public static String[] NOTNULL_NAME_EXPERTTERM ={"Ժʿר����������","Ƹ�ڿ�ʼʱ��","�Ƽ��˲�����","Ƹ�ε�λ","�Ƿ���Ƹ"};
	public static String[] DEFDOC_EXPERTTERM ={"expel"};
	public static String[] DEFDOC_NAME_EXPERTTERM ={"�������Ż���"};
	public static String[] PK_EXPERTTERM ={"pk_expert_term","pk_hr_exper"};
	public static String[] PK_NAME_EXPERTTERM ={"����","Ժʿר����������"};
	public static String TIP_EXPERTTERM ="exper_code";
	public static String TIP_NAME_EXPERTTERM ="ר�ұ���";
	//н�����-�����ܶ�
	public static String TABLENAME_WADATA = "н�����-�����ܶ�";
	public static String[] NOTNULL_WADATA ={"psnid","psnclid","deptid"};//"pk_corp"���ݿ��޴��ֶ�    ,"cyear","cperiod"��ʱ��У��
	public static String[] NOTNULL_NAME_WADATA ={"��Ա","��Ա���","����"};//"���Ź�˾"���ݿ��޴��ֶ�  ,"���","�ڼ�"��ʱ��У��
	public static String[] DEFDOC_WADATA ={"psnclid"};
	public static String[] DEFDOC_NAME_WADATA ={"��Ա���"};
	public static String[] PK_WADATA ={"pk_wa_data","classid","psnid","deptid"};//"pk_corp"���ݿ��޴��ֶ�
	public static String[] PK_NAME_WADATA ={"����","н�����","��Ա","����"};//"���Ź�˾"���ݿ��޴��ֶ�
	public static String TIP_WADATA ="psncode";
	public static String TIP_NAME_WADATA ="Ա������";
	
	public static String[] NULLARR = new String[]{};//������
	
	public static String TYPE_CHECK_NULL = "�ǿ�У��";
	public static String TYPE_CHECK_CORP = "��˾У��";
	public static String TYPE_DATA_CONTROL = "���ݶ���У��";
	
}

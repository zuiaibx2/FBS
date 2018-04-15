/**
 * IWriteWSDataServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package nc.ui.export.webservice;

public interface IWriteWSDataServicePortType extends java.rmi.Remote {
    public java.lang.String writeBd_deptdoc(nc.ws.vo.bd.Bd_deptdocVO[] bd_deptdocVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_job(nc.ws.vo.om.Om_jobVO[] om_jobVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_duty(nc.ws.vo.om.Om_dutyVO[] om_dutyVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_corp_workout(nc.ws.vo.om.Om_corp_workoutVO[] om_corp_workoutVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_corp_workout_b(nc.ws.vo.om.Om_corp_workout_bVO[] om_corp_workout_bVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_dept_workout(nc.ws.vo.om.Om_dept_workoutVO[] om_dept_workoutVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeOm_job_workout(nc.ws.vo.om.Om_job_workoutVO[] om_job_workoutVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeBd_psnbasdoc(nc.ws.vo.bd.Bd_psnbasdocVO[] bd_psnbasdocVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeBd_psndoc(nc.ws.vo.bd.Bd_psndocVO[] bd_psndocVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_deptchg(nc.ws.vo.hi.Hi_psndoc_deptchgVO[] hi_psndoc_deptchgVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_partylog(nc.ws.vo.hi.Hi_psndoc_partylogVO[] hi_psndoc_partylogVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_edu(nc.ws.vo.hi.Hi_psndoc_eduVO[] hi_psndoc_eduVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_grpdef14(nc.ws.vo.hi.Hi_psndoc_grpdef14VO[] hi_psndoc_grpdef14VOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_work(nc.ws.vo.hi.Hi_psndoc_workVO[] hi_psndoc_workVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_abroad(nc.ws.vo.hi.Hi_psndoc_abroadVO[] hi_psndoc_abroadVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_enc(nc.ws.vo.hi.Hi_psndoc_encVO[] hi_psndoc_encVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_pun(nc.ws.vo.hi.Hi_psndoc_punVO[] hi_psndoc_punVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_training(nc.ws.vo.hi.Hi_psndoc_trainingVO[] hi_psndoc_trainingVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_spetech(nc.ws.vo.hi.Hi_psndoc_spetechVO[] hi_psndoc_spetechVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_techrank(nc.ws.vo.hi.Hi_psndoc_techrankVO[] hi_psndoc_techrankVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_grpdef11(nc.ws.vo.hi.Hi_psndoc_grpdef11VO[] hi_psndoc_grpdef11VOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHi_psndoc_dimission(nc.ws.vo.hi.Hi_psndoc_dimissionVO[] hi_psndoc_dimissionVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHrldm_ldpsn_info(nc.ws.vo.hrldm.Hrldm_ldpsn_infoVO[] hrldm_ldpsn_infoVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHrldm_psndoc_duty(nc.ws.vo.hrldm.Hrldm_psndoc_dutyVO[] hrldm_psndoc_dutyVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHrldm_train_plan(nc.ws.vo.hrldm.Hrldm_train_planVO[] hrldm_train_planVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeHr_expert(nc.ws.vo.hr.Hr_expertVO[] hr_expertVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeExpert_term(nc.ws.vo.expert.Expert_termVO[] expert_termVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String writeWa_data(nc.ws.vo.wa.Wa_dataVO[] wa_dataVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String checkWsVersion(nc.ws.vo.version.Fbs_export_timeVO[] fbs_export_timeVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String insertWSVersion(nc.ws.vo.version.Fbs_export_timeVO[] fbs_export_timeVOarrayItem) throws java.rmi.RemoteException;
    public java.lang.String checkToolVersion(java.lang.String string) throws java.rmi.RemoteException;
}

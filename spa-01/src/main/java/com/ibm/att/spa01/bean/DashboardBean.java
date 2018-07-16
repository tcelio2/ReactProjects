package com.ibm.att.spa01.bean;

public class DashboardBean {
	
    private String managerName;  //item complementar
    private int managerId; //item complementar
    private String managerUserName;//item complementar
    private String application;
    private String email;
    private String lastName;
    private int dashboardId;
    //dados do schedule utilizado para gerar dashboard caso hld ou ad ou ia ou cw existirem
    private int scheduleId;
    private String scheduleHLD;
    private String scheduleIA;
    private String scheduleAD;
    private String scheduleCW;
    
    
    private int deliverableId;         //dados referenste as tabelas relacionadas a Dashboard (tabela deliverable)
    private String deliverableIdLabel; //dados referenste as tabelas relacionadas a Dashboard (tabela deliverable)
    
    private int userProjectId;				 //dados referenste as tabelas relacionadas a Dashboard (tabela user_project)
    private String userProjectIdLabel;			 //dados referenste as tabelas relacionadas a Dashboard (tabela user_project)
    
    
    //
    private int projectId;    //deve ser diferente da chave primaria do banco de dados
    private String projectName;
    private String projectState;
    private String sdlc; //methodology
    private String projectStatus;
    private String issue;
    private String comments;
    private String jeopardyList;
    //--------------PROJECT INFORMATION---------
    private String piFtps;
    private String piFtpsCurrentMonth;
    private String piFtpsNextMonth;
    private String piCrs;
    private String piSe;
    private String piIbmPm;
    private String piApm;
    //-----------------SCHEDULE----------------
    private String scRelease;
    private String scTestingTarget;
    private String scSprint;
    private String scSchedule;
    //--------------------IMPACT------------------
    private String iType;
    private String iTube;
    private String iBc;
    private String iInv;
    private String iPi;
    //-------------------REQUIREMENT----------------------
    private String reqSrs;
    private String reqStatus;
    private String reqBaselineDate;
    private String reqDueDate;
    private String reqPlanned;

    //---------------------DESIGN-------------------------------------
    //hld
    private String desHld;
    //hld - tube
    private String desHldTube; //1
    private String desHldTubeResource; //1
    private String desHldTubeDueDate; //1
    private String desHldTubePlanned; //1
    //hld - bc
    private String desHldBc;//2
    private String desHldBcResource;//2
    private String desHldBcDueDate;//2
    private String desHldBcPlanned;//2
    //hld - inv
    private String desHldinv;//3
    private String desHldinvResource;//3
    private String desHldinvDueDate;//3
    private String desHldinvPlanned;//3
    //hld - pi
    private String desHldPi;//4
    private String desHldPiResource;//4
    private String desHldPiDueDate;//4
    private String desHldPiPlanned;//4
    //Ia
    private String desIa;
    //ia Ia
    private String desIaIa;
    private String desIaIaResource;
    private String desIaIaDueDate;
    private String desIaIaPlanned;
    //Ad	
    private String desAd;
    //ad - tube
    private String desAdTube; //1
    private String desAdTubeResource; //1
    private String desAdTubeDueDate; //1
    private String desAdTubePlanned; //1
    //ad - bc
    private String desAdBc;//2
    private String desAdBcResource;//2
    private String desAdBcDueDate;//2
    private String desAdBcPlanned;//2
    //ad - inv
    private String desAdinv;//3
    private String desAdinvResource;//3
    private String desAdinvDueDate;//3
    private String desAdinvPlanned;//3
    //Cw
    private String desCw;
    //cw - pi
    private String desCwPi; //1
    private String desCwPiResource; //1
    private String desCwPiDueDate; //1
    private String desCwPiPlanned; //1

    //----------------------DEVELOPMENT-----------------------------------
    //UTD
    private String devUtd;
    //UTD - tube
    private String devUtdTube;
    private String devUtdTubeResource;
    private String devUtdTubeDueDate;
    private String devUtdTubePlanned;
    //UTD - bc
    private String devUtdBc;
    private String devUtdBcResource;
    private String devUtdBcDueDate;
    private String devUtdBcPlanned;
    //UTD - Inv
    private String devUtdInv;
    private String devUtdInvResource;
    private String devUtdInvDueDate;
    private String devUtdInvPlanned;
    //STD
    private String devStd;
    //STD - STRS
    private String devStdStsr;
    private String devStdStsrResource;
    private String devStdStsrDueDate;
    private String devStdStsrPlanned;
    //STD - TESTEDATA
    private String devStdTestData;
    private String devStdTestDataResource;
    private String devStdTestDataDueDate;
    private String devStdTestDataPlanned;
    //TAP
    private String devTap;
    //TAP - PI
    private String devTapPi;
    private String devTapPiResource;
    private String devTapPiDueDate;
    private String devTapPiPlanned;
    //CODE	
    private String devCode;
    //CODE - TUBE
    private String devCodeTube;
    private String devCodeTubeResource;
    private String devCodeTubeDueDate;
    private String devCodeTubePlanned;
    //CODE - BC
    private String devCodeBc;
    private String devCodeBcResource;
    private String devCodeBcDueDate;
    private String devCodeBcPlanned;
    //CODE - INV
    private String devCodeInv;
    private String devCodeInvResource;
    private String devCodeInvDueDate;
    private String devCodeInvPlanned;
    //UT
    private String devUt;
    //UT - TUBE
    private String devUtTube;
    private String devUtTubeResource;
    private String devUtTubeDueDate;
    private String devUtTubePlanned;
    //UT - BC
    private String devUtBc;
    private String devUtBcResource;
    private String devUtBcDueDate;
    private String devUtBcPlanned;
    //UT - INV
    private String devUtInv;
    private String devUtInvResource;
    private String devUtInvDueDate;
    private String devUtInvPlanned;

    private String methodology;
    private int methodologyId;
	
    //=================================================================================
    //=============LABEL=========================== PARTE DE TITULOS DAS TABELAS=======
    //=================================================================================
    
    private String managerNameLabel;  //item complementar
    private String managerIdLabel; //item complementar
    private String managerUserNameLabel; //item complementar
    private String applicationLabel;
    //
    private String projectIdLabel;    //deve ser diferente da chave primaria do banco de dados
    private String projectNameLabel;
    private String projectStateLabel;
    private String sdlcLabel; //methodology
    private String projectStatusLabel;
    private String issueLabel;
    private String commentsLabel;
    private String jeopardyListLabel;
    //--------------PROJECT INFORMATION---------
    private String piFtpsLabel;
    private String piFtpsCurrentMonthLabel;
    private String piFtpsNextMonthLabel;
    private String piCrsLabel;
    private String piSeLabel;
    private String piIbmPmLabel;
    private String piApmLabel;
    //-----------------SCHEDULE----------------
    private String scReleaseLabel;
    private String scTestingTargetLabel;
    private String scSprintLabel;
    private String scScheduleLabel;
    //--------------------IMPACT------------------
    private String iTypeLabel;
    private String iTubeLabel;
    private String iBcLabel;
    private String iInvLabel;
    private String iPiLabel;
    
    
    
    
    
    //-------------REQUIREMENT-------------
    private String reqSrsLabel;
    private String reqStatusLabel;
    private String reqBaselineDateLabel;
    private String reqDueDateLabel;
    private String reqPlannedLabel;

    //--------------DESIGN-----------------
    //HLD
    private String desHldLabel;
    //hld - tube
    private String desHldTubeLabel; //1
    private String desHldTubeResourceLabel; //1
    private String desHldTubeDueDateLabel; //1
    private String desHldTubePlannedLabel; //1
    //hld - bc
    private String desHldBcLabel;//2
    private String desHldBcResourceLabel;//2
    private String desHldBcDueDateLabel;//2
    private String desHldBcPlannedLabel;//2
    //hld - inv
    private String desHldinvLabel;//3
    private String desHldinvResourceLabel;//3
    private String desHldinvDueDateLabel;//3
    private String desHldinvPlannedLabel;//3
    //hld - pi
    private String desHldPiLabel;//4
    private String desHldPiResourceLabel;//4
    private String desHldPiDueDateLabel;//4
    private String desHldPiPlannedLabel;//4
    
    //IA
    private String desIaLabel;
    //IA - ia
    private String desIaIaLabel;
    private String desIaIaResourceLabel;
    private String desIaIaDueDateLabel;
    private String desIaIaPlannedLabel;
    //AD	
    private String desAdLabel;
    //AD - tube 
    private String desAdTubeLabel; //1
    private String desAdTubeResourceLabel; //1
    private String desAdTubeDueDateLabel; //1
    private String desAdTubePlannedLabel; //1
    //AD - bc
    private String desAdBcLabel;//2
    private String desAdBcResourceLabel;//2
    private String desAdBcDueDateLabel;//2
    private String desAdBcPlannedLabel;//2
    //AD - inv
    private String desAdinvLabel;//3
    private String desAdinvResourceLabel;//3
    private String desAdinvDueDateLabel;//3
    private String desAdinvPlannedLabel;//3
    //Cw
    private String desCwLabel;
    //Cw - pi
    private String desCwPiLabel; //1
    private String desCwPiResourceLabel;
    private String desCwPiDueDateLabel; //1
    private String desCwPiPlannedLabel; //1

    //------------DEVELOPMENT----------------------
    //--Utd
    private String devUtdLabel;
    //--Utd tube
    private String devUtdTubeLabel;
    private String devUtdTubeResourceLabel;
    private String devUtdTubeDueDateLabel;
    private String devUtdTubePlannedLabel;
    //--Utd BC
    private String devUtdBcLabel;
    private String devUtdBcResourceLabel;
    private String devUtdBcDueDateLabel;
    private String devUtdBcPlannedLabel;
    //--Utd Inv
    private String devUtdInvLabel;
    private String devUtdInvResourceLabel;
    private String devUtdInvDueDateLabel;
    private String devUtdInvPlannedLabel;    
    
    //std
    private String devStdLabel;
    //std - STRS
    private String devStdStsrLabel;
    private String devStdStsrResourceLabel;
    private String devStdStsrDueDateLabel;
    private String devStdStsrPlannedLabel;
    //std - testData
    private String devStdTestDataLabel;
    private String devStdTestDataResourceLabel;
    private String devStdTestDataDueDateLabel;
    private String devStdTestDataPlannedLabel;
    //tap
    private String devTapLabel;
    //tap - PI
    private String devTapPiLabel;
    private String devTapPiResourceLabel;
    private String devTapPiDueDateLabel;
    private String devTapPiPlannedLabel;
    //Code	
    private String devCodeLabel;
    //Code - TUBE	
    private String devCodeTubeLabel;
    private String devCodeTubeResourceLabel;
    private String devCodeTubeDueDateLabel;
    private String devCodeTubePlannedLabel;
    //Code - BC
    private String devCodeBcLabel;
    private String devCodeBcResourceLabel;
    private String devCodeBcDueDateLabel;
    private String devCodeBcPlannedLabel;
    //Code - INV
    private String devCodeInvLabel;
    private String devCodeInvResourceLabel;
    private String devCodeInvDueDateLabel;
    private String devCodeInvPlannedLabel;
    //Ut
    private String devUtLabel;
    //Ut - tube
    private String devUtTubeLabel;
    private String devUtTubeResourceLabel;
    private String devUtTubeDueDateLabel;
    private String devUtTubePlannedLabel;
    //Ut - BC
    private String devUtBcLabel;
    private String devUtBcResourceLabel;
    private String devUtBcDueDateLabel;
    private String devUtBcPlannedLabel;
    //Ut - inv
    private String devUtInvLabel;
    private String devUtInvResourceLabel;
    private String devUtInvDueDateLabel;
    private String devUtInvPlannedLabel;

    private String methodologyLabel;
    private String methodologyIdLabel;
	
	
	
    
    
    
    
	
	
    public int getScheduleId() {
        return scheduleId;
    }
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
    public String getScheduleHLD() {
        return scheduleHLD;
    }
    public void setScheduleHLD(String scheduleHLD) {
        this.scheduleHLD = scheduleHLD;
    }
    public String getScheduleIA() {
        return scheduleIA;
    }
    public void setScheduleIA(String scheduleIA) {
        this.scheduleIA = scheduleIA;
    }
    public String getScheduleAD() {
        return scheduleAD;
    }
    public void setScheduleAD(String scheduleAD) {
        this.scheduleAD = scheduleAD;
    }
    public String getScheduleCW() {
        return scheduleCW;
    }
    public void setScheduleCW(String scheduleCW) {
        this.scheduleCW = scheduleCW;
    }
    public int getUserProjectId() {
        return userProjectId;
    }
    public void setUserProjectId(int userProjectId) {
        this.userProjectId = userProjectId;
    }
    public String getUserProjectIdLabel() {
        return userProjectIdLabel;
    }
    public void setUserProjectIdLabel(String userProjectIdLabel) {
        this.userProjectIdLabel = userProjectIdLabel;
    }
    public int getDeliverableId() {
        return deliverableId;
    }
    public void setDeliverableId(int deliverableId) {
        this.deliverableId = deliverableId;
    }
    public String getDeliverableIdLabel() {
        return deliverableIdLabel;
    }
    public void setDeliverableIdLabel(String deliverableIdLabel) {
        this.deliverableIdLabel = deliverableIdLabel;
    }
    public String getManagerUserNameLabel() {
        return managerUserNameLabel;
    }
    public void setManagerUserNameLabel(String managerUserNameLabel) {
        this.managerUserNameLabel = managerUserNameLabel;
    }
    public String getManagerUserName() {
        return managerUserName;
    }
    public void setManagerUserName(String managerUserName) {
        this.managerUserName = managerUserName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getDashboardId() {
        return dashboardId;
    }
    public void setDashboardId(int dashboardId) {
        this.dashboardId = dashboardId;
    }
    public String getReqSrsLabel() {
        return reqSrsLabel;
    }
    public void setReqSrsLabel(String reqSrsLabel) {
        this.reqSrsLabel = reqSrsLabel;
    }
    public String getReqStatusLabel() {
        return reqStatusLabel;
    }
    public void setReqStatusLabel(String reqStatusLabel) {
        this.reqStatusLabel = reqStatusLabel;
    }
    public String getReqBaselineDateLabel() {
        return reqBaselineDateLabel;
    }
    public void setReqBaselineDateLabel(String reqBaselineDateLabel) {
        this.reqBaselineDateLabel = reqBaselineDateLabel;
    }
    public String getReqDueDateLabel() {
        return reqDueDateLabel;
    }
    public void setReqDueDateLabel(String reqDueDateLabel) {
        this.reqDueDateLabel = reqDueDateLabel;
    }
    public String getReqPlannedLabel() {
        return reqPlannedLabel;
    }
    public void setReqPlannedLabel(String reqPlannedLabel) {
        this.reqPlannedLabel = reqPlannedLabel;
    }
    public String getDesHldLabel() {
        return desHldLabel;
    }
    public void setDesHldLabel(String desHldLabel) {
        this.desHldLabel = desHldLabel;
    }
    public String getDesHldTubeLabel() {
        return desHldTubeLabel;
    }
    public void setDesHldTubeLabel(String desHldTubeLabel) {
        this.desHldTubeLabel = desHldTubeLabel;
    }
    public String getDesHldTubeDueDateLabel() {
        return desHldTubeDueDateLabel;
    }
    public void setDesHldTubeDueDateLabel(String desHldTubeDueDateLabel) {
        this.desHldTubeDueDateLabel = desHldTubeDueDateLabel;
    }
    public String getDesHldBcLabel() {
        return desHldBcLabel;
    }
    public void setDesHldBcLabel(String desHldBcLabel) {
        this.desHldBcLabel = desHldBcLabel;
    }
    public String getDesHldBcDueDateLabel() {
        return desHldBcDueDateLabel;
    }
    public void setDesHldBcDueDateLabel(String desHldBcDueDateLabel) {
        this.desHldBcDueDateLabel = desHldBcDueDateLabel;
    }
    public String getDesHldinvLabel() {
        return desHldinvLabel;
    }
    public void setDesHldinvLabel(String desHldinvLabel) {
        this.desHldinvLabel = desHldinvLabel;
    }
    public String getDesHldinvDueDateLabel() {
        return desHldinvDueDateLabel;
    }
    public void setDesHldinvDueDateLabel(String desHldinvDueDateLabel) {
        this.desHldinvDueDateLabel = desHldinvDueDateLabel;
    }
    public String getDesHldPiLabel() {
        return desHldPiLabel;
    }
    public void setDesHldPiLabel(String desHldPiLabel) {
        this.desHldPiLabel = desHldPiLabel;
    }
    public String getDesHldPiDueDateLabel() {
        return desHldPiDueDateLabel;
    }
    public void setDesHldPiDueDateLabel(String desHldPiDueDateLabel) {
        this.desHldPiDueDateLabel = desHldPiDueDateLabel;
    }
    public String getDesIaLabel() {
        return desIaLabel;
    }
    public void setDesIaLabel(String desIaLabel) {
        this.desIaLabel = desIaLabel;
    }
    public String getDesIaIaLabel() {
        return desIaIaLabel;
    }
    public void setDesIaIaLabel(String desIaIaLabel) {
        this.desIaIaLabel = desIaIaLabel;
    }
  
    public String getDesAdLabel() {
        return desAdLabel;
    }
    public void setDesAdLabel(String desAdLabel) {
        this.desAdLabel = desAdLabel;
    }
    public String getDesAdTubeLabel() {
        return desAdTubeLabel;
    }
    public void setDesAdTubeLabel(String desAdTubeLabel) {
        this.desAdTubeLabel = desAdTubeLabel;
    }
    public String getDesAdTubeDueDateLabel() {
        return desAdTubeDueDateLabel;
    }
    public void setDesAdTubeDueDateLabel(String desAdTubeDueDateLabel) {
        this.desAdTubeDueDateLabel = desAdTubeDueDateLabel;
    }
    public String getDesAdBcLabel() {
        return desAdBcLabel;
    }
    public void setDesAdBcLabel(String desAdBcLabel) {
        this.desAdBcLabel = desAdBcLabel;
    }
    public String getDesAdBcDueDateLabel() {
        return desAdBcDueDateLabel;
    }
    public void setDesAdBcDueDateLabel(String desAdBcDueDateLabel) {
        this.desAdBcDueDateLabel = desAdBcDueDateLabel;
    }
    public String getDesAdinvLabel() {
        return desAdinvLabel;
    }
    public void setDesAdinvLabel(String desAdinvLabel) {
        this.desAdinvLabel = desAdinvLabel;
    }
    public String getDesAdinvDueDateLabel() {
        return desAdinvDueDateLabel;
    }
    public void setDesAdinvDueDateLabel(String desAdinvDueDateLabel) {
        this.desAdinvDueDateLabel = desAdinvDueDateLabel;
    }
    public String getDesCwLabel() {
        return desCwLabel;
    }
    public void setDesCwLabel(String desCwLabel) {
        this.desCwLabel = desCwLabel;
    }
    public String getDesCwPiLabel() {
        return desCwPiLabel;
    }
    public void setDesCwPiLabel(String desCwPiLabel) {
        this.desCwPiLabel = desCwPiLabel;
    }
    public String getDesCwPiDueDateLabel() {
        return desCwPiDueDateLabel;
    }
    public void setDesCwPiDueDateLabel(String desCwPiDueDateLabel) {
        this.desCwPiDueDateLabel = desCwPiDueDateLabel;
    }
    public String getDevUtdLabel() {
        return devUtdLabel;
    }
    public void setDevUtdLabel(String devUtdLabel) {
        this.devUtdLabel = devUtdLabel;
    }
    public String getDevUtdTubeLabel() {
        return devUtdTubeLabel;
    }
    public void setDevUtdTubeLabel(String devUtdTubeLabel) {
        this.devUtdTubeLabel = devUtdTubeLabel;
    }
    public String getDevUtdTubeDueDateLabel() {
        return devUtdTubeDueDateLabel;
    }
    public void setDevUtdTubeDueDateLabel(String devUtdTubeDueDateLabel) {
        this.devUtdTubeDueDateLabel = devUtdTubeDueDateLabel;
    }
    public String getDevUtdBcLabel() {
        return devUtdBcLabel;
    }
    public void setDevUtdBcLabel(String devUtdBcLabel) {
        this.devUtdBcLabel = devUtdBcLabel;
    }
    public String getDevUtdBcDueDateLabel() {
        return devUtdBcDueDateLabel;
    }
    public void setDevUtdBcDueDateLabel(String devUtdBcDueDateLabel) {
        this.devUtdBcDueDateLabel = devUtdBcDueDateLabel;
    }
    public String getDevUtdInvLabel() {
        return devUtdInvLabel;
    }
    public void setDevUtdInvLabel(String devUtdInvLabel) {
        this.devUtdInvLabel = devUtdInvLabel;
    }
    public String getDevUtdInvDueDateLabel() {
        return devUtdInvDueDateLabel;
    }
    public void setDevUtdInvDueDateLabel(String devUtdInvDueDateLabel) {
        this.devUtdInvDueDateLabel = devUtdInvDueDateLabel;
    }
    public String getDevStdLabel() {
        return devStdLabel;
    }
    public void setDevStdLabel(String devStdLabel) {
        this.devStdLabel = devStdLabel;
    }
    public String getDevStdStsrLabel() {
        return devStdStsrLabel;
    }
    public void setDevStdStsrLabel(String devStdStsrLabel) {
        this.devStdStsrLabel = devStdStsrLabel;
    }
    public String getDevStdStsrDueDateLabel() {
        return devStdStsrDueDateLabel;
    }
    public void setDevStdStsrDueDateLabel(String devStdStsrDueDateLabel) {
        this.devStdStsrDueDateLabel = devStdStsrDueDateLabel;
    }
    public String getDevStdTestDataLabel() {
        return devStdTestDataLabel;
    }
    public void setDevStdTestDataLabel(String devStdTestDataLabel) {
        this.devStdTestDataLabel = devStdTestDataLabel;
    }
    public String getDevStdTestDataDueDateLabel() {
        return devStdTestDataDueDateLabel;
    }
    public void setDevStdTestDataDueDateLabel(String devStdTestDataDueDateLabel) {
        this.devStdTestDataDueDateLabel = devStdTestDataDueDateLabel;
    }
    public String getDevTapLabel() {
        return devTapLabel;
    }
    public void setDevTapLabel(String devTapLabel) {
        this.devTapLabel = devTapLabel;
    }
    public String getDevTapPiLabel() {
        return devTapPiLabel;
    }
    public void setDevTapPiLabel(String devTapPiLabel) {
        this.devTapPiLabel = devTapPiLabel;
    }
    public String getDevTapPiDueDateLabel() {
        return devTapPiDueDateLabel;
    }
    public void setDevTapPiDueDateLabel(String devTapPiDueDateLabel) {
        this.devTapPiDueDateLabel = devTapPiDueDateLabel;
    }
    public String getDevCodeLabel() {
        return devCodeLabel;
    }
    public void setDevCodeLabel(String devCodeLabel) {
        this.devCodeLabel = devCodeLabel;
    }
    public String getDevCodeTubeLabel() {
        return devCodeTubeLabel;
    }
    public void setDevCodeTubeLabel(String devCodeTubeLabel) {
        this.devCodeTubeLabel = devCodeTubeLabel;
    }
    public String getDevCodeTubeDueDateLabel() {
        return devCodeTubeDueDateLabel;
    }
    public void setDevCodeTubeDueDateLabel(String devCodeTubeDueDateLabel) {
        this.devCodeTubeDueDateLabel = devCodeTubeDueDateLabel;
    }
    public String getDevCodeBcLabel() {
        return devCodeBcLabel;
    }
    public void setDevCodeBcLabel(String devCodeBcLabel) {
        this.devCodeBcLabel = devCodeBcLabel;
    }
    public String getDevCodeBcDueDateLabel() {
        return devCodeBcDueDateLabel;
    }
    public void setDevCodeBcDueDateLabel(String devCodeBcDueDateLabel) {
        this.devCodeBcDueDateLabel = devCodeBcDueDateLabel;
    }
    public String getDevCodeInvLabel() {
        return devCodeInvLabel;
    }
    public void setDevCodeInvLabel(String devCodeInvLabel) {
        this.devCodeInvLabel = devCodeInvLabel;
    }
    public String getDevCodeInvDueDateLabel() {
        return devCodeInvDueDateLabel;
    }
    public void setDevCodeInvDueDateLabel(String devCodeInvDueDateLabel) {
        this.devCodeInvDueDateLabel = devCodeInvDueDateLabel;
    }
    public String getDevUtLabel() {
        return devUtLabel;
    }
    public void setDevUtLabel(String devUtLabel) {
        this.devUtLabel = devUtLabel;
    }
    public String getDevUtTubeLabel() {
        return devUtTubeLabel;
    }
    public void setDevUtTubeLabel(String devUtTubeLabel) {
        this.devUtTubeLabel = devUtTubeLabel;
    }
    public String getDevUtTubeDueDateLabel() {
        return devUtTubeDueDateLabel;
    }
    public void setDevUtTubeDueDateLabel(String devUtTubeDueDateLabel) {
        this.devUtTubeDueDateLabel = devUtTubeDueDateLabel;
    }
    public String getDevUtBcLabel() {
        return devUtBcLabel;
    }
    public void setDevUtBcLabel(String devUtBcLabel) {
        this.devUtBcLabel = devUtBcLabel;
    }
    public String getDevUtBcDueDateLabel() {
        return devUtBcDueDateLabel;
    }
    public void setDevUtBcDueDateLabel(String devUtBcDueDateLabel) {
        this.devUtBcDueDateLabel = devUtBcDueDateLabel;
    }
    public String getDevUtInvLabel() {
        return devUtInvLabel;
    }
    public void setDevUtInvLabel(String devUtInvLabel) {
        this.devUtInvLabel = devUtInvLabel;
    }
    public String getDevUtInvDueDateLabel() {
        return devUtInvDueDateLabel;
    }
    public void setDevUtInvDueDateLabel(String devUtInvDueDateLabel) {
        this.devUtInvDueDateLabel = devUtInvDueDateLabel;
    }
    public String getMethodologyLabel() {
        return methodologyLabel;
    }
    public void setMethodologyLabel(String methodologyLabel) {
        this.methodologyLabel = methodologyLabel;
    }
    public String getMethodologyIdLabel() {
        return methodologyIdLabel;
    }
    public void setMethodologyIdLabel(String methodologyIdLabel) {
        this.methodologyIdLabel = methodologyIdLabel;
    }
	public int getManagerId() {
	    return managerId;
	}
	public void setManagerId(int managerId) {
	    this.managerId = managerId;
	}
	public String getManagerName() {
	    return managerName;
	}
	public void setManagerName(String managerName) {
	    this.managerName = managerName;
	}
	public String getDevUtdTubeDueDate() {
	    return devUtdTubeDueDate;
	}
	public void setDevUtdTubeDueDate(String devUtdTubeDueDate) {
	    this.devUtdTubeDueDate = devUtdTubeDueDate;
	}
	public String getDevUtdTube() {
	    return devUtdTube;
	}
	public void setDevUtdTube(String devUtdTube) {
	    this.devUtdTube = devUtdTube;
	}

	public String getDevUtdBc() {
	    return devUtdBc;
	}
	public void setDevUtdBc(String devUtdBc) {
	    this.devUtdBc = devUtdBc;
	}
	public String getDevUtdBcDueDate() {
	    return devUtdBcDueDate;
	}
	public void setDevUtdBcDueDate(String devUtdBcDueDate) {
	    this.devUtdBcDueDate = devUtdBcDueDate;
	}
	public String getDevUtdInv() {
	    return devUtdInv;
	}
	public void setDevUtdInv(String devUtdInv) {
	    this.devUtdInv = devUtdInv;
	}
	public String getDevUtdInvDueDate() {
	    return devUtdInvDueDate;
	}
	public void setDevUtdInvDueDate(String devUtdInvDueDate) {
	    this.devUtdInvDueDate = devUtdInvDueDate;
	}
	public String getDevStdStsr() {
	    return devStdStsr;
	}
	public void setDevStdStsr(String devStdStsr) {
	    this.devStdStsr = devStdStsr;
	}
	public String getDevStdStsrDueDate() {
	    return devStdStsrDueDate;
	}
	public void setDevStdStsrDueDate(String devStdStsrDueDate) {
	    this.devStdStsrDueDate = devStdStsrDueDate;
	}
	public String getDevStdTestData() {
	    return devStdTestData;
	}
	public void setDevStdTestData(String devStdTestData) {
	    this.devStdTestData = devStdTestData;
	}
	public String getDevStdTestDataDueDate() {
	    return devStdTestDataDueDate;
	}
	public void setDevStdTestDataDueDate(String devStdTestDataDueDate) {
	    this.devStdTestDataDueDate = devStdTestDataDueDate;
	}
	public String getDevTapPi() {
	    return devTapPi;
	}
	public void setDevTapPi(String devTapPi) {
	    this.devTapPi = devTapPi;
	}
	public String getDevTapPiDueDate() {
	    return devTapPiDueDate;
	}
	public void setDevTapPiDueDate(String devTapPiDueDate) {
	    this.devTapPiDueDate = devTapPiDueDate;
	}
	public String getDevCodeTube() {
	    return devCodeTube;
	}
	public void setDevCodeTube(String devCodeTube) {
	    this.devCodeTube = devCodeTube;
	}
	public String getDevCodeTubeDueDate() {
	    return devCodeTubeDueDate;
	}
	public void setDevCodeTubeDueDate(String devCodeTubeDueDate) {
	    this.devCodeTubeDueDate = devCodeTubeDueDate;
	}
	public String getDevCodeBc() {
	    return devCodeBc;
	}
	public void setDevCodeBc(String devCodeBc) {
	    this.devCodeBc = devCodeBc;
	}
	public String getDevCodeBcDueDate() {
	    return devCodeBcDueDate;
	}
	public void setDevCodeBcDueDate(String devCodeBcDueDate) {
	    this.devCodeBcDueDate = devCodeBcDueDate;
	}
	public String getDevCodeInv() {
	    return devCodeInv;
	}
	public void setDevCodeInv(String devCodeInv) {
	    this.devCodeInv = devCodeInv;
	}
	public String getDevCodeInvDueDate() {
	    return devCodeInvDueDate;
	}
	public void setDevCodeInvDueDate(String devCodeInvDueDate) {
	    this.devCodeInvDueDate = devCodeInvDueDate;
	}
	public String getDevUtTube() {
	    return devUtTube;
	}
	public void setDevUtTube(String devUtTube) {
	    this.devUtTube = devUtTube;
	}
	public String getDevUtTubeDueDate() {
	    return devUtTubeDueDate;
	}
	public void setDevUtTubeDueDate(String devUtTubeDueDate) {
	    this.devUtTubeDueDate = devUtTubeDueDate;
	}
	public String getDevUtBc() {
	    return devUtBc;
	}
	public void setDevUtBc(String devUtBc) {
	    this.devUtBc = devUtBc;
	}
	public String getDevUtBcDueDate() {
	    return devUtBcDueDate;
	}
	public void setDevUtBcDueDate(String devUtBcDueDate) {
	    this.devUtBcDueDate = devUtBcDueDate;
	}
	public String getDevUtInv() {
	    return devUtInv;
	}
	public void setDevUtInv(String devUtInv) {
	    this.devUtInv = devUtInv;
	}
	public String getDevUtInvDueDate() {
	    return devUtInvDueDate;
	}
	public void setDevUtInvDueDate(String devUtInvDueDate) {
	    this.devUtInvDueDate = devUtInvDueDate;
	}
	public String getDesHldTube() {
	    return desHldTube;
	}
	public void setDesHldTube(String desHldTube) {
	    this.desHldTube = desHldTube;
	}
	public String getDesHldTubeDueDate() {
	    return desHldTubeDueDate;
	}
	public void setDesHldTubeDueDate(String desHldTubeDueDate) {
	    this.desHldTubeDueDate = desHldTubeDueDate;
	}
	public String getDesHldBc() {
	    return desHldBc;
	}
	public void setDesHldBc(String desHldBc) {
	    this.desHldBc = desHldBc;
	}
	public String getDesHldBcDueDate() {
	    return desHldBcDueDate;
	}
	public void setDesHldBcDueDate(String desHldBcDueDate) {
	    this.desHldBcDueDate = desHldBcDueDate;
	}
	public String getDesHldinv() {
	    return desHldinv;
	}
	public void setDesHldinv(String desHldinv) {
	    this.desHldinv = desHldinv;
	}
	public String getDesHldinvDueDate() {
	    return desHldinvDueDate;
	}
	public void setDesHldinvDueDate(String desHldinvDueDate) {
	    this.desHldinvDueDate = desHldinvDueDate;
	}
	public String getDesHldPi() {
	    return desHldPi;
	}
	public void setDesHldPi(String desHldPi) {
	    this.desHldPi = desHldPi;
	}
	public String getDesHldPiDueDate() {
	    return desHldPiDueDate;
	}
	public void setDesHldPiDueDate(String desHldPiDueDate) {
	    this.desHldPiDueDate = desHldPiDueDate;
	}
	public String getDesIaIa() {
	    return desIaIa;
	}
	public void setDesIaIa(String desIaIa) {
	    this.desIaIa = desIaIa;
	}
	public String getDesIaIaDueDate() {
	    return desIaIaDueDate;
	}
	public void setDesIaIaDueDate(String desIaDueDate) {
	    this.desIaIaDueDate = desIaDueDate;
	}
	public String getDesAdTube() {
	    return desAdTube;
	}
	public void setDesAdTube(String desAdTube) {
	    this.desAdTube = desAdTube;
	}
	public String getDesAdTubeDueDate() {
	    return desAdTubeDueDate;
	}
	public void setDesAdTubeDueDate(String desAdTubeDueDate) {
	    this.desAdTubeDueDate = desAdTubeDueDate;
	}
	public String getDesAdBc() {
	    return desAdBc;
	}
	public void setDesAdBc(String desAdBc) {
	    this.desAdBc = desAdBc;
	}
	public String getDesAdBcDueDate() {
	    return desAdBcDueDate;
	}
	public void setDesAdBcDueDate(String desAdBcDueDate) {
	    this.desAdBcDueDate = desAdBcDueDate;
	}
	public String getDesAdinv() {
	    return desAdinv;
	}
	public void setDesAdinv(String desAdinv) {
	    this.desAdinv = desAdinv;
	}
	public String getDesAdinvDueDate() {
	    return desAdinvDueDate;
	}
	public void setDesAdinvDueDate(String desAdinvDueDate) {
	    this.desAdinvDueDate = desAdinvDueDate;
	}
	public String getDesCwPi() {
	    return desCwPi;
	}
	public void setDesCwPi(String desCwPi) {
	    this.desCwPi = desCwPi;
	}
	public String getDesCwPiDueDate() {
	    return desCwPiDueDate;
	}
	public void setDesCwPiDueDate(String desCwPiDueDate) {
	    this.desCwPiDueDate = desCwPiDueDate;
	}
	public String getReqStatus() {
	    return reqStatus;
	}
	public void setReqStatus(String reqStatus) {
	    this.reqStatus = reqStatus;
	}
	public String getReqBaselineDate() {
	    return reqBaselineDate;
	}
	public void setReqBaselineDate(String reqBaselineDate) {
	    this.reqBaselineDate = reqBaselineDate;
	}
	public String getReqDueDate() {
	    return reqDueDate;
	}
	public void setReqDueDate(String reqDueDate) {
	    this.reqDueDate = reqDueDate;
	}
	public String getReqPlanned() {
	    return reqPlanned;
	}
	public void setReqPlanned(String reqPlanned) {
	    this.reqPlanned = reqPlanned;
	}
	public String getMethodology() {
	    return methodology;
	}
	public void setMethodology(String methodology) {
	    this.methodology = methodology;
	}
	public String getDesHld() {
	    return desHld;
	}
	public void setDesHld(String desHld) {
	    this.desHld = desHld;
	}
	public String getDesIa() {
	    return desIa;
	}
	public void setDesIa(String desIa) {
	    this.desIa = desIa;
	}
	public String getDesAd() {
	    return desAd;
	}
	public void setDesAd(String desAd) {
	    this.desAd = desAd;
	}
	public String getDesCw() {
	    return desCw;
	}
	public void setDesCw(String desCw) {
	    this.desCw = desCw;
	}
	public String getDevUtd() {
	    return devUtd;
	}
	public void setDevUtd(String devUtd) {
	    this.devUtd = devUtd;
	}
	public String getDevStd() {
	    return devStd;
	}
	public void setDevStd(String devStd) {
	    this.devStd = devStd;
	}
	public String getDevTap() {
	    return devTap;
	}
	public void setDevTap(String devTap) {
	    this.devTap = devTap;
	}
	public String getDevCode() {
	    return devCode;
	}
	public void setDevCode(String devCode) {
	    this.devCode = devCode;
	}
	public String getDevUt() {
	    return devUt;
	}
	public void setDevUt(String devUt) {
	    this.devUt = devUt;
	}
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectState() {
		return projectState;
	}
	public void setProjectState(String projectState) {
		this.projectState = projectState;
	}
	public String getSdlc() {
		return sdlc;
	}
	public void setSdlc(String sdlc) {
		this.sdlc = sdlc;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getJeopardyList() {
		return jeopardyList;
	}
	public void setJeopardyList(String jeopardyList) {
		this.jeopardyList = jeopardyList;
	}
	public String getPiFtps() {
		return piFtps;
	}
	public void setPiFtps(String piFtps) {
		this.piFtps = piFtps;
	}
	public String getPiFtpsCurrentMonth() {
		return piFtpsCurrentMonth;
	}
	public void setPiFtpsCurrentMonth(String piFtpsCurrentMonth) {
		this.piFtpsCurrentMonth = piFtpsCurrentMonth;
	}
	public String getPiFtpsNextMonth() {
		return piFtpsNextMonth;
	}
	public void setPiFtpsNextMonth(String piFtpsNextMonth) {
		this.piFtpsNextMonth = piFtpsNextMonth;
	}
	public String getPiCrs() {
		return piCrs;
	}
	public void setPiCrs(String piCrs) {
		this.piCrs = piCrs;
	}
	public String getPiSe() {
		return piSe;
	}
	public void setPiSe(String piSe) {
		this.piSe = piSe;
	}
	public String getPiIbmPm() {
		return piIbmPm;
	}
	public void setPiIbmPm(String piIbmPm) {
		this.piIbmPm = piIbmPm;
	}
	public String getPiApm() {
		return piApm;
	}
	public void setPiApm(String piApm) {
		this.piApm = piApm;
	}
	public String getScRelease() {
		return scRelease;
	}
	public void setScRelease(String scRelease) {
		this.scRelease = scRelease;
	}
	public String getScTestingTarget() {
		return scTestingTarget;
	}
	public void setScTestingTarget(String scTestingTarget) {
		this.scTestingTarget = scTestingTarget;
	}
	public String getScSprint() {
		return scSprint;
	}
	public void setScSprint(String scSprint) {
		this.scSprint = scSprint;
	}
	public String getScSchedule() {
		return scSchedule;
	}
	public void setScSchedule(String scSchedule) {
		this.scSchedule = scSchedule;
	}
	public String getiType() {
		return iType;
	}
	public void setiType(String iType) {
		this.iType = iType;
	}
	public String getiTube() {
		return iTube;
	}
	public void setiTube(String iTube) {
		this.iTube = iTube;
	}
	public String getiBc() {
		return iBc;
	}
	public void setiBc(String iBc) {
		this.iBc = iBc;
	}
	public String getiInv() {
		return iInv;
	}
	public void setiInv(String iInv) {
		this.iInv = iInv;
	}
	public String getiPi() {
		return iPi;
	}
	public void setiPi(String iPi) {
		this.iPi = iPi;
	}
	public String getReqSrs() {
	    return reqSrs;
	}
	public void setReqSrs(String reqSrs) {
	    this.reqSrs = reqSrs;
	}
	public int getMethodologyId() {
	    return methodologyId;
	}
	public void setMethodologyId(int methodologyId) {
	    this.methodologyId = methodologyId;
	}
	public String getDesHldTubeResource() {
	    return desHldTubeResource;
	}
	public void setDesHldTubeResource(String desHldTubeResource) {
	    this.desHldTubeResource = desHldTubeResource;
	}
	public String getDesHldTubePlanned() {
	    return desHldTubePlanned;
	}
	public void setDesHldTubePlanned(String desHldTubePlanned) {
	    this.desHldTubePlanned = desHldTubePlanned;
	}
	public String getDesHldBcResource() {
	    return desHldBcResource;
	}
	public void setDesHldBcResource(String desHldBcResource) {
	    this.desHldBcResource = desHldBcResource;
	}
	public String getDesHldBcPlanned() {
	    return desHldBcPlanned;
	}
	public void setDesHldBcPlanned(String desHldBcPlanned) {
	    this.desHldBcPlanned = desHldBcPlanned;
	}
	public String getDesHldinvResource() {
	    return desHldinvResource;
	}
	public void setDesHldinvResource(String desHldinvResource) {
	    this.desHldinvResource = desHldinvResource;
	}
	public String getDesHldinvPlanned() {
	    return desHldinvPlanned;
	}
	public void setDesHldinvPlanned(String desHldinvPlanned) {
	    this.desHldinvPlanned = desHldinvPlanned;
	}
	public String getDesHldPiResource() {
	    return desHldPiResource;
	}
	public void setDesHldPiResource(String desHldPiResource) {
	    this.desHldPiResource = desHldPiResource;
	}
	public String getDesHldPiPlanned() {
	    return desHldPiPlanned;
	}
	public void setDesHldPiPlanned(String desHldPiPlanned) {
	    this.desHldPiPlanned = desHldPiPlanned;
	}
	public String getDesIaIaResource() {
	    return desIaIaResource;
	}
	public void setDesIaIaResource(String desIaIaResource) {
	    this.desIaIaResource = desIaIaResource;
	}
	public String getDesIaIaPlanned() {
	    return desIaIaPlanned;
	}
	public void setDesIaIaPlanned(String desIaIaPlanned) {
	    this.desIaIaPlanned = desIaIaPlanned;
	}
	public String getDesAdTubeResource() {
	    return desAdTubeResource;
	}
	public void setDesAdTubeResource(String desAdTubeResource) {
	    this.desAdTubeResource = desAdTubeResource;
	}
	public String getDesAdTubePlanned() {
	    return desAdTubePlanned;
	}
	public void setDesAdTubePlanned(String desAdTubePlanned) {
	    this.desAdTubePlanned = desAdTubePlanned;
	}
	public String getDesAdBcResource() {
	    return desAdBcResource;
	}
	public void setDesAdBcResource(String desAdBcResource) {
	    this.desAdBcResource = desAdBcResource;
	}
	public String getDesAdBcPlanned() {
	    return desAdBcPlanned;
	}
	public void setDesAdBcPlanned(String desAdBcPlanned) {
	    this.desAdBcPlanned = desAdBcPlanned;
	}
	public String getDesAdinvResource() {
	    return desAdinvResource;
	}
	public void setDesAdinvResource(String desAdinvResource) {
	    this.desAdinvResource = desAdinvResource;
	}
	public String getDesAdinvPlanned() {
	    return desAdinvPlanned;
	}
	public void setDesAdinvPlanned(String desAdinvPlanned) {
	    this.desAdinvPlanned = desAdinvPlanned;
	}
	public String getDesCwPiResource() {
	    return desCwPiResource;
	}
	public void setDesCwPiResource(String desCwPiResource) {
	    this.desCwPiResource = desCwPiResource;
	}
	public String getDesCwPiPlanned() {
	    return desCwPiPlanned;
	}
	public void setDesCwPiPlanned(String desCwPiPlanned) {
	    this.desCwPiPlanned = desCwPiPlanned;
	}
	public String getDevUtdTubeResource() {
	    return devUtdTubeResource;
	}
	public void setDevUtdTubeResource(String devUtdTubeResource) {
	    this.devUtdTubeResource = devUtdTubeResource;
	}
	public String getDevUtdTubePlanned() {
	    return devUtdTubePlanned;
	}
	public void setDevUtdTubePlanned(String devUtdTubePlanned) {
	    this.devUtdTubePlanned = devUtdTubePlanned;
	}
	public String getDevUtdBcResource() {
	    return devUtdBcResource;
	}
	public void setDevUtdBcResource(String devUtdBcResource) {
	    this.devUtdBcResource = devUtdBcResource;
	}
	public String getDevUtdBcPlanned() {
	    return devUtdBcPlanned;
	}
	public void setDevUtdBcPlanned(String devUtdBcPlanned) {
	    this.devUtdBcPlanned = devUtdBcPlanned;
	}
	public String getDevUtdInvResource() {
	    return devUtdInvResource;
	}
	public void setDevUtdInvResource(String devUtdInvResource) {
	    this.devUtdInvResource = devUtdInvResource;
	}
	public String getDevUtdInvPlanned() {
	    return devUtdInvPlanned;
	}
	public void setDevUtdInvPlanned(String devUtdInvPlanned) {
	    this.devUtdInvPlanned = devUtdInvPlanned;
	}
	public String getDevStdStsrResource() {
	    return devStdStsrResource;
	}
	public void setDevStdStsrResource(String devStdStsrResource) {
	    this.devStdStsrResource = devStdStsrResource;
	}
	public String getDevStdStsrPlanned() {
	    return devStdStsrPlanned;
	}
	public void setDevStdStsrPlanned(String devStdStsrPlanned) {
	    this.devStdStsrPlanned = devStdStsrPlanned;
	}
	public String getDevStdTestDataResource() {
	    return devStdTestDataResource;
	}
	public void setDevStdTestDataResource(String devStdTestDataResource) {
	    this.devStdTestDataResource = devStdTestDataResource;
	}
	public String getDevStdTestDataPlanned() {
	    return devStdTestDataPlanned;
	}
	public void setDevStdTestDataPlanned(String devStdTestDataPlanned) {
	    this.devStdTestDataPlanned = devStdTestDataPlanned;
	}
	public String getDevTapPiResource() {
	    return devTapPiResource;
	}
	public void setDevTapPiResource(String devTapPiResource) {
	    this.devTapPiResource = devTapPiResource;
	}
	public String getDevTapPiPlanned() {
	    return devTapPiPlanned;
	}
	public void setDevTapPiPlanned(String devTapPiPlanned) {
	    this.devTapPiPlanned = devTapPiPlanned;
	}
	public String getDevCodeTubeResource() {
	    return devCodeTubeResource;
	}
	public void setDevCodeTubeResource(String devCodeTubeResource) {
	    this.devCodeTubeResource = devCodeTubeResource;
	}
	public String getDevCodeTubePlanned() {
	    return devCodeTubePlanned;
	}
	public void setDevCodeTubePlanned(String devCodeTubePlanned) {
	    this.devCodeTubePlanned = devCodeTubePlanned;
	}
	public String getDevCodeBcResource() {
	    return devCodeBcResource;
	}
	public void setDevCodeBcResource(String devCodeBcResource) {
	    this.devCodeBcResource = devCodeBcResource;
	}
	public String getDevCodeBcPlanned() {
	    return devCodeBcPlanned;
	}
	public void setDevCodeBcPlanned(String devCodeBcPlanned) {
	    this.devCodeBcPlanned = devCodeBcPlanned;
	}
	public String getDevCodeInvResource() {
	    return devCodeInvResource;
	}
	public void setDevCodeInvResource(String devCodeInvResource) {
	    this.devCodeInvResource = devCodeInvResource;
	}
	public String getDevCodeInvPlanned() {
	    return devCodeInvPlanned;
	}
	public void setDevCodeInvPlanned(String devCodeInvPlanned) {
	    this.devCodeInvPlanned = devCodeInvPlanned;
	}
	public String getDevUtTubeResource() {
	    return devUtTubeResource;
	}
	public void setDevUtTubeResource(String devUtTubeResource) {
	    this.devUtTubeResource = devUtTubeResource;
	}
	public String getDevUtTubePlanned() {
	    return devUtTubePlanned;
	}
	public void setDevUtTubePlanned(String devUtTubePlanned) {
	    this.devUtTubePlanned = devUtTubePlanned;
	}
	public String getDevUtBcResource() {
	    return devUtBcResource;
	}
	public void setDevUtBcResource(String devUtBcResource) {
	    this.devUtBcResource = devUtBcResource;
	}
	public String getDevUtBcPlanned() {
	    return devUtBcPlanned;
	}
	public void setDevUtBcPlanned(String devUtBcPlanned) {
	    this.devUtBcPlanned = devUtBcPlanned;
	}
	public String getDevUtInvResource() {
	    return devUtInvResource;
	}
	public void setDevUtInvResource(String devUtInvResource) {
	    this.devUtInvResource = devUtInvResource;
	}
	public String getDevUtInvPlanned() {
	    return devUtInvPlanned;
	}
	public void setDevUtInvPlanned(String devUtInvPlanned) {
	    this.devUtInvPlanned = devUtInvPlanned;
	}
	public String getManagerNameLabel() {
	    return managerNameLabel;
	}
	public void setManagerNameLabel(String managerNameLabel) {
	    this.managerNameLabel = managerNameLabel;
	}
	public String getManagerIdLabel() {
	    return managerIdLabel;
	}
	public void setManagerIdLabel(String managerIdLabel) {
	    this.managerIdLabel = managerIdLabel;
	}
	public String getApplicationLabel() {
	    return applicationLabel;
	}
	public void setApplicationLabel(String applicationLabel) {
	    this.applicationLabel = applicationLabel;
	}
	public String getProjectIdLabel() {
	    return projectIdLabel;
	}
	public void setProjectIdLabel(String projectIdLabel) {
	    this.projectIdLabel = projectIdLabel;
	}
	public String getProjectNameLabel() {
	    return projectNameLabel;
	}
	public void setProjectNameLabel(String projectNameLabel) {
	    this.projectNameLabel = projectNameLabel;
	}
	public String getProjectStateLabel() {
	    return projectStateLabel;
	}
	public void setProjectStateLabel(String projectStateLabel) {
	    this.projectStateLabel = projectStateLabel;
	}
	public String getSdlcLabel() {
	    return sdlcLabel;
	}
	public void setSdlcLabel(String sdlcLabel) {
	    this.sdlcLabel = sdlcLabel;
	}
	public String getProjectStatusLabel() {
	    return projectStatusLabel;
	}
	public void setProjectStatusLabel(String projectStatusLabel) {
	    this.projectStatusLabel = projectStatusLabel;
	}
	public String getIssueLabel() {
	    return issueLabel;
	}
	public void setIssueLabel(String issueLabel) {
	    this.issueLabel = issueLabel;
	}
	public String getCommentsLabel() {
	    return commentsLabel;
	}
	public void setCommentsLabel(String commentsLabel) {
	    this.commentsLabel = commentsLabel;
	}
	public String getJeopardyListLabel() {
	    return jeopardyListLabel;
	}
	public void setJeopardyListLabel(String jeopardyListLabel) {
	    this.jeopardyListLabel = jeopardyListLabel;
	}
	public String getPiFtpsLabel() {
	    return piFtpsLabel;
	}
	public void setPiFtpsLabel(String piFtpsLabel) {
	    this.piFtpsLabel = piFtpsLabel;
	}
	public String getPiFtpsCurrentMonthLabel() {
	    return piFtpsCurrentMonthLabel;
	}
	public void setPiFtpsCurrentMonthLabel(String piFtpsCurrentMonthLabel) {
	    this.piFtpsCurrentMonthLabel = piFtpsCurrentMonthLabel;
	}
	public String getPiFtpsNextMonthLabel() {
	    return piFtpsNextMonthLabel;
	}
	public void setPiFtpsNextMonthLabel(String piFtpsNextMonthLabel) {
	    this.piFtpsNextMonthLabel = piFtpsNextMonthLabel;
	}
	public String getPiCrsLabel() {
	    return piCrsLabel;
	}
	public void setPiCrsLabel(String piCrsLabel) {
	    this.piCrsLabel = piCrsLabel;
	}
	public String getPiSeLabel() {
	    return piSeLabel;
	}
	public void setPiSeLabel(String piSeLabel) {
	    this.piSeLabel = piSeLabel;
	}
	public String getPiIbmPmLabel() {
	    return piIbmPmLabel;
	}
	public void setPiIbmPmLabel(String piIbmPmLabel) {
	    this.piIbmPmLabel = piIbmPmLabel;
	}
	public String getPiApmLabel() {
	    return piApmLabel;
	}
	public void setPiApmLabel(String piApmLabel) {
	    this.piApmLabel = piApmLabel;
	}
	public String getScReleaseLabel() {
	    return scReleaseLabel;
	}
	public void setScReleaseLabel(String scReleaseLabel) {
	    this.scReleaseLabel = scReleaseLabel;
	}
	public String getScTestingTargetLabel() {
	    return scTestingTargetLabel;
	}
	public void setScTestingTargetLabel(String scTestingTargetLabel) {
	    this.scTestingTargetLabel = scTestingTargetLabel;
	}
	public String getScSprintLabel() {
	    return scSprintLabel;
	}
	public void setScSprintLabel(String scSprintLabel) {
	    this.scSprintLabel = scSprintLabel;
	}
	public String getScScheduleLabel() {
	    return scScheduleLabel;
	}
	public void setScScheduleLabel(String scScheduleLabel) {
	    this.scScheduleLabel = scScheduleLabel;
	}
	public String getiTypeLabel() {
	    return iTypeLabel;
	}
	public void setiTypeLabel(String iTypeLabel) {
	    this.iTypeLabel = iTypeLabel;
	}
	public String getiTubeLabel() {
	    return iTubeLabel;
	}
	public void setiTubeLabel(String iTubeLabel) {
	    this.iTubeLabel = iTubeLabel;
	}
	public String getiBcLabel() {
	    return iBcLabel;
	}
	public void setiBcLabel(String iBcLabel) {
	    this.iBcLabel = iBcLabel;
	}
	public String getiInvLabel() {
	    return iInvLabel;
	}
	public void setiInvLabel(String iInvLabel) {
	    this.iInvLabel = iInvLabel;
	}
	public String getiPiLabel() {
	    return iPiLabel;
	}
	public void setiPiLabel(String iPiLabel) {
	    this.iPiLabel = iPiLabel;
	}
	public String getDesHldTubeResourceLabel() {
	    return desHldTubeResourceLabel;
	}
	public void setDesHldTubeResourceLabel(String desHldTubeResourceLabel) {
	    this.desHldTubeResourceLabel = desHldTubeResourceLabel;
	}
	public String getDesHldTubePlannedLabel() {
	    return desHldTubePlannedLabel;
	}
	public void setDesHldTubePlannedLabel(String desHldTubePlannedLabel) {
	    this.desHldTubePlannedLabel = desHldTubePlannedLabel;
	}
	public String getDesHldBcResourceLabel() {
	    return desHldBcResourceLabel;
	}
	public void setDesHldBcResourceLabel(String desHldBcResourceLabel) {
	    this.desHldBcResourceLabel = desHldBcResourceLabel;
	}
	public String getDesHldBcPlannedLabel() {
	    return desHldBcPlannedLabel;
	}
	public void setDesHldBcPlannedLabel(String desHldBcPlannedLabel) {
	    this.desHldBcPlannedLabel = desHldBcPlannedLabel;
	}
	public String getDesHldinvResourceLabel() {
	    return desHldinvResourceLabel;
	}
	public void setDesHldinvResourceLabel(String desHldinvResourceLabel) {
	    this.desHldinvResourceLabel = desHldinvResourceLabel;
	}
	public String getDesHldinvPlannedLabel() {
	    return desHldinvPlannedLabel;
	}
	public void setDesHldinvPlannedLabel(String desHldinvPlannedLabel) {
	    this.desHldinvPlannedLabel = desHldinvPlannedLabel;
	}
	public String getDesHldPiResourceLabel() {
	    return desHldPiResourceLabel;
	}
	public void setDesHldPiResourceLabel(String desHldPiResourceLabel) {
	    this.desHldPiResourceLabel = desHldPiResourceLabel;
	}
	public String getDesHldPiPlannedLabel() {
	    return desHldPiPlannedLabel;
	}
	public void setDesHldPiPlannedLabel(String desHldPiPlannedLabel) {
	    this.desHldPiPlannedLabel = desHldPiPlannedLabel;
	}
	public String getDesIaIaResourceLabel() {
	    return desIaIaResourceLabel;
	}
	public void setDesIaIaResourceLabel(String desIaIaResourceLabel) {
	    this.desIaIaResourceLabel = desIaIaResourceLabel;
	}
	public String getDesIaIaDueDateLabel() {
	    return desIaIaDueDateLabel;
	}
	public void setDesIaIaDueDateLabel(String desIaIaDueDateLabel) {
	    this.desIaIaDueDateLabel = desIaIaDueDateLabel;
	}
	public String getDesIaIaPlannedLabel() {
	    return desIaIaPlannedLabel;
	}
	public void setDesIaIaPlannedLabel(String desIaIaPlannedLabel) {
	    this.desIaIaPlannedLabel = desIaIaPlannedLabel;
	}
	public String getDesAdTubeResourceLabel() {
	    return desAdTubeResourceLabel;
	}
	public void setDesAdTubeResourceLabel(String desAdTubeResourceLabel) {
	    this.desAdTubeResourceLabel = desAdTubeResourceLabel;
	}
	public String getDesAdTubePlannedLabel() {
	    return desAdTubePlannedLabel;
	}
	public void setDesAdTubePlannedLabel(String desAdTubePlannedLabel) {
	    this.desAdTubePlannedLabel = desAdTubePlannedLabel;
	}
	public String getDesAdBcResourceLabel() {
	    return desAdBcResourceLabel;
	}
	public void setDesAdBcResourceLabel(String desAdBcResourceLabel) {
	    this.desAdBcResourceLabel = desAdBcResourceLabel;
	}
	public String getDesAdBcPlannedLabel() {
	    return desAdBcPlannedLabel;
	}
	public void setDesAdBcPlannedLabel(String desAdBcPlannedLabel) {
	    this.desAdBcPlannedLabel = desAdBcPlannedLabel;
	}
	public String getDesAdinvResourceLabel() {
	    return desAdinvResourceLabel;
	}
	public void setDesAdinvResourceLabel(String desAdinvResourceLabel) {
	    this.desAdinvResourceLabel = desAdinvResourceLabel;
	}
	public String getDesAdinvPlannedLabel() {
	    return desAdinvPlannedLabel;
	}
	public void setDesAdinvPlannedLabel(String desAdinvPlannedLabel) {
	    this.desAdinvPlannedLabel = desAdinvPlannedLabel;
	}
	public String getDesCwPiResourceLabel() {
	    return desCwPiResourceLabel;
	}
	public void setDesCwPiResourceLabel(String desCwPiResourceLabel) {
	    this.desCwPiResourceLabel = desCwPiResourceLabel;
	}
	public String getDesCwPiPlannedLabel() {
	    return desCwPiPlannedLabel;
	}
	public void setDesCwPiPlannedLabel(String desCwPiPlannedLabel) {
	    this.desCwPiPlannedLabel = desCwPiPlannedLabel;
	}
	public String getDevUtdTubeResourceLabel() {
	    return devUtdTubeResourceLabel;
	}
	public void setDevUtdTubeResourceLabel(String devUtdTubeResourceLabel) {
	    this.devUtdTubeResourceLabel = devUtdTubeResourceLabel;
	}
	public String getDevUtdTubePlannedLabel() {
	    return devUtdTubePlannedLabel;
	}
	public void setDevUtdTubePlannedLabel(String devUtdTubePlannedLabel) {
	    this.devUtdTubePlannedLabel = devUtdTubePlannedLabel;
	}
	public String getDevUtdBcResourceLabel() {
	    return devUtdBcResourceLabel;
	}
	public void setDevUtdBcResourceLabel(String devUtdBcResourceLabel) {
	    this.devUtdBcResourceLabel = devUtdBcResourceLabel;
	}
	public String getDevUtdBcPlannedLabel() {
	    return devUtdBcPlannedLabel;
	}
	public void setDevUtdBcPlannedLabel(String devUtdBcPlannedLabel) {
	    this.devUtdBcPlannedLabel = devUtdBcPlannedLabel;
	}
	public String getDevUtdInvResourceLabel() {
	    return devUtdInvResourceLabel;
	}
	public void setDevUtdInvResourceLabel(String devUtdInvResourceLabel) {
	    this.devUtdInvResourceLabel = devUtdInvResourceLabel;
	}
	public String getDevUtdInvPlannedLabel() {
	    return devUtdInvPlannedLabel;
	}
	public void setDevUtdInvPlannedLabel(String devUtdInvPlannedLabel) {
	    this.devUtdInvPlannedLabel = devUtdInvPlannedLabel;
	}
	public String getDevStdStsrResourceLabel() {
	    return devStdStsrResourceLabel;
	}
	public void setDevStdStsrResourceLabel(String devStdStsrResourceLabel) {
	    this.devStdStsrResourceLabel = devStdStsrResourceLabel;
	}
	public String getDevStdStsrPlannedLabel() {
	    return devStdStsrPlannedLabel;
	}
	public void setDevStdStsrPlannedLabel(String devStdStsrPlannedLabel) {
	    this.devStdStsrPlannedLabel = devStdStsrPlannedLabel;
	}
	public String getDevStdTestDataResourceLabel() {
	    return devStdTestDataResourceLabel;
	}
	public void setDevStdTestDataResourceLabel(String devStdTestDataResourceLabel) {
	    this.devStdTestDataResourceLabel = devStdTestDataResourceLabel;
	}
	public String getDevStdTestDataPlannedLabel() {
	    return devStdTestDataPlannedLabel;
	}
	public void setDevStdTestDataPlannedLabel(String devStdTestDataPlannedLabel) {
	    this.devStdTestDataPlannedLabel = devStdTestDataPlannedLabel;
	}
	public String getDevTapPiResourceLabel() {
	    return devTapPiResourceLabel;
	}
	public void setDevTapPiResourceLabel(String devTapPiResourceLabel) {
	    this.devTapPiResourceLabel = devTapPiResourceLabel;
	}
	public String getDevTapPiPlannedLabel() {
	    return devTapPiPlannedLabel;
	}
	public void setDevTapPiPlannedLabel(String devTapPiPlannedLabel) {
	    this.devTapPiPlannedLabel = devTapPiPlannedLabel;
	}
	public String getDevCodeTubeResourceLabel() {
	    return devCodeTubeResourceLabel;
	}
	public void setDevCodeTubeResourceLabel(String devCodeTubeResourceLabel) {
	    this.devCodeTubeResourceLabel = devCodeTubeResourceLabel;
	}
	public String getDevCodeTubePlannedLabel() {
	    return devCodeTubePlannedLabel;
	}
	public void setDevCodeTubePlannedLabel(String devCodeTubePlannedLabel) {
	    this.devCodeTubePlannedLabel = devCodeTubePlannedLabel;
	}
	public String getDevCodeBcResourceLabel() {
	    return devCodeBcResourceLabel;
	}
	public void setDevCodeBcResourceLabel(String devCodeBcResourceLabel) {
	    this.devCodeBcResourceLabel = devCodeBcResourceLabel;
	}
	public String getDevCodeBcPlannedLabel() {
	    return devCodeBcPlannedLabel;
	}
	public void setDevCodeBcPlannedLabel(String devCodeBcPlannedLabel) {
	    this.devCodeBcPlannedLabel = devCodeBcPlannedLabel;
	}
	public String getDevCodeInvResourceLabel() {
	    return devCodeInvResourceLabel;
	}
	public void setDevCodeInvResourceLabel(String devCodeInvResourceLabel) {
	    this.devCodeInvResourceLabel = devCodeInvResourceLabel;
	}
	public String getDevCodeInvPlannedLabel() {
	    return devCodeInvPlannedLabel;
	}
	public void setDevCodeInvPlannedLabel(String devCodeInvPlannedLabel) {
	    this.devCodeInvPlannedLabel = devCodeInvPlannedLabel;
	}
	public String getDevUtTubeResourceLabel() {
	    return devUtTubeResourceLabel;
	}
	public void setDevUtTubeResourceLabel(String devUtTubeResourceLabel) {
	    this.devUtTubeResourceLabel = devUtTubeResourceLabel;
	}
	public String getDevUtTubePlannedLabel() {
	    return devUtTubePlannedLabel;
	}
	public void setDevUtTubePlannedLabel(String devUtTubePlannedLabel) {
	    this.devUtTubePlannedLabel = devUtTubePlannedLabel;
	}
	public String getDevUtBcResourceLabel() {
	    return devUtBcResourceLabel;
	}
	public void setDevUtBcResourceLabel(String devUtBcResourceLabel) {
	    this.devUtBcResourceLabel = devUtBcResourceLabel;
	}
	public String getDevUtBcPlannedLabel() {
	    return devUtBcPlannedLabel;
	}
	public void setDevUtBcPlannedLabel(String devUtBcPlannedLabel) {
	    this.devUtBcPlannedLabel = devUtBcPlannedLabel;
	}
	public String getDevUtInvResourceLabel() {
	    return devUtInvResourceLabel;
	}
	public void setDevUtInvResourceLabel(String devUtInvResourceLabel) {
	    this.devUtInvResourceLabel = devUtInvResourceLabel;
	}
	public String getDevUtInvPlannedLabel() {
	    return devUtInvPlannedLabel;
	}
	public void setDevUtInvPlannedLabel(String devUtInvPlannedLabel) {
	    this.devUtInvPlannedLabel = devUtInvPlannedLabel;
	}
	
	
}	
	
	
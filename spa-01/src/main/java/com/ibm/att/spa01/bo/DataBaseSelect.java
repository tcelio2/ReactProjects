package com.ibm.att.spa01.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.ibm.att.spa01.bean.TeamLeaderBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bean.UserDashboardBean;
import com.ibm.att.spa01.dao.DashboardDAO;
import com.ibm.att.spa01.dao.DeliverableDAO;
import com.ibm.att.spa01.dao.ScheduleDAO;
import com.ibm.att.spa01.dao.TeamLeaderDAO;
import com.ibm.att.spa01.dao.UsersDAO;
import com.ibm.att.spa01.util.CreateHtml;

public class DataBaseSelect {

    public DataBaseSelect() {

    }

    public Map<String, String> getAllUsersForMAPS() {

	Map<String, String> users = new LinkedHashMap<String, String>();
	//UserBean userBean = null;
	List<UserBean> userBean = new ArrayList<UserBean>();

	UsersDAO userDAO = new UsersDAO();
	userBean = userDAO.selectUsers();

	for (int i = 0; i <= userBean.size() - 1; i++) {
	    users.put(userBean.get(i).getUserName(), userBean.get(i).getRole());
	}

	return users;
    }

    public List<UserDashboardBean> getAllManagersForDashboard() {
	List<UserDashboardBean> udb = new ArrayList<UserDashboardBean>();

	DashboardDAO ddao = new DashboardDAO();
	try {
	    udb = ddao.getAllUserDashboard();
	} catch (Exception e) {
	    e.getStackTrace();
	}

	return udb;
    }

    public StringBuilder getAllUsersForDataTable(){
	
	StringBuilder fullHtml = new StringBuilder();
	List<UserBean> userBean = new ArrayList<UserBean>();
	UsersDAO userDAO = new UsersDAO();
	userBean = userDAO.selectUsers();

	String role = "";
	String row = "";
	fullHtml.append("<table id='example' class='display' width='100%' cellspacing='0'>");
	fullHtml.append("<thead><tr><th>User name</th><th>First name</th><th>Last name</th><th>Role</th><th>E-mail</th><th></th></tr></thead>");
	fullHtml.append("<tbody>");
	    
	for (int i = 0; i <= userBean.size() - 1; i++) {
	    if (i % 2 == 0) {
		row = "odd";
	    } else {
		row = "even";
	    }

	 
	    fullHtml.append("<tr id=" + userBean.get(i).getId() + " class=" + row + " role='row'>"
                                +"<td class='edit_' table='id_user' id=" + userBean.get(i).getId() + " table='"+userBean.get(i).getUserNameLabel()+"'>" + userBean.get(i).getUserName() + "</td>"
                                +"<td class='edit_' table='name' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getName() + "</td>"
                                +"<td class='edit_' table='last_name' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getLastName() + "</td>"
                                +"<td class='edit_' table='user_role_id_role' id=" + userBean.get(i).getId() + " role_id='"+userBean.get(i).getRoleId()+"'>" + userBean.get(i).getRole() + "</td>"
                                +"<td class='edit_' table='email' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getEmail() + "</td>"
                               
                                +"<td><input id=" + userBean.get(i).getId() + " class='delete_' type='submit' value='delete'></td>"
                            +"</tr>");
	    
	    
	    
	    
	//    fullHtml.append("</select></td>" + "<td><a href='#' class='admin_save edit_admin' id=" + userBean.get(i).getId() + ">edit</a> <a href='#' id=" + userBean.get(i).getId() + " class='admin_update'>update</a>" + "<a href='#' id="
	//	    + userBean.get(i).getId() + " class='admin_delete delete'>x</a></td>" + "</tr>");

	    //<img src='img/loader2.gif'/>
	    //fullHtml2 += "<h3>"+userBean.get(i).getUserName()+" - "+userBean.get(i).getRole()+"</h3>";
	}
	fullHtml.append("</tbody></table>");
	return fullHtml;
	
	
	
    }
    
    public StringBuilder getAllUsersForChangeProjects(){
	
  	StringBuilder fullHtml = new StringBuilder();
  	List<UserBean> userBean = new ArrayList<UserBean>();
  	UsersDAO userDAO = new UsersDAO();
  	userBean = userDAO.selectUsersForDataTable();

  	String role = "";
  	String row = "";
//  	fullHtml.append("<table id='example' class='display' width='100%' cellspacing='0'>");
//  	fullHtml.append("<thead><tr><th>User name</th><th>First name</th><th>Last name</th><th>Role</th><th>E-mail</th><th></th></tr></thead>");
//  	fullHtml.append("<tbody>");
  	
  	fullHtml.append("<option name='' last_name='' class=''></option>");
  	for (int i = 0; i <= userBean.size() - 1; i++) {
  	    if (i % 2 == 0) {
  		row = "odd";
  	    } else {
  		row = "even";
  	    }
  	  fullHtml.append("<option name="+userBean.get(i).getName()+" last_name="+userBean.get(i).getLastName()+" class='"+userBean.get(i).getId()+"'>" + userBean.get(i).getName()+" "+userBean.get(i).getLastName()+"</option>");
  	 
//  	    fullHtml.append("<tr id=" + userBean.get(i).getId() + " class=" + row + " role='row'>"
//                                  +"<td class='edit_' table='id_user' id=" + userBean.get(i).getId() + " table='"+userBean.get(i).getUserNameLabel()+"'>" + userBean.get(i).getUserName() + "</td>"
//                                  +"<td class='edit_' table='name' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getName() + "</td>"
//                                  +"<td class='edit_' table='last_name' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getLastName() + "</td>"
//                                  +"<td class='edit_' table='user_role_id_role' id=" + userBean.get(i).getId() + " role_id='"+userBean.get(i).getRoleId()+"'>" + userBean.get(i).getRole() + "</td>"
//                                  +"<td class='edit_' table='email' id=" + userBean.get(i).getId() + ">" + userBean.get(i).getEmail() + "</td>"
//                                 
//                                  +"<td><input id=" + userBean.get(i).getId() + " class='delete_' type='submit' value='delete'></td>"
//                              +"</tr>");
  	    
  	    
  	    
  	    
  	//    fullHtml.append("</select></td>" + "<td><a href='#' class='admin_save edit_admin' id=" + userBean.get(i).getId() + ">edit</a> <a href='#' id=" + userBean.get(i).getId() + " class='admin_update'>update</a>" + "<a href='#' id="
  	//	    + userBean.get(i).getId() + " class='admin_delete delete'>x</a></td>" + "</tr>");

  	    //<img src='img/loader2.gif'/>
  	    //fullHtml2 += "<h3>"+userBean.get(i).getUserName()+" - "+userBean.get(i).getRole()+"</h3>";
  	}
  	//fullHtml.append("</tbody></table>");
  	return fullHtml;
  	
  	
  	
      }
      
    
public StringBuilder getAllProjectsDataTable(){
	
	StringBuilder fullHtml = new StringBuilder();
	List<DashboardBean> dbBean = new ArrayList<DashboardBean>();
	DashboardDAO dbDAO = new DashboardDAO();
	dbBean = dbDAO.selectAllprojects();

	String role = "";
	String row = "";
	fullHtml.append("<table id='example2' class='display' width='100%' cellspacing='0'>");
	fullHtml.append("<thead><tr><th>Project ID</th><th>Project name</th><th>Methodology</th><th>Application</th><th></th><th></th></tr></thead>");
	fullHtml.append("<tbody>");
	    
	for (int i = 0; i <= dbBean.size() - 1; i++) {
	    if (i % 2 == 0) {
		row = "odd";
	    } else {
		row = "even";
	    }

	 
	    fullHtml.append("<tr id=" + dbBean.get(i).getDashboardId() + " class=" + row + " role='row'>"
                    +"<td class='" + dbBean.get(i).getProjectId() + "' table='project_id' id=" + dbBean.get(i).getProjectId() + " table=''>" + dbBean.get(i).getProjectId() + "</td>"
                    +"<td class='" + dbBean.get(i).getProjectName() + "' table='project_name' id=" + dbBean.get(i).getProjectName() + ">" + dbBean.get(i).getProjectName() + "</td>"
                    +"<td class='" + dbBean.get(i).getMethodology() + "' table='methodology' id=" + dbBean.get(i).getMethodology() + ">" + dbBean.get(i).getMethodology() + "</td>"
                    +"<td class='" + dbBean.get(i).getApplication() + "' table='application' id=" + dbBean.get(i).getApplication() + ">" + dbBean.get(i).getApplication() + "</td>"
                   
                    +"<td><input id=" + dbBean.get(i).getDashboardId() + " class='delete_project' type='submit' value='delete'></td>"
                +"</tr>");
	}
	fullHtml.append("</tbody></table>");
	return fullHtml;
    }
    

    public StringBuilder getAllProjectsAndUsersDataTable() {

	StringBuilder fullHtml = new StringBuilder();
	List<DashboardBean> dbBean = new ArrayList<DashboardBean>();
	DashboardDAO dbDAO = new DashboardDAO();
	dbBean = dbDAO.selectAllprojectsAndManagers();

	String role = "";
	String row = "";
	fullHtml.append("<table id='example3' class='display' width='100%' cellspacing='0'>");
	fullHtml.append("<thead><tr><th>Project ID</th><th>Project name</th><th>Manager Name</th><th>Last Name</th><th></th><th></th></tr></thead>");
	fullHtml.append("<tbody>");

	for (int i = 0; i <= dbBean.size() - 1; i++) {
	    if (i % 2 == 0) {
		row = "odd";
	    } else {
		row = "even";
	    }

	    fullHtml.append("<tr background-color='#e7eaef' id=" + dbBean.get(i).getDashboardId() + " class=" + row + " role='row'>" 
		    + "<td class='" + dbBean.get(i).getProjectId() + "' table='project_id' id=" + dbBean.get(i).getProjectId() + " table=''>"+ dbBean.get(i).getProjectId() + "</td>"
		    + "<td class='" + dbBean.get(i).getProjectName() + "' table='project_name' id=" + dbBean.get(i).getProjectName() + ">"+ dbBean.get(i).getProjectName() + "</td>"
		    + "<td class='" + dbBean.get(i).getManagerUserName() + "' table='name' id=" + dbBean.get(i).getManagerUserName() + ">"+ dbBean.get(i).getManagerUserName() + "</td>" 
		    + "<td class='" + dbBean.get(i).getLastName() + "' table='last_name' id=" + dbBean.get(i).getLastName() + ">"+ dbBean.get(i).getLastName() + "</td>" 

		    + "<td><input project_name='"+ dbBean.get(i).getProjectName() +"' project_id='"+ dbBean.get(i).getProjectId() +"' user_id='"+ dbBean.get(i).getUserProjectId() +"' id='" + dbBean.get(i).getDashboardId() + "' class='change_manager' type='submit' value='Change'></td>" + "</tr>");
	}
	fullHtml.append("</tbody></table>");
	return fullHtml;
    }



    public StringBuilder getAllUsers() {

	StringBuilder fullHtml = new StringBuilder();
	List<UserBean> userBean = new ArrayList<UserBean>();

	UsersDAO userDAO = new UsersDAO();
	userBean = userDAO.selectUsers();

	String role = "";
	String row = "";

	for (int i = 0; i <= userBean.size() - 1; i++) {
	    if (i % 2 == 0) {
		row = "odd";
	    } else {
		row = "even";
	    }

	    fullHtml.append("<tr id=" + userBean.get(i).getId() + " class=" + row + " role='row' name='" + userBean.get(i).getUserName() + "' email='' role=''>" + "<td  class='name' >" + userBean.get(i).getUserName() + "</td>"
		    + "<td class='email'><input id='row-4-age' class='email' name='row-4-age' value='" + userBean.get(i).getEmail() + "' type='text' disabled ></td>" + "<td class='group'><input id='row-4-position' name='row-4-position' value='"
		    + userBean.get(i).getUserName() + "' type='text' disabled ></td>" + "<td class='role'><select size='1' id='row-4-office' class='role' name='row-4-office' disabled >");

	    if (userBean.get(i).getRole().matches("MANAGER")) {
		fullHtml.append("<option value='" + userBean.get(i).getRole() + "' selected='selected'>" + userBean.get(i).getRole() + "</option>");
	    } else {
		fullHtml.append("<option value='MANAGER' >MANAGER</option>");
	    }

	    if (userBean.get(i).getRole().matches("TEAM LEADER")) {
		fullHtml.append("<option value='" + userBean.get(i).getRole() + "' selected='selected'>" + userBean.get(i).getRole() + "</option>");
	    } else {
		fullHtml.append("<option value='TEAM LEADER' >TEAM LEADER</option>");
	    }
	    if (userBean.get(i).getRole().matches("DEVELOPER")) {
		fullHtml.append("<option value='" + userBean.get(i).getRole() + "' selected='selected'>" + userBean.get(i).getRole() + "</option>");
	    } else {
		fullHtml.append("<option value='DEVELOPER' >DEVELOPER</option>");
	    }
	    if (userBean.get(i).getRole().matches("ADMIN")) {
		fullHtml.append("<option value='" + userBean.get(i).getRole() + "' selected='selected'>" + userBean.get(i).getRole() + "</option>");
	    } else {
		fullHtml.append("<option value='ADMIN' >ADMIN</option>");
	    }

	    fullHtml.append("</select></td>" + "<td><a href='#' class='admin_save edit_admin' id=" + userBean.get(i).getId() + ">edit</a> <a href='#' id=" + userBean.get(i).getId() + " class='admin_update'>update</a>" + "<a href='#' id="
		    + userBean.get(i).getId() + " class='admin_delete delete'>x</a></td>" + "</tr>");

	    //<img src='img/loader2.gif'/>
	    //fullHtml2 += "<h3>"+userBean.get(i).getUserName()+" - "+userBean.get(i).getRole()+"</h3>";
	}

	return fullHtml;

    }

    public List<DeliverableBean> getAllDeliverables(int userId) {

	List<DeliverableBean> db = new ArrayList<DeliverableBean>();
	try{
	    DeliverableDAO dDAO = new DeliverableDAO();
		db = dDAO.selectDeliverable(userId);
		
	}catch(Exception ex){
	    System.out.println(ex.getMessage()+"<<-");
	}
	return db;

    }

    public String getAllSchedules(int idUser) {
    	List<ScheduleBean> sb = new ArrayList<ScheduleBean>();
    	  String scheduleStr = "";
    	try {
    	    ScheduleDAO sdao = new ScheduleDAO();
     	    sb = sdao.selectSchedule(idUser);
     	    int num = sb.size() - 1;
     	    System.out.println("numero antes do while: "+num);
     	    while(num >= 0){
     		
     		if(!sb.get(num).getHldStartDate().matches("EMPTY")){
     		    	System.out.println("EH VAZIO AQUI NO HLD");
         		scheduleStr += "<div class='rTableRow' id='"+sb.get(num).getScheduleId()+"'>"
                		+"<div class='rTableCell d_project_id' id='projectid' style='text-align: left;'>"+sb.get(num).getProjectId()+"</div>"
                		+"<div class='rTableCell d_project_name' id='projectname' style='text-align: left;'>"+sb.get(num).getProjectName()+"</div>"
                		+"<div class='rTableCell d_methodology' id='deliverable' style='text-align: left;'>"+sb.get(num).getDeliverableTitle()+"</div>"
                		+"<div class='rTableCell d_deliverable' id='type'>HLD</div>"
                		+"<div class='rTableCell Edit d_start_date' id='stardate'>"+sb.get(num).getHldStartDate()+"</div>"
                		+"<div class='rTableCell Edit d_end_date' id='enddate'>"+sb.get(num).getHldEndDate()+"</div>"																												
                		+"<div class='rTableCell Edit d_comments' id='comment' style='text-align: left;'>"+sb.get(num).getHldCommnet()+"</div>"	
                		+"<div class='rTableCell'><a class='b_delete' id='"+sb.get(num).getScheduleId()+"'><img alt='' src='img/paper-bin.png'></a></div>"
                	+"</div>";
     		    
     		}
     		if(!sb.get(num).getIaStartDate().matches("EMPTY")){
     		    	System.out.println("EH VAZIO AQUI NO IA");
         		scheduleStr += "<div class='rTableRow' id='"+sb.get(num).getScheduleId()+"'>"
                		+"<div class='rTableCell d_project_id' id='projectid' style='text-align: left;'>"+sb.get(num).getProjectId()+"</div>"
                		+"<div class='rTableCell d_project_name' id='projectname' style='text-align: left;'>"+sb.get(num).getProjectName()+"</div>"
                		+"<div class='rTableCell d_methodology' id='deliverable' style='text-align: left;'>"+sb.get(num).getDeliverableTitle()+"</div>"
                		+"<div class='rTableCell d_deliverable' id='type'>IA</div>"
                		+"<div class='rTableCell Edit d_start_date' id='stardate'>"+sb.get(num).getIaStartDate()+"</div>"
                		+"<div class='rTableCell Edit d_end_date' id='enddate'>"+sb.get(num).getIaEndDate()+"</div>"																												
                		+"<div class='rTableCell Edit d_comments' id='comment' style='text-align: left;'>"+sb.get(num).getIaCommnet()+"</div>"	
                		+"<div class='rTableCell'><a class='b_delete' id='"+sb.get(num).getScheduleId()+"'><img alt='' src='img/paper-bin.png'></a></div>"
                	+"</div>";
     		    
     		}
     		if(!sb.get(num).getAdStartDate().matches("EMPTY")){
     		    	System.out.println("EH VAZIO AQUI NO AD");
     		    
         		scheduleStr += "<div class='rTableRow' id='"+sb.get(num).getScheduleId()+"'>"
                		+"<div class='rTableCell d_project_id' id='projectid' style='text-align: left;'>"+sb.get(num).getProjectId()+"</div>"
                		+"<div class='rTableCell d_project_name' id='projectname' style='text-align: left;'>"+sb.get(num).getProjectName()+"</div>"
                		+"<div class='rTableCell d_methodology' id='deliverable' style='text-align: left;'>"+sb.get(num).getDeliverableTitle()+"</div>"
                		+"<div class='rTableCell d_deliverable' id='type'>AD</div>"
                		+"<div class='rTableCell Edit d_start_date' id='stardate'>"+sb.get(num).getAdStartDate()+"</div>"
                		+"<div class='rTableCell Edit d_end_date' id='enddate'>"+sb.get(num).getAdEndDate()+"</div>"																												
                		+"<div class='rTableCell Edit d_comments' id='comment' style='text-align: left;'>"+sb.get(num).getAdComment()+"</div>"	
                		+"<div class='rTableCell'><a class='b_delete' id='"+sb.get(num).getScheduleId()+"'><img alt='' src='img/paper-bin.png'></a></div>"
                	+"</div>";
     		    
     		}
     		if(!sb.get(num).getCwStartDate().matches("EMPTY")){
     		    	System.out.println("EH VAZIO AQUI NO CW");
         		scheduleStr += "<div class='rTableRow' id='"+sb.get(num).getScheduleId()+"'>"
                		+"<div class='rTableCell d_project_id' id='projectid' style='text-align: left;'>"+sb.get(num).getProjectId()+"</div>"
                		+"<div class='rTableCell d_project_name' id='projectname' style='text-align: left;'>"+sb.get(num).getProjectName()+"</div>"
                		+"<div class='rTableCell d_methodology' id='deliverable' style='text-align: left;'>"+sb.get(num).getDeliverableTitle()+"</div>"
                		+"<div class='rTableCell d_deliverable' id='type'>CW</div>"
                		+"<div class='rTableCell Edit d_start_date' id='stardate'>"+sb.get(num).getCwStartDate()+"</div>"
                		+"<div class='rTableCell Edit d_end_date' id='enddate'>"+sb.get(num).getCwEndDate()+"</div>"																												
                		+"<div class='rTableCell Edit d_comments' id='comment' style='text-align: left;'>"+sb.get(num).getCwComment()+"</div>"	
                		+"<div class='rTableCell'><a class='b_delete' id='"+sb.get(num).getScheduleId()+"'><img alt='' src='img/paper-bin.png'></a></div>"
                	+"</div>";
     		    
     		}
     		
     		
     		num = num - 1;
     		System.out.println("numero: "+num);
     	    }
     	   
     	    

    	} catch (Exception ex) {
    	    ex.printStackTrace();
    	}
    	return scheduleStr;
        }
    
    
    public List<DashboardBean> getAllProjects(int userId) {
	List<DashboardBean> sb = new ArrayList<DashboardBean>();
	try {
	    ScheduleDAO sdao = new ScheduleDAO();
	    sb = sdao.getAllProjects(userId);

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return sb;
    }

  
    //    public boolean verifyUser(String user, String password){
    //	boolean verify = false;
    //	UsersDAO ud = new UsersDAO();
    //	UserBean ubean = new UserBean();
    //	ubean = ud.verifyUserLogin(user, password);
    //	
    ////	if(ubean.get){
    ////	    verify = true;
    ////	}
    //	
    //	return verify;
    //    }

    public List<DashboardBean> getAllDashboardsAgil() {

	List<DashboardBean> db = new ArrayList<DashboardBean>();

	DashboardDAO dDAO = new DashboardDAO();
	db = dDAO.selectDashboardAgil();
	return db;

    }

    public List<DashboardBean> getAllDashboardsWaterfall() {

	List<DashboardBean> db = new ArrayList<DashboardBean>();

	DashboardDAO dDAO = new DashboardDAO();
	db = dDAO.selectDashboardWaterfall();
	return db;

    }

    public List<DashboardBean> getAllDashboardsLean() {

	List<DashboardBean> db = new ArrayList<DashboardBean>();

	DashboardDAO dDAO = new DashboardDAO();
	db = dDAO.selectDashboardLean();
	return db;

    }

    public DeliverableBean getOneDeliverable(int id) {
	DeliverableBean db = new DeliverableBean();

	DeliverableDAO ddao = new DeliverableDAO();
	db = ddao.getOnedeliverable(id);

	return db;
    }

    public List<TeamLeaderBean> getAgileTeamLeader() {

	List<TeamLeaderBean> db = new ArrayList<TeamLeaderBean>();

	TeamLeaderDAO dDAO = new TeamLeaderDAO();
	db = dDAO.selectAgileTeamLeader();
	return db;

    }
    
    public List<TeamLeaderBean> getWaterfallTeamLeader() {

	List<TeamLeaderBean> db = new ArrayList<TeamLeaderBean>();

	TeamLeaderDAO dDAO = new TeamLeaderDAO();
	db = dDAO.selectWaterfallTeamLeader();
	return db;

    }
    
    public String getProjectsFromPm(int pm, int userId){
	
                	
                	
	StringBuilder htmlSTBuilder = new StringBuilder();
	StringBuilder htmlSTBuilderTabOne = new StringBuilder();
	StringBuilder htmlSTBuilderTabTwo = new StringBuilder();
	StringBuilder htmlSTBuilderTabThree = new StringBuilder();
	StringBuilder htmlSTBuilderTabFour = new StringBuilder();
	StringBuilder htmlSTBuilderTabFive = new StringBuilder();
	
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	List<DashboardBean> beanList = new ArrayList<DashboardBean>();
	DashboardDAO dbDao = new DashboardDAO();
	//int numProjects
	beanList = dbDao.selectProjectsFromManager(pm);
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	
	try{	    //aqui insere os primeiro valores da primeira tabela
	    
	    	    int num = beanList.size()-1;
	    	    int tabNum = 0;
	    	    String methodologyStr = beanList.get(num).getSdlc();
	    	    String projectManagerName = beanList.get(num).getManagerName();
	    	    String projectManagerLastName = beanList.get(num).getLastName();
	    	    //projectManager = beanList.get(num).getManagerName();
	    	    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManagerName+" "+projectManagerLastName+" - "+methodologyStr+"</legend>");
	    	    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
	    	    
	    	    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
		    int ID_USER = userId;
			
	    	   
       	    while(num >= 0){
       		
       		
       		String edit_ = "";
       		if(beanList.get(num).getUserProjectId() == ID_USER){
       		    edit_ = "edit_";
       		}else{
       		    edit_ = "";
       		}
       			
       		
       		
       		String statusStatus_ =  beanList.get(num).getProjectStatus(); 
       		String statusStatus =  ""; 
       		System.out.println("status 0-"+beanList.get(num).getProjectStatus());
       		if(statusStatus_.matches("Green")){
       		   statusStatus =  "<img style='height:12px' src='img/green_icon.png' />";  
       		}
       		if(statusStatus_.matches("Yellow")){
       		    statusStatus =  "<img style='height:12px' src='img/yellow_icon.png' />";
       		}
       		if(statusStatus_.matches("Red")){
       		    statusStatus =  "<img style='height:12px' src='img/red_icon.png' />";
       		}
   	//	String statusStatus =  "<img style='height:12px' src='img/green_icon.png' />";                            
       		//projectManager = beanList.get(num).getManagerName();
       		System.out.println("passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getSdlc()+"--"+beanList.get(num).getManagerName());
       		//application = beanList.get(num).getApplication();
       		//itens genericos para todas as tabelas
       		 System.out.println(beanList.get(num).getProjectName()+"passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getMethodology());
      		//troca de tabela caso o atual seja diferente do anterior
       		 //Project tab
       		htmlSTBuilderTabOne.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_projectstate' id='"+beanList.get(num).getProjectStateLabel()+"'>"+beanList.get(num).getProjectState()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_sdlc' id='"+beanList.get(num).getSdlcLabel()+"'>"+beanList.get(num).getSdlc()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc status edit_especial_one_ d_projectstatus' id='"+beanList.get(num).getProjectStatusLabel()+"'>"+statusStatus+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_issue' id='"+beanList.get(num).getIssueLabel()+"'>"+beanList.get(num).getIssue()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_comments' id='"+beanList.get(num).getCommentsLabel()+"'>"+beanList.get(num).getComments()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_jeopardylist' id='"+beanList.get(num).getJeopardyListLabel()+"'>"+beanList.get(num).getJeopardyList()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftps' id='"+beanList.get(num).getPiFtpsLabel()+"'>"+beanList.get(num).getPiFtps()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpscurrentmonth' id='"+beanList.get(num).getPiFtpsCurrentMonthLabel()+"'>"+beanList.get(num).getPiFtpsCurrentMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpsnextmonth' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_picrs' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_pise' id='"+beanList.get(num).getPiSeLabel()+"'>"+beanList.get(num).getPiSe()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piibmpm' id='"+beanList.get(num).getPiIbmPmLabel()+"'>"+beanList.get(num).getPiIbmPm()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piapm' id='"+beanList.get(num).getPiApmLabel()+"'>"+beanList.get(num).getPiApm()+"</div>");
                htmlSTBuilderTabOne.append("</div>");
                //Overview Tab
                htmlSTBuilderTabTwo.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell schedule' id='"+beanList.get(num).getScReleaseLabel()+"'>"+beanList.get(num).getScRelease()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstate'id='"+beanList.get(num).getScTestingTargetLabel()+"'>"+beanList.get(num).getScTestingTarget()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_sdlc'id='"+beanList.get(num).getScSprintLabel()+"'>"+beanList.get(num).getScSprint()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstatus'id='"+beanList.get(num).getScScheduleLabel()+"'>"+beanList.get(num).getScSchedule()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_issue'id='"+beanList.get(num).getiTypeLabel()+"'>"+beanList.get(num).getiType()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_comments'id='"+beanList.get(num).getiTubeLabel()+"'>"+beanList.get(num).getiTube()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_jeopardylist'id='"+beanList.get(num).getiBcLabel()+"'>"+beanList.get(num).getiBc()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftps'id='"+beanList.get(num).getiInvLabel()+"'>"+beanList.get(num).getiInv()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftpscurrentmonth'id='"+beanList.get(num).getiPiLabel()+"'>"+beanList.get(num).getiPi()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" requirement  d_piftpsnextmonth'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_picrs'id='"+beanList.get(num).getDesHldLabel()+"'>"+beanList.get(num).getDesHld()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_pise'id='"+beanList.get(num).getDesIaLabel()+"'>"+beanList.get(num).getDesIa()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piibmpm'id='"+beanList.get(num).getDesAdLabel()+"'>"+beanList.get(num).getDesAd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piapm'id='"+beanList.get(num).getDesCwLabel()+"'>"+beanList.get(num).getDesCw()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
                htmlSTBuilderTabTwo.append("</div>");
                //Requirement Tab
                htmlSTBuilderTabThree.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqStatusLabel()+"'>"+beanList.get(num).getReqStatus()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqBaselineDateLabel()+"'>"+beanList.get(num).getReqBaselineDate()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqDueDateLabel()+"'>"+beanList.get(num).getReqDueDate()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqPlannedLabel()+"'>"+beanList.get(num).getReqPlanned()+"</div>");
                htmlSTBuilderTabThree.append("</div>");
                //Design Tab
                htmlSTBuilderTabFour.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel() + "'></div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel() + "'>" + beanList.get(num).getProjectId() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel() + "'>" + beanList.get(num).getProjectName() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesHldLabel() + "'>" + beanList.get(num).getDesHld() + "</div>");
  	    	  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldTubeLabel() + "'>" + beanList.get(num).getDesHldTube() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldBcLabel() + "'>" + beanList.get(num).getDesHldBc() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldinvLabel() + "'>" + beanList.get(num).getDesHldinv() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldPiLabel() + "'>" + beanList.get(num).getDesHldPi() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesIaLabel() + "'>" + beanList.get(num).getDesIa() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesIaIaLabel() + "'>" + beanList.get(num).getDesIaIa() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesAdLabel() + "'>" + beanList.get(num).getDesAd() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdTubeLabel() + "'>" + beanList.get(num).getDesAdTube() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdBcLabel() + "'>" + beanList.get(num).getDesAdBc() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdinvLabel() + "'>" + beanList.get(num).getDesAdinv() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesCwLabel() + "'>" + beanList.get(num).getDesCw() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesCwPiLabel() + "'>" + beanList.get(num).getDesCwPi() + "</div>");
                htmlSTBuilderTabFour.append("<div style='display: table-cell;' class='rTableCell cc design' mode=''><button class='design_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                      
              //::::::::::::::HIDE INFORMATION design:::::::::::::::: 
              //table titles
              htmlSTBuilderTabFour.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow'>");
	        htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("</div>");
		//table values data
		htmlSTBuilderTabFour.append("<div class='rTableRow' tab_especial='tab-04' id='"+beanList.get(num).getDashboardId()+"'>");
		htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubePlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldinvResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiDueDate()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubePlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesAdinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesCwPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("</div>");
	        htmlSTBuilderTabFour.append("</div></div>");
	        //::::::::::::::END OF HIDE INFORMATION design::::::::::::::::
                     
              //DEVELOPMENT
              htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdTubeLabel()+"'>"+beanList.get(num).getDevUtdTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdBcLabel()+"'>"+beanList.get(num).getDevUtdBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdInvLabel()+"'>"+beanList.get(num).getDevUtdInv()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdStsrLabel()+"'>"+beanList.get(num).getDevStdStsr()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdTestDataLabel()+"'>"+beanList.get(num).getDevStdTestData()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevTapPiLabel()+"'>"+beanList.get(num).getDevTapPi()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeTubeLabel()+"'>"+beanList.get(num).getDevCodeTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeBcLabel()+"'>"+beanList.get(num).getDevCodeBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeInvLabel()+"'>"+beanList.get(num).getDevCodeInv()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtTubeLabel()+"'>"+beanList.get(num).getDevUtTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtBcLabel()+"'>"+beanList.get(num).getDevUtBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtInvLabel()+"'>"+beanList.get(num).getDevUtInv()+"</div>");
              htmlSTBuilderTabFive.append("<div style='display: table-cell;' class='rTableCell cc development'><button class='development_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                      
              //::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN ONE - TITLE AND DATA::::::::::::::::
              htmlSTBuilderTabFive.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("</div>");
  		htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeResource()+"</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeDueDate()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubePlanned()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcResource()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcDueDate()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataResourceLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataDueDateLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataPlannedLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("</div>");
  		
	  	//::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN TWO - TITLES AND DATA::::::::::::::::
  		htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'><div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("</div>");
              htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'><div id='"+beanList.get(num).getDevCodeTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubePlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubePlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvPlanned()+ "</div>");
              htmlSTBuilderTabFive.append("</div>");
              htmlSTBuilderTabFive.append("</div></div>");
              //::::::::::::::END OF HIDE INFORMATION DEVELOPMENT - COLUMN ONE AND TWO::::::::::::::::		
  		    
                 System.out.println("valor do num: "+num);
                 System.out.println("-->"+beanList.get(num).getProjectIdLabel()+"\n\n");
   		
       		if( num > 0){
       		 	 System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
       		 	    System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
                       		
       		 	    //::::::::::::::MORE IMPORTANTE PART OF THIS METHOD!!!:::::::::::::
       		 	    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
       		 	    if(beanList.get(num).getMethodologyId() != beanList.get(num-1).getMethodologyId()){
                       		   
                       		    //projectManager = beanList.get(num-1).getManagerName();
                       		    methodologyStr = beanList.get(num-1).getSdlc();
                       		    //methodologyStr = beanList.get(num-1).getSdlc();
                       		//if(num != 0){	   
                       		    System.out.println("entrei no if principal");
                       		    //htmlSTBuilder.append(CreateHtml.get)
                       		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                       		    
                       		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                       		    //htmlSTBuilder.append(CreateHtml.getPagination());//inserir div pagination
                       		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                       		    
                       		    htmlSTBuilderTabOne.setLength(0);
                       		    htmlSTBuilderTabTwo.setLength(0);
                       		    htmlSTBuilderTabThree.setLength(0);
                       		    htmlSTBuilderTabFour.setLength(0);
                       		    htmlSTBuilderTabFive.setLength(0);
                       		    tabNum = tabNum + 1;
                       		    
                       		    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManagerName+" "+projectManagerLastName+" - "+methodologyStr+"</legend>");
                       		    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
                       		    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
                       		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
                       		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
                       		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
                       		}
       		 	       		    
                       		}
                       		
                       		//abaixo temos o oposto do bloco de cima-> acima diferente de zero e abaixo igual a zero
                       		//troca de tabela caso o atual seja diferente do anterior e finaliza as tabelas
                       		if(num == 0){
                       		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                       		    htmlSTBuilderTabOne.setLength(0);
                       		    htmlSTBuilderTabTwo.setLength(0);
                       		    htmlSTBuilderTabThree.setLength(0);
                       		    htmlSTBuilderTabFour.setLength(0);
                       		    htmlSTBuilderTabFive.setLength(0);
                       		}
                       		num = num - 1;
       	    }
       	    
       	    
	}catch(Exception ex){
	    System.out.println("Error: "+ex.getMessage()+"-"+ex.getClass()+"-"+ex.getLocalizedMessage()+"--"+ex.getCause());
	}
	
	
	
	
	return htmlSTBuilder.toString();
	
	
    }
    
   /* public String getProjectsGroupByManager2(){
	
   	StringBuilder htmlSTBuilder = new StringBuilder();
   	
   	StringBuilder htmlSTBuilderTabOne = new StringBuilder();
   	StringBuilder htmlSTBuilderTabTwo = new StringBuilder();
   	StringBuilder htmlSTBuilderTabThree = new StringBuilder();
   	StringBuilder htmlSTBuilderTabFour = new StringBuilder();
   	StringBuilder htmlSTBuilderTabFive = new StringBuilder();
   	
   	
   	List<DashboardBean> beanList = new ArrayList<DashboardBean>(); 
   	DashboardDAO dbDao = new DashboardDAO();
   	List<Integer> numProjectsOrderByManagers = new ArrayList<Integer>();
   	beanList = dbDao.selectProjectsGroupByManagers();
   	numProjectsOrderByManagers = dbDao.getNumprojectsorderByManagers(); //PAGINATION --- get the number of projects by managers...They are order by managers like beanlist above!!!
   	int numProjectsByPage = 4;//PAGINATION --- this is the nuber of projects by pagination
   	int atualPage = 1;//PAGINATION --- actual page
   	//int numTotalProjects = 0;
   	
   	//itens genericos para todas as tabelas
   	String projectManager = "";
   	String application = "";
   	int projectId;
   	String ProjectName = "";
   	//status
   	String statusState = "";
   	String statusSdlc = "";
   	String statusStatus = "";
   	String statusIssue = "";
   	String statusComments = "";
   	String statusJeopardyList = "";
   	//projectInfo
   	String projectInfoFtps = "";
   	String projectInfoFtpsCM = "";
   	String projectInfoFtpsNM = "";
   	String projectInfoCRs = "";
   	String projectInfoSE = "";
   	String projectInfoIbmPM = "";
   	String projectInfoApm = "";
   	
   	//schedule
   	String scheduleRelease = "";
   	String scheduleTestingTarget = "";
   	String scheduleSprint = "";
   	String scheduleSchedule = "";
   	
   	//Impact
   	String impactType = "";
   	String impactTube = "";
   	String impactBc = "";
   	String impactInv = "";
   	String impactPi = "";
   	
   	//requirement
   	String reqSrs = ""; //esta tbem em overview
   	String reqStatus = "";
   	String reqBaselineDate = "";
   	String reqDueDate = "";
   	String reqPlanned = "";
   	
   	//design
   	String designHLD = "";//esta tbem em overview
   	String designHLDtube = "";
   	String designHLDbc = "";
   	String designHLDinv = "";
   	String designHLDpi = "";
   	String designIA = "";//esta tbem em overview
   	String designIAia = "";
   	String designAD = "";//esta tbem em overview
   	String designADtube = "";
   	String designADbc = "";
   	String designADinv = "";
   	String designCW = "";//esta tbem em overview
   	String designCWpi = "";
   	
   	//development
   	
   	String devUTD = "";//esta tbem em overview
   	String devUTDtube = "";
   	String devUTDbc = "";
   	String devUTDinv = "";
   	String devSTD = "";//esta tbem em overview
   	String devSTDstrs = "";
   	String devSTDtestData = "";
   	String devTAP = "";//esta tbem em overview
   	String devTAPpi = "";
   	String devCODE = "";//esta tbem em overview
   	String devCODEtube = "";
   	String devCODEbc = "";
   	String devCODEinv = "";
   	String devUT = "";//esta tbem em overview
   	String devUTtube = "";
   	String devUTbc = "";
   	String devUTinv = "";
   	
   	try{	    //aqui insere os primeiro valores da primeira tabela
   	    
   	    	    int num = beanList.size()-1;
   	    	    int tabNum = 0;
   	    	    int numberReferencePagination = 0;//PAGINATION  -- this is used for get element on list of projects of pagination.
   	    	    projectManager = 	beanList.get(num).getManagerName();
   	    	    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManager+"</legend>");
   	    	    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
   	    	    
   	    	    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
   		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
   		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
   		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
   		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
   	    	    
   	    	   
           	    while(num >= 0){
           			
           		
           		 projectManager = beanList.get(num).getManagerName();
           		 projectId = beanList.get(num).getProjectId();
           		 ProjectName = beanList.get(num).getProjectName();
           		//status
           		 statusState = beanList.get(num).getProjectState();
           		 statusSdlc = beanList.get(num).getSdlc();
           		 statusStatus = beanList.get(num).getProjectStatus();
           		 statusIssue = beanList.get(num).getIssue();
           		 statusComments = beanList.get(num).getComments();
           		 statusJeopardyList = beanList.get(num).getJeopardyList();
           		//projectInfo
           		 projectInfoFtps = beanList.get(num).getPiFtps();
           		 projectInfoFtpsCM = beanList.get(num).getPiFtpsCurrentMonth();
           		 projectInfoFtpsNM = beanList.get(num).getPiFtpsNextMonth();
           		 projectInfoCRs = beanList.get(num).getPiCrs();
           		 projectInfoSE = beanList.get(num).getPiSe();
           		 projectInfoIbmPM = beanList.get(num).getPiIbmPm();
           		 projectInfoApm = beanList.get(num).getPiApm();
           		
           		//schedule
           		 scheduleRelease = beanList.get(num).getScRelease();
           		 scheduleTestingTarget = beanList.get(num).getScTestingTarget();
           		 scheduleSprint = beanList.get(num).getScSprint();
           		 scheduleSchedule = beanList.get(num).getScSchedule();
           		
           		//Impact
           		 impactType = beanList.get(num).getiType();
           		 impactTube = beanList.get(num).getiTube();
           		 impactBc = beanList.get(num).getiBc();
           		 impactInv = beanList.get(num).getiInv();
           		 impactPi = beanList.get(num).getiPi();
           		
           		//requirement
           		 reqSrs = beanList.get(num).getReqSrs(); //esta tbem em overview
           		 reqStatus = beanList.get(num).getReqStatus();
           		 reqBaselineDate = beanList.get(num).getReqBaselineDate();
           		 reqDueDate = beanList.get(num).getReqDueDate();
           		 reqPlanned = beanList.get(num).getReqPlanned();
           		
           		//design
           		 designHLD = beanList.get(num).getDesHld();//esta tbem em overview
           		 designHLDtube = beanList.get(num).getDesHldTube();
           		 designHLDbc = beanList.get(num).getDesHldBc();
           		 designHLDinv = beanList.get(num).getDesHldinv();
           		 designHLDpi = beanList.get(num).getDesHldPi();
           		 designIA = beanList.get(num).getDesIa();//esta tbem em overview
           		 designIAia = beanList.get(num).getDesIaIa();
           		 designAD = beanList.get(num).getDesAd();//esta tbem em overview
           		 designADtube = beanList.get(num).getDesAdTube();
           		 designADbc = beanList.get(num).getDesAdBc();
           		 designADinv = beanList.get(num).getDesAdinv();
           		 designCW = beanList.get(num).getDesCw();//esta tbem em overview
           		 designCWpi = beanList.get(num).getDesCwPi();
           		
           		//development
           		
           		 devUTD = beanList.get(num).getDevUtd();//esta tbem em overview
           		 devUTDtube = beanList.get(num).getDevUtdTube();
           		 devUTDbc = beanList.get(num).getDevUtdBc();
           		 devUTDinv = beanList.get(num).getDevUtdInv();
           		 devSTD = beanList.get(num).getDevStd();//esta tbem em overview
           		 devSTDstrs = beanList.get(num).getDevStdStsr();
           		 devSTDtestData = beanList.get(num).getDevStdTestData();
           		 devTAP = beanList.get(num).getDevTap();//esta tbem em overview
           		 devTAPpi = beanList.get(num).getDevTapPi();
           		 devCODE = beanList.get(num).getDevCode();//esta tbem em overview
           		 devCODEtube = beanList.get(num).getDevCodeTube();
           		 devCODEbc = beanList.get(num).getDevCodeBc();
           		 devCODEinv = beanList.get(num).getDevCodeInv();
           		 devUT = beanList.get(num).getDevUt();//esta tbem em overview
           		 devUTtube = beanList.get(num).getDevUtTube();
           		 devUTbc = beanList.get(num).getDevUtBc();
           		 devUTinv = beanList.get(num).getDevUtInv();
           		
           		projectManager = beanList.get(num).getManagerName();
           		System.out.println("passei aqui222-> numero: "+num+"gerente: "+beanList.get(num).getMethodology());
           		//application = beanList.get(num).getApplication();
           		//itens genericos para todas as tabelas
           		 
           		
           		
           		 System.out.println(ProjectName+"passei aqui222-> numero: "+num+"gerente: "+beanList.get(num).getManagerName());
                           		//troca de tabela caso o atual seja diferente do anterior
           		 
           		System.out.println("entrei no else");
                        htmlSTBuilderTabOne.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+projectId+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+ProjectName+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_projectstate' id='"+beanList.get(num).getProjectStateLabel()+"'>"+statusState+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_sdlc' id='"+beanList.get(num).getSdlcLabel()+"'>"+statusSdlc+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_projectstatus' id='"+beanList.get(num).getProjectStatusLabel()+"'>"+statusStatus+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_issue' id='"+beanList.get(num).getIssueLabel()+"'>"+statusIssue+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_comments' id='"+beanList.get(num).getCommentsLabel()+"'>"+statusComments+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ status d_jeopardylist' id='"+beanList.get(num).getJeopardyListLabel()+"'>"+statusJeopardyList+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_piftps' id='"+beanList.get(num).getPiFtpsLabel()+"'>"+projectInfoFtps+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_piftpscurrentmonth' id='"+beanList.get(num).getPiFtpsCurrentMonthLabel()+"'>"+projectInfoFtpsCM+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_piftpsnextmonth' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+projectInfoFtpsNM+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_picrs' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+projectInfoCRs+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_pise' id='"+beanList.get(num).getPiSeLabel()+"'>"+projectInfoSE+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_piibmpm' id='"+beanList.get(num).getPiIbmPmLabel()+"'>"+projectInfoIbmPM+"</div>");
                      htmlSTBuilderTabOne.append("<div class='rTableCell cc edit_ project-info d_piapm' id='"+beanList.get(num).getPiApmLabel()+"'>"+projectInfoApm+"</div>");
                      htmlSTBuilderTabOne.append("</div>");

                      htmlSTBuilderTabTwo.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                            htmlSTBuilderTabTwo.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                            htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+projectId+"</div>");
                            htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+ProjectName+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ schedule' id='"+beanList.get(num).getScReleaseLabel()+"'>"+scheduleRelease+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ schedule  d_projectstate'id='"+beanList.get(num).getScTestingTargetLabel()+"'>"+scheduleTestingTarget+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ schedule  d_sdlc'id='"+beanList.get(num).getScSprintLabel()+"'>"+scheduleSprint+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ schedule  d_projectstatus'id='"+beanList.get(num).getScScheduleLabel()+"'>"+scheduleSchedule+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ impact  d_issue'id='"+beanList.get(num).getiTypeLabel()+"'>"+impactType+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ impact  d_comments'id='"+beanList.get(num).getiTubeLabel()+"'>"+impactTube+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ impact  d_jeopardylist'id='"+beanList.get(num).getiBcLabel()+"'>"+impactBc+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ impact  d_piftps'id='"+beanList.get(num).getiInvLabel()+"'>"+impactInv+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ impact  d_piftpscurrentmonth'id='"+beanList.get(num).getiPiLabel()+"'>"+impactPi+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ requirement  d_piftpsnextmonth'id='"+beanList.get(num).getReqSrsLabel()+"'>"+reqSrs+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ design  d_picrs'id='"+beanList.get(num).getDesHldLabel()+"'>"+designHLD+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ design  d_pise'id='"+beanList.get(num).getDesIaLabel()+"'>"+designIA+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ design  d_piibmpm'id='"+beanList.get(num).getDesAdLabel()+"'>"+designAD+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ design  d_piapm'id='"+beanList.get(num).getDesCwLabel()+"'>"+designCW+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ development  d_piapm' id='"+beanList.get(num).getDevUtdLabel()+"'>"+devUTD+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ development  d_piapm' id='"+beanList.get(num).getDevStdLabel()+"'>"+devSTD+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ development  d_piapm' id='"+beanList.get(num).getDevTapLabel()+"'>"+devTAP+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ development  d_piapm' id='"+beanList.get(num).getDevCodeLabel()+"'>"+devCODE+"</div>");
                      htmlSTBuilderTabTwo.append("<div class='rTableCell cc edit_ development  d_piapm' id='"+beanList.get(num).getDevUtLabel()+"'>"+devUT+"</div>");
                      htmlSTBuilderTabTwo.append("</div>");
                      
                    htmlSTBuilderTabThree.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                                  htmlSTBuilderTabThree.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                                  htmlSTBuilderTabThree.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+ProjectName+"</div>");
                                  htmlSTBuilderTabThree.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+ProjectName+"</div>");
                            htmlSTBuilderTabThree.append("<div class='rTableCell cc edit_ requirement'id='"+beanList.get(num).getReqSrsLabel()+"'>"+reqSrs+"</div>");
                            htmlSTBuilderTabThree.append("<div class='rTableCell cc edit_ requirement' id='"+beanList.get(num).getReqStatusLabel()+"'>"+reqStatus+"</div>");
                            htmlSTBuilderTabThree.append("<div class='rTableCell cc edit_ requirement' id='"+beanList.get(num).getReqBaselineDateLabel()+"'>"+reqBaselineDate+"</div>");
                            htmlSTBuilderTabThree.append("<div class='rTableCell cc edit_ requirement' id='"+beanList.get(num).getReqDueDateLabel()+"'>"+reqDueDate+"</div>");
                            htmlSTBuilderTabThree.append("<div class='rTableCell cc edit_ requirement' id='"+beanList.get(num).getReqPlannedLabel()+"'>"+reqPlanned+"</div>");
                            htmlSTBuilderTabThree.append("</div>");
                            
                    htmlSTBuilderTabFour.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                                  htmlSTBuilderTabFour.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                                  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+projectId+"</div>");
                                  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+ProjectName+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design_group' id='"+beanList.get(num).getDesHldLabel()+"'>"+designHLD+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesHldTubeLabel()+"'>"+designHLDtube+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesHldBcLabel()+"'>"+designHLDbc+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesHldinvLabel()+"'>"+designHLDinv+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesHldPiLabel()+"'>"+designHLDpi+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design_group' id='"+beanList.get(num).getDesIaIaLabel()+"'>"+designIA+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesIaIaLabel()+"'>"+designIAia+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design_group' id='"+beanList.get(num).getDesAdLabel()+"'>"+designAD+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesAdTubeLabel()+"'>"+designADtube+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesAdBcLabel()+"'>"+designADbc+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesAdinvLabel()+"'>"+designADinv+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design_group' id='"+beanList.get(num).getDesCwLabel()+"'>"+designCW+"</div>");
                            htmlSTBuilderTabFour.append("<div class='rTableCell cc edit_ design' id='"+beanList.get(num).getDesCwPiLabel()+"'>"+designCWpi+"</div>");
                            htmlSTBuilderTabFour.append("<div style='display: table-cell;' class='rTableCell cc edit_ design'><button class='design_details' type='submit'><img src='img/detail2.png'></button></div>");
                            htmlSTBuilderTabFour.append("</div>");
                            
                    htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                                  htmlSTBuilderTabFive.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                                  htmlSTBuilderTabFive.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+projectId+"</div>");
                                  htmlSTBuilderTabFive.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+ProjectName+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development_group' id='"+beanList.get(num).getDevUtdLabel()+"'>"+devUTD+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtdTubeLabel()+"'>"+devUTDtube+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtdBcLabel()+"'>"+devUTDbc+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtdInvLabel()+"'>"+devUTDinv+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development_group' id='"+beanList.get(num).getDevStdLabel()+"'>"+devSTD+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevStdStsrLabel()+"'>"+devSTDstrs+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevStdTestDataLabel()+"'>"+devSTDtestData+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development_group' id='"+beanList.get(num).getDevTapLabel()+"'>"+devTAP+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevTapPiLabel()+"'>"+devTAPpi+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development_group' id='"+beanList.get(num).getDevCodeLabel()+"'>"+devCODE+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevCodeTubeLabel()+"'>"+devCODEtube+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevCodeBcLabel()+"'>"+devCODEbc+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevCodeInvLabel()+"'>"+devCODEinv+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development_group' id='"+beanList.get(num).getDevUtLabel()+"'>"+devUT+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtTubeLabel()+"'>"+devUTtube+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtBcLabel()+"'>"+devUTbc+"</div>");
                            htmlSTBuilderTabFive.append("<div class='rTableCell cc edit_ development' id='"+beanList.get(num).getDevUtInvLabel()+"'>"+devUTinv+"</div>");
                            htmlSTBuilderTabFive.append("<div style='display: table-cell;' class='rTableCell cc edit_ development'><button class='design_details' type='submit'><img src='img/detail2.png'></button></div>");
                            htmlSTBuilderTabFive.append("</div>");
                         System.out.println("valor do num: "+num);
                         System.out.println("-->"+beanList.get(num).getProjectIdLabel()+"\n\n");
           		 
           		 	if( num > 0){
           		 	    System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getManagerId()+"--"+beanList.get(num-1).getManagerId());
                           		if(beanList.get(num).getManagerId() != beanList.get(num-1).getManagerId()){
                           		   
                           		    projectManager = beanList.get(num-1).getManagerName();
                           		//if(num != 0){	   
                           		    System.out.println("entrei no if principal");
                           		    //htmlSTBuilder.append(CreateHtml.get)
                           		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                           		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                           		    
                           		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                           		   // htmlSTBuilder.append(CreateHtml.getPagination(numProjectsByPage, atualPage ,numProjectsOrderByManagers.get(numberReferencePagination)));//inserir div pagination
                           		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                           		    
                           		    htmlSTBuilderTabOne.setLength(0);
                           		    htmlSTBuilderTabTwo.setLength(0);
                           		    htmlSTBuilderTabThree.setLength(0);
                           		    htmlSTBuilderTabFour.setLength(0);
                           		    htmlSTBuilderTabFive.setLength(0);
                           		    tabNum = tabNum + 1;
                           		    
                           		    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManager+"</legend>");
                           		    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
                           		    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
                           		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
                           		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
                           		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
                           		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
                           		    
                           		    
                           		 numberReferencePagination = numberReferencePagination + 1;
                           		    
                           		}
           		 	
                           		//}else{
                           		    
                           		    
   	                       		    
                           		}
                           		
                           		
                           		
                           		//abaixo temos o oposto do bloco de cima-> acima diferente de zero e abaixo igual a zero
                           		
                           		
                           		//troca de tabela caso o atual seja diferente do anterior e finaliza as tabelas
                           		if(num == 0){
                           		    System.out.println("entrei no num == 0");
                           		  //htmlSTBuilder.append(CreateHtml.get)
                           		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                           		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                           		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                           		    
                           		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                           		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                           		    //htmlSTBuilder.append(CreateHtml.getPagination(numProjectsByPage, atualPage ,numProjectsOrderByManagers.get(numberReferencePagination)));//inserir div pagination
                           		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                           		   
                           		    htmlSTBuilderTabOne.setLength(0);
                           		    htmlSTBuilderTabTwo.setLength(0);
                           		    htmlSTBuilderTabThree.setLength(0);
                           		    htmlSTBuilderTabFour.setLength(0);
                           		    htmlSTBuilderTabFive.setLength(0);
                           		   
                           		    
                           		}
                           		num = num - 1;
           	    }
           	    
           	    
   	}catch(Exception ex){
   	    System.out.println("Error: "+ex.getMessage()+"-"+ex.getClass()+"-"+ex.getLocalizedMessage()+"--"+ex.getCause());
   	}
   	
   	
   	
   	
   	return htmlSTBuilder.toString();
       }*/
    
    
    
    
public String getProjectsGroupByMethodology(int userId){
	
    	StringBuilder htmlSTBuilder = new StringBuilder();
	StringBuilder htmlSTBuilderTabOne = new StringBuilder();
	StringBuilder htmlSTBuilderTabTwo = new StringBuilder();
	StringBuilder htmlSTBuilderTabThree = new StringBuilder();
	StringBuilder htmlSTBuilderTabFour = new StringBuilder();
	StringBuilder htmlSTBuilderTabFive = new StringBuilder();
	
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	List<DashboardBean> beanList = new ArrayList<DashboardBean>(); 
	DashboardDAO dbDao = new DashboardDAO();
	beanList = dbDao.selectProjectsGroupByMethodology();
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	
	try{	    //aqui insere os primeiro valores da primeira tabela
	    
	    	    int num = beanList.size()-1;
	    	    int tabNum = 0;
	    	    String methodologyStr = beanList.get(num).getSdlc();
	    	    //projectManager = beanList.get(num).getManagerName();
	    	    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+methodologyStr+"</legend>");
	    	    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
	    	    
	    	    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
	    	    
		    int ID_USER = userId;
			
	    	   
       	    while(num >= 0){
       		
       		
       		String edit_ = "";
       		if(beanList.get(num).getUserProjectId() == ID_USER){
       		    edit_ = "edit_";
       		}else{
       		    edit_ = "";
       		}
       			
       			
       		
       		String statusStatus_ =  beanList.get(num).getProjectStatus(); 
       		String statusStatus =  ""; 
       		System.out.println("status 0-"+beanList.get(num).getProjectStatus());
       		if(statusStatus_.matches("Green")){
       		   statusStatus =  "<img style='height:12px' src='img/green_icon.png' />";  
       		}
       		if(statusStatus_.matches("Yellow")){
       		    statusStatus =  "<img style='height:12px' src='img/yellow_icon.png' />";
       		}
       		if(statusStatus_.matches("Red")){
       		    statusStatus =  "<img style='height:12px' src='img/red_icon.png' />";
       		}
   		                          
       		
   		
   		System.out.println("passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getSdlc()+"--"+beanList.get(num).getManagerName());
       		 System.out.println(beanList.get(num).getProjectName()+"passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getMethodology());
      		//troca de tabela caso o atual seja diferente do anterior
       		 //Project tab
                  htmlSTBuilderTabOne.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_projectstate' id='"+beanList.get(num).getProjectStateLabel()+"'>"+beanList.get(num).getProjectState()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_sdlc' id='"+beanList.get(num).getSdlcLabel()+"'>"+beanList.get(num).getSdlc()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc status edit_especial_one_ d_projectstatus' id='"+beanList.get(num).getProjectStatusLabel()+"'>"+statusStatus+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_issue' id='"+beanList.get(num).getIssueLabel()+"'>"+beanList.get(num).getIssue()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_comments' id='"+beanList.get(num).getCommentsLabel()+"'>"+beanList.get(num).getComments()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_jeopardylist' id='"+beanList.get(num).getJeopardyListLabel()+"'>"+beanList.get(num).getJeopardyList()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftps' id='"+beanList.get(num).getPiFtpsLabel()+"'>"+beanList.get(num).getPiFtps()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpscurrentmonth' id='"+beanList.get(num).getPiFtpsCurrentMonthLabel()+"'>"+beanList.get(num).getPiFtpsCurrentMonth()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpsnextmonth' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_picrs' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_pise' id='"+beanList.get(num).getPiSeLabel()+"'>"+beanList.get(num).getPiSe()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piibmpm' id='"+beanList.get(num).getPiIbmPmLabel()+"'>"+beanList.get(num).getPiIbmPm()+"</div>");
                  htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piapm' id='"+beanList.get(num).getPiApmLabel()+"'>"+beanList.get(num).getPiApm()+"</div>");
                  htmlSTBuilderTabOne.append("</div>");
                  //Overview Tab
                  htmlSTBuilderTabTwo.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell schedule' id='"+beanList.get(num).getScReleaseLabel()+"'>"+beanList.get(num).getScRelease()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstate'id='"+beanList.get(num).getScTestingTargetLabel()+"'>"+beanList.get(num).getScTestingTarget()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_sdlc'id='"+beanList.get(num).getScSprintLabel()+"'>"+beanList.get(num).getScSprint()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstatus'id='"+beanList.get(num).getScScheduleLabel()+"'>"+beanList.get(num).getScSchedule()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_issue'id='"+beanList.get(num).getiTypeLabel()+"'>"+beanList.get(num).getiType()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_comments'id='"+beanList.get(num).getiTubeLabel()+"'>"+beanList.get(num).getiTube()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_jeopardylist'id='"+beanList.get(num).getiBcLabel()+"'>"+beanList.get(num).getiBc()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftps'id='"+beanList.get(num).getiInvLabel()+"'>"+beanList.get(num).getiInv()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftpscurrentmonth'id='"+beanList.get(num).getiPiLabel()+"'>"+beanList.get(num).getiPi()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" requirement  d_piftpsnextmonth'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_picrs'id='"+beanList.get(num).getDesHldLabel()+"'>"+beanList.get(num).getDesHld()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_pise'id='"+beanList.get(num).getDesIaLabel()+"'>"+beanList.get(num).getDesIa()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piibmpm'id='"+beanList.get(num).getDesAdLabel()+"'>"+beanList.get(num).getDesAd()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piapm'id='"+beanList.get(num).getDesCwLabel()+"'>"+beanList.get(num).getDesCw()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
                  htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
                  htmlSTBuilderTabTwo.append("</div>");
                  //Requirement Tab
                  htmlSTBuilderTabThree.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqStatusLabel()+"'>"+beanList.get(num).getReqStatus()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqBaselineDateLabel()+"'>"+beanList.get(num).getReqBaselineDate()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqDueDateLabel()+"'>"+beanList.get(num).getReqDueDate()+"</div>");
                  htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqPlannedLabel()+"'>"+beanList.get(num).getReqPlanned()+"</div>");
                  htmlSTBuilderTabThree.append("</div>");
                  //Design Tab
                  htmlSTBuilderTabFour.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel() + "'></div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel() + "'>" + beanList.get(num).getProjectId() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel() + "'>" + beanList.get(num).getProjectName() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesHldLabel() + "'>" + beanList.get(num).getDesHld() + "</div>");
    	    	  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldTubeLabel() + "'>" + beanList.get(num).getDesHldTube() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldBcLabel() + "'>" + beanList.get(num).getDesHldBc() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldinvLabel() + "'>" + beanList.get(num).getDesHldinv() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldPiLabel() + "'>" + beanList.get(num).getDesHldPi() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesIaLabel() + "'>" + beanList.get(num).getDesIa() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesIaIaLabel() + "'>" + beanList.get(num).getDesIaIa() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesAdLabel() + "'>" + beanList.get(num).getDesAd() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdTubeLabel() + "'>" + beanList.get(num).getDesAdTube() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdBcLabel() + "'>" + beanList.get(num).getDesAdBc() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdinvLabel() + "'>" + beanList.get(num).getDesAdinv() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesCwLabel() + "'>" + beanList.get(num).getDesCw() + "</div>");
    		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesCwPiLabel() + "'>" + beanList.get(num).getDesCwPi() + "</div>");
                  htmlSTBuilderTabFour.append("<div style='display: table-cell;' class='rTableCell cc design' mode=''><button class='design_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                        
                //::::::::::::::HIDE INFORMATION design:::::::::::::::: 
                //table titles
                htmlSTBuilderTabFour.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow'>");
	        htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("</div>");
		//table values data
		htmlSTBuilderTabFour.append("<div class='rTableRow' tab_especial='tab-04' id='"+beanList.get(num).getDashboardId()+"'>");
  		htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubePlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldinvResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiDueDate()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubePlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesAdinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesCwPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("</div>");
	        htmlSTBuilderTabFour.append("</div></div>");
	        //::::::::::::::END OF HIDE INFORMATION design::::::::::::::::
                       
                //DEVELOPMENT
                htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabFive.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdTubeLabel()+"'>"+beanList.get(num).getDevUtdTube()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdBcLabel()+"'>"+beanList.get(num).getDevUtdBc()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdInvLabel()+"'>"+beanList.get(num).getDevUtdInv()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdStsrLabel()+"'>"+beanList.get(num).getDevStdStsr()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdTestDataLabel()+"'>"+beanList.get(num).getDevStdTestData()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevTapPiLabel()+"'>"+beanList.get(num).getDevTapPi()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeTubeLabel()+"'>"+beanList.get(num).getDevCodeTube()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeBcLabel()+"'>"+beanList.get(num).getDevCodeBc()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeInvLabel()+"'>"+beanList.get(num).getDevCodeInv()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtTubeLabel()+"'>"+beanList.get(num).getDevUtTube()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtBcLabel()+"'>"+beanList.get(num).getDevUtBc()+"</div>");
                htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtInvLabel()+"'>"+beanList.get(num).getDevUtInv()+"</div>");
                htmlSTBuilderTabFive.append("<div style='display: table-cell;' class='rTableCell cc development'><button class='development_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                        
                //::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN ONE - TITLE AND DATA::::::::::::::::
                htmlSTBuilderTabFive.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("</div>");
    		htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeResource()+"</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeDueDate()+"</div>");
    		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubePlanned()+"</div>");
    		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcResource()+"</div>");
    		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcDueDate()+"</div>");
    		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataResourceLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataDueDateLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataPlannedLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("</div>");
    		
	  	//::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN TWO - TITLES AND DATA::::::::::::::::
    		htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'><div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
    		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
    		htmlSTBuilderTabFive.append("</div>");
                htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'><div id='"+beanList.get(num).getDevCodeTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubePlanned()  + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcPlanned()  + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvPlanned()  + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubePlanned()  + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcPlanned()  + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvResource() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvDueDate() + "</div>");
                htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvPlanned()+ "</div>");
                htmlSTBuilderTabFive.append("</div>");
                htmlSTBuilderTabFive.append("</div></div>");
                //::::::::::::::END OF HIDE INFORMATION DEVELOPMENT - COLUMN ONE AND TWO::::::::::::::::	
  		    
                 System.out.println("valor do num: "+num);
                 System.out.println("-->"+beanList.get(num).getProjectIdLabel()+"\n\n");
   		
       		if( num > 0){
       		 	 System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
       		 	    System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
                       		
       		 	    //::::::::::::::MORE IMPORTANTE PART OF THIS METHOD!!!:::::::::::::
       		 	    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
       		 	    if(beanList.get(num).getMethodologyId() != beanList.get(num-1).getMethodologyId()){
                       		   
                       		    //projectManager = beanList.get(num-1).getManagerName();
                       		    methodologyStr = beanList.get(num-1).getSdlc();
                       		//if(num != 0){	   
                       		    System.out.println("entrei no if principal");
                       		    //htmlSTBuilder.append(CreateHtml.get)
                       		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                       		    
                       		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                       		    //htmlSTBuilder.append(CreateHtml.getPagination());//inserir div pagination
                       		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                       		    
                       		    htmlSTBuilderTabOne.setLength(0);
                       		    htmlSTBuilderTabTwo.setLength(0);
                       		    htmlSTBuilderTabThree.setLength(0);
                       		    htmlSTBuilderTabFour.setLength(0);
                       		    htmlSTBuilderTabFive.setLength(0);
                       		    tabNum = tabNum + 1;
                       		    
                       		    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+methodologyStr+"</legend>");
                       		    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
                       		    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
                       		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
                       		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
                       		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
                       		}
       		 	       		    
                       		}
                       		
                       		//abaixo temos o oposto do bloco de cima-> acima diferente de zero e abaixo igual a zero
                       		//troca de tabela caso o atual seja diferente do anterior e finaliza as tabelas
                       		if(num == 0){
                       		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                       		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                       		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                       		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                       		    htmlSTBuilderTabOne.setLength(0);
                       		    htmlSTBuilderTabTwo.setLength(0);
                       		    htmlSTBuilderTabThree.setLength(0);
                       		    htmlSTBuilderTabFour.setLength(0);
                       		    htmlSTBuilderTabFive.setLength(0);
                       		}
                       		num = num - 1;
       	    }
       	    
       	    
	}catch(Exception ex){
	    System.out.println("Error: "+ex.getMessage()+"-"+ex.getClass()+"-"+ex.getLocalizedMessage()+"--"+ex.getCause());
	}
	
	
	
	
	return htmlSTBuilder.toString();
       }
    

public String getProjectsGroupByManager(int userId){

	StringBuilder htmlSTBuilder = new StringBuilder();
	StringBuilder htmlSTBuilderTabOne = new StringBuilder();
	StringBuilder htmlSTBuilderTabTwo = new StringBuilder();
	StringBuilder htmlSTBuilderTabThree = new StringBuilder();
	StringBuilder htmlSTBuilderTabFour = new StringBuilder();
	StringBuilder htmlSTBuilderTabFive = new StringBuilder();
	
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	List<DashboardBean> beanList = new ArrayList<DashboardBean>(); 
	DashboardDAO dbDao = new DashboardDAO();
	List<Integer> numProjectsOrderByManagers = new ArrayList<Integer>();
	
	beanList = dbDao.selectProjectsGroupByManagers();
	//:::::::::::::::::DAO::::::::::::::::::::::::::
	
	try{	    //aqui insere os primeiro valores da primeira tabela
	    
	    	    int num = beanList.size()-1;
	    	    int tabNum = 0;
	    	    //String methodologyStr = beanList.get(num).getSdlc();
	    	    String projectManagerName = beanList.get(num).getManagerName();
	    	    String projectManagerLastName = beanList.get(num).getLastName();
	    	    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManagerName+" "+projectManagerLastName+ "</legend>");
	    	    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
	    	    
	    	    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
		    int ID_USER = userId;
			
	    	   
   	    while(num >= 0){
   		
   		
   		String edit_ = "";
       		if(beanList.get(num).getUserProjectId() == ID_USER){
       		    edit_ = "edit_";
       		}else{
       		    edit_ = "";
       		}
   		
   		String statusStatus_ =  beanList.get(num).getProjectStatus(); 
       		String statusStatus =  ""; 
       		System.out.println("status 0-"+beanList.get(num).getProjectStatus());
       		if(statusStatus_.matches("Green")){
       		   statusStatus =  "<img style='height:12px' src='img/green_icon.png' />";  
       		}
       		if(statusStatus_.matches("Yellow")){
       		    statusStatus =  "<img style='height:12px' src='img/yellow_icon.png' />";
       		}
       		if(statusStatus_.matches("Red")){
       		    statusStatus =  "<img style='height:12px' src='img/red_icon.png' />";
       		}
   		
   		
	//	String statusStatus =  "<img style='height:12px' src='img/green_icon.png' />";                            
   		//projectManager = beanList.get(num).getManagerName();
   		System.out.println("passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getSdlc()+"--"+beanList.get(num).getManagerName());
   		//application = beanList.get(num).getApplication();
   		//itens genericos para todas as tabelas
   		 System.out.println(beanList.get(num).getProjectName()+"passei aqui222-> numero: "+num+"methodology: "+beanList.get(num).getMethodology());
  		//troca de tabela caso o atual seja diferente do anterior
   		 //Project tab
   		htmlSTBuilderTabOne.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_projectstate' id='"+beanList.get(num).getProjectStateLabel()+"'>"+beanList.get(num).getProjectState()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_sdlc' id='"+beanList.get(num).getSdlcLabel()+"'>"+beanList.get(num).getSdlc()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc status edit_especial_one_ d_projectstatus' id='"+beanList.get(num).getProjectStatusLabel()+"'>"+statusStatus+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_issue' id='"+beanList.get(num).getIssueLabel()+"'>"+beanList.get(num).getIssue()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_comments' id='"+beanList.get(num).getCommentsLabel()+"'>"+beanList.get(num).getComments()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" status d_jeopardylist' id='"+beanList.get(num).getJeopardyListLabel()+"'>"+beanList.get(num).getJeopardyList()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftps' id='"+beanList.get(num).getPiFtpsLabel()+"'>"+beanList.get(num).getPiFtps()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpscurrentmonth' id='"+beanList.get(num).getPiFtpsCurrentMonthLabel()+"'>"+beanList.get(num).getPiFtpsCurrentMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piftpsnextmonth' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_picrs' id='"+beanList.get(num).getPiFtpsNextMonthLabel()+"'>"+beanList.get(num).getPiFtpsNextMonth()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_pise' id='"+beanList.get(num).getPiSeLabel()+"'>"+beanList.get(num).getPiSe()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piibmpm' id='"+beanList.get(num).getPiIbmPmLabel()+"'>"+beanList.get(num).getPiIbmPm()+"</div>");
                htmlSTBuilderTabOne.append("<div class='rTableCell cc "+edit_+" project-info d_piapm' id='"+beanList.get(num).getPiApmLabel()+"'>"+beanList.get(num).getPiApm()+"</div>");
                htmlSTBuilderTabOne.append("</div>");
                //Overview Tab
                htmlSTBuilderTabTwo.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell schedule' id='"+beanList.get(num).getScReleaseLabel()+"'>"+beanList.get(num).getScRelease()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstate'id='"+beanList.get(num).getScTestingTargetLabel()+"'>"+beanList.get(num).getScTestingTarget()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_sdlc'id='"+beanList.get(num).getScSprintLabel()+"'>"+beanList.get(num).getScSprint()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" schedule  d_projectstatus'id='"+beanList.get(num).getScScheduleLabel()+"'>"+beanList.get(num).getScSchedule()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_issue'id='"+beanList.get(num).getiTypeLabel()+"'>"+beanList.get(num).getiType()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_comments'id='"+beanList.get(num).getiTubeLabel()+"'>"+beanList.get(num).getiTube()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_jeopardylist'id='"+beanList.get(num).getiBcLabel()+"'>"+beanList.get(num).getiBc()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftps'id='"+beanList.get(num).getiInvLabel()+"'>"+beanList.get(num).getiInv()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" impact  d_piftpscurrentmonth'id='"+beanList.get(num).getiPiLabel()+"'>"+beanList.get(num).getiPi()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" requirement  d_piftpsnextmonth'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_picrs'id='"+beanList.get(num).getDesHldLabel()+"'>"+beanList.get(num).getDesHld()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_pise'id='"+beanList.get(num).getDesIaLabel()+"'>"+beanList.get(num).getDesIa()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piibmpm'id='"+beanList.get(num).getDesAdLabel()+"'>"+beanList.get(num).getDesAd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" design  d_piapm'id='"+beanList.get(num).getDesCwLabel()+"'>"+beanList.get(num).getDesCw()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
                htmlSTBuilderTabTwo.append("<div class='rTableCell cc "+edit_+" development  d_piapm' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
                htmlSTBuilderTabTwo.append("</div>");
                //Requirement Tab
                htmlSTBuilderTabThree.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement'id='"+beanList.get(num).getReqSrsLabel()+"'>"+beanList.get(num).getReqSrs()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqStatusLabel()+"'>"+beanList.get(num).getReqStatus()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqBaselineDateLabel()+"'>"+beanList.get(num).getReqBaselineDate()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqDueDateLabel()+"'>"+beanList.get(num).getReqDueDate()+"</div>");
                htmlSTBuilderTabThree.append("<div class='rTableCell cc "+edit_+" requirement' id='"+beanList.get(num).getReqPlannedLabel()+"'>"+beanList.get(num).getReqPlanned()+"</div>");
                htmlSTBuilderTabThree.append("</div>");
                //Design Tab
                htmlSTBuilderTabFour.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel() + "'></div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel() + "'>" + beanList.get(num).getProjectId() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel() + "'>" + beanList.get(num).getProjectName() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesHldLabel() + "'>" + beanList.get(num).getDesHld() + "</div>");
  	    	  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldTubeLabel() + "'>" + beanList.get(num).getDesHldTube() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldBcLabel() + "'>" + beanList.get(num).getDesHldBc() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldinvLabel() + "'>" + beanList.get(num).getDesHldinv() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesHldPiLabel() + "'>" + beanList.get(num).getDesHldPi() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesIaLabel() + "'>" + beanList.get(num).getDesIa() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesIaIaLabel() + "'>" + beanList.get(num).getDesIaIa() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesAdLabel() + "'>" + beanList.get(num).getDesAd() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdTubeLabel() + "'>" + beanList.get(num).getDesAdTube() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdBcLabel() + "'>" + beanList.get(num).getDesAdBc() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesAdinvLabel() + "'>" + beanList.get(num).getDesAdinv() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design_group' id='"+beanList.get(num).getDesCwLabel() + "'>" + beanList.get(num).getDesCw() + "</div>");
  		  htmlSTBuilderTabFour.append("<div class='rTableCell cc "+edit_+" design' id='"+beanList.get(num).getDesCwPiLabel() + "'>" + beanList.get(num).getDesCwPi() + "</div>");
                htmlSTBuilderTabFour.append("<div style='display: table-cell;' class='rTableCell cc design' mode=''><button class='design_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                      
              //::::::::::::::HIDE INFORMATION design:::::::::::::::: 
              //table titles
              htmlSTBuilderTabFour.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow'>");
	        htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Resource</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Due Date</span></div>");
		htmlSTBuilderTabFour.append("<div id='' class='rTableCellFirstInfo design_row'><span style='font-weight: bold;'>Planned%</span></div>");            		
		htmlSTBuilderTabFour.append("</div>");
		//table values data
		htmlSTBuilderTabFour.append("<div class='rTableRow' tab_especial='tab-04' id='"+beanList.get(num).getDashboardId()+"'>");
		htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldTubePlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldinvResource()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesHldinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiDueDate()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesHldPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesHldPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesIaIaPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesIaIaPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubeDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdTubePlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdBcPlanned() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesAdinvDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesAdinvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesAdinvPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" design'>"  +beanList.get(num).getDesCwPiResource() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiDueDate() + "</div>");
	        htmlSTBuilderTabFour.append("<div id='"+beanList.get(num).getDesCwPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" design'>" +beanList.get(num).getDesCwPiPlanned()  + "</div>");
	        htmlSTBuilderTabFour.append("</div>");
	        htmlSTBuilderTabFour.append("</div></div>");
	        //::::::::::::::END OF HIDE INFORMATION design::::::::::::::::
                     
              //DEVELOPMENT
              htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_application' id='"+beanList.get(num).getApplicationLabel()+"'></div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_projectid' id='"+beanList.get(num).getProjectIdLabel()+"'>"+beanList.get(num).getProjectId()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell d_projectname' id='"+beanList.get(num).getProjectNameLabel()+"'>"+beanList.get(num).getProjectName()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtdLabel()+"'>"+beanList.get(num).getDevUtd()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdTubeLabel()+"'>"+beanList.get(num).getDevUtdTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdBcLabel()+"'>"+beanList.get(num).getDevUtdBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtdInvLabel()+"'>"+beanList.get(num).getDevUtdInv()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevStdLabel()+"'>"+beanList.get(num).getDevStd()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdStsrLabel()+"'>"+beanList.get(num).getDevStdStsr()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevStdTestDataLabel()+"'>"+beanList.get(num).getDevStdTestData()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevTapLabel()+"'>"+beanList.get(num).getDevTap()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevTapPiLabel()+"'>"+beanList.get(num).getDevTapPi()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevCodeLabel()+"'>"+beanList.get(num).getDevCode()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeTubeLabel()+"'>"+beanList.get(num).getDevCodeTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeBcLabel()+"'>"+beanList.get(num).getDevCodeBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevCodeInvLabel()+"'>"+beanList.get(num).getDevCodeInv()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development_group' id='"+beanList.get(num).getDevUtLabel()+"'>"+beanList.get(num).getDevUt()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtTubeLabel()+"'>"+beanList.get(num).getDevUtTube()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtBcLabel()+"'>"+beanList.get(num).getDevUtBc()+"</div>");
              htmlSTBuilderTabFive.append("<div class='rTableCell cc "+edit_+" development' id='"+beanList.get(num).getDevUtInvLabel()+"'>"+beanList.get(num).getDevUtInv()+"</div>");
              htmlSTBuilderTabFive.append("<div style='display: table-cell;' class='rTableCell cc development'><button class='development_details' type='submit' mode='' id='"+beanList.get(num).getDashboardId()+"'><img src='img/detail2.png'></button></div>");
                      
              //::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN ONE - TITLE AND DATA::::::::::::::::
              htmlSTBuilderTabFive.append("<div class='pop-up-info' style='display: none; top: 284.983px; margin-left: -788px;'  id='"+beanList.get(num).getDashboardId()+"' ><div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("</div>");
  		htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeResource()+"</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubeDueDate()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdTubePlanned()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcResource()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcDueDate()+"</div>");
  		htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdBcPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtdInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevUtdInvPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdStsrPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdStsrPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataResourceLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataDueDateLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevStdTestDataPlannedLabel()+ "' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevStdTestDataPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiResource()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiDueDate()+"</div>");
	  	htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevTapPiPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>"+beanList.get(num).getDevTapPiPlanned()+"</div>");
	  	htmlSTBuilderTabFive.append("</div>");
  		
	  	//::::::::::::::HIDE INFORMATION DEVELOPMENT - COLUMN TWO - TITLES AND DATA::::::::::::::::
  		htmlSTBuilderTabFive.append("<div class='rTableRow' id='"+beanList.get(num).getDashboardId()+"'><div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Resource</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Due Date</span></div>");
  		htmlSTBuilderTabFive.append("<div id='' class='rTableCellFirstInfo developmentFirstRow'><span style='font-weight: bold;'>Planned%</span></div>"); 
  		htmlSTBuilderTabFive.append("</div>");
              htmlSTBuilderTabFive.append("<div class='rTableRow' tab_especial='tab-05' id='"+beanList.get(num).getDashboardId()+"'><div id='"+beanList.get(num).getDevCodeTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubeDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeTubePlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeBcPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevCodeInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevCodeInvPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubeDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubeDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtTubePlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtTubePlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtBcPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtBcPlanned()  + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvResourceLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvResource() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvDueDateLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvDueDate() + "</div>");
              htmlSTBuilderTabFive.append("<div id='"+beanList.get(num).getDevUtInvPlannedLabel()+"' class='rTableCellInfo cc "+edit_+" development'>" +beanList.get(num).getDevUtInvPlanned()+ "</div>");
              htmlSTBuilderTabFive.append("</div>");
              htmlSTBuilderTabFive.append("</div></div>");
              //::::::::::::::END OF HIDE INFORMATION DEVELOPMENT - COLUMN ONE AND TWO::::::::::::::::	
		    
             System.out.println("valor do num: "+num);
             System.out.println("-->"+beanList.get(num).getProjectIdLabel()+"\n\n");
		
   		if( num > 0){
   		 	 System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
   		 	    System.out.println("Condicao para entra aqui ser diferente->"+beanList.get(num).getMethodologyId()+"--"+beanList.get(num-1).getMethodologyId());
                   		
   		 	    //::::::::::::::MORE IMPORTANTE PART OF THIS METHOD!!!:::::::::::::
   		 	    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
   		 	    	if(beanList.get(num).getManagerId() != beanList.get(num-1).getManagerId()){
                   		   
                   		    //projectManager = beanList.get(num-1).getManagerName();
                   		    //methodologyStr = beanList.get(num-1).getSdlc();
                   		    String projectManagerName_ = beanList.get(num-1).getManagerName();
                   		    String projectManagerLastName_ = beanList.get(num-1).getLastName();
                   		//if(num != 0){	   
                   		    System.out.println("entrei no if principal");
                   		    //htmlSTBuilder.append(CreateHtml.get)
                   		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                   		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                   		    
                   		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                   		    //htmlSTBuilder.append(CreateHtml.getPagination());//inserir div pagination
                   		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                   		    
                   		    htmlSTBuilderTabOne.setLength(0);
                   		    htmlSTBuilderTabTwo.setLength(0);
                   		    htmlSTBuilderTabThree.setLength(0);
                   		    htmlSTBuilderTabFour.setLength(0);
                   		    htmlSTBuilderTabFive.setLength(0);
                   		    tabNum = tabNum + 1;
                   		    
                   		    htmlSTBuilder.append("<fieldset class='scroll"+tabNum+"'><legend>"+projectManagerName_+" "+projectManagerLastName_+"</legend>");
                   		    htmlSTBuilder.append(CreateHtml.getFildSetAndTabs(tabNum));
                   		    htmlSTBuilderTabOne.append(CreateHtml.getTabOne(tabNum)); //incializa mais uma tabela
                   		    htmlSTBuilderTabTwo.append(CreateHtml.getTabTwo(tabNum));
                   		    htmlSTBuilderTabThree.append(CreateHtml.getTabThree(tabNum));
                   		    htmlSTBuilderTabFour.append(CreateHtml.getTabFour(tabNum));
                   		    htmlSTBuilderTabFive.append(CreateHtml.getTabFive(tabNum));
                   		}
   		 	       		    
                   		}
                   		
                   		//abaixo temos o oposto do bloco de cima-> acima diferente de zero e abaixo igual a zero
                   		//troca de tabela caso o atual seja diferente do anterior e finaliza as tabelas
                   		if(num == 0){
                   		    htmlSTBuilderTabOne.append(CreateHtml.getFinalTab()); //termina a tabela anterior
                   		    htmlSTBuilderTabTwo.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabThree.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabFour.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilderTabFive.append(CreateHtml.getFinalTab());
                   		    htmlSTBuilder.append(htmlSTBuilderTabOne.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabTwo.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabThree.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabFour.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append(htmlSTBuilderTabFive.toString());//<=======finaliza uma tabela nova
                   		    htmlSTBuilder.append("</fieldset>");//<=======finaliza uma tabela nova
                   		    htmlSTBuilderTabOne.setLength(0);
                   		    htmlSTBuilderTabTwo.setLength(0);
                   		    htmlSTBuilderTabThree.setLength(0);
                   		    htmlSTBuilderTabFour.setLength(0);
                   		    htmlSTBuilderTabFive.setLength(0);
                   		}
                   		num = num - 1;
   	    }
   	    
   	    
	}catch(Exception ex){
	    System.out.println("Error: "+ex.getMessage()+"-"+ex.getClass()+"-"+ex.getLocalizedMessage()+"--"+ex.getCause());
	}
	
	
	
	
	return htmlSTBuilder.toString();
       }
    
    

}

package com.ibm.att.spa01.bo;

import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.dao.DeliverableDAO;
import com.ibm.att.spa01.dao.ScheduleDAO;
import com.ibm.att.spa01.dao.DashboardDAO;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.dao.UsersDAO;
import com.ibm.att.spa01.util.CreateHtml;

public class DataBaseUpdate {

    
    public DataBaseUpdate(){
	
    }
    
     
    public boolean updateDeliverable(int id, String title, String description, String hld, String ia, String ad, String cw){
	boolean value = false;
	DeliverableBean dbean = new DeliverableBean();
	dbean.setTitle(title);
	dbean.setDescription(description);
	dbean.setAd(ad);
	dbean.setCw(cw);
	dbean.setHld(hld);
	dbean.setIa(ia);
	dbean.setId(id);
	
	DeliverableDAO dbdao = new DeliverableDAO();
	if(dbdao.updateDeliverableValue(dbean)){
	    value = true;
	}
	return value;
	
    }
    
    public boolean updateScheduleproject(ScheduleBean sbean){
	
	boolean check = false;
	ScheduleDAO sdao = new ScheduleDAO();
	
	if(sdao.updateSchedule(sbean)){
	    check = true;
	    System.out.println("update sucessfully!!");
	}
	
	
	return check;
    }
    
    public boolean updateUser(int id, String table, String content){
	boolean check = false;
	UsersDAO usersDAO = new UsersDAO();
	
	if(usersDAO.updateUser(id, table, content)){
	    check = true;
	
	}
	
	return check;
    }
    
 
    public boolean updateDashboard(String application, int projectId, String projectName, String projectState, String sdlc, String projectStatus, String issue, String comments, String jeopardyList, String piFtps, String piFtpsCurrentMonth, String piFtpsNextMonth, String piCrs, String piSe, String piIbmPm, String piApm, String scRelease, String scTestingTarget, String scSprint, String scSchedule, String iType, String iTube, String iBc, String iInv, String iPi){
    	boolean value = false;
    	DashboardBean dbean = new DashboardBean();
    	dbean.setApplication(application);
    	dbean.setProjectId(projectId);
    	dbean.setProjectName(projectName);
    	dbean.setProjectState(projectState);
    	dbean.setSdlc(sdlc);
    	dbean.setProjectStatus(projectStatus);
    	dbean.setIssue(issue);
    	dbean.setComments(comments);
    	dbean.setJeopardyList(jeopardyList);
    	dbean.setPiFtps(piFtps);
    	dbean.setPiFtpsCurrentMonth(piFtpsCurrentMonth);
    	dbean.setPiFtpsNextMonth(piFtpsNextMonth);
    	dbean.setPiCrs(piCrs);
    	dbean.setPiSe(piSe);
    	dbean.setPiIbmPm(piIbmPm);
    	dbean.setPiApm(piApm);
    	dbean.setScRelease(scRelease);
    	dbean.setScTestingTarget(scTestingTarget);
    	dbean.setScSprint(scSprint);
    	dbean.setScSchedule(scSchedule);
       	dbean.setiType(iType);
    	dbean.setiTube(iTube);
    	dbean.setiBc(iBc);
    	dbean.setiInv(iInv);
    	dbean.setiPi(iPi);
    	
    	DashboardDAO dbdao = new DashboardDAO();
    	if(dbdao.updateDashboardValue(dbean)){
    		value = true;
    	}
    	
    	return value;	
    }
    
    public boolean updateRowDashboard(String id_row, String value, String column){
	boolean flag = false;
	DashboardDAO dbdao = new DashboardDAO(); 
	int id = Integer.parseInt(id_row);
	
	try{
	    if(dbdao.updateDashBoardRow(id, value, column)){
		flag = true;
	    }
	    
	    
	    
	}catch(Exception ex){
	    System.out.println(ex.getMessage());
	}
	return flag;
    }
    
    public boolean updateRowDeliverable(String id_row, String value, String column){
    	boolean flag = false;
    	DeliverableDAO dbdao = new DeliverableDAO(); 
    	int id = Integer.parseInt(id_row);
    	
    	try{
    	    if(dbdao.updateDeliverableRow(id, value, column)){
    	    	flag = true;
    	    }
    	    
    	}catch(Exception ex){
    	    System.out.println(ex.getMessage());
    	}
    	return flag;
        }
    
    public boolean updateRowSchedule(String id_row, String deliverable_row, String type_row, String value, String column){
    	boolean flag = false;
    	ScheduleDAO dbdao = new ScheduleDAO(); 
   /* 	int id = Integer.parseInt(id_row);*/
    	
    	try{
    	    if(dbdao.updateScheduleRow(id_row, deliverable_row, type_row, value, column)){
    	    	flag = true;
    	    }
    	    
    	}catch(Exception ex){
    	    System.out.println(ex.getMessage());
    	}
    	return flag;
        }
    
    public boolean updatePasswordUser(int id, String password){
	boolean flag = false;
	UsersDAO udao = new UsersDAO();
	if(udao.updatePassword(id, password)){
	    flag = true;
	}
	
	return flag;
    }
    public boolean updateProjectTable(int user_id, int id_dashboard){
   	boolean flag = false;
   	DashboardDAO ddao = new DashboardDAO();
   	if(ddao.updateDashBoardManager(user_id, id_dashboard)){
   	    flag = true;
   	}
   	
   	return flag;
       }    
}

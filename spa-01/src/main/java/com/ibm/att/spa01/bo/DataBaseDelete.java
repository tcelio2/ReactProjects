package com.ibm.att.spa01.bo;

import com.ibm.att.spa01.dao.DeliverableDAO;
import com.ibm.att.spa01.dao.ScheduleDAO;
import com.ibm.att.spa01.dao.DashboardDAO;
import com.ibm.att.spa01.dao.UsersDAO;

public class DataBaseDelete {

    
    public DataBaseDelete(){
	
    }
    
    
    public boolean deleteDeliverable(int id){
	boolean confirmation = false;
	DeliverableDAO dao = new DeliverableDAO();
	if(dao.deleteDeliverable(id)){
	    confirmation = true;
	}
	return confirmation;
    }
    
    public boolean deleteSchedule(String id){
    	boolean confirmation = false;
    	ScheduleDAO dao = new ScheduleDAO();
    	if(dao.deleteSchedule(id)){
    	    confirmation = true;
    	}
    	return confirmation;
        }
    
    public boolean deleteDashboard(int id){
    	boolean confirmation = false;
    	DashboardDAO dao = new DashboardDAO();
    	if(dao.deleteDashboard(id)){
    	    confirmation = true;
    	}
    	return confirmation;
        }
    
    public boolean deleteUser(int userId){
	boolean confirmation = false;
	UsersDAO udao = new UsersDAO();
	if(udao.deleteUser(userId)){
	    confirmation = true;
	}
	
	return confirmation;
    }
    public boolean deleteProject(int id){
	boolean g = false;
	DashboardDAO dd = new DashboardDAO();
	if(dd.deleteDashboard(id)){
	    g = true;
	}
	return g;
    }
    
    
}

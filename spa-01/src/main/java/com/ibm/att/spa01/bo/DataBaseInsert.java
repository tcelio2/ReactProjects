package com.ibm.att.spa01.bo;

import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.dao.DashboardDAO;
import com.ibm.att.spa01.dao.DeliverableDAO;
import com.ibm.att.spa01.dao.ScheduleDAO;
import com.ibm.att.spa01.dao.UsersDAO;



public class DataBaseInsert {

    
    public DataBaseInsert(){
	
    }
    
    
    public boolean insertUser(String name, String email, String role, int role_id, String lastName, String userName, String password){
	boolean confirmation = false;
	UserBean ub = new UserBean();
	ub.setUserName(name);
	ub.setEmail(email);
	ub.setRole(role);
	ub.setRoleId(role_id);
	ub.setLastName(lastName);
	ub.setUserName(userName);
	ub.setPassword(password);
	
	UsersDAO udao = new UsersDAO();
	
	if(udao.insertUser(ub)){
	    confirmation = true;
	}
	
	return confirmation;
    }
    
    public int insertDeliverable(String title, String description, String hld, String ia, String ad, String cw, int user_id){
	int id_return = 0;
	DeliverableBean dlv = new DeliverableBean();
	dlv.setTitle(title);
	dlv.setDescription(description);
	dlv.setHld(hld);
	dlv.setIa(ia);
	dlv.setAd(ad);
	dlv.setCw(cw);
	dlv.setIdUser(user_id);
	DeliverableDAO dDAO = new DeliverableDAO();
	id_return = dDAO.insertDeliverable(dlv);
	
	
	return id_return;
    }
 
    
    public int insertSchedule(ScheduleBean sbean){
    	
    	boolean check = false;
    	ScheduleDAO sdao = new ScheduleDAO();
    	int confirmation = sdao.insertSchedule(sbean);
    	
    	if(confirmation != 0){
    	    //check = true;
    	    System.out.println("insert sucessfully!!");
    	}  	
    	return confirmation;
    }
    
    public boolean createProject(String projectName, int projectId, String methodology, int methodology_id){
	boolean c = false;
	DashboardDAO ddao = new DashboardDAO();
	if(ddao.insertProject(projectName, projectId, methodology, methodology_id)){
	    c = true;
	}
	return c;
    }
    
    
    
    
    
}

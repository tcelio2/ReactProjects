package com.ibm.att.spa01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bo.DataBaseDelete;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.bo.DataBaseUpdate;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet(value="/schedule", name="ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ScheduleServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("user") != null) {
        	  	DataBaseSelect dbs = new DataBaseSelect();
        	    	String listSchedule = "";
        	    	List<DashboardBean> sb = new ArrayList<DashboardBean>();
        	    	List<DeliverableBean> dlb = new ArrayList<DeliverableBean>();
        	    	
        	    	UserBean userBeanSession = (UserBean) session.getAttribute("user");
        	    	int userId = userBeanSession.getId();
        	    	try{
        	    	    //sb = dbs.addAllagetAllProjects();
        	    	    sb.addAll(dbs.getAllProjects(userId));
        	    	}catch(Exception ex){
        	    	    ex.getStackTrace();
        	    	}
        	    	//--------------	    	
        	    	try{
        	    	    dlb.addAll(dbs.getAllDeliverables(userId));
        	    	}catch(Exception exs){
        	    	    exs.getStackTrace();
        	    	}
        	    	//---------------	 
        	    	try{
        	    		listSchedule = dbs.getAllSchedules(userId);	    	    
        	    	}catch(Exception ex){
        	    	    ex.getStackTrace();
        	    	}
        	    
        	    	
        	    request.setAttribute("projects", sb);
        	    request.setAttribute("deliverables", dlb);
        	    request.setAttribute("schedules", listSchedule);
        	    RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/schedule.jsp");
        	    dispatcher.forward(request,response);
	    }else{
		 request.getRequestDispatcher("index.jsp").include(request, response);
	    }
	    
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	
		
		String confirm = "FAIL";
		
		String param = request.getParameter("value");
		String projectId = request.getParameter("projectId");
		String deliverable1 = request.getParameter("deliverable");
		String type = request.getParameter("type");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String comment = request.getParameter("comment");
		

*/
		
		
		
		
		
		//===========================================
		
		
		
		
	    	String deliverable = request.getParameter("deliverable");
	    	
	    	StringBuilder result = new StringBuilder();
	    	
	    	PrintWriter out = response.getWriter();
	    	
	    	//String result = "";
//	    	result.append("<tr>");
	    	
//	    	if(!deliverable.matches("")){
	    	    
	    	
	    	    
	    	   
	    	DeliverableBean dbean = new DeliverableBean();
	    	DataBaseSelect db = new DataBaseSelect();
	    	dbean = db.getOneDeliverable(Integer.parseInt(deliverable));
	    		
	    	if(dbean.getHld().matches("S")){
	    	    result.append("<tr id="+dbean.getId()+"><td>HLD</td><td><input class='hld_start_date date start_date' type='text'></td><td><input class='hld_end_date date end_date' type='text'></td><td><input class='hld_comment comment' type='text'></td></tr>");
	    		    
			}
			if(dbean.getIa().matches("S")){
			    result.append("<tr id="+dbean.getId()+"><td>IA</td><td><input class='ia_start_date date start_date' type='text'></td><td><input class='ia_end_date date end_date' type='text'></td><td><input class='ia_comment comment' type='text'></td></tr>");
			    
			}
			if(dbean.getAd().matches("S")){
			    result.append("<tr id="+dbean.getId()+"><td>AD</td><td><input class='ad_start_date date start_date' type='text'></td><td><input class='ad_end_date date end_date' type='text'></td><td><input class='ad_comment comment' type='text'></td></tr>");
			   
			}
			if(dbean.getCw().matches("S")){
			    result.append("<tr id="+dbean.getId()+"><td>CW</td><td><input class='cw_start_date date start_date' type='text'></td><td><input class='cw_end_date date end_date' type='text'></td><td><input class='cw_comment comment' type='text'></td></tr>");
			   
			}
	    	
			
			
			
			
	/*		
			
			if (param.matches("SELECT")) {
				StringBuilder html = null ;
			    DataBaseSelect dbs = new DataBaseSelect();
			    html = dbs.getAllUsers();
			    response.setContentType("application/txt");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(html.toString());	
			}		
			
			if(param.matches("DELETE")){
				
		    	DataBaseDelete dbi = new DataBaseDelete();
		    	int id_ = Integer.parseInt(projectId);
		    	if(dbi.deleteSchedule(id_)){
		    		confirm = "DELETED";
		    	}
			 response.setContentType("application/txt");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(confirm);	
		    }

		    if(param.matches("UPDATE")){
			
		    	DataBaseUpdate dbu = new DataBaseUpdate();
		    	int id_ = Integer.parseInt(projectId);
		    	if(dbu.updateSchedule(id_, deliverable1, type, startDate, endDate, comment)){
		    		confirm = "UPDATED";
		    	}
			 response.setContentType("application/txt");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(confirm);	
		    }	
			
			
			*/
			
			
			
			
			
			
			
			
			
			
			
			
			
			//result.append("</tr>");
			
			System.out.println("resultado final:"+result);
			
	    	  
	    	    
	    	    
	    //	}
	    	result.toString();
	    	out.println(result);
	        out.close();

//	    	 response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
//	    	 response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
//	    	 response.getWriter().write(result); 
		
	}

}

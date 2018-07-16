package com.ibm.att.spa01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.ibm.att.spa01.bo.DataBaseDelete;
import com.ibm.att.spa01.bo.DataBaseInsert;
import com.ibm.att.spa01.bo.DataBaseUpdate;
import com.ibm.att.spa01.json.ScheduleJson;

/**
 * Servlet implementation class DeliverableScheduleServlet
 */
@WebServlet(value="/deliverableuser", name="DeliverableScheduleServlet")
public class DeliverableScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliverableScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    System.out.println("get aqui...");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("post squi");
	    
	    String confirm = "FAIL";
	    
		//String row_id_update = request.getParameter("id_row_table");
		//String row_deliverable_update = request.getParameter("deliverable_row_table");
		//String row_type_update = request.getParameter("type_row_table");
		String input_value = request.getParameter("input_value_update");
		//String table_comun = request.getParameter("table_column");
	 	
		String dashboard_id = request.getParameter("dashboard_id");
		String deliverable_id = request.getParameter("deliverable_id");
		String deliverable_title = request.getParameter("deliverable_title");
		String project_name = request.getParameter("project_name");
		String project_id = request.getParameter("project_id");
			//hld
		String hld_start_date = request.getParameter("hld_start_date");
		String hld_end_date =request.getParameter("hld_end_date");
		String hld_comment =request.getParameter("hld_comment");
			//ia	
		String ia_start_date =request.getParameter("ia_start_date");
		String ia_end_date =request.getParameter("ia_end_date");
		String ia_comment =request.getParameter("ia_comment");
			//ad			
		String ad_start_date =request.getParameter("ad_start_date");
		String ad_end_date =request.getParameter("ad_end_date");
		String ad_comment =request.getParameter("ad_comment");
			//cw					
		String cw_start_date =request.getParameter("cw_start_date");
		String cw_end_date =request.getParameter("cw_end_date");
		String cw_comment =request.getParameter("cw_comment");
		
		
	    String param = request.getParameter("value");
	    String id = request.getParameter("id");
	    
	//    String deliverable = request.getParameter("deliverable");
	//    String type = request.getParameter("type");
	    
	    if(param.matches("INSERT")){
			//String schedulestr = request.getParameter("schedule");
			//Gson gson = new Gson();
			//Type listType = new TypeToken<List<ScheduleJson>>() {}.getType();
			//List<ScheduleJson> sched = gson.fromJson(schedulestr.toString(), listType);

			DataBaseInsert dbi = new DataBaseInsert();

			//DataBaseUpdate dbu = new DataBaseUpdate();
			ScheduleBean sbean = new ScheduleBean();
			sbean.setHldStartDate(hld_start_date);
			sbean.setHldEndDate(hld_end_date);
			sbean.setHldCommnet(hld_comment);
			
			sbean.setAdStartDate(ad_start_date);
			sbean.setAdEndDate(ad_end_date);
			sbean.setAdComment(ad_comment);

			sbean.setIaStartDate(ia_start_date);
			sbean.setIaEndDate(ia_end_date);
			sbean.setIaCommnet(ia_comment);
			
			sbean.setCwStartDate(cw_start_date);
			sbean.setCwEndDate(cw_end_date);
			sbean.setCwComment(cw_comment);
			
			sbean.setDeliverableTitle(deliverable_title);
			sbean.setProjectName(project_name);
			sbean.setProjectId(project_id);
			sbean.setDeliverableId(Integer.parseInt(deliverable_id));
			sbean.setDashboardId(Integer.parseInt(dashboard_id));
			try {
			    int numberSchedule = dbi.insertSchedule(sbean);
			    confirm = String.valueOf(numberSchedule);
			} catch (Exception e) {
			    System.out.println(e.getMessage());
			}
				
			response.setContentType("application/txt");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(confirm);

				//System.out.println(sched.get(i).getType() + "-" + sched.get(i).getSdate() + "-"	+ sched.get(i).getEdate() + "-" + sched.get(i).getComment());
			
	    
	    }
	    
	    if(param.matches("UPDATE_ROW")){

	    	DataBaseUpdate dbUpdate = new DataBaseUpdate();

//			try{
//			    if(dbUpdate.updateRowSchedule(row_id_update, row_deliverable_update, row_type_update, input_value, table_comun)){
//				confirm = "UPDATED";
//			    }
//			    
//			}catch(Exception ex){
//			    System.out.println("Error on update!"+ex.getMessage());
//			}
			response.setContentType("application/txt");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(confirm);
	    }	
	    
	   
	    if(param.matches("DELETE")){
			
	    	DataBaseDelete dbi = new DataBaseDelete();
	 /*   	int id_ = Integer.parseInt(id);*/
	    	if(dbi.deleteSchedule(id)){
	    		confirm = "DELETED";
	    	}
			 response.setContentType("application/txt");
			 response.setCharacterEncoding("UTF-8");
			 response.getWriter().write(confirm);	
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	/*   
		String projectId = request.getParameter("projectId");
		String deliverable = request.getParameter("deliverable");
		String type = request.getParameter("type");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String comment = request.getParameter("comment");
	    */

//	 dbi.insertSchedule(projectId, deliverable, type, startDate, endDate, comment);
 //    dbi.insertSchedule(sbean);
	    
/*	 response.setContentType("application/txt");
	 response.setCharacterEncoding("UTF-8");
	 response.getWriter().write("ok");	
*/
	 
	    
	}

}

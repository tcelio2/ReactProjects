package com.ibm.att.spa01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bo.DataBaseDelete;
import com.ibm.att.spa01.bo.DataBaseInsert;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.bo.DataBaseUpdate;
import com.ibm.att.spa01.util.CreateHtml;



/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(value="/admin", name="AdminServlet")
//@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("user") != null) {
		    StringBuilder users = null ;
		    StringBuilder projects = null;
		    StringBuilder projectsANDmanagers = null;
		    StringBuilder managersDropBox = null;
		    
		    DataBaseSelect dbs = new DataBaseSelect();
		    users = dbs.getAllUsersForDataTable();
		    projects = dbs.getAllProjectsDataTable();
		    projectsANDmanagers = dbs.getAllProjectsAndUsersDataTable();
		    managersDropBox =  dbs.getAllUsersForChangeProjects();
		    
		    request.setAttribute("userTable", users.toString());
		    request.setAttribute("projectsTable", projects.toString());
		    request.setAttribute("projectsAndManagersTable", projectsANDmanagers.toString());
		    request.setAttribute("managers", managersDropBox.toString());
		    
		    
		    request.getRequestDispatcher("/pages/admin.jsp").forward(request, response);
	    }else{
		    request.getRequestDispatcher("index.jsp").include(request, response);
	    }
	    
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String param = request.getParameter("value");
	    String name = request.getParameter("name");
	    String last_name = request.getParameter("last_name");
	    String user_name = request.getParameter("user_name");
	    String email = request.getParameter("email");
	    String role = request.getParameter("role");
	    String id = request.getParameter("id");
	    String user_id = request.getParameter("user_id");
	    String role_id = request.getParameter("role_id");
	    String row_type = request.getParameter("row_type");
	   
	    String project_name = request.getParameter("project_name");
	    String project_id = request.getParameter("project_id");
	    String methodology = request.getParameter("methodology");
	    String methodology_id = request.getParameter("methodology_id");
	    
	    String table = request.getParameter("table");
	    String content = request.getParameter("content");
	  
	    
	    String confirm = "FAIL";
	    
	    if(param.matches("SELECT")){
		    StringBuilder html = null ;
		    DataBaseSelect dbs = new DataBaseSelect();
		    html = dbs.getAllUsers();
		    response.setContentType("application/txt");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(html.toString());	
	    }
	    if(param.matches("INSERT")){
		DataBaseInsert dbi = new DataBaseInsert();
		if(dbi.insertUser(name, email, role, Integer.parseInt(role_id), last_name, user_name, user_name) ){
		    confirm = "INSERTED";
		}
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);	
	    }
	    if(param.matches("CREATE_PROJECT")){
	  		DataBaseInsert dbi = new DataBaseInsert();
	  		if(dbi.createProject(project_name, Integer.parseInt(project_id), methodology, Integer.parseInt(methodology_id))){
	  		    confirm = "CREATED";
	  		}
	  		 response.setContentType("application/txt");
	  		 response.setCharacterEncoding("UTF-8");
	  		 response.getWriter().write(confirm);	
	  	    }
	    if(param.matches("DELETE_PROJECT")){
		DataBaseDelete dbi = new DataBaseDelete();
		
		if(dbi.deleteDashboard(Integer.valueOf(id))){
		    confirm = "DELETED";
		}
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);	
	    }
	    
	    
	    
	    if(param.matches("DELETE")){
		DataBaseDelete dbi = new DataBaseDelete();
		if(dbi.deleteUser(Integer.valueOf(id))){
		    confirm = "DELETED";
		}
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);	
	    }
	    if(param.matches("UPDATE")){
		DataBaseUpdate dbu = new DataBaseUpdate();
		//UserBean userbean = new UserBean();
		//CreateHtml createhtml = new CreateHtml();
		//userbean.setId(Integer.parseInt(id));
		//userbean.setEmail(email);
		//userbean.setRole(role);
		//userbean.setUserName(name);
		
		//String htmlResult = "";
		
		if(dbu.updateUser(Integer.parseInt(id), table, content)){
		    //htmlResult = createhtml.createHtmlForUser(userbean, row_type);
		    confirm = "UPDATED";
		}
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);	
	    }
	    if(param.matches("UPDATE_PROJECT_TABLE")){
		DataBaseUpdate dbu = new DataBaseUpdate();
		
		if(dbu.updateProjectTable(Integer.parseInt(user_id), Integer.parseInt(id))){
		    confirm = "UPDATED";
		}
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);
		
	    }

	}
	

}

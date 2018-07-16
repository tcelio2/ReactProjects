package com.ibm.att.spa01.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bean.UserDashboardBean;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.util.CreateHtml;

/**
 * Servlet implementation class DashboardFilterServlet
 */
@WebServlet(value="/dashboardFilter", name="DashboardFilterServlet")
public class DashboardFilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardFilterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//filter=pm or method or date
	    	//filter?page=1 or 2 or 3
	    
	    HttpSession session = request.getSession(false);
    	if (session != null && session.getAttribute("user") != null) {
                    	
    	    		UserBean ub =  (UserBean) session.getAttribute("user");	
    	    
    	    		String param = "";
                    	String pm = "";
                    	 param = request.getParameter("filter");
                    	
                    	 pm = request.getParameter("pm");
                    	
                    	List<UserDashboardBean> idbean = new ArrayList<UserDashboardBean>();
                    	DataBaseSelect dbS = new DataBaseSelect();
                    	idbean.addAll(dbS.getAllManagersForDashboard());
                    	request.setAttribute("manager", idbean);
                    	 
                    	
                    	if(!pm.isEmpty() && !pm.matches("''")){
                	    	    
                	    	    	    int pm_id = Integer.parseInt(pm);	
                        	    	    String dbStr = "";
                        	    	    try{
                        	    		dbStr = dbS.getProjectsFromPm(pm_id, ub.getId());
                        	    		
                        	    	    }catch(Exception ex){
                        	    		System.out.println("Error in DashboardFilterServlet: ->>"+ex.getMessage());
                        	    	    }
                        	    	     request.setAttribute("dashboardByManager", dbStr);
                    	    
                    	}
                    	
                	System.out.println("chegou em get com o valor: "+param);
                    	if(!param.isEmpty() && param.matches("pm")){
                	    	   
                	    	    String dbStr = "";
                	    	    String paginationBig = CreateHtml.getPaginationBig();
                	    	    try{
                	    		dbStr = dbS.getProjectsGroupByManager(ub.getId());
                	    		
                	    	    }catch(Exception ex){
                	    		System.out.println("Error in DashboardFilterServlet: ->>"+ex.getMessage());
                	    	    }
                	    	    request.setAttribute("paginationBig", paginationBig);
                	    	     request.setAttribute("dashboardByManager", dbStr);
                    	}
                    	
                    	if(!param.isEmpty() && param.matches("methodology")){
                	    	  
                	    	    String dbStr = "";
                	    	    try{
                	    		dbStr = dbS.getProjectsGroupByMethodology(ub.getId());
                	    	    }catch(Exception ex){
                	    		System.out.println("Error in DashboardFilterServlet: ->>"+ex.getMessage());
                	    	    }
                	    	     request.setAttribute("dashboardByMethodology", dbStr);
                    	}
                    	request.getRequestDispatcher("pages/dashboard.jsp").forward(request, response);
    	    
    	    
    	} else {
	    System.out.println("Session eh null!");
    	    request.getRequestDispatcher("index.jsp").include(request, response);

	
	}
	    
	    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

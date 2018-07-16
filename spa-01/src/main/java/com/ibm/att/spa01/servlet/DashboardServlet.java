package com.ibm.att.spa01.servlet;

import java.io.IOException;
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
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bean.UserDashboardBean;
import com.ibm.att.spa01.bo.DataBaseDelete;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.bo.DataBaseUpdate;

/**
 * Servlet implementation class DashboardServlet
 */
@WebServlet(value="/dashboard", name="DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        	HttpSession session = request.getSession(false);
        		
        	if (session != null && session.getAttribute("user") != null) {
        	    UserBean userBean = (UserBean) session.getAttribute("user");
                    
            	    		    //System.out.println("valores gravados na session "+userBean.);
            	    	
            	    		    
                        	    DataBaseSelect dbS = new DataBaseSelect();
                        	    String dbStr = "";
                        	    List<UserDashboardBean> idbean = new ArrayList<UserDashboardBean>();
                        	    //String user_id = request.getSession().getId(); //user ID
                        	    try {
                        		dbStr = dbS.getProjectsGroupByMethodology(userBean.getId());
                        		idbean.addAll(dbS.getAllManagersForDashboard());
                        	    } catch (Exception ex) {
                        		System.out.println("Error in DashboardFilterServlet: ->>" + ex.getMessage());
                        	    }
                        	    request.setAttribute("dashboardByMethodology", dbStr);
                        	    request.setAttribute("manager", idbean);
                        	    request.getRequestDispatcher("/pages/dashboard.jsp").forward(request, response);

        	    
        	} else {
        	    System.out.println("Session eh null!");
	    	    request.getRequestDispatcher("index.jsp").include(request, response);

        	
        	}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    	
	      
                    	    String confirm = "FAIL";
                		
                    	    	
                    	    
                    	    
                		String row_id_update = request.getParameter("id_row_table");
                		String input_value = request.getParameter("input_value_update");
                		String table_comun = request.getParameter("table_column");
                		
                		
                		String param = request.getParameter("value");
                		
                		String application = request.getParameter("application");
                		String projectId = request.getParameter("projectId");
                		String projectName = request.getParameter("projectName");
                		String projectState = request.getParameter("projectState");
                		String sdlc = request.getParameter("sdlc");
                		String projectStatus = request.getParameter("projectStatus");
                		String issue = request.getParameter("issue");
                		String comments = request.getParameter("comments");
                		String jeopardyList = request.getParameter("jeopardyList");	
                		String piFtps = request.getParameter("piFtps");
                		String piFtpsCurrentMonth = request.getParameter("piFtpsCurrentMonth");
                		String piFtpsNextMonth = request.getParameter("piFtpsNextMonth");
                		String piCrs = request.getParameter("piCrs");
                		String piSe = request.getParameter("piSe");
                		String piIbmPm = request.getParameter("piIbmPm");
                		String piApm = request.getParameter("piApm");
                		String scRelease = request.getParameter("scRelease");
                		String scTestingTarget = request.getParameter("scTestingTarget");
                		String scSprint = request.getParameter("scSprint");
                		String scSchedule = request.getParameter("scSchedule");
                		String iType = request.getParameter("iType");
                		String iTube = request.getParameter("iTube");
                		String iBc = request.getParameter("iBc");
                		String iInv = request.getParameter("iInv");
                		String iPi = request.getParameter("iPi");
                		
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
                	    	if(dbi.deleteDashboard(id_)){
                	    		confirm = "DELETED";
                	    	}
                		 response.setContentType("application/txt");
                		 response.setCharacterEncoding("UTF-8");
                		 response.getWriter().write(confirm);	
                	    }
            
                	    if(param.matches("UPDATE")){
                		
                	    	DataBaseUpdate dbu = new DataBaseUpdate();
                	    	int id_ = Integer.parseInt(projectId);
                	    	if(dbu.updateDashboard(application, id_, projectName, projectState, sdlc, projectStatus, issue, comments, jeopardyList, piFtps, piFtpsCurrentMonth, piFtpsNextMonth, piCrs, piSe, piIbmPm, piApm, scRelease, scTestingTarget, scSprint, scSchedule, iType, iTube, iBc, iInv, iPi)){
                	    		confirm = "UPDATED";
                	    	}
                		 response.setContentType("application/txt");
                		 response.setCharacterEncoding("UTF-8");
                		 response.getWriter().write(confirm);	
                	    }	
                	    
                	    if(param.matches("TAB")){
                		
                		String html = "<fieldset class='scroll'><legend>Lean</legend><ul class='tabs'><li class='tab-link current' data-tab='tab-1'>INFORMATION</li><li class='tab-link' data-tab='tab-2'>PROJECT INFO</li><li class='tab-link' data-tab='tab-3'>SCHEDULE</li></ul><div id='tab-1' class='tab-content current'><div class='rTable2'><div class='rTableHead'><span style='font-weight: bold;'>Application</span></div><div class='rTableHead'><span style='font-weight: bold;'>Project ID</span></div><div class='rTableHead medium'><span style='font-weight: bold;'>Project Name</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Unit Test Docs</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>System Test Docs</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>TAP</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>CODE</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>UT</span></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>15</div><div class='rTableCell d_projectname'>IBM mobile</div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>11</div><div class='rTableCell d_projectname'>Invoice</div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div><div class='rTableCell  cc development d_itype'></div></div></div></div><div id='tab-2' class='tab-content'><div class='rTable2'><div class='rTableHead'><span style='font-weight: bold;'>Application</span></div><div class='rTableHead'><span style='font-weight: bold;'>Project ID</span></div><div class='rTableHead medium'><span style='font-weight: bold;'>Project Name</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>State</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>SDLC</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Status</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Issue</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Comments</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Jeopardy List</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>bla bla bla</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>State</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>SDLC</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Status</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Issue</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Comments</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Jeopardy List</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>bla bla bla</span></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>15</div><div class='rTableCell d_projectname'>IBM mobile</div><div class='rTableCell cc status d_application'>yyy</div><div class='rTableCell cc status d_projectstate'>zzz</div><div class='rTableCell cc status d_sdlc'>bbb</div><div class='rTableCell cc status d_projectstatus'>kkk</div><div class='rTableCell cc status d_issue'>lll</div><div class='rTableCell cc status d_comments'>mmm</div><div class='rTableCell cc status d_jeopardylist'>ppp</div><div class='rTableCell cc status d_application'>yyy</div><div class='rTableCell cc status d_projectstate'>zzz</div><div class='rTableCell cc status d_sdlc'>bbb</div><div class='rTableCell cc status d_projectstatus'>kkk</div><div class='rTableCell cc status d_issue'>lll</div><div class='rTableCell cc status d_comments'>mmm</div><div class='rTableCell cc status d_jeopardylist'>ppp</div></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>11</div><div class='rTableCell d_projectname'>Invoice</div><div class='rTableCell cc status d_application'>yyy</div><div class='rTableCell cc status d_projectstate'>zzz</div><div class='rTableCell cc status d_sdlc'>bbb</div><div class='rTableCell cc status d_projectstatus'>kkk</div><div class='rTableCell cc status d_issue'>lll</div><div class='rTableCell cc status d_comments'>mmm</div><div class='rTableCell cc status d_jeopardylist'>ppp</div><div class='rTableCell cc status d_application'>yyy</div><div class='rTableCell cc status d_projectstate'>zzz</div><div class='rTableCell cc status d_sdlc'>bbb</div><div class='rTableCell cc status d_projectstatus'>kkk</div><div class='rTableCell cc status d_issue'>lll</div><div class='rTableCell cc status d_comments'>mmm</div><div class='rTableCell cc status d_jeopardylist'>ppp</div></div></div></div><div id='tab-3' class='tab-content'><div class='rTable2'><div class='rTableHead'><span style='font-weight: bold;'>Application</span></div><div class='rTableHead'><span style='font-weight: bold;'>Project ID</span></div><div class='rTableHead medium'><span style='font-weight: bold;'>Project Name</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>WWW</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>ZZZ</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>RRRR</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>VVVV</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>QQQ</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>sssss List</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>bla bla bla</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>VVVV</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>DDDD</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>###</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>Issue</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>DDDD</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>gggg List</span></div><div class='rTableHead cc'><span style='font-weight: bold;'>bla bla bla</span></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>15</div><div class='rTableCell d_projectname'>IBM mobile</div><div class='rTableCell cc  project-info d_application'>rrrr</div><div class='rTableCell cc  project-info d_projectstate'>hhh</div><div class='rTableCell cc  project-info d_sdlc'>lllll</div><div class='rTableCell cc  project-info d_projectstatus'>;;;;</div><div class='rTableCell cc  project-info d_issue'>kkkk</div><div class='rTableCell cc  project-info d_comments'>uuuu</div><div class='rTableCell cc  project-info d_jeopardylist'>tttt</div><div class='rTableCell cc  project-info d_application'>444444444</div><div class='rTableCell cc  project-info d_projectstate'>ffff</div><div class='rTableCell cc  project-info d_sdlc'>mmmm</div><div class='rTableCell cc  project-info d_projectstatus'>iiii</div><div class='rTableCell cc  project-info d_issue'>ppppp</div><div class='rTableCell cc  project-info d_comments'>zzzzz</div><div class='rTableCell cc  project-info d_jeopardylist'>33333</div></div><div class='rTableRow'><div class='rTableCell d_application'></div><div class='rTableCell d_projectid'>11</div><div class='rTableCell d_projectname'>Invoice</div><div class='rTableCell cc  project-info d_application'>rrrr</div><div class='rTableCell cc  project-info d_projectstate'>hhh</div><div class='rTableCell cc  project-info d_sdlc'>lllll</div><div class='rTableCell cc  project-info d_projectstatus'>;;;;</div><div class='rTableCell cc  project-info d_issue'>kkkk</div><div class='rTableCell cc  project-info d_comments'>uuuu</div><div class='rTableCell cc  project-info d_jeopardylist'>tttt</div><div class='rTableCell cc  project-info d_application'>444444444</div><div class='rTableCell cc  project-info d_projectstate'>ffff</div><div class='rTableCell cc  project-info d_sdlc'>mmmm</div><div class='rTableCell cc  project-info d_projectstatus'>iiii</div><div class='rTableCell cc  project-info d_issue'>ppppp</div><div class='rTableCell cc  project-info d_comments'>zzzzz</div><div class='rTableCell cc  project-info d_jeopardylist'>33333</div></div></div></div></fieldset>";
                		response.setContentType("application/txt");
                		response.setCharacterEncoding("UTF-8");
                		response.getWriter().write(html);
                		
                		
                	    }
            
                	    if(param.matches("UPDATE_ROW")){
                		DataBaseUpdate dbUpdate = new DataBaseUpdate();
                		//String row_id_update = request.getParameter("id_row_table");
                		//String input_value = request.getParameter("input_value_update");
                		//String table_comun = request.getParameter("table_column");
                		
                		//row_update
                		try{
                		    if(dbUpdate.updateRowDashboard(row_id_update, input_value, table_comun)){
                			confirm = "UPDATED";
                		    }
                		    
                		}catch(Exception ex){
                		    System.out.println("Err on update!"+ex.getMessage());
                		}
                		response.setContentType("application/txt");
                		response.setCharacterEncoding("UTF-8");
                		response.getWriter().write(confirm);
                	    }
        	    
        	
		
	    
	    
	}

}

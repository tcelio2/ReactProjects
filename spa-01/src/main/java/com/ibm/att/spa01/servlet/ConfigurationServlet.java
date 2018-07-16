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

import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.bo.DataBaseUpdate;


@WebServlet(value="/configuration", name="ConfigurationServlet")
public class ConfigurationServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   HttpSession session = request.getSession(false);
	    
		if (session != null && session.getAttribute("user") != null) {
//			            System.out.println("session nao eh null");
//				    UserBean userBeanSession = (UserBean) session.getAttribute("user");
//				    int userIdSession = userBeanSession.getId();
//				    System.out.println("vlue from servlet: "+userIdSession);
//				    DataBaseSelect dbs = new DataBaseSelect();
//				    List<DeliverableBean> list = new ArrayList<DeliverableBean>();
//				    list.addAll(dbs.getAllDeliverables(userIdSession));// = dbs.getAllDeliverables();
//				    //list.addAll(index, list);
//				    
//				   
//				    request.setAttribute("deliverables", list);
				    RequestDispatcher rd = request.getRequestDispatcher("/pages/configuration.jsp");
				    rd.forward(request, response);
			   
		    }else{
			            request.getRequestDispatcher("index.jsp").include(request, response);
			
		    }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String confirm = "FAIL";
	 HttpSession session = request.getSession(false);
	if (session != null && session.getAttribute("user") != null) {
		    
	    String password = request.getParameter("password");
	    UserBean user = (UserBean) session.getAttribute("user");
	    int user_id = user.getId();
	    
	    try{
		    DataBaseUpdate dbu = new DataBaseUpdate();
		    if(dbu.updatePasswordUser(user_id, password)){
			confirm = "SUCCESS";
		    }
		    
		    
		}catch(Exception e){
		    System.out.println(e.getMessage());
		}
	}
	
	 response.setContentType("application/txt");
	 response.setCharacterEncoding("UTF-8");
	 response.getWriter().write(confirm);	
	
	//String second = request.getParameter("second");
	
	
	
	
	
    }

}

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

import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.bo.DataBaseDelete;
import com.ibm.att.spa01.bo.DataBaseInsert;
import com.ibm.att.spa01.bo.DataBaseSelect;
import com.ibm.att.spa01.bo.DataBaseUpdate;



/**
 * Servlet implementation class DeliverableServlet
 */
//@WebServlet("/DeliverableServlet")
@WebServlet(value="/deliverable", name="DeliverableServlet")
public class DeliverableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliverableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    
	    //vai verficar se existe uma sessao. Se nao existir, vai criar uma nova sessap		
	    //false vai verificar a existencia e se nao tiver retorna null	    
	    HttpSession session = request.getSession(false);
	    
	if (session != null && session.getAttribute("user") != null) {
		            System.out.println("session nao eh null");
			    UserBean userBeanSession = (UserBean) session.getAttribute("user");
			    int userIdSession = userBeanSession.getId();
			    System.out.println("vlue from servlet: "+userIdSession);
			    DataBaseSelect dbs = new DataBaseSelect();
			    List<DeliverableBean> list = new ArrayList<DeliverableBean>();
			    list.addAll(dbs.getAllDeliverables(userIdSession));// = dbs.getAllDeliverables();
			    //list.addAll(index, list);
			    
			   
			    request.setAttribute("deliverables", list);
			    RequestDispatcher rd = request.getRequestDispatcher("/pages/deliverableTemplate.jsp");
			    rd.forward(request, response);
		   
	    }else{
		            request.getRequestDispatcher("index.jsp").include(request, response);
		
	    }
	   
	    
	   
//	    List<DeliverableBean> list = new ArrayList<DeliverableBean>();
//	    
//	    DeliverableBean a1 = new DeliverableBean();
//	    a1.setTitle("Thiago");
//	    a1.setDescription("wwwww");
//	    list.add(a1);
//	    
//	    DeliverableBean a2 = new DeliverableBean();
//	    a2.setTitle("Thiago2");
//	    a2.setDescription("wwwww2");
//	    list.add(a2);
//	    
//	    DeliverableBean a3 = new DeliverableBean();
//	    a3.setTitle("Thiago3");
//	    a3.setDescription("wwwww3");
//	    list.add(a3);
	  	  
	    
	   // list = dbs.getAllDeliverables();
	    //String list = "THIAGO";
	   // request.setAttribute("deliverables", list);
	   // request.getRequestDispatcher("/deliverableTemplate.jsp").forward(request,response);
	    //dispatcher.
	    
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//	    HttpSession session = request.getSession();
//	    UserBean nome = (UserBean)(session.getAttribute("user"));
	    //String paramSession = (String)(session.getAttribute("paramSession"));
	    
	    //System.out.println("THIAGO VALUE: "+nome.getUserName()+"SESSION PARAM: "+paramSession);
	    String confirm = "";
	    HttpSession session = request.getSession(false);
	    if(session != null && session.getAttribute("user") != null){
		
		 UserBean usuarioBeanSession = (UserBean)(session.getAttribute("user"));
		System.out.println("usuario "+usuarioBeanSession.getName());
		 confirm = "FAIL";
		    
		 	int usuario_id = usuarioBeanSession.getId();
			String row_id_update = request.getParameter("id_row_table");
			String input_value = request.getParameter("input_value_update");
			String table_comun = request.getParameter("table_column");
		    
		    String param = request.getParameter("value");
		    String title = request.getParameter("title");
		    String description = request.getParameter("description");
		    String hld = request.getParameter("hld");
		    String ia = request.getParameter("ia");
		    String ad = request.getParameter("ad");
		    String cw = request.getParameter("cw");
		    
		    String id = request.getParameter("id");
		    
		        
		    if(param.matches("SELECT")){
			    StringBuilder html = null ;
			    DataBaseSelect dbs = new DataBaseSelect();
			    html = dbs.getAllUsers();
			    response.setContentType("application/txt");
			    response.setCharacterEncoding("UTF-8");
			    response.getWriter().write(html.toString());	
			    //request.setAttribute("deliverables", list);
			    RequestDispatcher rd = request.getRequestDispatcher("/deliverableTemplate.jsp");
			    rd.forward(request, response);
		    }
		    
		    if(param.matches("INSERT")){
			
		    	DataBaseInsert dbi = new DataBaseInsert();
		    	int num = dbi.insertDeliverable(title, description, hld, ia, ad, cw, usuario_id);
		    	
		    	if(num != 0){		    
		    		confirm = "INSERTED";
		    		System.out.println("value"+num);
		    	}
		    	String num_bck = Integer.toString(num);
		    	response.setContentType("application/txt");
		    	response.setCharacterEncoding("UTF-8");
		    	response.getWriter().write(num_bck);			 	
		    }
		    
		    if(param.matches("DELETE")){
			
		    	DataBaseDelete dbi = new DataBaseDelete();
		    	int id_ = Integer.parseInt(id);
		    	if(dbi.deleteDeliverable(id_)){
		    		confirm = "DELETED";
		    	}
				 response.setContentType("application/txt");
				 response.setCharacterEncoding("UTF-8");
				 response.getWriter().write(confirm);	
		    }
		    
		    if(param.matches("UPDATE")){
			
		    	DataBaseUpdate dbu = new DataBaseUpdate();
		    	int id_ = Integer.parseInt(id);
		    	if(dbu.updateDeliverable(id_, title, description, hld, ia, ad, cw)){    
		    		confirm = "UPDATED";
		    	}
		    	response.setContentType("application/txt");
		    	response.setCharacterEncoding("UTF-8");
		    	response.getWriter().write(confirm);	
		    }

		    if(param.matches("UPDATE_ROW")){

		    	DataBaseUpdate dbUpdate = new DataBaseUpdate();

				try{
				    if(dbUpdate.updateRowDeliverable(row_id_update, input_value, table_comun)){
					confirm = "UPDATED";
				    }
				    
				}catch(Exception ex){
				    System.out.println("Error on update!"+ex.getMessage());
				}
				response.setContentType("application/txt");
				response.setCharacterEncoding("UTF-8");
				response.getWriter().write(confirm);
		    }	    
		
	    }else{
		 response.setContentType("application/txt");
		 response.setCharacterEncoding("UTF-8");
		 response.getWriter().write(confirm);	
	    }
	    
	    
	    
	  
	    
	    
	    
	}

}

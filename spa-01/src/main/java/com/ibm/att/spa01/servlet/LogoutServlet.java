package com.ibm.att.spa01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet(value="/logout", name="LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("logout - by get");
	   // response.setContentType("text/html");
/*	    	Cookie[] cookies = request.getCookies();
	    	if(cookies != null){
	    	for(Cookie cookie : cookies){
	    		if(cookie.getName().equals("JSESSIONID")){
	    			System.out.println("JSESSIONID="+cookie.getValue());
	    			break;
	    		}
	    	}
	    	}*/
	    	//invalidate the session if exists
	    	 request.getSession().invalidate();
	    	//request.getRequestDispatcher("index.jsp").include(request, response);
		 response.sendRedirect(request.getContextPath()+"/");
	    	//response.sendRedirect("/");
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    System.out.println("logout - by post");
	   // response.setContentType("text/html");
//	    	Cookie[] cookies = request.getCookies();
//	    	if(cookies != null){
//	    	for(Cookie cookie : cookies){
//	    		if(cookie.getName().equals("JSESSIONID")){
//	    			System.out.println("JSESSIONID="+cookie.getValue());
//	    			break;
//	    		}
//	    	}
//	    	}
	    	//invalidate the session if exists
	    	//HttpSession session = request.getSession(false);
	    	//System.out.println("User="+session.getAttribute("user"));
	        request.getSession().invalidate();
	    	response.sendRedirect(request.getContextPath()+"/login");
	}

}

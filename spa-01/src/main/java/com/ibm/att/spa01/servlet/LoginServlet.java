package com.ibm.att.spa01.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.dao.UsersDAO;



/**
 * Servlet implementation class LogServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession sessao = request.getSession(false);
		
		if (sessao != null) {
			sessao.invalidate();
		}
		response.sendRedirect("index.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    	String login = request.getParameter("login");
	    	String password = request.getParameter("password");
	    	  	
	    	UsersDAO udao = new UsersDAO();
	    	UserBean ubean = new UserBean();
	    	
	    	ubean = udao.verifyUserLogin(login, password);
	    	
	    	String msg = "";
	     	String redir = "index.jsp";
	    	
	    	try{
	    		if (ubean.getEmail() != null) {
	    			// session
	    			HttpSession session = request.getSession();
	    			session.setAttribute("user", ubean);
	    			session.setMaxInactiveInterval(30 * 60);
	    			// cookie
	    			Cookie userName = new Cookie("userCookie", ubean.getUserName());
	    			userName.setMaxAge(30 * 60); // 30 x 60 seconds
	    			response.addCookie(userName);    			
	    			redir = "dashboard";
	    			response.sendRedirect(redir);

	    		} else {
	    			msg = "Invalid login or password!";
	    			redir = "index.jsp";
	    			request.setAttribute("msg", msg);
	    			response.sendRedirect(redir);
	    		}
	    	} catch (Exception ex) {
	    		ex.printStackTrace();		
		}
	}

}

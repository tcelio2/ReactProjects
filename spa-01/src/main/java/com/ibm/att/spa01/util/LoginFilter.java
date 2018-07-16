package com.ibm.att.spa01.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebFilter("/pages/*")
public class LoginFilter implements Filter{

    public void init(FilterConfig config) throws ServletException {
	
	
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
	HttpSession session = request.getSession(false);
	
	String requestPath = request.getRequestURI();
	if(needsAuthentication(requestPath) || session == null || session.getAttribute("user") == null){
	    response.sendRedirect(request.getContextPath() + "/index.jsp");
	}else{
	   // if(request.getRequestURI().endsWith(".css")){
	    //	request.setCharacterEncoding("UTF-8");
		chain.doFilter(req, res);	
	    //}
	    
	}
    }
    //basic validation of pages that do not require authentication
    private boolean needsAuthentication(String url) {
        String[] validNonAuthenticationUrls =
            { "index.jsp"};
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
    
    public void destroy() {
  	// TODO Auto-generated method stub
  	
     }

      
    
    
}

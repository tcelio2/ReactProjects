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

import com.ibm.att.spa01.bean.TeamLeaderBean;
import com.ibm.att.spa01.bo.DataBaseSelect;

/**
 * Servlet implementation class TeamLeaderServlet
 */
@WebServlet(value="/teamLeader", name="TeamLeaderServlet")
public class TeamLeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamLeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("user") != null) {
        		DataBaseSelect dbs = new DataBaseSelect();
        		
        		List<TeamLeaderBean> listAgile = new ArrayList<TeamLeaderBean>();
        		List<TeamLeaderBean> listWaterfall = new ArrayList<TeamLeaderBean>();
        		
        		listAgile.addAll(dbs.getAgileTeamLeader());
        		listWaterfall.addAll(dbs.getWaterfallTeamLeader());
        		
        		request.setAttribute("teamLeaderWaterfall", listWaterfall);
        		request.setAttribute("teamLeaderAgile", listAgile);		
        		RequestDispatcher rd = request.getRequestDispatcher("/pages/teamLeader.jsp");
        		rd.forward(request, response);
	    }else{
			request.getRequestDispatcher("index.jsp").include(request, response);
	    }
	
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String param = request.getParameter("value");		
		
	if (param.matches("SELECT")) {
	    StringBuilder html = null ;
	    DataBaseSelect dbs = new DataBaseSelect();
	    html = dbs.getAllUsers();
	    response.setContentType("application/txt");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(html.toString());	
	}	    
    }
}
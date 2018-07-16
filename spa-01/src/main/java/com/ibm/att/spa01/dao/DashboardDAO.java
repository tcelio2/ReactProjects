package com.ibm.att.spa01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.DeliverableJsonBean;
import com.ibm.att.spa01.bean.UserDashboardBean;

public class DashboardDAO {

	private Connection con = null;
	private PreparedStatement ptmt = null;
		
	public DashboardDAO(){
	    ConnectionDAO conDAO = new ConnectionDAO();
		this.con = conDAO.getConection();
	}
		
	
	public List<Integer> getNumprojectsorderByManagers(){
	    
	    List<Integer> pj = new ArrayList<Integer>();	    
	    
	    try{
		 PreparedStatement stmt = con.prepareStatement("Select COUNT (project_id) as total, manager_name from dashboard group by manager_name order by manager_name");
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()){
		     rs.getInt("total");
		    // System.out.println("-------------------------->   Num of projects"+rs.getInt("total"));
		     pj.add(rs.getInt("total"));
		 }
		
	    }catch(Exception ex){
		System.out.println("Error on count projects"+ex.getMessage());
	    }
	    
	    
	    
	    
	    return pj;
	}
	
	
	public List<DashboardBean> selectDashboardAgil(){
			
		List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
		try {
		    
		    PreparedStatement stmt = con.prepareStatement("Select application, project_id, project_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, "
		    		+ "pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, "
		    		+ "i_type, i_tube, i_bc, i_inv, req_srs, req_status, req_base_line_date, req_due_date, req_planned, i_pi, des_hld, des_hld_tube, des_hld_tube_due_date, "
		    		+ "des_hld_bc, des_hld_bc_due_date, des_hld_inv, des_hld_inv_due_date, des_hld_pi, des_hld_pi_due_date, des_ia, des_ia_ia, des_ia_ia_due_date, des_ad, des_ad_tube, "
		    		+ "des_ad_tube_due_date, des_ad_bc, des_ad_bc_due_date, des_ad_inv, des_ad_inv_due_date, des_cw, des_cw_pi, des_cw_pi_due_date, dev_utd, dev_utd_tube, dev_utd_due_date, dev_utd_bc, dev_utd_bc_due_date, dev_utd_inv, dev_utd_inv_due_date, dev_std, dev_std_stsr, dev_std_stsr_due_date, dev_std_testdata, dev_std_testdata_due_date, dev_tap, dev_tap_pi, dev_tap_pi_due_date, dev_code, dev_code_tube, dev_code_tube_due_date, dev_code_bc, dev_code_bc_due_date, dev_code_inv, dev_code_inv_due_date, dev_ut, dev_ut_tube, dev_ut_tube_due_date, dev_ut_bc, dev_ut_bc_due_date, dev_ut_inv, dev_ut_inv_due_date, methodology  "
		    		+ "from dashboard where methodology = 'agil'");
		    
		    ResultSet rs = stmt.executeQuery();
		    ResultSetMetaData rsmd = rs.getMetaData();
		    
		    while(rs.next()){
			
		    	DashboardBean dBean = new DashboardBean();
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));	    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		    	dBean.setPiApm(rs.getString("pi_apm"));		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSchedule(rs.getString("sc_schedule"));	    	
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiPi(rs.getString("i_pi"));
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setReqStatus(rs.getString("req_status"));
		    	dBean.setReqBaselineDate(rs.getString("req_base_line_date"));
		    	dBean.setReqDueDate(rs.getString("req_due_date"));
		    	dBean.setReqPlanned(rs.getString("req_planned"));
		    	
		    	
		    	dBean.setDesHld(rs.getString("des_hld"));
		    	dBean.setDesHldTube(rs.getString("des_hld_tube"));
		    	dBean.setDesHldTubeDueDate(rs.getString("des_hld_tube_due_date"));
		    	dBean.setDesHldBc(rs.getString("des_hld_bc"));
		    	dBean.setDesHldBcDueDate(rs.getString("des_hld_bc_due_date"));
		    	dBean.setDesHldinv(rs.getString("des_hld_inv"));
		    	dBean.setDesHldinvDueDate(rs.getString("des_hld_inv_due_date"));
		    	dBean.setDesHldPi(rs.getString("des_hld_pi"));
		    	dBean.setDesHldPiDueDate(rs.getString("des_hld_pi_due_date"));
		    	
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesIaIa(rs.getString("des_ia_ia"));
		    	dBean.setDesIaIaDueDate(rs.getString("des_ia_ia_due_date"));
		    	
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesAdTube(rs.getString("des_ad_tube"));
		    	dBean.setDesAdTubeDueDate(rs.getString("des_ad_tube_due_date"));
		    	dBean.setDesAdBc(rs.getString("des_ad_bc"));
		    	dBean.setDesAdBcDueDate(rs.getString("des_ad_bc_due_date"));
		    	dBean.setDesAdinv(rs.getString("des_ad_inv"));
		    	dBean.setDesAdinvDueDate(rs.getString("des_ad_inv_due_date"));
		    	
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDesCwPi(rs.getString("des_cw_pi"));
		    	dBean.setDesCwPiDueDate(rs.getString("des_cw_pi_due_date"));

		    	//DEVELOPMENT
		    	//dev utd
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevUtdTube(rs.getString("dev_utd_tube"));
		    	dBean.setDevUtdTubeDueDate(rs.getString("dev_utd_due_date")); 
		    	dBean.setDevUtdBc(rs.getString("dev_utd_bc")); 
		    	dBean.setDevUtdBcDueDate(rs.getString("dev_utd_bc_due_date")); 
		    	dBean.setDevUtdInv(rs.getString("dev_utd_inv")); 
		    	dBean.setDevUtdInvDueDate(rs.getString("dev_utd_inv_due_date")); 
		    	//dev std
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevStdStsr(rs.getString("dev_std_stsr")); 
		    	dBean.setDevStdStsrDueDate(rs.getString("dev_std_stsr_due_date")); 
		    	dBean.setDevStdTestData(rs.getString("dev_std_testdata")); 
		    	dBean.setDevStdTestDataDueDate(rs.getString("dev_std_testdata_due_date")); 
		    	//dev tap
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevTapPi(rs.getString("dev_tap_pi")); 
		    	dBean.setDevTapPiDueDate(rs.getString("dev_tap_pi_due_date")); 
		    	//dev code
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevCodeTube(rs.getString("dev_code_tube")); 
		    	dBean.setDevCodeTubeDueDate(rs.getString("dev_code_tube_due_date")); 
		    	dBean.setDevCodeBc(rs.getString("dev_code_bc")); 
		    	dBean.setDevCodeBcDueDate(rs.getString("dev_code_bc_due_date")); 
		    	dBean.setDevCodeInv(rs.getString("dev_code_inv")); 
		    	dBean.setDevCodeInvDueDate(rs.getString("dev_code_inv_due_date")); 
		    	//dev ut
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setDevUtTube(rs.getString("dev_ut_tube")); 
		    	dBean.setDevUtTubeDueDate(rs.getString("dev_ut_tube_due_date")); 
		    	dBean.setDevUtBc(rs.getString("dev_ut_bc")); 
		    	dBean.setDevUtBcDueDate(rs.getString("dev_ut_bc_due_date")); 
		    	dBean.setDevUtInv(rs.getString("dev_ut_inv")); 
		    	dBean.setDevUtInvDueDate(rs.getString("dev_ut_inv_due_date")); 
		    	
		    	dBean.setMethodology(rs.getString("methodology"));
		    	
		    	
		
				dlist.add(dBean);

		    }
		    stmt.close();
		    
		} catch (Exception e) {
		    System.out.println("Fail on select: " + e.getMessage());
		}
		
		return dlist;
	    }
		
	
	
	public List<DashboardBean> selectDashboardLean(){
		
		List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
		try {
		    
		    PreparedStatement stmt = con.prepareStatement("Select application, project_id, project_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, "
		    		+ "pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, "
		    		+ "i_type, i_tube, i_bc, i_inv, req_srs, i_pi, des_hld, des_ia, des_ad, des_cw, dev_utd, dev_std, dev_tap, dev_code, dev_ut, methodology  from dashboard where methodology = 'lean'");
		    
		    ResultSet rs = stmt.executeQuery();
		    
		    while(rs.next()){
			
		    	DashboardBean dBean = new DashboardBean();
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));	    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		    	dBean.setPiApm(rs.getString("pi_apm"));		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSchedule(rs.getString("sc_schedule"));	    	
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiPi(rs.getString("i_pi"));
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setDesHld(rs.getString("des_hld"));
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setMethodology(rs.getString("methodology"));
		
				dlist.add(dBean);

		    }
		    stmt.close();
		    
		} catch (SQLException e) {
		    System.out.println("Fail on select: " + e.getSQLState());
		}
		
		return dlist;
	    }
	
	
	public List<DashboardBean> selectDashboardWaterfall(){
		
		List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
		try {
		    
		    PreparedStatement stmt = con.prepareStatement("Select application, project_id, project_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, "
		    		+ "pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, "
		    		+ "i_type, i_tube, i_bc, i_inv, req_srs, i_pi, des_hld, des_ia, des_ad, des_cw, dev_utd, dev_std, dev_tap, dev_code, dev_ut, methodology  from dashboard where methodology = 'waterfall'");
		    
		    ResultSet rs = stmt.executeQuery();
		    
		    while(rs.next()){
			
		    	DashboardBean dBean = new DashboardBean();
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));	    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		    	dBean.setPiApm(rs.getString("pi_apm"));		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSchedule(rs.getString("sc_schedule"));	    	
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiPi(rs.getString("i_pi"));
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setDesHld(rs.getString("des_hld"));
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setMethodology(rs.getString("methodology"));
		
				dlist.add(dBean);

		    }
		    stmt.close();
		    
		} catch (SQLException e) {
		    System.out.println("Fail on select: " + e.getSQLState());
		}
		
		return dlist;
	    }
	
	
	
	public Map<Integer, List<DashboardBean>> getDashBoardManagerByGet(){
	    
	    Map<Integer, List<DashboardBean>> beanMap = new HashMap<Integer, List<DashboardBean>>(); 
	    List<DashboardBean> listBean = new ArrayList<DashboardBean>();
	   
	    
	    
	    try{
		
		
		 PreparedStatement stmt = con.prepareStatement("Select application, project_id, project_name, manager_id, manager_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, i_type, i_tube, i_bc, i_inv, req_srs, i_pi, des_hld, des_ia, des_ad, des_cw, dev_utd, dev_std, dev_tap, dev_code, dev_ut, methodology from dashboard order by manager_id;");
		    
		    ResultSet rs = stmt.executeQuery();
		    
		    
		    int numManager = 0;
		 
		    while(rs.next()){
			   DashboardBean dBean = new DashboardBean();
			   
			   
			    dBean.setManagerId(rs.getInt("manager_id"));
 			    dBean.setManagerName(rs.getString("manager_name"));
 		    	    dBean.setApplication(rs.getString("application"));
 		    	    dBean.setProjectId(rs.getInt("project_id"));
			 
			 if(numManager > 0){
        				if(rs.getInt("manager_id") != listBean.get(numManager - 1).getManagerId()){
        				        
        				    System.out.println(".."+rs.getString("manager_id")+"--"+listBean.get(numManager - 1).getManagerId());
//        				           dBean.setManagerId(rs.getInt("manager_id"));
//        					   dBean.setManagerName(rs.getString("manager_name"));
//        				    	   dBean.setApplication(rs.getString("application"));
//        				    	   dBean.setProjectId(rs.getInt("project_id"));
        				    	
        				    	   beanMap.put(numManager, listBean);
        				    	   
        				    	   System.out.println("valor gravado: "+listBean.get(0).getManagerName());
        				    	   
        				    	   listBean.clear();
        					   numManager = 0;    
        					

       				    }
			 }

			    System.out.println(".."+rs.getString("manager_name"));
    			  
		         	
			    
				listBean.add(dBean);
				numManager += 1;	
				
		    }
		    beanMap.put(numManager, listBean);
		    stmt.close();
		
		
	    }catch(Exception ex){
		System.out.println("problem: ->>>> "+ex.getMessage());
	    }
	    
	    
	    
	    return beanMap;
	    
	}
	
	public List<DashboardBean> selectProjectsFromManager(int pm){
	    List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
	   // Connection dbConnection = null;
	    PreparedStatement preparedStatement = null;
		
		try {
		    String query = "SELECT u.name, u.id_user, u.user_name, a.dashboard_id, a.project_id, a.application, a.project_name, "
	    		    	+ "a.project_state, a.sdlc, a.project_status, a.comments, a.jeopardy_list, a.issue, a.pi_ftps, a.pi_ftps_currentmonth, a.pi_ftps_nextmonth, "
	    		    	+ "a.pi_crs, a.pi_se, a.pi_ibmpm, a.pi_apm, a.sc_release, a.sc_testingtarget, a.sc_sprint, a.sc_schedule, a.i_type, a.i_tube, a.i_bc, "
	    		    	+ "a.i_inv, a.i_pi, a.dev_utd, a.dev_utd_tube, a.dev_utd_tube_resource, a.dev_utd_tube_due_date, a.dev_utd_tube_planned, a.dev_utd_bc, "
	    		    	+ "a.dev_utd_bc_resource, a.dev_utd_bc_due_date, a.dev_utd_bc_planned, a.dev_utd_inv, a.dev_utd_inv_resource, a.dev_utd_inv_due_date, "
	    		    	+ "a.dev_utd_inv_planned, a.dev_std, a.dev_std_stsr, a.dev_std_stsr_resource, a.dev_std_stsr_due_date, a.dev_std_stsr_planned, "
	    		    	+ "a.dev_std_testdata, a.dev_std_testdata_resource, a.dev_std_testdata_due_date, a.dev_std_testdata_planned, a.dev_tap, "
	    		    	+ "a.dev_tap_pi, a.dev_tap_pi_resource, a.dev_tap_pi_due_date, a.dev_tap_pi_planned, a.dev_code, a.dev_code_tube, a.dev_code_tube_resource, "
	    		    	+ "a.dev_code_tube_due_date, a.dev_code_tube_planned, a.dev_code_bc, a.dev_code_bc_resource, a.dev_code_bc_due_date, a.dev_code_bc_planned, "
	    		    	+ "a.dev_code_inv, a.dev_code_inv_resource, a.dev_code_inv_due_date, a.dev_code_inv_planned, a.dev_ut, a.dev_ut_tube, a.dev_ut_tube_resource, "
	    		    	+ "a.dev_ut_tube_due_date, a.dev_ut_tube_planned, a.dev_ut_bc, a.dev_ut_bc_resource, a.dev_ut_bc_due_date, a.dev_ut_bc_planned, a.dev_ut_inv, "
	    		    	+ "a.dev_ut_inv_resource, a.dev_ut_inv_due_date, a.dev_ut_inv_planned, a.des_hld, a.des_hld_tube, a.des_hld_tube_resource, "
	    		    	+ "a.des_hld_tube_due_date, a.des_hld_tube_planned, a.des_hld_bc, a.des_hld_bc_resource, a.des_hld_bc_due_date, a.des_hld_bc_planned, "
	    		    	+ "a.des_hld_inv, a.des_hld_inv_resource, a.des_hld_inv_due_date, a.des_hld_inv_planned, a.des_hld_pi, a.des_hld_pi_resource, "
	    		    	+ "a.des_hld_pi_due_date, a.des_hld_pi_planned, a.des_ia, a.des_ia_ia, a.des_ia_ia_resource, a.des_ia_ia_due_date, a.des_ia_ia_planned, "
	    		    	+ "a.des_ad, a.des_ad_tube, a.des_ad_tube_resource, a.des_ad_tube_due_date, a.des_ad_tube_planned, a.des_ad_bc, a.des_ad_bc_resource, "
	    		    	+ "a.des_ad_bc_due_date, a.des_ad_bc_planned, a.des_ad_inv, a.des_ad_inv_resource, a.des_ad_inv_due_date, a.des_ad_inv_planned, "
	    		    	+ "a.des_cw, a.des_cw_pi, a.des_cw_pi_resource, a.des_cw_pi_due_date, a.des_cw_pi_planned, a.req_srs, a.req_srs_status, "
	    		    	+ "a.req_srs_base_line_date, a.req_srs_due_date, a.req_srs_planned, a.user_project_id, a.deliverable_id, a.methodology_id, u.last_name "
	    		    	+ "FROM "
	    		    	+ "dashboard a, user_project u where u.id_user = a.user_project_id AND u.id_user =? order by a.methodology_id";		    
		    //dbConnection = ConnectionDAO.getConection();
		    preparedStatement = con.prepareStatement(query);
		    preparedStatement.setInt(1, pm);
		    ResultSet rs = preparedStatement.executeQuery();
		 
	    	    ResultSetMetaData rsmd = rs.getMetaData();    
	    	
		   
			
			while(rs.next()){
				
				DashboardBean dBean = new DashboardBean();
		    	
		    	
				dBean.setManagerName(rs.getString("name"));
		    	dBean.setManagerNameLabel(rsmd.getColumnLabel(1));
		    	
		    	dBean.setManagerId(rs.getInt("id_user"));
		    	dBean.setManagerIdLabel(rsmd.getColumnLabel(2));
		    	
		    	dBean.setManagerUserName(rs.getString("user_name"));
		    	dBean.setManagerUserNameLabel(rsmd.getColumnLabel(3));
		    	
		      	dBean.setDashboardId(rs.getInt("dashboard_id"));//nao tem label
		    	
				dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectIdLabel(rsmd.getColumnLabel(5));
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setApplicationLabel(rsmd.getColumnLabel(6));
		    	
		    
		    	
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectNameLabel(rsmd.getColumnLabel(7));
		    	
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setProjectStateLabel(rsmd.getColumnLabel(8));
		    	
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setSdlcLabel(rsmd.getColumnLabel(9));
		    	
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setProjectStatusLabel(rsmd.getColumnLabel(10));
		    	
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setCommentsLabel(rsmd.getColumnLabel(11));
		    	
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setJeopardyListLabel(rsmd.getColumnLabel(12));
		    	
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setIssueLabel(rsmd.getColumnLabel(13));
		    	
		    	
		    	
		
		    	
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsLabel(rsmd.getColumnLabel(14));
		    	
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsCurrentMonthLabel(rsmd.getColumnLabel(15));
		    	
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));
		    	dBean.setPiFtpsNextMonthLabel(rsmd.getColumnLabel(16));
		    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiCrsLabel(rsmd.getColumnLabel(17));
		    	
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		    	dBean.setPiSeLabel(rsmd.getColumnLabel(18));
		    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		     	dBean.setPiIbmPmLabel(rsmd.getColumnLabel(19));
		     	
		    	dBean.setPiApm(rs.getString("pi_apm"));		
		    	dBean.setPiApmLabel(rsmd.getColumnLabel(20));
		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScReleaseLabel(rsmd.getColumnLabel(21));
		    	
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScTestingTargetLabel(rsmd.getColumnLabel(22));
		    	
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSprintLabel(rsmd.getColumnLabel(23));
		    	
		    	dBean.setScSchedule(rs.getString("sc_schedule"));
		    	dBean.setScScheduleLabel(rsmd.getColumnLabel(24));
		    	
		    	//-----impact----
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTypeLabel(rsmd.getColumnLabel(25));
		    	
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiTubeLabel(rsmd.getColumnLabel(26));
		    	//System.out.println(rsmd.getColumnName(24)+"------------"+rsmd.getColumnLabel(24));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiBcLabel(rsmd.getColumnLabel(27));
		    	
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiInvLabel(rsmd.getColumnLabel(28));
		    	
		    	dBean.setiPi(rs.getString("i_pi"));
		    	dBean.setiPiLabel(rsmd.getColumnLabel(29));
		    	//---fim de impact-----
		    	
		    	
		    	//-----------------------------------------------
		    	//-----------------------------------------------
			///----------------------BEGIN OF DEVELOPMENT-----------------
		    	
		    	//--------------UTD------------------------------
		    			    			    	
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevUtdLabel(rsmd.getColumnLabel(30));
		    	//---------------utd - tube-----
		    	dBean.setDevUtdTube(rs.getString("dev_utd_tube"));
		    	dBean.setDevUtdTubeLabel(rsmd.getColumnLabel(31));
		    	
		    	dBean.setDevUtdTubeResource(rs.getString("dev_utd_tube_resource"));
		    	dBean.setDevUtdTubeResourceLabel(rsmd.getColumnLabel(32));
		    	
		    	dBean.setDevUtdTubeDueDate(rs.getString("dev_utd_tube_due_date"));
		    	dBean.setDevUtdTubeDueDateLabel(rsmd.getColumnLabel(33));
		    	
		    	dBean.setDevUtdTubePlanned(rs.getString("dev_utd_tube_planned"));
		    	dBean.setDevUtdTubePlannedLabel(rsmd.getColumnLabel(34));
		    	//--------------------utd - bc---------------
		    	dBean.setDevUtdBc(rs.getString("dev_utd_bc"));
		    	dBean.setDevUtdBcLabel(rsmd.getColumnLabel(35));

		    	dBean.setDevUtdBcResource(rs.getString("dev_utd_bc_resource"));
		    	dBean.setDevUtdBcResourceLabel(rsmd.getColumnLabel(36));

		    	dBean.setDevUtdBcDueDate(rs.getString("dev_utd_bc_due_date"));
		    	dBean.setDevUtdBcDueDateLabel(rsmd.getColumnLabel(37));

		    	dBean.setDevUtdBcPlanned(rs.getString("dev_utd_bc_planned"));
		    	dBean.setDevUtdBcPlannedLabel(rsmd.getColumnLabel(38));
		    	//-------------------utd - inv----------------
		    	dBean.setDevUtdInv(rs.getString("dev_utd_inv"));
		    	dBean.setDevUtdInvLabel(rsmd.getColumnLabel(39));

		    	dBean.setDevUtdInvResource(rs.getString("dev_utd_inv_resource"));
		    	dBean.setDevUtdInvResourceLabel(rsmd.getColumnLabel(40));

		    	dBean.setDevUtdInvDueDate(rs.getString("dev_utd_inv_due_date"));
		    	dBean.setDevUtdInvDueDateLabel(rsmd.getColumnLabel(41));

		    	dBean.setDevUtdInvPlanned(rs.getString("dev_utd_inv_planned"));
		    	dBean.setDevUtdInvPlannedLabel(rsmd.getColumnLabel(41));
		    	//----------------------STD------------------------
		    	
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevStdLabel(rsmd.getColumnLabel(43));
		    	//-----------------------std - strs -------------
		    	
		    	dBean.setDevStdStsr(rs.getString("dev_std_stsr"));
		    	dBean.setDevStdStsrLabel(rsmd.getColumnLabel(44));
		    	
		    	dBean.setDevStdStsrResource(rs.getString("dev_std_stsr_resource"));
		    	dBean.setDevStdStsrResourceLabel(rsmd.getColumnLabel(45));
		    	
		    	dBean.setDevStdStsrDueDate(rs.getString("dev_std_stsr_due_date"));
		    	dBean.setDevStdStsrDueDateLabel(rsmd.getColumnLabel(46));
		    	
		    	dBean.setDevStdStsrPlanned(rs.getString("dev_std_stsr_planned"));
		    	dBean.setDevStdStsrPlannedLabel(rsmd.getColumnLabel(47));
		    	
		    	//-----------------------std - testdata -------------
		    	
		    	dBean.setDevStdTestData(rs.getString("dev_std_testdata"));
		    	dBean.setDevStdTestDataLabel(rsmd.getColumnLabel(48));
		    	
		    	dBean.setDevStdTestDataResource(rs.getString("dev_std_testdata_resource"));
		    	dBean.setDevStdTestDataResourceLabel(rsmd.getColumnLabel(49));
		    	
		    	dBean.setDevStdTestDataDueDate(rs.getString("dev_std_testdata_due_date"));
		    	dBean.setDevStdTestDataDueDateLabel(rsmd.getColumnLabel(50));
		    	
		    	dBean.setDevStdTestDataPlanned(rs.getString("dev_std_testdata_planned"));
		    	dBean.setDevStdTestDataPlannedLabel(rsmd.getColumnLabel(51));
		    	
		    	//------------------TAP---------
		    	
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevTapLabel(rsmd.getColumnLabel(52));
		    	
		    	//---------------tap pi -------------
		    	
		    	dBean.setDevTapPi(rs.getString("dev_tap_pi"));
		    	dBean.setDevTapPiLabel(rsmd.getColumnLabel(53));
		    	
		    	dBean.setDevTapPiResource(rs.getString("dev_tap_pi_resource"));
		    	dBean.setDevTapPiResourceLabel(rsmd.getColumnLabel(54));
		    	
		    	dBean.setDevTapPiDueDate(rs.getString("dev_tap_pi_due_date"));
		    	dBean.setDevTapPiDueDateLabel(rsmd.getColumnLabel(55));
		    	
		    	dBean.setDevTapPiPlanned(rs.getString("dev_tap_pi_planned"));
		    	dBean.setDevTapPiPlannedLabel(rsmd.getColumnLabel(56));
		    	
		    	//--------------------CODE--------------------
		    	
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevCodeLabel(rsmd.getColumnLabel(57));
		    	//-----------------------code-tube----------------
		    	
		    	dBean.setDevCodeTube(rs.getString("dev_code_tube"));
		    	dBean.setDevCodeTubeLabel(rsmd.getColumnLabel(58));
		    	
		    	dBean.setDevCodeTubeResource(rs.getString("dev_code_tube_resource"));
		    	dBean.setDevCodeTubeResourceLabel(rsmd.getColumnLabel(59));
		    	
		    	dBean.setDevCodeTubeDueDate(rs.getString("dev_code_tube_due_date"));
		    	dBean.setDevCodeTubeDueDateLabel(rsmd.getColumnLabel(60));
		    	
		    	dBean.setDevCodeTubePlanned(rs.getString("dev_code_tube_planned"));
		    	dBean.setDevCodeTubePlannedLabel(rsmd.getColumnLabel(61));
		    	//---------------------------code-bc-------------------
		    	
		    	
		    	dBean.setDevCodeBc(rs.getString("dev_code_bc"));
		    	dBean.setDevCodeBcLabel(rsmd.getColumnLabel(62));
		    	
		    	dBean.setDevCodeBcResource(rs.getString("dev_code_bc_resource"));
		    	dBean.setDevCodeBcResourceLabel(rsmd.getColumnLabel(63));
		    	
		    	dBean.setDevCodeBcDueDate(rs.getString("dev_code_bc_due_date"));
		    	dBean.setDevCodeBcDueDateLabel(rsmd.getColumnLabel(64));
		    	
		    	dBean.setDevCodeBcPlanned(rs.getString("dev_code_bc_planned"));
		    	dBean.setDevCodeBcPlannedLabel(rsmd.getColumnLabel(65));
		    	//----------------------code-inv----------------
		    	
		    	dBean.setDevCodeInv(rs.getString("dev_code_inv"));
		    	dBean.setDevCodeInvLabel(rsmd.getColumnLabel(66));
		    	
		    	dBean.setDevCodeInvResource(rs.getString("dev_code_inv_resource"));
		    	dBean.setDevCodeInvResourceLabel(rsmd.getColumnLabel(67));
		    	
		    	dBean.setDevCodeInvDueDate(rs.getString("dev_code_inv_due_date"));
		    	dBean.setDevCodeInvDueDateLabel(rsmd.getColumnLabel(68));
		    	
		    	dBean.setDevCodeInvPlanned(rs.getString("dev_code_inv_planned"));
		    	dBean.setDevCodeInvPlannedLabel(rsmd.getColumnLabel(69));
		    	
		    	//-------------------UT----------------------
		    	
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setDevUtLabel(rsmd.getColumnLabel(70));
		    	
		    	//--------------------------ut-tube------------------
		    	
		    	dBean.setDevUtTube(rs.getString("dev_ut_tube"));
		    	dBean.setDevUtTubeLabel(rsmd.getColumnLabel(71));
		    	
		    	dBean.setDevUtTubeResource(rs.getString("dev_ut_tube_resource"));
		    	dBean.setDevUtTubeResourceLabel(rsmd.getColumnLabel(72));
		    	
		    	dBean.setDevUtTubeDueDate(rs.getString("dev_ut_tube_due_date"));
		    	dBean.setDevUtTubeDueDateLabel(rsmd.getColumnLabel(73));
		    	
		    	dBean.setDevUtTubePlanned(rs.getString("dev_ut_tube_planned"));
		    	dBean.setDevUtTubePlannedLabel(rsmd.getColumnLabel(74));
		    	
		    	//-------------------------ut-bc------------------------------
		    	
		    	dBean.setDevUtBc(rs.getString("dev_ut_bc"));
		    	dBean.setDevUtBcLabel(rsmd.getColumnLabel(75));
		    	
		    	dBean.setDevUtBcResource(rs.getString("dev_ut_bc_resource"));
		    	dBean.setDevUtBcResourceLabel(rsmd.getColumnLabel(76));
		    	
		    	dBean.setDevUtBcDueDate(rs.getString("dev_ut_bc_due_date"));
		    	dBean.setDevUtBcDueDateLabel(rsmd.getColumnLabel(77));
		    	
		    	dBean.setDevUtBcPlanned(rs.getString("dev_ut_bc_planned"));
		    	dBean.setDevUtBcPlannedLabel(rsmd.getColumnLabel(78));
		    	//--------------------ut - inv---------------------------
		    	
		    	dBean.setDevUtInv(rs.getString("dev_ut_inv"));
		    	dBean.setDevUtInvLabel(rsmd.getColumnLabel(79));
		    	
		    	dBean.setDevUtInvResource(rs.getString("dev_ut_inv_resource"));
		    	dBean.setDevUtInvResourceLabel(rsmd.getColumnLabel(80));
		    	
		    	dBean.setDevUtInvDueDate(rs.getString("dev_ut_inv_due_date"));
		    	dBean.setDevUtInvDueDateLabel(rsmd.getColumnLabel(81));
		    	
		    	dBean.setDevUtInvPlanned(rs.getString("dev_ut_inv_planned"));
		    	dBean.setDevUtInvPlannedLabel(rsmd.getColumnLabel(82));
		    	
		    	//-----------------------END OF DEVELOPMENT-----------------
		    	//-----------------------------------------------------------
		    	
		    	///----------------------BEGIN OF DESIGN-----------------
		    	
		    	
		    	//-----------------begin of HLD------------
		    	dBean.setDesHld(rs.getString("des_hld"));  
		    	dBean.setDesHldLabel(rsmd.getColumnLabel(83));
		    	
			//---tube
		    	dBean.setDesHldTube(rs.getString("des_hld_tube"));
		    	dBean.setDesHldTubeLabel(rsmd.getColumnLabel(84));
		    	
		    	dBean.setDesHldTubeResource(rs.getString("des_hld_tube_resource"));
		    	dBean.setDesHldTubeResourceLabel(rsmd.getColumnLabel(85));
		    	
		    	dBean.setDesHldTubeDueDate(rs.getString("des_hld_tube_due_date"));
		    	dBean.setDesHldTubeDueDateLabel(rsmd.getColumnLabel(86));
		    	
		    	dBean.setDesHldTubePlanned(rs.getString("des_hld_tube_planned"));
		    	dBean.setDesHldTubePlannedLabel(rsmd.getColumnLabel(87));
		    	
		 	//----------BC
		    	dBean.setDesHldBc(rs.getString("des_hld_bc"));
		    	dBean.setDesHldBcLabel(rsmd.getColumnLabel(88));
		    	
		    	dBean.setDesHldBcResource(rs.getString("des_hld_bc_resource"));
		    	dBean.setDesHldBcResourceLabel(rsmd.getColumnLabel(89));
		    	
		    	dBean.setDesHldBcDueDate(rs.getString("des_hld_bc_due_date"));
		    	dBean.setDesHldBcDueDateLabel(rsmd.getColumnLabel(90));
		    	
		    	dBean.setDesHldBcPlanned(rs.getString("des_hld_bc_planned"));
		    	dBean.setDesHldBcPlannedLabel(rsmd.getColumnLabel(91));
		    	
		    	//----------------inv
			dBean.setDesHldinv(rs.getString("des_hld_inv"));
		    	dBean.setDesHldinvLabel(rsmd.getColumnLabel(92));
		    	
		    	dBean.setDesHldinvResource(rs.getString("des_hld_inv_resource"));
		    	dBean.setDesHldinvResourceLabel(rsmd.getColumnLabel(93));
		    	
		    	dBean.setDesHldinvDueDate(rs.getString("des_hld_inv_due_date"));
		    	dBean.setDesHldinvDueDateLabel(rsmd.getColumnLabel(94));
		    	
		    	dBean.setDesHldinvPlanned(rs.getString("des_hld_inv_planned"));
		    	dBean.setDesHldinvPlannedLabel(rsmd.getColumnLabel(95));
		    	
		    	//------------------pi
		    	
			dBean.setDesHldPi(rs.getString("des_hld_pi"));
			dBean.setDesHldPiLabel(rsmd.getColumnLabel(96));
		   	
			dBean.setDesHldPiResource(rs.getString("des_hld_pi_resource"));
		   	dBean.setDesHldPiResourceLabel(rsmd.getColumnLabel(97));
		   	
		   	dBean.setDesHldPiDueDate(rs.getString("des_hld_pi_due_date"));
		   	dBean.setDesHldPiDueDateLabel(rsmd.getColumnLabel(98));
		   	
		   	dBean.setDesHldPiPlanned(rs.getString("des_hld_pi_planned"));
		   	dBean.setDesHldPiPlannedLabel(rsmd.getColumnLabel(99));
		    	
		   	//---------------ia---------------
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesIaLabel(rsmd.getColumnLabel(100));
		    	
		    	dBean.setDesIaIa(rs.getString("des_ia_ia"));
		    	dBean.setDesIaIaLabel(rsmd.getColumnLabel(101));
		    	
		    	dBean.setDesIaIaResource(rs.getString("des_ia_ia_resource"));
		    	dBean.setDesIaIaResourceLabel(rsmd.getColumnLabel(102));
		    	
		    	dBean.setDesIaIaDueDate(rs.getString("des_ia_ia_due_date"));
		    	dBean.setDesIaIaDueDateLabel(rsmd.getColumnLabel(103));
		    	
		    	dBean.setDesIaIaPlanned(rs.getString("des_ia_ia_planned"));
		    	dBean.setDesIaIaPlannedLabel(rsmd.getColumnLabel(104));
		    	

		    	
		    	//-----------------AD--------------
		    	
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesAdLabel(rsmd.getColumnLabel(105));
		    	//-------------ad - tube-----------------
		    	dBean.setDesAdTube(rs.getString("des_ad_tube"));
		    	dBean.setDesAdTubeLabel(rsmd.getColumnLabel(106));
		    	
		    	dBean.setDesAdTubeResource(rs.getString("des_ad_tube_resource"));
		    	dBean.setDesAdTubeResourceLabel(rsmd.getColumnLabel(107));
		    	
		    	dBean.setDesAdTubeDueDate(rs.getString("des_ad_tube_due_date"));
		    	dBean.setDesAdTubeDueDateLabel(rsmd.getColumnLabel(108));
		    	
		    	dBean.setDesAdTubePlanned(rs.getString("des_ad_tube_planned"));
		    	dBean.setDesAdTubePlannedLabel(rsmd.getColumnLabel(109));
		    	//---------------ad - bc --------------------
		    	
		    	dBean.setDesAdBc(rs.getString("des_ad_bc"));
		    	dBean.setDesAdBcLabel(rsmd.getColumnLabel(110));
		    	
		    	dBean.setDesAdBcResource(rs.getString("des_ad_bc_resource"));
		    	dBean.setDesAdBcResourceLabel(rsmd.getColumnLabel(111));
		    	
		    	dBean.setDesAdBcDueDate(rs.getString("des_ad_bc_due_date"));
		    	dBean.setDesAdBcDueDateLabel(rsmd.getColumnLabel(112));
		    	
		    	dBean.setDesAdBcPlanned(rs.getString("des_ad_bc_planned"));
		    	dBean.setDesAdBcPlannedLabel(rsmd.getColumnLabel(113));
		    	//-------------------ad - inv -----------------------
		    	
		    	dBean.setDesAdinv(rs.getString("des_ad_inv"));
		    	dBean.setDesAdinvLabel(rsmd.getColumnLabel(114));
		    	
		    	dBean.setDesAdinvResource(rs.getString("des_ad_inv_resource"));
		    	dBean.setDesAdinvResourceLabel(rsmd.getColumnLabel(115));
		    	
		    	dBean.setDesAdinvDueDate(rs.getString("des_ad_inv_due_date"));
		    	dBean.setDesAdinvDueDateLabel(rsmd.getColumnLabel(116));
		    	
		    	dBean.setDesAdinvPlanned(rs.getString("des_ad_inv_planned"));
		    	dBean.setDesAdinvPlannedLabel(rsmd.getColumnLabel(117));
		    	
		    	
		    	//-------------------CW--------------------
		    	
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDesCwLabel(rsmd.getColumnLabel(118));
		    	
		    	dBean.setDesCwPi(rs.getString("des_cw_pi"));
		    	dBean.setDesCwPiLabel(rsmd.getColumnLabel(119));
		    	
		    	dBean.setDesCwPiResource(rs.getString("des_cw_pi_resource"));
		    	dBean.setDesCwPiResourceLabel(rsmd.getColumnLabel(120));
		    	
		    	dBean.setDesCwPiDueDate(rs.getString("des_cw_pi_due_date"));
		    	dBean.setDesCwPiDueDateLabel(rsmd.getColumnLabel(121));
		    	
		    	dBean.setDesCwPiPlanned(rs.getString("des_cw_pi_planned"));
		    	dBean.setDesCwPiPlannedLabel(rsmd.getColumnLabel(122));
		    	///---------------------END OF DESIGN-----------------------
		    	//-----------------------------------------------------
		    	
		    	
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setReqSrsLabel(rsmd.getColumnLabel(123));
		    	
		    	dBean.setReqStatus(rs.getString("req_srs_status"));
		    	dBean.setReqStatusLabel(rsmd.getColumnLabel(124));
		    	
		    	dBean.setReqBaselineDate(rs.getString("req_srs_base_line_date"));
		    	dBean.setReqDueDate(rsmd.getColumnLabel(125));
		    	
		    	dBean.setReqDueDate(rs.getString("req_srs_due_date"));
		    	dBean.setReqDueDateLabel(rsmd.getColumnLabel(126));
		    	
		    	
		    	dBean.setReqPlanned(rs.getString("req_srs_planned"));
		    	dBean.setReqPlannedLabel(rsmd.getColumnLabel(127));
		    	//-----end of requirement--------------
		    	
		    	
		    	dBean.setUserProjectId(rs.getInt("user_project_id"));
		    	dBean.setUserProjectIdLabel(rsmd.getColumnLabel(128));
		    	
		    	dBean.setDeliverableId(rs.getInt("deliverable_id"));
		    	dBean.setDeliverableIdLabel(rsmd.getColumnLabel(129));
		    	
		    	
		    	
//			dBean.setMethodology(rs.getString("methodology"));
//		    	dBean.setMethodologyLabel(rsmd.getColumnLabel(38));
//	
			dBean.setMethodologyId(rs.getInt("methodology_id"));
		    	dBean.setMethodologyIdLabel(rsmd.getColumnLabel(130));
		    	
		    	dBean.setLastName(rs.getString("last_name"));
		    	
		    	
		
		    	System.out.println(dBean.getProjectId()+"project teste\n");
		    	
				dlist.add(dBean);

			}
			preparedStatement.close();
			    
			} catch (SQLException e) {
			    System.out.println("Fail on select: " + e.getMessage());
			}
			
			return dlist;

	}
	
	
	public List<DashboardBean> selectProjectsGroupByManagers(){
		
	    List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
		try {
		    
		    String query = "SELECT u.name, u.id_user, u.user_name, a.dashboard_id, a.project_id, a.application, a.project_name, "
		    	+ "a.project_state, a.sdlc, a.project_status, a.comments, a.jeopardy_list, a.issue, a.pi_ftps, a.pi_ftps_currentmonth, a.pi_ftps_nextmonth, "
		    	+ "a.pi_crs, a.pi_se, a.pi_ibmpm, a.pi_apm, a.sc_release, a.sc_testingtarget, a.sc_sprint, a.sc_schedule, a.i_type, a.i_tube, a.i_bc, "
		    	+ "a.i_inv, a.i_pi, a.dev_utd, a.dev_utd_tube, a.dev_utd_tube_resource, a.dev_utd_tube_due_date, a.dev_utd_tube_planned, a.dev_utd_bc, "
		    	+ "a.dev_utd_bc_resource, a.dev_utd_bc_due_date, a.dev_utd_bc_planned, a.dev_utd_inv, a.dev_utd_inv_resource, a.dev_utd_inv_due_date, "
		    	+ "a.dev_utd_inv_planned, a.dev_std, a.dev_std_stsr, a.dev_std_stsr_resource, a.dev_std_stsr_due_date, a.dev_std_stsr_planned, "
		    	+ "a.dev_std_testdata, a.dev_std_testdata_resource, a.dev_std_testdata_due_date, a.dev_std_testdata_planned, a.dev_tap, "
		    	+ "a.dev_tap_pi, a.dev_tap_pi_resource, a.dev_tap_pi_due_date, a.dev_tap_pi_planned, a.dev_code, a.dev_code_tube, a.dev_code_tube_resource, "
		    	+ "a.dev_code_tube_due_date, a.dev_code_tube_planned, a.dev_code_bc, a.dev_code_bc_resource, a.dev_code_bc_due_date, a.dev_code_bc_planned, "
		    	+ "a.dev_code_inv, a.dev_code_inv_resource, a.dev_code_inv_due_date, a.dev_code_inv_planned, a.dev_ut, a.dev_ut_tube, a.dev_ut_tube_resource, "
		    	+ "a.dev_ut_tube_due_date, a.dev_ut_tube_planned, a.dev_ut_bc, a.dev_ut_bc_resource, a.dev_ut_bc_due_date, a.dev_ut_bc_planned, a.dev_ut_inv, "
		    	+ "a.dev_ut_inv_resource, a.dev_ut_inv_due_date, a.dev_ut_inv_planned, a.des_hld, a.des_hld_tube, a.des_hld_tube_resource, "
		    	+ "a.des_hld_tube_due_date, a.des_hld_tube_planned, a.des_hld_bc, a.des_hld_bc_resource, a.des_hld_bc_due_date, a.des_hld_bc_planned, "
		    	+ "a.des_hld_inv, a.des_hld_inv_resource, a.des_hld_inv_due_date, a.des_hld_inv_planned, a.des_hld_pi, a.des_hld_pi_resource, "
		    	+ "a.des_hld_pi_due_date, a.des_hld_pi_planned, a.des_ia, a.des_ia_ia, a.des_ia_ia_resource, a.des_ia_ia_due_date, a.des_ia_ia_planned, "
		    	+ "a.des_ad, a.des_ad_tube, a.des_ad_tube_resource, a.des_ad_tube_due_date, a.des_ad_tube_planned, a.des_ad_bc, a.des_ad_bc_resource, "
		    	+ "a.des_ad_bc_due_date, a.des_ad_bc_planned, a.des_ad_inv, a.des_ad_inv_resource, a.des_ad_inv_due_date, a.des_ad_inv_planned, "
		    	+ "a.des_cw, a.des_cw_pi, a.des_cw_pi_resource, a.des_cw_pi_due_date, a.des_cw_pi_planned, a.req_srs, a.req_srs_status, "
		    	+ "a.req_srs_base_line_date, a.req_srs_due_date, a.req_srs_planned, a.user_project_id, a.deliverable_id, a.methodology_id, u.last_name "
		    	+ "FROM "
		    	+ "dashboard a, user_project u where u.id_user = a.user_project_id order by u.name";
		    
		    PreparedStatement stmt = con.prepareStatement(query);
//		    PreparedStatement stmt = con.prepareStatement("Select manager_id, manager_name, application, project_id, project_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, "
//		    		+ "pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, "
//		    		+ "i_type, i_tube, i_bc, i_inv, req_srs, i_pi, des_hld, des_ia, des_ad, des_cw, dev_utd, dev_std, dev_tap, dev_code, dev_ut, methodology, methodology_id  from dashboard order by methodology_id");
		    ResultSet rs = stmt.executeQuery();
		    ResultSetMetaData rsmd = rs.getMetaData();
		    while(rs.next()){
			
//			System.out.println("Segue: "+rs.getString("name")+"\n\n\n");
		    	DashboardBean dBean = new DashboardBean();
		    	
		    	
			dBean.setManagerName(rs.getString("name"));
		    	dBean.setManagerNameLabel(rsmd.getColumnLabel(1));
		    	
		    	dBean.setManagerId(rs.getInt("id_user"));
		    	dBean.setManagerIdLabel(rsmd.getColumnLabel(2));
		    	
		    	dBean.setManagerUserName(rs.getString("user_name"));
		    	dBean.setManagerUserNameLabel(rsmd.getColumnLabel(3));
		    	
		      	dBean.setDashboardId(rs.getInt("dashboard_id"));//nao tem label
		    	
			dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectIdLabel(rsmd.getColumnLabel(5));
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setApplicationLabel(rsmd.getColumnLabel(6));
		    	
		    
		    	
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectNameLabel(rsmd.getColumnLabel(7));
		    	
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setProjectStateLabel(rsmd.getColumnLabel(8));
		    	
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setSdlcLabel(rsmd.getColumnLabel(9));
		    	
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setProjectStatusLabel(rsmd.getColumnLabel(10));
		    	
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setCommentsLabel(rsmd.getColumnLabel(11));
		    	
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setJeopardyListLabel(rsmd.getColumnLabel(12));
		    	
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setIssueLabel(rsmd.getColumnLabel(13));
		    	
		    	
		    	
		
		    	
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsLabel(rsmd.getColumnLabel(14));
		    	
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsCurrentMonthLabel(rsmd.getColumnLabel(15));
		    	
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));
		    	dBean.setPiFtpsNextMonthLabel(rsmd.getColumnLabel(16));
		    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiCrsLabel(rsmd.getColumnLabel(17));
		    	
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		    	dBean.setPiSeLabel(rsmd.getColumnLabel(18));
		    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		     	dBean.setPiIbmPmLabel(rsmd.getColumnLabel(19));
		     	
		    	dBean.setPiApm(rs.getString("pi_apm"));		
		    	dBean.setPiApmLabel(rsmd.getColumnLabel(20));
		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScReleaseLabel(rsmd.getColumnLabel(21));
		    	
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScTestingTargetLabel(rsmd.getColumnLabel(22));
		    	
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSprintLabel(rsmd.getColumnLabel(23));
		    	
		    	dBean.setScSchedule(rs.getString("sc_schedule"));
		    	dBean.setScScheduleLabel(rsmd.getColumnLabel(24));
		    	
		    	//-----impact----
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTypeLabel(rsmd.getColumnLabel(25));
		    	
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiTubeLabel(rsmd.getColumnLabel(26));
		    	//System.out.println(rsmd.getColumnName(24)+"------------"+rsmd.getColumnLabel(24));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiBcLabel(rsmd.getColumnLabel(27));
		    	
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiInvLabel(rsmd.getColumnLabel(28));
		    	
		    	dBean.setiPi(rs.getString("i_pi"));
		    	dBean.setiPiLabel(rsmd.getColumnLabel(29));
		    	//---fim de impact-----
		    	
		    	
		    	//-----------------------------------------------
		    	//-----------------------------------------------
			///----------------------BEGIN OF DEVELOPMENT-----------------
		    	
		    	//--------------UTD------------------------------
		    			    			    	
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevUtdLabel(rsmd.getColumnLabel(30));
		    	//---------------utd - tube-----
		    	dBean.setDevUtdTube(rs.getString("dev_utd_tube"));
		    	dBean.setDevUtdTubeLabel(rsmd.getColumnLabel(31));
		    	
		    	dBean.setDevUtdTubeResource(rs.getString("dev_utd_tube_resource"));
		    	dBean.setDevUtdTubeResourceLabel(rsmd.getColumnLabel(32));
		    	
		    	dBean.setDevUtdTubeDueDate(rs.getString("dev_utd_tube_due_date"));
		    	dBean.setDevUtdTubeDueDateLabel(rsmd.getColumnLabel(33));
		    	
		    	dBean.setDevUtdTubePlanned(rs.getString("dev_utd_tube_planned"));
		    	dBean.setDevUtdTubePlannedLabel(rsmd.getColumnLabel(34));
		    	//--------------------utd - bc---------------
		    	dBean.setDevUtdBc(rs.getString("dev_utd_bc"));
		    	dBean.setDevUtdBcLabel(rsmd.getColumnLabel(35));

		    	dBean.setDevUtdBcResource(rs.getString("dev_utd_bc_resource"));
		    	dBean.setDevUtdBcResourceLabel(rsmd.getColumnLabel(36));

		    	dBean.setDevUtdBcDueDate(rs.getString("dev_utd_bc_due_date"));
		    	dBean.setDevUtdBcDueDateLabel(rsmd.getColumnLabel(37));

		    	dBean.setDevUtdBcPlanned(rs.getString("dev_utd_bc_planned"));
		    	dBean.setDevUtdBcPlannedLabel(rsmd.getColumnLabel(38));
		    	//-------------------utd - inv----------------
		    	dBean.setDevUtdInv(rs.getString("dev_utd_inv"));
		    	dBean.setDevUtdInvLabel(rsmd.getColumnLabel(39));

		    	dBean.setDevUtdInvResource(rs.getString("dev_utd_inv_resource"));
		    	dBean.setDevUtdInvResourceLabel(rsmd.getColumnLabel(40));

		    	dBean.setDevUtdInvDueDate(rs.getString("dev_utd_inv_due_date"));
		    	dBean.setDevUtdInvDueDateLabel(rsmd.getColumnLabel(41));

		    	dBean.setDevUtdInvPlanned(rs.getString("dev_utd_inv_planned"));
		    	dBean.setDevUtdInvPlannedLabel(rsmd.getColumnLabel(41));
		    	//----------------------STD------------------------
		    	
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevStdLabel(rsmd.getColumnLabel(43));
		    	//-----------------------std - strs -------------
		    	
		    	dBean.setDevStdStsr(rs.getString("dev_std_stsr"));
		    	dBean.setDevStdStsrLabel(rsmd.getColumnLabel(44));
		    	
		    	dBean.setDevStdStsrResource(rs.getString("dev_std_stsr_resource"));
		    	dBean.setDevStdStsrResourceLabel(rsmd.getColumnLabel(45));
		    	
		    	dBean.setDevStdStsrDueDate(rs.getString("dev_std_stsr_due_date"));
		    	dBean.setDevStdStsrDueDateLabel(rsmd.getColumnLabel(46));
		    	
		    	dBean.setDevStdStsrPlanned(rs.getString("dev_std_stsr_planned"));
		    	dBean.setDevStdStsrPlannedLabel(rsmd.getColumnLabel(47));
		    	
		    	//-----------------------std - testdata -------------
		    	
		    	dBean.setDevStdTestData(rs.getString("dev_std_testdata"));
		    	dBean.setDevStdTestDataLabel(rsmd.getColumnLabel(48));
		    	
		    	dBean.setDevStdTestDataResource(rs.getString("dev_std_testdata_resource"));
		    	dBean.setDevStdTestDataResourceLabel(rsmd.getColumnLabel(49));
		    	
		    	dBean.setDevStdTestDataDueDate(rs.getString("dev_std_testdata_due_date"));
		    	dBean.setDevStdTestDataDueDateLabel(rsmd.getColumnLabel(50));
		    	
		    	dBean.setDevStdTestDataPlanned(rs.getString("dev_std_testdata_planned"));
		    	dBean.setDevStdTestDataPlannedLabel(rsmd.getColumnLabel(51));
		    	
		    	//------------------TAP---------
		    	
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevTapLabel(rsmd.getColumnLabel(52));
		    	
		    	//---------------tap pi -------------
		    	
		    	dBean.setDevTapPi(rs.getString("dev_tap_pi"));
		    	dBean.setDevTapPiLabel(rsmd.getColumnLabel(53));
		    	
		    	dBean.setDevTapPiResource(rs.getString("dev_tap_pi_resource"));
		    	dBean.setDevTapPiResourceLabel(rsmd.getColumnLabel(54));
		    	
		    	dBean.setDevTapPiDueDate(rs.getString("dev_tap_pi_due_date"));
		    	dBean.setDevTapPiDueDateLabel(rsmd.getColumnLabel(55));
		    	
		    	dBean.setDevTapPiPlanned(rs.getString("dev_tap_pi_planned"));
		    	dBean.setDevTapPiPlannedLabel(rsmd.getColumnLabel(56));
		    	
		    	//--------------------CODE--------------------
		    	
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevCodeLabel(rsmd.getColumnLabel(57));
		    	//-----------------------code-tube----------------
		    	
		    	dBean.setDevCodeTube(rs.getString("dev_code_tube"));
		    	dBean.setDevCodeTubeLabel(rsmd.getColumnLabel(58));
		    	
		    	dBean.setDevCodeTubeResource(rs.getString("dev_code_tube_resource"));
		    	dBean.setDevCodeTubeResourceLabel(rsmd.getColumnLabel(59));
		    	
		    	dBean.setDevCodeTubeDueDate(rs.getString("dev_code_tube_due_date"));
		    	dBean.setDevCodeTubeDueDateLabel(rsmd.getColumnLabel(60));
		    	
		    	dBean.setDevCodeTubePlanned(rs.getString("dev_code_tube_planned"));
		    	dBean.setDevCodeTubePlannedLabel(rsmd.getColumnLabel(61));
		    	//---------------------------code-bc-------------------
		    	
		    	
		    	dBean.setDevCodeBc(rs.getString("dev_code_bc"));
		    	dBean.setDevCodeBcLabel(rsmd.getColumnLabel(62));
		    	
		    	dBean.setDevCodeBcResource(rs.getString("dev_code_bc_resource"));
		    	dBean.setDevCodeBcResourceLabel(rsmd.getColumnLabel(63));
		    	
		    	dBean.setDevCodeBcDueDate(rs.getString("dev_code_bc_due_date"));
		    	dBean.setDevCodeBcDueDateLabel(rsmd.getColumnLabel(64));
		    	
		    	dBean.setDevCodeBcPlanned(rs.getString("dev_code_bc_planned"));
		    	dBean.setDevCodeBcPlannedLabel(rsmd.getColumnLabel(65));
		    	//----------------------code-inv----------------
		    	
		    	dBean.setDevCodeInv(rs.getString("dev_code_inv"));
		    	dBean.setDevCodeInvLabel(rsmd.getColumnLabel(66));
		    	
		    	dBean.setDevCodeInvResource(rs.getString("dev_code_inv_resource"));
		    	dBean.setDevCodeInvResourceLabel(rsmd.getColumnLabel(67));
		    	
		    	dBean.setDevCodeInvDueDate(rs.getString("dev_code_inv_due_date"));
		    	dBean.setDevCodeInvDueDateLabel(rsmd.getColumnLabel(68));
		    	
		    	dBean.setDevCodeInvPlanned(rs.getString("dev_code_inv_planned"));
		    	dBean.setDevCodeInvPlannedLabel(rsmd.getColumnLabel(69));
		    	
		    	//-------------------UT----------------------
		    	
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setDevUtLabel(rsmd.getColumnLabel(70));
		    	
		    	//--------------------------ut-tube------------------
		    	
		    	dBean.setDevUtTube(rs.getString("dev_ut_tube"));
		    	dBean.setDevUtTubeLabel(rsmd.getColumnLabel(71));
		    	
		    	dBean.setDevUtTubeResource(rs.getString("dev_ut_tube_resource"));
		    	dBean.setDevUtTubeResourceLabel(rsmd.getColumnLabel(72));
		    	
		    	dBean.setDevUtTubeDueDate(rs.getString("dev_ut_tube_due_date"));
		    	dBean.setDevUtTubeDueDateLabel(rsmd.getColumnLabel(73));
		    	
		    	dBean.setDevUtTubePlanned(rs.getString("dev_ut_tube_planned"));
		    	dBean.setDevUtTubePlannedLabel(rsmd.getColumnLabel(74));
		    	
		    	//-------------------------ut-bc------------------------------
		    	
		    	dBean.setDevUtBc(rs.getString("dev_ut_bc"));
		    	dBean.setDevUtBcLabel(rsmd.getColumnLabel(75));
		    	
		    	dBean.setDevUtBcResource(rs.getString("dev_ut_bc_resource"));
		    	dBean.setDevUtBcResourceLabel(rsmd.getColumnLabel(76));
		    	
		    	dBean.setDevUtBcDueDate(rs.getString("dev_ut_bc_due_date"));
		    	dBean.setDevUtBcDueDateLabel(rsmd.getColumnLabel(77));
		    	
		    	dBean.setDevUtBcPlanned(rs.getString("dev_ut_bc_planned"));
		    	dBean.setDevUtBcPlannedLabel(rsmd.getColumnLabel(78));
		    	//--------------------ut - inv---------------------------
		    	
		    	dBean.setDevUtInv(rs.getString("dev_ut_inv"));
		    	dBean.setDevUtInvLabel(rsmd.getColumnLabel(79));
		    	
		    	dBean.setDevUtInvResource(rs.getString("dev_ut_inv_resource"));
		    	dBean.setDevUtInvResourceLabel(rsmd.getColumnLabel(80));
		    	
		    	dBean.setDevUtInvDueDate(rs.getString("dev_ut_inv_due_date"));
		    	dBean.setDevUtInvDueDateLabel(rsmd.getColumnLabel(81));
		    	
		    	dBean.setDevUtInvPlanned(rs.getString("dev_ut_inv_planned"));
		    	dBean.setDevUtInvPlannedLabel(rsmd.getColumnLabel(82));
		    	
		    	//-----------------------END OF DEVELOPMENT-----------------
		    	//-----------------------------------------------------------
		    	
		    	///----------------------BEGIN OF DESIGN-----------------
		    	
		    	
		    	//-----------------begin of HLD------------
		    	dBean.setDesHld(rs.getString("des_hld"));  
		    	dBean.setDesHldLabel(rsmd.getColumnLabel(83));
		    	
			//---tube
		    	dBean.setDesHldTube(rs.getString("des_hld_tube"));
		    	dBean.setDesHldTubeLabel(rsmd.getColumnLabel(84));
		    	
		    	dBean.setDesHldTubeResource(rs.getString("des_hld_tube_resource"));
		    	dBean.setDesHldTubeResourceLabel(rsmd.getColumnLabel(85));
		    	
		    	dBean.setDesHldTubeDueDate(rs.getString("des_hld_tube_due_date"));
		    	dBean.setDesHldTubeDueDateLabel(rsmd.getColumnLabel(86));
		    	
		    	dBean.setDesHldTubePlanned(rs.getString("des_hld_tube_planned"));
		    	dBean.setDesHldTubePlannedLabel(rsmd.getColumnLabel(87));
		    	
		 	//----------BC
		    	dBean.setDesHldBc(rs.getString("des_hld_bc"));
		    	dBean.setDesHldBcLabel(rsmd.getColumnLabel(88));
		    	
		    	dBean.setDesHldBcResource(rs.getString("des_hld_bc_resource"));
		    	dBean.setDesHldBcResourceLabel(rsmd.getColumnLabel(89));
		    	
		    	dBean.setDesHldBcDueDate(rs.getString("des_hld_bc_due_date"));
		    	dBean.setDesHldBcDueDateLabel(rsmd.getColumnLabel(90));
		    	
		    	dBean.setDesHldBcPlanned(rs.getString("des_hld_bc_planned"));
		    	dBean.setDesHldBcPlannedLabel(rsmd.getColumnLabel(91));
		    	
		    	//----------------inv
			dBean.setDesHldinv(rs.getString("des_hld_inv"));
		    	dBean.setDesHldinvLabel(rsmd.getColumnLabel(92));
		    	
		    	dBean.setDesHldinvResource(rs.getString("des_hld_inv_resource"));
		    	dBean.setDesHldinvResourceLabel(rsmd.getColumnLabel(93));
		    	
		    	dBean.setDesHldinvDueDate(rs.getString("des_hld_inv_due_date"));
		    	dBean.setDesHldinvDueDateLabel(rsmd.getColumnLabel(94));
		    	
		    	dBean.setDesHldinvPlanned(rs.getString("des_hld_inv_planned"));
		    	dBean.setDesHldinvPlannedLabel(rsmd.getColumnLabel(95));
		    	
		    	//------------------pi
		    	
			dBean.setDesHldPi(rs.getString("des_hld_pi"));
			dBean.setDesHldPiLabel(rsmd.getColumnLabel(96));
		   	
			dBean.setDesHldPiResource(rs.getString("des_hld_pi_resource"));
		   	dBean.setDesHldPiResourceLabel(rsmd.getColumnLabel(97));
		   	
		   	dBean.setDesHldPiDueDate(rs.getString("des_hld_pi_due_date"));
		   	dBean.setDesHldPiDueDateLabel(rsmd.getColumnLabel(98));
		   	
		   	dBean.setDesHldPiPlanned(rs.getString("des_hld_pi_planned"));
		   	dBean.setDesHldPiPlannedLabel(rsmd.getColumnLabel(99));
		    	
		   	//---------------ia---------------
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesIaLabel(rsmd.getColumnLabel(100));
		    	
		    	dBean.setDesIaIa(rs.getString("des_ia_ia"));
		    	dBean.setDesIaIaLabel(rsmd.getColumnLabel(101));
		    	
		    	dBean.setDesIaIaResource(rs.getString("des_ia_ia_resource"));
		    	dBean.setDesIaIaResourceLabel(rsmd.getColumnLabel(102));
		    	
		    	dBean.setDesIaIaDueDate(rs.getString("des_ia_ia_due_date"));
		    	dBean.setDesIaIaDueDateLabel(rsmd.getColumnLabel(103));
		    	
		    	dBean.setDesIaIaPlanned(rs.getString("des_ia_ia_planned"));
		    	dBean.setDesIaIaPlannedLabel(rsmd.getColumnLabel(104));
		    	

		    	
		    	//-----------------AD--------------
		    	
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesAdLabel(rsmd.getColumnLabel(105));
		    	//-------------ad - tube-----------------
		    	dBean.setDesAdTube(rs.getString("des_ad_tube"));
		    	dBean.setDesAdTubeLabel(rsmd.getColumnLabel(106));
		    	
		    	dBean.setDesAdTubeResource(rs.getString("des_ad_tube_resource"));
		    	dBean.setDesAdTubeResourceLabel(rsmd.getColumnLabel(107));
		    	
		    	dBean.setDesAdTubeDueDate(rs.getString("des_ad_tube_due_date"));
		    	dBean.setDesAdTubeDueDateLabel(rsmd.getColumnLabel(108));
		    	
		    	dBean.setDesAdTubePlanned(rs.getString("des_ad_tube_planned"));
		    	dBean.setDesAdTubePlannedLabel(rsmd.getColumnLabel(109));
		    	//---------------ad - bc --------------------
		    	
		    	dBean.setDesAdBc(rs.getString("des_ad_bc"));
		    	dBean.setDesAdBcLabel(rsmd.getColumnLabel(110));
		    	
		    	dBean.setDesAdBcResource(rs.getString("des_ad_bc_resource"));
		    	dBean.setDesAdBcResourceLabel(rsmd.getColumnLabel(111));
		    	
		    	dBean.setDesAdBcDueDate(rs.getString("des_ad_bc_due_date"));
		    	dBean.setDesAdBcDueDateLabel(rsmd.getColumnLabel(112));
		    	
		    	dBean.setDesAdBcPlanned(rs.getString("des_ad_bc_planned"));
		    	dBean.setDesAdBcPlannedLabel(rsmd.getColumnLabel(113));
		    	//-------------------ad - inv -----------------------
		    	
		    	dBean.setDesAdinv(rs.getString("des_ad_inv"));
		    	dBean.setDesAdinvLabel(rsmd.getColumnLabel(114));
		    	
		    	dBean.setDesAdinvResource(rs.getString("des_ad_inv_resource"));
		    	dBean.setDesAdinvResourceLabel(rsmd.getColumnLabel(115));
		    	
		    	dBean.setDesAdinvDueDate(rs.getString("des_ad_inv_due_date"));
		    	dBean.setDesAdinvDueDateLabel(rsmd.getColumnLabel(116));
		    	
		    	dBean.setDesAdinvPlanned(rs.getString("des_ad_inv_planned"));
		    	dBean.setDesAdinvPlannedLabel(rsmd.getColumnLabel(117));
		    	
		    	
		    	//-------------------CW--------------------
		    	
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDesCwLabel(rsmd.getColumnLabel(118));
		    	
		    	dBean.setDesCwPi(rs.getString("des_cw_pi"));
		    	dBean.setDesCwPiLabel(rsmd.getColumnLabel(119));
		    	
		    	dBean.setDesCwPiResource(rs.getString("des_cw_pi_resource"));
		    	dBean.setDesCwPiResourceLabel(rsmd.getColumnLabel(120));
		    	
		    	dBean.setDesCwPiDueDate(rs.getString("des_cw_pi_due_date"));
		    	dBean.setDesCwPiDueDateLabel(rsmd.getColumnLabel(121));
		    	
		    	dBean.setDesCwPiPlanned(rs.getString("des_cw_pi_planned"));
		    	dBean.setDesCwPiPlannedLabel(rsmd.getColumnLabel(122));
		    	///---------------------END OF DESIGN-----------------------
		    	//-----------------------------------------------------
		    	
		    	
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setReqSrsLabel(rsmd.getColumnLabel(123));
		    	
		    	dBean.setReqStatus(rs.getString("req_srs_status"));
		    	dBean.setReqStatusLabel(rsmd.getColumnLabel(124));
		    	
		    	dBean.setReqBaselineDate(rs.getString("req_srs_base_line_date"));
		    	dBean.setReqDueDate(rsmd.getColumnLabel(125));
		    	
		    	dBean.setReqDueDate(rs.getString("req_srs_due_date"));
		    	dBean.setReqDueDateLabel(rsmd.getColumnLabel(126));
		    	
		    	
		    	dBean.setReqPlanned(rs.getString("req_srs_planned"));
		    	dBean.setReqPlannedLabel(rsmd.getColumnLabel(127));
		    	//-----end of requirement--------------
		    	
		    	
		    	dBean.setUserProjectId(rs.getInt("user_project_id"));
		    	dBean.setUserProjectIdLabel(rsmd.getColumnLabel(128));
		    	
		    	dBean.setDeliverableId(rs.getInt("deliverable_id"));
		    	dBean.setDeliverableIdLabel(rsmd.getColumnLabel(129));
		    	
		    	
		    	
//			dBean.setMethodology(rs.getString("methodology"));
//		    	dBean.setMethodologyLabel(rsmd.getColumnLabel(38));
//	
			dBean.setMethodologyId(rs.getInt("methodology_id"));
		    	dBean.setMethodologyIdLabel(rsmd.getColumnLabel(130));
		    	
		    	dBean.setLastName(rs.getString("last_name"));
		    	//dBean.setLastName(rsmd.getColumnLabel(131));
		    	
		
		    	System.out.println(dBean.getProjectId()+"project teste\n");
		    	
				dlist.add(dBean);

		    }
		    stmt.close();
		    
		} catch (SQLException e) {
		    System.out.println("Fail on select: " + e.getMessage());
		}
		
		return dlist;
	    }
	
	
	
	
	public List<DashboardBean> selectProjectsGroupByMethodology(){
		
		List<DashboardBean> dlist = new ArrayList<DashboardBean>();
		
		try {
		    
		    String query = "SELECT u.name, u.id_user, u.user_name, a.dashboard_id, a.project_id, a.application, a.project_name, "
    		    	+ "a.project_state, a.sdlc, a.project_status, a.comments, a.jeopardy_list, a.issue, a.pi_ftps, a.pi_ftps_currentmonth, a.pi_ftps_nextmonth, "
    		    	+ "a.pi_crs, a.pi_se, a.pi_ibmpm, a.pi_apm, a.sc_release, a.sc_testingtarget, a.sc_sprint, a.sc_schedule, a.i_type, a.i_tube, a.i_bc, "
    		    	+ "a.i_inv, a.i_pi, a.dev_utd, a.dev_utd_tube, a.dev_utd_tube_resource, a.dev_utd_tube_due_date, a.dev_utd_tube_planned, a.dev_utd_bc, "
    		    	+ "a.dev_utd_bc_resource, a.dev_utd_bc_due_date, a.dev_utd_bc_planned, a.dev_utd_inv, a.dev_utd_inv_resource, a.dev_utd_inv_due_date, "
    		    	+ "a.dev_utd_inv_planned, a.dev_std, a.dev_std_stsr, a.dev_std_stsr_resource, a.dev_std_stsr_due_date, a.dev_std_stsr_planned, "
    		    	+ "a.dev_std_testdata, a.dev_std_testdata_resource, a.dev_std_testdata_due_date, a.dev_std_testdata_planned, a.dev_tap, "
    		    	+ "a.dev_tap_pi, a.dev_tap_pi_resource, a.dev_tap_pi_due_date, a.dev_tap_pi_planned, a.dev_code, a.dev_code_tube, a.dev_code_tube_resource, "
    		    	+ "a.dev_code_tube_due_date, a.dev_code_tube_planned, a.dev_code_bc, a.dev_code_bc_resource, a.dev_code_bc_due_date, a.dev_code_bc_planned, "
    		    	+ "a.dev_code_inv, a.dev_code_inv_resource, a.dev_code_inv_due_date, a.dev_code_inv_planned, a.dev_ut, a.dev_ut_tube, a.dev_ut_tube_resource, "
    		    	+ "a.dev_ut_tube_due_date, a.dev_ut_tube_planned, a.dev_ut_bc, a.dev_ut_bc_resource, a.dev_ut_bc_due_date, a.dev_ut_bc_planned, a.dev_ut_inv, "
    		    	+ "a.dev_ut_inv_resource, a.dev_ut_inv_due_date, a.dev_ut_inv_planned, a.des_hld, a.des_hld_tube, a.des_hld_tube_resource, "
    		    	+ "a.des_hld_tube_due_date, a.des_hld_tube_planned, a.des_hld_bc, a.des_hld_bc_resource, a.des_hld_bc_due_date, a.des_hld_bc_planned, "
    		    	+ "a.des_hld_inv, a.des_hld_inv_resource, a.des_hld_inv_due_date, a.des_hld_inv_planned, a.des_hld_pi, a.des_hld_pi_resource, "
    		    	+ "a.des_hld_pi_due_date, a.des_hld_pi_planned, a.des_ia, a.des_ia_ia, a.des_ia_ia_resource, a.des_ia_ia_due_date, a.des_ia_ia_planned, "
    		    	+ "a.des_ad, a.des_ad_tube, a.des_ad_tube_resource, a.des_ad_tube_due_date, a.des_ad_tube_planned, a.des_ad_bc, a.des_ad_bc_resource, "
    		    	+ "a.des_ad_bc_due_date, a.des_ad_bc_planned, a.des_ad_inv, a.des_ad_inv_resource, a.des_ad_inv_due_date, a.des_ad_inv_planned, "
    		    	+ "a.des_cw, a.des_cw_pi, a.des_cw_pi_resource, a.des_cw_pi_due_date, a.des_cw_pi_planned, a.req_srs, a.req_srs_status, "
    		    	+ "a.req_srs_base_line_date, a.req_srs_due_date, a.req_srs_planned, a.user_project_id, a.deliverable_id, a.methodology_id "
    		    	+ "FROM "
    		    	+ "dashboard a, user_project u where u.id_user = a.user_project_id order by a.methodology_id";
		    
		    PreparedStatement stmt = con.prepareStatement(query);
//		    PreparedStatement stmt = con.prepareStatement("Select manager_id, manager_name, application, project_id, project_name, project_state, sdlc, project_status, issue, comments, jeopardy_list, "
//		    		+ "pi_ftps, pi_ftps_currentmonth, pi_ftps_nextmonth, pi_crs, pi_se, pi_ibmpm, pi_apm, sc_release, sc_testingtarget, sc_sprint, sc_schedule, "
//		    		+ "i_type, i_tube, i_bc, i_inv, req_srs, i_pi, des_hld, des_ia, des_ad, des_cw, dev_utd, dev_std, dev_tap, dev_code, dev_ut, methodology, methodology_id  from dashboard order by methodology_id");
		    ResultSet rs = stmt.executeQuery();
		    ResultSetMetaData rsmd = rs.getMetaData();
		    while(rs.next()){
			
//			System.out.println("Segue: "+rs.getString("name")+"\n\n\n");
		    	DashboardBean dBean = new DashboardBean();
		    	
		    	
		    	
			dBean.setManagerName(rs.getString("name"));
		    	dBean.setManagerNameLabel(rsmd.getColumnLabel(1));
		    	
		    	dBean.setManagerId(rs.getInt("id_user"));
		    	dBean.setManagerIdLabel(rsmd.getColumnLabel(2));
		    	
		    	dBean.setManagerUserName(rs.getString("user_name"));
		    	dBean.setManagerUserNameLabel(rsmd.getColumnLabel(3));
		    	
		      	dBean.setDashboardId(rs.getInt("dashboard_id"));//nao tem label
		    	
			dBean.setProjectId(rs.getInt("project_id"));
		    	dBean.setProjectIdLabel(rsmd.getColumnLabel(5));
		    	
		    	dBean.setApplication(rs.getString("application"));
		    	dBean.setApplicationLabel(rsmd.getColumnLabel(6));
		    	
		    
		    	
		    	dBean.setProjectName(rs.getString("project_name"));
		    	dBean.setProjectNameLabel(rsmd.getColumnLabel(7));
		    	
		    	dBean.setProjectState(rs.getString("project_state"));
		    	dBean.setProjectStateLabel(rsmd.getColumnLabel(8));
		    	
		    	dBean.setSdlc(rs.getString("sdlc"));
		    	dBean.setSdlcLabel(rsmd.getColumnLabel(9));
		    	
		    	dBean.setProjectStatus(rs.getString("project_status"));
		    	dBean.setProjectStatusLabel(rsmd.getColumnLabel(10));
		    	
		    	dBean.setComments(rs.getString("comments"));
		    	dBean.setCommentsLabel(rsmd.getColumnLabel(11));
		    	
		    	dBean.setJeopardyList(rs.getString("jeopardy_list"));
		    	dBean.setJeopardyListLabel(rsmd.getColumnLabel(12));
		    	
		    	dBean.setIssue(rs.getString("issue"));
		    	dBean.setIssueLabel(rsmd.getColumnLabel(13));
		    	
		    	
		    	
		
		    	
		    	dBean.setPiFtps(rs.getString("pi_ftps"));
		    	dBean.setPiFtpsLabel(rsmd.getColumnLabel(14));
		    	
		    	dBean.setPiFtpsCurrentMonth(rs.getString("pi_ftps_currentmonth"));
		    	dBean.setPiFtpsCurrentMonthLabel(rsmd.getColumnLabel(15));
		    	
		    	dBean.setPiFtpsNextMonth(rs.getString("pi_ftps_nextmonth"));
		    	dBean.setPiFtpsNextMonthLabel(rsmd.getColumnLabel(16));
		    	
		    	dBean.setPiCrs(rs.getString("pi_crs"));
		    	dBean.setPiCrsLabel(rsmd.getColumnLabel(17));
		    	
		    	dBean.setPiSe(rs.getString("pi_se"));    	
		    	dBean.setPiSeLabel(rsmd.getColumnLabel(18));
		    	
		     	dBean.setPiIbmPm(rs.getString("pi_ibmpm"));
		     	dBean.setPiIbmPmLabel(rsmd.getColumnLabel(19));
		     	
		    	dBean.setPiApm(rs.getString("pi_apm"));		
		    	dBean.setPiApmLabel(rsmd.getColumnLabel(20));
		    	
		    	dBean.setScRelease(rs.getString("sc_release"));
		    	dBean.setScReleaseLabel(rsmd.getColumnLabel(21));
		    	
		    	dBean.setScTestingTarget(rs.getString("sc_testingtarget"));
		    	dBean.setScTestingTargetLabel(rsmd.getColumnLabel(22));
		    	
		    	dBean.setScSprint(rs.getString("sc_sprint"));
		    	dBean.setScSprintLabel(rsmd.getColumnLabel(23));
		    	
		    	dBean.setScSchedule(rs.getString("sc_schedule"));
		    	dBean.setScScheduleLabel(rsmd.getColumnLabel(24));
		    	
		    	//-----impact----
		    	dBean.setiType(rs.getString("i_type"));
		    	dBean.setiTypeLabel(rsmd.getColumnLabel(25));
		    	
		    	dBean.setiTube(rs.getString("i_tube"));
		    	dBean.setiTubeLabel(rsmd.getColumnLabel(26));
		    	//System.out.println(rsmd.getColumnName(24)+"------------"+rsmd.getColumnLabel(24));
		    	dBean.setiBc(rs.getString("i_bc"));
		    	dBean.setiBcLabel(rsmd.getColumnLabel(27));
		    	
		    	dBean.setiInv(rs.getString("i_inv"));
		    	dBean.setiInvLabel(rsmd.getColumnLabel(28));
		    	
		    	dBean.setiPi(rs.getString("i_pi"));
		    	dBean.setiPiLabel(rsmd.getColumnLabel(29));
		    	//---fim de impact-----
		    	
		    	
		    	//-----------------------------------------------
		    	//-----------------------------------------------
			///----------------------BEGIN OF DEVELOPMENT-----------------
		    	
		    	//--------------UTD------------------------------
		    			    			    	
		    	dBean.setDevUtd(rs.getString("dev_utd"));
		    	dBean.setDevUtdLabel(rsmd.getColumnLabel(30));
		    	//---------------utd - tube-----
		    	dBean.setDevUtdTube(rs.getString("dev_utd_tube"));
		    	dBean.setDevUtdTubeLabel(rsmd.getColumnLabel(31));
		    	
		    	dBean.setDevUtdTubeResource(rs.getString("dev_utd_tube_resource"));
		    	dBean.setDevUtdTubeResourceLabel(rsmd.getColumnLabel(32));
		    	
		    	dBean.setDevUtdTubeDueDate(rs.getString("dev_utd_tube_due_date"));
		    	dBean.setDevUtdTubeDueDateLabel(rsmd.getColumnLabel(33));
		    	
		    	dBean.setDevUtdTubePlanned(rs.getString("dev_utd_tube_planned"));
		    	dBean.setDevUtdTubePlannedLabel(rsmd.getColumnLabel(34));
		    	//--------------------utd - bc---------------
		    	dBean.setDevUtdBc(rs.getString("dev_utd_bc"));
		    	dBean.setDevUtdBcLabel(rsmd.getColumnLabel(35));

		    	dBean.setDevUtdBcResource(rs.getString("dev_utd_bc_resource"));
		    	dBean.setDevUtdBcResourceLabel(rsmd.getColumnLabel(36));

		    	dBean.setDevUtdBcDueDate(rs.getString("dev_utd_bc_due_date"));
		    	dBean.setDevUtdBcDueDateLabel(rsmd.getColumnLabel(37));

		    	dBean.setDevUtdBcPlanned(rs.getString("dev_utd_bc_planned"));
		    	dBean.setDevUtdBcPlannedLabel(rsmd.getColumnLabel(38));
		    	//-------------------utd - inv----------------
		    	dBean.setDevUtdInv(rs.getString("dev_utd_inv"));
		    	dBean.setDevUtdInvLabel(rsmd.getColumnLabel(39));

		    	dBean.setDevUtdInvResource(rs.getString("dev_utd_inv_resource"));
		    	dBean.setDevUtdInvResourceLabel(rsmd.getColumnLabel(40));

		    	dBean.setDevUtdInvDueDate(rs.getString("dev_utd_inv_due_date"));
		    	dBean.setDevUtdInvDueDateLabel(rsmd.getColumnLabel(41));

		    	dBean.setDevUtdInvPlanned(rs.getString("dev_utd_inv_planned"));
		    	dBean.setDevUtdInvPlannedLabel(rsmd.getColumnLabel(41));
		    	//----------------------STD------------------------
		    	
		    	dBean.setDevStd(rs.getString("dev_std"));
		    	dBean.setDevStdLabel(rsmd.getColumnLabel(43));
		    	//-----------------------std - strs -------------
		    	
		    	dBean.setDevStdStsr(rs.getString("dev_std_stsr"));
		    	dBean.setDevStdStsrLabel(rsmd.getColumnLabel(44));
		    	
		    	dBean.setDevStdStsrResource(rs.getString("dev_std_stsr_resource"));
		    	dBean.setDevStdStsrResourceLabel(rsmd.getColumnLabel(45));
		    	
		    	dBean.setDevStdStsrDueDate(rs.getString("dev_std_stsr_due_date"));
		    	dBean.setDevStdStsrDueDateLabel(rsmd.getColumnLabel(46));
		    	
		    	dBean.setDevStdStsrPlanned(rs.getString("dev_std_stsr_planned"));
		    	dBean.setDevStdStsrPlannedLabel(rsmd.getColumnLabel(47));
		    	
		    	//-----------------------std - testdata -------------
		    	
		    	dBean.setDevStdTestData(rs.getString("dev_std_testdata"));
		    	dBean.setDevStdTestDataLabel(rsmd.getColumnLabel(48));
		    	
		    	dBean.setDevStdTestDataResource(rs.getString("dev_std_testdata_resource"));
		    	dBean.setDevStdTestDataResourceLabel(rsmd.getColumnLabel(49));
		    	
		    	dBean.setDevStdTestDataDueDate(rs.getString("dev_std_testdata_due_date"));
		    	dBean.setDevStdTestDataDueDateLabel(rsmd.getColumnLabel(50));
		    	
		    	dBean.setDevStdTestDataPlanned(rs.getString("dev_std_testdata_planned"));
		    	dBean.setDevStdTestDataPlannedLabel(rsmd.getColumnLabel(51));
		    	
		    	//------------------TAP---------
		    	
		    	dBean.setDevTap(rs.getString("dev_tap"));
		    	dBean.setDevTapLabel(rsmd.getColumnLabel(52));
		    	
		    	//---------------tap pi -------------
		    	
		    	dBean.setDevTapPi(rs.getString("dev_tap_pi"));
		    	dBean.setDevTapPiLabel(rsmd.getColumnLabel(53));
		    	
		    	dBean.setDevTapPiResource(rs.getString("dev_tap_pi_resource"));
		    	dBean.setDevTapPiResourceLabel(rsmd.getColumnLabel(54));
		    	
		    	dBean.setDevTapPiDueDate(rs.getString("dev_tap_pi_due_date"));
		    	dBean.setDevTapPiDueDateLabel(rsmd.getColumnLabel(55));
		    	
		    	dBean.setDevTapPiPlanned(rs.getString("dev_tap_pi_planned"));
		    	dBean.setDevTapPiPlannedLabel(rsmd.getColumnLabel(56));
		    	
		    	//--------------------CODE--------------------
		    	
		    	dBean.setDevCode(rs.getString("dev_code"));
		    	dBean.setDevCodeLabel(rsmd.getColumnLabel(57));
		    	//-----------------------code-tube----------------
		    	
		    	dBean.setDevCodeTube(rs.getString("dev_code_tube"));
		    	dBean.setDevCodeTubeLabel(rsmd.getColumnLabel(58));
		    	
		    	dBean.setDevCodeTubeResource(rs.getString("dev_code_tube_resource"));
		    	dBean.setDevCodeTubeResourceLabel(rsmd.getColumnLabel(59));
		    	
		    	dBean.setDevCodeTubeDueDate(rs.getString("dev_code_tube_due_date"));
		    	dBean.setDevCodeTubeDueDateLabel(rsmd.getColumnLabel(60));
		    	
		    	dBean.setDevCodeTubePlanned(rs.getString("dev_code_tube_planned"));
		    	dBean.setDevCodeTubePlannedLabel(rsmd.getColumnLabel(61));
		    	//---------------------------code-bc-------------------
		    	
		    	
		    	dBean.setDevCodeBc(rs.getString("dev_code_bc"));
		    	dBean.setDevCodeBcLabel(rsmd.getColumnLabel(62));
		    	
		    	dBean.setDevCodeBcResource(rs.getString("dev_code_bc_resource"));
		    	dBean.setDevCodeBcResourceLabel(rsmd.getColumnLabel(63));
		    	
		    	dBean.setDevCodeBcDueDate(rs.getString("dev_code_bc_due_date"));
		    	dBean.setDevCodeBcDueDateLabel(rsmd.getColumnLabel(64));
		    	
		    	dBean.setDevCodeBcPlanned(rs.getString("dev_code_bc_planned"));
		    	dBean.setDevCodeBcPlannedLabel(rsmd.getColumnLabel(65));
		    	//----------------------code-inv----------------
		    	
		    	dBean.setDevCodeInv(rs.getString("dev_code_inv"));
		    	dBean.setDevCodeInvLabel(rsmd.getColumnLabel(66));
		    	
		    	dBean.setDevCodeInvResource(rs.getString("dev_code_inv_resource"));
		    	dBean.setDevCodeInvResourceLabel(rsmd.getColumnLabel(67));
		    	
		    	dBean.setDevCodeInvDueDate(rs.getString("dev_code_inv_due_date"));
		    	dBean.setDevCodeInvDueDateLabel(rsmd.getColumnLabel(68));
		    	
		    	dBean.setDevCodeInvPlanned(rs.getString("dev_code_inv_planned"));
		    	dBean.setDevCodeInvPlannedLabel(rsmd.getColumnLabel(69));
		    	
		    	//-------------------UT----------------------
		    	
		    	dBean.setDevUt(rs.getString("dev_ut"));
		    	dBean.setDevUtLabel(rsmd.getColumnLabel(70));
		    	
		    	//--------------------------ut-tube------------------
		    	
		    	dBean.setDevUtTube(rs.getString("dev_ut_tube"));
		    	dBean.setDevUtTubeLabel(rsmd.getColumnLabel(71));
		    	
		    	dBean.setDevUtTubeResource(rs.getString("dev_ut_tube_resource"));
		    	dBean.setDevUtTubeResourceLabel(rsmd.getColumnLabel(72));
		    	
		    	dBean.setDevUtTubeDueDate(rs.getString("dev_ut_tube_due_date"));
		    	dBean.setDevUtTubeDueDateLabel(rsmd.getColumnLabel(73));
		    	
		    	dBean.setDevUtTubePlanned(rs.getString("dev_ut_tube_planned"));
		    	dBean.setDevUtTubePlannedLabel(rsmd.getColumnLabel(74));
		    	
		    	//-------------------------ut-bc------------------------------
		    	
		    	dBean.setDevUtBc(rs.getString("dev_ut_bc"));
		    	dBean.setDevUtBcLabel(rsmd.getColumnLabel(75));
		    	
		    	dBean.setDevUtBcResource(rs.getString("dev_ut_bc_resource"));
		    	dBean.setDevUtBcResourceLabel(rsmd.getColumnLabel(76));
		    	
		    	dBean.setDevUtBcDueDate(rs.getString("dev_ut_bc_due_date"));
		    	dBean.setDevUtBcDueDateLabel(rsmd.getColumnLabel(77));
		    	
		    	dBean.setDevUtBcPlanned(rs.getString("dev_ut_bc_planned"));
		    	dBean.setDevUtBcPlannedLabel(rsmd.getColumnLabel(78));
		    	//--------------------ut - inv---------------------------
		    	
		    	dBean.setDevUtInv(rs.getString("dev_ut_inv"));
		    	dBean.setDevUtInvLabel(rsmd.getColumnLabel(79));
		    	
		    	dBean.setDevUtInvResource(rs.getString("dev_ut_inv_resource"));
		    	dBean.setDevUtInvResourceLabel(rsmd.getColumnLabel(80));
		    	
		    	dBean.setDevUtInvDueDate(rs.getString("dev_ut_inv_due_date"));
		    	dBean.setDevUtInvDueDateLabel(rsmd.getColumnLabel(81));
		    	
		    	dBean.setDevUtInvPlanned(rs.getString("dev_ut_inv_planned"));
		    	dBean.setDevUtInvPlannedLabel(rsmd.getColumnLabel(82));
		    	
		    	//-----------------------END OF DEVELOPMENT-----------------
		    	//-----------------------------------------------------------
		    	
		    	///----------------------BEGIN OF DESIGN-----------------
		    	
		    	
		    	//-----------------begin of HLD------------
		    	dBean.setDesHld(rs.getString("des_hld"));  
		    	dBean.setDesHldLabel(rsmd.getColumnLabel(83));
		    	
			//---tube
		    	dBean.setDesHldTube(rs.getString("des_hld_tube"));
		    	dBean.setDesHldTubeLabel(rsmd.getColumnLabel(84));
		    	
		    	dBean.setDesHldTubeResource(rs.getString("des_hld_tube_resource"));
		    	dBean.setDesHldTubeResourceLabel(rsmd.getColumnLabel(85));
		    	
		    	dBean.setDesHldTubeDueDate(rs.getString("des_hld_tube_due_date"));
		    	dBean.setDesHldTubeDueDateLabel(rsmd.getColumnLabel(86));
		    	
		    	dBean.setDesHldTubePlanned(rs.getString("des_hld_tube_planned"));
		    	dBean.setDesHldTubePlannedLabel(rsmd.getColumnLabel(87));
		    	
		 	//----------BC
		    	dBean.setDesHldBc(rs.getString("des_hld_bc"));
		    	dBean.setDesHldBcLabel(rsmd.getColumnLabel(88));
		    	
		    	dBean.setDesHldBcResource(rs.getString("des_hld_bc_resource"));
		    	dBean.setDesHldBcResourceLabel(rsmd.getColumnLabel(89));
		    	
		    	dBean.setDesHldBcDueDate(rs.getString("des_hld_bc_due_date"));
		    	dBean.setDesHldBcDueDateLabel(rsmd.getColumnLabel(90));
		    	
		    	dBean.setDesHldBcPlanned(rs.getString("des_hld_bc_planned"));
		    	dBean.setDesHldBcPlannedLabel(rsmd.getColumnLabel(91));
		    	
		    	//----------------inv
			dBean.setDesHldinv(rs.getString("des_hld_inv"));
		    	dBean.setDesHldinvLabel(rsmd.getColumnLabel(92));
		    	
		    	dBean.setDesHldinvResource(rs.getString("des_hld_inv_resource"));
		    	dBean.setDesHldinvResourceLabel(rsmd.getColumnLabel(93));
		    	
		    	dBean.setDesHldinvDueDate(rs.getString("des_hld_inv_due_date"));
		    	dBean.setDesHldinvDueDateLabel(rsmd.getColumnLabel(94));
		    	
		    	dBean.setDesHldinvPlanned(rs.getString("des_hld_inv_planned"));
		    	dBean.setDesHldinvPlannedLabel(rsmd.getColumnLabel(95));
		    	
		    	//------------------pi
		    	
			dBean.setDesHldPi(rs.getString("des_hld_pi"));
			dBean.setDesHldPiLabel(rsmd.getColumnLabel(96));
		   	
			dBean.setDesHldPiResource(rs.getString("des_hld_pi_resource"));
		   	dBean.setDesHldPiResourceLabel(rsmd.getColumnLabel(97));
		   	
		   	dBean.setDesHldPiDueDate(rs.getString("des_hld_pi_due_date"));
		   	dBean.setDesHldPiDueDateLabel(rsmd.getColumnLabel(98));
		   	
		   	dBean.setDesHldPiPlanned(rs.getString("des_hld_pi_planned"));
		   	dBean.setDesHldPiPlannedLabel(rsmd.getColumnLabel(99));
		    	
		   	//---------------ia---------------
		    	dBean.setDesIa(rs.getString("des_ia"));
		    	dBean.setDesIaLabel(rsmd.getColumnLabel(100));
		    	
		    	dBean.setDesIaIa(rs.getString("des_ia_ia"));
		    	dBean.setDesIaIaLabel(rsmd.getColumnLabel(101));
		    	
		    	dBean.setDesIaIaResource(rs.getString("des_ia_ia_resource"));
		    	dBean.setDesIaIaResourceLabel(rsmd.getColumnLabel(102));
		    	
		    	dBean.setDesIaIaDueDate(rs.getString("des_ia_ia_due_date"));
		    	dBean.setDesIaIaDueDateLabel(rsmd.getColumnLabel(103));
		    	
		    	dBean.setDesIaIaPlanned(rs.getString("des_ia_ia_planned"));
		    	dBean.setDesIaIaPlannedLabel(rsmd.getColumnLabel(104));
		    	

		    	
		    	//-----------------AD--------------
		    	
		    	dBean.setDesAd(rs.getString("des_ad"));
		    	dBean.setDesAdLabel(rsmd.getColumnLabel(105));
		    	//-------------ad - tube-----------------
		    	dBean.setDesAdTube(rs.getString("des_ad_tube"));
		    	dBean.setDesAdTubeLabel(rsmd.getColumnLabel(106));
		    	
		    	dBean.setDesAdTubeResource(rs.getString("des_ad_tube_resource"));
		    	dBean.setDesAdTubeResourceLabel(rsmd.getColumnLabel(107));
		    	
		    	dBean.setDesAdTubeDueDate(rs.getString("des_ad_tube_due_date"));
		    	dBean.setDesAdTubeDueDateLabel(rsmd.getColumnLabel(108));
		    	
		    	dBean.setDesAdTubePlanned(rs.getString("des_ad_tube_planned"));
		    	dBean.setDesAdTubePlannedLabel(rsmd.getColumnLabel(109));
		    	//---------------ad - bc --------------------
		    	
		    	dBean.setDesAdBc(rs.getString("des_ad_bc"));
		    	dBean.setDesAdBcLabel(rsmd.getColumnLabel(110));
		    	
		    	dBean.setDesAdBcResource(rs.getString("des_ad_bc_resource"));
		    	dBean.setDesAdBcResourceLabel(rsmd.getColumnLabel(111));
		    	
		    	dBean.setDesAdBcDueDate(rs.getString("des_ad_bc_due_date"));
		    	dBean.setDesAdBcDueDateLabel(rsmd.getColumnLabel(112));
		    	
		    	dBean.setDesAdBcPlanned(rs.getString("des_ad_bc_planned"));
		    	dBean.setDesAdBcPlannedLabel(rsmd.getColumnLabel(113));
		    	//-------------------ad - inv -----------------------
		    	
		    	dBean.setDesAdinv(rs.getString("des_ad_inv"));
		    	dBean.setDesAdinvLabel(rsmd.getColumnLabel(114));
		    	
		    	dBean.setDesAdinvResource(rs.getString("des_ad_inv_resource"));
		    	dBean.setDesAdinvResourceLabel(rsmd.getColumnLabel(115));
		    	
		    	dBean.setDesAdinvDueDate(rs.getString("des_ad_inv_due_date"));
		    	dBean.setDesAdinvDueDateLabel(rsmd.getColumnLabel(116));
		    	
		    	dBean.setDesAdinvPlanned(rs.getString("des_ad_inv_planned"));
		    	dBean.setDesAdinvPlannedLabel(rsmd.getColumnLabel(117));
		    	
		    	
		    	//-------------------CW--------------------
		    	
		    	dBean.setDesCw(rs.getString("des_cw"));
		    	dBean.setDesCwLabel(rsmd.getColumnLabel(118));
		    	
		    	dBean.setDesCwPi(rs.getString("des_cw_pi"));
		    	dBean.setDesCwPiLabel(rsmd.getColumnLabel(119));
		    	
		    	dBean.setDesCwPiResource(rs.getString("des_cw_pi_resource"));
		    	dBean.setDesCwPiResourceLabel(rsmd.getColumnLabel(120));
		    	
		    	dBean.setDesCwPiDueDate(rs.getString("des_cw_pi_due_date"));
		    	dBean.setDesCwPiDueDateLabel(rsmd.getColumnLabel(121));
		    	
		    	dBean.setDesCwPiPlanned(rs.getString("des_cw_pi_planned"));
		    	dBean.setDesCwPiPlannedLabel(rsmd.getColumnLabel(122));
		    	///---------------------END OF DESIGN-----------------------
		    	//-----------------------------------------------------
		    	
		    	
		    	
		    	dBean.setReqSrs(rs.getString("req_srs"));
		    	dBean.setReqSrsLabel(rsmd.getColumnLabel(123));
		    	
		    	dBean.setReqStatus(rs.getString("req_srs_status"));
		    	dBean.setReqStatusLabel(rsmd.getColumnLabel(124));
		    	
		    	dBean.setReqBaselineDate(rs.getString("req_srs_base_line_date"));
		    	dBean.setReqDueDate(rsmd.getColumnLabel(125));
		    	
		    	dBean.setReqDueDate(rs.getString("req_srs_due_date"));
		    	dBean.setReqDueDateLabel(rsmd.getColumnLabel(126));
		    	
		    	
		    	dBean.setReqPlanned(rs.getString("req_srs_planned"));
		    	dBean.setReqPlannedLabel(rsmd.getColumnLabel(127));
		    	//-----end of requirement--------------
		    	
		    	
		    	dBean.setUserProjectId(rs.getInt("user_project_id"));
		    	dBean.setUserProjectIdLabel(rsmd.getColumnLabel(128));
		    	
		    	dBean.setDeliverableId(rs.getInt("deliverable_id"));
		    	dBean.setDeliverableIdLabel(rsmd.getColumnLabel(129));
		    	
		    	
		    	
//			dBean.setMethodology(rs.getString("methodology"));
//		    	dBean.setMethodologyLabel(rsmd.getColumnLabel(38));
//	
			dBean.setMethodologyId(rs.getInt("methodology_id"));
		    	dBean.setMethodologyIdLabel(rsmd.getColumnLabel(130));
		    	
		    	
		
		    	System.out.println(dBean.getProjectId()+"project teste\n");
		    	
				dlist.add(dBean);

		    }
		    stmt.close();
		    
		} catch (SQLException e) {
		    System.out.println("Fail on select: " + e.getMessage());
		}
		
		return dlist;
	    }
	
	
	
	public List<UserDashboardBean> getAllUserDashboard(){
	    
	    List<UserDashboardBean> ud = new ArrayList<UserDashboardBean>();
	    
	    try{
		String query = "Select distinct d.user_project_id, a.name,  a.last_name from dashboard d, user_project a where d.user_project_id = a.id_user";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		
		
		while(rs.next()){
		    
		    UserDashboardBean udBean = new UserDashboardBean();
		    udBean.setManagerId(rs.getInt("user_project_id"));
		    udBean.setManagerName(rs.getString("name"));
		    udBean.setManagerLastName(rs.getString("last_name"));
		    
		    ud.add(udBean);
		}
		stmt.close();
	    }catch(Exception ex){
		
	    }
	    
	    
	    return ud;
	}
	
	public boolean updateDashBoardRow(int id_row, String value, String column){
	    boolean flag = false;
	    
	    try{
		String queryUpdate = "UPDATE dashboard SET "+column+"=? WHERE dashboard_id=?";
		
		ptmt = con.prepareStatement(queryUpdate);
		ptmt.setString(1, value);
		ptmt.setInt(2, id_row);
		int confirmation = ptmt.executeUpdate();
		if(confirmation > 0){
		    flag = true;
		}
		ptmt.close();
		
	    }catch(Exception e){
		System.out.println("Exception: "+e.getMessage());
	    }
	    
	    return flag;
	}
	
	public boolean updateDashBoardManager(int user_id, int dashboard_id){
	    boolean flag = false;
	    
	    try{
		String queryUpdate = "UPDATE dashboard SET USER_PROJECT_ID=? WHERE dashboard_id=?";
		
		ptmt = con.prepareStatement(queryUpdate);
		ptmt.setInt(1, user_id);
		ptmt.setInt(2, dashboard_id);
		int confirmation = ptmt.executeUpdate();
		if(confirmation > 0){
		    flag = true;
		}
		ptmt.close();
		
	    }catch(Exception e){
		System.out.println("Exception: "+e.getMessage());
	    }
	    
	    return flag;
	}
	
	
    public boolean updateDashboardValue(DashboardBean dBean){
    	
	boolean confirm = false;
	
	try{
	    String queryString = "UPDATE dashboard SET application=?, project_name=?, project_state=?, sdlc=?, project_status=?, issue=?, comments=?, jeopardy_list=?, "
	    						+ "pi_ftps=?, pi_ftps_currentmonth=?, pi_ftps_nextmonth=?, pi_crs=?, pi_se=?, pi_ibmpm=?, pi_apm=?, "
	    						+ "sc_release=?, sc_testingtarget=?, sc_sprint=?, sc_schedule=?, "
	    						+ "i_type=?, i_tube=?, i_bc=?, i_inv=?, i_pi=? WHERE project_id=?";
	    
	    ptmt = con.prepareStatement(queryString);
	    
	    ptmt.setString(1, dBean.getApplication());
	    ptmt.setString(2, dBean.getProjectName());
	    ptmt.setString(3, dBean.getProjectState());
	    ptmt.setString(4, dBean.getSdlc());
	    ptmt.setString(5, dBean.getProjectStatus());
	    ptmt.setString(6, dBean.getIssue());
	    ptmt.setString(7, dBean.getComments());
	    ptmt.setString(8, dBean.getJeopardyList());
	    ptmt.setString(9, dBean.getPiFtps());
	    ptmt.setString(10, dBean.getPiFtpsCurrentMonth());
	    ptmt.setString(11, dBean.getPiFtpsNextMonth());
	    ptmt.setString(12, dBean.getPiCrs());
	    ptmt.setString(13, dBean.getPiSe());
	    ptmt.setString(14, dBean.getPiIbmPm());
	    ptmt.setString(15, dBean.getPiApm());
	    ptmt.setString(16, dBean.getScRelease());
	    ptmt.setString(17, dBean.getScTestingTarget());
	    ptmt.setString(18, dBean.getScSprint());
	    ptmt.setString(19, dBean.getScSchedule());
	    ptmt.setString(20, dBean.getiType());
	    ptmt.setString(21, dBean.getiTube());
	    ptmt.setString(22, dBean.getiBc());
	    ptmt.setString(23, dBean.getiInv());
	    ptmt.setString(24, dBean.getiPi());
	    ptmt.setInt(25, dBean.getProjectId());
	    
	    int confirmation = ptmt.executeUpdate();//value bigger then zero is a confirmation success.
	    ptmt.close();
	    if(confirmation > 0){
		confirm = true;	
	    }
	    
	    
	}catch(Exception ex){
	    ex.printStackTrace();
	}finally{
	    try{
	    	if(ptmt != null){
	    		ptmt.close();
		}if(con != null){
		    con.close();
		}
	    }catch(SQLException sql){
		sql.printStackTrace();
	    }catch (Exception e) {
		e.printStackTrace();
	    }
	}
	return confirm;
    }
	
    public boolean deleteDashboard(int dId){
    	
    	boolean confirmation = false;
    	
    	try{
    	    String query = "DELETE FROM dashboard WHERE dashboard_id=?";
    	    ptmt = con.prepareStatement(query);
    	    ptmt.setInt(1, dId);
    	    ptmt.executeUpdate();
    	    confirmation = true;
    	}catch(SQLException sql){
    	    sql.printStackTrace();
    	}finally{
    	    try{
    		if(ptmt != null){
    		    ptmt.close();
    		}if(con != null){
    		    con.close();
    		}
    	    }catch(SQLException e){
    		e.printStackTrace();
    	    }catch(Exception ex){
    		ex.printStackTrace();
    	    }
    	}
    	return confirmation;
        }
    
    public boolean insertProject(String projectName, int projectId, String methodology, int methodologyId){
	boolean confirmation = false;
	try{
    	    String query = "INSERT INTO dashboard(project_name, methodology, methodology_id,project_id, sdlc, project_status) values (?,?,?,?,?,?)";
    	    
    	    String sdlc = methodology.substring(0, 1).toUpperCase() + methodology.substring(1).toLowerCase();
    	    System.out.println("nome minusculo: "+sdlc);
    	    ptmt = con.prepareStatement(query);
    	    ptmt.setString(1,projectName);
    	    ptmt.setString(2,methodology);
    	    ptmt.setInt(3,methodologyId);
	    ptmt.setInt(4,projectId);
	    ptmt.setString(5, sdlc);
	    ptmt.setString(6, "Yellow");
	    
    	    ptmt.executeUpdate();
    	    confirmation = true;
    	}catch(SQLException sql){
    	    sql.printStackTrace();
    	}finally{
    	    try{
    		if(ptmt != null){
    		    ptmt.close();
    		}if(con != null){
    		    con.close();
    		}
    	    }catch(SQLException e){
    		e.printStackTrace();
    	    }catch(Exception ex){
    		ex.printStackTrace();
    	    }
    	}
    	return confirmation;
    }
    
    public List<DashboardBean> selectAllprojects(){
	
	List<DashboardBean> dlist = new ArrayList<DashboardBean>();
	
	try {
	    
	    PreparedStatement stmt = con.prepareStatement("SELECT DASHBOARD_ID, PROJECT_NAME, METHODOLOGY, PROJECT_ID, application FROM dashboard");
	    
	    ResultSet rs = stmt.executeQuery();
	    ResultSetMetaData rsmd = rs.getMetaData();
	    
	    while(rs.next()){
		
	    	DashboardBean dBean = new DashboardBean();
	    	
	    	dBean.setDashboardId(rs.getInt("dashboard_id"));
	    	dBean.setProjectName(rs.getString("project_name"));
	    	dBean.setMethodology(rs.getString("methodology"));
	    	dBean.setProjectId(rs.getInt("project_id"));
	    	dBean.setApplication(rs.getString("application"));
	    	dlist.add(dBean);

	    }
	    stmt.close();
	    
	} catch (Exception e) {
	    System.out.println("Fail on select: " + e.getMessage());
	}
	
	return dlist;
    }
	
    public List<DashboardBean> selectAllprojectsAndManagers(){
	
  	List<DashboardBean> dlist = new ArrayList<DashboardBean>();
  	
  	try {
  	    
  	    PreparedStatement stmt = con.prepareStatement("SELECT DASHBOARD_ID, PROJECT_NAME, PROJECT_ID, APPLICATION, USER_PROJECT_ID, NAME, LAST_NAME FROM dashboard " 
							+"LEFT JOIN user_project ON (dashboard.USER_PROJECT_ID = user_project.ID_USER)");
  	    
  	    ResultSet rs = stmt.executeQuery();
  	    
  	    while(rs.next()){
  		
  	    	DashboardBean dBean = new DashboardBean();
  	    	
  	    	dBean.setDashboardId(rs.getInt("dashboard_id"));
  	    	dBean.setProjectName(rs.getString("project_name"));
  	    	dBean.setProjectId(rs.getInt("project_id"));
  	    	dBean.setUserProjectId(rs.getInt("user_project_id"));
  	    	dBean.setManagerUserName(rs.getString("name"));
  	    	dBean.setLastName(rs.getString("last_name"));
  	    	dlist.add(dBean);
  	    }
  	    stmt.close();
  	} catch (Exception e) {
  	    System.out.println("Fail on select44: " + e.getMessage());
  	}
  	return dlist;
      }
}

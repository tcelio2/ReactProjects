package com.ibm.att.spa01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibm.att.spa01.bean.DashboardBean;
import com.ibm.att.spa01.bean.DeliverableBean;
import com.ibm.att.spa01.bean.ScheduleBean;
import com.mysql.jdbc.Statement;

public class ScheduleDAO {

    private Connection con = null;
    private PreparedStatement pmtm = null;
    
    
    public ScheduleDAO(){
	  ConnectionDAO conDAO = new ConnectionDAO();
	  this.con = conDAO.getConection();
    }
    
    public List<ScheduleBean> selectSchedule(int userId){
		
		List<ScheduleBean> slist = new ArrayList<ScheduleBean>();
		
		try {
		    
		    PreparedStatement stmt = con.prepareStatement("select distinct s.id as schedule_id, "
		    							+"s.hld_start_date, s.hld_end_date, s.hld_comment, " 
			    						+"s.ia_start_date, s.ia_end_date, s.ia_comment, "
			    						+"s.ad_start_date, s.ad_end_date, s.ad_comment, "
			    						+"s.cw_start_date, s.cw_end_date, s.cw_comment, "
                                                                        +"s.deliverable_id, s.dashboard_dashboard_id, "
                                                                        +"s.project_name, s.project_id, s.deliverable_title, "
                                                                        +"d.id as id_deliverable, "
                                                                        +"d.user_project_id_user "
                                                                        +"from schedule s, deliverable d, dashboard p "
                                                                        +"where s.deliverable_id = d.id "
                                                                        +"and d.user_project_id_user = ?");
		    stmt.setInt(1, userId);
		    ResultSet rs = stmt.executeQuery();
		    
		    
		    while(rs.next()){
			
		    	ScheduleBean scBean = new ScheduleBean();
		    
		    	scBean.setScheduleId(rs.getInt("schedule_id"));
		    	scBean.setProjectId(rs.getString("project_id"));
		    	scBean.setProjectName(rs.getString("project_name"));
		    	scBean.setDeliverableTitle(rs.getString("deliverable_title"));
		    	scBean.setDeliverableId(rs.getInt("deliverable_id"));
		    	scBean.setDashboardId(rs.getInt("dashboard_dashboard_id"));
		    	//scBean.setType(rs.getString("type"));
		    	scBean.setHldStartDate(rs.getString("hld_start_date"));
		    	scBean.setHldEndDate(rs.getString("hld_end_date"));
		    	scBean.setHldCommnet(rs.getString("hld_comment"));
		    	
		    	scBean.setIaStartDate(rs.getString("ia_start_date"));
		    	scBean.setIaEndDate(rs.getString("ia_end_date"));
		    	scBean.setIaCommnet(rs.getString("ia_comment"));
		    	
		    	scBean.setAdStartDate(rs.getString("ad_start_date"));
		    	scBean.setAdEndDate(rs.getString("ad_end_date"));
		    	scBean.setAdComment(rs.getString("ad_comment"));
		    	
		    	scBean.setCwStartDate(rs.getString("cw_start_date"));
		    	scBean.setCwEndDate(rs.getString("cw_end_date"));
		    	scBean.setCwComment(rs.getString("cw_comment"));
		
		    	slist.add(scBean);

		    }
		    stmt.close();
		    
		} catch (SQLException e) {
		    System.out.println("Fail on select:d " + e.getSQLState());
		}
		
		return slist;
	    }
    

    public List<DashboardBean> getAllProjects(int userId){
	List<DashboardBean> slist = new ArrayList<DashboardBean>();
	
	try {
	    String query = "SELECT dashboard_id, project_id, project_name FROM dashboard WHERE USER_PROJECT_ID = ? ORDER BY PROJECT_NAME";
	    PreparedStatement stmt = con.prepareStatement(query);
	    
	    stmt.setInt(1, userId);
	    
	    ResultSet rs = stmt.executeQuery();
	    
	    while(rs.next()){
		
		//ScheduleBean sbean = new ScheduleBean();
		DashboardBean dBean = new DashboardBean();
		dBean.setDashboardId(rs.getInt("dashboard_id"));
		dBean.setProjectId(rs.getInt("project_id"));
		dBean.setProjectName(rs.getString("project_name"));
		//sbean.setDescription(rs.getString("description"));
		slist.add(dBean);
		
	    }
	    stmt.close();
	    
	} catch (Exception e) {
	      e.getStackTrace();
	}
	
	return slist;
    }
    
    public boolean deleteSchedule(){
	boolean check = false;
	
	
	return check;
    }
    
    public boolean insertSchedule(){
	boolean check = false;
	
	
	return check;
    }
    
    public boolean updateSchedule(ScheduleBean schedule){
	boolean check = false;
	try{
	    String updateQuery = "UPDATE DELIVERABLE SET HLD_START_DATE=?, HLD_END_DATE=?, HLD_COMMENT=?, IA_START_DATE=?, IA_END_DATE=?, IA_COMMENT=?, AD_START_DATE=?, AD_END_DATE=?, AD_COMMENT=?, CW_START_DATE=?, CW_END_DATE=?, CW_COMMENT=? WHERE ID=? ";
//	    PreparedStatement ps = con.prepareStatement(updateQuery);
//	    ps.setString(1, schedule.getHldStartDate());
//	    ps.setString(2, schedule.getHldEndDate());
//	    ps.setString(3, schedule.getHldComment());
//	    ps.setString(4, schedule.getIaStartDate());
//	    ps.setString(5, schedule.getIaEndDate());
//	    ps.setString(6, schedule.getIaComment());
//	    ps.setString(7, schedule.getAdStartDate());
//	    ps.setString(8, schedule.getAdEndDate());
//	    ps.setString(9, schedule.getAdComment());
//	    ps.setString(10, schedule.getCwStartDate());
//	    ps.setString(11, schedule.getCwStartDate());
//	    ps.setString(12, schedule.getCwComment());
//	    ps.setInt(13, schedule.getId());
	    
	    check = true;
	  //  ps.executeUpdate();
	  //  ps.close();
	    
	}catch(Exception ex){
	    System.out.println(ex.getMessage());
	}
	
	return check;
    }
    
    
//=========================
    
    
    public int insertSchedule(ScheduleBean sBean){
	
		//boolean confirm = false;
		int confirmation = 0;
		
		//this.con = ConnectionDAO.getConection();
		
		try {
			String queryString = "insert into schedule (dashboard_dashboard_id, deliverable_id, hld_start_date,  hld_end_date, hld_comment, ia_start_date, ia_end_date, ia_comment, ad_start_date, ad_end_date, ad_comment, cw_start_date, cw_end_date, cw_comment, deliverable_title, project_name, project_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // returning projectid";

			pmtm = con.prepareStatement(queryString, PreparedStatement.RETURN_GENERATED_KEYS);
		
			     


			
			pmtm.setInt(1, sBean.getDashboardId());
			pmtm.setInt(2, sBean.getDeliverableId());
			pmtm.setString(3, sBean.getHldStartDate());
			pmtm.setString(4, sBean.getHldEndDate());
			pmtm.setString(5, sBean.getHldCommnet());
			pmtm.setString(6, sBean.getIaStartDate());
			pmtm.setString(7, sBean.getIaEndDate());
			pmtm.setString(8, sBean.getIaCommnet());
			pmtm.setString(9, sBean.getAdStartDate());
			pmtm.setString(10, sBean.getAdEndDate());
			pmtm.setString(11, sBean.getAdComment());
			pmtm.setString(12, sBean.getCwStartDate());
			pmtm.setString(13, sBean.getCwEndDate());
			pmtm.setString(14, sBean.getCwComment());
			
			pmtm.setString(15, sBean.getDeliverableTitle());
			pmtm.setString(16, sBean.getProjectName());
			pmtm.setString(17, sBean.getProjectId());

			pmtm.executeUpdate();
			

			ResultSet res = pmtm.getGeneratedKeys();
			
			 while (res.next()){
			//     System.out.println("Generated key: " + res.getInt(1));
			     confirmation = res.getInt(1);
			 }

			 // Using the getGeneratedKeys() method to retrieve
		            // the key(s). In this case there is only one key column
		          
			
			pmtm.close();
			//confirm = true;

			// System.out.println("value inserted "+ keyset);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: "+e.getMessage()+"\n"+e.getCause());
		} finally {

			try {
				if (pmtm != null) {
					pmtm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.getStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return confirmation;

	}
    
    
    
    public boolean updateScheduleValue(ScheduleBean dBean){
    	
    	boolean confirm = false;
    	
    	try{
    	    String queryString = "UPDATE schedule SET startDate=?, endDate=?, comment=? WHERE projectId=? and deliverable=? and type=?";
//    	    pmtm = con.prepareStatement(queryString);
//    	    pmtm.setString(1, dBean.getDeliverable());
//    	    pmtm.setString(2, dBean.getType());
//    	    pmtm.setString(3, dBean.getStartDate());
//    	    pmtm.setString(4, dBean.getEndDate());
//    	    pmtm.setString(5, dBean.getComment());
//    	    pmtm.setString(6, dBean.getProjectId());
    	    pmtm.executeUpdate();
    	    pmtm.close();
    	    confirm = true;
    	}catch(Exception ex){
    	    ex.printStackTrace();
    	}finally{
    	    try{
    		if(pmtm != null){
    			pmtm.close();
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
        
    public boolean deleteSchedule(String dId){
    	
    	boolean confirmation = false;
    	
    	try{
    	    String query = "DELETE FROM schedule WHERE id=?";
    	    pmtm = con.prepareStatement(query);
    	    pmtm.setString(1, dId);
    	    pmtm.executeUpdate();
    	    confirmation = true;
    	}catch(SQLException sql){
    	    sql.printStackTrace();
    	}finally{
    	    try{
    		if(pmtm != null){
    			pmtm.close();
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
    
	public boolean updateScheduleRow(String id_row, String deliverable_row, String type_row, String value, String column){
	    boolean flag = false;
	    
	    try{
		String queryUpdate = "UPDATE schedule SET "+column+"=? WHERE projectId=? and deliverable=? and type=?";
		
		pmtm = con.prepareStatement(queryUpdate);
		pmtm.setString(1, value);
		pmtm.setString(2, id_row);
		pmtm.setString(3, deliverable_row);
		pmtm.setString(4, type_row);
		int confirmation = pmtm.executeUpdate();
		if(confirmation > 0){
		    flag = true;
		}
		pmtm.close();
		
	    }catch(Exception e){
		System.out.println("Exception: "+e.getMessage());
	    }
	    
	    return flag;
	}
    
    
    
}

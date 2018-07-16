package com.ibm.att.spa01.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.att.spa01.bean.DeliverableBean;



public class DeliverableDAO {

    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement ptmt = null;
    
    public DeliverableDAO(){
	  ConnectionDAO conDAO = new ConnectionDAO();
	  this.con = conDAO.getConection();
    }
    
    public List<DeliverableBean> selectDeliverable(int user_id){
	
	List<DeliverableBean> dlist = new ArrayList<DeliverableBean>();
	System.out.println("userid from DAO: "+user_id);
	try {
	    
	    PreparedStatement ptmt = con.prepareStatement("Select id, title, description, hld, ia,ad, cw from deliverable where user_project_id_user = ? order by id");
	    ptmt.setInt(1, user_id);
	    
	    ResultSet rs = ptmt.executeQuery();
	    
	    while(rs.next()){
		
		DeliverableBean dBean = new DeliverableBean();
		dBean.setId(rs.getInt("id"));
		dBean.setTitle(rs.getString("title"));
		dBean.setDescription(rs.getString("description"));
		dBean.setHld(rs.getString("hld"));
		dBean.setIa(rs.getString("ia"));
		dBean.setAd(rs.getString("ad"));
		dBean.setCw(rs.getString("cw"));
		dBean.setIdUser(user_id);
		
		dlist.add(dBean);
	    }
	    ptmt.close();
	    
	} catch (SQLException e) {
	    System.out.println("FAil on select: "+e.getSQLState());
	}
	
	return dlist;
    }
    
    public DeliverableBean getOnedeliverable(int id){
	DeliverableBean dBean = new DeliverableBean();
	try{
	    String query = "SELECT * from DELIVERABLE WHERE ID = ?";
	    ptmt = con.prepareStatement(query);
	    ptmt.setInt(1, id);
	    ResultSet rs = ptmt.executeQuery();
	    while(rs.next()){
		
		//DeliverableBean dBean = new DeliverableBean();
		dBean.setId(rs.getInt("id"));
		dBean.setTitle(rs.getString("title"));
		dBean.setDescription(rs.getString("description"));
		dBean.setHld(rs.getString("hld"));
		dBean.setIa(rs.getString("ia"));
		dBean.setAd(rs.getString("ad"));
		dBean.setCw(rs.getString("cw"));
		
		
		//dlist.add(dBean);
	    }
	    ptmt.close();
	    
	}catch(Exception sql){
	    sql.getStackTrace();
	}
	
	
	return dBean;
    }
    
    
    public int insertDeliverable(DeliverableBean dBean){
	
	int id_return = 0;
	//this.con = ConnectionDAO.getConection();
	try {
	    String queryString = "INSERT INTO deliverable (title, description, hld, ia, ad, cw, user_project_id_user) VALUES(?,?,?,?,?,?,?)";
	    //statement.executeUpdate();
	    ptmt = con.prepareStatement(queryString,PreparedStatement.RETURN_GENERATED_KEYS);
	    ptmt.setString(1, dBean.getTitle());
	    ptmt.setString(2, dBean.getDescription());
	    ptmt.setString(3, dBean.getHld());
	    ptmt.setString(4, dBean.getIa());
	    ptmt.setString(5, dBean.getAd());
	    ptmt.setString(6, dBean.getCw());
	    ptmt.setInt(7, dBean.getIdUser());
	    //int lastid = rs.getString("last_id");
	   
	        
	    
	    //ptmt.execute(queryString, Statement.RETURN_GENERATED_KEYS);//(queryString, Statement.RETURN_GENERATED_KEYS);
	    //ptmt.executeQuery();//getGeneratedKeys();
	    ptmt.executeUpdate();
	    ResultSet rs = ptmt.getGeneratedKeys();
	   // int generatedKey = 0;
	    if(rs.next()) {
		id_return = (int) rs.getInt(1);
	    }
	        
	   
	 //   System.out.println("value inserted "+ generatedKey);
	    
	    
	    
	} catch (Exception e) {
	    System.out.println("Erro: "+e.getMessage());
	    
	}finally{
	    
	    try {
		if(ptmt != null){
		  ptmt.close();  
		}if(con != null){
		    con.close();
		}
	    } catch (SQLException e) {
		System.out.println();
		e.getStackTrace();
	    }catch (Exception e2) {
		e2.printStackTrace();
	    }
	}
	return id_return;
	
    }
    
    public boolean updateDeliverableValue(DeliverableBean dBean){
	
	boolean confirm = false;
	
	try{
	    String queryString = "UPDATE deliverable SET title=?, description=?, hld=?, ia=?, ad=?, cw=? WHERE id=?";
	    ptmt = con.prepareStatement(queryString);
	    //ptmt.setInt(, x);
	    ptmt.setString(1, dBean.getTitle());
	    ptmt.setString(2, dBean.getDescription());
	    ptmt.setString(3, dBean.getHld());
	    ptmt.setString(4, dBean.getIa());
	    ptmt.setString(5, dBean.getAd());
	    ptmt.setString(6, dBean.getCw());
	    ptmt.setInt(7, dBean.getId());
	    ptmt.executeUpdate();
	    ptmt.close();
	    confirm = true;
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
    
    public boolean deleteDeliverable(int dId){
	
	boolean confirmation = false;
	
	try{
	    String query = "DELETE FROM deliverable WHERE id = ?";
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
    
    
	public boolean updateDeliverableRow(int id_row, String value, String column){
	    boolean flag = false;
	    
	    try{
		String queryUpdate = "UPDATE deliverable SET "+column+"=? WHERE id=?";
		
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
    
    
}

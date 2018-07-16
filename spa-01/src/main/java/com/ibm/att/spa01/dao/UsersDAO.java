package com.ibm.att.spa01.dao;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ibm.att.spa01.bean.UserBean;
import com.ibm.att.spa01.util.Hash;



public class UsersDAO {

    private Connection con = null;
    private Statement statement = null;
    private PreparedStatement ptmt = null;
    
    public UsersDAO(){
	ConnectionDAO dao = new ConnectionDAO();
	this.con = dao.getConection();
    }
    
    public UserBean verifyUserLogin(String user, String password){
	UserBean userBean = new UserBean();
	PreparedStatement stmt = null;
	Hash hs = new Hash();
	//UserBean usb = new UserBean();
	try{
	    String query = "Select "
	    			+ "a.id_user, a.name, a.user_name, a.last_name, a.email, a.password, a.user_role_id_role, "
	    			+ "b.id_role, b.role_name from user_project as a, user_role as b "
	    			+ "where "
	    			+ "a.user_name =? AND a.password=? "
	    			+ "AND "
	    			+ "a.user_role_id_role = b.id_role";
	    stmt = con.prepareStatement(query);
	    String password_ = hs.translate2Hexadecimal(hs.generateHash(password, "MD5"));
	    stmt.setString(1, user);
	    stmt.setString(2, password_);
	    
	    ResultSet rs = stmt.executeQuery();
	    ResultSetMetaData rsmd = rs.getMetaData();
	    
	    while(rs.next()){
		
//		System.out.println("value: "+rs.getInt("id"));
		
		userBean.setId(rs.getInt("id_user"));
		userBean.setIdLabel(rsmd.getColumnLabel(1));
		
		userBean.setName(rs.getString("name"));
		userBean.setNameLabel(rsmd.getColumnLabel(4));
		
		userBean.setUserName(rs.getString("user_name"));
		userBean.setUserNameLabel(rsmd.getColumnLabel(1));
		
		userBean.setLastName(rs.getString("last_name"));
		userBean.setLastNameLabel(rsmd.getColumnLabel(4));
		
		userBean.setRole(rs.getString("role_name"));
		userBean.setRoleLabel(rsmd.getColumnLabel(2));
		
		userBean.setEmail(rs.getString("email"));
		userBean.setEmaillabel(rsmd.getColumnLabel(3));
		
		userBean.setPassword(rs.getString("password"));
		userBean.setPasswordlabel(rsmd.getColumnLabel(3));
		
		userBean.setRoleId(rs.getInt("user_role_id_role"));
		userBean.setRoleIdlabel(rsmd.getColumnLabel(6));
		
	
		userBean.setRole(rs.getString("role_name"));
		userBean.setRoleLabel(rsmd.getColumnLabel(6));
		
		
	    }
	    stmt.close();
	}catch(SQLException ex){
	    ex.printStackTrace();
	}
	
	
	return userBean;
    }
    
    
    public List<UserBean> selectUsers(){
	
	List<UserBean> userlist = new ArrayList<UserBean>();
	
	try {
	    
	    PreparedStatement stmt = con.prepareStatement("Select a.id_user, a.name, a.last_name, a.user_name, a.email, b.id_role, b.role_name, a.user_role_id_role from user_project a, user_role b where a.user_role_id_role = b.id_role");
	    ResultSet rs = stmt.executeQuery();
	    
	    while(rs.next()){
		
		UserBean userBean = new UserBean();
		userBean.setId(rs.getInt("id_user"));
		userBean.setName(rs.getString("name"));
		userBean.setLastName(rs.getString("last_name"));
		userBean.setUserName(rs.getString("user_name"));
		userBean.setEmail(rs.getString("email"));
		userBean.setRole(rs.getString("role_name"));
		userBean.setRoleId(rs.getInt("id_role"));
		
		userlist.add(userBean);
	    }
	    stmt.close();
	    
	} catch (SQLException e) {
	    System.out.println("FAil on select: "+e.getSQLState());
	}
	
	return userlist;
    }
    
    public List<UserBean> selectUsersForDataTable(){
	
List<UserBean> userlist = new ArrayList<UserBean>();
	
	try {
	    
	    PreparedStatement stmt = con.prepareStatement("Select id_user, name, last_name, email from user_project");
	    ResultSet rs = stmt.executeQuery();
	    
	    while(rs.next()){
		
		UserBean userBean = new UserBean();
		userBean.setId(rs.getInt("id_user"));
		userBean.setName(rs.getString("name"));
		userBean.setLastName(rs.getString("last_name"));
		userBean.setEmail(rs.getString("email"));
		
		userlist.add(userBean);
	    }
	    stmt.close();
	    
	} catch (SQLException e) {
	    System.out.println("FAil on select: "+e.getSQLState());
	}
	
	return userlist;
	
	
    }
    
    
    public boolean insertUser(UserBean userBean){
	
	boolean confirmation = false;
	Hash hs = new Hash();
	String password_ = null;
	
	try {
	    String queryString = "INSERT INTO user_project (name, email, user_role_id_role, last_name, user_name, password) VALUES(?,?,?,?,?,?)";

	    password_ = hs.translate2Hexadecimal(hs.generateHash(userBean.getPassword(), "MD5"));
	    
	    ptmt = con.prepareStatement(queryString);
	    ptmt.setString(1, userBean.getName());
	    ptmt.setString(2, userBean.getEmail());
	    ptmt.setInt(3, userBean.getRoleId());
	    ptmt.setString(4, userBean.getLastName());
	    ptmt.setString(5, userBean.getUserName());
	    ptmt.setString(6, password_);
	    
	    ptmt.executeUpdate();
	    confirmation = true;
	} catch (Exception e) {
	    e.printStackTrace();
	}finally{
	    
	    try {
		if(ptmt != null){
		  ptmt.close();  
		}if(con != null){
		    con.close();
		}
	    } catch (SQLException e) {
		 e.getStackTrace();
	    }catch (Exception e2) {
		e2.printStackTrace();
	    }
	}
	return confirmation;
	
    }
    
    public boolean updateUser(int id, String table, String content){
	
	boolean confirm = false;
	
	try{
	    String queryString = "UPDATE USER_PROJECT SET "+table+"=? WHERE id_user=?";
	    ptmt = con.prepareStatement(queryString);
	    ptmt.setString(1, content);
	    ptmt.setInt(2, id);
	    ptmt.executeUpdate();
	   
	    
	}catch(Exception ex){
	    ex.printStackTrace();
	}finally{
	    try{
		if(ptmt != null){
		    ptmt.close();
		    confirm = true;
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
    
    public boolean deleteUser(int userId){
	
	boolean confirmation = false;
	
	try{
	    String query = "DELETE FROM user_project WHERE id_user = ?";
	    ptmt = con.prepareStatement(query);
	    ptmt.setInt(1, userId);
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
    
    public boolean updatePassword(int idUser, String password){
	boolean flag = false;
	Hash hs2 = new Hash();
	byte[] passwordInByte = hs2.generateHash(password, "MD5");
	String newPassword = hs2.translate2Hexadecimal(passwordInByte);
	
	try{
	    
	    String query = "UPDATE USER_PROJECT SET PASSWORD = ? WHERE ID_USER = ?";
	    ptmt = con.prepareStatement(query);
	    ptmt.setString(1, newPassword);
	    ptmt.setInt(2, idUser);
	    ptmt.executeUpdate();
	    flag = true;
	}catch(Exception e){
	    System.out.println("Error update password: "+e.getMessage());
	}
	
	return flag;
    }
    
    
}

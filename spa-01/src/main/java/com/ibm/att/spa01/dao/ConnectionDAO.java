package com.ibm.att.spa01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectionDAO {
   
    private String url = null;
    private String driver = null;
    private String user = null;
    private String password = null;
    
    
    ConnectionDAO(){
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault());
	
	this.url = resourceBundle.getString("dbUrl");
	this.driver = resourceBundle.getString("dbDriver");
	this.user = resourceBundle.getString("dbUser");
	this.password = resourceBundle.getString("dbPassword");
	
    }
    
    public Connection getConection(){
	
	Connection con = null;
	try {
	    Class.forName(driver);
	    con = DriverManager.getConnection(url, user, password);
	   
	} catch (Exception e) {
	    System.out.println("Connection Fail: "+e.getMessage());
	}
	
	return con;
    }
    
    
//    private final static String DRIVER = "org.postgresql.Driver";
//    private final static String URL = "jdbc:postgresql://localhost:5432/spa-01";
//    private final static String USER = "postgres";
//    private final static String PASSWORD = "1234";
    
    
    
//    private final static String DRIVER = "com.mysql.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://localhost:3306/spa-01";
//    private final static String USER = "root";
//    private final static String PASSWORD = "";
    
//   private final static String DRIVER = "com.mysql.jdbc.Driver";
//    private final static String URL = "jdbc:mysql://9.8.235.59:3306/spa";
//    private final static String USER = "spa_user";
//    private final static String PASSWORD = "dqm50vnc";

   
//    public static Connection getConection(){
//	
//	Connection con = null;
//	try {
//	    Class.forName(DRIVER);
//	    con = DriverManager.getConnection(URL, USER, PASSWORD);
//	   
//	} catch (Exception e) {
//	    System.out.println("Connection Fail: "+e.getMessage());
//	}
//	
//	return con;
//    }
    

    
}

package com.shop.service;
import java.sql.*;
public class ConnectionService {
	
	
	

	public boolean getConnection(String username,String password) {

	Statement stmt=null;
	Connection conn=null;

	     //SQL Server Query String for a named instance

	     String connectionUrl = "jdbc:mysql://localhost:3306/dbshop";
	        try {
	       // Establish the connection.

	      Class.forName("com.mysql.jdbc.Driver");
	       conn = DriverManager.getConnection(connectionUrl,"root","toor");
	       //System.out.println("Connection made...");
	       //Execute SQL statements
	       stmt = conn.createStatement();
	       ResultSet rs = stmt.executeQuery("select * from Login");
	       
	       

	       if (rs != null) {
	         
	         while (rs.next()) {
	       	  
	        	 
	        	 if(username.trim().equals(rs.getString("username")) &&
	        			 password.trim().equals(rs.getString("password")))
	        		 return true;
	        			 
	         }
	       }
	        conn.close();

	      }



	  

	     catch (Exception e) {
	       e.printStackTrace();
	     } //catch
	         return false;

        

	   } 

	}




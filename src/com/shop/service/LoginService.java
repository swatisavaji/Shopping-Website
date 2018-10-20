package com.shop.service;
import java.sql.*;


public class LoginService {
	
	// Connect to a DB
	ConnectionService cs=new ConnectionService();
	
	
	public boolean authenticate(String username, String password)
	{
		
		boolean answer=cs.getConnection(username, password);
		
		return answer;
		
		
	}

}

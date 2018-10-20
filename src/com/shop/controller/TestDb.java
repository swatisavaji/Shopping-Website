package com.shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.shop.service.ConnectionService;
import com.shop.service.LoginService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestDb() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   

    



    	protected void doGet(HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		performTask(request, response);
    	}

    	protected void doPost(HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		performTask(request, response);
    	}

    	private void performTask(HttpServletRequest request,
    			HttpServletResponse response) throws ServletException, IOException {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("TestDb says hi");
    		out.println("<br/>");
    		//out.println(ConnectionService());
    
    		String username=request.getParameter("username");
			String password=request.getParameter("password");

    		ConnectionService cs=new ConnectionService();
    		LoginService ls=new LoginService();

    		boolean answer=ls.authenticate("java", "java");
    		
    		out.println(answer);
    	/*public String testJndiDataSource() {
    		Connection conn = null;
    		Statement st = null;
    		ResultSet rs = null;
    		StringBuffer sb = new StringBuffer();
    		try {
    			InitialContext ctx = new InitialContext();
    			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");

    			// This works too
    			// Context envCtx = (Context) ctx.lookup("java:comp/env");
    			// DataSource ds = (DataSource) envCtx.lookup("jdbc/TestDB");

    			conn = ds.getConnection();

    			st = conn.createStatement();
    			rs = st.executeQuery("SELECT * FROM employees");

    			while (rs.next()) {
    				String id = rs.getString("id");
    				String firstName = rs.getString("first_name");
    				String lastName = rs.getString("last_name");
    				sb.append("ID: " + id + ", First Name: " + firstName
    						+ ", Last Name: " + lastName + "<br/>");
    			}
    		} catch (Exception ex) {
    			ex.printStackTrace();
    		} finally {
    			try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
    			try { if (st != null) st.close(); } catch (SQLException e) { e.printStackTrace(); }
    			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    		}
    		return sb.toString();
    	}*/

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

}

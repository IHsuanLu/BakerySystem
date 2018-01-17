package Customer_ManagementE;

import java.util.*;
import java.sql.*;

public class hotDAO {
private Connection conn;

	
	public hotDAO() throws Exception {
		
		String user = "root";
		String password = "12345";
		String dburl = "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		// connect to database
		conn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
						
		} catch (Exception exc) {
			exc.getStackTrace();
		}
	}
	public List<String> getBean() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT sum(quantity) FROM Project.Order_Detail where p_name='Mung_Bean_Pastry'");
			while (myRs.next()) {
				String sum = myRs.getString("sum(quantity)");
				list.add(sum);
			}
//			Set<String> hs = new HashSet<>();
//			hs.addAll(list);
//			list.clear();
//			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	public List<String> getPine() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT sum(quantity) FROM Project.Order_Detail where p_name='Pineapple_Cake'");
			while (myRs.next()) {
				String sum = myRs.getString("sum(quantity)");
				list.add(sum);
			}
//			Set<String> hs = new HashSet<>();
//			hs.addAll(list);
//			list.clear();
//			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	public List<String> getYolk() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT sum(quantity) FROM Project.Order_Detail where p_name='Yolk_Pastry'");
			while (myRs.next()) {
				String sum = myRs.getString("sum(quantity)");
				list.add(sum);
			}
//			Set<String> hs = new HashSet<>();
//			hs.addAll(list);
//			list.clear();
//			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}public List<String> getCurry() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT sum(quantity) FROM Project.Order_Detail where p_name='Curry_Pastry'");
			while (myRs.next()) {
				String sum = myRs.getString("sum(quantity)");
				list.add(sum);
			}
//			Set<String> hs = new HashSet<>();
//			hs.addAll(list);
//			list.clear();
//			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {
	
		if (myRs != null) {
			myRs.close();
		}
	
		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}
}

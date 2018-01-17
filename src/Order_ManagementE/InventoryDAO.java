package Order_ManagementE;


import java.util.*;



import java.sql.*;
import java.io.*;
import java.math.BigDecimal;

public class InventoryDAO {

	
	private Connection myConn;
	
	public InventoryDAO() throws Exception {
		
		String user = "root";
		String password = "12345";
		String dburl = "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
						
		} catch (Exception exc) {
			exc.getStackTrace();
		}
	}
	
	public List<String> getQuantity(String p_name) throws Exception {
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select qty from Inventory where p_name like ?");
			
			myStmt.setString(1, p_name);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String OrderNo = myRs.getString("qty");
				list.add(OrderNo);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
//	public List<String> getLocation(String p_name) throws Exception {
//		List<String> list = new ArrayList<>();
//		
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//		
//		try {
//			myStmt = myConn.prepareStatement("select location from Inventory where p_name like ?");
//			
//			myStmt.setString(1, p_name);
//			
//			myRs = myStmt.executeQuery();
//			while (myRs.next()) {
//				String OrderNo = myRs.getString("location");
//				list.add(OrderNo);
//			}
//
//			return list;		
//		}
//		finally {
//			close(myStmt, myRs);
//		}
//	}
	
	public  void changeQty (String order_no , String p_name) throws Exception{
		int inventoryQ =0;
		int orderQ =0;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		PreparedStatement Stmt = null;
		ResultSet Rs = null;
		
		PreparedStatement newStmt = null;
		
//		ResultSet newRs = null;
		try {
		myStmt = myConn.prepareStatement("select qty from Inventory where p_name = ?");
		myStmt.setString(1, p_name);
		myRs = myStmt.executeQuery();
		while (myRs.next()) {
		String aString=myRs.getString("Qty");
		inventoryQ += Integer.valueOf(aString);
//		System.out.println(inventoryQ);
		}
		
		Stmt = myConn.prepareStatement("select quantity from order_detail where p_name = ? and order_no = ?");
		Stmt.setString(1, p_name);
		Stmt.setString(2, order_no);
		Rs = Stmt.executeQuery();
		while (Rs.next()) {
		String bString=Rs.getString("quantity");
		orderQ += Integer.valueOf(bString);
		System.out.println(orderQ);
		}
		
		
		String remaining = String.valueOf(inventoryQ - orderQ);
		
		
		newStmt = myConn.prepareStatement("UPDATE Inventory SET qty=? WHERE p_name=?");
		newStmt.setString(1, remaining);
		newStmt.setString(2, p_name);
		newStmt.executeUpdate();
		
//		return remaining;
		
		}finally {
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

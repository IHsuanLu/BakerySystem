package Order_ManagementE;

import java.util.*;


import Order_ManagementE.OrderList;

import java.sql.*;
import java.io.*;
import java.math.BigDecimal;;

public class OrderListDAO {
private Connection myConn;
	
	public OrderListDAO() throws Exception {
		
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
	
	public List<String> getAllOrderList() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select order_no from order_detail");
			while (myRs.next()) {
				String OrderNo = myRs.getString("order_no");
				list.add(OrderNo);
			}
			Set<String> hs = new HashSet<>();
			hs.addAll(list);
			list.clear();
			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}

	public List<String> searchOrderList(String order_no) throws Exception {
		List<String> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			order_no += "%";
			order_no = "%" + order_no;
			myStmt = myConn.prepareStatement("select order_no from order_detail where order_no like ?");
			
			myStmt.setString(1, order_no);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				String OrderNo = myRs.getString("order_no");
				list.add(OrderNo);
			}
			Set<String> hs = new HashSet<>();
			hs.addAll(list);
			list.clear();
			list.addAll(hs);
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<String> getAllPname(String order_no) throws Exception {
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select p_name from order_detail where order_no like ?");
			
			myStmt.setString(1, order_no);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String OrderNo = myRs.getString("p_name");
				list.add(OrderNo);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<String> getQuantity(String order_no) throws Exception {
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.prepareStatement("select quantity from order_detail where order_no like ?");
			
			myStmt.setString(1, order_no);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String OrderNo = myRs.getString("quantity");
				list.add(OrderNo);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public void deleteOrderList (String order_no) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
		myStmt = myConn.prepareStatement("DELETE FROM order_detail WHERE order_no = ?");
		
		myStmt.setString(1, order_no);
		
		myStmt.executeUpdate();
		}finally {
			close(myStmt, myRs);
		}
	}
	
	public void deleteOrder (String order_no) throws Exception{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		try {
		myStmt = myConn.prepareStatement("DELETE FROM OrderAll WHERE order_no = ?");
		
		myStmt.setString(1, order_no);
		
		myStmt.executeUpdate();
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
	
	public static void main(String[] args) throws Exception {
		
		OrderListDAO dao = new OrderListDAO();
		System.out.println(dao.getAllOrderList());
		
	}
}


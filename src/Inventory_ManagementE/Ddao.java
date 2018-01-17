package Inventory_ManagementE;

import java.util.*;


import java.sql.*;
import java.io.*;
public class Ddao {

	private Connection myConn;
	
	public Ddao() throws Exception {
		

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
	
	public void deleteProduct(String productNo) throws SQLException{
		PreparedStatement myStmt = null;
		
		try{
			//prepare statement
			myStmt = myConn.prepareStatement("delete from Inventory where p_no=?");
			
			//set param
			myStmt.setString(1, productNo);
			
			// execute SQL
			myStmt.executeUpdate();	
		} 
		finally{
			close(myStmt);
		}
	}
	
	public void updateInventory(Inventory theInventory) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update Inventory"
					+ " set p_no=?, p_name=?, price=?, year=?, description=?,qty=?"
					+ " where p_no=?");
			
			// set params
			myStmt.setString(1, theInventory.getPno());
			myStmt.setString(2, theInventory.getPname());
			myStmt.setString(3, theInventory.getPrice());
			myStmt.setString(4, theInventory.getYear());
			myStmt.setString(5, theInventory.getDescription());
			myStmt.setDouble(6, theInventory.getQty());
			myStmt.setString(7, theInventory.getPno());
			// execute SQL
			myStmt.executeUpdate();		
			}

		finally {
			close(myStmt);
		}
		
	}
	
	
	public List<Inventory> getAllInventory() throws Exception {
		List<Inventory> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from Inventory");
			
			while (myRs.next()) {
				Inventory tempInventory = convertRowToInventory(myRs);
				list.add(tempInventory);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Inventory> searchProductName(String p_name) throws Exception {
		List<Inventory> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {		
			p_name += "%";
			myStmt = myConn.prepareStatement("select * from Inventory where p_name like ?");
			
			myStmt.setString(1, p_name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Inventory tempInventory = convertRowToInventory(myRs);
				list.add(tempInventory);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<Inventory> searchProductNumber(String p_no) throws Exception {
		List<Inventory> list = new ArrayList<>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {		
			p_no += "%";
			myStmt = myConn.prepareStatement("select * from Inventory where p_no like ?");
			
			myStmt.setString(1, p_no);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Inventory tempInventory = convertRowToInventory(myRs);
				list.add(tempInventory);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	private Inventory convertRowToInventory(ResultSet myRs) throws SQLException {
		
		String p_no = myRs.getString("p_no");
		String p_name = myRs.getString("p_name");
		String price = myRs.getString("price");
		String year = myRs.getString("year");
		String description = myRs.getString("description");
		Integer qty = myRs.getInt("qty");
		
		Inventory tempInventory = new Inventory(p_no, p_name, price, year, description, qty);
		
		return tempInventory;
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
	
	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}

	public static void main(String[] args) throws Exception {
		 
		Ddao Ddao = new Ddao();
		System.out.println(Ddao.searchProductName("ring"));

		//System.out.println(Ddao.getAllEmployees());  //get所有員工的資料
	}

}


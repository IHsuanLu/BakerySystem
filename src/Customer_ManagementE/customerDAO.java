package Customer_ManagementE;

import java.util.*;


import java.sql.*;

public class customerDAO {
	
private Connection conn;

	
	public customerDAO() throws Exception {
		
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
	//找出R
	public  List<String> analysisDate() {
		List<String> list = new ArrayList<>();
		List<String> list2 =new ArrayList<>();
		List<String> list3 =new ArrayList<>();
		List<String> list4 =new ArrayList<>();
		Object[][] data;
		Statement myStmt = null;
		ResultSet myRs = null;
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT count(distinct order_no),max(date),sum(total_price),cus_ssn FROM OrderAll group by cus_ssn ");
			while (myRs.next()) {
				
				String date = myRs.getString("max(date)");
				list.add(date);
				String cus_ssn = myRs.getString("cus_ssn");
				list2.add(cus_ssn);
				String time = myRs.getString("count(distinct order_no)");
				list3.add(time);
				String money = myRs.getString("sum(total_price)");
				list4.add(money);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	//以兩群為例
	public List<String> findF1() throws Exception {



		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT count(distinct order_no) ,cus_ssn FROM OrderAll group by cus_ssn order by count(distinct order_no) desc limit 4");
			while (myRs.next()) {
				String CusNo = myRs.getString("cus_ssn");
				list.add(CusNo);
			}
//
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<String> findF2() throws Exception {

		
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT count(distinct order_no) ,cus_ssn FROM OrderAll group by cus_ssn order by count(distinct order_no) asc limit 4");
			while (myRs.next()) {
				String CusNo = myRs.getString("cus_ssn");
				list.add(CusNo);
			}
//
			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<String> getCusList() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT distinct cus_ssn FROM OrderAll order by cus_ssn");
			while (myRs.next()) {
				String CusNo = myRs.getString("cus_ssn");
				list.add(CusNo);
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
	
	
	public List<String> getM(String cus_ssn) throws Exception {
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.prepareStatement("SELECT sum(total_price) FROM OrderAll where cus_ssn like ?");
			
			myStmt.setString(1, cus_ssn);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String price = myRs.getString("sum(total_price)");
				list.add(price);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	
	public List<String> getR(String cus_ssn) throws Exception{
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.prepareStatement("SELECT date FROM OrderAll where cus_ssn like ? ORDER BY date DESC");
			
			myStmt.setString(1, cus_ssn);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String date = myRs.getString("date");
				list.add(date);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	public List<String> getF(String cus_ssn) throws Exception{
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.prepareStatement("SELECT COUNT(DISTINCT order_no) FROM OrderAll where cus_ssn like ? ");
			
			myStmt.setString(1, cus_ssn);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String time = myRs.getString("count(distinct order_no)");
				list.add(time);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	public List<String> RFM(String cus_ssn) throws Exception{
		List<String> list = new ArrayList<>();
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.prepareStatement("SELECT RFM FROM cluster where cus_ssn like ? ");
			
			myStmt.setString(1, cus_ssn);
			
			myRs = myStmt.executeQuery();
			while (myRs.next()) {
				String value = myRs.getString("RFM");
				list.add(value);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
		
	}
	
	public List<String> showRFM() throws Exception {
		List<String> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT RFM FROM cluster order by RFM asc");
			while (myRs.next()) {
				String value = myRs.getString("RFM");
				list.add(value);
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
	public List<Double> showRes() throws Exception {
		List<Double> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = conn.createStatement();
			myRs = myStmt.executeQuery("SELECT response FROM Result order by RFM asc");
			while (myRs.next()) {
				Double value = myRs.getDouble("response");
				list.add(value);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	

public void updateCustomer(){
		
		PreparedStatement command = null;
		int[] rfm = new int[]{222, 211, 122, 112, 212, 221, 121, 111};
		int[] cus_ssn = new int[]{10, 104306039, 105, 123, 456, 666, 88, 888};
		try{
			for(int i = 0;i<rfm.length; i++){
				
			command = conn.prepareStatement("UPDATE cluster SET RFM=? WHERE cus_ssn = ?");
			
			
			command.setInt(1, rfm[i]);
			command.setInt(2, cus_ssn[i]);



			command.executeUpdate();
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
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

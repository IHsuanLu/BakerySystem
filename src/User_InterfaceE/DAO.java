package User_InterfaceE;



import java.sql.*;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.swing.JOptionPane;

public class DAO implements CurrentDate{

	private Connection conn = null;
	
	private	String Muname;
	private long counter;
	
	private double convertedqtyRing ;
	private double convertedqtyNecklace ;
	private double convertedqtyEarrings ;
	private double convertedqtyBracelet ;
	private String convertedSSN ;
	private String convertedPassword ;
	private String convertedName ;
	private String convertedTel;
	private String convertedAddress;
	private String convertedEmail;
	
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	
		
	DAO(String Muname, long counter){
		
		this.Muname = Muname;
		this.counter = counter;
	
		
		System.out.println(Muname  + " from DAO");
		System.out.println(counter + " from DAO");
		
		
		String user = "root";
		String password = "12345";
		String dburl = "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		// connect to database
		conn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
						
		} catch (Exception exc) {
			System.out.println("X");
			exc.getStackTrace();
		}
	}
	
	public DAO(){
		
		String user = "root";
		String password = "12345";
		String dburl = "jdbc:mysql://localhost:3306/Project?characterEncoding=utf8";

		try {
		Class.forName("com.mysql.jdbc.Driver");
		// connect to database
		conn = DriverManager.getConnection(dburl, user, password);
		System.out.println("DB connection successful to: " + dburl);
						
		} catch (Exception exc) {
			System.out.println("X");
			exc.getStackTrace();
		}
	}
	

	public void addCustomer (Customer theCustomer) {
		
		PreparedStatement command = null;
 		
		try{
			// prepare statement
			command = conn.prepareStatement("INSERT INTO Customer (cus_ssn, cus_name, cus_tel, address, email, password) values (?, ?, ?, ?, ?, ?)");
			
			command.setString(1, theCustomer.getSsn());
			command.setString(2, theCustomer.getCusname());
			command.setString(3, theCustomer.getCustel());
			command.setString(4, theCustomer.getAddress());
			command.setString(5, theCustomer.getEmail());
			command.setString(6, theCustomer.getPassword());

			command.executeUpdate();
			
		}catch(Exception exc){
			exc.printStackTrace();
		} 
	}
	
	public void updateCustomer(Customer theCustomer){
		
		PreparedStatement command = null;
		
		try{
			command = conn.prepareStatement("UPDATE Customer SET cus_ssn=?, cus_name=?, cus_tel=?, address=?, email=?, password=? WHERE cus_ssn = ?");
			
			
			command.setString(1, theCustomer.getSsn());
			command.setString(2, theCustomer.getCusname());
			command.setString(3, theCustomer.getCustel());
			command.setString(4, theCustomer.getAddress());
			command.setString(5, theCustomer.getEmail());
			command.setString(6, theCustomer.getPassword());
			command.setString(7, Muname);



			command.executeUpdate();
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}

	
	public String SearchAndGetSSN(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;

		
		try{
			command = conn.prepareStatement("SELECT cus_ssn FROM Customer WHERE cus_ssn =" + cus_ssn +";");
						
			rs = command.executeQuery();
			
			while(rs.next()){
				
				convertedSSN = convertToStringSSN(rs);	
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
		
		return convertedSSN ;
	}
	
	public String SearchAndGetPassword(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT password FROM Customer WHERE cus_ssn =" + cus_ssn + " ;");
			
//			command.setString(1, cus_ssn);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedPassword = convertToStringPassword(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
		
		return convertedPassword;
	}
	
	
	public String getUsername(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT cus_name FROM Customer WHERE cus_ssn =" + cus_ssn +";");
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedName = convertToStringName(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedName;
		
	}
	
	public String getUserTel(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT cus_tel FROM Customer WHERE cus_ssn =" + cus_ssn +";");
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedTel = convertToStringTel(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedTel;
		
	}	
	
	public String getUserAddress(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT address FROM Customer WHERE cus_ssn =" + cus_ssn +";");
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedAddress = convertToStringAddress(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedAddress;
		
	}	
	
	public String getUserEmail(String cus_ssn){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT email FROM Customer WHERE cus_ssn =" + cus_ssn +";");
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedEmail = convertToStringEmail(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedEmail;
		
	}	
	
	

	public double getPineappleQty(){
		
		try {
				PreparedStatement command = null;
				ResultSet rs = null;
			
				command = conn.prepareStatement("SELECT qty FROM Inventory WHERE p_name = 'Pineapple_Cake'");
				
				rs = command.executeQuery();		
				
				while(rs.next()){
					convertedqtyRing = convertToDouble(rs);
				}
				
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		
		return convertedqtyRing;
	}
	
	
	public double getMungBeanQty(){
		
		try {
				PreparedStatement command = null;
				ResultSet rs = null;
			
				command = conn.prepareStatement("SELECT qty FROM Inventory WHERE p_name = 'Mung_Bean_Pastry'");
				
				rs = command.executeQuery();		
				
				while(rs.next()){
					convertedqtyNecklace = convertToDouble(rs);
				}
				
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		
		return convertedqtyNecklace;
	}
	
	public double getCurryQty(){
		
		try {
				PreparedStatement command = null;
				ResultSet rs = null;
			
				command = conn.prepareStatement("SELECT qty FROM Inventory WHERE p_name = 'Curry_Pastry'");
				
				rs = command.executeQuery();		
				
				while(rs.next()){
					convertedqtyEarrings = convertToDouble(rs);
				}
				
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		System.out.println(convertedqtyBracelet);
		return convertedqtyEarrings;
	}
	
	public double getYolkQty(){
		
		try {
				PreparedStatement command = null;
				ResultSet rs = null;
			
				command = conn.prepareStatement("SELECT qty FROM Inventory WHERE p_name = 'Yolk_Pastry'");
				
				rs = command.executeQuery();		
				
				while(rs.next()){
					convertedqtyBracelet = convertToDouble(rs);
				}
				
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
		System.out.println(convertedqtyBracelet);
		return convertedqtyBracelet;
	}
	
	
	
	public void InsertPineapple(Double quantity){		
		
		try{
			PreparedStatement command = null;
			ResultSet rs = null;
			
			command = conn.prepareStatement("INSERT INTO Order_Detail (order_no, p_name, quantity, price, date) values (?, 'Pineapple_Cake', ?, '18', ?)");
			
			String theCounter = String.valueOf(counter);
			
			command.setString(1, "#" + theCounter);
			command.setDouble(2, quantity);
			command.setString(3, ft.format(date));
			
			command.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "加入成功！");

			System.out.println("Insert Successfully");
			
		} catch(Exception exc){
			
			exc.printStackTrace();
			JOptionPane.showMessageDialog(null, "已經加入購物車了！");
		}
	}
	
	
public void InsertMungBean(Double quantity){		
		
		try{
			PreparedStatement command = null;
			ResultSet rs = null;
			
			command = conn.prepareStatement("INSERT INTO Order_Detail (order_no, p_name, quantity, price) values (?, 'Mung_Bean_Pastry', ?, '26')");
			
			String theCounter = String.valueOf(counter);
			
			command.setString(1, "#" + theCounter);
//			int q = (int) quantity.doubleValue();
			command.setDouble(2, quantity);
			
//			System.out.println(command);
			command.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "加入成功！");

			System.out.println("Insert Successfully");
			
		} catch(Exception exc){
						
			JOptionPane.showMessageDialog(null, "已經加入購物車了！");
		}
	}

public void InsertCurry(Double quantity){		
	
	try{
		PreparedStatement command = null;
		ResultSet rs = null;
		
		command = conn.prepareStatement("INSERT INTO Order_Detail (order_no, p_name, quantity, price) values (?, 'Curry_Pastry', ?, '33')");
		
		String theCounter = String.valueOf(counter);
		
		command.setString(1, "#" + theCounter);
		command.setDouble(2, quantity);
		
		command.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "加入成功！");

		System.out.println("Insert Successfully");
		
	} catch(Exception exc){
					
		JOptionPane.showMessageDialog(null, "已經加入購物車了！");
	}
}


public void InsertYolk(Double quantity){		
	
	try{
		PreparedStatement command = null;
		ResultSet rs = null;
		
		command = conn.prepareStatement("INSERT INTO Order_Detail (order_no, p_name, quantity, price) values (?, 'Yolk_Pastry', ?, '35')");
		
		String theCounter = String.valueOf(counter);
		
		command.setString(1, "#" + theCounter);
		command.setDouble(2, quantity);
		
		command.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "加入成功！");

		System.out.println("Insert Successfully");
		
	} catch(Exception exc){
					
		JOptionPane.showMessageDialog(null, "已經加入購物車了！");
	}
}



	
	public List<OrderDetail> getOrderDetail(String theCounter){
		
		List<OrderDetail> list = new ArrayList<>();
			
		PreparedStatement command = null;
		ResultSet rs = null;

			try{
				command = conn.prepareStatement("SELECT * FROM Order_detail WHERE order_no = ?");
				
				command.setString(1, theCounter);
				
				rs = command.executeQuery();
				
				while(rs.next()){
					OrderDetail tempOrderDetail  = convertRowToEmployee(rs);
					list.add(tempOrderDetail);
				}
				
			} catch(Exception exc){
				exc.printStackTrace();
			}
			
			System.out.println(list);
			return list;
		}
	
	public List<OrderDetail> getEmptyOrderDetail(){
		
		List<OrderDetail> list = new ArrayList<>();
			
		PreparedStatement command = null;
		ResultSet rs = null;

			try{
				command = conn.prepareStatement("SELECT * FROM Order_detail WHERE order_no = ?");
				
				command.setString(1, "#999999999");
				
				rs = command.executeQuery();
				
				while(rs.next()){
					OrderDetail tempOrderDetail  = convertRowToEmployee(rs);
					list.add(tempOrderDetail);
				}
				
			} catch(Exception exc){
				exc.printStackTrace();
			}
			return list;
		}
	
	public int getCalculateFactor1(String theCounter){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		int K = 0;
			try {
				command = conn.prepareStatement("SELECT quantity, price FROM Order_detail WHERE order_no = ?");
				
				command.setString(1, theCounter);
				
				rs = command.executeQuery();
				
				while (rs.next()) {
				
					K = K + (Integer.parseInt(rs.getString(1))*(Integer.parseInt(rs.getString(2))));
				}
			} catch (Exception exc){
				exc.printStackTrace();
			}
			
			return K;
	}
	
	
	public void insertIntoOrder(int totalPrice){
		
		try{
			PreparedStatement command = null;
			ResultSet rs = null;
			
			command = conn.prepareStatement("INSERT INTO OrderAll (order_no, total_price, cus_ssn, date) values (?, ?, ?, ?)");
			
			String theCounter = String.valueOf(counter);
			
			command.setString(1, "#" + theCounter);
			command.setInt(2, totalPrice);
			command.setString(3, Muname);
			
			command.setString(4, ft.format(date));
			
			
			command.executeUpdate();
			
			System.out.println("Insert Successfully");
			
			
		} catch(Exception exc){
						
			exc.printStackTrace();
		}
		
	}

		
	
	public void DeleteFromCart(String p_name){		
		
		try{
				PreparedStatement command = null;
			
				command = conn.prepareStatement("DELETE FROM Order_Detail WHERE p_name = ?");
			
				command.setString(1, p_name);
			
				command.executeUpdate();
				

		} catch(Exception exc){
			JOptionPane.showMessageDialog(null, "已經加入購物車了！");
		}
	}
	
	public void DeleteFromCartALL(String theCounter){		
		
		try{
				PreparedStatement command = null;
			
				command = conn.prepareStatement("DELETE FROM Order_Detail WHERE order_no = ?");
			
				command.setString(1, theCounter);
			
				command.executeUpdate();
				

		} catch(Exception exc){
			JOptionPane.showMessageDialog(null, "已經加入購物車了！");
		}
	}
	
	
	private OrderDetail convertRowToEmployee(ResultSet myRs) throws SQLException {

		String order_no = myRs.getString("order_no");
		String p_name = myRs.getString("p_name");
		Double quantity = myRs.getDouble("quantity");
		String price = myRs.getString("price");
		
		OrderDetail tempOrderDetail = new OrderDetail(order_no, p_name, quantity, price);
		
		return tempOrderDetail;
	}
	
	private double convertToDouble(ResultSet myRs) throws SQLException{
		
		Double qty = myRs.getDouble("qty");
		
		return qty;
		
	}
	
	private String convertToStringSSN(ResultSet myRs) throws SQLException{
		
		String cus_ssn = myRs.getString("cus_ssn");
		
		return cus_ssn;	
	}
	
	private String convertToStringPassword(ResultSet myRs) throws SQLException{
		
		String password = myRs.getString("password");
		
		return password;	
	}
	
	private String convertToStringName(ResultSet myRs) throws SQLException{
		
		String cus_name = myRs.getString("cus_name");
		
		return cus_name;	
	}
	
	private String convertToStringTel(ResultSet myRs) throws SQLException{
		
		String cus_tel = myRs.getString("cus_tel");
		
		return cus_tel;	
	}
	
	private String convertToStringAddress(ResultSet myRs) throws SQLException{
		
		String address = myRs.getString("address");
		
		return address;	
	}
	
	private String convertToStringEmail(ResultSet myRs) throws SQLException{
		
		String email = myRs.getString("email");
		
		return email;	
	}


}

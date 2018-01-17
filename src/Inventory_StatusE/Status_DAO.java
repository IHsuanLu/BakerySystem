package Inventory_StatusE;

import java.math.BigDecimal;
import java.security.GeneralSecurityException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import javax.swing.JOptionPane;

import Inventory_ManagementE.Inventory;
import User_InterfaceE.CartTableModel;
import User_InterfaceE.OrderDetail;

public class Status_DAO {
	
	private Connection conn = null;
	private String convertedDate;
	private String convertedNO;
	private int convertedPrice;
	private double convertedMPrice;

	public Status_DAO() {

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
	
	
	public void updateMaterialWeight(int m_weight, String latest_purchase, String m_no, long latest_orderno){
		
		PreparedStatement command = null;
		
		try{
			command = conn.prepareStatement("UPDATE Raw_Materials SET m_weight=?, latest_purchase=?, latest_orderno=? WHERE m_no = ?");
			
			command.setInt(1, m_weight);
			command.setString(2, latest_purchase);
			command.setLong(3, latest_orderno);
			command.setString(4, m_no);

			command.executeUpdate();
			
		} catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public String getLatestPurchase(String m_no){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT latest_purchase FROM Raw_Materials WHERE m_no=?");
			
			command.setString(1, m_no);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedDate = convertToDate(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedDate;
	}
	
	public String getLatestOrderno(String m_no){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT latest_orderno FROM Raw_Materials WHERE m_no=?");
			
			command.setString(1, m_no);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedNO = convertToNO(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedNO;
	}
	
	public List<RawMaterials> getGeneralMaterials(){
		
		List<RawMaterials> list = new ArrayList<>();
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try {
				command = conn.prepareStatement("SELECT * from Raw_Materials WHERE m_no IN (?, ?, ?)");
				
				command.setString(1, "G101");
				command.setString(2, "G102");
				command.setString(3, "G103");

				
				rs = command.executeQuery();
			
			while (rs.next()) {
				RawMaterials tempRawMaterials = convertRowToRawMaterials(rs);
				list.add(tempRawMaterials);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getPrice(String p_no){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT price FROM Inventory WHERE p_no=?");
			
			command.setString(1, p_no);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedPrice = convertToPrice(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedPrice;
	}
	
	public double getMPrice(String m_no){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		
		try{
			command = conn.prepareStatement("SELECT m_price FROM Raw_Materials WHERE m_no=?");
			
			command.setString(1, m_no);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedMPrice = convertToMPrice(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedMPrice;
	}
	
	public void InsertStoreOrder(String s_order_no, String m_name, double s_total_price, String s_order_date){		
		
		try{
			PreparedStatement command = null;
			
			command = conn.prepareStatement("INSERT INTO Store_OrderDetail (s_order_no, m_name, s_total_price, s_order_date) values (?, ?, ?, ?)");
			
			command.setString(1, s_order_no);
			command.setString(2, m_name);
			command.setDouble(3, s_total_price);
			command.setString(4, s_order_date);
			
			command.executeUpdate();
			
			System.out.println("Insert Successfully");
			
		} catch(Exception exc){
			
			exc.printStackTrace();
		}
	}
	
	
	private RawMaterials convertRowToRawMaterials(ResultSet myRs) throws SQLException {
		
		String m_no = myRs.getString("m_no");
		String m_name = myRs.getString("m_name");
		BigDecimal m_price = myRs.getBigDecimal("m_price");
		int m_weight = myRs.getInt("m_weight");
		String latest_purchase = myRs.getString("latest_purchase");
		String latest_orderno = myRs.getString("latest_orderno");
		
		RawMaterials tempRawMaterials = new RawMaterials(m_no, m_name, m_price, m_weight, latest_purchase, latest_orderno);
		
		return tempRawMaterials;
	}


	private String convertToDate(ResultSet myRs) throws SQLException{
		
		String date = myRs.getString("latest_purchase");
		
		return date;	
	}
	
	private String convertToNO(ResultSet myRs) throws SQLException{
		
		String no = myRs.getString("latest_orderno");
		
		return no;	
	}
	
	private int convertToPrice(ResultSet myRs) throws SQLException{
		
		int price = myRs.getInt("price");
		
		return price;	
	}
	
	private double convertToMPrice(ResultSet myRs) throws SQLException{
		
		double m_price = myRs.getDouble("m_price");
		
		return m_price;	
	}
	
}

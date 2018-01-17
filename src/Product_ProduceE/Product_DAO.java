package Product_ProduceE;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import GUI_Tutorial.Employee;


public class Product_DAO {
	
	private Connection conn = null;

	public Product_DAO() {

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
	
	
	public int getWeightOf(String m_no){
		
		PreparedStatement command = null;
		ResultSet rs = null;
		int convertedWeight = 0;
		
		try{
			command = conn.prepareStatement("SELECT m_weight FROM Raw_Materials WHERE m_no = ?");
			
			command.setString(1, m_no);
			
			rs = command.executeQuery();
			
			while(rs.next()){
				convertedWeight = convertToWeight(rs);
			}
			
		} catch(Exception exc){
			exc.printStackTrace();
		}

		return convertedWeight;
		
	}
	
	public List<String> getAllMaterialsNo(){
		
		List<String> list = new ArrayList<>();
		
		Statement command = null;
		ResultSet rs = null;
		
		try {
			command = conn.createStatement();
			rs = command.executeQuery("select m_no from Raw_Materials");
			
			while (rs.next()) {
				String convertedString = convertToString(rs);
				list.add(convertedString);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println(list);
		return list;	
	}
	
	public void setInventoryQty(int newValue, String p_no){
		
		PreparedStatement command = null;
		
		try{
			command = conn.prepareStatement("UPDATE Inventory SET qty = ? WHERE p_no = ?");
			
			command.setInt(1, newValue);
			command.setString(2, p_no);
			
			command.executeUpdate();
			
		} catch(Exception exc){
			exc.printStackTrace();
		}	
	}
	
	public void setMaterialWeight(int newValue, String m_no){
		
		PreparedStatement command = null;
		
		try{
			command = conn.prepareStatement("UPDATE Raw_Materials SET m_weight = ? WHERE m_no = ?");
			
			command.setInt(1, newValue);
			command.setString(2, m_no);
			
			command.executeUpdate();
			
		} catch(Exception exc){
			exc.printStackTrace();
		}	
	}
	
	
	private int convertToWeight(ResultSet myRs) throws SQLException{
		
		int m_weight = myRs.getInt("m_weight");
		
		return m_weight;
		
	}
	
	private String convertToString (ResultSet myRs) throws SQLException{
		
		String m_no = myRs.getString("m_no");
		
		return m_no;
	}
	
	
}

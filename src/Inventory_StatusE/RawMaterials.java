package Inventory_StatusE;

import java.math.BigDecimal;
import java.sql.Date;

public class RawMaterials {
	
	private String m_no;
	private String m_name;
	private BigDecimal m_price;
	private int m_weight;
	private String latest_purchase;
	private String latest_orderno;
	
	public RawMaterials (String m_no, String m_name, BigDecimal m_price, int m_weight, String latest_purchase, String latest_orderno){
		super();
		
		this.m_no = m_no;
		this.m_name = m_name;
		this.m_price = m_price;
		this.m_weight = m_weight;
		this.latest_purchase = latest_purchase;
		this.latest_orderno = latest_orderno;
	}
	
	public String getM_no(){
		return m_no;
	}
	
	public String getM_name(){
		return m_name;
	}
	
	public BigDecimal getM_price(){
		return m_price;
	}
	
	public int getM_weight(){
		return m_weight;
	}
	
	public String getLatest_Purchase(){
		return latest_purchase;
	}
	
	public String getLatest_Orderno(){
		return latest_orderno;
	}
}

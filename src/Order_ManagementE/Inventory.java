package Order_ManagementE;

import java.math.BigDecimal;

public class Inventory {
	private String p_no;
	private String p_name;
	private BigDecimal price;
	private int year;
	private String description;
	private int Qyt;
	
	public Inventory (String p_no,String p_name,BigDecimal price,int year,String description,int Qyt) {
		super();
		this.p_no= p_no;
		this.p_name = p_name;
		this.price = price;
		this.year = year;
		this.description = description;
		this.Qyt = Qyt;
	}
	
	public String getP_no() {
		return p_no;
	}
	
	public String getP_name() {
		return p_name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getQty() {
		return Qyt;
	}
	
}

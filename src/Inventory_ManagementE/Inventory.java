package Inventory_ManagementE;

import java.math.BigDecimal;

public class Inventory {

	private String p_no;
	private String p_name;
	private String price;
	private String year;
	private String description;
	private Integer qty;

	
	public Inventory(String p_no, String p_name, String price, String year,
			String description, Integer qty) {
		super();
		
		this.p_no = p_no;
		this.p_name = p_name;
		this.price = price;
		this.year = year;
		this.description = description;
		this.qty = qty;
	
	}
	
	public String getPno(){
		return p_no;
	}
	
	public String setPno(String p_no){
		return p_no;
	}
	
	public String getPname() {
		return p_name;
	}

	public void setPname(String p_name) {
		this.p_name = p_name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty= qty;
	}

//	@Override
//	public String toString() {
//		return String
//				.format("Employee [id=%s, lastName=%s, firstName=%s, email=%s, salary=%s]",
//						p_name, price, year, description);
//	}
	
}

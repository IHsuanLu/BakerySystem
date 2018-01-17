package Order_ManagementE;

import java.math.BigDecimal;

public class OrderList {
	private String order_no;
	private String p_name;
	private int quantity;
	private BigDecimal price;
	
	public  OrderList(String order_no,String p_name,int quantity,BigDecimal price) {
		super();
		this.order_no= order_no;
		this.p_name = p_name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getOrder_no() {
		return order_no;
	}
	
	public String getP_name() {
		return p_name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public String toString() {
		return String
				.format("OrderList [order_no=%s, p_name=%s, quantity=%s, price=%s]",
						order_no, p_name, quantity, price);
	}
}

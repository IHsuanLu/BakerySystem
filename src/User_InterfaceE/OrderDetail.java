package User_InterfaceE;


public class OrderDetail {

	private String order_no;
	private String p_name;
	private Double quantity;
	private String price;
	
	public OrderDetail(String order_no, String p_name, Double quantity, String price) {
		
		super();
		
		this.order_no = order_no;
		this.p_name = p_name;
		this.quantity = quantity;
		this.price = price;
		
	}
	
	public String getOrderno(){
		return order_no;
	}
	
	public String setOrderno(String order_no){
		return order_no;
	}
	
	public String getPname() {
		return p_name;
	}

	public void setPname(String p_name) {
		this.p_name = p_name;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantuty(Double quantity) {
		this.quantity= quantity;
	}
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return String
				.format("OrderDetail [order_no=%s, p_name=%s, quantity=%s, price=%s]",
						order_no, p_name, quantity, price);
	}
}


package User_InterfaceE;

import java.math.BigDecimal;

public class Customer {

	private String cus_ssn;
	private String cus_name;
	private String cus_tel;
	private String address;
	private String email;
	private String password;

	
	public Customer(String cus_ssn, String cus_name, String cus_tel, String address,
			String email, String password) {
		super();
		
		this.cus_ssn = cus_ssn;
		this.cus_name = cus_name;
		this.cus_tel = cus_tel;
		this.address = address;
		this.email = email;
		this.password = password;
	
	}
	
	public String getSsn(){
		return cus_ssn;
	}
	
	public String setSsn(String cus_ssn){
		return cus_ssn;
	}
	
	public String getCusname() {
		return cus_name;
	}

	public void setCusname(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCustel() {
		return cus_tel;
	}

	public void setCustel(String cus_tel) {
		this.cus_tel = cus_tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password= password;
	}

//	@Override
//	public String toString() {
//		return String
//				.format("Employee [id=%s, lastName=%s, firstName=%s, email=%s, salary=%s]",
//						cus_name, cus_tel, address, email);
//	}
	
}

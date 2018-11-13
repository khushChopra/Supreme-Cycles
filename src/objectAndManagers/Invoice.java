package objectAndManagers;

public class Invoice{	
	private int id;
	java.sql.Timestamp creation;
	private String customer_number;
	private String address;
	private int amount;
	private String transportservice_id;
	
	
	public String toString(){
		return "{customer_number=" + customer_number +", amount="+amount+", address="+address+" }";
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public java.sql.Timestamp getcreation() {
		return creation;
	}

	public void setCreation(java.sql.Timestamp creation) {
		this.creation = creation;
	}




	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getCustomer_number() {
		return customer_number;
	}



	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}



	public String getTransportservice_id() {
		return transportservice_id;
	}



	public void setTransportservice_id(String transportservice_id) {
		this.transportservice_id = transportservice_id;
	}
}
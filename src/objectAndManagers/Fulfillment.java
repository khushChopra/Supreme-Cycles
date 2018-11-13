package objectAndManagers;

public class Fulfillment{
	private String customer_number;
	private String requirements;
	private java.sql.Timestamp generated_time;
	private String address;
	private int price;
	
	@Override
	public String toString(){
		return "{customer_number=" + customer_number +", generated_time="+generated_time.toString()+", Price="+String.valueOf(price)+" }";
	}


	public java.sql.Timestamp getGenerated_time(){
		return generated_time;
	}
	
	public void setGenerated_time(java.sql.Timestamp generated_time) {
		this.generated_time = generated_time;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}




	public String getCustomer_number() {
		return customer_number;
	}




	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}
}
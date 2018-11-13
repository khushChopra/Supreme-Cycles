package objectAndManagers;

public class CycleCart{
	private String customer_number;
	private String cycle_code;
	private int quantity;
	
	@Override
	public String toString(){
		return "{customer_number=" + customer_number +", cycle_code="+cycle_code+", quantity="+String.valueOf(quantity)+" }";
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getCycle_code() {
		return cycle_code;
	}

	public void setCycle_code(String cycle_code) {
		this.cycle_code = cycle_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
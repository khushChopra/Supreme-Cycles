package objectAndManagers;

public class AccessoryCart{
	private String customer_number;
	private String accessory_code;
	private int quantity;
	
	@Override
	public String toString(){
		return "{customer_number=" + customer_number +", accessory_code="+accessory_code+", quantity="+String.valueOf(quantity)+" }";
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getAccessory_code() {
		return accessory_code;
	}

	public void setAccessory_code(String accessory_code) {
		this.accessory_code = accessory_code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
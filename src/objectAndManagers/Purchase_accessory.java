package objectAndManagers;

public class Purchase_accessory{
	private String model_code;
	private int purchase_id;
	private int quantity;
	
	@Override
	public String toString(){
		return "{model_code=" + model_code +", quantity="+quantity+", purchase_id="+String.valueOf(purchase_id)+" }";
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}


	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
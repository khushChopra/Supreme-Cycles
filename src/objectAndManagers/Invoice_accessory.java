package objectAndManagers;

public class Invoice_accessory{
	private int invoice_id;
	private String model_code;
	private int quantity;
	
	@Override
	public String toString(){
		return "{invoice_id=" + invoice_id +", model_code="+model_code+", quantity="+String.valueOf(quantity)+" }";
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}
}
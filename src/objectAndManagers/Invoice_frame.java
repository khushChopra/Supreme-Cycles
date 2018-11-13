package objectAndManagers;

public class Invoice_frame{
	private int invoice_id;
	private String model_code;
	private String frame_number;
	
	@Override
	public String toString(){
		return "{invoice_id=" + invoice_id +", model_code="+model_code+", frame_number="+frame_number+" }";
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

	public String getFrame_number() {
		return frame_number;
	}

	public void setFrame_number(String frame_number) {
		this.frame_number = frame_number;
	}
}
package objectAndManagers;

public class Cycle_frame{
	private String frame_number;
	private String model_code;
	private int purchase_id;
	
	@Override
	public String toString(){
		return "{frame_number=" + frame_number +", model_code="+model_code+", purchase_id="+String.valueOf(purchase_id)+" }";
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getFrame_number() {
		return frame_number;
	}

	public void setFrame_number(String frame_number) {
		this.frame_number = frame_number;
	}


	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
}
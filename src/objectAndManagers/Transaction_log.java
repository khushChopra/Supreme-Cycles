package objectAndManagers;

public class Transaction_log{
	private String details;
	private String type;
	private int id;
	private int amount;
	java.sql.Timestamp creation;
	
	@Override
	public String toString(){
		return "{details=" + details +", type="+type+", creation="+creation+", amount="+String.valueOf(amount)+" }";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
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
}
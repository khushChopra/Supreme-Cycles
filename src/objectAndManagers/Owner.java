package objectAndManagers;

public class Owner{
	private String owner_number;
	private String owner_name;
	
	@Override
	public String toString(){
		return "{number=" + owner_number +", name="+owner_name+" }";
	}

	public String getONumber() {
		return owner_number;
	}

	public void setONumber(String number) {
		this.owner_number = number;
	}

	public String getOName() {
		return owner_name;
	}

	public void setOName(String name) {
		this.owner_name = name;
	}
	
	public boolean empty() {
		return (this.owner_name==null && this.owner_number ==null);
	}
}
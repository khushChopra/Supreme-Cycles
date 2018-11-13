package objectAndManagers;

public class Employee{
	private String number;
	private String name;
	private String address;
	
	@Override
	public String toString(){
		return "{number=" + number +", name="+name+", address="+address+" }";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
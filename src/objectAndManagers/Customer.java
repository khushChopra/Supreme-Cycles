package objectAndManagers;

public class Customer{
	private String number;
	private String name;
	private String address;
	private String email;

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean empty() {
		return (this.name==null && this.number ==null)||(this.name=="" && this.number =="");
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.name==((Customer) obj).getName().toString() && this.number == ((Customer) obj).getNumber().toString());
	}
	
	@Override
	public String toString(){
		return "{Number=" + number +", Name="+name+", Address="+address+", Email="+email+" }";
	}
}
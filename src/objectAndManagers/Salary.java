package objectAndManagers;

public class Salary{	
	private int id;
	java.sql.Timestamp creation;
	private String owner_number;
	private String emp_num;
	private int amount;
	
	
	@Override
	public String toString(){
		return "{emp_num=" + emp_num +", amount="+amount+" }";
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



	public String getOwner_number() {
		return owner_number;
	}



	public void setOwner_number(String owner_number) {
		this.owner_number = owner_number;
	}



	public String getEmp_num() {
		return emp_num;
	}



	public void setEmp_num(String emp_num) {
		this.emp_num = emp_num;
	}
}
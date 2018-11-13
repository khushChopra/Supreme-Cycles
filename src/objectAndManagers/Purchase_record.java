package objectAndManagers;

public class Purchase_record{	
	private int id;
	java.sql.Timestamp creation;
	private String owner_number;
	private String dis_num;
	private int amount;
	private int closed;
	
	
	@Override
	public String toString(){
		return "{dis_num=" + dis_num +", amount="+amount+" }";
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


	public int getClosed() {
		return closed;
	}



	public void setClosed(int closed) {
		this.closed = closed;
	}



	public String getDis_num() {
		return dis_num;
	}



	public void setDis_num(String dis_num) {
		this.dis_num = dis_num;
	}
}
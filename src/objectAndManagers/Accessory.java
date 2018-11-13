package objectAndManagers;

public class Accessory{
	private String model_code;
	private String model_name;
	private String brand_name;
	private String color;
	private String type;
	private String accessory_size;
	private String image;
	private int price;
	private int quantity;
	
	@Override
	public String toString(){
		return "{Model_code=" + model_code +", model_name="+model_name+", brand_name="+brand_name+", Price="+String.valueOf(price)+" }";
	}

	public String getModel_code() {
		return model_code;
	}

	public void setModel_code(String model_code) {
		this.model_code = model_code;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAccessory_size() {
		return accessory_size;
	}

	public void setAccessory_size(String accessory_size) {
		this.accessory_size = accessory_size;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
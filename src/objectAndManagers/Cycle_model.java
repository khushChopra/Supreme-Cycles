package objectAndManagers;

public class Cycle_model{
	private String model_code;
	private String model_name;
	private String brand_name;
	private String color;
	private String type;
	private String kit_details;
	private String frame_size;
	private String weight;
	private String material;
	private String image;
	private int price;
	
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

	public String getKit_details() {
		return kit_details;
	}

	public void setKit_details(String kit_details) {
		this.kit_details = kit_details;
	}

	public String getFrame_size() {
		return frame_size;
	}

	public void setFrame_size(String frame_size) {
		this.frame_size = frame_size;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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
}
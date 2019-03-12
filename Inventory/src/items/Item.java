package items;

public class Item {

	private String name;
	private double price;
	private String upc;
	
	public Item(String name, double price,String upc) {
		this.setName(name);
		this.setPrice(price);
		this.setUpc(upc);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}
	
}

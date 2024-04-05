package abstractClass;

public abstract class Item {
	private String name;
	private int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		String result = "";
		result = String.format("%s: %d원", name, price);
		return result;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
}

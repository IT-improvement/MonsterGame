package abstractClass;

public abstract class Item {
	private String name; // pk
	private int price;
	private String img;

	public Item(String name, int price, String img) {
		this.name = name;
		this.price = price;
		this.img = img;
	}

	@Override
	public String toString() {
		String result = "";
		result = String.format("%s: %d원", name, price);
		return result;
	}

	public String getImg() {
		return img;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

}

package item;

import abstractClass.Item;

public class Defense extends Item {

	private int defense;

	public Defense(String name, int price, int defense, String img) {
		super(name, price, img);
		this.defense = defense;
	}

	public int getDefense() {
		return defense;
	}
}

package item;

import abstractClass.Item;

public class Weapon extends Item {

	private int power;

	public Weapon(String name, int price, int power) {
		super(name, price);
		this.power = power;
	}

	public int getPower() {
		return power;
	}

}

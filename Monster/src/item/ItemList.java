package item;

import java.util.ArrayList;
import java.util.HashMap;

import abstractClass.Item;
import abstractClass.Job;

public class ItemList {
	private ArrayList<Item> itemList;

	public ItemList() {
		itemList = new ArrayList<>();
		setItemList();
	}

	private void setItemList() {
		itemList.add(addWeapon("방망이", 1000, 10));
		itemList.add(addDefense("천갑옷", 2000, 10));
	}

	private Item addWeapon(String name, int price, int power) {
		Item item = new Weapon(name, price, power, "🪓");
		return item;
	}

	private Item addDefense(String name, int price, int denfense) {
		Item item = new Defense(name, price, denfense, "🛡️");
		return item;
	}

	public ArrayList<Item> getItemList() {
		return itemList;
	}
}

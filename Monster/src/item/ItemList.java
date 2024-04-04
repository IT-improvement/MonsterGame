package item;

import java.util.ArrayList;
import java.util.HashMap;

import abstractClass.Item;
import abstractClass.Job;

public class ItemList {
	private ArrayList<Item> itemList;
	private static HashMap<Job, ArrayList<Item>> userItemList;

	public ItemList() {
		itemList = new ArrayList<>();
		userItemList = new HashMap<>();
	}

	private void setItemList() {
		itemList.add(addWeapon("방망이", 1000, 10));
	}

	private Item addWeapon(String name, int price, int power) {
		Item item = new Weapon(name, price, power);
		return item;
	}
}

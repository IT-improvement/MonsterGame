package item;

import java.util.ArrayList;
import java.util.HashMap;

import abstractClass.Item;
import main.Game;
import user.User;

public class ItemManager {
	private static HashMap<User, ArrayList<Item>> userItemList;

	private ItemList list;

	private ItemManager() {
		userItemList = new HashMap<>();
		list = new ItemList();
	}

	private static ItemManager instance = new ItemManager();

	public static ItemManager getInstance() {
		return instance;
	}

	public void addItem(String itemName) {
		User user = Game.user;
		Item target = checkItem(itemName);
		ArrayList<Item> targetItem = addItemList(user, target);
		userItemList.put(user, targetItem);
	}

	private Item checkItem(String itemName) {
		ArrayList<Item> itemList = list.getItemList();
		Item target = null;
		for (Item item : itemList)
			if (item.getName().equals(itemName))
				target = item;
		return target;
	}

	private ArrayList<Item> addItemList(User user, Item target) {
		ArrayList<Item> targetItem = userItemList.get(user);
		if (targetItem == null) {
			targetItem = new ArrayList<>();
		}
		targetItem.add(target);
		return targetItem;
	}

}

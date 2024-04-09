package item;

import java.util.ArrayList;
import java.util.HashMap;

import abstractClass.Item;
import abstractClass.Job;
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
		if (payMoney(target)) {
			userItemList.put(user, targetItem);
			System.out.print(target.getName() + " 구매 완료!");
		}
	}

	private boolean payMoney(Item item) {
		Job job = Game.job;
		int price = item.getPrice();
		if (job.getCash() - price < 0) {
			System.err.print("구매불가!");
			return false;
		}
		Game.job.setCash(-price);
		return true;
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

	public ArrayList<Item> get(User user) {
		return userItemList.get(user);
	}

}

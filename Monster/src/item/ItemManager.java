package item;

import java.util.ArrayList;
import java.util.HashMap;

import abstractClass.Item;
import abstractClass.Job;

public class ItemManager {
	private static HashMap<Job, ArrayList<Item>> userItemList;

	private ItemManager() {
		userItemList = new HashMap<>();
	}

	private static ItemManager instance = new ItemManager();

	public static ItemManager getInstance() {
		return instance;
	}

}

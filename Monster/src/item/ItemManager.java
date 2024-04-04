package item;

public class ItemManager {

	private ItemManager() {

	}

	private static ItemManager instance = new ItemManager();

	public static ItemManager getInstance() {
		return instance;
	}
}

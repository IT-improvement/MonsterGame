package user;

import java.util.ArrayList;

import abstractClass.Item;
import item.Defense;
import item.Weapon;
import main.Game;

public class InvenManager {

	private Inven inven = new Inven();

	private InvenManager() {

	}

	private static InvenManager instance = new InvenManager();

	public static InvenManager getInstance() {
		return instance;
	}

	public void setEquipment(int index) {
		Item item = inven.getItem(index);
		ArrayList<Item> itemList = Inven.getItemList();
		itemList.remove(item);
		if (item instanceof Weapon)
			Game.job.setWeapon(item);
		else if (item instanceof Defense)
			Game.job.setDefense(item);
		inven.setItemList(itemList);
	}
}

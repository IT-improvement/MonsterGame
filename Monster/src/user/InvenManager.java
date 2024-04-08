package user;

import java.awt.Image;
import java.util.ArrayList;

import abstractClass.Item;
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

	public void setEquipment() {
		Item item = inven.getItem();
		ArrayList<Item> itemList = inven.getItemList();
		itemList.remove(item);
		if(item instanceof Weapon)
			Game.job.setWeapon(item);
	}
}

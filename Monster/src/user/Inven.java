package user;

import java.util.ArrayList;

import abstractClass.Item;
import item.ItemManager;
import main.FontStyle;
import main.Game;

public class Inven {

	private ArrayList<Item> itemList;
	private int index;

	public Inven() {
		ItemManager itemManager = ItemManager.getInstance();
		itemList = itemManager.get(Game.user);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int size() {
		return itemList == null ? 0 : itemList.size();
	}

	@Override
	public String toString() {
		String result = "";

		for (int i = 0; i < itemList.size(); i++) {
			String img = itemList.get(i).getImg();
			if (index == i) {
				result += FontStyle.ANSI_PURPLE_BACKGROUND_LIGHT + FontStyle.ANSI_WHITE + img;
			} else {
				result += FontStyle.ANSI_RESET + img;
			}
			if (i % 3 == 2)
				result += "\n";
		}

		result += FontStyle.ANSI_RESET;
		return result;
	}
}
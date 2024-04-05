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

	@Override
	public String toString() {
		String result = "";
		if (itemList == null) {
			result = FontStyle.ANSI_RED + "아이템이 없습니다.";
		} else {
			for (int i = 0; i < itemList.size(); i++) {
				String img = itemList.get(i).getImg();
				if (index == i) {
					result += FontStyle.ANSI_PURPLE_BACKGROUND_LIGHT + FontStyle.ANSI_WHITE + img;
				} else {
					result += img;
				}
				if (i % 3 == 2)
					result += "\n";
			}
		}
		return result;
	}
}

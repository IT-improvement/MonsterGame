package user;

import java.util.ArrayList;

import abstractClass.Item;
import item.ItemManager;
import main.FontStyle;
import main.Game;

public class Inven {

	private static ArrayList<Item> itemList;
	private int index;

	public Inven() {
		ItemManager itemManager = ItemManager.getInstance();
		itemList = itemManager.get(Game.user);
	}
	
	public static ArrayList<Item> getItemList() {
		return itemList;
	}

	public static void setItemList(ArrayList<Item> itemList) {
		Inven.itemList = itemList;
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

	public Item getItem() {
		return itemList.get(index);
	}

	@Override
	public String toString() {
		String result = "";
		result += "  ㅡ ㅡ ㅡ \r\n" + "/ 인벤토리 \\\n" + "===========\n" + " ";
		for (int i = 0; i < itemList.size(); i++) {
			String img = itemList.get(i).getImg();
			if (index == i) {
				result += FontStyle.ANSI_PURPLE_BACKGROUND_LIGHT + FontStyle.ANSI_WHITE + img + FontStyle.ANSI_RESET
						+ " ";
			} else {
				result += FontStyle.ANSI_RESET + img + " ";
			}
			if (i % 3 == 2)
				result += "\n ";
		}

		result += FontStyle.ANSI_RESET + "\n===========\n";
		result += "무기: ";
		if (Game.job.getWeapon() == null)
			result += "없음\n";
		else
			result += Game.job.getWeapon().getName() + "\n";
		result += "방어구: ";
		if (Game.job.getDefense() == null)
			result += "없음\n";
		else
			result += Game.job.getDefense().getName() + "\n";
		result += "반지: ";
		result += "없음\n";
		return result;
	}
}

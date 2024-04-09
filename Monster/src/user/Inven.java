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
		result += "착용중인 무기: ";
		if (Game.job.getWeapon() == null)
			result += "없음\n";
		else
			result += Game.job.getWeapon().getName() + "\n";
		result += "착용중인 방어구:";
		if (Game.job.getDefense() == null)
			result += "없음\n";
		else
			result += Game.job.getDefense().getName() + "\n";
		result += "착용중인 반지:";
		result += "없음\n";

		result += FontStyle.ANSI_RESET + "\n===========\n";
		return result;
	}
}

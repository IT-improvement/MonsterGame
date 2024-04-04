package map;

import abstractClass.Map;
import main.FontStyle;
import main.Game;

public class Town extends Map {

	private final String GULID = "🧑‍🎓";
	private final String SHOP = "🥷";
	private final String FILE = "🧑‍🏫";

	public Town() {
		super(2, 11, FontStyle.ANSI_CYAN + FontStyle.ANSI_BOLD + "마을");

	}

	public String getGULID() {
		return GULID;
	}

	public String getSHOP() {
		return SHOP;
	}

	public String getFILE() {
		return FILE;
	}

	@Override
	public void setMonster() {
		monsterList = null;
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < this.getHeight(); i++) {
			for (int j = 0; j < this.getWidth(); j++) {
				boolean isCheck = false;

				if (i == 0) {
					if (j == 3) {
						isCheck = true;
						result += FontStyle.ANSI_BLACK + GULID;
					} else if (j == 5) {
						isCheck = true;
						result += FontStyle.ANSI_BLACK + SHOP;
					} else if (j == 7) {
						isCheck = true;
						result += FontStyle.ANSI_BLACK + FILE;
					}
				}
				if (!isCheck) {
					if (Game.user.getX() == j && Game.user.getY() == i)
						result += FontStyle.ANSI_RESET + "🧍‍♂️";
					else
						result += FontStyle.ANSI_CYAN + "🟫";
				}
			}
			if (i == 0) {
				result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
			} else if (i == 1) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "직업: " + Game.user.getName();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			}
			result += "\n";
		}
		result += "                    ";
		result += "\t" + FontStyle.ANSI_PURPLE + "|";
		result += "\t" + FontStyle.ANSI_RESET + "체력: " + Game.user.getHp() + "/" + Game.user.getMAX_HP();
		result += "\t" + FontStyle.ANSI_PURPLE + "|";
		result += "\n                    ";
		result += "\t" + FontStyle.ANSI_PURPLE + "|";
		result += "\t" + FontStyle.ANSI_RESET + "마나: " + Game.user.getMp() + "/" + Game.user.getMAX_MP();
		result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
		result += "\n                    ";
		result += "\t" + FontStyle.ANSI_PURPLE + "|";
		result += "\t" + FontStyle.ANSI_RESET + "레벨: " + Game.user.getLevel();
		result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
		result += "\n                    ";
		result += "\t" + FontStyle.ANSI_PURPLE + "|";
		result += "\t" + FontStyle.ANSI_RESET + "경험치: " + Game.user.getXp();
		if (Game.user.getXp() / 10 != 0)
			result += "\t" + FontStyle.ANSI_PURPLE + "|";
		else
			result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
		result += "\n                    ";
		result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
		return result;
	}
}

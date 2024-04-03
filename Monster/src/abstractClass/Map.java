package abstractClass;

import java.util.ArrayList;

import main.Game;
import monster.Golem;
import monster.Slime;

public abstract class Map {
	private int height;
	private int width;
	private String name;
	public ArrayList<Monster> monsterList;

	public Map(int height, int width, String name) {
		this.name = name;
		this.height = height;
		this.width = width;
		monsterList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public ArrayList<Monster> getMonsterList() {
		return monsterList;
	}

	public void setMonsterList(ArrayList<Monster> monsterList) {
		this.monsterList = monsterList;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public abstract void setMonster();

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i == 0 && j == 0) {
					result += Game.ANSI_CYAN + "🌪️";
					continue;
				}
				boolean isCheck = false;

				for (Monster monster : monsterList) {
					if (monster.getY() == i && monster.getX() == j) {
						if (i == Game.user.getY() && j == Game.user.getX()) {
							isCheck = true;
							result += Game.ANSI_RED + "🔫‍";
						} else {
							isCheck = true;
							result += Game.ANSI_GREEN + "🌳";
						}
					}
				}

				if (!isCheck) {
					if (i == Game.user.getY() && j == Game.user.getX()) {
						result += Game.ANSI_RESET + "🧍‍♂️";
					} else {
						result += Game.ANSI_BROWN + "🟫";
					}
				}
			}
			if (i == 2) {
				result += "\t" + Game.ANSI_PURPLE + "=========================";
			} else if (i == 3) {
				result += "\t" + Game.ANSI_PURPLE + "|";
				result += "\t" + Game.ANSI_RESET + "직업: " + Game.user.getName();
				result += "\t" + Game.ANSI_PURPLE + "|";
			} else if (i == 4) {
				result += "\t" + Game.ANSI_PURPLE + "|";
				result += "\t" + Game.ANSI_RESET + "체력: " + Game.user.getHp() + "/" + Game.user.getMAX_HP();
				result += "\t" + Game.ANSI_PURPLE + "|";
			} else if (i == 5) {
				result += "\t" + Game.ANSI_PURPLE + "|";
				result += "\t" + Game.ANSI_RESET + "마나: " + Game.user.getMp() + "/" + Game.user.getMAX_MP();
				result += "\t" + Game.ANSI_PURPLE + "\t\t|";
			} else if (i == 6) {
				result += "\t" + Game.ANSI_PURPLE + "|";
				result += "\t" + Game.ANSI_RESET + "레벨: " + Game.user.getLevel();
				result += "\t" + Game.ANSI_PURPLE + "\t\t|";
			} else if (i == 7) {
				result += "\t" + Game.ANSI_PURPLE + "|";
				result += "\t" + Game.ANSI_RESET + "경험치: " + Game.user.getXp();
				result += "\t" + Game.ANSI_PURPLE + "\t\t|";
			} else if (i == 8) {
				result += "\t" + Game.ANSI_PURPLE + "=========================";
			}
			result += "\n";
		}

		return result;
	}
}

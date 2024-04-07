package abstractClass;

import java.util.ArrayList;

import main.FontStyle;
import main.Game;
import unit.Begginer;

public abstract class Map {
	private int height;
	private int width;
	private String name;
	public ArrayList<Monster> monsterList;
	private String mapColor;

	public Map(int height, int width, String name, String mapColor) {
		this.name = name;
		this.height = height;
		this.width = width;
		this.mapColor = mapColor;
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
					result += FontStyle.ANSI_CYAN + "🌪️";
					continue;
				}
				if (i == width - 1 && j == height - 1) {
					result += FontStyle.ANSI_CYAN + "🌪️";
					continue;
				}
				boolean isCheck = false;

				for (Monster monster : monsterList) {
					if (monster.getY() == i && monster.getX() == j) {
						if (i == Game.job.getY() && j == Game.job.getX()) {
							isCheck = true;
							result += FontStyle.ANSI_RED + "🔫‍";
						} else {
							isCheck = true;
							result += FontStyle.ANSI_GREEN + "🌳";
						}
					}
				}

				if (!isCheck) {
					if (i == Game.job.getY() && j == Game.job.getX()) {
						result += FontStyle.ANSI_RESET + "🧍‍♂️";
					} else {
						result += mapColor + "🟫";
					}
				}
			}
			if (i == 0) {
				result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
			} else if (i == 1) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "직업: " + Game.job.getName();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 2) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "공격력: " + Game.job.getPower();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 3) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "방어력: " + Game.job.getDefense() + "";
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 4) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "체력: " + Game.job.getHp() + "/" + Game.job.getMAX_HP();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 5) {
				if (Game.job instanceof Begginer) {
					result += "\t" + FontStyle.ANSI_PURPLE + "|";
					result += "\t" + FontStyle.ANSI_RESET + "마나: " + Game.job.getMp() + "/" + Game.job.getMAX_MP();
					result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
				} else {
					result += "\t" + FontStyle.ANSI_PURPLE + "|";
					result += "\t" + FontStyle.ANSI_RESET + "마나: " + Game.job.getMp() + "/" + Game.job.getMAX_MP();
					result += "\t" + FontStyle.ANSI_PURPLE + "|";
				}
			} else if (i == 6) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "레벨: " + Game.job.getLevel();
				result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
			} else if (i == 7) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "경험치: " + Game.job.getXp();
				if (Game.job.getXp() / 10 != 0)
					result += "\t" + FontStyle.ANSI_PURPLE + "|";
				else
					result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
			} else if (i == 8) {
				result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
			}
			result += "\n";
		}

		return result;
	}
}

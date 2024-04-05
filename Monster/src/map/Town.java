package map;

import java.util.ArrayList;

import abstractClass.Map;
import abstractClass.Npc;
import main.FontStyle;
import main.Game;
import npc.File;
import npc.Guild;
import npc.Shop;

public class Town extends Map {

	private ArrayList<Npc> npcList;

	public Town() {
		super(10, 11, FontStyle.ANSI_CYAN + FontStyle.ANSI_BOLD + "마을",FontStyle.ANSI_CYAN);
		npcList = new ArrayList<Npc>();
		addNpc();
	}

	public ArrayList<Npc> getNpcList() {
		return npcList;
	}

	private void addNpc() {
		Guild guild = new Guild();
		npcList.add(guild);
		Shop shop = new Shop();
		npcList.add(shop);
		File file = new File();
		npcList.add(file);
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
				if (i == 1 && j == 10) {
					result += FontStyle.ANSI_CYAN + "🌪️";
					continue;
				}
				boolean isCheck = false;

				if (i == 0) {
					for (Npc npc : npcList) {
						if (j == npc.getX()) {
							isCheck = true;
							result += FontStyle.ANSI_BLACK + npc.getName();
						}
					}
				}
				if (!isCheck) {
					if (i == 0 || i == 1) {
						if (Game.job.getX() == j && Game.job.getY() == i)
							result += FontStyle.ANSI_RESET + "🧍‍♂️";
						else
							result += FontStyle.ANSI_CYAN + "🟫";
					} else {
						result += FontStyle.ANSI_WHITE + "🟫";
					}
				}
			}
			if (i == 0) {
				result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
			} else if (i == 1) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "직업: " + Game.job.getName();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			}

			if (i == 2) {
				result += "\t" + FontStyle.ANSI_PURPLE + "=========================";
			} else if (i == 3) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "직업: " + Game.job.getName();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 4) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "체력: " + Game.job.getHp() + "/" + Game.job.getMAX_HP();
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
			} else if (i == 5) {
				result += "\t" + FontStyle.ANSI_PURPLE + "|";
				result += "\t" + FontStyle.ANSI_RESET + "마나: " + Game.job.getMp() + "/" + Game.job.getMAX_MP();
				result += "\t" + FontStyle.ANSI_PURPLE + "\t\t|";
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

package abstractClass;

import java.util.ArrayList;

import main.Game;
import monster.Golem;
import monster.Slime;

public abstract class Map {
	private int height;
	private int width;
	public ArrayList<Monster> monsterList;

	public Map(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		monsterList = new ArrayList<>();
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
				boolean isCheck = false;
				for (Monster monster : monsterList) {
					if (monster.getY() == i && monster.getX() == j) {
						if (i == Game.user.getY() && j == Game.user.getX()) {
							isCheck = true;
							result += Game.ANSI_RED + "🔫‍ ";
						} else {
							isCheck = true;
							if (monster instanceof Golem) {
								result += Game.ANSI_GRAY + "🌳 ";
							} else if (monster instanceof Slime)
								result += Game.ANSI_GREEN + "🌳 ";
						}
					}
				}
				if (!isCheck) {
					if (i == Game.user.getY() && j == Game.user.getX()) {
						result += Game.ANSI_RESET + "🧍‍♂️ ";
					} else {
						result += Game.ANSI_BROWN + "🟫 ";
					}
				}
			}
			result += "\n";
		}

		return result;
	}
}

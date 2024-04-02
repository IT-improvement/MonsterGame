package unit;

import abstractClass.User;

public class Begginer extends User {

	private int xp;
	private int level;

	public Begginer(String name, int power, int hp, int mp) {
		super("초보자", 10, 100, 0);
		this.level = 1;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
		if (this.xp >= 100) {
			level++;
			this.xp -= 100;
		}
	}

	public int getLevel() {
		return level;
	}

}

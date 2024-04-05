package abstractClass;

import main.FontStyle;

public abstract class Job extends Life {

	private int mp;
	private int MAX_MP;
	private int xp;
	private int level;
	private int cash;

	public Job(String name, int power, int hp, int mp, int x, int y) {
		super(name, power, hp, x, y);
		MAX_MP = this.mp = mp;
		this.level = 1;
		this.cash = 10000;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		super.hp += hp;
		if (this.hp <= 0) {
			System.out.println("사망");
			super.setDead(true);
		}
		if (super.hp > super.getMAX_HP())
			super.hp = super.getMAX_HP();
	}

	public int getMp() {
		return mp;
	}

	public int getMAX_MP() {
		return MAX_MP;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp += xp;
		if (this.xp >= 100) {
			level++;
			String message = "레벨 " + level + "에 도달했습니다! 축하합니다!";
			System.out.println(FontStyle.ANSI_YELLOW + FontStyle.ANSI_BOLD + message + FontStyle.ANSI_RESET);
			this.xp -= 100;
		}
	}

	public int getLevel() {
		return level;
	}

	public abstract int skill();
}

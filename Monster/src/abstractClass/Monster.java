package abstractClass;

public abstract class Monster extends Life {

	private int xp;
	private int money;

	public Monster(String name, int power, int hp, int xp, int x, int y, int money) {
		super(name, power, hp, x, y);
		this.xp = xp;
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}


	public int getHp() {
		return super.hp;
	}

	public void setHp(int hp) {
		super.hp += hp;
		if (this.hp <= 0) {
			System.out.println("사망");
			super.setDead(true);
		}
	}

	public int getXp() {
		return xp;
	}

	public abstract String getMessage();

}

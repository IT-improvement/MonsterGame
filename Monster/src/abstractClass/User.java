package abstractClass;

public abstract class User extends Life {

	private int mp;
	private int MAX_MP;
	private int xp;
	private int level;

	public User(String name, int power, int hp, int mp, int x, int y) {
		super(name, power, hp, x , y);
		MAX_MP = this.mp = mp;
		this.level = 1;
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

	public void setMp(int mp) {
		this.mp = mp;
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

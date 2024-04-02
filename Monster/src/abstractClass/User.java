package abstractClass;

public abstract class User {
	private String name;
	private int power;
	private int hp;
	private int MAX_HP;
	private int mp;
	private int MAX_MP;
	private boolean isDead;

	public User(String name, int power, int hp, int mp) {
		this.name = name;
		this.power = power;
		MAX_HP = this.hp = hp;
		MAX_MP = this.mp = mp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp += hp;
		if (this.hp == 0) {
			System.out.println("사망");
			isDead = true;
		}
		if (this.hp > MAX_HP)
			this.hp = MAX_HP;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

}

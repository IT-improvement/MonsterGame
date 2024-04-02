package abstractClass;

public abstract class User extends Life {

	private int mp;
	private int MAX_MP;

	public User(String name, int power, int hp, int mp) {
		super(name, power, hp);
		MAX_MP = this.mp = mp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		super.hp += hp;
		if (this.hp <=0) {
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

}

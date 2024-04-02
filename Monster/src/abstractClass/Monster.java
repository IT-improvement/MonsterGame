package abstractClass;

public abstract class Monster extends Life {

	public Monster(String name, int power, int hp) {
		super(name, power, hp);
	}

	public void setHp(int hp) {
		super.hp += hp;
		if (this.hp <= 0) {
			System.out.println("사망");
			super.setDead(true);
		}
	}

}

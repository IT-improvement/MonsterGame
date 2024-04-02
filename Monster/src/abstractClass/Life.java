package abstractClass;

public abstract class Life {
	private String name;
	private int power;
	public int hp;
	private int MAX_HP;
	private boolean isDead;

	public Life(String name, int power, int hp) {
		this.name = name;
		this.power = power;
		MAX_HP = this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public int getMAX_HP() {
		return MAX_HP;
	}

}

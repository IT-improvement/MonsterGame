package abstractClass;

public abstract class Life {
	private String name;
	private int power;
	public int hp;
	private int MAX_HP;
	private boolean isDead;
	private int x;
	private int y;

	public Life(String name, int power, int hp, int x, int y) {
		this.name = name;
		this.power = power;
		this.x = x;
		this.y = y;
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}

package unit;

import abstractClass.Job;
import interfaces.Healable;

public class Healer extends Job implements Healable {

	public Healer(int cash) {
		super("힐러", 10, 70, 1500, 0, 0, cash);
	}

	@Override
	public void heal(Job user) {
		if (this.getMp() < 10) {
			System.err.println("마나가 부족합니다.");
			return;
		}
		if (!user.isDead()) {
			return;
		}
		user.setHp(20);
		this.setMp(-10);
	}

	@Override
	public int skill() {
		return 0;
	}

}

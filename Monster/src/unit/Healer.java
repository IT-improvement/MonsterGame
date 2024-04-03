package unit;

import abstractClass.User;
import interfaces.Healable;

public class Healer extends User implements Healable {

	public Healer() {
		super("힐러", 0, 70, 1500,0,0);
	}

	@Override
	public void heal(User user) {
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

}

package unit;

import abstractClass.Job;
import interfaces.Healable;
import main.Game;

public class Healer extends Job implements Healable {

	public Healer(int cash) {
		super("힐러", 10, 70, 1500, 0, 0, Game.job.getCash(), Game.job.getLevel(), Game.job.getXp());
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

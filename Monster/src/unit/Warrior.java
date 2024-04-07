package unit;

import abstractClass.Job;
import interfaces.Skillable;
import main.Game;

public class Warrior extends Job implements Skillable {
	private int useSkill;

	public Warrior() {
		super("전사", 30, 200, 30, 0, 0, Game.job.getCash(), Game.job.getLevel(), Game.job.getXp());
		useSkill = 10;
	}

	public int getUseSkill() {
		return useSkill;
	}

	@Override
	public int skill() {
		if (this.getMp() < 10) {
			System.err.println("마나가 부족합니다.");
			return 0;
		}
		this.setMp(-useSkill);
		return 40;
	}

}

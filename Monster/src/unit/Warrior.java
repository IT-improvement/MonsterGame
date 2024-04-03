package unit;

import abstractClass.User;
import interfaces.Skillable;

public class Warrior extends User implements Skillable {

	public Warrior() {
		super("전사", 30, 200, 30);
	}

	@Override
	public int skill() {
		if (this.getMp() < 10) {
			System.err.println("마나가 부족합니다.");
			return 0;
		}
		return 40;
	}

}

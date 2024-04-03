package unit;

import abstractClass.User;
import interfaces.Skillable;

public class Wizard extends User implements Skillable{

	public Wizard() {
		super("마법사", 20, 100, 100);
	}

	@Override
	public int skill() {
		if(this.getMp()<20) {
			System.err.println("마나가 부족합니다.");
			return 0;
		}
		return 50;
	}

}

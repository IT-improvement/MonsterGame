package unit;

import abstractClass.Job;
import interfaces.Skillable;

public class Wizard extends Job implements Skillable{

	public Wizard() {
		super("마법사", 20, 100, 100,0,0);
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

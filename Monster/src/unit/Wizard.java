package unit;

import abstractClass.User;
import interfaces.Skillable;

public class Wizard extends User implements Skillable{

	public Wizard(String name, int power, int hp, int mp) {
		super("마법사", 50, 100, 100);
	}

	@Override
	public int skill() {
		return 0;
	}

}

package unit;

import abstractClass.User;
import interfaces.Skillable;

public class Warrior extends User implements Skillable {

	public Warrior(String name, int power, int hp, int mp) {
		super("전사", 40, 200, 30);
	}

	@Override
	public int skill() {
		return 0;
	}

}

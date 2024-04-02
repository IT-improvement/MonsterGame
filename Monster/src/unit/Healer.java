package unit;

import abstractClass.User;
import interfaces.Healable;

public class Healer extends User implements Healable {

	public Healer(String name, int power, int hp, int mp) {
		super("힐러", 0, 70, 150);
	}

	@Override
	public int heal() {
		return 0;
	}

}

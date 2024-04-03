package unit;

import abstractClass.User;

public class Begginer extends User {

	public Begginer() {
		super("초보자", 10, 100, 0, 1, 0);
	}

	@Override
	public int skill() {
		return 0;
	}

}

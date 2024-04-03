package monster;

import abstractClass.Monster;
import main.Game;

public class Golem extends Monster {

	public Golem(int x, int y) {
		super("골렘", 5, 30, 20, x, y);
	}

	@Override
	public String toString() {
		String result = "";
		result += Game.ANSI_GRAY + "\n  ________  ";
		result += "\n /  o  o  \\ ";
		result += "\n|    _     |";
		result += "\n|  /   \\  |";
		result += "\n|  \\___/  |";
		result += "\n \\________/";
		result += Game.ANSI_RESET + "\n";
		return result;
	}

	@Override
	public String getMessage() {
		return "손바닥 치기";
	}
}

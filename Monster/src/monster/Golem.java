package monster;

import abstractClass.Monster;
import main.FontStyle;

public class Golem extends Monster {

	public Golem(int x, int y) {
		super("골렘", 5, 30, 50, x, y,1000);
	}

	@Override
	public String toString() {
		String result = "";
		result += FontStyle.ANSI_CYAN +FontStyle.ANSI_BOLD+ "\n  ________  ";
		result += "\n /  o  o  \\ ";
		result += "\n|    _     |";
		result += "\n|  /   \\  |";
		result += "\n|  \\___/  |";
		result += "\n \\________/";
		result += FontStyle.ANSI_RESET + "\n";
		return result;
	}

	@Override
	public String getMessage() {
		return "손바닥 치기";
	}
}

package monster;

import abstractClass.Monster;
import main.FontStyle;

public class Slime extends Monster {

	public Slime(int x, int y) {
		super("슬라임", 20, 20, 50, x, y, 1500);

	}

	@Override
	public String toString() {
		String result = "";
		result += FontStyle.ANSI_GREEN + FontStyle.ANSI_BOLD + "   /\\  ___  /\\";
		result += "\n   )O  \\/  O(";
		result += "\n  / \\      / \\";
		result += "\n / /'\\____/`\\ \\";
		result += "\n( (   /  \\   ) )";
		result += "\n \\ \\_/____\\_/ /";
		result += "\n  \\_/      \\_/";
		result += "\n" + FontStyle.ANSI_RESET;
		return result;
	}

	@Override
	public String getMessage() {
		return "몸통박치기!";
	}
}

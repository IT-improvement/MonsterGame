package monster;

import abstractClass.Monster;
import main.Game;

public class Slime extends Monster {

	public Slime(int x, int y) {
		super("슬라임", 20, 20, 10, x, y);

	}

	@Override
	public String toString() {
		String result = "";
		result += Game.ANSI_GREEN + "   /\\  ___  /\\";
		result += "\n   )O  \\/  O(";
		result += "\n  / \\      / \\";
		result += "\n / /'\\____/`\\ \\";
		result += "\n( (   /  \\   ) )";
		result += "\n \\ \\_/____\\_/ /";
		result += "\n  \\_/      \\_/";
		result+="\n"+Game.ANSI_RESET;
		return result;
	}

	@Override
	public String getMessage() {
		return "몸통박치기!";
	}
}

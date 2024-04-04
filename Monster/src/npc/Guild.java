package npc;

import abstractClass.Npc;
import main.FontStyle;

public class Guild extends Npc {

	public Guild() {
		super(2, 0, "🧑‍🎓");
	}

	@Override
	public void printGuideMessage() {
		String line = FontStyle.ANSI_BLUE + "=========================";
		String side = FontStyle.ANSI_BLUE + "|";
		String result = "";
		result += line + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t길드 매니저\t\t" + side + "\n";
		result += line + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t1. 길드창설\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t2. 길드삭제\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t3. 길드원관리\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t*. 나가기\t\t" + side + "\n";
		result += line + "\n";
		System.out.println(result);

	}

	@Override
	public String toString() {
		String result = "";
		result += "⢀⣀⣀⣀⣀⣀⣀⣤⣶⣶⣶⣤⣤⣤⣄⣀⡀⡀⣀⣀⣀⣀⣀⣀⣤⣄⡀\n";
		result += "⢠⣴⡿⠿⠛⠉⢉⣡⣴⠟⠋⠉⠉⠉⠉⠉⠉⠙⠻⢿⣿⣿⡇⠻⣿⣿⣿⡀\n";
		result += "⢠⠏⠁⣀⡀⠀⠀⠉⠛⠁⢀⣠⠄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⠤⣿⣿⣿⣿\n";
		result += "⢠⠇⣀⣠⡾⠒⢲⣦⣤⣤⣤⣤⣤⣄⣀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆\n";
		result += "⢠⡏⣿⣿⣿⡿⠖⠋⠉⢉⣉⡉⠉⠉⠉⠒⠋⠉⣀⣀⣽⣿⣿⣷⠀⢻⣿\n";
		result += "⢸⠃⢹⣿⣿⣿⣶⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠇\n";
		result += "⢸⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀\n";
		result += "⡞⠀⠈⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁\n";
		result += "⡇⠀⠀⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀\n";
		result += "⢣⡀⠀⠀⠀⠀⠀⠈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⢀⡀\n";
		result += "⠀⠙⠢⢄⡀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⢀⠞⠉\n";
		result += "⠀⠀⠀⠈⠙⢦⣄⠀⠀⠀⠙⠻⠿⠿⠿⠿⠿⠿⠿⠛⠋⠉⢀⠞⠉\n";
		return result;
	}
}

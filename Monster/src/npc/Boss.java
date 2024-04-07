package npc;

import abstractClass.Npc;
import main.FontStyle;

public class Boss extends Npc {

	public Boss() {
		super(8, 0, "🧑‍🏫");
	}

	@Override
	public void printGuideMessage() {
		String line = FontStyle.ANSI_BLUE + "=========================";
		String side = FontStyle.ANSI_BLUE + "|";
		String result = "";
		result += line + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t1. 마법사 전직\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t2. 전사 전직\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t3. 힐러 전직\t" + side + "\n";
		result += side + FontStyle.ANSI_CYAN + "\t\t*. 나가기\t\t" + side + "\n";
		result += line+"\n";
		System.out.println(result);
	}

	@Override
	public String toString() {
		String result = "";
		String welcomeMessage = FontStyle.ANSI_CYAN+" 전직마법사에 오신걸 환영합니다 ";
		int messageLength = welcomeMessage.length();

		String line2 = FontStyle.ANSI_BLUE +" " + "\u25cf".repeat(messageLength+2);

		result = "\n" + line2 + "\n" + "\u25cf " + welcomeMessage + FontStyle.ANSI_BLUE +" \u25cf\n" + line2;
		return result;
	}

}

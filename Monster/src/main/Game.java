package main;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Map;
import abstractClass.Monster;
import abstractClass.User;
import map.Map1;
import unit.Begginer;

public class Game {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BROWN = "\u001B[33m";
	public static final String ANSI_GRAY = "\u001B[90m";

	private Scanner scan = new Scanner(System.in);

	public static User user;
	private Map map;

	public Game() {
		user = new Begginer();
		map = new Map1();
	}

	/* print */
	private void printStart() {
		System.out.println(ANSI_CYAN + ANSI_BOLD + "===== 메뉴 선택 =====");
		System.out.println(ANSI_RESET + ANSI_CYAN + "1) 로그인");
		System.out.println("2) 회원가입" + ANSI_RESET);
	}

	private String inputString(String message) {
		System.out.print(message + ": ");
		return scan.next();
	}

	public void run() {
		while (true) {
			printStart();
			System.out.println(map);
			String dir = inputString(ANSI_RESET + "입력");
			move(dir);
			if (isFight() == null) {
				continue;
			}
			fight();
		}
	}

	private void move(String dir) {
		int tX = user.getX();
		int tY = user.getY();
		if (dir.equals("a"))
			tX--;
		else if (dir.equals("d"))
			tX++;
		else if (dir.equals("s"))
			tY++;
		else if (dir.equals("w"))
			tY--;
		if (tX < 0 || tX >= 10 || tY < 0 || tY >= 10) {
			return;
		}
		user.setX(tX);
		user.setY(tY);
	}

	private Monster isFight() {
		ArrayList<Monster> monsterList = map.getMonsterList();
		for (Monster monster : monsterList) {
			if (monster.getX() == user.getX() && monster.getY() == user.getY())
				return monster;
		}
		return null;
	}

	private void fight() {

	}
}

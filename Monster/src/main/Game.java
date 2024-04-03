package main;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Map;
import abstractClass.Monster;
import abstractClass.User;
import interfaces.Skillable;
import map.Map1;
import monster.Golem;
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
	private Monster monster;

	public Game() {
		user = new Begginer();
		map = new Map1();
		monster = null;
	}

	// input String
	private String inputString(String message) {
		System.out.print(message + ": ");
		return scan.next();
	}

	// input Num
	private int inputNum(String message) {
		int num = -1;
		try {
			System.out.print(message + ": ");
			String temp = scan.next();
			num = Integer.parseInt(temp);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}

	/* print */
	private void printStart() {
		System.out.println(ANSI_CYAN + ANSI_BOLD + "===== 메뉴 선택 =====");
		System.out.println(ANSI_RESET + ANSI_CYAN + "1) 로그인");
		System.out.println("2) 회원가입" + ANSI_RESET);
	}

	private void printMonster(Monster monster) {
		System.out.println(ANSI_BOLD + ANSI_RED + "몬스터 등장!!");
		System.out.println(monster);
	}

	private void printBegginer() {
		System.out.println("1) 평차치기");
		System.out.println("*) 도망가기");
	}

	private void printFristJob() {
		System.out.println("1) 평타치기");
		System.out.println("3) 스킬쓰기");
		System.out.println("*) 도망가기");

	}

	private void begginer(int sel) {
		switch (sel) {
		case 1:
			bassicAttack();
			break;
		default:
			break;
		}
	}

	private void fristJob(int sel) {
		switch (sel) {
		case 1:
			bassicAttack();
			break;
		case 2:
			firstSkill();
			break;
		default:
			break;
		}
	}

	private void bassicAttack() {
		monster.setHp(-user.getPower());
	}

	private void firstSkill() {
		int damage = user.skill();
		monster.setHp(-damage);
	}

	public void run() {
		while (true) {
			printStart();
			System.out.println(map);
			String dir = inputString(ANSI_RESET + "입력");
			move(dir);
			monster = isFight();
			if (monster == null) {
				continue;
			}
			fight(monster);
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

	private void fight(Monster monster) {
		printMonster(monster);
		battle(monster);
	}

	private void battle(Monster monster) {
		while (!monster.isDead() && !user.isDead()) {
			userAttack();
			monsterAttack();
		}
	}

	private void userAttack() {
		if (user instanceof Skillable) {
			printFristJob();
			fristJob(inputNum("메뉴입력"));
		} else {
			printBegginer();
			begginer(inputNum("메뉴입력"));
		}
	}

	private void monsterAttack() {
		user.setHp(-monster.getPower());
	}
}

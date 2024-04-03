package main;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Map;
import abstractClass.Monster;
import abstractClass.User;
import interfaces.Skillable;
import map.SlimeAndGolemForest;
import monster.Golem;
import unit.Begginer;

public class Game {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BOLD = "\u001B[1m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BROWN = "\u001B[33m";
	public static final String ANSI_GRAY = "\u001B[90m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_BLACK = "\u001B[30m"; // 검정색
	public static final String ANSI_BLUE = "\u001B[34m"; // 파란색
	public static final String ANSI_WHITE = "\u001B[37m"; // 흰색

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // 검정색 배경
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m"; // 빨간색 배경
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m"; // 녹색 배경
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m"; // 노란색 배경
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m"; // 파란색 배경
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m"; // 자주색 배경
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m"; // 시안색 배경
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // 흰색 배경
	public static final String ANSI_PURPLE_BACKGROUND_LIGHT = "\u001B[45;1m"; // 자주색 배경

	private Scanner scan = new Scanner(System.in);

	public static User user;
	private Map map;
	private Monster monster;

	private boolean isRun;
	private boolean isFight;

	public Game() {
		user = new Begginer();
		map = new SlimeAndGolemForest();
		monster = null;
		isRun = true;
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

	public void run() {
		while (isRun) {
			// printStart();
			System.out.println(map.getName() + ANSI_RESET);
			System.out.println(map);
			String dir = inputString(ANSI_RESET + "입력");
			move(dir);
			monster = isFight();
			if (monster == null) {
				continue;
			}
			fight();
		}
	}

	/* print */
	private void printStart() {
		System.out.println(ANSI_CYAN + ANSI_BOLD + "===== 메뉴 선택 =====");
		System.out.println(ANSI_RESET + ANSI_CYAN + "1) 로그인");
		System.out.println("2) 회원가입" + ANSI_RESET);
	}

	private void printMonster() {
		System.out.println(monster);
	}

	private void printBegginer() {
		System.out.println("============");
		System.out.println("| 1) 평타치기 |");
		System.out.println("| *) 도망가기 |");
		System.out.println("============");
	}

	private void printFristJob() {
		System.out.println("============");
		System.out.println("| 1) 평타치기 |");
		System.out.println("| 2) 스킬쓰기 |");
		System.out.println("| *) 도망가기 |");
		System.out.println("============");

	}

	private void printMonsterAttack() {
		System.out.println(ANSI_RED+ monster.getName() + ": " + monster.getMessage()+ANSI_RESET);
		String result = "";
		result += ANSI_RED + user.getName() + ": [" + user.getHp() + "|" + user.getMAX_HP() + "]" + Game.ANSI_RESET;
		System.out.println(result);
	}

	private void printStatusMonster() {
		System.out.println(monster.getName() + ": [" + monster.getHp() + "|" + monster.getMAX_HP() + "]");
	}

	/* menu Method */
	private void begginer(int sel) {
		switch (sel) {
		case 1:
			bassicAttack();
			break;
		default:
			isFight = false;
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
			isFight = false;
			break;
		}
	}

	private void bassicAttack() {
		System.out.println("평타!!");
		monster.setHp(-user.getPower());
	}

	private void firstSkill() {
		System.out.println("스킬~");
		int damage = user.skill();
		monster.setHp(-damage);
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
			if (monster.getX() == user.getX() && monster.getY() == user.getY()) {
				isFight = true;
				return monster;
			}
		}
		return null;
	}

	private void fight() {
		System.out.println(ANSI_BOLD + ANSI_RED + "몬스터 등장!!");
		battle();
	}

	private void battle() {
		while (true) {
			printMonster();
			printStatusMonster();
			userAttack();
			if (monster.isDead()) {
				deadMonster();
			}
			if (!isFight)
				break;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			monsterAttack();
			printMonsterAttack();
			if (user.isDead()) {
				deadUser();
			}
			if (!isFight)
				break;
		}
	}

	private void deadMonster() {
		user.setXp(monster.getXp());
		System.err.println("몬스터 처치!!");
		map.monsterList.remove(monster);
		System.out.println(monster.getXp() + "경험치 획득!");
		isFight = false;
	}

	private void deadUser() {
		System.err.println("게임종료!!");
		isFight = false;
		isRun = false;
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

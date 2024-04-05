package main;

import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Job;
import abstractClass.Map;
import abstractClass.Monster;
import abstractClass.Npc;
import file.FileManager;
import interfaces.Skillable;
import map.Town;
import unit.Begginer;
import user.User;
import user.UserManager;

public class Game {

	private Start start = new Start();

	private Scanner scan = new Scanner(System.in);

	public static Job job;
	private Map map;
	private Monster monster;

	private boolean isRun;
	private boolean isFight;

	private static User user;

	private FileManager fileManager;
	private UserManager userManager;

	public Game() {
		job = new Begginer();
		map = new Town();
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
		user = start.run();
		userSet(user.getId());
		userManager.setJob();
		while (isRun) {
			// printStart();
			System.out.println(map.getName() + FontStyle.ANSI_RESET);
			System.out.println(map);
			String dir = inputString(FontStyle.ANSI_RESET + "입력");
			move(dir);
			monster = isFight();
			if (monster == null) {
				continue;
			}
			fight();
		}
	}

	private void userSet(String id) {
		userManager = UserManager.getInstance();
		String data[] = userManager.selectJob(id);
		System.out.println(data);
	}

	/* print */
	private void printStart() {
		System.out.println(FontStyle.ANSI_CYAN + FontStyle.ANSI_BOLD + "===== 메뉴 선택 =====");
		System.out.println(FontStyle.ANSI_RESET + FontStyle.ANSI_CYAN + "1) 로그인");
		System.out.println("2) 회원가입" + FontStyle.ANSI_RESET);
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
		System.out.println(FontStyle.ANSI_RED + monster.getName() + ": " + monster.getMessage() + FontStyle.ANSI_RESET);
		String result = "";
		result += FontStyle.ANSI_RED + job.getName() + ": [" + job.getHp() + "|" + job.getMAX_HP() + "]"
				+ FontStyle.ANSI_RESET;
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

	private int guild(int sel) {
		if (sel == 1)
			return sel;
		else if (sel == 2)
			return sel;
		else if (sel == 3)
			return sel;
		else
			return 0;
	}

	private int file(int sel) {
		if (sel == 1) {
			fileManager = FileManager.getInstance();
			String mapName = map.getClass().getSimpleName();
			String jobName = job.getClass().getSimpleName();
			String id = user.getId();
			fileManager.saveJob(mapName, jobName, id);
			return sel;
		} else if (sel == 2)
			return sel;
		else
			return 0;
	}

	private void bassicAttack() {
		System.out.println("평타!!");
		monster.setHp(-job.getPower());
	}

	private void firstSkill() {
		System.out.println("스킬~");
		int damage = job.skill();
		monster.setHp(-damage);
	}

	private void move(String dir) {
		int tX = job.getX();
		int tY = job.getY();
		if (dir.equals("a"))
			tX--;
		else if (dir.equals("d"))
			tX++;
		else if (dir.equals("s"))
			tY++;
		else if (dir.equals("w"))
			tY--;
		if (map instanceof Town) {
			if (tX < 0 || tX >= 11 || tY < 0 || tY >= 2) {
				return;
			}
		} else {
			if (tX < 0 || tX >= 10 || tY < 0 || tY >= 10) {
				return;
			}
		}
		if (checkMap()) {
			String npc = checkNpc(tX, tY);
			if (npc != null) {
				meetNpc(npc);
				return;
			}
		}
		job.setX(tX);
		job.setY(tY);
	}

	private void meetNpc(String npc) {
		Town town = new Town();
		ArrayList<Npc> npcList = town.getNpcList();
		if (npc.equals(npcList.get(0).getName())) {
			System.out.println(npcList.get(0));
			npcList.get(0).printGuideMessage();
			while (true) {
				int sel = guild(Scan.inputNum("길드메뉴"));
				if (sel == 0)
					break;
			}
		} else if (npc.equals(npcList.get(1).getName())) {
			System.out.println(npcList.get(1));
			npcList.get(1).printGuideMessage();
		} else if (npc.equals(npcList.get(2).getName())) {
			System.out.println(npcList.get(2));
			npcList.get(2).printGuideMessage();
			while (true) {
				int sel = file(Scan.inputNum("파일메뉴"));
				if (sel == 0)
					break;
				else if (sel == 2) {
					isRun = false;
					break;
				}
			}
		}
	}

	private boolean checkMap() {
		if (map instanceof Town)
			return true;
		return false;
	}

	private String checkNpc(int x, int y) {
		Town town = new Town();
		ArrayList<Npc> npcList = town.getNpcList();
		for (int i = 0; i < npcList.size(); i++) {
			Npc npc = npcList.get(i);
			if (npc.getY() == y && npc.getX() == x) {
				return npc.getName();
			}
		}
		return null;
	}

	private Monster isFight() {
		ArrayList<Monster> monsterList = map.getMonsterList();
		for (Monster monster : monsterList) {
			if (monster.getX() == job.getX() && monster.getY() == job.getY()) {
				isFight = true;
				return monster;
			}
		}
		return null;
	}

	private void fight() {
		System.out.println(FontStyle.ANSI_BOLD + FontStyle.ANSI_RED + "몬스터 등장!!");
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
			}
			monsterAttack();
			printMonsterAttack();
			if (job.isDead()) {
				deadUser();
			}
			if (!isFight)
				break;
		}
	}

	private void deadMonster() {
		job.setXp(monster.getXp());
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
		if (job instanceof Skillable) {
			printFristJob();
			fristJob(inputNum("메뉴입력"));
		} else {
			printBegginer();
			begginer(inputNum("메뉴입력"));
		}
	}

	private void monsterAttack() {
		job.setHp(-monster.getPower());
	}
}

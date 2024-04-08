package main;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Scanner;

import abstractClass.Job;
import abstractClass.Map;
import abstractClass.Monster;
import abstractClass.Npc;
import file.FileManager;
import interfaces.Skillable;
import item.ItemManager;
import map.GolemForest;
import map.SlimeAndGolemForest;
import map.SlimeForest;
import map.Town;
import unit.Begginer;
import unit.Healer;
import unit.Warrior;
import unit.Wizard;
import user.Inven;
import user.InvenManager;
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

	public static User user;

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

	private int shop(int sel) {
		ItemManager itemManager = ItemManager.getInstance();
		if (sel == 1) {
			itemManager.addItem("방망이");
			return sel;
		} else if (sel == 2) {
			itemManager.addItem("천갑옷");
			return sel;
		} else if (sel == 3)
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

	private int changeJob(int sel) {
		if (sel == 1) {
			Wizard wizard = new Wizard();
			job = wizard;
			return sel;
		} else if (sel == 2) {
			Warrior warrior = new Warrior();
			job = warrior;
			return sel;
		} else if (sel == 3) {
			Healer healer = new Healer();
			job = healer;
			return sel;
		} else
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

	private void inven() {
		Inven inven = new Inven();
		int size = 0;
		while (true) {
			size = inven.size();
			if (size == 0) {
				System.out.println(FontStyle.ANSI_RED + "아이템이 없습니다.");
				return;
			}
			System.out.println(inven);
			System.out.println("index: " + inven.getIndex());
			System.out.println("size: " + inven.size());
			String dir = Scan.inputString("입력");
			if (dir.equals("q")) {
				InvenManager invenManager = InvenManager.getInstance();
				invenManager.setEquipment(inven.getIndex());
				inven.setIndex(0);
				if (inven.size() == 0) {
					return;
				}
				continue;
			}

			if (size == 0)
				return;

			int index = moveInven(inven.getIndex(), dir, size);
			if (index == -1)
				break;
			inven.setIndex(index);
		}
	}

	private int moveInven(int index, String dir, int size) {
		int tempIndex = index;
		if (dir.equals("a"))
			tempIndex--;
		else if (dir.equals("d"))
			tempIndex++;
		else if (dir.equals("w"))
			tempIndex -= 3;
		else if (dir.equals("s"))
			tempIndex += 3;
		else
			return -1;
		if (tempIndex < 0 || tempIndex >= size)
			return index;

		return tempIndex;
	}

	private void move(String dir) {
		int tX = job.getX();
		int tY = job.getY();
		if (dir.equals("r")) {
			inven();
			return;
		}
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
			if (tX == 10 && tY == 1) {
				map = new SlimeForest();
				job.setX(0);
				job.setY(1);
				return;
			}
		} else {
			if (map instanceof SlimeForest) {
				if (tX == 0 && tY == 0) {
					map = new Town();
					job.setX(9);
					job.setY(1);
					return;
				} else if (tX == 9 && tY == 9) {
					map = new SlimeAndGolemForest();
					job.setX(0);
					job.setY(1);
					return;
				}
			} else if (map instanceof SlimeAndGolemForest) {
				if (tX == 0 && tY == 0) {
					map = new SlimeForest();
					job.setX(8);
					job.setY(9);
					return;
				} else if (tX == 9 && tY == 9) {
					map = new GolemForest();
					job.setX(0);
					job.setY(1);
					return;
				}
			} else if (map instanceof GolemForest) {
				if (tX == 0 && tY == 0) {
					map = new SlimeAndGolemForest();
					job.setX(8);
					job.setY(9);
					return;
				} else if (tX == 9 && tY == 9) {
					System.out.println("레벨이 부족합니다");
					return;
				}
			}
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
			while (true) {
				System.out.println(npcList.get(1));
				npcList.get(1).printGuideMessage();
				int sel = shop(Scan.inputNum("상점메뉴"));
				if (sel == 0)
					break;
			}
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
		} else if (npc.equals(npcList.get(3).getName())) {
			if (job.getLevel() < 0) {
				System.out.println(FontStyle.ANSI_RED + "레벨이 부족합니다!" + FontStyle.ANSI_RESET);
				return;
			}
			System.out.println(npcList.get(3));
			npcList.get(3).printGuideMessage();
			while (true) {
				int sel = changeJob(Scan.inputNum("전직메뉴"));
				if (sel == 0)
					break;
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
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
				Thread.sleep(800);
			} catch (Exception e) {
			}
			monsterAttack();
			printMonsterAttack();
			try {
				Thread.sleep(800);
			} catch (Exception e) {
			}
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
		job.setCash(monster.getMoney());
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

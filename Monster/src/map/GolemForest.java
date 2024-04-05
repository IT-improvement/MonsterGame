package map;

import abstractClass.Map;
import abstractClass.Monster;
import main.FontStyle;
import monster.Golem;
import monster.Slime;

public class GolemForest extends Map {

	public GolemForest() {
		super(10, 10, FontStyle.ANSI_GRAY + FontStyle.ANSI_BOLD + "골렘의 소굴",FontStyle.ANSI_GRAY);
		setMonster();
	}

	@Override
	public void setMonster() {
		for (int i = 0; i < 3; i++) {
			int x = (int) (Math.random() * super.getHeight());
			int y = (int) (Math.random() * super.getWidth());
			if (y == 0 && (x == 0 || x == 1)) {
				i--;
				continue;
			}
			boolean isCheck = false;
			for (Monster golems : monsterList) {
				if (golems.getX() == x && golems.getY() == y) {
					isCheck = true;
					break;
				}
			}
			if (isCheck) {
				i--;
				continue;
			}
			Golem golem = new Golem(x, y);
			monsterList.add(golem);
		}
	}
}

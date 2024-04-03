package map;

import java.util.ArrayList;

import abstractClass.Map;
import abstractClass.Monster;
import monster.Golem;

public class Map1 extends Map {

	public Map1() {
		super(10, 10);
		setMonster();
	}

	@Override
	public void setMonster() {
		for (int i = 0; i < 3; i++) {
			int x = (int) (Math.random() * super.getHeight());
			int y = (int) (Math.random() * super.getWidth());
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
			Golem golem = new Golem(y, x);
			monsterList.add(golem);
		}
	}
}

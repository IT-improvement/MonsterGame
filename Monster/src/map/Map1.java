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

	private void setMonster() {
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

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < super.getWidth(); i++) {
			for (int j = 0; j < super.getHeight(); j++) {

			}
		}
		return result;
	}
}

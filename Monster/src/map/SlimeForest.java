package map;

import abstractClass.Map;
import abstractClass.Monster;
import main.FontStyle;
import monster.Slime;

public class SlimeForest extends Map {

	public SlimeForest() {
		super(10, 10, FontStyle.ANSI_GREEN + FontStyle.ANSI_BOLD + "슬라임의 숲",FontStyle.ANSI_GREEN);
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
			Slime slime = new Slime(x, y);
			monsterList.add(slime);
		}
	}
}

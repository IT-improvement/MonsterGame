package map;

import abstractClass.Map;
import abstractClass.Monster;
import main.FontStyle;

public class SlimeAndGolemForest extends Map {

	String path = "monster.";
	String mons[] = { "Golem", "Slime" };

	public SlimeAndGolemForest() {
		super(10, 10, FontStyle.ANSI_GREEN +FontStyle.ANSI_BOLD +"슬라임과 골렘의 숲");
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
			int num = (int) (Math.random() * mons.length);
			try {
				Class<?> clazz = Class.forName(path + mons[num]);

				// 이건 오버로드된 생성자일때
				Class<?>[] params = { int.class, int.class };
				Object object = clazz.getDeclaredConstructor(params).newInstance(x, y);

				// Object obj = clazz.getDeclaredConstructor().newInstance(); //이건 기본생성자일때
				Monster monster = (Monster) object;
				monsterList.add(monster);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

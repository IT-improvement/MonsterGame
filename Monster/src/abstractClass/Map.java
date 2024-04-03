package abstractClass;

import java.util.ArrayList;

public abstract class Map {
	private int height;
	private int width;
	public ArrayList<Monster> monsterList;

	public Map(int height, int width) {
		super();
		this.height = height;
		this.width = width;
		monsterList = new ArrayList<>();
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_SaintSeiya extends Map {
	//saint seiya
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	public void setPos(){
		Vector2[] pos = {
				new Vector2(195,52), // left ground
				new Vector2(546,52), // right ground
				new Vector2(20,50), // level 1 left
				new Vector2(730,50), // level 1 right
				new Vector2(265,172), // level 2 left
				new Vector2(465,172), // level 2 right
				new Vector2(95,222), // level 3 left
				new Vector2(650,222) // level 3 right
				};
		setSpawnPos(pos);
	}

	public Map_SaintSeiya(){
		setPos();
		objects = new Array<Box>();
		objects.add(new Box(-1, -1, 1000, 1)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(0, 22, 200, 28)); // left ground
		objects.add(new Box(310, 22, 165, 28)); // mid ground
		objects.add(new Box(595, 22, 165, 28)); // right ground
		objects.add(new Box(185, 120, 24, 2)); // level1 left
		objects.add(new Box(570, 120, 24, 2)); // level1 right
		objects.add(new Box(305, 170, 24, 2)); // level2 left
		objects.add(new Box(470, 170, 24, 2)); // level2 right
		objects.add(new Box(100, 220, 24, 2)); // level3 left
		objects.add(new Box(660, 220, 24, 2)); // level3 right
	}
}
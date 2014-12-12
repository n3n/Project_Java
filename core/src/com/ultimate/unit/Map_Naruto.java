package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_Naruto extends Map {
	//naruto map
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	public void setPos(){
		Vector2[] pos = {
				new Vector2(160,50), // left ground
				new Vector2(365,50), // right ground
				new Vector2(570,50), // mid ground
				new Vector2(231,132), // level 1 right
				new Vector2(562,132), // level 2 left
				new Vector2(470,300), // IN THE AIRRRR (LEFT)
				new Vector2(260,300) // IN THE AIRRR (RIGHT)
				};
		setSpawnPos(pos);
	}
	
	public Map_Naruto(){
		setPos();
		objects = new Array<Box>();
//		objects.add(new Box(-1, -1, 1000, 1)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(0, 20, 56, 28)); // leftest ground
		objects.add(new Box(142, 20, 87, 28)); // left ground
		objects.add(new Box(348, 20, 87, 28)); // mid ground
		objects.add(new Box(554, 20, 87, 28)); // right ground
		objects.add(new Box(728, 20, 56, 28)); // rightest ground
		objects.add(new Box(145, 130, 87, 2)); // level1 left
		objects.add(new Box(560, 130, 84, 2)); // level1 right
		objects.add(new Box(0, 220, 90, 4)); // level2 left
		objects.add(new Box(690, 220, 90, 4)); // level2 right
	}
}

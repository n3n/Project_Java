package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_Alale extends Map {
	//alale
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	public void setPos(){
		Vector2[] pos = {
				new Vector2(50,30),
				new Vector2(700,36),
				new Vector2(95,120),
				new Vector2(370,120),
				new Vector2(630,120),
				new Vector2(40,245),
				new Vector2(365,155),
				new Vector2(50,300),
				new Vector2(650,300)};
		setSpawnPos(pos);
	}
	
//	private Vector2[] spawnPos = {
//			new Vector2(50,30), // left ground
//			new Vector2(740,36), // right ground
//			new Vector2(95,120), // level 1 left
//			new Vector2(370,120), // level 1 mid
//			new Vector2(630,120), // level 1 right
//			new Vector2(40,245), // level 2 left
//			new Vector2(365,155), // level 2 mid
//			new Vector2(50,300), // IN THE AIRRRR (LEFT)
//			new Vector2(650,300) // IN THE AIRRR (RIGHT)
//	};

	public Map_Alale(){
		setPos();
		objects = new Array<Box>();
		objects.add(new Box(0, 0 , 760, 29)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(60, 110, 130, 10)); // level 1 left
		objects.add(new Box(330, 110, 130, 10)); // level 1 mid 
		objects.add(new Box(590, 110, 130, 10)); // level 1 right 
		objects.add(new Box(0, 180, 50, 20)); // level 2 left
		objects.add(new Box(740, 180, 50, 20)); // level 2 left
		objects.add(new Box(150, 229, 130, 10)); // level 3 left
		objects.add(new Box(475, 229, 130, 10)); // level 3 left
	}
}
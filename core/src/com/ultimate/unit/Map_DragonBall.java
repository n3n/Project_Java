package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_DragonBall extends Map {
	//dragonball
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	public void setPos(){
		Vector2[] pos = {
				new Vector2(50,30), // left ground
				new Vector2(695,30), // right ground
				new Vector2(2,190), // level 2 left
				new Vector2(720,190), // level 2 right
				new Vector2(370, 278), // level 3 left
				new Vector2(240,444), // IN THE AIRRRR (LEFT)
				new Vector2(500,444) // IN THE AIRRR (RIGHT)
				};
		setSpawnPos(pos);
	}

	public Map_DragonBall(){
		setPos();
		objects = new Array<Box>();
		objects.add(new Box(0, 0 , 760, 29)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(85, 105, 95, 5)); // level 1 left
		objects.add(new Box(345, 105, 95, 5)); // level 1 mid
		objects.add(new Box(600, 105, 95, 5)); // level 1 right
		objects.add(new Box(0, 185, 50, 5)); // level 2 left 
		objects.add(new Box(740, 185, 50, 5)); // level 2 right 
		objects.add(new Box(345, 185, 95, 5)); // level 2 mid
		objects.add(new Box(85, 273, 95, 5)); // level 3 left
		objects.add(new Box(345, 273, 95, 5)); // level 3 mid
		objects.add(new Box(600, 273, 95, 5)); // level 3 right
		objects.add(new Box(345, 355, 95, 5)); // level 4 mid
	}
}
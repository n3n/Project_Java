package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_Jojo extends Map {
	//JoJo map
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	public void setPos(){
		Vector2[] pos = {
				new Vector2(40,50), // left ground
				new Vector2(700,50), // right ground
				new Vector2(365,50), // mid ground
				new Vector2(525,155), // level 1 right
				new Vector2(188,155), // level 1 left
				new Vector2(365,155), // level 2 mid
				new Vector2(50,300), // IN THE AIRRRR (LEFT)
				new Vector2(650,300) // IN THE AIRRR (RIGHT)
				};
		setSpawnPos(pos);
	}
	
	public Map_Jojo(){
		setPos();
		objects = new Array<Box>();
		objects.add(new Box(0, 22, 760, 20)); // Ground
		//objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		//objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(138, 118, 185, 20)); // level 1 left
		objects.add(new Box(465, 118, 185, 20)); // level 1 right
		objects.add(new Box(0, 215, 200, 20)); // level 2 left
		objects.add(new Box(564, 215, 200, 20)); // level 2 right
		objects.add(new Box(350, 215, 90, 20)); //level 2 mid
	}
}

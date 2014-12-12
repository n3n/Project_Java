package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;


public class Map_DeathNote extends Map {
	//death note map
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;

	
	public void setPos(){
		Vector2[] pos = {
				new Vector2(199,36), // left ground
				new Vector2(399,36), // mid ground
				new Vector2(698,36), // right ground
				new Vector2(720,245), // level 2 right
				new Vector2(40,245), // level 2 left
				new Vector2(365,155), // level 2 mid
				new Vector2(50,300), // IN THE AIRRRR (LEFT)
				new Vector2(650,300) // IN THE AIRRR (RIGHT)
				};
		setSpawnPos(pos);
	}

	public Map_DeathNote(){
		setPos();
		objects = new Array<Box>();
		objects.add(new Box(0, 0 , 760, 36)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(110, 118, 140, 20)); // level 1 left
		objects.add(new Box(365, 118, 50, 20)); // level 1 mid
		objects.add(new Box(530, 118, 140, 20)); // level 1 right
		objects.add(new Box(0, 215, 80, 20)); // level 2 left
		objects.add(new Box(700, 215, 80, 20)); // level 2 right
	}
}
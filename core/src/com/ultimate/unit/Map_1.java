package com.ultimate.unit;

import com.badlogic.gdx.utils.Array;


public class Map_1 extends Map {
	
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;
	
	public Map_1(){
		objects = new Array<Box>();
		objects.add(new Box(-1, -1, 1000, 1)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(1000, -1, 2, 1100)); // Wall right
	}
	

}

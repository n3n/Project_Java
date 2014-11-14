package com.ultimate.unit;

import com.badlogic.gdx.utils.Array;


public class Map_1 extends Map {
	
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;
	private int[][] spawnPos = {
			{0,0},
			{1,1}
			}; 
	public Map_1(){
		objects = new Array<Box>();
//		objects.add(new Box(-1, -110, 1000, 100)); // Ground
//		objects.add(new Box(-120, -1, 100, 1100)); // Wall left
//		objects.add(new Box(1000, -1, 2, 1100)); // Wall right
//		objects.add(new Box(-1, -1, 1000, 1)); // Ground
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(0, 22, 200, 28)); // left ground
		objects.add(new Box(310, 22, 165, 28)); // mid ground
		objects.add(new Box(595, 22, 165, 28)); // right ground
		objects.add(new Box(185, 120, 24, 2)); // level1 left
		objects.add(new Box(550, 120, 24, 2)); // level1 right
	}
	

}

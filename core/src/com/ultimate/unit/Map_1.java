package com.ultimate.unit;

import com.badlogic.gdx.utils.Array;


public class Map_1 extends Map {
	
	public final static int WIDTH = 400;
	public final static int HEIGHT = 1000;
	public final static int TYPE = 1;
	public static final int[][] spawnPos = {
			{40,52},
			{130,52},
			{171,124},
			{281,52},
			{331,52},
			{381,52},
			{441,52},
			{526,124},
			{576,52},
			{636,52},
			{686,52},
			{726,52}
			}; 
	public Map_1(){
		objects = new Array<Box>();
		objects.add(new Box(-1, -1, 2, 1100)); // Wall left
		objects.add(new Box(780, -1, 2, 1100)); // Wall right
		objects.add(new Box(0, 22, 200, 28)); // left ground
		objects.add(new Box(310, 22, 165, 28)); // mid ground
		objects.add(new Box(595, 22, 165, 28)); // right ground
		objects.add(new Box(185, 120, 24, 2)); // level1 left
		objects.add(new Box(550, 120, 24, 2)); // level1 right
	}
	

}

package com.ultimate.unit;

import com.badlogic.gdx.utils.Array;

public abstract class Map {
	
	protected Array<Box> objects;
	
	public Array<Box> getObject(){
		return objects;
	}
	
}

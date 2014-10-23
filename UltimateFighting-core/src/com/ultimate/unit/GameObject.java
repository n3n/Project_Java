package com.ultimate.unit;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	public Vector2 position;
	public Rectangle bounds;
	
	public GameObject(float x, float y, int width, int height){
		position = new Vector2(x, y);
		bounds = new Rectangle(x, y, width, height);
	}
}

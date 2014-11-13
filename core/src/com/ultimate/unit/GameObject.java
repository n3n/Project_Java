package com.ultimate.unit;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
	
	private Vector2 position;
	private Rectangle bounds;
	
	public GameObject(){
		position = new Vector2();
		bounds = new Rectangle();
	}
	
	public void setBounds(float x, float y, int width, int height){
		bounds.set(x, y, width, height);
	}
	
	public void setPosition(float x, float y){
		position.set(x, y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
}

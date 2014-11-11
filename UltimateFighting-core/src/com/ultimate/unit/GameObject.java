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
	
	public void setBounds(int x, int y, int width, int height){
		bounds.set(x, y, width, height);
	}
	
	public void setPosition(int x, int y){
		position.set(x, y);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public Rectangle getBounds(){
		return bounds;
	}
}

package com.ultimate.unit;

public class Box extends GameObject {
	
	public Box(){
		
	}
	
	public Box(float x, float y, int width, int height) {
		setPosition(x, y);
		setBounds(getPosition().x,getPosition().y, width, height);
	}
	
}

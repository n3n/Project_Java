package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;

public abstract class JobClass extends GameObject{
	
	public Vector2 velocity;
	protected float hp, mp, atk, mAtk, def, mDef, speed, gravity;
	public boolean onGround = true, isAction = false, isRight = true, isRun = false;
	final static int STATE_STAND = 1;
	final static int STATE_RUN = 2;
	final static int STATE_JUMP = 3;
	final static int STATE_ATK = 4;
	final static int STATE_BLOCK = 5;
	
	public JobClass(float x, float y, int width, int height){
		super(x, y, width, height);
		velocity = new Vector2();
	}
	
	public void setPosition(float x, float y){
		position = new Vector2(position.x += x, position.y += y);
	}
}
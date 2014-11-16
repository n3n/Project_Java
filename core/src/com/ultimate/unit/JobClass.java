package com.ultimate.unit;

import com.badlogic.gdx.math.Vector2;
import com.ultimate.game.UltimateFight;

public abstract class JobClass extends GameObject{
	
	public Vector2 velocity;
	private float hp, mp, atk, mAtk, def, mDef, speed, gravity;
	private boolean isAction = false, isRight = true;
	private int type;
	private int STATE = 1;
	public final static int STATE_STAND = 1;
	public final static int STATE_RUN = 2;
	public final static int STATE_JUMP_UP = 3;
	public final static int STATE_BLOCK = 4;
	public final static int STATE_ATK1 = 5;
	public final static int STATE_ATK2 = 6;
	public final static int STATE_ATK3 = 7;
	public final static int STATE_JUMP_DOWN = 8;
	public final static int STATE_DEAD = 9;
	public final static int STATE_WIN = 10;
	public final static int STATE_HURT = 11;
	public final static int STATE_ULTIMATE = 12;
	
	public JobClass(){
		
	}
	
	public JobClass(float x, float y, int width, int height){
		setPosition(x, y);
		setBounds(getPosition().x,getPosition().y, width, height);
		velocity = new Vector2();
	}
	
	public void moveRight(float x){
		setPosition(getPosition().x += x, getPosition().y);
		getBounds().setPosition(getPosition());
	}
	
	public void moveLeft(float x){
		setPosition(getPosition().x -= x, getPosition().y);
		getBounds().setPosition(getPosition());
	}
	
	public void moveUp(float y){
		setPosition(getPosition().x, getPosition().y += y);
		getBounds().setPosition(getPosition());
	}
	
	public void moveDown(float y){
		setPosition(getPosition().x, getPosition().y -= y);
		getBounds().setPosition(getPosition());
	}
	
	public void getDmg(){
		this.hp -= 100;
	}
	
	public int getType(){
		return type;
	}
	
	public void setType(int type){
		this.type = type;
	}
	
	public boolean isRight(){
		return isRight;
	}
	
	public void setRight(boolean right){
		this.isRight = right;
	}
	
	public boolean isAction(){
		return isAction;
	}
	
	public void setAction(boolean action){
		this.isAction = action;
	}
	
	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public float getMp() {
		return mp;
	}

	public void setMp(float mp) {
		this.mp = mp;
	}

	public float getAtk() {
		return atk;
	}

	public void setAtk(float atk) {
		this.atk = atk;
	}

	public float getmAtk() {
		return mAtk;
	}

	public void setmAtk(float mAtk) {
		this.mAtk = mAtk;
	}

	public float getDef() {
		return def;
	}

	public void setDef(float def) {
		this.def = def;
	}

	public float getmDef() {
		return mDef;
	}

	public void setmDef(float mDef) {
		this.mDef = mDef;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		this.STATE = sTATE;
	}

	public abstract void atk1(UltimateFight game);
	public abstract void atk2(UltimateFight game);
	public abstract void atk3(UltimateFight game);
	public abstract void atk4(UltimateFight game);
	public abstract void block(UltimateFight game);
}
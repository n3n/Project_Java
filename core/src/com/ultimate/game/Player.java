package com.ultimate.game;

import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;

/**
 * 
 * @author Labelpezzy
 *
 */
public class Player {

	private int id;
	public JobClass character;
	private float stateTime = 0f;
	private String name = "undefined";
	private boolean inGame = false;
	private int kill = 0;
	private int dead = 0;
	
	public int getKill() {
		return kill;
	}


	public void setKill(int kill) {
		this.kill = kill;
	}


	public int getDead() {
		return dead;
	}


	public void setDead(int dead) {
		this.dead = dead;
	}
	
	public void increaseKill(){
		this.kill++;
	}
	
	public void increaseDead(){
		this.dead++;
	}
	
	public boolean isInGame() {
		return inGame;
	}


	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}


	public Player(){
		id = (int)(Math.random()*1000000);
		character = new Luffy();
	}
	
	public float getHP(){
		return character.getHp();
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	/**
	 * 
	 * @return Integer: id
	 */
	public int getPlayerID(){
		return id;
	}

	public void setJob(JobClass job){
		this.character = job;
	}
	
	public float getStateTime(){
		return stateTime;
	}
	
	public void setStateTime(float stateTime){
		this.stateTime = stateTime;
	}
}

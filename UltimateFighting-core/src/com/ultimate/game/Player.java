package com.ultimate.game;

import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;


public class Player {
	
	private int id;
	public JobClass character;
	
	public Player(){
		id = (int)(Math.random()*1000000);
		character = new Luffy();
	}
	
	public int getPlayerID(){
		return id;
	}

	public void setJob(JobClass job){
		this.character = job;
	}
}

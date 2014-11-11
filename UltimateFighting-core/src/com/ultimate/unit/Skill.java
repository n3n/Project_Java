package com.ultimate.unit;

public class Skill extends GameObject{

	private int id;
	private int player_id;
	private int type;
	
	public static final int TYPE_ATK = 1;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Skill(){
		
	}
	
	
}

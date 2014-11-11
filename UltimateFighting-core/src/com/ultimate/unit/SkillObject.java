package com.ultimate.unit;


public class SkillObject extends GameObject{
	
	private int id;
	private int type;
	private int status;
	private int owner_id;
	
	public static final int TYPE_ATK = 1;
	public static final int TYPE_RANGE = 2;
	
	public SkillObject()
	{
	}
	
//	public SkillObject(float x, float y, int width, int height) {
////		super(x, y, width, height);
//		setPosition(x, y);
//		setBounds(getPosition().x,getPosition().y, width, height);
//		status = 1; 
//	}
	
	public void setID(int id){
		this.id = id;
	}

	public int getID(){
		return id;
	}

	public void setType(int type){
		this.type = type;
	}

	public int getType(){
		return type;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}
	
	public void setOwner_id(int id){
		this.owner_id = id;
	}
	
	public int getOwner_id(){
		return owner_id;
	}

}

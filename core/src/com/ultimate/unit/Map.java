package com.ultimate.unit;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.ultimate.game.Assets;

public abstract class Map {
	
	protected Array<Box> objects;
	private Vector2[] spawnPos;
	
	public static Texture[] map_id = {
			Assets.map_alale,
			Assets.map_deathnote,
			Assets.map_dragonball,
			Assets.map_jojo,
			Assets.map_naruto,
			Assets.map_saintseiya
			};
	
	public Vector2[] getSpawnPos(){
		return spawnPos;
	}
	
	public void setSpawnPos(Vector2[] pos){
		this.spawnPos = pos;
	}
	
	public static Texture[] stage_id = {
			Assets.stage_alale,
			Assets.stage_deathnote,
			Assets.stage_dragonball,
			Assets.stage_jojo,
			Assets.stage_naruto,
			Assets.stage_saintseiya
			};
	
	public static Map[] object_id = {
		new Map_Alale(),
		new Map_DeathNote(),
		new Map_DragonBall(),
		new Map_Jojo(),
		new Map_Naruto(),
		new Map_SaintSeiya()
	};
	
	public Array<Box> getObject(){
		return objects;
	}
	
}

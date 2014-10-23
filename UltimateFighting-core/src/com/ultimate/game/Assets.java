package com.ultimate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Animation2 vegetaStand;
	public static Animation2 vegetaAtk;
	public static Animation2 vegetaDef;
	public static Animation2 vegetaRun;
	
	public static TextureRegion loadSprite(String file){
		return new TextureRegion(new Texture(Gdx.files.internal(file)));
	}
	
	public static void load(){
		vegetaStand = new Animation2(0.2f, 
				loadSprite("sprites/vegeta/vegeta_stand1.png"),
				loadSprite("sprites/vegeta/vegeta_stand2.png"),
				loadSprite("sprites/vegeta/vegeta_stand3.png"),
				loadSprite("sprites/vegeta/vegeta_stand4.png"),
				loadSprite("sprites/vegeta/vegeta_stand3.png"),
				loadSprite("sprites/vegeta/vegeta_stand2.png"),
				loadSprite("sprites/vegeta/vegeta_stand1.png")
				);
		vegetaRun = new Animation2(0.1f, 
				loadSprite("sprites/vegeta/vegeta_run_1.png"),
				loadSprite("sprites/vegeta/vegeta_run_2.png"),
				loadSprite("sprites/vegeta/vegeta_run_3.png")
				);
		vegetaAtk = new Animation2(0.1f, 
				loadSprite("sprites/vegeta/vegeta_B_forward_1.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_2.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_3.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_4.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_5.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_6.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_7.png")
				);
		
	}
}

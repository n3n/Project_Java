package com.ultimate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Animation2 vegetaStand;
	public static Animation2 vegetaBlock;
	public static Animation2 vegetaRun;
	public static Animation2 vegetaAtk;
	public static Animation2 vegetaJumpUp;
	public static Animation2 vegetaJumpDown;
	
	public static Animation2 luffyStand;
	public static Animation2 luffyBlock;
	public static Animation2 luffyRun;
	public static Animation2 luffyJumpUp;
	public static Animation2 luffyJumpDown;
	public static Animation2 luffyAtk;
	public static Animation2 luffyForwardAtk;
	
	public static Animation2 aceStand;
	public static Animation2 aceRun;
	public static Animation2 aceJumpUp;
	public static Animation2 aceJumpDown;
	public static Animation2 aceBlock;
	public static Animation2 aceAtk;
	public static Animation2 aceForwardAtk;
	
	public static Texture bg_mainMenu;
	
	
	public static TextureRegion loadSprite(String file){
		return new TextureRegion(new Texture(Gdx.files.internal(file)));
	}
	public static Texture loadTexture(String file){
		return new Texture(file);
	}
	
	public static void load(){
		loadVegeta();
		loadLuffy();
		loadAce();
		loadSanosuke();
		loadEtc();
	}
	
	private static void loadVegeta(){
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
		vegetaAtk = new Animation2(0.075f, 
				loadSprite("sprites/vegeta/vegeta_B_forward_1.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_2.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_3.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_4.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_5.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_6.png"),
				loadSprite("sprites/vegeta/vegeta_B_forward_7.png")
				);
	}
	
	private static void loadSanosuke(){
		
	}
	
	private static void loadLuffy(){
		luffyStand =  new Animation2(0.2f, 
				loadSprite("sprites/luffy/Luffy_Stand_1.png")
				);
		luffyAtk =  new Animation2(0.075f, 
				loadSprite("sprites/luffy/Luffy_Up+B_1.png"),
				loadSprite("sprites/luffy/Luffy_Up+B_2.png"),
				loadSprite("sprites/luffy/Luffy_Up+B_3.png"),
				loadSprite("sprites/luffy/Luffy_Up+B_4.png"),
				loadSprite("sprites/luffy/Luffy_Up+B_5.png")
				);
		luffyRun = new Animation2(0.2f, 
				loadSprite("sprites/luffy/Luffy_Run_1.png"),
				loadSprite("sprites/luffy/Luffy_Run_2.png"),
				loadSprite("sprites/luffy/Luffy_Run_3.png")
				);
		luffyBlock = new Animation2(0.2f, 
				loadSprite("sprites/luffy/Luffy_Guard_1.png"),
				loadSprite("sprites/luffy/Luffy_Guard_2.png"),
				loadSprite("sprites/luffy/Luffy_Guard_3.png")
				);
		luffyForwardAtk = new Animation2(0.1f, 
				loadSprite("sprites/luffy/Luffy_Forward+Y_1.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_2.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_3.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_4.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_5.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_6.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_7.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_8.png")
				);
		luffyJumpUp = new Animation2(0.1f,
				loadSprite("sprites/luffy/Luffy_Jump_1.png"),
				loadSprite("sprites/luffy/Luffy_Jump_2.png"),
				loadSprite("sprites/luffy/Luffy_Jump_3.png"),
				loadSprite("sprites/luffy/Luffy_Jump_4.png"),
				loadSprite("sprites/luffy/Luffy_Jump_5.png"),
				loadSprite("sprites/luffy/Luffy_Jump_6.png")
				);
		luffyJumpDown = new Animation2(0.1f, loadSprite("sprites/luffy/Luffy_Jump_6.png"));
		
		
	}
	
	private static void loadAce(){
		aceStand = new Animation2(0.2f, 
				loadSprite("sprites/Ace/ace_stance-1.png"),
				loadSprite("sprites/Ace/ace_stance-2.png"),
				loadSprite("sprites/Ace/ace_stance-3.png"),
				loadSprite("sprites/Ace/ace_stance-2.png"),
				loadSprite("sprites/Ace/ace_stance-1.png")
				);
		
		aceRun = new Animation2(0.075f, 
				loadSprite("sprites/Ace/ace_run-1.png"),
				loadSprite("sprites/Ace/ace_run-2.png"),
				loadSprite("sprites/Ace/ace_run-3.png"),
				loadSprite("sprites/Ace/ace_run-4.png"),
				loadSprite("sprites/Ace/ace_run-5.png"),
				loadSprite("sprites/Ace/ace_run-6.png"),
				loadSprite("sprites/Ace/ace_run-7.png"),
				loadSprite("sprites/Ace/ace_run-8.png")
				);
		
		aceAtk = new Animation2(0.1f, 
				loadSprite("sprites/Ace/ace_B-1.png"),
				loadSprite("sprites/Ace/ace_B-2.png"),
				loadSprite("sprites/Ace/ace_B-3.png"),
				loadSprite("sprites/Ace/ace_B-4.png"),
				loadSprite("sprites/Ace/ace_B-5.png"),
				loadSprite("sprites/Ace/ace_B-6.png")
				);
		
		aceForwardAtk = new Animation2(0.075f,
				loadSprite("sprites/Ace/ace_Ae+B-1.png"),
				loadSprite("sprites/Ace/ace_Ae+B-2.png"),
				loadSprite("sprites/Ace/ace_Ae+B-3.png"),
				loadSprite("sprites/Ace/ace_Ae+B-4.png"),
				loadSprite("sprites/Ace/ace_Ae+B-5.png"),
				loadSprite("sprites/Ace/ace_Ae+B-6.png"),
				loadSprite("sprites/Ace/ace_Ae+B-7.png"),
				loadSprite("sprites/Ace/ace_Ae+B-8.png"),
				loadSprite("sprites/Ace/ace_Ae+B-9.png"),
				loadSprite("sprites/Ace/ace_Ae+B-10.png"),
				loadSprite("sprites/Ace/ace_Ae+B-11.png"),
				loadSprite("sprites/Ace/ace_Ae+B-12.png")
				);
		
		aceJumpUp = new Animation2(0.05f, 
				loadSprite("sprites/Ace/ace_jump-1.png"),
				loadSprite("sprites/Ace/ace_jump-2.png"),
				loadSprite("sprites/Ace/ace_jump-3.png"),
				loadSprite("sprites/Ace/ace_jump-4.png"),
				loadSprite("sprites/Ace/ace_jump-5.png"),
				loadSprite("sprites/Ace/ace_jump-6.png"),
				loadSprite("sprites/Ace/ace_jump-7.png"),
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-10.png"),
				loadSprite("sprites/Ace/ace_jump-11.png"),
				loadSprite("sprites/Ace/ace_jump-12.png")
				);
		
		aceJumpDown = new Animation2(0.05f,
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-8.png"),
				loadSprite("sprites/Ace/ace_jump-9.png"),
				loadSprite("sprites/Ace/ace_jump-10.png"),
				loadSprite("sprites/Ace/ace_jump-11.png"),
				loadSprite("sprites/Ace/ace_jump-12.png")
				);
	}
	
	private static void loadEtc(){
		bg_mainMenu = loadTexture("dark-wood_158357.jpg");
	}
}

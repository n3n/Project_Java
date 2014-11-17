package com.ultimate.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Animation2 vegetaStand;
	public static Animation2 vegetaBlock;
	public static Animation2 vegetaRun;
	public static Animation2 vegetaJumpUp;
	public static Animation2 vegetaJumpDown;
	public static Animation2 vegetaAtk;
	public static Animation2 vegetaAtkHeavy;
	public static Animation2 vegetaForwardAtk;
	public static Animation2 vegetaHurt;
	
	public static Animation2 luffyStand;
	public static Animation2 luffyBlock;
	public static Animation2 luffyRun;
	public static Animation2 luffyJumpUp;
	public static Animation2 luffyJumpDown;
	public static Animation2 luffyAtk;
	public static Animation2 luffyAtkHeavy;
	public static Animation2 luffyForwardAtk;
	public static Animation2 luffyHurt;
	
	public static Animation2 aceStand;
	public static Animation2 aceRun;
	public static Animation2 aceJumpUp;
	public static Animation2 aceJumpDown;
	public static Animation2 aceBlock;
	public static Animation2 aceAtk;
	public static Animation2 aceAtkHeavy;
	public static Animation2 aceForwardAtk;
	public static Animation2 aceHurt;
	
	public static Texture bg_mainMenu;
	public static Texture map_1;
	public static Texture blood;
	public static Texture blood_tunk;
	public static Texture bg;
	public static Texture multiplayer;
	public static Texture multiplayer_onclick;
	public static Texture howtoplay;
	public static Texture howtoplay_onclick;
	public static Texture exit;
	public static Texture exit_onclick;
	public static Texture create;
	public static Texture create_onclick;
	public static Texture creategame;
	public static Texture creategame_onclick;
	public static Texture join;
	public static Texture join_onclick;
	public static Texture credit;
	public static Texture credit_onclick;
	public static Texture joingame;
	public static Texture joingame_onclick;
	public static Texture left;
	public static Texture left_onclick;
	public static Texture right;
	public static Texture right_onclick;
	public static Texture logo;
	public static Texture back;
	public static Texture back_onclick;
	public static Texture play;
	public static Texture play_onclick;
	public static Texture entername;
	public static Texture battleselect;
	public static Texture map_alale;
	public static Texture map_deathnote;
	public static Texture map_dragonball;
	public static Texture map_jojo;
	public static Texture map_naruto;
	public static Texture map_saintseiya;
	public static Texture state_deathnote;
	public static Texture state_naruto;
	public static Texture state_alale;
	public static Texture state_dragonball;
	public static Texture state_jojo;
	public static Texture state_saintseiya;
	public static Texture nametag;
	public static Texture ipaddress;
	
	public static Sound click;
	public static Sound atk;
	public static Sound atk2;
	public static Texture bg_loading;
	
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
		luffyForwardAtk = new Animation2(0.075f, 
				loadSprite("sprites/luffy/Luffy_Forward+Y_1.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_2.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_3.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_4.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_5.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_6.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_7.png"),
				loadSprite("sprites/luffy/Luffy_Forward+Y_8.png")
				);
		luffyJumpUp = new Animation2(0.075f,
				loadSprite("sprites/luffy/Luffy_Jump_1.png"),
				loadSprite("sprites/luffy/Luffy_Jump_2.png"),
				loadSprite("sprites/luffy/Luffy_Jump_3.png"),
				loadSprite("sprites/luffy/Luffy_Jump_4.png"),
				loadSprite("sprites/luffy/Luffy_Jump_5.png"),
				loadSprite("sprites/luffy/Luffy_Jump_6.png")
				);
		luffyJumpDown = new Animation2(0.1f, loadSprite("sprites/luffy/Luffy_Jump_6.png"));
		
		luffyHurt =  new Animation2(0.1f, 
				loadSprite("sprites/luffy/luffy_hurt_1.png"),
				loadSprite("sprites/luffy/luffy_hurt_2.png"),
				loadSprite("sprites/luffy/luffy_hurt_3.png"),
				loadSprite("sprites/luffy/luffy_hurt_4.png"),
				loadSprite("sprites/luffy/luffy_hurt_5.png"),
				loadSprite("sprites/luffy/luffy_hurt_6.png"),
				loadSprite("sprites/luffy/luffy_hurt_7.png"),
				loadSprite("sprites/luffy/luffy_hurt_8.png"),
				loadSprite("sprites/luffy/luffy_hurt_9.png"),
				loadSprite("sprites/luffy/luffy_hurt_10.png"),
				loadSprite("sprites/luffy/luffy_hurt_11.png")
				);
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
		map_1 = loadTexture("maps/test_map_1.png");
		blood = loadTexture("Materials/blood.png");
		blood_tunk = loadTexture("Materials/bloodtunk.png");
		bg = loadTexture("Materials/bg.png");
		multiplayer = loadTexture("Materials/multiplayer.png");
		multiplayer_onclick = loadTexture("Materials/multiplayer_onclick.png");
		credit = loadTexture("Materials/credit.png");
		credit_onclick = loadTexture("Materials/credit_onclick.png");
		howtoplay = loadTexture("Materials/howtoplay.png");
		howtoplay_onclick = loadTexture("Materials/howtoplay_onclick.png");
		exit = loadTexture("Materials/exit.png");
		exit_onclick = loadTexture("Materials/exit_onclick.png");
		logo = loadTexture("Materials/Logo.png");
		create = loadTexture("Materials/create.png");
		create_onclick = loadTexture("Materials/create_onclick.png");
		creategame = loadTexture("Materials/creategame.png");
		creategame_onclick = loadTexture("Materials/creategame_onclick.png");
		joingame = loadTexture("Materials/joingame.png");
		joingame_onclick = loadTexture("Materials/joingame_onclick.png");
		join = loadTexture("Materials/join.png");
		join_onclick = loadTexture("Materials/join_onclick.png");
		back  = loadTexture("Materials/back.png");
		back_onclick = loadTexture("Materials/back_onclick.png");
		battleselect = loadTexture("Materials/battleselect.png");
		left = loadTexture("Materials/left.png");
		left_onclick = loadTexture("Materials/left_onclick.png");
		right = loadTexture("Materials/right.png");
		right_onclick = loadTexture("Materials/right_onclick.png");
		map_alale = loadTexture("Materials/alale.png");
		map_deathnote = loadTexture("Materials/deathnote.png");
		map_dragonball= loadTexture("Materials/dragonball.png");
		map_jojo = loadTexture("Materials/jojo.png");
		map_naruto = loadTexture("Materials/naruto.png");
		map_saintseiya = loadTexture("Materials/saintseiya.png");
		state_alale = loadTexture("Materials/alale_stage.png");
		state_deathnote = loadTexture("Materials/deathnote_stage.png");
		state_dragonball= loadTexture("Materials/dragonball_stage.png");
		state_jojo = loadTexture("Materials/jojo_stage.png");
		state_naruto = loadTexture("Materials/naruto_stage.png");
		state_saintseiya = loadTexture("Materials/saintseiya_stage.png");
		play = loadTexture("Materials/play.png");
		play_onclick = loadTexture("Materials/play_onclick.png");
		entername = loadTexture("Materials/entername.png");
		nametag = loadTexture("Materials/nametag.png");
		ipaddress = loadTexture("Materials/ipaddress.png");
		click = loadSound("sound/029.mp3");
		atk = loadSound("sound/01_Luffy_B_audio.mp3");
		atk2 = loadSound("sound/014.mp3");
		
	}
	
	public static Sound loadSound(String file){
		Gdx.app.log("Load", "Sound: assets" + file);
		return Gdx.audio.newSound(Gdx.files.internal(file));
	}
	
	public static TextureRegion loadSprite(String file){
		Gdx.app.log("Load", "TextureRegion: assets" + file);
		return new TextureRegion(new Texture(Gdx.files.internal(file)));
	}
	
	public static Texture loadTexture(String file){
		Gdx.app.log("Load", "Texture: assets" + file);
		return new Texture(file);
	}
}

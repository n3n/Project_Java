package com.ultimate.controller;

import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.LoadingScreen;
import com.ultimate.screen.MainMenuScreen;

public class LoadingController extends GameController{

	UltimateFight game;
	LoadingScreen screen;
	
	public LoadingController(UltimateFight game, LoadingScreen screen){
		this.game = game;
		this.screen = screen;
		
	}
	
	public void update() {
		
		Assets.load();
		game.setScreen(new MainMenuScreen(game));
		game.sound_bg = Assets.loadSound("sound/BGM_MENU.mp3");
		game.sound_bg.loop(0.5f);
	}

}

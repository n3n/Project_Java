package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.HowToPlayScreen;
import com.ultimate.screen.MainMenuScreen;
import com.ultimate.screen.MultiplayerMenuScreen;


public class MainMenuController extends GameController {
	UltimateFight game;
	MainMenuScreen screen;
	
	public MainMenuController(UltimateFight game, MainMenuScreen screen){
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
	}
	
	public void update(){
		pointer.set(new Rectangle(Gdx.input.getX(), Gdx.input.getY(), 2, 2));
		screen.fontMultiplayer.setColor(1f,1f,1f,1f);
		screen.fontHowToPlay.setColor(1f,1f,1f,1f);
		screen.fontExit.setColor(1f,1f,1f,1f);
		
		if(screen.boundMultiplayer.overlaps(pointer)){
			screen.fontMultiplayer.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new MultiplayerMenuScreen(game));
				screen.dispose();
			}
		}
		else if(screen.boundHowToPlay.overlaps(pointer)){
			screen.fontHowToPlay.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new HowToPlayScreen(game));
				screen.dispose();
			}
		}
		else if(screen.boundExit.overlaps(pointer)){
			screen.fontExit.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0))
				game.dispose();
		}
	}
}

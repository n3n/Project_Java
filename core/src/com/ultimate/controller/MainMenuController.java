package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
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
		pointer.setSize(2, 2);
	}
	
	public void update(){
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		
//		System.out.println(pointer.x + ", " + pointer.y);
		
		if(screen.boundMultiplayer.overlaps(pointer)){
			game.batch.draw(Assets.multiplayer_onclick, screen.x, screen.y);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				Gdx.app.log("Screen", "To Multiplayer menu screen");
				screen.dispose();
				game.setScreen(new MultiplayerMenuScreen(game));
			}
		}
		else if(screen.boundHowToPlay.overlaps(pointer)){
			game.batch.draw(Assets.howtoplay_onclick, screen.x, screen.y-120);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				Gdx.app.log("Screen", "To How to play screen");
				screen.dispose();
				game.setScreen(new HowToPlayScreen(game));
			}
		}
		else if(screen.boundCredit.overlaps(pointer)){
			game.batch.draw(Assets.credit_onclick, screen.x, screen.y-240);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				Gdx.app.log("Screen", "To Credit screen");
				screen.dispose();
//				game.setScreen(new CreditScreen(game));
			}
		}
		else if(screen.boundExit.overlaps(pointer)){
			game.batch.draw(Assets.exit_onclick, screen.x, screen.y-360);
			if(Gdx.input.isButtonPressed(0)) {
				Assets.click.play();
				Gdx.app.log("App", "Exit");
				Gdx.app.exit();
			}
		}
	}
}

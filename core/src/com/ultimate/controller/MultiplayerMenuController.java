package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.CreateServerScreen;
import com.ultimate.screen.JoinServerScreen;
import com.ultimate.screen.MainMenuScreen;
import com.ultimate.screen.MultiplayerMenuScreen;

public class MultiplayerMenuController extends GameController {

	MultiplayerMenuScreen screen;
	
	public MultiplayerMenuController(UltimateFight game, MultiplayerMenuScreen screen){
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
		pointer.setSize(2, 2);
	}
	
	public void update(){
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		
		if(screen.boundCreateServer.overlaps(pointer)){
			game.batch.draw(Assets.creategame_onclick, (Gdx.graphics.getWidth()/2)-(screen.width/2), screen.y);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "To Create server screen");
				game.setScreen(new CreateServerScreen(game));
			}

		}
		else if(screen.boundJoinServer.overlaps(pointer)){
			game.batch.draw(Assets.joingame_onclick, (Gdx.graphics.getWidth()/2)-(screen.width/2), screen.y-120);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "To JoinServer screen");
				game.setScreen(new JoinServerScreen(game));
			}

		}
		else if(screen.boundBack.overlaps(pointer)){
			game.batch.draw(Assets.back_onclick, 30, 30);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "To Mainmenu screen");
				try {Thread.sleep(70);} catch (InterruptedException e) {}
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
}

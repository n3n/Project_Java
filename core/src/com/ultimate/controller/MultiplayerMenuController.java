package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameClient;
import com.ultimate.screen.CreateServerScreen;
import com.ultimate.screen.GameScreen;
import com.ultimate.screen.MainMenuScreen;
import com.ultimate.screen.MultiplayerMenuScreen;

public class MultiplayerMenuController extends GameController {

	MultiplayerMenuScreen screen;
	
	public MultiplayerMenuController(UltimateFight game, MultiplayerMenuScreen screen){
		this.game = game;
		this.screen = screen;
		
	}
	
	public void update(){
		x = Gdx.input.getX();
		y = Gdx.input.getY();
		pointer = new Rectangle(x, y, 2, 2);
		
		screen.fontCreateServer.setColor(Color.BLACK);
		screen.fontJoinServer.setColor(Color.BLACK);
		screen.fontBack.setColor(Color.BLACK);
		
		if(screen.boundCreateServer.overlaps(pointer)){
			screen.fontCreateServer.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new CreateServerScreen(game));
			}

		}
		else if(screen.boundJoinServer.overlaps(pointer)){
			screen.fontJoinServer.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0)){
//				game.setScreen(new JoinServerScreen(game));
				game.client = new GameClient(game, "127.0.0.1");
				game.setScreen(new GameScreen(game));
			}

		}
		else if(screen.boundBack.overlaps(pointer)){
			screen.fontBack.setColor(Color.BLUE);
			if(Gdx.input.isButtonPressed(0)){
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}
}

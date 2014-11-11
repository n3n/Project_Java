package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameServer;
import com.ultimate.screen.CreateServerScreen;
import com.ultimate.screen.GameScreen;
import com.ultimate.unit.Ace;

public class CreateServerController extends GameController {

	UltimateFight game;
	CreateServerScreen screen;
	
	public CreateServerController(UltimateFight game, CreateServerScreen screen){
		this.game = game;
		this.screen = screen;
		System.out.println("Hello");
	}
	
	public void update() {
		x = Gdx.input.getX();
		y = Gdx.input.getY();
		pointer = new Rectangle(x, y, 2, 2);
		
		if(Gdx.input.isKeyPressed(Keys.M)){
			game.server = new GameServer(game);
			game.setScreen(new GameScreen(game));
			System.out.println("Start Server");
		}
		else if(Gdx.input.isKeyPressed(Keys.A)){
			game.player.setJob(new Ace());
		}
	}

}

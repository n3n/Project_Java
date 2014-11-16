package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameServer;
import com.ultimate.screen.CreateServerScreen;
import com.ultimate.screen.EnterNameScreen;
import com.ultimate.screen.MultiplayerMenuScreen;

public class CreateServerController extends GameController {

	UltimateFight game;
	CreateServerScreen screen;
	
	public CreateServerController(UltimateFight game, CreateServerScreen screen){
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
		pointer.setSize(2, 2);
	}
	
	public void update() {
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		
		if(screen.boundCreate.overlaps(pointer)){
			game.batch.draw(Assets.create_onclick, (Gdx.graphics.getWidth()/2)-(215/2), (Gdx.graphics.getHeight()/2)-215, 220, 65);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Event", "Create game server");
				game.server = new GameServer(game);
				game.setScreen(new EnterNameScreen(game));
			}
		}
		else if(screen.boundLeft.overlaps(pointer)){
			game.batch.draw(Assets.left_onclick, ((Gdx.graphics.getWidth()/2)/2)-60, (Gdx.graphics.getHeight()/2)-15);
			if(Gdx.input.isButtonPressed(0)){
				try {Thread.sleep(100);} catch (InterruptedException e) {}
				Assets.click.play();
			}
		}
		else if(screen.boundRight.overlaps(pointer)){
			game.batch.draw(Assets.right_onclick, (Gdx.graphics.getWidth()/2)+200, (Gdx.graphics.getHeight()/2)-15);
			if(Gdx.input.isButtonPressed(0)){
				try {Thread.sleep(100);} catch (InterruptedException e) {}
				Assets.click.play();
			}
		}
		else if(screen.boundBack.overlaps(pointer)){
			game.batch.draw(Assets.back_onclick, 30, 30);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "To Multiplayer menu screen");
				game.setScreen(new MultiplayerMenuScreen(game));
			}
		}
		
//		if(Gdx.input.isKeyPressed(Keys.M)){
//			game.server = new GameServer(game);
//			game.setScreen(new GameScreen(game));
//			System.out.println("Start Server");
//		}
//		else if(Gdx.input.isKeyPressed(Keys.A)){
//			game.player.setJob(new Ace());
//		}
	}

}

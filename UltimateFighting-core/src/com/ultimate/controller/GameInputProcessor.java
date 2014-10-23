package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameServer;

public class GameInputProcessor {

	UltimateFight game;

	public GameInputProcessor(UltimateFight game){
		this.game = game;
	}

	public void update(){
		processor();
	}

	public void processor(){
		if(Gdx.input.isKeyPressed(Keys.A) && !game.player.character.isAction){
			game.player.character.isRun = true;
			game.player.character.isRight = false;
			game.player.character.position.x -= 2;
		}
		else if(Gdx.input.isKeyPressed(Keys.D) && !game.player.character.isAction){
			game.player.character.isRun = true;
			game.player.character.isRight = true;
			game.player.character.position.x += 2;
		}
		else if(Gdx.input.isKeyPressed(Keys.W) && !game.player.character.isAction){

		}
		else if(Gdx.input.isKeyPressed(Keys.S) && !game.player.character.isAction){

		}
		else if(Gdx.input.isKeyPressed(Keys.SPACE) && !game.player.character.isAction){

		}
		else if(Gdx.input.isKeyPressed(Keys.J) && !game.player.character.isAction){
			game.player.character.isAction = true;
			new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(100);
						game.player.character.position.x += 2;
						Thread.sleep(100);
						game.player.character.position.x += 2;
						Thread.sleep(100);
						game.player.character.position.x += 2;
						Thread.sleep(400);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					game.player.character.isAction = false;
				}
			}).start();
		}
		else if(Gdx.input.isKeyPressed(Keys.K) && !game.player.character.isAction){

		}
		else{
			game.player.character.isRun = false;
		}

		//		GameServer.sendToAllConnention(game.player);
	}
}

package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameClient;
import com.ultimate.network.GameServer;

public class MainMenuScreen implements Screen{
	
	UltimateFight game;
	
	public MainMenuScreen(UltimateFight game) {
		this.game = game;
	}
	
	public void render(float delta) {
		if(Gdx.input.isKeyPressed(Keys.S)){
			System.out.println("Start singleplayer");
			game.setScreen(new GameScreen(game));
			this.dispose();
		}
		else if(Gdx.input.isKeyPressed(Keys.M)){
			System.out.println("Start multiplayer");
			game.server = new GameServer(game);
			game.setScreen(new GameScreen(game));
			this.dispose();
		}
		else if(Gdx.input.isKeyPressed(Keys.J)){
			System.out.println("Connecting to server");
			game.client = new GameClient(game, "127.0.0.1");
			game.setScreen(new GameScreen(game));
			this.dispose();
		}
		
	}

	public void resize(int width, int height) {
				
	}

	public void show() {
		
	}

	public void hide() {
		
	}

	public void pause() {
		
	}

	public void resume() {
		
	}

	public void dispose() {
		
	}

}

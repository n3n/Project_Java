package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.MultiplayerMenuController;
import com.ultimate.game.UltimateFight;

public class MultiplayerMenuScreen extends ScreenBase {
	UltimateFight game;
	
	public BitmapFont fontCreateServer;
	public BitmapFont fontJoinServer;
	public BitmapFont fontBack;
	
	public Rectangle boundCreateServer;
	public Rectangle boundJoinServer;
	public Rectangle boundBack;
	
	MultiplayerMenuController controller;
	
	public MultiplayerMenuScreen(UltimateFight game){
		this.game = game;
		controller = new MultiplayerMenuController(game, this);
		
		// Font
		fontCreateServer = getFont();
		fontJoinServer = getFont();
		fontBack = getFont();
		// Rectangle
		boundCreateServer = new Rectangle((Gdx.graphics.getWidth()/2)-90, 165, 240, 40);
		boundJoinServer = new Rectangle((Gdx.graphics.getWidth()/2)-90, 265 , 100, 40);
		boundBack = new Rectangle((Gdx.graphics.getWidth()/2)-90, 365, 100, 40);
	}
	
	public void render(float delta) {

//		if(Gdx.input.isKeyPressed(Keys.L)){
//			game.setScreen(new JoinServerScreen(game));
//			game.client = new GameClient(game, "127.0.0.1");
//			game.setScreen(new GameScreen(game));
//		}
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		controller.update();
		game.batch.begin();
		fontCreateServer.draw(game.batch, "Create Server", (Gdx.graphics.getWidth()/2)-100, (Gdx.graphics.getHeight()/2)+100);
		fontJoinServer.draw(game.batch, "Join Server", (Gdx.graphics.getWidth()/2)-100, (Gdx.graphics.getHeight()/2));
		game.batch.end();
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

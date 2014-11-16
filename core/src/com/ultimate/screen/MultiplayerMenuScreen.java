package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.MultiplayerMenuController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class MultiplayerMenuScreen extends ScreenBase {
	UltimateFight game;
	
	public Rectangle boundCreateServer;
	public Rectangle boundJoinServer;
	public Rectangle boundBack;
	
	public int width = 220;
	public int height = 89;
	public int x = (Gdx.graphics.getWidth()/2)-(width/2);
	public int y = 300;
	
	MultiplayerMenuController controller;
	
	public MultiplayerMenuScreen(UltimateFight game){
		this.game = game;
		controller = new MultiplayerMenuController(game, this);
		
		// Rectangle
		boundCreateServer = new Rectangle(x, (Gdx.graphics.getHeight()-y)-height, width, height);
		boundJoinServer = new Rectangle(x, (Gdx.graphics.getHeight()-(y-120))-height , width, height);
		try {Thread.sleep(100);}catch (InterruptedException e) {}
		boundBack = new Rectangle(30, (Gdx.graphics.getHeight()-30)-58, 68, 58);
		
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(Assets.bg, 0, 0);
		game.batch.draw(Assets.creategame, x, y);
		game.batch.draw(Assets.joingame, x, y-120);
		game.batch.draw(Assets.back, 30, 30);
		controller.update();
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
		boundBack = null;
		boundCreateServer = null;
		boundJoinServer = null;
		controller = null;
	}

}

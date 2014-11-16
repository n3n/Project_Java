package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.MainMenuController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class MainMenuScreen extends ScreenBase implements Screen{
	
	UltimateFight game;
	
	public Rectangle boundMultiplayer;
	public Rectangle boundHowToPlay;
	public Rectangle boundExit;
	public Rectangle boundCredit;
	
	public int x = 450;
	public int y = 400;
	public int width = 220;
	public int height = 89;
	MainMenuController controller;

	
	
	public MainMenuScreen(UltimateFight game) {
		this.game = game;
		controller = new MainMenuController(game, this);
		
		boundMultiplayer = new Rectangle( x, (Gdx.graphics.getHeight()-y)-height, width, height);
		boundHowToPlay = new Rectangle( x, (Gdx.graphics.getHeight()-(y-120))-height, width, height);
		boundCredit = new Rectangle( x, (Gdx.graphics.getHeight()-(y-240))-height, width, height);
		boundExit = new Rectangle( x, (Gdx.graphics.getHeight()-(y-360))-height, width, height);
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		game.batch.begin();
		
		// draw bg
		game.batch.draw(Assets.bg, 0, 0, 760, 540);
		game.batch.draw(Assets.logo, 47, 110);
		game.batch.draw(Assets.multiplayer, x, 400);
		game.batch.draw(Assets.howtoplay, x, 280);
		game.batch.draw(Assets.credit, x, 160);
		game.batch.draw(Assets.exit, x, 40);
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
		boundMultiplayer = null;
		boundHowToPlay = null;
		boundExit = null;
		boundCredit = null;
		controller = null;
	}

}

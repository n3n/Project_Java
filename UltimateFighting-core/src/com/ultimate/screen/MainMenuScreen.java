package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.MainMenuController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class MainMenuScreen extends ScreenBase implements Screen{
	
	UltimateFight game;
	
	public BitmapFont fontMultiplayer;
	public BitmapFont fontHowToPlay;
	public BitmapFont fontExit;
	
	public Rectangle boundMultiplayer;
	public Rectangle boundHowToPlay;
	public Rectangle boundExit;
	
	MainMenuController controller;
	
	public MainMenuScreen(UltimateFight game) {
		this.game = game;
		controller = new MainMenuController(game, this);
		
		fontMultiplayer = getFont();
		fontHowToPlay = getFont();
		fontExit = getFont();
		
		boundMultiplayer = new Rectangle((Gdx.graphics.getWidth()/2)-90, 165, 240, 40);
		boundHowToPlay = new Rectangle((Gdx.graphics.getWidth()/2)-90, 265 , 100, 40);
		boundExit = new Rectangle((Gdx.graphics.getWidth()/2)-90, 365, 100, 40);
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		controller.update();
		
		game.batch.begin();
		// draw bg
		game.batch.draw(Assets.bg_mainMenu, 0, 0, 760, 540);
		// draw font type
		fontMultiplayer.draw(game.batch, "Multiplayer", (Gdx.graphics.getWidth()/2)-100, (Gdx.graphics.getHeight()/2)+100);
		fontHowToPlay.draw(game.batch, "How to play", (Gdx.graphics.getWidth()/2)-100, (Gdx.graphics.getHeight()/2));
		fontExit.draw(game.batch, "Exit", (Gdx.graphics.getWidth()/2)-100, (Gdx.graphics.getHeight()/2)-100);
		
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

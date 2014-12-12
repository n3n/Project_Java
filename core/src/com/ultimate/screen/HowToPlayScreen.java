package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.HowToPlayController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class HowToPlayScreen extends ScreenBase {

	UltimateFight game;
	HowToPlayController controller;
	public Rectangle boundBack;
	
	public HowToPlayScreen(UltimateFight game){
		this.game = game;
		controller = new HowToPlayController(game, this);
		boundBack = new Rectangle(30, (Gdx.graphics.getHeight()-30)-58, 68, 58);
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(Assets.howtoplay_bg,0 ,0);
		game.batch.draw(Assets.back, 30, 30);
		controller.update();
		game.batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

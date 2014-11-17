package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.JoinServerController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class JoinServerScreen extends ScreenBase {
	
	UltimateFight game;
	JoinServerController controller;
	public Rectangle boundJoin;
	public Rectangle boundBack;
	public int width = Gdx.graphics.getWidth()/2;
	public BitmapFont loading = genFont();

	public JoinServerScreen(UltimateFight game){
		this.game = game;
		game.server = null;
		game.client = null;
		boundJoin = new Rectangle(width-(Assets.join.getWidth()/2), (Gdx.graphics.getHeight())-(Gdx.graphics.getHeight()-380)-89, 220, 89);
		boundBack = new Rectangle(30, (Gdx.graphics.getHeight()-30)-58, 68, 58);
		controller = new JoinServerController(game, this);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(Assets.bg, 0, 0);
		game.batch.draw(Assets.ipaddress, width-(Assets.ipaddress.getWidth()/2), Gdx.graphics.getHeight()-115);
		game.batch.draw(Assets.nametag, (Gdx.graphics.getWidth()/2)-200, Gdx.graphics.getHeight()-240, 400, 60);
		game.batch.draw(Assets.join, width-(Assets.join.getWidth()/2), Gdx.graphics.getHeight()-380);
		game.batch.draw(Assets.back, 30, 30);
		controller.update();
		game.batch.end();
	}

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
		controller = null;
//		boundJoin = null;
		boundBack = null;
		loading = null;
	}

}

package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.CreateServerController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class CreateServerScreen extends ScreenBase {

	UltimateFight game;
	CreateServerController controller;
	
	public int width = 220;
	public int height = 89;
	public int x = (Gdx.graphics.getWidth()/2)-(width/2);
	public int y = 300;
	
	public Rectangle boundBack;
	public Rectangle boundCreate;
	public Rectangle boundLeft;
	public Rectangle boundRight;
	public String name;
	public CreateServerScreen(UltimateFight game){
		this.game = game;
		controller = new CreateServerController(game, this);
		
		boundCreate = new Rectangle((Gdx.graphics.getWidth()/2)-(215/2), (Gdx.graphics.getHeight()-(Gdx.graphics.getHeight()/2))+155, 220, 61);
		boundLeft = new Rectangle(((Gdx.graphics.getWidth()/2)/2)-60, (Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/2)+75)), 46, 89);
		boundRight = new Rectangle((Gdx.graphics.getWidth()/2)+200, (Gdx.graphics.getHeight()-((Gdx.graphics.getHeight()/2)+75)), 46, 89);
		boundBack = new Rectangle(30, (Gdx.graphics.getHeight()-30)-58, 68, 58);
		
	}
	
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.draw(Assets.bg, 0, 0);
		game.batch.draw(Assets.battleselect, (Gdx.graphics.getWidth()/2)-(Assets.battleselect.getWidth()/2), Gdx.graphics.getHeight()-100);
		game.batch.draw(Assets.left, ((Gdx.graphics.getWidth()/2)/2)-60, (Gdx.graphics.getHeight()/2)-15);
		game.batch.draw(Assets.create, (Gdx.graphics.getWidth()/2)-(215/2), (Gdx.graphics.getHeight()/2)-215, 220, 65);
		game.batch.draw(Assets.right, (Gdx.graphics.getWidth()/2)+200, (Gdx.graphics.getHeight()/2)-15);
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
		controller = null;
		boundBack = null;
		boundCreate = null;
		boundLeft = null;
		boundRight = null;
		name = null;
	}

}

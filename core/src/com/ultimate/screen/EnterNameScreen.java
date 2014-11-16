package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.controller.EnterNameController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class EnterNameScreen extends ScreenBase{
	
	UltimateFight game;
	EnterNameController controller;
	public Rectangle boundPlay;
	
	public EnterNameScreen(UltimateFight game){
		this.game = game;
		controller = new EnterNameController(game, this);
		font.setColor(Color.BLACK);
		param.size = 10;
		boundPlay = new Rectangle((Gdx.graphics.getWidth()/2)-(Assets.play.getWidth()/2), Gdx.graphics.getHeight()-150-89, 220, 89);
	}
	
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.bg, 0, 0);
		game.batch.draw(Assets.entername, (Gdx.graphics.getWidth()/2)-(Assets.play.getWidth()/2), 450);
		game.batch.draw(Assets.play, (Gdx.graphics.getWidth()/2)-(Assets.play.getWidth()/2), 150);
		game.batch.draw(Assets.nametag, (Gdx.graphics.getWidth()/2)-250, 300, 500, 60);
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
		boundPlay = null;
	}

}

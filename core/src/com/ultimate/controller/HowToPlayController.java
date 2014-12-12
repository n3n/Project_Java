package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.HowToPlayScreen;
import com.ultimate.screen.MainMenuScreen;

public class HowToPlayController extends GameController {

	UltimateFight game;
	HowToPlayScreen screen;
	
	public HowToPlayController(UltimateFight game, HowToPlayScreen screen) {
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
		pointer.setSize(0, 0);
	}

	@Override
	public void update() {
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		if(screen.boundBack.overlaps(pointer)){
			game.batch.draw(Assets.back_onclick, 30, 30);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "To Main menu screen");
				game.setScreen(new MainMenuScreen(game));
			}
		}
	}

}

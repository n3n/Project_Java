package com.ultimate.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.EnterNameScreen;
import com.ultimate.screen.GameScreen;

public class EnterNameController extends GameController{
	
	UltimateFight game;
	EnterNameScreen screen;
	KeyInputProcessor inputProcess;
	
	public EnterNameController(UltimateFight game, EnterNameScreen screen){
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
		pointer.setSize(0, 0);
		game.player.setInGame(false);
		inputProcess = new KeyInputProcessor();
		Gdx.input.setInputProcessor(inputProcess);
		
	}
	
	
	public void update() {
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		screen.getFont().draw(game.batch, inputProcess.getStr(), (Gdx.graphics.getWidth()/2)-200, 345);
		if(pointer.overlaps(screen.boundPlay)){
			game.batch.draw(Assets.play_onclick, (Gdx.graphics.getWidth()/2)-(Assets.play.getWidth()/2), 150);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				game.player.setName(inputProcess.getStr());
				game.setScreen(new GameScreen(game));
			}
		}
	}

}

package com.ultimate.controller;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.GameClient;
import com.ultimate.screen.EnterNameScreen;
import com.ultimate.screen.JoinServerScreen;
import com.ultimate.screen.MultiplayerMenuScreen;

public class JoinServerController extends GameController {
	
	UltimateFight game;
	JoinServerScreen screen;
	KeyInputProcessor inputProcess;
	String loading = "Loading";
	int isConnect = 0;
	boolean connecting = false;
	
	public JoinServerController(UltimateFight game, JoinServerScreen screen){
		this.game = game;
		this.screen = screen;
		pointer = new Rectangle();
		pointer.setSize(2, 2);
		inputProcess = new KeyInputProcessor();
		inputProcess.setEnablePoint(true);
		inputProcess.setMaxLength(25);
		Gdx.input.setInputProcessor(inputProcess);
		screen.setFont(5);
		screen.getFont().setColor(Color.BLACK);
		screen.loading.setColor(Color.BLACK);
		game.client = new GameClient(game);
	}
	
	public void update(){
		
		pointer.setPosition(Gdx.input.getX(), Gdx.input.getY());
		screen.getFont().draw(game.batch, inputProcess.getStr(), (Gdx.graphics.getWidth()/2)-180, Gdx.graphics.getHeight()-195);
		if(isConnect == 1){
			screen.dispose();
			try {Thread.sleep(50);} catch (InterruptedException e) {}
			game.setScreen(new EnterNameScreen(game));
		}
		if(screen.boundJoin.overlaps(pointer)){
			game.batch.draw(Assets.join_onclick, screen.width-(Assets.join.getWidth()/2), Gdx.graphics.getHeight()-380);
			try {Thread.sleep(100);} catch (InterruptedException e) {}
			if(Gdx.input.isButtonPressed(0) && !connecting){
				Assets.click.play();
				game.client.setIP(inputProcess.getStr());
				
				new Thread(){
					public void run(){
							try {
								game.client.tryConnect();
								isConnect = 1;
								return;
							} catch (IOException e){
								isConnect = -1;
								return;
							}
					}
				}.start();
			}
		}else if(screen.boundBack.overlaps(pointer)){
			game.batch.draw(Assets.back_onclick, 30, 30);
			if(Gdx.input.isButtonPressed(0)){
				Assets.click.play();
				screen.dispose();
				Gdx.app.log("Screen", "Back to Multiplayer menu screen");
				try {Thread.sleep(50);} catch (InterruptedException e) {}
				game.setScreen(new MultiplayerMenuScreen(game));
			}
		}
	}
}

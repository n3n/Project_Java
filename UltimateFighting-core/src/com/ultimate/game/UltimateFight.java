package com.ultimate.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.network.GameClient;
import com.ultimate.network.GameServer;
import com.ultimate.screen.MainMenuScreen;

public class UltimateFight extends Game implements ApplicationListener {
	
	public SpriteBatch batch;
	public static Player player;
	public GameServer server;
	public GameClient client;
	
	float stateTime = 0;
	TextureRegion currentFrame;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		Assets.load();
	}

	@Override
	public void render () {
		super.render();
		setScreen(new MainMenuScreen(this));
//		setScreen(new GameScreen(this));
	}
}

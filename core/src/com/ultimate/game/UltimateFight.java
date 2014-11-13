package com.ultimate.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ultimate.network.GameClient;
import com.ultimate.network.GameServer;
import com.ultimate.network.GameWorld;
import com.ultimate.screen.MainMenuScreen;

public class UltimateFight extends Game implements ApplicationListener {
	
	public SpriteBatch batch;
	public Player player;
	public GameServer server;
	public GameClient client;
	public GameWorld world;
	
	public void create() {
		batch = new SpriteBatch();
		player = new Player();
		Assets.load();
		this.setScreen(new MainMenuScreen(this));
	}

	public void render() {
		super.render();
	}
	
	
}

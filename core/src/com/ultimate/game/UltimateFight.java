package com.ultimate.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ultimate.network.GameClient;
import com.ultimate.network.GameServer;
import com.ultimate.network.GameWorld;
import com.ultimate.screen.LoadingScreen;

public class UltimateFight extends Game implements ApplicationListener {
	
	public SpriteBatch batch;
	public Player player;
	public GameServer server;
	public GameClient client;
	public GameWorld world;
	public Sound sound_bg;
	
	public Sound getSound_bg() {
		return sound_bg;
	}

	public void setSound_bg(Sound sound_bg) {
		this.sound_bg = sound_bg;
	}

	public void create() {
		batch = new SpriteBatch();
		player = new Player();
		this.setScreen(new LoadingScreen(this));
	}

	public void render() {
		super.render();
	}
	
	
}

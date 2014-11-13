package com.ultimate.screen;


import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.controller.GameCheckCollision;
import com.ultimate.controller.GameInputProcessor;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.StateTime;

public class GameScreen extends ScreenBase implements Screen{
	UltimateFight game;
	TextureRegion keyFrame;
	public static float stateTime = 0;
	TextureRegion currentFrame;
	GameInputProcessor inputProcess;
	GameCheckCollision checkCollision;
	public GameScreen(UltimateFight game){
		this.game = game;
		inputProcess = new GameInputProcessor(game);
		if(game.server != null){
			checkCollision = new GameCheckCollision(game);
		}
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		game.batch.begin();
		inputProcess.update();
		game.batch.draw(Assets.map_1, 0, 0);
		game.player.setStateTime(stateTime);
		try{
			Iterator<Player> players = game.world.getPlayers();
			while(players.hasNext()){
				final Player player = (Player) players.next();
//				
				if(game.server != null){
					game.world.checkColision(player);
					checkCollision.run();
					game.server.sendToAllConnention(player);			
				}
				else if(game.client != null){
					game.client.sendData(game.player);
				}
				game.world.renderer.render(player);
			}
		}catch(Exception e){
			
		}
		
		game.batch.end();
		
		try {
			Thread.sleep((long)(1000/50-Gdx.graphics.getDeltaTime()));
		} catch (InterruptedException e) {
//			e.printStackTrace();
		}
	}
	
	public void update(float delta) {
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

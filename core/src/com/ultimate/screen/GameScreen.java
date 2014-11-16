package com.ultimate.screen;


import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.controller.GameCheckCollision;
import com.ultimate.controller.GameInputProcessor;
import com.ultimate.controller.ServerProcessing;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.Ace;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;

public class GameScreen extends ScreenBase implements Screen{
	
	UltimateFight game;
	GameInputProcessor inputProcess;
	ServerProcessing serverProcess;
	BitmapFont name;
	private boolean isDead = false;
	public GameScreen(UltimateFight game){
		this.game = game;
		inputProcess = new GameInputProcessor(game);
		if(game.server != null){
			serverProcess = new ServerProcessing(game);
		}
		setFont(2);
		game.player.setInGame(true);
		font.setColor(1f, 1f, 1f, 1f);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		inputProcess.update();
		game.batch.draw(Assets.map_1, 0, 0);
		
		
		if(Gdx.input.isKeyJustPressed(Keys.Z)){
			game.player.setJob(new Luffy());
		}
		
		try{
			Iterator<Player> players = game.world.getPlayers();
			while(players.hasNext()){
				Player player = (Player) players.next();
				if(game.server != null){
					game.world.checkColision(player);
					serverProcess.update();
					game.server.sendToAllConnention(player);
				}
				else
					game.client.sendData(game.player);
				game.world.renderer.render(player);
			}
		}catch(Exception e){}
		update();
		game.batch.end();
		
		Framerate.run();
	}
	
	public void update() {
		game.player.setStateTime(game.player.getStateTime() + Gdx.graphics.getDeltaTime());
		game.batch.draw(Assets.blood_tunk, 30, 475);
		if((game.player.character.getHp() <= 0 || game.player.character.getPosition().y <= -200) && !isDead){
			isDead = true;
			game.player.character.getPosition().y = -300;
			new Thread(new Runnable() {
				public void run() {
					for(int i=0;i<3;i++) try {Thread.sleep(1000);} catch (InterruptedException e) {}
					game.player.setJob(randomSpawn());
					if(game.server != null) game.server.sendToAllConnention(game.player);
					else game.client.sendData(game.player);
					isDead = false;
				}
			}).start();
		}
	}
	
	public JobClass randomSpawn(){
		isDead = false;
		switch (1+(int)(Math.random()*2)) {
		case 1: return new Luffy();
		default: return new Luffy();
		}
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

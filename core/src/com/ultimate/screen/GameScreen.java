package com.ultimate.screen;


import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.math.Vector2;
import com.ultimate.controller.GameInputProcessor;
import com.ultimate.controller.ServerProcessing;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.DisconnectPacket;
import com.ultimate.unit.Ace;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;
import com.ultimate.unit.Map;

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
		game.player.setJob(randomSpawn());
		game.player.setInGame(true);
		font.setColor(1f, 1f, 1f, 1f);
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		inputProcess.update();
		game.batch.draw(Map.map_id[game.world.getMapID()], 0, 0);
		
		
		if(Gdx.input.isKeyJustPressed(Keys.Z)){
			game.player.setJob(randomSpawn());
		}else if(Gdx.input.isKeyJustPressed(Keys.X)){
			game.player.character.getDmg();
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
		if(game.world.isEnd()){
			this.dispose();
			game.setScreen(new MainMenuScreen(game));
		}
	}
	
	public void update() {
		game.player.setStateTime(game.player.getStateTime() + Gdx.graphics.getDeltaTime());
		
		int blood_width = (int)((game.player.character.getHp()/100)*24.6);
		
		game.batch.draw(Assets.blood, 82, 487, blood_width, 17);
		if(game.player.character instanceof Luffy)game.batch.draw(Assets.blood_luffy, 30, 475);
		else if(game.player.character instanceof Ace)game.batch.draw(Assets.blood_ace, 30, 475);
		
		
		if((game.player.character.getHp() <= 0 || game.player.character.getPosition().y <= -200) && !isDead){
			isDead = true;
			game.player.character.setHp(0);
			new Thread(new Runnable() {
				public void run() {
					game.player.character.setSTATE(JobClass.STATE_DEAD);
					if(true){
						new Thread(){
							public void run(){
								for(int i=0;i<60;i++) {
									try {Thread.sleep(50);} catch (InterruptedException e) {}
									game.player.character.setSTATE(JobClass.STATE_DEAD);
								}
								game.player.character.setSTATE(JobClass.STATE_DEAD);
								game.player.setJob(randomSpawn());
								if(game.server != null) game.server.sendToAllConnention(game.player);
								else game.client.sendData(game.player);
								isDead = false;
							}
						}.start();
					}
				}
			}).start();
		}
	}
	
	public JobClass randomSpawn(){
		isDead = false;
		JobClass character;
		int num = 1+(int)(Math.random()*2);
		System.out.println(num);
		switch (num) {
			case 1: 
				character = new Luffy();
				break;
			case 2: 
				character = new Ace();
				break;
			default: 
				character = new Luffy();
				break;
		}
		Vector2 pos = randomPos();
		character.setPosition(pos.x, pos.y);
		return character;
	}
	
	public Vector2 randomPos(){
		int length = game.world.getMap().getSpawnPos().length;
		int randomVal = (int)(Math.random()*length-1);
		return game.world.getMap().getSpawnPos()[randomVal];
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

	public void pause() {
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		if(game.client != null){
			DisconnectPacket packet = new DisconnectPacket();
			packet.setID(game.player.getPlayerID());
			game.client.sendData(packet);
		}else if(game.server != null){
			game.server.getServer().stop();
			game.server = null;
			inputProcess = null;
			serverProcess = null;
			name = null;
			game.world = null;
			game.player.character = null;
		}
	}

}

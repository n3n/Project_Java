package com.ultimate.network;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.GameScreen;
import com.ultimate.unit.Ace;
import com.ultimate.unit.GameObject;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;
import com.ultimate.unit.Skill;
import com.ultimate.unit.Vegeta;
/**
 * 
 * @author FallenGo
 * @version 1.0
 * Game Client
 */
public class GameClient {
	private Client client;
	private int port = 52227;
	UltimateFight game;
	private String ipAddress = "";
	public GameClient(final UltimateFight game){
		
		this.game = game;
		
		// Initial game world
		game.world = new GameWorld(game);
		
		// Initial game client
		client = new Client();
		registerKryonet();
		
		// Add listener to client
		initListener();
		
		// Start client
		client.start();
		
		game.world.addPlayer(game.player.getPlayerID(), game.player);
		

		

//		try {
//			client.sendUDP(game.player);
//			System.out.println("Send!");
//		} catch (Exception e) {
//			System.out.println("Can't connected");
//		}
	}
	
	public void tryConnect() throws IOException{
		client.connect(10000, ipAddress, port, port);
	}
	
	public void setIP(String ip){
		this.ipAddress = ip;
	}
	
	public String getIP(){
		return this.ipAddress;
	}
	
	public void sendData(Object object){
		try {
			client.sendUDP(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Add listener to client for receive data from server
	 */
	public void initListener(){
		client.addListener(new Listener() {
			public void received (Connection connection, Object data) {
				if(data instanceof Player) {
					Player player = (Player)data;
//					System.out.println("Player: ("+player.character.getPosition().x+", "+player.character.getPosition().y+")");
					game.world.addPlayer(player.getPlayerID(), player);
				}
			}
		});
	}
	
	private void registerKryonet(){
		client.getKryo().register(Player.class);
		client.getKryo().register(Vegeta.class);
		client.getKryo().register(Ace.class);
		client.getKryo().register(Luffy.class);
		client.getKryo().register(JobClass.class);
		client.getKryo().register(GameObject.class);
		client.getKryo().register(Vector2.class);
		client.getKryo().register(Rectangle.class);
		client.getKryo().register(Skill.class);
	}
}

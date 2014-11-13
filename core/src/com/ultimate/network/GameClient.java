package com.ultimate.network;

import java.io.IOException;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
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
	
	public GameClient(final UltimateFight game, String ipAddress){
		
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
		
		// Try connect to server
		try {
			client.connect(5000, ipAddress, port, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		try {
			client.sendUDP(game.player);
			System.out.println("Send!");
		} catch (Exception e) {
			System.out.println("Can't connected");
		}
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

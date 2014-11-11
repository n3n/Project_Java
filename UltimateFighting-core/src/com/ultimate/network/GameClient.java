package com.ultimate.network;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.SkillObject;
/**
 * 
 * @author FallenGo
 * @version 1.0
 * Game Client
 */
public class GameClient {
	private Client client;
	int port = 52227;
	String ipAddress;
	UltimateFight game;
	
	public GameClient(final UltimateFight game, String ipAddress){
		this.ipAddress = ipAddress;
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
			if(object instanceof SkillObject){
				System.out.println("Send! " + (object instanceof SkillObject));
			}
			Log.DEBUG();
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
				else if(data instanceof SkillObject){
					
				}
			}
		});
	}
	
	private void registerKryonet(){
		client.getKryo().register(com.ultimate.game.Player.class);
		client.getKryo().register(com.ultimate.unit.Vegeta.class);
		client.getKryo().register(com.ultimate.unit.Ace.class);
		client.getKryo().register(com.ultimate.unit.Luffy.class);
		client.getKryo().register(com.ultimate.unit.JobClass.class);
		client.getKryo().register(com.ultimate.unit.GameObject.class);
		client.getKryo().register(com.badlogic.gdx.math.Vector2.class);
		client.getKryo().register(com.badlogic.gdx.math.Rectangle.class);
		client.getKryo().register(com.ultimate.unit.SkillObject.class);
		client.getKryo().register(com.ultimate.controller.GameCheckCollision.class);
		client.getKryo().register(com.ultimate.game.UltimateFight.class);
		client.getKryo().register(com.ultimate.network.GameWorld.class);
	}
}

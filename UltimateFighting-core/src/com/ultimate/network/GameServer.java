package com.ultimate.network;

import java.io.IOException;
import java.util.ArrayList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.SkillObject;

/**
 * 
 * @author FallenGo
 * @version 1.0
 * Game Server
 */
public class GameServer {
	
	static Server server;
	int port = 52227;
	private ArrayList<Integer> idList; // Keep connection id 
	UltimateFight game;
	
	public GameServer(final UltimateFight game){
		System.out.println("Create server");
		idList = new ArrayList<Integer>();
		this.game = game;
		game.world = new GameWorld(game);
		game.world.addPlayer(game.player.getPlayerID(), game.player);
		
		// Initial game server
		server = new Server();
		registerKryonet();
		// add listener to server
		initListener(); 
		// Try bind port
		try {
			server.bind(port, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Start server
		server.start();
	}
	
	public void sendToAllConnention(Player player){
		server.sendToAllUDP(player);
	}
	
	/**
	 *  Add listener to server
	 */
	private void initListener(){
		server.addListener(new Listener() {
			public void received (Connection connection, Object data) {
				/* Receive player object*/
				if (data instanceof Player) {
					Player player = (Player)data;
					game.world.addPlayer(player.getPlayerID(), player);
				}
				/* Receive material object */
				if(data instanceof SkillObject){
					SkillObject object = (SkillObject)data;
					game.world.addObject(object);
					System.out.println("Receive object");
				}
//				System.out.println(data instanceof SkillObject);
//				System.out.println(data.getClass());
			}
			public void connected(Connection connection){
				System.out.println("Has connected");
			}
		});
	}
	
	private void registerKryonet(){
		server.getKryo().register(com.ultimate.game.Player.class);
		server.getKryo().register(com.ultimate.unit.Vegeta.class);
		server.getKryo().register(com.ultimate.unit.Ace.class);
		server.getKryo().register(com.ultimate.unit.Luffy.class);
		server.getKryo().register(com.ultimate.unit.JobClass.class);
		server.getKryo().register(com.ultimate.unit.GameObject.class);
		server.getKryo().register(com.badlogic.gdx.math.Vector2.class);
		server.getKryo().register(com.badlogic.gdx.math.Rectangle.class);
		server.getKryo().register(com.ultimate.unit.SkillObject.class);
		server.getKryo().register(com.ultimate.controller.GameCheckCollision.class);
		server.getKryo().register(com.ultimate.game.UltimateFight.class);
		server.getKryo().register(com.ultimate.network.GameWorld.class);
	}
}

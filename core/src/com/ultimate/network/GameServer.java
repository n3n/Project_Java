package com.ultimate.network;

import java.io.IOException;
import java.util.ArrayList;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
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
	
	public void sendToAllConnention(Object object){
		server.sendToAllUDP(object);
		server.sendToAllTCP(object);
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
				if(data instanceof Skill){
					Skill object = (Skill)data;
					game.world.addObject(object);
				}
			}
			public void connected(Connection connection){
				System.out.println("Has connected");
			}
		});
	}
	
	private void registerKryonet(){
		server.getKryo().register(Player.class);
		server.getKryo().register(Vegeta.class);
		server.getKryo().register(Ace.class);
		server.getKryo().register(Luffy.class);
		server.getKryo().register(JobClass.class);
		server.getKryo().register(GameObject.class);
		server.getKryo().register(Vector2.class);
		server.getKryo().register(Rectangle.class);
		server.getKryo().register(Skill.class);
	}
}

package com.ultimate.network;

import java.io.IOException;
import java.util.ArrayList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.GameObject;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Vegeta;


public class GameServer {
	
	static Server server;
	int port = 52227;
	private ArrayList<Integer> idList; // Keep connection id 
	
	public GameServer(final UltimateFight game){
		System.out.println("Create server");
		idList = new ArrayList<Integer>();
		
		// Initial game server
		server = new Server();
		server.getKryo().register(Player.class);
		server.getKryo().register(com.ultimate.unit.Vegeta.class);
		server.getKryo().register(com.ultimate.unit.JobClass.class);
		server.getKryo().register(com.ultimate.unit.GameObject.class);
		server.getKryo().register(com.badlogic.gdx.math.Vector2.class);
		server.getKryo().register(com.badlogic.gdx.math.Rectangle.class);
		
		// Try bind port
		try {
			server.bind(port, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Start server
		server.start();
		
		// Add listener to server
		server.addListener(new Listener() {
			public void received (Connection connection, Object packetData) {
				if (packetData instanceof Player) {
					System.out.println("Received!");
				}
			}
			public void connected(Connection connection){
				System.out.println("Someone has connected!");
			}
		});
		System.out.println("Completed!");
	}
	
	public static void sendToAllConnention(Player player){
		server.sendToAllUDP(player);
	}
}

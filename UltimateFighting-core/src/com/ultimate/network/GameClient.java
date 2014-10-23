package com.ultimate.network;

import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.GameObject;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Vegeta;

public class GameClient {
	Client client;
	int port = 52227;
	String ipAddress;
	UltimateFight game;
	
	public GameClient(final UltimateFight game, String ipAddress){
		
		System.out.println("Connecting...");
		this.ipAddress = ipAddress;
		
		// Initial game client
		client = new Client();
		client.getKryo().register(Player.class);
		client.getKryo().register(com.ultimate.unit.Vegeta.class);
		client.getKryo().register(com.ultimate.unit.JobClass.class);
		client.getKryo().register(com.ultimate.unit.GameObject.class);
		client.getKryo().register(com.badlogic.gdx.math.Vector2.class);
		client.getKryo().register(com.badlogic.gdx.math.Rectangle.class);
		
		// Start client
		client.start();
		
		// Try connect to server
		try {
			client.connect(5000, ipAddress, port, port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Add listener to client for receive data from server
		client.addListener(new Listener() {
			public void received (Connection connection, Object packetData) {
				if(packetData instanceof Player) {
					System.out.println("Client received!");
					Player player = (Player)packetData;
				}
			}
		});
		try {
			client.sendUDP(game.player);
			System.out.println("Send!");
		} catch (Exception e) {
			System.out.println("Can't connected");
		}
	}
	
	public void sendData(Player player){
		System.out.println("Sending...!");
		try {
			client.sendUDP(player);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnected(Player player){
		try {
			client.sendUDP(player);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}

package com.ultimate.network;

import java.util.Iterator;

import com.badlogic.gdx.utils.Array;
import com.ultimate.game.Player;

public class GameWorld {
	private Array<Player> players;
	
	public GameWorld(){
		players = new Array<Player>();
	}
	
	public void addPlayer(Player player){
		Iterator<Player> IterPlayer = players.iterator();
		while(IterPlayer.hasNext()){
			Player oldPlayer = (Player)IterPlayer.next();
			if( oldPlayer.getPlayerID() == player.getPlayerID() ){
				return;
			}
		}
		players.add(player);
		System.out.println("New player has joined");
	}
	
	public Iterator<Player> getPlayers(){
		return players.iterator();
	}
	
}

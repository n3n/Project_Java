package com.ultimate.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.badlogic.gdx.Gdx;
import com.ultimate.controller.WorldRenderer;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.Map;
import com.ultimate.unit.Skill;

public class GameWorld {
	private TreeMap<Integer, Player> players;
	private TreeMap<Integer, Skill> objects;
	public UltimateFight game;
	public WorldRenderer renderer;
	public int map_id;
	private Map map;
	private boolean isEnd = false;
	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	private int skillID = 1;
	private int time = 0;
	
	public GameWorld(UltimateFight game){
		players = new TreeMap<Integer, Player>();
		renderer = new WorldRenderer(game);
		objects = new TreeMap<Integer, Skill>();
		this.game = game;
	}
	
	public void addPlayer(int id, Player player){
		
		try{
			Player temp = players.get(id);
			if(game.server != null){
				if( (player.getHP() < temp.getHP()) || (temp.getHP() <= 0 && player.getHP() == 1000) ){
					players.put(id, player);
				}else{
					players.put(id, player);
				}
			}
			else{
				
				if(player.character.getHp() < temp.character.getHp()){
					game.player.setKill(player.getKill());
					game.player.setDead(player.getDead());
					players.put(id, player);
				}
				else if(player.getPlayerID() == game.player.getPlayerID()){
					if(player.character.getHp() < game.player.character.getHp()){
						game.player.character.setHp(player.character.getHp());
						game.player.setKill(player.getKill());
						game.player.setDead(player.getDead());
						players.put(id, player);
//						System.out.println("You are under attack! | HP: " + game.player.character.getHp());
					}
					else if(player.character.getHp() >= 0){
						game.player.setKill(player.getKill());
						game.player.setDead(player.getDead());
						players.put(id, player);
					}
					else{
						System.out.println("...");
					}
				}else{
//					System.out.println("ELSE");
					players.put(id, player);
				}
			}
			
		}catch(Exception e){
			if(game.server != null){
				players.put(id, player);
			}
			players.put(id, player);
		}
		
	}
	
	public void setMapID(int map){
		this.map_id = map;
		this.map = Map.object_id[map];
//		System.out.println("Map: " + this.map);
	}
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public int getMapID(){
		return map_id;
	}
	
	public TreeMap<Integer, Player> getPlayersMap(){
		return players;
	}
	
	public void removePlayer(int id){
		try{
			if(!players.containsKey(id)) return; 
			
			if(game.server != null){
				DisconnectPacket packet = new DisconnectPacket();
				packet.setID(id);
				game.server.sendToAllConnention(packet);
				Gdx.app.log("Disconnect", players.get(id).getName()+" has left the game");
				players.remove(id);
				Gdx.app.log("Disconnect", "Success");
			}
			
		}catch(Exception e){}
	}
	
	public Iterator<Player> getPlayers(){
		ArrayList<Player> arrayPlayers = new ArrayList<Player>(); 
		for(int id: players.keySet())
			arrayPlayers.add(players.get(id));
		return arrayPlayers.iterator();
	}
	
	public int getSize(){
		return players.size();
	}
	
	public boolean checkColision(Player player){
		Iterator<Player> iterPlayers = getPlayers();
		while(iterPlayers.hasNext()){
			Player eachPlayer = (Player)iterPlayers.next();
			if(eachPlayer.getPlayerID() != player.getPlayerID() && eachPlayer.character.getBounds().overlaps(player.character.getBounds())){
				return true;
			}
		}
		return false;
	}

	public void addObject(Skill object){
		object.setId(skillID++);
		objects.put(object.getId(), object);
	}

	public void removeObject(int id){
		objects.remove(id);
	}

	public Iterator<Skill> getObjects(){
		ArrayList<Skill> arrayObjects = new ArrayList<Skill>(); 
		for(int id: objects.keySet())
			arrayObjects.add(objects.get(id));
		return arrayObjects.iterator();
	}
	
	public TreeMap<Integer, Skill> getObjectMap(){
		return objects;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getTime(){
		return time;
	}
}
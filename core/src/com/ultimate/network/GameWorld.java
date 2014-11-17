package com.ultimate.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.sun.xml.internal.org.jvnet.fastinfoset.ExternalVocabulary;
import com.ultimate.controller.WorldRenderer;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Map;
import com.ultimate.unit.Skill;

public class GameWorld {
	private TreeMap<Integer, Player> players;
	private TreeMap<Integer, Skill> objects;
	public UltimateFight game;
	public WorldRenderer renderer;
	public Map map;
	private int skillID = 1;
	
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
//				System.out.printf("Server: Player: %s, HP: %s\n",player.getPlayerID(), player.character.getHp());
//				System.out.printf("Server: Temp: %s, HP: %s\n",player.getPlayerID(), player.character.getHp());
			}else{
//				System.out.printf("Client: Player: %s, HP: %s\n",player.getPlayerID(), player.character.getHp());
//				System.out.printf("Client: Temp: %s, HP: %s\n",player.getPlayerID(), player.character.getHp());
//				System.out.printf("Client: Player: %s, HP: %s | Temp: %s\n",player.getPlayerID(), player.character.getHp(), temp.character.getHp());
			}
			if(game.server != null){
				players.put(id, player);
			}
			else{
				System.out.printf("C|P:%s-HP:%s | T: %s\n",player.getPlayerID(), player.character.getHp(), temp.character.getHp());
				if(player.character.getHp() < temp.character.getHp()){
					System.out.println("##########################################################################################");
					players.put(id, player);
				}
				else if(player.getPlayerID() == game.player.getPlayerID() && player.character.getHp() != 0){
					game.player.character.setHp(player.character.getHp());
					players.put(id, player);
					System.out.println("HP: "+player.character.getHp());
				}else{
					players.put(id, player);
				}
			}
			
		}catch(Exception e){
			if(game.server != null){
				System.out.printf("Put: Player: %s, HP: %s\n",player.getPlayerID(), player.character.getHp());
				players.put(id, player);
			}
			e.printStackTrace();
			players.put(id, player);
		}
		
	}
	
	public void setMap(Map map){
		this.map = map;
	}
	
	public TreeMap<Integer, Player> getPlayersMap(){
		return players;
	}
	
	public void removePlayer(int id){
		players.remove(id);
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
			if(eachPlayer.character.getHp() <= 0){
//				getPlayersMap().get(eachPlayer.getPlayerID()).character.setSTATE(JobClass.STATE_DEAD);
			}
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
//		System.out.println("Remove");
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
}
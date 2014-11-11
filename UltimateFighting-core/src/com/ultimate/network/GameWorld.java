package com.ultimate.network;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.ultimate.controller.WorldRenderer;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.Map;
import com.ultimate.unit.SkillObject;

public class GameWorld {
	private TreeMap<Integer, Player> players;
	private TreeMap<Integer, SkillObject> objects;
	public UltimateFight game;
	public WorldRenderer renderer;
	public Map map;
	private int skillID = 1;
	
	public GameWorld(UltimateFight game){
		players = new TreeMap<Integer, Player>();
		renderer = new WorldRenderer(game);
		objects = new TreeMap<Integer, SkillObject>();
		this.game = game;
	}
	
	public void addPlayer(int id, Player player){
		players.put(id, player);
	}
	
	public void setMap(Map map){
		this.map = map;
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
			if(eachPlayer.getPlayerID() != player.getPlayerID() && eachPlayer.character.bounds.overlaps(player.character.bounds)){
				return true;
			}
		}
		return false;
	}

	public void addObject(SkillObject object){
		object.setID(skillID++);
		objects.put(object.getID(), object);
	}

	public void removeObject(int id){
		
		objects.remove(id);
	}

	public Iterator<SkillObject> getObjects(){
		ArrayList<SkillObject> arrayObjects = new ArrayList<SkillObject>(); 
		for(int id: objects.keySet())
			arrayObjects.add(objects.get(id));
		return arrayObjects.iterator();
	}
}
package com.ultimate.controller;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Skill;
import com.ultimate.unit.SkillObject;

public class GameCheckCollision extends Thread{
	
	UltimateFight game;
	
	public GameCheckCollision(UltimateFight game){
		this.game = game;
		System.out.println("Start collision");
	}
	
	public void run(){

		
		while(game.server != null || game.client != null){
			try{
				Iterator<Skill> objects = game.world.getObjects();
				while(objects.hasNext()){
					Skill object = objects.next();
						Iterator<Player> players = game.world.getPlayers();
						while(players.hasNext()){
							Player player = players.next();
							if((player.getPlayerID() != object.getPlayer_id()) && object.getBounds().overlaps(player.character.getBounds())){
								System.out.println("Player: "+player.getPlayerID()+" was attacked by player: "+object.getPlayer_id());
								player.character.setSTATE(JobClass.STATE_HURT);
								game.world.addPlayer(player.getPlayerID(), player);;
							}
						}
					switch (object.getType()) {
						case SkillObject.TYPE_ATK:
							game.world.removeObject(object.getId());
							break;
						default:
							break;
					}
				}
			}
			catch(ConcurrentModificationException e){
				
			}
		}
	}
}

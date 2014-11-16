package com.ultimate.controller;

import java.util.ConcurrentModificationException;

import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Skill;

public class GameCheckCollision{
	
	UltimateFight game;
	
	public GameCheckCollision(UltimateFight game){
		this.game = game;
	}
	
	public void run(){
			try{
				for(int skill_id: game.world.getObjectMap().keySet()){
					final Skill object = game.world.getObjectMap().get(skill_id);
					
					for(int player_id: game.world.getPlayersMap().keySet()){
						final Player player = game.world.getPlayersMap().get(player_id);
						if((player.getPlayerID() != object.getPlayer_id()) && object.getBounds().overlaps(player.character.getBounds()) && !object.isPassed()){
//							System.out.println("Player: "+player.getPlayerID()+" was attacked by player: "+object.getPlayer_id());
//							System.out.println("Player: " + player.getPlayerID());
//							game.world.getPlayersMap().get(player.getPlayerID()).character.setHp(game.world.getPlayersMap().get(player.getPlayerID()).character.getHp()-100);
//							float hp = game.world.getPlayersMap().get(player.getPlayerID()).character.getHp();
//							game.world.getPlayersMap().get(player.getPlayerID()).character.setHp(hp- 100);
							game.world.getPlayersMap().get(player.getPlayerID()).character.getDmg();
							Player aa = game.world.getPlayersMap().get(player.getPlayerID());
							System.out.println("HP: " + aa.character.getHp());
							aa.character.getDmg();
							System.out.println("HP: " + aa.character.getHp());
							game.server.sendToAllConnention(game.world.getPlayersMap().get(player.getPlayerID()));
//							System.out.println(game.world.getPlayersMap().get(player.getPlayerID()).character.getHp());
							new Thread(){
								public void run(){
									game.player.setStateTime(0);
									try {
										for(int i=1;i<=600;i++){
											game.world.getPlayersMap().get(player.getPlayerID()).character.setSTATE(JobClass.STATE_HURT);
											if(i%20 == 0) {
												if(object.getTurn() == -1) {
													
													game.world.getPlayersMap().get(player.getPlayerID()).character.moveLeft(4);
													if(GameInputProcessor.collision()){
														game.player.character.moveRight(4);
														break;
													}
												}
												if(object.getTurn() == 1) {
													game.world.getPlayersMap().get(player.getPlayerID()).character.moveRight(4);
													System.out.println();
													if(GameInputProcessor.collision()){
														game.player.character.moveLeft(4);
														break;
													}
												}
												game.world.getPlayersMap().get(player.getPlayerID()).character.moveDown(4);
												if(GameInputProcessor.collision()) game.player.character.moveUp(4);
											}
											game.world.getPlayersMap().get(player.getPlayerID()).character.setAction(true);
											Thread.sleep(1);
										}
										game.world.getPlayersMap().get(player.getPlayerID()).character.setAction(false);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}.start();
						}
					}
					switch (object.getType()) {
						case Skill.TYPE_FORWARD_ATK:
							game.world.removeObject(object.getId());
							break;
						case Skill.TYPE_ATK:
							game.world.removeObject(object.getId());
							break;
					}
				}
			}
			catch(ConcurrentModificationException e){
				e.printStackTrace();
			}catch(NullPointerException e){
				e.printStackTrace();
			}
	}
}

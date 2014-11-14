package com.ultimate.controller;

import java.util.ConcurrentModificationException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Luffy;
import com.ultimate.unit.Skill;

public class ServerProcessing {
	private Vector2 pointer;
	UltimateFight game;
	
	public ServerProcessing(UltimateFight game){
		this.game = game;
		pointer = new Vector2();
	}
	
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY());
		fallCheck();
	}
	
	private void fallCheck(){
		for(int id: game.world.getPlayersMap().keySet()){
			if(game.world.getPlayersMap().get(id).character.getPosition().y <= -200){
				game.world.getPlayersMap().get(id).setJob(new Luffy());
			}
		}
	}
	
	private void collisionProcess(){
		try{
			for(int skill_id: game.world.getObjectMap().keySet()){
				final Skill object = game.world.getObjectMap().get(skill_id);
				
				for(int player_id: game.world.getPlayersMap().keySet()){
					final Player player = game.world.getPlayersMap().get(player_id);
					if((player.getPlayerID() != object.getPlayer_id()) && object.getBounds().overlaps(player.character.getBounds()) && !object.isPassed()){
						System.out.println("Player: "+player.getPlayerID()+" was attacked by player: "+object.getPlayer_id());
						game.world.getPlayersMap().get(player.getPlayerID()).character.setHp(game.world.getPlayersMap().get(player.getPlayerID()).character.getHp()-100);
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
												}
											}
											if(object.getTurn() == 1) {
												game.world.getPlayersMap().get(player.getPlayerID()).character.moveRight(4);
												if(GameInputProcessor.collision()){
													game.player.character.moveLeft(4);
												}
											}
//											game.world.getPlayersMap().get(player.getPlayerID()).character.moveDown(4);
//											if(GameInputProcessor.collision()) game.player.character.moveUp(4);
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
					case Skill.LUFFY_FORWORD_ATK:
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
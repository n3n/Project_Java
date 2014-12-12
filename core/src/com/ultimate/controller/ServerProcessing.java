package com.ultimate.controller;

import java.util.ConcurrentModificationException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.cntTimePacket;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Skill;

public class ServerProcessing {
	
	private Vector2 pointer;
	UltimateFight game;
	private int cntTime = 60;
	
	public int getCntTime() {
		return cntTime;
	}

	public void setCntTime(int cntTime) {
		this.cntTime = cntTime;
	}

	public ServerProcessing(final UltimateFight game){
		this.game = game;
		pointer = new Vector2();
		new Thread(){
			public void run(){
				while(!game.world.isEnd()){
					try {Thread.sleep(1000);} catch (InterruptedException e) {}
					game.world.setTime(cntTime);
//					System.out.println(game.world.getTime());
					cntTimePacket packet = new cntTimePacket();
					packet.setTime(cntTime);
					game.server.sendToAllConnention(packet);
					if(cntTime-- <= 0) {
//						game.world.setEnd(true);
					}
				}
			}
		}.start();
	}
	
//	public void ranking(){
//	
//	}
	
	public void update(){
		pointer.set(Gdx.input.getX(), Gdx.input.getY());
		atk();
	}
	
	private void atk(){
		try{
			for(int skill_id: game.world.getObjectMap().keySet()){
				Skill object = game.world.getObjectMap().get(skill_id);
				for(int player_id: game.world.getPlayersMap().keySet()){
					Player player = game.world.getPlayersMap().get(player_id);
					if(player.character.getBounds().overlaps(object.getBounds()) && player.getPlayerID() != object.getPlayer_id() && player.character.getHp() > 0 ){
						player.character.setSTATE(JobClass.STATE_HURT);
						player.character.setHp(player.character.getHp()-100);
						if(player.character.isRight()) 
							player.character.getPosition().x += 4;
						else 
							player.character.getPosition().x -= 4;
						if(player.getHP() <= 0){
							Player killer = game.world.getPlayersMap().get(object.getPlayer_id());
							killer.increaseKill();
							game.world.addPlayer(killer.getPlayerID(), killer);
							game.server.sendToAllConnention(killer);
							player.increaseDead();
							System.out.println("Player: "+player.getName()+", Kill: "+player.getKill()+", Dead: "+player.getDead());
							System.out.println("Killer: "+killer.getName()+", Kill: "+killer.getKill()+", Dead: "+killer.getDead());
						}
						game.world.addPlayer(player.getPlayerID(), player);
						game.server.sendToAllConnention(player);
						System.out.printf("Player: %d was attacked, HP: %f\n", player.getPlayerID(), game.world.getPlayersMap().get(player_id).character.getHp());
					}
				}
				game.world.removeObject(skill_id);
			}
		}catch(ConcurrentModificationException e){
			
		}
	}
}

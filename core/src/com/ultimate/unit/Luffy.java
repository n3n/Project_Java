package com.ultimate.unit;

import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;
import com.ultimate.network.StateTime;
import com.ultimate.screen.GameScreen;

public class Luffy extends JobClass {

	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	public static final int timeForwardAtk = 210;

	public Luffy() {
		super(60, 60, WIDTH, HEIGHT);
		setHp(10000);
		setMp(100);
		setDef(100);
		setmDef(100);
		setAtk(100);
		setmAtk(100);
		setSpeed(10);
		setGravity(1.5f);
		setType(2);
	}
	
	public void atk1(final UltimateFight game){
		new Thread(new Runnable() {
			public void run() {
				game.player.setStateTime(0);
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.player.character.setSTATE(JobClass.STATE_STAND);
				game.player.character.setAction(false);
			}
		}).start();
	}
	
	public void atk2(final UltimateFight game){
		new Thread(new Runnable() {
			public void run() {
				try {
					
					if(!game.player.character.isRight()){
						
						game.player.setStateTime(0f);
						Thread.sleep(300);
						
						game.player.character.moveLeft(110);
						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x-30, game.player.character.getPosition().y);
						object.setBounds(game.player.character.getPosition().x, game.player.character.getPosition().y, 140, 70);
						object.setPlayer_id(game.player.getPlayerID());
						object.setType(Skill.TYPE_ATK);
						object.setTurn(-1);
						if(game.server != null){
							game.world.addObject(object);
						}
						else if(game.client != null){
							game.client.sendData(object);
						}
						Thread.sleep(150);
						game.player.character.moveRight(110);
					}
					else{
						game.player.setStateTime(0);
						Thread.sleep(300);
						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x+140, game.player.character.getPosition().y);
						object.setBounds(game.player.character.getPosition().x, game.player.character.getPosition().y, 140, 70);
						object.setPlayer_id(game.player.getPlayerID());
						object.setType(Skill.LUFFY_FORWORD_ATK);
						object.setTurn(1);
						if(game.server != null){
							game.world.addObject(object);
						}
						else if(game.client != null){
							game.client.sendData(object);
						}
						Thread.sleep(150);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				game.player.character.setSTATE(JobClass.STATE_STAND);
				game.player.character.setAction(false);
			}
		}).start();
	}

	public void atk3(UltimateFight game) {
	}

	@Override
	public void atk4(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void block(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}
}

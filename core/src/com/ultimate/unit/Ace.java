package com.ultimate.unit;

import com.ultimate.game.UltimateFight;
import com.ultimate.screen.GameScreen;

public class Ace extends JobClass {

	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	
	public Ace() {
		super(0, 0, WIDTH, HEIGHT);
		setHp(10000);
		setMp(100);
		setDef(100);
		setmDef(100);
		setAtk(100);
		setmAtk(100);
		setSpeed(10);
		setGravity(1.5f);
		setType(3);
	}
	
	public void atk1(final UltimateFight game){
		new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(400);
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
						Thread.sleep(500);
//						game.player.character.moveLeft(110);
//						SkillObject object = new SkillObject(game.player.character.position.x - 100, game.player.character.position.y - 100, 100, 40);
//						object.setOwner_id(game.player.getPlayerID());
//						object.setType(1);
						if(game.server != null){
//							game.world.addObject(object);
						}
						else if(game.client != null){
//							game.client.sendData(object);
						}
						Thread.sleep(210);
//						game.player.character.moveRight(110);
						
					}
					else{
						Thread.sleep(710);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				game.player.character.setSTATE(JobClass.STATE_STAND);
				game.player.character.setAction(false);
			}
		}).start();
	}

	@Override
	public void atk3(UltimateFight game) {
		// TODO Auto-generated method stub
		
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

package com.ultimate.unit;

import com.ultimate.game.UltimateFight;

public class Ace extends JobClass {

	public static int WIDTH = 50;
	public static int HEIGHT = 50;

	public Ace() {
		super(50, 50, WIDTH, HEIGHT);
		setHp(1000);
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
				game.player.setStateTime(0);
				try {
					Thread.sleep(20);
					Skill object = new Skill();
					object.setPlayer_id(game.player.getPlayerID());
					object.setType(Skill.TYPE_ATK);
					if(!game.player.character.isRight()){ // Left side
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 20, 70);
						object.setTurn(-1);
					}
					else{ // Right side
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 60, 70);
						object.setTurn(1);
					}
					if(game.server != null){
						game.world.addObject(object);
					}
					else if(game.client != null){
						game.client.sendData(object);
					}
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
					if(!game.player.character.isRight()){ // Left side

						game.player.setStateTime(0f);
						Thread.sleep(500);

						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 40, 70);
						object.setPlayer_id(game.player.getPlayerID());
						object.setType(Skill.TYPE_FORWARD_ATK);
						object.setTurn(-1);
						if(game.server != null){
							game.world.addObject(object);
						}
						else if(game.client != null){
							game.client.sendData(object);
						}
						Thread.sleep(150);
					}
					else{ // Right
						game.player.setStateTime(0);
						Thread.sleep(300);
						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 80, 70);
						object.setPlayer_id(game.player.getPlayerID());
						object.setType(Skill.TYPE_FORWARD_ATK);
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

package com.ultimate.unit;

import com.ultimate.game.UltimateFight;

public class Luffy extends JobClass {

	public static int WIDTH = 50;
	public static int HEIGHT = 50;

	public Luffy() {
		super(60, 60, WIDTH, HEIGHT);
		setHp(1000);
		setMp(100);
		setDef(100);
		setmDef(100);
		setAtk(100);
		setmAtk(100);
		setSpeed(10);
		setGravity(1.5f);
		setType(2);
		setSTATE(JobClass.STATE_STAND);
	}

	public void atk1(final UltimateFight game){ //j
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
						object.setBounds(object.getPosition().x, object.getPosition().y, 70, 70);
						object.setTurn(1);
					}
					if(game.server != null){
						game.world.addObject(object);
					}
					else if(game.client != null){
						game.client.sendData(object);
					}
					Thread.sleep(220);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				game.player.character.setSTATE(JobClass.STATE_STAND);
				game.player.character.setAction(false);
			}
		}).start();
	}

	public void atk2(final UltimateFight game){ //K
		new Thread(new Runnable() {
			public void run() {
				try {

					if(!game.player.character.isRight()){ // Left side

						game.player.setStateTime(0f);
						Thread.sleep(300);

						game.player.character.moveLeft(110);
						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 120, 70);
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
						game.player.character.moveRight(110);
					}
					else{ // Right
						game.player.setStateTime(0);
						Thread.sleep(300);
						Skill object = new Skill();
						object.setPosition(game.player.character.getPosition().x, game.player.character.getPosition().y);
						object.setBounds(object.getPosition().x, object.getPosition().y, 150, 70);
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

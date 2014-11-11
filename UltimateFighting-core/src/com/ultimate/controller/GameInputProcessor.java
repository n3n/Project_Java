package com.ultimate.controller;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.GameScreen;
import com.ultimate.unit.Box;
import com.ultimate.unit.JobClass;
import com.ultimate.unit.Map;
import com.ultimate.unit.Map_1;

public class GameInputProcessor {

	UltimateFight game;
	Map map;
	
	public GameInputProcessor(UltimateFight game){
		this.game = game;
		map = new Map_1();
	}

	public void update(){
		processor();
	}

	public void processor(){
		
		if(!game.player.character.isAction()){
			game.player.character.setSTATE(JobClass.STATE_STAND);
			game.player.character.setAction(false);
		}
		if(Gdx.input.isKeyPressed(Keys.J)){
			atk1();
		}
		else if(Gdx.input.isKeyPressed(Keys.SPACE)){
			jump();
		}
		else if(Gdx.input.isKeyPressed(Keys.A) ){
			moveLeft();
		}
		else if(Gdx.input.isKeyPressed(Keys.D) ){
			moveRight();
		}
		//		GameServer.sendToAllConnention(game.player);
	}
	
	private boolean collision(){
		Iterator<Box> objects = map.getObject().iterator();
		while(objects.hasNext()){
			Box object = (Box) objects.next();
			if(object.bounds.overlaps(game.player.character.bounds)){
				System.out.println("Collision detected!!");
				return true;
			}
		}
		return false;
	}
	
	private void moveLeft(){
		if(!game.player.character.isAction()){
			game.player.character.setSTATE(JobClass.STATE_RUN);
			game.player.character.setRight(false);
			game.player.character.moveLeft(game.player.character.getSpeed());
			if(collision()){
				game.player.character.moveRight(game.player.character.getSpeed());
			}
			if(Gdx.input.isKeyPressed(Keys.K)){
				atkForward();
			}
			else if(Gdx.input.isKeyPressed(Keys.J)){
				atk1();
			}
			else if(Gdx.input.isKeyPressed(Keys.SPACE)){
				jump();
			}
			
		}
		else if((game.player.character.getSTATE() == JobClass.STATE_JUMP_DOWN || game.player.character.getSTATE() == JobClass.STATE_JUMP_UP) && Gdx.input.isKeyPressed(Keys.A)){
			game.player.character.moveLeft(game.player.character.getSpeed() - ( (game.player.character.getSpeed() * 70)/100 ) );
			if(collision()){
				game.player.character.moveRight(game.player.character.getSpeed());
			}
		}
	}
	
	private void moveRight(){
		if(!game.player.character.isAction()){
			game.player.character.setSTATE(JobClass.STATE_RUN);
			game.player.character.setRight(true);
			game.player.character.moveRight(game.player.character.getSpeed());
			if(collision()){
				game.player.character.moveLeft(game.player.character.getSpeed());
			}
			if(Gdx.input.isKeyPressed(Keys.K)){
				atkForward();
			}
			else if(Gdx.input.isKeyPressed(Keys.J)){
				atk1();
			}
			else if(Gdx.input.isKeyPressed(Keys.SPACE)){
				jump();
			}
		}
		else if( (game.player.character.getSTATE() == JobClass.STATE_JUMP_DOWN || game.player.character.getSTATE() == JobClass.STATE_JUMP_UP) && Gdx.input.isKeyPressed(Keys.D)){
			game.player.character.moveRight(game.player.character.getSpeed() - ( (game.player.character.getSpeed() * 70)/100 ) );
			if(collision()){
				game.player.character.moveLeft(game.player.character.getSpeed());
			}
		}

	}
	
	private void atk1(){
		if(!game.player.character.isAction() && Gdx.input.isKeyPressed(Keys.J)){
			GameScreen.stateTime = 0;
			game.player.character.setSTATE(JobClass.STATE_ATK1);
			game.player.character.setAction(true);
			game.player.character.atk1(game);
		}
	}
	
	private void atkForward(){
		if(!game.player.character.isAction() && Gdx.input.isKeyPressed(Keys.K)){
			GameScreen.stateTime = 0;
			game.player.character.setSTATE(JobClass.STATE_ATK2);
			game.player.character.setAction(true);
			game.player.character.atk2(game);
		}
	}
	
	private void jump(){
		if(Gdx.input.isKeyPressed(Keys.SPACE) && !game.player.character.isAction() && game.player.character.getSTATE() != JobClass.STATE_JUMP_DOWN && game.player.character.getSTATE() != JobClass.STATE_JUMP_UP){
			GameScreen.stateTime = 0;
			game.player.character.setAction(true);
			new Thread(new Runnable(){
				public void run(){
					try{
						game.player.character.setSTATE(JobClass.STATE_JUMP_UP);
						for(int i = 1; i <= 30; i++){
							Thread.sleep(15);
							moveRight();
							moveLeft();
							game.player.character.moveUp(3);
						}
						game.player.character.setSTATE(JobClass.STATE_JUMP_DOWN);
						for(int i = 1; i <= 30; i++){
							Thread.sleep(15);
							moveRight();
							moveLeft();
							game.player.character.moveDown(4);
							if(collision()){
								game.player.character.moveUp(4);
								break;
							}
						}
						
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					game.player.character.setSTATE(JobClass.STATE_STAND);
					game.player.character.setAction(false);
				}
			}).start();
		}
	}
	
	
}

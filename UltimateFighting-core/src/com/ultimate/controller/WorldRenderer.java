package com.ultimate.controller;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.game.Animation2;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.GameScreen;
import com.ultimate.unit.JobClass;

public class WorldRenderer {
	
	UltimateFight game;
	
	public WorldRenderer(UltimateFight game){
		this.game = game;
	}
	
	public void render(Player player){
		TextureRegion keyFrame = null;
		switch(player.character.getType()){
			case 1: // Vegeta
				switch(player.character.getSTATE()){
					case JobClass.STATE_RUN:
						keyFrame = Assets.vegetaRun.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.vegetaAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.vegetaStand.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
				}
			break;
				
			case 2: // Luffy
				switch(player.character.getSTATE()){
					case JobClass.STATE_RUN:
						keyFrame = Assets.luffyRun.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.luffyAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.luffyStand.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_UP:
						keyFrame = Assets.luffyJumpUp.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_DOWN:
						keyFrame = Assets.luffyJumpDown.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK2:
						keyFrame = Assets.luffyForwardAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
				}
				break;
			case 3: // Ace
				switch (player.character.getSTATE()) {
					case JobClass.STATE_RUN:
						keyFrame = Assets.aceRun.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.aceAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.aceStand.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_UP:
						keyFrame = Assets.aceJumpUp.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_DOWN:
						keyFrame = Assets.aceJumpDown.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK2:
						keyFrame = Assets.aceForwardAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
						break;
				}
				break;
		}
		if(player.character.isRight()){
			if(keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.position.x, player.character.position.y);
		}
		else{
			if(!keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.position.x, player.character.position.y);
		}
		
	}
	
	public void renderMe(){
		
	}
}

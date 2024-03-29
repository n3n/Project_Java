package com.ultimate.controller;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.game.Animation2;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
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
						keyFrame = Assets.vegetaRun.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.vegetaAtk.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.vegetaStand.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
				}
			break;
				
			case 2: // Luffy
				switch(player.character.getSTATE()){
					case JobClass.STATE_RUN:
						keyFrame = Assets.luffyRun.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.luffyAtk.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.luffyStand.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_UP:
						keyFrame = Assets.luffyJumpUp.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_DOWN:
						keyFrame = Assets.luffyJumpDown.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK2:
						keyFrame = Assets.luffyForwardAtk.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_HURT:
						keyFrame = Assets.luffyHurt.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_NONLOOPING);
						break;
					case JobClass.STATE_DEAD:
						keyFrame = Assets.luffyDead.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_NONLOOPING);
						break;
				}
				break;
			case 3: // Ace
				switch (player.character.getSTATE()) {
					case JobClass.STATE_RUN:
						System.out.println(player.getStateTime());
						keyFrame = Assets.aceRun.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK1:
						keyFrame = Assets.aceAtk.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_STAND:
						keyFrame = Assets.aceStand.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_UP:
						keyFrame = Assets.aceJumpUp.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_JUMP_DOWN:
						keyFrame = Assets.aceJumpDown.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_ATK2:
						keyFrame = Assets.aceForwardAtk.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_LOOPING);
						break;
					case JobClass.STATE_HURT:
						keyFrame = Assets.aceHurt.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_NONLOOPING);
						break;
					case JobClass.STATE_DEAD:
						keyFrame = Assets.aceDead.getKeyFrame(player.getStateTime() , Animation2.ANIMATION_NONLOOPING);
						break;
				}
				break;
		}
		if(player.character.isRight()){
			if(keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.getPosition().x, player.character.getPosition().y);
		}
		else{
			if(!keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.getPosition().x, player.character.getPosition().y);
		}
		BitmapFont name;
		name = new BitmapFont();
		name.scale(0.01f);
		name.setColor(1f, 1f, 1f, 1f);
		name.draw(game.batch, player.getName(), player.character.getPosition().x-20, player.character.getPosition().y+70);
		
	}
	
	public void renderMe(){
		
	}
}

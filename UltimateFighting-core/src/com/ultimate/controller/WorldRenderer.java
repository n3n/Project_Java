package com.ultimate.controller;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.game.Animation2;
import com.ultimate.game.Assets;
import com.ultimate.game.Player;
import com.ultimate.game.UltimateFight;
import com.ultimate.screen.GameScreen;

public class WorldRenderer {
	
	UltimateFight game;
	
	public WorldRenderer(UltimateFight game){
		this.game = game;
	}
	
	public void render(Player player){
		TextureRegion keyFrame;
		if(player.character.isRun){
			keyFrame = Assets.vegetaRun.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
		}
		else if(player.character.isAction){
			keyFrame = Assets.vegetaAtk.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
		}
		else{
			keyFrame = Assets.vegetaStand.getKeyFrame(GameScreen.stateTime , Animation2.ANIMATION_LOOPING);
		}
		if(player.character.isRight){
			if(keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.position.x + 0.5f, player.character.position.y - 0.5f);
		}
		else{
			if(!keyFrame.isFlipX()) keyFrame.flip(true, false);
			game.batch.draw(keyFrame, player.character.position.x - 0.5f, player.character.position.y - 0.5f);
		}
		
	}
	
	public void renderMe(){
		
	}
}

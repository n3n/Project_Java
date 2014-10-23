package com.ultimate.screen;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ultimate.controller.GameInputProcessor;
import com.ultimate.controller.WorldRenderer;
import com.ultimate.game.UltimateFight;

public class GameScreen implements Screen{
	UltimateFight game;
	TextureRegion keyFrame;
	public static float stateTime = 0;
	TextureRegion currentFrame;
	WorldRenderer gameWorld;
	GameInputProcessor inputProcess;
	public GameScreen(final UltimateFight game){
		this.game = game;
		inputProcess = new GameInputProcessor(game);
		gameWorld = new WorldRenderer(game);
		
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
        game.batch.begin();
        inputProcess.update();
        gameWorld.render(game.player);
        game.batch.end();
	}
	
	public void update(float delta) {
		if(Gdx.input.isKeyPressed(Keys.J) && !UltimateFight.player.character.isAction){
			UltimateFight.player.character.isAction = true;
			new Thread(new Runnable() {
				public void run() {
					Gdx.app.postRunnable(new Runnable() {
						public void run() {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							UltimateFight.player.character.isAction = false;
						}
					});
				}
			}).start();
		}
	}
	
	public void show() {
	}

	public void resize(int width, int height) {

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}

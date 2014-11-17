package com.ultimate.screen;

import com.ultimate.controller.LoadingController;
import com.ultimate.game.Assets;
import com.ultimate.game.UltimateFight;

public class LoadingScreen extends ScreenBase {

	UltimateFight game;
	LoadingController controller;
	int cnt = 0;
	public LoadingScreen(UltimateFight game){
		this.game = game;
		controller = new LoadingController(game, this);
		Assets.bg_loading = Assets.loadTexture("Materials/Loading.png");
		System.out.println("..");
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<1; i++){
					try {Thread.sleep(100);} catch (InterruptedException e) {}
					cnt += 1;
				}
			}
		}).start();
	}
	
	public void render(float delta) {
		game.batch.begin();
		game.batch.draw(Assets.bg_loading,0 ,0);
		game.batch.end();
		if(cnt == 1){
			controller.update();
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

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

package com.ultimate.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ultimate.game.UltimateFight;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 760;
		config.height = 540;
		config.resizable = false;
		new LwjglApplication(new UltimateFight(), config);
	}
}

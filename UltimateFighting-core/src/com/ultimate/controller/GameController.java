package com.ultimate.controller;

import com.badlogic.gdx.math.Rectangle;
import com.ultimate.game.UltimateFight;

public abstract class GameController {
	
	UltimateFight game;
	
	int x, y;
	Rectangle pointer;
	
	public abstract void update();
}

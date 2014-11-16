package com.ultimate.screen;

import com.badlogic.gdx.Gdx;

public class Framerate {
	
	private static int framerate = 50;
	
	public static void run(){
		try {
			Thread.sleep((long)(1000/getFrameRate()-Gdx.graphics.getDeltaTime()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void setFrameRate(int rate){
		framerate = rate;
	}
	
	public static int getFrameRate(){
		return framerate;
	}
}

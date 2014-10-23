package com.ultimate.unit;

public class Vegeta extends JobClass{
	
	public static final int type = 1;
	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	
	public Vegeta() {
		super(0, 0, WIDTH, HEIGHT);
		hp = 10000;
		mp = 100;
		def = 100;
		mDef = 100;
		atk = 100;
		mAtk = 100;
		speed = 3;
		gravity = 1.5f;
	}
}

package com.ultimate.unit;

import com.ultimate.game.UltimateFight;

public class Vegeta extends JobClass{
	
	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	
	public Vegeta() {
		super(0, 0, WIDTH, HEIGHT);
		setHp(10000);
		setMp(100);
		setDef(100);
		setmDef(100);
		setAtk(100);
		setmAtk(100);
		setSpeed(10);
		setGravity(1.5f);
		setType(1);
	}

	@Override
	public void atk1(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atk2(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atk3(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atk4(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void block(UltimateFight game) {
		// TODO Auto-generated method stub
		
	}
}

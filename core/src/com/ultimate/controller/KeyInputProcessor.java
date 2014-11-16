package com.ultimate.controller;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class KeyInputProcessor implements InputProcessor {
	
	private String str = "";
	private int maxLength = 15;
	private boolean enableDigit = true;
	private boolean enablePoint = false;
	private boolean enableChar = true;
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getStr() {
		return str;
	}

	public void setName(String str) {
		this.str = str;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Keys.BACKSPACE && str.length() >= 1) str = str.substring(0, str.length()-1);
		else if(keycode == Keys.SPACE && enableChar) str += " ";
		else if(keycode == 56 && enablePoint) str += ".";
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		if(Character.isLetter(character) && str.length() <= maxLength && enableChar) str += character+"";
		else if(Character.isDigit(character) && enableDigit) str += character+"";
		return false;
	}

	public boolean isEnableDigit() {
		return enableDigit;
	}

	public void setEnableDigit(boolean enableDigit) {
		this.enableDigit = enableDigit;
	}

	public boolean isEnablePoint() {
		return enablePoint;
	}

	public void setEnablePoint(boolean enablePoint) {
		this.enablePoint = enablePoint;
	}

	public boolean isEnableChar() {
		return enableChar;
	}

	public void setEnableChar(boolean enableChar) {
		this.enableChar = enableChar;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

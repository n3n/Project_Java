package com.ultimate.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.ultimate.controller.GameController;

public abstract class ScreenBase implements Screen{
	FileHandle fontFile = Gdx.files.internal("fonts/THSarabun.ttf");
	FreeTypeFontGenerator generator = new FreeTypeFontGenerator(fontFile);
	FreeTypeFontParameter param = new FreeTypeFontParameter();
	BitmapFont font;
	GameController controller;
	public ScreenBase(){
		param.size = 60;
		param.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^?.,/\\()&*_+-=;:'\"[]{}";
		font = genFont();
	}
	
	public BitmapFont genFont(){
		return generator.generateFont(param);
	}
	public BitmapFont getFont() {
		return font;
	}

	public void setFont(BitmapFont font) {
		this.font = font;
	}

	public void setFont(int size){
		param.size = size;
	}
}

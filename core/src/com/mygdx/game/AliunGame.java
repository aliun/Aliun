package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class AliunGame extends Game {
	
	public SpriteBatch batch;
	
	@Override
	public void create () {
		batcher = new SpriteBatch();
		Settings.load();
		Assets.load();
		setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void render() {
		super.render();
	}
	
}

package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	public static Texture background;
    public static TextureRegion backgroundRegion;

	public static Texture items;
	public static TextureRegion create;
	public static TextureRegion visit;
	public static TextureRegion options;
	public static TextureRegion help;
	public static TextureRegion about;
	
	//public static Animation coinAnim;
	//public static BitmapFont font;

	public static Music music;
    public static Sound click;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background = loadTexture("background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 4500, 8000);

		items = loadTexture("assets.png");
		
		
		create = new TextureRegion  (items, 0, 200, 480, 200);   
		visit = new TextureRegion   (items, 0, 400, 480, 200);
		help = new TextureRegion    (items, 0, 0,   480, 200);
	    about = new TextureRegion   (items, 0, 600, 480, 200);

		//coinAnim = new Animation(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
		//	new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));

		//font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);

		music = Gdx.audio.newMusic(Gdx.files.internal("music.wav"));
		music.setLooping(true);
		music.setVolume(0.5f);

		//click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
	}
	
	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
}

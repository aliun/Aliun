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
	public static TextureRegion logo;
	
	public static TextureRegion create;
	public static TextureRegion visit;
	public static TextureRegion help;
	public static TextureRegion about;
	public static TextureRegion musicoff;
	public static TextureRegion musicon;
	public static TextureRegion soundoff;
	public static TextureRegion soundon;

	public static TextureRegion oncreate;
	public static TextureRegion onvisit;
	public static TextureRegion onhelp;
	public static TextureRegion onabout;
	public static TextureRegion onmusicoff;
	public static TextureRegion onmusicon;
	public static TextureRegion onsoundoff;
	public static TextureRegion onsoundon;
	
	//public static Animation coinAnim;
	//public static BitmapFont font;

	public static Music music;
    public static Sound click;

	public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
	}

	public static void load () {
		background = loadTexture("background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 1080, 1921);

		items = loadTexture("assets.png");

	    
	    logo = new TextureRegion   (items, 0, 1240, 780, 390);
		
		
		create = new TextureRegion  (items, 0, 200, 480, 200);   
		visit = new TextureRegion   (items, 0, 400, 480, 200);
		help = new TextureRegion    (items, 0, 0,   480, 200);
	    about = new TextureRegion   (items, 0, 600, 480, 200);
	    
	    soundon = new TextureRegion   (items, 960, 0, 120, 120);
	    musicon = new TextureRegion   (items, 960, 480, 120, 120);
	    soundoff = new TextureRegion   (items, 960, 240, 120, 120);
	    musicoff = new TextureRegion   (items, 960, 720, 120, 120);
	    
	    oncreate = new TextureRegion  (items, 480, 200, 480, 200);   
		onvisit = new TextureRegion   (items, 480, 400, 480, 200);
		onhelp = new TextureRegion    (items, 480, 0,   480, 200);
	    onabout = new TextureRegion   (items, 480, 600, 480, 200);
	    
	    onsoundon = new TextureRegion   (items, 960, 120, 120, 120);
	    onmusicon = new TextureRegion   (items, 960, 600, 120, 120);
	    onsoundoff = new TextureRegion   (items, 960, 360, 120, 120);
	    onmusicoff = new TextureRegion   (items, 960, 840, 120, 120);

		//coinAnim = new Animation(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
		//	new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));

		//font = new BitmapFont(Gdx.files.internal("data/font.fnt"), Gdx.files.internal("data/font.png"), false);

		music = Gdx.audio.newMusic(Gdx.files.internal("music.wav"));
		music.setLooping(true);
		music.setVolume(0.5f);
		if (Settings.musicEnabled) music.play();
		
		

		//click = Gdx.audio.newSound(Gdx.files.internal("click.wav"));
	}
	
	public static void playSound (Sound sound) {
		if (Settings.soundEnabled) sound.play(1);
	}
	
	
}

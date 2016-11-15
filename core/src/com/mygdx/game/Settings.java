package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Settings {
	public static boolean soundEnabled = true;
	public static boolean musicEnabled = true;
	public static boolean aliunCreated = false;
	public final static String file = ".aliun";

	public static void load () {
		try {
			FileHandle filehandle = Gdx.files.external(file);
			String[] strings = filehandle.readString().split("\n");
			
			soundEnabled = Boolean.parseBoolean(strings[0]);
			musicEnabled = Boolean.parseBoolean(strings[1]);
			aliunCreated = Boolean.parseBoolean(strings[2]);
			
			if (aliunCreated)
			{
				//ucitaj podatke
			}
			
		} catch (Throwable e) {
			// :( It's ok we have defaults
		}
	}

	public static void save () {
		try {
			FileHandle filehandle = Gdx.files.external(file);
			filehandle.writeString(Boolean.toString(soundEnabled)+"\n", false);
			filehandle.writeString(Boolean.toString(musicEnabled)+"\n", false);
			filehandle.writeString(Boolean.toString(aliunCreated)+"\n", true);
			
		} catch (Throwable e) {
		}
	}

}

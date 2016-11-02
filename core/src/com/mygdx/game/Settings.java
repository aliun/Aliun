package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class Settings {
	public static boolean soundEnabled = true;
	public final static String file = ".aliun";

	public static void load () {
		try {
			FileHandle filehandle = Gdx.files.external(file);
			String[] strings = filehandle.readString().split("\n");
			
			soundEnabled = Boolean.parseBoolean(strings[0]);
			
		} catch (Throwable e) {
			// :( It's ok we have defaults
		}
	}

	public static void save () {
		try {
			FileHandle filehandle = Gdx.files.external(file);
			filehandle.writeString(Boolean.toString(soundEnabled)+"\n", false);
			
		} catch (Throwable e) {
		}
	}

}

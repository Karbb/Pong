package com.karbb.pongclone.utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class AssetLoader {

	public static final String PADDLE_TEXTURE = "paddle.png";
	public static final String BALL_TEXTURE = "ball.png";
	public static final String INTRO_TEXTURE = "intro.png";
	
	public static final String INTRO_MUSIC = "doobly.mp3";

	private AssetManager manager;

	public AssetLoader() {
		manager = new AssetManager();
		manager.load(PADDLE_TEXTURE, Texture.class);
		manager.load(BALL_TEXTURE, Texture.class);
		manager.load(INTRO_TEXTURE, Texture.class);
		
		manager.load(INTRO_MUSIC, Music.class);
	}

	public AssetManager getManager() {
		return manager;
	}

	public void setManager(AssetManager manager) {
		this.manager = manager;
	}

}

package com.karbb.pongclone.utilities;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {

	public static final String PADDLE_TEXTURE = "paddle.png";
	public static final String BALL_TEXTURE = "ball.png";

	private AssetManager manager;


	public AssetLoader() {
		manager = new AssetManager();
		manager.load(PADDLE_TEXTURE, Texture.class);
		manager.load(BALL_TEXTURE, Texture.class);
	}
	
	public AssetManager getManager() {
		return manager;
	}

	public void setManager(AssetManager manager) {
		this.manager = manager;
	}

}

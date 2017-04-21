package com.karbb.pongclone;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.karbb.pongclone.utilities.AssetLoader;

public class PongGame extends Game {
	SpriteBatch batch;

	AssetLoader assetLoader;
	Rectangle gameBounds;
	World world;

	@Override
	public void create() {
		assetLoader = new AssetLoader();
		assetLoader.getManager().finishLoading();
		batch = new SpriteBatch();

		world = new World();

	}

	@Override
	public void render() {
		float deltaTime = Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.update(deltaTime);
		world.draw(batch);
		
	}

	@Override
	public void dispose() {
		assetLoader.getManager().dispose();
		batch.dispose();
	}
}

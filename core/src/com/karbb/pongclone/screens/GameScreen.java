package com.karbb.pongclone.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.karbb.pongclone.PongGame;
import com.karbb.pongclone.World;
import com.karbb.pongclone.utilities.AssetLoader;

public class GameScreen extends PongScreen {

	SpriteBatch batch;

	World world;

	float time = 0;

	public GameScreen(Game game) {
		super(game);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		world = new World();
	}

	@Override
	public void render(float delta) {
		float deltaTime = Gdx.graphics.getDeltaTime();

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		world.update(deltaTime);
		world.draw(batch);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

}
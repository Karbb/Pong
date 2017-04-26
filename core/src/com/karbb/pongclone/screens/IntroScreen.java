package com.karbb.pongclone.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.karbb.pongclone.utilities.AssetLoader;

public class IntroScreen extends PongScreen {

	SpriteBatch batch;
	AssetLoader assetLoader;

	Texture img;
	Music music;

	float time;

	public IntroScreen(Game game) {
		super(game);
	}

	@Override
	public void show() {
		assetLoader = new AssetLoader();
		assetLoader.getManager().finishLoading();

		img = new Texture(AssetLoader.INTRO_TEXTURE);
		music = Gdx.audio.newMusic(Gdx.files.internal("doobly.mp3"));

		batch = new SpriteBatch();
		
		time = 0;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();

		music.play();
		music.setLooping(true);

		time += delta;
		if (time > 1) {
			if (Gdx.input.isKeyPressed(Keys.ANY_KEY)) {
				game.setScreen(new GameScreen(game));
			}
		}
	}

	@Override
	public void hide() {
		batch.dispose();
	}

}

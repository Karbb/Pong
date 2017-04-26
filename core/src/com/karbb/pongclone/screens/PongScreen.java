package com.karbb.pongclone.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.karbb.pongclone.PongGame;

public abstract class PongScreen implements Screen {

	final Game game;

	public PongScreen(Game game) {
		this.game = game;
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

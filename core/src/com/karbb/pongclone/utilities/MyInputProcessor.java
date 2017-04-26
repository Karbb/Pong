package com.karbb.pongclone.utilities;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.karbb.pongclone.entities.Paddle;

public class MyInputProcessor implements InputProcessor {

	Paddle paddle1;
	Paddle paddle2;

	public MyInputProcessor(Paddle paddle1, Paddle paddle2) {
		this.paddle1 = paddle1;
		this.paddle2 = paddle2;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.LEFT:
			paddle1.setLeftMove(true);
			break;
		case Keys.RIGHT:
			paddle1.setRightMove(true);
			break;

		case Keys.A:
			paddle2.setLeftMove(true);
			break;
		case Keys.D:
			paddle2.setRightMove(true);
			break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.LEFT:
			paddle1.setLeftMove(false);
			break;
		case Keys.RIGHT:
			paddle1.setRightMove(false);
			break;

		case Keys.A:
			paddle2.setLeftMove(false);
			break;
		case Keys.D:
			paddle2.setRightMove(false);
			break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}

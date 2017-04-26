package com.karbb.pongclone;

import com.badlogic.gdx.Game;
import com.karbb.pongclone.screens.GameScreen;
import com.karbb.pongclone.screens.IntroScreen;

public class PongGame extends Game {

	@Override
	public void create() {
		setScreen(new IntroScreen(this));
	}
}

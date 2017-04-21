package com.karbb.pongclone.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.karbb.pongclone.PongGame;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pong";
		config.width = 800;
		config.height = 600;
		config.foregroundFPS = 60;
		new LwjglApplication(new PongGame(), config);
	}
}

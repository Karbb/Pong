package com.karbb.pongclone.entities;

import com.karbb.pongclone.utilities.AssetLoader;

public class Ball extends Entity {
	
	public static final int BALL_MOVING = 0;
	public static final int BALL_BOUNCING = 1;
	
	public static final float HEIGHT = 25;
	public static final float WIDTH = 25;
	public int state;

	public Ball(float x, float y) {
		super(AssetLoader.BALL_TEXTURE, x, y);
		velocity.set(0,200);
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
	}
	
	
}

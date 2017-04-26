package com.karbb.pongclone.entities;

import com.badlogic.gdx.Gdx;
import com.karbb.pongclone.utilities.AssetLoader;

public class Paddle extends Entity {

	private boolean leftMove;
	private boolean rightMove;

	private static final float SPEED = 300;

	public static final float HEIGHT = 10;
	public static final float WIDTH = 100;

	public Paddle(float x, float y) {
		super(AssetLoader.PADDLE_TEXTURE, x, y);
	}

	@Override
	public void update(float deltaTime) {
		if (leftMove && position.x - SPEED * deltaTime > 0) {
			velocity.x = -SPEED;
		} else if (rightMove && position.x + SPEED * deltaTime < Gdx.graphics.getWidth() - bounds.width) {
			velocity.x = SPEED;
		} else {
			velocity.x = 0;
		}
		super.update(deltaTime);
	}

	public boolean isLeftMove() {
		return leftMove;
	}

	public void setLeftMove(boolean leftMove) {
		this.leftMove = leftMove;
	}

	public boolean isRightMove() {
		return rightMove;
	}

	public void setRightMove(boolean rightMove) {
		this.rightMove = rightMove;
	}

}

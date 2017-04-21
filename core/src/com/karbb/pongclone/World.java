package com.karbb.pongclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.karbb.pongclone.entities.Ball;
import com.karbb.pongclone.entities.Entity;
import com.karbb.pongclone.entities.Paddle;
import com.karbb.pongclone.utilities.MyInputProcessor;

public class World {

	public static final float WORLD_WIDTH = 10;
	public static final float WORLD_HEIGHT = 15 * 20;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;

	public final Paddle paddle1;
	public final Paddle paddle2;
	public final Ball ball;

	public World() {
		this.paddle1 = new Paddle(Gdx.graphics.getWidth() / 2 - Paddle.WIDTH,50);
		this.paddle2 = new Paddle(Gdx.graphics.getWidth() / 2 -  Paddle.WIDTH / 2, Gdx.graphics.getHeight() - 50);
		this.ball = new Ball(Gdx.graphics.getWidth() / 2 - Ball.WIDTH / 2,
				Gdx.graphics.getHeight() / 2 -  Ball.WIDTH / 2);

		
		paddle1.setPosition(Gdx.graphics.getWidth() / 2 - paddle1.bounds.width / 2, 50);
		paddle2.setPosition(Gdx.graphics.getWidth() / 2 - paddle1.bounds.width / 2, Gdx.graphics.getHeight() - 50);
		Gdx.input.setInputProcessor(new MyInputProcessor(paddle2));
	}

	public void update(float deltaTime) {
		paddle1.update(deltaTime);
		paddle2.update(deltaTime);
		ball.update(deltaTime);
		checkCollisions(ball);
		checkCollisionBallVSPaddle(ball, paddle1);
		checkCollisionBallVSPaddle(ball, paddle2);
	}

	private void checkCollisionBallVSPaddle(Ball ball, Paddle paddle) {
		boolean collision = ball.bounds.overlaps(paddle.bounds);
		if (collision) {
			ball.velocity.y = -ball.velocity.y;
		}

	}

	private void checkCollisions(Ball ball) {
		
		//boolean out = ball.bounds.x < 0 || ball.bounds.x > Gdx.graphics.getWidth() - ball.getEntitySprite().getWidth();
		if (ball.bounds.x < 0 && ball.velocity.x < 0) {
			ball.velocity.x = -ball.velocity.x;
		} else if (ball.bounds.x > Gdx.graphics.getWidth() - ball.getEntitySprite().getWidth() && ball.velocity.x > 0) {
			ball.velocity.x = -ball.velocity.x;
		}
		
	}

	public void draw(SpriteBatch batch) {
		batch.begin();
		paddle1.draw(batch);
		paddle2.draw(batch);
		ball.draw(batch);
		batch.end();
	}

}

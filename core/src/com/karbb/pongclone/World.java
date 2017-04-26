package com.karbb.pongclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.karbb.pongclone.entities.Ball;
import com.karbb.pongclone.entities.Entity;
import com.karbb.pongclone.entities.Paddle;
import com.karbb.pongclone.utilities.AssetLoader;
import com.karbb.pongclone.utilities.MyInputProcessor;

public class World {

	public static final float WORLD_WIDTH = 800;
	public static final float WORLD_HEIGHT = 600;
	public static final int WORLD_STATE_RUNNING = 0;
	public static final int WORLD_STATE_NEXT_LEVEL = 1;
	public static final int WORLD_STATE_GAME_OVER = 2;

	public final Paddle paddle1;
	public final Paddle paddle2;
	public final Ball ball;

	public float timer;

	public float scorePlayer1, scorePlayer2;

	public boolean scoreP1, scoreP2;

	public World() {
		this.paddle1 = new Paddle(Gdx.graphics.getWidth() / 2 - Paddle.WIDTH / 2, 50);
		this.paddle2 = new Paddle(Gdx.graphics.getWidth() / 2 - Paddle.WIDTH / 2, Gdx.graphics.getHeight() - 50);
		this.ball = new Ball(Gdx.graphics.getWidth() / 2 - Ball.WIDTH / 2,
				Gdx.graphics.getHeight() / 2 - Ball.WIDTH / 2);

		Gdx.input.setInputProcessor(new MyInputProcessor(paddle1, paddle2));

		timer = 0;
		scorePlayer1 = scorePlayer2 = 0;
	}

	public void update(float deltaTime) {
		paddle1.update(deltaTime);
		paddle2.update(deltaTime);
		ball.update(deltaTime);

		if (checkPoints(deltaTime)) {
			timer += deltaTime;
		}

		resetPosition(deltaTime);

		checkCollisions(ball, deltaTime);
		checkCollisionBallVSPaddle(ball, paddle1, deltaTime);
		checkCollisionBallVSPaddle(ball, paddle2, deltaTime);
	}

	private void resetPosition(float deltatime) {
		if (timer > 0.5) {
			if (scoreP1) {
				scorePlayer1++;
				scoreP1 = false;
			}
			if (scoreP2) {
				scorePlayer2++;
				scoreP2 = false;
			}
			
			ball.resetPosition();
			paddle1.resetPosition();
			paddle2.resetPosition();
			timer = 0;
		}
	}

	private void checkCollisionBallVSPaddle(Ball ball, Paddle paddle, float deltaTime) {
		Rectangle futureBall = new Rectangle(ball.position.x + ball.velocity.x * deltaTime,
				ball.position.y + ball.velocity.y * deltaTime, Ball.WIDTH, Ball.HEIGHT);

		Rectangle paddleLeft = new Rectangle(paddle.position.x, paddle.position.y, 1, Paddle.HEIGHT);
		Rectangle paddleTop = new Rectangle(paddle.position.x, paddle.position.y + Paddle.HEIGHT, Paddle.WIDTH, 1);
		Rectangle paddleBottom = new Rectangle(paddle.position.x, paddle.position.y, Paddle.WIDTH, 1);
		Rectangle paddleRight = new Rectangle(paddle.position.x + Paddle.WIDTH, paddle.position.y, 1, Paddle.HEIGHT);

		boolean collisionVertical = futureBall.overlaps(paddleTop) || futureBall.overlaps(paddleBottom);
		boolean collisionHorizontal = futureBall.overlaps(paddleLeft) || futureBall.overlaps(paddleRight);
		
		if (collisionVertical) {
			ball.velocity.y = -ball.velocity.y;
		}
		if (collisionHorizontal) {
			ball.velocity.x = -ball.velocity.x;
		}
	}

	private void checkCollisions(Ball ball, float deltaTime) {

		if (ball.bounds.x < 0 && ball.velocity.x < 0) {
			ball.velocity.x = -ball.velocity.x;
		} else if (ball.bounds.x > Gdx.graphics.getWidth() - ball.getEntitySprite().getWidth() && ball.velocity.x > 0) {
			ball.velocity.x = -ball.velocity.x;
		}
	}

	private boolean checkPoints(float deltaTime) {

		if (ball.bounds.y + ball.velocity.y * deltaTime + Ball.HEIGHT > WORLD_HEIGHT) {
			ball.velocity.set(0, 0);
			scoreP1 = true;
			return true;
		}
		if (ball.bounds.y - ball.velocity.y * deltaTime < 0) {
			ball.velocity.set(0, 0);
			scoreP2 = true;
			return true;
		}
		return false;
	}

	public void draw(SpriteBatch batch) {
		batch.begin();
		paddle1.draw(batch);
		paddle2.draw(batch);
		ball.draw(batch);
		batch.end();
	}

}

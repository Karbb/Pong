package com.karbb.pongclone.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Entity {

	private Sprite entitySprite;
	private Texture entityTexture;
	public Vector2 position;
	public Vector2 velocity;
	public Vector2 accel;
	public Rectangle bounds;

	public Vector2 initialPosition;

	public Entity(String textureFile, float x, float y) {
		entityTexture = new Texture(Gdx.files.internal(textureFile));
		entitySprite = new Sprite(entityTexture);
		bounds = entitySprite.getBoundingRectangle();
		this.position = new Vector2(x, y);
		velocity = new Vector2();
		accel = new Vector2();
		entitySprite.setPosition(position.x, position.y);
		initialPosition = new Vector2(x, y);
	}

	public void update(float deltaTime) {
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds = entitySprite.getBoundingRectangle();
		entitySprite.setPosition(position.x, position.y);
	}

	public boolean collideGameBounds() {
		if (bounds.x < 0 || bounds.x + entitySprite.getWidth() > Gdx.graphics.getWidth() || bounds.y < 0
				|| bounds.y + entitySprite.getHeight() > Gdx.graphics.getHeight()) {
			return true;
		} else {
			return false;
		}
	}

	public void resetPosition() {
		position.set(initialPosition);
	}

	public void setPosition(float x, float y) {
		position.set(x, y);
	}

	public void draw(SpriteBatch batch) {
		entitySprite.draw(batch);
	}

	public Sprite getEntitySprite() {
		return entitySprite;
	}

	public void setEntitySprite(Sprite entitySprite) {
		this.entitySprite = entitySprite;
	}

	public Texture getEntityTexture() {
		return entityTexture;
	}

	public void setEntityTexture(Texture entityTexture) {
		this.entityTexture = entityTexture;
	}

}

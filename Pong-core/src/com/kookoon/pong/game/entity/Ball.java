package com.kookoon.pong.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Ball extends Entity {
	
	Texture texture;
	public int height;
	public int width;

	public Ball(float x, float y) {
		this.x = (int) x;
		this.y = (int) y;
		texture = new Texture(Gdx.files.internal("ball.png"));
		width = 32;
		height = 32;
		velocity = new Vector2(2f, 2f);
	}

	public void update(float delta) {
		
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture, x - texture.getWidth() / 2, y - texture.getHeight() / 2);
	}

	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

}

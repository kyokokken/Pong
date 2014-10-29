package com.kookoon.pong.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity {
	
	Texture texture;
	int width;
	public int height;
	public int score;

	public Player(float x, float y) {
		this.x = (int) x;
		this.y = (int) y;
		texture = new Texture(Gdx.files.internal("paddle_blue.png"));
		velocity = new Vector2(5f, 5f);
		width = 32;
		height = 128;
		score = 0;
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

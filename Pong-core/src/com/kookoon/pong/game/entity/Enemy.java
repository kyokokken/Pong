package com.kookoon.pong.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemy extends Entity {
 
	Texture texture;
	public int score;
	public int height;
	public int width;
	
	public Enemy(float x, float y) {
		this.x = (int) x;
		this.y = (int) y;
		texture = new Texture(Gdx.files.internal("paddle_red.png"));
		score = 0;
		velocity = new Vector2(5f, 5f);
		height = 128;
		width = 32;
	}

	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(SpriteBatch batch) {
		batch.draw(texture, x - texture.getWidth() / 2, y - texture.getHeight() / 2);
		
	}

	public Rectangle getRectangle() {
		return new Rectangle(x, y, width, height);
	}

}

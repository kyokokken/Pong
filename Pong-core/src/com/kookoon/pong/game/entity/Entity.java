package com.kookoon.pong.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
	public int x;
	public int y;
	public Vector2 velocity;
	
	public Entity() {
		velocity = new Vector2(0f, 0f);
	}
	
	public abstract void render(SpriteBatch batch);
}

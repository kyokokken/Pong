package com.kookoon.pong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.kookoon.pong.game.entity.Entity;

public class WorldRenderer {

	private WorldController controller;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	
	public WorldRenderer(WorldController controller) {
		this.controller = controller;
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false);
	}

	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl20.glClearColor(0.5f, 0.5f, 0.5f, 0);
		batch.begin();
		for (Entity entity : controller.getEntities())
		{
			entity.render(batch);
		}
		batch.end();
	}

}

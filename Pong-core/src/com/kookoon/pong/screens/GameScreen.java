package com.kookoon.pong.screens;

import com.badlogic.gdx.Screen;
import com.kookoon.pong.WorldController;
import com.kookoon.pong.WorldRenderer;

public class GameScreen implements Screen {

	private WorldRenderer renderer;
	private WorldController controller;

	@Override
	public void show() {
		controller = new WorldController();
		renderer = new WorldRenderer(controller);
	}
	
	@Override
	public void render(float delta) {
		controller.update(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {

	}


	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}

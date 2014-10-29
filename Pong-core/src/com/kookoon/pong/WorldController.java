package com.kookoon.pong;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.kookoon.pong.game.entity.Ball;
import com.kookoon.pong.game.entity.Enemy;
import com.kookoon.pong.game.entity.Player;
import com.kookoon.pong.game.Level;
import com.kookoon.pong.game.entity.Entity;

public class WorldController {

	private Player player;
	private Enemy enemy;
	private Ball ball;
	private Level level;
	private ArrayList<Entity> entities;
	private float increaseFactor;

	public WorldController() {
		player = new Player(20, Gdx.graphics.getHeight() / 2);
		enemy = new Enemy(Gdx.graphics.getWidth() - 20,
				Gdx.graphics.getHeight() / 2);
		ball = new Ball(Gdx.graphics.getWidth() / 2,
				Gdx.graphics.getHeight() / 2);
		level = new Level();
		entities = new ArrayList<Entity>();
		entities.add(player);
		entities.add(enemy);
		entities.add(ball);
		increaseFactor = 1.25f;
	}

	public void update(float delta) {
		updatePlayer(delta);
		updateBall(delta);
		updateEnemy(delta);
	}

	private void updateEnemy(float delta) {
		if (ball.y > enemy.y)
		{
			enemy.y += enemy.velocity.y;
		}
		if (ball.y < enemy.y)
		{
			enemy.y -= enemy.velocity.y;
		}
		if (enemy.y > Gdx.graphics.getHeight() - enemy.height / 2)
			enemy.y = Gdx.graphics.getHeight() - enemy.height / 2;
		if (enemy.y < enemy.height / 2)
			enemy.y = enemy.height / 2;
		
	}

	private void updateBall(float delta) {
		ball.x += ball.velocity.x;
		ball.y += ball.velocity.y;
		
		//Collision with top wall.
		if (ball.velocity.y > 0 && ball.y > Gdx.graphics.getHeight() - ball.height / 2)
		{
			ball.y = Gdx.graphics.getHeight() - ball.height / 2;
			ball.velocity.y *= -1f;
			System.out.println(ball.velocity.x + " " + ball.velocity.y);
		}
		if (ball.velocity.y < 0 && ball.y < ball.height / 2) {
			ball.y = ball.height / 2;
			ball.velocity.y *= -1f;
			System.out.println(ball.velocity.x + " " + ball.velocity.y);
		}
		if (ball.x < ball.width / 2)
		{
			enemy.score += 1;
			resetBall();
		}
		if (ball.x > Gdx.graphics.getWidth() - ball.width / 2)
		{
			player.score += 1;
			resetBall();
		}
		
		//Collision with paddles
		if (ball.velocity.x > 0 && ball.getRectangle().overlaps(enemy.getRectangle()))
		{
			ball.velocity.x *= -1 * increaseFactor;
			ball.velocity.y *= 1 * increaseFactor;
			System.out.println(ball.velocity.x + " " + ball.velocity.y);
		}
		
		if (ball.velocity.x < 0 && ball.getRectangle().overlaps(player.getRectangle())) {
			ball.velocity.x *= -1 * increaseFactor;
			ball.velocity.y *= 1 * increaseFactor;
			System.out.println(ball.velocity.x + " " + ball.velocity.y);
		}
	}

	private void resetBall() {
		ball.x = Gdx.graphics.getWidth() / 2;
		ball.y = Gdx.graphics.getHeight() / 2;
	}

	private void updatePlayer(float delta) {
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			player.y += player.velocity.y;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			player.y -= player.velocity.y;
		}
		if (player.y > Gdx.graphics.getHeight() - player.height / 2)
			player.y = Gdx.graphics.getHeight() - player.height / 2;
		if (player.y < player.height / 2)
			player.y = player.height / 2;
	}

	public List<Entity> getEntities() {
		return entities;
	}

}

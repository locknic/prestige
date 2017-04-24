package com.custardgames.prestige.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.custardgames.prestige.Prestige;

public class EndGameScreen implements Screen
{
	private final Prestige game;

	public EndGameScreen(Prestige game)
	{
		this.game = game;
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta)
	{
		game.batch.begin();
		game.font.draw(game.batch, "Welcome to Drop!!! ", 100, 150);
		game.font.draw(game.batch, "Tap anywhere to begin!", 100, 100);
		game.batch.end();

		if (Gdx.input.isTouched())
		{
			game.changeScreen(new GameScreen(game));
		}
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}

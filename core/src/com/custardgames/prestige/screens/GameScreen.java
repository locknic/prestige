package com.custardgames.prestige.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.custardgames.prestige.Prestige;
import com.custardgames.prestige.ai.AI;
import com.custardgames.prestige.ai.VeryEasyAI;
import com.custardgames.prestige.ui.GameStage;

public class GameScreen implements Screen
{
	private final Prestige game;

	private GameStage gameStage;
	
	public GameScreen(Prestige game, AI ai)
	{
		this.game = game;

		InputMultiplexer imp = new InputMultiplexer();
		
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		game.sceneLoader.loadScene("MainScene");

		gameStage = new GameStage(game, ai);
		gameStage.setViewport(new FitViewport(Prestige.WIDTH, Prestige.HEIGHT));
		imp.addProcessor(gameStage);
		
		Gdx.input.setInputProcessor(imp);
	}
	
	public GameScreen(Prestige game)
	{
		this.game = game;

		InputMultiplexer imp = new InputMultiplexer();
		
		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		Gdx.input.setInputProcessor(inputMultiplexer);
		
		game.sceneLoader.loadScene("MainScene");

		gameStage = new GameStage(game);
		gameStage.setViewport(new FitViewport(Prestige.WIDTH, Prestige.HEIGHT));
		imp.addProcessor(gameStage);
		
		Gdx.input.setInputProcessor(imp);
	}
	
	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta)
	{
		gameStage.act();
		gameStage.draw();
		
		if (gameStage.ai != null)
		{
			gameStage.ai.act();
		}
	}

	@Override
	public void resize(int width, int height)
	{
		gameStage.getViewport().update(width, height, true);
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
		gameStage.dispose();
	}

}

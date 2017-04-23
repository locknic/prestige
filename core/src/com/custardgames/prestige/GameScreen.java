package com.custardgames.prestige;

import com.badlogic.gdx.Screen;

public class GameScreen implements Screen
{
	private final Prestige game;

	private GameStage uiStage;

	public GameScreen(Prestige game)
	{
		this.game = game;

		uiStage = new GameStage(game);
		
		game.sceneLoader.loadScene("MainScene", uiStage.getViewport());
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta)
	{
		uiStage.act();
		uiStage.draw();
	}

	@Override
	public void resize(int width, int height)
	{
		uiStage.getViewport().update(width, height, true);
		game.sceneLoader.rayHandler.useCustomViewport(uiStage.getViewport().getScreenX(), uiStage.getViewport().getScreenY(), uiStage.getViewport().getScreenWidth(), uiStage.getViewport().getScreenHeight());
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
		uiStage.dispose();
	}

}

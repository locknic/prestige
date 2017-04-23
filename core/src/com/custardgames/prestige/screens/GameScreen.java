package com.custardgames.prestige.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Prestige;

public class GameScreen implements Screen
{
	private final Prestige game;

	private GameStage gameStage;
	private Stage uiStage;

	public GameScreen(Prestige game)
	{
		this.game = game;

		gameStage = new GameStage(game);

		game.sceneLoader.loadScene("MainScene", gameStage.getViewport());
		
		uiStage = new Stage();
		uiStage.setViewport(new ExtendViewport(Prestige.WIDTH, Prestige.HEIGHT));
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
		
		uiStage.act();
		uiStage.draw();
		game.batch.setProjectionMatrix(uiStage.getCamera().combined);
		game.batch.begin();
		game.font.draw(game.batch, "Gold " + gameStage.player1.inventory.gold + "  Wood " + gameStage.player1.inventory.wood + "  Stone " + gameStage.player1.inventory.stone + "  Food " + gameStage.player1.inventory.food + "  Prestige " + gameStage.player1.inventory.prestige, -uiStage.getWidth() / 2 + 20, uiStage.getHeight() / 2 - 40);
		game.batch.end();
	}

	@Override
	public void resize(int width, int height)
	{
		gameStage.getViewport().update(width, height, true);
		game.sceneLoader.rayHandler.useCustomViewport(gameStage.getViewport().getScreenX(), gameStage.getViewport().getScreenY(),
				gameStage.getViewport().getScreenWidth(), gameStage.getViewport().getScreenHeight());
		uiStage.getViewport().update(width, height);
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

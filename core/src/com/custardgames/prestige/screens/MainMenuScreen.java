package com.custardgames.prestige.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.custardgames.prestige.Prestige;
import com.custardgames.prestige.ai.VeryEasyAI;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class MainMenuScreen implements Screen
{
	private final Prestige game;
	private Stage stage;
	
	public CompositeActor locationsActor;

	public MainMenuScreen(final Prestige game)
	{
		this.game = game;
		this.stage = new Stage();
		
		game.sceneLoader.loadScene("MainMenu");
		locationsActor = new CompositeActor(game.sceneLoader.loadVoFromLibrary("mainmenu"), game.sceneLoader.getRm());
		stage.addActor(locationsActor);
		Gdx.input.setInputProcessor(stage);
		
		locationsActor.getItem("2player").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent e, float x, float y)
			{
				game.changeScreen(new GameScreen(game));
			}
		});
		
		locationsActor.getItem("veryeasyai").addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent e, float x, float y)
			{
				game.changeScreen(new GameScreen(game, new VeryEasyAI()));
			}
		});
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float delta)
	{
		stage.act();
		stage.draw();
		
//		if (Gdx.input.isTouched())
//		{
//			game.changeScreen(new GameScreen(game));
//		}
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

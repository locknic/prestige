package com.custardgames.prestige;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.uwsoft.editor.renderer.SceneLoader;

public class Prestige extends Game
{
	public static final int WIDTH = 896;
	public static final int HEIGHT = 512;
	
	SpriteBatch batch;
	BitmapFont font;
	
	SceneLoader sceneLoader;

	@Override
	public void render()
	{
		// 18, 134, 254
		Gdx.gl.glClearColor(18/255f, 134/255f, 254/255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		sceneLoader.getEngine().update(Gdx.graphics.getDeltaTime());

		super.render();
	}
	
	@Override
	public void create()
	{
		sceneLoader = new SceneLoader();
		batch = new SpriteBatch();
		font = new BitmapFont();

		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose()
	{
		super.dispose();
		batch.dispose();
		font.dispose();
	}
}

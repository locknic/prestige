package com.custardgames.prestige.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class Scoreboard extends UIItem
{
	public final GameStage gameStage;
	Actor actor;
	
	public Scoreboard(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.actor = actor;
		
		actor.addListener(this);
	}
	
	@Override
	public void clicked(InputEvent e, float x, float y)
	{
		System.out.println("HELLO?");
		gameStage.reloadGame();
	}

}

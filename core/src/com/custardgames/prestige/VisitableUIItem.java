package com.custardgames.prestige;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class VisitableUIItem extends UIItem
{
	private final GameStage gameStage;
	
	Actor actor;
	
	String description;
	
	public VisitableUIItem(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.name = actor.getName();
		this.actor = actor;
		this.actor.addListener(this);
	}
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		System.out.println("ENTERED " + name);
	}
	
	@Override
	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
	{
		System.out.println("EXITED " + name);
	}
	
	@Override
	public void clicked(InputEvent e, float x, float y)
	{
		visit();
	}
	
	public void visit()
	{
		
	}
}

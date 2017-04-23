package com.custardgames.prestige;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class UIItem extends ClickListener
{
	String name;
	
	public UIItem()
	{
		this.name = "UNKOWN";
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
		System.out.println("CLICKED " + name);
	}
}

package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.GivingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Fruit extends GivingUIItem
{

	public Fruit(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		if (!hasVisitor && inventory.food <= 4)
		{
			inventory.food += 2;
		}
	}

	@Override
	public String getDescription()
	{
		return "Work at the fields to collect " + inventory.food + " food. Fields grow 2 food per day (max 6).";
	}

	@Override
	public String getName()
	{
		return "Fields";
	}
	
	

}

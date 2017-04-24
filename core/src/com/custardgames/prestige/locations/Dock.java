package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.GivingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Dock extends GivingUIItem
{

	public Dock(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		if (!hasVisitor && inventory.gold < 3)
		{
			inventory.gold += 1;
		}
	}

	@Override
	public String getDescription()
	{
		return "Work at the dock to collect " + inventory.gold + " gold. Docks collect 1 gold per day (max 3).";
	}

	@Override
	public String getName()
	{
		return "Dock";
	}

}

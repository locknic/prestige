package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.TradingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Church extends TradingUIItem
{

	public Church(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		inventory.prestige = 1;
	}

	@Override
	public void setExpectedItems()
	{
		expectedItems.gold = 8;
	}

	@Override
	public String getDescription()
	{
		return "Donate " + expectedItems.gold + " gold to the church to get " + inventory.prestige + " prestige.";
	}

	@Override
	public String getName()
	{
		return "Church";
	}

}

package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.locations.types.TradingUIItem;

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
		expectedItems.gold = 5;
	}

}

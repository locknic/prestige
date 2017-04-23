package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.locations.types.TradingUIItem;

public class Shelter extends TradingUIItem
{

	public Shelter(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.prestige = 1;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.food = 5;
	}

}

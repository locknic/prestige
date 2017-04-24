package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.TradingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Woodshop extends TradingUIItem
{

	public Woodshop(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.gold = 3;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.wood = 8;
	}

	@Override
	public String getDescription()
	{
		return "Sell " + this.expectedItems.wood + " wood to get " + this.inventory.gold + " gold.";
	}

	@Override
	public String getName()
	{
		return "Woodshop";
	}

}

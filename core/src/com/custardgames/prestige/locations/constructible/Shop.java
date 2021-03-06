package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.locations.types.PlayerTradingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Shop extends PlayerTradingUIItem
{

	public Shop(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.gold = 2;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.food = 5;
	}

	@Override
	public String getDescription()
	{
		return "Allows you to sell " + this.expectedItems.food + " to get " + this.inventory.gold + "gold here.";
	}

	@Override
	public String getName()
	{
		return "Shop";
	}

}

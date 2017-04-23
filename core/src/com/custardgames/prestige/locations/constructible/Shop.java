package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Player;
import com.custardgames.prestige.locations.types.PlayerTradingUIItem;

public class Shop extends PlayerTradingUIItem
{

	public Shop(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.gold = 5;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.food = 5;
	}

}

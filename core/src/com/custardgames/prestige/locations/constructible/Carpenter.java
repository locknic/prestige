package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.locations.types.PlayerTradingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Carpenter extends PlayerTradingUIItem
{

	public Carpenter(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.prestige = 1;
		this.inventory.gold = 2;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.wood = 8;
	}

	@Override
	public String getDescription()
	{
		return "Craft " + this.expectedItems.wood + " wood to get 1 prestige and 2 gold here.";
	}

	@Override
	public String getName()
	{
		return "Carpenter Workshop";
	}

}

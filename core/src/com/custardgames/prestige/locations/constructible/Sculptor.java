package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.locations.types.PlayerTradingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Sculptor extends PlayerTradingUIItem
{

	public Sculptor(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.prestige = 2;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.stone = 6;
	}
	
	@Override
	public String getDescription()
	{
		return "Craft " + this.expectedItems.stone + " stone to get 2 prestige here.";
	}

	@Override
	public String getName()
	{
		return "Sculpting Workshop";
	}

}

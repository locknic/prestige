package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.locations.types.TradingUIItem;

public class Mason extends TradingUIItem
{

	public Mason(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		this.inventory.wood = 3;
	}

	@Override
	public void setExpectedItems()
	{
		this.expectedItems.stone = 5;
	}

}

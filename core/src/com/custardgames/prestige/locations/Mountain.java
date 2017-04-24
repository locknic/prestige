package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.GivingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Mountain extends GivingUIItem
{
	public Mountain(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		if (!hasVisitor && inventory.stone < 4)
		{
			inventory.stone += 1;
		}
	}

	@Override
	public String getDescription()
	{
		return "Go mining to get " + inventory.stone + " stone. Mines collect 1 stone per day from falling rocks (max 4).";

	}

	@Override
	public String getName()
	{
		return "Mines";
	}
}
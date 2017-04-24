package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.GivingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Forest extends GivingUIItem
{
	public Forest(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		if(!hasVisitor)
		{
			if (inventory.wood < 4)
			{
				inventory.wood += 2;
			}
			else
			{
				inventory.wood = 5;
			}
		}
	}

	@Override
	public String getDescription()
	{
		return "Chop down trees to get " + inventory.wood + " wood. The forest grows 2 wood per day (max 5).";

	}

	@Override
	public String getName()
	{
		return "Forest";
	}

}

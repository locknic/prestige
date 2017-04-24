package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.ui.GameStage;

public abstract class GivingUIItem extends VisitableUIItem
{

	public GivingUIItem(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public boolean visitAction()
	{
		if (!inventory.isEmpty())
		{
			gameStage.getTurnPlayer().inventory.takeInventory(inventory);
			return true;
		}
		else
		{
			return false;
		}
	}

}

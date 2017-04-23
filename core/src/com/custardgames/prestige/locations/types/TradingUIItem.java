package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Inventory;

public abstract class TradingUIItem extends VisitableUIItem
{
	public Inventory expectedItems;
	
	public TradingUIItem(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
		expectedItems = new Inventory();
		
		setExpectedItems();
	}
	
	public abstract void setExpectedItems();

	@Override
	public boolean visitAction()
	{
		if (gameStage.getTurnPlayer().inventory.trade(expectedItems, inventory))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}

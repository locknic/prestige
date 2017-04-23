package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Inventory;
import com.custardgames.prestige.Player;

public abstract class CollectingUIItem extends VisitableUIItem
{
	protected final Player player;
	public Inventory collection;
	public boolean constructed;

	public CollectingUIItem(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor);
		this.player = player;
		this.collection = new Inventory();
		this.initCollection();
		this.constructed = false;
	}

	public abstract void initCollection();
	
	@Override
	public void turnPassed()
	{
		player.inventory.collectInventory(collection);
	}
	
	@Override
	public boolean visitAction()
	{
		if (!constructed)
		{
			constructed = true;
			return true;
		}
		else
		{
			return false;
		}
	}
}

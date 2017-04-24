package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Inventory;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.ui.GameStage;

public abstract class CollectingUIItem extends VisitableUIItem
{
	protected final Player player;
	public Inventory collection;

	public CollectingUIItem(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor);
		this.player = player;
		this.collection = new Inventory();
		this.initCollection();
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
		return false;
	}
}

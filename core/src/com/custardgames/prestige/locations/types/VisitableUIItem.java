package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.custardgames.prestige.entities.Inventory;
import com.custardgames.prestige.turns.TurnItem;
import com.custardgames.prestige.ui.GameStage;
import com.custardgames.prestige.ui.ToolTip;
import com.custardgames.prestige.ui.UIItem;

public abstract class VisitableUIItem extends UIItem implements TurnItem, ToolTip
{
	protected final GameStage gameStage;

	public final Actor actor;

	public boolean hasVisitor;
	public Inventory inventory;

	public VisitableUIItem(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.actor = actor;
		if (actor != null)
		{
			this.actor.addListener(this);
			gameStage.turnItems.add(this);
		}
		this.hasVisitor = false;
		this.inventory = new Inventory();
	}
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		gameStage.requestTooltip(this);
	}

	@Override
	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
	{
		gameStage.stopTooltipRequest();
	}
	
	@Override
	public void clicked(InputEvent e, float x, float y)
	{
		visit();
	}

	public void visit()
	{
		gameStage.visitLocation(this);
	}

	public abstract boolean visitAction();
	
}

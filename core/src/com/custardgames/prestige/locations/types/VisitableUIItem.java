package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Inventory;
import com.custardgames.prestige.UIItem;
import com.custardgames.prestige.turns.TurnItem;

public abstract class VisitableUIItem extends UIItem implements TurnItem
{
	protected final GameStage gameStage;

	public Actor actor;

	public String description;
	public boolean hasVisitor;

	public Inventory inventory;

	public VisitableUIItem(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.name = actor.getName();
		this.actor = actor;
		this.actor.addListener(this);
		this.hasVisitor = false;
		this.inventory = new Inventory();

		gameStage.turnItems.add(this);
	}

	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		System.out.println("ENTERED " + name);
	}

	@Override
	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
	{
		System.out.println("EXITED " + name);
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

package com.custardgames.prestige.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.custardgames.prestige.entities.Inventory;
import com.custardgames.prestige.locations.types.ConstructibleUIItem;
import com.custardgames.prestige.locations.types.VisitableUIItem;

public abstract class ConstructionCard extends UIItem
{
	protected final GameStage gameStage;
	protected final Actor actor;
	
	public Inventory cost;
	public Inventory reward;
	
	public ConstructionCard(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.actor = actor;
		cost = new Inventory();
		reward = new Inventory();
		initCostAndReward();
	}
	
	public abstract void initCostAndReward();
	
	public abstract VisitableUIItem construct(Actor actor);
	
	@Override
	public void enter(InputEvent event, float x, float y, int pointer, Actor fromActor)
	{
		gameStage.requestBuildingCost(cost);
		gameStage.requestTooltip(getToolTip());
	}

	@Override
	public void exit(InputEvent event, float x, float y, int pointer, Actor toActor)
	{
		gameStage.stopBuildingCostRequest();
		gameStage.stopTooltipRequest();
	}
	
	@Override
	public void clicked(InputEvent e, float x, float y)
	{
		visit();
	}
	
	public abstract ToolTip getToolTip();
	
	public void visit()
	{
		ConstructibleUIItem constructionSite = gameStage.getConstructionZone();
		if (constructionSite != null)
		{
			if (gameStage.getTurnPlayer().inventory.trade(cost, reward))
			{
				VisitableUIItem item = construct(constructionSite.actor);
				gameStage.constructPlayerLocation(item);
			}
		}
	}
	
	public class ToolTipHolder implements ToolTip
	{
		String name;
		String description;
		
		public ToolTipHolder(String name, String description)
		{
			this.name = name;
			this.description = description;
		}
		
		@Override
		public String getName()
		{
			return name;
		}

		@Override
		public String getDescription()
		{
			return description;
		}
		
	}
}

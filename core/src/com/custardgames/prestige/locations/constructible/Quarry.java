package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.locations.types.CollectingUIItem;
import com.custardgames.prestige.ui.GameStage;

public class Quarry extends CollectingUIItem
{
	public static final String DESCRIPTION = "Dig your own quarry to automatically collect 2 food every day.";
	
	public Quarry(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void initCollection()
	{
		collection.stone += 2;
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}

	@Override
	public String getName()
	{
		return "Quarry";
	}
}

package com.custardgames.prestige.locations;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.locations.types.GivingUIItem;

public class Dock extends GivingUIItem
{

	public Dock(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
	}

	@Override
	public void turnPassed()
	{
		inventory.gold += 1;
	}

}

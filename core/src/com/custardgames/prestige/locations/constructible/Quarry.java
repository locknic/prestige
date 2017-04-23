package com.custardgames.prestige.locations.constructible;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.GameStage;
import com.custardgames.prestige.Player;
import com.custardgames.prestige.locations.types.CollectingUIItem;

public class Quarry extends CollectingUIItem
{
	public Quarry(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor, player);
	}

	@Override
	public void initCollection()
	{
		collection.stone += 1;
	}
}

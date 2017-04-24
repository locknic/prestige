package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.entities.Player;
import com.custardgames.prestige.ui.GameStage;

public abstract class PlayerTradingUIItem extends TradingUIItem
{
	protected final Player player;
	
	public PlayerTradingUIItem(GameStage gameStage, Actor actor, Player player)
	{
		super(gameStage, actor);
		this.player = player;
	}

	@Override
	public boolean visitAction()
	{
		if (gameStage.getTurnPlayer() == player)
		{
			return super.visitAction();
		}
		else
		{
			return false;
		}
	}

}

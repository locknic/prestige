package com.custardgames.prestige.ai;

import com.custardgames.prestige.ui.GameStage;

public abstract class AI
{
	public GameStage gameStage;

	public abstract void act();
	
	public void setGameStage(GameStage gameStage)
	{
		this.gameStage = gameStage;
	}
}

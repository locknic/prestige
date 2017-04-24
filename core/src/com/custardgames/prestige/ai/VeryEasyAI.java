package com.custardgames.prestige.ai;

public class VeryEasyAI extends AI
{
	@Override
	public void act()
	{
		if (!gameStage.turnManager.player1Turn)
		{
			if (gameStage.player2.inventory.gold < 8)
			{
				if (!gameStage.dock.hasVisitor)
				{
					gameStage.visitLocation(gameStage.dock);
				}
				else
				{
					gameStage.visitLocation(gameStage.fruit);
				}
			}
			else
			{
				if (!gameStage.church.hasVisitor)
				{
					gameStage.visitLocation(gameStage.church);
				}
				else
				{
					gameStage.visitLocation(gameStage.dock);
				}
			}
		}
	}
}

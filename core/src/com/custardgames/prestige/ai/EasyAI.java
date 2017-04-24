package com.custardgames.prestige.ai;

import com.custardgames.prestige.entities.Player;

public class EasyAI extends AI
{
	boolean moved = false;
	
	@Override
	public void act()
	{
		Player player2 = gameStage.player2;
		if (!gameStage.turnManager.player1Turn && !moved)
		{
			if (player2.inventory.food >= 20)
			{
				gameStage.visitLocation(gameStage.shelter);
				moved = true;
				return;
			}
			
			if (player2.inventory.gold < 3)
			{
				if (!gameStage.dock.hasVisitor)
				{
					gameStage.visitLocation(gameStage.dock);
					moved = true;
					return;
				}
			}
			
			if (player2.inventory.food < 6)
			{
				if (!gameStage.fruit.hasVisitor)
				{
					gameStage.visitLocation(gameStage.fruit);
					moved = true;
					return;
				}
			}
			
			if (player2.inventory.wood < 2)
			{
				if (!gameStage.forest.hasVisitor)
				{
					gameStage.visitLocation(gameStage.forest);
					moved = true;
					return;
				}
			}
			
			if (player2.inventory.gold >= 3 && player2.inventory.food >= 6 && player2.inventory.wood >= 2)
			{
				gameStage.fieldCard.visit();
				moved = true;
				return;
			}
			
			if (!gameStage.dock.hasVisitor)
			{
				gameStage.visitLocation(gameStage.dock);
				moved = true;
				return;
			}
			
			if (!gameStage.fruit.hasVisitor)
			{
				gameStage.visitLocation(gameStage.fruit);
				moved = true;
				return;
			}
		}
		else if (gameStage.turnManager.player1Turn)
		{
			moved = false;
		}
	}

}

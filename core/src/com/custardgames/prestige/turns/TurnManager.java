package com.custardgames.prestige.turns;

import com.custardgames.prestige.GameStage;

public class TurnManager
{
	private final GameStage gameStage;
	public boolean player1Turn;
	public int month;
	public boolean usedTurn;

	public TurnManager(GameStage gameStage)
	{
		this.gameStage = gameStage;
		this.player1Turn = false;
		this.month = 1;
		this.usedTurn = false;

	}

	public void nextTurn()
	{
		player1Turn = !player1Turn;
		gameStage.initTurn();

		if (player1Turn)
		{
			month++;
		}

		if (month == 13)
		{
			endGame();
		}
	}

	public void endGame()
	{
		gameStage.endGame();
	}
}

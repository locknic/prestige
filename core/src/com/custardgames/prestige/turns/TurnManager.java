package com.custardgames.prestige.turns;

import com.custardgames.prestige.ui.GameStage;

public class TurnManager
{
	public static final int MAX_DAYS = 30;

	private final GameStage gameStage;
	public boolean player1Turn;
	public int day;
	public boolean usedTurn;

	public TurnManager(GameStage gameStage)
	{
		this.gameStage = gameStage;
		this.player1Turn = false;
		this.day = 1;
		this.usedTurn = false;

	}

	public void nextTurn()
	{
		player1Turn = !player1Turn;
		gameStage.initTurn();

		day++;

		if (day > MAX_DAYS)
		{
			endGame();
		}
	}

	public void endGame()
	{
		gameStage.endGame();
	}
}

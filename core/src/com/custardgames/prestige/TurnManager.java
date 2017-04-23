package com.custardgames.prestige;

public class TurnManager
{
	boolean player1Turn;
	int month;
	
	public TurnManager()
	{
		this.player1Turn = false;
	}
	
	public void nextTurn()
	{
		player1Turn = !player1Turn;
		
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
		
	}
}

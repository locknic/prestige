package com.custardgames.prestige;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player
{
	private final GameStage gameStage;
	
	int gold;
	int wood;
	int stone;
	int food;
	int prestige;
	
	Actor actor;
	Actor target;
	
	public Player(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;
		this.gold = 1;
		this.wood = 0;
		this.stone = 0;
		this.food = 3;
		this.prestige = 0;
		
		this.actor = actor;
	}
	
	public void addVisitAction()
	{
		
	}
	
	
}

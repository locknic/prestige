package com.custardgames.prestige;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.locations.types.VisitableUIItem;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class Player
{
	private final GameStage gameStage;

	public Inventory inventory;
	public Actor actor;
	public Actor house;
	public VisitableUIItem target;

	public Player(GameStage gameStage, Actor actor)
	{
		this.gameStage = gameStage;

		inventory = new Inventory();
		inventory.gold = 1;
		inventory.wood = 0;
		inventory.stone = 0;
		inventory.food = 3;
		inventory.prestige = 0;

		this.actor = actor;
	}

	public void goHome()
	{
		actor.addAction(sequence(moveTo(house.getX(), house.getY(), 0.5f), delay(0.1f), run(new Runnable()
		{
			public void run()
			{
				if (target != null)
				{
					target.hasVisitor = false;
					target = null;
				}

				gameStage.startTurn();
			}
		})));
	}

	public void addVisitAction(VisitableUIItem destination)
	{
		target = destination;

		actor.addAction(sequence(moveTo(destination.actor.getX(), destination.actor.getY(), 0.5f), delay(0.1f), run(new Runnable()
		{
			public void run()
			{
				target.hasVisitor = true;
				gameStage.finishTurn();
			}
		})));
	}

}

package com.custardgames.prestige;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class GameStage extends Stage
{
	private Prestige game;
	
	TurnManager turnManager;
	
	CompositeActor uiActor;

	Player player1;
	Player player2;
	Actor player1House;
	Actor player2House;
	
	VisitableUIItem forest;
	VisitableUIItem mountain;
	VisitableUIItem fruit;
	VisitableUIItem dock;
	
	public GameStage(Prestige game)
	{
		super(new FitViewport(Prestige.WIDTH, Prestige.HEIGHT));
		Gdx.input.setInputProcessor(this);

		turnManager = new TurnManager();
		uiActor = new CompositeActor(game.sceneLoader.loadVoFromLibrary("entityButtons"), game.sceneLoader.getRm());
		addActor(uiActor);
		
		setup();
	}
	
	public void setup ()
	{
		for (Actor child : uiActor.getChildren())
		{
			if (child.getName().equals("player1"))
			{
				player1 = new Player(this, child);
			} 
			else if (child.getName().equals("player2"))
			{
				player2 = new Player(this, child);
			}
			else if (child.getName().equals("player1-house"))
			{
				player1House = child;
			}
			else if (child.getName().equals("player2-house"))
			{
				player2House = child;
			}
			else if (child.getName().equals("forest"))
			{
				forest = new VisitableUIItem(this, child);
			}
			else if (child.getName().equals("mountain"))
			{
				mountain = new VisitableUIItem(this, child);
			}
			else if (child.getName().equals("fruit"))
			{
				fruit = new VisitableUIItem(this, child);
			}
			else if (child.getName().equals("dock"))
			{
				dock = new VisitableUIItem(this, child);
			}
		}
	}
	
	public Player getTurnPlayer()
	{
		if (turnManager.player1Turn)
		{
			return player1;
		}
		else
		{
			return player2;
		}
	}
	
	public void visitForest()
	{
		
	}
	
	
}

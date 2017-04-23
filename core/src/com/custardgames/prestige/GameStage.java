package com.custardgames.prestige;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.custardgames.prestige.locations.Church;
import com.custardgames.prestige.locations.Dock;
import com.custardgames.prestige.locations.Forest;
import com.custardgames.prestige.locations.Fruit;
import com.custardgames.prestige.locations.Mason;
import com.custardgames.prestige.locations.Mountain;
import com.custardgames.prestige.locations.Shelter;
import com.custardgames.prestige.locations.Woodshop;
import com.custardgames.prestige.locations.types.ConstructibleUIItem;
import com.custardgames.prestige.locations.types.VisitableUIItem;
import com.custardgames.prestige.screens.MainMenuScreen;
import com.custardgames.prestige.turns.TurnItem;
import com.custardgames.prestige.turns.TurnManager;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class GameStage extends Stage
{
	private final Prestige game;

	TurnManager turnManager;

	CompositeActor uiActor;

	public Player player1;
	public Player player2;
	public Actor player1House;
	public Actor player2House;

	public Forest forest;
	public Mountain mountain;
	public Fruit fruit;
	public Dock dock;
	public Woodshop woodshop;
	public Mason mason;
	public Shelter shelter;
	public Church church;
	
	public Array<TurnItem> turnItems;
	
	public Array<UIItem> player1ConstructionZones;
	public Array<UIItem> player2ConstructionZones;

	public GameStage(Prestige game)
	{
		super(new FitViewport(Prestige.WIDTH, Prestige.HEIGHT));
		Gdx.input.setInputProcessor(this);
		
		this.game = game;

		turnManager = new TurnManager(this);
		turnItems = new Array<TurnItem>();
		player1ConstructionZones = new Array<UIItem>();
		
		uiActor = new CompositeActor(game.sceneLoader.loadVoFromLibrary("entityButtons"), game.sceneLoader.getRm());
		addActor(uiActor);

		setup();
		initTurn();
	}

	public void setup()
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
				forest = new Forest(this, child);
			}
			else if (child.getName().equals("mountain"))
			{
				mountain = new Mountain(this, child);
			}
			else if (child.getName().equals("fruit"))
			{
				fruit = new Fruit(this, child);
			}
			else if (child.getName().equals("dock"))
			{
				dock = new Dock(this, child);
			}
			else if (child.getName().equals("woodshop"))
			{
				woodshop = new Woodshop(this, child);
			}
			else if (child.getName().equals("mason"))
			{
				mason = new Mason(this, child);
			}
			else if (child.getName().equals("shelter"))
			{
				shelter = new Shelter(this, child);
			}
			else if (child.getName().equals("church"))
			{
				church = new Church(this, child);
			}
			else if (child.getName().startsWith("zone1-"))
			{
				player1ConstructionZones.add(new ConstructibleUIItem(child));
			}
			else if (child.getName().startsWith("zone2-"))
			{
				player1ConstructionZones.add(new ConstructibleUIItem(child));
			}
		}

		player1.house = player1House;
		player2.house = player2House;
	}
	
	public void endGame()
	{
		game.changeScreen(new MainMenuScreen(game));
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

	public void initTurn()
	{
		getTurnPlayer().goHome();
		
		for(TurnItem item: turnItems)
		{
			item.turnPassed();
		}
	}

	public void startTurn()
	{
		turnManager.usedTurn = false;
	}

	public void initFinish()
	{
		turnManager.usedTurn = true;
	}

	public void finishTurn()
	{
		turnManager.nextTurn();
	}

	public void visitLocation(VisitableUIItem location)
	{
		if (!turnManager.usedTurn && !location.hasVisitor)
		{
			if (location.visitAction())
			{
				initFinish();
				getTurnPlayer().addVisitAction(location);
			}
		}
	}

}

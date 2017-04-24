package com.custardgames.prestige.ui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.custardgames.prestige.Prestige;
import com.custardgames.prestige.ai.AI;
import com.custardgames.prestige.entities.Inventory;
import com.custardgames.prestige.entities.InventoryLabels;
import com.custardgames.prestige.entities.Player;
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
import com.custardgames.prestige.screens.GameScreen;
import com.custardgames.prestige.turns.TurnItem;
import com.custardgames.prestige.turns.TurnManager;
import com.custardgames.prestige.ui.cards.CarpenterCard;
import com.custardgames.prestige.ui.cards.FieldCard;
import com.custardgames.prestige.ui.cards.PlantationCard;
import com.custardgames.prestige.ui.cards.QuarryCard;
import com.custardgames.prestige.ui.cards.SculptorCard;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class GameStage extends Stage
{
	private final Prestige game;

	public static final int GAME_WIDTH = 896;
	public static final int GAME_HEIGHT = 512;

	public TurnManager turnManager;

	CompositeActor locationsActor;
	CompositeActor uiActor;

	public Player player1;
	public InventoryLabels player1InventoryLabels;
	public Actor player1House;

	public Player player2;
	public InventoryLabels player2InventoryLabels;
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

	public Array<ConstructibleUIItem> player1ConstructionZones;
	public Array<ConstructibleUIItem> player2ConstructionZones;

	public Array<VisitableUIItem> player1ConstructedZones;
	public Array<VisitableUIItem> player2ConstructedZones;

	public FieldCard fieldCard;
	public PlantationCard plantationCard;
	public QuarryCard quarryCard;
	public SculptorCard sculptorCard;
	public CarpenterCard carpenterCard;

	public Label dayLabel;

	public InventoryLabels forestLabel;
	public InventoryLabels mountainLabel;
	public InventoryLabels fruitLabel;
	public InventoryLabels dockLabel;

	public CompositeActor tooltip;
	public CompositeActor buildingCost;

	public Scoreboard scoreboard;
	
	public AI ai;

	public GameStage(Prestige game, AI ai)
	{
		this(game);
		
		this.ai = ai;
		ai.setGameStage(this);
	}
	
	public GameStage(Prestige game)
	{
		super();
		this.game = game;

		turnManager = new TurnManager(this);
		turnItems = new Array<TurnItem>();

		player1ConstructionZones = new Array<ConstructibleUIItem>();
		player2ConstructionZones = new Array<ConstructibleUIItem>();

		player1ConstructedZones = new Array<VisitableUIItem>();
		player2ConstructedZones = new Array<VisitableUIItem>();

		player1InventoryLabels = new InventoryLabels(this);
		player2InventoryLabels = new InventoryLabels(this);

		forestLabel = new InventoryLabels(this);
		mountainLabel = new InventoryLabels(this);
		fruitLabel = new InventoryLabels(this);
		dockLabel = new InventoryLabels(this);

		locationsActor = new CompositeActor(game.sceneLoader.loadVoFromLibrary("entityButtons"), game.sceneLoader.getRm());
		addActor(locationsActor);

		setup();
		initTurn();
	}

	@Override
	public void act()
	{
		super.act();

	}

	public void endGame()
	{
		String result;
		
		if (player1.inventory.prestige > player2.inventory.prestige)
		{
			result = "Player 1 wins!";
		}
		else if (player2.inventory.prestige > player1.inventory.prestige)
		{
			result = "Player 2 wins!";
		}
		else
		{
			result = "It's a draw!";
		}

		((Label) ((CompositeActor) scoreboard.actor).getItem("score-desc")).setText(result);
		((Label) ((CompositeActor) scoreboard.actor).getItem("p1-score")).setText(Integer.toString(player1.inventory.prestige));
		((Label) ((CompositeActor) scoreboard.actor).getItem("p2-score")).setText(Integer.toString(player2.inventory.prestige));
		scoreboard.actor.setVisible(true);
	}

	public void reloadGame()
	{
		game.changeScreen(new GameScreen(game));
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

		for (TurnItem item : turnItems)
		{
			item.turnPassed();
		}

		player1InventoryLabels.updateLabels();
		player2InventoryLabels.updateLabels();
	}

	public void startTurn()
	{
		turnManager.usedTurn = false;
		dayLabel.setText("DAY " + turnManager.day);
		updateLabels();
	}

	public void initFinish()
	{
		turnManager.usedTurn = true;

	}

	public void finishTurn()
	{
		updateLabels();

		player1InventoryLabels.updateLabels();
		player2InventoryLabels.updateLabels();

		turnManager.nextTurn();
	}

	public void updateLabels()
	{
		forestLabel.updateLabels();
		mountainLabel.updateLabels();
		fruitLabel.updateLabels();
		dockLabel.updateLabels();
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

	public ConstructibleUIItem getConstructionZone()
	{
		if (turnManager.player1Turn)
		{
			if (player1ConstructionZones.size > 0)
			{
				ConstructibleUIItem result = player1ConstructionZones.get(0);
				player1ConstructionZones.removeIndex(0);
				return result;
			}
		}
		else
		{
			if (player2ConstructionZones.size > 0)
			{
				ConstructibleUIItem result = player2ConstructionZones.get(0);
				player2ConstructionZones.removeIndex(0);
				return result;
			}
		}

		return null;
	}

	public void constructPlayerLocation(VisitableUIItem item)
	{
		if (turnManager.player1Turn)
		{
			player1ConstructedZones.add(item);
		}
		else
		{
			player2ConstructedZones.add(item);
		}

		initFinish();
		getTurnPlayer().addVisitAction(item);
	}

	public void setup()
	{
		for (Actor child : locationsActor.getChildren())
		{
			if (child.getName().equals("player1"))
			{
				player1 = new Player(this, child);
				player1InventoryLabels.setInventory(player1.inventory);
			}
			else if (child.getName().equals("player2"))
			{
				player2 = new Player(this, child);
				player2InventoryLabels.setInventory(player2.inventory);
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
				forestLabel.setInventory(forest.inventory);
			}
			else if (child.getName().equals("mountain"))
			{
				mountain = new Mountain(this, child);
				mountainLabel.setInventory(mountain.inventory);
			}
			else if (child.getName().equals("fruit"))
			{
				fruit = new Fruit(this, child);
				fruitLabel.setInventory(fruit.inventory);
			}
			else if (child.getName().equals("dock"))
			{
				dock = new Dock(this, child);
				dockLabel.setInventory(dock.inventory);
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
				player2ConstructionZones.add(new ConstructibleUIItem(child));
			}
			else if (child.getName().equals("farm-card"))
			{
				fieldCard = new FieldCard(this, child);
			}
			else if (child.getName().equals("plantation-card"))
			{
				plantationCard = new PlantationCard(this, child);
			}
			else if (child.getName().equals("quarry-card"))
			{
				quarryCard = new QuarryCard(this, child);
			}
			else if (child.getName().equals("sculptor-card"))
			{
				sculptorCard = new SculptorCard(this, child);
			}
			else if (child.getName().equals("carpenter-card"))
			{
				carpenterCard = new CarpenterCard(this, child);
			}
			else if (child.getName().equals("p1-prestige"))
			{
				player1InventoryLabels.setPrestige(getLabel(child));
			}
			else if (child.getName().equals("p1-gold"))
			{
				player1InventoryLabels.setGold(getLabel(child));
			}
			else if (child.getName().equals("p1-wood"))
			{
				player1InventoryLabels.setWood(getLabel(child));
			}
			else if (child.getName().equals("p1-stone"))
			{
				player1InventoryLabels.setStone(getLabel(child));
			}
			else if (child.getName().equals("p1-food"))
			{
				player1InventoryLabels.setFood(getLabel(child));
			}
			else if (child.getName().equals("p2-prestige"))
			{
				player2InventoryLabels.setPrestige(getLabel(child));
			}
			else if (child.getName().equals("p2-gold"))
			{
				player2InventoryLabels.setGold(getLabel(child));
			}
			else if (child.getName().equals("p2-wood"))
			{
				player2InventoryLabels.setWood(getLabel(child));
			}
			else if (child.getName().equals("p2-stone"))
			{
				player2InventoryLabels.setStone(getLabel(child));
			}
			else if (child.getName().equals("p2-food"))
			{
				player2InventoryLabels.setFood(getLabel(child));
			}
			else if (child.getName().equals("dayButton"))
			{
				dayLabel = getLabel(child);
			}
			else if (child.getName().equals("forestButton"))
			{
				forestLabel.setWood(getLabel(child));
			}
			else if (child.getName().equals("mountainButton"))
			{
				mountainLabel.setStone(getLabel(child));
			}
			else if (child.getName().equals("fruitButton"))
			{
				fruitLabel.setFood(getLabel(child));
			}
			else if (child.getName().equals("dockButton"))
			{
				dockLabel.setGold(getLabel(child));
			}
			else if (child.getName().equals("tooltip"))
			{
				tooltip = (CompositeActor) child;
				tooltip.setVisible(false);
			}
			else if (child.getName().equals("buildingCost"))
			{
				buildingCost = (CompositeActor) child;
				buildingCost.setVisible(false);
			}
			else if (child.getName().equals("scoreboard"))
			{
				child.setVisible(false);
				scoreboard = new Scoreboard(this, child);
			}
		}

		player1.house = player1House;
		player2.house = player2House;
	}

	public void requestTooltip(ToolTip toolTip)
	{
		((Label) tooltip.getItem("tooltipName")).setText(toolTip.getName());
		((Label) tooltip.getItem("tooltipDesc")).setText(toolTip.getDescription());
		tooltip.setVisible(true);
	}

	public void stopTooltipRequest()
	{
		tooltip.setVisible(false);
	}

	public void requestBuildingCost(Inventory cost)
	{
		getLabel(buildingCost.getItem("cost-gold")).setText(Integer.toString(cost.gold));
		getLabel(buildingCost.getItem("cost-wood")).setText(Integer.toString(cost.wood));
		getLabel(buildingCost.getItem("cost-stone")).setText(Integer.toString(cost.stone));
		getLabel(buildingCost.getItem("cost-food")).setText(Integer.toString(cost.food));

		buildingCost.setVisible(true);
	}

	public void stopBuildingCostRequest()
	{
		buildingCost.setVisible(false);
	}

	public Label getLabel(Actor child)
	{
		if (child instanceof CompositeActor)
		{
			for (Actor subchild : ((CompositeActor) child).getChildren())
			{
				System.out.println(subchild.getClass().getName());
				if (subchild instanceof Label)
				{
					return (Label) subchild;
				}
			}
		}

		return null;
	}

}

package com.custardgames.prestige.entities;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.custardgames.prestige.ui.GameStage;

public class InventoryLabels
{
	public final GameStage gameStage;

	public Inventory inventory;

	public Label prestige;
	public Label gold;
	public Label wood;
	public Label stone;
	public Label food;

	public Label prestigeReflect;
	public Label goldReflect;
	public Label woodReflect;
	public Label stoneReflect;
	public Label foodReflect;

	public int prestigeOld;
	public int goldOld;
	public int woodOld;
	public int stoneOld;
	public int foodOld;

	public InventoryLabels(GameStage gameStage)
	{
		this.gameStage = gameStage;
	}

	public void setInventory(Inventory inventory)
	{
		this.inventory = inventory;

		prestigeOld = inventory.prestige;
		goldOld = inventory.gold;
		woodOld = inventory.wood;
		stoneOld = inventory.stone;
		foodOld = inventory.food;
	}

	public void setPrestige(Label prestige)
	{
		this.prestige = prestige;
		prestigeReflect = new Label("", prestige.getStyle());
		Vector2 coords = prestige.localToStageCoordinates(new Vector2(0f, 0f));
		prestigeReflect.setPosition(coords.x, coords.y);
		gameStage.addActor(prestigeReflect);
	}

	public void setGold(Label gold)
	{
		this.gold = gold;
		goldReflect = new Label("", gold.getStyle());
		Vector2 coords = gold.localToStageCoordinates(new Vector2(0f, 0f));
		goldReflect.setPosition(coords.x, coords.y);
		gameStage.addActor(goldReflect);
	}

	public void setWood(Label wood)
	{
		this.wood = wood;
		woodReflect = new Label("", wood.getStyle());
		Vector2 coords = wood.localToStageCoordinates(new Vector2(0f, 0f));
		woodReflect.setPosition(coords.x, coords.y);
		gameStage.addActor(woodReflect);
	}

	public void setStone(Label stone)
	{
		this.stone = stone;
		stoneReflect = new Label("", stone.getStyle());
		Vector2 coords = stone.localToStageCoordinates(new Vector2(0f, 0f));
		stoneReflect.setPosition(coords.x, coords.y);
		gameStage.addActor(stoneReflect);
	}

	public void setFood(Label food)
	{
		this.food = food;
		foodReflect = new Label("", food.getStyle());
		Vector2 coords = food.localToStageCoordinates(new Vector2(0f, 0f));
		foodReflect.setPosition(coords.x, coords.y);
		gameStage.addActor(foodReflect);
	}

	public void updateLabels()
	{
		if (inventory != null)
		{
			if (prestige != null)
			{
				this.prestige.setText(Integer.toString(inventory.prestige));

				reflect(inventory.prestige, prestigeOld, prestigeReflect);
				prestigeOld = inventory.prestige;
			}
			if (gold != null)
			{
				this.gold.setText(Integer.toString(inventory.gold));

				reflect(inventory.gold, goldOld, goldReflect);
				goldOld = inventory.gold;
			}
			if (wood != null)
			{
				this.wood.setText(Integer.toString(inventory.wood));

				reflect(inventory.wood, woodOld, woodReflect);
				woodOld = inventory.wood;
			}
			if (stone != null)
			{
				this.stone.setText(Integer.toString(inventory.stone));

				reflect(inventory.stone, stoneOld, stoneReflect);
				stoneOld = inventory.stone;
			}
			if (food != null)
			{
				this.food.setText(Integer.toString(inventory.food));

				reflect(inventory.food, foodOld, foodReflect);
				foodOld = inventory.food;
			}
		}
	}

	public void reflect(int num1, int num2, Label label)
	{
		int result = num1 - num2;
		if (result > 0)
		{
			label.setText("+" + result);
			reflectAction(label);
		}
		else if (result < 0)
		{
			label.setText("-" + result);
			reflectAction(label);
		}
	}

	public void reflectAction(Label actor)
	{
		actor.addAction(sequence(alpha(1.0f, 0.1f), alpha(0.0f, 1f)));
		actor.addAction(sequence(moveBy(-5f, -30f, 1f), moveBy(5f, 30f, 0f)));
	}
}

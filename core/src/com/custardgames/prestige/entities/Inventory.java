package com.custardgames.prestige.entities;

public class Inventory
{
	public int gold;
	public int wood;
	public int stone;
	public int food;
	public int prestige;

	public Inventory()
	{
		clearInventory();
	}

	public void clearInventory()
	{
		this.gold = 0;
		this.wood = 0;
		this.stone = 0;
		this.food = 0;
		this.prestige = 0;
	}

	public void takeInventory(Inventory inventory)
	{
		this.gold += inventory.gold;
		this.wood += inventory.wood;
		this.stone += inventory.stone;
		this.food += inventory.food;
		this.prestige += inventory.prestige;

		inventory.clearInventory();
	}
	
	public void collectInventory(Inventory inventory)
	{
		this.gold += inventory.gold;
		this.wood += inventory.wood;
		this.stone += inventory.stone;
		this.food += inventory.food;
		this.prestige += inventory.prestige;
	}

	public boolean isEmpty()
	{
		if (gold <= 0 && wood <= 0 && stone <= 0 & food <= 0 & prestige <= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean trade(Inventory expected, Inventory result)
	{
		if (gold >= expected.gold && wood >= expected.wood && stone >= expected.stone && food >= expected.food && prestige >= expected.prestige)
		{
			this.gold -= expected.gold;
			this.wood -= expected.wood;
			this.stone -= expected.stone;
			this.food -= expected.food;
			this.prestige -= expected.prestige;

			takeInventory(result);

			return true;
		}
		else
		{
			return false;
		}
	}
}

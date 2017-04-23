package com.custardgames.prestige.locations.types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.custardgames.prestige.UIItem;

public class ConstructibleUIItem extends UIItem
{
	public Actor actor;
	
	public ConstructibleUIItem(Actor actor)
	{
		this.actor = actor;
	}
}

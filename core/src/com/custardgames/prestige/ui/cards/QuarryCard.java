package com.custardgames.prestige.ui.cards;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.custardgames.prestige.locations.constructible.Quarry;
import com.custardgames.prestige.locations.types.VisitableUIItem;
import com.custardgames.prestige.ui.ConstructionCard;
import com.custardgames.prestige.ui.GameStage;
import com.custardgames.prestige.ui.ToolTip;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class QuarryCard extends ConstructionCard
{

	public QuarryCard(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
		this.actor.addListener(this);
	}

	@Override
	public void initCostAndReward()
	{
		cost.gold = 5;
		cost.wood = 4;
		cost.stone = 4;
		cost.food = 4;
	}

	@Override
	public VisitableUIItem construct(Actor actor)
	{
		Quarry field = new Quarry(gameStage, actor, gameStage.getTurnPlayer());
		((Image) actor).setDrawable(((Image) ((CompositeActor) this.actor).getItem("quarry-image")).getDrawable());
		actor.addAction(color(new Color(1f,1f,1f,1f)));
		return field;
	}
	
	@Override
	public ToolTip getToolTip()
	{
		return new ToolTipHolder("Quarry", "Dig your own quarry to automatically collect 1 food every day.");
	}

}

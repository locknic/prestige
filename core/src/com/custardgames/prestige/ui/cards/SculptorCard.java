package com.custardgames.prestige.ui.cards;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.color;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.custardgames.prestige.locations.constructible.Sculptor;
import com.custardgames.prestige.locations.types.VisitableUIItem;
import com.custardgames.prestige.ui.ConstructionCard;
import com.custardgames.prestige.ui.GameStage;
import com.custardgames.prestige.ui.ToolTip;
import com.uwsoft.editor.renderer.scene2d.CompositeActor;

public class SculptorCard extends ConstructionCard
{

	public SculptorCard(GameStage gameStage, Actor actor)
	{
		super(gameStage, actor);
		this.actor.addListener(this);
	}

	@Override
	public void initCostAndReward()
	{
		cost.gold = 8;
		cost.wood = 2;
		cost.stone = 4;
		cost.food = 1;
	}

	@Override
	public VisitableUIItem construct(Actor actor)
	{
		Sculptor field = new Sculptor(gameStage, actor, gameStage.getTurnPlayer());
		((Image) actor).setDrawable(((Image) ((CompositeActor) this.actor).getItem("sculptor-image")).getDrawable());
		actor.addAction(color(new Color(1f,1f,1f,1f)));
		return field;
	}
	
	@Override
	public ToolTip getToolTip()
	{
		return new ToolTipHolder("Sculptor", "Craft 6 stone to get 2 prestige here.");
	}

}

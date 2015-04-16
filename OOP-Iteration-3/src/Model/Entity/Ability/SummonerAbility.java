package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public abstract class SummonerAbility extends SkillAbility{

	public SummonerAbility(ArrayList<Entity> targetList) {
		super(targetList);
	}

}

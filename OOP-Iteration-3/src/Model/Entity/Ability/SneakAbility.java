package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public abstract class SneakAbility extends SkillAbility{

	public SneakAbility(ArrayList<Entity> targetList) {
		super(targetList);
	}

}

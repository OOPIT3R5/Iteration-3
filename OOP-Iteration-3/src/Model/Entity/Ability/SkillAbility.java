package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class SkillAbility extends Ability {
	
    protected abstract int getSkillLevel();

	protected abstract Entity getSourceEntity();
    
}

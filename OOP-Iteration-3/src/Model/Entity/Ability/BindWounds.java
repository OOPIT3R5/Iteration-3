package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;

public class BindWounds extends SkillAbility{
	
    private Entity sourceEntity;
	private Skill skill;

	public BindWounds(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
	}

	@Override
    public void execute() {
		int amountToHeal = getSkillLevel() * 2;
		getSourceEntity().changeHealth(amountToHeal);
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}

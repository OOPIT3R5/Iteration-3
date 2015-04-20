package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;

public class Heal extends SummonerAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public Heal(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }
	
	@Override
	public void execute() {
		useMana(sourceEntity);
	}
	
	@Override
	public void cast() {
		Entity targetEntity = getSourceEntity();
		targetEntity.getStatistics().changeHealth(getSkillLevel());
	}

	@Override
	public int getRequiredMana() {
		return 15;
	}

	@Override
	protected int scaleMagnitude() {
		return 0;
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
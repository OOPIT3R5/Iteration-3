package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Utility.RandomlyGenerate;

public class Attack extends SkillAbility{
	
	private Entity sourceEntity;
	private GameMap map;
	private Skill skill;
	
	public Attack(Entity sourceEntity, GameMap map, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.map = map;
		this.skill = skill;
    }

	@Override
	public void execute() {
		Entity targetEntity = getTargetEntity();
		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		int damage = (int) (probabilityOfSuccess * getSkillLevel());
		
		if (chanceOfSuccess > probabilityOfSuccess){		// success
			targetEntity.changeHealth(-1*damage);
		}
	}

	private Entity getTargetEntity() {
		return map.getEntity(getSourceEntity().getLocationFacing());
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

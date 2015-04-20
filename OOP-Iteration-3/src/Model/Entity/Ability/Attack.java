package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Utility.RandomlyGenerate;

public class Attack extends SkillAbility{
	
	private Entity sourceEntity;
	private Skill skill;
	
	public Attack(Entity sourceEntity) {
		this.sourceEntity = sourceEntity;
		this.skill = sourceEntity.getActiveSkill();
    }

	@Override
	public void execute() {
		Entity targetEntity = getTargetEntity();
		
		if (targetEntity != null){
			double probabilityOfSuccess = RandomlyGenerate.probability();
			double chanceOfSuccess = getSkillLevel()/100;
			int damage = (int) (probabilityOfSuccess * getSkillLevel());
			
			if (chanceOfSuccess > probabilityOfSuccess){		// success
				targetEntity.changeHealth(-1*damage);
			}
		}
	}

	private Entity getTargetEntity() {
		return sourceEntity.getGamemap().getEntity(getSourceEntity().getLocationFacing());
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

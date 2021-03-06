package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Entity.Skill;
import Utility.RandomlyGenerate;

public class Sleep extends SummonerAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public Sleep(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }
	
	@Override
	public void cast() {
		Entity targetEntity = getTargetEntity();
		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		
		if (targetEntity != null){
			if (chanceOfSuccess > probabilityOfSuccess){		// success
				((NPC)targetEntity).sleep();		
			} else {		// failure
				((NPC)targetEntity).provoke();
			}
		}
	}
	
	@Override
	public void execute() {
		useMana(sourceEntity);
	}

	@Override
	public int getRequiredMana() {
		return 20;
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

	private Entity getTargetEntity() {
		return sourceEntity.getGamemap().getEntity(getSourceEntity().getLocationFacing());
	}
	
	@Override
	protected int scaleMagnitude() {
		return 0;
	}
}

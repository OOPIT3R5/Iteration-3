package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;

public class Polymorph extends SummonerAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public Polymorph(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }
	
	@Override
	public void cast() {
		Entity targetEntity = getTargetEntity();
		
		if (targetEntity != null){
		
			
				
			
				
			
		}
	}
	
	@Override
	public void execute() {
		useMana(sourceEntity);
		 sourceEntity.polymorph();	

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
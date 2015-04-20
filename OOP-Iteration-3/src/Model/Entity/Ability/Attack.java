package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;

public class Attack extends SkillAbility{
	
	private Entity sourceEntity;
	private Skill skill;
	int range = 0;
	
	public Attack(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
	public void execute() {
		//Entity targetEntity = getTargetEntity();
		ArrayList<Entity> entities = sourceEntity.getGamemap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			if(checkDistance(sourceEntity.getLocation(),entities.get(i).getLocation(),1,2)){
				entities.get(i).changeHealth(-10);
			}
			
		}
		
//		if (targetEntity != null){
//			double probabilityOfSuccess = RandomlyGenerate.probability();
//			double chanceOfSuccess = getSkillLevel()/100;
//			int damage = (int) (probabilityOfSuccess * getSkillLevel() + 25);
//			
////			if (chanceOfSuccess > probabilityOfSuccess){		// success
////				targetEntity.changeHealth(-1*damage);
////			}
//		}
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
}

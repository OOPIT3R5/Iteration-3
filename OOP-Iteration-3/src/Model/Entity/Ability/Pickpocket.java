package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Utility.RandomlyGenerate;

public class Pickpocket extends SkillAbility {
	
	private Entity sourceEntity;
	private Skill skill;
	
	public Pickpocket(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
    public void execute() {
		Entity targetEntity = getTargetEntity();
		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		
		ArrayList<Entity> entities = sourceEntity.getGamemap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			if(checkDistance(sourceEntity.getLocation(),entities.get(i).getLocation(),1,2)){
				entities.get(i).stealGold(5);
				System.out.println("STOLE GOLD!!!!");
			}
			sourceEntity.awardGold(5);
		}
		
//		if (targetEntity != null){
//			if (chanceOfSuccess > probabilityOfSuccess){		// success
//				int gold = (int) (probabilityOfSuccess * 100);
//				int amountStolen = targetEntity.stealGold(gold);
//				sourceEntity.awardGold(amountStolen);
//			} else {		// failure
//				((NPC)targetEntity).provoke();		// needs to be implemented
//			}
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

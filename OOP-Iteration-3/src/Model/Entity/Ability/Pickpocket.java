package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;
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
		
		if (targetEntity != null){
			if (chanceOfSuccess > probabilityOfSuccess){		// success
				int gold = (int) (probabilityOfSuccess * 100);
				int amountStolen = targetEntity.stealGold(gold);
				sourceEntity.awardGold(amountStolen);
			} else {		// failure
				((NPC)targetEntity).provoke();		// needs to be implemented
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

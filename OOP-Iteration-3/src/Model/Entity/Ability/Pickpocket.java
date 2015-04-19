package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class Pickpocket extends SkillAbility {
	
	private Entity sourceEntity;
	private GameMap map;
	private Skill skill;
	
	public Pickpocket(Entity sourceEntity, GameMap map, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.map = map;
		this.skill = skill;
    }

	@Override
    public void execute() {
		Entity targetEntity = getTargetEntity();
		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		
		if (chanceOfSuccess > probabilityOfSuccess){		// success
			int gold = (int) (probabilityOfSuccess * 100);		// random amount of gold?
			int amountStolen = targetEntity.stealGold(gold);
			sourceEntity.awardGold(amountStolen);
		} else {		// failure
			// ((NPC)targetEntity).provoke();		// needs to be implemented
		}
	}
	
	private Entity getTargetEntity() {		// TODO: breaking LoD?
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

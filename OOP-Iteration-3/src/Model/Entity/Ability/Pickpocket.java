package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class Pickpocket extends SingleTargetAbility {
	
	private Tile targetTile;
	private Skill skill;
	private Entity sourceEntity;

	public Pickpocket(Tile targetTile, Skill skill, Entity sourceEntity) {
		this.targetTile = targetTile;
		this.skill = skill;
		this.sourceEntity = sourceEntity;
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
	
	private Entity getTargetEntity() {
		return targetTile.getEntity();
	}
	
	@Override
	protected Tile getTargetTile() {
		return targetTile;
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

}

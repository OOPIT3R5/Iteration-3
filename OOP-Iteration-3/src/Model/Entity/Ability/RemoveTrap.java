package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class RemoveTrap extends SingleTargetAbility {

	private Tile targetTile;
	private Skill skill;
	private Entity sourceEntity;
	
	public RemoveTrap(Tile targetTile, Skill skill, Entity sourceEntity){
		this.targetTile = targetTile;
		this.skill = skill;
		this.sourceEntity = sourceEntity;
    }

	@Override
    public void execute() {		
		double probabilityOfSuccess = RandomlyGenerate.probability();
		double chanceOfSuccess = getSkillLevel()/100;
		
		if (chanceOfSuccess > probabilityOfSuccess){		// success = removal
			removeTargetTrap();
		} else {						// failure = activation
			activateTargetTrap();
		}
	}
	
	private void activateTargetTrap(){
		targetTile.activateTrap(sourceEntity);
	}
	
	private void removeTargetTrap(){
		targetTile.removeTrap();
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

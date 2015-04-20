package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class RemoveTrap extends SkillAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public RemoveTrap(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
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
	
	public Tile getTargetTile(){
		return sourceEntity.getGamemap().getTile(getSourceEntity().getLocationFacing());
	}
	
	private void activateTargetTrap(){
		getTargetTile().activateTrap(sourceEntity);
	}
	
	private void removeTargetTrap(){
		getTargetTile().removeTrap();
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

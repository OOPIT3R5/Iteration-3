package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;
import Model.Items.Trap;

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
		
		HexagonalLocation location = (HexagonalLocation)sourceEntity.getLocationFacing();
		
		if (chanceOfSuccess > probabilityOfSuccess){		// success = removal
			removeTargetTrap(location);
		} else {						// failure = activation
			activateTargetTrap(location);
		}
	}
	
	public Tile getTargetTile(){
		return sourceEntity.getGamemap().getTile(getSourceEntity().getLocationFacing());
	}
	
	private void activateTargetTrap(HexagonalLocation location) {
		//GameMap map = sourceEntity.getGamemap();
		//((Trap)map.getMapObject(location)).
	}
	
	private void removeTargetTrap(HexagonalLocation location) {
		//getTargetTile().removeTrap(location);
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

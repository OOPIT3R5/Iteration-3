package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class Observe extends SkillAbility{

	private Entity sourceEntity;
	private Skill skill;
	
	public Observe(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
    public void execute() {
		double chanceOfSuccess = getSkillLevel()/100;
		
		for(Tile tile : getTargetTiles()){
			double probabilityOfSuccess = RandomlyGenerate.probability();
			if (tile != null){
				Entity targetEntity = tile.getEntity();
				if (targetEntity != null){
					if (chanceOfSuccess > probabilityOfSuccess){		// success = observed
						targetEntity.observe();
					}
				}
			}			
		}
	}
	
	public ArrayList<Tile> getTargetTiles(){
		Location center = (getSourceEntity().getLocation());
		int radius = 5;
		
		GameMap map = sourceEntity.getGamemap();
		
		ArrayList<Tile> result = new ArrayList<Tile>();
		for (HexagonalLocation location : HexagonalLocation.circle((HexagonalLocation)center ,radius)){
			result.add(map.getTile(location));
		}
		
		return result;
	}	

	@Override
	public int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}

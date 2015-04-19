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

public class Creep extends SkillAbility{

	private Entity sourceEntity;
	private GameMap map;
	private Skill skill;

	public Creep(Entity sourceEntity, GameMap map, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.map = map;
		this.skill = skill;
    }

	@Override
	public void execute() {
		double chanceOfSuccess = getSkillLevel()/50;
		double probabilityOfSuccess = RandomlyGenerate.probability();
		
		for(Tile tile : getTargetTiles()){
			if (chanceOfSuccess > probabilityOfSuccess){		// success = detection
				//((NPC)tile.getEntity()).becomeNonHostile();
			}
		}
	}

	public ArrayList<Tile> getTargetTiles(){
		Location center = (getSourceEntity().getLocation());
		int radius = 5;
		
		ArrayList<Tile> result = new ArrayList<Tile>();
		for (HexagonalLocation location : HexagonalLocation.circle((HexagonalLocation)center ,radius)){
			result.add(map.get(location));
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

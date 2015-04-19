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

public class Fireball extends SummonerAbility {
	
	private Entity sourceEntity;
	private GameMap map;
	private Skill skill;

	public Fireball(Entity sourceEntity, GameMap map, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.map = map;
		this.skill = skill;
    }

	@Override
    public void execute() {
		sourceEntity.checkMana(this);
	}

	@Override
	public void cast() {
		double chanceOfSuccess = getSkillLevel()/50;
		double probabilityOfSuccess = RandomlyGenerate.probability();
		
		for(Tile tile : getTargetTiles()){
			if (chanceOfSuccess > probabilityOfSuccess){		// success = detection
				((NPC)tile.getEntity()).changeHealth(-1*scaleMagnitude());
			}
		}
	}

	@Override
	public int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	public int getRequiredMana() {
		return 5;
	}

	@Override
	protected int scaleMagnitude() {
		return 150 * getSkillLevel()/100;
	}

	protected ArrayList<Tile> getTargetTiles(){
		Location center = (getSourceEntity().getLocation());
		int length = 3;
		
		ArrayList<Tile> result = new ArrayList<Tile>();
		for (HexagonalLocation location : HexagonalLocation.line((HexagonalLocation)center ,length,getSourceEntity().getDirectionFacing())){
			result.add(map.getTile(location));
		}
		
		return result;
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

}

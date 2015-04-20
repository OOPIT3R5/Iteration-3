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

public class Blizzard extends SummonerAbility{

	private Entity sourceEntity;
	private Skill skill;

	public Blizzard(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
    public void execute() {
		useMana(sourceEntity);
	}

	public ArrayList<Tile> getTargetTiles(){
		Location center = (getSourceEntity().getLocation());
		int radius = 20;
		
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

	@Override
	public int getRequiredMana() {
		return 20;
	}

	@Override
	public void cast() {
		double chanceOfSuccess = getSkillLevel()/50;
		double probabilityOfSuccess = RandomlyGenerate.probability();
		
		for(Tile tile : getTargetTiles()){
			Entity targetEntity = tile.getEntity();
			targetEntity.changeHealth(-1*(scaleMagnitude()+10));
//			if (targetEntity != null){
//				if (chanceOfSuccess > probabilityOfSuccess){		// success = damage
//					targetEntity.changeHealth(-1*scaleMagnitude());
//				}
//			}
			System.out.println("Blizzard Success");
		}
	}

	@Override
	protected int scaleMagnitude() {
		return 150 * getSkillLevel()/100;
	}
}

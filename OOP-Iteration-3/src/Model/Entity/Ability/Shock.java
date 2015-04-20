package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.Tile;
import Utility.RandomlyGenerate;

public class Shock extends SummonerAbility{

	private Entity sourceEntity;
	private Skill skill;

	public Shock(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
	public void cast() {
		double chanceOfSuccess = getSkillLevel()/50;
		double probabilityOfSuccess = RandomlyGenerate.probability();
		
		ArrayList<Entity> entities = sourceEntity.getGamemap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			if(checkDistance(sourceEntity.getLocation(),entities.get(i).getLocation(),1,5)){
				entities.get(i).changeHealth(-50); break;
			}
		}
		
//		for(Tile tile : getTargetTiles()){
//			Entity targetEntity = tile.getEntity();
//			if (targetEntity != null){
//				if (chanceOfSuccess > probabilityOfSuccess || true){		// success = detection
//					targetEntity.changeHealth(-1*scaleMagnitude());
//					System.out.println(targetEntity.getStatistics().getLife());
//				}
//			}
//		}
	}

	@Override
    public void execute() {
		useMana(sourceEntity);
	}
	
	@Override
	public int getRequiredMana() {
		return 20;
	}

	@Override
	public int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

	public ArrayList<Tile> getTargetTiles(){
		Location center = (getSourceEntity().getLocation());
		int radius = 3;

		GameMap map = sourceEntity.getGamemap();
		
		ArrayList<Tile> result = new ArrayList<Tile>();
		for (HexagonalLocation location : HexagonalLocation.arc((HexagonalLocation)center ,radius,getSourceEntity().getDirectionFacing())){
			result.add(map.getTile(location));
		}
		
		return result;
	}

	@Override
	protected int scaleMagnitude() {
		return 150 * getSkillLevel() + 50;
	}
}
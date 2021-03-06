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
	private Skill skill;

	public Creep(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }

	@Override
	public void execute() {
		double chanceOfSuccess = getSkillLevel()/50;
		double probabilityOfSuccess = RandomlyGenerate.probability();
		
		System.out.println("IM CREEPIN");
		ArrayList<Entity> entities = sourceEntity.getGamemap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			if(sourceEntity.isCreeping()){
				sourceEntity.creep();
			}else{
				sourceEntity.creep();
			}
			if(checkDistance(sourceEntity.getLocation(),entities.get(i).getLocation(),1,25)){
				NPC targetEntity = (NPC)entities.get(i);
				targetEntity.becomeNonHostile();
				
			}
		}
		
		
//		for(Tile tile : getTargetTiles()){
//			Entity targetEntity = (NPC)tile.getEntity();
//			if (targetEntity != null){
//				if (chanceOfSuccess > probabilityOfSuccess){		// success = non-hostile
//					((NPC)targetEntity).becomeNonHostile();
//				}
//			}
//		}
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
		int radius = 5;

		GameMap map = sourceEntity.getGamemap();
		
		ArrayList<Tile> result = new ArrayList<Tile>();
		for (HexagonalLocation location : HexagonalLocation.circle((HexagonalLocation)center ,radius)){
			result.add(map.getTile(location));

		}
		
		return result;
	}

}

package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Monster;
import Model.Entity.NPC;
import Model.Entity.Skill;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Utility.RandomlyGenerate;

public class Charm extends SummonerAbility {

	private Entity sourceEntity;
	private Skill skill;
	
	public Charm(Entity sourceEntity, Skill skill) {
		this.sourceEntity = sourceEntity;
		this.skill = skill;
    }
	
	@Override
	public void cast() {
		Entity targetEntity = getTargetEntity();
		
		if (targetEntity != null){
			double probabilityOfSuccess = RandomlyGenerate.probability();
			double chanceOfSuccess = getSkillLevel()/100;
			
			if (chanceOfSuccess > probabilityOfSuccess){		// success
				((NPC)getTargetEntity()).charm();		
			} else {		// failure
				((NPC)targetEntity).provoke();
			}
		}
	}
	
	@Override
	public void execute() {
		useMana(sourceEntity);
		
		/*ArrayList<Entity> entities = sourceEntity.getGamemap().getAllNPCS();
		for(int i=0; i<entities.size(); i++){
			if(checkDistance(sourceEntity.getLocation(),entities.get(i).getLocation(),1,2)){
				NPC targetEntity = (NPC)entities.get(i);
				((NPC)targetEntity).setIfShouldFollowingEntity(true);
			}
		}*/
		GameMap gm = sourceEntity.getGamemap();
		Entity monster = new Monster();
		monster.setLocation(new HexagonalLocation(gm.getAvatar().getLocation().getU()+1, gm.getAvatar().getLocation().getV()));
		gm.spawn(monster, new HexagonalLocation(gm.getAvatar().getLocation().getU()+1, gm.getAvatar().getLocation().getU()));
		monster.setMap(gm);
	}

	@Override
	public int getRequiredMana() {
		return 20;
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Entity getSourceEntity() {
		return sourceEntity;
	}

	private Entity getTargetEntity() {
		return sourceEntity.getGamemap().getEntity(getSourceEntity().getLocationFacing());
	}
	
	@Override
	protected int scaleMagnitude() {
		return 0;
	}
}
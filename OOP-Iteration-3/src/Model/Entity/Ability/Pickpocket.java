package Model.Entity.Ability;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class Pickpocket extends SingleTargetAbility {
	
	private Tile targetTile;
	private Skill skill;
	private Avatar sourceAvatar;

	public Pickpocket(Tile targetTile, Skill skill, Avatar sourceAvatar) {
		this.targetTile = targetTile;
		this.skill = skill;
		this.sourceAvatar = sourceAvatar;
    }

	@Override
    public void execute() {
		Entity targetEntity = getTargetEntity();
		
		
		
//		if (targetEntity.isHostile()){		// hostile Entity
//			
//		} else {		// nonhostile Entity
//			
//		}
		
	}
	
	public Entity getTargetEntity() {
		// TODO Auto-generated method stub
		return targetTile.getEntity();
	}
	
	@Override
	public Tile getTargetTile() {
		// TODO Auto-generated method stub
		return targetTile;
	}

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return skill.getCurrentLevel();
	}

}

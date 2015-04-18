package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class BindWounds extends SingleTargetAbility{
	
	private Tile targetTile;
	private Skill skill;

	public BindWounds(Tile targetTile, Skill skill) {
		this.targetTile = targetTile;
		this.skill = skill;
	}

	@Override
    public void execute() {
		Entity targetEntity = getTargetEntity();
		int amountToHeal = getSkillLevel() * 2;
		// targetEntity.heal(amountToHeal);		// need heal method in Entity
	}

	public Entity getTargetEntity() {
		// TODO Auto-generated method stub
		return targetTile.getEntity();
	}

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return skill.getCurrentLevel();
	}

	@Override
	public Tile getTargetTile() {
		// TODO Auto-generated method stub
		return targetTile;
	}

}

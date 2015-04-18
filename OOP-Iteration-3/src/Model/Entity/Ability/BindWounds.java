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
		targetEntity.changeHealth(amountToHeal);
	}

	private Entity getTargetEntity() {
		return targetTile.getEntity();
	}

	@Override
	protected int getSkillLevel() {
		return skill.getCurrentLevel();
	}

	@Override
	protected Tile getTargetTile() {
		return targetTile;
	}

}

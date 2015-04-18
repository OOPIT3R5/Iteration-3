package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class RemoveTrap extends SingleTargetAbility {

	private Tile targetTile;
	private Skill skill;
	
	public RemoveTrap(Tile targetTile, Skill skill){
		this.targetTile = targetTile;
		this.skill = skill;		
    }

	@Override
    public void execute() {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public Trap getTargetTrap(){
		return targetTile.get
	}
	*/

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

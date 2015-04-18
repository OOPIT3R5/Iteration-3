package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class Attack extends MultipleTargetAbility{
	
	private ArrayList<Tile> targetTiles;
	private Skill skill;
	
	public Attack(ArrayList<Tile> targetTiles, Skill skill){
		this.targetTiles = targetTiles;
		this.skill = skill;
    }

	@Override
    public void execute() {
        
	}

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return skill.getCurrentLevel();
	}

	@Override
	public ArrayList<Tile> getTargetTiles() {
		// TODO Auto-generated method stub
		return targetTiles;
	}
}

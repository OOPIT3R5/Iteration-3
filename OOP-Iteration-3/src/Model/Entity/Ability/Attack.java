package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Entity.Skill;
import Model.Map.Grid.Tile.Tile;

public class Attack extends SkillAbility{
	
	private ArrayList<Tile> targetTiles;
	private Skill skill;
	
	public Attack(ArrayList<Tile> targetTiles, Skill skill){
		this.targetTiles = targetTiles;
		this.skill = skill;
    }

	@Override
	protected int getSkillLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Entity getSourceEntity() {
		// TODO Auto-generated method stub
		return null;
	}
}

package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class Fireball extends SummonerAbility {

	public Fireball(ArrayList<Tile> targetList, Entity entity) {
        
    }

	@Override
    public void execute() {
		// sourceAvatar.checkMana(this);
	}
	
	public void complete(){
		
	}

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getRequiredMana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void scaleMagnitude() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ArrayList<Tile> getTargetTiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void cast() {
		// TODO Auto-generated method stub
		
	}

}

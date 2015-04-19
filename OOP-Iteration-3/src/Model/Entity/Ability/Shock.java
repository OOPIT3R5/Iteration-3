package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class Shock extends SummonerAbility {

	public Shock(ArrayList<Tile> targetList, Entity entity) {
        
    }

	@Override
    public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSkillLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRequiredMana() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int scaleMagnitude() {
		// TODO Auto-generated method stub
        return 0;
	}

	@Override
	public void cast() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Entity getSourceEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	protected ArrayList<Tile> getTargetTiles() {
		// TODO Auto-generated method stub
		return null;
	}

}

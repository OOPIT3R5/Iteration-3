package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class Enhance extends SummonerAbility {

	public Enhance(ArrayList<Tile> targetList, Entity entity) {
        super(targetList, entity);
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

}

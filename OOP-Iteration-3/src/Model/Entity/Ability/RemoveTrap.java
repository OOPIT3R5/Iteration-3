package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class RemoveTrap extends SneakAbility {

	public RemoveTrap(ArrayList<Tile> targetList) {		// doesn't need a target entity....
		super(targetList);
	}

	@Override
    public void execute() {
		// TODO Auto-generated method stub
		
	}

}

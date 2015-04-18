package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Grid.Tile.Tile;

public class DoNothing extends Ability{

	@Override
    public void execute() {
		return; //Do nothing.
	}

}

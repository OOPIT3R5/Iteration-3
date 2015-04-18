package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Map.*;
import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Grid.Tile.Tile;

public class Move extends Ability {
	
	private int movementSpeed;
	private Direction direction;
    private Entity e;

	public Move(Entity e, Direction direction, int movementSpeed) {
	    this.e = e;
		this.direction = direction;
		this.movementSpeed = movementSpeed;
	    this.e = e;
    }

	@Override
	public void execute() {
		Entity currentEntity = e;
		// get oldTile
		System.out.println(currentEntity.getLocation().toString());
		currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));
		System.out.println(currentEntity.getLocation().toString());
		// get newTile
		// remove Entity from oldTile
		// place Entity on newTile
	}

}

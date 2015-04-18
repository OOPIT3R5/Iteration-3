package Model.Entity.Ability;

import Model.Entity.Entity;
import Model.Map.Direction;

public class Move extends Ability {
	
	private int movementSpeed;
	private Direction direction;
    private Entity entity;

	public Move(Entity entity, Direction direction, int movementSpeed) {
		this.direction = direction;
		this.movementSpeed = movementSpeed;
	    this.entity = entity;
    }

	@Override
	public void execute() {
		Entity currentEntity = entity;
		// get oldTile
		System.out.println(currentEntity.getLocation().toString());
		currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));		// incorporate movement speed?
		System.out.println(currentEntity.getLocation().toString());
		// get newTile
		// remove Entity from oldTile
		// place Entity on newTile
	}

}

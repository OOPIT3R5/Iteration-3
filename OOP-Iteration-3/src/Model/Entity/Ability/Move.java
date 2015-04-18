package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Direction;

public class Move extends Ability {
	
	private int movementSpeed;
	private Direction direction;

	public Move(ArrayList<Entity> targetList, Direction direction, int movementSpeed) {
		super(targetList);
		this.direction = direction;
		this.movementSpeed = movementSpeed;
	}

	@Override
	public void execute() {
		Entity currentEntity = targetList.get(0);
		// get oldTile
		System.out.println(currentEntity.getLocation().toString());
		currentEntity.setLocation(currentEntity.getLocation().getNeighbor(direction));
		System.out.println(currentEntity.getLocation().toString());
		// get newTile
		// remove Entity from oldTile
		// place Entity on newTile
	}

}

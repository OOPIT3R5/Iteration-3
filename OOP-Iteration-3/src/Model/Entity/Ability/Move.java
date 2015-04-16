package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;
import Model.Map.Direction;

public class Move extends Ability {
	
	private int movementSpeed;

	public Move(ArrayList<Entity> targetList, Direction direction, int movementSpeed) {
		super(targetList);
		this.movementSpeed = movementSpeed;
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		
	}

}

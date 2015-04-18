package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Map.*;
import Model.Entity.Entity;
import Model.Map.Direction;

public class Move extends Ability {
	
	private int movementSpeed;
	private Direction direction_;

	public Move(ArrayList<Entity> targetList, Direction direction, int movementSpeed) {
		super(targetList);
		this.movementSpeed = movementSpeed;
		direction_ = direction;
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		for (Entity entity : super.getTargetList()) {
			entity.moveByOne(direction_);
			//map.updateEntityLocation(entity);
		}
	}

}

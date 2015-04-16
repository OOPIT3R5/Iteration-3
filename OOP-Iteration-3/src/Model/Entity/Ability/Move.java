package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public class Move extends Ability{
	
	private int movementSpeed;

	public Move(ArrayList<Entity> targetList, int movementSpeed) {
		super(targetList);
		this.movementSpeed = movementSpeed;
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		
	}

}

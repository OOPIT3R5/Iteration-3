package Model.Entity.Ability;

import java.util.ArrayList;

import Model.Entity.Entity;

public class DoNothing extends Ability{
	
	public DoNothing(ArrayList<Entity> targetList) {
		super(targetList);
	}

	@Override
	void execute() {
		
	}

}

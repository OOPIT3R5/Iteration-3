package Model.Entity.Ability;

import Model.Entity.Entity;

public class DoNothing extends Ability{

	@Override
    public void execute() {
		return; 	// do nothing
	}

	@Override
	protected Entity getSourceEntity() {
		return null;
	}

}

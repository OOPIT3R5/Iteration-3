package Model.Entity.Ability;

import Model.Entity.Entity;

public abstract class Ability {    
	public abstract void execute();
    protected abstract Entity getSourceEntity();
}

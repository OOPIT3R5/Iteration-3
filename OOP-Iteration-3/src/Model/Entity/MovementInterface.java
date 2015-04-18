package Model.Entity;

import Model.Map.Direction;

public interface MovementInterface {
	
	public abstract void disableMove(Direction direction);
	
	public abstract void disableWalk(Direction direction);
	
	public abstract void enableMove(Direction direction);
	
}

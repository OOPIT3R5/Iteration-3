package Model.Terrain;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public abstract class Terrain {
	
	public abstract void notifyOfEntity(MovementInterface target, Direction direction);
	
}

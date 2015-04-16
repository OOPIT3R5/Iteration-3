package Model.Terrain;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Water extends Terrain {
	
	public Water() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableWalk(Direction.hexToInt(direction) + 3);
	}
	
}

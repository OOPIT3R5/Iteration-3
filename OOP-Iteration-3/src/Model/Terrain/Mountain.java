package Model.Terrain;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Mountain extends Terrain {
	
	public Mountain() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableMove(Direction.hexToInt(direction) + 3);
	}
	
}

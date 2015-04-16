package Model.Terrain;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Grass extends Terrain {
	
	public Grass() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.enableMove(Direction.hexToInt(direction) + 3);
	}
	
}

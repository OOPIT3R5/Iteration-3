package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Water extends Terrain {
	
	public Water() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableWalk(direction);
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	
	
	
}

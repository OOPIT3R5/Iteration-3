package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Water extends Terrain {
	
	public Water() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableWalk(Direction.intToHex(Direction.hexToInt(direction) + 3));
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.BLUE;
	}
	
	
	
}

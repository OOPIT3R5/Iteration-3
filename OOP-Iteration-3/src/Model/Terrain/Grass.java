package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Grass extends Terrain {
	
	public Grass() {
		super();
	}
	
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.enableMove(Direction.hexToInt(direction) + 3);
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return Color.GREEN;
	}
	
}

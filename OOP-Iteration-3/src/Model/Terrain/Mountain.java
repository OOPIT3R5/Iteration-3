package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Mountain extends Terrain {
	
	public Mountain() {
		super();
	}
	
	@Override
	public Color getColor() {
		return Color.LIGHT_GRAY;
	}

	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableMove(direction);
	}
	
	@Override
	public String toString()
	{
		return "Mountain Tile";
	}
}

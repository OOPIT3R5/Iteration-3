package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Water extends Terrain {
	
	public Water() {
		super();
	}
	
	@Override
	public Color getColor() {
		System.out.print(".");
		return Color.BLUE;
	}

	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.disableWalk(direction);
	}
	
	@Override
	public String toString()
	{
		return "Water Tile";
	}
	
}

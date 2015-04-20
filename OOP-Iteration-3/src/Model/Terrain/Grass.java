package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public class Grass extends Terrain {
	
	public Grass() {
		super();
	}
	
	@Override
	public Color getColor() {
		return Color.GREEN;
	}

	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		target.enableMove(direction);
	}
	
	@Override
	public String toString()
	{
		return "Grass Tile";
	}
	
}

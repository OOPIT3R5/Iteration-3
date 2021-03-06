package Model.Terrain;

import java.awt.Color;

import Model.Entity.MovementInterface;
import Model.Map.Direction;

public abstract class Terrain {
	
	public abstract Color getColor();
	
	public abstract void notifyOfEntity(MovementInterface target, Direction direction);
	
}

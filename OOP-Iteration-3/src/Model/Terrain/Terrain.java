package Model.Terrain;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Location;

public abstract class Terrain {
	
	public abstract Color getColor();

	public abstract void move(Entity entity, Location target);
	
}

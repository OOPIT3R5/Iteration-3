package Model.Terrain;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Location;

public class Grass extends Terrain {
	
	public Grass() {
		super();
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
	}
	
	public String toString() {
		return "Grass Tile";
	}
	
	@Override
	public void move(Entity entity, Location target) {
		entity.walkTo(target);
	}
	
}

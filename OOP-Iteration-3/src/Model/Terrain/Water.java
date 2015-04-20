package Model.Terrain;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Location;

public class Water extends Terrain {
	
	public Water() {
		super();
	}

	@Override
	public Color getColor() {
		return Color.BLUE;
	}
	
	public String toString() {
		return "Water Tile";
	}

	@Override
	public void move(Entity entity, Location target) {
		entity.swimTo(target);
	}
	
}

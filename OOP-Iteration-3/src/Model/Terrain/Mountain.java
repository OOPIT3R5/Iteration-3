package Model.Terrain;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Map.Direction;
import Model.Map.Location;

public class Mountain extends Terrain {
	
	public Mountain() {
		super();
	}
	@Override
	public Color getColor() {
		return Color.LIGHT_GRAY;
	}
	
	public String toString() {
		return "Mountain Tile";
	}
	
	@Override
	public void move(Entity entity, Location target) {
		
	}
}

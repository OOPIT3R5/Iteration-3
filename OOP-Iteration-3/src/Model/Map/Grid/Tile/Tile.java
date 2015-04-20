package Model.Map.Grid.Tile;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Items.Trap;
import Model.Map.Direction;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public abstract class Tile {

	private final Terrain terrain_;
	private Location location_;
	
	public Tile() {
		terrain_ = new Grass();
	}
	
	public Tile(Terrain terrain) {
		terrain_ = terrain;
	}
	
	public abstract Tile clone();
	
	public Terrain getTerrain() {
		return terrain_;
	}
	
	public Color getColor(){
		return terrain_.getColor();
	}
	
	public abstract void setLocation(int x, int y);
	
	public abstract void setLocation(Location location);

	public void putLocation(Location location) {
		location_ = location;
	}
	
	public Location getLocation() {
		return location_;
	}

	public void detectTrap(){
		// TODO set trap visible 
	}
	
	public boolean equals(Tile other) {
		return location_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		builder.append("Tile");
		builder.append(terrain_.toString());
		//builder.append();
		
		return builder.toString();
	}
	
}

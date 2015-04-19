package Model.Map.Grid.Tile;

import java.awt.Color;

import Model.Entity.Entity;
import Model.Entity.MovementInterface;
import Model.Items.MapObject;
import Model.Items.Trap;
import Model.Map.Direction;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public abstract class Tile {

	private final Terrain terrain_;
	private Location location_;
	private Entity entity_;
	private MapObject map_object_;
	private Trap trap_;
	
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

	public void setEntity(Entity entity) {
		entity_ = entity;
	}
	
	public Entity getEntity() {
		return entity_;
	}
	
	public void removeEntity() {
		entity_ = null;
	}

	public void setMapObject(MapObject map_object) {
		map_object_ = map_object;
	}
	
	public MapObject getMapObject() {
		return map_object_;
	}
	
	public Trap getTrap(){
		return trap_;
	}
	
	public void setTrap(Trap t){
		trap_ = t;
	}
	
	public void removeTrap(){
		trap_ = null;
	}
	
	public void activateTrap(Entity e){
		if (trap_ != null)
			trap_.onTouch(e);
	}
	
	public void detectTrap(){
		// set trap visible
	}
	
	public boolean equals(Tile other) {
		return location_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return "";
	}
	
	public boolean hasEntity() {
		return (entity_ != null);
	}

	public abstract void notifyOfEntity(MovementInterface target, Direction direction);
	public abstract void prospectiveMovement(MovementInterface target, Direction direction);
	
}

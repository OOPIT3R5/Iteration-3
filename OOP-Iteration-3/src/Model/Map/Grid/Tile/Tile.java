package Model.Map.Grid.Tile;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public abstract class Tile {

	private final Terrain terrain_;
	private Location location_;
	private Entity entity_;
	private MapObject map_object_;
	
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
	
	public boolean equals(Tile other) {
		return location_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return "";
	}
	
}

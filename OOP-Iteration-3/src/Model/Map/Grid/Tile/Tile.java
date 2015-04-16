package Model.Map.Grid.Tile;

import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public abstract class Tile {

	private final Terrain terrain_;
	private Location location_;
	/*private Entity entity_;
	private MapObject map_object_;*/
	
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
	
	public void setLocation(Location location) {
		location_ = location;
	}
	
	public Location getLocation() {
		return location_;
	}

	/*public void setEntity(Entity entity) {
		entity_ = entity;
	}
	
	public Vector2D getEntity() {
		return entity_;
	}

	public void setMapObject(MapObject map_object) {
		map_object_ = map_object;
	}
	
	public Vector2D getMapObject() {
		return map_object_;
	}*/
	
	public boolean equals(Tile other) {
		return location_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return "";//getLocation().getX() + "," + getLocation().getY();
	}
	
}

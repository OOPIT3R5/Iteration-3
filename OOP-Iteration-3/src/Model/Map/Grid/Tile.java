package Model.Map.Grid;

import Model.Map.Vector2D;
import Model.Map.Terrain.Terrain;


public class Tile {

	private Vector2D vector_;
	private Terrain terrain_;
	/*private Entity entity_;
	private MapObject map_object_;*/
	
	public Tile(Vector2D vector) {
		vector_ = vector;
	}
	
	public Tile(Vector2D vector, Terrain terrain) {
		vector_ = vector;
		terrain_ = terrain;
	}

	public Tile(int x, int y) {
		vector_ = new Vector2D(x, y);
	}
	
	public Tile(int x, int y, Terrain terrain) {
		vector_ = new Vector2D(x, y);
		terrain_ = terrain;
	}
	
	public void setTerrain(Terrain terrain) {
		terrain_ = terrain;
	}
	
	public Terrain getTerrain() {
		return terrain_;
	}
	
	public void setLocation(int x, int y) {
		vector_ = new Vector2D(x, y);
	}
	
	public void setLocation(Vector2D vector) {
		vector_ = vector;
	}
	
	public Vector2D getLocation() {
		return vector_;
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
		return vector_.equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return getLocation().getX() + "," + getLocation().getY();
	}
	
}

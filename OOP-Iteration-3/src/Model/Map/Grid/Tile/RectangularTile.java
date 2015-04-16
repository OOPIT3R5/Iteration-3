package Model.Map.Grid.Tile;

import Model.Map.Location;
import Model.Map.RectangularLocation;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;

public class RectangularTile extends Tile {
	
	public RectangularTile() {
		super(new Grass());
	}
	
	public RectangularTile(Terrain terrain) {
		super(terrain);
	}
	
	public RectangularTile clone() {
		return new RectangularTile(getTerrain());
	}
	
	@Override
	public void setLocation(int x, int y) {
		setLocation(new RectangularLocation(x, y));
	}

	@Override
	public void setLocation(Location location) {
		super.putLocation((RectangularLocation)location);
	}

	@Override
	public RectangularLocation getLocation() {
		return (RectangularLocation)super.getLocation();
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
	
	public boolean equals(RectangularTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return "";//getLocation().getX() + "," + getLocation().getY();
	}
	
}

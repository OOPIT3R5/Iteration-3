package Model.Map.Grid.Tile;

import Model.Entity.MovementInterface;
import Model.Map.Direction;
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
	
	public boolean equals(RectangularTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return "";//getLocation().getX() + "," + getLocation().getY();
	}
	
	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		if (super.hasEntity())
			target.disableMove(Direction.octToInt(direction) + 4);
	}
	
}

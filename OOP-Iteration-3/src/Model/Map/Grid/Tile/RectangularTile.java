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
	
	@Override
	public RectangularTile clone() {
		return new RectangularTile(getTerrain());
	}
	
	public boolean equals(RectangularTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}

	@Override
	public RectangularLocation getLocation() {
		return (RectangularLocation)super.getLocation();
	}

	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {		// TODO replace with prospectiveMovement?
		if (super.hasEntity())
			target.disableMove(Direction.intToHex(Direction.hexToInt(direction) + 4));
		else
			getTerrain().notifyOfEntity(target, direction);
	}
	
	@Override
	public void prospectiveMovement(MovementInterface target, Direction direction) {
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		setLocation(new RectangularLocation(x, y));
	}
	
	@Override
	public void setLocation(Location location) {
		super.putLocation(location);
	}

	@Override
	public String toString() {
		return getLocation().getX() + "," + getLocation().getY();
	}
	
}

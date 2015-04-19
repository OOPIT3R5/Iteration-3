package Model.Map.Grid.Tile;

import java.awt.Graphics;

import Model.Entity.MovementInterface;
import Model.Map.Direction;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;
import View.HexTileView;


public class HexagonalTile extends Tile {
	
	HexTileView hView;
	
	public HexagonalTile() {
		super(new Grass());
		hView = new HexTileView(this);
	}
	
	public HexagonalTile( Terrain terrain) {
		super(terrain);
		hView = new HexTileView(this);
		
	}

	@Override
	public HexagonalTile clone() {
		return new HexagonalTile( super.getTerrain());
	}
	
	@Override
	public void setLocation(int u, int v) {
		setLocation(new HexagonalLocation(u, v));
	}

	@Override
	public void setLocation(Location hex_location) {
		super.putLocation((HexagonalLocation)hex_location);
	}

	@Override
	public HexagonalLocation getLocation() {
		return (HexagonalLocation)super.getLocation();
	}
	
	public boolean equals(HexagonalTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return getLocation().getU() + ", " + getLocation().getV();
	}
	
	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {
		if (super.hasEntity())
			target.disableMove(Direction.intToHex(Direction.hexToInt(direction) + 3));
		else
			getTerrain().notifyOfEntity(target, direction);
	}
	
	
	public void render(Graphics g)
	{
		hView.render(g);
	}
	
}

package Model.Map.Grid.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import Model.Entity.MovementInterface;
import Model.Map.Direction;
import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;
import View.Model.HexTileView;


public class HexagonalTile extends Tile {
	
	HexTileView hView;
	
	public HexagonalTile() {
		super(new Grass());
		hView = new HexTileView(getLocation(), getColor());
	}
	
	public HexagonalTile(Terrain terrain) {
		super(terrain);
		hView = new HexTileView(getLocation(), getColor());
	}

	@Override
	public HexagonalTile clone() {
		return new HexagonalTile(super.getTerrain());
	}
	
	@Override
	public void setLocation(int u, int v) {
		setLocation(new HexagonalLocation(u, v));
	}

	@Override
	public void setLocation(Location hex_location) {
		super.putLocation((HexagonalLocation)hex_location);
		hView.update(getLocation());
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
		//return getLocation().getU() + ", " + getLocation().getV();
		StringBuilder builder = new StringBuilder();
		//builder.append(super.getTerrain().toString());
		
		return builder.toString();
	}
	
	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {		// TODO Delete if not needed
		if (super.hasEntity())
			target.disableMove(Direction.intToHex(Direction.hexToInt(direction) + 3));
		else
			getTerrain().notifyOfEntity(target, direction);
	}
	
	@Override
	public void prospectiveMovement(MovementInterface target, Direction direction){
		if (super.hasEntity())
			target.disableMove(direction);
		else
			getTerrain().notifyOfEntity(target, direction);
	}
	
	
	public void render(Graphics g, HexagonalLocation center) {
		hView.render(g, center);
		if (hasEntity())
			getEntity().render(g, center);
		if(hasMapObject())
			getMapObject().render(g, center, super.getLocation());
	}
	
}









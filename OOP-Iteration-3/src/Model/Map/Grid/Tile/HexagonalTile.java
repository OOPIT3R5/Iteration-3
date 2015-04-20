package Model.Map.Grid.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.MovementInterface;
import Model.Items.MapObject;
import Model.Map.Direction;
import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;
import View.EntityView;
import View.Model.HexTileView;


public class HexagonalTile extends Tile {
	
	HexTileView hView;
	HexTileView hViewNonvisible;
	
	private CachedEntity cached_entity_;
	private MapObject cached_map_object_;

	private class CachedEntity {
		public Direction directionFacing_;
		public HexagonalLocation currentLocation_;
		public int hp_;
		public int mhp_;
		
		CachedEntity(Direction directionFacing, HexagonalLocation currentLocation, int hp, int mhp) {
			directionFacing_ = directionFacing;
			currentLocation_ = currentLocation;
			hp_ = hp;
			mhp_ = mhp;
		}
	}
	
	
	public HexagonalTile() {
		super(new Grass());
		hView = new HexTileView(getLocation(), getColor());
		hViewNonvisible = new HexTileView(getLocation(), getColor().darker().darker());
	}
	
	public HexagonalTile(Terrain terrain) {
		super(terrain);
		hView = new HexTileView(getLocation(), getColor());
		hViewNonvisible = new HexTileView(getLocation(), getColor().darker().darker());
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
		hViewNonvisible.update(getLocation());
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
	
	public void cacheEntity() {
		//Graphics g, HexagonalLocation avatar_location, Direction directionFacing, HexagonalLocation currentLocation, int hp, int mhp
		Entity to_cache = getEntity();
		cached_entity_ = new CachedEntity(to_cache.getDirectionFacing(), to_cache.getLocation(),
				to_cache.getStatistics().getLife(), to_cache.getStatistics().getMana());
	}
	
	public void render(Graphics g, HexagonalLocation center) {
		int distance = HexagonalLocation.rectilinearDistance(getLocation(), center);
		if (Math.abs(distance) < 3)
			hView.render(g, center);
		else
			hViewNonvisible.render(g, center);
		if (Math.abs(distance) < 3) {
			if (hasEntity()) {
				cacheEntity();
				getEntity().render(g, center);
			} else {
				cached_entity_ = null;
			}
			if(hasMapObject()) {
				getMapObject().getMapObjectView().render(g, center, (HexagonalLocation)super.getLocation());
			} else {
				
			}
		} else {
			if (cached_entity_ != null)
				try {
					new EntityView().render(g, center, cached_entity_.directionFacing_, cached_entity_.currentLocation_, cached_entity_.hp_, cached_entity_.mhp_);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
}









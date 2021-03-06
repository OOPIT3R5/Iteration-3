package Model.Map.Grid.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.MovementInterface;
import Model.Items.MapObject;
import Model.Map.Direction;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;
import View.NpcView;
import View.Model.HexTileView;

public class HexagonalTile extends Tile {
	
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
	HexTileView hView;
	HexTileView hViewNonvisible;
	
	HexTileView black;
	private CachedEntity cached_entity_;
	
	private MapObject cached_map_object_;

	private boolean has_been_seen_ = false;
	
	public HexagonalTile() {
		super(new Grass());
		hView = new HexTileView(getLocation(), getColor());
		hViewNonvisible = new HexTileView(getLocation(), getColor().darker().darker());
		black = new HexTileView(getLocation(), Color.DARK_GRAY);
	}
	
	public HexagonalTile(Terrain terrain) {
		super(terrain);
		hView = new HexTileView(getLocation(), getColor());
		hViewNonvisible = new HexTileView(getLocation(), getColor().darker().darker());
		black = new HexTileView(getLocation(), Color.DARK_GRAY);
	}

	public void cacheEntity() {
		//Graphics g, HexagonalLocation avatar_location, Direction directionFacing, HexagonalLocation currentLocation, int hp, int mhp
		Entity to_cache = getEntity();
		//System.out.println(to_cache.getLocation().toString());
		if(to_cache != null)
			cached_entity_ = new CachedEntity(to_cache.getDirectionFacing(), to_cache.getLocation(),
				
				to_cache.getStatistics().getLife(), to_cache.getStatistics().getMana());
	}
	
	@Override
	public HexagonalTile clone() {
		return new HexagonalTile(super.getTerrain());
	}

	public boolean equals(HexagonalTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}

	@Override
	public HexagonalLocation getLocation() {
		return (HexagonalLocation)super.getLocation();
	}
	
	@Override
	public void notifyOfEntity(MovementInterface target, Direction direction) {		// TODO Delete if not needed
		if (super.hasEntity()) {
			super.getEntity().disableMove(Direction.intToHex(Direction.hexToInt(direction) + 3));
			target.disableMove(direction);
		} else
			getTerrain().notifyOfEntity(target, direction);
	}
	
	@Override
	public void prospectiveMovement(MovementInterface target, Direction direction) {
		boolean go = true;
		if(super.hasMapObject()){
			if(!super.getMapObject().isPassable()) {
				go = false;
				target.disableMove(direction);
			}
		}
		if (super.hasEntity()) {
			go = false;
			super.getEntity().disableMove(Direction.intToHex(Direction.hexToInt(direction) + 3));
			target.disableMove(direction);
		}
		if (go)
			getTerrain().notifyOfEntity(target, direction);
		
	}
	
	public void render(Graphics g, HexagonalLocation center) {
		int distance = HexagonalLocation.rectilinearDistance(getLocation(), center);
		if (Math.abs(distance) < 3) {
			cached_entity_ = null;
			hView.render(g, center);
		} else {
			if (!has_been_seen_) {
				black.render(g, center);
			} else {
				hViewNonvisible.render(g, center);
			}
		}
		if (Math.abs(distance) >= 3) {
			if (cached_entity_ != null)
				try {
					new NpcView().render(g, center, cached_entity_.directionFacing_, cached_entity_.currentLocation_, cached_entity_.hp_, cached_entity_.mhp_);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if (Math.abs(distance) < 3) {
			has_been_seen_ = true;
			if (hasEntity()) {
				cacheEntity();
				getEntity().render(g, center);
			}
			if(hasMapObject()) {
				getMapObject().getMapObjectView().render(g, center, (HexagonalLocation)super.getLocation());
				
			} else {
				
				
			}
		}
	}
	
	@Override
	public void setLocation(int u, int v) {
		setLocation(new HexagonalLocation(u, v));
	}
	
	@Override
	public void setLocation(Location hex_location) {
		super.putLocation(hex_location);
		hView.update(getLocation());
		hViewNonvisible.update(getLocation());
		black.update(getLocation());
	}
	
	@Override
	public String toString() {
		//return getLocation().getU() + ", " + getLocation().getV();
		StringBuilder builder = new StringBuilder();
		//builder.append(super.getTerrain().toString());
		
		return builder.toString();
	}

	
	
}









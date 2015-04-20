package Model.Map.Grid.Tile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.Direction;
import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;
import View.EntityView;
import View.NpcView;
import View.Model.HexTileView;

public class HexagonalTile extends Tile {
	
	HexTileView hView;
	HexTileView hViewNonvisible;
	HexTileView black;
	
	private CachedEntity cached_entity_;
	private MapObject cached_map_object_;
	
	private boolean has_been_seen_ = false;

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
		black = new HexTileView(getLocation(), Color.DARK_GRAY);
	}
	
	public HexagonalTile(Terrain terrain) {
		super(terrain);
		hView = new HexTileView(getLocation(), getColor());
		hViewNonvisible = new HexTileView(getLocation(), getColor().darker().darker());
		black = new HexTileView(getLocation(), Color.DARK_GRAY);
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
		black.update(getLocation());
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
	
	public void render(Graphics g, HexagonalLocation center) {
		int distance = HexagonalLocation.rectilinearDistance(getLocation(), center);
		if (Math.abs(distance) < 3) {
			has_been_seen_ = true;
			cached_entity_ = null;
			hView.render(g, center);
		} else {
			if (!has_been_seen_) {
				System.out.println("should come here");
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
	}

	public void move(Entity entity) {
		getTerrain().move(entity, getLocation());
	}
	
}









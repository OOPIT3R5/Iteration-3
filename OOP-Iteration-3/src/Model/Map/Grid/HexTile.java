package Model.Map.Grid;
import Model.Map.HexCoordinate;
import Model.Map.Terrain.Terrain;


public class HexTile extends Tile {
	
	private int number_;
	
	public HexTile(HexCoordinate hex) {
		super(hex);
	}
	
	public HexTile(int u, int v, int number) {
		super(0, 0);
		setLocation(u, v);
		number_ = number;
	}
	
	public HexTile(int u, int v) {
		super(0, 0);
		setLocation(u, v);
	}
	
	public HexTile(HexCoordinate hex, Terrain terrain) {
		super(hex, terrain);
	}
	
	public HexTile(int u, int v, Terrain terrain) {
		super(0, 0, terrain);
		setLocation(u, v);
	}
	
	public void setLocation(int u, int v) {
		setLocation(new HexCoordinate(u, v));
	}
	
	public void setLocation(HexCoordinate hex_coord) {
		super.setLocation(hex_coord);
	}
	
	public HexCoordinate getLocation() {
		return (HexCoordinate)(super.getLocation());
	}
	
	public boolean equals(HexTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return getLocation().getU() + ","+
				getLocation().getY() + " : " + number_;
	}
	
}

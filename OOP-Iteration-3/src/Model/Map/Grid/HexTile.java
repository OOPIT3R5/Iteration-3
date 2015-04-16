package Model.Map.Grid;
import Model.Map.HexCoordinate;
import Model.Map.Vector2D;
import Model.Map.Terrain.Terrain;


public class HexTile extends Tile {
	
	private int number_;
	
	public HexTile(Terrain terrain) {
		super(terrain);
	}
	
	public HexTile(int number) {
		super();
		number_ = number;
	}
	
	public HexTile clone() {
		return new HexTile(super.getTerrain());
	}
	
	public void setLocation(int u, int v) {
		setLocation(new HexCoordinate(u, v));
	}
	
	public void setLocation(HexCoordinate hex_coordinate) {
		super.setLocation(hex_coordinate);
	}
	
	public HexCoordinate getLocation() {
		return (HexCoordinate)super.getLocation();
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

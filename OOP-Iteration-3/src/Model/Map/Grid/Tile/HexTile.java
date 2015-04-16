package Model.Map.Grid.Tile;
import Model.Map.HexagonalLocation;
import Model.Terrain.Grass;
import Model.Terrain.Terrain;


public class HexTile extends Tile {
	
	public HexTile() {
		super(new Grass());
	}
	
	public HexTile(Terrain terrain) {
		super(terrain);
	}
	
	public HexTile clone() {
		return new HexTile(super.getTerrain());
	}
	
	public void setLocation(int u, int v) {
		setLocation(new HexagonalLocation(u, v));
	}
	
	public void setLocation(HexagonalLocation hex_coordinate) {
		super.setLocation(hex_coordinate);
	}
	
	public HexagonalLocation getLocation() {
		return (HexagonalLocation)super.getLocation();
	}
	
	public boolean equals(HexTile other) {
		return getLocation().equals(other.getLocation())
				&& getTerrain() == other.getTerrain();
	}
	
	public String toString() {
		return getLocation().getU() + ","+
				getLocation().getV();
	}
	
}

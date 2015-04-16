package Model.Map;

public abstract class Location {
	
	protected final int[] coordinate = new int[2];
	
	public Location(int x, int y) {
		coordinate[0] = x;
		coordinate[1] = y;
	}
	
	public abstract Location getNeighbor(Direction d);
	
	public abstract Location getNeighbor(int d);
	
}

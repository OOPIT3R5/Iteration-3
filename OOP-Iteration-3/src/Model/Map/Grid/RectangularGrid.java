package Model.Map.Grid;

import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.RectangularCoordinateInterface;
import Model.Map.RectangularLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.Grid.Tile.RectangularTile;
import Model.Map.Grid.Tile.Tile;


/**
 * 
 * @author Jack
 *
 */
public class RectangularGrid extends Grid {
	
	public RectangularGrid(int width, int height) {
		super(width, height);
	}
	
	/** Adds object to grid at provided xy index. */
	@Override
	public void add(int x, int y, Tile rect_tile) {
		rect_tile.setLocation(x, y);
		insert(x, y, rect_tile);
	}

	@Override
	public void fill(Tile rect_tile) {
		for (int row = 0; row < super.getHeight(); row++)
			for (int col = 0; col < super.getWidth(); col++)
				insert(col, row, rect_tile.clone());
	}
	
	@Override
	public RectangularTile get(Location rect_location) {
		RectangularCoordinateInterface rect_coord = (RectangularCoordinateInterface)rect_location;
		return get(rect_coord.getX(), rect_coord.getY());
	}
	
	/** Returns object at xy index. */
	@Override
	public RectangularTile get(int x, int y) {
		return see(x, y);
	}
	
	/** Adds object to grid[x][y]. */
	@Override
	public void insert(int x, int y, Tile tile) {
		tile.setLocation(new RectangularLocation(x, y));
		super.put(x, y, tile);
	}
	
	@Override
	protected RectangularTile see(int x, int y) {
		return (RectangularTile)super.see(x, y);
	}
	
}

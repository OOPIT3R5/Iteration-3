package Model.Map.Grid;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.HexagonalLocation;
import Model.Map.Location;
import Model.Map.Grid.Tile.Tile;


/**
 * 
 * @author Jack
 *
 */
public abstract class Grid {
	
	private Tile[][] grid_;
	private int width_;
	private int height_;
	private int size_;
	
	public Grid(int width, int height) {
		grid_ = new Tile[width][height];
		width_ = width;
		height_ = height;
		size_ = 0;
		//fill(new HexagonalTile(new Grass()));
	}
	
	//public abstract void drawRectangleWithCoords(Graphics g, Point p, Location center, int width,
		//	int height, int radius);
	
	
	/** Adds object to grid at provided xy index. */
	public abstract void add(int x, int y, Tile tile);

	public void addEntity(int i , int j, Entity e)
	{
		e.setLocation(new HexagonalLocation(i , j));
		grid_[i][j].setEntity(e);
	}

	public void addMapObject(int i, int j, MapObject mo) 
	{
		
		grid_[i][j].setMapObject(mo);
	}
	
	//public abstract void fill(Tile tile);
	
	/** Clears entire grid. */
	public void clear() {
		for (int row = 0; row < height_; row++) 
			for (int col = 0; col < width_; col++)
				delete(col, row);
		size_ = 0;
	}
	
	public void delete(int x, int y) {
		if (see(x, y) != null)
			size_ -= 1;
		grid_[x][y] = null;
	}
	
	public void fill(Tile defaultTile)
	{
		System.out.println("HERE");
		for (int row = 0; row < getHeight(); row++)
			for (int col = 0; col < getWidth(); col++) {
				Tile insert = defaultTile.clone();
				//insert.setLocation(new HexagonalLocation(row, col));
				insert(col, row, insert.clone());
				insert.setLocation(col, row - (col / 2));
			}
	}
	
	public Tile get(int i , int j)
	{
		return grid_[i][j];
	}
	
	/** Returns object at xy index. */
	public abstract Tile get(Location location);
	
	protected int getHeight() {
		return height_;
	}
	
	/** Returns object at xy index. */
	//public abstract Tile get(int x, int y);
	
	protected int getWidth() {
		return width_;
	}
	
	/** Adds object to grid[x][y]. */
	public abstract void insert(int x, int y, Tile tile);
	
	/** Returns <code>true</code> if grid is empty. */
	public boolean isEmpty() {
		return (size_ == 0);
	}
	
	protected void put(int x, int y, Tile tile) {
		if (see(x, y) == null)
			size_ += 1;
		grid_[y][x] = tile;
	}
	
	/** Removes object at xy index. */
	public void remove(int x, int y) {
		delete(x, y);
	}
	
	protected Tile see(int x, int y) {
		return grid_[y][x];
	}
	
	public void spawnEntity(Location location, Entity e)
	{
		int x = location.getX();
		int y = location.getY();
		
		grid_[x][y].setEntity(e);
	}
	
	@Override
	public String toString() {
		
		StringBuilder string = new StringBuilder();
		string.append("[ ");
		for (int i = 0; i < width_; i++) {
			string.append("[ ");
			for (int j = 0; j < height_; j++) {
				string.append(grid_[i][j].toString());
				if (j < height_ - 1)
					string.append(", ");
			}
			string.append(" ]");
			if (i < height_ - 1) {
				string.append(", ");
				string.append("\n  ");
			}
		}
		string.append(" ]");
		return string.toString();
	}
	
}

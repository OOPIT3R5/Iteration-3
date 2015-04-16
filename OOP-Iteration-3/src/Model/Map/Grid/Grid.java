package Model.Map.Grid;

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
	}
	
	/** Adds object to grid at provided xy index. */
	public void add(int x, int y, Tile tile) {
		tile.setLocation(x, y);
		insert(x, y, tile);
	}

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
	
	public void fill(Tile tile) {
		for (int col = 0; col < width_; col++)
			for (int row = 0; row < height_; row++)
				insert(col, row, tile.clone());
	}
	
	/** Returns object at xy index. */
	public Tile get(int x, int y) {
		return see(x, y);
	}
	
	protected int getWidth() {
		return width_;
	}
	
	protected int getHeight() {
		return height_;
	}
	
	/** Adds object to grid[x][y]. */
	public void insert(int x, int y, Tile tile) {
		if (see(x, y) == null)
			size_ += 1;
		tile.setLocation(x, y);
		grid_[y][x] = tile;
	}
	
	/** Returns <code>true</code> if grid is empty. */
	public boolean isEmpty() {
		return (size_ == 0);
	}
	
	/** Removes object at xy index. */
	public void remove(int x, int y) {
		delete(x, y);
	}
	
	public Tile see(int x, int y) {
		return grid_[y][x];
	}
	
}

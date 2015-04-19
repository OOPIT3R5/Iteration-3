package Model.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Map.Grid.DrawableHexGridInterface;
import Model.Map.Grid.Grid;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.Tile;
import View.GameView;
import View.ModelView;


public class GameMap{
	
	
	GameView mapView;
	Grid gameMapGrid;
	private static int HEIGHT;
	private static int WIDTH;
	
	public ArrayList<HexagonalLocation> getLine(Location loc)
	{
		return null;
		//TODO modify location interface
		
		
	
	}

	public GameMap(int width, int height) {
		this.HEIGHT = height;
		this.WIDTH = width;
		 mapView = new GameView();
		 gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
	}

	public void fill(Tile defaultTile)
	{
		gameMapGrid.fill(defaultTile);
	}
	
	public void add(int x, int y, Tile t)
	{
		
	}
	
	public void drawRectangleWithCoords(Graphics g, Point p, Location center, int width,
			int height, int radius)
	{
		((DrawableHexGridInterface)gameMapGrid).drawRectangleWithCoords(g, p, (HexagonalLocation)center, width, height, radius);
	}
	
	public ModelView getView() {
		// TODO Auto-generated method stub
		return mapView;
	}

	public void spawn(Avatar av)
	{
		
	}
	
	public Tile getTile(Location location){
		return gameMapGrid.get(location);
	}

	public Entity getEntity(Location location) {
		return ((HexagonalGrid) gameMapGrid).getEntity(location);
	}
	
}

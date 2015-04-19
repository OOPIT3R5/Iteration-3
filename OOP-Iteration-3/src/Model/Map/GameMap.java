package Model.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Map.Grid.DrawableHexGridInterface;
import Model.Map.Grid.Grid;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.Grid.Tile.Tile;
import View.GameMapView;
import View.GameView;
import View.ModelView;


public class GameMap{
	
	
	GameMapView mapView;
	HexagonalGrid gameMapGrid;
	private int HEIGHT;
	private int WIDTH;
	private Avatar avatar;
	public ArrayList<HexagonalLocation> getLine(Location loc)
	{
		return null;
		//TODO modify location interface
		
		
	
	}

	public GameMap(int width, int height, Avatar a) {
		this.HEIGHT = height;
		this.WIDTH = width;
		this.avatar = a;
		 gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
		 mapView = new GameMapView(this);
		 //gameMapGrid.initalize();
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
		return mapView;
	}

	public void spawn(Avatar av)
	{
		HexagonalTile hexTile = new HexagonalTile();
		hexTile.setEntity(av);
		
		
	}
	
	public Tile getTile(Location location){
		return gameMapGrid.get(location);
	}

	public Entity getEntity(Location location) {
		return ((HexagonalGrid) gameMapGrid).getEntity(location);
	}
	
	public void render(Graphics g, Avatar av)
	{
		mapView.render(g);
	}

	

	public Avatar getAvatar() {
		// TODO Auto-generated method stub
		return avatar;
	}

	public ArrayList<HexagonalLocation> getHexTiles() {
		ArrayList<HexagonalLocation> locations;
		
		locations = HexagonalLocation.circle((HexagonalLocation)avatar.getLocation(), 49);
		
		return locations;
	}
	
}

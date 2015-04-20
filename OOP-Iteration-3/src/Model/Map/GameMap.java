package Model.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Items.MapObject;
import Model.Items.TakeableItem;
import Model.Map.Grid.DrawableHexGridInterface;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.Grid.Tile.Tile;
import Model.Terrain.Water;
import View.ModelView;
import View.Model.GameMapView;


public class GameMap {
	
	GameMapView mapView;
	HexagonalGrid gameMapGrid;
	private int HEIGHT;
	private int WIDTH;
	private Avatar avatar;
	
	public GameMap(int width, int height, Avatar a) {
		this.HEIGHT = height;
		this.WIDTH = width;
		this.avatar = a;
		 gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
		 mapView = new GameMapView();
		 //gameMapGrid.initalize();
		 
		// System.out.println("======MAP=======");
		// System.out.println(gameMapGrid.toString());
	}
	
	public GameMap(int width, int height)
	{
		this.HEIGHT = height;
		this.WIDTH = width;
		gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
		mapView = new GameMapView();
	}
	
	public void initialize() {
		gameMapGrid.add(0, 0, new HexagonalTile(new Water()));
		System.out.println("what");
		for (int i = 0; i < 8; i++) {
			gameMapGrid.add(7, i, new HexagonalTile(new Water()));
		}
	}
	
	public void drawRectangleWithCoords(Graphics g, Point p, Location center, int width,
			int height, int radius) {
		((DrawableHexGridInterface)gameMapGrid).drawRectangleWithCoords(g, p, (HexagonalLocation)center, width, height, radius);
		
	}
	
	public void fill(Tile defaultTile)
	{
		gameMapGrid.fill(defaultTile);
	}
	
	public void border(Tile border) {
		gameMapGrid.border(border);
	}
	
	public Avatar getAvatar() {
		return avatar;
	}
	
	public Entity getEntity(Location location) {
		return ((HexagonalGrid) gameMapGrid).getEntity(location);
	}

	public ArrayList<HexagonalTile> getTilesSurroundingAvatar(int radius) {
		ArrayList<HexagonalLocation> hex_coords;
		hex_coords = HexagonalLocation.circle((HexagonalLocation)avatar.getLocation(), radius);
		//hex_coords = HexagonalLocation.circle(new HexagonalLocation(4, 4), radius);
		//ArrayList<HexagonalTile> foo = gameMapGrid.getHexTiles(hex_coords);
		return gameMapGrid.getHexTiles(hex_coords);
	}

	public ArrayList<HexagonalLocation> getHexTileLocations() {
		
		ArrayList<HexagonalLocation> locations;
		
		locations = HexagonalLocation.circle((HexagonalLocation)avatar.getLocation(), 49);
		
		return locations;
	}
	
	public ArrayList<HexagonalLocation> getLine(Location loc)
	{
		return null;
		//TODO modify location interface
		
		
	
	}
	
	public Tile getTile(Location location){
		return gameMapGrid.get((HexagonalLocation)location);
	}

	public ModelView getView() {
		return mapView;
	}
	
	public void render(Graphics g, Avatar av) {
		mapView.render(g);
		gameMapGrid.render(g, av.getLocation(), 7);
		//DrawableHexGridInterface drawable_grid = gameMapGrid;
		//drawable_grid.render(g, new Point(400, 400), (HexagonalLocation)av.getLocation(), 3, 40);
	}

	public void spawn(Entity e, HexagonalLocation location) {
		HexagonalTile hexTile = gameMapGrid.get(location);
		e.setLocation(location);
		hexTile.setEntity(e);
	}
	


	public void spawnObject(MapObject o, HexagonalLocation location) {
		HexagonalTile hexTile = gameMapGrid.get(location);
		hexTile.setMapObject(o);
	}
	
	
	public Iterator<HexagonalTile> getIterator()
	{
		gameMapGrid.initializeIterator();
		return gameMapGrid;
	}
	
	
	
	public void addEntity(int i , int j, Entity e)
	{
		gameMapGrid.addEntity(i, j, e);
	}
	
	
	public void addMapObject(int i , int j , MapObject mo)
	{
		gameMapGrid.addMapObject(i , j , mo);
	}
	
	public ArrayList<Entity> getAllNPCS()
	{
		ArrayList<Entity> npcs = new ArrayList<Entity>();
		gameMapGrid.initializeIterator();
		Iterator<HexagonalTile> iterator = gameMapGrid;
		while(iterator.hasNext())
		{
			HexagonalTile tile = iterator.next();
			Entity curEntity = tile.getEntity();
			if(curEntity != null)
				npcs.add(curEntity);
		}
		
		return npcs;
		
		
	}
	
	public void eraseEverything()
	{
		Iterator<HexagonalTile> iterator = gameMapGrid;
		while(iterator.hasNext())
		{
			HexagonalTile tile = iterator.next();
			tile.nullify();
		}
	}

	
	
}

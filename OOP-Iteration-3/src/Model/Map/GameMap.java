package Model.Map;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Entity.NPC;
import Model.Items.MapObject;
import Model.Map.Grid.DrawableHexGridInterface;
import Model.Map.Grid.HexagonalGrid;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.Grid.Tile.Tile;
import View.ModelView;
import View.Model.GameMapView;


public class GameMap {
	
	private GameMapView mapView;
	private HexagonalGrid gameMapGrid;
	
	private int HEIGHT;
	private int WIDTH;
	
	private Avatar avatar;
	private HashMap<HexagonalLocation, Entity> entities = new HashMap<HexagonalLocation, Entity>();
	private HashMap<HexagonalLocation, MapObject> map_objects = new HashMap<HexagonalLocation, MapObject>();
	
	public GameMap(int width, int height, Avatar a) {
		this.HEIGHT = height;
		this.WIDTH = width;
		this.avatar = a;
		gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
		mapView = new GameMapView();
	}
	
	/*public GameMap(int width, int height) {
		this.HEIGHT = height;
		this.WIDTH = width;
		gameMapGrid =  new HexagonalGrid(HEIGHT, WIDTH);
		mapView = new GameMapView();
	}*/
	
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

	public ArrayList<HexagonalTile> getTilesSurroundingAvatar(int radius) {
		ArrayList<HexagonalLocation> hex_coords;
		hex_coords = HexagonalLocation.circle((HexagonalLocation)avatar.getLocation(), radius);
		return gameMapGrid.getHexTiles(hex_coords);
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

	public void spawnEntity(Entity entity, HexagonalLocation location) {
		entity.setLocation(location);
		entities.put(location, entity);
	}

	public void spawnObject(MapObject object, HexagonalLocation location) {
		map_objects.put(location, object);
	}
	
	/*public Iterator<HexagonalTile> getIterator()
	{
		gameMapGrid.initializeIterator();
		return gameMapGrid;
	}*/
	
	public ArrayList<Entity> getEntities() {
		ArrayList<Entity> alEntities = new ArrayList<Entity>();
		Iterator<Entry<HexagonalLocation, Entity>> it = entities.entrySet().iterator();
		while (it.hasNext()) {
	    	HashMap.Entry<HexagonalLocation, Entity> entity = it.next();
	    	alEntities.add((Entity)entity.getValue());
	    	it.remove();
		}
		return alEntities;		
	}
	
	public void moveEntity(Entity entity, Direction direction) {
		if (entity.equals(avatar)) {
			Location target = avatar.getLocation().getNeighbor(direction);
			gameMapGrid.move(entity, target);
		}
	}
	
	public Entity getEntity(Location location) {
		return entities.get(location);
	}
	
	public void removeEntity(Entity entity) {
		entities.values().removeAll(Collections.singleton(entity));
	}

	public ArrayList<MapObject> getObjects() {
		ArrayList<MapObject> alObjects = new ArrayList<MapObject>();
		Iterator<Entry<HexagonalLocation, MapObject>> it = map_objects.entrySet().iterator();
		while (it.hasNext()) {
	    	HashMap.Entry<HexagonalLocation, MapObject> entity = it.next();
	    	alObjects.add((MapObject)entity.getValue());
	    	it.remove();
		}
		return alObjects;
	}
	
	public MapObject getMapObject(Location location) {
		return map_objects.get(location);
	}
	
}

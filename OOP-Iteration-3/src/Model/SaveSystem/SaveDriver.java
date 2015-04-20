package Model.SaveSystem;

import java.util.ArrayList;
import java.util.Iterator;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;

public class SaveDriver {
	ArrayList<Entity> entities;
	ArrayList<MapObject> mapObjects;
	Iterator<HexagonalTile> iterator;
	GameMap map;
	Saver saver;
	String save;
	public SaveDriver(GameMap map, Saver saver)
	{
		this.map = map;
		initialize();
		this.saver = saver;
		
		save = saveEverything();
		
	}
	
	private String saveEverything()
	{
		StringBuilder gameSave = new StringBuilder();
		for(Entity e: entities)
		{
			gameSave.append(saver.save(e));
		}
		
		for(MapObject mo : mapObjects)
		{
			gameSave.append(saver.save(mo));
		}
		
		return gameSave.toString();
	}
	
	private void initialize()
	{
		this.iterator = map.getIterator();
		
		while(iterator.hasNext())
		{
			HexagonalTile tile = iterator.next();
			Entity entity = tile.getEntity();
			MapObject mo = tile.getMapObject();
			
			if(entity != null)
				entities.add(entity);
			
			if(mo != null)
				mapObjects.add(mo);
			
			
		}
	}
	
}

package Model.SaveSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Model.Entity.Entity;
import Model.Items.MapObject;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;

public class SaveDriver {
	ArrayList<Entity> entities;
	//ArrayList<MapObject> mapObjects;
	HashMap<HexagonalLocation, MapObject> mapObjects;
	//HashMap<HexagonalLocation, Entity> entities;
	Iterator<HexagonalTile> iterator;
	GameMap map;
	Saver saver;
	String save;
	public SaveDriver(GameMap map, Saver saver)
	{
		
		entities = new ArrayList<Entity>();
		mapObjects = new HashMap<HexagonalLocation , MapObject>();
		
		
		this.map = map;
		initialize();
		this.saver = saver;
		
		save = saveEverything();
		System.out.println(save);
		
	}
	
	private String saveEverything()
	{
		StringBuilder gameSave = new StringBuilder();
		gameSave.append("gamesave");
		for(Entity e: entities)
		{
			gameSave.append(saver.save(e));
			gameSave.append("\n");
		}
		
		for(Entry<HexagonalLocation, MapObject> mo : mapObjects.entrySet())
		{
			gameSave.append(saver.save(mo.getKey() , mo.getValue()));
			gameSave.append("\n");
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
				mapObjects.put(tile.getLocation() , mo);
			
			
		}
	}
	
}

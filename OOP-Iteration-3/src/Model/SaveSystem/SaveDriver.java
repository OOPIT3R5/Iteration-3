package Model.SaveSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
		
		String fname = "save.csv";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(save);
		writer.close();
		//File saveFile = new File(System.getProperty("user.dir") + "/Assets/save");
		
		System.out.println("GAME SAVED");
		
	}
	
	private String saveEverything()
	{
		StringBuilder gameSave = new StringBuilder();
	
		
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

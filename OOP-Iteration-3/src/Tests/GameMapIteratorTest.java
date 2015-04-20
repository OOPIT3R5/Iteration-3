package Tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import Model.Entity.Entity;
import Model.Entity.Monster;
import Model.Items.MapObject;
import Model.Items.ShoesItem;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Map.Grid.Tile.Tile;

public class GameMapIteratorTest {

	@Test
	public void test() {
		GameMap gm = new GameMap(10, 10);
		Iterator<HexagonalTile> iterator = gm.getIterator();
		
		Entity monster = new Monster();
		MapObject shoes = new ShoesItem(10, "nike", null);
		
		
		gm.addEntity(1, 1, monster);
		gm.addMapObject(1, 2, shoes);
		
		while(iterator.hasNext())
		{
			Tile curTile = iterator.next();
			boolean hasEntity = curTile.hasEntity();
			boolean hasMapObject = curTile.hasMapObject();
			if(hasEntity)
				System.out.println("Entity here");
			
			if(hasMapObject)
				System.out.println("MapObject here");
			
			else
				System.out.println("empty tile");
		}
	}

}

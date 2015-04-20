package Tests;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import Model.Entity.Entity;
import Model.Entity.Monster;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;

public class GameMapIteratorTest {

	@Test
	public void test() {
		GameMap gm = new GameMap(10, 10);
		Iterator<HexagonalTile> iterator = gm.getIterator();
		Entity monster = new Monster();
		gm.addEntity(1, 1, monster);
		while(iterator.hasNext())
		{
			System.out.println(iterator.next().hasEntity());
		}
	}

}

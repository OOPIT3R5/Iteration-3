package Utility;

import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.Monster;
import Model.Items.MapObject;
import Model.Items.ShoesItem;
import Model.Map.GameMap;
import View.Model.MapObjectView;

/**
 * The DefaultGame object takes the GameMap from MainMenuController and 
 * adds some entities and objects to it.
 * 
 *
 */
public class DefaultGame {

	GameMap gm;
	
	public DefaultGame(GameMap gm)
	{
		this.gm = gm;
		initializeGame();
	}
	
	private void initializeGame()
	{
		System.out.println("EMPHASIS");
		Entity monster = new Monster();
		MapObject shoes = null;
		try {
			shoes = new ShoesItem(10, "nike", new MapObjectView(MapObjectView.getSpriteFromFE(1, 1)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		gm.addEntity(5, 5, monster);
		gm.addMapObject(1, 2, shoes);
		
		monster.setMap(gm);
		System.out.println("MONSTER BEEN ADDED TO MAP");
		
		
	}
	
	
	
}

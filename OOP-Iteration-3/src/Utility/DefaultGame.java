package Utility;

import java.io.IOException;

import Model.Entity.Avatar;
import Model.Entity.Entity;
import Model.Entity.HelpfulMenace;
import Model.Entity.NPC;
import Model.Entity.Pet;
import Model.Entity.Monster;
import Model.Entity.PetOwnership;
import Model.Entity.TroublesomeMenace;
import Model.Items.MapObject;
import Model.Items.ShoesItem;
import Model.Items.TakeDamageAreaEffect;
import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
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
		
		Entity pet 
		PetOwnership po = new PetOwnership(gm.getAvatar(), ((Pet)pet));
		
		
		Entity NoMoveEntity = new Monster();
		((NPC)NoMoveEntity).becomeNonHostile();

		
		MapObject shoes = null;
		try {
			shoes = new ShoesItem(10, "nike", new MapObjectView(MapObjectView.getSpriteFromFE(1, 1)));
			pet = = new TroublesomeMenace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		

		monster.setLocation(new HexagonalLocation(5, 5));
		gm.spawn(monster, new HexagonalLocation(5, 5));

		NoMoveEntity.setLocation(new HexagonalLocation(1,6));
		gm.spawn(NoMoveEntity, new HexagonalLocation(1,6));
		
		gm.addMapObject(1, 2, shoes);
		
		pet.setLocation(new HexagonalLocation(2, 2));
		gm.spawn(pet, new HexagonalLocation(2, 2));
		
		NoMoveEntity.setMap(gm);
		pet.setMap(gm);
		monster.setMap(gm);
		System.out.println("MONSTER BEEN ADDED TO MAP");
		
		
	}
	
	
	
}

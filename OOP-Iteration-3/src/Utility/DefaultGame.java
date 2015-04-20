package Utility;

import java.io.IOException;

import Model.Entity.Entity;
import Model.Entity.Monster;
import Model.Entity.NPC;
import Model.Entity.Pet;
import Model.Entity.PetOwnership;
import Model.Entity.TroublesomeMenace;
import Model.Entity.Ability.TeleportItemAbility;
import Model.Items.HealDamageAreaEffect;
import Model.Items.LevelUpAreaEffect;
import Model.Items.MapObject;
import Model.Items.Obstacle;
import Model.Items.OneShotItem;
import Model.Items.ShoesItem;
import Model.Items.Trap;
import Model.Items.TwoHandedWeaponItem;
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
		
		Entity pet = new TroublesomeMenace();
		PetOwnership po = new PetOwnership(gm.getAvatar(), ((Pet)pet));
		
		
		Entity NoMoveEntity = new Monster();
		((NPC)NoMoveEntity).becomeNonHostile();
		MapObject trap = null;
		MapObject sword = null;
		MapObject shoes = null;
		MapObject heal = null;
		MapObject levelUp = null;
		MapObject levelUp2 = null;
		MapObject levelUp3 = null;
		MapObject levelUp4 = null;
		MapObject teleport = null;
		MapObject obstacle = null;
		
		try {
			obstacle = new Obstacle("big boulder",  new MapObjectView(MapObjectView.getSpriteFromPokemon(1, 0)));
			teleport = new OneShotItem(new TeleportItemAbility(47, 25, gm), "awesome tel",  new MapObjectView(MapObjectView.getSpriteFromFE(11, 0)));
			levelUp = new LevelUpAreaEffect( new MapObjectView(MapObjectView.getSpriteFromFE(2, 0)));
			levelUp2 = new LevelUpAreaEffect( new MapObjectView(MapObjectView.getSpriteFromFE(2, 0)));

			levelUp3 = new LevelUpAreaEffect( new MapObjectView(MapObjectView.getSpriteFromFE(2, 0)));

			levelUp4 = new LevelUpAreaEffect( new MapObjectView(MapObjectView.getSpriteFromFE(2, 0)));

			trap = new Trap(50,new MapObjectView(MapObjectView.getSpriteFromFE(4, 0)));
			shoes = new ShoesItem(10, "nike", new MapObjectView(MapObjectView.getSpriteFromFE(1, 1)));
			sword = new TwoHandedWeaponItem(10, "sword", new MapObjectView(MapObjectView.getSpriteFromFE(3, 1)));
			heal = new HealDamageAreaEffect(10,new MapObjectView(MapObjectView.getSpriteFromFE(3, 0)) );
			//pet =  new TroublesomeMenace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
		
		
		monster.setLocation(new HexagonalLocation(5, 5));
		gm.spawn(monster, new HexagonalLocation(5, 5));

		NoMoveEntity.setLocation(new HexagonalLocation(1,6));
		gm.addMapObject(2, 2, obstacle);
		gm.spawn(NoMoveEntity, new HexagonalLocation(1,6));
		gm.addMapObject(1, 1, teleport);
		gm.addMapObject(50, 51, levelUp);
		gm.addMapObject(49, 51, levelUp2);

		gm.addMapObject(47, 51, levelUp3);

		gm.addMapObject(46, 51, levelUp4);

		
		gm.addMapObject(10, 1, heal);
		gm.addMapObject(1, 10, trap);
		gm.addMapObject(1, 2, shoes);
		gm.addMapObject(1, 4, sword);
		
		pet.setLocation(new HexagonalLocation(2, 2));
		gm.spawn(pet, new HexagonalLocation(2, 2));
		
		NoMoveEntity.setMap(gm);
		pet.setMap(gm);
		monster.setMap(gm);
		System.out.println("MONSTER BEEN ADDED TO MAP");
		
		
	}
	
	
	
}

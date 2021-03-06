package Main;

import java.io.IOException;

import Model.Entity.Avatar;
import Model.Entity.Ability.HealLifeItemAbility;
import Model.Entity.Ability.HealManaItemAbility;
import Model.Items.AccessoryItem;
import Model.Items.ArmorItem;
import Model.Items.OneHandedWeaponItem;
import Model.Items.ShoesItem;
import Model.Items.SmasherShieldOffHandItem;
import Model.Items.SneakWeaponItem;
import Model.Items.SummonerTomeOffHandItem;
import Model.Items.SummonerWeaponItem;
import Model.Items.TwoHandedWeaponItem;
import Model.Items.UsableItem;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import View.GameView;
import View.Model.MapObjectView;

public class Game {
	
	GameView gameView;
	GameMap gameMap;
	Avatar avatar;
	
	
	//constructor for new game
	public Game(Avatar a){
		
		this.avatar = a;
		gameMap = new GameMap(100, 100, avatar);
	    setUpAvatar(avatar);
		
		gameMap.spawn(avatar, avatar.getLocation());
		gameView = new GameView(gameMap, avatar);
		this.gameMap.fill(new HexagonalTile(new Grass()));
		gameMap.border(new HexagonalTile(new Mountain()));
		gameMap.initialize();
		
	}
	
	//constructor for load game
	public Game(GameMap gameMap, Avatar avatar) {
		
		this.gameMap = gameMap;
		this.avatar = avatar;
		this.gameMap.fill(new HexagonalTile(new Grass()));
	}
	
	public void erase()
	{
		gameMap.eraseEverything();
	}
	
	public Avatar getAvatar(){
			return avatar;
		
	}
	public GameMap getGameMap() {
		return gameMap;
	}
	
	public GameView getView(){
		
		return gameView;
	}

	public void setGameMap(GameMap gameMap) {
		this.gameMap = gameMap;
	}
	
	public void setUpAvatar(Avatar avatar){
			avatar.reset();
	        try{
	            avatar.addToInventory(new TwoHandedWeaponItem(50, "Dirty Rapier", new MapObjectView(MapObjectView.getSpriteFromFE(0, 4))));
	            avatar.addToInventory(new AccessoryItem(10, "Psyduck Cup", new MapObjectView(MapObjectView.getSpriteFromPokemon(22, 13))));
	            avatar.addToInventory(new ShoesItem(5, "Boots of Fury", new MapObjectView(MapObjectView.getSpriteFromFE(9, 7))));
	            avatar.addToInventory(new SummonerTomeOffHandItem(2, "Kickass Book", new MapObjectView(MapObjectView.getSpriteFromFE(0,6))));
                avatar.addToInventory(new SmasherShieldOffHandItem(3, "Shield of #REKT", new MapObjectView(MapObjectView.getSpriteFromFE(7,7))));
	            avatar.addToInventory(new OneHandedWeaponItem(25, "Rapier", new MapObjectView(MapObjectView.getSpriteFromFE(13,3))));
	            avatar.addToInventory(new ArmorItem(55,"Big Boss Armor", new MapObjectView(MapObjectView.getSpriteFromFE(31,0))));
                avatar.addToInventory(new SneakWeaponItem(25, "Ranged Bow", new MapObjectView(MapObjectView.getSpriteFromFE(18,4))));
                avatar.addToInventory(new SummonerWeaponItem(50, "Staff of Awesomeness", new MapObjectView(MapObjectView.getSpriteFromFE(8,6))));
                avatar.addToInventory(new UsableItem(new HealLifeItemAbility(50),"HP Potion", new MapObjectView(MapObjectView.getSpriteFromPokemon(5,0)), avatar));
                avatar.addToInventory(new UsableItem(new HealManaItemAbility(50),"MP Potion", new MapObjectView(MapObjectView.getSpriteFromPokemon(5,6)), avatar));
                avatar.awardGold(100);
                avatar.awardExperience(250);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}


}

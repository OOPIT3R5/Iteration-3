package Main;

import java.io.IOException;

import Model.Entity.Avatar;
import Model.Entity.Smasher;
import Model.Entity.Ability.DoNothing;
import Model.Items.AccessoryItem;
import Model.Items.ArmorItem;
import Model.Items.OneHandedWeaponItem;
import Model.Items.ShoesItem;
import Model.Items.SmasherShieldOffHandItem;
import Model.Items.TwoHandedWeaponItem;
import Model.Map.GameMap;
import View.GameView;
import View.MapObjectView;

public class Game {
	
	GameView gameView;
	GameMap gameMap;
	Avatar avatar;
	
	
	//constructor for new game
	public Game(Avatar a){
		
		this.avatar = a;
		gameMap = new GameMap(10, 10);
	    setUpAvatar(avatar);
		
		gameMap.spawn(avatar);
		gameView = new GameView(gameMap, avatar);
	}
	
	//constructor for load game
	public Game(GameMap gameMap, Avatar avatar){
		
		this.gameMap = gameMap;
		this.avatar = avatar;
	
		
	}
	
	public void setUpAvatar(Avatar avatar){
		 
	        try{
	            avatar.addToInventory(new TwoHandedWeaponItem(50, new DoNothing(), "Dirty Rapier", new MapObjectView(MapObjectView.getSpriteFromFE(0, 4))));
	            avatar.addToInventory(new AccessoryItem(10, new DoNothing(), "Psyduck Cup", new MapObjectView(MapObjectView.getSpriteFromPokemon(22, 13))));
	            avatar.addToInventory(new ShoesItem(5, new DoNothing(), "Boots of Fury", new MapObjectView(MapObjectView.getSpriteFromFE(9, 7))));
	            avatar.addToInventory(new SmasherShieldOffHandItem(2, new DoNothing(), "Kickass Book", new MapObjectView(MapObjectView.getSpriteFromFE(0,6))));
	            avatar.addToInventory(new OneHandedWeaponItem(25, new DoNothing(), "Rapier", new MapObjectView(MapObjectView.getSpriteFromFE(13,3))));
	            avatar.addToInventory(new ArmorItem(55, new DoNothing(), "Big Boss Armor", new MapObjectView(MapObjectView.getSpriteFromFE(31,0))));
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	}
	
	public Avatar getAvatar(){
			return avatar;
		
	}
	public GameView getView(){
		
		return gameView;
	}


}
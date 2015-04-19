package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Entity;
import Model.Entity.Smasher;
import Model.Items.*;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;
import View.GameView;
import View.MapObjectView;
import View.ModelView;

public class GameController extends Controller {
	String next = "";
	Entity e;

	private static GameController instance = null;
	GameMap map = new GameMap(100,100);

	KeyListener back = new BacktoMainMenu();
	KeyListener inv = new InventoryListener();
	KeyListener render = new Render();
	
	ModelView tempView = new GameView(); //This will be removed
	
	private GameController() {
		map.fill(new HexagonalTile(new Grass()));		// populate map from file?
		map.add(1, 1, new HexagonalTile(new Water()));
		map.add(5, 5, new HexagonalTile(new Mountain()));

        e = new Entity("Joshua");
        new Smasher(e);
        try{
            e.addToInventory(new TwoHandedWeaponItem(50, new DoNothing(), "Dirty Rapier", new MapObjectView(MapObjectView.getSpriteFromFE(0, 4))));
            e.addToInventory(new AccessoryItem(10, new DoNothing(), "Psyduck Cup", new MapObjectView(MapObjectView.getSpriteFromPokemon(22, 13))));
            e.addToInventory(new ShoesItem(5, new DoNothing(), "Boots of Fury", new MapObjectView(MapObjectView.getSpriteFromFE(9, 7))));
            e.addToInventory(new SmasherShieldOffHandItem(2, new DoNothing(), "Kickass book", new MapObjectView(MapObjectView.getSpriteFromFE(0,6))));
            //System.out.println(e.inven
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static GameController getInstance(){
		
		if(instance == null){
			
			instance = new GameController();
		}
		return instance;
	}
	@Override
	public ModelView getView() {
		return map.getView(); 	//TBD!!!!!!!!!!!!!!!!!!!!!!
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(back);
		f.addKeyListener(inv);
		f.addKeyListener(render);
	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(back);
		f.removeKeyListener(inv);
		f.removeKeyListener(render);
	}
	
	public class BacktoMainMenu implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("BACK")){
				setNext(MainMenuController.getInstance());		
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class InventoryListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("INVENTORY")){
				setNext(InventoryController.getInstance(e));
				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}

}

package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Entity.Entity;
import Model.Entity.Smasher;
import Model.Items.*;
import Model.Map.Direction;
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
	
	ArrayList<KeyListener> listeners = new ArrayList<KeyListener>();
	
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
        listeners.add(new BacktoMainMenu());
        listeners.add(new InventoryListener());
        listeners.add(new Render());
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
		for(int i = 0; i < listeners.size(); i++){
			f.addKeyListener(listeners.get(i));
		}
	}

	@Override
	public void deRegister(JFrame f) {
		for(int i = 0; i < listeners.size(); i++){
			f.removeKeyListener(listeners.get(i));
		}
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
	
	public class MoveUpListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent k) {
			int key = k.getKeyCode();
			if(key == KeySet.getKey("NORTH")){
				Move m = new Move(e,map,Direction.NORTH,e.getMovementSpeed());
				m.execute();
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

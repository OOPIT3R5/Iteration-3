package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Entity.Entity;
import Model.Map.GameMap;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;
import View.GameView;
import View.ModelView;


public class GameController extends Controller {
	String next = "";
	Entity e = new Entity(); //TBD!!!!!!!!!!!!!!!!!!!!
	private static GameController instance = null;
	GameMap map = new GameMap(100,100);
	
	KeyListener back = new BacktoMainMenu();
	KeyListener inv = new InventoryListener();
	
	ModelView tempView = new GameView(); //This will be removed
	
	private GameController() {
		map.fill(new HexagonalTile(new Grass()));		// populate map from file?
		map.add(1, 1, new HexagonalTile(new Water()));
		map.add(5, 5, new HexagonalTile(new Mountain()));
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
	public Controller update() {
		if(next.equals("main")){
			return  MainMenuController.getInstance();
		}
		return InventoryController.getInstance();
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(back);
		f.addKeyListener(inv);
	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(back);
		f.removeKeyListener(inv);
	}
	
	public class BacktoMainMenu implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("BACK")){
				next = "main";
				setChanged();
				notifyObservers();
				deleteObservers();
				
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
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("INVENTORY")){
				next = "inventory";
				setChanged();
				notifyObservers();
				deleteObservers();
				
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

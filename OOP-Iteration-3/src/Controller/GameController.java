package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;

import Main.Game;
import Main.KeySet;
import Model.Entity.Ability.DoNothing;
import Model.Entity.Ability.Move;
import Model.Entity.Avatar;
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
	private static Avatar avatar;

	private static Game game;
	private static GameController instance = null;

	KeyListener back = new BacktoMainMenu();
	KeyListener inv = new InventoryListener();
	KeyListener render = new Render();
	
	 //This will be removed
	
	private GameController() {
		
	}
	public static void setGame(Game g){
		
		game = g;
		avatar = g.getAvatar();
		
	}
	
	public static GameController getInstance(){
		
		if(instance == null){
			
			instance = new GameController();
		}
		return instance;
	}
	@Override
	public ModelView getView() {
		return game.getView(); 	//TBD!!!!!!!!!!!!!!!!!!!!!!
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
				setNext(InventoryController.getInstance(avatar));
				
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

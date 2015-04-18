package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Model.Entity.Entity;
import View.GameView;
import View.ModelView;


public class GameController extends Controller {
	String next = "";
	Entity e = new Entity(); //TBD!!!!!!!!!!!!!!!!!!!!
	
	KeyListener back = new BacktoMainMenu();
	KeyListener inv = new InventoryListener();
	
	ModelView tempView = new GameView(); //This will be removed
	
	public GameController() {
		addObserver(RunGame.r);
	}

	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return tempView; //TBD!!!!!!!!!!!!!!!!!!!!!!
	}

	@Override
	public Controller update() {
		if(next.equals("main")){
			return new MainMenuController();
		}
		return new InventoryController();
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
			if(key == RunGame.getKey("BACK")){
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
			if(key == RunGame.getKey("INVENTORY")){
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

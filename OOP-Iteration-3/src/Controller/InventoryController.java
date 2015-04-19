package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Entity.Entity;
import View.InventoryView;
import View.ModelView;

public class InventoryController extends Controller {
	KeyListener back = new BacktoGame();
	KeyListener render = new Render();
	
	private static InventoryController instance;
	
	private static InventoryView inventoryView;
	
	private InventoryController(Entity e){
		
		
	}
	
	public static InventoryController getInstance(Entity e){
		if(instance == null){
			
			instance = new InventoryController(e);
			inventoryView = new InventoryView(e);
			
		}
		return instance;
	}
	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return inventoryView;
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(back);
		f.addKeyListener(render);
	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(render);
		f.removeKeyListener(back);
	}
	
	public class BacktoGame implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("BACK")){
				setNext(GameController.getInstance());
				
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

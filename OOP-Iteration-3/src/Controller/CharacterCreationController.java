package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Menu.CharacterCreation;
import View.ModelView;

public class CharacterCreationController extends Controller  {
	CharacterCreation cm = new CharacterCreation();
	
	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	KeyListener enter = new Update();
	
	public CharacterCreationController() {
	}
	
	public void register(JFrame f){
		f.addKeyListener(enter);
		f.addKeyListener(down);
		f.addKeyListener(up);
	}
	
	public void deRegister(JFrame f){
		f.removeKeyListener(enter);
		f.removeKeyListener(down);
		f.removeKeyListener(up);
	}

	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return cm.getView();
	}

	@Override
	public Controller update() {
		return new MainMenuController();
	}
	
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("NORTH") || key == KeySet.getKey("EAST")){
				cm.MoveUp();
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
	public class DownAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("WEST") || key == KeySet.getKey("SOUTH")){
				cm.MoveDown();
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
	
	public class Update implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("ENTER")){
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

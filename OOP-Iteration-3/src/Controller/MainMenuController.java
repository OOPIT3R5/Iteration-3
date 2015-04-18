package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import Main.RunGame;
import Model.Menu.MainMenu;
import View.ModelView;



public class MainMenuController extends Controller {
	MainMenu mm;
	
	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	KeyListener enter = new Update();
	
	public MainMenuController(){
		mm = new MainMenu();
	}
	
	public void register(JFrame f){
		f.addKeyListener(up);
		f.addKeyListener(down);
		f.addKeyListener(enter);
	}
	public void deRegister(JFrame f){
		f.removeKeyListener(up);
		f.removeKeyListener(down);
		f.removeKeyListener(enter);
	}
	public ModelView getView(){
		return mm.getView();
	}
	
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("SOUTH")){
				mm.MoveUp();
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
			if(key == KeySet.getKey("NORTH")){
				mm.MoveDown();
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

	@Override
	public Controller update() {
		String state = mm.getState();
		if(state.equals("new")){ //Is there a way around this?
			return new CharacterCreationController();
		}
		else if(state.equals("options")){
			return new ConfigController();
		}
		else if(state.equals("load")){
			return new GameController();
		}
		return null;
		
	}
}

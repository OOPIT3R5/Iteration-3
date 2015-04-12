package Controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Model.Menu.MainMenu;



public class MainMenuController extends Controller {
	MainMenu mm = new MainMenu();
	
	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	KeyListener enter = new Update();
	
	public MainMenuController(){
		addObserver(RunGame.r);
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
	public JComponent getView(){
		return mm.getView();
	}
	
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_W){
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
			if(key == KeyEvent.VK_S){
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
			if(key == KeyEvent.VK_ENTER){
				setChanged();
				notifyObservers();
				deleteObserver(RunGame.r);
				
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
		return null;
		
	}
}

package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import Model.Menu.ConfigControls;
import View.ModelView;

public class ConfigController extends Controller {
	boolean binding = false;
	KeyListener bind = new BindAction();
	KeyListener rst = new ResetAction();
	KeyListener enter = new Update();
	KeyListener up = new UpAction();
	KeyListener down = new DownAction();
	
	ConfigControls cc = new ConfigControls();
	
	public ConfigController() {
		addObserver(RunGame.r);
	}

	@Override
	public ModelView getView() {
		// TODO Auto-generated method stub
		return cc.getView();
	}

	@Override
	public Controller update() {
		return new MainMenuController();
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(up);
		f.addKeyListener(down);
		f.addKeyListener(bind);
		f.addKeyListener(rst);
		f.addKeyListener(enter);

	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(up);
		f.removeKeyListener(down);
		f.removeKeyListener(bind);
		f.removeKeyListener(rst);
		f.removeKeyListener(enter);
	}
	public class Update implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_ESCAPE){
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
	
	public class BindAction implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
	        if (e.getKeyChar() == RunGame.getKey("ENTER")) {
	        	binding  = true;
	        }
	        else if(binding){
	        	binding = false;
	        	RunGame.setKey(cc.getState(), e.getKeyCode());
	        	RunGame.paint();
	        }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	}
	
	public class ResetAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_R){
				RunGame.keyReset();
				RunGame.paint();
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
	
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == RunGame.getKey("SOUTH") && !binding){
				cc.MoveUp();
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
			if(key == RunGame.getKey("NORTH") && !binding){
				cc.MoveDown();
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

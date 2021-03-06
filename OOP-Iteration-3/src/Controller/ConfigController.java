package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import Main.KeySet;
import Model.Menu.ConfigControls;
import View.ModelView;

public class ConfigController extends Controller {
	
	public class BindAction implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
	        if (e.getKeyChar() == KeySet.getKey("ENTER")) {
	        	binding  = true;
	        }
	        else if(binding){
	        	binding = false;
	        	KeySet.setKey(cc.getState(), e.getKeyCode());
	        }
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class DownAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("NORTH") && !binding){
				cc.MoveDown();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class ResetAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_R){
				KeySet.keyReset();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class UpAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeySet.getKey("SOUTH") && !binding){
				cc.MoveUp();
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public class Update implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_ESCAPE){
				setNext(MainMenuController.getInstance());
			}
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
	public static ConfigController getInstance(){
		
		if(instance == null){
			instance = new ConfigController();
		}
		return instance;
	}
	private static ConfigController instance;
	boolean binding = false;
	
	KeyListener bind = new BindAction();

	KeyListener rst = new ResetAction();
	KeyListener enter = new Update();

	KeyListener up = new UpAction();

	KeyListener down = new DownAction();
	KeyListener render = new Render();
	
	ConfigControls cc = new ConfigControls();
	
	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(up);
		f.removeKeyListener(down);
		f.removeKeyListener(bind);
		f.removeKeyListener(rst);
		f.removeKeyListener(enter);
		f.removeKeyListener(render);
	}
	
	@Override
	public ModelView getView() {
		return cc.getView();
	}
	@Override
	public void register(JFrame f) {
		f.addKeyListener(up);
		f.addKeyListener(down);
		f.addKeyListener(bind);
		f.addKeyListener(rst);
		f.addKeyListener(enter);
		f.addKeyListener(render);

	}

}

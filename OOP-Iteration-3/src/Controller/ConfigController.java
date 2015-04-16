package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Model.Menu.ConfigControls;

public class ConfigController extends Controller {
	
	KeyListener bind = new BindAction();
	KeyListener rst = new ResetAction();
	KeyListener enter = new Update();
	KeyListener key = new KeyAction();
	
	ConfigControls cc = new ConfigControls();
	
	public ConfigController() {
		addObserver(RunGame.r);
	}

	@Override
	public JComponent getView() {
		// TODO Auto-generated method stub
		return cc.getView();
	}

	@Override
	public Controller update() {
		return new MainMenuController();
	}

	@Override
	public void register(JFrame f) {
		f.addKeyListener(bind);
		f.addKeyListener(rst);
		f.addKeyListener(enter);
		f.addKeyListener(key);

	}

	@Override
	public void deRegister(JFrame f) {
		f.removeKeyListener(bind);
		f.removeKeyListener(rst);
		f.removeKeyListener(enter);
		f.removeKeyListener(key);
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
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_ENTER){
				RunGame.setKey(cc.readKey(), cc.readValue());
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
	
	public class ResetAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if(key == KeyEvent.VK_R){
				RunGame.keyReset();
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
	
	public class KeyAction implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			cc.selectKey(KeyEvent.getKeyText(key));
			
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

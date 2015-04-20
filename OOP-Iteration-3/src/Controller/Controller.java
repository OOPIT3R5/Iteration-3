package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JComponent;
import javax.swing.JFrame;

import Main.KeySet;
import View.ModelView;

public abstract class Controller extends Observable {
	Controller next;
	public abstract ModelView getView();
	public abstract void register(JFrame f);
	public abstract void deRegister(JFrame f);
	
	public Controller(){
		setNext(this);
	}
	public Controller update(){
		return next;
	}
	
	public void setNext(Controller next){
		this.next = next;
	}
	
	public class Render implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			setChanged();
			notifyObservers();
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	}
}		

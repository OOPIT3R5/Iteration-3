package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;

import View.ModelView;

public abstract class Controller extends Observable {
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
	Controller next;
	public Controller(){
		setNext(this);
	}
	public abstract void deRegister(JFrame f);
	
	public abstract ModelView getView();
	public abstract void register(JFrame f);
	
	public void setNext(Controller next){
		this.next = next;
	}
	
	public Controller update(){
		return next;
	}
}		

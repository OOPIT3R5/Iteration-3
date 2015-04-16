package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class Controller extends Observable {
	public abstract JComponent getView();
	public abstract Controller update();
	public abstract void register(JFrame f);
	public abstract void deRegister(JFrame f);
}		

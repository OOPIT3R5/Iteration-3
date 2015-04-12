package Controller;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Controller.Controller;
import Controller.MainMenuController;


public class RunGame implements Observer {
	
	private JFrame frame = new JFrame();
	Controller c = null;
	public static RunGame r = null;
	
	public static void main(String argv[]){
		r = new RunGame();
		r.init();
	}
	
	public void init(){
		c = new MainMenuController();
		frame.add(c.getView());
		c.register(frame);
		frame.setFocusable(true);
        frame.setLayout(new FlowLayout());
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
	}
	public void quit(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	@Override
	public void update(Observable o, Object arg) {
		frame.remove(c.getView());
		c.deRegister(frame);
		if((c = c.update()) == null){ //Use a QuitController instead
			quit();
			return;
		}
		c.register(frame);
		frame.add(c.getView());
		frame.revalidate();
        frame.repaint();
	}
	
	

}

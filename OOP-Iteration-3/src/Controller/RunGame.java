package Controller;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import Controller.Controller;
import Controller.MainMenuController;


public class RunGame implements Observer {
	
	private JFrame frame = new JFrame();
	Controller c = null;
	private static Map<String, Integer> keyBindings = new HashMap<String, Integer>();
	public static RunGame r = new RunGame();
	
	public static void main(String argv[]){
		r.init();
	}
	
	public void init(){
		keyReset();
		c = new MainMenuController();
		frame.add(c.getView());
		c.register(frame);
		frame.setFocusable(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
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
	
	//key binding operations
	public static void keyReset(){
		keyBindings.put("SOUTHWEST",97);
		keyBindings.put("SOUTH",83);
		keyBindings.put("SOUTHEAST",99);
		keyBindings.put("EAST",68);
		keyBindings.put("NORTHEAST",105);
		keyBindings.put("NORTH",87);
		keyBindings.put("NORTHWEST",103);
		keyBindings.put("WEST",65);
		keyBindings.put("ENTER",10);
	}
	public static int getKey(String s){
		return keyBindings.get(s);
	}
	
	public static Map<String, Integer> getKeys(){
		return keyBindings;
	}
	
	public static void setKey(String s, int i){
		keyBindings.put(s,i);
	}
	
	

}

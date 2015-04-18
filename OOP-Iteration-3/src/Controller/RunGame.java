package Controller;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import View.View;
import Controller.Controller;
import Controller.MainMenuController;


public class RunGame implements Observer {
	
	private JFrame frame = new JFrame();
	Controller c = null;
	private static View view;
	private static Map<String, Integer> keyBindings = new HashMap<String, Integer>();
	public static RunGame r = new RunGame();
	
	public static void main(String argv[]){
		r.init();
	}
	
	public void init(){ 
		view = new View();
		c = new MainMenuController();
		
		
		keyReset();
		frame.add(view);
		view.render(c.getView());
		c.register(frame);
		frame.setFocusable(true);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.repaint();
	}
	public void quit(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	public static void paint(){
		view.repaint();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		c.deRegister(frame);
		if((c = c.update()) == null){ //Use a QuitController instead
			quit();
			return;
		}
		view.render(c.getView());
		c.register(frame);
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
		keyBindings.put("BACK",27);
		keyBindings.put("INVENTORY",73);
		keyBindings.put("ACTION1",49);
		keyBindings.put("ACTION2",50);
		keyBindings.put("ACTION3",51);
		keyBindings.put("ACTION4",52);
		keyBindings.put("ACTION5",53);
		keyBindings.put("ACTION6",54);
		keyBindings.put("ACTION7",55);
		keyBindings.put("ACTION8",56);
		keyBindings.put("ACTION9",57);
		keyBindings.put("ACTION0",48);
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

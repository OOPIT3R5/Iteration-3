import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JFrame;

import Controller.CharacterCreationController;
import Controller.ConfigController;
import Controller.Controller;
import Controller.GameController;
import Controller.InventoryController;
import Controller.MainMenuController;
import Model.Menu.Menu;
import View.CharacterCreationView;
import View.ConfigControlsView;
import View.GameView;
import View.InventoryView;
import View.MainMenuView;
import View.ModelView;
import View.View;


public class RunGame implements Observer {
	static  Map<String, Integer> keyBindings = new HashMap<String, Integer>();
	JFrame frame = new JFrame();
	View view;
	Controller c;
	ModelView v;
	Menu m;
	
	MainMenuController mc;
	Menu mm;
	ModelView mv;
	
	CharacterCreationController ccc;
	Menu ccm;
	ModelView ccv;
	
	ConfigController cc;
	Menu cm;
	ModelView cv;
	
	GameController gc;
	Menu gm;
	ModelView gv;
	
	InventoryController ic;
	Menu im;
	ModelView iv;
	
	
	public static void main(String argv[]){
		
	}
	
	public RunGame(){
		//Main Menu
		String[] optionsMM = {"New","Load","Options","Quit"};
		mm = new Menu(optionsMM);
		mc = new MainMenuController();
		mv = new MainMenuView(optionsMM);
		mc.addObserver(this);
		mm.addObserver(mv);
		
		//Character Creation
		String[] optionsCCC = {"Smasher","Summoner","Sneak","Back"};
		ccm = new Menu(optionsCCC);
		ccc = new CharacterCreationController();
		ccv = new CharacterCreationView(optionsCCC);
		ccc.addObserver(this);
		ccm.addObserver(ccv);
		
		//Configurable Controls
		int i = 0;
		String[] optionsCC = new String[keyBindings.size()];
		for(Entry<String, Integer> entry: keyBindings.entrySet()){
			optionsCC[i++] = entry.getKey();
   		 }
		cm = new Menu(optionsCC);
		cc = new ConfigController();
		cv = new ConfigControlsView(optionsCC);
		cc.addObserver(this);
		cm.addObserver(cv);
		
		//Game Map
		
		//Inventory
		
		//Start
		c = mc;
		c.register(frame);
		v = mv;
		view.render(v);
		
		
	}
	public void quit(){
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
	
	public void paint(){
		view.repaint();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		c.deRegister(frame);
		if((c = c.update()) == null){ //Use a QuitController instead
			quit();
			return;
		}
		v = v.updateView();
		view.render(v);
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



package Main;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class KeySet {
	 private static Map<String, Integer> keyBindings = new HashMap<String, Integer>();
	 
	//key binding operations
	 public KeySet(){
		 keyReset();
	  }
    public static void keyReset(){
        keyBindings.put("SOUTHWEST",KeyEvent.VK_A);
        keyBindings.put("SOUTH",KeyEvent.VK_S);
        keyBindings.put("SOUTHEAST",KeyEvent.VK_D);
        keyBindings.put("EAST",null);
        keyBindings.put("NORTHEAST",KeyEvent.VK_E);
        keyBindings.put("NORTH",KeyEvent.VK_W);
        keyBindings.put("NORTHWEST",KeyEvent.VK_Q);
        keyBindings.put("WEST",null);
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
        keyBindings.put("ACTION10",48);
        keyBindings.put("ACTION11",KeyEvent.VK_MINUS);
        keyBindings.put("ACTION12",KeyEvent.VK_EQUALS);
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

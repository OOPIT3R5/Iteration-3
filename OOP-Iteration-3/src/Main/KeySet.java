package Main;

import java.util.HashMap;
import java.util.Map;

public class KeySet {
	 private static Map<String, Integer> keyBindings = new HashMap<String, Integer>();
	 
	//key binding operations
	 public KeySet(){
		 keyReset();
	  }
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

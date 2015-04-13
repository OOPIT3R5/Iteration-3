package Model.Menu;

import javax.swing.JComponent;

import View.ConfigControlsView;
/* 
 * I am aware of the perhaps unnecessary coupling here. 
 * If you don't know what I am talking about - THERE IS NOTHING TO SEE HERE.
 * Observers don't work because I need to read the drop-down inside of the view.
 * All suggestions are welcome.
 * Bidirectional observers?
 * Remind me to fix it later.
 * */
public class ConfigControls {
	
	ConfigControlsView cv = new ConfigControlsView();
	
	public ConfigControls(){
	}
	
	public JComponent getView(){
		return cv;
	}
	
	public int readValue(){
		return cv.readValue();
	}
	public void selectKey(String s){ 
		cv.setInput(s);
	}
	public String readKey(){
		return cv.readKey().toString();
	}
}

package View;


import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.util.Map.Entry;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.RunGame;

@SuppressWarnings("serial")
public class ConfigControlsView extends JPanel{
	JComboBox<String> keyList = new JComboBox<String>();
	JTextField input = new JTextField(6);
	public ConfigControlsView(){
		setLayout(new FlowLayout());
		for(Entry<String, Integer> entry: RunGame.getKeys().entrySet()){
   			keyList.addItem(entry.getKey());
   		 }
		//input.setFocusable(false);
		keyList.setFocusable(false);
		add(keyList);
		add(input);
	}
	
	public void setInput(String s){
		input.setText(s);
	}
	
	public int readValue(){
		String s = input.getText();
		if(s.equals("")){
			return KeyEvent.getExtendedKeyCodeForChar(RunGame.getKey(keyList.getSelectedItem().toString()));
		}
		s = s.toUpperCase();
		return KeyEvent.getExtendedKeyCodeForChar(s.charAt(0));
	}
	
	public Object readKey(){
		return keyList.getSelectedItem();
	}
}

package View;

import java.awt.Color;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class MainMenuView extends JPanel implements Observer {
	
	private HashMap<String,JLabel> options = new HashMap<String,JLabel>();

	public MainMenuView(String[] options){
		for(String s : options){
			this.options.put(s, new JLabel(s));
		}
		for(Entry<String, JLabel> entry: this.options.entrySet()){
   			JLabel a = entry.getValue();
   			add(a);
   			a.setForeground(Color.BLACK);
   		 }		
		this.options.get(options[0]).setForeground(Color.RED);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(Entry<String, JLabel> entry: options.entrySet()){
   			JLabel a = entry.getValue();
   			a.setForeground(Color.BLACK);
   		 }
		options.get(arg1).setForeground(Color.RED);		
	}
	
}

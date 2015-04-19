package View;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Main.KeySet;
import Main.RunGame;
import View.Model.ModelView;
@SuppressWarnings("serial")
public class ConfigControlsView extends ModelView implements Observer{
	
	private HashMap<String,Color> options = new HashMap<String,Color>();
	
	int width = View.WIDTH;
	int height = 0;
	
	int buttonWidth = 200;
	int buttonHeight = 22;
	
	public ConfigControlsView(String[] options){
		for(String s : options){
			this.options.put(s,Color.BLACK);
		}
		this.options.put(options[0], Color.RED);
	}
	@Override
	public void accept(View view) {
		view.visit(this);
	}

	@Override
	public void render(Graphics g) {
		int startY = 0;
		int startX = 0;
		float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(100.0f));
		String title = "Configurable Controls";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(title);
		g.drawString(title, width/2 - (w / 2), 100);
		g.setFont(g.getFont().deriveFont(old));
		MenuButton m = new MenuButton(buttonWidth, buttonHeight);
		for(Entry<String, Color> entry: options.entrySet()){
			m.render(g, View.WIDTH/3 - buttonWidth/2 + startX, View.HEIGHT/3 + startY, entry.getValue(),entry.getKey()+" : " + keyToChar(KeySet.getKey(entry.getKey())));
			startY = startY + buttonHeight;
			if(startY >= View.HEIGHT/3){
				startY = 0;
				startX += buttonWidth;
			}
   		 }
		g.setColor(Color.BLACK);		
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		for(Entry<String, Color> entry: options.entrySet()){
			options.put(entry.getKey(), Color.BLACK);
   		 }
		options.put(arg1.toString(), Color.RED);		
	}
	public String keyToChar(int i){
		return KeyEvent.getKeyText(i);
	}
}

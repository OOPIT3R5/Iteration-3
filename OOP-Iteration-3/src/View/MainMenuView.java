package View;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;

import Main.RunGame;


@SuppressWarnings("serial")
public class MainMenuView extends ModelView implements Observer {
	
	private HashMap<String,Color> options = new HashMap<String,Color>();
	
	int boxWidth = View.WIDTH/2;
	int boxHeight = View.HEIGHT;
	int boxX = View.WIDTH/2 - boxWidth/2;
	int boxY = 0;
	
	int buttonWidth = 100;
	int buttonHeight = 50;

	public MainMenuView(String[] options){
		for(String s : options){
			this.options.put(s,Color.BLACK);
		}
		this.options.put(options[0], Color.RED);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(Entry<String, Color> entry: options.entrySet()){
			options.put(entry.getKey(), Color.BLACK);
   		 }
		options.put(arg1.toString(), Color.RED);
		//RunGame.paint();
	}

	@Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		view.visit(this);
	}

	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub		
		int start = 0;
		g.drawRect(boxX, boxY, boxWidth, boxHeight);
		float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(100.0f));
		String title = "Main Menu";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth("Main Menu");
		g.drawString("Main Menu", boxX + boxWidth/2 - (w / 2), boxY + 100);
		g.setFont(g.getFont().deriveFont(old));
		MenuButton m = new MenuButton(buttonWidth, buttonHeight);
		for(Entry<String, Color> entry: options.entrySet()){
			m.render(g, View.WIDTH/2 - buttonWidth/2, View.HEIGHT/3 + start, entry.getValue(),entry.getKey());
			start = start + buttonHeight*2;
   		 }
		g.setColor(Color.BLACK);
	}

	@Override
	public ModelView updateView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

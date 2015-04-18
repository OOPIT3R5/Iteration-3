package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class MainMenuView extends ModelView implements Observer {
	
	private HashMap<String,JLabel> options = new HashMap<String,JLabel>();
	
	public final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public final int SUB1_X = 2*SCREEN_WIDTH/7;
	public final int SUB1_Y = SCREEN_HEIGHT/12;
	public final int SUB1_WIDTH = 2*SCREEN_WIDTH/5;
	public final int SUB1_HEIGHT = 8*SCREEN_HEIGHT/10;

	public MainMenuView(String[] options){
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for(Entry<String, JLabel> entry: options.entrySet()){
   			JLabel a = entry.getValue();
   			a.setForeground(Color.WHITE);
   		 }
		options.get(arg1).setForeground(Color.RED);		
	}

	@Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		view.visit(this);
	}

	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		int buttonPadding = 20;
		int buttonWidth = 100;
		int buttonHeight = 50;
		g.setColor(new Color(255, 0, 0));
		
		g.drawRect((View.WIDTH/2) - (buttonWidth/2), (View.HEIGHT/2) + buttonHeight ,buttonWidth , buttonHeight);
		g.drawRect((View.WIDTH/2) - (buttonWidth/2), (View.HEIGHT/2) + buttonHeight ,buttonWidth , buttonHeight);

	}
	
}

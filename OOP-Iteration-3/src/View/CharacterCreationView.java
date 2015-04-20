package View;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;


@SuppressWarnings("serial")
public class CharacterCreationView extends ModelView implements Observer {
	
	private HashMap<String,Color> options = new HashMap<String,Color>();
	private String[] orderedOptions;
	
	int boxWidth = View.WIDTH/2;
	int boxHeight = View.HEIGHT;
	int boxX = View.WIDTH/2 - boxWidth/2;
	int boxY = 0;
	
	int buttonWidth = 100;
	int buttonHeight = 50;

	public CharacterCreationView(String[] options){
		for(String s : options){
			this.options.put(s,Color.BLACK);
		}
		this.options.put(options[0], Color.RED);
		orderedOptions = options;
	}

	@Override
	public void accept(View view) {
		view.visit(this);
	}

	@Override
	public void render(Graphics g) {	
		int start = 0;
		g.drawRect(boxX, boxY, boxWidth, boxHeight);
		float old = g.getFont().getSize();
		g.setFont(g.getFont().deriveFont(75.0f));
		String title = "Character Creation";
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(title);
		g.drawString(title, boxX + boxWidth/2 - (w / 2), boxY + 100);
		g.setFont(g.getFont().deriveFont(old));
		MenuButton m = new MenuButton(buttonWidth, buttonHeight);
		for(String s : orderedOptions){
			m.render(g, View.WIDTH/2 - buttonWidth/2, View.HEIGHT/3 + start, options.get(s),s);
			start = start + buttonHeight*2;
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
	
}

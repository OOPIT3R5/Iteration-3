package View;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class MenuButton {
	int width;
	int height;
	
	public MenuButton(int width, int height){
		this.width = width;
		this.height = height;	
	}
	
	public void render(Graphics g, int x, int y, Color color, String text){
		g.setColor(color);
		FontMetrics fm = g.getFontMetrics();
	    int w = fm.stringWidth(text);
	    int h = fm.getAscent();
		g.drawRect(x, y, width, height);
		g.drawString(text, x+ width/2 - (w / 2), y + height/2 + (h / 4));
	}

}

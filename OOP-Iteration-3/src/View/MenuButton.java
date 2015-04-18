package View;

import java.awt.Graphics;

public class MenuButton {
	int width;
	int height;
	String text;
	public MenuButton(int width, int height, String text){
		
		this.text = text;
		this.width = width;
		this.height = height;
		
		
	}
	
	public void render(Graphics g, int x, int y){
		
		g.drawRect(x - width/2, y - height/2, width, height);
		g.drawString(text, x - width/2, y - height/2);
		
	}

}

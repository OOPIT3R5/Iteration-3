package View.Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;

import View.View;

public class TileView extends ModelView{
	BufferedImage tileImage;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(View view) {
		view.visit(this);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}

package View.Model;

import java.awt.Graphics;
import java.util.Observable;

import View.ModelView;
import View.View;

public class GameMapView extends ModelView {
	
	public GameMapView()
	{
	}
	
	@Override
	public void accept(View view) {
		view.visit(this);
	}

	@Override
	public void render(Graphics g) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	
}

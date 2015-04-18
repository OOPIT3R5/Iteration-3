package View;

import java.awt.Graphics;
import java.util.Observable;

public class GameMapView extends ModelView{

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

	@Override
	public ModelView updateView() {
		// TODO Auto-generated method stub
		return null;
	}

}

package View;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameView extends ModelView {

	public GameView() {
		
	}

	@Override
	public void accept(View view) {
		view.visit(this);
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("Insert Game map here", 500, 100);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

package View;

import java.awt.Graphics;
import java.util.Observer;

public abstract class ModelView implements Observer {


	public abstract void accept(View view);

	public abstract void render(Graphics g);
	
	public abstract ModelView updateView();

}


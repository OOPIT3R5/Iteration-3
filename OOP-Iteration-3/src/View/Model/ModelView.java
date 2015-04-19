package View.Model;

import java.awt.Graphics;
import java.util.Observer;

import View.View;

public abstract class ModelView implements Observer {


	public abstract void accept(View view);

	public abstract void render(Graphics g);

}


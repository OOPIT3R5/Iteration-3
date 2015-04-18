package View;

import java.awt.Graphics;

public abstract class ModelView {


	public abstract void accept(View view);

	public abstract void render(Graphics g);

}


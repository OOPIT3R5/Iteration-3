package View;

import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import View.Model.GameMapView;
import View.Model.TileView;

public class View extends JPanel{
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	private ModelView modelView;

	public View(){
		setSize(WIDTH, HEIGHT);
		this.setBounds(0, 0, WIDTH, HEIGHT);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (modelView != null) {
			modelView.render(g);
		}
		

	}
	public void render(ModelView mv) {
		mv.accept(this);

	}
	
	
	public void visit(CharacterCreationView mv) {
		this.modelView = mv;
		this.repaint();
	}
	public void visit(ConfigControlsView mv) {
		this.modelView = mv;
		this.repaint();

	}
	
	public void visit(GameMapView mv) {
		this.modelView = mv;
		this.repaint();

	}
	
	
	public void visit(GameView mv) {
		this.modelView = mv;
		this.repaint();

	}
	
	public void visit(InventoryView mv) {
		this.modelView = mv;
		this.repaint();

	}
	public void visit(MainMenuView mv) {
		this.modelView = mv;
		this.repaint();

	}
	
	public void visit(TileView mv) {
		this.modelView = mv;
		this.repaint();

	}
	
}

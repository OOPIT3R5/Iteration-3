package Model.Map.Grid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;


@SuppressWarnings("serial")
public class Test extends JPanel {

	public Grid gg_;
	
	public Test(Grid gg) {
		super();
		gg_ = gg;
	}
	
	@Override
	public void paint(Graphics g) {
		((HexagonalGrid)gg_).drawRectangleWithCoords(g, new Point(450, 400), new HexagonalLocation(8, 3), 12, 12, 20);
		
		/*g.setColor(Color.WHITE);
		gg_.drawRectangle(g, new Point(450, 400), new HexCoordinate(0, 0), 6, 5, 50);
		g.setColor(Color.GRAY);
		//gg_.drawArc(g, new Point(100, 650), new HexCoordinate(0, 0), Direction.NORTHEAST, 8, 16);
		//gg_.drawArc(g, new Point(750, 40), new HexCoordinate(0, 0), Direction.SOUTH, 9, 16);
		g.setColor(Color.RED);
		gg_.drawRectangle(g, new Point(220, 220), new HexCoordinate(0, 0), 4, 3, 30);
		g.setColor(Color.BLUE);
		gg_.drawHex(g, new Point(650, 500), new HexCoordinate(0, 0), 4, 30);
		//gg_.drawArc(g, new Point(220, 220), new HexCoordinate(0, 0), Direction.NORTHEAST, 4, 30);
		g.setColor(Color.PINK);
		//gg_.drawArc(g, new Point(650, 500), new HexCoordinate(0, 0), Direction.SOUTH, 4, 30);
		gg_.initialize();
		gg_.fill();
		System.out.println(gg_.toString());*/
	}
	
	public static void main(String[] args) {
		Grid gg = new HexagonalGrid(10, 10);
		gg.fill(new HexagonalTile());
		System.out.println(gg.toString());
		
		JFrame frame = new JFrame("Drawn HexTiled Grids");
		frame.add(new Test(gg));
		frame.setSize(890, 820);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
}

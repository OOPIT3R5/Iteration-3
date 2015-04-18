package Model.Map.Grid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Map.GameMap;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import Model.Terrain.Grass;
import Model.Terrain.Mountain;
import Model.Terrain.Water;


@SuppressWarnings("serial")
public class Test extends JPanel {

	public Grid gg_;
	private static int x;
	private static int y;
	
	public Test(Grid gg) {
		super();
		gg_ = gg;
	}
	
	@Override
	public void paint(Graphics g) {
		((HexagonalGrid)gg_).drawRectangleWithCoords(g, new Point(0, 0), new HexagonalLocation(x, y), 100, 100, 75);	// 75 = good size
		
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
	
	public static void main(String[] args) throws InterruptedException {
		
		GameMap gg = new GameMap(100, 100);
		gg.fill(new HexagonalTile(new Grass()));
		//System.out.println(gg.toString());

		gg.add(1, 1, new HexagonalTile(new Water()));
		gg.add(5, 5, new HexagonalTile(new Mountain()));
		
		JFrame frame = new JFrame("Drawn HexTiled Grids");
		frame.add(new Test(gg));
		frame.setSize(768, 768);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		for(int i = 0; i < 10; i++){
			x = i;
			y = i;
			frame.repaint();
			Thread.sleep(1000);
		}
		
	}
	
}

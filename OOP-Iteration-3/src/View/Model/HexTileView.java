package View.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import Model.Map.HexagonalLocation;
import View.ModelView;
import View.View;

public class HexTileView {
	
	private final int hexagon_size = 100;
	private Color representation_;
	private HexagonalLocation location_;
	
	public HexTileView(HexagonalLocation location, Color representation) {
		location_ = location;
		representation_ = representation;
	}
	
	public void render(Graphics g, HexagonalLocation avatar_location) {
		Point origin = new Point(View.WIDTH / 2, View.HEIGHT / 2);
		int x = (int)(origin.getX() + 3 / 2.0 * hexagon_size * (location_.getU() - avatar_location.getU()));
		int y = (int)(origin.getY() + Math.sqrt(3) * hexagon_size * ((location_.getV() - avatar_location.getV()) + (location_.getU() - avatar_location.getU()) / 2.0));
		new FlatHexagon(new Point(x, y), (int)(hexagon_size * 1.02), true).draw(g);
		new FlatHexagon(new Point( x, y), (int)(hexagon_size * .95), true, representation_).draw(g);
		g.setColor(Color.BLACK);
		g.drawString(location_.toString(), x-40, y+75);
	}

	public void update(HexagonalLocation location) {
		location_ = location;
	}

}

package View.Model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Observable;

import Model.Map.HexagonalCoordinateInterface;
import Model.Map.HexagonalLocation;
import Model.Map.Grid.Tile.HexagonalTile;
import View.View;

public class HexTileView extends ModelView {

	Color representation_;
	HexagonalTile tile;
	
	public HexTileView(HexagonalTile tile) {
		this.tile = tile;
		representation_ = tile.getColor();
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void accept(View view) {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics g, Point origin, HexagonalLocation relative_position) {
		int hexagon_size = 100;
		//g.drawOval(tile.getLocation().getU() * View.WIDTH / 100, tile.getLocation().getV() * View.HEIGHT / 100, View.WIDTH / 200,
				//View.HEIGHT/200);
		//FlatHexagon fh = new FlatHexagon(new Point(tile.getLocation().getU() * View.WIDTH/100 ,tile.getLocation().getV() * View.HEIGHT/100), 10, true);
		//fh.draw(g);
		HexagonalLocation h = tile.getLocation();
		h = tile.getLocation();
		new FlatHexagon(new Point(
				(int)(origin.getX() + 3 / 2.0 * hexagon_size * (h.getU() - relative_position.getU())), 
				(int)(origin.getY() + Math.sqrt(3) * hexagon_size * ((h.getV() - relative_position.getV()) + (h.getU() - relative_position.getU()) / 2.0))),
				(int)(hexagon_size * 1.02), true).draw(g);
		new FlatHexagon(new Point(
				(int)(origin.getX() + 3 / 2.0 * hexagon_size * (h.getU() - relative_position.getU())), 
				(int)(origin.getY() + Math.sqrt(3) * hexagon_size * ((h.getV() - relative_position.getV()) + (h.getU() - relative_position.getU()) / 2.0))),
				(int)(hexagon_size * .95), true, representation_).draw(g);
		if (tile.hasEntity()) {
			new FlatHexagon(new Point(
					(int)(origin.getX() + 3 / 2.0 * hexagon_size * (h.getU() - relative_position.getU())), 
					(int)(origin.getY() + Math.sqrt(3) * hexagon_size * ((h.getV() - relative_position.getV()) + (h.getU() - relative_position.getU()) / 2.0))),
					(int)(hexagon_size * .5), true, Color.RED).draw(g);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
